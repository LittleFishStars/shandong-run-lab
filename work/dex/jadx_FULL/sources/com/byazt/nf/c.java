package com.byazt.nf;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.baidu.location.LocationConst;
import com.byazt.eu.n;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.va.uj;
import com.byazt.vx.eo;
import com.byazt.vx.qy;
import com.byazt.vx.t;
import com.byazt.vx.yv;
import com.byazt.yl.ve;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.shandong_school.splash.SplashActivity;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 753, 20})
public class c {
    public String m;
    public tt rh;
    public com.byazt.bo.c sp;
    public int tt;
    public com.byazt.ll.tt u;
    public int ve;
    public ve yp;
    public long z;
    public boolean uj = false;
    public boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28819a = -1;
    public boolean x = false;
    public boolean i = false;
    public boolean da = true;
    public int sl = -1;
    public String t = "";
    public AtomicInteger c = new AtomicInteger(1);
    public final com.byazt.bo.c nu = new com.byazt.bo.c() { // from class: com.byazt.nf.c.1
        @Override // com.byazt.bo.c
        public boolean c() {
            return false;
        }

        @Override // com.byazt.bo.c
        public float tt() {
            if (c.this.u != null) {
                return c.this.u.p();
            }
            return 0.0f;
        }

        @Override // com.byazt.bo.c
        @DungeonFlag
        public Map<String, Object> uj() {
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
            map.put("transId", c.this.m);
            map.put(MediationConstant.KEY_REASON, 0);
            map.put("gromoreExtra", (c.this.u == null || c.this.u.cu() == null) ? "" : c.this.u.cu().get("gromoreExtra"));
            map.put("errorCode", Integer.valueOf(c.this.sl));
            map.put("errorMsg", c.this.t);
            com.byazt.pp.ve veVarC = t.c(c.this.u, c.this.yp, true);
            map.put(MediationConstant.KEY_ADN_NAME, veVarC != null ? veVarC.t() : "");
            map.put("ecpm", veVarC != null ? veVarC.u() : "");
            return map;
        }

        @Override // com.byazt.bo.c
        public String ve() {
            return c.this.u != null ? c.this.u.yv() : "";
        }
    };

