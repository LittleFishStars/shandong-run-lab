package com.ipd.dsp.internal.v;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.i.v;
import com.ipd.dsp.internal.q.c0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f38557a;

    public b(@NonNull Context context) {
        this(context.getResources());
    }

    @Override // com.ipd.dsp.internal.v.e
    @Nullable
    public v<BitmapDrawable> a(@NonNull v<Bitmap> vVar, @NonNull i iVar) {
        return c0.a(this.f38557a, vVar);
    }

    @Deprecated
    public b(@NonNull Resources resources, com.ipd.dsp.internal.j.e eVar) {
        this(resources);
    }

    public b(@NonNull Resources resources) {
        this.f38557a = (Resources) m.a(resources);
    }
}
