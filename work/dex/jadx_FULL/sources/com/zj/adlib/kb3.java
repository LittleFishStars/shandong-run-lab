package com.zj.adlib;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class kb3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<hb3> f17630a;

    public kb3(List<hb3> list, int i) {
        this.f17630a = new ArrayList(list);
        this.f42779a = i;
    }

    public List<hb3> a() {
        return this.f17630a;
    }

    public int b() {
        return this.f42779a;
    }

    public boolean c(List<hb3> list) {
        return this.f17630a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof kb3) {
            return this.f17630a.equals(((kb3) obj).f17630a);
        }
        return false;
    }

    public int hashCode() {
        return this.f17630a.hashCode();
    }

    public String toString() {
        return "{ " + this.f17630a + " }";
    }
}
