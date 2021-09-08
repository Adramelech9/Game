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

    public static String getSeq() {
        return seq;
    }

    public static int[] getSequence() {
        return sequence;
    }

    RandomKey(int num) throws NoSuchAlgorithmException, InvalidKeyException {
        SecureRandom random = new SecureRandom();
        SecureRandom random2 = new SecureRandom();

        for (int i = 0; i < 128; i++) {
            this.sequence[i] = random.nextInt(num) + 1;
            this.seq += sequence[i];
            key += random2.nextInt(9);
        }

        final Charset asciiCs = Charset.forName("US-ASCII");
        final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        final SecretKeySpec secret_key = new javax.crypto.spec.SecretKeySpec(asciiCs.encode(key).array(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        final byte[] mac_data = sha256_HMAC.doFinal(asciiCs.encode(seq).array());
        String result = "";
        for (final byte element : mac_data)
        {
            result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }
        System.out.println("HMAC: " + result);

    }
}
