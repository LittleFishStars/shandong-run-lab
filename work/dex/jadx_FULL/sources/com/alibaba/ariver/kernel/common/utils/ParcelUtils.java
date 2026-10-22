package com.alibaba.ariver.kernel.common.utils;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParcelUtils {
    public static <T extends Parcelable> T parcelAndUnParcel(T t) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeParcelable(t, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain2.unmarshall(bArrMarshall, 0, bArrMarshall.length);
            parcelObtain2.setDataPosition(0);
            return (T) parcelObtain2.readParcelable(ParcelUtils.class.getClassLoader());
        } finally {
            parcelObtain2.recycle();
        }
    }
}
