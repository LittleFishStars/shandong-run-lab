package com.alibaba.ariver.kernel.common.io;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ByteArrayParcelable implements Parcelable {
    public static final Parcelable.Creator<ByteArrayParcelable> CREATOR = new Parcelable.Creator<ByteArrayParcelable>() { // from class: com.alibaba.ariver.kernel.common.io.ByteArrayParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ByteArrayParcelable createFromParcel(Parcel parcel) {
            return new ByteArrayParcelable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ByteArrayParcelable[] newArray(int i) {
            return new ByteArrayParcelable[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f24241a;

    public ByteArrayParcelable(byte[] bArr) {
        this.f24241a = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getBytes() {
        return this.f24241a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        byte[] bArr = this.f24241a;
        int length = bArr == null ? 0 : bArr.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f24241a);
        }
    }

    public ByteArrayParcelable(Parcel parcel) {
        int i = parcel.readInt();
        if (i > 0) {
            byte[] bArr = new byte[i];
            this.f24241a = bArr;
            parcel.readByteArray(bArr);
        }
    }
}
