package com.alibaba.ariver.kernel.ipc.uniform;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IPCParameter implements Parcelable {
    public static final Parcelable.Creator<IPCParameter> CREATOR = new Parcelable.Creator<IPCParameter>() { // from class: com.alibaba.ariver.kernel.ipc.uniform.IPCParameter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCParameter createFromParcel(Parcel parcel) {
            return new IPCParameter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCParameter[] newArray(int i) {
            return new IPCParameter[i];
        }
    };
    public static final byte SER_TYPE_PARCELABLE = 2;
    public static final byte SER_TYPE_SERIALIZE = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24293a = "IPCParameter";
    public String className;
    public String methodName;
    public String[] paramTypes;
    public List<byte[]> paramValues;
    public Parcelable parcelable;
    public String returnType;
    public byte serType;

    public IPCParameter() {
        this.className = "";
        this.methodName = "";
        this.serType = (byte) 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.serType = parcel.readByte();
            this.className = parcel.readString();
            this.methodName = parcel.readString();
            this.returnType = parcel.readString();
            String[] strArrCreateStringArray = parcel.createStringArray();
            this.paramTypes = strArrCreateStringArray;
            if (strArrCreateStringArray != null && strArrCreateStringArray.length != 0) {
                if (this.serType == 2) {
                    this.parcelable = parcel.readParcelable(getClass().getClassLoader());
                    return;
                }
                this.paramValues = new ArrayList(this.paramTypes.length);
                for (int i = 0; i < this.paramTypes.length; i++) {
                    this.paramValues.add(parcel.createByteArray());
                }
            }
        } catch (Exception e) {
            RVLogger.e(f24293a, "readFromParcel exception occurs", e);
        }
    }

    public String toString() {
        return "IPCParameter{className='" + this.className + "', methodName='" + this.methodName + "', paramTypes=" + Arrays.toString(this.paramTypes) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeByte(this.serType);
            parcel.writeString(this.className);
            parcel.writeString(this.methodName);
            parcel.writeString(this.returnType);
            String[] strArr = this.paramTypes;
            if (strArr == null || strArr.length == 0) {
                this.paramTypes = new String[0];
            }
            parcel.writeStringArray(this.paramTypes);
            if (this.serType == 2) {
                parcel.writeParcelable(this.parcelable, i);
                return;
            }
            for (int i2 = 0; i2 < this.paramTypes.length; i2++) {
                parcel.writeByteArray(this.paramValues.get(i2));
            }
        } catch (Exception e) {
            RVLogger.e(f24293a, "writeToParcel exception occurs", e);
        }
    }

    public IPCParameter(Parcel parcel) {
        this.className = "";
        this.methodName = "";
        readFromParcel(parcel);
    }
}
