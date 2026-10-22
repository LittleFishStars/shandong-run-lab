package com.google.android.exoplayer2.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(21)
public final class PlatformScheduler implements Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30806a = "PlatformScheduler";
    public static final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f3616b = "service_action";
    public static final String c = "service_package";
    public static final String d = "requirements";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final JobScheduler f3618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ComponentName f3619a;

    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int notMetRequirements = new Requirements(extras.getInt("requirements")).getNotMetRequirements(this);
            if (notMetRequirements == 0) {
                gj9.x1(this, new Intent((String) sb0.g(extras.getString(PlatformScheduler.f3616b))).setPackage((String) sb0.g(extras.getString(PlatformScheduler.c))));
                return false;
            }
            Log.n(PlatformScheduler.f30806a, "Requirements not met: " + notMetRequirements);
            jobFinished(jobParameters, true);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    static {
        b = (gj9.f41922a >= 26 ? 16 : 0) | 15;
    }

    @RequiresPermission("android.permission.RECEIVE_BOOT_COMPLETED")
    public PlatformScheduler(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.f3617a = i;
        this.f3619a = new ComponentName(applicationContext, (Class<?>) PlatformSchedulerService.class);
        this.f3618a = (JobScheduler) sb0.g((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    public static JobInfo c(int i, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements requirementsFilterRequirements = requirements.filterRequirements(b);
        if (!requirementsFilterRequirements.equals(requirements)) {
            Log.n(f30806a, "Ignoring unsupported requirements: " + (requirementsFilterRequirements.getRequirements() ^ requirements.getRequirements()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(i, componentName);
        if (requirements.isUnmeteredNetworkRequired()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.isNetworkRequired()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        if (gj9.f41922a >= 26 && requirements.isStorageNotLowRequired()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f3616b, str);
        persistableBundle.putString(c, str2);
        persistableBundle.putInt("requirements", requirements.getRequirements());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public Requirements a(Requirements requirements) {
        return requirements.filterRequirements(b);
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean b(Requirements requirements, String str, String str2) {
        return this.f3618a.schedule(c(this.f3617a, this.f3619a, requirements, str2, str)) == 1;
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean cancel() {
        this.f3618a.cancel(this.f3617a);
        return true;
    }
}
