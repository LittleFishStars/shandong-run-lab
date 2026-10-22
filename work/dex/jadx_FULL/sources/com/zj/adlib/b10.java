package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b10 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterView<?> f40650a;

    public class a implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15420a;

        public a(Subscriber subscriber) {
            this.f15420a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f15420a.isUnsubscribed()) {
                return;
            }
            this.f15420a.onNext(Integer.valueOf(i));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (this.f15420a.isUnsubscribed()) {
                return;
            }
            this.f15420a.onNext(-1);
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            b10.this.f40650a.setOnItemSelectedListener(null);
        }
    }

    public b10(AdapterView<?> adapterView) {
        this.f40650a = adapterView;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f40650a.setOnItemSelectedListener(aVar);
        subscriber.onNext(Integer.valueOf(this.f40650a.getSelectedItemPosition()));
    }
}
