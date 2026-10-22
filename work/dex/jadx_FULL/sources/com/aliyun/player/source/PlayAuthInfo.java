package com.aliyun.player.source;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PlayAuthInfo {
    private List<MediaFormat> mFormats;
    private String mPlayAuth;

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

    public List<MediaFormat> getFormats() {
        return this.mFormats;
    }

    public String getPlayAuth() {
        return this.mPlayAuth;
    }

    public void setFormats(List<MediaFormat> list) {
        this.mFormats = list;
    }

    public void setPlayAuth(String str) {
        this.mPlayAuth = str;
    }
}
