package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ObservableTransformer<Upstream, Downstream> extends Observable.Transformer<Upstream, Downstream> {
    @NonNull
    Observable<Downstream> apply(@NonNull Observable<Upstream> observable);

    default Observable<Downstream> call(Observable<Upstream> observable) {
        return apply(observable);
    }
}
