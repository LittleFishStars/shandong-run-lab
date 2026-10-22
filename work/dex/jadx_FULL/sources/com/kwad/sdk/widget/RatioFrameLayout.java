package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class RatioFrameLayout extends FrameLayout {
    private double aJV;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public double getRatio() {
        return this.aJV;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aJV != AudioStats.AUDIO_AMPLITUDE_NONE) {
            int size = View.MeasureSpec.getSize(i);
            Log.d("RatioFrameLayout", "widthSize:" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) size) * this.aJV), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(double d) {
        this.aJV = d;
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJV = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
