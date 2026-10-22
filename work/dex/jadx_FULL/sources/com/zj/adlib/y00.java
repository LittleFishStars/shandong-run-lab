package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class y00 implements Observable.OnSubscribe<x00> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterView<?> f45928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super x00, Boolean> f20757a;

    public class a implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20758a;

        public a(Subscriber subscriber) {
            this.f20758a = subscriber;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            x00 x00VarC = x00.c(adapterView, view, i, j);
            if (!((Boolean) y00.this.f20757a.call(x00VarC)).booleanValue()) {
                return false;
            }
            if (this.f20758a.isUnsubscribed()) {
                return true;
            }
            this.f20758a.onNext(x00VarC);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            y00.this.f45928a.setOnItemLongClickListener(null);
        }
    }

    public y00(AdapterView<?> adapterView, Func1<? super x00, Boolean> func1) {
        this.f45928a = adapterView;
        this.f20757a = func1;
    }

    public void call(Subscriber<? super x00> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f45928a.setOnItemLongClickListener(aVar);
    }
}
