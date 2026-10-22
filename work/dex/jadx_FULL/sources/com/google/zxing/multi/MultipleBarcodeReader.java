package com.google.zxing.multi;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.zj.adlib.jv0;
import com.zj.adlib.ug7;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface MultipleBarcodeReader {
    ug7[] b(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException;

    ug7[] c(jv0 jv0Var) throws NotFoundException;
}
