import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Savings_W2023_Champions extends Account_W2023_Champions {

    private static final String SECRET_KEY = "YOUR_SECRET_KEY";

    private double interestRate;

    private double balance;
    private double encryptedInterestRate;

    public Savings_W2023_Champions(String accountNumber, double balance, String dateCreated, String ownerName, double interestRate) throws Exception {
        super(accountNumber, balance, dateCreated, ownerName);
        this.interestRate = interestRate;
        this.encryptedInterestRate = interestRate;
        this.balance = balance;
    }

    public void addInterest() throws MalformedBalanceException {
        try {
            double decryptedInterestRate = decryptData(String.valueOf(encryptedInterestRate), SECRET_KEY);
            balance *= (1 + decryptedInterestRate);
        } catch (Exception e) {
            throw new MalformedBalanceException(e.toString());
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void withdraw(double amount) throws MalformedBalanceException, DailyLimitException {
        // Check if the withdrawal amount is negative or zero
        if (amount <= 0) {
            throw new MalformedBalanceException("Invalid withdrawal amount");
        }

        // Check if the balance after withdrawal will be negative
        if (balance - amount < 0) {
            throw new MalformedBalanceException("Insufficient balance for withdrawal");
        }

        // Perform the withdrawal operation
        balance -= amount;
        System.out.println("Success!");
    }

    private String encryptData(String data, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey(secretKey));
        byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    private double decryptData(String encryptedData, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, generateSecretKey(secretKey));
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        String decryptedString = new String(decryptedData, StandardCharsets.UTF_8);
        return Double.parseDouble(decryptedString);
    }


    private SecretKeySpec generateSecretKey(String secretKey) throws Exception {
        byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, "AES");
    }
}
