package com.zj.adlib;

import android.view.View;
import android.view.ViewTreeObserver;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class xr9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f45886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func0<Boolean> f20716a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20717a;

        public a(Subscriber subscriber) {
            this.f20717a = subscriber;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f20717a.isUnsubscribed()) {
                return true;
            }
            this.f20717a.onNext((Object) null);
            return ((Boolean) xr9.this.f20716a.call()).booleanValue();
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnPreDrawListener f45888a;

        public b(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            this.f45888a = onPreDrawListener;
        }

        public void onUnsubscribe() {
            xr9.this.f45886a.getViewTreeObserver().removeOnPreDrawListener(this.f45888a);
        }
    }

    public xr9(View view, Func0<Boolean> func0) {
        this.f45886a = view;
        this.f20716a = func0;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f45886a.getViewTreeObserver().addOnPreDrawListener(aVar);
    }
}
