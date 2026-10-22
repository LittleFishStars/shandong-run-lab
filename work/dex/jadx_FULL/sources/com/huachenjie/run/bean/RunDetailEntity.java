package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.common.bean.InvalidReason;
import com.huachenjie.common.bean.PaceInfo;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.c49;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDetailEntity extends SportRecord {
    public static final Parcelable.Creator<RunDetailEntity> CREATOR = new Parcelable.Creator<RunDetailEntity>() { // from class: com.huachenjie.run.bean.RunDetailEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDetailEntity createFromParcel(Parcel source) {
            return new RunDetailEntity(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDetailEntity[] newArray(int size) {
            return new RunDetailEntity[size];
        }
    };
    private int alignType;
    private int appealStatus;
    private List<String> auditDetail;
    private double checkLat;
    private double checkLng;
    private int clockMode;
    private int faceCheck;
    private List<RunDetailFaceCheckInfoBean> faceCheckInfoList;
    private List<RunDetailFaceClockBean> faceClockList;
    private List<InvalidReason> invalidReasons;
    private List<PaceInfo> paceInfoList;
    private long paceInterval;
    private List<Long> paceList;
    private List<HCJLatLng> pois;
    private long popTime;
    private boolean runFaceFlag;
    private String runFaceImg;
    private boolean runFaceUpload;
    private RunVision runVision;
    private List<RunRecordStatusLog> statusLogRecords;
    private int stepInterval;
    private List<Float> stepList;
    private List<TargetPoints> targetPoints;
    private String unAppealRemark;
    private String userFaceImg;
    private boolean visionDisplay;

    public RunDetailEntity() {
    }

    @Override // com.huachenjie.common.bean.SportRecord, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String formatActivityReward() {
        String reward = getReward();
        return (reward == null || reward.isEmpty()) ? "" : String.format("，活动奖励：%s", reward);
    }

    public String formatCalorie() {
        return BigDecimal.valueOf(getCalorie()).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString();
    }

    public String formatRecordStatus() {
        if (getSportType() == 2) {
            return getStatus() == 1 ? "目标失败" : "目标达成";
        }
        if (getRecheckStatus() == 2) {
            return "复核中";
        }
        int sunRunRecordStatus = getSunRunRecordStatus();
        if (sunRunRecordStatus == 2 || sunRunRecordStatus == 3 || sunRunRecordStatus == 4 || sunRunRecordStatus == 5) {
            return "无效";
        }
        return sunRunRecordStatus != 10 ? "计入成绩" : "";
    }

    public String formatRunTimeRange() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return simpleDateFormat.format(Long.valueOf(getStartTime())) + q.a.i + simpleDateFormat2.format(Long.valueOf(getStartTime())) + c49.f40900a + simpleDateFormat2.format(Long.valueOf(getEndTime()));
    }

    public String formatTotalDistanceText() {
        return String.format("本次总里程  %sKm", BigDecimal.valueOf(getDistance()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.FLOOR).toString());
    }

    public String formatValidDistance() {
        return BigDecimal.valueOf(getValidDistance()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.FLOOR).toString();
    }

    public int getAlignType() {
        return this.alignType;
    }

    public int getAppealStatus() {
        return this.appealStatus;
    }

    public List<String> getAuditDetail() {
        return this.auditDetail;
    }

    public double getCheckLat() {
        return this.checkLat;
    }

    public double getCheckLng() {
        return this.checkLng;
    }

    public int getClockMode() {
        return this.clockMode;
    }

    public int getFaceCheck() {
        return this.faceCheck;
    }

    public List<RunDetailFaceCheckInfoBean> getFaceCheckInfoList() {
        return this.faceCheckInfoList;
    }

    public int getFaceCheckResultBg() {
        if (getRecheckStatus() == 2) {
            return R.drawable.run_bg_run_detail_face_detect_review;
        }
        return this.faceCheck == 2 ? R.drawable.run_bg_run_detail_face_detect_success : R.drawable.run_bg_run_detail_face_detect_fail;
    }

    public int getFaceCheckResultColor() {
        if (getRecheckStatus() == 2) {
            return RunIndexRecordAdapter.N;
        }
        if (this.faceCheck == 2) {
            return -12858007;
        }
        return RunIndexRecordAdapter.L;
    }

    public int getFaceCheckResultIcon() {
        if (getRecheckStatus() == 2) {
            return R.drawable.run_run_ic_detail_face_warn;
        }
        return this.faceCheck == 2 ? R.drawable.run_run_ic_detail_face_success : R.drawable.run_run_ic_detail_face_fail;
    }

    public String getFaceCheckResultText() {
        if (getRecheckStatus() == 2) {
            return "人脸校验人工复核中，次日完成复核请耐心等待";
        }
        int i = this.faceCheck;
        if (i != 1) {
            return i != 2 ? "很遗憾，您的本次校验未通过！" : "您成功通过了本次校验，请再接再厉哦~";
        }
        return "很遗憾，您未完成本次跑步校验！";
    }

    public List<RunDetailFaceClockBean> getFaceClockList() {
        return this.faceClockList;
    }

    public List<InvalidReason> getInvalidReasons() {
        return this.invalidReasons;
    }

    public List<PaceInfo> getPaceInfoList() {
        return this.paceInfoList;
    }

    public long getPaceInterval() {
        return this.paceInterval;
    }

    public List<Long> getPaceList() {
        return this.paceList;
    }

    public List<HCJLatLng> getPois() {
        return this.pois;
    }

    public long getPopTime() {
        return this.popTime;
    }

    public int getRecordStatusBg() {
        if (getSportType() == 2) {
            return getStatus() == 1 ? R.drawable.run_run_bg_detail_status_error : R.drawable.run_run_bg_detail_status_ok;
        }
        if (getRecheckStatus() == 2) {
            return R.drawable.run_run_bg_detail_status_recheck;
        }
        int sunRunRecordStatus = getSunRunRecordStatus();
        return (sunRunRecordStatus == 2 || sunRunRecordStatus == 3 || sunRunRecordStatus == 4 || sunRunRecordStatus == 5) ? R.drawable.run_run_bg_detail_status_error : R.drawable.run_run_bg_detail_status_ok;
    }

    public String getRunFaceImg() {
        return this.runFaceImg;
    }

    public RunVision getRunVision() {
        return this.runVision;
    }

    public List<RunRecordStatusLog> getStatusLogRecords() {
        return this.statusLogRecords;
    }

    public int getStepInterval() {
        return this.stepInterval;
    }

    public List<Float> getStepList() {
        return this.stepList;
    }

    public List<TargetPoints> getTargetPoints() {
        return this.targetPoints;
    }

    public String getUnAppealRemark() {
        return this.unAppealRemark;
    }

    public String getUserFaceImg() {
        return this.userFaceImg;
    }

    public String getVisionActualDisplay() {
        RunVision runVision = this.runVision;
        if (runVision == null) {
            return "";
        }
        return (this.sunRunRecordStatus == 10 || runVision.getVisionStatus() == 2) ? "识别中..." : String.valueOf(this.runVision.getActualNumber());
    }

    public boolean isRunFaceFlag() {
        return this.runFaceFlag;
    }

    public boolean isRunFaceUpload() {
        return this.runFaceUpload;
    }

    public boolean isVisionDisplay() {
        return this.visionDisplay;
    }

    public void readFromParcel(Parcel source) {
        this.pois = source.createTypedArrayList(HCJLatLng.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.stepList = arrayList;
        source.readList(arrayList, Float.class.getClassLoader());
        this.stepInterval = source.readInt();
        ArrayList arrayList2 = new ArrayList();
        this.paceList = arrayList2;
        source.readList(arrayList2, Long.class.getClassLoader());
        this.paceInfoList = source.createTypedArrayList(PaceInfo.CREATOR);
        this.paceInterval = source.readLong();
        this.targetPoints = source.createTypedArrayList(TargetPoints.CREATOR);
        this.auditDetail = source.createStringArrayList();
        this.invalidReasons = source.createTypedArrayList(InvalidReason.CREATOR);
        this.unAppealRemark = source.readString();
        this.clockMode = source.readInt();
        this.alignType = source.readInt();
        this.statusLogRecords = source.createTypedArrayList(RunRecordStatusLog.CREATOR);
        this.appealStatus = source.readInt();
        this.visionDisplay = source.readByte() != 0;
        this.runVision = (RunVision) source.readParcelable(RunVision.class.getClassLoader());
        this.runFaceFlag = source.readByte() != 0;
        this.runFaceImg = source.readString();
        this.userFaceImg = source.readString();
        this.faceCheck = source.readInt();
        this.checkLat = source.readDouble();
        this.checkLng = source.readDouble();
        this.popTime = source.readLong();
        this.runFaceUpload = source.readByte() != 0;
        this.faceClockList = source.createTypedArrayList(RunDetailFaceClockBean.CREATOR);
        this.faceCheckInfoList = source.createTypedArrayList(RunDetailFaceCheckInfoBean.CREATOR);
    }

    public void setAlignType(int alignType) {
        this.alignType = alignType;
    }

    public void setAppealStatus(int appealStatus) {
        this.appealStatus = appealStatus;
    }

    public void setAuditDetail(List<String> auditDetail) {
        this.auditDetail = auditDetail;
    }

    public void setCheckLat(double checkLat) {
        this.checkLat = checkLat;
    }

    public void setCheckLng(double checkLng) {
        this.checkLng = checkLng;
    }

    public void setClockMode(int clockMode) {
        this.clockMode = clockMode;
    }

    public void setFaceCheck(int faceCheck) {
        this.faceCheck = faceCheck;
    }

    public void setFaceCheckInfoList(List<RunDetailFaceCheckInfoBean> faceCheckInfoList) {
        this.faceCheckInfoList = faceCheckInfoList;
    }

    public void setFaceClockList(List<RunDetailFaceClockBean> faceClockList) {
        this.faceClockList = faceClockList;
    }

    public void setInvalidReasons(List<InvalidReason> invalidReasons) {
        this.invalidReasons = invalidReasons;
    }

    public void setPaceInfoList(List<PaceInfo> paceInfoList) {
        this.paceInfoList = paceInfoList;
    }

    public void setPaceInterval(long paceInterval) {
        this.paceInterval = paceInterval;
    }

    public void setPaceList(List<Long> paceList) {
        this.paceList = paceList;
    }

    public void setPois(List<HCJLatLng> pois) {
        this.pois = pois;
    }

    public void setPopTime(long popTime) {
        this.popTime = popTime;
    }

    public void setRunFaceFlag(boolean runFaceFlag) {
        this.runFaceFlag = runFaceFlag;
    }

    public void setRunFaceImg(String runFaceImg) {
        this.runFaceImg = runFaceImg;
    }

    public void setRunFaceUpload(boolean runFaceUpload) {
        this.runFaceUpload = runFaceUpload;
    }

    public void setRunVision(RunVision runVision) {
        this.runVision = runVision;
    }

    public void setStatusLogRecords(List<RunRecordStatusLog> statusLogRecords) {
        this.statusLogRecords = statusLogRecords;
    }

    public void setStepInterval(int stepInterval) {
        this.stepInterval = stepInterval;
    }

    public void setStepList(List<Float> stepList) {
        this.stepList = stepList;
    }

    public void setTargetPoints(List<TargetPoints> targetPoints) {
        this.targetPoints = targetPoints;
    }

    public void setUnAppealRemark(String unAppealRemark) {
        this.unAppealRemark = unAppealRemark;
    }

    public void setUserFaceImg(String userFaceImg) {
        this.userFaceImg = userFaceImg;
    }

    public void setVisionDisplay(boolean visionDisplay) {
        this.visionDisplay = visionDisplay;
    }

    @Override // com.huachenjie.common.bean.SportRecord, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.pois);
        parcel.writeList(this.stepList);
        parcel.writeInt(this.stepInterval);
        parcel.writeList(this.paceList);
        parcel.writeTypedList(this.paceInfoList);
        parcel.writeLong(this.paceInterval);
        parcel.writeTypedList(this.targetPoints);
        parcel.writeStringList(this.auditDetail);
        parcel.writeTypedList(this.invalidReasons);
        parcel.writeString(this.unAppealRemark);
        parcel.writeInt(this.clockMode);
        parcel.writeInt(this.alignType);
        parcel.writeTypedList(this.statusLogRecords);
        parcel.writeInt(this.appealStatus);
        parcel.writeByte(this.visionDisplay ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.runVision, i);
        parcel.writeByte(this.runFaceFlag ? (byte) 1 : (byte) 0);
        parcel.writeString(this.runFaceImg);
        parcel.writeString(this.userFaceImg);
        parcel.writeInt(this.faceCheck);
        parcel.writeDouble(this.checkLat);
        parcel.writeDouble(this.checkLng);
        parcel.writeLong(this.popTime);
        parcel.writeByte(this.runFaceUpload ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.faceClockList);
        parcel.writeTypedList(this.faceCheckInfoList);
    }

    public RunDetailEntity(Parcel in) {
        super(in);
        this.pois = in.createTypedArrayList(HCJLatLng.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.stepList = arrayList;
        in.readList(arrayList, Float.class.getClassLoader());
        this.stepInterval = in.readInt();
        ArrayList arrayList2 = new ArrayList();
        this.paceList = arrayList2;
        in.readList(arrayList2, Long.class.getClassLoader());
        this.paceInfoList = in.createTypedArrayList(PaceInfo.CREATOR);
        this.paceInterval = in.readLong();
        this.targetPoints = in.createTypedArrayList(TargetPoints.CREATOR);
        this.auditDetail = in.createStringArrayList();
        this.invalidReasons = in.createTypedArrayList(InvalidReason.CREATOR);
        this.unAppealRemark = in.readString();
        this.clockMode = in.readInt();
        this.alignType = in.readInt();
        this.statusLogRecords = in.createTypedArrayList(RunRecordStatusLog.CREATOR);
        this.appealStatus = in.readInt();
        this.visionDisplay = in.readByte() != 0;
        this.runVision = (RunVision) in.readParcelable(RunVision.class.getClassLoader());
        this.runFaceFlag = in.readByte() != 0;
        this.runFaceImg = in.readString();
        this.userFaceImg = in.readString();
        this.faceCheck = in.readInt();
        this.checkLat = in.readDouble();
        this.checkLng = in.readDouble();
        this.popTime = in.readLong();
        this.runFaceUpload = in.readByte() != 0;
        this.faceClockList = in.createTypedArrayList(RunDetailFaceClockBean.CREATOR);
        this.faceCheckInfoList = in.createTypedArrayList(RunDetailFaceCheckInfoBean.CREATOR);
    }
}
