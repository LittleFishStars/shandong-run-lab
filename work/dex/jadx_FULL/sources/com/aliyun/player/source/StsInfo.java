package com.aliyun.player.source;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StsInfo {
    private String mAccessKeyId;
    private String mAccessKeySecret;
    private List<MediaFormat> mFormats;
    private String mRegion;
    private String mSecurityToken;

    private String getFormatStr() {
        List<MediaFormat> list = this.mFormats;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (MediaFormat mediaFormat : this.mFormats) {
            if (mediaFormat != null) {
                sb.append(mediaFormat.getFormat());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public List<MediaFormat> getFormats() {
        return this.mFormats;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public String getSecurityToken() {
        return this.mSecurityToken;
    }

    public void setAccessKeyId(String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.mAccessKeySecret = str;
    }

    public void setFormats(List<MediaFormat> list) {
        this.mFormats = list;
    }

    public void setRegion(String str) {
        this.mRegion = str;
    }

    public void setSecurityToken(String str) {
        this.mSecurityToken = str;
    }
}
