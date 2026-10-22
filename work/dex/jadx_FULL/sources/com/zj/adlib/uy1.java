package com.zj.adlib;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.exoplayer2.text.Cue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class uy1 {
    public byte[] a(List<Cue> list) {
        ArrayList<Bundle> arrayListD = a51.d(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListD);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
