package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.UPCEANReader;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class df9 extends UPCEANReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UPCEANReader f41174a = new xt2();

    public static ug7 m(ug7 ug7Var) throws FormatException {
        String strG = ug7Var.g();
        if (strG.charAt(0) != '0') {
            throw FormatException.getFormatInstance();
        }
        ug7 ug7Var2 = new ug7(strG.substring(1), null, ug7Var.f(), BarcodeFormat.UPC_A);
        if (ug7Var.e() != null) {
            ug7Var2.i(ug7Var.e());
        }
        return ug7Var2;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, FormatException {
        return m(this.f41174a.a(jv0Var));
    }

    @Override // com.google.zxing.oned.UPCEANReader, com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(this.f41174a.b(i, qv0Var, map));
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return m(this.f41174a.d(jv0Var, map));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(qv0 qv0Var, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f41174a.decodeMiddle(qv0Var, iArr, sb);
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public ug7 g(int i, qv0 qv0Var, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(this.f41174a.g(i, qv0Var, iArr, map));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat k() {
        return BarcodeFormat.UPC_A;
    }
}
