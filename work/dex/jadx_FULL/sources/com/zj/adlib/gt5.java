package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.UPCEANReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class gt5 extends OneDReader {
    public static final UPCEANReader[] b = new UPCEANReader[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UPCEANReader[] f41983a;

    public gt5(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new xt2());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new df9());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new zt2());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new if9());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new xt2());
            arrayList.add(new zt2());
            arrayList.add(new if9());
        }
        this.f41983a = (UPCEANReader[]) arrayList.toArray(b);
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] iArrJ = UPCEANReader.j(qv0Var);
        for (UPCEANReader uPCEANReader : this.f41983a) {
            try {
                ug7 ug7VarG = uPCEANReader.g(i, qv0Var, iArrJ, map);
                boolean z = ug7VarG.b() == BarcodeFormat.EAN_13 && ug7VarG.g().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z || !z2) {
                    return ug7VarG;
                }
                ug7 ug7Var = new ug7(ug7VarG.g().substring(1), ug7VarG.d(), ug7VarG.f(), BarcodeFormat.UPC_A);
                ug7Var.i(ug7VarG.e());
                return ug7Var;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        for (UPCEANReader uPCEANReader : this.f41983a) {
            uPCEANReader.reset();
        }
    }
}
