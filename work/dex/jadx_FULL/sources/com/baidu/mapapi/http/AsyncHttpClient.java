package com.baidu.mapapi.http;

import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AsyncHttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26494a = 10000;
    private int b = 10000;
    private ExecutorService c = Executors.newCachedThreadPool();

    public class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpClient.ProtoResultCallback f26495a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpClient.ProtoResultCallback protoResultCallback, String str) {
            super(null);
            this.f26495a = protoResultCallback;
            this.b = str;
        }

        @Override // com.baidu.mapapi.http.AsyncHttpClient.b
        public void a() throws Throwable {
            HttpClient httpClient = new HttpClient("GET", this.f26495a);
            httpClient.setMaxTimeOut(AsyncHttpClient.this.f26494a);
            httpClient.setReadTimeOut(AsyncHttpClient.this.b);
            httpClient.request(this.b);
        }
    }

    public static abstract class b implements Runnable {
        private b() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public void get(String str, HttpClient.ProtoResultCallback protoResultCallback) {
        if (str == null) {
            throw new IllegalArgumentException("URI cannot be null");
        }
        this.c.submit(new a(protoResultCallback, str));
    }

    public boolean isAuthorized() {
        int iPermissionCheck = PermissionCheck.permissionCheck();
        return iPermissionCheck == 0 || iPermissionCheck == 602 || iPermissionCheck == 601;
    }
}
