package com.aliyun.player;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VidPlayerConfigGen {
    private Map<String, Object> configMap = new HashMap();

    public enum EncryptType {
        Unencrypted,
        AliyunVodEncryption,
        HLSEncryption
    }

    public void addPlayerConfig(String str, int i) {
        if (str != null) {
            this.configMap.put(str, Integer.valueOf(i));
        }
    }

    public void addPlayerConfig(String str, String str2) {
        if (str != null) {
            this.configMap.put(str, str2);
        }
    }

    public String genConfig() {
        if (this.configMap.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : this.configMap.keySet()) {
            try {
                jSONObject.put(str, this.configMap.get(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void setEncryptType(EncryptType encryptType) {
        addPlayerConfig("EncryptType", encryptType == EncryptType.AliyunVodEncryption ? "AliyunVoDEncryption" : encryptType.name());
    }

    public void setMtsHlsUriToken(String str) {
        addPlayerConfig("MtsHlsUriToken", str);
    }

    public void setPreviewTime(int i) {
        addPlayerConfig("PreviewTime", i);
    }
}
