package com.zj.adlib;

import android.view.MenuItem;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class yl5 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem f46057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super MenuItem, Boolean> f20879a;

    public class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20880a;

        public a(Subscriber subscriber) {
            this.f20880a = subscriber;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            yl5 yl5Var = yl5.this;
            if (!((Boolean) yl5Var.f20879a.call(yl5Var.f46057a)).booleanValue()) {
                return false;
            }
            if (this.f20880a.isUnsubscribed()) {
                return true;
            }
            this.f20880a.onNext((Object) null);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            yl5.this.f46057a.setOnMenuItemClickListener(null);
        }
    }

    public yl5(MenuItem menuItem, Func1<? super MenuItem, Boolean> func1) {
        this.f46057a = menuItem;
        this.f20879a = func1;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f46057a.setOnMenuItemClickListener(aVar);
    }
}
