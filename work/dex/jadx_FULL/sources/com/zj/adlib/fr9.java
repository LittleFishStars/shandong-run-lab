package com.zj.adlib;

import android.view.KeyEvent;
import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fr9 implements Observable.OnSubscribe<KeyEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f41743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super KeyEvent, Boolean> f16608a;

    public class a implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f16609a;

        public a(Subscriber subscriber) {
            this.f16609a = subscriber;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (this.f16609a.isUnsubscribed() || !((Boolean) fr9.this.f16608a.call(keyEvent)).booleanValue()) {
                return false;
            }
            this.f16609a.onNext(keyEvent);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            fr9.this.f41743a.setOnKeyListener(null);
        }
    }

    public fr9(View view, Func1<? super KeyEvent, Boolean> func1) {
        this.f41743a = view;
        this.f16608a = func1;
    }

    public void call(Subscriber<? super KeyEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f41743a.setOnKeyListener(aVar);
    }
}
