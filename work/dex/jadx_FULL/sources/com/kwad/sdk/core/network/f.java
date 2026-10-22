package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface f {
    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    @Nullable
    SceneImpl getScene();

    String getUrl();
}
