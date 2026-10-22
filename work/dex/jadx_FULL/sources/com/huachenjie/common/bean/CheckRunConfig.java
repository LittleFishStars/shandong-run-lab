package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CheckRunConfig implements Parcelable {
    public static final Parcelable.Creator<CheckRunConfig> CREATOR = new Parcelable.Creator<CheckRunConfig>() { // from class: com.huachenjie.common.bean.CheckRunConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckRunConfig createFromParcel(Parcel in) {
            return new CheckRunConfig(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckRunConfig[] newArray(int size) {
            return new CheckRunConfig[size];
        }
    };
    private AlertTip alertTip;
    private boolean bodyEnable;
    private int bodyRate;
    private boolean faceAuth;
    private List<FaceCheckConfig> faceCheckConfigList;
    private int faceEnabled;
    private String faceImg;
    private int faceModelType;
    private int faceTime;
    private int nfcPauseDuration;
    private int runScene;
    private String semesterCode;
    private int similarityValue;
    private SunRunActivityData sunRunActivity;

    public CheckRunConfig(Parcel in) {
        this.runScene = in.readInt();
        this.alertTip = (AlertTip) in.readParcelable(AlertTip.class.getClassLoader());
        this.sunRunActivity = (SunRunActivityData) in.readParcelable(SunRunActivityData.class.getClassLoader());
        this.faceAuth = in.readByte() != 0;
        this.faceImg = in.readString();
        this.similarityValue = in.readInt();
        this.faceTime = in.readInt();
        this.bodyEnable = in.readByte() != 0;
        this.bodyRate = in.readInt();
        this.semesterCode = in.readString();
        this.faceModelType = in.readInt();
        this.faceCheckConfigList = in.createTypedArrayList(FaceCheckConfig.CREATOR);
        this.faceEnabled = in.readInt();
        this.nfcPauseDuration = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AlertTip getAlertTip() {
        return this.alertTip;
    }

    public boolean getBodyEnable() {
        return this.bodyEnable;
    }

    public int getBodyRate() {
        return this.bodyRate;
    }

    public List<FaceCheckConfig> getFaceCheckConfigList() {
        return this.faceCheckConfigList;
    }

    public int getFaceEnabled() {
        return this.faceEnabled;
    }

    public String getFaceImg() {
        return this.faceImg;
    }

    public int getFaceModelType() {
        return this.faceModelType;
    }

    public int getFaceTime() {
        return this.faceTime;
    }

    public int getNfcPauseDuration() {
        return this.nfcPauseDuration;
    }

    public int getRunScene() {
        return this.runScene;
    }

    public String getSemesterCode() {
        return this.semesterCode;
    }

    public int getSimilarityValue() {
        return this.similarityValue;
    }

    public SunRunActivityData getSunRunActivity() {
        return this.sunRunActivity;
    }

    public boolean isFaceAuth() {
        return this.faceAuth;
    }

    public void setAlertTip(AlertTip alertTip) {
        this.alertTip = alertTip;
    }

    public void setBodyEnable(boolean bodyEnable) {
        this.bodyEnable = bodyEnable;
    }

    public void setBodyRate(int bodyRate) {
        this.bodyRate = bodyRate;
    }

    public void setFaceAuth(boolean faceAuth) {
        this.faceAuth = faceAuth;
    }

    public void setFaceCheckConfigList(List<FaceCheckConfig> faceCheckConfigList) {
        this.faceCheckConfigList = faceCheckConfigList;
    }

    public void setFaceEnabled(int faceEnabled) {
        this.faceEnabled = faceEnabled;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public void setFaceModelType(int faceModelType) {
        this.faceModelType = faceModelType;
    }

    public void setFaceTime(int faceTime) {
        this.faceTime = faceTime;
    }

    public void setNfcPauseDuration(int nfcPauseDuration) {
        this.nfcPauseDuration = nfcPauseDuration;
    }

    public void setRunScene(int runScene) {
        this.runScene = runScene;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    public void setSimilarityValue(int similarityValue) {
        this.similarityValue = similarityValue;
    }

    public void setSunRunActivity(SunRunActivityData sunRunActivity) {
        this.sunRunActivity = sunRunActivity;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.runScene);
        parcel.writeParcelable(this.alertTip, i);
        parcel.writeParcelable(this.sunRunActivity, i);
        parcel.writeByte(this.faceAuth ? (byte) 1 : (byte) 0);
        parcel.writeString(this.faceImg);
        parcel.writeInt(this.similarityValue);
        parcel.writeInt(this.faceTime);
        parcel.writeByte(this.bodyEnable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.bodyRate);
        parcel.writeString(this.semesterCode);
        parcel.writeInt(this.faceModelType);
        parcel.writeTypedList(this.faceCheckConfigList);
        parcel.writeInt(this.faceEnabled);
        parcel.writeInt(this.nfcPauseDuration);
    }
}
