package com.zj.adlib;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class v07<T> extends AbstractProducerToDataSourceAdapter<T> {
    public v07(Producer<T> producer, z68 z68Var, RequestListener requestListener) {
        super(producer, z68Var, requestListener);
    }

    public static <T> DataSource<T> r(Producer<T> producer, z68 z68Var, RequestListener requestListener) {
        return new v07(producer, z68Var, requestListener);
    }
}
