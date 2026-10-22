package com.byazt.apd;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.ete.ic;
import com.byazt.ete.sv;
import com.byazt.ogz.i;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ysz.n;
import com.byazt.ysz.sp;
import com.byazt.ysz.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1580, 13})
public class tt {
    public final uj c;

    @com.byazt.zqa.c(c = {0, 1, 1580, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {
        public static final tt c = new tt();
    }

    public static final tt c() {
        return c.c;
    }

    public int a() {
        return com.byazt.by.uj.c().ve();
    }

    public long i() {
        return this.c.ve();
    }

    public int n() {
        return this.c.n();
    }

    public String sp() {
        return this.c.sp();
    }

    public boolean tt(ic icVar) {
        if (icVar == null || TextUtils.isEmpty(icVar.da())) {
            return false;
        }
        return c(icVar.da(), icVar.n());
    }

    public void uj() {
        this.c.uj();
    }

    public int ve() {
        return this.c.tt();
    }

    public JSONObject x() {
        return this.c.x();
    }

    private tt() {
        if (!i.c()) {
            this.c = new com.byazt.ysz.tt();
            return;
        }
        if (p.sp) {
            this.c = new sp();
        } else if (p.x()) {
            this.c = new n();
        } else {
            this.c = new com.byazt.ysz.tt();
        }
    }

    public boolean a(ic icVar) {
        return icVar != null && icVar.ma() == 2;
    }

    public void c(Function<SparseArray<Object>, Object> function) {
        this.c.c(function);
    }

    public void n(ic icVar) {
        this.c.ve(icVar);
    }

    public void uj(final ic icVar) {
        if (icVar == null) {
            return;
        }
        n(icVar);
        if (TextUtils.isEmpty(icVar.da())) {
            return;
        }
        int iVe = com.byazt.by.uj.c().ve() + 1;
        if (iVe > 100) {
            iVe = 100;
        }
        com.byazt.by.uj.c().c(iVe);
        final int iVe2 = ve();
        final int iN = n();
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        if (icVar.n() == 1 && icVar.xl() == 1) {
            com.byazt.ukr.tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.apd.tt.1
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(LoginConstants.EXT, icVar.w_());
                        jSONObject.put("live_sdk_status", iVe2);
                        jSONObject.put("live_auth_status", iN);
                        jSONObject.put("app_start_time", jElapsedRealtime);
                        jSONObject.put("is_web", icVar.s_());
                    } catch (Throwable unused) {
                    }
                    return com.byazt.qal.tt.tt().c("saas_miss").tt(jSONObject.toString());
                }
            }, "saas_miss", true);
        }
    }

    public int ve(ic icVar) {
        if (gt.tt().ym()) {
            return this.c.tt(icVar);
        }
        return 0;
    }

    public int c(Context context, com.byazt.eia.i iVar, Map<String, Object> map) {
        if (context == null || iVar == null) {
            return 5;
        }
        return this.c.c(context, iVar, map);
    }

    public void tt() {
        this.c.c();
    }

    public void c(String str, boolean z) {
        this.c.c(str, z);
    }

    public int c(com.byazt.eia.i iVar, com.byazt.ysz.ve veVar, String str, Map<String, Object> map) {
        return this.c.c(iVar, veVar, str, map);
    }

    public int c(Context context, ic icVar, Map<String, Object> map) {
        return this.c.c(context, icVar, map);
    }

    public boolean c(ic icVar) {
        return this.c.a_(icVar);
    }

    public void c(String str, ic icVar, long j) {
        this.c.c(str, icVar, j);
    }

    public boolean c(String str, int i) {
        return this.c.c(str, i);
    }

    public void c(View view, sv svVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || svVar == null || (tag = view.getTag(TTAdConstant.KEY_CLICK_AREA)) == null || !(tag instanceof Integer)) {
            return;
        }
        int iIntValue = ((Integer) tag).intValue();
        int i = iIntValue & 255;
        int i2 = (iIntValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (i == 101 && !svVar.ve()) {
            i = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i));
        map2.put("click_saas_area", Integer.valueOf(i2));
    }

    public int c(String str) {
        return this.c.c(str);
    }

    public int c(com.byazt.cn.tt ttVar, boolean z) {
        return this.c.c(ttVar, z);
    }

    public void c(com.byazt.qh.uj ujVar) {
        this.c.c(ujVar);
    }
}
