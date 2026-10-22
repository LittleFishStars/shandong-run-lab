package com.ipd.dsp.internal.j1;

import android.util.Pair;
import android.view.View;
import com.ipd.dsp.internal.c2.s;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38366a;
    public final int b;
    public final int c;
    public final int d;
    public final Map<String, Integer> e = new HashMap();

    public a(View view) {
        if (view == null) {
            this.f38366a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        this.f38366a = i;
        int i2 = iArr[1];
        this.c = i2;
        Pair<Integer, Integer> pairD = s.d(view.getContext());
        this.b = ((Integer) pairD.first).intValue() - (i + view.getWidth());
        this.d = ((Integer) pairD.second).intValue() - (i2 + view.getHeight());
    }

    public Map<String, Integer> a() {
        this.e.put("x1", Integer.valueOf(this.f38366a));
        this.e.put("x2", Integer.valueOf(this.b));
        this.e.put("y1", Integer.valueOf(this.c));
        this.e.put("y2", Integer.valueOf(this.d));
        return this.e;
    }
}
