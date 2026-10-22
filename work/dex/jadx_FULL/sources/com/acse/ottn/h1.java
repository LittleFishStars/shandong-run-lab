package com.acse.ottn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h1 implements s4<Number> {
    @Override // com.acse.ottn.s4
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return Float.valueOf(fFloatValue + (f * (number2.floatValue() - fFloatValue)));
    }
}
