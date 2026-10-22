package com.czhj.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() { // from class: com.czhj.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private final int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<byte[]> f29478a = new ArrayList();
    private final List<byte[]> b = new ArrayList(64);
    private int d = 0;

    public ByteArrayPool(int i) {
        this.c = i;
    }

    private synchronized void a() {
        while (this.d > this.c) {
            byte[] bArrRemove = this.f29478a.remove(0);
            this.b.remove(bArrRemove);
            this.d -= bArrRemove.length;
        }
    }

    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            byte[] bArr = this.b.get(i2);
            if (bArr.length >= i) {
                this.d -= bArr.length;
                this.b.remove(i2);
                this.f29478a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.c) {
                this.f29478a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.b, bArr, BUF_COMPARATOR);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.b.add(iBinarySearch, bArr);
                this.d += bArr.length;
                a();
            }
        }
    }
}
