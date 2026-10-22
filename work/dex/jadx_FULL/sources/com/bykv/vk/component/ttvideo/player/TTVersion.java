package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class TTVersion {
    public static final boolean ENABLE_AUDIO_EFFECT = false;
    public static final boolean ENABLE_BORINGSSL = false;
    public static final boolean ENABLE_EXT_LIBYUV = false;
    public static final boolean ENABLE_EXT_SSL = false;
    public static final boolean ENABLE_SHARED_FFMPEG = true;

    @Keep
    public static final int VERSION = 1;
    public static final String VERSION_INFO = "c7b53fdb5e 2023-01-18 14:58:56";
    public static final String VERSION_NAME = "2.10.42.103-csj";

    public static void saveVersionInfo() {
        TTPlayerConfiger.setValue(15, "c7b53fdb5e 2023-01-18 14:58:56");
        TTPlayerConfiger.setValue(13, 1);
        TTPlayerConfiger.setValue(14, "2.10.42.103-csj");
    }
}
