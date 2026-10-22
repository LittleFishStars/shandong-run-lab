package com.zj.adlib;

import android.widget.SearchView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cz7 implements Observable.OnSubscribe<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchView f41073a;

    public class a implements SearchView.OnQueryTextListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15908a;

        public a(Subscriber subscriber) {
            this.f15908a = subscriber;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (this.f15908a.isUnsubscribed()) {
                return false;
            }
            this.f15908a.onNext(str);
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            cz7.this.f41073a.setOnQueryTextListener(null);
        }
    }

    public cz7(SearchView searchView) {
        this.f41073a = searchView;
    }

    public void call(Subscriber<? super CharSequence> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f41073a.setOnQueryTextListener(aVar);
        subscriber.onNext(this.f41073a.getQuery());
    }
}
