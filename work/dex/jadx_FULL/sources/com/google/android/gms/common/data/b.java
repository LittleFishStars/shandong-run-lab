package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class b<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f31277a = {"data"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Parcelable.Creator f5636a;

    @KeepForSdk
    public b(@NonNull DataHolder dataHolder, @NonNull Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f5636a = creator;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void a(@NonNull DataHolder.a aVar, @NonNull T t) {
        Parcel parcelObtain = Parcel.obtain();
        t.writeToParcel(parcelObtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", parcelObtain.marshall());
        aVar.c(contentValues);
        parcelObtain.recycle();
    }

    @NonNull
    @KeepForSdk
    public static DataHolder.a g() {
        return DataHolder.builder(f31277a);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @KeepForSdk
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public T get(int i) {
        DataHolder dataHolder = (DataHolder) yw6.l(super.f31272a);
        byte[] byteArray = dataHolder.getByteArray("data", i, dataHolder.getWindowIndex(i));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(byteArray, 0, byteArray.length);
        parcelObtain.setDataPosition(0);
        T t = (T) this.f5636a.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return t;
    }
}
