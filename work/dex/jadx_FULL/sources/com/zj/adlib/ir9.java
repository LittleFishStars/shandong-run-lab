package com.zj.adlib;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ir9 implements Observable.OnSubscribe<hr9> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f42428a;

    public class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f17258a;

        public a(Subscriber subscriber) {
            this.f17258a = subscriber;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f17258a.isUnsubscribed()) {
                return;
            }
            this.f17258a.onNext(hr9.c(ir9.this.f42428a, i, i2, i3, i4, i5, i6, i7, i8));
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f42430a;

        public b(View.OnLayoutChangeListener onLayoutChangeListener) {
            this.f42430a = onLayoutChangeListener;
        }

        public void onUnsubscribe() {
            ir9.this.f42428a.removeOnLayoutChangeListener(this.f42430a);
        }
    }

    public ir9(View view) {
        this.f42428a = view;
    }

    public void call(Subscriber<? super hr9> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f42428a.addOnLayoutChangeListener(aVar);
    }
}
