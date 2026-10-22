package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.ac;
import com.zj.adlib.c49;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class ExceptionMessage implements b, Serializable {
    private static final long serialVersionUID = -5338556142957298914L;
    public long mCurrentTimeStamp;
    public int mPid;
    public int mTid;
    public long mUsageTimeMills;
    public String mCrashDetail = "Unknown";
    public String mMemoryInfo = "Unknown";
    public String mDiskInfo = "Unknown";
    public String mProcessName = "Unknown";
    public int mExceptionType = 0;
    public String mCrashType = getTypeCommon();
    public String mThreadName = "Unknown";
    public String mIsAppOnForeground = "Unknown";
    public String mLogUUID = "Unknown";
    public String mVirtualApp = "Unknown";
    public String mCustomMsg = "Unknown";
    public String mThreadOverflow = "Unknown";
    public String mFdOverflow = "Unknown";
    public String mTaskId = "Unknown";
    public String mErrorMessage = "";
    public String mVersionCode = "Unknown";
    public boolean mVersionConflict = false;
    public String mAppVersionBeforeLastUpload = "Unknown";
    public String mJNIError = "";
    public String mGCInfo = "";
    public String mLockInfo = "";
    public String mMonitorInfo = "";
    public String mSlowLooper = "";
    public String mSlowOperation = "";
    public String mBuildConfigInfo = "";
    public String mAbi = "Unknown";
    public String mDumpsys = "";
    public int mCrashSource = 0;

    public static final String getSdkCrashVersionName(String str, int i) {
        return str + c49.f40900a + i;
    }

    public static final String getSdkVersionNameSuffix(int i) {
        if (i == 1) {
            return "-ad";
        }
        if (i == 2) {
            return "-ct";
        }
        if (i == 3) {
            return "-ec";
        }
        if (i != 4) {
            return i != 5 ? "" : "-car";
        }
        return "-pct";
    }

    private void setIsForeground() {
        try {
            com.kwad.sdk.core.c.b.LW();
            this.mIsAppOnForeground = com.kwad.sdk.core.c.b.isAppOnForeground() ? "Foreground" : "Background";
        } catch (Exception unused) {
        }
    }

    public String getReportMsg() {
        return "UUID=" + this.mLogUUID + ",crashTime=" + i.aT(this.mCurrentTimeStamp) + ",customMsg=" + this.mCustomMsg;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public int getTid() {
        return this.mTid;
    }

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    public abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCrashDetail = jSONObject.optString("mCrashDetail");
        this.mMemoryInfo = jSONObject.optString("mMemoryInfo");
        this.mDiskInfo = jSONObject.optString("mDiskInfo");
        this.mProcessName = jSONObject.optString("mProcessName");
        this.mCrashType = jSONObject.optString("mCrashType");
        this.mThreadName = jSONObject.optString("mThreadName");
        this.mIsAppOnForeground = jSONObject.optString("mIsAppOnForeground");
        this.mLogUUID = jSONObject.optString("mLogUUID");
        this.mVirtualApp = jSONObject.optString("mVirtualApp");
        this.mCustomMsg = jSONObject.optString("mCustomMsg");
        this.mThreadOverflow = jSONObject.optString("mThreadOverflow");
        this.mFdOverflow = jSONObject.optString("mFdOverflow");
        this.mTaskId = jSONObject.optString("mTaskId");
        this.mErrorMessage = jSONObject.optString("mErrorMessage");
        this.mCurrentTimeStamp = jSONObject.optLong("mCurrentTimeStamp");
        this.mUsageTimeMills = jSONObject.optLong("mUsageTimeMills");
        this.mPid = jSONObject.optInt("mPid");
        this.mTid = jSONObject.optInt("mTid");
        this.mVersionCode = jSONObject.optString("mVersionCode");
        this.mVersionConflict = jSONObject.optBoolean("mVersionConflict");
        this.mAppVersionBeforeLastUpload = jSONObject.optString("mAppVersionBeforeLastUpload");
        this.mJNIError = jSONObject.optString("mJNIError");
        this.mGCInfo = jSONObject.optString("mGCInfo");
        this.mLockInfo = jSONObject.optString("mLockInfo");
        this.mMonitorInfo = jSONObject.optString("mMonitorInfo");
        this.mSlowLooper = jSONObject.optString("mSlowLooper");
        this.mSlowOperation = jSONObject.optString("mSlowOperation");
        this.mBuildConfigInfo = jSONObject.optString("mBuildConfigInfo");
        this.mAbi = jSONObject.optString("mAbi");
        this.mDumpsys = jSONObject.optString("mDumpsys");
        this.mCrashSource = jSONObject.optInt("mCrashSource");
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    public void setTid(int i) {
        this.mTid = i;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "mCrashDetail", this.mCrashDetail);
        ac.putValue(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        ac.putValue(jSONObject, "mDiskInfo", this.mDiskInfo);
        ac.putValue(jSONObject, "mProcessName", this.mProcessName);
        ac.putValue(jSONObject, "mCrashType", this.mCrashType);
        ac.putValue(jSONObject, "mThreadName", this.mThreadName);
        setIsForeground();
        ac.putValue(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        ac.putValue(jSONObject, "mLogUUID", this.mLogUUID);
        ac.putValue(jSONObject, "mVirtualApp", this.mVirtualApp);
        ac.putValue(jSONObject, "mCustomMsg", this.mCustomMsg);
        ac.putValue(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        ac.putValue(jSONObject, "mFdOverflow", this.mFdOverflow);
        ac.putValue(jSONObject, "mTaskId", this.mTaskId);
        ac.putValue(jSONObject, "mErrorMessage", this.mErrorMessage);
        ac.putValue(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        ac.putValue(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        ac.putValue(jSONObject, "mPid", this.mPid);
        ac.putValue(jSONObject, "mTid", this.mTid);
        ac.putValue(jSONObject, "mVersionCode", this.mVersionCode);
        ac.putValue(jSONObject, "mVersionConflict", this.mVersionConflict);
        ac.putValue(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        ac.putValue(jSONObject, "mJNIError", this.mJNIError);
        ac.putValue(jSONObject, "mGCInfo", this.mGCInfo);
        ac.putValue(jSONObject, "mLockInfo", this.mLockInfo);
        ac.putValue(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        ac.putValue(jSONObject, "mSlowLooper", this.mSlowLooper);
        ac.putValue(jSONObject, "mSlowOperation", this.mSlowOperation);
        ac.putValue(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        ac.putValue(jSONObject, "mAbi", this.mAbi);
        ac.putValue(jSONObject, "mDumpsys", this.mDumpsys);
        ac.putValue(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("异常状态汇总:\nUUID: ");
            sb.append(this.mLogUUID);
            sb.append("\nCPU架构: ");
            sb.append(this.mAbi);
            sb.append("\n异常进程: ");
            sb.append(this.mProcessName);
            sb.append(" (");
            sb.append(this.mPid);
            sb.append(")\n");
            sb.append("异常线程: ");
            sb.append(this.mThreadName);
            sb.append(" (");
            sb.append(this.mTid);
            sb.append(")\n");
            sb.append("异常类型: ");
            sb.append(this.mCrashType);
            sb.append("\n应用多开环境: ");
            sb.append(this.mVirtualApp);
            sb.append("\nTaskId: ");
            sb.append(this.mTaskId);
            sb.append("\nmTid: ");
            sb.append(this.mTid);
            sb.append("\n自定义信息: ");
            sb.append(this.mCustomMsg);
            sb.append("\n前后台状态: ");
            sb.append(this.mIsAppOnForeground);
            sb.append("\n异常发生时间: ");
            sb.append(i.aT(this.mCurrentTimeStamp));
            sb.append("\n版本号: ");
            sb.append(this.mVersionCode);
            sb.append("\n升级前版本号: ");
            sb.append(this.mAppVersionBeforeLastUpload);
            sb.append("\n使用时长: ");
            sb.append(j.aU(this.mUsageTimeMills));
            sb.append("\n异常详情: \n");
            if (this instanceof JavaExceptionMessage) {
                sb.append(this.mCrashDetail.replace("##", "\n\t").replace("#", "\n"));
            } else {
                sb.append(this.mCrashDetail);
            }
            sb.append("\n磁盘详情: \n");
            sb.append(this.mDiskInfo);
            sb.append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("异常上报Debug: \n");
                sb.append(this.mErrorMessage);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig信息: \n");
                sb.append(this.mBuildConfigInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI异常: \n");
                sb.append(this.mJNIError);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC耗时: \n");
                sb.append(this.mGCInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("锁耗时(dvm_lock_sample): \n");
                sb.append(this.mLockInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("锁耗时(monitor): \n");
                sb.append(this.mMonitorInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper耗时: \n");
                sb.append(this.mSlowLooper);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS调度耗时: \n");
                sb.append(this.mSlowOperation);
                sb.append("\n");
            }
            sb.append("内存详情: \n");
            sb.append(this.mMemoryInfo);
            sb.append("\n");
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
        return sb.substring(0);
    }
}
