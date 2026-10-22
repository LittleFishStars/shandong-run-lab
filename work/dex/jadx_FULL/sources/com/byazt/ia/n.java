package com.byazt.ia;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 515, 46})
public class n {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile n c;
    public uj n;
    public Context tt;
    public tt uj;
    public Map<com.byazt.uy.ve, ve> ve = new HashMap();

    /* JADX INFO: renamed from: com.byazt.ia.n$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 515, 219})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.uy.ve.values().length];
            c = iArr;
            try {
                iArr[com.byazt.uy.ve.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.uy.ve.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.uy.ve.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private n(@NonNull Context context) {
        this.tt = context;
        this.uj = new tt(this.tt);
        this.n = new uj(this.tt);
    }

    public static n c() {
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void c(Context context) {
        if (c == null) {
            c = new n(context);
        }
    }

    @Nullable
    private ve c(com.byazt.uy.ve veVar) {
        ve spVar = this.ve.get(veVar);
        if (spVar != null) {
            return spVar;
        }
        int i = AnonymousClass1.c[veVar.ordinal()];
        if (i == 1) {
            spVar = new sp(this.tt, this.uj, this.n);
        } else if (i == 2) {
            spVar = new c(this.tt, this.uj, this.n);
        } else if (i == 3) {
            spVar = new a(this.tt, this.uj, this.n);
        }
        if (spVar != null) {
            this.ve.put(veVar, spVar);
        }
        return spVar;
    }

    public com.byazt.xz.c c(com.byazt.uy.ve veVar, com.byazt.xz.c cVar) {
        ve veVarC;
        return (veVar == null || (veVarC = c(veVar)) == null) ? cVar : veVarC.c(cVar);
    }
}
