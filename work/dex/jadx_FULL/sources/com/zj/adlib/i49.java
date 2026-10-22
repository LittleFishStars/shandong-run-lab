package com.zj.adlib;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i49 implements Observable.OnSubscribe<h49> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f42278a;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f17143a;

        public a(Subscriber subscriber) {
            this.f17143a = subscriber;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f17143a.isUnsubscribed()) {
                return;
            }
            this.f17143a.onNext(h49.d(i49.this.f42278a, charSequence, i, i2, i3));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextWatcher f42280a;

        public b(TextWatcher textWatcher) {
            this.f42280a = textWatcher;
        }

        public void onUnsubscribe() {
            i49.this.f42278a.removeTextChangedListener(this.f42280a);
        }
    }

    public i49(TextView textView) {
        this.f42278a = textView;
    }

    public void call(Subscriber<? super h49> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f42278a.addTextChangedListener(aVar);
        TextView textView = this.f42278a;
        subscriber.onNext(h49.d(textView, textView.getText(), 0, 0, 0));
    }
}
