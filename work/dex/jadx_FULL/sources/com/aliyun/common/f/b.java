package com.aliyun.common.f;

import android.net.Uri;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.aliyun.common.b.a f25573a;

    public b(com.aliyun.common.b.a aVar) {
        this.f25573a = aVar;
    }

    private <T> T a(InputStream inputStream, Class<? extends T> cls) {
        try {
            T t = (T) this.f25573a.readValue(inputStream, cls);
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            return t;
        } catch (Throwable th) {
            try {
                Log.e("ResourceParser", "failed to read stream as " + cls, th);
                try {
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    public InputStream a(String str) {
        Uri uri = Uri.parse(str);
        if (uri == null) {
            Log.e("ResourceParser", "failed to parse uri: " + str);
            return null;
        }
        String path = uri.getPath();
        Log.d("ResourceParser", "scheme : " + uri.getScheme() + " host : " + uri.getHost() + " path : " + uri.getPath());
        try {
            return new FileInputStream(path);
        } catch (Throwable th) {
            Log.e("ResourceParser", "failed to open assets: " + str, th);
            return null;
        }
    }

    public <T> T a(String str, Class<? extends T> cls) {
        InputStream inputStreamA = a(str);
        if (inputStreamA == null) {
            return null;
        }
        return (T) a(inputStreamA, cls);
    }

    public <T extends a> T b(String str, Class<? extends T> cls) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith("/config.json")) {
            str = str + "/config.json";
        }
        T t = (T) a(str, cls);
        if (t == null || !t.validate()) {
            return null;
        }
        return t;
    }
}
