package com.zj.adlib;

import android.annotation.TargetApi;
import android.view.MenuItem;
import android.widget.Toolbar;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(21)
public final class u89 implements Observable.OnSubscribe<MenuItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f45088a;

    public class a implements Toolbar.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20006a;

        public a(Subscriber subscriber) {
            this.f20006a = subscriber;
        }

        @Override // android.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f20006a.isUnsubscribed()) {
                return true;
            }
            this.f20006a.onNext(menuItem);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            u89.this.f45088a.setOnMenuItemClickListener(null);
        }
    }

    public u89(Toolbar toolbar) {
        this.f45088a = toolbar;
    }

    public void call(Subscriber<? super MenuItem> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f45088a.setOnMenuItemClickListener(aVar);
    }
}
