package com.zj.adlib;

import androidx.camera.video.AudioStats;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class dn6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HCJMapUtils f41233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double f16044a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16046a = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f16045a = 0.3f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f16047b = 10.0f;
    public double o = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double p = AudioStats.AUDIO_AMPLITUDE_NONE;

    public dn6() {
        f41233a = HCJMapEntry.getInstance().createMapUtils();
    }

    public static double a(HCJLatLng p, HCJLatLng lineBegin, HCJLatLng lineEnd) {
        double d = p.lng;
        double d2 = lineBegin.lng;
        double d3 = p.lat;
        double d4 = lineBegin.lat;
        double d5 = lineEnd.lng;
        double d6 = d5 - d2;
        double d7 = lineEnd.lat;
        double d8 = d7 - d4;
        double d9 = (((d - d2) * d6) + ((d3 - d4) * d8)) / ((d6 * d6) + (d8 * d8));
        if (d9 >= AudioStats.AUDIO_AMPLITUDE_NONE && (d2 != d5 || d4 != d7)) {
            if (d9 > 1.0d) {
                d4 = d7;
                d2 = d5;
            } else {
                d2 += d6 * d9;
                d4 += d9 * d8;
            }
        }
        return f41233a.calculateLineDistance(p, new HCJLatLng(d4, d2));
    }

    public static HCJLatLng c(List<HCJLatLng> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    public int b() {
        return this.f16046a;
    }

    public float d() {
        return this.f16045a;
    }

    public final void e() {
        this.g = 0.001d;
        this.h = 0.001d;
        this.i = 5.698402909980532E-4d;
        this.j = 5.698402909980532E-4d;
    }

    public final HCJLatLng f(double oldValue_x, double value_x, double oldValue_y, double value_y) {
        this.f16044a = oldValue_x;
        this.b = value_x;
        double d = this.g;
        double d2 = this.i;
        double dSqrt = Math.sqrt((d * d) + (d2 * d2)) + this.p;
        this.k = dSqrt;
        double d3 = this.g;
        double dSqrt2 = Math.sqrt((dSqrt * dSqrt) / ((dSqrt * dSqrt) + (d3 * d3))) + this.o;
        this.m = dSqrt2;
        double d4 = this.b;
        double d5 = this.f16044a;
        this.e = ((d4 - d5) * dSqrt2) + d5;
        double d6 = this.k;
        this.i = Math.sqrt((1.0d - dSqrt2) * d6 * d6);
        this.c = oldValue_y;
        this.d = value_y;
        double d7 = this.h;
        double d8 = this.j;
        double dSqrt3 = Math.sqrt((d7 * d7) + (d8 * d8)) + this.p;
        this.l = dSqrt3;
        double d9 = this.h;
        double dSqrt4 = Math.sqrt((dSqrt3 * dSqrt3) / ((dSqrt3 * dSqrt3) + (d9 * d9))) + this.o;
        this.n = dSqrt4;
        double d10 = this.d;
        double d11 = this.c;
        this.f = ((d10 - d11) * dSqrt4) + d11;
        double d12 = 1.0d - dSqrt4;
        double d13 = this.l;
        this.j = Math.sqrt(d12 * d13 * d13);
        return new HCJLatLng(this.f, this.e);
    }

    public List<HCJLatLng> g(List<HCJLatLng> originlist) {
        return h(originlist, this.f16046a);
    }

    public final List<HCJLatLng> h(List<HCJLatLng> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            e();
            HCJLatLng hCJLatLng = originlist.get(0);
            arrayList.add(hCJLatLng);
            for (int i = 1; i < originlist.size(); i++) {
                HCJLatLng hCJLatLngJ = j(hCJLatLng, originlist.get(i), intensity);
                if (hCJLatLngJ != null) {
                    arrayList.add(hCJLatLngJ);
                    hCJLatLng = hCJLatLngJ;
                }
            }
        }
        return arrayList;
    }

    public HCJLatLng i(HCJLatLng lastLoc, HCJLatLng curLoc) {
        return j(lastLoc, curLoc, this.f16046a);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a A[PHI: r1
      0x001a: PHI (r1v5 int) = (r1v0 int), (r1v1 int) binds: [B:12:0x0018, B:15:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    public final HCJLatLng j(HCJLatLng lastLoc, HCJLatLng curLoc, int intensity) {
        if (this.g == AudioStats.AUDIO_AMPLITUDE_NONE || this.h == AudioStats.AUDIO_AMPLITUDE_NONE) {
            e();
        }
        HCJLatLng hCJLatLngF = null;
        if (lastLoc != null && curLoc != null) {
            int i = 1;
            if (intensity < 1) {
                intensity = i;
            } else {
                i = 5;
                if (intensity > 5) {
                    intensity = i;
                }
            }
            int i2 = 0;
            while (i2 < intensity) {
                hCJLatLngF = f(lastLoc.lng, curLoc.lng, lastLoc.lat, curLoc.lat);
                i2++;
                curLoc = hCJLatLngF;
            }
        }
        return hCJLatLngF;
    }

    public List<HCJLatLng> k(List<HCJLatLng> originlist) {
        return n(h(o(originlist), this.f16046a), this.f16045a);
    }

    public final List<HCJLatLng> l(List<HCJLatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            HCJLatLng hCJLatLngC = c(arrayList);
            HCJLatLng hCJLatLng = inPoints.get(i);
            if (hCJLatLngC == null || i == inPoints.size() - 1) {
                arrayList.add(hCJLatLng);
            } else if (a(hCJLatLng, hCJLatLngC, inPoints.get(i + 1)) < threshHold) {
                arrayList.add(hCJLatLng);
            }
        }
        return arrayList;
    }

    public List<HCJLatLng> m(List<HCJLatLng> inPoints) {
        return n(inPoints, this.f16045a);
    }

    public final List<HCJLatLng> n(List<HCJLatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            HCJLatLng hCJLatLngC = c(arrayList);
            HCJLatLng hCJLatLng = inPoints.get(i);
            if (hCJLatLngC == null || i == inPoints.size() - 1) {
                arrayList.add(hCJLatLng);
            } else if (a(hCJLatLng, hCJLatLngC, inPoints.get(i + 1)) > threshHold) {
                arrayList.add(hCJLatLng);
            }
        }
        return arrayList;
    }

    public List<HCJLatLng> o(List<HCJLatLng> originlist) {
        return l(originlist, this.f16047b);
    }

    public void p(int mIntensity) {
        this.f16046a = mIntensity;
    }

    public void q(float mnoiseThreshhold) {
        this.f16047b = mnoiseThreshhold;
    }

    public void r(float mThreshhold) {
        this.f16045a = mThreshhold;
    }
}
