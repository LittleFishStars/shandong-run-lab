package com.zj.adlib;

import android.view.KeyEvent;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class o49 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f43668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super Integer, Boolean> f18562a;

    public class a implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f18563a;

        public a(Subscriber subscriber) {
            this.f18563a = subscriber;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (!((Boolean) o49.this.f18562a.call(Integer.valueOf(i))).booleanValue()) {
                return false;
            }
            if (this.f18563a.isUnsubscribed()) {
                return true;
            }
            this.f18563a.onNext(Integer.valueOf(i));
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            o49.this.f43668a.setOnEditorActionListener(null);
        }
    }

    public o49(TextView textView, Func1<? super Integer, Boolean> func1) {
        this.f43668a = textView;
        this.f18562a = func1;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f43668a.setOnEditorActionListener(aVar);
    }
}
