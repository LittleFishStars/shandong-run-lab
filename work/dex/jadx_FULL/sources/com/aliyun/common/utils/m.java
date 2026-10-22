package com.aliyun.common.utils;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static int a(String str) throws Throwable {
        Exception e;
        Throwable th;
        ?? r3;
        int integer;
        MediaExtractor mediaExtractor = new MediaExtractor();
        int i = 0;
        ?? r4 = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                try {
                    try {
                        mediaExtractor.setDataSource(fileInputStream2.getFD());
                        int trackCount = mediaExtractor.getTrackCount();
                        integer = 0;
                        while (i < trackCount) {
                            try {
                                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                                if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                                    integer = trackFormat.getInteger("frame-rate");
                                }
                                i++;
                            } catch (Exception e2) {
                                e = e2;
                                i = integer;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                Log.e("AliYunLog", "get frame rate error", e);
                                mediaExtractor.release();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                integer = i;
                                r4 = fileInputStream;
                                return integer;
                            }
                        }
                        mediaExtractor.release();
                        try {
                            fileInputStream2.close();
                            r4 = trackCount;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            r4 = trackCount;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r3 = fileInputStream2;
                        mediaExtractor.release();
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable th3) {
                th = th3;
                r3 = r4;
            }
        } catch (Exception e7) {
            e = e7;
        }
        return integer;
    }
}
