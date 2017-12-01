package com.genericrest.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author fernando
 */
public class Criptography {

    private static final String ALGORITHM = "MD5";
    private static MessageDigest md;

    public static String encrypt(String password) {
        if (StringUtils.isEmpty(password)) {
            return null;
        }
        try {
            md = MessageDigest.getInstance(ALGORITHM);
            byte[] passBytes = password.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
