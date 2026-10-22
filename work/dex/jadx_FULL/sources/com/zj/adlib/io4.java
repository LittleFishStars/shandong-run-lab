package com.zj.adlib;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class io4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JobParameters f42400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final JobInfoSchedulerService f17247a;

    public io4(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f17247a = jobInfoSchedulerService;
        this.f42400a = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new io4(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17247a.jobFinished(this.f42400a, false);
    }
}
