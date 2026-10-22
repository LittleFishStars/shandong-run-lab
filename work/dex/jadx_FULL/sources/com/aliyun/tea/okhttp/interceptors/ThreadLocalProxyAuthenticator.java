package com.aliyun.tea.okhttp.interceptors;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ThreadLocalProxyAuthenticator extends Authenticator {
    private ThreadLocal<PasswordAuthentication> credentials;

    public static class SingletonHolder {
        private static final ThreadLocalProxyAuthenticator instance = new ThreadLocalProxyAuthenticator();

        private SingletonHolder() {
        }
    }

    public static void clearCredentials() {
        ThreadLocalProxyAuthenticator threadLocalProxyAuthenticator = getInstance();
        Authenticator.setDefault(threadLocalProxyAuthenticator);
        threadLocalProxyAuthenticator.credentials.set(null);
    }

    public static final ThreadLocalProxyAuthenticator getInstance() {
        return SingletonHolder.instance;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return this.credentials.get();
    }

    public void setCredentials(String str, String str2) {
        ThreadLocalProxyAuthenticator threadLocalProxyAuthenticator = getInstance();
        Authenticator.setDefault(threadLocalProxyAuthenticator);
        threadLocalProxyAuthenticator.credentials.set(new PasswordAuthentication(str, str2.toCharArray()));
    }

    private ThreadLocalProxyAuthenticator() {
        this.credentials = new ThreadLocal<>();
    }
}
