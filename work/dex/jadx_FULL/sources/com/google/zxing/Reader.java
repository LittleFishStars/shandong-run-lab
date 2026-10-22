package com.google.zxing;

import com.zj.adlib.jv0;
import com.zj.adlib.ug7;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface Reader {
    ug7 a(jv0 jv0Var) throws NotFoundException, ChecksumException, FormatException;

    ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
