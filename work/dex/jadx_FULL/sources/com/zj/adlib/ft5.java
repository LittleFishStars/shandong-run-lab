package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ft5 implements Reader {
    public static final Reader[] b = new Reader[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<DecodeHintType, ?> f41753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Reader[] f16618a;

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException {
        e(null);
        return b(jv0Var);
    }

    public final ug7 b(jv0 jv0Var) throws NotFoundException {
        Reader[] readerArr = this.f16618a;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                try {
                    return reader.d(jv0Var, this.f41753a);
                } catch (ReaderException unused) {
                }
            }
            Map<DecodeHintType, ?> map = this.f41753a;
            if (map != null && map.containsKey(DecodeHintType.ALSO_INVERTED)) {
                jv0Var.b().h();
                for (Reader reader2 : this.f16618a) {
                    try {
                        return reader2.d(jv0Var, this.f41753a);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ug7 c(jv0 jv0Var) throws NotFoundException {
        if (this.f16618a == null) {
            e(null);
        }
        return b(jv0Var);
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(map);
        return b(jv0Var);
    }

    public void e(Map<DecodeHintType, ?> map) {
        this.f41753a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new et5(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new d57());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new w62());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new xi0());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new qh6());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new df5());
            }
            if (z && z2) {
                arrayList.add(new et5(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new et5(map));
            }
            arrayList.add(new d57());
            arrayList.add(new w62());
            arrayList.add(new xi0());
            arrayList.add(new qh6());
            arrayList.add(new df5());
            if (z2) {
                arrayList.add(new et5(map));
            }
        }
        this.f16618a = (Reader[]) arrayList.toArray(b);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        Reader[] readerArr = this.f16618a;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                reader.reset();
            }
        }
    }
}
