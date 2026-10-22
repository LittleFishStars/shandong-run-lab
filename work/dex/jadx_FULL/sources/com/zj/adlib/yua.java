package com.zj.adlib;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class yua {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StyleItem[] f20941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<Integer, StyleItem> f20940a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f46123a = null;

    public final Map<Integer, StyleItem> a() {
        return this.f20940a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.f20940a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.f20940a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f20941a = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.f20941a;
    }

    public final Object d() {
        return this.f46123a;
    }
}
