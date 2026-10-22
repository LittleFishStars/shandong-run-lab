package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class v00 implements Observable.OnSubscribe<u00> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterView<?> f45260a;

    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20151a;

        public a(Subscriber subscriber) {
            this.f20151a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f20151a.isUnsubscribed()) {
                return;
            }
            this.f20151a.onNext(u00.c(adapterView, view, i, j));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            v00.this.f45260a.setOnItemClickListener(null);
        }
    }

    public v00(AdapterView<?> adapterView) {
        this.f45260a = adapterView;
    }

    public void call(Subscriber<? super u00> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f45260a.setOnItemClickListener(aVar);
    }
}
