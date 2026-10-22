package com.zj.adlib;

import android.database.DataSetObserver;
import android.widget.Adapter;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class s00<T extends Adapter> implements Observable.OnSubscribe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f44573a;

    public class a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19463a;

        public a(Subscriber subscriber) {
            this.f19463a = subscriber;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.f19463a.isUnsubscribed()) {
                return;
            }
            this.f19463a.onNext(s00.this.f44573a);
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSetObserver f44575a;

        public b(DataSetObserver dataSetObserver) {
            this.f44575a = dataSetObserver;
        }

        public void onUnsubscribe() {
            s00.this.f44573a.unregisterDataSetObserver(this.f44575a);
        }
    }

    public s00(T t) {
        this.f44573a = t;
    }

    public void call(Subscriber<? super T> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f44573a.registerDataSetObserver(aVar);
        subscriber.onNext(this.f44573a);
    }
}
