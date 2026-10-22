package com.zj.adlib;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.exoplayer2.text.Cue;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ty1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45026a = "c";

    public ImmutableList<Cue> a(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
        parcelObtain.recycle();
        return a51.b(Cue.f31001a, (ArrayList) sb0.g(bundle.getParcelableArrayList("c")));
    }
}
