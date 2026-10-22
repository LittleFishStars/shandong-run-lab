package com.kwad.sdk.commercial.model;

import android.os.Looper;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ba;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class SDKInitMsg extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final int CHILD_PROCESS = 2;
    private static final int DYNAMIC_DISABLE = 2;
    private static final int DYNAMIC_ENABLE = 1;
    public static final int FAIL = 2;
    public static final int FINISH = 1;
    private static final int MAIN_PROCESS = 1;
    private static final int MAIN_THREAD = 1;
    public static final int NEW_FINISH = 3;
    public static final int NEW_FINISH_MODULE = 6;
    public static final int START = 0;
    public static final int START_BEGIN = 4;
    public static final int START_FINISH = 5;
    private static final int WORK_THREAD = 2;
    private static final long serialVersionUID = 368743526206619387L;
    public String errorReason;
    public int initCount;
    public int initProcess;
    public int initStatus;
    public int initThread;
    public int intBuildNumber;
    public int intDynamicSDK;
    public long launchIntervalTime;
    public long totalDurationTime;

    public SDKInitMsg() {
        this.initProcess = ba.isInMainProcess(ServiceProvider.Ud()) ? 1 : 2;
        this.initThread = Looper.getMainLooper() == Looper.myLooper() ? 1 : 2;
        this.intDynamicSDK = com.kwad.framework.a.a.ayN.booleanValue() ? 1 : 2;
        this.intBuildNumber = 5560136;
    }

    public SDKInitMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public SDKInitMsg setInitCount(int i) {
        this.initCount = i;
        return this;
    }

    public SDKInitMsg setInitStatus(int i) {
        this.initStatus = i;
        return this;
    }

    public SDKInitMsg setLaunchIntervalTime(long j) {
        this.launchIntervalTime = j;
        return this;
    }

    public SDKInitMsg setTotalDurationTime(long j) {
        this.totalDurationTime = j;
        return this;
    }
}
