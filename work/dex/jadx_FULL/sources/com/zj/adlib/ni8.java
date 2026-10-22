package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataBufferRef;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class ni8<T> extends m62<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f43532a;

    public ni8(@NonNull DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.zj.adlib.m62, java.util.Iterator
    @NonNull
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.K);
        }
        int i = this.K + 1;
        this.K = i;
        if (i == 0) {
            Object objL = yw6.l(super.f43229a.get(0));
            this.f43532a = objL;
            if (!(objL instanceof DataBufferRef)) {
                throw new IllegalStateException("DataBuffer reference of type " + String.valueOf(objL.getClass()) + " is not movable");
            }
        } else {
            ((DataBufferRef) yw6.l(this.f43532a)).zaa(this.K);
        }
        return this.f43532a;
    }
}
