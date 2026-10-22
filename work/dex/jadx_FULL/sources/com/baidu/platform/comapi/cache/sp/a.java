package com.baidu.platform.comapi.cache.sp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, C0287a> f26785a = new HashMap();
    private final SpStorageConfig b;
    private final C0287a c;

    /* JADX INFO: renamed from: com.baidu.platform.comapi.cache.sp.a$a, reason: collision with other inner class name */
    public static class C0287a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedPreferences f26786a;
        private SharedPreferences.Editor b;

        public C0287a(SharedPreferences sharedPreferences) {
            this.f26786a = sharedPreferences;
        }
    }

    private a(SpStorageConfig spStorageConfig) {
        this.b = spStorageConfig;
        String strA = spStorageConfig.a();
        if (!spStorageConfig.b()) {
            this.c = new C0287a(JNIInitializer.getCachedContext().getSharedPreferences(strA, 0));
            return;
        }
        Map<String, C0287a> map = f26785a;
        C0287a c0287a = map.get(strA);
        if (c0287a != null) {
            this.c = c0287a;
            return;
        }
        C0287a c0287a2 = new C0287a(JNIInitializer.getCachedContext().getSharedPreferences(strA, 0));
        this.c = c0287a2;
        map.put(strA, c0287a2);
    }

    public static a a(SpStorageConfig spStorageConfig) {
        if (TextUtils.isEmpty(spStorageConfig.a())) {
            throw new IllegalArgumentException();
        }
        return new a(spStorageConfig);
    }

    public void b(String str, int i) {
        synchronized (this.b) {
            a();
            this.c.b.putInt(str, i).apply();
        }
    }

    public int a(String str, int i) {
        int i2;
        synchronized (this.b) {
            i2 = this.c.f26786a.getInt(str, i);
        }
        return i2;
    }

    public void b(String str, float f) {
        synchronized (this.b) {
            a();
            this.c.b.putFloat(str, f).apply();
        }
    }

    public float a(String str, float f) {
        float f2;
        synchronized (this.b) {
            f2 = this.c.f26786a.getFloat(str, f);
        }
        return f2;
    }

    public void b(String str, long j) {
        synchronized (this.b) {
            a();
            this.c.b.putLong(str, j).apply();
        }
    }

    public long a(String str, long j) {
        long j2;
        synchronized (this.b) {
            j2 = this.c.f26786a.getLong(str, j);
        }
        return j2;
    }

    public void b(String str, boolean z) {
        synchronized (this.b) {
            a();
            this.c.b.putBoolean(str, z).apply();
        }
    }

    public boolean a(String str, boolean z) {
        boolean z2;
        synchronized (this.b) {
            z2 = this.c.f26786a.getBoolean(str, z);
        }
        return z2;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.b) {
            string = this.c.f26786a.getString(str, str2);
        }
        return string;
    }

    public void b(String str, String str2) {
        synchronized (this.b) {
            a();
            this.c.b.putString(str, str2).apply();
        }
    }

    public void a(String str) {
        synchronized (this.b) {
            a();
            this.c.b.remove(str).apply();
        }
    }

    private void a() {
        synchronized (this.b) {
            C0287a c0287a = this.c;
            if (c0287a.b != null) {
                return;
            }
            c0287a.b = c0287a.f26786a.edit();
        }
    }
}
