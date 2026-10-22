package com.zj.adlib;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_common.zzpq;
import com.google.android.gms.internal.mlkit_common.zzpr;
import com.google.android.gms.internal.mlkit_common.zzpt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zmd implements zzpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final List f46300a;

    public zmd(Context context, zzpt zzptVar) {
        ArrayList arrayList = new ArrayList();
        this.f46300a = arrayList;
        if (zzptVar.c()) {
            arrayList.add(new cod(context, zzptVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpr
    public final void a(zzpq zzpqVar) {
        Iterator it = this.f46300a.iterator();
        while (it.hasNext()) {
            ((zzpr) it.next()).a(zzpqVar);
        }
    }
}
