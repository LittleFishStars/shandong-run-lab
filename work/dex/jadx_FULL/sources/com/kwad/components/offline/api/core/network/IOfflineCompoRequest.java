package com.kwad.components.offline.api.core.network;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineCompoRequest {
    boolean encryptDisable();

    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getMethod();

    String getRequestHost();

    @Nullable
    KsScene getScene();

    String getUrl();
}
