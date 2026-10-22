package com.getui.gtc.dim.b;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.dim.AppDataProvider;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimSource;
import com.zj.adlib.c49;
import com.zj.adlib.dv9;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final List<String> f30309a = Arrays.asList("dim-2-1-21-5", "dim-2-1-21-3", "dim-2-1-21-1");
    AppDataProvider e;
    String f;
    private volatile int k;
    private volatile String r;
    int c = 0;
    int d = 1;
    private int m = 3;
    private final int[] n = {-1, 33};
    private volatile boolean s = true;
    final Map<String, Integer> b = new HashMap();
    private final Map<String, Integer> g = new HashMap();
    private final List<String> i = new ArrayList();
    private final List<String> j = new ArrayList();
    private final Map<String, String> h = new HashMap();
    private final Map<String, Boolean> o = new HashMap(4);
    private final List<String> p = new ArrayList();
    private final List<String> q = new ArrayList();
    private final Map<String, Boolean> l = new HashMap();

    /* JADX INFO: renamed from: com.getui.gtc.dim.b.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30310a;

        static {
            int[] iArr = new int[Caller.values().length];
            f30310a = iArr;
            try {
                iArr[Caller.PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30310a[Caller.IDO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30310a[Caller.GY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30310a[Caller.WUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30310a[Caller.ONEID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static boolean a(boolean z, String str) {
        if (z && "*".equals(str)) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        for (String str2 : str.split("#")) {
            if (str2.contains(c49.f40900a)) {
                String[] strArrSplit = str2.split(c49.f40900a);
                if (strArrSplit.length == 2 && i >= Integer.parseInt(strArrSplit[0]) && i <= Integer.parseInt(strArrSplit[1])) {
                    return true;
                }
            } else if (String.valueOf(i).equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String b(Caller caller) {
        if (caller == null) {
            return "";
        }
        int i = AnonymousClass1.f30310a[caller.ordinal()];
        if (i == 1) {
            return dv9.f16127b;
        }
        if (i == 2) {
            return "ido";
        }
        if (i == 3) {
            return "gy";
        }
        if (i != 4) {
            return i != 5 ? "" : "oneid";
        }
        return "wus";
    }

    public static boolean h(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case 320919007:
                    if (str.equals("dim-2-1-21-1")) {
                        b = 0;
                    }
                    break;
                case 320919008:
                    if (str.equals("dim-2-1-21-2")) {
                        b = 1;
                    }
                    break;
                case 320919009:
                    if (str.equals("dim-2-1-21-3")) {
                        b = 2;
                    }
                    break;
                case 320919011:
                    if (str.equals("dim-2-1-21-5")) {
                        b = 3;
                    }
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return true;
            }
        }
        return false;
    }

    private static boolean i(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Boolean j(String str) {
        try {
            if (this.l.containsKey(str)) {
                return this.l.get(str);
            }
            d unused = d.a.f30307a;
            h hVarA = d.a(str);
            Boolean bool = hVarA != null ? (Boolean) hVarA.f30314a : null;
            com.getui.gtc.dim.e.b.a("dim sys callable from db : " + str + " : " + bool);
            this.l.put(str, bool);
            return bool;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("callable", th);
            return null;
        }
    }

    public int a() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
        com.getui.gtc.dim.e.b.a("dim sys busi enable set: ".concat(String.valueOf(i)));
    }

    public void a(AppDataProvider appDataProvider) {
        this.e = appDataProvider;
        com.getui.gtc.dim.e.b.a("dim sys app data provider set: ".concat(String.valueOf(appDataProvider)));
    }

    public void a(Caller caller) {
        if (caller != null) {
            synchronized (this) {
                this.k |= caller.index;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys gtc init caller set: ".concat(String.valueOf(caller)));
    }

    public void a(String str, int i) {
        if (str.equalsIgnoreCase(Build.BRAND)) {
            this.n[0] = i;
        } else if (str.equals("dim-2-2-0-1")) {
            this.n[1] = i;
        }
        com.getui.gtc.dim.e.b.a("dim sys pm policy set: " + str + " : " + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r6.j.contains(r8 + com.zj.adlib.u15.f19942b + b(r7)) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Caller caller, String str) {
        if (caller != null && caller != Caller.UNKNOWN && caller.containAt(this.k)) {
            try {
                if (!this.j.isEmpty()) {
                }
                if ((this.m & 1) == 0) {
                    com.getui.gtc.dim.e.b.a("dim sys ig ca");
                    return true;
                }
                a aVarA = a.a(str);
                if (aVarA != null) {
                    Boolean boolJ = j(aVarA.f30301a + u15.f19942b + caller.name());
                    com.getui.gtc.dim.e.b.a("dim sys get callable " + caller + " : " + str + " : " + boolJ);
                    if (boolJ != null && !boolJ.booleanValue()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
            }
        }
        return false;
    }

    public final boolean a(String str) {
        try {
            return this.i.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(String str, Caller caller, boolean z) {
        this.l.put(str + u15.f19942b + caller.name(), Boolean.valueOf(z));
        d unused = d.a.f30307a;
        d.a(str + u15.f19942b + caller.name(), Boolean.valueOf(z));
        com.getui.gtc.dim.e.b.a("dim sys callable set: " + str + " : " + caller + " : " + z);
        return true;
    }

    public boolean a(String str, String str2) {
        if (Caller.valueOf(str2) == Caller.IDO) {
            return this.s;
        }
        com.getui.gtc.dim.e.b.a("dim sys gbdExecutable get always true");
        return true;
    }

    public final int b(String str) {
        Integer num = 0;
        if (!TextUtils.isEmpty(str) && (num = this.g.get(str)) == null) {
            num = this.g.get("dim-2-2-0-1");
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return j(str + u15.f19942b + Caller.valueOf(str2).name());
        }
        for (Caller caller : Caller.values()) {
            if (caller.containAt(this.k)) {
                Boolean boolJ = j(str + u15.f19942b + caller.name());
                if (boolJ == null || boolJ.booleanValue()) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public void b(int i) {
        this.c = i;
        com.getui.gtc.dim.e.b.a("dim sys trace enable set: ".concat(String.valueOf(i)));
    }

    public void b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, Integer.valueOf(i));
        com.getui.gtc.dim.e.b.a("dim sys globalAllow set: " + str + " : " + i);
    }

    public final boolean b() {
        int[] iArr = this.n;
        int i = iArr[0];
        if (i >= 0) {
            return Build.VERSION.SDK_INT >= i;
        }
        return Build.VERSION.SDK_INT >= iArr[1];
    }

    public boolean b(String str, Caller caller, boolean z) {
        if (caller != Caller.IDO || i("com.igexin.sdk.PushManager") || i("com.g.gysdk.GYManager") || !i("com.getui.gs.sdk.GsManager")) {
            com.getui.gtc.dim.e.b.a("dim sys gbdExecutable set ignored");
            return false;
        }
        this.s = z;
        com.getui.gtc.dim.e.b.a("dim sys gbdExecutable set: ".concat(String.valueOf(z)));
        return true;
    }

    public int c() {
        return this.k;
    }

    public void c(int i) {
        this.d = i;
        com.getui.gtc.dim.e.b.a("dim sys trace hw oaid enable set: ".concat(String.valueOf(i)));
    }

    public void c(String str) {
        if (str != null) {
            try {
                if (str.contains(new String(Base64.decode("Y29tLmdldHVpLmd0Yy5leHRlbnNpb24uZGlzdHJpYnV0aW9uLmdkaS5zdHViLlB1c2hFeHRlbnNpb24=", 2)))) {
                    this.f = str;
                }
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
                return;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys gtc dyc config set: ".concat(String.valueOf(str)));
    }

    public void c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, Integer.valueOf(i));
        com.getui.gtc.dim.e.b.a("dim sys globalAllow policy set: " + str + " : " + i);
    }

    public void c(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (String str3 : str2.split("#")) {
                this.j.add(str + u15.f19942b + str3);
            }
            com.getui.gtc.dim.e.b.a("dim sys global disallow set: " + str + " : " + str2);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("dim sys global disallow set: " + str + " : " + str2, th);
        }
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.h.put(str, str2);
        com.getui.gtc.dim.e.b.a("dim sys global trace order set: " + str + " : " + str2);
    }

    public final boolean d(String str) {
        for (Caller caller : Caller.values()) {
            if (a(caller, str)) {
                return true;
            }
        }
        return false;
    }

    public final DimSource e(String str) {
        String str2;
        try {
            ArrayList<Caller> arrayList = new ArrayList();
            for (Caller caller : Caller.values()) {
                if (a(caller, str)) {
                    arrayList.add(caller);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            if (this.h.isEmpty()) {
                str2 = null;
            } else {
                str2 = this.h.get(str);
                if (str2 == null) {
                    str2 = this.h.get("dim-2-2-0-1");
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                String[] strArrSplit = str2.split("#");
                if (strArrSplit.length >= 4) {
                    for (String str3 : strArrSplit) {
                        for (Caller caller2 : arrayList) {
                            if (b(caller2).equals(str3)) {
                                return DimSource.of(caller2);
                            }
                        }
                    }
                } else {
                    com.getui.gtc.dim.e.b.b("dim sys trace order: " + str2 + " not match for " + str);
                }
            }
            Caller caller3 = Caller.IDO;
            if (arrayList.contains(caller3)) {
                return DimSource.of(caller3);
            }
            Caller caller4 = Caller.PUSH;
            if (arrayList.contains(caller4)) {
                return DimSource.of(caller4);
            }
            Caller caller5 = Caller.GY;
            if (arrayList.contains(caller5)) {
                return DimSource.of(caller5);
            }
            Caller caller6 = Caller.WUS;
            if (arrayList.contains(caller6)) {
                return DimSource.of(caller6);
            }
            Caller caller7 = Caller.ONEID;
            if (arrayList.contains(caller7)) {
                return DimSource.of(caller7);
            }
            return null;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("allowSource key:".concat(String.valueOf(str)), th);
        }
    }

    public void e(String str, String str2) {
        boolean zA = a(false, str2);
        this.o.put(str, Boolean.valueOf(zA));
        com.getui.gtc.dim.e.b.a("dim sys black version set: " + str + " : " + str2 + " : " + zA);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.add(str);
        com.getui.gtc.dim.e.b.a("dim sys app provider globalAllow set: " + str + " : true");
    }

    public void f(String str, String str2) {
        String string;
        StringBuilder sb;
        boolean z = false;
        try {
            String str3 = Build.BRAND;
            String[] strArrSplit = str2.split("&");
            if (str3.equalsIgnoreCase(strArrSplit[0]) && a(true, strArrSplit[1])) {
                String str4 = strArrSplit[2];
                try {
                    if (!str4.equals("*")) {
                        if (this.r == null) {
                            this.r = com.getui.gtc.dim.c.a.d();
                        }
                        if (!TextUtils.isEmpty(this.r)) {
                            for (String str5 : str4.split("#")) {
                                if (this.r.startsWith(str5)) {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                sb = new StringBuilder("dim sys black rom set: ");
                            }
                            string = sb.toString();
                            com.getui.gtc.dim.e.b.a(string);
                        }
                        sb = new StringBuilder("dim sys black rom set: ");
                    }
                    this.q.add(str);
                    sb = new StringBuilder("dim sys black rom set: ");
                    sb.append(str);
                    sb.append(" : ");
                    sb.append(str2);
                    sb.append(" : true");
                    string = sb.toString();
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    try {
                        com.getui.gtc.dim.e.b.b(th);
                        string = "dim sys black rom set: " + str + " : " + str2 + " : " + z;
                    } catch (Throwable th2) {
                        com.getui.gtc.dim.e.b.a("dim sys black rom set: " + str + " : " + str2 + " : " + z);
                        throw th2;
                    }
                }
                com.getui.gtc.dim.e.b.a(string);
            }
            sb = new StringBuilder("dim sys black rom set: ");
            sb.append(str);
            sb.append(" : ");
            sb.append(str2);
            sb.append(" : false");
            string = sb.toString();
        } catch (Throwable th3) {
            th = th3;
        }
        com.getui.gtc.dim.e.b.a(string);
    }

    public void g(String str, String str2) {
        boolean z = false;
        for (String str3 : str2.split("#")) {
            if (str3.equals(Build.MODEL)) {
                this.p.add(str);
                z = true;
                break;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys black model set: " + str + " : " + str2 + " : " + z);
    }

    public final boolean g(String str) {
        try {
            Boolean bool = this.o.get(str);
            if (bool == null) {
                bool = this.o.get("dim-2-2-0-1");
            }
            if (bool == null) {
                if (Build.VERSION.SDK_INT >= 34 && h(str)) {
                    com.getui.gtc.dim.e.b.a("dim sys black version use ld for: " + str + " : true");
                    return true;
                }
            } else if (bool.booleanValue()) {
                return true;
            }
            return this.p.contains(str) || this.q.contains(str);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return true;
        }
    }
}
