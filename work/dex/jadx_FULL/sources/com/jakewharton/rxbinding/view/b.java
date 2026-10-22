package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements Observable.OnSubscribe<ViewAttachEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f38637a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15002a;

        public a(Subscriber subscriber) {
            this.f15002a = subscriber;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            if (this.f15002a.isUnsubscribed()) {
                return;
            }
            this.f15002a.onNext(ViewAttachEvent.b(b.this.f38637a, ViewAttachEvent.Kind.ATTACH));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NonNull View view) {
            if (this.f15002a.isUnsubscribed()) {
                return;
            }
            this.f15002a.onNext(ViewAttachEvent.b(b.this.f38637a, ViewAttachEvent.Kind.DETACH));
        }
    }

    /* JADX INFO: renamed from: com.jakewharton.rxbinding.view.b$b, reason: collision with other inner class name */
    public class C0934b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnAttachStateChangeListener f38639a;

        public C0934b(View.OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f38639a = onAttachStateChangeListener;
        }

        public void onUnsubscribe() {
            b.this.f38637a.removeOnAttachStateChangeListener(this.f38639a);
        }
    }

    public b(View view) {
        this.f38637a = view;
    }

    public void call(Subscriber<? super ViewAttachEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new C0934b(aVar));
        this.f38637a.addOnAttachStateChangeListener(aVar);
    }
}
