package cz.covid.po.api.integration.common.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.util.Assert;

/**
 * Utility class for encryption.
 */
public final class EncryptionUtil {

    /**
     * Encryption by MD5.
     *
     * @param val value to encrypt
     *
     * @return encrypted
     */
    public static String encryptMD5(String val) {
        Assert.notNull(val, "val cannot be null");
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(val));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Some problem with MD5 encryption", e);
        }
    }

}
