package com.byazt.dj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 13})
public class tt {
    public final PluginValueSet c;
    public String tt;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public final com.byazt.rl.c c;
        public String tt;

        public c(String str) {
            this.c = com.byazt.rl.c.c();
            this.tt = str;
        }

        public c a(String str) {
            this.c.c(260014, str);
            return this;
        }

        public c c(String str) {
            this.c.c(260001, str);
            return this;
        }

        public c da(String str) {
            this.c.c(260024, str);
            return this;
        }

        public c i(String str) {
            this.c.c(260022, str);
            return this;
        }

        public c n(String str) {
            this.c.c(260013, str);
            return this;
        }

        public c sp(String str) {
            this.c.c(260019, str);
            return this;
        }

        public c tt(String str) {
            this.c.c(260002, str);
            return this;
        }

        public c uj(String str) {
            this.c.c(260004, str);
            return this;
        }

        public c ve(String str) {
            this.c.c(260003, str);
            return this;
        }

        public c x(String str) {
            this.c.c(260021, str);
            return this;
        }

        public c a(int i) {
            this.c.c(260018, i);
            return this;
        }

        public c c(boolean z) {
            this.c.c(260005, z);
            return this;
        }

        public c n(int i) {
            this.c.c(260016, i);
            return this;
        }

        public c sp(int i) {
            this.c.c(260020, i);
            return this;
        }

        public c tt(int i) {
            this.c.c(260007, i);
            return this;
        }

        public c uj(int i) {
            this.c.c(260015, i);
            return this;
        }

        public c ve(boolean z) {
            this.c.c(260011, z);
            return this;
        }

        public c x(int i) {
            this.c.c(260025, i);
            return this;
        }

        public c c(int i) {
            this.c.c(260006, i);
            return this;
        }

        public c tt(float f) {
            this.c.c(260009, f);
            return this;
        }

        public c uj(boolean z) {
            this.c.c(260026, z);
            return this;
        }

        public c ve(int i) {
            this.c.c(2600012, i);
            return this;
        }

        public c(tt ttVar) {
            this.c = com.byazt.rl.c.c(ttVar.c);
            this.tt = ttVar.tt;
        }

        public c c(float f) {
            this.c.c(260008, f);
            return this;
        }

        public c tt(boolean z) {
            this.c.c(260010, z);
            return this;
        }

        public c c(Map<String, Object> map) {
            this.c.c(8260032, map);
            return this;
        }

        public c c(int[] iArr) {
            this.c.c(260017, iArr);
            return this;
        }

        public c c(Object obj) {
            this.c.c(260023, obj);
            return this;
        }

        public tt c() {
            return new tt(this.c.tt().sparseArray(), this.tt);
        }
    }

    public tt(SparseArray<Object> sparseArray, String str) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
        this.tt = str;
    }

    public int a() {
        return this.c.intValue(260006);
    }

    public String c() {
        return (String) this.c.objectValue(260001, String.class);
    }

    public boolean da() {
        return this.c.booleanValue(260010);
    }

    public String gr() {
        return (String) this.c.objectValue(260024, String.class);
    }

    public int gt() {
        return this.c.intValue(260020);
    }

    public Object gu() {
        return this.c.objectValue(260023, Object.class);
    }

    public float i() {
        return this.c.floatValue(260009);
    }

    public int m() {
        return this.c.intValue(260016);
    }

    public String my() {
        return (String) this.c.objectValue(260019, String.class);
    }

    public boolean n() {
        return this.c.booleanValue(260005);
    }

    public int[] nu() {
        return (int[]) this.c.objectValue(260017, int[].class);
    }

    public String or() {
        return this.tt;
    }

    public String qy() {
        return (String) this.c.objectValue(260022, String.class);
    }

    public int rh() {
        return this.c.intValue(260018);
    }

    public String rl() {
        return (String) this.c.objectValue(260021, String.class);
    }

    public boolean sl() {
        return this.c.booleanValue(260011);
    }

    public int sp() {
        return this.c.intValue(260007);
    }

    public int t() {
        return this.c.intValue(2600012);
    }

    public String u() {
        return (String) this.c.objectValue(260013, String.class);
    }

    public String uj() {
        return (String) this.c.objectValue(260004, String.class);
    }

    public String ve() {
        return (String) this.c.objectValue(260003, String.class);
    }

    public float x() {
        return this.c.floatValue(260008);
    }

    public String yp() {
        return (String) this.c.objectValue(260014, String.class);
    }

    public boolean yv() {
        return this.c.booleanValue(260026);
    }

    public int z() {
        return this.c.intValue(260015);
    }

    public Map zb() {
        return (Map) this.c.objectValue(8260032, Map.class);
    }

    public int zm() {
        return this.c.intValue(260025);
    }

    public void c(String str) {
        this.tt = this.tt;
    }

    public String tt() {
        return (String) this.c.objectValue(260002, String.class);
    }
}
