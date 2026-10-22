package com.zj.adlib;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewTreeObserver;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(16)
public final class vr9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f45432a;

    public class a implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20291a;

        public a(Subscriber subscriber) {
            this.f20291a = subscriber;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (this.f20291a.isUnsubscribed()) {
                return;
            }
            this.f20291a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnDrawListener f45434a;

        public b(ViewTreeObserver.OnDrawListener onDrawListener) {
            this.f45434a = onDrawListener;
        }

        public void onUnsubscribe() {
            vr9.this.f45432a.getViewTreeObserver().removeOnDrawListener(this.f45434a);
        }
    }

    public vr9(View view) {
        this.f45432a = view;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f45432a.getViewTreeObserver().addOnDrawListener(aVar);
    }
}
