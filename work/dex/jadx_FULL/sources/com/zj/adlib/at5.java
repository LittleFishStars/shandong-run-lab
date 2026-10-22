package com.zj.adlib;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class at5 extends tl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ul2[] f40607a = new ul2[0];

    public at5(tv0 tv0Var) {
        super(tv0Var);
    }

    public ul2[] i(Map<DecodeHintType, ?> map) throws NotFoundException {
        ch3[] ch3VarArrK = new MultiFinderPatternFinder(getImage(), map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).k(map);
        if (ch3VarArrK.length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (ch3 ch3Var : ch3VarArrK) {
            try {
                arrayList.add(processFinderPatternInfo(ch3Var));
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? f40607a : (ul2[]) arrayList.toArray(f40607a);
    }
}
