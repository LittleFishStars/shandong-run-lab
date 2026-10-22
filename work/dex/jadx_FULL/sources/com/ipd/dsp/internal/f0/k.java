package com.ipd.dsp.internal.f0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k {

    public enum a {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        UNKNOWN
    }

    @Nullable
    public static com.ipd.dsp.internal.h0.b a(@NonNull f fVar) {
        com.ipd.dsp.internal.h0.c cVarA = h.j().a();
        com.ipd.dsp.internal.h0.b bVar = cVarA.get(cVarA.a(fVar));
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    public static a b(@NonNull f fVar) {
        a aVarD = d(fVar);
        a aVar = a.COMPLETED;
        if (aVarD == aVar) {
            return aVar;
        }
        com.ipd.dsp.internal.k0.b bVarE = h.j().e();
        if (bVarE.i(fVar)) {
            return a.PENDING;
        }
        return bVarE.j(fVar) ? a.RUNNING : aVarD;
    }

    public static a c(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return b(a(str, str2, str3));
    }

    public static a d(@NonNull f fVar) {
        com.ipd.dsp.internal.h0.c cVarA = h.j().a();
        com.ipd.dsp.internal.h0.b bVar = cVarA.get(fVar.b());
        String strA = fVar.a();
        File fileC = fVar.c();
        File fileH = fVar.h();
        if (bVar != null) {
            if (!bVar.k() && bVar.h() <= 0) {
                return a.UNKNOWN;
            }
            if (fileH != null && fileH.equals(bVar.d()) && fileH.exists() && bVar.i() == bVar.h()) {
                return a.COMPLETED;
            }
            if (strA == null && bVar.d() != null && bVar.d().exists()) {
                return a.IDLE;
            }
            if (fileH != null && fileH.equals(bVar.d()) && fileH.exists()) {
                return a.IDLE;
            }
        } else {
            if (cVarA.a() || cVarA.a(fVar.b())) {
                return a.UNKNOWN;
            }
            if (fileH != null && fileH.exists()) {
                return a.COMPLETED;
            }
            String strA2 = cVarA.a(fVar.e());
            if (strA2 != null && new File(fileC, strA2).exists()) {
                return a.COMPLETED;
            }
        }
        return a.UNKNOWN;
    }

    public static boolean e(@NonNull f fVar) {
        return h.j().e().e(fVar) != null;
    }

    public static boolean c(@NonNull f fVar) {
        return d(fVar) == a.COMPLETED;
    }

    @NonNull
    public static f a(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return new f.a(str, str2, str3).a();
    }

    @Nullable
    public static com.ipd.dsp.internal.h0.b b(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return a(a(str, str2, str3));
    }

    public static boolean d(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return c(a(str, str2, str3));
    }
}
