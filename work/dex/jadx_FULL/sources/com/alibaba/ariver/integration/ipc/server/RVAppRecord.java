package com.alibaba.ariver.integration.ipc.server;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.resource.api.models.AppModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RVAppRecord {
    private static final String TAG = "AriverInt:RVAppRecord";
    private static long lastStartToken = -1;
    boolean isTaskRoot;
    private Class<? extends Activity> mActivityClz;
    private final String mAppId;
    private AppModel mAppModel;
    private long mLastStartClientTimeStamp;
    private boolean mReceivedRemoteReady;
    private int mRemoteLpid;
    private Bundle mSceneParams;
    private Bundle mStartParams;
    private final long mStartToken;
    ActivityManager.RunningTaskInfo runningTaskInfo;

    public RVAppRecord(String str, long j, Bundle bundle, @Nullable Bundle bundle2) {
        this.mLastStartClientTimeStamp = -1L;
        this.mAppId = str;
        this.mStartToken = j;
        this.mStartParams = bundle;
        bundle.putString("appId", str);
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.mSceneParams = bundle2;
        bundle2.putLong(RVConstants.EXTRA_START_TOKEN, j);
    }

    public static synchronized RVAppRecord generate(String str, Bundle bundle, @Nullable Bundle bundle2) {
        return new RVAppRecord(str, generateStartToken(), bundle, bundle2);
    }

    public static long generateStartToken() {
        long jNanoTime = System.nanoTime();
        if (jNanoTime == lastStartToken) {
            jNanoTime++;
        }
        lastStartToken = jNanoTime;
        return jNanoTime;
    }

    public void finishClient() {
        RVLogger.d(TAG, "forceFinish from stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        Bundle bundle = new Bundle();
        bundle.putString(RVConstants.EXTRA_PREPARE_ABORT_REASON, "Finish from manual!");
        IpcServerUtils.sendMsgToClient(getAppId(), getStartToken(), 4, bundle);
    }

    public Class<? extends Activity> getActivityClz() {
        return this.mActivityClz;
    }

    public String getAppId() {
        return this.mAppId;
    }

    @Nullable
    public AppModel getAppModel() {
        return this.mAppModel;
    }

    public long getLastStartClientTimeStamp() {
        return this.mLastStartClientTimeStamp;
    }

    public int getRemoteLpid() {
        return this.mRemoteLpid;
    }

    public ActivityManager.RunningTaskInfo getRunningTaskInfo() {
        return this.runningTaskInfo;
    }

    public Bundle getSceneParams() {
        return this.mSceneParams;
    }

    public Bundle getStartParams() {
        return this.mStartParams;
    }

    public long getStartToken() {
        return this.mStartToken;
    }

    public boolean isReady() {
        return this.mReceivedRemoteReady || IpcChannelManager.getInstance().getClientChannel(this.mStartToken) != null;
    }

    public boolean isReceivedRemoteReady() {
        return this.mReceivedRemoteReady;
    }

    public boolean isTaskRoot() {
        return this.isTaskRoot;
    }

    public void setActivityClz(@NonNull Class<? extends Activity> cls) {
        this.mActivityClz = cls;
    }

    public void setAppModel(AppModel appModel) {
        this.mAppModel = appModel;
    }

    public void setLastStartClientTimeStamp(long j) {
        this.mLastStartClientTimeStamp = j;
    }

    public void setReceivedRemoteReady(int i) {
        this.mRemoteLpid = i;
        this.mReceivedRemoteReady = true;
    }

    public void setSceneParams(Bundle bundle) {
        this.mSceneParams = bundle;
        if (bundle != null) {
            bundle.setClassLoader(RVAppRecord.class.getClassLoader());
        }
    }

    public void setStartParams(Bundle bundle) {
        this.mStartParams = bundle;
        if (bundle != null) {
            bundle.setClassLoader(RVAppRecord.class.getClassLoader());
        }
    }

    public void setTaskRoot(boolean z) {
        this.isTaskRoot = z;
    }

    public String toString() {
        return "AppRecord{mStartToken=" + this.mStartParams + ", appId='" + this.mAppId + "', activityClz=" + this.mActivityClz + ", ready=" + isReady() + '}';
    }

    public RVAppRecord(String str, Bundle bundle, @Nullable Bundle bundle2) {
        this(str, System.currentTimeMillis(), bundle, bundle2);
    }
}
