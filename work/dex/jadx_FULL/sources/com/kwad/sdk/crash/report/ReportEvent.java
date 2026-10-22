package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    public static class CustomStatEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString(CachedContentIndex.a.e);
            this.value = jSONObject.optString("value");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, CachedContentIndex.a.e, this.key);
            ac.putValue(jSONObject, "value", this.value);
            return jSONObject;
        }
    }

    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "type", this.type);
            ac.putValue(jSONObject, "message", this.message);
            ac.a(jSONObject, "urlPackage", this.urlPackage);
            ac.putValue(jSONObject, "flag", this.flag);
            return jSONObject;
        }
    }

    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            ac.a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString(HlsPlaylistParser.V);
            this.pageType = jSONObject.optInt(RVConstants.EXTRA_PAGETYPE);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "page", this.page);
            ac.putValue(jSONObject, "params", this.params);
            ac.putValue(jSONObject, HlsPlaylistParser.V, this.identity);
            ac.putValue(jSONObject, RVConstants.EXTRA_PAGETYPE, this.pageType);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString(RVParams.SESSION_ID);
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        ac.putValue(jSONObject, "clientIncrementId", this.clientIncrementId);
        ac.putValue(jSONObject, RVParams.SESSION_ID, this.sessionId);
        ac.a(jSONObject, "statPackage", this.statPackage);
        ac.putValue(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
