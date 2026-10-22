package com.beizi.fusion.model;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdPlusConfig {

    @JsonNode(key = "adUrl")
    private String adUrl;

    @JsonNode(key = "h5RedirectBlackList")
    private List<String> h5RedirectBlackList;

    @JsonNode(key = "rwReqUrl")
    private String rwReqUrl;

    @JsonNode(key = "unReqUrl")
    private String unReqUrl;

    @JsonNode(key = "version")
    private String version;

    public static AdPlusConfig objectFromData(String str) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(str, AdPlusConfig.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getAdUrl() {
        return this.adUrl;
    }

    public List<String> getH5RedirectBlackList() {
        return this.h5RedirectBlackList;
    }

    public String getRwReqUrl() {
        return this.rwReqUrl;
    }

    public String getUnReqUrl() {
        return this.unReqUrl;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAdUrl(String str) {
        this.adUrl = str;
    }

    public void setH5RedirectBlackList(List<String> list) {
        this.h5RedirectBlackList = list;
    }

    public void setRwReqUrl(String str) {
        this.rwReqUrl = str;
    }

    public void setUnReqUrl(String str) {
        this.unReqUrl = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public static AdPlusConfig objectFromData(String str, String str2) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), AdPlusConfig.class);
        } catch (JSONException | Exception unused) {
            return null;
        }
    }
}
