package com.byazt.ng;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28830a;
    public String c;
    public long da;
    public String i;
    public String m;
    public long my;
    public String n;
    public String nu;
    public String qy;
    public int rh;
    public String sl;
    public String sp;
    public String t;
    public String tt;
    public String u;
    public String uj;
    public String ve;
    public String x;
    public String yp;
    public int z;
    public int gt = -1;
    public int rl = -1;
    public Map<String, Object> gu = new ConcurrentHashMap();
    public long gr = -1;

    public uj a(String str) {
        this.uj = str;
        return this;
    }

    public uj c(int i) {
        this.yp = String.valueOf(i);
        return this;
    }

    public uj da(String str) {
        this.x = str;
        return this;
    }

    public uj i(String str) {
        this.sp = str;
        return this;
    }

    public uj n(String str) {
        this.ve = str;
        return this;
    }

    public uj setResult(int i) {
        this.gt = i;
        return this;
    }

    public uj sl(String str) {
        this.t = str;
        return this;
    }

    public uj sp(String str) {
        this.n = str;
        return this;
    }

    public uj t(String str) {
        this.qy = str;
        return this;
    }

    public uj tt(String str) {
        this.i = str;
        return this;
    }

    public uj uj(String str) {
        this.tt = str;
        return this;
    }

    public uj ve(String str) {
        this.sl = str;
        return this;
    }

    public uj x(String str) {
        this.f28830a = str;
        return this;
    }

    public uj a(int i) {
        this.rl = i;
        return this;
    }

    public uj c(long j) {
        this.my = j;
        return this;
    }

    public uj n(int i) {
        this.rh = i;
        return this;
    }

    public uj tt(long j) {
        this.da = j;
        return this;
    }

    public uj uj(int i) {
        this.nu = String.valueOf(i);
        return this;
    }

    public uj ve(int i) {
        this.m = String.valueOf(i);
        return this;
    }

    public uj c(String str) {
        this.c = str;
        return this;
    }

    public uj tt(int i) {
        this.z = i;
        return this;
    }

    public uj ve(long j) {
        this.gr = j;
        return this;
    }

    public static uj tt() {
        return new uj();
    }

    public static uj ve() {
        uj ujVar = new uj();
        ujVar.ve(System.currentTimeMillis());
        return ujVar;
    }

    public uj c(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.gu.put(str, obj);
        }
        return this;
    }

    public uj c(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.gu.putAll(map);
        }
        return this;
    }

    public long c() {
        return this.gr;
    }
}
