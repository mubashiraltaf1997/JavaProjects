import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public abstract class Account_W2023_Champions {

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String SECRET_KEY = "ThisIsARandomSecretKey";

    protected String encryptedAccountNumber;
    protected String encryptedOwnerName;
    protected String encryptedBalance;
    protected String encryptedDateCreated;

    public Account_W2023_Champions(String accountNumber, double balance, String dateCreated, String ownerName) throws Exception {
        this.encryptedAccountNumber = encryptData(accountNumber, SECRET_KEY);
        this.encryptedBalance = encryptData(Double.toString(balance), SECRET_KEY);
        this.encryptedDateCreated = encryptData(dateCreated, SECRET_KEY);
        this.encryptedOwnerName = encryptData(ownerName, SECRET_KEY);
    }
    public String getAccountNumber() throws Exception {
        return decryptData(encryptedAccountNumber, SECRET_KEY);
    }
    public double getBalance() throws Exception {
        String decryptedBalance = decryptData(encryptedBalance, SECRET_KEY);
        return Double.parseDouble(decryptedBalance);
    }
    public String getDateCreated() throws Exception {
        return decryptData(encryptedDateCreated, SECRET_KEY);
    }
    public String getOwnerName() throws Exception {
        return decryptData(encryptedOwnerName, SECRET_KEY);
    }
    public void deposit(double amount) throws MalformedBalanceException {
        if (amount < 0) {
            throw new MalformedBalanceException("Deposit amount cannot be negative.");
        }
        try {
            double decryptedBalance = Double.parseDouble(decryptData(encryptedBalance, SECRET_KEY));
            double updatedBalance = decryptedBalance + amount;
            encryptedBalance = encryptData(Double.toString(updatedBalance), SECRET_KEY);
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public abstract void withdraw(double amount) throws MalformedBalanceException, DailyLimitException;

    @Override
    public String toString() {
        return "Account_W2023_Champions{" +
                "encryptedBalance=" + encryptedBalance +
                ", encryptedDateCreated='" + encryptedDateCreated + '\'' +
                ", encryptedOwnerName='" + encryptedOwnerName + '\'' +
                ", encryptedAccountNumber='" + encryptedAccountNumber + '\'' +
                '}';
    }

    private String encryptData(String data, String secretKey) throws Exception {
        SecretKeySpec secretKeySpec = generateSecretKeySpec(secretKey);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private String decryptData(String encryptedData, String secretKey) throws Exception {
        SecretKeySpec secretKeySpec = generateSecretKeySpec(secretKey);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    private SecretKeySpec generateSecretKeySpec(String secretKey) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] key = sha.digest(secretKey.getBytes());
        return new SecretKeySpec(key, ENCRYPTION_ALGORITHM);
    }
}
