package com.zj.adlib;

import android.widget.RadioGroup;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i97 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RadioGroup f42304a;

    public class a implements RadioGroup.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f17168a;

        public a(Subscriber subscriber) {
            this.f17168a = subscriber;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (this.f17168a.isUnsubscribed()) {
                return;
            }
            this.f17168a.onNext(Integer.valueOf(i));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            i97.this.f42304a.setOnCheckedChangeListener(null);
        }
    }

    public i97(RadioGroup radioGroup) {
        this.f42304a = radioGroup;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f42304a.setOnCheckedChangeListener(aVar);
        subscriber.onNext(Integer.valueOf(this.f42304a.getCheckedRadioButtonId()));
    }
}
