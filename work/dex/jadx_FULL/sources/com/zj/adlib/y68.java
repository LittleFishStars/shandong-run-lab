package com.zj.adlib;

import com.facebook.datasource.AbstractDataSource;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public final class y68<T> extends AbstractDataSource<rm1<T>> {
    public static <V> y68<V> l() {
        return new y68<>();
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public rm1<T> getResult() {
        return rm1.l((rm1) super.getResult());
    }

    public boolean n(@Nullable rm1<T> rm1Var) {
        return super.setResult(rm1.l(rm1Var), true);
    }

    public boolean o(Throwable th) {
        return super.setFailure(th);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float f) {
        return super.setProgress(f);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(@Nullable rm1<T> rm1Var) {
        rm1.p(rm1Var);
    }
}
