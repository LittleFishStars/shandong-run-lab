package com.zj.adlib;

import android.widget.SeekBar;
import com.jakewharton.rxbinding.widget.SeekBarChangeEvent;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class r38 implements Observable.OnSubscribe<SeekBarChangeEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SeekBar f44356a;

    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19224a;

        public a(Subscriber subscriber) {
            this.f19224a = subscriber;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (this.f19224a.isUnsubscribed()) {
                return;
            }
            this.f19224a.onNext(t38.b(seekBar, i, z));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (this.f19224a.isUnsubscribed()) {
                return;
            }
            this.f19224a.onNext(u38.b(seekBar));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (this.f19224a.isUnsubscribed()) {
                return;
            }
            this.f19224a.onNext(v38.b(seekBar));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            r38.this.f44356a.setOnSeekBarChangeListener(null);
        }
    }

    public r38(SeekBar seekBar) {
        this.f44356a = seekBar;
    }

    public void call(Subscriber<? super SeekBarChangeEvent> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44356a.setOnSeekBarChangeListener(aVar);
        SeekBar seekBar = this.f44356a;
        subscriber.onNext(t38.b(seekBar, seekBar.getProgress(), false));
    }
}
