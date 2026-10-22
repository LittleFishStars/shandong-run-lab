package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.zj.adlib.mhb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class h extends a<mhb> {
    public h(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* bridge */ /* synthetic */ void a(mhb mhbVar, long j) {
        a2(mhbVar, j);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(mhb mhbVar) {
        return a(mhbVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ int c(mhb mhbVar) {
        return b2(mhbVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ long d(mhb mhbVar) {
        return c2(mhbVar);
    }

    private static String a(mhb mhbVar) {
        return mhbVar == null ? "" : mhbVar.b();
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(mhb mhbVar) {
        if (mhbVar == null) {
            return -113;
        }
        return mhbVar.f43306a;
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(mhb mhbVar) {
        if (mhbVar == null) {
            return 0L;
        }
        return mhbVar.c;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(mhb mhbVar, long j) {
        if (mhbVar != null) {
            mhbVar.c = j;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final long b() {
        return com.autonavi.aps.amapapi.config.a.e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final long c() {
        return com.autonavi.aps.amapapi.config.a.f;
    }
}
