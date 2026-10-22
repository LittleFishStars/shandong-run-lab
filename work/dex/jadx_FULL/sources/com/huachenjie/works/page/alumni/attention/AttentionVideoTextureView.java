package com.huachenjie.works.page.alumni.attention;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AttentionVideoTextureView extends TextureView {
    protected static final String TAG = "XLog";
    public int K;
    public int L;
    public int currentVideoHeight;
    public int currentVideoWidth;

    public AttentionVideoTextureView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.currentVideoWidth;
        int i2 = this.currentVideoHeight;
        int defaultSize = View.getDefaultSize(i, widthMeasureSpec);
        int defaultSize2 = View.getDefaultSize(i2, heightMeasureSpec);
        if (i == 0 || i2 == 0) {
            setMeasuredDimension(defaultSize, defaultSize2);
            return;
        }
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        float f = i / i2;
        if (this.K == 0) {
            this.K = (int) TypedValue.applyDimension(1, 500.0f, getResources().getDisplayMetrics());
        }
        if (this.L == 0) {
            this.L = (int) TypedValue.applyDimension(1, 160.0f, getResources().getDisplayMetrics());
        }
        int i3 = (int) (measuredWidth / f);
        int i4 = this.K;
        if (i3 > i4) {
            measuredWidth = (int) (i4 * f);
            i3 = i4;
        }
        Log.d(TAG, "view size(" + measuredWidth + "," + i3 + ")");
        setMeasuredDimension(measuredWidth, i3);
    }

    @Override // android.view.View
    public void setRotation(float rotation) {
        if (rotation != getRotation()) {
            super.setRotation(rotation);
            requestLayout();
        }
    }

    public void setVideoSize(int currentVideoWidth, int currentVideoHeight) {
        Log.d(TAG, "setVideoSize(" + currentVideoWidth + "," + currentVideoHeight + ")");
        if (this.currentVideoWidth == currentVideoWidth && this.currentVideoHeight == currentVideoHeight) {
            return;
        }
        this.currentVideoWidth = currentVideoWidth;
        this.currentVideoHeight = currentVideoHeight;
        Log.d(TAG, "requestLayout(" + currentVideoWidth + "," + currentVideoHeight + ")");
        requestLayout();
    }

    public AttentionVideoTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.K = 0;
        this.L = 0;
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
