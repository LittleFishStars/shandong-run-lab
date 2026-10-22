package com.baidu.sec.privacy.e;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.hjq.permissions.Permission;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements com.baidu.sec.privacy.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f26808a;
    public static Context b;
    public com.baidu.sec.privacy.e.d.a<String> c;
    public com.baidu.sec.privacy.e.d.a<Integer> d;
    public com.baidu.sec.privacy.e.d.a<Integer> e;
    public com.baidu.sec.privacy.e.d.a<String> f;
    public com.baidu.sec.privacy.e.d.a<String> g;
    public com.baidu.sec.privacy.e.d.a<String> h;
    public com.baidu.sec.privacy.e.d.a<String> i;

    /* JADX INFO: renamed from: com.baidu.sec.privacy.e.a$a, reason: collision with other inner class name */
    public class C0290a implements com.baidu.sec.privacy.e.d.a<String> {
        public C0290a() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return (String) a.this.d(str);
        }
    }

    public class b implements com.baidu.sec.privacy.e.d.a<Integer> {
        public b() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(String str, Object... objArr) {
            return (Integer) a.this.d(str);
        }
    }

    public class c implements com.baidu.sec.privacy.e.d.a<Integer> {
        public c(a aVar) {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(String str, Object... objArr) {
            return (Integer) a.c(str);
        }
    }

    public class d implements com.baidu.sec.privacy.e.d.a<String> {
        public d() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return a.this.f();
        }
    }

    public class e implements com.baidu.sec.privacy.e.d.a<String> {
        public e() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return a.this.e();
        }
    }

    public class f implements com.baidu.sec.privacy.e.d.a<String> {
        public f() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return a.this.d();
        }
    }

    public class g implements com.baidu.sec.privacy.e.d.a<String> {
        public g(a aVar) {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return Build.MANUFACTURER;
        }
    }

    public a(Context context) {
        b = context;
    }

    public final Object d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArrSplit = str.split("&&");
            if (strArrSplit.length != 2) {
                return null;
            }
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            if ("1".equals(str2)) {
                return h(str3);
            }
            if ("2".equals(str2)) {
                return Integer.valueOf(f(str3));
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    public final int e(String str) {
        try {
            return Settings.Secure.getInt(b.getContentResolver(), str);
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public final int f(String str) {
        try {
            return Settings.System.getInt(b.getContentResolver(), str);
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public boolean g() {
        if (com.baidu.sec.privacy.f.c.d(b)) {
            return true;
        }
        return com.baidu.sec.privacy.d.a.a();
    }

    public final String h(String str) {
        try {
            return Settings.System.getString(b.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public String c(String str, boolean z) {
        return c(str, z, false);
    }

    public final String e() {
        return com.baidu.sec.privacy.f.b.a(b);
    }

    public final String f() {
        return com.baidu.sec.privacy.f.b.b(b);
    }

    public static a a(Context context) {
        if (f26808a == null) {
            synchronized (a.class) {
                f26808a = new a(context);
            }
        }
        return f26808a;
    }

    public int b(String str, boolean z) {
        return b(str, z, false);
    }

    public String c(String str, boolean z, boolean z2) {
        if (z) {
            if (this.c == null) {
                this.c = new C0290a();
            }
            return com.baidu.sec.privacy.f.f.a(b, 42, "1&&" + str, z2, this.c, new Object[0]);
        }
        if (com.baidu.sec.privacy.f.f.a(b, 42)) {
            return h(str);
        }
        return com.baidu.sec.privacy.f.f.a(b, z2);
    }

    public final String g(String str) {
        try {
            return Settings.Secure.getString(b.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public int b(String str, boolean z, boolean z2) {
        if (z) {
            if (this.d == null) {
                this.d = new b();
            }
            return com.baidu.sec.privacy.f.f.a(b, 42, "2&&" + str, -1, z2, this.d, new Object[0]);
        }
        if (com.baidu.sec.privacy.f.f.a(b, 42)) {
            return f(str);
        }
        return com.baidu.sec.privacy.f.f.a(b, -1, z2);
    }

    @Override // com.baidu.sec.privacy.b.a
    public boolean a() {
        return com.baidu.sec.privacy.d.b.b(com.baidu.sec.privacy.d.a.e);
    }

    public static Object c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArrSplit = str.split("&&");
            if (strArrSplit.length != 2) {
                return null;
            }
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            if ("1".equals(str2)) {
                return a(com.baidu.sec.privacy.b.b.a()).g(str3);
            }
            if ("2".equals(str2)) {
                return Integer.valueOf(a(com.baidu.sec.privacy.b.b.a()).e(str3));
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    @Override // com.baidu.sec.privacy.b.a
    public File a(String str) {
        try {
            if (com.baidu.sec.privacy.f.f.a(b, 44)) {
                return new File(str);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }

    public String b(boolean z) {
        if (this.f == null) {
            this.f = new d();
        }
        return com.baidu.sec.privacy.f.f.a(b, 7, z, this.f, new Object[0]);
    }

    public final String d() {
        try {
            return com.baidu.sec.privacy.f.d.b(b);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    @Override // com.baidu.sec.privacy.b.a
    public Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        if (com.baidu.sec.privacy.f.f.a(b, 54)) {
            return classLoader.loadClass(str);
        }
        return null;
    }

    public String b() {
        if (this.i == null) {
            this.i = new g(this);
        }
        return com.baidu.sec.privacy.f.f.a(b, 71, false, this.i, new Object[0]);
    }

    public boolean a(String str, String str2) {
        try {
            if (com.baidu.sec.privacy.f.f.a(b, 42) && com.baidu.sec.privacy.f.e.a(b, new String[]{Permission.WRITE_SETTINGS})) {
                return Settings.System.putString(b.getContentResolver(), str, str2);
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return false;
        }
    }

    public int a(String str, boolean z) {
        return a(str, z, false);
    }

    public int a(String str, boolean z, boolean z2) {
        if (z) {
            if (this.e == null) {
                this.e = new c(this);
            }
            return com.baidu.sec.privacy.f.f.a(b, 48, "2&&" + str, -1, z2, this.e, new Object[0]);
        }
        if (com.baidu.sec.privacy.f.f.a(b, 48)) {
            return e(str);
        }
        return com.baidu.sec.privacy.f.f.a(b, -1, z2);
    }

    public Pair<String, String> c() {
        if (this.h == null) {
            this.h = new f();
        }
        String strA = com.baidu.sec.privacy.f.f.a(b, 64, false, this.h, new Object[0]);
        String str = "";
        if (com.baidu.sec.privacy.f.f.a("64")) {
            str = "" + com.baidu.sec.privacy.d.a.a("64la_in", 0L);
        }
        return new Pair<>(strA, str);
    }

    public String a(boolean z) {
        if (this.g == null) {
            this.g = new e();
        }
        return com.baidu.sec.privacy.f.f.a(b, 8, z, this.g, new Object[0]);
    }
}
