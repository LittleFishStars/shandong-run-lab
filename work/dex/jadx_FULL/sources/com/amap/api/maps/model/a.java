package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.DPoint;
import com.zj.adlib.cwa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cwa f26131a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<a> d;

    public a(cwa cwaVar) {
        this(cwaVar, 0);
    }

    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f26131a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }

    private a(double d, double d2, double d3, double d4, int i) {
        this(new cwa(d, d2, d3, d4), i);
    }

    private a(cwa cwaVar, int i) {
        this.d = null;
        this.f26131a = cwaVar;
        this.b = i;
    }

    private void a(double d, double d2, WeightedLatLng weightedLatLng) {
        List<a> list = this.d;
        if (list != null) {
            cwa cwaVar = this.f26131a;
            if (d2 < cwaVar.f) {
                if (d < cwaVar.e) {
                    list.get(0).a(d, d2, weightedLatLng);
                    return;
                } else {
                    list.get(1).a(d, d2, weightedLatLng);
                    return;
                }
            }
            if (d < cwaVar.e) {
                list.get(2).a(d, d2, weightedLatLng);
                return;
            } else {
                list.get(3).a(d, d2, weightedLatLng);
                return;
            }
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(weightedLatLng);
        if (this.c.size() <= 50 || this.b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        cwa cwaVar = this.f26131a;
        arrayList.add(new a(cwaVar.f41056a, cwaVar.e, cwaVar.b, cwaVar.f, this.b + 1));
        List<a> list = this.d;
        cwa cwaVar2 = this.f26131a;
        list.add(new a(cwaVar2.e, cwaVar2.c, cwaVar2.b, cwaVar2.f, this.b + 1));
        List<a> list2 = this.d;
        cwa cwaVar3 = this.f26131a;
        list2.add(new a(cwaVar3.f41056a, cwaVar3.e, cwaVar3.f, cwaVar3.d, this.b + 1));
        List<a> list3 = this.d;
        cwa cwaVar4 = this.f26131a;
        list3.add(new a(cwaVar4.e, cwaVar4.c, cwaVar4.f, cwaVar4.d, this.b + 1));
        List<WeightedLatLng> list4 = this.c;
        this.c = null;
        for (WeightedLatLng weightedLatLng : list4) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    public final Collection<WeightedLatLng> a(cwa cwaVar) {
        ArrayList arrayList = new ArrayList();
        a(cwaVar, arrayList);
        return arrayList;
    }

    private void a(cwa cwaVar, Collection<WeightedLatLng> collection) {
        if (this.f26131a.d(cwaVar)) {
            List<a> list = this.d;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(cwaVar, collection);
                }
            } else if (this.c != null) {
                if (cwaVar.e(this.f26131a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.c) {
                    if (cwaVar.c(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
