package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.s72;
import com.zj.adlib.ys8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDetailFaceClockBean implements Parcelable {
    public static final Parcelable.Creator<RunDetailFaceClockBean> CREATOR = new Parcelable.Creator<RunDetailFaceClockBean>() { // from class: com.huachenjie.run.bean.RunDetailFaceClockBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDetailFaceClockBean createFromParcel(Parcel in) {
            return new RunDetailFaceClockBean(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDetailFaceClockBean[] newArray(int size) {
            return new RunDetailFaceClockBean[size];
        }
    };
    private long clockTime;
    private String pointName;
    private boolean warn;
    private String warnMsg;

    public RunDetailFaceClockBean() {
        this.clockTime = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getClockTime() {
        return this.clockTime;
    }

    public int getDotBg() {
        if (this.clockTime <= 0) {
            return R.drawable.run_run_shape_detail_machine_dot_empty;
        }
        return this.warn ? R.drawable.run_run_shape_detail_machine_dot_warn : R.drawable.run_run_shape_detail_machine_dot_normal;
    }

    public int getNameColor() {
        if (this.clockTime <= 0) {
            return -3355444;
        }
        return this.warn ? RunIndexRecordAdapter.N : RunIndexRecordAdapter.K;
    }

    public String getPointName() {
        return this.pointName;
    }

    public int getTimeColor() {
        if (this.clockTime <= 0) {
            return -3355444;
        }
        if (this.warn) {
            return RunIndexRecordAdapter.N;
        }
        return -9078407;
    }

    public String getTimeDisplay() {
        long j = this.clockTime;
        return j <= 0 ? ys8.e(R.string.run_run_detail_machine_no_record) : s72.a(j * 1000);
    }

    public String getWarnMsg() {
        return this.warnMsg;
    }

    public boolean isWarn() {
        return this.warn;
    }

    public void readFromParcel(Parcel source) {
        this.pointName = source.readString();
        this.clockTime = source.readLong();
        this.warn = source.readByte() != 0;
        this.warnMsg = source.readString();
    }

    public void setClockTime(long clockTime) {
        this.clockTime = clockTime;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public void setWarn(boolean warn) {
        this.warn = warn;
    }

    public void setWarnMsg(String warnMsg) {
        this.warnMsg = warnMsg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.pointName);
        parcel.writeLong(this.clockTime);
        parcel.writeByte(this.warn ? (byte) 1 : (byte) 0);
        parcel.writeString(this.warnMsg);
    }

    public RunDetailFaceClockBean(Parcel in) {
        this.clockTime = 0L;
        this.pointName = in.readString();
        this.clockTime = in.readLong();
        this.warn = in.readByte() != 0;
        this.warnMsg = in.readString();
    }
}
