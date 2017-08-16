package DES;


//import com.google.common.base.Strings;  
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  
  
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;  
import javax.crypto.SecretKey;  
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESKeySpec;  
import java.security.InvalidKeyException;  
import java.security.Key;  
import java.security.NoSuchAlgorithmException;  
import java.security.SecureRandom;  
import java.security.spec.InvalidKeySpecException;  
  
/** 
 * Created by xiang.li on 2015/2/28. 
 * DES 加解密工具类 
 * 
 * <pre> 
 * 支持 DES、DESede(TripleDES,就是3DES)、AES、Blowfish、RC2、RC4(ARCFOUR) 
 * DES                  key size must be equal to 56 
 * DESede(TripleDES)    key size must be equal to 112 or 168 
 * AES                  key size must be equal to 128, 192 or 256,but 192 and 256 bits may not be available 
 * Blowfish             key size must be multiple of 8, and can only range from 32 to 448 (inclusive) 
 * RC2                  key size must be between 40 and 1024 bits 
 * RC4(ARCFOUR)         key size must be between 40 and 1024 bits 
 * 具体内容 需要关注 JDK Document http://.../docs/technotes/guides/security/SunProviders.html 
 * </pre> 
 */  
public class DES {
    /** 
     * 定义加密方式 
     */  
    private final static String KEY_DES = "DES";  
    private final static String KEY_AES = "AES";    // 测试  
  
