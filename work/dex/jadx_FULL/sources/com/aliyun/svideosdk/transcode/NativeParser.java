package com.aliyun.svideosdk.transcode;

import android.text.TextUtils;
import android.util.Log;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.aliyun.common.utils.c;
import com.aliyun.common.utils.g;
import com.aliyun.svideosdk.nativeload.a;
import com.fl.saas.common.util.FileTypeUtils;
import com.zj.adlib.un1;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeParser extends a {
    public static final int AUDIO_BIT_RATE = 20;
    public static final int AUDIO_CHANNELS = 21;
    public static final int AUDIO_CODEC = 16;
    public static final int AUDIO_DURATION = 18;
    public static final int AUDIO_FORAMT = 23;
    public static final int AUDIO_FRAME_COUNT = 19;
    public static final int AUDIO_FRAME_SAMPLES = 24;
    public static final int AUDIO_SAMPLE_RATE = 22;
    public static final int AUDIO_START_TIME = 17;
    public static final int AUDIO_STREAM_DIC_KEY_START = 15;
    public static final int AUDIO_STREAM_INDEX = 15;
    public static final int DIC_KEY_END = 30;
    public static final int FILE_BIT_RATE = 29;
    public static final int FILE_DIC_KEY_START = 25;
    public static final int FILE_DURATION = 28;
    public static final int FILE_FORMAT = 26;
    public static final int FILE_NAME = 25;
    public static final int FILE_START_TIME = 27;
    public static final String VALUE_WRONG = "unknown";
    public static final int VIDEO_BIT_RATE = 5;
    public static final int VIDEO_CODEC = 1;
    public static final int VIDEO_CODEC_HEIGHT = 9;
    public static final int VIDEO_CODEC_WIDTH = 8;
    public static final int VIDEO_DURATION = 3;
    public static final int VIDEO_FORMAT = 10;
    public static final int VIDEO_FPS = 13;
    public static final int VIDEO_FRAME_COUNT = 4;
    public static final int VIDEO_GOP = 11;
    public static final int VIDEO_HEIGHT = 7;
    public static final int VIDEO_MAX_BFRAME = 12;
    public static final int VIDEO_ROTATION = 14;
    public static final int VIDEO_START_TIME = 2;
    public static final int VIDEO_STREAM_DIC_KEY_START = 0;
    public static final int VIDEO_STREAM_INDEX = 0;
    public static final int VIDEO_WIDTH = 6;
    private static final ArrayList<String> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25858a;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        b = arrayList;
        arrayList.add("rgba64be");
        arrayList.add("yuvj422p");
        arrayList.add("yuv444p");
        arrayList.add("yuvj444p");
        arrayList.add("yuvj420p");
        arrayList.add("yuv420p");
        arrayList.add("nv12");
        arrayList.add("nv21");
        arrayList.add("bgra");
        arrayList.add(un1.b);
        arrayList.add("argb");
        arrayList.add("bgr24");
        arrayList.add("rgb24");
        arrayList.add("pal8");
    }

    public NativeParser() {
        this.f25858a = 0L;
        this.f25858a = nativeCreate();
    }

    private native boolean nativeCheckBFrame(long j);

    private native boolean nativeCheckInvertAvailable(long j);

    private native long nativeCreate();

    private native void nativeDispose(long j);

    private native int nativeGetMaxGopSize(long j);

    private native String nativeGetValue(long j, int i);

    private native int nativeInit(long j, String str);

    private native void nativePrint(long j);

    private native void nativeRelease(long j);

    public boolean checkBFrame() {
        return nativeCheckBFrame(this.f25858a);
    }

    public boolean checkIfSupportedImage(String str) {
        String strB;
        if (!new File(str).exists() || (strB = g.b(str)) == null || !strB.contains("image")) {
            return false;
        }
        if (!strB.contains(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) && !strB.contains("jpg") && !strB.contains(FileTypeUtils.FILE_TYPE_GIF) && strB.contains("png")) {
            String value = getValue(10);
            Log.d(NativeParser.class.getName(), "Color format:" + value);
            if (!value.contains("yuv420p") && !value.contains("yuv444p")) {
                return b.contains(value);
            }
        }
        return true;
    }

    public boolean checkInvertAvailable() {
        return nativeCheckInvertAvailable(this.f25858a);
    }

    public void dispose() {
        nativeDispose(this.f25858a);
    }

    public int getMaxGopSize() {
        return nativeGetMaxGopSize(this.f25858a);
    }

    public String getValue(int i) {
        return (i < 0 || i >= 30) ? "unknown" : nativeGetValue(this.f25858a, i);
    }

    public int init(String str) {
        c.a(Boolean.FALSE, Boolean.valueOf(TextUtils.isEmpty(str)));
        return nativeInit(this.f25858a, str);
    }

    public void print() {
        nativePrint(this.f25858a);
    }

    public void release() {
        nativeRelease(this.f25858a);
    }
}
