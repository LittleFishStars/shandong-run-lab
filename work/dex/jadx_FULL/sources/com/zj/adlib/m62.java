package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class m62<T> implements Iterator<T> {
    public int K = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final DataBuffer f43229a;

    public m62(@NonNull DataBuffer dataBuffer) {
        this.f43229a = (DataBuffer) yw6.l(dataBuffer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.K < this.f43229a.getCount() + (-1);
    }

    @Override // java.util.Iterator
    @NonNull
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.f43229a;
            int i = this.K + 1;
            this.K = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.K);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
