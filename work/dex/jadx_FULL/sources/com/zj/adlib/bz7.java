package com.zj.adlib;

import android.widget.SearchView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bz7 implements Observable.OnSubscribe<dz7> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchView f40869a;

    public class a implements SearchView.OnQueryTextListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15662a;

        public a(Subscriber subscriber) {
            this.f15662a = subscriber;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (this.f15662a.isUnsubscribed()) {
                return false;
            }
            this.f15662a.onNext(dz7.b(bz7.this.f40869a, str, false));
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            if (this.f15662a.isUnsubscribed()) {
                return false;
            }
            Subscriber subscriber = this.f15662a;
            SearchView searchView = bz7.this.f40869a;
            subscriber.onNext(dz7.b(searchView, searchView.getQuery(), true));
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            bz7.this.f40869a.setOnQueryTextListener(null);
        }
    }

    public bz7(SearchView searchView) {
        this.f40869a = searchView;
    }

    public void call(Subscriber<? super dz7> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f40869a.setOnQueryTextListener(aVar);
        SearchView searchView = this.f40869a;
        subscriber.onNext(dz7.b(searchView, searchView.getQuery(), false));
    }
}
