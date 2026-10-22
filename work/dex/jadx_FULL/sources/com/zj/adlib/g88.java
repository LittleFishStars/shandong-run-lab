package com.zj.adlib;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f41844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<py1> f16722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16723a;

    public g88(PointF pointF, boolean z, List<py1> list) {
        this.f41844a = pointF;
        this.f16723a = z;
        this.f16722a = new ArrayList(list);
    }

    public List<py1> a() {
        return this.f16722a;
    }

    public PointF b() {
        return this.f41844a;
    }

    public void c(g88 g88Var, g88 g88Var2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        if (this.f41844a == null) {
            this.f41844a = new PointF();
        }
        this.f16723a = g88Var.d() || g88Var2.d();
        if (g88Var.a().size() != g88Var2.a().size()) {
            g25.e("Curves must have the same number of control points. Shape 1: " + g88Var.a().size() + "\tShape 2: " + g88Var2.a().size());
        }
        int iMin = Math.min(g88Var.a().size(), g88Var2.a().size());
        if (this.f16722a.size() < iMin) {
            for (int size = this.f16722a.size(); size < iMin; size++) {
                this.f16722a.add(new py1());
            }
        } else if (this.f16722a.size() > iMin) {
            for (int size2 = this.f16722a.size() - 1; size2 >= iMin; size2--) {
                List<py1> list = this.f16722a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = g88Var.b();
        PointF pointFB2 = g88Var2.b();
        f(up5.k(pointFB.x, pointFB2.x, f), up5.k(pointFB.y, pointFB2.y, f));
        for (int size3 = this.f16722a.size() - 1; size3 >= 0; size3--) {
            py1 py1Var = g88Var.a().get(size3);
            py1 py1Var2 = g88Var2.a().get(size3);
            PointF pointFA = py1Var.a();
            PointF pointFB3 = py1Var.b();
            PointF pointFC = py1Var.c();
            PointF pointFA2 = py1Var2.a();
            PointF pointFB4 = py1Var2.b();
            PointF pointFC2 = py1Var2.c();
            this.f16722a.get(size3).d(up5.k(pointFA.x, pointFA2.x, f), up5.k(pointFA.y, pointFA2.y, f));
            this.f16722a.get(size3).e(up5.k(pointFB3.x, pointFB4.x, f), up5.k(pointFB3.y, pointFB4.y, f));
            this.f16722a.get(size3).g(up5.k(pointFC.x, pointFC2.x, f), up5.k(pointFC.y, pointFC2.y, f));
        }
    }

    public boolean d() {
        return this.f16723a;
    }

    public void e(boolean z) {
        this.f16723a = z;
    }

    public void f(float f, float f2) {
        if (this.f41844a == null) {
            this.f41844a = new PointF();
        }
        this.f41844a.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f16722a.size() + "closed=" + this.f16723a + '}';
    }

    public g88() {
        this.f16722a = new ArrayList();
    }
}
