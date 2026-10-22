package com.facebook.imagepipeline.producers;

import com.zj.adlib.ze3;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseNetworkFetcher<FETCH_STATE extends ze3> implements NetworkFetcher<FETCH_STATE> {
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public boolean c(FETCH_STATE fetch_state) {
        return true;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void d(FETCH_STATE fetch_state, int i) {
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    @Nullable
    public Map<String, String> e(FETCH_STATE fetch_state, int i) {
        return null;
    }
}
