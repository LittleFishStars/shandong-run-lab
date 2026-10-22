package com.zj.adlib;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nsd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TelemetryLoggingClient f43604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicLong f18508a = new AtomicLong(-1);

    @VisibleForTesting
    public nsd(Context context, String str) {
        this.f43604a = p29.b(context, q29.a().b("mlkit:vision").a());
    }

    public static nsd a(Context context) {
        return new nsd(context, "mlkit:vision");
    }

    public final /* synthetic */ void b(long j, Exception exc) {
        this.f18508a.set(j);
    }

    public final synchronized void c(int i, int i2, long j, long j2) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f18508a.get() != -1 && jElapsedRealtime - this.f18508a.get() <= TimeUnit.MINUTES.toMillis(30L)) {
            return;
        }
        this.f43604a.g(new TelemetryData(0, Arrays.asList(new MethodInvocation(i, i2, 0, j, j2, null, null, 0)))).h(new OnFailureListener() { // from class: com.zj.adlib.msd
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f18294a.b(jElapsedRealtime, exc);
            }
        });
    }
}