    /** 
     * 全局数组 
     */  
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };  
  
    /** 
     * 初始化密钥 
     * @return 
     */  
    public static String init() {  
        return init(null);  
    }  
  
    /** 
     * 初始化密钥 
     * @param seed 初始化参数 
     * @return 
     */  
    public static String init(String seed) {  
        SecureRandom secure = null;  
        String str = "";  
        try {  
            if ( seed!= null) {  
                // 带参数的初始化  
                secure = new SecureRandom(decryptBase64(seed));  //生成实际随机数
            } else {  
                // 不带参数的初始化  
                secure = new SecureRandom();  
            }  
  
            KeyGenerator generator = KeyGenerator.getInstance(KEY_DES);  //返回生成指定算法的秘密密钥的 KeyGenerator 对象
            generator.init(secure);  //初始化此密钥生成器
  
            SecretKey key = generator.generateKey();  //生成一个密钥
            str = encryptBase64(key.getEncoded());  //返回基本编码格式的密钥，如果此密钥不支持编码，则返回 null;其中key.getEncoded()生成byte型数组
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return str;  
    }  
  
    /** 
     * 转换密钥 
     * @param key 密钥的字节数组 
     * @return 
     */  
    private static Key byteToKey(byte[] key) {  
        SecretKey secretKey = null;  
        try {  
            DESKeySpec dks = new DESKeySpec(key);  //创建一个 DESKeySpec 对象，使用 key 中的前 8 个字节作为 DES 密钥的密钥内容
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_DES);  //返回转换指定算法的秘密密钥的 SecretKeyFactory 对象
            secretKey = factory.generateSecret(dks); //根据提供的密钥规范（密钥材料）生成 SecretKey 对象 
  
            // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码  
//            secretKey = new SecretKeySpec(key, KEY_DES);  
        } catch (InvalidKeyException e) {  
            e.printStackTrace();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (InvalidKeySpecException e) {  
            e.printStackTrace();  
        }  
        return secretKey;  
    }  
  
    /** 
     * DES 解密 
     * @param data 需要解密的字符串 
     * @param key 密钥 
     * @return 
     */  
    public static String decryptDES(String data, String key) {  
        // 验证传入的字符串  
        if (data.isEmpty()) {  
            return "";  
        }  
        // 调用解密方法完成解密  
        byte[] bytes = decryptDES(hexString2Bytes(data), key);  
        // 将得到的字节数组变成字符串返回  
        return new String(bytes);  
    }  
  
    /** 
     * DES 解密 
     * @param data 需要解密的字节数组 
     * @param key 密钥 
     * @return 
     */  
    public static byte[] decryptDES(byte[] data, String key) {  
        byte[] bytes = null;  
        try {  
            Key k = byteToKey(decryptBase64(key));  
            Cipher cipher = Cipher.getInstance(KEY_DES);  
            cipher.init(Cipher.DECRYPT_MODE, k);  
            bytes = cipher.doFinal(data);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bytes;  
    }  
  
    /** 
     * DES 加密 
     * @param data 需要加密的字符串 
     * @param key 密钥 
     * @return 
     */  
    public static String encryptDES(String data, String key) {  
        // 验证传入的字符串  
        if (data.isEmpty()) {  
            return "";  
        }  
        // 调用加密方法完成加密  
        byte[] bytes = encryptDES(data.getBytes(), key);  
        // 将得到的字节数组变成字符串返回  
        return byteArrayToHexString(bytes);  
    }  
  
    /** 
     * DES 加密 
     * @param data 需要加密的字节数组 
     * @param key 密钥 
     * @return 
     */  
    public static byte[] encryptDES(byte[] data, String key) {  
        byte[] bytes = null;  
        try {  
            Key k = byteToKey(decryptBase64(key));  
            Cipher cipher = Cipher.getInstance(KEY_DES);  
            cipher.init(Cipher.ENCRYPT_MODE, k);  //用密钥初始化此 Cipher,其中ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
            bytes = cipher.doFinal(data);  //按单部分操作加密数据
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bytes;  
    }  
  
  
    /** 
     * BASE64 解密 
     * @param key 需要解密的字符串 
     * @return 字节数组 
     * @throws Exception 
     */  
    public static byte[] decryptBase64(String key) throws Exception {  
        return (new BASE64Decoder()).decodeBuffer(key);  
    }  
  
    /** 
     * BASE64 加密 
     * @param key 需要加密的字节数组 
     * @return 字符串 
     * @throws Exception 
     */  
    public static String encryptBase64(byte[] key) throws Exception {  
        return (new BASE64Encoder()).encodeBuffer(key);  
    }  
  
    /** 
     * 将一个字节转化成十六进制形式的字符串 
     * @param b 字节数组 
     * @return 字符串 
     */  
    private static String byteToHexString(byte b) {  
        int ret = b;  
        //System.out.println("ret = " + ret);  
        if (ret < 0) {  
            ret += 256;  
        }  
        int m = ret / 16;  
        int n = ret % 16;  
        return hexDigits[m] + hexDigits[n];  
    }  
  
    /** 
     * 转换字节数组为十六进制字符串 
     * @param bytes 字节数组 
     * @return 十六进制字符串 
     */  
    private static String byteArrayToHexString(byte[] bytes) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < bytes.length; i++) {  
            sb.append(byteToHexString(bytes[i]));  
        }  
        return sb.toString();  
    }  
  
  
    /** 
     * 转换十六进制字符串为字节数组 
     * @param hexstr 十六进制字符串 
     * @return 
     */  
    public static byte[] hexString2Bytes(String hexstr) {  
        byte[] b = new byte[hexstr.length() / 2];  
        int j = 0;  
        for (int i = 0; i < b.length; i++) {  
            char c0 = hexstr.charAt(j++);  
            char c1 = hexstr.charAt(j++);  
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));  
        }  
        return b;  
    }  
  
    /** 
     * 转换字符类型数据为整型数据 
     * @param c 字符 
     * @return 
     */  
    private static int parse(char c) {  
        if (c >= 'a')  
            return (c - 'a' + 10) & 0x0f;  
        if (c >= 'A')  
            return (c - 'A' + 10) & 0x0f;  
        return (c - '0') & 0x0f;  
    }  
  
    /** 
     * 测试方法 
     * @param args 
     */  
    public static void main(String[] args) {  
        String key = DES.init();  
        System.out.println("DES密钥:\n" + key);  
  
        String word = "123";  
          
  
        String encWord = encryptDES(word, key);  
  
        System.out.println(word + "\n加密后：\n" + encWord);  
        System.out.println(word + "\n解密后：\n" + decryptDES(encWord, key));  
    }  
}

