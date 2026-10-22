package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.CollectionUtils;
import com.igexin.push.config.c;
import com.zj.adlib.ys8;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SchoolRule implements Parcelable {
    public static final Parcelable.Creator<SchoolRule> CREATOR = new Parcelable.Creator<SchoolRule>() { // from class: com.huachenjie.common.bean.SchoolRule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SchoolRule createFromParcel(Parcel in) {
            return new SchoolRule(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SchoolRule[] newArray(int size) {
            return new SchoolRule[size];
        }
    };
    public static String RUN_TIME_TYPE_ERVERY_DAY = "0";
    public static String RUN_TIME_TYPE_WEEKEND = "2";
    public static String RUN_TIME_TYPE_WORKDAY = "1";
    private List<ClockInMode> clockModeList;
    private int dayMaxDistance;
    private int dayMaxTimes;
    private String endDate;
    public String fileName;
    public String fileUrl;
    private boolean forbiddenWiFi;
    private boolean gpsWhiteFlag;
    private int maxFrequency;
    private long maxPace;
    private int minFrequency;
    private long minPace;
    private List<String> morningTimeFragment;
    public String remark;
    private float segmentStrideAvg;
    private int segmentStrideExceptionNum;
    private long singleMaxDistance;
    private long singleMinDistance;
    private String startDate;
    private long suspendTime;
    private int swingAmplitudeThreshold;
    public List<RunTimeAreaData> timeFragment;
    private long totalDistance;
    private int totalTimes;
    private int weekMaxDistance;
    private int weekMaxTimes;
    private int weekMinTimes;

    public SchoolRule() {
        this.suspendTime = c.l;
        this.segmentStrideAvg = Float.MAX_VALUE;
        this.segmentStrideExceptionNum = Integer.MAX_VALUE;
        this.swingAmplitudeThreshold = 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ClockInMode> getClockModeList() {
        return this.clockModeList;
    }

    public int getDayMaxDistance() {
        return this.dayMaxDistance;
    }

    public int getDayMaxTimes() {
        return this.dayMaxTimes;
    }

    public int getDisKM() {
        return Math.round((this.totalDistance * 1.0f) / 1000.0f);
    }

    public String getEndDate() {
        return this.endDate;
    }

    public int getMaxFrequency() {
        return this.maxFrequency;
    }

    public long getMaxPace() {
        return this.maxPace;
    }

    public int getMinFrequency() {
        return this.minFrequency;
    }

    public long getMinPace() {
        return this.minPace;
    }

    public List<String> getMorningTimeFragment() {
        return this.morningTimeFragment;
    }

    public String getRuleTime() {
        return ys8.c("%s - %s", this.startDate, this.endDate);
    }

    public float getSegmentStrideAvg() {
        return this.segmentStrideAvg;
    }

    public int getSegmentStrideExceptionNum() {
        return this.segmentStrideExceptionNum;
    }

    public long getSingleMaxDistance() {
        return this.singleMaxDistance;
    }

    public long getSingleMinDistance() {
        return this.singleMinDistance;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public long getSuspendTime() {
        return this.suspendTime;
    }

    public int getSwingAmplitudeThreshold() {
        return this.swingAmplitudeThreshold;
    }

    public long getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalTimes() {
        return this.totalTimes;
    }

    public int getWeekMaxDistance() {
        return this.weekMaxDistance;
    }

    public int getWeekMaxTimes() {
        return this.weekMaxTimes;
    }

    public int getWeekMinTimes() {
        return this.weekMinTimes;
    }

    public boolean isForbiddenWiFi() {
        return this.forbiddenWiFi;
    }

    public boolean isGpsWhiteFlag() {
        return this.gpsWhiteFlag;
    }

    public float maxLimitSpeedMs() {
        if (getMaxPace() == 0) {
            return 0.0f;
        }
        return (1.0f / getMaxPace()) * 1000.0f;
    }

    public float minLimitSpeedMs() {
        if (getMinPace() == 0) {
            return 0.0f;
        }
        return (1.0f / getMinPace()) * 1000.0f;
    }

    public void setClockModeList(List<ClockInMode> clockModeList) {
        this.clockModeList = clockModeList;
    }

    public void setDayMaxDistance(int dayMaxDistance) {
        this.dayMaxDistance = dayMaxDistance;
    }

    public void setDayMaxTimes(int dayMaxTimes) {
        this.dayMaxTimes = dayMaxTimes;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setForbiddenWiFi(boolean forbiddenWiFi) {
        this.forbiddenWiFi = forbiddenWiFi;
    }

    public void setGpsWhiteFlag(boolean gpsWhiteFlag) {
        this.gpsWhiteFlag = gpsWhiteFlag;
    }

    public void setMaxFrequency(int maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public void setMaxPace(long maxPace) {
        this.maxPace = maxPace;
    }

    public void setMinFrequency(int minFrequency) {
        this.minFrequency = minFrequency;
    }

    public void setMinPace(long minPace) {
        this.minPace = minPace;
    }

    public void setMorningTimeFragment(List<String> morningTimeFragment) {
        this.morningTimeFragment = morningTimeFragment;
    }

    public void setSegmentStrideAvg(float segmentStrideAvg) {
        this.segmentStrideAvg = segmentStrideAvg;
    }

    public void setSegmentStrideExceptionNum(int segmentStrideExceptionNum) {
        this.segmentStrideExceptionNum = segmentStrideExceptionNum;
    }

    public void setSingleMaxDistance(long singleMaxDistance) {
        this.singleMaxDistance = singleMaxDistance;
    }

    public void setSingleMinDistance(long singleMinDistance) {
        this.singleMinDistance = singleMinDistance;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setSuspendTime(long suspendTime) {
        this.suspendTime = suspendTime;
    }

    public void setSwingAmplitudeThreshold(int swingAmplitudeThreshold) {
        this.swingAmplitudeThreshold = swingAmplitudeThreshold;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setTotalTimes(int totalTimes) {
        this.totalTimes = totalTimes;
    }

    public void setWeekMaxDistance(int weekMaxDistance) {
        this.weekMaxDistance = weekMaxDistance;
    }

    public void setWeekMaxTimes(int weekMaxTimes) {
        this.weekMaxTimes = weekMaxTimes;
    }

    public void setWeekMinTimes(int weekMinTimes) {
        this.weekMinTimes = weekMinTimes;
    }

    public float singleDisKmMax() {
        long j = this.singleMaxDistance;
        if (0 == j) {
            return 10.0f;
        }
        return (j * 1.0f) / 1000.0f;
    }

    public float singleDisKmMin() {
        return (this.singleMinDistance * 1.0f) / 1000.0f;
    }

    public int timeTypeEveryDaySize() {
        int i = 0;
        if (CollectionUtils.r(this.timeFragment)) {
            return 0;
        }
        Iterator<RunTimeAreaData> it = this.timeFragment.iterator();
        while (it.hasNext()) {
            if (RUN_TIME_TYPE_ERVERY_DAY.equals(it.next().getTimeType())) {
                i++;
            }
        }
        return i;
    }

    public int timeTypeWeekendSize() {
        int i = 0;
        if (CollectionUtils.r(this.timeFragment)) {
            return 0;
        }
        Iterator<RunTimeAreaData> it = this.timeFragment.iterator();
        while (it.hasNext()) {
            if (RUN_TIME_TYPE_WEEKEND.equals(it.next().getTimeType())) {
                i++;
            }
        }
        return i;
    }

    public int timeTypeWorkdaySize() {
        int i = 0;
        if (CollectionUtils.r(this.timeFragment)) {
            return 0;
        }
        Iterator<RunTimeAreaData> it = this.timeFragment.iterator();
        while (it.hasNext()) {
            if (RUN_TIME_TYPE_WORKDAY.equals(it.next().getTimeType())) {
                i++;
            }
        }
        return i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.singleMinDistance);
        parcel.writeLong(this.singleMaxDistance);
        parcel.writeInt(this.weekMinTimes);
        parcel.writeInt(this.weekMaxTimes);
        parcel.writeInt(this.weekMaxDistance);
        parcel.writeInt(this.dayMaxTimes);
        parcel.writeInt(this.dayMaxDistance);
        parcel.writeLong(this.totalDistance);
        parcel.writeInt(this.totalTimes);
        parcel.writeLong(this.minPace);
        parcel.writeLong(this.maxPace);
        parcel.writeInt(this.minFrequency);
        parcel.writeInt(this.maxFrequency);
        parcel.writeLong(this.suspendTime);
        parcel.writeByte(this.forbiddenWiFi ? (byte) 1 : (byte) 0);
        parcel.writeString(this.startDate);
        parcel.writeString(this.endDate);
        parcel.writeTypedList(this.clockModeList);
        parcel.writeStringList(this.morningTimeFragment);
        parcel.writeString(this.remark);
        parcel.writeString(this.fileName);
        parcel.writeString(this.fileUrl);
        parcel.writeTypedList(this.timeFragment);
        parcel.writeFloat(this.segmentStrideAvg);
        parcel.writeInt(this.segmentStrideExceptionNum);
        parcel.writeInt(this.swingAmplitudeThreshold);
        parcel.writeByte(this.gpsWhiteFlag ? (byte) 1 : (byte) 0);
    }

    public SchoolRule(Parcel in) {
        this.suspendTime = c.l;
        this.segmentStrideAvg = Float.MAX_VALUE;
        this.segmentStrideExceptionNum = Integer.MAX_VALUE;
        this.swingAmplitudeThreshold = 2;
        this.singleMinDistance = in.readLong();
        this.singleMaxDistance = in.readLong();
        this.weekMinTimes = in.readInt();
        this.weekMaxTimes = in.readInt();
        this.weekMaxDistance = in.readInt();
        this.dayMaxTimes = in.readInt();
        this.dayMaxDistance = in.readInt();
        this.totalDistance = in.readLong();
        this.totalTimes = in.readInt();
        this.minPace = in.readLong();
        this.maxPace = in.readLong();
        this.minFrequency = in.readInt();
        this.maxFrequency = in.readInt();
        this.suspendTime = in.readLong();
        this.forbiddenWiFi = in.readByte() != 0;
        this.startDate = in.readString();
        this.endDate = in.readString();
        this.clockModeList = in.createTypedArrayList(ClockInMode.CREATOR);
        this.morningTimeFragment = in.createStringArrayList();
        this.remark = in.readString();
        this.fileName = in.readString();
        this.fileUrl = in.readString();
        this.timeFragment = in.createTypedArrayList(RunTimeAreaData.INSTANCE);
        this.segmentStrideAvg = in.readFloat();
        this.segmentStrideExceptionNum = in.readInt();
        this.swingAmplitudeThreshold = in.readInt();
        this.gpsWhiteFlag = in.readByte() != 0;
    }
}
