package com.byazt.z;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.byazt.zz.rh;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 765})
@TargetApi(21)
public class RetryJobSchedulerService extends JobService {
    public static void c(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context contextIc;
        long j2;
        rh reserveWifiStatusListener;
        rh reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (contextIc = com.byazt.zz.ve.ic()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.byazt.zz.ve.ic()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.c(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextIc.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
                m.c(th);
            }
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(contextIc.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i2 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.byazt.zz.ve.ic()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.c(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                com.byazt.x.c.uj("RetrySchedulerService", "schedule err errCode = ".concat(String.valueOf(iSchedule)));
            }
        } catch (Throwable th2) {
            m.c(th2);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.byazt.zz.ve.c(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.byazt.zz.ve.da()) {
            return 2;
        }
        return iOnStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.byazt.x.c.ve("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
        com.byazt.b.rh.c().c(jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
