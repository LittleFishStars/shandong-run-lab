package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class w00 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterView<?> f45496a;

    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20354a;

        public a(Subscriber subscriber) {
            this.f20354a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f20354a.isUnsubscribed()) {
                return;
            }
            this.f20354a.onNext(Integer.valueOf(i));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            w00.this.f45496a.setOnItemClickListener(null);
        }
    }

    public w00(AdapterView<?> adapterView) {
        this.f45496a = adapterView;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f45496a.setOnItemClickListener(aVar);
    }
}
