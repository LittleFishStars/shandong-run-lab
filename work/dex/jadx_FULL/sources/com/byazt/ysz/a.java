package com.byazt.ysz;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.aas.nb;
import com.byazt.aas.zb;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.ete.q;
import com.byazt.ete.sv;
import com.byazt.ete.to;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.omf.rl;
import com.byazt.omf.x;
import com.byazt.ukr.yp;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 589, 34})
public abstract class a extends com.byazt.ysz.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SoftReference<ic> f29213a;
    public String n;
    public String uj;

    public interface c {
        void c(boolean z);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016b A[Catch: Exception -> 0x0179, TryCatch #8 {Exception -> 0x0179, blocks: (B:91:0x014b, B:100:0x016b, B:102:0x0175), top: B:204:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0175 A[Catch: Exception -> 0x0179, TRY_LEAVE, TryCatch #8 {Exception -> 0x0179, blocks: (B:91:0x014b, B:100:0x016b, B:102:0x0175), top: B:204:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:140:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:142:0x0202  */
    /* JADX WARN: Code duplicated, block: B:145:0x0211  */
    /* JADX WARN: Code duplicated, block: B:148:0x022a  */
    /* JADX WARN: Code duplicated, block: B:163:0x030f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0316  */
    /* JADX WARN: Code duplicated, block: B:171:0x0349 A[Catch: Exception -> 0x036c, TRY_LEAVE, TryCatch #0 {Exception -> 0x036c, blocks: (B:169:0x0343, B:171:0x0349), top: B:188:0x0343 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x037f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:177:0x0380  */
    /* JADX WARN: Code duplicated, block: B:179:0x038a  */
    /* JADX WARN: Code duplicated, block: B:181:0x0396  */
    /* JADX WARN: Code duplicated, block: B:183:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:188:0x0343 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x013d A[EXC_TOP_SPLITTER, PHI: r4
      0x013d: PHI (r4v22 org.json.JSONObject) = (r4v19 org.json.JSONObject), (r4v21 org.json.JSONObject) binds: [B:81:0x0133, B:82:0x0135] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x0165  */
    private Bundle tt(Context context, i iVar, Map<String, Object> map) {
        nu nuVar;
        int i;
        int i2;
        int i3;
        String strC;
        JSONArray jSONArrayX;
        int i4;
        JSONObject jSONObject;
        int i5;
        int i6;
        String string;
        Object obj;
        long jLongValue;
        Map<String, Object> map2 = map;
        Bundle bundle = new Bundle();
        if (iVar != null) {
            try {
                bundle.putLong("room_id", Long.parseLong(iVar.da()));
            } catch (Exception e) {
                m.c(e);
            }
            Bundle bundle2 = new Bundle();
            nu nuVarYp = iVar.yp();
            if (iVar.n() != 9) {
                nuVar = nuVarYp;
            } else if (iVar.D_() != null) {
                nuVarYp = iVar.D_().ve();
                nuVar = nuVarYp;
            } else {
                nuVar = null;
            }
            int iC = com.byazt.wu.ve.c(map);
            q qVarC_ = iVar.C_();
            if (iVar.n() == 9) {
                qVarC_ = iVar.D_() != null ? iVar.D_().uj() : null;
            }
            if (qVarC_ == null || qVarC_.ve() != 0) {
                i = iC;
            } else {
                int iTt = qVarC_.tt();
                if (iTt == 1) {
                    i = 101;
                } else if (iTt == 3) {
                    i = 104;
                } else {
                    i = iC;
                }
            }
            int iN = iVar.n();
            int iUj = uj(iVar);
            sv svVarSl = iVar.sl();
            if (iVar.n() == 9) {
                svVarSl = iVar.D_() != null ? iVar.D_().a() : null;
            }
            String strT = iVar.t();
            if (iVar.n() == 9) {
                strT = iVar.D_() != null ? iVar.D_().n() : null;
            }
            if (!com.byazt.bb.a.c(i)) {
                if (iUj > 0 && n() != 2) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        try {
                            rl.c(iVar.rl(), new Integer(1), Integer.class);
                            jSONObject2.put("auth_reward_gold", iUj);
                            bundle2.putString("live_auth_extra_info", jSONObject2.toString());
                        } catch (JSONException e2) {
                            e = e2;
                            i3 = 1;
                            Object[] objArr = new Object[i3];
                            objArr[0] = e;
                            m.tt(com.byazt.we.ve.TAG, objArr);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        i3 = 1;
                    }
                } else if (tt(iVar) == 0) {
                    if (iVar.n() == 7) {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } else if (iVar.n() == 8) {
                        bundle2.putInt("live_popup_dou_deeplink_dialog", 1);
                        bundle2.putString("live_popup_dou_deeplink_url", nuVar != null ? nuVar.tt() : "");
                    }
                }
                i = iN;
                i2 = -1;
            } else if (i == 101 || i == 102 || i == 104) {
                try {
                    jSONObject = new JSONObject();
                    if (svVarSl != null) {
                        if (i == 101) {
                            i2 = 1;
                        } else {
                            i2 = i == 104 ? 3 : 2;
                        }
                        try {
                            jSONObject.put("live_auto_auth_login_source", i2);
                            int i7 = i2;
                            try {
                                jSONObject.put("live_auto_auth_success_has_ticket", com.byazt.wu.ve.c(strT));
                                jSONObject.put("live_auto_auth_promotion_id", svVarSl.tt());
                                i2 = i7;
                                if (iUj <= 0) {
                                    i5 = i2;
                                    i6 = i;
                                } else if (jSONObject == null) {
                                    try {
                                        jSONObject = new JSONObject();
                                        try {
                                            i5 = i2;
                                            try {
                                                i6 = i;
                                                try {
                                                    try {
                                                        rl.c(iVar.rl(), new Integer(1), Integer.class);
                                                        jSONObject.put("auth_reward_gold", iUj);
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        i2 = i5;
                                                        i = i6;
                                                        i4 = 1;
                                                        Object[] objArr2 = new Object[i4];
                                                        objArr2[0] = e;
                                                        m.tt(com.byazt.we.ve.TAG, objArr2);
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    i4 = 1;
                                                    i2 = i5;
                                                    i = i6;
                                                    Object[] objArr3 = new Object[i4];
                                                    objArr3[0] = e;
                                                    m.tt(com.byazt.we.ve.TAG, objArr3);
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                i2 = i5;
                                                i4 = 1;
                                                Object[] objArr4 = new Object[i4];
                                                objArr4[0] = e;
                                                m.tt(com.byazt.we.ve.TAG, objArr4);
                                                if (svVarSl != null) {
                                                    if (!TextUtils.isEmpty(svVarSl.sp())) {
                                                        bundle2.putString("live_csj_libra_param", svVarSl.sp());
                                                    }
                                                    jSONArrayX = svVarSl.x();
                                                    if (jSONArrayX != null) {
                                                        c(jSONArrayX, iVar);
                                                        bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                                        bundle.putString("live_tob_task_key", iVar.rl());
                                                    }
                                                }
                                                if (nuVar != null) {
                                                    strC = null;
                                                } else {
                                                    strC = null;
                                                }
                                                if (TextUtils.isEmpty(strC)) {
                                                    strC = c(nb.sl(com.byazt.ppf.ve.c(iVar, map)));
                                                }
                                                bundle2.putString("enter_from_merge", strC);
                                                bundle2.putString("enter_method", tt(nb.sl(com.byazt.ppf.ve.c(iVar, map))));
                                                bundle2.putInt("live_pangle_interaction_type", i);
                                                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                                if (i2 != -1) {
                                                    try {
                                                        if (!TextUtils.isEmpty(strT)) {
                                                            JSONObject jSONObject3 = new JSONObject(strT);
                                                            JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("enter_request");
                                                            JSONObject jSONObject4 = new JSONObject();
                                                            jSONObject4.put("live_auto_auth_login_source", i2);
                                                            jSONObjectOptJSONObject.put("live_commerce_sdk_custom_params", jSONObject4);
                                                            jSONObject3.remove("enter_request");
                                                            jSONObject3.put("enter_request", jSONObjectOptJSONObject);
                                                            strT = jSONObject3.toString();
                                                        }
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                                map2 = map;
                                                bundle.putString("ecom_live_params", c(iVar, strT, map2));
                                                if (!iVar.y_()) {
                                                    return bundle;
                                                }
                                                obj = map2.get("reward_countdown");
                                                if (obj instanceof Long) {
                                                    jLongValue = ((Long) obj).longValue();
                                                    if (jLongValue > 0) {
                                                        bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                                        bundle.putInt("android.app.activity.request_code", 1);
                                                        if (map2.containsKey("reward_live_scene")) {
                                                            bundle.putInt("live_popup_reward_auth", 1);
                                                            m.c("rewardAuthFlag", "liv pop rew auth:  1");
                                                        }
                                                    }
                                                }
                                                return bundle;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        i4 = 1;
                                        Object[] objArr5 = new Object[i4];
                                        objArr5[0] = e;
                                        m.tt(com.byazt.we.ve.TAG, objArr5);
                                        if (svVarSl != null) {
                                            if (!TextUtils.isEmpty(svVarSl.sp())) {
                                                bundle2.putString("live_csj_libra_param", svVarSl.sp());
                                            }
                                            jSONArrayX = svVarSl.x();
                                            if (jSONArrayX != null) {
                                                c(jSONArrayX, iVar);
                                                bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                                bundle.putString("live_tob_task_key", iVar.rl());
                                            }
                                        }
                                        if (nuVar != null) {
                                            strC = null;
                                        } else {
                                            strC = null;
                                        }
                                        if (TextUtils.isEmpty(strC)) {
                                            strC = c(nb.sl(com.byazt.ppf.ve.c(iVar, map)));
                                        }
                                        bundle2.putString("enter_from_merge", strC);
                                        bundle2.putString("enter_method", tt(nb.sl(com.byazt.ppf.ve.c(iVar, map))));
                                        bundle2.putInt("live_pangle_interaction_type", i);
                                        bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                        if (i2 != -1) {
                                            if (!TextUtils.isEmpty(strT)) {
                                                JSONObject jSONObject5 = new JSONObject(strT);
                                                JSONObject jSONObjectOptJSONObject2 = jSONObject5.optJSONObject("enter_request");
                                                JSONObject jSONObject6 = new JSONObject();
                                                jSONObject6.put("live_auto_auth_login_source", i2);
                                                jSONObjectOptJSONObject2.put("live_commerce_sdk_custom_params", jSONObject6);
                                                jSONObject5.remove("enter_request");
                                                jSONObject5.put("enter_request", jSONObjectOptJSONObject2);
                                                strT = jSONObject5.toString();
                                            }
                                        }
                                        map2 = map;
                                        bundle.putString("ecom_live_params", c(iVar, strT, map2));
                                        if (!iVar.y_()) {
                                            return bundle;
                                        }
                                        obj = map2.get("reward_countdown");
                                        if (obj instanceof Long) {
                                            jLongValue = ((Long) obj).longValue();
                                            if (jLongValue > 0) {
                                                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                                bundle.putInt("android.app.activity.request_code", 1);
                                                if (map2.containsKey("reward_live_scene")) {
                                                    bundle.putInt("live_popup_reward_auth", 1);
                                                    m.c("rewardAuthFlag", "liv pop rew auth:  1");
                                                }
                                            }
                                        }
                                        return bundle;
                                    }
                                } else {
                                    i5 = i2;
                                    i6 = i;
                                    rl.c(iVar.rl(), new Integer(1), Integer.class);
                                    jSONObject.put("auth_reward_gold", iUj);
                                }
                                if (jSONObject != null) {
                                    string = jSONObject.toString();
                                    if (!TextUtils.isEmpty(string)) {
                                        bundle2.putString("live_auth_extra_info", string);
                                    }
                                }
                                i2 = i5;
                                i = i6;
                            } catch (Exception e9) {
                                e = e9;
                                i = iN;
                                i2 = i7;
                                i4 = 1;
                                Object[] objArr6 = new Object[i4];
                                objArr6[0] = e;
                                m.tt(com.byazt.we.ve.TAG, objArr6);
                                if (svVarSl != null) {
                                    if (!TextUtils.isEmpty(svVarSl.sp())) {
                                        bundle2.putString("live_csj_libra_param", svVarSl.sp());
                                    }
                                    jSONArrayX = svVarSl.x();
                                    if (jSONArrayX != null) {
                                        c(jSONArrayX, iVar);
                                        bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                        bundle.putString("live_tob_task_key", iVar.rl());
                                    }
                                }
                                if (nuVar != null) {
                                    strC = null;
                                } else {
                                    strC = null;
                                }
                                if (TextUtils.isEmpty(strC)) {
                                    strC = c(nb.sl(com.byazt.ppf.ve.c(iVar, map)));
                                }
                                bundle2.putString("enter_from_merge", strC);
                                bundle2.putString("enter_method", tt(nb.sl(com.byazt.ppf.ve.c(iVar, map))));
                                bundle2.putInt("live_pangle_interaction_type", i);
                                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                if (i2 != -1) {
                                    if (!TextUtils.isEmpty(strT)) {
                                        JSONObject jSONObject7 = new JSONObject(strT);
                                        JSONObject jSONObjectOptJSONObject3 = jSONObject7.optJSONObject("enter_request");
                                        JSONObject jSONObject8 = new JSONObject();
                                        jSONObject8.put("live_auto_auth_login_source", i2);
                                        jSONObjectOptJSONObject3.put("live_commerce_sdk_custom_params", jSONObject8);
                                        jSONObject7.remove("enter_request");
                                        jSONObject7.put("enter_request", jSONObjectOptJSONObject3);
                                        strT = jSONObject7.toString();
                                    }
                                }
                                map2 = map;
                                bundle.putString("ecom_live_params", c(iVar, strT, map2));
                                if (!iVar.y_()) {
                                    return bundle;
                                }
                                obj = map2.get("reward_countdown");
                                if (obj instanceof Long) {
                                    jLongValue = ((Long) obj).longValue();
                                    if (jLongValue > 0) {
                                        bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                        bundle.putInt("android.app.activity.request_code", 1);
                                        if (map2.containsKey("reward_live_scene")) {
                                            bundle.putInt("live_popup_reward_auth", 1);
                                            m.c("rewardAuthFlag", "liv pop rew auth:  1");
                                        }
                                    }
                                }
                                return bundle;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            i = iN;
                        }
                    } else {
                        i = iN;
                        i2 = -1;
                        if (iUj <= 0) {
                            i5 = i2;
                            i6 = i;
                        } else if (jSONObject == null) {
                            jSONObject = new JSONObject();
                            i5 = i2;
                            i6 = i;
                            rl.c(iVar.rl(), new Integer(1), Integer.class);
                            jSONObject.put("auth_reward_gold", iUj);
                        } else {
                            i5 = i2;
                            i6 = i;
                            rl.c(iVar.rl(), new Integer(1), Integer.class);
                            jSONObject.put("auth_reward_gold", iUj);
                        }
                        if (jSONObject != null) {
                            string = jSONObject.toString();
                            if (!TextUtils.isEmpty(string)) {
                                bundle2.putString("live_auth_extra_info", string);
                            }
                        }
                        i2 = i5;
                        i = i6;
                    }
                } catch (Exception e11) {
                    e = e11;
                    i = iN;
                    i4 = 1;
                    i2 = -1;
                    Object[] objArr7 = new Object[i4];
                    objArr7[0] = e;
                    m.tt(com.byazt.we.ve.TAG, objArr7);
                    if (svVarSl != null) {
                        if (!TextUtils.isEmpty(svVarSl.sp())) {
                            bundle2.putString("live_csj_libra_param", svVarSl.sp());
                        }
                        jSONArrayX = svVarSl.x();
                        if (jSONArrayX != null) {
                            c(jSONArrayX, iVar);
                            bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                            bundle.putString("live_tob_task_key", iVar.rl());
                        }
                    }
                    if (nuVar != null) {
                        strC = null;
                    } else {
                        strC = null;
                    }
                    if (TextUtils.isEmpty(strC)) {
                        strC = c(nb.sl(com.byazt.ppf.ve.c(iVar, map)));
                    }
                    bundle2.putString("enter_from_merge", strC);
                    bundle2.putString("enter_method", tt(nb.sl(com.byazt.ppf.ve.c(iVar, map))));
                    bundle2.putInt("live_pangle_interaction_type", i);
                    bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                    if (i2 != -1) {
                        if (!TextUtils.isEmpty(strT)) {
                            JSONObject jSONObject9 = new JSONObject(strT);
                            JSONObject jSONObjectOptJSONObject4 = jSONObject9.optJSONObject("enter_request");
                            JSONObject jSONObject10 = new JSONObject();
                            jSONObject10.put("live_auto_auth_login_source", i2);
                            jSONObjectOptJSONObject4.put("live_commerce_sdk_custom_params", jSONObject10);
                            jSONObject9.remove("enter_request");
                            jSONObject9.put("enter_request", jSONObjectOptJSONObject4);
                            strT = jSONObject9.toString();
                        }
                    }
                    map2 = map;
                    bundle.putString("ecom_live_params", c(iVar, strT, map2));
                    if (!iVar.y_()) {
                        return bundle;
                    }
                    obj = map2.get("reward_countdown");
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                        if (jLongValue > 0) {
                            bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                            bundle.putInt("android.app.activity.request_code", 1);
                            if (map2.containsKey("reward_live_scene")) {
                                bundle.putInt("live_popup_reward_auth", 1);
                                m.c("rewardAuthFlag", "liv pop rew auth:  1");
                            }
                        }
                    }
                    return bundle;
                }
            } else {
                if (i == 103) {
                    try {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } catch (Exception e12) {
                        e = e12;
                        i4 = 1;
                        i2 = -1;
                        Object[] objArr8 = new Object[i4];
                        objArr8[0] = e;
                        m.tt(com.byazt.we.ve.TAG, objArr8);
                        if (svVarSl != null) {
                            if (!TextUtils.isEmpty(svVarSl.sp())) {
                                bundle2.putString("live_csj_libra_param", svVarSl.sp());
                            }
                            jSONArrayX = svVarSl.x();
                            if (jSONArrayX != null) {
                                c(jSONArrayX, iVar);
                                bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                bundle.putString("live_tob_task_key", iVar.rl());
                            }
                        }
                        if (nuVar != null) {
                            strC = null;
                        } else {
                            strC = null;
                        }
                        if (TextUtils.isEmpty(strC)) {
                            strC = c(nb.sl(com.byazt.ppf.ve.c(iVar, map)));
                        }
                        bundle2.putString("enter_from_merge", strC);
                        bundle2.putString("enter_method", tt(nb.sl(com.byazt.ppf.ve.c(iVar, map))));
                        bundle2.putInt("live_pangle_interaction_type", i);
                        bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                        if (i2 != -1) {
                            if (!TextUtils.isEmpty(strT)) {
                                JSONObject jSONObject11 = new JSONObject(strT);
                                JSONObject jSONObjectOptJSONObject5 = jSONObject11.optJSONObject("enter_request");
                                JSONObject jSONObject12 = new JSONObject();
                                jSONObject12.put("live_auto_auth_login_source", i2);
                                jSONObjectOptJSONObject5.put("live_commerce_sdk_custom_params", jSONObject12);
                                jSONObject11.remove("enter_request");
                                jSONObject11.put("enter_request", jSONObjectOptJSONObject5);
                                strT = jSONObject11.toString();
                            }
                        }
                        map2 = map;
                        bundle.putString("ecom_live_params", c(iVar, strT, map2));
                        if (!iVar.y_()) {
                            return bundle;
                        }
                        obj = map2.get("reward_countdown");
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                            if (jLongValue > 0) {
                                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                bundle.putInt("android.app.activity.request_code", 1);
                                if (map2.containsKey("reward_live_scene")) {
                                    bundle.putInt("live_popup_reward_auth", 1);
                                    m.c("rewardAuthFlag", "liv pop rew auth:  1");
                                }
                            }
                        }
                        return bundle;
                    }
                } else {
                    i = iN;
                }
                jSONObject = null;
                i2 = -1;
                if (iUj <= 0) {
                    i5 = i2;
                    i6 = i;
                } else if (jSONObject == null) {
                    jSONObject = new JSONObject();
                    i5 = i2;
                    i6 = i;
                    rl.c(iVar.rl(), new Integer(1), Integer.class);
                    jSONObject.put("auth_reward_gold", iUj);
                } else {
                    i5 = i2;
                    i6 = i;
                    rl.c(iVar.rl(), new Integer(1), Integer.class);
                    jSONObject.put("auth_reward_gold", iUj);
                }
                if (jSONObject != null) {
                    string = jSONObject.toString();
                    if (!TextUtils.isEmpty(string)) {
                        bundle2.putString("live_auth_extra_info", string);
                    }
                }
                i2 = i5;
                i = i6;
            }
            if (svVarSl != null) {
                if (!TextUtils.isEmpty(svVarSl.sp())) {
                    bundle2.putString("live_csj_libra_param", svVarSl.sp());
                }
                jSONArrayX = svVarSl.x();
                if (jSONArrayX != null) {
                    c(jSONArrayX, iVar);
                    bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                    bundle.putString("live_tob_task_key", iVar.rl());
                }
            }
            if (nuVar != null || TextUtils.isEmpty(nuVar.tt())) {
                strC = null;
            } else {
                try {
                    Uri uri = Uri.parse(nuVar.tt());
                    JSONObject jSONObject13 = new JSONObject(uri.getQueryParameter("ad_data_params"));
                    String strOptString = jSONObject13.optString("log_extra");
                    HashMap map3 = new HashMap();
                    JSONObject jSONObject14 = new JSONObject();
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject15 = new JSONObject(strOptString);
                        jSONObject15.put("ad_event_aid", jSONObject13.optString("aid"));
                        jSONObject15.put("ad_event_source", com.byazt.apd.ve.c(uri, "source"));
                        jSONObject15.put("ad_event_gd_label", com.byazt.apd.ve.c(uri, "gd_label"));
                        jSONObject15.put("ad_event_union_user_id", com.byazt.apd.ve.c(uri, "union_user_id"));
                        jSONObject15.put("ad_event_app_siteid", x.m().rl());
                        jSONObject15.put("ad_event_live_type", "1");
                        map3.put("log_extra", jSONObject15.toString());
                        jSONObject14.put("log_extra", jSONObject15.toString());
                    }
                    String strOptString2 = jSONObject13.optString("cid");
                    jSONObject14.put("creativeID", strOptString2);
                    bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject14.toString());
                    map3.put("is_other_channel", "union_ad");
                    map3.put("value", strOptString2);
                    bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                    String strC2 = com.byazt.apd.ve.c(uri, "pangle_live_room_data");
                    if (!TextUtils.isEmpty(strC2)) {
                        bundle.putString("pangle_live_room_data", strC2);
                    }
                    String strC3 = com.byazt.apd.ve.c(uri, "owner_open_id");
                    if (TextUtils.isEmpty(strC3)) {
                        strC3 = com.byazt.apd.ve.c(uri, PtgRewardConstant.REWARD_PARAMS.USER_ID);
                    }
                    bundle2.putString("anchor_id", strC3);
                    bundle2.putString("live.intent.extra.REQUEST_ID", com.byazt.apd.ve.c(uri, "request_id"));
                    strC = com.byazt.apd.ve.c(uri, "enter_from_merge");
                } catch (Exception e13) {
                    m.c(e13);
                    strC = null;
                }
            }
            if (TextUtils.isEmpty(strC)) {
                strC = c(nb.sl(com.byazt.ppf.ve.c(iVar, map)));
            }
            bundle2.putString("enter_from_merge", strC);
            bundle2.putString("enter_method", tt(nb.sl(com.byazt.ppf.ve.c(iVar, map))));
            bundle2.putInt("live_pangle_interaction_type", i);
            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
            if (i2 != -1) {
                if (!TextUtils.isEmpty(strT)) {
                    JSONObject jSONObject16 = new JSONObject(strT);
                    JSONObject jSONObjectOptJSONObject6 = jSONObject16.optJSONObject("enter_request");
                    JSONObject jSONObject17 = new JSONObject();
                    jSONObject17.put("live_auto_auth_login_source", i2);
                    jSONObjectOptJSONObject6.put("live_commerce_sdk_custom_params", jSONObject17);
                    jSONObject16.remove("enter_request");
                    jSONObject16.put("enter_request", jSONObjectOptJSONObject6);
                    strT = jSONObject16.toString();
                }
            }
            map2 = map;
            bundle.putString("ecom_live_params", c(iVar, strT, map2));
        }
        if (!iVar.y_()) {
            return bundle;
        }
        obj = map2.get("reward_countdown");
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
            if (jLongValue > 0) {
                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                bundle.putInt("android.app.activity.request_code", 1);
                if (map2.containsKey("reward_live_scene") && ((Integer) map2.get("reward_live_scene")).intValue() == 1) {
                    bundle.putInt("live_popup_reward_auth", 1);
                    m.c("rewardAuthFlag", "liv pop rew auth:  1");
                }
            }
        }
        return bundle;
    }

    private int uj(i iVar) {
        String strM = iVar.m();
        Integer num = (Integer) rl.c(iVar.rl(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(strM)) {
            return 0;
        }
        try {
            return new JSONObject(strM).optInt("auth_reward_gold");
        } catch (Throwable th) {
            m.ve(com.byazt.we.ve.TAG, th);
            return 0;
        }
    }

    @Override // com.byazt.ysz.c
    public void a_(String str) {
        this.n = str;
    }

    @Override // com.byazt.ysz.uj
    public int c(i iVar, ve veVar, String str, Map<String, Object> map) {
        return -1;
    }

    @Override // com.byazt.ysz.c
    public boolean r_() {
        return false;
    }

    @Override // com.byazt.ysz.uj
    public String sp() {
        return this.n;
    }

    @Override // com.byazt.ysz.uj
    @Deprecated
    public int tt(ic icVar) {
        return 2;
    }

    @Override // com.byazt.ysz.uj
    public boolean a_(ic icVar) {
        return c((i) icVar);
    }

    @Override // com.byazt.ysz.c, com.byazt.ysz.uj
    public void c(Function<SparseArray<Object>, Object> function) {
        super.c(function);
    }

    @Override // com.byazt.ysz.uj
    public int c(final Context context, final i iVar, final Map<String, Object> map) {
        ve(iVar);
        final int iN = iVar.n();
        int i = (iN != 9 || !Objects.equals(map.get("saas_status_while_click"), 2) || iVar.D_() == null || iVar.D_().ve() == null) ? iN : 2;
        if (!c(iVar.da(), i)) {
            return 6;
        }
        final String str = map != null ? (String) map.get("event_tag") : "";
        if (!a()) {
            c(com.byazt.ppf.ve.c(iVar, map), str, iN, 1, i == 7 ? 1 : 2);
            return 1;
        }
        com.byazt.ppf.ve.c(iVar, map).lw();
        if (this.c == null) {
            return 4;
        }
        this.tt = str;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (n() != 2 ? c(iVar, new c() { // from class: com.byazt.ysz.a.1
            @Override // com.byazt.ysz.a.c
            public void c(boolean z) {
                boolean z2;
                if (atomicBoolean.compareAndSet(false, true)) {
                    a aVar = a.this;
                    aVar.c(context, iVar, iN, aVar.tt, (Map<String, Object>) map);
                    z2 = false;
                } else {
                    z2 = true;
                }
                yp.c().c(com.byazt.ppf.ve.c(iVar, (Map<String, Object>) map), System.currentTimeMillis() - jCurrentTimeMillis, z, z2);
            }
        }, true, map) : false) {
            q qVarC_ = iVar.C_();
            if (iVar.n() == 9) {
                qVarC_ = iVar.D_() != null ? iVar.D_().uj() : null;
            }
            q qVar = qVarC_;
            if (qVar != null) {
                long jN = qVar.n();
                if (jN > 0) {
                    da.ve().postDelayed(new Runnable() { // from class: com.byazt.ysz.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                a.this.c(context, iVar, iN, str, (Map<String, Object>) map);
                            }
                        }
                    }, jN);
                }
                if (qVar.a() == 1 && x.m().ve() != null) {
                    new com.byazt.ddx.i().c(new com.byazt.ddx.i.c() { // from class: com.byazt.ysz.a.3
                        @Override // com.byazt.ddx.i.c
                        public void c(long j) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                a.this.c(context, iVar, iN, str, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.byazt.ddx.i.c
                        public void c(boolean z) {
                        }

                        @Override // com.byazt.ddx.i.c
                        public void c(String str2) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                a.this.c(context, iVar, iN, str, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return c(context, iVar, i, str, map);
    }

    public boolean c(i iVar, final c cVar, boolean z, Map<String, Object> map) {
        if (this.n == null) {
            return false;
        }
        q qVarC_ = iVar.C_();
        if (iVar.n() == 9) {
            qVarC_ = iVar.D_() != null ? iVar.D_().uj() : null;
        }
        if (qVarC_ == null || qVarC_.ve() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.n.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int iTt = qVarC_.tt();
        boolean z2 = iTt > 0;
        if (z) {
            z2 = iTt == 3;
        }
        if (z2) {
            this.f29213a = new SoftReference<>(com.byazt.ppf.ve.c(iVar, map));
            if (c(new com.byazt.cn.tt() { // from class: com.byazt.ysz.a.4
                @Override // com.byazt.cn.tt
                public void c(Object obj) {
                    boolean z3 = false;
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        if (map2.containsKey("code")) {
                            Object obj2 = map2.get("code");
                            if (obj2 instanceof String) {
                                try {
                                    int i = Integer.parseInt((String) obj2);
                                    z3 = i == 1;
                                    m.c(com.byazt.we.ve.TAG, "requestDyAuth result:".concat(String.valueOf(i)));
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    cVar.c(z3);
                }
            }, iTt == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Context context, i iVar, int i, String str, Map<String, Object> map) {
        int iIntValue;
        int i2;
        int i3;
        int i4;
        int i5;
        m.c(com.byazt.we.ve.TAG, "openLive key:" + com.byazt.ppf.ve.c(iVar, map).lw());
        if (this.c != null) {
            int iTt = 0;
            Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(0).c(Integer.class).c(0, new zb().c("context", context).c("bundle", tt(context, iVar, map))).tt());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            this.tt = str;
            this.uj = iVar.rl();
            if (iIntValue == 0) {
                this.f29213a = new SoftReference<>(com.byazt.ppf.ve.c(iVar, map));
                int iC = com.byazt.wu.ve.c(map);
                if (iC == 101 || iC == 102) {
                    iIntValue |= iC << 8;
                } else {
                    i5 = 2;
                    if (c(iVar, iC)) {
                        iTt = tt(iVar);
                        i = 7;
                        if (iTt == 0) {
                            try {
                                new com.byazt.glq.c().c(str).c(context, map, iVar);
                                iIntValue |= iC << 8;
                            } catch (Exception e) {
                                m.c(e);
                            }
                        }
                    } else if (iVar.n() != 9) {
                    }
                }
                i2 = i;
                i4 = iTt;
                i3 = i5;
            } else {
                iTt = 3;
            }
            i5 = i;
            i2 = i;
            i4 = iTt;
            i3 = i5;
        } else {
            iIntValue = 4;
            i2 = i;
            i3 = i2;
            i4 = 1;
        }
        c(com.byazt.ppf.ve.c(iVar, map), str, i2, i3, i4);
        return iIntValue;
    }

    private void c(JSONArray jSONArray, i iVar) {
        com.byazt.fri.c cVar;
        if (iVar == null || jSONArray == null || (cVar = (com.byazt.fri.c) rl.c(iVar.rl(), com.byazt.fri.c.class)) == null || cVar.tt.isEmpty()) {
            return;
        }
        String strUj = iVar.uj();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("type");
                if (cVar.tt.contains(strUj + LoginConstants.UNDER_LINE + strOptString)) {
                    jSONObject.put("status", 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String c(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        if (i == 1) {
            return "ad_union_banner";
        }
        if (i == 3 || i == 4) {
            return "ad_union_topview";
        }
        if (i == 2) {
            return "ad_union_former_insert";
        }
        return i == 6 ? "ad_union_patch" : EnterFromMerge.NO_VALUE.lowerName();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    @Override // com.byazt.ysz.uj
    public int c(Context context, ic icVar, Map<String, Object> map) {
        long jLongValue;
        if (map != null) {
            try {
                Object obj = map.get("reward_countdown");
                if (obj instanceof Long) {
                    jLongValue = ((Long) obj).longValue();
                } else {
                    jLongValue = 0;
                }
            } catch (Exception e) {
                m.tt(com.byazt.we.ve.TAG, e.toString());
            }
        } else {
            jLongValue = 0;
        }
        if (context == null || icVar == null) {
            return 5;
        }
        if (!(context instanceof Activity)) {
            return 7;
        }
        if (!to.c(icVar)) {
            return 5;
        }
        if (jLongValue < 0) {
            return 8;
        }
        if (to.tt(icVar) == 1) {
            return 9;
        }
        return c(context, (i) icVar, map);
    }

    @Override // com.byazt.ysz.uj
    public int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 15;
        }
        if (this.c == null) {
            return 12;
        }
        if (!a()) {
            return 11;
        }
        Object objKk = x.m().kk();
        if (objKk == null) {
            return 13;
        }
        try {
            Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(8).c(Boolean.class).c(0, new zb().c("context", objKk).c("scheme_uri", str)).tt());
            return objApply != null ? ((Boolean) objApply).booleanValue() : false ? 1 : 10;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.byazt.ysz.uj
    public int c(com.byazt.cn.tt ttVar, boolean z) {
        if (this.c == null) {
            return 12;
        }
        if (!a()) {
            return 11;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", "requestDyAuth");
        map.put("expand_method_param", new Object[]{x.m().kk(), ttVar, Boolean.valueOf(z)});
        m.c(com.byazt.we.ve.TAG, "requestDyAuth:" + this.c.apply(com.byazt.yxi.uj.c().c(7).c(Void.class).c(0, map).tt()) + ", syncAuth = " + z);
        return 1;
    }

    @Override // com.byazt.ysz.c, com.byazt.ysz.uj
    public void c(String str, ic icVar, long j) {
        com.byazt.ex.c.c(str, icVar, j);
    }

    @Override // com.byazt.ysz.uj
    public void c(String str, boolean z) {
        if (this.c != null && a()) {
            HashMap map = new HashMap();
            map.put("expand_method_name", str);
            map.put("expand_method_param", new Object[]{Boolean.valueOf(z)});
            this.c.apply(com.byazt.yxi.uj.c().c(7).c(Void.class).c(0, map).tt());
        }
    }

    public static String tt(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }
}
