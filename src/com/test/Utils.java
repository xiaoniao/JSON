package com.test;

import java.util.Collection;
import java.util.Map;

public class Utils {

	/**
	 * �Ƿ���JSON����
	 */
	public static boolean isObject(Class<?> cls) {
		return !isArray(cls) && !isBasic(cls);
	}

	/**
	 * �Ƿ���JSON����
	 */
	public static boolean isArray(Class<?> cls) {
		return isBasicArray(cls) || isList(cls);
	}

	/**
	 * �Ƿ��ǻ�������(number string boolean)
	 * ����ǻ������;�ֱ�����ֵ��������ѭ���������������
	 */
	public static boolean isBasic(Class<?> cls) {
		String simpleName = cls.getSimpleName();
		return isBoolean(simpleName) || isNumber(simpleName) || isString(simpleName);
	}

	private static boolean isBoolean(String simpleName) {
		switch (simpleName) {
		case "boolean":
		case "Boolean":
			return true;

		default:
			return false;
		}
	}

	private static boolean isNumber(String simpleName) {
		switch (simpleName) {
		case "byte":
		case "Byte":
		case "short":
		case "Short":
		case "int":
		case "Integer":
		case "long":
		case "Long":
		case "float":
		case "Float":
		case "double":
		case "Double":
			return true;

		default:
			return false;
		}
	}

	public static boolean isString(String simpleName) {
		switch (simpleName) {
		case "Enum":
		case "char":
		case "String":
			return true;

		default:
			return false;
		}
	}

	public static boolean isBasicArray(Class<?> cls) {
		return cls.isArray();
	}

	public static boolean isList(Class<?> cls) {
		return Collection.class.isAssignableFrom(cls);
	}

	public static boolean isMap(Class<?> cls) {
		return Map.class.isAssignableFrom(cls);
	}

	public static String createIn(int level) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < level; i++) {
			s.append("    ");
		}
		return s.toString();
	}
}
