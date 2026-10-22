package com.zj.adlib;

import com.contrarywind.adapter.WheelAdapter;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hb0<T> implements WheelAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f42087a;

    public hb0(List<T> list) {
        this.f42087a = list;
    }

    @Override // com.contrarywind.adapter.WheelAdapter
    public int a() {
        return this.f42087a.size();
    }

    @Override // com.contrarywind.adapter.WheelAdapter
    public Object getItem(int i) {
        return (i < 0 || i >= this.f42087a.size()) ? "" : this.f42087a.get(i);
    }

    @Override // com.contrarywind.adapter.WheelAdapter
    public int indexOf(Object obj) {
        return this.f42087a.indexOf(obj);
    }
}
