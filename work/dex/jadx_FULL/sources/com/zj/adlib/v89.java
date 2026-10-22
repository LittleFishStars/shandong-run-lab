package com.zj.adlib;

import android.annotation.TargetApi;
import android.view.View;
import android.widget.Toolbar;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(21)
public final class v89 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f45306a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20193a;

        public a(Subscriber subscriber) {
            this.f20193a = subscriber;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f20193a.isUnsubscribed()) {
                return;
            }
            this.f20193a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            v89.this.f45306a.setNavigationOnClickListener(null);
        }
    }

    public v89(Toolbar toolbar) {
        this.f45306a = toolbar;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f45306a.setNavigationOnClickListener(aVar);
    }
}
