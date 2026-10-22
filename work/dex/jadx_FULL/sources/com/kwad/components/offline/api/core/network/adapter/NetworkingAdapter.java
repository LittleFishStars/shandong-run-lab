package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class NetworkingAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> extends l<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final OfflineCompoNetworking<R, T> mOfflineCompoNetworking;

    public NetworkingAdapter(@NonNull OfflineCompoNetworking<R, T> offlineCompoNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNetworking;
    }

    @Override // com.kwad.sdk.core.network.l
    public boolean enableMonitorReport() {
        return this.mOfflineCompoNetworking.enableMonitorReport();
    }

    @Override // com.kwad.sdk.core.network.l
    public boolean isPostByJson() {
        return this.mOfflineCompoNetworking.isPostByJson();
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    public RequestAdapter<R> createRequest() {
        final R rCreateRequest = this.mOfflineCompoNetworking.createRequest();
        return (RequestAdapter<R>) new RequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter.1
            @Override // com.kwad.sdk.core.network.b
            public boolean encryptDisable() {
                return rCreateRequest.encryptDisable();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
            public JSONObject getBody() {
                return rCreateRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
            public Map<String, String> getBodyMap() {
                return rCreateRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
            public Map<String, String> getHeader() {
                return rCreateRequest.getHeader();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.RequestAdapter
            public R getOfflineCompoRequest() {
                return (R) rCreateRequest;
            }

            @Override // com.kwad.sdk.core.network.b
            public String getRequestHost() {
                return rCreateRequest.getRequestHost();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
            @Nullable
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
            public String getUrl() {
                return rCreateRequest.getUrl();
            }
        };
    }

    @Override // com.kwad.sdk.core.network.l, com.kwad.sdk.core.network.a
    public void onResponse(RequestAdapter<R> requestAdapter, c cVar) {
        super.onResponse(requestAdapter, cVar);
        this.mOfflineCompoNetworking.onResponse(requestAdapter.getOfflineCompoRequest(), cVar);
    }

    @Override // com.kwad.sdk.core.network.l
    @NonNull
    public ResultDataAdapter<T> parseData(String str) {
        return new ResultDataAdapter<>(this.mOfflineCompoNetworking.parseData(str));
    }
}
