package com.zj.adlib;

import android.view.MenuItem;
import android.widget.PopupMenu;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class zu6 implements Observable.OnSubscribe<MenuItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PopupMenu f46343a;

    public class a implements PopupMenu.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f21110a;

        public a(Subscriber subscriber) {
            this.f21110a = subscriber;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f21110a.isUnsubscribed()) {
                return true;
            }
            this.f21110a.onNext(menuItem);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            zu6.this.f46343a.setOnMenuItemClickListener(null);
        }
    }

    public zu6(PopupMenu popupMenu) {
        this.f46343a = popupMenu;
    }

    public void call(Subscriber<? super MenuItem> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f46343a.setOnMenuItemClickListener(aVar);
    }
}
