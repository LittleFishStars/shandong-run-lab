package com.kc.dw.ad.view;

import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.view.View;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j extends com.kc.dw.core.safe.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsdVideoTextureView f39194a;

    public j(SsdVideoTextureView ssdVideoTextureView) {
        this.f39194a = ssdVideoTextureView;
    }

    @Override // com.kc.dw.core.safe.i
    public void safeOnVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int measuredWidth;
        View view;
        SsdVideoTextureView ssdVideoTextureView = this.f39194a;
        ssdVideoTextureView.l = i;
        ssdVideoTextureView.m = i2;
        MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = ssdVideoTextureView.i;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i, i2);
        }
        SsdVideoTextureView ssdVideoTextureView2 = this.f39194a;
        if (ssdVideoTextureView2.o != null) {
            return;
        }
        LogUtil.i(ssdVideoTextureView2.f39180a, "" + i + " " + i2);
        if (this.f39194a.getParent() instanceof View) {
            measuredWidth = ((View) this.f39194a.getParent()).getMeasuredWidth();
            view = (View) this.f39194a.getParent();
        } else {
            measuredWidth = this.f39194a.getMeasuredWidth();
            view = this.f39194a;
        }
        int measuredHeight = view.getMeasuredHeight();
        Matrix matrixA = this.f39194a.a(measuredWidth, measuredHeight);
        SsdVideoTextureView ssdVideoTextureView3 = this.f39194a;
        if (!ssdVideoTextureView3.n) {
            ssdVideoTextureView3.a(measuredWidth, measuredHeight, matrixA);
        } else {
            ssdVideoTextureView3.setTransform(matrixA);
            this.f39194a.postInvalidate();
        }
    }
}
