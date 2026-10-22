package com.ipd.dsp.internal.u;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f.m;
import com.ipd.dsp.internal.i.v;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements m<c> {
    public final m<Bitmap> c;

    public f(m<Bitmap> mVar) {
        this.c = (m) com.ipd.dsp.internal.d0.m.a(mVar);
    }

    @Override // com.ipd.dsp.internal.f.m
    @NonNull
    public v<c> a(@NonNull Context context, @NonNull v<c> vVar, int i, int i2) {
        c cVar = vVar.get();
        v<Bitmap> gVar = new com.ipd.dsp.internal.q.g(cVar.e(), com.ipd.dsp.internal.components.glide.a.a(context).e());
        v<Bitmap> vVarA = this.c.a(context, gVar, i, i2);
        if (!gVar.equals(vVarA)) {
            gVar.e();
        }
        cVar.a(this.c, vVarA.get());
        return vVar;
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.c.equals(((f) obj).c);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.c.a(messageDigest);
    }
}
