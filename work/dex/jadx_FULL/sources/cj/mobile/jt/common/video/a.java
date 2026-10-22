package cj.mobile.jt.common.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class a implements TextureView.SurfaceTextureListener, SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceHolder f22412a;
    public HandlerThread b;
    public Handler c;
    public final Handler d;
    public final p e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile boolean k;

    public a(p pVar) {
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void a(Runnable runnable) {
    }

    public final void b(Runnable runnable) {
    }
}
