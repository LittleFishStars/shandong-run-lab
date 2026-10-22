package com.zj.adlib;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class tr9 implements Observable.OnSubscribe<MotionEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super MotionEvent, Boolean> f19890a;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19891a;

        public a(Subscriber subscriber) {
            this.f19891a = subscriber;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
            if (!((Boolean) tr9.this.f19890a.call(motionEvent)).booleanValue()) {
                return false;
            }
            if (this.f19891a.isUnsubscribed()) {
                return true;
            }
            this.f19891a.onNext(motionEvent);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            tr9.this.f44993a.setOnTouchListener(null);
        }
    }

    public tr9(View view, Func1<? super MotionEvent, Boolean> func1) {
        this.f44993a = view;
        this.f19890a = func1;
    }

    public void call(Subscriber<? super MotionEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44993a.setOnTouchListener(aVar);
    }
}
