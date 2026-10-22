package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class RunRecordStatusLog implements Parcelable {
    public static final Parcelable.Creator<RunRecordStatusLog> CREATOR = new Parcelable.Creator<RunRecordStatusLog>() { // from class: com.huachenjie.common.bean.RunRecordStatusLog.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunRecordStatusLog createFromParcel(Parcel in) {
            return new RunRecordStatusLog(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunRecordStatusLog[] newArray(int size) {
            return new RunRecordStatusLog[size];
        }
    };
    private boolean appealFlag;
    private List<String> remark;
    private int sourceType;
    private int status;
    private long updateTime;

    public RunRecordStatusLog(Parcel in) {
        this.sourceType = in.readInt();
        this.status = in.readInt();
        this.appealFlag = in.readByte() != 0;
        this.remark = in.createStringArrayList();
        this.updateTime = in.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getRemark() {
        return this.remark;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int getStatus() {
        return this.status;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isAppealFlag() {
        return this.appealFlag;
    }

    public void setAppealFlag(boolean appealFlag) {
        this.appealFlag = appealFlag;
    }

    public void setRemark(List<String> remark) {
        this.remark = remark;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sourceType);
        parcel.writeInt(this.status);
        parcel.writeByte(this.appealFlag ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.remark);
        parcel.writeLong(this.updateTime);
    }
}
