package com.zj.adlib;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class qm1<T> extends AbstractProducerToDataSourceAdapter<rm1<T>> {
    public qm1(Producer<rm1<T>> producer, z68 z68Var, RequestListener requestListener) {
        super(producer, z68Var, requestListener);
    }

    public static <T> DataSource<rm1<T>> r(Producer<rm1<T>> producer, z68 z68Var, RequestListener requestListener) {
        return new qm1(producer, z68Var, requestListener);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public rm1<T> getResult() {
        return rm1.l((rm1) super.getResult());
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(rm1<T> rm1Var) {
        rm1.p(rm1Var);
    }

    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public void onNewResultImpl(rm1<T> rm1Var, boolean z) {
        super.onNewResultImpl(rm1.l(rm1Var), z);
    }
}
