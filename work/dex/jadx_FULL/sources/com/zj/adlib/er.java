package com.zj.adlib;

import android.widget.AbsListView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class er implements Observable.OnSubscribe<dr> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsListView f41504a;

    public class a implements AbsListView.OnScrollListener {
        public int K = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f16391a;

        public a(Subscriber subscriber) {
            this.f16391a = subscriber;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f16391a.isUnsubscribed()) {
                return;
            }
            this.f16391a.onNext(dr.b(absListView, this.K, i, i2, i3));
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.K = i;
            if (this.f16391a.isUnsubscribed()) {
                return;
            }
            this.f16391a.onNext(dr.b(absListView, i, absListView.getFirstVisiblePosition(), absListView.getChildCount(), absListView.getCount()));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            er.this.f41504a.setOnScrollListener(null);
        }
    }

    public er(AbsListView absListView) {
        this.f41504a = absListView;
    }

    public void call(Subscriber<? super dr> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f41504a.setOnScrollListener(aVar);
    }
}
