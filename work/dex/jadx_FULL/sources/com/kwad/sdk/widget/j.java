package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class j {
    private boolean mClipBackground;

    @NonNull
    private a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    public static class a {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public final a cH(boolean z) {
            this.leftTop = z;
            return this;
        }

        public final a cI(boolean z) {
            this.topRight = z;
            return this;
        }

        public final a cJ(boolean z) {
            this.rightBottom = z;
            return this;
        }

        public final a cK(boolean z) {
            this.bottomLeft = z;
            return this;
        }

        public final boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean isLeftTop() {
            return this.leftTop;
        }

        public final boolean isRightBottom() {
            return this.rightBottom;
        }

        public final boolean isTopRight() {
            return this.topRight;
        }

        public final void setAllCorner(boolean z) {
            this.leftTop = z;
            this.topRight = z;
            this.rightBottom = z;
            this.bottomLeft = z;
        }
    }

    public j() {
        this.radiusArray = new float[8];
        this.mCornerConf = new a();
    }

    private Path getPath() {
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        this.mPath.addRoundRect(this.mRectF, this.mRadius == 0.0f ? this.radiusArray : getRadius(), Path.Direction.CW);
        return this.mPath;
    }

    private float[] getRadius() {
        this.radiusArray[0] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[1] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[2] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[3] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[4] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[5] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[6] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        this.radiusArray[7] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        return this.radiusArray;
    }

    public final void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public final void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.mRectF, null, 31);
        } else {
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    public final void beforeDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.mRectF, null, 31);
            } else {
                canvas.save();
                canvas.clipPath(getPath());
            }
        }
    }

    @NonNull
    public final a getCornerConf() {
        return this.mCornerConf;
    }

    public final void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int i = R.attr.ksad_radius;
                int i2 = R.attr.ksad_clipBackground;
                int[] iArr = {i, i2};
                Arrays.sort(iArr);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
                this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
                this.mClipBackground = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void onSizeChanged(int i, int i2) {
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    public final void setRadius(float f) {
        this.mRadius = f;
    }

    public final void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public j(a aVar) {
        this.radiusArray = new float[8];
        this.mCornerConf = aVar;
    }
}
