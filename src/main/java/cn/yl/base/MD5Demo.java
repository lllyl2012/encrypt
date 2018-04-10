package cn.yl.base;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Demo {
	private static final String KEY_MD5 = "MD5";
	
	public static String getResult(String inputStr){
		System.out.println("==========加密前的数据："+inputStr);
		BigInteger bigInteger = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] inputData = inputStr.getBytes();
			md.update(inputData);
			bigInteger = new BigInteger(md.digest());
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("MD5加密后："+bigInteger);
		return bigInteger.toString();
	}
	public static void main(String[] args) {
		String i = "几点上课啦发送的浪费空间打开了";
		getResult(i);
	}
	
}
