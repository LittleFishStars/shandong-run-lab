package com.kwad.sdk.service.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public interface f {
    com.kwad.sdk.core.response.helper.g Ai();

    List<AdTemplate> FA();

    String FB();

    JSONObject FC();

    JSONObject FD();

    Map<String, String> FE();

    boolean Fu();

    boolean Fv();

    boolean Fw();

    boolean Fx();

    String Fy();

    com.kwad.sdk.core.b Fz();

    void a(String str, Map<String, String> map, String str2);

    String ax(String str);

    boolean bn(AdTemplate adTemplate);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    String getSDKVersion();

    boolean tr();

    boolean tt();

    boolean tu();
}
