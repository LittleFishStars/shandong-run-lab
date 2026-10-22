package com.zj.adlib;

import android.widget.SeekBar;
import androidx.annotation.Nullable;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class s38 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SeekBar f44599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Boolean f19505a;

    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19506a;

        public a(Subscriber subscriber) {
            this.f19506a = subscriber;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (this.f19506a.isUnsubscribed()) {
                return;
            }
            Boolean bool = s38.this.f19505a;
            if (bool == null || bool.booleanValue() == z) {
                this.f19506a.onNext(Integer.valueOf(i));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            s38.this.f44599a.setOnSeekBarChangeListener(null);
        }
    }

    public s38(SeekBar seekBar, @Nullable Boolean bool) {
        this.f44599a = seekBar;
        this.f19505a = bool;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44599a.setOnSeekBarChangeListener(aVar);
        subscriber.onNext(Integer.valueOf(this.f44599a.getProgress()));
    }
}
