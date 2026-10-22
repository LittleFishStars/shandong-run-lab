package com.byazt.by;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.yv;
import com.byazt.bwm.sp;
import com.byazt.dna.u;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 54})
public final class ve {
    public static volatile ve tt;
    public SharedPreferences da;
    public volatile boolean x;
    public AtomicBoolean c = new AtomicBoolean(false);
    public AtomicBoolean ve = new AtomicBoolean(false);
    public AtomicInteger uj = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger n = new AtomicInteger(Integer.MAX_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f28337a = null;
    public AtomicInteger sp = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger i = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger sl = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger t = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger u = new AtomicInteger(Integer.MAX_VALUE);

    private ve() {
    }

    private boolean c(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        return i2 == 3 && i != 5;
    }

    private SharedPreferences u() {
        return com.byazt.nys.tt.tt(gt.getContext(), "sp_bidding_opt_libra", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp() {
        boolean zVe = ve();
        if (zVe) {
            com.byazt.tdq.uj.uj();
            uj.c();
            tt.c();
        }
        try {
            if (!com.byazt.xo.c.ve()) {
                String strC = c("/api/ad/union/ping");
                if (!TextUtils.isEmpty(strC)) {
                    com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
                    veVarVe.c(strC);
                    veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.by.ve.2
                        @Override // com.byazt.mh.c
                        public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                        }

                        @Override // com.byazt.mh.c
                        public void c(com.byazt.va.uj ujVar, IOException iOException) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        if (zVe) {
            DeviceUtils.c(3, false);
            c.c(gt.getContext(), 3);
            int i = com.byazt.ddx.uj.c;
            com.byazt.zlb.tt ttVar = com.byazt.zlb.tt.c;
            z();
            yv.c(259200000L);
        }
    }

    private void z() {
        com.byazt.xgx.c cVar = new com.byazt.xgx.c();
        u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
        DeviceUtils.c(Boolean.valueOf(cVar.c()));
        DeviceUtils.tt();
        uVar.getSSID(Boolean.valueOf(cVar.tt()));
        uVar.getWifiMac(Boolean.valueOf(cVar.tt()));
        uVar.getImsi(Boolean.valueOf(cVar.c()));
        uVar.getMacAddress(Boolean.valueOf(cVar.c()));
        uVar.getMcc();
    }

    public int a() {
        try {
            if (this.sp.get() == Integer.MAX_VALUE) {
                if (this.c.get()) {
                    this.sp.set(com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.da == null) {
                        this.da = u();
                    }
                    this.sp.set(this.da.getInt("key_network_module", 1));
                }
            }
            return this.sp.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public boolean da() {
        try {
            if (this.sl.get() == Integer.MAX_VALUE) {
                if (this.c.get()) {
                    this.sl.set(com.byazt.ti.tt.c("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.da == null) {
                        this.da = u();
                    }
                    this.sl.set(this.da.getInt("boost_save_config", 0));
                }
            }
            return this.sl.get() == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public int i() {
        try {
            if (this.t.get() == Integer.MAX_VALUE) {
                if (this.da == null) {
                    this.da = u();
                }
                this.t.set(this.da.getInt("bst_pl_exec_conf", -1));
                if (this.t.get() >= 0) {
                    return this.t.get();
                }
                this.t.set(this.da.getInt("_use_pl_", 0));
            }
            return this.t.get();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int n() {
        try {
            if (this.n.get() == Integer.MAX_VALUE) {
                if (this.c.get()) {
                    this.n.set(com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.da == null) {
                        this.da = u();
                    }
                    this.n.set(this.da.getInt("key_net_queue_limit", 7));
                }
            }
            return this.n.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public void sl() {
        try {
            com.byazt.ti.tt.c("sp_bidding_opt_libra");
            SharedPreferences.Editor editorEdit = u().edit();
            editorEdit.clear();
            editorEdit.apply();
            this.uj.set(0);
            this.n.set(7);
            this.i.set(0);
        } catch (Throwable unused) {
        }
    }

    public int sp() {
        try {
            if (this.i.get() == Integer.MAX_VALUE) {
                if (this.c.get()) {
                    this.i.set(com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.da == null) {
                        this.da = u();
                    }
                    this.i.set(this.da.getInt("key_req_build_opt", 1));
                }
            }
            return this.i.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void t() {
        com.byazt.bwm.n.c(new sp("advance_init_rb") { // from class: com.byazt.by.ve.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ve.this.ve.get()) {
                        return;
                    }
                    ve.this.ve.set(true);
                    ve.this.yp();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    public String uj() {
        try {
            if (TextUtils.isEmpty(this.f28337a)) {
                if (this.c.get()) {
                    this.f28337a = com.byazt.ti.tt.tt("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.da == null) {
                        this.da = u();
                    }
                    this.f28337a = this.da.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.f28337a = TextUtils.isEmpty(this.f28337a) ? "api-access.pangolin-sdk-toutiao.com" : this.f28337a;
        return this.f28337a;
    }

    public boolean ve() {
        try {
            if (this.uj.get() == Integer.MAX_VALUE) {
                if (this.c.get()) {
                    this.uj.set(com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.da == null) {
                        this.da = u();
                    }
                    this.uj.set(this.da.getInt("key_req_body_opt", 1));
                }
            }
            return this.uj.get() == 1;
        } catch (Throwable unused) {
        }
    }

    public int x() {
        if (this.u.get() == Integer.MAX_VALUE) {
            this.u.set(i());
        }
        return this.u.get();
    }

    public static ve c() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    public boolean tt() {
        if (!this.x) {
            this.c.set(com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.x = true;
        }
        return this.c.get();
    }

    public void tt(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.f28337a = strOptString;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject == null) {
                if (com.byazt.xo.c.sp()) {
                    return;
                }
                c("key_url_ads", strOptString);
                return;
            }
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("network_module", 1);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("if_req_body_opt", 1);
                this.uj.set(iOptInt2);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("net_queue_limit", 7);
                this.n.set(iOptInt3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("req_build_opt", 0);
                this.i.set(iOptInt4);
                int i = jSONObjectOptJSONObject.optBoolean("_use_pl_", false) ? 1 : 0;
                String strOptString2 = jSONObjectOptJSONObject.optString("zeus_sp", "");
                int iOptInt5 = jSONObjectOptJSONObject.optInt("bst_pl_exec_conf", -1);
                int iOptInt6 = jSONObjectOptJSONObject.optInt("boost_save_config", 0);
                this.sl.set(iOptInt6);
                long jOptLong = jSONObjectOptJSONObject.optLong("bstlayer_init_delay_time", 0L);
                if (com.byazt.xo.c.sp()) {
                    return;
                }
                if (this.c.get()) {
                    try {
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(iOptInt));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(iOptInt2));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(iOptInt3));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(iOptInt4));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(i));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "bst_pl_exec_conf", Integer.valueOf(iOptInt5));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "key_url_ads", strOptString);
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(iOptInt6));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "bstlayer_init_delay_time", Long.valueOf(jOptLong));
                        com.byazt.ti.tt.c("sp_bidding_opt_libra", "zeus_sp", strOptString2);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                try {
                    if (this.da == null) {
                        this.da = u();
                    }
                    SharedPreferences.Editor editorEdit = this.da.edit();
                    editorEdit.putInt("key_network_module", iOptInt);
                    editorEdit.putInt("key_req_body_opt", iOptInt2);
                    editorEdit.putInt("key_net_queue_limit", iOptInt3);
                    editorEdit.putInt("key_req_build_opt", iOptInt4);
                    editorEdit.putInt("_use_pl_", i);
                    editorEdit.putInt("bst_pl_exec_conf", iOptInt5);
                    editorEdit.putString("key_url_ads", strOptString);
                    editorEdit.putInt("boost_save_config", iOptInt6);
                    editorEdit.putLong("bstlayer_init_delay_time", jOptLong);
                    editorEdit.putString("zeus_sp", strOptString2);
                    editorEdit.commit();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
        }
    }

    public void c(boolean z) {
        this.c.set(z);
        if (z) {
            c("key_support_multiprocess", 1);
        }
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.u.set(jSONObject.optInt("bst_pl_exec_conf", -1));
        }
    }

    private void c(String str, int i) {
        try {
            if (this.c.get()) {
                com.byazt.ti.tt.c("sp_bidding_opt_libra", str, Integer.valueOf(i));
                return;
            }
            if (this.da == null) {
                this.da = u();
            }
            SharedPreferences.Editor editorEdit = this.da.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    private void c(String str, String str2) {
        try {
            if (this.c.get()) {
                com.byazt.ti.tt.c("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.da == null) {
                this.da = u();
            }
            SharedPreferences.Editor editorEdit = this.da.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static String c(String str) {
        String strUj = c().uj();
        if (TextUtils.isEmpty(strUj)) {
            return null;
        }
        return String.format("https://%s%s", strUj, str);
    }

    public boolean c(int i) {
        if (i <= 0) {
            return false;
        }
        return c(i, sp());
    }
}
