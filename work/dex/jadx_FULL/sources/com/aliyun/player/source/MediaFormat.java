package com.aliyun.player.source;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.fl.saas.common.util.FileTypeUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum MediaFormat {
    mp4("mp4"),
    m3u8("m3u8"),
    flv(LiveConfigKey.FLV),
    mp3(FileTypeUtils.FILE_TYPE_MP3);

    private String mFormat;

    MediaFormat(String str) {
        this.mFormat = str;
    }

    public String getFormat() {
        return this.mFormat;
    }
}
