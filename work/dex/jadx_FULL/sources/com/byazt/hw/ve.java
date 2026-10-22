package com.byazt.hw;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 77, 54})
public class ve {
    public boolean c = false;
    public boolean tt = true;
    public Map<String, Integer> ve = null;
    public Map<String, String> uj = null;
    public int n = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28633a = 1;
    public int sp = 1;
    public int x = 10;
    public int i = 1;
    public int da = 1;
    public int sl = 900;
    public int t = 120;
    public String u = null;
    public int yp = 0;
    public long z = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.c);
        sb.append(" probeEnable: ");
        sb.append(this.tt);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.ve;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.uj;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.n);
        sb.append("#");
        sb.append(this.f28633a);
        sb.append("#");
        sb.append(this.sp);
        sb.append(" reqErr: ");
        sb.append(this.x);
        sb.append("#");
        sb.append(this.i);
        sb.append("#");
        sb.append(this.da);
        sb.append(" updateInterval: ");
        sb.append(this.sl);
        sb.append(" updateRandom: ");
        sb.append(this.t);
        sb.append(" httpBlack: ");
        sb.append(this.u);
        return sb.toString();
    }
}
