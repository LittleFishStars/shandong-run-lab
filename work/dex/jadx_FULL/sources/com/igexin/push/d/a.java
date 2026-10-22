package com.igexin.push.d;

import android.content.Context;
import com.igexin.c.a.b.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements com.igexin.c.a.d.a.b<String, Integer, com.igexin.c.a.b.d, com.igexin.c.a.b.f> {
    private static final byte b = 1;
    private static final byte c = 2;
    private static final byte d = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f38087a;

    public a(Context context) {
        this.f38087a = context;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static com.igexin.c.a.b.f a2(String str, com.igexin.c.a.b.d dVar) {
        if (str.startsWith("socket") && com.igexin.push.core.e.n) {
            return new com.igexin.c.a.b.a.a.f(str, dVar);
        }
        return null;
    }

    private static boolean a(com.igexin.c.a.b.f fVar) {
        return fVar.b.startsWith("socket") || fVar.b.startsWith("submitTcpException");
    }

    private static byte b(com.igexin.c.a.b.f fVar) {
        String[] strArrA = g.a(fVar.b);
        if (strArrA[0].equals("socket")) {
            return (byte) 3;
        }
        return strArrA[0].equals("http") ? (byte) 2 : (byte) 0;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ byte a(com.igexin.c.a.d.f fVar) {
        String[] strArrA = g.a(((com.igexin.c.a.b.f) fVar).b);
        if (strArrA[0].equals("socket")) {
            return (byte) 3;
        }
        return strArrA[0].equals("http") ? (byte) 2 : (byte) 0;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ com.igexin.c.a.d.f a(String str, com.igexin.c.a.b.d dVar) {
        String str2 = str;
        com.igexin.c.a.b.d dVar2 = dVar;
        if (str2.startsWith("socket") && com.igexin.push.core.e.n) {
            return new com.igexin.c.a.b.a.a.f(str2, dVar2);
        }
        return null;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ boolean b(com.igexin.c.a.d.f fVar) {
        com.igexin.c.a.b.f fVar2 = (com.igexin.c.a.b.f) fVar;
        return fVar2.b.startsWith("socket") || fVar2.b.startsWith("submitTcpException");
    }
}
