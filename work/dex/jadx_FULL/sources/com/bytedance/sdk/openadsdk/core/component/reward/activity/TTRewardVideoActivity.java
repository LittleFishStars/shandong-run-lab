package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.aas.gr;
import com.byazt.aas.pf;
import com.byazt.cf.sp;
import com.byazt.dna.u;
import com.byazt.dqg.n;
import com.byazt.ee.c;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.l;
import com.byazt.ete.lt;
import com.byazt.ete.my;
import com.byazt.ete.or;
import com.byazt.fh.a;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.omf.p;
import com.byazt.qal.tt;
import com.byazt.ukr.yp;
import com.byazt.ut.uj;
import com.byazt.vb.ve;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.zj.adlib.c49;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String dz;
    private String iu;
    private int j;
    private String s;
    private String y;
    private ve yf;
    private final int kk = 10111;
    private final int tx = 10112;
    private final int v = 10113;
    private final int os = 10114;
    private final int oz = 10115;
    private final int r = 10116;
    private final AtomicBoolean ma = new AtomicBoolean();

    @DungeonFlag
    private int dz() {
        final int i = 0;
        if (kp.uj(this.qp)) {
            if (this.yp.get()) {
                i = 10116;
            } else if (!j()) {
                i = 10111;
            }
        }
        if (gt.tt().wq() == 0) {
            return i;
        }
        boolean zX = gr.x();
        int iC = gr.c(this.qp.ey() + LoginConstants.UNDER_LINE + this.qp.ck());
        if (zX) {
            i = 10115;
        } else if (iC == gr.tt) {
            i = 10114;
        } else if (iC == gr.ve) {
            i = 10113;
        }
        yp.c().tt(new c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                tt<tt> ttVarTt = tt.tt();
                ttVarTt.c("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", i);
                ttVarTt.tt(jSONObject.toString());
                return ttVarTt;
            }
        }, "armor_reward");
        return i;
    }

    private Object iu() {
        Map<String, Object> mapYt;
        ic icVar = this.qp;
        if (icVar == null || (mapYt = icVar.yt()) == null || !mapYt.containsKey("rs_info")) {
            return null;
        }
        return mapYt.get("rs_info");
    }

    private boolean j() {
        if (TextUtils.isEmpty(this.qp.qy())) {
            return false;
        }
        return this.ma.get();
    }

    private void ma() {
        this.h.c("cancelClickLandingRewardTip", (JSONObject) null);
    }

    private void y() {
        n nVar;
        if (kp.sp(this.qp) && this.cu.gt() >= kp.da(this.qp)) {
            if (!this.bx.sp() || (nVar = this.h) == null || nVar.i() != 0) {
                pf.c(this.sv, kp.i(this.qp), 0);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("toast_text", kp.i(this.qp));
                this.h.c("showToast", jSONObject);
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void bm() {
        super.bm();
        if (kp.nu(this.qp) || this.zb.d() || my.uj(this.qp)) {
            return;
        }
        if (this.cu.eo()) {
            this.eo.c(false, null, null, true, true);
            return;
        }
        int iA = this.bx.a(true);
        int iA2 = this.bx.a(or.tt(yv(), this.qp, true));
        String str = "已领取奖励";
        if (s() || this.bx.rh()) {
            com.byazt.kcl.n nVar = this.eo;
            if (iA2 > 0) {
                str = iA2 + "s";
            }
            nVar.c(false, str, "跳过", false, true);
        } else {
            com.byazt.kcl.n nVar2 = this.eo;
            if (iA2 > 0) {
                str = iA2 + "s";
            }
            nVar2.c(false, str, null, false, false);
        }
        this.bx.tt(iA);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public String d() {
        if (this.j == 0 || TextUtils.isEmpty(this.iu)) {
            return (kp.tt(this.qp) == 0 || TextUtils.isEmpty(kp.c(this.qp))) ? "" : kp.c(this.qp);
        }
        return this.iu;
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public String eo() {
        if (this.q.c() && !TextUtils.isEmpty(this.q.sp()) && !TextUtils.isEmpty(this.q.a())) {
            return this.q.sp();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(h());
        return sb.toString();
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public boolean gr() {
        return super.gr() || this.q.n();
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void gt() {
        super.gt();
        r();
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public int h() {
        if (this.j != 0 && !TextUtils.isEmpty(this.iu)) {
            return this.j;
        }
        if (kp.tt(this.qp) == 0 || TextUtils.isEmpty(kp.c(this.qp))) {
            return 0;
        }
        return kp.tt(this.qp);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public boolean md() {
        return this.q.c() || this.b.uj();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.zb.cu()) {
            return;
        }
        this.bx.c(i, i2, intent);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ve veVar;
        super.onDestroy();
        this.q.ve();
        List<ve> listC = com.byazt.epi.c.c();
        if (listC == null || listC.size() == 0 || (veVar = this.yf) == null) {
            return;
        }
        listC.remove(veVar);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (kp.nu(this.qp)) {
            this.bx.ve(a.tt);
            a.ve = false;
            a.tt = 0;
            a.c = this.bx.sv();
            ve(0);
        }
        if (kp.my(this.qp) && a.uj) {
            ma();
            uj(4);
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void p() {
        if (this.ve.getAndSet(true) || this.q.c()) {
            return;
        }
        com.byazt.rob.c cVar = this.to;
        if ((cVar == null || !cVar.ve()) && !or.tt(yv(), this.qp, true)) {
            c("onAdClose", (Bundle) null);
        }
    }

    public void r() {
        if (or.tt(yv(), this.qp, true)) {
            if (this.b.c() > this.bx.pf()) {
                this.b.c(false);
            }
            int iMax = Math.max(this.bx.a(true) - this.b.c(), 0);
            int iA = this.bx.a(false) - this.b.c();
            if (this.bx.x(false)) {
                iA = Math.max(0, iA - iMax);
            }
            if (this.uj.containsKey(0)) {
                iMax = 999;
                iA = 999;
            }
            sl(iA);
            t(iMax);
            if (this.uj.containsKey(0)) {
                ve(0, true);
            }
            os();
        }
    }

    public boolean s() {
        return Math.round(((float) (this.cu.h() + (((long) this.bx.l()) * 1000))) / 1000.0f) >= this.bx.lo();
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void x(int i) {
        if (!this.uj.containsKey(0)) {
            this.tt.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    h.c(TTRewardVideoActivity.this.sv, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (lt.c(this.qp)) {
            this.tt.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    h.c(TTRewardVideoActivity.this.sv, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.q.ve(i);
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public boolean yv() {
        return true;
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public String zb() {
        if (this.q.c() && !TextUtils.isEmpty(this.q.sp()) && !TextUtils.isEmpty(this.q.a())) {
            return this.q.a();
        }
        return d();
    }

    @DungeonFlag
    private JSONObject tt(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", d());
            jSONObject.put("reward_amount", h());
            jSONObject.put("network", rh.ve(gt.getContext()));
            jSONObject.put("sdk_version", p.n);
            jSONObject.put("user_agent", ((u) uj.getService("device_info_new")).getWebViewUA(false));
            jSONObject.put("extra", this.qp.q_());
            jSONObject.put("media_extra", this.s);
            jSONObject.put(CropKey.VIDEO_DURATION, this.cu.p());
            jSONObject.put("play_start_ts", this.l);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.cu.gt());
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.y);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace(c49.f40900a, ""));
            jSONObject.put(MediationConstant.BAIDU_REWARD_TYPE, i);
            jSONObject.putOpt("rs_info", iu());
            if (kp.uj(this.qp)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.byazt.qh.tt.c(jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void uj() {
        ve veVar = new ve() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
            @Override // com.byazt.vb.ve
            public void c(String str, String str2) {
                if (TTRewardVideoActivity.this.qp != null) {
                    String strQy = TTRewardVideoActivity.this.qp.qy();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, strQy)) {
                        TTRewardVideoActivity.this.ma.set(true);
                    }
                }
            }
        };
        this.yf = veVar;
        com.byazt.epi.c.c(veVar);
        super.uj();
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void ve(int i) {
        if (i != 0) {
            uj(i);
            return;
        }
        if (this.bx.pf() > 0) {
            return;
        }
        if ((!kp.p(this.qp) || this.f28770a.get()) && this.bx.or()) {
            uj(i);
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public String c() {
        return this.dz;
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void c(Intent intent) {
        super.c(intent);
        if (intent == null) {
            return;
        }
        this.s = intent.getStringExtra("media_extra");
        this.y = intent.getStringExtra(PtgRewardConstant.REWARD_PARAMS.USER_ID);
        this.iu = intent.getStringExtra("reward_name");
        this.dz = intent.getStringExtra("userData");
        this.j = intent.getIntExtra("reward_amount", 0);
        this.q.c(intent.getBooleanExtra("is_play_again", false));
        this.q.c(intent.getIntExtra("play_again_count", 0));
        this.q.tt(intent.getBooleanExtra("custom_play_again", false));
        this.q.tt(intent.getIntExtra("source_rit_id", 0));
        this.q.c(intent.getStringExtra("reward_again_name"));
        this.q.tt(intent.getStringExtra("reward_again_amount"));
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void uj(final int i) {
        if (!this.m.getAndSet(true)) {
            this.q.uj();
        }
        if (this.uj.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.uj.put(Integer.valueOf(i), Boolean.TRUE);
        this.pf.ve();
        boolean z = !kp.zm(this.qp);
        final int iH = h();
        final String strD = d();
        int iDz = dz();
        boolean z2 = iDz == 0;
        m.c("GROMORE_SS_REWARD_VERIFY", "sh ——》 isValid: " + z2 + ", direct: " + z + ", errCode: " + iDz);
        if (z2 && !z) {
            ve(i, true);
            gt.c().c(tt(i, true), new gu.n() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // com.byazt.omf.gu.n
                public void c(int i2, String str) {
                    TTRewardVideoActivity.this.ve(TTRewardVideoActivity.this.c(i, false, i2, str, iH, strD, false));
                }

                @Override // com.byazt.omf.gu.n
                public void c(com.byazt.omf.gr.uj ujVar) {
                    int iC = ujVar.ve.c();
                    String strTt = ujVar.ve.tt();
                    TTRewardVideoActivity.this.ve(ujVar.tt ? TTRewardVideoActivity.this.c(i, true, 10111, "reward failed", iC, strTt, true) : TTRewardVideoActivity.this.c(i, false, 10112, "server refuse", iC, strTt, true));
                }
            });
        } else {
            ve(c(i, z2, iDz, "reward failed", iH, strD, false));
            ve(i, z2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void ve(boolean z) {
        int i;
        if (this.gu) {
            if (gt.tt().hz() == 1) {
                i = 2000;
            } else {
                i = -1;
            }
        } else if (z) {
            i = 0;
        } else {
            i = -1;
        }
        int i2 = this.q.c() ? -1 : i;
        if (i2 < 0 || this.gt.get()) {
            return;
        }
        if (i2 == 0) {
            if (this.gt.getAndSet(true)) {
                return;
            }
            sp.c().c(this.qp, String.valueOf(this.ic));
            return;
        }
        this.tt.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (TTRewardVideoActivity.this.gt.getAndSet(true)) {
                    return;
                }
                sp.c().c(TTRewardVideoActivity.this.qp, String.valueOf(TTRewardVideoActivity.this.ic));
            }
        }, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            tt("onRewardVerify", bundle);
        }
        tt("onRewardArrived", bundle);
        this.pf.c(bundle);
        this.bx.c(i);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public boolean c(Bundle bundle) {
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        veVarC.put("is_reward_deep_link_to_live", false);
        veVarC.put("click_to_live_duration", System.currentTimeMillis());
        return super.c(bundle);
    }

    private void ve(int i, boolean z) {
        if (i == 0) {
            this.h.yp();
            this.nb.tt(z);
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle c(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", kp.c(this.qp, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && kp.sp(this.qp) && this.cu.gt() >= kp.da(this.qp)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void tt() {
        if (!this.b.n() && this.uj.containsKey(0) && this.q.ve(2)) {
            return;
        }
        super.tt();
    }

    private void tt(String str, Bundle bundle) {
        com.byazt.yi.c.c(0, this.q.c() ? l.c(this.hd) : this.hd, str, bundle);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void c(String str, Bundle bundle) {
        tt(str, bundle);
    }
}
