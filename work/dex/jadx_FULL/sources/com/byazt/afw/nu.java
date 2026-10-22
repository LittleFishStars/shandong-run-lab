package com.byazt.afw;

import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 137})
public class nu {
    public long c;
    public ic n;
    public String tt;
    public com.byazt.jzl.a uj;
    public int ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 475})
    public static class c {
        public int da;
        public int i;
        public int sl;
        public int t;
        public int x;
        public JSONArray yp;
        public Map<String, Object> z;
        public long c = 0;
        public long tt = 0;
        public long ve = 0;
        public boolean uj = false;
        public boolean n = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28284a = 0;
        public int sp = 0;
        public boolean u = false;

        public int a() {
            return this.sp;
        }

        public void c(JSONArray jSONArray) {
            this.yp = jSONArray;
        }

        public int da() {
            return this.da;
        }

        public int i() {
            long j = this.ve;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.c * 100) / j), 100);
        }

        public Map<String, Object> m() {
            return this.z;
        }

        public int n() {
            return this.f28284a;
        }

        public int sl() {
            return this.sl;
        }

        public int sp() {
            return this.x;
        }

        public int t() {
            return this.t;
        }

        public long tt() {
            return this.c;
        }

        public boolean u() {
            return this.u;
        }

        public long uj() {
            return this.ve;
        }

        public long ve() {
            return this.tt;
        }

        public int x() {
            return this.i;
        }

        public boolean yp() {
            return this.uj;
        }

        public boolean z() {
            return this.n;
        }

        public void a(int i) {
            this.t = i;
        }

        public JSONArray c() {
            return this.yp;
        }

        public void n(int i) {
            this.da = i;
        }

        public void tt(long j) {
            this.tt = j;
        }

        public void uj(int i) {
            this.i = i;
        }

        public void ve(long j) {
            this.ve = j;
        }

        public void c(long j) {
            this.c = j;
        }

        public void tt(int i) {
            this.sp = i;
        }

        public void ve(int i) {
            this.x = i;
        }

        public void c(int i) {
            this.f28284a = i;
        }

        public void tt(boolean z) {
            this.uj = z;
        }

        public void ve(boolean z) {
            this.n = z;
        }

        public void c(boolean z) {
            this.u = z;
        }

        public void c(Map<String, Object> map) {
            this.z = map;
        }
    }

    public nu(long j, String str, int i, com.byazt.jzl.a aVar, ic icVar) {
        this.c = j;
        this.tt = str;
        this.ve = i;
        this.uj = aVar;
        this.n = icVar;
    }

    public long c() {
        return this.c;
    }

    public ic n() {
        return this.n;
    }

    public String tt() {
        return this.tt;
    }

    public com.byazt.jzl.a uj() {
        return this.uj;
    }

    public int ve() {
        return this.ve;
    }
}
