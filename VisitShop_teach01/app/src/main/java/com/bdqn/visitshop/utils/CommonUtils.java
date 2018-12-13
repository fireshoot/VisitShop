package com.bdqn.visitshop.utils;

import java.security.MessageDigest;

public class CommonUtils {

	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	public static String md5sum(String str) {
		byte[] strByte = str.getBytes();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(strByte, 0, strByte.length);
			return toHexString(md5.digest());
		} catch (Exception e) {
			return null;
		}
	}

}
