package com.kwad.components.offline.api.core.model;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineCompoJsonParse {
    void parseJson(@Nullable JSONObject jSONObject);

    JSONObject toJson();
}
