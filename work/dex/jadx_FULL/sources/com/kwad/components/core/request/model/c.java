package com.kwad.components.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements com.kwad.sdk.core.b {
    public long authorId;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "photoId", this.photoId);
        ac.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
        return jSONObject;
    }
}
