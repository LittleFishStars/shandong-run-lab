package com.ipd.dsp.internal.s;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends d<Drawable> {
    public f(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    public static v<Drawable> a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new f(drawable);
        }
        return null;
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return Math.max(1, this.f.getIntrinsicWidth() * this.f.getIntrinsicHeight() * 4);
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<Drawable> d() {
        return this.f.getClass();
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
    }
}
