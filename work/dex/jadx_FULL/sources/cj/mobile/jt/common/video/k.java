package cj.mobile.jt.common.video;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cj.mobile.jt.core.nativead.NativeVideoListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class k extends FrameLayout implements p {
    public static final /* synthetic */ int z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f22437a;
    public b b;
    public c c;
    public View d;
    public m0 e;
    public final m f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public long m;
    public long n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public NativeVideoListener s;
    public Handler t;
    public d u;
    public boolean v;
    public final String w;
    public boolean x;
    public boolean y;

    public k(Context context, String str, m mVar) {
    }

    private void setSurfacePlayState(boolean z2) {
    }

    public final void a(m mVar) {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
    }

    public Context getAttachActivity() {
    }

    public m getConfig() {
        return this.f;
    }

    public long getCurrentPosition() {
        return this.m;
    }

    public long getDuration() {
        return this.n;
    }

    public int getRenderType() {
        return this.f.f22440a;
    }

    public int getVideoHeight() {
        return this.p;
    }

    public int getVideoWidth() {
        return this.o;
    }

    public final void h() {
    }

    public void setAdVisible(boolean z2) {
    }

    public void setDataSource(String str) {
    }

    public void setLooping(boolean z2) {
    }

    public void setMuted(boolean z2) {
    }

    public void setNativeVideoListener(NativeVideoListener nativeVideoListener) {
        this.s = nativeVideoListener;
    }

    public void setPlayerListener(o oVar) {
    }

    public void setRenderType(int i) {
    }

    public void setScaleType(int i) {
    }

    public final void a() {
    }

    public final void a(String str, ImageView.ScaleType scaleType) {
    }

    public final void a(int i, int i2) {
    }
}
