package com.alibaba.ariver.kernel.ipc.uniform;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IPCResult implements Parcelable {
    public static final Parcelable.Creator<IPCResult> CREATOR = new Parcelable.Creator<IPCResult>() { // from class: com.alibaba.ariver.kernel.ipc.uniform.IPCResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCResult createFromParcel(Parcel parcel) {
            return new IPCResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCResult[] newArray(int i) {
            return new IPCResult[i];
        }
    };
    public static final byte SER_TYPE_PARCELABLE = 2;
    public static final byte SER_TYPE_SERIALIZE = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24294a = "IPCResult";
    public Parcelable parcelable;
    public int resultCode;
    public String resultMsg;
    public String resultType;
    public byte[] resultValue;
    public byte serType;

    public IPCResult() {
        this.resultCode = 0;
        this.resultMsg = "";
        this.serType = (byte) 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.serType = parcel.readByte();
            this.resultCode = parcel.readInt();
            this.resultMsg = parcel.readString();
            String string = parcel.readString();
            this.resultType = string;
            if (TextUtils.equals(string, Void.TYPE.getName())) {
                return;
            }
            if (this.serType == 2) {
                this.parcelable = parcel.readParcelable(getClass().getClassLoader());
            } else {
                this.resultValue = parcel.createByteArray();
            }
        } catch (Exception e) {
            RVLogger.e(f24294a, "readFromParcel exception", e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeByte(this.serType);
            parcel.writeInt(this.resultCode);
            parcel.writeString(this.resultMsg);
            if (TextUtils.isEmpty(this.resultType)) {
                String name = Void.TYPE.getName();
                this.resultType = name;
                parcel.writeString(name);
                return;
            }
            parcel.writeString(this.resultType);
            if (this.serType == 2) {
                parcel.writeParcelable(this.parcelable, i);
                return;
            }
            if (this.resultValue == null) {
                this.resultValue = new byte[0];
            }
            parcel.writeByteArray(this.resultValue);
        } catch (Exception e) {
            RVLogger.e(f24294a, "writeToParcel exception", e);
        }
    }

    public IPCResult(Parcel parcel) {
        this.resultCode = 0;
        this.resultMsg = "";
        readFromParcel(parcel);
    }
}
