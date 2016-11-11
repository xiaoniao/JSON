package com.test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		Writer wc = new OutputStreamWriter(System.out);

		Map<User, User> userMap = new HashMap<>();
		userMap.put(new User("jack", 101), new User("jess", 506));
		toJson(1, userMap, wc);
		wc.write("\n");

		// ����map �� mapǶ��
		Map<String, Object> map = new HashMap<>();
		map.put("name", "jack");
		map.put("age", 1);
		Map<String, Object> innerMap = new HashMap<>();
		innerMap.put("title", "manager");
		innerMap.put("age", 101);
		map.put("innerMap", innerMap);
		toJson(1, map, wc);
		wc.write("\n");

		// ����Pojo �� pojoǶ��
		User u = new User("jess", 1000);
		u.setE(Enum.BOY);
		Map<String, User> m = new HashMap<>();
		m.put("user", new User("tom", 888));
		u.setMap(m);
		User user = new User("jack", 888, u);
		toJson(1, user, wc);
		wc.write("\n");

		// ����ԭ������
		Integer[] array1 = new Integer[] { 1, 2 };
		String[] array2 = new String[] { "a", "b" };
		User[] array3 = new User[] { new User("jack", 101), new User("jess", 506) };
		toJson(1, array1, wc);
		wc.write("\n");
		toJson(1, array2, wc);
		wc.write("\n");
		toJson(1, array3, wc);
		wc.write("\n");

		// ����list
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		List<User> list3 = new ArrayList<>();
		list3.add(new User("jack", 101));
		list3.add(new User("jess", 506));
		toJson(1, list1, wc);
		wc.write("\n");
		toJson(1, list2, wc);
		wc.write("\n");
		toJson(1, list3, wc);
		wc.flush();
	}

	/**
	 * ������ֱ�Ӵ�ӡ ����������ѭ������ ֱ��Ϊ��������ֹ
	 */
	private static void toJson(int level, Object object, Writer wc) throws Exception {
		Class<?> cls = object.getClass();
		// �ж���[���� ����{
		if (Utils.isObject(cls)) { // ����ָ�����м�ֵ�ԵĶ���
			wc.write("{");
			wc.write("\n");
			if (Utils.isMap(cls)) {
				// Map

				@SuppressWarnings("unchecked")
				Map<Object, Object> map = (Map<Object, Object>) object;
				boolean hasDot = false;
				for (Object key : map.keySet()) {
					if (hasDot) {
						wc.write(","); // ��һ��ѭ�����Ӷ��� ʣ��ÿ��ѭ�����Ӷ���
						wc.write("\n");
					}
					hasDot = true;
					wc.write(Utils.createIn(level) + "\"" + key + "\"" + ": ");
					writeValue(level, wc, map.get(key));
				}

			} else {
				// Java pojo
				Field[] fields = cls.getDeclaredFields();
				boolean hasDot = false;
				for (int j = 0; j < fields.length; j++) {
					Field field = fields[j];
					field.setAccessible(true);
					String key = field.getName();
					Object value = field.get(object);
					if (value == null || String.valueOf(value).equals("0") || String.valueOf(value).equals("0.0")
							|| value.equals('\u0000')) {
						continue;
					}

					if (hasDot) {
						wc.write(","); // ��һ��ѭ�����Ӷ��� ʣ��ÿ��ѭ�����Ӷ���
						wc.write("\n");
					}
					hasDot = true;
					wc.write(Utils.createIn(level) + "\"" + key + "\"" + ": ");
					writeValue(level, wc, value);
				}

			}
			wc.write("\n" + Utils.createIn(level - 1) + "}");

		} else if (Utils.isArray(cls)) {
			wc.write("[");
			wc.write("\n");
			wc.write(Utils.createIn(level));
			if (Utils.isBasicArray(cls)) {
				// ԭ������[]
				Object[] values = (Object[]) object;
				boolean hasDot = false;
				for (Object item : values) {
					if (hasDot) {
						wc.write(","); // ��һ��ѭ�����Ӷ��� ʣ��ÿ��ѭ�����Ӷ���
						wc.write("\n");
						wc.write(Utils.createIn(level));
					}
					hasDot = true;
					writeValue(level, wc, item);
				}

			} else {
				// java List
				@SuppressWarnings("unchecked")
				Collection<Object> values = (Collection<Object>) object;
				boolean hasDot = false;
				for (Object item : values) {
					if (hasDot) {
						wc.write(","); // ��һ��ѭ�����Ӷ��� ʣ��ÿ��ѭ�����Ӷ���
						wc.write("\n");
						wc.write(Utils.createIn(level));
					}
					hasDot = true;
					writeValue(level, wc, item);
				}

			}
			wc.write("\n" + Utils.createIn(level - 1) + "]");
		}
	}

	/**
	 * дֵ
	 */
	private static void writeValue(int level, Writer wc, Object value) throws Exception {
		if (Utils.isBasic(value.getClass())) {
			// ������
			writeBasicValue(wc, value, value.getClass());
		} else {
			// �������ͣ����� ���飩
			toJson(level + 1, value, wc);
		}
	}

	/**
	 * д�������͵�ֵ number string boolean
	 * 
	 * @param wc
	 * @param value
	 * @param cls
	 * @throws IOException
	 */
	private static void writeBasicValue(Writer wc, Object value, Class<?> cls) throws IOException {
		if (Utils.isString(cls.getSimpleName())) {
			wc.write("\"" + String.valueOf(value) + "\"");
		} else {
			wc.write(String.valueOf(value));
		}
	}
}
