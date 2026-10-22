package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ThreadInfo implements b, Serializable {
    private static final long serialVersionUID = -1743841938230203418L;
    public int mIndex;
    public String mJavaBacktrace;
    public String mName;
    public String mNativeBacktrace;
    public int mTid;
    public String mTrace;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mName = jSONObject.optString("mName");
        this.mTrace = jSONObject.optString("mTrace");
        this.mJavaBacktrace = jSONObject.optString("mJavaBacktrace");
        this.mNativeBacktrace = jSONObject.optString("mNativeBacktrace");
        this.mTid = jSONObject.optInt("mTid");
        this.mIndex = jSONObject.optInt("mIndex");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "mName", this.mName);
        ac.putValue(jSONObject, "mTrace", this.mTrace);
        ac.putValue(jSONObject, "mJavaBacktrace", this.mJavaBacktrace);
        ac.putValue(jSONObject, "mNativeBacktrace", this.mNativeBacktrace);
        ac.putValue(jSONObject, "mTid", this.mTid);
        ac.putValue(jSONObject, "mIndex", this.mIndex);
        return jSONObject;
    }
}
