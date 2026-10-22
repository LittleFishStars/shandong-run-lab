package com.byazt.jr;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.nr.m;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_LBSRISK_INVALID_BINARY_FORMAT, 2223})
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, tt {
    public c c;
    public tt.c tt;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.byazt.jr.tt
    public void c(c cVar) {
        this.c = cVar;
        setSurfaceTextureListener(this);
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.byazt.jr.tt
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            m.c(th);
            if (com.byazt.lt.tt.tt()) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        c cVar = this.c;
        if (cVar != null) {
            return cVar.c(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(tt.c cVar) {
        this.tt = cVar;
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.byazt.jr.tt
    public void c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
