package com.aliyun.player.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.aliyun.player.IPlayer;
import com.aliyun.player.videoview.AliDisplayView;
import com.cicada.player.utils.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a {
    private static final String k = "AliDisplayView_" + a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f25596a;
    protected h b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private IPlayer.ScaleMode f = IPlayer.ScaleMode.SCALE_ASPECT_FIT;
    private IPlayer.MirrorMode g = IPlayer.MirrorMode.MIRROR_MODE_NONE;
    private IPlayer.RotateMode h = IPlayer.RotateMode.ROTATE_0;
    private boolean i = false;
    private View j = null;

    /* JADX INFO: renamed from: com.aliyun.player.videoview.a.a$a, reason: collision with other inner class name */
    public class RunnableC0216a implements Runnable {
        public RunnableC0216a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g();
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPlayer.MirrorMode f25601a;

        public e(IPlayer.MirrorMode mirrorMode) {
            this.f25601a = mirrorMode;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f25601a);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.j.getParent() == a.this.f25596a) {
                a.this.f25596a.removeView(a.this.j);
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f25596a.addView(a.this.j, 0);
            a aVar = a.this;
            aVar.c(aVar.g);
            a aVar2 = a.this;
            aVar2.b(aVar2.f);
            a aVar3 = a.this;
            aVar3.c(aVar3.h);
            a.this.g();
        }
    }

    public interface h {
        void onSurfaceCreated(Surface surface);

        void onSurfaceDestroy();

        void onSurfaceSizeChanged();

        void onViewCreated(AliDisplayView.DisplayViewType displayViewType);
    }

    public a(ViewGroup viewGroup) {
        this.f25596a = viewGroup;
        Logger.v(k, this + " new IDisplayView()");
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f25596a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IPlayer.ScaleMode scaleMode) {
        if (scaleMode != null) {
            this.f = scaleMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IPlayer.MirrorMode mirrorMode) {
        if (mirrorMode != null) {
            this.g = mirrorMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IPlayer.RotateMode rotateMode) {
        if (rotateMode != null) {
            this.h = rotateMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x008b A[PHI: r0 r6
      0x008b: PHI (r0v6 int) = (r0v5 int), (r0v11 int) binds: [B:35:0x0089, B:30:0x007b] A[DONT_GENERATE, DONT_INLINE]
      0x008b: PHI (r6v1 int) = (r6v0 int), (r6v3 int) binds: [B:35:0x0089, B:30:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x0095 A[PHI: r0 r6
      0x0095: PHI (r0v9 int) = (r0v5 int), (r0v11 int) binds: [B:37:0x0093, B:32:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x0095: PHI (r6v2 int) = (r6v0 int), (r6v3 int) binds: [B:37:0x0093, B:32:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    public void g() {
        String str;
        int i;
        int i2;
        String str2 = k;
        Logger.v(str2, "updateViewParams  ");
        if (!this.i) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (this.j.getParent() == this.f25596a) {
                this.j.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (this.d == 0 || this.c == 0) {
            str = "updateViewParams ，unknow videoheight and width ";
        } else {
            int measuredWidth = this.f25596a.getMeasuredWidth();
            int measuredHeight = this.f25596a.getMeasuredHeight();
            if (measuredWidth != 0 && measuredHeight != 0) {
                if (a(this.h)) {
                    int value = (int) (this.e + this.h.getValue());
                    if (value == 90 || value == 270) {
                        measuredWidth = this.f25596a.getMeasuredHeight();
                        measuredHeight = this.f25596a.getMeasuredWidth();
                    }
                }
                IPlayer.ScaleMode scaleMode = this.f;
                if (scaleMode != IPlayer.ScaleMode.SCALE_TO_FILL) {
                    if (scaleMode == IPlayer.ScaleMode.SCALE_ASPECT_FILL) {
                        i = this.c;
                        int i3 = i * measuredHeight;
                        i2 = this.d;
                        int i4 = measuredWidth * i2;
                        if (i3 > i4) {
                            measuredWidth = (int) (((measuredHeight * 1.0f) * i) / i2);
                        } else if (i3 < i4) {
                            measuredHeight = (int) (((measuredWidth * 1.0f) * i2) / i);
                        }
                    } else {
                        i = this.c;
                        int i5 = i * measuredHeight;
                        i2 = this.d;
                        int i6 = measuredWidth * i2;
                        if (i5 < i6) {
                            measuredWidth = (int) (((measuredHeight * 1.0f) * i) / i2);
                        } else if (i5 > i6) {
                            measuredHeight = (int) (((measuredWidth * 1.0f) * i2) / i);
                        }
                    }
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams2.width = measuredWidth;
                layoutParams2.height = measuredHeight;
                layoutParams2.gravity = 17;
                if (this.j.getParent() == this.f25596a) {
                    this.j.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            str = "updateViewParams ，unknow parent height and width ";
        }
        Logger.w(str2, str);
    }

    public abstract View a(Context context);

    public void a() {
        Logger.v(k, " attachView");
        a(new g());
    }

    public void a(int i, int i2, int i3) {
        Logger.v(k, "setVideoSize  " + i + " ， " + i2 + " ， " + i3);
        this.c = i;
        this.d = i2;
        this.e = i3;
        a(new c());
    }

    public void a(IPlayer.ScaleMode scaleMode) {
        Logger.v(k, "setScaleMode  " + scaleMode);
        b(scaleMode);
        a(new d());
    }

    public void a(h hVar) {
        Logger.v(k, this + " setOnViewStatusListener " + hVar);
        this.b = hVar;
    }

    public void a(boolean z) {
        Logger.v(k, "setRenderFlag  " + z);
        this.i = z;
        a(new b());
    }

    public abstract boolean a(IPlayer.MirrorMode mirrorMode);

    public abstract boolean a(IPlayer.RotateMode rotateMode);

    public void b() {
        Logger.v(k, " detachView");
        a(new f());
    }

    public void b(IPlayer.MirrorMode mirrorMode) {
        Logger.v(k, "setMirrorMode  " + mirrorMode);
        c(mirrorMode);
        this.j.post(new e(mirrorMode));
    }

    public void b(IPlayer.RotateMode rotateMode) {
        Logger.v(k, "setRotateMode  " + rotateMode);
        c(rotateMode);
        g();
    }

    public abstract void b(boolean z);

    public void c() {
        this.j = a(this.f25596a.getContext());
    }

    public void d() {
        Logger.v(k, "parentSizeChanged  ");
        a(new RunnableC0216a());
    }

    public abstract Bitmap e();

    public Bitmap f() {
        return e();
    }
}
