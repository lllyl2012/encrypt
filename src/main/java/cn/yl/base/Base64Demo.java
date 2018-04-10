package cn.yl.base;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Demo {
	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/**
	 * BASE64加密
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	public static void main(String[] args) {
		String str= "12345678";
		
		try {
			String result1 = Base64Demo.encryptBASE64(str.getBytes());
			System.out.println("加密后:"+result1);
			byte[] result2 = Base64Demo.decryptBASE64(result1);
			String str2 = new String(result2);
			System.out.println("str2:"+str2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
