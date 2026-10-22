package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.zj.adlib.i76;
import com.zj.adlib.tb0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f31283a;

    public c(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        tb0.c(onImageLoadedListener);
        this.f31283a = new WeakReference(onImageLoadedListener);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f31283a.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) cVar.f31283a.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && i76.b(onImageLoadedListener2, onImageLoadedListener) && i76.b(((zag) cVar).f5651a, ((zag) this).f5651a);
    }

    public final int hashCode() {
        return i76.c(((zag) this).f5651a);
    }

    @Override // com.google.android.gms.common.images.zag
    public final void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (z2 || (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f31283a.get()) == null) {
            return;
        }
        onImageLoadedListener.a(((zag) this).f5651a.f40894a, drawable, z3);
    }
}
