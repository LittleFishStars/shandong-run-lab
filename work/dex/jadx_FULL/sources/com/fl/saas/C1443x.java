package com.fl.saas;

import android.text.TextUtils;
import android.util.Pair;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.fl.saas.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1443x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C1443x f30204a;

    /* JADX INFO: renamed from: com.fl.saas.x$a */
    public class a implements T {
        public a() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("");
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("");
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.x$b */
    public class b implements T {
        public b() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink requset onSuccess");
        }

        @Override // com.fl.saas.T
        public void b(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink requset 302");
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("FLSDK-S2S", "deeplink requset onError:" + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.x$c */
    public class c implements T {
        public c() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink installed requset onSuccess");
        }

        @Override // com.fl.saas.T
        public void b(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink installed requset 302");
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("FLSDK-S2S", "deeplink installed requset onError:" + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.x$d */
    public class d implements T {
        public d() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink attempt requset onSuccess");
        }

        @Override // com.fl.saas.T
        public void b(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink attempt requset 302");
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("FLSDK-S2S", "deeplink attempt requset onError:" + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.x$e */
    public class e implements T {
        public e() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink fail requset onSuccess");
        }

        @Override // com.fl.saas.T
        public void b(String str) {
            LogcatUtil.d("FLSDK-S2S", "deeplink fail requset 302");
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("FLSDK-S2S", "deeplink fail requset onError:" + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.x$f */
    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30210a;

        static {
            int[] iArr = new int[C1415j.b.values().length];
            f30210a = iArr;
            try {
                iArr[C1415j.b.SHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30210a[C1415j.b.SLIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30210a[C1415j.b.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean a(String str, String str2, int i) {
        try {
            String str3 = str + "showId";
            String str4 = str + "lastAdShowDay";
            String str5 = str + "lastDayAdShowNumber";
            String strC = S0.a().c(str4);
            String date = DeviceUtil.getDate();
            if (!date.equals(strC)) {
                S0.a().b(str5, 0);
                S0.a().b(str3, "");
            } else if (S0.a().a(str3, "").contains(str2)) {
                return true;
            }
            return i > 0 && date.equals(strC) && S0.a().a(str5) >= i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void b(C1415j c1415j) {
        if (c1415j == null) {
            return;
        }
        a(c1415j.k1, c1415j);
    }

    public void c(C1415j c1415j) {
        if (c1415j == null || "5".equals(c1415j.w0) || "6".equals(c1415j.w0)) {
            return;
        }
        if (c1415j.r()) {
            AbstractC1447z.a("click", c1415j);
        }
        a(a(c1415j.R0, Pair.create("__X_MAX_ACC__", String.valueOf(c1415j.M1)), Pair.create("__Y_MAX_ACC__", String.valueOf(c1415j.N1)), Pair.create("__Z_MAX_ACC__", String.valueOf(c1415j.O1))), c1415j);
    }

    public void d(C1415j c1415j) {
        if (c1415j == null) {
            return;
        }
        Iterator it = c1415j.S0.iterator();
        while (it.hasNext()) {
            C1401c.c().a(a((String) it.next(), c1415j), new b());
        }
    }

    public void e(C1415j c1415j) {
        if (c1415j == null) {
            return;
        }
        Iterator it = c1415j.n1.iterator();
        while (it.hasNext()) {
            C1401c.c().a(a((String) it.next(), c1415j), new d());
        }
    }

    public void f(C1415j c1415j) {
        if (c1415j == null) {
            return;
        }
        Iterator it = c1415j.o1.iterator();
        while (it.hasNext()) {
            C1401c.c().a(a((String) it.next(), c1415j), new e());
        }
    }

    public void g(C1415j c1415j) {
        if (c1415j == null) {
            return;
        }
        Iterator it = c1415j.m1.iterator();
        while (it.hasNext()) {
            C1401c.c().a(a((String) it.next(), c1415j), new c());
        }
    }

    public void h(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.h1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.h1, c1415j);
    }

    public void i(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.c1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.c1, c1415j);
    }

    public void j(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.Z0) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = c1415j.Z0.iterator();
        while (it.hasNext()) {
            arrayList.add(b((String) it.next(), c1415j));
        }
        a(arrayList, c1415j);
    }

    public void k(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.j1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.j1, c1415j);
    }

    public void l(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.f1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.f1, c1415j);
    }

    public void m(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.e1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.e1, c1415j);
    }

    public void n(C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.d1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.d1, c1415j);
    }

    private void a(List list, C1415j c1415j) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            C1401c.c().a(a((String) list.get(i), c1415j), new a());
        }
    }

    public void b(C1415j c1415j, int i) {
        List list;
        if (c1415j == null || (list = c1415j.T0) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.T0, c1415j);
    }

    public void c(C1415j c1415j, int i) {
        List list;
        if (c1415j == null || (list = c1415j.i1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.i1, c1415j);
    }

    public void d(C1415j c1415j, int i) {
        List list;
        if (c1415j == null || (list = c1415j.b1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.b1, c1415j);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x02a4 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:51:0x034a A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0356 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0358  */
    /* JADX WARN: Code duplicated, block: B:56:0x035b  */
    /* JADX WARN: Code duplicated, block: B:57:0x035d A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0360 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0363 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:63:0x03ba A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:66:0x03c9 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:69:0x03d8 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:72:0x03e7 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:75:0x03f6 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0405 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0414 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0423 A[Catch: Exception -> 0x04de, TryCatch #0 {Exception -> 0x04de, blocks: (B:40:0x010e, B:41:0x0112, B:46:0x0126, B:48:0x02a4, B:49:0x02bb, B:51:0x034a, B:60:0x0365, B:57:0x035d, B:58:0x0360, B:59:0x0363, B:61:0x036b, B:63:0x03ba, B:64:0x03c3, B:66:0x03c9, B:67:0x03d2, B:69:0x03d8, B:70:0x03e1, B:72:0x03e7, B:73:0x03f0, B:75:0x03f6, B:76:0x03ff, B:78:0x0405, B:79:0x040e, B:81:0x0414, B:82:0x041d, B:84:0x0423, B:85:0x042c, B:45:0x0121), top: B:92:0x00df }] */
    /* JADX WARN: Instruction removed from duplicated block: B:48:0x02a4, please report this as an issue */
    public String a(String str, C1415j c1415j) {
        String strReplaceAll;
        String strReplaceAll2;
        String strReplaceAll3;
        String strReplaceAll4;
        C1415j.a aVar;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String strValueOf4;
        String strValueOf5;
        String strValueOf6;
        String strValueOf7;
        String strValueOf8;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        String str2;
        String strReplaceAll5 = "5";
        try {
            String strB = b(str, c1415j);
            try {
                String strValueOf9 = String.valueOf(c1415j.E1);
                String strValueOf10 = String.valueOf(c1415j.F1);
                String strValueOf11 = String.valueOf(c1415j.G1);
                String strValueOf12 = String.valueOf(c1415j.H1);
                if (c1415j.w0.equals("5") || c1415j.w0.equals("6")) {
                    int i10 = c1415j.E1;
                    if (i10 != -999) {
                        strValueOf9 = String.valueOf(DeviceUtil.px2dip(i10));
                    }
                    int i11 = c1415j.F1;
                    if (i11 != -999) {
                        strValueOf10 = String.valueOf(DeviceUtil.px2dip(i11));
                    }
                    int i12 = c1415j.G1;
                    if (i12 != -999) {
                        strValueOf11 = String.valueOf(DeviceUtil.px2dip(i12));
                    }
                    int i13 = c1415j.H1;
                    if (i13 != -999) {
                        strValueOf12 = String.valueOf(DeviceUtil.px2dip(i13));
                    }
                }
                int i14 = c1415j.P1;
                int i15 = c1415j.Q1;
                int iPx2dip = DeviceUtil.px2dip(i14);
                int iPx2dip2 = DeviceUtil.px2dip(i15);
                int i16 = c1415j.v1;
                int i17 = c1415j.w1;
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long lValueOf = Long.valueOf(jCurrentTimeMillis);
                String strReplaceAll6 = strB.replaceAll("__REQ_WIDTH__", String.valueOf(i16)).replaceAll("__REQ_HEIGHT__", String.valueOf(i17)).replaceAll("__WIDTH__", String.valueOf(i14)).replaceAll("__HEIGHT__", String.valueOf(i15)).replaceAll("__DP_WIDTH__", String.valueOf(iPx2dip)).replaceAll("__DP_HEIGHT__", String.valueOf(iPx2dip2)).replaceAll("__LG_WIDTH__", String.valueOf(iPx2dip)).replaceAll("__LG_HEIGHT__", String.valueOf(iPx2dip2));
                try {
                    if (c1415j.C == 2 && (c1415j.w0.equals("5") || c1415j.w0.equals("6") || c1415j.f30175a == 991)) {
                        if (c1415j.E1 == -999 || c1415j.F1 == -999 || c1415j.G1 == -999 || c1415j.H1 == -999) {
                            strReplaceAll2 = strReplaceAll6;
                        } else {
                            strReplaceAll = strReplaceAll6.replaceAll("__DOWN_X__", strValueOf9).replaceAll("__DOWN_Y__", strValueOf10);
                        }
                        String strReplaceAll7 = strReplaceAll2.replaceAll("__ABS_DOWN_X__", c1415j.I1 + "").replaceAll("__ABS_DOWN_Y__", c1415j.J1 + "").replaceAll("__ABS_UP_X__", c1415j.K1 + "").replaceAll("__ABS_UP_Y__", c1415j.L1 + "").replaceAll("__TS__", String.valueOf(lValueOf)).replaceAll("__SEC__", String.valueOf(jCurrentTimeMillis / 1000)).replaceAll("__CLICK_ID__", c1415j.z1).replaceAll("__VIDEO_TIME__", c1415j.X1 + "").replaceAll("__DOWN_TIME__", c1415j.R1 + "").replaceAll("__UP_TIME__", c1415j.S1 + "").replaceAll("__READY_TIME__", c1415j.T1 + "");
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        strReplaceAll3 = strReplaceAll7.replaceAll("__RESPONSE_TIME__", jCurrentTimeMillis2 + "").replaceAll("__EVENT_MSEC__", jCurrentTimeMillis2 + "").replaceAll("__EVENT_SEC__", (jCurrentTimeMillis2 / 1000) + "").replaceAll("__PROGRESS__", c1415j.U1 + "").replaceAll("__PROGRESS_SEC__", c1415j.V1 + "").replaceAll("__PROGRESS_PART_TIME__", c1415j.W1 + "").replaceAll("__DP_RESULT__", c1415j.h2 + "");
                        if (c1415j.h2 == 1) {
                            strReplaceAll3 = strReplaceAll3.replaceAll("__DP_REASON__", c1415j.i2 + "");
                        }
                        strReplaceAll4 = strReplaceAll3.replaceAll("__PRICE__", AbstractC1417k.e(c1415j.d + "")).replaceAll("__SECOND_PRICE__", AbstractC1417k.e(c1415j.e + "")).replaceAll("__X_MAX_ACC__", String.valueOf(c1415j.M1)).replaceAll("__Y_MAX_ACC__", String.valueOf(c1415j.N1)).replaceAll("__Z_MAX_ACC__", String.valueOf(c1415j.O1)).replaceAll("__COST_TIME__", String.valueOf(DeviceUtil.getBootTime() - c1415j.l)).replaceAll("__CB__", String.valueOf(c1415j.q1)).replaceAll("__CBR__", String.valueOf(c1415j.r1)).replaceAll("__TRACK_ID__", c1415j.r);
                        aVar = c1415j.l2;
                        if (aVar != null) {
                            i9 = f.f30210a[c1415j.k2.ordinal()];
                            if (i9 != 1) {
                                str2 = aVar.b;
                            } else if (i9 != 2) {
                                str2 = aVar.c;
                            } else if (i9 != 3) {
                                str2 = "";
                            } else {
                                str2 = aVar.f30176a;
                            }
                            strReplaceAll4 = strReplaceAll4.replaceAll("__SLD__", str2);
                        }
                        String strReplaceAll8 = strReplaceAll4.replaceAll("__SHOW_TIME__", String.valueOf(jCurrentTimeMillis2 - c1415j.m2)).replaceAll("__MAX_SHOW_RATIO__", String.valueOf(c1415j.n2));
                        strValueOf = String.valueOf(c1415j.E1);
                        strValueOf2 = String.valueOf(c1415j.F1);
                        strValueOf3 = String.valueOf(c1415j.G1);
                        strValueOf4 = String.valueOf(c1415j.H1);
                        strValueOf5 = String.valueOf(c1415j.I1);
                        strValueOf6 = String.valueOf(c1415j.J1);
                        strValueOf7 = String.valueOf(c1415j.K1);
                        strValueOf8 = String.valueOf(c1415j.L1);
                        i = c1415j.E1;
                        if (i != -999) {
                            strValueOf = String.valueOf(DeviceUtil.px2dip(i));
                        }
                        i2 = c1415j.F1;
                        if (i2 != -999) {
                            strValueOf2 = String.valueOf(DeviceUtil.px2dip(i2));
                        }
                        i3 = c1415j.G1;
                        if (i3 != -999) {
                            strValueOf3 = String.valueOf(DeviceUtil.px2dip(i3));
                        }
                        i4 = c1415j.H1;
                        if (i4 != -999) {
                            strValueOf4 = String.valueOf(DeviceUtil.px2dip(i4));
                        }
                        i5 = c1415j.I1;
                        if (i5 != -999) {
                            strValueOf5 = String.valueOf(DeviceUtil.px2dip(i5));
                        }
                        i6 = c1415j.J1;
                        if (i6 != -999) {
                            strValueOf6 = String.valueOf(DeviceUtil.px2dip(i6));
                        }
                        i7 = c1415j.K1;
                        if (i7 != -999) {
                            strValueOf7 = String.valueOf(DeviceUtil.px2dip(i7));
                        }
                        i8 = c1415j.L1;
                        if (i8 != -999) {
                            strValueOf8 = String.valueOf(DeviceUtil.px2dip(i8));
                        }
                        strReplaceAll5 = strReplaceAll8.replaceAll("__LG_DOWN_X__", strValueOf).replaceAll("__LG_DOWN_Y__", strValueOf2).replaceAll("__LG_UP_X__", strValueOf3).replaceAll("__LG_UP_Y__", strValueOf4).replaceAll("__LG_ABS_DOWN_X__", strValueOf5).replaceAll("__LG_ABS_DOWN_Y__", strValueOf6).replaceAll("__LG_ABS_UP_X__", strValueOf7).replaceAll("__LG_ABS_UP_Y__", strValueOf8).replaceAll("__CLICKAREA__", c1415j.o2).replaceAll("__DPLINK__", c1415j.p2).replaceAll("__PUBLIC_AD_POOL__", c1415j.Z).replaceAll("__GLOBAL_PLACE_ID__", c1415j.a0).replaceAll("__GLOBAL_GROUP_ID__", c1415j.b0).replaceAll("__GLOBAL_TEST_ID__", c1415j.c0).replaceAll("__IS_VALID__", c1415j.d0 + "").replaceAll("__AD_SHOW_ROLE__", c1415j.r2 + "").replaceAll("__REL_TASK_ID__", c1415j.w2);
                        return strReplaceAll5.replaceAll("__MAT_DL_STATUS__", c1415j.s2 + "");
                    }
                    strReplaceAll = strReplaceAll6.replaceAll("__DOWN_X__", strValueOf9).replaceAll("__DOWN_Y__", strValueOf10);
                    strReplaceAll2 = strReplaceAll.replaceAll("__UP_X__", strValueOf11).replaceAll("__UP_Y__", strValueOf12);
                    String strReplaceAll9 = strReplaceAll2.replaceAll("__ABS_DOWN_X__", c1415j.I1 + "").replaceAll("__ABS_DOWN_Y__", c1415j.J1 + "").replaceAll("__ABS_UP_X__", c1415j.K1 + "").replaceAll("__ABS_UP_Y__", c1415j.L1 + "").replaceAll("__TS__", String.valueOf(lValueOf)).replaceAll("__SEC__", String.valueOf(jCurrentTimeMillis / 1000)).replaceAll("__CLICK_ID__", c1415j.z1).replaceAll("__VIDEO_TIME__", c1415j.X1 + "").replaceAll("__DOWN_TIME__", c1415j.R1 + "").replaceAll("__UP_TIME__", c1415j.S1 + "").replaceAll("__READY_TIME__", c1415j.T1 + "");
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    strReplaceAll3 = strReplaceAll9.replaceAll("__RESPONSE_TIME__", jCurrentTimeMillis3 + "").replaceAll("__EVENT_MSEC__", jCurrentTimeMillis3 + "").replaceAll("__EVENT_SEC__", (jCurrentTimeMillis3 / 1000) + "").replaceAll("__PROGRESS__", c1415j.U1 + "").replaceAll("__PROGRESS_SEC__", c1415j.V1 + "").replaceAll("__PROGRESS_PART_TIME__", c1415j.W1 + "").replaceAll("__DP_RESULT__", c1415j.h2 + "");
                    if (c1415j.h2 == 1) {
                        strReplaceAll3 = strReplaceAll3.replaceAll("__DP_REASON__", c1415j.i2 + "");
                    }
                    strReplaceAll4 = strReplaceAll3.replaceAll("__PRICE__", AbstractC1417k.e(c1415j.d + "")).replaceAll("__SECOND_PRICE__", AbstractC1417k.e(c1415j.e + "")).replaceAll("__X_MAX_ACC__", String.valueOf(c1415j.M1)).replaceAll("__Y_MAX_ACC__", String.valueOf(c1415j.N1)).replaceAll("__Z_MAX_ACC__", String.valueOf(c1415j.O1)).replaceAll("__COST_TIME__", String.valueOf(DeviceUtil.getBootTime() - c1415j.l)).replaceAll("__CB__", String.valueOf(c1415j.q1)).replaceAll("__CBR__", String.valueOf(c1415j.r1)).replaceAll("__TRACK_ID__", c1415j.r);
                    aVar = c1415j.l2;
                    if (aVar != null) {
                        i9 = f.f30210a[c1415j.k2.ordinal()];
                        if (i9 != 1) {
                            str2 = aVar.b;
                        } else if (i9 != 2) {
                            str2 = aVar.c;
                        } else if (i9 != 3) {
                            str2 = "";
                        } else {
                            str2 = aVar.f30176a;
                        }
                        strReplaceAll4 = strReplaceAll4.replaceAll("__SLD__", str2);
                    }
                    String strReplaceAll10 = strReplaceAll4.replaceAll("__SHOW_TIME__", String.valueOf(jCurrentTimeMillis3 - c1415j.m2)).replaceAll("__MAX_SHOW_RATIO__", String.valueOf(c1415j.n2));
                    strValueOf = String.valueOf(c1415j.E1);
                    strValueOf2 = String.valueOf(c1415j.F1);
                    strValueOf3 = String.valueOf(c1415j.G1);
                    strValueOf4 = String.valueOf(c1415j.H1);
                    strValueOf5 = String.valueOf(c1415j.I1);
                    strValueOf6 = String.valueOf(c1415j.J1);
                    strValueOf7 = String.valueOf(c1415j.K1);
                    strValueOf8 = String.valueOf(c1415j.L1);
                    i = c1415j.E1;
                    if (i != -999) {
                        strValueOf = String.valueOf(DeviceUtil.px2dip(i));
                    }
                    i2 = c1415j.F1;
                    if (i2 != -999) {
                        strValueOf2 = String.valueOf(DeviceUtil.px2dip(i2));
                    }
                    i3 = c1415j.G1;
                    if (i3 != -999) {
                        strValueOf3 = String.valueOf(DeviceUtil.px2dip(i3));
                    }
                    i4 = c1415j.H1;
                    if (i4 != -999) {
                        strValueOf4 = String.valueOf(DeviceUtil.px2dip(i4));
                    }
                    i5 = c1415j.I1;
                    if (i5 != -999) {
                        strValueOf5 = String.valueOf(DeviceUtil.px2dip(i5));
                    }
                    i6 = c1415j.J1;
                    if (i6 != -999) {
                        strValueOf6 = String.valueOf(DeviceUtil.px2dip(i6));
                    }
                    i7 = c1415j.K1;
                    if (i7 != -999) {
                        strValueOf7 = String.valueOf(DeviceUtil.px2dip(i7));
                    }
                    i8 = c1415j.L1;
                    if (i8 != -999) {
                        strValueOf8 = String.valueOf(DeviceUtil.px2dip(i8));
                    }
                    strReplaceAll5 = strReplaceAll10.replaceAll("__LG_DOWN_X__", strValueOf).replaceAll("__LG_DOWN_Y__", strValueOf2).replaceAll("__LG_UP_X__", strValueOf3).replaceAll("__LG_UP_Y__", strValueOf4).replaceAll("__LG_ABS_DOWN_X__", strValueOf5).replaceAll("__LG_ABS_DOWN_Y__", strValueOf6).replaceAll("__LG_ABS_UP_X__", strValueOf7).replaceAll("__LG_ABS_UP_Y__", strValueOf8).replaceAll("__CLICKAREA__", c1415j.o2).replaceAll("__DPLINK__", c1415j.p2).replaceAll("__PUBLIC_AD_POOL__", c1415j.Z).replaceAll("__GLOBAL_PLACE_ID__", c1415j.a0).replaceAll("__GLOBAL_GROUP_ID__", c1415j.b0).replaceAll("__GLOBAL_TEST_ID__", c1415j.c0).replaceAll("__IS_VALID__", c1415j.d0 + "").replaceAll("__AD_SHOW_ROLE__", c1415j.r2 + "").replaceAll("__REL_TASK_ID__", c1415j.w2);
                    return strReplaceAll5.replaceAll("__MAT_DL_STATUS__", c1415j.s2 + "");
                } catch (Exception unused) {
                    return strReplaceAll5;
                }
            } catch (Exception unused2) {
                strReplaceAll5 = strB;
            }
        } catch (Exception unused3) {
            strReplaceAll5 = str;
        }
    }

    public String b(String str, C1415j c1415j) {
        try {
            return str.replaceAll("__BEGIN_TIME__", c1415j.Y1 + "").replaceAll("__END_TIME__", c1415j.Z1 + "").replaceAll("__PLAY_FIRST_FRAME__", c1415j.a2 + "").replaceAll("__PLAY_LAST_FRAME__", c1415j.b2 + "").replaceAll("__SCENE__", c1415j.c2 + "").replaceAll("__TYPE__", c1415j.d2 + "").replaceAll("__BEHAVIOR__", c1415j.e2 + "").replaceAll("__STATUS__", c1415j.f2 + "");
        } catch (Exception unused) {
            return str;
        }
    }

    public static C1443x a() {
        if (f30204a == null) {
            synchronized (C1443x.class) {
                f30204a = new C1443x();
            }
        }
        return f30204a;
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll(str2, str3);
    }

    private static List a(List list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((String) it.next(), str, str2));
        }
        return arrayList;
    }

    private static String a(String str, Pair... pairArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        for (Pair pair : pairArr) {
            str = a(str, (String) pair.first, (String) pair.second);
        }
        return str;
    }

    private static List a(List list, Pair... pairArr) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((String) it.next(), pairArr));
        }
        return arrayList;
    }

    public void a(C1415j c1415j) {
        if (c1415j == null) {
            return;
        }
        a(c1415j.l1, c1415j);
    }

    public void a(C1415j c1415j, boolean z) {
        if (c1415j == null) {
            return;
        }
        if (c1415j.r()) {
            AbstractC1447z.a("mit", c1415j);
        }
        a(a(c1415j.Q0, "__IS_CACHED__", String.valueOf(z ? 1 : 0)), c1415j);
    }

    public void a(C1415j c1415j, int i) {
        List list;
        if (c1415j == null || (list = c1415j.a1) == null || list.isEmpty()) {
            return;
        }
        a(c1415j.a1, c1415j);
    }
}
