package com.kwad.sdk.resourceCache.model;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.br;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Keep
public class WarmUpResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -3822162279240949932L;
    public boolean cleanResourceWarmup;
    public boolean disableFontWarmup;
    public boolean disableImageWarmup;
    public boolean disableResourceWarmup;
    public boolean disableVideoWarmup;
    public boolean disableZipWarmup;
    public int minWarmupDiskSize;
    public WarmupVideos warmupVideos = new WarmupVideos();
    public WarmupImages warmupImages = new WarmupImages();
    public WarmupZips warmupZips = new WarmupZips();

    public static class ResourceItem implements b, Serializable {
        private static final long serialVersionUID = 7792858892044915778L;
        public String cachePath;
        public double downloadSize;
        public long endTime;
        public String md5;
        public int priority;
        public String resourceKey;
        public String url;
        public String zipDir;
        public boolean isCached = false;
        public boolean isZip = false;
        public HashMap<String, String> md5FileMap = new HashMap<>();

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.resourceKey = jSONObject.optString("resourceKey");
            this.priority = jSONObject.optInt("priority");
            this.downloadSize = jSONObject.optDouble("downloadSize", AudioStats.AUDIO_AMPLITUDE_NONE);
            this.url = jSONObject.optString("url");
            this.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.endTime = jSONObject.optLong("endTime");
            this.cachePath = jSONObject.optString("cachePath");
            this.isCached = jSONObject.optBoolean("isCached");
            this.isZip = jSONObject.optBoolean("isZip");
            this.zipDir = jSONObject.optString("zipDir");
            try {
                if (jSONObject.optString("md5FileMap").isEmpty()) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("md5FileMap"));
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.md5FileMap.put(next, jSONObject2.getString(next));
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                if (a.pe.booleanValue()) {
                    c.printStackTrace(th);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "resourceKey", this.resourceKey);
            ac.putValue(jSONObject, "priority", this.priority);
            ac.putValue(jSONObject, "downloadSize", this.downloadSize);
            ac.putValue(jSONObject, "url", this.url);
            ac.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, this.md5);
            ac.putValue(jSONObject, "endTime", this.endTime);
            ac.putValue(jSONObject, "cachePath", this.cachePath);
            ac.putValue(jSONObject, "isCached", this.isCached);
            ac.putValue(jSONObject, "isZip", this.isZip);
            ac.putValue(jSONObject, "zipDir", this.zipDir);
            try {
                ac.putValue(jSONObject, "md5FileMap", new JSONObject(this.md5FileMap).toString());
            } catch (Throwable th) {
                if (a.pe.booleanValue()) {
                    c.printStackTrace(th);
                }
            }
            return jSONObject;
        }
    }

    public static class WarmupImages implements b, Serializable {
        private static final long serialVersionUID = 9116421028365391209L;
        public ArrayList<ResourceItem> images = new ArrayList<>();

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            JSONArray jSONArrayOptJSONArray;
            if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("images")) == null) {
                return;
            }
            this.images.clear();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ResourceItem resourceItem = new ResourceItem();
                resourceItem.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                this.images.add(resourceItem);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<ResourceItem> it = this.images.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            ac.putValue(jSONObject, "images", jSONArray);
            return jSONObject;
        }
    }

    public static class WarmupVideos implements b, Serializable {
        private static final long serialVersionUID = -5397366224830219648L;
        public ArrayList<ResourceItem> videos = new ArrayList<>();
        public boolean wifiOnly;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.wifiOnly = jSONObject.optBoolean("wifiOnly");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("videos");
            if (jSONArrayOptJSONArray != null) {
                this.videos.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    ResourceItem resourceItem = new ResourceItem();
                    resourceItem.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                    this.videos.add(resourceItem);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<ResourceItem> it = this.videos.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            ac.putValue(jSONObject, "wifiOnly", this.wifiOnly);
            ac.putValue(jSONObject, "videos", jSONArray);
            return jSONObject;
        }
    }

    public static class WarmupZips implements b, Serializable {
        private static final long serialVersionUID = 6198220122324956576L;
        public boolean wifiOnly;
        public ArrayList<ResourceItem> zips = new ArrayList<>();
        public ArrayList<ResourceItem> fontZips = new ArrayList<>();

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.wifiOnly = jSONObject.optBoolean("wifiOnly");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("zips");
            if (jSONArrayOptJSONArray != null) {
                this.zips.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    ResourceItem resourceItem = new ResourceItem();
                    resourceItem.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                    this.zips.add(resourceItem);
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("fontZips");
            if (jSONArrayOptJSONArray2 != null) {
                this.fontZips.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    ResourceItem resourceItem2 = new ResourceItem();
                    resourceItem2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                    this.fontZips.add(resourceItem2);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            ac.putValue(jSONObject, "wifiOnly", this.wifiOnly);
            Iterator<ResourceItem> it = this.zips.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            ac.putValue(jSONObject, "zips", jSONArray);
            Iterator<ResourceItem> it2 = this.fontZips.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().toJson());
            }
            ac.putValue(jSONObject, "fontZips", jSONArray2);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("data");
        e eVar = (e) d.f(e.class);
        if (br.isNullString(strOptString)) {
            return;
        }
        String responseData = eVar.getResponseData(strOptString);
        if (TextUtils.isEmpty(responseData)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.disableResourceWarmup = jSONObject2.optBoolean("disableResourceWarmup");
            this.disableVideoWarmup = jSONObject2.optBoolean("disableVideoWarmup");
            this.disableImageWarmup = jSONObject2.optBoolean("disableImageWarmup");
            this.disableZipWarmup = jSONObject2.optBoolean("disableZipWarmup");
            this.disableFontWarmup = jSONObject2.optBoolean("disableFontWarmup");
            this.minWarmupDiskSize = jSONObject2.optInt("minWarmupDiskSize");
            this.cleanResourceWarmup = jSONObject2.optBoolean("cleanResourceWarmup");
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("warmupVideos");
            if (jSONObjectOptJSONObject != null) {
                this.warmupVideos.parseJson(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("warmupImages");
            if (jSONObjectOptJSONObject2 != null) {
                this.warmupImages.parseJson(jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("warmupZips");
            if (jSONObjectOptJSONObject3 != null) {
                this.warmupZips.parseJson(jSONObjectOptJSONObject3);
            }
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        ac.putValue(json, "result", this.result);
        ac.putValue(json, "disableResourceWarmup", this.disableResourceWarmup);
        ac.putValue(json, "disableVideoWarmup", this.disableVideoWarmup);
        ac.putValue(json, "disableImageWarmup", this.disableImageWarmup);
        ac.putValue(json, "disableZipWarmup", this.disableZipWarmup);
        ac.putValue(json, "disableFontWarmup", this.disableFontWarmup);
        ac.putValue(json, "minWarmupDiskSize", this.minWarmupDiskSize);
        ac.putValue(json, "cleanResourceWarmup", this.cleanResourceWarmup);
        ac.putValue(json, "warmupVideos", this.warmupVideos.toJson());
        ac.putValue(json, "warmupImages", this.warmupImages.toJson());
        ac.putValue(json, "warmupZips", this.warmupZips.toJson());
        return json;
    }
}
