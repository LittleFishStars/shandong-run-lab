package com.beizi.fusion;

import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface jd {

    public enum a {
        WGS_84(AMapLocation.COORD_TYPE_WGS84),
        GCJ_02(AMapLocation.COORD_TYPE_GCJ02),
        BD_09("BD09");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27430a;

        a(String str) {
            this.f27430a = str;
        }

        public String b() {
            return this.f27430a;
        }
    }

    double a();

    double b();

    a c();

    long d();
}
