package com.acse.ottn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x1 implements s4<Integer> {
    @Override // com.acse.ottn.s4
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer evaluate(float f, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        return Integer.valueOf((int) (iIntValue + (f * (num2.intValue() - iIntValue))));
    }
}
