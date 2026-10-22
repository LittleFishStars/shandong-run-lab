package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends com.kwad.sdk.core.network.b {

    @NonNull
    public final Map<String, String> bfP;

    public c(String str, String str2, String str3) {
        HashMap map = new HashMap();
        this.bfP = map;
        map.put("did", str);
        map.put(LoginConstants.SID, str2);
        map.put("fileExtend", str3);
        map.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.bfP;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.Mo().Z("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
