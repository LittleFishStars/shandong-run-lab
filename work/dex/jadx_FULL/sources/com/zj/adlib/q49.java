package com.zj.adlib;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q49 implements Observable.OnSubscribe<p49> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f44123a;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19001a;

        public a(Subscriber subscriber) {
            this.f19001a = subscriber;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f19001a.isUnsubscribed()) {
                return;
            }
            this.f19001a.onNext(p49.d(q49.this.f44123a, charSequence, i, i2, i3));
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextWatcher f44125a;

        public b(TextWatcher textWatcher) {
            this.f44125a = textWatcher;
        }

        public void onUnsubscribe() {
            q49.this.f44123a.removeTextChangedListener(this.f44125a);
        }
    }

    public q49(TextView textView) {
        this.f44123a = textView;
    }

    public void call(Subscriber<? super p49> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f44123a.addTextChangedListener(aVar);
        TextView textView = this.f44123a;
        subscriber.onNext(p49.d(textView, textView.getText(), 0, 0, 0));
    }
}
