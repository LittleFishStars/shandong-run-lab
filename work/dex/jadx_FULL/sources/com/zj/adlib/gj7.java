package com.zj.adlib;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class gj7 extends cl3 implements VisibilityAwareDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public VisibilityCallback f41921a;

    @VisibleForTesting
    @Nullable
    public Drawable b;

    public gj7(Drawable drawable) {
        super(drawable);
        this.b = null;
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            VisibilityCallback visibilityCallback = this.f41921a;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
            Drawable drawable = this.b;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.b.draw(canvas);
            }
        }
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void j(@Nullable VisibilityCallback visibilityCallback) {
        this.f41921a = visibilityCallback;
    }

    public void r(@Nullable Drawable drawable) {
        this.b = drawable;
        invalidateSelf();
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        VisibilityCallback visibilityCallback = this.f41921a;
        if (visibilityCallback != null) {
            visibilityCallback.a(z);
        }
        return super.setVisible(z, z2);
    }
}
