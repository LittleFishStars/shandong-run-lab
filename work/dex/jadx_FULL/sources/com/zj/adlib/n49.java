package com.zj.adlib;

import android.view.KeyEvent;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class n49 implements Observable.OnSubscribe<m49> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f43445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super m49, Boolean> f18349a;

    public class a implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f18350a;

        public a(Subscriber subscriber) {
            this.f18350a = subscriber;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            m49 m49VarC = m49.c(textView, i, keyEvent);
            if (!((Boolean) n49.this.f18349a.call(m49VarC)).booleanValue()) {
                return false;
            }
            if (this.f18350a.isUnsubscribed()) {
                return true;
            }
            this.f18350a.onNext(m49VarC);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            n49.this.f43445a.setOnEditorActionListener(null);
        }
    }

    public n49(TextView textView, Func1<? super m49, Boolean> func1) {
        this.f43445a = textView;
        this.f18349a = func1;
    }

    public void call(Subscriber<? super m49> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f43445a.setOnEditorActionListener(aVar);
    }
}
