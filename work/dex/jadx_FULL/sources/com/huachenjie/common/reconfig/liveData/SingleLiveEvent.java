package com.huachenjie.common.reconfig.liveData;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class SingleLiveEvent<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f33854a = "SingleLiveEvent";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f8831a = new AtomicBoolean(false);

    public class a implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observer f33855a;

        public a(final Observer val$observer) {
            this.f33855a = val$observer;
        }

        @Override // androidx.p002lifecycle.Observer
        public void onChanged(@Nullable T t) {
            if (SingleLiveEvent.this.f8831a.compareAndSet(true, false)) {
                this.f33855a.onChanged(t);
            }
        }
    }

    public void b() {
        this.f8831a.set(true);
        postValue(null);
    }

    @MainThread
    public void call() {
        setValue(null);
    }

    @Override // androidx.p002lifecycle.LiveData
    @MainThread
    public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w(f33854a, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(owner, new a(observer));
    }

    @Override // androidx.p002lifecycle.MutableLiveData, androidx.p002lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t) {
        this.f8831a.set(true);
        super.setValue(t);
    }
}
