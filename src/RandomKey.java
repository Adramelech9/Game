import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomKey {
    private static String seq = "";
    private static int[] sequence = new int [128];
    private static String key = "";
    byte bytes[] = new byte[128/8];

    public static String getKey() {
        return key;
    }

    public static int[] getSequence() {
        return sequence;
    }
    RandomKey(int i, int a) throws NoSuchAlgorithmException, InvalidKeyException {
        SecureRandom random = new SecureRandom();
        this.bytes = new byte[128/8];
        random.nextBytes(bytes);
        this.key = "";
        for (int j = 0; j < bytes.length; j++) {
            key += bytes[j];
        }
        String seq = String.valueOf(sequence[i]);
        randomHMAC(key, seq);
    }

    RandomKey(int num) {
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        for (int i = 0; i < bytes.length; i++) {
            key += bytes[i];
        }
        for (int i = 0; i < 128; i++) {
            this.sequence[i] = random.nextInt(num) + 1;
            this.seq += sequence[i];
        }
    }

    public static int randomHMAC(String key, String seq) throws NoSuchAlgorithmException, InvalidKeyException {
        final Charset asciiCs = Charset.forName("US-ASCII");
        final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        final SecretKeySpec secret_key = new javax.crypto.spec.SecretKeySpec(asciiCs.encode(key).array(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        final byte[] mac_data = sha256_HMAC.doFinal(asciiCs.encode(seq).array());
        String result = "";
        for (final byte element : mac_data)
        {
            result += String.format("%02x", element);
        }
        System.out.println(result);
        return 1;
    }
}
