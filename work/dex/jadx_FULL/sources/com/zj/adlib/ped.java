package com.zj.adlib;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_common.zzmb;
import com.google.android.gms.internal.mlkit_vision_common.zzmc;
import com.google.android.gms.internal.mlkit_vision_common.zzme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ped implements zzmc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final List f43968a;

    public ped(Context context, zzme zzmeVar) {
        ArrayList arrayList = new ArrayList();
        this.f43968a = arrayList;
        if (zzmeVar.c()) {
            arrayList.add(new tfd(context, zzmeVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void a(zzmb zzmbVar) {
        Iterator it = this.f43968a.iterator();
        while (it.hasNext()) {
            ((zzmc) it.next()).a(zzmbVar);
        }
    }
}
