package com.byazt.fx;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.byazt.ete.eo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 839, 20})
public class c {
    public List<tt> c;
    public final Vibrator n;
    public Context tt;
    public final List<Long> ve = new ArrayList();
    public final List<Integer> uj = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28547a = 0;
    public long sp = 0;

    public c(Context context, eo eoVar) {
        this.tt = context;
        this.n = ve.ve(context);
        this.c = eoVar.tt();
        c();
    }

    private static float c(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    public void c() {
        ve();
        List<tt> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.c, new Comparator<tt>() { // from class: com.byazt.fx.c.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(tt ttVar, tt ttVar2) {
                return Long.compare(ttVar.c(), ttVar2.c());
            }
        });
        for (tt ttVar : this.c) {
            long jC = ((long) ttVar.c()) + ttVar.tt();
            if (jC > this.sp) {
                this.sp = jC;
            }
        }
        for (tt ttVar2 : this.c) {
            if (this.f28547a < ttVar2.c()) {
                c(((long) ttVar2.c()) - this.f28547a);
            }
            c(ttVar2.tt(), ttVar2.ve(), ttVar2.uj());
        }
        long j = this.f28547a;
        long j2 = this.sp;
        if (j < j2) {
            c(j2 - j);
        }
    }

    public void tt() {
        if (!ve.c(this.tt) || this.ve.isEmpty() || this.uj.isEmpty()) {
            return;
        }
        this.n.vibrate(VibrationEffect.createWaveform(c(this.ve), tt(this.uj), -1));
    }

    public void ve() {
        this.ve.clear();
        this.uj.clear();
        this.f28547a = 0L;
        this.sp = 0L;
    }

    private int[] tt(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    private void c(long j) {
        if (j > 0) {
            this.ve.add(Long.valueOf(j));
            this.uj.add(0);
            this.f28547a += j;
        }
    }

    private void c(long j, float f, float f2) {
        float fC = c(f, 0.0f, 1.0f);
        float fC2 = c(f2, 0.0f, 1.0f);
        int iPow = (int) (((float) Math.pow(fC, 1.5d)) * 255.0f);
        int iMax = Math.max(1, (int) (fC2 * ((int) (j / 22))));
        long j2 = j - (((long) iMax) * 20);
        for (int i = 0; i < iMax; i++) {
            this.ve.add(20L);
            this.uj.add(Integer.valueOf(iPow));
            int i2 = iMax - 1;
            if (i < i2) {
                this.ve.add(Long.valueOf(Math.max(2L, j2 / ((long) i2))));
                this.uj.add(0);
            }
        }
        this.f28547a += j;
    }

    private long[] c(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }
}
