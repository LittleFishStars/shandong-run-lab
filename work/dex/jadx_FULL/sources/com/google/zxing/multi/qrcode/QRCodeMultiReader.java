package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.zj.adlib.at5;
import com.zj.adlib.c57;
import com.zj.adlib.d57;
import com.zj.adlib.jv0;
import com.zj.adlib.q82;
import com.zj.adlib.ug7;
import com.zj.adlib.ul2;
import com.zj.adlib.xg7;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class QRCodeMultiReader extends d57 implements MultipleBarcodeReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ug7[] f32513a = new ug7[0];
    public static final xg7[] b = new xg7[0];

    public static final class SAComparator implements Comparator<ug7>, Serializable {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ug7 ug7Var, ug7 ug7Var2) {
            Map<ResultMetadataType, Object> mapE = ug7Var.e();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) mapE.get(resultMetadataType)).intValue(), ((Integer) ug7Var2.e().get(resultMetadataType)).intValue());
        }
    }

    public static List<ug7> g(List<ug7> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ug7> arrayList2 = new ArrayList();
        for (ug7 ug7Var : list) {
            if (ug7Var.e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(ug7Var);
            } else {
                arrayList.add(ug7Var);
            }
        }
        if (arrayList2.isEmpty()) {
            return list;
        }
        Collections.sort(arrayList2, new SAComparator());
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        for (ug7 ug7Var2 : arrayList2) {
            sb.append(ug7Var2.g());
            byte[] bArrD = ug7Var2.d();
            byteArrayOutputStream.write(bArrD, 0, bArrD.length);
            Iterable<byte[]> iterable = (Iterable) ug7Var2.e().get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                for (byte[] bArr : iterable) {
                    byteArrayOutputStream2.write(bArr, 0, bArr.length);
                }
            }
        }
        ug7 ug7Var3 = new ug7(sb.toString(), byteArrayOutputStream.toByteArray(), b, BarcodeFormat.QR_CODE);
        if (byteArrayOutputStream2.size() > 0) {
            ug7Var3.j(ResultMetadataType.BYTE_SEGMENTS, Collections.singletonList(byteArrayOutputStream2.toByteArray()));
        }
        arrayList.add(ug7Var3);
        return arrayList;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public ug7[] b(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (ul2 ul2Var : new at5(jv0Var.b()).i(map)) {
            try {
                q82 q82VarD = getDecoder().d(ul2Var.a(), map);
                xg7[] xg7VarArrB = ul2Var.b();
                if (q82VarD.f() instanceof c57) {
                    ((c57) q82VarD.f()).a(xg7VarArrB);
                }
                ug7 ug7Var = new ug7(q82VarD.k(), q82VarD.g(), xg7VarArrB, BarcodeFormat.QR_CODE);
                List<byte[]> listA = q82VarD.a();
                if (listA != null) {
                    ug7Var.j(ResultMetadataType.BYTE_SEGMENTS, listA);
                }
                String strB = q82VarD.b();
                if (strB != null) {
                    ug7Var.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
                }
                if (q82VarD.l()) {
                    ug7Var.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(q82VarD.i()));
                    ug7Var.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(q82VarD.h()));
                }
                arrayList.add(ug7Var);
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? f32513a : (ug7[]) g(arrayList).toArray(f32513a);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public ug7[] c(jv0 jv0Var) throws NotFoundException {
        return b(jv0Var, null);
    }
}
