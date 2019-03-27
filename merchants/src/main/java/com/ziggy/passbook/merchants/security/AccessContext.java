package com.ziggy.passbook.merchants.security;

/*
用ThreadLocal去单独存储每一个线程携带的Token信息
 */
public class AccessContext {
    private static final ThreadLocal<String> token = new ThreadLocal<>();

    public static String getToken(){
        return token.get();
    }

    public static void setToken(String tokenString){
        token.set(tokenString);
    }

    public static void clearAccessKey(){
        token.remove();
    }
}
