package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding.widget.AdapterViewSelectionEvent;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d10 implements Observable.OnSubscribe<AdapterViewSelectionEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterView<?> f41081a;

    public class a implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15910a;

        public a(Subscriber subscriber) {
            this.f15910a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f15910a.isUnsubscribed()) {
                return;
            }
            this.f15910a.onNext(a10.b(adapterView, view, i, j));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (this.f15910a.isUnsubscribed()) {
                return;
            }
            this.f15910a.onNext(c10.b(adapterView));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            d10.this.f41081a.setOnItemSelectedListener(null);
        }
    }

    public d10(AdapterView<?> adapterView) {
        this.f41081a = adapterView;
    }

    public void call(Subscriber<? super AdapterViewSelectionEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f41081a.setOnItemSelectedListener(aVar);
        int selectedItemPosition = this.f41081a.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            subscriber.onNext(c10.b(this.f41081a));
            return;
        }
        subscriber.onNext(a10.b(this.f41081a, this.f41081a.getSelectedView(), selectedItemPosition, this.f41081a.getSelectedItemId()));
    }
}
