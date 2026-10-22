package com.kwad.components.core.page.widget.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.kwad.components.core.page.widget.a.e.1
        private static e b(Parcel parcel) {
            return new e(parcel);
        }

        private static e[] bK(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e[] newArray(int i) {
            return bK(i);
        }
    };
    public int ahA;
    public boolean ahB;
    public boolean ahC;
    public boolean ahD;
    public int ahE;
    public boolean ahF = true;
    public c ahG;
    public Map<String, String> ahH;
    public boolean ahw;
    public float ahx;
    public float ahy;
    public float ahz;

    public e() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float vn() {
        float f = this.ahy;
        if (f > 0.0f) {
            return f;
        }
        return -1.0f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.ahw ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.ahx);
        parcel.writeFloat(this.ahy);
        parcel.writeFloat(this.ahz);
        parcel.writeInt(this.ahA);
        parcel.writeByte(this.ahB ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ahC ? (byte) 1 : (byte) 0);
    }

    public e(Parcel parcel) {
        this.ahw = parcel.readByte() != 0;
        this.ahx = parcel.readFloat();
        this.ahy = parcel.readFloat();
        this.ahz = parcel.readFloat();
        this.ahA = parcel.readInt();
        this.ahB = parcel.readByte() != 0;
        this.ahC = parcel.readByte() != 0;
    }
}
