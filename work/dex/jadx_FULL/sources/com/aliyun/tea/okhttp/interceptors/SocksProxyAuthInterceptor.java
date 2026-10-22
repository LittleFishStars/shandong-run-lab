package com.aliyun.tea.okhttp.interceptors;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SocksProxyAuthInterceptor implements Interceptor {
    private String password;
    private String user;

    public SocksProxyAuthInterceptor(String str, String str2) {
        this.user = str;
        this.password = str2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        ThreadLocalProxyAuthenticator.getInstance().setCredentials(this.user, this.password);
        try {
            return chain.proceed(chain.request());
        } finally {
            ThreadLocalProxyAuthenticator.clearCredentials();
        }
    }
}
