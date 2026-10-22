package com.zj.adlib;

import com.huachenjie.common.widget.ruler.IScaleTransform;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class wo2 implements IScaleTransform<Double> {
    @Override // com.huachenjie.common.widget.ruler.IScaleTransform
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String transform(Double input) {
        return BigDecimal.valueOf(input.doubleValue()).divide(BigDecimal.valueOf(1000L), 2, 4).toString();
    }
}
