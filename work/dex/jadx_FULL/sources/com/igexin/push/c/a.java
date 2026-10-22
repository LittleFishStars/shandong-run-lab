package com.igexin.push.c;

import android.text.TextUtils;
import com.igexin.push.config.SDKUrlConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f37881a = com.igexin.push.c.b.f37886a + a.class.getName();
    private static final int q = 10;
    int b;
    protected int g;
    protected volatile long h;
    protected volatile long i;
    boolean j;
    private int l;
    private int m;
    private d n;
    final List<d> c = new ArrayList();
    private final List<b> o = new ArrayList();
    final Object d = new Object();
    private final Object p = new Object();
    public volatile EnumC0850a e = EnumC0850a.NORMAL;
    private int r = 0;
    public AtomicBoolean f = new AtomicBoolean(false);
    final Comparator<d> k = new Comparator<d>() { // from class: com.igexin.push.c.a.1
        private static int a(d dVar, d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(d dVar, d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }
    };

    /* JADX INFO: renamed from: com.igexin.push.c.a$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37883a;

        static {
            int[] iArr = new int[EnumC0850a.values().length];
            f37883a = iArr;
            try {
                iArr[EnumC0850a.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37883a[EnumC0850a.BACKUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37883a[EnumC0850a.TRY_NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.c.a$a, reason: collision with other inner class name */
    public enum EnumC0850a {
        NORMAL(0),
        BACKUP(1),
        TRY_NORMAL(2);

        int d;

        EnumC0850a(int i) {
            this.d = i;
        }

        private int a() {
            return this.d;
        }

        public static EnumC0850a a(int i) {
            for (EnumC0850a enumC0850a : values()) {
                if (enumC0850a.d == i) {
                    return enumC0850a;
                }
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f37885a;
        public long b;

        public final b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            try {
                this.f37885a = jSONObject.getString("address");
                this.b = jSONObject.getLong("outdateTime");
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            return this;
        }

        public final JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("address", this.f37885a);
                jSONObject.put("outdateTime", this.b);
                return jSONObject;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return null;
            }
        }

        public final String toString() {
            return "ServerAddress{address='" + this.f37885a + "', outdateTime=" + this.b + '}';
        }
    }

    private String a(boolean z) {
        try {
            synchronized (this.p) {
                String str = this.j ? com.igexin.push.core.e.at : com.igexin.push.core.e.au;
                if (this.o.isEmpty() && TextUtils.isEmpty(str)) {
                    com.igexin.c.a.c.a.a(f37881a + "cm list size = 0", new Object[0]);
                    this.m = 0;
                    this.l = 0;
                    return null;
                }
                if (this.o.isEmpty() && !TextUtils.isEmpty(str)) {
                    a(str);
                }
                StringBuilder sb = new StringBuilder();
                String str2 = f37881a;
                sb.append(str2);
                sb.append("cm try = ");
                sb.append(this.m);
                sb.append(" times");
                com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                if (this.m >= this.o.size() * 1) {
                    com.igexin.c.a.c.a.a(str2 + "cm invalid", new Object[0]);
                    this.m = 0;
                    this.l = 0;
                    this.o.clear();
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<b> it = this.o.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.b < jCurrentTimeMillis) {
                        com.igexin.c.a.c.a.a(f37881a + "|add[" + next.f37885a + "] outDate", new Object[0]);
                        it.remove();
                    }
                }
                h();
                if (this.o.isEmpty()) {
                    return null;
                }
                if (z) {
                    this.m++;
                }
                int i = this.l >= this.o.size() ? 0 : this.l;
                this.l = i;
                String str3 = this.o.get(i).f37885a;
                this.l++;
                return str3;
            }
        } catch (Exception e) {
            String str4 = f37881a;
            com.igexin.c.a.c.a.a(str4, e.toString());
            com.igexin.c.a.c.a.a(str4 + "|" + e.toString(), new Object[0]);
            return null;
        }
    }

    private void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.o.add(new b().a(jSONArray.getJSONObject(i)));
            }
            com.igexin.c.a.c.a.a(f37881a + "|get cm from cache, isWf = " + this.j + ", lastCmList = " + str, new Object[0]);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private String b(boolean z) {
        String strA;
        synchronized (this.d) {
            int i = this.b >= this.c.size() ? 0 : this.b;
            this.b = i;
            d dVar = this.c.get(i);
            this.n = dVar;
            strA = dVar.a(z);
        }
        return strA;
    }

    private void c(boolean z) {
        this.j = z;
    }

    private List<b> g() {
        return this.o;
    }

    private void h() {
        JSONArray jSONArray = new JSONArray();
        Iterator<b> it = this.o.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        com.igexin.push.core.e.f.a().c(jSONArray.length() == 0 ? "null" : jSONArray.toString(), !this.j);
    }

    private void i() {
        synchronized (this.d) {
            this.b = 0;
            Collections.sort(this.c, this.k);
        }
    }

    private void j() {
        com.igexin.c.a.c.a.a(f37881a + "|detect success, current type = " + this.e, new Object[0]);
        if (this.e == EnumC0850a.BACKUP) {
            a(EnumC0850a.TRY_NORMAL);
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
            com.igexin.push.e.a.a(true);
        }
    }

    private void k() {
        com.igexin.c.a.c.a.a(f37881a + "|before disconnect, type = " + this.e, new Object[0]);
        int i = AnonymousClass2.f37883a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                a(EnumC0850a.TRY_NORMAL);
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - this.i <= 86400000 || this.g <= com.igexin.push.config.d.t) {
            return;
        }
        a(EnumC0850a.BACKUP);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0088 A[Catch: all -> 0x00bd, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0022, B:7:0x0026, B:8:0x002a, B:26:0x00ae, B:15:0x003c, B:17:0x0040, B:18:0x0043, B:20:0x004c, B:21:0x0052, B:22:0x007b, B:24:0x0088, B:25:0x008d), top: B:32:0x0001 }] */
    public final synchronized void a(EnumC0850a enumC0850a) {
        StringBuilder sb = new StringBuilder();
        String str = f37881a;
        sb.append(str);
        sb.append("|set domain type = ");
        sb.append(enumC0850a);
        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
        if (com.igexin.push.config.d.g) {
            if (this.e != enumC0850a) {
                a((List<b>) null);
            }
            int i = AnonymousClass2.f37883a[enumC0850a.ordinal()];
            if (i == 1) {
                this.b = 0;
                SDKUrlConfig.setConnectAddress(b(true));
                if (enumC0850a == EnumC0850a.NORMAL) {
                    this.f.set(false);
                }
                SDKUrlConfig.getConnectAddress();
                com.igexin.c.a.c.a.a(str + "|set domain type normal cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
            } else if (i == 2) {
                this.f.set(true);
                if (this.e != enumC0850a) {
                    this.h = System.currentTimeMillis();
                }
                SDKUrlConfig.setConnectAddress(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                SDKUrlConfig.getConnectAddress();
                com.igexin.c.a.c.a.a(str + "|set domain type backup cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
            } else if (i == 3) {
                if (this.e != enumC0850a) {
                    this.r = 0;
                }
                this.b = 0;
                SDKUrlConfig.setConnectAddress(b(true));
                if (enumC0850a == EnumC0850a.NORMAL) {
                    this.f.set(false);
                }
                SDKUrlConfig.getConnectAddress();
                com.igexin.c.a.c.a.a(str + "|set domain type normal cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
            }
            this.e = enumC0850a;
            c.a().f().n();
        }
    }

    public final void a(List<b> list) {
        synchronized (this.p) {
            this.l = 0;
            this.m = 0;
            this.o.clear();
            if (list != null) {
                this.o.addAll(list);
                com.igexin.c.a.c.a.a(f37881a + "|set cm list: " + list.toString(), new Object[0]);
            }
            h();
        }
    }

    public final boolean a() {
        boolean z;
        try {
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
            z = true;
            boolean z2 = !com.igexin.push.e.a.e();
            String strA = a(z2);
            StringBuilder sb = new StringBuilder();
            String str = f37881a;
            sb.append(str);
            sb.append("|get from cm = ");
            sb.append(strA);
            com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
            if (strA == null) {
                if (com.igexin.push.config.d.g && this.e == EnumC0850a.BACKUP) {
                    int i = this.b;
                    String[] strArr = SDKUrlConfig.XFR_ADDRESS_BAK;
                    if (i >= strArr.length) {
                        i = 0;
                    }
                    strA = strArr[i];
                    this.b = i + 1;
                } else {
                    d dVar = this.n;
                    if (dVar != null && !dVar.d()) {
                        this.b++;
                    }
                    strA = b(z2);
                }
                z = false;
            }
            try {
                if (!SDKUrlConfig.getConnectAddress().equals(strA)) {
                    SDKUrlConfig.getConnectAddress();
                    com.igexin.c.a.c.a.a(str + "|address changed : form [" + SDKUrlConfig.getConnectAddress() + "] to [" + strA + "]", new Object[0]);
                }
                SDKUrlConfig.setConnectAddress(strA);
            } catch (Exception e) {
                e = e;
                com.igexin.c.a.c.a.a(e);
                String str2 = f37881a;
                com.igexin.c.a.c.a.a(str2, e.toString());
                com.igexin.c.a.c.a.a(str2 + "|switch address|" + e.toString(), new Object[0]);
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        return z;
    }

    public final synchronized void b() {
        this.m = 0;
        d dVar = this.n;
        if (dVar != null) {
            dVar.e();
        }
    }

    public final void b(List<d> list) {
        synchronized (this.d) {
            this.c.clear();
            this.c.addAll(list);
            Collections.sort(this.c, this.k);
        }
    }

    public final synchronized void c() {
        this.g++;
        com.igexin.c.a.c.a.a(f37881a + "|loginFailedCnt = " + this.g, new Object[0]);
    }

    public final void d() {
        if (AnonymousClass2.f37883a[this.e.ordinal()] == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
            a(EnumC0850a.TRY_NORMAL);
        }
    }

    public final void e() {
        if (this.e != EnumC0850a.BACKUP) {
            this.g = 0;
        }
        int i = AnonymousClass2.f37883a[this.e.ordinal()];
        if (i == 1) {
            this.i = System.currentTimeMillis();
            c.a().f().n();
            this.f.set(false);
        } else {
            if (i != 3) {
                return;
            }
            a(EnumC0850a.NORMAL);
            this.f.set(false);
        }
    }

    public final void f() {
        EnumC0850a enumC0850a;
        com.igexin.c.a.c.a.a(f37881a + "|before disconnect, type = " + this.e, new Object[0]);
        int[] iArr = AnonymousClass2.f37883a;
        int i = iArr[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                enumC0850a = EnumC0850a.TRY_NORMAL;
                a(enumC0850a);
            }
        } else if (System.currentTimeMillis() - this.i > 86400000 && this.g > com.igexin.push.config.d.t) {
            enumC0850a = EnumC0850a.BACKUP;
            a(enumC0850a);
        }
        if (com.igexin.push.core.e.u && this.e != EnumC0850a.BACKUP) {
            this.i = System.currentTimeMillis();
            c.a().f().n();
        }
        if (iArr[this.e.ordinal()] != 3) {
            return;
        }
        int i2 = this.r + 1;
        this.r = i2;
        if (i2 >= 10) {
            this.g = 0;
            this.h = System.currentTimeMillis();
            a(EnumC0850a.BACKUP);
        }
    }
}
