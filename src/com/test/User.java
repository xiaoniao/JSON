package com.test;

import java.util.Map;

public class User {
	private String name;
	private int followersCount;

	private byte b;
	private Byte b2;

	private short s;
	private Short s2;

	private int i;
	private Integer i2;

	private long l;
	private Long l2;

	private float f;
	private Float f2;

	private double d;
	private Double d2;

	private User user;

	private boolean bool;
	private Boolean bool2;

	private char ch;

	private String str;
	private Enum e;

	private Map<String, User> map;

	public User(String name, Integer followersCount) {
		this.name = name;
		this.followersCount = followersCount;
	}

	public User(String name, Integer followersCount, User user) {
		this.name = name;
		this.followersCount = followersCount;
		this.user = user;
	}

	public User(String name, int followersCount, byte b, Byte b2, short s, Short s2, int i, Integer i2, long l, Long l2,
			float f, Float f2, double d, Double d2, boolean bool, Boolean bool2, char ch, String str, Enum e,
			User user) {
		this.name = name;
		this.followersCount = followersCount;
		this.b = b;
		this.b2 = b2;
		this.s = s;
		this.s2 = s2;
		this.i = i;
		this.i2 = i2;
		this.l = l;
		this.l2 = l2;
		this.f = f;
		this.f2 = f2;
		this.d = d;
		this.d2 = d2;
		this.bool = bool;
		this.bool2 = bool2;
		this.ch = ch;
		this.str = str;
		this.e = e;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public byte getB() {
		return b;
	}

	public void setB(byte b) {
		this.b = b;
	}

	public Byte getB2() {
		return b2;
	}

	public void setB2(Byte b2) {
		this.b2 = b2;
	}

	public short getS() {
		return s;
	}

	public void setS(short s) {
		this.s = s;
	}

	public Short getS2() {
		return s2;
	}

	public void setS2(Short s2) {
		this.s2 = s2;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Integer getI2() {
		return i2;
	}

	public void setI2(Integer i2) {
		this.i2 = i2;
	}

	public long getL() {
		return l;
	}

	public void setL(long l) {
		this.l = l;
	}

	public Long getL2() {
		return l2;
	}

	public void setL2(Long l2) {
		this.l2 = l2;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public Float getF2() {
		return f2;
	}

	public void setF2(Float f2) {
		this.f2 = f2;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public Double getD2() {
		return d2;
	}

	public void setD2(Double d2) {
		this.d2 = d2;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public Boolean getBool2() {
		return bool2;
	}

	public void setBool2(Boolean bool2) {
		this.bool2 = bool2;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Enum getE() {
		return e;
	}

	public void setE(Enum e) {
		this.e = e;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

}
