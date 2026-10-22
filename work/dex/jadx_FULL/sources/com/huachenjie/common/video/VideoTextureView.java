package com.huachenjie.common.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class VideoTextureView extends TextureView {
    protected static final String TAG = "VideoTextureView";
    public int currentVideoHeight;
    public int currentVideoWidth;

    public VideoTextureView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.currentVideoWidth;
        int i2 = this.currentVideoHeight;
        ((View) getParent()).getMeasuredHeight();
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        int defaultSize = View.getDefaultSize(i, widthMeasureSpec);
        int defaultSize2 = View.getDefaultSize(i2, heightMeasureSpec);
        setMeasuredDimension(defaultSize, defaultSize2);
        if (i == 0 || i2 == 0) {
            setMeasuredDimension(defaultSize, defaultSize2);
        } else {
            setMeasuredDimension(measuredWidth, (int) (((double) measuredWidth) / ((double) (i / i2))));
        }
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
        requestLayout();
    }

    public VideoTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
