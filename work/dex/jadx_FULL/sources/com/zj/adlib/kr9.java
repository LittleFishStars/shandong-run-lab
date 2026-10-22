package com.zj.adlib;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class kr9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f42895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func0<Boolean> f17778a;

    public class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f17779a;

        public a(Subscriber subscriber) {
            this.f17779a = subscriber;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!((Boolean) kr9.this.f17778a.call()).booleanValue()) {
                return false;
            }
            if (this.f17779a.isUnsubscribed()) {
                return true;
            }
            this.f17779a.onNext((Object) null);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            kr9.this.f42895a.setOnLongClickListener(null);
        }
    }

    public kr9(View view, Func0<Boolean> func0) {
        this.f42895a = view;
        this.f17778a = func0;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f42895a.setOnLongClickListener(aVar);
    }
}
