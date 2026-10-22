package cj.mobile.jt.core.ui.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class k extends ImageView implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22569a;
    public Bitmap b;
    public Handler c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Thread g;
    public long h;
    public i i;
    public e j;
    public f k;
    public boolean l;
    public boolean m;
    public float n;
    public final Path o;
    public final RectF p;

    public k(Context context, AttributeSet attributeSet) {
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void d() {
    }

    public int getFrameCount() {
    }

    public long getFramesDisplayDuration() {
        return this.h;
    }

    public int getGifHeight() {
    }

    public int getGifWidth() {
    }

    public i getOnAnimationStop() {
        return this.i;
    }

    public j getOnFrameAvailable() {
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    @Override // java.lang.Runnable
    public final void run() {
    }

    public void setBytes(byte[] bArr) {
    }

    public void setCanClear(boolean z) {
        this.l = z;
    }

    public void setCornerRadiusDp(float f) {
    }

    public void setCornerRadiusPx(float f) {
    }

    public void setFramesDisplayDuration(long j) {
        this.h = j;
    }

    public void setOnAnimationStart(h hVar) {
    }

    public void setOnAnimationStop(i iVar) {
        this.i = iVar;
    }

    public void setOnFrameAvailable(j jVar) {
    }

    public void setRoundEnabled(boolean z) {
    }

    public final void a(int i, int i2) {
    }

    public k(Context context) {
    }
}
