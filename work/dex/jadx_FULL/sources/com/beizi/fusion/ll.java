package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Properties f27520a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ll f27521a = new ll();
    }

    private ll() {
        if (a.f27521a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            Properties properties = new Properties();
            this.f27520a = properties;
            properties.load(inputStreamOpen);
        } catch (IOException unused) {
        } finally {
            if (inputStreamOpen != null) {
                zd.a((Closeable) inputStreamOpen);
            }
        }
    }

    public int b() {
        Properties properties = this.f27520a;
        if (properties == null || !properties.containsKey("logLevel")) {
            return 0;
        }
        return no.i(this.f27520a.getProperty("logLevel", "0"));
    }

    public static ll a() {
        return a.f27521a;
    }
}
