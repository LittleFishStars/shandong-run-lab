package com.facebook.imagepipeline.producers;

import com.zj.adlib.q13;
import com.zj.adlib.ze3;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NetworkFetcher<FETCH_STATE extends ze3> {

    public interface Callback {
        void a();

        void b(InputStream inputStream, int i) throws IOException;

        void onFailure(Throwable th);
    }

    FETCH_STATE a(Consumer<q13> consumer, ProducerContext producerContext);

    void b(FETCH_STATE fetch_state, Callback callback);

    boolean c(FETCH_STATE fetch_state);

    void d(FETCH_STATE fetch_state, int i);

    @Nullable
    Map<String, String> e(FETCH_STATE fetch_state, int i);
}
