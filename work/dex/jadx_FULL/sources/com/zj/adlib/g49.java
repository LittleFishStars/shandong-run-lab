package com.zj.adlib;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g49 implements Observable.OnSubscribe<f49> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f41818a;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f16701a;

        public a(Subscriber subscriber) {
            this.f16701a = subscriber;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f16701a.isUnsubscribed()) {
                return;
            }
            this.f16701a.onNext(f49.b(g49.this.f41818a, editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextWatcher f41820a;

        public b(TextWatcher textWatcher) {
            this.f41820a = textWatcher;
        }

        public void onUnsubscribe() {
            g49.this.f41818a.removeTextChangedListener(this.f41820a);
        }
    }

    public g49(TextView textView) {
        this.f41818a = textView;
    }

    public void call(Subscriber<? super f49> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f41818a.addTextChangedListener(aVar);
        TextView textView = this.f41818a;
        subscriber.onNext(f49.b(textView, textView.getEditableText()));
    }
}
