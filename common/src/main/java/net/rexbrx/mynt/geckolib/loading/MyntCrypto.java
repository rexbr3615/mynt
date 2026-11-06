package net.rexbrx.mynt.geckolib.loading;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HexFormat;

/**
 * Decrypts .myntmodel contents.
 * <p>
 * Encrypted files start with {@link #MAGIC}; anything else is treated as plain JSON and returned untouched,
 * so unencrypted models keep working
 */
public final class MyntCrypto {
    private static final String MAGIC = "MYNT1:";
    private static final int IV_LENGTH = 12;
    private static final int TAG_BITS = 128;
    private static final SecretKeySpec KEY =
            new SecretKeySpec(HexFormat.of().parseHex("PUT_YOUR_KEY_HERE"), "AES");

    private MyntCrypto() {}

    /**
     * Returns the plain text of a model file, decrypting it first if it is encrypted
     */
    public static String decryptIfNeeded(String content) {
        if (!content.startsWith(MAGIC))
            return content;

        try {
            byte[] raw = Base64.getDecoder().decode(content.substring(MAGIC.length()).trim());
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            cipher.init(Cipher.DECRYPT_MODE, KEY, new GCMParameterSpec(TAG_BITS, raw, 0, IV_LENGTH));

            return new String(cipher.doFinal(raw, IV_LENGTH, raw.length - IV_LENGTH), StandardCharsets.UTF_8);
        }
        catch (GeneralSecurityException | IllegalArgumentException ex) {
            throw new IllegalStateException("Unable to decrypt model file", ex);
        }
    }
}
