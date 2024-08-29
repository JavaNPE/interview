package com.youliao.code;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/8/29 14:24
 * @Description:
 */
public class BadPaddingExceptionDemo {

    public static void main(String[] args) {
        try {
            // 密钥
            byte[] keyBytes = "MySecretKey12345".getBytes();
            System.out.println("keyBytes：" + Base64.getEncoder().encodeToString(keyBytes));
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
            System.out.println("secretKey：" + secretKey);


            // 创建AES加密器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // 待加密数据
            String data = "Hello, world!";
            byte[] encryptedData = cipher.doFinal(data.getBytes());

            // 打印加密后的数据
            System.out.println("Encrypted data: " + Base64.getEncoder().encodeToString(encryptedData));

            // 模拟使用错误的密钥解密数据
            byte[] wrongKeyBytes = "WrongKey".getBytes();
            SecretKey wrongKey = new SecretKeySpec(wrongKeyBytes, "AES");
            // cipher.init(Cipher.DECRYPT_MODE, wrongKey); // 报错情况：解密失败
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // 尝试解密数据，抛出 BadPaddingException 异常
            byte[] decryptedData = cipher.doFinal(encryptedData);
            System.out.println("decryptedData:" + Base64.getEncoder().encodeToString(decryptedData));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            // 捕获BadPaddingException异常并进行处理
            System.err.println("BadPaddingException caught: " + e.getMessage());
            // 其他处理逻辑...
        } catch (javax.crypto.BadPaddingException e) {
            // 捕获BadPaddingException异常并进行处理
            System.err.println("BadPaddingException caught: Invalid padding.");
            // 其他处理逻辑...
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }
}
