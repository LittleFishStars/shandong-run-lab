package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNormalNetworking;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class NormalNetworkingAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> extends m<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final OfflineCompoNormalNetworking<R, T> mOfflineCompoNetworking;

    public NormalNetworkingAdapter(@NonNull OfflineCompoNormalNetworking<R, T> offlineCompoNormalNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNormalNetworking;
    }

    @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    public NormalRequestAdapter<R> createRequest() {
        final R rCreateRequest = this.mOfflineCompoNetworking.createRequest();
        return (NormalRequestAdapter<R>) new NormalRequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NormalNetworkingAdapter.1
            @Override // com.kwad.sdk.core.network.f
            public JSONObject getBody() {
                return rCreateRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.f
            public Map<String, String> getBodyMap() {
                return rCreateRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.f
            public Map<String, String> getHeader() {
                return rCreateRequest.getHeader();
            }

            @Override // com.kwad.sdk.core.network.n
            public String getMethod() {
                return rCreateRequest.getMethod();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.NormalRequestAdapter
            public R getOfflineCompoRequest() {
                return (R) rCreateRequest;
            }

            @Override // com.kwad.sdk.core.network.f
            @Nullable
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.f
            public String getUrl() {
                return rCreateRequest.getUrl();
            }
        };
    }

    @Override // com.kwad.sdk.core.network.m
    public NormalResultDataAdapter<T> createResponseData() {
        return new NormalResultDataAdapter<>(this.mOfflineCompoNetworking.createResponseData());
    }
}
