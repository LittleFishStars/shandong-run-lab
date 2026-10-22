package com.amap.api.col.p0003l;

import com.zj.adlib.phb;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ka implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25983a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public ka() {
        this.f25983a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            phb.a(e);
            return 0;
        }
    }

    @Override // 
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ka clone();

    public final int b() {
        return a(this.f25983a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f25983a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }

    public final void a(ka kaVar) {
        this.f25983a = kaVar.f25983a;
        this.b = kaVar.b;
        this.c = kaVar.c;
        this.d = kaVar.d;
        this.e = kaVar.e;
        this.f = kaVar.f;
        this.g = kaVar.g;
        this.h = kaVar.h;
        this.i = kaVar.i;
    }

    public ka(boolean z, boolean z2) {
        this.f25983a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = z;
        this.i = z2;
    }
}
