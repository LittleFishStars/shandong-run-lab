package com.alivc.component.decoder;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DecoderSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final int CREATE_SURFACE_MSG = 12345;
    private int mTextureId = 0;
    private long mDecoderHandler = 0;
    private SurfaceTexture mSurfaceTexture = null;
    private Surface mSurface = null;
    private HandlerThread mHandleThread = new HandlerThread("DecoderSurfaceTexture");
    private Handler mHandler = null;
    private CountDownLatch mCountDown = new CountDownLatch(1);

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != DecoderSurfaceTexture.CREATE_SURFACE_MSG) {
                super.handleMessage(message);
                return;
            }
            DecoderSurfaceTexture.this.mSurfaceTexture = new SurfaceTexture(DecoderSurfaceTexture.this.mTextureId);
            DecoderSurfaceTexture.this.mSurfaceTexture.setOnFrameAvailableListener((DecoderSurfaceTexture) message.obj);
            DecoderSurfaceTexture.this.mSurface = new Surface(DecoderSurfaceTexture.this.mSurfaceTexture);
            DecoderSurfaceTexture.this.mCountDown.countDown();
        }
    }

    public DecoderSurfaceTexture() {
        this.mHandleThread.start();
    }

    private native void onFrameAvailable(long j);

    public Surface createSurface(int i, long j) {
        if (i <= 0) {
            return null;
        }
        this.mTextureId = i;
        this.mDecoderHandler = j;
        try {
            this.mHandler = new a(this.mHandleThread.getLooper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Message message = new Message();
        message.what = CREATE_SURFACE_MSG;
        message.obj = this;
        this.mHandler.sendMessage(message);
        try {
            this.mCountDown.await();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.mSurface;
    }

    public void dispose() {
        this.mSurface.release();
        this.mHandleThread.quit();
    }

    public void getTransformMatrix(float[] fArr) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return;
        }
        surfaceTexture.getTransformMatrix(fArr);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        onFrameAvailable(this.mDecoderHandler);
    }

    public void updateTexImage() {
        this.mSurfaceTexture.updateTexImage();
    }
}
