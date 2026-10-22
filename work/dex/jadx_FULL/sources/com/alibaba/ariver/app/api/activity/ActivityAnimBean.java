package com.alibaba.ariver.app.api.activity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.AnimRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActivityAnimBean implements Parcelable {
    public static final Parcelable.Creator<ActivityAnimBean> CREATOR = new Parcelable.Creator<ActivityAnimBean>() { // from class: com.alibaba.ariver.app.api.activity.ActivityAnimBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityAnimBean createFromParcel(Parcel parcel) {
            return new ActivityAnimBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityAnimBean[] newArray(int i) {
            return new ActivityAnimBean[i];
        }
    };

    @AnimRes
    public int enter;

    @AnimRes
    public int enterFast;

    @AnimRes
    public int exit;

    @AnimRes
    public int exitFast;
    public boolean needPopAnim;
    public boolean needRestartAnim;

    @AnimRes
    public int popEnter;

    @AnimRes
    public int popExit;

    public ActivityAnimBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityAnimBean{enter=" + this.enter + ", exit=" + this.exit + ", needPopAnim=" + this.needPopAnim + ", popEnter=" + this.popEnter + ", popExit=" + this.popExit + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.enter);
        parcel.writeInt(this.exit);
        parcel.writeByte(this.needRestartAnim ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enterFast);
        parcel.writeInt(this.exitFast);
        parcel.writeByte(this.needPopAnim ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.popEnter);
        parcel.writeInt(this.popExit);
    }

    public ActivityAnimBean(Parcel parcel) {
        this.enter = parcel.readInt();
        this.exit = parcel.readInt();
        this.needRestartAnim = parcel.readByte() != 0;
        this.enterFast = parcel.readInt();
        this.exitFast = parcel.readInt();
        this.needPopAnim = parcel.readByte() != 0;
        this.popEnter = parcel.readInt();
        this.popExit = parcel.readInt();
    }
}
