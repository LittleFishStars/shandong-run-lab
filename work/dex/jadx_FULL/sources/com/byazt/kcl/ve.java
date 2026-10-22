package com.byazt.kcl;

import android.os.Bundle;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.dna.u;
import com.byazt.ete.da;
import com.byazt.ete.gt;
import com.byazt.ete.i;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ddx.n f28723a;
    public final TTBaseVideoActivity c;
    public View n;
    public ic tt;
    public boolean uj = false;
    public String ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 24})
    public static class c implements com.byazt.ya.c {
        public final int c;
        public final long tt;
        public final JSONObject ve;

        public c(int i, long j, JSONObject jSONObject) {
            this.c = i;
            this.tt = j;
            this.ve = jSONObject;
        }

        @Override // com.byazt.ya.c
        public void onSend(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.ve;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.c);
            jSONObject2.put("duration", this.tt);
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
        }
    }

    public ve(TTBaseVideoActivity tTBaseVideoActivity) {
        this.c = tTBaseVideoActivity;
    }

    private boolean a() {
        ic icVar = this.tt;
        return icVar == null || gt.sl(icVar) != 1;
    }

    public com.byazt.ddx.n n() {
        if (this.f28723a == null) {
            this.f28723a = new com.byazt.ddx.n(this.tt, this.ve);
        }
        return this.f28723a;
    }

    public void tt() {
        final JSONObject jSONObjectC = c(new JSONObject());
        com.byazt.ddx.uj.c(this.tt, this.ve, "skip_endcard", new com.byazt.ya.c() { // from class: com.byazt.kcl.ve.2
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                com.byazt.ic.c.c(jSONObjectC, ve.this.tt);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectC);
            }
        });
    }

    @DungeonFlag
    public JSONObject uj() {
        try {
            long jYp = this.c.pu().yp();
            int iZ = this.c.pu().z();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jYp);
                jSONObject.put("percent", iZ);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void ve() {
        final JSONObject jSONObjectC = c(new JSONObject());
        com.byazt.ddx.uj.c(this.tt, this.ve, "reward_arrived_begin", new com.byazt.ya.c() { // from class: com.byazt.kcl.ve.3
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                com.byazt.ic.c.c(jSONObjectC, ve.this.tt);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectC);
            }
        });
    }

    public void c(ic icVar, String str, View view) {
        if (this.uj) {
            return;
        }
        this.uj = true;
        this.tt = icVar;
        this.ve = str;
        this.n = view;
    }

    @DungeonFlag
    private void tt(View view, da daVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387609) {
            c("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387630) {
            c("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387875) {
            c("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387793) {
            c("click_play_logo", (JSONObject) null);
        } else if (view.getId() != 2114387649 && view.getId() != 2114387925 && view.getId() != 2114387964) {
            if (view.getId() == 2114387642) {
                c("click_video", uj());
            } else if (view.getId() == 2114387864) {
                c("fallback_endcard_click", uj());
            }
        } else {
            c("click_start_play_bar", uj());
        }
        ve(view, daVar);
    }

    @DungeonFlag
    private void ve(View view, da daVar) {
        if (a() || this.tt == null || view == null) {
            return;
        }
        if (view.getId() == 2114387609 || view.getId() == 2114387630 || view.getId() == 2114387875 || view.getId() == 2114387793 || view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964 || view.getId() == 2114387830 || view.getId() == 2114387642 || view.getId() == 2114387864) {
            int displayDpi = ((u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi();
            com.byazt.ddx.uj.c("click_other", this.tt, new i.c().a(daVar.nu()).n(daVar.rh()).uj(daVar.my()).ve(daVar.gt()).tt(System.currentTimeMillis()).c(0L).tt(pf.c(this.n)).c(pf.c((View) null)).ve(pf.ve(this.n)).uj(pf.ve((View) null)).uj(daVar.n()).n(daVar.a()).a(daVar.sp()).c(daVar.u()).ve(x.m().tt() ? 1 : 2).tt(displayDpi).c(pf.a(com.byazt.omf.gt.getContext())).tt(pf.sp(com.byazt.omf.gt.getContext())).c(com.byazt.wz.x.tt(this.tt)).c(), this.ve, true, this.c.ic(), -1, false, daVar.c());
        }
    }

    public JSONObject c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.c.to() != null) {
                jSONObject.put("reward_full_scene_type", this.c.to().eo());
                this.c.to().c(jSONObject);
            }
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }

    public void c(Map<String, Object> map) {
        if (map == null || this.c.to() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.c.to().eo()));
        this.c.to().c(map);
    }

    public void c() {
        final JSONObject jSONObjectC = c(new JSONObject());
        com.byazt.ddx.uj.c(this.tt, this.ve, FreeSpaceBox.TYPE, new com.byazt.ya.c() { // from class: com.byazt.kcl.ve.1
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                com.byazt.ic.c.c(jSONObjectC, ve.this.tt);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectC);
            }
        });
    }

    public void c(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z);
            jSONObject2.put("isServerCallback", z2);
            jSONObject2.put(MediationConstant.KEY_REWARD_TYPE, i);
            jSONObject2.put("errorCode", i2);
            jSONObject2.put("errorMsg", string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e) {
            m.uj("RewardFullEventManager", e.getMessage());
        }
        com.byazt.ddx.uj.c(this.tt, this.ve, str, new com.byazt.ya.c() { // from class: com.byazt.kcl.ve.4
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject3) throws JSONException {
                com.byazt.ic.c.c(jSONObject, ve.this.tt);
                jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, ve.this.c(jSONObject));
            }
        });
    }

    public void c(String str, int i, String str2) {
        final JSONObject jSONObjectC = c(new JSONObject());
        try {
            jSONObjectC.put("dialog_type", i);
            jSONObjectC.put("template_url", str2);
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.ddx.uj.c(this.tt, this.ve, str, new com.byazt.ya.c() { // from class: com.byazt.kcl.ve.5
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                com.byazt.ic.c.c(jSONObjectC, ve.this.tt);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, ve.this.c(jSONObjectC));
            }
        });
    }

    public void c(boolean z, int i, long j) {
        new com.byazt.ddx.c.C0382c().n(this.tt.uj()).c(this.ve).tt(z ? "scroll_up" : "scroll_down").uj(this.tt.w_()).c(new c(i, j, c(new JSONObject())));
    }

    public void c(View view, da daVar) {
        try {
            tt(view, daVar);
        } catch (Exception e) {
            m.uj("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    public void c(String str, JSONObject jSONObject) {
        ic icVar = this.tt;
        String str2 = this.ve;
        if (!this.c.yv()) {
            jSONObject = null;
        }
        com.byazt.ddx.uj.c(icVar, str2, str, jSONObject);
    }
}
