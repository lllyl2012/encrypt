package cn.yl.base;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHADemo {

	private static final String KEY_SHA = "SHA";
	
	private static String getResult(String inputStr){
		BigInteger sha = null;
		System.out.println("============加密前===========:"+inputStr);
		byte[] inputData = inputStr.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
			messageDigest.update(inputData);
			sha = new BigInteger(messageDigest.digest());
			System.out.println("SHA加密后："+sha.toString(32));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sha.toString(32);
	}
	
	public static void main(String[] args) {
		String in = "aaaaaaaaaa";
		getResult(in);
	}
}
