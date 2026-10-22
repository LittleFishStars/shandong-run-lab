package com.zj.adlib;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class ew0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f41536a = new su3("StreamingFormatChecker", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedList f16418a = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16417a = -1;

    @KeepForSdk
    public void a(@NonNull InputImage inputImage) {
        if (inputImage.j() != -1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f16418a.add(Long.valueOf(jElapsedRealtime));
        if (this.f16418a.size() > 5) {
            this.f16418a.removeFirst();
        }
        if (this.f16418a.size() != 5 || jElapsedRealtime - ((Long) yw6.l((Long) this.f16418a.peekFirst())).longValue() >= 5000) {
            return;
        }
        long j = this.f16417a;
        if (j == -1 || jElapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5L)) {
            this.f16417a = jElapsedRealtime;
            f41536a.n("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
        }
    }
}
