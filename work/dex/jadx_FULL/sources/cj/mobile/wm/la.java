package cj.mobile.wm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class la {
    public static final Comparator<byte[]> dexe = new dexa();
    public final List<byte[]> dexa = new ArrayList();
    public final List<byte[]> dexb = new ArrayList(64);
    public int dexc = 0;
    public final int dexd;

    public static class dexa implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public la(int i) {
        this.dexd = i;
    }

    private synchronized void dexa() {
        while (this.dexc > this.dexd) {
            byte[] bArrRemove = this.dexa.remove(0);
            this.dexb.remove(bArrRemove);
            this.dexc -= bArrRemove.length;
        }
    }

    public synchronized void dexa(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.dexd) {
                this.dexa.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.dexb, bArr, dexe);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.dexb.add(iBinarySearch, bArr);
                this.dexc += bArr.length;
                dexa();
            }
        }
    }

    public synchronized byte[] dexa(int i) {
        for (int i2 = 0; i2 < this.dexb.size(); i2++) {
            byte[] bArr = this.dexb.get(i2);
            if (bArr.length >= i) {
                this.dexc -= bArr.length;
                this.dexb.remove(i2);
                this.dexa.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
