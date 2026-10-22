package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import com.zj.adlib.a7b;
import com.zj.adlib.a9b;
import com.zj.adlib.acb;
import com.zj.adlib.b9b;
import com.zj.adlib.bcb;
import com.zj.adlib.e9b;
import com.zj.adlib.f9b;
import com.zj.adlib.j4b;
import com.zj.adlib.k9b;
import com.zj.adlib.l9b;
import com.zj.adlib.nbb;
import com.zj.adlib.p4b;
import com.zj.adlib.qbb;
import com.zj.adlib.r4b;
import com.zj.adlib.s4b;
import com.zj.adlib.sbb;
import com.zj.adlib.u8b;
import com.zj.adlib.wbb;
import com.zj.adlib.y6b;
import com.zj.adlib.y8b;
import com.zj.adlib.zbb;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class go {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f25962a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static r4b f912a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WeakReference<k9b> f913a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f914a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String[] f915a = new String[10];
    public static int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static WeakReference<ip> f916b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f917b = false;
    public static WeakReference<ip> c;

    public interface a {
        void a(int i);
    }

    public static class b extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25963a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k9b f918a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ r4b f919a;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public b(Context context, r4b r4bVar, String str, String str2, k9b k9bVar) {
            this.f25963a = context;
            this.f919a = r4bVar;
            this.f = str;
            this.g = str2;
            this.f918a = k9bVar;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            String strB = go.b(this.f25963a, this.f919a, this.f, this.g);
            k9b k9bVar = this.f918a;
            if (k9bVar.f17613a == null) {
                k9bVar.f17613a = new u8b(new y8b(new a9b(new b9b())));
            }
            try {
                l9b.c(p4b.e(strB), s4b.p(strB), this.f918a);
            } catch (Throwable unused) {
            }
        }
    }

    public static class c extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25964a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ip f920a;
        public final /* synthetic */ String f;

        public c(Context context, String str, ip ipVar) {
            this.f25964a = context;
            this.f = str;
            this.f920a = ipVar;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                synchronized (go.class) {
                    k9b k9bVarA = nbb.a(go.f913a);
                    nbb.f(this.f25964a, k9bVarA, this.f, 1000, 4096000, "1");
                    k9bVarA.f17615a = this.f920a;
                    if (k9bVarA.f17614a == null) {
                        k9bVarA.f17614a = new sbb(new qbb(this.f25964a, new wbb(), new y8b(new a9b(new b9b())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", j4b.j(this.f25964a), fj.L(), fj.e0(this.f25964a), j4b.g(this.f25964a), Build.MODEL, j4b.e(this.f25964a), j4b.h(this.f25964a), Build.VERSION.RELEASE));
                    }
                    k9bVarA.b = 3600000;
                    l9b.a(k9bVarA);
                }
            } catch (Throwable th) {
                a7b.m(th, "lg", "pul");
            }
        }
    }

    public static class d extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25965a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f921a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k9b f922a;

        public d(k9b k9bVar, Context context, a aVar) {
            this.f922a = k9bVar;
            this.f25965a = context;
            this.f921a = aVar;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                synchronized (go.class) {
                    k9b k9bVar = this.f922a;
                    if (k9bVar.f17614a == null) {
                        k9bVar.f17614a = new sbb(new qbb(this.f25965a, new wbb(), new y8b(new a9b(new b9b())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", j4b.j(this.f25965a), fj.L(), fj.e0(this.f25965a), j4b.g(this.f25965a), Build.MODEL, j4b.e(this.f25965a), j4b.h(this.f25965a), Build.VERSION.RELEASE));
                    }
                    int iA = l9b.a(this.f922a);
                    a aVar = this.f921a;
                    if (aVar != null) {
                        aVar.a(iA);
                    }
                }
            } catch (Throwable th) {
                a7b.m(th, "lg", "pul");
            }
        }
    }

    public static r4b a(String str) {
        List<r4b> listB = y6b.b();
        if (listB == null) {
            listB = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (r4b r4bVar : listB) {
                if (y6b.f(r4bVar.i(), str)) {
                    return r4bVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return s4b.a();
                } catch (ff e) {
                    e.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    r4b r4bVarQ = s4b.q();
                    r4bVarQ.c(true);
                    return r4bVarQ;
                } catch (ff e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String b(Context context, r4b r4bVar, String str, String str2) {
        String strB = nbb.b();
        String strC = nbb.c(context, r4bVar);
        j4b.a(context);
        return nbb.e(strC, strB, str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x00ff A[RETURN] */
    public static String c(List<r4b> list) {
        f9b f9bVar;
        FileInputStream fileInputStream;
        try {
            try {
                File file = new File("/data/anr/traces.txt");
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    int iAvailable = fileInputStream.available();
                    if (iAvailable > 1024000) {
                        fileInputStream.skip(iAvailable - 1024000);
                    }
                    f9bVar = new f9b(fileInputStream, e9b.b);
                    boolean z = false;
                    while (true) {
                        try {
                            String strTrim = f9bVar.a().trim();
                            if (strTrim.contains("pid")) {
                                while (!strTrim.startsWith("\"main\"")) {
                                    strTrim = f9bVar.a();
                                }
                                z = true;
                            }
                            if (strTrim.equals("") && z) {
                                break;
                            }
                            if (z) {
                                try {
                                    if (f25962a > 9) {
                                        f25962a = 0;
                                    }
                                    String[] strArr = f915a;
                                    int i = f25962a;
                                    strArr[i] = strTrim;
                                    f25962a = i + 1;
                                } catch (Throwable th) {
                                    a7b.m(th, "alg", "aDa");
                                }
                                int i2 = b;
                                if (i2 == 5) {
                                    break;
                                }
                                if (!f917b) {
                                    for (r4b r4bVar : list) {
                                        boolean zH = y6b.h(r4bVar.i(), strTrim);
                                        f917b = zH;
                                        if (zH) {
                                            f912a = r4bVar;
                                            break;
                                        }
                                    }
                                } else {
                                    b = i2 + 1;
                                }
                            }
                        } catch (EOFException unused) {
                            break;
                        } catch (FileNotFoundException unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                a7b.m(th, "alg", "getA");
                                if (f9bVar != null) {
                                    try {
                                        f9bVar.close();
                                    } catch (Throwable th3) {
                                        a7b.m(th3, "alg", "getA");
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (f917b) {
                                    return n();
                                }
                                return null;
                            } catch (Throwable th4) {
                                if (f9bVar != null) {
                                    try {
                                        f9bVar.close();
                                    } catch (Throwable th5) {
                                        a7b.m(th5, "alg", "getA");
                                    }
                                }
                                if (fileInputStream == null) {
                                    throw th4;
                                }
                                try {
                                    fileInputStream.close();
                                    throw th4;
                                } catch (Throwable th6) {
                                    a7b.m(th6, "alg", "getA");
                                    throw th4;
                                }
                            }
                        }
                    }
                    try {
                        f9bVar.close();
                    } catch (Throwable th7) {
                        a7b.m(th7, "alg", "getA");
                    }
                    fileInputStream.close();
                } catch (FileNotFoundException unused3) {
                    f9bVar = null;
                } catch (Throwable th8) {
                    th = th8;
                    f9bVar = null;
                }
                if (f917b) {
                    return n();
                }
                return null;
            } catch (Throwable th9) {
                a7b.m(th9, "alg", "getA");
            }
        } catch (FileNotFoundException unused4) {
            f9bVar = null;
            fileInputStream = null;
        } catch (Throwable th10) {
            th = th10;
            f9bVar = null;
            fileInputStream = null;
        }
        if (f9bVar != null) {
            try {
                f9bVar.close();
            } catch (Throwable th11) {
                a7b.m(th11, "alg", "getA");
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        if (f917b) {
            return n();
        }
        return null;
    }

    public static void e(Context context) {
        String strC;
        r4b r4bVar;
        List<r4b> listB = y6b.b();
        if (listB == null || listB.size() == 0 || (strC = c(listB)) == null || "".equals(strC) || (r4bVar = f912a) == null) {
            return;
        }
        g(context, r4bVar, 2, "ANR", strC);
    }

    public static void f(Context context, ip ipVar, String str) {
        z.g().b(new c(context, str, ipVar));
    }

    public static void g(Context context, r4b r4bVar, int i, String str, String str2) {
        String str3;
        String strB = nbb.b();
        String strC = nbb.c(context, r4bVar);
        j4b.a(context);
        String strD = nbb.d(strC, strB, i, str, str2);
        if (strD == null || "".equals(strD)) {
            return;
        }
        String strE = p4b.e(str2);
        if (i == 1) {
            str3 = y6b.b;
        } else if (i == 2) {
            str3 = y6b.d;
        } else if (i != 0) {
            return;
        } else {
            str3 = y6b.c;
        }
        String str4 = str3;
        k9b k9bVarA = nbb.a(f913a);
        nbb.f(context, k9bVarA, str4, 1000, 4096000, "1");
        if (k9bVarA.f17613a == null) {
            k9bVarA.f17613a = new u8b(new y8b(new a9b(new b9b())));
        }
        try {
            l9b.c(strE, s4b.p(strD.replaceAll("\n", "<br/>")), k9bVarA);
        } catch (Throwable unused) {
        }
    }

    public static void h(Context context, r4b r4bVar, String str, int i, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("class:");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$<br/>");
        }
        sb.append(str);
        g(context, r4bVar, i, str2, sb.toString());
    }

    public static void i(Context context, r4b r4bVar, String str, k9b k9bVar, String str2) {
        try {
            z.g().b(new b(context, r4bVar, str, str2, k9bVar));
        } catch (Throwable unused) {
        }
    }

    public static void j(Context context, k9b k9bVar, a aVar) {
        try {
            z.g().b(new d(k9bVar, context, aVar));
        } catch (Throwable unused) {
        }
    }

    public static void k(Context context, Throwable th, int i, String str, String str2) {
        String strE = s4b.e(th);
        r4b r4bVarA = a(strE);
        if (m(r4bVarA)) {
            String strReplaceAll = strE.replaceAll("\n", "<br/>");
            String string = th.toString();
            if (string == null || "".equals(string)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(strReplaceAll);
            g(context, r4bVarA, i, string, sb.toString());
        }
    }

    public static void l(r4b r4bVar, Context context, String str, String str2) {
        if (!m(r4bVar) || str == null || "".equals(str)) {
            return;
        }
        g(context, r4bVar, 1, str, str2);
    }

    public static boolean m(r4b r4bVar) {
        return r4bVar != null && r4bVar.h();
    }

    public static String n() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = f25962a; i < 10 && i <= 9; i++) {
                sb.append(f915a[i]);
            }
            for (int i2 = 0; i2 < f25962a; i2++) {
                sb.append(f915a[i2]);
            }
        } catch (Throwable th) {
            a7b.m(th, "alg", "gLI");
        }
        return sb.toString();
    }

    public static void o(Context context) {
        zbb zbbVar = new zbb(f914a);
        f914a = false;
        f(context, zbbVar, y6b.c);
    }

    public static void p(Context context) {
        WeakReference<ip> weakReference = f916b;
        if (weakReference == null || weakReference.get() == null) {
            f916b = new WeakReference<>(new acb(context, 3600000, "hKey", new bcb(context, false)));
        }
        f(context, f916b.get(), y6b.d);
    }

    public static void q(Context context) {
        WeakReference<ip> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new acb(context, 3600000, "gKey", new bcb(context, false)));
        }
        f(context, c.get(), y6b.b);
    }
}
