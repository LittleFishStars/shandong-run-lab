package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n3c extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f43438a;

    public n3c(ImageView imageView, int i) {
        super(Uri.EMPTY, i);
        tb0.c(imageView);
        this.f43438a = new WeakReference(imageView);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3c)) {
            return false;
        }
        ImageView imageView = (ImageView) this.f43438a.get();
        ImageView imageView2 = (ImageView) ((n3c) obj).f43438a.get();
        return (imageView2 == null || imageView == null || !i76.b(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.gms.common.images.zag
    public final void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = (ImageView) this.f43438a.get();
        if (imageView != null) {
            if (!z2 && !z3 && (imageView instanceof zal)) {
                throw null;
            }
            boolean z4 = false;
            if (!z2 && !z) {
                z4 = true;
            }
            if (z4) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof n4c) {
                    drawable2 = ((n4c) drawable2).a();
                }
                drawable = new n4c(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zal) {
                throw null;
            }
            if (drawable == null || !z4) {
                return;
            }
            ((n4c) drawable).b(250);
        }
    }

    public n3c(ImageView imageView, Uri uri) {
        super(uri, 0);
        tb0.c(imageView);
        this.f43438a = new WeakReference(imageView);
    }
}
