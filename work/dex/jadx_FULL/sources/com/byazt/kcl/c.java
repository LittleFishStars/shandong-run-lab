package com.byazt.kcl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.byazt.aas.nb;
import com.byazt.bwm.sp;
import com.byazt.ete.da;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.yp;
import com.byazt.ouz.NativeExpressView;
import com.byazt.yih.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ic f28719a;
    public TTBaseVideoActivity n;
    public String sp;
    public com.byazt.pop.ve tt;
    public String x;
    public final Map<String, com.byazt.pop.ve> c = Collections.synchronizedMap(new HashMap());
    public final ve uj = new ve();
    public View ve = null;
    public long i = 0;
    public long da = 0;
    public long sl = 0;
    public long t = 0;
    public long u = 0;
    public long yp = 0;
    public boolean m = true;
    public boolean z = false;

    /* JADX INFO: renamed from: com.byazt.kcl.c$c, reason: collision with other inner class name */
    public interface InterfaceC0450c {
        void c(View view, da daVar);

        void c(String str, JSONObject jSONObject);
    }

    public interface tt {
        void c(boolean z);

        void c(boolean z, long j, long j2, String str, String str2);

        void c(boolean z, long j, String str, String str2);

        void c(boolean z, String str, String str2);

        void tt(boolean z, long j, long j2, String str, String str2);

        void ve(boolean z, long j, long j2, String str, String str2);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 187})
    public static class uj extends sp {
        public final String c;

        public uj(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.c(3).c(this.c, "recycleRes", 0L, 0L, "", "");
            } catch (Throwable th) {
                m.ve("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 132})
    public class ve implements DownloadListener {
        public boolean tt = true;

        public ve() {
        }

        public void c(boolean z) {
            this.tt = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            c(this.tt);
            c.this.c(str, true);
            c.this.n.c(1);
        }
    }

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.n = tTBaseVideoActivity;
    }

    private void x() {
        ic icVar = this.f28719a;
        if (icVar == null || icVar.i() != 4) {
            return;
        }
        this.tt = x.c(this.n, this.f28719a, this.sp);
    }

    public ve sp() {
        return this.uj;
    }

    public void a() {
        com.byazt.pop.ve veVar = this.tt;
        if (veVar != null) {
            veVar.ve();
        }
        for (Map.Entry<String, com.byazt.pop.ve> entry : this.c.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().ve();
            }
        }
        try {
            c(this.x);
        } catch (Throwable th) {
            m.ve("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    public void c(ic icVar, String str, String str2) {
        if (this.z) {
            return;
        }
        this.z = true;
        this.f28719a = icVar;
        this.sp = str;
        x();
        this.x = str2;
    }

    public void n() {
        for (Map.Entry<String, com.byazt.pop.ve> entry : this.c.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public com.byazt.pop.ve tt() {
        return this.tt;
    }

    public void uj() {
        com.byazt.pop.ve veVar = this.tt;
        if (veVar != null) {
            veVar.c((Activity) this.n, false);
            this.tt.tt();
        }
        for (Map.Entry<String, com.byazt.pop.ve> entry : this.c.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().tt();
            }
        }
    }

    public boolean ve() {
        return this.tt != null;
    }

    public void c() {
        ic icVar;
        if (this.tt == null && (icVar = this.f28719a) != null && icVar.i() == 4) {
            this.tt = x.c(this.n, this.f28719a, this.sp);
        }
    }

    private void c(String str) {
        com.byazt.bwm.n.tt(new uj("executeMultiProcessAppDownloadCallBack", str), 5);
    }

    public static yp c(int i) {
        return yp.c.c(com.byazt.wzi.c.c(gt.getContext()).c(i));
    }

    public void c(final tt ttVar) {
        com.byazt.pop.ve veVar = this.tt;
        if (veVar == null) {
            return;
        }
        veVar.c(new com.byazt.pop.c() { // from class: com.byazt.kcl.c.1
            @Override // com.byazt.pop.c
            public void c() {
                boolean z;
                if (System.currentTimeMillis() - c.this.i > NativeExpressView.my) {
                    c.this.i = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(z);
                }
            }

            @Override // com.byazt.pop.c
            public void tt(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - c.this.da > NativeExpressView.my) {
                    c.this.da = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.tt(z2, j, j2, str, str2);
                }
            }

            @Override // com.byazt.pop.c
            public void ve(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - c.this.t > NativeExpressView.my) {
                    c.this.t = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.ve(z2, j, j2, str, str2);
                }
            }

            @Override // com.byazt.pop.c
            public void c(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - c.this.sl > NativeExpressView.my) {
                    c.this.sl = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(z2, j, j2, str, str2);
                }
            }

            @Override // com.byazt.pop.c
            public void c(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - c.this.u > NativeExpressView.my) {
                    c.this.u = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(z2, j, str, str2);
                }
            }

            @Override // com.byazt.pop.c
            public void c(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - c.this.yp > NativeExpressView.my) {
                    c.this.yp = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(z, str, str2);
                }
            }
        });
    }

    public void c(String str, boolean z) {
        if (this.c.containsKey(str)) {
            com.byazt.pop.ve veVar = this.c.get(str);
            if (veVar != null) {
                if (z) {
                    veVar.c(com.byazt.wz.x.c(this.f28719a));
                }
                if (veVar instanceof com.byazt.wz.c) {
                    ((com.byazt.wz.c) veVar).x().c(this.m);
                } else if (veVar instanceof com.byazt.wz.sp) {
                    ((com.byazt.wz.sp) veVar).x().c(this.m);
                }
                veVar.c(nb.qy(this.f28719a), false);
                return;
            }
            return;
        }
        com.byazt.pop.ve veVarC = x.c(this.n, str, this.f28719a, this.sp);
        if (z) {
            veVarC.c(com.byazt.wz.x.c(this.f28719a));
        }
        if (veVarC instanceof com.byazt.wz.c) {
            ((com.byazt.wz.c) veVarC).x().c(this.m);
        } else if (veVarC instanceof com.byazt.wz.sp) {
            ((com.byazt.wz.sp) veVarC).x().c(this.m);
        }
        this.c.put(str, veVarC);
        veVarC.c(nb.qy(this.f28719a), false);
    }

    public void c(final InterfaceC0450c interfaceC0450c) {
        this.tt.c(1, new com.byazt.dk.ve.c() { // from class: com.byazt.kcl.c.2
            @Override // com.byazt.dk.ve.c
            public boolean c(int i, String str, String str2, String str3, Object obj) {
                if (i == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    boolean z = str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad");
                    if (z && str3.equals("click_start")) {
                        interfaceC0450c.c(c.this.ve, new da());
                        c.this.ve = null;
                        return true;
                    }
                    if (z) {
                        str3.hashCode();
                        if (str3.equals("click_continue")) {
                            com.byazt.ddx.uj.tt(c.this.f28719a, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.byazt.ddx.uj.tt(c.this.f28719a, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                }
                return true;
            }
        });
    }

    public void c(View view, InterfaceC0450c interfaceC0450c, da daVar) {
        if (this.tt != null && view != null) {
            if (view.getId() == 2114387609) {
                interfaceC0450c.c("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387630) {
                interfaceC0450c.c("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387875) {
                interfaceC0450c.c("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387793) {
                    interfaceC0450c.c("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0450c.c(view, daVar);
    }

    public void c(com.byazt.ua.c.InterfaceC0539c interfaceC0539c) {
        com.byazt.pop.ve veVar = this.tt;
        if (veVar != null) {
            veVar.c(interfaceC0539c);
        }
    }
}
