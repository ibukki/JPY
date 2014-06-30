package com.jpy.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.jersey.core.util.Base64;

public class PasswordUtil {

    public static String getEncryPassword(String Password) throws NoSuchAlgorithmException
    {
    	MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(Password.getBytes());
        byte[] b=md.digest();
        return new String(Base64.encode(b));
    }
    
}
