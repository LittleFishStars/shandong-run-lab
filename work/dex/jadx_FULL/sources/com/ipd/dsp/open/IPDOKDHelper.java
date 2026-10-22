package com.ipd.dsp.open;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.f0.c;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.i0.b;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class IPDOKDHelper {
    public static final String TAG = "download";

    @Keep
    public interface DownloadListener {
        @Keep
        void onFailure(String str);

        @Keep
        void onProgress(int i);

        @Keep
        void onStart();

        @Keep
        void onSuccess();
    }

    @Keep
    public static void newTask(String str, String str2, String str3, final DownloadListener downloadListener) {
        new f.a(str, str2, str3).a(1).c(1000).a(false).a().a((c) new com.ipd.dsp.internal.q0.c() { // from class: com.ipd.dsp.open.IPDOKDHelper.1
            private DecimalFormat df;
            private int lastProgress;

            private int percent(long j, long j2) {
                double d = j / j2;
                if (this.df == null) {
                    DecimalFormat decimalFormat = new DecimalFormat("##0%");
                    this.df = decimalFormat;
                    decimalFormat.setRoundingMode(RoundingMode.DOWN);
                }
                return Integer.parseInt(this.df.format(d));
            }

            @Override // com.ipd.dsp.internal.q0.c
            public void canceled(@NonNull f fVar) {
                k.a("download", "canceled");
            }

            @Override // com.ipd.dsp.internal.q0.c
            public void completed(@NonNull f fVar) {
                k.a("download", "completed");
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onSuccess();
                }
            }

            @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
            public void connected(@NonNull f fVar, int i, long j, long j2) {
                k.a("download", "connected");
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onStart();
                }
            }

            @Override // com.ipd.dsp.internal.q0.c
            public void error(@NonNull f fVar, @NonNull Exception exc) {
                k.b("download", "error", exc);
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onFailure(Log.getStackTraceString(exc));
                }
            }

            @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
            public void progress(@NonNull f fVar, long j, long j2) {
                int iPercent = percent(j, j2);
                if (iPercent > this.lastProgress) {
                    this.lastProgress = iPercent;
                    k.d("download", "progress[" + iPercent + "]");
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onProgress(iPercent);
                    }
                }
            }

            @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
            public void retry(@NonNull f fVar, @NonNull b bVar) {
                k.a("download", "retry:" + bVar);
            }

            @Override // com.ipd.dsp.internal.q0.c
            public void started(@NonNull f fVar) {
                k.a("download", "started");
            }

            @Override // com.ipd.dsp.internal.q0.c
            public void warn(@NonNull f fVar) {
                k.f("download", AliyunLogCommon.LogLevel.WARN);
            }
        });
    }
}
