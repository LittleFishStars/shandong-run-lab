package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class o91 implements CacheConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, o91> f43692a = new HashMap();
    public static final long b = Long.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f18576b = "cdu_";
    public static final String c = "by_";
    public static final String d = "st_";
    public static final String e = "jo_";
    public static final int f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f18577f = "ja_";
    public static final String g = "bi_";
    public static final String h = "dr_";
    public static final String i = "pa_";
    public static final String j = "se_";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f18578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f18579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final File f18580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18581a;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final int f18582e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f43693a = 14;

        public static byte[] d(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        public static String e(int i) {
            return String.format(Locale.getDefault(), "_$%010d$_", Long.valueOf((System.currentTimeMillis() / 1000) + ((long) i)));
        }

        public static byte[] f(byte[] bArr) {
            return h(bArr) ? d(bArr, 14, bArr.length) : bArr;
        }

        public static long g(byte[] bArr) {
            if (h(bArr)) {
                try {
                    return Long.parseLong(new String(d(bArr, 2, 12))) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
            return -1L;
        }

        public static boolean h(byte[] bArr) {
            return bArr != null && bArr.length >= 14 && bArr[0] == 95 && bArr[1] == 36 && bArr[12] == 36 && bArr[13] == 95;
        }

        public static boolean i(byte[] bArr) {
            long jG = g(bArr);
            return jG != -1 && System.currentTimeMillis() > jG;
        }

        public static byte[] j(int i, byte[] bArr) {
            byte[] bytes = e(i).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43694a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f18583a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final File f18584a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Thread f18585a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<File, Long> f18586a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicInteger f18587a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicLong f18588a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ File f18589a;

            /* JADX INFO: renamed from: com.zj.adlib.o91$b$a$a, reason: collision with other inner class name */
            public class C1331a implements FilenameFilter {
                public C1331a() {
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.startsWith(o91.f18576b);
                }
            }

            public a(File file) {
                this.f18589a = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = this.f18589a.listFiles(new C1331a());
                if (fileArrListFiles != null) {
                    int length = 0;
                    int i = 0;
                    for (File file : fileArrListFiles) {
                        length = (int) (((long) length) + file.length());
                        i++;
                        b.this.f18586a.put(file, Long.valueOf(file.lastModified()));
                    }
                    b.this.f18588a.getAndAdd(length);
                    b.this.f18587a.getAndAdd(i);
                }
            }
        }

        /* JADX INFO: renamed from: com.zj.adlib.o91$b$b, reason: collision with other inner class name */
        public class C1332b implements FilenameFilter {
            public C1332b() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(o91.f18576b);
            }
        }

        public b(File file, long j, int i) {
            this.f18586a = Collections.synchronizedMap(new HashMap());
            this.f18584a = file;
            this.f18583a = j;
            this.f43694a = i;
            this.f18588a = new AtomicLong();
            this.f18587a = new AtomicInteger();
            Thread thread = new Thread(new a(file));
            this.f18585a = thread;
            thread.start();
        }

        public final boolean l() {
            File[] fileArrListFiles = this.f18584a.listFiles(new C1332b());
            boolean z = true;
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    if (file.delete()) {
                        this.f18588a.addAndGet(-file.length());
                        this.f18587a.addAndGet(-1);
                        this.f18586a.remove(file);
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.f18586a.clear();
                    this.f18588a.set(0L);
                    this.f18587a.set(0);
                }
            }
            return z;
        }

        public final int m() {
            v();
            return this.f18587a.get();
        }

        public final String n(String str) {
            return o91.f18576b + str.substring(0, 3) + str.substring(3).hashCode();
        }

        public final long o() {
            v();
            return this.f18588a.get();
        }

        public final File p(String str) {
            v();
            File file = new File(this.f18584a, n(str));
            if (file.exists()) {
                this.f18587a.addAndGet(-1);
                this.f18588a.addAndGet(-file.length());
            }
            return file;
        }

        public final File q(String str) {
            File file = new File(this.f18584a, n(str));
            if (file.exists()) {
                return file;
            }
            return null;
        }

        public final void r(File file) {
            this.f18587a.addAndGet(1);
            this.f18588a.addAndGet(file.length());
            while (true) {
                if (this.f18587a.get() <= this.f43694a && this.f18588a.get() <= this.f18583a) {
                    return;
                }
                this.f18588a.addAndGet(-t());
                this.f18587a.addAndGet(-1);
            }
        }

        public final boolean s(String str) {
            File fileQ = q(str);
            if (fileQ == null) {
                return true;
            }
            if (!fileQ.delete()) {
                return false;
            }
            this.f18588a.addAndGet(-fileQ.length());
            this.f18587a.addAndGet(-1);
            this.f18586a.remove(fileQ);
            return true;
        }

        public final long t() {
            File key;
            if (this.f18586a.isEmpty()) {
                return 0L;
            }
            Long l = Long.MAX_VALUE;
            Set<Map.Entry<File, Long>> setEntrySet = this.f18586a.entrySet();
            synchronized (this.f18586a) {
                key = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    Long value = entry.getValue();
                    if (value.longValue() < l.longValue()) {
                        key = entry.getKey();
                        l = value;
                    }
                }
            }
            if (key == null) {
                return 0L;
            }
            long length = key.length();
            if (!key.delete()) {
                return 0L;
            }
            this.f18586a.remove(key);
            return length;
        }

        public final void u(File file) {
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            this.f18586a.put(file, lValueOf);
        }

        public final void v() {
            try {
                this.f18585a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public o91(String str, File file, long j2, int i2) {
        this.f18581a = str;
        this.f18580a = file;
        this.f18578a = j2;
        this.f18582e = i2;
    }

    public static o91 k() {
        return p("", Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static o91 l(long j2, int i2) {
        return p("", j2, i2);
    }

    public static o91 m(@NonNull File file) {
        return n(file, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static o91 n(@NonNull File file, long j2, int i2) {
        String str = file.getAbsoluteFile() + LoginConstants.UNDER_LINE + j2 + LoginConstants.UNDER_LINE + i2;
        Map<String, o91> map = f43692a;
        o91 o91Var = map.get(str);
        if (o91Var == null) {
            synchronized (o91.class) {
                o91Var = map.get(str);
                if (o91Var == null) {
                    o91 o91Var2 = new o91(str, file, j2, i2);
                    map.put(str, o91Var2);
                    o91Var = o91Var2;
                }
            }
        }
        return o91Var;
    }

    public static o91 o(String str) {
        return p(str, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static o91 p(String str, long j2, int i2) {
        if (i.C0(str)) {
            str = "cacheUtils";
        }
        return n(new File(Utils.a().getCacheDir(), str), j2, i2);
    }

    public void A(@NonNull String str, Bitmap bitmap) {
        B(str, bitmap, -1);
    }

    public void B(@NonNull String str, Bitmap bitmap, int i2) {
        S(g + str, i.e(bitmap), i2);
    }

    public void C(@NonNull String str, Drawable drawable) {
        D(str, drawable, -1);
    }

    public void D(@NonNull String str, Drawable drawable, int i2) {
        S(h + str, i.x(drawable), i2);
    }

    public void E(@NonNull String str, Parcelable parcelable) {
        F(str, parcelable, -1);
    }

    public void F(@NonNull String str, Parcelable parcelable, int i2) {
        S(i + str, i.J0(parcelable), i2);
    }

    public void G(@NonNull String str, Serializable serializable) {
        H(str, serializable, -1);
    }

    public void H(@NonNull String str, Serializable serializable, int i2) {
        S(j + str, i.V0(serializable), i2);
    }

    public void I(@NonNull String str, String str2) {
        J(str, str2, -1);
    }

    public void J(@NonNull String str, String str2, int i2) {
        S(d + str, i.Y0(str2), i2);
    }

    public void K(@NonNull String str, JSONArray jSONArray) {
        L(str, jSONArray, -1);
    }

    public void L(@NonNull String str, JSONArray jSONArray, int i2) {
        S(f18577f + str, i.E0(jSONArray), i2);
    }

    public void M(@NonNull String str, JSONObject jSONObject) {
        N(str, jSONObject, -1);
    }

    public void N(@NonNull String str, JSONObject jSONObject, int i2) {
        S(e + str, i.F0(jSONObject), i2);
    }

    public void O(@NonNull String str, byte[] bArr) {
        P(str, bArr, -1);
    }

    public void P(@NonNull String str, byte[] bArr, int i2) {
        S(c + str, bArr, i2);
    }

    public final byte[] Q(@NonNull String str) {
        return R(str, null);
    }

    public final byte[] R(@NonNull String str, byte[] bArr) {
        File fileQ;
        b bVarH = h();
        if (bVarH == null || (fileQ = bVarH.q(str)) == null) {
            return bArr;
        }
        byte[] bArrO0 = i.O0(fileQ);
        if (a.i(bArrO0)) {
            bVarH.s(str);
            return bArr;
        }
        bVarH.u(fileQ);
        return a.f(bArrO0);
    }

    public final void S(String str, byte[] bArr, int i2) {
        b bVarH;
        if (bArr == null || (bVarH = h()) == null) {
            return;
        }
        if (i2 >= 0) {
            bArr = a.j(i2, bArr);
        }
        File fileP = bVarH.p(str);
        i.f1(fileP, bArr);
        bVarH.u(fileP);
        bVarH.r(fileP);
    }

    public boolean T(@NonNull String str) {
        b bVarH = h();
        if (bVarH == null) {
            return true;
        }
        if (bVarH.s(c + str)) {
            if (bVarH.s(d + str)) {
                if (bVarH.s(e + str)) {
                    if (bVarH.s(f18577f + str)) {
                        if (bVarH.s(g + str)) {
                            if (bVarH.s(h + str)) {
                                if (bVarH.s(i + str)) {
                                    if (bVarH.s(j + str)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean a() {
        b bVarH = h();
        if (bVarH == null) {
            return true;
        }
        return bVarH.l();
    }

    public Bitmap b(@NonNull String str) {
        return c(str, null);
    }

    public Bitmap c(@NonNull String str, Bitmap bitmap) {
        byte[] bArrQ = Q(g + str);
        return bArrQ == null ? bitmap : i.i(bArrQ);
    }

    public byte[] d(@NonNull String str) {
        return e(str, null);
    }

    public byte[] e(@NonNull String str, byte[] bArr) {
        return R(c + str, bArr);
    }

    public int f() {
        b bVarH = h();
        if (bVarH == null) {
            return 0;
        }
        return bVarH.m();
    }

    public long g() {
        b bVarH = h();
        if (bVarH == null) {
            return 0L;
        }
        return bVarH.o();
    }

    public final b h() {
        if (this.f18580a.exists()) {
            if (this.f18579a == null) {
                this.f18579a = new b(this.f18580a, this.f18578a, this.f18582e);
            }
        } else if (this.f18580a.mkdirs()) {
            this.f18579a = new b(this.f18580a, this.f18578a, this.f18582e);
        } else {
            Log.e("CacheDiskUtils", "can't make dirs in " + this.f18580a.getAbsolutePath());
        }
        return this.f18579a;
    }

    public Drawable i(@NonNull String str) {
        return j(str, null);
    }

    public Drawable j(@NonNull String str, Drawable drawable) {
        byte[] bArrQ = Q(h + str);
        return bArrQ == null ? drawable : i.j(bArrQ);
    }

    public JSONArray q(@NonNull String str) {
        return r(str, null);
    }

    public JSONArray r(@NonNull String str, JSONArray jSONArray) {
        byte[] bArrQ = Q(f18577f + str);
        return bArrQ == null ? jSONArray : i.l(bArrQ);
    }

    public JSONObject s(@NonNull String str) {
        return t(str, null);
    }

    public JSONObject t(@NonNull String str, JSONObject jSONObject) {
        byte[] bArrQ = Q(e + str);
        return bArrQ == null ? jSONObject : i.m(bArrQ);
    }

    public String toString() {
        return this.f18581a + "@" + Integer.toHexString(hashCode());
    }

    public <T> T u(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return (T) v(str, creator, null);
    }

    public <T> T v(@NonNull String str, @NonNull Parcelable.Creator<T> creator, T t) {
        byte[] bArrQ = Q(i + str);
        return bArrQ == null ? t : (T) i.o(bArrQ, creator);
    }

    public Object w(@NonNull String str) {
        return x(str, null);
    }

    public Object x(@NonNull String str, Object obj) {
        byte[] bArrQ = Q(j + str);
        return bArrQ == null ? obj : i.n(bArrQ);
    }

    public String y(@NonNull String str) {
        return z(str, null);
    }

    public String z(@NonNull String str, String str2) {
        byte[] bArrQ = Q(d + str);
        return bArrQ == null ? str2 : i.p(bArrQ);
    }
}
