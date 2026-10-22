package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import com.acse.ottn.io.reactivex.annotations.Nullable;
import com.acse.ottn.io.reactivex.disposables.Disposable;
import com.acse.ottn.io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean isDisposed();

    @NonNull
    ObservableEmitter<T> serialize();

    void setCancellable(@Nullable Cancellable cancellable);

    void setDisposable(@Nullable Disposable disposable);

    boolean tryOnError(@NonNull Throwable th);
}
