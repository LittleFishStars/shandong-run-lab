package com.kc.dw.core.view.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GifImageView extends AppCompatImageView implements Runnable {
    private static final String TAG = "GifDecoderView";
    private boolean animating;
    private OnAnimationStart animationStartCallback;
    private OnAnimationStop animationStopCallback;
    private Thread animationThread;
    private boolean canClear;
    private final Runnable cleanupRunnable;
    private OnFrameAvailable frameCallback;
    private long framesDisplayDuration;
    private GifDecoder gifDecoder;
    private final Handler handler;
    private boolean renderFrame;
    private boolean shouldClear;
    private Bitmap tmpBitmap;
    private final Runnable updateResults;

    @Keep
    public interface OnAnimationStart {
        void onAnimationStart();
    }

    @Keep
    public interface OnAnimationStop {
        void onAnimationStop();
    }

    @Keep
    public interface OnFrameAvailable {
        Bitmap onFrameAvailable(Bitmap bitmap);
    }

    public GifImageView(Context context) {
        super(context);
        this.handler = new Handler(Looper.getMainLooper());
        this.frameCallback = null;
        this.framesDisplayDuration = -1L;
        this.animationStopCallback = null;
        this.animationStartCallback = null;
        this.updateResults = new j(this) { // from class: com.kc.dw.core.view.gif.GifImageView.1
            public final GifImageView this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                if (this.this$0.tmpBitmap == null || this.this$0.tmpBitmap.isRecycled()) {
                    return;
                }
                GifImageView gifImageView = this.this$0;
                gifImageView.setImageBitmap(gifImageView.tmpBitmap);
            }
        };
        this.cleanupRunnable = new j(this) { // from class: com.kc.dw.core.view.gif.GifImageView.2
            public final GifImageView this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.this$0.tmpBitmap = null;
                this.this$0.gifDecoder = null;
                this.this$0.animationThread = null;
                this.this$0.shouldClear = false;
            }
        };
        this.canClear = true;
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler(Looper.getMainLooper());
        this.frameCallback = null;
        this.framesDisplayDuration = -1L;
        this.animationStopCallback = null;
        this.animationStartCallback = null;
        this.updateResults = new j(this) { // from class: com.kc.dw.core.view.gif.GifImageView.1
            public final GifImageView this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                if (this.this$0.tmpBitmap == null || this.this$0.tmpBitmap.isRecycled()) {
                    return;
                }
                GifImageView gifImageView = this.this$0;
                gifImageView.setImageBitmap(gifImageView.tmpBitmap);
            }
        };
        this.cleanupRunnable = new j(this) { // from class: com.kc.dw.core.view.gif.GifImageView.2
            public final GifImageView this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.this$0.tmpBitmap = null;
                this.this$0.gifDecoder = null;
                this.this$0.animationThread = null;
                this.this$0.shouldClear = false;
            }
        };
        this.canClear = true;
    }

    private boolean canStart() {
        return (this.animating || this.renderFrame) && this.gifDecoder != null && this.animationThread == null;
    }

    private void startAnimationThread() {
        if (canStart()) {
            Thread thread = new Thread(this);
            this.animationThread = thread;
            thread.start();
        }
    }

    public void clear() {
        this.animating = false;
        this.renderFrame = false;
        this.shouldClear = true;
        stopAnimation();
        this.handler.post(this.cleanupRunnable);
    }

    public int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    public long getFramesDisplayDuration() {
        return this.framesDisplayDuration;
    }

    public int getGifHeight() {
        return this.gifDecoder.getHeight();
    }

    public int getGifWidth() {
        return this.gifDecoder.getWidth();
    }

    public OnAnimationStop getOnAnimationStop() {
        return this.animationStopCallback;
    }

    public OnFrameAvailable getOnFrameAvailable() {
        return this.frameCallback;
    }

    public void gotoFrame(int i) {
        if (this.gifDecoder.getCurrentFrameIndex() == i || !this.gifDecoder.setFrameIndex(i - 1) || this.animating) {
            return;
        }
        this.renderFrame = true;
        startAnimationThread();
    }

    public boolean isAnimating() {
        return this.animating;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.canClear) {
            clear();
        }
    }

    public void resetAnimation() {
        this.gifDecoder.resetLoopIndex();
        gotoFrame(0);
    }

    @Override // java.lang.Runnable
    public void run() {
        long jNanoTime;
        try {
            OnAnimationStart onAnimationStart = this.animationStartCallback;
            if (onAnimationStart != null) {
                onAnimationStart.onAnimationStart();
            }
            do {
                if (!this.animating && !this.renderFrame) {
                    break;
                }
                boolean zAdvance = this.gifDecoder.advance();
                try {
                    long jNanoTime2 = System.nanoTime();
                    Bitmap nextFrame = this.gifDecoder.getNextFrame();
                    this.tmpBitmap = nextFrame;
                    OnFrameAvailable onFrameAvailable = this.frameCallback;
                    if (onFrameAvailable != null) {
                        this.tmpBitmap = onFrameAvailable.onFrameAvailable(nextFrame);
                    }
                    jNanoTime = (System.nanoTime() - jNanoTime2) / 1000000;
                    try {
                        this.handler.post(this.updateResults);
                    } catch (Throwable th) {
                        th = th;
                        Log.w(TAG, th);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jNanoTime = 0;
                }
                this.renderFrame = false;
                if (!this.animating || !zAdvance) {
                    this.animating = false;
                    break;
                }
                try {
                    int nextDelay = (int) (((long) this.gifDecoder.getNextDelay()) - jNanoTime);
                    if (nextDelay > 0) {
                        long j = this.framesDisplayDuration;
                        if (j <= 0) {
                            j = nextDelay;
                        }
                        Thread.sleep(j);
                    }
                } catch (Exception unused) {
                }
            } while (this.animating);
            if (this.shouldClear) {
                this.handler.post(this.cleanupRunnable);
            }
            this.animationThread = null;
            OnAnimationStop onAnimationStop = this.animationStopCallback;
            if (onAnimationStop != null) {
                onAnimationStop.onAnimationStop();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void setBytes(byte[] bArr) {
        try {
            GifDecoder gifDecoder = new GifDecoder();
            this.gifDecoder = gifDecoder;
            try {
                gifDecoder.read(4, bArr);
                if (this.animating) {
                    startAnimationThread();
                } else {
                    gotoFrame(0);
                }
            } catch (Throwable unused) {
                this.gifDecoder = null;
            }
        } catch (Throwable unused2) {
        }
    }

    public void setBytes(byte[] bArr, int i) {
        try {
            GifDecoder gifDecoder = new GifDecoder();
            this.gifDecoder = gifDecoder;
            try {
                gifDecoder.read(i, bArr);
                if (this.animating) {
                    startAnimationThread();
                } else {
                    gotoFrame(0);
                }
            } catch (Throwable unused) {
                this.gifDecoder = null;
            }
        } catch (Throwable unused2) {
        }
    }

    public void setCanClear(boolean z) {
        this.canClear = z;
    }

    public void setFramesDisplayDuration(long j) {
        this.framesDisplayDuration = j;
    }

    public void setOnAnimationStart(OnAnimationStart onAnimationStart) {
        this.animationStartCallback = onAnimationStart;
    }

    public void setOnAnimationStop(OnAnimationStop onAnimationStop) {
        this.animationStopCallback = onAnimationStop;
    }

    public void setOnFrameAvailable(OnFrameAvailable onFrameAvailable) {
        this.frameCallback = onFrameAvailable;
    }

    public void startAnimation() {
        this.animating = true;
        startAnimationThread();
    }

    public void stopAnimation() {
        this.animating = false;
        Thread thread = this.animationThread;
        if (thread != null) {
            thread.interrupt();
            this.animationThread = null;
        }
    }
}
