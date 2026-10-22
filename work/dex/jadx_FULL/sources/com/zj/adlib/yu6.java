package com.zj.adlib;

import android.widget.PopupMenu;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class yu6 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PopupMenu f46119a;

    public class a implements PopupMenu.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f20931a;

        public a(Subscriber subscriber) {
            this.f20931a = subscriber;
        }

        @Override // android.widget.PopupMenu.OnDismissListener
        public void onDismiss(PopupMenu popupMenu) {
            if (this.f20931a.isUnsubscribed()) {
                return;
            }
            this.f20931a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            yu6.this.f46119a.setOnDismissListener(null);
        }
    }

    public yu6(PopupMenu popupMenu) {
        this.f46119a = popupMenu;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f46119a.setOnDismissListener(aVar);
    }
}
