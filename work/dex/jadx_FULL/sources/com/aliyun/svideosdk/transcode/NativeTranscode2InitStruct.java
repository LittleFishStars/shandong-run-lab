package com.aliyun.svideosdk.transcode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeTranscode2InitStruct {
    public String intputPath;
    public String outputPath;
    public NativeTranscode2.TranscodeCallback cb = null;
    public long reportId = -1;
    public long logId = -1;
    public boolean needAudio = true;
    public boolean needVideo = true;
    public long startTime = 0;
    public long endTime = 0;
    public int cropMode = 1;
    public int cropX = 0;
    public int cropY = 0;
    public int cropWidth = 0;
    public int cropHeight = 0;
    public int cropBackColor = 0;
    public int outputWidth = 0;
    public int outputHeight = 0;
    public boolean useHWEncoder = true;
    public boolean useHWDecoder = true;
}
