package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k extends u0 {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37566a;

        static {
            int[] iArr = new int[d0.values().length];
            f37566a = iArr;
            try {
                iArr[d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37566a[d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37566a[d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static f0 a(String str, String str2, String str3, String str4) {
        f0 f0VarA = u0.a(str, str2, str3, str4);
        String strA = j.a().a(a1.c(str2, str3));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strSha256Encrypt = SHA.sha256Encrypt(q0.f() + strA + jCurrentTimeMillis);
        f0VarA.f(String.valueOf(jCurrentTimeMillis));
        f0VarA.g(strSha256Encrypt);
        return f0VarA;
    }

    public static h1 a(List<b1> list, String str, String str2, String str3, String str4) {
        v.c("hmsSdk", "generate UploadData");
        h1 h1VarB = u0.b(str, str2);
        if (h1VarB == null) {
            return null;
        }
        h1VarB.a(a(m1.d().a(), str, str2, str3));
        h1VarB.a(a(str, str2));
        h1VarB.a(a(str2, str, str4));
        h1VarB.a(a1.g(str, str2));
        h1VarB.a(list);
        return h1VarB;
    }

    public static l a(String str, String str2) {
        l lVarA = u0.a(str, str2);
        i iVarC = j.a().c(str, str2);
        lVarA.g(j.a().a(a1.c(str, str2)));
        lVarA.f(a1.o(str, str2));
        lVarA.c(j.a().f(str, str2));
        int i = a.f37566a[iVarC.a().ordinal()];
        if (i == 1) {
            lVarA.d(iVarC.b());
        } else if (i == 2) {
            lVarA.b(iVarC.b());
        } else if (i == 3) {
            lVarA.e(iVarC.b());
        }
        return lVarA;
    }

    public static y0 a(String str, String str2, String str3) {
        y0 y0VarA = u0.a(str, str2, str3);
        Pair<String, String> pairE = j.a().e(str2, str);
        y0VarA.f((String) pairE.first);
        y0VarA.g((String) pairE.second);
        y0VarA.h(o.b());
        y0VarA.d(j.a().d(str2, str));
        return y0VarA;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> mapC = u0.c(str, str3);
        Map<String, String> mapI = a1.i(str, str2);
        if (mapI == null) {
            return mapC;
        }
        mapC.putAll(mapI);
        return mapC;
    }
}
