package com.zj.adlib;

import android.view.View;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class rp9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19394a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19395a;

        public a(Subscriber subscriber) {
            this.f19395a = subscriber;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            if (!rp9.this.f19394a || this.f19395a.isUnsubscribed()) {
                return;
            }
            this.f19395a.onNext((Object) null);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NonNull View view) {
            if (rp9.this.f19394a || this.f19395a.isUnsubscribed()) {
                return;
            }
            this.f19395a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnAttachStateChangeListener f44509a;

        public b(View.OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f44509a = onAttachStateChangeListener;
        }

        public void onUnsubscribe() {
            rp9.this.f44507a.removeOnAttachStateChangeListener(this.f44509a);
        }
    }

    public rp9(View view, boolean z) {
        this.f44507a = view;
        this.f19394a = z;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f44507a.addOnAttachStateChangeListener(aVar);
    }
}
