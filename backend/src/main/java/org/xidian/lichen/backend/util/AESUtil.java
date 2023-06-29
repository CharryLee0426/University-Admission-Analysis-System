package org.xidian.lichen.backend.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY = "ThisIsASecretKey";
    private static final String INIT_VECTOR = "ThisIsAnInitVect";

    public static String encrypt(String message) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(getKey(), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(INIT_VECTOR.getBytes()));
        byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String cipherText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(getKey(), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(INIT_VECTOR.getBytes()));
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(original, StandardCharsets.UTF_8);
    }

    private static byte[] getKey() throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] key = Arrays.copyOf(sha.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8)), 16);
        return key;
    }
}
