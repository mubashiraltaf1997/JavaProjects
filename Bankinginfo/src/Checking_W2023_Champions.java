import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class Checking_W2023_Champions extends Account_W2023_Champions {

    private String encryptedOverdraftLimit;
    private double balance;

    private static final String SECRET_KEY = "YOUR_SECRET_KEY";

    public Checking_W2023_Champions(String accountNumber, double balance, String dateCreated, String ownerName, double overdraftLimit) throws Exception {
        super(accountNumber, balance, dateCreated, ownerName);
        this.balance = balance;
        this.encryptedOverdraftLimit = encryptData(Double.toString(overdraftLimit), SECRET_KEY);
    }

    public void withdraw(double amount) throws DailyLimitException {
        try {
            double decryptedOverdraftLimit = Double.parseDouble(decryptData(encryptedOverdraftLimit, SECRET_KEY));
            if (balance - amount >= -decryptedOverdraftLimit) {
                balance -= amount;
                System.out.println("Success!");
            } else {
                throw new DailyLimitException("Insufficient funds.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public double getOverdraftLimit() {
        try {
            double decryptedOverdraftLimit = Double.parseDouble(decryptData(encryptedOverdraftLimit, SECRET_KEY));
            return decryptedOverdraftLimit;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    // Helper method to encrypt data
    private String encryptData(String data, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey(secretKey));
        byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Helper method to decrypt data
    private String decryptData(String encryptedData, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, generateSecretKey(secretKey));
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    // Helper method to generate secret key from string
    private SecretKeySpec generateSecretKey(String secretKey) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
        key = sha.digest(key);
        return new SecretKeySpec(key, "AES");
    }
}
