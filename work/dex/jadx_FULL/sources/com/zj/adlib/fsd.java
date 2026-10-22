package com.zj.adlib;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.android.gms.internal.mlkit_vision_barcode.zztn;
import com.google.android.gms.internal.mlkit_vision_barcode.zztp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fsd implements zztn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final List f41749a;

    public fsd(Context context, zztp zztpVar) {
        ArrayList arrayList = new ArrayList();
        this.f41749a = arrayList;
        if (zztpVar.c()) {
            arrayList.add(new btd(context, zztpVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztn
    public final void a(zztm zztmVar) {
        Iterator it = this.f41749a.iterator();
        while (it.hasNext()) {
            ((zztn) it.next()).a(zztmVar);
        }
    }
}
