package cn.ylcto.util.utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class DESUtil {
	private static Key key;
	//自己的密钥
	private static String KEY_STR = "mykey";
	static{
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");//密钥生成器
			// SHA1PRNG随机数算法
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);//初始化密钥生成器
			key = generator.generateKey(); //生成密钥
			generator = null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 对字符串进行加密，返回BASE64的加密字符串
	 * @param str 
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getEncryptString(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("DES");//Cipher完成加密工作类
            cipher.init(Cipher.ENCRYPT_MODE, key);//对Cipher初始化，加密模式
            byte[] encryptStrBytes = cipher.doFinal(strBytes);//加密数据
            return base64Encoder.encode(encryptStrBytes); //返回BASE64的加密字符串
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
	  /**
     * 对BASE64加密字符串进行解密
     *
     */
    public static String getDecryptString(String str) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] strBytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");//Cipher完成加密工作类
            cipher.init(Cipher.DECRYPT_MODE, key);//对Cipher初始化，解密模式
            byte[] encryptStrBytes = cipher.doFinal(strBytes);//解密数据
            return new String(encryptStrBytes, "UTF-8");//返回解密字符串
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        String name = "root";
        String password = "xiqian";
        String encryname = getEncryptString(name);
        String encrypassword = getEncryptString(password);
        System.out.println("encryname : " + encryname);
        System.out.println("encrypassword : " + encrypassword);

        System.out.println("name : " + getDecryptString(encryname));
        System.out.println("password : " + getDecryptString(encrypassword));
    }

}
