package com.kwad.sdk.collector.a;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.i;
import com.kwad.sdk.utils.ac;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends d {
    private C1268a aJh;

    /* JADX INFO: renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    public static class C1268a {
        private List<String> aJi;

        public C1268a(List<String> list) {
            this.aJi = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, this.aJi);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C1268a c1268a = new C1268a(list);
        this.aJh = c1268a;
        putBody("targetAppInfo", c1268a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.EU();
    }
}
