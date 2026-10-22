package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.huachenjie.base.view.danmuku.view.OnDanMuTouchCallBackListener;
import com.huachenjie.base.view.danmuku.view.OnDanMuViewTouchListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class y52 implements OnDanMuViewTouchListener {
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 100;
    public static final int w = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f45959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f20785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f20786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f20787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnDanMuTouchCallBackListener f20788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f20789a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f20791b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Bitmap f20792b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f20793b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f20794b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f20795c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f20797d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f20799e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f20800e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f20801f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20790a = true;
    public float c = -1.0f;
    public float d = -1.0f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f20796c = true;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f20798d = true;
    public int s = 50;

    public void A(float startPositionX) {
        this.c = startPositionX;
    }

    public void B(float startPositionY) {
        this.d = startPositionY;
    }

    public void C(int width) {
        this.o = width;
    }

    @Override // com.huachenjie.base.view.danmuku.view.OnDanMuViewTouchListener
    public boolean a(float x, float y) {
        return x >= m() && x <= m() + ((float) l()) && y >= n() && y <= n() + ((float) h());
    }

    public float b() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = this.f20785a;
        if (j == 0) {
            this.f20785a = jUptimeMillis;
            return 0.0f;
        }
        long j2 = jUptimeMillis - j;
        this.f20785a = jUptimeMillis;
        if (j2 <= 0) {
            return 0.0f;
        }
        if (j2 > 100) {
            j2 = 100;
        }
        return (this.e * j2) / 1000.0f;
    }

    public void c(boolean isMoving) {
        this.f20796c = isMoving;
    }

    public void d(boolean enableTouch) {
        this.f20794b = enableTouch;
    }

    public boolean e() {
        return this.f20794b;
    }

    public int f() {
        return this.q;
    }

    public int g() {
        return this.r;
    }

    public int h() {
        return this.p;
    }

    public OnDanMuTouchCallBackListener i() {
        return this.f20788a;
    }

    public int j() {
        return this.s;
    }

    public float k() {
        return this.e;
    }

    public int l() {
        return this.o;
    }

    public float m() {
        return this.c;
    }

    public float n() {
        return this.d;
    }

    public boolean o() {
        return this.f20798d;
    }

    public boolean p() {
        return this.f20800e;
    }

    public boolean q() {
        return this.f20801f;
    }

    public boolean r() {
        return this.f20796c;
    }

    @Override // com.huachenjie.base.view.danmuku.view.OnDanMuViewTouchListener
    public void release() {
        this.f20786a = null;
        this.f20792b = null;
        this.f20787a = null;
        this.f20788a = null;
    }

    public void s(int index) {
        this.q = index;
    }

    public void setOnTouchCallBackListener(OnDanMuTouchCallBackListener onTouchCallBackListener) {
        this.f20788a = onTouchCallBackListener;
    }

    public void t(boolean isAlive) {
        if (!isAlive) {
            release();
        }
        this.f20798d = isAlive;
    }

    public void u(boolean attached) {
        this.f20800e = attached;
    }

    public void v(int displayType) {
        this.r = displayType;
    }

    public void w(int height) {
        this.p = height;
    }

    public void x(boolean measured) {
        this.f20801f = measured;
    }

    public void y(int priority) {
        if (priority != 50 && priority != 100) {
            throw new IllegalArgumentException("there's no such number of priority");
        }
        this.s = priority;
    }

    public void z(float speed) {
        this.e = speed;
        this.f20785a = 0L;
    }
}
