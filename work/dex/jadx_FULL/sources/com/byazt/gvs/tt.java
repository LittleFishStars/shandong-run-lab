package com.byazt.gvs;

import androidx.annotation.NonNull;
import com.byazt.bog.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 193, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f28591a = "7z_unzip_start";
    public static String c = "request_finish";
    public static String da = "rm_entry_finish";
    public static String i = "load_finish";
    public static String n = "install_finish";
    public static String sl = "e_create_ac_failed";
    public static String sp = "7z_unzip_finish";
    public static volatile tt t = null;
    public static String tt = "download_start";
    public static String uj = "install_start";
    public static String ve = "download_finish";
    public static String x = "load_start";
    public final List<com.byazt.gvs.c> u = new ArrayList();

    @com.byazt.zqa.c(c = {0, 1, 193, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f28592a = 12001;
        public static int c = 1;
        public static int cu = 50004;
        public static int d = 40000;
        public static int da = 20000;
        public static int eo = 41000;
        public static int gr = 32004;
        public static int gt = 32000;
        public static int gu = 32003;
        public static int h = 32999;
        public static int i = 12004;
        public static int m = 22002;
        public static int md = 32008;
        public static int my = 31000;
        public static int n = 12000;
        public static int nu = 22999;
        public static int or = 50000;
        public static int p = 32007;
        public static int qy = 32002;
        public static int rh = 30000;
        public static int rl = 32001;
        public static int sl = 21000;
        public static int sp = 12002;
        public static int t = 21001;
        public static int tt = 2;
        public static int u = 21002;
        public static int uj = -2;
        public static int ve = -1;
        public static int x = 12003;
        public static int yp = 22000;
        public static int yv = 32006;
        public static int z = 22001;
        public static int zb = 42000;
        public static int zm = 32005;
    }

    private tt() {
    }

    public static tt c() {
        if (t == null) {
            synchronized (tt.class) {
                t = new tt();
            }
        }
        return t;
    }

    public void c(@NonNull com.byazt.gvs.c cVar) {
        synchronized (this.u) {
            this.u.add(cVar);
        }
    }

    public void c(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.u) {
            Iterator<com.byazt.gvs.c> it = this.u.iterator();
            while (it.hasNext()) {
                try {
                    it.next().c(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    a.c(th);
                }
            }
        }
    }
}
