package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ResultDataAdapter<T extends CommonOfflineCompoResultData> extends BaseResultData {
    private static final long serialVersionUID = -6920968714292152136L;
    private final T mOfflineCompoResultData;

    public ResultDataAdapter(T t) {
        this.mOfflineCompoResultData = t;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean hasData() {
        return this.mOfflineCompoResultData.hasData();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return this.mOfflineCompoResultData.isDataEmpty();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isResultOk() {
        return this.mOfflineCompoResultData.isResultOk();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean notifyFailOnResultError() {
        return this.mOfflineCompoResultData.notifyFailOnResultError();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        this.mOfflineCompoResultData.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        ac.a(json, this.mOfflineCompoResultData.toJson(), true);
        return json;
    }
}
