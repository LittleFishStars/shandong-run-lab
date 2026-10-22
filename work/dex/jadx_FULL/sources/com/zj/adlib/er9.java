package com.zj.adlib;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class er9 implements Observable.OnSubscribe<MotionEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f41511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super MotionEvent, Boolean> f16396a;

    public class a implements View.OnHoverListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f16397a;

        public a(Subscriber subscriber) {
            this.f16397a = subscriber;
        }

        @Override // android.view.View.OnHoverListener
        public boolean onHover(View view, @NonNull MotionEvent motionEvent) {
            if (!((Boolean) er9.this.f16396a.call(motionEvent)).booleanValue()) {
                return false;
            }
            if (this.f16397a.isUnsubscribed()) {
                return true;
            }
            this.f16397a.onNext(motionEvent);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            er9.this.f41511a.setOnHoverListener(null);
        }
    }

    public er9(View view, Func1<? super MotionEvent, Boolean> func1) {
        this.f41511a = view;
        this.f16396a = func1;
    }

    public void call(Subscriber<? super MotionEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f41511a.setOnHoverListener(aVar);
    }
}
