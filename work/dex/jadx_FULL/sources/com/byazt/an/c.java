package com.byazt.an;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1270, 20})
public abstract class c implements Parcelable {
    public final Parcelable tt;
    public static final c c = new c() { // from class: com.byazt.an.c.1
    };
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.ClassLoaderCreator<c>() { // from class: com.byazt.an.c.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return c.c;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    public final Parcelable c() {
        return this.tt;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.tt, i);
    }

    private c() {
        this.tt = null;
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.tt = parcelable == c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.tt = parcelable == null ? c : parcelable;
    }
}
