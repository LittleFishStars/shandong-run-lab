package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class xi0 implements Reader {
    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, FormatException {
        return d(jv0Var, null);
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        xg7[] xg7VarArrB;
        xg7[] xg7VarArrB2;
        FormatException formatException;
        ResultPointCallback resultPointCallback;
        ql2 ql2Var = new ql2(jv0Var.b());
        q82 q82VarC = null;
        try {
            wi0 wi0VarB = ql2Var.b(false);
            xg7VarArrB = wi0VarB.b();
            try {
                xg7VarArrB2 = xg7VarArrB;
                formatException = null;
                q82VarC = new Decoder().c(wi0VarB);
                e = null;
            } catch (FormatException e) {
                e = e;
                xg7VarArrB2 = xg7VarArrB;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                xg7VarArrB2 = xg7VarArrB;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            xg7VarArrB = null;
        } catch (NotFoundException e4) {
            e = e4;
            xg7VarArrB = null;
        }
        if (q82VarC == null) {
            try {
                wi0 wi0VarB2 = ql2Var.b(true);
                xg7VarArrB2 = wi0VarB2.b();
                q82VarC = new Decoder().c(wi0VarB2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        xg7[] xg7VarArr = xg7VarArrB2;
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (xg7 xg7Var : xg7VarArr) {
                resultPointCallback.a(xg7Var);
            }
        }
        ug7 ug7Var = new ug7(q82VarC.k(), q82VarC.g(), q82VarC.e(), xg7VarArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        List<byte[]> listA = q82VarC.a();
        if (listA != null) {
            ug7Var.j(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = q82VarC.b();
        if (strB != null) {
            ug7Var.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]z" + q82VarC.j());
        return ug7Var;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
