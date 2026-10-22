package com.kwad.components.ad.a;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.core.network.b {
    public b(String str, List<String> list) {
        putBody("adxId", str);
        putBody("materialIds", new JSONArray((Collection) list));
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((f) ServiceProvider.get(f.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((f) ServiceProvider.get(f.class)).getApiVersionCode());
        putBody(UserTrackConstant.SDK_TYPE, 1);
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
        if (com.kwad.framework.a.a.pe.booleanValue()) {
            d.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.EP();
    }
}
