package com.fl.saas;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.base.interfaces.AdViewVideoListener;

/* JADX INFO: renamed from: com.fl.saas.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1411h extends AbstractC1425o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f30174a;
    private long b;

    public boolean b() {
        return this.f30174a && ((((System.currentTimeMillis() - this.b) / 1000) > ((long) getAdSource().D1) ? 1 : (((System.currentTimeMillis() - this.b) / 1000) == ((long) getAdSource().D1) ? 0 : -1)) < 0);
    }

    public void c() {
        double d = getAdSource().d > 0 ? getAdSource().d : getAdSource().c;
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoReward(d);
        }
    }

    public void d() {
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoCompleted();
        }
    }

    public abstract void e();

    public void f() {
        this.f30174a = false;
        reportRequestShow();
        e();
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onClickedEvent() {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdClick("");
        }
    }

    public void onClosedEvent() {
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdClose();
        }
    }

    @Override // com.fl.saas.AbstractC1423n
    public void onLoadedEvent() {
        this.f30174a = true;
        this.b = System.currentTimeMillis();
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onShowEvent() {
        this.f30174a = false;
        super.onShowEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdShow();
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoPrepared();
        }
    }

    public void b(Activity activity) {
        setContext((Context) activity);
        this.f30174a = false;
        reportRequestShow();
        e();
    }
}
