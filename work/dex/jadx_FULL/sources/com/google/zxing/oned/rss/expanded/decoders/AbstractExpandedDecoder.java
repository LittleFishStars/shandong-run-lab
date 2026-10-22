package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.zj.adlib.j70;
import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AbstractExpandedDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f32522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qv0 f6769a;

    public AbstractExpandedDecoder(qv0 qv0Var) {
        this.f6769a = qv0Var;
        this.f32522a = new j(qv0Var);
    }

    public static AbstractExpandedDecoder a(qv0 qv0Var) {
        if (qv0Var.m(1)) {
            return new f(qv0Var);
        }
        if (!qv0Var.m(2)) {
            return new j70(qv0Var);
        }
        int iG = j.g(qv0Var, 1, 4);
        if (iG == 4) {
            return new a(qv0Var);
        }
        if (iG == 5) {
            return new b(qv0Var);
        }
        int iG2 = j.g(qv0Var, 1, 5);
        if (iG2 == 12) {
            return new c(qv0Var);
        }
        if (iG2 == 13) {
            return new d(qv0Var);
        }
        switch (j.g(qv0Var, 1, 7)) {
            case 56:
                return new e(qv0Var, "310", "11");
            case 57:
                return new e(qv0Var, "320", "11");
            case 58:
                return new e(qv0Var, "310", "13");
            case 59:
                return new e(qv0Var, "320", "13");
            case 60:
                return new e(qv0Var, "310", "15");
            case 61:
                return new e(qv0Var, "320", "15");
            case 62:
                return new e(qv0Var, "310", "17");
            case 63:
                return new e(qv0Var, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: " + qv0Var);
        }
    }

    public abstract String b() throws NotFoundException, FormatException;

    public final j getGeneralDecoder() {
        return this.f32522a;
    }

    public final qv0 getInformation() {
        return this.f6769a;
    }
}
