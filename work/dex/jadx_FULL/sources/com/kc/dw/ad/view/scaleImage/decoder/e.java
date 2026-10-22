package com.kc.dw.ad.view.scaleImage.decoder;

import android.app.ActivityManager;
import com.byazt.hv.TTDownloadField;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SkiaPooledImageRegionDecoder f39212a;

    public e(SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder) {
        this.f39212a = skiaPooledImageRegionDecoder;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0000 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int size;
        boolean z;
        boolean z2;
        String string;
        while (true) {
            SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = this.f39212a;
            SkiaPooledImageRegionDecoder.a aVar = skiaPooledImageRegionDecoder.f39209a;
            if (aVar == null) {
                return;
            }
            synchronized (aVar) {
                size = aVar.b.size();
            }
            long j = this.f39212a.f;
            if (size >= 4) {
                string = "No additional decoders allowed, reached hard limit (4)";
            } else {
                long j2 = ((long) size) * j;
                if (j2 > 20971520) {
                    string = "No additional encoders allowed, reached hard memory limit (20Mb)";
                } else if (size >= skiaPooledImageRegionDecoder.c()) {
                    StringBuilder sbA = com.kc.dw.activity.a.a("No additional encoders allowed, limited by CPU cores (");
                    sbA.append(skiaPooledImageRegionDecoder.c());
                    sbA.append(")");
                    string = sbA.toString();
                } else {
                    ActivityManager activityManager = (ActivityManager) skiaPooledImageRegionDecoder.d.getSystemService(TTDownloadField.TT_ACTIVITY);
                    z = true;
                    if (activityManager != null) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        z2 = memoryInfo.lowMemory;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        string = "No additional encoders allowed, memory is low";
                    } else {
                        skiaPooledImageRegionDecoder.a("Additional decoder allowed, current count is " + size + ", estimated native memory " + (j2 / 1048576) + "Mb");
                    }
                    if (z) {
                        return;
                    }
                    try {
                        if (this.f39212a.f39209a != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            this.f39212a.a("Starting decoder");
                            this.f39212a.d();
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            this.f39212a.a("Started decoder, took " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms");
                        }
                    } catch (Exception e) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder2 = this.f39212a;
                        StringBuilder sbA2 = com.kc.dw.activity.a.a("Failed to start decoder: ");
                        sbA2.append(e.getMessage());
                        skiaPooledImageRegionDecoder2.a(sbA2.toString());
                    }
                }
            }
            skiaPooledImageRegionDecoder.a(string);
            z = false;
            if (z) {
                return;
            }
            if (this.f39212a.f39209a != null) {
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                this.f39212a.a("Starting decoder");
                this.f39212a.d();
                long jCurrentTimeMillis4 = System.currentTimeMillis();
                this.f39212a.a("Started decoder, took " + (jCurrentTimeMillis4 - jCurrentTimeMillis3) + "ms");
            }
        }
    }
}
