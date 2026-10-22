package com.alibaba.ariver.kernel.api.remote;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteCallResult implements Parcelable {
    public static final Parcelable.Creator<RemoteCallResult> CREATOR = new Parcelable.Creator<RemoteCallResult>() { // from class: com.alibaba.ariver.kernel.api.remote.RemoteCallResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteCallResult createFromParcel(Parcel parcel) {
            return new RemoteCallResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteCallResult[] newArray(int i) {
            return new RemoteCallResult[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24217a;
    private Object b;

    public RemoteCallResult(Object obj) {
        this.f24217a = false;
        if (obj instanceof Throwable) {
            this.f24217a = true;
        }
        this.b = obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        return this.b;
    }

    public boolean isError() {
        return this.f24217a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f24217a ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.b);
    }

    public RemoteCallResult(Parcel parcel) {
        this.f24217a = false;
        this.f24217a = parcel.readByte() != 0;
        this.b = parcel.readValue(getClass().getClassLoader());
    }
}
