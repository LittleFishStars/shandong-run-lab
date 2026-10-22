package com.zj.adlib;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class nna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f43569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yna f18469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<OfflineMapProvince> f18470a = new ArrayList<>();

    public nna(Context context) {
        this.f43569a = context;
        this.f18469a = yna.b(context);
    }

    public static void f(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    public static void g(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    public static boolean j(int i) {
        return i == 4;
    }

    public static boolean k(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    public static boolean l(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f18470a) {
            Iterator<OfflineMapProvince> it = this.f18470a.iterator();
            while (it.hasNext()) {
                for (OfflineMapCity offlineMapCity : it.next().getCityList()) {
                    if (offlineMapCity.getCode().equals(str)) {
                        return offlineMapCity;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapProvince> b() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f18470a) {
            Iterator<OfflineMapProvince> it = this.f18470a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final void c(com.amap.api.col.p0003l.ax axVar) {
        String pinyin = axVar.getPinyin();
        synchronized (this.f18470a) {
            loop0: for (OfflineMapProvince offlineMapProvince : this.f18470a) {
                if (offlineMapProvince != null) {
                    for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            d(axVar, offlineMapCity);
                            e(axVar, offlineMapProvince);
                            break loop0;
                        }
                    }
                }
            }
        }
    }

    public final void d(com.amap.api.col.p0003l.ax axVar, OfflineMapCity offlineMapCity) {
        int iD = axVar.c().d();
        if (axVar.c().equals(axVar.f25880a)) {
            p(axVar.t());
        } else {
            if (axVar.c().equals(axVar.f)) {
                axVar.getCity();
                o(axVar);
                axVar.t().n();
            }
            if (k(axVar.getcompleteCode(), axVar.c().d())) {
                h(axVar.t());
            }
        }
        offlineMapCity.setState(iD);
        offlineMapCity.setCompleteCode(axVar.getcompleteCode());
    }

    public final void e(com.amap.api.col.p0003l.ax axVar, OfflineMapProvince offlineMapProvince) {
        tna tnaVar;
        int iD = axVar.c().d();
        if (iD == 6) {
            offlineMapProvince.setState(iD);
            offlineMapProvince.setCompleteCode(0);
            p(new tna(offlineMapProvince, this.f43569a));
            try {
                boa.k(offlineMapProvince.getProvinceCode(), this.f43569a);
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (j(iD) && l(offlineMapProvince)) {
            if (axVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(iD);
                offlineMapProvince.setCompleteCode(axVar.getcompleteCode());
                offlineMapProvince.setVersion(axVar.getVersion());
                offlineMapProvince.setUrl(axVar.getUrl());
                tnaVar = new tna(offlineMapProvince, this.f43569a);
                tnaVar.m(axVar.a());
                tnaVar.d(axVar.getCode());
            } else {
                offlineMapProvince.setState(iD);
                offlineMapProvince.setCompleteCode(100);
                tnaVar = new tna(offlineMapProvince, this.f43569a);
            }
            tnaVar.n();
            h(tnaVar);
            tnaVar.a();
        }
    }

    public final void h(tna tnaVar) {
        yna ynaVar = this.f18469a;
        if (ynaVar == null || tnaVar == null) {
            return;
        }
        ynaVar.e(tnaVar);
    }

    public final void i(List<OfflineMapProvince> list) {
        OfflineMapProvince next;
        OfflineMapCity next2;
        synchronized (this.f18470a) {
            if (this.f18470a.size() > 0) {
                for (int i = 0; i < this.f18470a.size(); i++) {
                    OfflineMapProvince offlineMapProvince = this.f18470a.get(i);
                    Iterator<OfflineMapProvince> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (offlineMapProvince.getPinyin().equals(next.getPinyin())) {
                            break;
                        }
                        if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince.getProvinceCode().equals("000001") || offlineMapProvince.getProvinceCode().equals("100000")) {
                            if (next.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                    }
                    if (next != null) {
                        g(offlineMapProvince, next);
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = next.getCityList();
                        for (int i2 = 0; i2 < cityList.size(); i2++) {
                            OfflineMapCity offlineMapCity = cityList.get(i2);
                            Iterator<OfflineMapCity> it2 = cityList2.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                            } while (!offlineMapCity.getPinyin().equals(next2.getPinyin()));
                            if (next2 != null) {
                                f(offlineMapCity, next2);
                            }
                        }
                    }
                }
            } else {
                Iterator<OfflineMapProvince> it3 = list.iterator();
                while (it3.hasNext()) {
                    this.f18470a.add(it3.next());
                }
            }
        }
    }

    public final OfflineMapCity m(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f18470a) {
            Iterator<OfflineMapProvince> it = this.f18470a.iterator();
            while (it.hasNext()) {
                for (OfflineMapCity offlineMapCity : it.next().getCityList()) {
                    if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                        return offlineMapCity;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> n() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f18470a) {
            Iterator<OfflineMapProvince> it = this.f18470a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    public final void o(com.amap.api.col.p0003l.ax axVar) {
        File[] fileArrListFiles = new File(zwa.f0(this.f43569a)).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(axVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    public final void p(tna tnaVar) {
        yna ynaVar = this.f18469a;
        if (ynaVar != null) {
            ynaVar.k(tnaVar);
        }
    }

    public final OfflineMapProvince r(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f18470a) {
            for (OfflineMapProvince offlineMapProvince : this.f18470a) {
                if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return offlineMapProvince;
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> s() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f18470a) {
            arrayList = new ArrayList<>();
            for (OfflineMapProvince offlineMapProvince : this.f18470a) {
                if (offlineMapProvince != null) {
                    for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                        if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> t() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f18470a) {
            arrayList = new ArrayList<>();
            for (OfflineMapProvince offlineMapProvince : this.f18470a) {
                if (offlineMapProvince != null && (offlineMapProvince.getState() == 4 || offlineMapProvince.getState() == 7)) {
                    arrayList.add(offlineMapProvince);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> u() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f18470a) {
            arrayList = new ArrayList<>();
            for (OfflineMapProvince offlineMapProvince : this.f18470a) {
                if (offlineMapProvince != null) {
                    for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                        if (q(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> v() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f18470a) {
            arrayList = new ArrayList<>();
            for (OfflineMapProvince offlineMapProvince : this.f18470a) {
                if (offlineMapProvince != null && q(offlineMapProvince.getState())) {
                    arrayList.add(offlineMapProvince);
                }
            }
        }
        return arrayList;
    }

    public final void w() {
        x();
        this.f18469a = null;
        this.f43569a = null;
    }

    public final void x() {
        ArrayList<OfflineMapProvince> arrayList = this.f18470a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f18470a.clear();
            }
        }
    }
}
