package com.alibaba.triver.kit.api.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LaunchMonitorData implements Parcelable {
    public static final Parcelable.Creator<LaunchMonitorData> CREATOR = new Parcelable.Creator<LaunchMonitorData>() { // from class: com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LaunchMonitorData createFromParcel(Parcel parcel) {
            return new LaunchMonitorData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LaunchMonitorData[] newArray(int i) {
            return new LaunchMonitorData[i];
        }
    };
    private static final String KEY_AB_WORKER_TEST = "abTestTag";
    private static final String KEY_HIGH_MEM = "highMemory";
    private static final String KEY_START_MEM = "startMemory";
    private static final String TAG = "LaunchMonitorData";
    private String errorCode;
    private String errorMessage;
    private volatile Map<String, String> mData;
    private volatile Map<String, String> memInfo;

    public LaunchMonitorData() {
        this.mData = new ConcurrentHashMap();
        this.memInfo = new ConcurrentHashMap();
    }

    public void addPoint(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mData.put(str, jCurrentTimeMillis + "");
    }

    public boolean containsKey(String str) {
        return this.mData.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String findLastStage(String str) {
        String str2 = null;
        try {
            Long l = 0L;
            for (String str3 : this.mData.keySet()) {
                if (TextUtils.isEmpty(str) || !TextUtils.equals(str3, str)) {
                    String str4 = this.mData.get(str3);
                    if (str4 != null) {
                        Long lValueOf = Long.valueOf(str4);
                        if (lValueOf.longValue() > l.longValue()) {
                            str2 = str3;
                            l = lValueOf;
                        }
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
        return str2;
    }

    public String get(String str) {
        return this.mData.get(str);
    }

    public Map<String, String> getData() {
        return this.mData;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Map<String, String> getMemDetail() {
        return this.memInfo;
    }

    public void merge(LaunchMonitorData launchMonitorData) {
        if (launchMonitorData != null) {
            this.mData.putAll(launchMonitorData.getData());
            this.memInfo.putAll(launchMonitorData.getMemDetail());
            setErrorCode(launchMonitorData.getErrorCode());
            setErrorMessage(launchMonitorData.getErrorMessage());
        }
    }

    public void mergeAppend(LaunchMonitorData launchMonitorData) {
        if (launchMonitorData != null) {
            this.mData.put("appStage", JSON.toJSONString(launchMonitorData.getData()));
            this.memInfo.put("appMemDetail", JSON.toJSONString(launchMonitorData.getMemDetail()));
        }
    }

    public String remove(String str) {
        return this.mData.remove(str);
    }

    public void setABTestTag(int i) {
        this.memInfo.put("abTestTag", Integer.toString(i));
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setStartMemory(String str) {
        this.memInfo.put("startMemory", str);
    }

    public String toString() {
        return JSON.toJSONString(this.mData);
    }

    public void updateHighMemory(String str) {
        this.memInfo.put("highMemory", str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(new ConcurrentHashMap(this.mData));
        parcel.writeString(this.errorCode);
        parcel.writeString(this.errorMessage);
    }

    public void addPoint(String str, Long l) {
        if (l.longValue() > 0) {
            this.mData.put(str, l + "");
        }
    }

    public LaunchMonitorData(Parcel parcel) {
        this.mData = new ConcurrentHashMap();
        this.memInfo = new ConcurrentHashMap();
        parcel.readMap(this.mData, getClass().getClassLoader());
        this.errorCode = parcel.readString();
        this.errorMessage = parcel.readString();
        if (this.mData == null) {
            this.mData = new ConcurrentHashMap();
        }
    }
}
