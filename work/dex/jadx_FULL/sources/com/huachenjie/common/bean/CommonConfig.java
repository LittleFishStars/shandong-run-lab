package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CommonConfig implements Parcelable {
    public static final Parcelable.Creator<CommonConfig> CREATOR = new Parcelable.Creator<CommonConfig>() { // from class: com.huachenjie.common.bean.CommonConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonConfig createFromParcel(Parcel in) {
            return new CommonConfig(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonConfig[] newArray(int size) {
            return new CommonConfig[size];
        }
    };
    private int adIntervalDuration;
    private int amapGPSLevel;
    private int autoStopDuration;
    private int gpsAbnormalMaxTimes;
    private int gpsFilterAccuracy;
    private boolean kyyShieldSwitch;
    private int materialToEnergy;
    private int paceAbnormalTime;
    private long paceInterval;
    private int poiInterval;
    private float runFilterAccuracy;
    private String schoolIconImg;
    private long sensitiveDistance;
    private String serviceWechat;
    private int stepInterval;
    private int strideStatisticsInterval;
    private long validDistance;

    public CommonConfig() {
        this.runFilterAccuracy = 50.0f;
        this.poiInterval = 15;
        this.validDistance = 25L;
        this.sensitiveDistance = 45L;
        this.paceInterval = 50L;
        this.stepInterval = 20;
        this.paceAbnormalTime = 120;
        this.amapGPSLevel = 3;
        this.strideStatisticsInterval = 100;
        this.materialToEnergy = 2;
        this.adIntervalDuration = 180;
        this.gpsAbnormalMaxTimes = 4;
        this.kyyShieldSwitch = false;
        this.gpsFilterAccuracy = 150;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdIntervalDuration() {
        return this.adIntervalDuration;
    }

    public int getAmapGPSLevel() {
        return this.amapGPSLevel;
    }

    public int getAutoStopDuration() {
        return this.autoStopDuration;
    }

    public int getGpsAbnormalMaxTimes() {
        return this.gpsAbnormalMaxTimes;
    }

    public int getGpsFilterAccuracy() {
        return this.gpsFilterAccuracy;
    }

    public int getMaterialToEnergy() {
        return this.materialToEnergy;
    }

    public int getPaceAbnormalTime() {
        return this.paceAbnormalTime;
    }

    public long getPaceInterval() {
        return this.paceInterval;
    }

    public int getPoiInterval() {
        return this.poiInterval;
    }

    public float getRunFilterAccuracy() {
        return this.runFilterAccuracy;
    }

    public String getSchoolIconImg() {
        return this.schoolIconImg;
    }

    public long getSensitiveDistance() {
        return this.sensitiveDistance;
    }

    public String getServiceWechat() {
        return this.serviceWechat;
    }

    public int getStepInterval() {
        int i = this.stepInterval;
        if (i == 0) {
            return 20;
        }
        return i;
    }

    public int getStrideStatisticsInterval() {
        return this.strideStatisticsInterval;
    }

    public long getValidDistance() {
        return this.validDistance;
    }

    public boolean isKyyShieldSwitch() {
        return this.kyyShieldSwitch;
    }

    public void setAdIntervalDuration(int adIntervalDuration) {
        this.adIntervalDuration = adIntervalDuration;
    }

    public void setAmapGPSLevel(int amapGPSLevel) {
        this.amapGPSLevel = amapGPSLevel;
    }

    public void setAutoStopDuration(int autoStopDuration) {
        this.autoStopDuration = autoStopDuration;
    }

    public void setGpsAbnormalMaxTimes(int gpsAbnormalMaxTimes) {
        this.gpsAbnormalMaxTimes = gpsAbnormalMaxTimes;
    }

    public void setGpsFilterAccuracy(int gpsFilterAccuracy) {
        this.gpsFilterAccuracy = gpsFilterAccuracy;
    }

    public void setKyyShieldSwitch(boolean kyyShieldSwitch) {
        this.kyyShieldSwitch = kyyShieldSwitch;
    }

    public void setMaterialToEnergy(int materialToEnergy) {
        this.materialToEnergy = materialToEnergy;
    }

    public void setPaceAbnormalTime(int paceAbnormalTime) {
        this.paceAbnormalTime = paceAbnormalTime;
    }

    public void setPaceInterval(long paceInterval) {
        this.paceInterval = paceInterval;
    }

    public void setPoiInterval(int poiInterval) {
        this.poiInterval = poiInterval;
    }

    public void setRunFilterAccuracy(float runFilterAccuracy) {
        this.runFilterAccuracy = runFilterAccuracy;
    }

    public void setSchoolIconImg(String schoolIconImg) {
        this.schoolIconImg = schoolIconImg;
    }

    public void setSensitiveDistance(long sensitiveDistance) {
        this.sensitiveDistance = sensitiveDistance;
    }

    public void setServiceWechat(String serviceWechat) {
        this.serviceWechat = serviceWechat;
    }

    public void setStepInterval(int stepInterval) {
        this.stepInterval = stepInterval;
    }

    public void setStrideStatisticsInterval(int strideStatisticsInterval) {
        this.strideStatisticsInterval = strideStatisticsInterval;
    }

    public void setValidDistance(long validDistance) {
        this.validDistance = validDistance;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.runFilterAccuracy);
        parcel.writeInt(this.poiInterval);
        parcel.writeLong(this.validDistance);
        parcel.writeLong(this.sensitiveDistance);
        parcel.writeLong(this.paceInterval);
        parcel.writeInt(this.stepInterval);
        parcel.writeString(this.serviceWechat);
        parcel.writeInt(this.paceAbnormalTime);
        parcel.writeInt(this.autoStopDuration);
        parcel.writeInt(this.amapGPSLevel);
        parcel.writeInt(this.strideStatisticsInterval);
        parcel.writeInt(this.materialToEnergy);
        parcel.writeInt(this.adIntervalDuration);
        parcel.writeInt(this.gpsAbnormalMaxTimes);
        parcel.writeString(this.schoolIconImg);
        parcel.writeByte(this.kyyShieldSwitch ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.gpsFilterAccuracy);
    }

    public CommonConfig(Parcel in) {
        this.runFilterAccuracy = 50.0f;
        this.poiInterval = 15;
        this.validDistance = 25L;
        this.sensitiveDistance = 45L;
        this.paceInterval = 50L;
        this.stepInterval = 20;
        this.paceAbnormalTime = 120;
        this.amapGPSLevel = 3;
        this.strideStatisticsInterval = 100;
        this.materialToEnergy = 2;
        this.adIntervalDuration = 180;
        this.gpsAbnormalMaxTimes = 4;
        this.kyyShieldSwitch = false;
        this.gpsFilterAccuracy = 150;
        this.runFilterAccuracy = in.readFloat();
        this.poiInterval = in.readInt();
        this.validDistance = in.readLong();
        this.sensitiveDistance = in.readLong();
        this.paceInterval = in.readLong();
        this.stepInterval = in.readInt();
        this.serviceWechat = in.readString();
        this.paceAbnormalTime = in.readInt();
        this.autoStopDuration = in.readInt();
        this.amapGPSLevel = in.readInt();
        this.strideStatisticsInterval = in.readInt();
        this.materialToEnergy = in.readInt();
        this.adIntervalDuration = in.readInt();
        this.gpsAbnormalMaxTimes = in.readInt();
        this.schoolIconImg = in.readString();
        this.kyyShieldSwitch = in.readByte() != 0;
        this.gpsFilterAccuracy = in.readInt();
    }
}
