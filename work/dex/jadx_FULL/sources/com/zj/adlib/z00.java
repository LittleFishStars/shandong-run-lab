package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class z00 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterView<?> f46149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func0<Boolean> f20948a;

    public class a implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20949a;

        public a(Subscriber subscriber) {
            this.f20949a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!((Boolean) z00.this.f20948a.call()).booleanValue()) {
                return false;
            }
            if (this.f20949a.isUnsubscribed()) {
                return true;
            }
            this.f20949a.onNext(Integer.valueOf(i));
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            z00.this.f46149a.setOnItemLongClickListener(null);
        }
    }

    public z00(AdapterView<?> adapterView, Func0<Boolean> func0) {
        this.f46149a = adapterView;
        this.f20948a = func0;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f46149a.setOnItemLongClickListener(aVar);
    }
}
