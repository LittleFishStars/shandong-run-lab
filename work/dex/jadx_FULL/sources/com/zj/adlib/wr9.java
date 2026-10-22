package com.zj.adlib;

import android.view.View;
import android.view.ViewTreeObserver;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class wr9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f45672a;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20512a;

        public a(Subscriber subscriber) {
            this.f20512a = subscriber;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f20512a.isUnsubscribed()) {
                return;
            }
            this.f20512a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f45674a;

        public b(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.f45674a = onGlobalLayoutListener;
        }

        public void onUnsubscribe() {
            wr9.this.f45672a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f45674a);
        }
    }

    public wr9(View view) {
        this.f45672a = view;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f45672a.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
    }
}
