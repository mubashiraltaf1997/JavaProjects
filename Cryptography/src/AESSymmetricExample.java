import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * A basic symmetric encryption example using AES with GCM mode and no padding.
 * This implementation follows current best practices as recommended by NIST.
 */
public class AESSymmetricExample {

    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 128;

    private static SecretKeySpec secretKey;
    private static byte[] iv;

    public static void main(String[] args) throws Exception {

        String plaintext = "Sensitive information";
        String key = "MyStrongPassword";

        System.out.println("Input text: " + plaintext);
        System.out.println("Input key: " + key);

        String encryptedString = encrypt(plaintext, key);

        // Encryption pass
        System.out.println("Cipher text: " + encryptedString);

        String decryptedString = decrypt(encryptedString, key);

        // Decryption pass
        System.out.println("Plain text: " + decryptedString);
    }

    public static void setKey(String myKey) {
        byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        secretKey = keySpec;
    }

    public static void generateIV() {
        SecureRandom random = new SecureRandom();
        iv = new byte[GCM_IV_LENGTH];
        random.nextBytes(iv);
    }

    public static String encrypt(String plaintext, String key) throws Exception {
        setKey(key);
        generateIV();

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] cipherText = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        byte[] message = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, message, 0, iv.length);
        System.arraycopy(cipherText, 0, message, iv.length, cipherText.length);

        return Base64.getEncoder().encodeToString(message);
    }

    public static String decrypt(String ciphertext, String key) throws Exception {
        setKey(key);

        byte[] message = Base64.getDecoder().decode(ciphertext);
        byte[] iv = new byte[GCM_IV_LENGTH];
        System.arraycopy(message, 0, iv, 0, iv.length);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        byte[] cipherText = new byte[message.length - iv.length];
        System.arraycopy(message, iv.length, cipherText, 0, cipherText.length);

        byte[] plainText = cipher.doFinal(cipherText);

        return new String(plainText, StandardCharsets.UTF_8);
    }

}
