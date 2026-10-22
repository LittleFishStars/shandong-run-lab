package com.kc.aw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.FrameLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _m0 extends FrameLayout {
    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(new Canvas(Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888)));
        canvas.saveLayer(new RectF(getLeft(), getTop(), getRight(), getBottom()), null, 31);
        throw null;
    }

    public void setAllRound(int i) {
    }

    public void setLeftBottomRound(int i) {
    }

    public void setLeftTopRound(int i) {
    }

    public void setRightBottomRound(int i) {
    }

    public void setRightTopRound(int i) {
    }
}
