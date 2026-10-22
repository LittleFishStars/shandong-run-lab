package com.zj.adlib;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding.view.ViewGroupHierarchyChangeEvent;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class uq9 implements Observable.OnSubscribe<ViewGroupHierarchyChangeEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f45208a;

    public class a implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20122a;

        public a(Subscriber subscriber) {
            this.f20122a = subscriber;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (this.f20122a.isUnsubscribed()) {
                return;
            }
            this.f20122a.onNext(vq9.c((ViewGroup) view, view2));
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (this.f20122a.isUnsubscribed()) {
                return;
            }
            this.f20122a.onNext(wq9.c((ViewGroup) view, view2));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            uq9.this.f45208a.setOnHierarchyChangeListener(null);
        }
    }

    public uq9(ViewGroup viewGroup) {
        this.f45208a = viewGroup;
    }

    public void call(Subscriber<? super ViewGroupHierarchyChangeEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f45208a.setOnHierarchyChangeListener(aVar);
    }
}
