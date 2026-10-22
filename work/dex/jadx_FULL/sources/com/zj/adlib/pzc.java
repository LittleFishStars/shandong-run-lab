package com.zj.adlib;

import android.content.Context;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.android.gms.internal.mlkit_common.zzs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pzc f44092a;
    public static final pzc b;
    public static final pzc c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzar f18968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18969a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f18970b = false;

    static {
        hoc hocVar = null;
        vrc vrcVar = new vrc(hocVar);
        vrcVar.b();
        f44092a = vrcVar.d();
        vrc vrcVar2 = new vrc(hocVar);
        vrcVar2.b();
        vrcVar2.a(new wkc());
        b = vrcVar2.d();
        vrc vrcVar3 = new vrc(hocVar);
        vrcVar3.c();
        c = vrcVar3.d();
    }

    public /* synthetic */ pzc(boolean z, boolean z2, zzar zzarVar, vvc vvcVar) {
        this.f18969a = z;
        this.f18968a = zzarVar;
    }

    public static /* bridge */ /* synthetic */ boolean a(pzc pzcVar) {
        boolean z = pzcVar.f18970b;
        return false;
    }

    public static /* bridge */ /* synthetic */ int c(pzc pzcVar, Context context, dpd dpdVar) {
        zzar zzarVar = pzcVar.f18968a;
        int size = zzarVar.size();
        int i = 0;
        while (i < size) {
            int iZza = ((zzs) zzarVar.get(i)).zza(context, dpdVar, pzcVar.f18969a) - 1;
            i++;
            if (iZza == 1) {
                return 2;
            }
        }
        return 3;
    }
}
