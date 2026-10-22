package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.oned.OneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class et5 extends OneDReader {
    public static final OneDReader[] b = new OneDReader[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OneDReader[] f41522a;

    public et5(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new gt5(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new ym1(z));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new an1());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new xm1());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new e54());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new vm1());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new d97());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new e97());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new gt5(map));
            arrayList.add(new ym1());
            arrayList.add(new vm1());
            arrayList.add(new an1());
            arrayList.add(new xm1());
            arrayList.add(new e54());
            arrayList.add(new d97());
            arrayList.add(new e97());
        }
        this.f41522a = (OneDReader[]) arrayList.toArray(b);
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (OneDReader oneDReader : this.f41522a) {
            try {
                return oneDReader.b(i, qv0Var, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        for (OneDReader oneDReader : this.f41522a) {
            oneDReader.reset();
        }
    }
}
