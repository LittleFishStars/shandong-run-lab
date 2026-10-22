package com.kc.cw.ad.internal.a;

import android.content.Context;
import android.widget.ViewAnimator;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends ViewAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f38831a;
    private i b;
    private h c;
    private long d;

    public b(Context context, i iVar, h hVar, long j) {
        super(context);
        this.f38831a = null;
        this.b = iVar;
        this.c = hVar;
        this.d = j;
        this.f38831a = a.a(iVar, j, hVar);
        a();
    }

    public void a() {
        g gVar = this.f38831a;
        if (gVar != null) {
            setInAnimation(gVar.a());
            setOutAnimation(this.f38831a.b());
        }
    }

    @Override // android.view.View
    public void clearAnimation() {
        setInAnimation(null);
        setOutAnimation(null);
    }

    public h getTransitionDirection() {
        return this.c;
    }

    public long getTransitionDuration() {
        return this.d;
    }

    public i getTransitionType() {
        return this.b;
    }

    public void setTransitionDirection(h hVar) {
        if (this.c != hVar) {
            this.c = hVar;
            this.f38831a = a.a(this.b, this.d, hVar);
            a();
        }
    }

    public void setTransitionDuration(long j) {
        if (this.d != j) {
            this.d = j;
            this.f38831a = a.a(this.b, j, this.c);
            a();
        }
    }

    public void setTransitionType(i iVar) {
        if (this.b != iVar) {
            this.b = iVar;
            this.f38831a = a.a(iVar, this.d, this.c);
            a();
        }
    }
}
