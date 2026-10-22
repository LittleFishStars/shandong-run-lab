package com.zj.adlib;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(api = 21)
public class ho4 implements WorkScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42170a = "JobInfoScheduler";
    public static final String b = "attemptNumber";
    public static final String c = "backendName";
    public static final String d = "priority";
    public static final String e = "extras";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f17041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SchedulerConfig f17042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventStore f17043a;

    public ho4(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f17041a = context;
        this.f17043a = eventStore;
        this.f17042a = schedulerConfig;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void a(TransportContext transportContext, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.f17041a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f17041a.getSystemService("jobscheduler");
        int iC = c(transportContext);
        if (!z && d(jobScheduler, iC, i)) {
            h25.b(f42170a, "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long jT = this.f17043a.t(transportContext);
        JobInfo.Builder builderC = this.f17042a.c(new JobInfo.Builder(iC, componentName), transportContext.d(), jT, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", transportContext.b());
        persistableBundle.putInt("priority", sy6.a(transportContext.d()));
        if (transportContext.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        h25.d(f42170a, "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(iC), Long.valueOf(this.f17042a.h(transportContext.d(), jT, i)), Long.valueOf(jT), Integer.valueOf(i));
        jobScheduler.schedule(builderC.build());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void b(TransportContext transportContext, int i) {
        a(transportContext, i, false);
    }

    @VisibleForTesting
    public int c(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f17041a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(sy6.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }
}
