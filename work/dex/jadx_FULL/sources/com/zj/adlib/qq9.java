package com.zj.adlib;

import android.view.DragEvent;
import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class qq9 implements Observable.OnSubscribe<DragEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super DragEvent, Boolean> f19164a;

    public class a implements View.OnDragListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19165a;

        public a(Subscriber subscriber) {
            this.f19165a = subscriber;
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            if (!((Boolean) qq9.this.f19164a.call(dragEvent)).booleanValue()) {
                return false;
            }
            if (this.f19165a.isUnsubscribed()) {
                return true;
            }
            this.f19165a.onNext(dragEvent);
            return true;
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            qq9.this.f44280a.setOnDragListener(null);
        }
    }

    public qq9(View view, Func1<? super DragEvent, Boolean> func1) {
        this.f44280a = view;
        this.f19164a = func1;
    }

    public void call(Subscriber<? super DragEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44280a.setOnDragListener(aVar);
    }
}
