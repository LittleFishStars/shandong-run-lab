package com.aliyun.common.utils;

import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<b, SortedSet<Size>> f25582a = new HashMap<>();

    public void a() {
        this.f25582a.clear();
    }

    public void a(b bVar) {
        this.f25582a.remove(bVar);
    }

    public boolean a(Size size) {
        for (b bVar : this.f25582a.keySet()) {
            if (bVar.a(size)) {
                SortedSet<Size> sortedSet = this.f25582a.get(bVar);
                if (sortedSet.contains(size)) {
                    return false;
                }
                sortedSet.add(size);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(size);
        this.f25582a.put(b.b(size.getWidth(), size.getHeight()), treeSet);
        return true;
    }

    public Set<b> b() {
        return this.f25582a.keySet();
    }

    public SortedSet<Size> b(b bVar) {
        return this.f25582a.get(bVar);
    }
}
