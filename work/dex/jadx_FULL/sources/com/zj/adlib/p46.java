package com.zj.adlib;

import com.contrarywind.adapter.WheelAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p46 implements WheelAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43900a;
    public int b;

    public p46(int i, int i2) {
        this.f43900a = i;
        this.b = i2;
    }

    @Override // com.contrarywind.adapter.WheelAdapter
    public int a() {
        return (this.b - this.f43900a) + 1;
    }

    @Override // com.contrarywind.adapter.WheelAdapter
    public Object getItem(int i) {
        if (i < 0 || i >= a()) {
            return 0;
        }
        return Integer.valueOf(this.f43900a + i);
    }

    @Override // com.contrarywind.adapter.WheelAdapter
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f43900a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
