package com.ipd.dsp.internal.m;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.j.e;
import com.ipd.dsp.internal.k.j;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f38404a;
    public final e b;
    public final com.ipd.dsp.internal.f.b c;
    public a d;

    public b(j jVar, e eVar, com.ipd.dsp.internal.f.b bVar) {
        this.f38404a = jVar;
        this.b = eVar;
        this.c = bVar;
    }

    public void a(d.a... aVarArr) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            d.a aVar2 = aVarArr[i];
            if (aVar2.b() == null) {
                aVar2.a(this.c == com.ipd.dsp.internal.f.b.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            dVarArr[i] = aVar2.a();
        }
        a aVar3 = new a(this.b, this.f38404a, a(dVarArr));
        this.d = aVar3;
        o.a(aVar3);
    }

    @VisibleForTesting
    public c a(d... dVarArr) {
        long jB = (this.f38404a.b() - this.f38404a.c()) + this.b.b();
        int iC = 0;
        for (d dVar : dVarArr) {
            iC += dVar.c();
        }
        float f = jB / iC;
        HashMap map = new HashMap();
        for (d dVar2 : dVarArr) {
            map.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f) / a(dVar2)));
        }
        return new c(map);
    }

    public static int a(d dVar) {
        return o.a(dVar.d(), dVar.b(), dVar.a());
    }
}