    /* JADX INFO: renamed from: com.byazt.nf.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 753, 44})
    public class RunnableC0471c implements Runnable {
        public final int tt;

        public RunnableC0471c(int i) {
            this.tt = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.sp != null || c.this.i || !c.this.da || c.this.uj || c.this.n) {
                return;
            }
            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.tt + "次重试请求");
            c.this.sp();
        }
    }

    public interface tt {
        void c(com.byazt.bo.c cVar);
    }

    public c(String str) {
        com.byazt.nbs.tt ttVarC;
        com.byazt.qe.ve veVarTt = com.byazt.bp.tt.tt();
        if (veVarTt != null && (ttVarC = veVarTt.c(str, 7, 101)) != null) {
            this.tt = ttVarC.hd();
            this.ve = ttVarC.bm();
        }
        if (this.tt < 0) {
            this.tt = 15000;
        }
    }

    private void a() {
        com.byazt.eu.tt.tt("GROMORE_SS_REWARD_VERIFY", "startPreRequest:CSJ代码位没有开启show强校验，执行15s逻辑->startPreRequest");
        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        n.c(new Runnable() { // from class: com.byazt.nf.c.7
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f28819a != -1 || c.this.uj || c.this.n) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                    return;
                }
                com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
                c.this.sp();
                n.c(c.this.new RunnableC0471c(1), 3000L);
                n.c(c.this.new RunnableC0471c(2), SplashActivity.f36053a);
                n.c(c.this.new RunnableC0471c(3), 9000L);
            }
        }, this.tt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void sp() {
        com.byazt.va.n nVarTt = com.byazt.yp.tt.c().tt().tt();
        nVarTt.c(com.byazt.bp.ve.uj());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        String strX = com.byazt.bp.c.t().x();
        if (!TextUtils.isEmpty(strX)) {
            nVarTt.tt("X-Tt-Env", strX);
            nVarTt.tt("x-use-ppe", "1");
        }
        nVarTt.tt("User-Agent", com.byazt.yl.tt.c);
        final boolean z = !com.byazt.bp.tt.tt().n();
        if (z) {
            nVarTt.tt("x-pglcypher", "4");
            nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, eo.tt(c(true)));
        } else {
            nVarTt.ve(c(false));
        }
        nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.nf.c.8
            @Override // com.byazt.mh.c
            public void c(uj ujVar, final com.byazt.hm.tt ttVar) {
                n.c(new Runnable() { // from class: com.byazt.nf.c.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        c.this.c(ttVar, z, jCurrentTimeMillis);
                    }
                });
            }

            @Override // com.byazt.mh.c
            public void c(uj ujVar, final IOException iOException) {
                n.c(new Runnable() { // from class: com.byazt.nf.c.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + iOException.toString());
                        c.this.c(-2, "request error" + iOException.getMessage(), z);
                    }
                });
            }
        });
    }

    private Object x() {
        Map<String, Object> mediaExtraInfo;
        ve veVar = this.yp;
        if (veVar == null || (mediaExtraInfo = veVar.getMediaExtraInfo()) == null || !mediaExtraInfo.containsKey("rs_info")) {
            return null;
        }
        return mediaExtraInfo.get("rs_info");
    }

    public void n() {
        n.c(new Runnable() { // from class: com.byazt.nf.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.uj) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经destroy, 直接return");
                    return;
                }
                if (c.this.sp != null || c.this.i) {
                    StringBuilder sb = new StringBuilder("--==-- complete回调进来，已经有响应(");
                    sb.append(c.this.sp != null);
                    sb.append(")或已经给出开发者回调(");
                    sb.append(c.this.i);
                    sb.append("), 直接return");
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", sb.toString());
                    return;
                }
                if (c.this.f28819a == -1) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，先进来发起请求");
                    c.this.f28819a = SystemClock.elapsedRealtime();
                    if (c.this.da) {
                        c.this.sp();
                        return;
                    } else {
                        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                        return;
                    }
                }
                if (SystemClock.elapsedRealtime() - c.this.f28819a > 2000) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，后进来但大于2s，发起请求");
                    if (c.this.da) {
                        c.this.sp();
                    } else {
                        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                    }
                }
            }
        });
    }

    public void tt() {
        n.c(new Runnable() { // from class: com.byazt.nf.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.n = true;
            }
        });
    }

    public boolean uj() {
        ve veVar = this.yp;
        if (veVar != null && veVar.getMediaExtraInfo() != null) {
            Map<String, Object> mediaExtraInfo = this.yp.getMediaExtraInfo();
            if (!c(mediaExtraInfo.get("isPangle"))) {
                return false;
            }
            Object obj = mediaExtraInfo.get("isRDEnable");
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void ve() {
        n.c(new Runnable() { // from class: com.byazt.nf.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.uj = true;
            }
        });
    }

    public boolean c() {
        boolean z = this.ve == 1;
        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： ".concat(String.valueOf(z)));
        return z;
    }

    public void c(com.byazt.ll.tt ttVar, ve veVar) {
        this.z = System.currentTimeMillis();
        this.u = ttVar;
        this.yp = veVar;
        if (uj()) {
            com.byazt.eu.tt.tt("GROMORE_SS_REWARD_VERIFY", "onAdnAdShow:开启了show强校验，先不进行15s逻辑->startPreRequest");
        } else {
            a();
        }
    }

    public boolean c(Object obj) {
        if (MediationConstant.ADN_PANGLE.equals(this.yp.getAdnName())) {
            return true;
        }
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public void c(com.byazt.bo.c cVar, ve veVar) {
        if (uj() && cVar != null && !cVar.c()) {
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
            map.put("transId", this.m);
            map.put(MediationConstant.KEY_REASON, 0);
            com.byazt.ll.tt ttVar = this.u;
            Object obj = "";
            if (ttVar != null && ttVar.cu() != null) {
                obj = this.u.cu().get("gromoreExtra");
            }
            map.put("gromoreExtra", obj);
            map.put("errorCode", -10002);
            map.put("errorMsg", "ADN 回调 rewardVerify:false");
            com.byazt.bo.c cVarC = com.byazt.hz.t.c(this.u, cVar, veVar, map);
            tt ttVar2 = this.rh;
            if (ttVar2 == null || this.i) {
                return;
            }
            this.i = true;
            ttVar2.c(cVarC);
            return;
        }
        n.c(new Runnable() { // from class: com.byazt.nf.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.uj) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经destroy, 直接return");
                    return;
                }
                c.this.x = true;
                if (c.this.sp != null) {
                    if (c.this.rh == null || c.this.i) {
                        return;
                    }
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经有结果，直接给开发者回调");
                    c.this.i = true;
                    c.this.rh.c(c.this.sp);
                    return;
                }
                if (c.this.f28819a == -1) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，先进来发起请求");
                    c.this.f28819a = SystemClock.elapsedRealtime();
                    if (c.this.da) {
                        c.this.sp();
                    } else {
                        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                    }
                } else if (SystemClock.elapsedRealtime() - c.this.f28819a > 2000) {
                    com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，后进来但大于2s，发起请求");
                    if (c.this.da) {
                        c.this.sp();
                    } else {
                        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                    }
                }
                n.c(new Runnable() { // from class: com.byazt.nf.c.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.uj) {
                            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                        } else {
                            if (c.this.rh == null || c.this.i) {
                                return;
                            }
                            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                            c.this.i = true;
                            c.this.rh.c(c.this.sp != null ? c.this.sp : c.this.nu);
                        }
                    }
                }, 3000L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void c(com.byazt.hm.tt ttVar, boolean z, long j) {
        JSONObject jSONObject;
        if (this.uj) {
            return;
        }
        if (ttVar == null) {
            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify netResponse is null");
            c(-1, "response is null", z);
            return;
        }
        int iTt = ttVar.tt();
        if (eo.c(ttVar)) {
            String strC = eo.c(ttVar.sl());
            if (!TextUtils.isEmpty(strC)) {
                try {
                    this.sl = 20000;
                    c(new JSONObject(strC), z, j);
                    return;
                } catch (Throwable th) {
                    m.c(th);
                    this.sl = 1;
                    c(-1, th.getMessage(), z);
                    return;
                }
            }
            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data v4 is null");
            c(iTt, "data is empty", z);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(ttVar.n());
            int iOptInt = jSONObject2.optInt("cypher", -1);
            String strOptString = jSONObject2.optString("message");
            this.sl = jSONObject2.optInt("code");
            this.t = jSONObject2.optString("desc");
            int i = this.sl;
            if (i == 50001) {
                this.da = true;
                com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: 50001，请求媒体服务端失败，需要重试");
                c(this.sl, this.t, z);
                return;
            }
            if (i != 0 && i != 20000) {
                this.da = false;
                com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: " + this.sl + ", msg: " + this.t + "，不能再重试");
                c(this.sl, this.t, z);
                return;
            }
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject3 = null;
                if (iOptInt == 2) {
                    String strC2 = eo.c(strOptString);
                    if (!TextUtils.isEmpty(strC2)) {
                        jSONObject = new JSONObject(strC2);
                        jSONObject3 = jSONObject;
                    }
                } else if (iOptInt == 1) {
                    String strTt = com.byazt.vx.c.tt(strOptString, com.byazt.vx.tt.c());
                    if (!TextUtils.isEmpty(strTt)) {
                        jSONObject = new JSONObject(strTt);
                        jSONObject3 = jSONObject;
                    }
                } else if (iOptInt == 0) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                c(jSONObject3, z, j);
                return;
            }
            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify cypher error or message is null");
            c(iTt, "message is null", z);
        } catch (Throwable th2) {
            c(-1, th2.getMessage(), z);
        }
    }

    @DungeonFlag
    private void c(JSONObject jSONObject, boolean z, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject != null) {
            com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- data: " + jSONObject.toString());
            final boolean zOptBoolean = jSONObject.optBoolean("is_verify");
            final int iOptInt = jSONObject.optInt(MediationConstant.KEY_REASON);
            final String strOptString = jSONObject.optString("reward_name");
            final int iOptInt2 = jSONObject.optInt("reward_amount");
            this.sp = new com.byazt.bo.c() { // from class: com.byazt.nf.c.6
                @Override // com.byazt.bo.c
                public boolean c() {
                    return zOptBoolean;
                }

                @Override // com.byazt.bo.c
                public float tt() {
                    return iOptInt2;
                }

                @Override // com.byazt.bo.c
                @DungeonFlag
                public Map<String, Object> uj() {
                    HashMap map = new HashMap();
                    map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                    map.put("transId", c.this.m);
                    map.put(MediationConstant.KEY_REASON, Integer.valueOf(iOptInt));
                    map.put("gromoreExtra", (c.this.u == null || c.this.u.cu() == null) ? "" : c.this.u.cu().get("gromoreExtra"));
                    map.put("errorCode", Integer.valueOf(c.this.sl));
                    map.put("errorMsg", c.this.t);
                    com.byazt.pp.ve veVarC = t.c(c.this.u, c.this.yp, true);
                    map.put(MediationConstant.KEY_ADN_NAME, veVarC != null ? veVarC.t() : "");
                    map.put("ecpm", veVarC != null ? veVarC.u() : "");
                    return map;
                }

                @Override // com.byazt.bo.c
                public String ve() {
                    return strOptString;
                }
            };
            if (this.x && this.rh != null && !this.i) {
                com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify接口请求回来，给开发者verify回调");
                this.i = true;
                this.rh.c(this.sp);
            }
            c(z, jCurrentTimeMillis);
            return;
        }
        com.byazt.eu.tt.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data is null");
        c(-1, "data is null", z);
    }

    private void c(boolean z, long j) {
        yv.c(z ? "v4Enc_reward" : "v2Enc_reward", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str, boolean z) {
        yv.c(z ? "v4Enc_reward" : "v2Enc_reward", false, 0L, "code = " + i + "，msg = " + str);
    }

    @DungeonFlag
    private String c(boolean z) {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", com.byazt.yl.tt.tt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.yl.tt.uj());
            jSONObject.put("user_agent", com.byazt.yl.tt.c);
            jSONObject.put("try_value", this.c.getAndIncrement());
            jSONObject.put("network", qy.tt());
            jSONObject.put("play_start_ts", this.z);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.byazt.ll.tt ttVar = this.u;
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, ttVar != null ? ttVar.h() : "");
            if (TextUtils.isEmpty(this.m)) {
                string = UUID.randomUUID().toString();
                this.m = string;
            } else {
                string = this.m;
            }
            jSONObject.put("trans_id", string);
            com.byazt.ll.tt ttVar2 = this.u;
            jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_LINK_ID, ttVar2 != null ? ttVar2.c() : "");
            com.byazt.ll.tt ttVar3 = this.u;
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, ttVar3 != null ? ttVar3.gt() : "");
            ve veVar = this.yp;
            jSONObject.put("adn_rit", veVar != null ? veVar.getAdNetworkSlotId() : "");
            com.byazt.ll.tt ttVar4 = this.u;
            jSONObject.put("reward_name", ttVar4 != null ? ttVar4.yv() : "");
            com.byazt.ll.tt ttVar5 = this.u;
            jSONObject.put("reward_amount", ttVar5 != null ? ttVar5.p() : 0);
            jSONObject.putOpt("rs_info", x());
            com.byazt.ll.tt ttVar6 = this.u;
            jSONObject.put("media_extra", (ttVar6 == null || ttVar6.cu() == null) ? "" : this.u.cu().get("gromoreExtra"));
            com.byazt.ll.tt ttVar7 = this.u;
            if (ttVar7 != null && ttVar7.rl() != null) {
                jSONObject.put("scenario_id", this.u.rl());
            }
            com.byazt.pp.ve veVarC = t.c(this.u, this.yp, true);
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, veVarC != null ? veVarC.t() : "");
            jSONObject.put("ecpm", veVarC != null ? veVarC.u() : "");
        } catch (JSONException e) {
            m.c(e);
        }
        if (z) {
            return jSONObject.toString();
        }
        return eo.c(jSONObject).toString();
    }

    public void c(tt ttVar) {
        this.rh = ttVar;
    }
}
