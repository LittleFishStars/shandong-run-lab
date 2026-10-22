package com.bykv.vk.component.ttvideo;

import android.view.Surface;
import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class b implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<TTVideoEngine> f29285a;

    public b(TTVideoEngine tTVideoEngine) {
        this.f29285a = new WeakReference<>(tTVideoEngine);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TTVideoEngine tTVideoEngine = this.f29285a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TTVideoEngine tTVideoEngine = this.f29285a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a((Surface) null);
        }
    }
}
