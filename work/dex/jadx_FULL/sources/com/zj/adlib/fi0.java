package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fi0 implements Observable.OnSubscribe<u00> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoCompleteTextView f41680a;

    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f16530a;

        public a(Subscriber subscriber) {
            this.f16530a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f16530a.isUnsubscribed()) {
                return;
            }
            this.f16530a.onNext(u00.c(adapterView, view, i, j));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            fi0.this.f41680a.setOnItemClickListener(null);
        }
    }

    public fi0(AutoCompleteTextView autoCompleteTextView) {
        this.f41680a = autoCompleteTextView;
    }

    public void call(Subscriber<? super u00> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f41680a.setOnItemClickListener(aVar);
    }
}
