package com.byazt.qmz;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.dna.qp;
import com.byazt.nr.d;
import com.byazt.oaq.tt;
import com.byazt.sz.z;
import com.byazt.te.uj;
import com.byazt.xj.ve;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1234, 20})
public class c implements qp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ve f28979a;
    public ve da;
    public boolean gr;
    public int gt;
    public boolean gu;
    public ve i;
    public int m;
    public boolean md;
    public boolean my;
    public ve n;
    public int nu;
    public int p;
    public int qy;
    public int rl;
    public ve sl;
    public ve sp;
    public int t;
    public z tt;
    public int u;
    public ve uj;
    public ve ve;
    public ve x;
    public int yp;
    public int yv;
    public int z;
    public boolean zm;
    public final d c = new d(Looper.getMainLooper(), this);
    public int rh = Integer.MIN_VALUE;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("xSetting");
            String strOptString = jSONObject.optString("dynamic_configs", "");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject3 != null) {
                    this.u = jSONObjectOptJSONObject3.optInt(CropKey.VIDEO_DURATION);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("reward_full_time_type", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("reward_full_play_time", 0);
                if (iOptInt == 1) {
                    this.yp = iOptInt2;
                    this.my = true;
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                if (jSONObjectOptJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.t = jSONObjectOptJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.t = jSONObjectOptJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                if (new JSONObject(strOptString).optBoolean("is_show_video_duration", false)) {
                    this.my = false;
                }
            } catch (JSONException unused) {
            }
        }
    }

    private boolean uj() {
        return (this.uj == null && this.f28979a == null && this.n == null && this.x == null && this.da == null) ? false : true;
    }

    private void ve() {
        int i;
        int i2;
        int i3;
        ve veVar;
        if (this.my) {
            i = this.yp;
            i2 = this.m;
        } else {
            i = this.u;
            i2 = this.z;
        }
        z zVar = this.tt;
        boolean z = true;
        if (zVar != null && (veVar = this.ve) != null) {
            zVar.c(veVar, "videoProgress", Integer.valueOf(i2));
        }
        int i4 = i2 + this.nu;
        int iMax = Math.max(0, i - i4);
        if (i4 < this.t && iMax != 0 && this.rh > 0) {
            z = false;
        }
        ve veVar2 = this.uj;
        if ((veVar2 instanceof com.byazt.te.c) && this.rh != Integer.MIN_VALUE) {
            veVar2.tt(0);
            ((com.byazt.te.c) this.uj).c(iMax, i4, this.rh);
        }
        ve veVar3 = this.f28979a;
        if (veVar3 instanceof tt) {
            ((tt) veVar3).uj(z);
        }
        ve veVar4 = this.sp;
        if ((veVar4 instanceof uj) && (i3 = this.rh) != Integer.MIN_VALUE) {
            ((uj) veVar4).c(iMax, i4, i3);
        }
        ve veVar5 = this.n;
        if (veVar5 instanceof com.byazt.te.tt) {
            ((com.byazt.te.tt) veVar5).c(i, i4, iMax, z);
        }
        ve veVar6 = this.x;
        if (veVar6 instanceof com.byazt.oaq.c) {
            ((com.byazt.oaq.c) veVar6).tt(this.gt, this.rl);
        }
        ve veVar7 = this.i;
        if (veVar7 != null) {
            veVar7.tt(this.gu ? 0 : 8);
        }
        ve veVar8 = this.sl;
        if (veVar8 != null) {
            veVar8.tt(this.zm ? 0 : 8);
        }
        ve veVar9 = this.da;
        if (veVar9 instanceof com.byazt.te.ve) {
            ((com.byazt.te.ve) veVar9).c(this.qy, this.yv, this.p, this.gr, this.md);
        }
    }

    public void c(z zVar, ve veVar) {
        this.tt = zVar;
        this.ve = veVar;
        ve veVarN = veVar.n("RVCountdown");
        this.uj = veVarN;
        if (veVarN == null) {
            this.uj = this.ve.n("FVCountdown");
        }
        ve veVarN2 = this.ve.n("RVSkip");
        this.f28979a = veVarN2;
        if (veVarN2 == null) {
            this.f28979a = this.ve.n("FVSkip");
        }
        this.n = this.ve.n("CycleCountDownView");
        this.sp = this.ve.n("RewardClickCountdown");
        this.x = this.ve.n("CycleSkip");
        this.da = this.ve.n("CsjRefreshTip");
        this.i = this.ve.uj("CsjRefreshTipContainer");
        this.sl = this.ve.uj("CsjRefreshTipCancel");
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what != 100) {
            return;
        }
        this.c.sendEmptyMessageDelayed(100, 200L);
        ve();
    }

    public void tt() {
        this.c.removeCallbacksAndMessages(null);
    }

    public void c() {
        if (uj()) {
            this.c.sendEmptyMessage(100);
        }
    }

    public void c(int i, int i2, int i3, int i4) {
        this.z = i;
        this.m = i2;
        this.nu = i3;
        this.rh = i4;
    }

    public void c(int i, int i2) {
        this.gt = i;
        this.rl = i2;
    }

    public void c(int i, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.qy = i;
        this.yv = i2;
        this.p = i3;
        this.gu = z2;
        this.gr = z3;
        this.zm = z4;
        this.md = z;
    }
}
