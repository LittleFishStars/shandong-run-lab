package com.zj.adlib;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class r49 implements Observable.OnSubscribe<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f44366a;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19226a;

        public a(Subscriber subscriber) {
            this.f19226a = subscriber;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f19226a.isUnsubscribed()) {
                return;
            }
            this.f19226a.onNext(charSequence);
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextWatcher f44368a;

        public b(TextWatcher textWatcher) {
            this.f44368a = textWatcher;
        }

        public void onUnsubscribe() {
            r49.this.f44366a.removeTextChangedListener(this.f44368a);
        }
    }

    public r49(TextView textView) {
        this.f44366a = textView;
    }

    public void call(Subscriber<? super CharSequence> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f44366a.addTextChangedListener(aVar);
        subscriber.onNext(this.f44366a.getText());
    }
}
