package cn.yl.base;

import java.math.BigInteger;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {

	public static final String KEY_MAC = "HmacMD5";
	
	/**
	 * 初始化HMAC秘钥
	 */
	public static String initMacKey() throws Exception{
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
		SecretKey secretKey = keyGenerator.generateKey();
		return Base64Demo.encryptBASE64(secretKey.getEncoded());
	}
	
	/**
	 * HMAC加密：主要方法
	 */
	public static String encryptHMAC(byte[] data, String key) throws Exception{
		SecretKey secretKey = new SecretKeySpec(Base64Demo.decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return new String(mac.doFinal(data));
	}
	
	public static void main(String[] args) throws Exception {
		String key = initMacKey();
		System.out.println("mac:"+key);
		String a = "gagaga";
		byte[] arr = a.getBytes();
		String str = encryptHMAC(arr, key);
		System.out.println(str);
	}
}
