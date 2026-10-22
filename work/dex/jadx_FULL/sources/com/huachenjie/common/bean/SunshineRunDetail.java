package com.huachenjie.common.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.zj.adlib.z62;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SunshineRunDetail implements Parcelable {
    public static final Parcelable.Creator<SunshineRunDetail> CREATOR = new Parcelable.Creator<SunshineRunDetail>() { // from class: com.huachenjie.common.bean.SunshineRunDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SunshineRunDetail createFromParcel(Parcel in) {
            return new SunshineRunDetail(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SunshineRunDetail[] newArray(int size) {
            return new SunshineRunDetail[size];
        }
    };
    public static final int PLAN_TYPE_BY_DISTANCE = 3;
    public static final int PLAN_TYPE_BY_TIMES = 2;
    public static final int PLAN_TYPE_DEFALUT = 1;
    private String aiMoringTimes;
    private boolean creditSwordStatus;
    private int deductionDistance;
    private int deductionTimes;
    private int outsideAttendDeductionDistance;
    private int outsideAttendDeductionTimes;
    private int planType;
    private String runPlanCode;
    private String schoolCode;
    private SchoolRule schoolDemandRule;
    private int stadiumDeductionDistance;
    private int stadiumDeductionTimes;
    private StudentDoneRule studentDoneRuleInfo;
    private int swordChargingNum;
    private int userStatus;
    private boolean validStatus;
    private int wearableDeductionDistance;
    private int wearableDeductionTimes;

    public SunshineRunDetail(Parcel in) {
        this.planType = 0;
        this.validStatus = in.readByte() != 0;
        this.schoolCode = in.readString();
        this.runPlanCode = in.readString();
        this.planType = in.readInt();
        this.schoolDemandRule = (SchoolRule) in.readParcelable(SchoolRule.class.getClassLoader());
        this.studentDoneRuleInfo = (StudentDoneRule) in.readParcelable(StudentDoneRule.class.getClassLoader());
        this.deductionDistance = in.readInt();
        this.deductionTimes = in.readInt();
        this.aiMoringTimes = in.readString();
        this.creditSwordStatus = in.readByte() != 0;
        this.userStatus = in.readInt();
        this.swordChargingNum = in.readInt();
        this.stadiumDeductionDistance = in.readInt();
        this.stadiumDeductionTimes = in.readInt();
        this.wearableDeductionDistance = in.readInt();
        this.wearableDeductionTimes = in.readInt();
        this.outsideAttendDeductionDistance = in.readInt();
        this.outsideAttendDeductionTimes = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SuppressLint({"DefaultLocale"})
    public String getAiDeductionInfo() {
        int i = this.deductionDistance;
        if (i > 0 && this.planType == 3) {
            return String.format("AI锻炼已抵扣%s公里", z62.f46193a.c(Long.valueOf(i), 1));
        }
        int i2 = this.deductionTimes;
        return (i2 <= 0 || this.planType != 2) ? "" : String.format("AI锻炼已抵扣%d次", Integer.valueOf(i2));
    }

    public String getAiMoringTimes() {
        return this.aiMoringTimes;
    }

    public int getDeductionDistance() {
        return this.deductionDistance;
    }

    public int getDeductionTimes() {
        return this.deductionTimes;
    }

    public int getOutsideAttendDeductionDistance() {
        return this.outsideAttendDeductionDistance;
    }

    @SuppressLint({"DefaultLocale"})
    public String getOutsideAttendDeductionInfo() {
        int i = this.outsideAttendDeductionDistance;
        if (i > 0 && this.planType == 3) {
            return String.format("课外考勤已抵扣%s公里", z62.f46193a.c(Long.valueOf(i), 1));
        }
        int i2 = this.outsideAttendDeductionTimes;
        return (i2 <= 0 || this.planType != 2) ? "" : String.format("课外考勤已抵扣%d次", Integer.valueOf(i2));
    }

    public int getOutsideAttendDeductionTimes() {
        return this.outsideAttendDeductionTimes;
    }

    public int getPlanType() {
        return this.planType;
    }

    public String getRunPlanCode() {
        return this.runPlanCode;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public SchoolRule getSchoolDemandRule() {
        return this.schoolDemandRule;
    }

    public int getStadiumDeductionDistance() {
        return this.stadiumDeductionDistance;
    }

    @SuppressLint({"DefaultLocale"})
    public String getStadiumDeductionInfo() {
        int i = this.stadiumDeductionDistance;
        if (i > 0 && this.planType == 3) {
            return String.format("场馆锻炼已抵扣%s公里", z62.f46193a.c(Long.valueOf(i), 1));
        }
        int i2 = this.stadiumDeductionTimes;
        return (i2 <= 0 || this.planType != 2) ? "" : String.format("场馆锻炼已抵扣%d次", Integer.valueOf(i2));
    }

    public int getStadiumDeductionTimes() {
        return this.stadiumDeductionTimes;
    }

    public StudentDoneRule getStudentDoneRuleInfo() {
        return this.studentDoneRuleInfo;
    }

    public int getSwordChargingNum() {
        return this.swordChargingNum;
    }

    public int getUserStatus() {
        return this.userStatus;
    }

    public int getWearableDeductionDistance() {
        return this.wearableDeductionDistance;
    }

    @SuppressLint({"DefaultLocale"})
    public String getWearableDeductionInfo() {
        int i = this.wearableDeductionDistance;
        if (i > 0 && this.planType == 3) {
            return String.format("运动手表已抵扣%s公里", z62.f46193a.c(Long.valueOf(i), 1));
        }
        int i2 = this.wearableDeductionTimes;
        return (i2 <= 0 || this.planType != 2) ? "" : String.format("运动手表已抵扣%d次", Integer.valueOf(i2));
    }

    public int getWearableDeductionTimes() {
        return this.wearableDeductionTimes;
    }

    public boolean isCreditSwordStatus() {
        return this.creditSwordStatus;
    }

    public boolean isValidStatus() {
        return this.validStatus;
    }

    public void setAiMoringTimes(String aiMoringTimes) {
        this.aiMoringTimes = aiMoringTimes;
    }

    public void setCreditSwordStatus(boolean creditSwordStatus) {
        this.creditSwordStatus = creditSwordStatus;
    }

    public void setDeductionDistance(int deductionDistance) {
        this.deductionDistance = deductionDistance;
    }

    public void setDeductionTimes(int deductionTimes) {
        this.deductionTimes = deductionTimes;
    }

    public void setOutsideAttendDeductionDistance(int outsideAttendDeductionDistance) {
        this.outsideAttendDeductionDistance = outsideAttendDeductionDistance;
    }

    public void setOutsideAttendDeductionTimes(int outsideAttendDeductionTimes) {
        this.outsideAttendDeductionTimes = outsideAttendDeductionTimes;
    }

    public SunshineRunDetail setPlanType(int planType) {
        this.planType = planType;
        return this;
    }

    public SunshineRunDetail setRunPlanCode(String runPlanCode) {
        this.runPlanCode = runPlanCode;
        return this;
    }

    public SunshineRunDetail setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
        return this;
    }

    public SunshineRunDetail setSchoolDemandRule(SchoolRule schoolDemandRule) {
        this.schoolDemandRule = schoolDemandRule;
        return this;
    }

    public void setStadiumDeductionDistance(int stadiumDeductionDistance) {
        this.stadiumDeductionDistance = stadiumDeductionDistance;
    }

    public void setStadiumDeductionTimes(int stadiumDeductionTimes) {
        this.stadiumDeductionTimes = stadiumDeductionTimes;
    }

    public SunshineRunDetail setStudentDoneRuleInfo(StudentDoneRule studentDoneRuleInfo) {
        this.studentDoneRuleInfo = studentDoneRuleInfo;
        return this;
    }

    public void setSwordChargingNum(int swordChargingNum) {
        this.swordChargingNum = swordChargingNum;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public SunshineRunDetail setValidStatus(boolean validStatus) {
        this.validStatus = validStatus;
        return this;
    }

    public void setWearableDeductionDistance(int wearableDeductionDistance) {
        this.wearableDeductionDistance = wearableDeductionDistance;
    }

    public void setWearableDeductionTimes(int wearableDeductionTimes) {
        this.wearableDeductionTimes = wearableDeductionTimes;
    }

    public boolean showAiDeductionTip() {
        return !TextUtils.isEmpty(getAiDeductionInfo());
    }

    public boolean showOutsideAttendDeductionTip() {
        return !TextUtils.isEmpty(getOutsideAttendDeductionInfo());
    }

    public boolean showStadiumDeductionTip() {
        return !TextUtils.isEmpty(getStadiumDeductionInfo());
    }

    public boolean showWearableDeductionTip() {
        return !TextUtils.isEmpty(getWearableDeductionInfo());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte(this.validStatus ? (byte) 1 : (byte) 0);
        parcel.writeString(this.schoolCode);
        parcel.writeString(this.runPlanCode);
        parcel.writeInt(this.planType);
        parcel.writeParcelable(this.schoolDemandRule, i);
        parcel.writeParcelable(this.studentDoneRuleInfo, i);
        parcel.writeInt(this.deductionDistance);
        parcel.writeInt(this.deductionTimes);
        parcel.writeString(this.aiMoringTimes);
        parcel.writeByte(this.creditSwordStatus ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.userStatus);
        parcel.writeInt(this.swordChargingNum);
        parcel.writeInt(this.stadiumDeductionDistance);
        parcel.writeInt(this.stadiumDeductionTimes);
        parcel.writeInt(this.wearableDeductionDistance);
        parcel.writeInt(this.wearableDeductionTimes);
        parcel.writeInt(this.outsideAttendDeductionDistance);
        parcel.writeInt(this.outsideAttendDeductionTimes);
    }
}
