package com.zj.adlib;

import android.widget.CompoundButton;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class zr1 implements Observable.OnSubscribe<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompoundButton f46324a;

    public class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f21105a;

        public a(Subscriber subscriber) {
            this.f21105a = subscriber;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f21105a.isUnsubscribed()) {
                return;
            }
            this.f21105a.onNext(Boolean.valueOf(z));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            zr1.this.f46324a.setOnCheckedChangeListener(null);
        }
    }

    public zr1(CompoundButton compoundButton) {
        this.f46324a = compoundButton;
    }

    public void call(Subscriber<? super Boolean> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f46324a.setOnCheckedChangeListener(aVar);
        subscriber.onNext(Boolean.valueOf(this.f46324a.isChecked()));
    }
}
