package book.beans;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Leonard
 */
public final class DESFunction {

    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;
    private static byte[] bytekey = {
            0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79
    };

    private static void init() {

        try {
            
            key = new SecretKeySpec(bytekey, "AES");

            ecipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            dcipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
        }

    }

    public static String encrypt(String str) {

        init();
        try {
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            enc = BASE64EncoderStream.encode(enc);

            return new String(enc);

        } catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Encrypt exception:" + e.getMessage());
        }
        return null;
    }

    public static String decrypt(String str) {

        init();
        try {

            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);

            return new String(utf8, "UTF8");

        } catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            System.out.println("Decrypt exception:" + e.getMessage());
        }

        return null;
    }
}
