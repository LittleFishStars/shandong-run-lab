package com.byazt.omf;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alipay.sdk.m.t.e;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.qp;
import com.byazt.aas.sv;
import com.byazt.ete.bm;
import com.byazt.ete.hj;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.ete.tk;
import com.byazt.nys.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kc.openset.advertisers.hl.HLADNID;
import com.zj.adlib.xh9;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr implements gu<com.byazt.ddx.c> {
    public static final AtomicInteger tt = new AtomicInteger(0);
    public static final AtomicInteger ve = new AtomicInteger(0);
    public final Context c;
    public AtomicLong uj = new AtomicLong(0);

    @com.byazt.zqa.c(c = {0, 1, 31, 1489})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28881a;
        public final int c;
        public final ArrayList<Integer> da;
        public final String i;
        public final String n;
        public final String sp;
        public final long tt;
        public final int uj;
        public final long ve;
        public final com.byazt.ete.c x;

        private c(String str, int i, int i2, String str2, int i3, String str3, com.byazt.ete.c cVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.c = i;
            this.uj = i2;
            this.n = str2;
            this.sp = str3;
            this.x = cVar;
            this.i = str;
            this.f28881a = i3;
            this.tt = j;
            this.ve = j2;
            this.da = arrayList;
        }

        public static c c(JSONObject jSONObject) {
            return c(jSONObject, null, null);
        }

        public static c c(JSONObject jSONObject, com.byazt.dj.tt ttVar, bm bmVar) {
            Object obj;
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString("desc");
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.byazt.ete.c, ArrayList<Integer>> pairC = com.byazt.omf.c.c(jSONObject, ttVar, bmVar, jOptLong2);
            if (pairC != null && (obj = pairC.first) != null) {
                ((com.byazt.ete.c) obj).c(jSONObject.optLong("request_after"));
            }
            return pairC == null ? new c(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null) : new c(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.byazt.ete.c) pairC.first, jOptLong, jOptLong2, (ArrayList) pairC.second);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 31, 309})
    public static class tt {
        public final int c;
        public final boolean tt;

        private tt(int i, boolean z) {
            this.c = i;
            this.tt = z;
        }

        public static tt c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new tt(jSONObject.optInt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE), jSONObject.optBoolean("result"));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 31, TTAdConstant.IMAGE_LIST_CODE})
    public static class uj {
        public final int c;
        public final boolean tt;
        public final hj ve;

        private uj(int i, boolean z, hj hjVar) {
            this.c = i;
            this.tt = z;
            this.ve = hjVar;
        }

        public static uj c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            hj hjVar = new hj();
            if (jSONObjectOptJSONObject != null) {
                try {
                    hjVar.c(jSONObjectOptJSONObject.optInt(MediationConstant.KEY_REASON));
                    hjVar.tt(jSONObjectOptJSONObject.optInt("corp_type"));
                    hjVar.ve(jSONObjectOptJSONObject.optInt("reward_amount"));
                    hjVar.c(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
            }
            return new uj(iOptInt, zOptBoolean, hjVar);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 31, TypedValues.CycleType.TYPE_WAVE_SHAPE})
    public static class ve {
        public final int c;
        public final String tt;
        public final tk ve;

        private ve(int i, String str, tk tkVar) {
            this.c = i;
            this.tt = str;
            this.ve = tkVar;
        }

        public static ve c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            tk tkVar = new tk();
            if (jSONObjectOptJSONObject != null) {
                try {
                    tkVar.c(jSONObjectOptJSONObject.optBoolean("is_open"));
                    tkVar.c(jSONObjectOptJSONObject.optString("req_id"));
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
            }
            return new ve(iOptInt, strOptString, tkVar);
        }
    }

    public gr(Context context) {
        this.c = context;
    }

    private boolean tt(int i) {
        return i == 3 || i == 4;
    }

    private boolean tt(String str) {
        if (com.byazt.dl.ve.c()) {
            return true;
        }
        if (!com.byazt.dl.ve.c(str)) {
            return false;
        }
        String strTt = com.byazt.dl.ve.tt();
        if (!TextUtils.isEmpty(strTt)) {
            com.byazt.ukr.yp.c(strTt, System.currentTimeMillis(), false);
        }
        return true;
    }

    private boolean ve(String str) {
        if (com.byazt.dl.ve.ve()) {
            return true;
        }
        if (!com.byazt.dl.ve.tt(str)) {
            return false;
        }
        String strUj = com.byazt.dl.ve.uj();
        if (!TextUtils.isEmpty(strUj)) {
            com.byazt.ukr.yp.c(strUj, System.currentTimeMillis(), true);
        }
        return true;
    }

    public void n(final com.byazt.dj.tt ttVar, final bm bmVar, final int i, gu.tt ttVar2) {
        final com.byazt.gk.c cVar = new com.byazt.gk.c(ttVar2);
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("bid_p_f") { // from class: com.byazt.omf.gr.22
            @Override // java.lang.Runnable
            public void run() {
                gr.this.c(ttVar, bmVar, i, cVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    public void uj(com.byazt.dj.tt ttVar, bm bmVar, int i, gu.tt ttVar2) {
        tt(ttVar, bmVar, i, ttVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private void uj(String str) {
        com.byazt.aas.z.c(str);
        if (com.byazt.lkt.c.c() != null) {
            com.byazt.lkt.c.c().c(str);
        }
    }

    private void n(String str) {
        com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
        veVarVe.c(str);
        veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.18
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
            }
        });
    }

    private boolean uj(com.byazt.dj.tt ttVar) {
        return ttVar != null && ttVar.sp() == 320 && ttVar.a() == 640;
    }

    @Override // com.byazt.omf.gu
    public void tt(final com.byazt.dj.tt ttVar, final bm bmVar, final int i, gu.tt ttVar2) {
        final com.byazt.gk.c cVar = new com.byazt.gk.c(ttVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("bid_pre") { // from class: com.byazt.omf.gr.12
                @Override // java.lang.Runnable
                public void run() {
                    gr.this.c(ttVar, bmVar, i, cVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            c(ttVar, bmVar, i, cVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    @Override // com.byazt.omf.gu
    public void ve(final com.byazt.dj.tt ttVar, final bm bmVar, final int i, gu.tt ttVar2) {
        final com.byazt.gk.c cVar = new com.byazt.gk.c(ttVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("bid_g_m") { // from class: com.byazt.omf.gr.23
                @Override // java.lang.Runnable
                public void run() {
                    gr.this.c(ttVar, bmVar, i, cVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            c(ttVar, bmVar, i, cVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    private void tt(final com.byazt.dj.tt ttVar, final bm bmVar, final int i, final gu.tt ttVar2, String str, final int i2) {
        final com.byazt.ete.tt ttVar3 = new com.byazt.ete.tt();
        ttVar3.c(ttVar);
        try {
            boolean[] zArr = {false};
            if (c(ttVar, ttVar3, ttVar2, i2 == 5, bmVar, i, zArr)) {
                return;
            }
            com.byazt.va.n nVarC = c(ttVar, bmVar, i, ttVar2, str, i2, ttVar3, zArr[0]);
            if (nVarC == null) {
                ttVar3.c(-15);
                ttVar2.c(-15, sp.c(-15), ttVar3);
            } else {
                nVarC.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.19
                    @Override // com.byazt.mh.c
                    public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar4) {
                        gr.this.c(ujVar, ttVar4, ttVar3, ttVar2, ttVar, bmVar, i, i2);
                    }

                    @Override // com.byazt.mh.c
                    public void c(com.byazt.va.uj ujVar, IOException iOException) {
                        gr.this.c(ujVar, iOException, ttVar3, ttVar2);
                    }
                });
                com.byazt.omf.uj.c().ve();
                c();
            }
        } catch (Throwable th) {
            c(th, ttVar3, ttVar2);
        }
    }

    private static String ve(com.byazt.dj.tt ttVar) {
        String strYv = x.m().yv();
        String strN = x.m().n();
        x.m().tt((String) null);
        String strQy = ttVar != null ? ttVar.qy() : null;
        if (TextUtils.isEmpty(strYv)) {
            return c(strQy, strN);
        }
        try {
            if (!TextUtils.isEmpty(strYv) && strYv.contains("game_adapter_did")) {
                strYv = c(new JSONArray(strYv)).toString();
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        if (TextUtils.isEmpty(strQy)) {
            return c(strYv, strN);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(strQy);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("name", null);
                    if (TextUtils.equals("is_shake_ads", strOptString)) {
                        if (TextUtils.equals(strN, "0")) {
                            jSONObject.put("value", "0");
                            x.m().tt("0");
                        } else {
                            x.m().tt(jSONObject.optString("value"));
                        }
                        z = true;
                    }
                    hashSet.add(strOptString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strYv);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String strOptString2 = jSONObject2.optString("name", null);
                        if (!hashSet.contains(strOptString2)) {
                            if (TextUtils.equals("is_shake_ads", strOptString2)) {
                                if (TextUtils.equals(strN, "0")) {
                                    jSONObject2.put("value", "0");
                                    x.m().tt("0");
                                } else {
                                    x.m().tt(jSONObject2.optString("value"));
                                }
                                z = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z) {
                    jSONArray = tt(jSONArray, strN);
                }
                return c(c(jSONArray), strN).toString();
            } catch (Throwable unused) {
                return c(strQy, strN);
            }
        } catch (Throwable unused2) {
            return c(strYv, strN);
        }
    }

    public JSONObject c(com.byazt.dj.tt ttVar, bm bmVar, int i, boolean z, int i2, boolean z2) {
        return c(ttVar, bmVar, i, z, i2, z2, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    private JSONObject c(bm bmVar) {
        com.byazt.iyp.c.C0441c c0441cTt;
        boolean z;
        boolean z2;
        boolean z3;
        CharSequence title;
        JSONObject jSONObject = new JSONObject();
        boolean z4 = false;
        if (bmVar != null) {
            try {
                if (TextUtils.isEmpty(bmVar.my) || (c0441cTt = com.byazt.iyp.c.tt(bmVar.my)) == null) {
                    z = false;
                    z3 = false;
                } else {
                    z = true;
                    if (TextUtils.isEmpty(c0441cTt.c)) {
                        z2 = false;
                    } else {
                        jSONObject.put("top_page_title", c0441cTt.c);
                        z2 = true;
                    }
                    if (TextUtils.isEmpty(c0441cTt.tt)) {
                        z3 = false;
                    } else {
                        jSONObject.put("top_page_name", c0441cTt.tt);
                        z3 = true;
                    }
                    if (TextUtils.isEmpty(c0441cTt.ve)) {
                        z = false;
                    } else {
                        jSONObject.put("t_name", c0441cTt.ve);
                    }
                    z4 = z2;
                }
            } catch (Throwable th) {
                com.byazt.nr.m.ve("NetApiImpl", "buildFeatureRequestBody error: ", th);
                return jSONObject;
            }
        } else {
            z = false;
            z3 = false;
        }
        if (z4 && z3 && z) {
            return jSONObject;
        }
        Activity activity = null;
        if (x.m().ve() != null && x.m().ve().c() != null) {
            activity = x.m().ve().c().get();
        }
        if (activity != null) {
            if (!z4 || !z3) {
                com.byazt.iyp.sl.c(activity);
                if (!z4 && (title = activity.getTitle()) != null && title.length() > 0) {
                    jSONObject.put("top_page_title", title.toString());
                }
                if (!z3) {
                    jSONObject.put("top_page_name", activity.getClass().getName());
                }
            }
            if (!z) {
                try {
                    String strA = com.byazt.iyp.uj.a();
                    if (!TextUtils.isEmpty(strA)) {
                        jSONObject.put("t_name", strA);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    private JSONObject tt(com.byazt.vo.tt ttVar, List<com.byazt.nc.a> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", com.byazt.dyf.tt.AD_TAG_DISLIKE);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", p.n);
            com.byazt.qh.tt.c(jSONObject2);
            if (ttVar != null) {
                jSONObject2.put("extra", ttVar.n());
                if (ttVar.ve() == null) {
                    ttVar.c("other");
                }
                jSONObject2.put("dislike_source", ttVar.ve());
            }
            String strC = c(list);
            if (strC != null) {
                jSONObject2.put("comment", strC);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", tt(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put(AssistPushConsts.MSG_TYPE_ACTIONS, jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:104:0x01fb A[Catch: all -> 0x0186, TRY_ENTER, TryCatch #2 {all -> 0x0186, blocks: (B:76:0x0178, B:90:0x01ba, B:104:0x01fb, B:106:0x0205, B:108:0x020b, B:110:0x0212, B:112:0x0218, B:113:0x0221, B:116:0x022f, B:119:0x0248, B:120:0x0251, B:117:0x0236, B:124:0x02b7, B:126:0x02ba, B:131:0x02ec), top: B:207:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x022f A[Catch: all -> 0x0186, TRY_ENTER, TryCatch #2 {all -> 0x0186, blocks: (B:76:0x0178, B:90:0x01ba, B:104:0x01fb, B:106:0x0205, B:108:0x020b, B:110:0x0212, B:112:0x0218, B:113:0x0221, B:116:0x022f, B:119:0x0248, B:120:0x0251, B:117:0x0236, B:124:0x02b7, B:126:0x02ba, B:131:0x02ec), top: B:207:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0236 A[Catch: all -> 0x0186, TryCatch #2 {all -> 0x0186, blocks: (B:76:0x0178, B:90:0x01ba, B:104:0x01fb, B:106:0x0205, B:108:0x020b, B:110:0x0212, B:112:0x0218, B:113:0x0221, B:116:0x022f, B:119:0x0248, B:120:0x0251, B:117:0x0236, B:124:0x02b7, B:126:0x02ba, B:131:0x02ec), top: B:207:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0248 A[Catch: all -> 0x0186, TryCatch #2 {all -> 0x0186, blocks: (B:76:0x0178, B:90:0x01ba, B:104:0x01fb, B:106:0x0205, B:108:0x020b, B:110:0x0212, B:112:0x0218, B:113:0x0221, B:116:0x022f, B:119:0x0248, B:120:0x0251, B:117:0x0236, B:124:0x02b7, B:126:0x02ba, B:131:0x02ec), top: B:207:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    /* JADX WARN: Code duplicated, block: B:131:0x02ec A[Catch: all -> 0x0186, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0186, blocks: (B:76:0x0178, B:90:0x01ba, B:104:0x01fb, B:106:0x0205, B:108:0x020b, B:110:0x0212, B:112:0x0218, B:113:0x0221, B:116:0x022f, B:119:0x0248, B:120:0x0251, B:117:0x0236, B:124:0x02b7, B:126:0x02ba, B:131:0x02ec), top: B:207:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x030f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0311  */
    /* JADX WARN: Code duplicated, block: B:13:0x0033 A[Catch: all -> 0x043a, TRY_LEAVE, TryCatch #6 {all -> 0x043a, blocks: (B:10:0x002a, B:13:0x0033), top: B:215:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:142:0x034b  */
    /* JADX WARN: Code duplicated, block: B:145:0x0358 A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x037f A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0386  */
    /* JADX WARN: Code duplicated, block: B:150:0x0388  */
    /* JADX WARN: Code duplicated, block: B:152:0x0391 A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x03a2 A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x03ae A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:161:0x03b7 A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x03ca A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0401  */
    /* JADX WARN: Code duplicated, block: B:189:0x0420 A[Catch: all -> 0x0430, TryCatch #0 {all -> 0x0430, blocks: (B:141:0x0346, B:143:0x034d, B:145:0x0358, B:147:0x037f, B:151:0x0389, B:153:0x039e, B:155:0x03a2, B:152:0x0391, B:157:0x03ae, B:161:0x03b7, B:162:0x03c0, B:164:0x03ca, B:165:0x03d7, B:167:0x03e1, B:169:0x03eb, B:171:0x03f1, B:172:0x03f6, B:174:0x03fa, B:180:0x0404, B:182:0x040b, B:184:0x0411, B:186:0x0417, B:187:0x041c, B:189:0x0420, B:190:0x042c), top: B:204:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0043 A[Catch: all -> 0x005c, TryCatch #8 {all -> 0x005c, blocks: (B:16:0x003d, B:18:0x0043, B:21:0x004f, B:22:0x0054, B:23:0x0058, B:29:0x0065, B:31:0x0069, B:33:0x006e, B:35:0x0076, B:62:0x00ef, B:64:0x00f7, B:67:0x0103, B:39:0x008b, B:41:0x008f), top: B:219:0x003d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:213:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x004f A[Catch: all -> 0x005c, TryCatch #8 {all -> 0x005c, blocks: (B:16:0x003d, B:18:0x0043, B:21:0x004f, B:22:0x0054, B:23:0x0058, B:29:0x0065, B:31:0x0069, B:33:0x006e, B:35:0x0076, B:62:0x00ef, B:64:0x00f7, B:67:0x0103, B:39:0x008b, B:41:0x008f), top: B:219:0x003d }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0054 A[Catch: all -> 0x005c, TryCatch #8 {all -> 0x005c, blocks: (B:16:0x003d, B:18:0x0043, B:21:0x004f, B:22:0x0054, B:23:0x0058, B:29:0x0065, B:31:0x0069, B:33:0x006e, B:35:0x0076, B:62:0x00ef, B:64:0x00f7, B:67:0x0103, B:39:0x008b, B:41:0x008f), top: B:219:0x003d }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[Catch: all -> 0x005c, TryCatch #8 {all -> 0x005c, blocks: (B:16:0x003d, B:18:0x0043, B:21:0x004f, B:22:0x0054, B:23:0x0058, B:29:0x0065, B:31:0x0069, B:33:0x006e, B:35:0x0076, B:62:0x00ef, B:64:0x00f7, B:67:0x0103, B:39:0x008b, B:41:0x008f), top: B:219:0x003d }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad A[Catch: all -> 0x00eb, TryCatch #7 {all -> 0x00eb, blocks: (B:42:0x0092, B:44:0x00ad, B:46:0x00b4, B:48:0x00c2, B:50:0x00c9, B:52:0x00cf, B:53:0x00d4, B:55:0x00da, B:57:0x00e0, B:59:0x00e6), top: B:217:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b4 A[Catch: all -> 0x00eb, TryCatch #7 {all -> 0x00eb, blocks: (B:42:0x0092, B:44:0x00ad, B:46:0x00b4, B:48:0x00c2, B:50:0x00c9, B:52:0x00cf, B:53:0x00d4, B:55:0x00da, B:57:0x00e0, B:59:0x00e6), top: B:217:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c2 A[Catch: all -> 0x00eb, TryCatch #7 {all -> 0x00eb, blocks: (B:42:0x0092, B:44:0x00ad, B:46:0x00b4, B:48:0x00c2, B:50:0x00c9, B:52:0x00cf, B:53:0x00d4, B:55:0x00da, B:57:0x00e0, B:59:0x00e6), top: B:217:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cf A[Catch: all -> 0x00eb, TryCatch #7 {all -> 0x00eb, blocks: (B:42:0x0092, B:44:0x00ad, B:46:0x00b4, B:48:0x00c2, B:50:0x00c9, B:52:0x00cf, B:53:0x00d4, B:55:0x00da, B:57:0x00e0, B:59:0x00e6), top: B:217:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #7 {all -> 0x00eb, blocks: (B:42:0x0092, B:44:0x00ad, B:46:0x00b4, B:48:0x00c2, B:50:0x00c9, B:52:0x00cf, B:53:0x00d4, B:55:0x00da, B:57:0x00e0, B:59:0x00e6), top: B:217:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0103 A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x005c, blocks: (B:16:0x003d, B:18:0x0043, B:21:0x004f, B:22:0x0054, B:23:0x0058, B:29:0x0065, B:31:0x0069, B:33:0x006e, B:35:0x0076, B:62:0x00ef, B:64:0x00f7, B:67:0x0103, B:39:0x008b, B:41:0x008f), top: B:219:0x003d }] */
    /* JADX WARN: Code duplicated, block: B:70:0x012f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0131  */
    /* JADX WARN: Code duplicated, block: B:83:0x018f  */
    /* JADX WARN: Code duplicated, block: B:86:0x019d  */
    /* JADX WARN: Code duplicated, block: B:87:0x019f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ba A[Catch: all -> 0x0186, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0186, blocks: (B:76:0x0178, B:90:0x01ba, B:104:0x01fb, B:106:0x0205, B:108:0x020b, B:110:0x0212, B:112:0x0218, B:113:0x0221, B:116:0x022f, B:119:0x0248, B:120:0x0251, B:117:0x0236, B:124:0x02b7, B:126:0x02ba, B:131:0x02ec), top: B:207:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:94:0x01cc  */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONObject c(com.byazt.dj.tt ttVar, bm bmVar, int i, boolean z, int i2, boolean z2, String str) {
        String str2;
        String strSp;
        int iC;
        int i3;
        String str3;
        int i4;
        com.byazt.apd.tt ttVarC;
        int iVe;
        String str4;
        int i5;
        String strSp2;
        boolean z3;
        boolean z4;
        JSONObject jSONObjectC;
        String[] strArrC;
        int i6;
        String str5;
        String str6;
        int i7;
        int i8;
        int i9;
        int i10;
        JSONObject jSONObjectC2;
        JSONObject jSONObjectTt;
        long jCurrentTimeMillis;
        qy qyVar;
        boolean z5;
        int andSet;
        String strN;
        String strA;
        JSONObject jSONObject;
        String strC;
        int i11;
        JSONObject jSONObject2 = new JSONObject();
        if (bmVar != null) {
            try {
                if (!TextUtils.isEmpty(bmVar.tt())) {
                    strSp = bmVar.tt();
                } else {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            strSp = nb.sp();
                        } else {
                            strSp = str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        str2 = null;
                        c(str2, ttVar, th);
                        return jSONObject2;
                    }
                }
                if (ttVar != null) {
                    try {
                        if (ttVar.gu() != null) {
                            iC = com.byazt.sq.a.c(ttVar.gu());
                            if (iC != 1) {
                                jSONObject2.put("req_type", 1);
                            } else if (iC != 3) {
                                jSONObject2.put("req_type", -1);
                            } else {
                                jSONObject2.put("req_type", 3);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = strSp;
                        c(str2, ttVar, th);
                        return jSONObject2;
                    }
                }
                if (i == 7) {
                    if (bmVar != null && (i11 = bmVar.c) > 0) {
                        jSONObject2.put("req_type", i11);
                    }
                    if (bmVar != null && !TextUtils.isEmpty(bmVar.ve)) {
                        jSONObject2.put("pre_sessions", bmVar.ve);
                        jSONObject2.put("play_again_count", bmVar.uj);
                    }
                } else if (i == 8 && bmVar != null && (i3 = bmVar.c) > 0) {
                    jSONObject2.put("req_type", i3);
                }
                try {
                    strN = com.byazt.by.n.c().n();
                    strA = com.byazt.by.n.c().a();
                    jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(strN)) {
                        jSONObject.putOpt("version", strN);
                    }
                    if (ttVar != null) {
                        strC = nb.c(ttVar.nu());
                        if (!TextUtils.isEmpty(strC)) {
                            jSONObject.put("external_ab_vid", strC);
                        }
                    } else {
                        strC = null;
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        jSONObject.putOpt("param", strA);
                    }
                    if (TextUtils.isEmpty(strN) || !TextUtils.isEmpty(strC) || !TextUtils.isEmpty(strA)) {
                        jSONObject2.put("abtest", jSONObject);
                    }
                } catch (Throwable unused) {
                }
                if (i2 == 5 && (andSet = ve.getAndSet(0)) > 0) {
                    jSONObject2.put("throttle_count", andSet);
                }
                try {
                    jSONObject2.put("request_id", strSp);
                    if (z2) {
                        jSONObject2.put("exemption_req", 1);
                    }
                    jSONObject2.put("ad_sdk_version", p.n);
                    jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
                    jSONObject2.put("is_plugin", p.c());
                    jSONObject2.put("sdk_boost_type", com.byazt.xo.c.n());
                    if (p.n()) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    jSONObject2.put("is_use_tt_video", i4);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    ttVarC = com.byazt.apd.tt.c();
                    iVe = ttVarC.ve();
                    jSONObject2.put("live_sdk_status", iVe);
                    jSONObject2.put("live_auth_status", ttVarC.n());
                    jSONObject2.put("live_sdk_config", ttVarC.x());
                    jSONObject2.put("live_ad_click_count", ttVarC.a());
                    x.m().t();
                    if (iVe != 2) {
                        try {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            str4 = strSp;
                            try {
                                jSONObject2.put("app_start_time", jElapsedRealtime - Process.getStartElapsedRealtime());
                                jSONObject2.put("live_last_init_time", jElapsedRealtime - ttVarC.i());
                            } catch (Throwable th3) {
                                th = th3;
                                str2 = str4;
                                c(str2, ttVar, th);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str4 = strSp;
                            str2 = str4;
                            c(str2, ttVar, th);
                        }
                    } else {
                        str4 = strSp;
                    }
                    try {
                        if (x.m().bx()) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                        jSONObject2.put("csj_type", i5);
                        jSONObject2.put("pma_data", com.byazt.fj.c.c().tt());
                        strSp2 = ttVarC.sp();
                        if (!TextUtils.isEmpty(strSp2)) {
                            jSONObject2.put("live_plugin_version", strSp2);
                        }
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                        if (i2 == 5) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        bmVar.c("liveInfo", jCurrentTimeMillis3, z3);
                        jSONObject2.put("source_type", NativeCallContext.DOMAIN_APP);
                        jSONObject2.put("logsdk_version", com.byazt.by.uj.c().n(i));
                        if (i2 != 4 || i2 == 5) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        jSONObject2.put(NativeCallContext.DOMAIN_APP, DeviceUtils.c(i, z4));
                        jSONObjectC = com.byazt.by.c.c(this.c, i);
                        if (jSONObjectC != null) {
                            if (!gt.tt().ny() && !com.byazt.yih.i.tt()) {
                                jSONObjectC.remove("free_space");
                            }
                            if (ttVar != null && ttVar.z() > 0) {
                                jSONObjectC.put("orientation", ttVar.z());
                            }
                            if (com.byazt.by.uj.c().sp(i)) {
                                jSONObjectC.put("wifi_signal", "unknown");
                                jSONObjectC.put("cellular_signal", "unknown");
                            } else {
                                jSONObjectC.put("wifi_signal", DeviceUtils.c(0));
                                jSONObjectC.put("cellular_signal", DeviceUtils.c(1));
                            }
                            if (i2 != 4) {
                                jSONObjectC.put("sof_chara", com.byazt.aas.gr.a());
                            }
                            com.byazt.aas.sl.c(jSONObjectC);
                            jSONObjectC.put("cpu_arch", com.byazt.aas.gr.u());
                            jSONObjectC.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.byazt.pf.c.c().a());
                            jSONObjectC.put("font_size", com.byazt.qw.ve.ve().da());
                            jSONObjectC.put("gpu_model", com.byazt.qw.x.c());
                        }
                        jSONObject2.put("device", jSONObjectC);
                        jSONObject2.put("pan_code_serial", HLADNID.Reason.OTHER);
                        jSONObject2.put(RichTextUtils.USER_SCHEME, c(ttVar, i));
                        jSONObject2.put("ua", ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(false));
                        jSONObject2.put(xh9.WEBSITE_PARAMS_CHANNEL, p.x);
                        strArrC = com.byazt.by.c.c(i);
                        String strConcat = "";
                        if (strArrC != null || strArrC.length < 2) {
                            i6 = 0;
                            str5 = "";
                            str6 = str5;
                        } else {
                            i6 = 0;
                            str6 = strArrC[0];
                            str5 = strArrC[1];
                        }
                        jSONObject2.put(LoginConstants.IP, str6);
                        jSONObject2.put("client_ipv6", str5);
                        jSONObject2.put("client_ipv4", com.byazt.by.c.c(str6, i));
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(c(ttVar, i, bmVar));
                        jSONObject2.put("adslots", jSONArray);
                        i7 = bmVar.yp;
                        if (i7 > 0) {
                            jSONObject2.put("load_ad_api", i7);
                        }
                        com.byazt.by.c.c(jSONObject2, i);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("start2req_time", SystemClock.elapsedRealtime() - rh.n);
                        if (rh.tt.get()) {
                            i8 = i6;
                        } else {
                            i8 = 1;
                        }
                        jSONObject3.put("start_type", i8);
                        jSONObject3.put("show_count", com.byazt.ddx.uj.c);
                        jSONObject2.put("ads_parameter", jSONObject3);
                        c(jSONObject2, bmVar);
                        long jCurrentTimeMillis4 = System.currentTimeMillis() / 1000;
                        jSONObject2.put("ts", jCurrentTimeMillis4);
                        if (ttVar.uj() == null && str4 != null) {
                            str3 = str4;
                            try {
                                strConcat = String.valueOf(jCurrentTimeMillis4).concat(ttVar.uj()).concat(str3);
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = str3;
                                c(str2, ttVar, th);
                            }
                        }
                        jSONObject2.put("req_sign", com.byazt.nr.a.tt(strConcat));
                        if (i2 == 4) {
                            jCurrentTimeMillis = System.currentTimeMillis();
                            jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(gt.tt().c(ttVar.uj())));
                            if (gt.tt().tt(ttVar.uj())) {
                                if (7 == ttVar.gt()) {
                                    z5 = 1;
                                } else {
                                    z5 = i6;
                                }
                                c(z5, jSONObject2, ttVar.uj());
                            } else {
                                com.byazt.ukr.yp.c().c(ttVar.uj(), (String) null, (String) null, true);
                            }
                            qyVar = bmVar.z;
                            if (qyVar != null) {
                                qyVar.c("precache_time", System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                        if (z) {
                            jSONObject2.put("ad_sdk_version", p.n);
                            return jSONObject2;
                        }
                        if (i2 == 3) {
                            jSONObject2.put("material_keys", nb.c(ttVar));
                        }
                        if (gt.tt().ri()) {
                            jSONObject2.put("feature_data", com.byazt.qw.ve.ve().n());
                        }
                        if (gt.tt().ge() && (jSONObjectTt = com.byazt.feb.c.c().tt()) != null && jSONObjectTt.length() > 0) {
                            jSONObject2.putOpt("feature_data_v2", jSONObjectTt);
                        }
                        if (bmVar.c != 2 || bmVar.tt == 2) {
                            i9 = 1;
                        } else {
                            i9 = i6;
                        }
                        if (i9 == 0 && com.byazt.iyp.ve.uj() == 1 && (jSONObjectC2 = c(bmVar)) != null && jSONObjectC2.length() > 0) {
                            jSONObject2.put("load_feature", jSONObjectC2);
                        }
                        i10 = bmVar.nu;
                        if (i10 > 0) {
                            jSONObject2.put("second_page_type", i10);
                            jSONObject2.put("second_page_origin_req_id", bmVar.rh);
                        }
                        com.byazt.cl.c.c(jSONObject2);
                    } catch (Throwable th6) {
                        th = th6;
                        str3 = str4;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str3 = strSp;
                }
            } catch (Throwable th8) {
                th = th8;
                str2 = null;
                c(str2, ttVar, th);
                return jSONObject2;
            }
        } else {
            if (TextUtils.isEmpty(str)) {
                strSp = str;
            } else {
                strSp = nb.sp();
            }
            if (ttVar != null) {
                if (ttVar.gu() != null) {
                    iC = com.byazt.sq.a.c(ttVar.gu());
                    if (iC != 1) {
                        jSONObject2.put("req_type", 1);
                    } else if (iC != 3) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 3);
                    }
                }
            }
            if (i == 7) {
                if (bmVar != null) {
                    jSONObject2.put("req_type", i11);
                }
                if (bmVar != null) {
                    jSONObject2.put("pre_sessions", bmVar.ve);
                    jSONObject2.put("play_again_count", bmVar.uj);
                }
            } else if (i == 8) {
                jSONObject2.put("req_type", i3);
            }
            strN = com.byazt.by.n.c().n();
            strA = com.byazt.by.n.c().a();
            jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(strN)) {
                jSONObject.putOpt("version", strN);
            }
            if (ttVar != null) {
                strC = nb.c(ttVar.nu());
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject.put("external_ab_vid", strC);
                }
            } else {
                strC = null;
            }
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.putOpt("param", strA);
            }
            if (TextUtils.isEmpty(strN)) {
                jSONObject2.put("abtest", jSONObject);
            } else {
                jSONObject2.put("abtest", jSONObject);
            }
            if (i2 == 5) {
                jSONObject2.put("throttle_count", andSet);
            }
            jSONObject2.put("request_id", strSp);
            if (z2) {
                jSONObject2.put("exemption_req", 1);
            }
            jSONObject2.put("ad_sdk_version", p.n);
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject2.put("is_plugin", p.c());
            jSONObject2.put("sdk_boost_type", com.byazt.xo.c.n());
            if (p.n()) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            jSONObject2.put("is_use_tt_video", i4);
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            ttVarC = com.byazt.apd.tt.c();
            iVe = ttVarC.ve();
            jSONObject2.put("live_sdk_status", iVe);
            jSONObject2.put("live_auth_status", ttVarC.n());
            jSONObject2.put("live_sdk_config", ttVarC.x());
            jSONObject2.put("live_ad_click_count", ttVarC.a());
            x.m().t();
            if (iVe != 2) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                str4 = strSp;
                jSONObject2.put("app_start_time", jElapsedRealtime2 - Process.getStartElapsedRealtime());
                jSONObject2.put("live_last_init_time", jElapsedRealtime2 - ttVarC.i());
            } else {
                str4 = strSp;
            }
            if (x.m().bx()) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            jSONObject2.put("csj_type", i5);
            jSONObject2.put("pma_data", com.byazt.fj.c.c().tt());
            strSp2 = ttVarC.sp();
            if (!TextUtils.isEmpty(strSp2)) {
                jSONObject2.put("live_plugin_version", strSp2);
            }
            long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis5;
            if (i2 == 5) {
                z3 = true;
            } else {
                z3 = false;
            }
            bmVar.c("liveInfo", jCurrentTimeMillis6, z3);
            jSONObject2.put("source_type", NativeCallContext.DOMAIN_APP);
            jSONObject2.put("logsdk_version", com.byazt.by.uj.c().n(i));
            if (i2 != 4) {
                z4 = true;
            } else {
                z4 = true;
            }
            jSONObject2.put(NativeCallContext.DOMAIN_APP, DeviceUtils.c(i, z4));
            jSONObjectC = com.byazt.by.c.c(this.c, i);
            if (jSONObjectC != null) {
                if (!gt.tt().ny()) {
                    jSONObjectC.remove("free_space");
                }
                if (ttVar != null) {
                    jSONObjectC.put("orientation", ttVar.z());
                }
                if (com.byazt.by.uj.c().sp(i)) {
                    jSONObjectC.put("wifi_signal", "unknown");
                    jSONObjectC.put("cellular_signal", "unknown");
                } else {
                    jSONObjectC.put("wifi_signal", DeviceUtils.c(0));
                    jSONObjectC.put("cellular_signal", DeviceUtils.c(1));
                }
                if (i2 != 4) {
                    jSONObjectC.put("sof_chara", com.byazt.aas.gr.a());
                }
                com.byazt.aas.sl.c(jSONObjectC);
                jSONObjectC.put("cpu_arch", com.byazt.aas.gr.u());
                jSONObjectC.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.byazt.pf.c.c().a());
                jSONObjectC.put("font_size", com.byazt.qw.ve.ve().da());
                jSONObjectC.put("gpu_model", com.byazt.qw.x.c());
            }
            jSONObject2.put("device", jSONObjectC);
            jSONObject2.put("pan_code_serial", HLADNID.Reason.OTHER);
            jSONObject2.put(RichTextUtils.USER_SCHEME, c(ttVar, i));
            jSONObject2.put("ua", ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(false));
            jSONObject2.put(xh9.WEBSITE_PARAMS_CHANNEL, p.x);
            strArrC = com.byazt.by.c.c(i);
            String strConcat2 = "";
            if (strArrC != null) {
                i6 = 0;
                str5 = "";
                str6 = str5;
            } else {
                i6 = 0;
                str5 = "";
                str6 = str5;
            }
            jSONObject2.put(LoginConstants.IP, str6);
            jSONObject2.put("client_ipv6", str5);
            jSONObject2.put("client_ipv4", com.byazt.by.c.c(str6, i));
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(c(ttVar, i, bmVar));
            jSONObject2.put("adslots", jSONArray2);
            i7 = bmVar.yp;
            if (i7 > 0) {
                jSONObject2.put("load_ad_api", i7);
            }
            com.byazt.by.c.c(jSONObject2, i);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("start2req_time", SystemClock.elapsedRealtime() - rh.n);
            if (rh.tt.get()) {
                i8 = i6;
            } else {
                i8 = 1;
            }
            jSONObject4.put("start_type", i8);
            jSONObject4.put("show_count", com.byazt.ddx.uj.c);
            jSONObject2.put("ads_parameter", jSONObject4);
            c(jSONObject2, bmVar);
            long jCurrentTimeMillis7 = System.currentTimeMillis() / 1000;
            jSONObject2.put("ts", jCurrentTimeMillis7);
            if (ttVar.uj() == null) {
            }
            jSONObject2.put("req_sign", com.byazt.nr.a.tt(strConcat2));
            if (i2 == 4) {
                jCurrentTimeMillis = System.currentTimeMillis();
                jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(gt.tt().c(ttVar.uj())));
                if (gt.tt().tt(ttVar.uj())) {
                    if (7 == ttVar.gt()) {
                        z5 = 1;
                    } else {
                        z5 = i6;
                    }
                    c(z5, jSONObject2, ttVar.uj());
                } else {
                    com.byazt.ukr.yp.c().c(ttVar.uj(), (String) null, (String) null, true);
                }
                qyVar = bmVar.z;
                if (qyVar != null) {
                    qyVar.c("precache_time", System.currentTimeMillis() - jCurrentTimeMillis);
                }
            }
            if (z) {
                jSONObject2.put("ad_sdk_version", p.n);
                return jSONObject2;
            }
            if (i2 == 3) {
                jSONObject2.put("material_keys", nb.c(ttVar));
            }
            if (gt.tt().ri()) {
                jSONObject2.put("feature_data", com.byazt.qw.ve.ve().n());
            }
            if (gt.tt().ge()) {
                jSONObject2.putOpt("feature_data_v2", jSONObjectTt);
            }
            if (bmVar.c != 2) {
                i9 = 1;
            } else {
                i9 = 1;
            }
            if (i9 == 0) {
                jSONObject2.put("load_feature", jSONObjectC2);
            }
            i10 = bmVar.nu;
            if (i10 > 0) {
                jSONObject2.put("second_page_type", i10);
                jSONObject2.put("second_page_origin_req_id", bmVar.rh);
            }
            com.byazt.cl.c.c(jSONObject2);
        }
        return jSONObject2;
    }

    private JSONArray tt(List<com.byazt.nc.a> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.byazt.nc.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().getId());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    private static String tt(com.byazt.dj.tt ttVar) {
        String strVe = ve(ttVar);
        Map<String, Object> mapP = x.m().p();
        if (mapP != null && !mapP.isEmpty()) {
            try {
                JSONArray jSONArray = TextUtils.isEmpty(strVe) ? new JSONArray() : new JSONArray(strVe);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("name") : "";
                    if (!TextUtils.isEmpty(strOptString) && mapP.containsKey(strOptString)) {
                        mapP.remove(strOptString);
                    }
                }
                for (Map.Entry<String, Object> entry : mapP.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", entry.getKey());
                        jSONObject.put("value", entry.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
                return c(jSONArray).toString();
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
        return strVe;
    }

    private static JSONArray tt(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals("0", str)) {
                jSONObject = new JSONObject();
                jSONObject.put("name", "is_shake_ads");
                jSONObject.put("value", "0");
                x.m().tt("0");
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return jSONArray;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(hq hqVar, String str, String str2, final gu.ve veVar, int i, long j) {
        JSONObject jSONObjectC = c(hqVar, str, str2);
        com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
        if (i == 1) {
            nVarTt.c(hqVar.sp());
        } else {
            nVarTt.c(hqVar.c());
        }
        nVarTt.c(jSONObjectC);
        nVarTt.n(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.omf.gr.11
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                veVar.c(602, "time out!");
            }
        }, j);
        nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.13
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (ttVar == null) {
                    veVar.c(603, "response is null!");
                    return;
                }
                if (!ttVar.i()) {
                    veVar.c(ttVar.tt(), ttVar.ve());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(ttVar.n());
                    String strOptString = jSONObject.optString("message");
                    int iOptInt = jSONObject.optInt("status", -1);
                    if (iOptInt != 200) {
                        veVar.c(iOptInt, strOptString);
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        veVar.c(jSONObjectOptJSONObject);
                        return;
                    }
                    veVar.c(606, strOptString + ", data is null!");
                } catch (Throwable th) {
                    veVar.c(605, th.getMessage());
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                veVar.c(601, iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(JSONObject jSONObject, final gu.ve<com.byazt.hm.tt> veVar) {
        String strC = nb.c("/api/ad/union/sdk/apply_coupon/v2", false);
        sv svVar = new sv(com.byazt.hy.n.c().tt().a());
        svVar.c(strC);
        svVar.ve(jSONObject, "coupon_apply");
        svVar.n(new HashMap());
        svVar.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.17
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                gu.ve veVar2 = veVar;
                if (veVar2 != null) {
                    veVar2.c(ttVar);
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                gu.ve veVar2 = veVar;
                if (veVar2 != null) {
                    veVar2.c(601, iOException.getMessage());
                }
            }
        });
    }

    private void c(String str, com.byazt.dj.tt ttVar, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("req_id", str);
            if (ttVar != null) {
                jSONObject.putOpt("slot", ttVar.uj());
            }
            com.byazt.ukr.yp.c().c("b_ad_req", jSONObject, th);
        } catch (Throwable unused) {
        }
    }

    private void c(JSONObject jSONObject, bm bmVar) {
        JSONArray jSONArray;
        if (bmVar == null || (jSONArray = bmVar.f28481a) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    private void c(com.byazt.ete.tt ttVar, long j, long j2, long j3, long j4) {
        if (ttVar == null) {
            return;
        }
        ttVar.c(j);
        ttVar.tt(j3);
        ttVar.ve(j2);
        ttVar.uj(j4);
    }

    private boolean c(String str, bm bmVar) {
        float fUj = com.byazt.by.n.c().uj();
        if (bmVar != null && bmVar.n == 2 && fUj > 0.0f) {
            return ve(str);
        }
        return tt(str);
    }

    @Override // com.byazt.omf.gu
    public void c(final com.byazt.dj.tt ttVar, final bm bmVar, final int i, gu.tt ttVar2) {
        final com.byazt.gk.c cVar = new com.byazt.gk.c(ttVar2);
        cVar.c(i);
        if ((i != 3 || !com.byazt.cc.a.c(ttVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.bwm.n.uj(new com.byazt.bwm.sp("get_ad") { // from class: com.byazt.omf.gr.1
                @Override // java.lang.Runnable
                public void run() {
                    gr.this.uj(ttVar, bmVar, i, cVar);
                }
            });
        } else {
            uj(ttVar, bmVar, i, cVar);
        }
    }

    public com.byazt.wo.tt c(com.byazt.dj.tt ttVar, com.byazt.ete.tt ttVar2, bm bmVar, int i, int i2, gu.tt ttVar3, boolean z) {
        com.byazt.wo.tt ttVarTt;
        com.byazt.zlb.ve.c(ttVar);
        boolean z2 = i2 == 5;
        bmVar.c("buildAdBodyReady", z2);
        JSONObject jSONObjectC = c(ttVar, bmVar, i, false, i2, z);
        bmVar.c("doBuildAdBody", z2);
        if (jSONObjectC == null) {
            ttVar2.c(-9);
            ttVar3.c(-9, sp.c(-9), ttVar2);
            return null;
        }
        String string = jSONObjectC.toString();
        if (i2 == 5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ttVarTt = com.byazt.by.a.c().c(string);
            bmVar.c("encrypt", System.currentTimeMillis() - jCurrentTimeMillis, z2);
        } else {
            ttVarTt = com.byazt.by.a.c().tt(string);
        }
        if (ttVarTt == null) {
            ttVar2.c(-9);
            ttVar3.c(-9, sp.c(-9), ttVar2);
            return null;
        }
        ttVarTt.c(jSONObjectC);
        return ttVarTt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.dj.tt ttVar, bm bmVar, int i, gu.tt ttVar2, String str, int i2) {
        tt(ttVar, bmVar, i, ttVar2, str, i2);
    }

    private boolean c(com.byazt.dj.tt ttVar, com.byazt.ete.tt ttVar2, gu.tt ttVar3, boolean z, bm bmVar, int i, boolean[] zArr) {
        if (ttVar3 == null) {
            return true;
        }
        if (!com.byazt.ogz.i.c()) {
            ttVar2.c(1000);
            ttVar3.c(1000, "广告请求开关已关闭,请联系穿山甲管理员", ttVar2);
            return true;
        }
        if (z) {
            bmVar.c("execGetAdReady", z);
            if (!TextUtils.isEmpty(ttVar.rl()) && bmVar.n <= 0) {
                c(ttVar2, ttVar, ttVar3, bmVar, i);
                com.byazt.ukr.tt.c();
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (c(ttVar.uj(), bmVar)) {
                if (com.byazt.dl.a.c().c(ttVar.uj(), ttVar.or())) {
                    zArr[0] = true;
                    return false;
                }
                ttVar2.c(-8);
                ttVar3.c(-8, sp.c(-8), ttVar2);
                ve.incrementAndGet();
                com.byazt.ukr.tt.c();
                return true;
            }
            bmVar.c("checkCallFreq", System.currentTimeMillis() - jCurrentTimeMillis, z);
        }
        return false;
    }

    private void c(com.byazt.ete.tt ttVar, com.byazt.dj.tt ttVar2, final gu.tt ttVar3, bm bmVar, int i) {
        ttVar.ve(2);
        ttVar.c(ttVar2.rl());
        try {
            boolean z = false;
            JSONObject jSONObjectC = com.byazt.by.a.c(new JSONObject(ttVar2.rl()), false, true);
            if (jSONObjectC == null) {
                c(ttVar3, ttVar);
                return;
            }
            c cVarC = c.c(jSONObjectC, ttVar2, bmVar);
            ttVar.c(cVarC.da);
            uj(cVarC.i);
            int i2 = cVarC.uj;
            if (i2 != 20000) {
                ttVar.c(i2);
                ttVar3.c(cVarC.uj, "reason: " + cVarC.f28881a + "  message: " + cVarC.n, ttVar);
                return;
            }
            com.byazt.ete.c cVar = cVarC.x;
            if (cVar == null) {
                c(ttVar3, ttVar);
                return;
            }
            cVar.c(jSONObjectC);
            List<ic> listTt = cVarC.x.tt();
            if (listTt != null) {
                List<ic> arrayList = new ArrayList<>(listTt);
                for (ic icVar : listTt) {
                    ic icVarC = com.byazt.aas.uj.c(icVar.y(), i, icVar.jl());
                    if (icVarC != null) {
                        arrayList.remove(icVar);
                        icVarC.eo(icVar.em());
                        arrayList.add(icVarC);
                    } else if (icVar.iu()) {
                        final String str = cVarC.sp;
                        if (!TextUtils.isEmpty(str) && bmVar != null) {
                            bmVar.c(str);
                        }
                        final String strUj = ttVar2.uj();
                        final String strC = nb.c(ttVar2);
                        gt.c().ve(ttVar2, bmVar, i, new gu.tt() { // from class: com.byazt.omf.gr.20
                            @Override // com.byazt.omf.gu.tt
                            public void c(int i3, String str2, com.byazt.ete.tt ttVar4) {
                                com.byazt.ukr.yp.c().c(i3, str2, str, strUj, strC);
                                ttVar3.c(i3, str2, ttVar4);
                            }

                            @Override // com.byazt.omf.gu.tt
                            public void c(com.byazt.ete.c cVar2, com.byazt.ete.tt ttVar4) {
                                com.byazt.ukr.yp.c().c(0, "success", str, strUj, strC);
                                ttVar3.c(cVar2, ttVar4);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                } else {
                    cVarC.x.c(arrayList);
                }
            }
            ttVar3.c(cVarC.x, ttVar);
        } catch (Throwable th) {
            com.byazt.nr.m.ve("NetApiImpl", "get ad error: ", th);
            c(ttVar3, ttVar);
        }
    }

    private com.byazt.va.n c(com.byazt.dj.tt ttVar, bm bmVar, int i, gu.tt ttVar2, String str, int i2, com.byazt.ete.tt ttVar3, boolean z) throws JSONException {
        byte[] bytes;
        Map<String, String> mapC;
        com.byazt.wo.tt ttVarC = c(ttVar, ttVar3, bmVar, i, i2, ttVar2, z);
        if (ttVarC == null) {
            return null;
        }
        String strC = nb.c(str, true);
        com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
        String strC2 = com.byazt.tb.ve.c(nVarTt, strC);
        nVarTt.c(strC2);
        if (ttVarC.c() != null) {
            com.byazt.tb.ve.c(ttVarC.c(), 0);
        }
        if (i2 == 5) {
            if (ttVarC.uj() != null) {
                JSONObject jSONObjectUj = ttVarC.uj();
                nVarTt.c(jSONObjectUj);
                bytes = jSONObjectUj.toString().getBytes(StandardCharsets.UTF_8);
                nVarTt.c(false);
            } else {
                if (ttVarC.ve() == null) {
                    return null;
                }
                bytes = ttVarC.ve();
                nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, bytes);
                nVarTt.c(true);
            }
        } else {
            JSONObject jSONObjectUj2 = ttVarC.uj();
            nVarTt.c(jSONObjectUj2);
            bytes = jSONObjectUj2.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z2 = i2 == 5;
        bmVar.c("doHttpReqSignReady", z2);
        com.byazt.lkt.c cVarC = com.byazt.lkt.c.c(true);
        bmVar.c("MSInst", z2);
        Map<String, String> mapC2 = cVarC.c(strC2, bytes);
        bmVar.c("doHttpReqSign", z2);
        if (mapC2 == null) {
            mapC2 = new HashMap<>();
        }
        if (i2 == 5 && (mapC = com.byazt.zlb.ve.c(ttVar.uj())) != null) {
            mapC2.putAll(mapC);
        }
        qp.c(mapC2);
        Map<String, String> mapN = ttVarC.n();
        nVarTt.tt("User-Agent", ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(false));
        if (mapN != null) {
            mapC2.putAll(mapN);
        }
        if (mapC2.size() > 0) {
            for (Map.Entry<String, String> entry : mapC2.entrySet()) {
                nVarTt.tt(entry.getKey(), entry.getValue());
            }
        }
        nVarTt.n(c(bytes, mapN, ttVarC));
        bmVar.c("appendHeader", z2);
        return nVarTt;
    }

    private Map<String, Object> c(byte[] bArr, Map<String, String> map, com.byazt.wo.tt ttVar) {
        HashMap map2 = new HashMap();
        try {
            com.byazt.wo.c cVar = new com.byazt.wo.c();
            cVar.x(System.currentTimeMillis());
            cVar.i(bArr == null ? 0L : bArr.length);
            cVar.ve(ttVar.tt());
            if (map != null) {
                cVar.c(map.get("x-pglcypher"));
            }
            cVar.c(ttVar.c());
            com.byazt.dna.n nVarTt = com.byazt.aas.gr.tt();
            cVar.tt(nVarTt != null ? nVarTt.getSpecificArmorLoadStatus() : 0);
            cVar.c(gt.tt().pl());
            map2.put("load_time_model", cVar);
        } catch (Exception unused) {
        }
        return map2;
    }

    private void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.uj.get() >= 30000) {
            this.uj.set(jCurrentTimeMillis);
            com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.omf.gr.21
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.ogz.x.c((com.byazt.ogz.n) null).uj();
                }
            }, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.va.uj ujVar, IOException iOException, com.byazt.ete.tt ttVar, gu.tt ttVar2) {
        com.byazt.ukr.tt.c();
        if (iOException != null) {
            ttVar.c(602);
            ttVar2.c(602, iOException.getMessage(), ttVar);
            com.byazt.nr.m.c("NetApiImpl", "onFailure: ", 601);
        }
    }

    private void c(Throwable th, com.byazt.ete.tt ttVar, gu.tt ttVar2) {
        if (ttVar2 != null) {
            ttVar.c(4000);
            ttVar2.c(4000, th.getMessage(), ttVar);
            com.byazt.nr.m.ve("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void c(com.byazt.hm.tt ttVar, com.byazt.dj.tt ttVar2, int i, bm bmVar, gu.tt ttVar3, com.byazt.ete.tt ttVar4, com.byazt.va.uj ujVar) {
        JSONObject jSONObject;
        int i2;
        JSONObject jSONObject2;
        com.byazt.ete.tt ttVar5 = ttVar4;
        if (ttVar == null) {
            return;
        }
        if (ttVar.i()) {
            try {
                com.byazt.wo.c cVarC = c(ujVar);
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strN = ttVar.n();
                ttVar5.c(strN);
                com.byazt.zlb.tt ttVar6 = com.byazt.zlb.tt.c;
                if (ttVar6 != null) {
                    ttVar6.uj("NetApiImpl", "response:");
                    com.byazt.zlb.tt.c.uj("NetApiImpl", strN);
                }
                JSONObject jSONObject3 = new JSONObject(strN);
                int iOptInt = jSONObject3.optInt("status_code");
                String strOptString = new JSONObject(ttVar2.rl()).optString("auction_price");
                int i3 = 20000;
                try {
                    if (iOptInt != 20000) {
                        if (iOptInt == 40046) {
                            ttVar5.c(iOptInt);
                            ttVar3.c(40046, sp.c(iOptInt), ttVar5);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("adms");
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject4 = new JSONObject(jSONObjectOptJSONObject.optString(itKeys.next()));
                        jSONObject4.put("auction_price", strOptString);
                        JSONObject jSONObjectC = com.byazt.by.a.c(jSONObject4, false, true);
                        if (jSONObjectC == null) {
                            c(ttVar3, ttVar4);
                            return;
                        }
                        c cVarC2 = c.c(jSONObjectC, ttVar2, bmVar);
                        ttVar5.c(cVarC2.da);
                        int i4 = cVarC2.uj;
                        if (i4 != i3) {
                            ttVar5.c(i4);
                            ttVar3.c(cVarC2.uj, "reason: " + cVarC2.f28881a + "  message: " + cVarC2.n, ttVar5);
                            com.byazt.dl.a.c().c(ttVar2.uj(), cVarC2.uj, cVarC2.f28881a, ttVar2.or());
                            return;
                        }
                        com.byazt.ete.c cVar = cVarC2.x;
                        if (cVar == null) {
                            c(ttVar3, ttVar4);
                            return;
                        }
                        cVar.c(jSONObjectC);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (bmVar != 0) {
                            try {
                                jSONObject = jSONObjectOptJSONObject;
                                i2 = 20000;
                                jSONObject2 = jSONObjectC;
                                c(ttVar4, cVarC.i() - bmVar.x, cVarC2.c, jCurrentTimeMillis - cVarC.i(), jCurrentTimeMillis2 - jCurrentTimeMillis);
                            } catch (Throwable th) {
                                th = th;
                                com.byazt.nr.m.ve("NetApiImpl", "get ad error: ", th);
                                c(ttVar3, ttVar4);
                                return;
                            }
                        } else {
                            jSONObject = jSONObjectOptJSONObject;
                            jSONObject2 = jSONObjectC;
                            i2 = i3;
                        }
                        ttVar3.c(cVarC2.x, ttVar4);
                        com.byazt.rh.tt.c().c(jSONObject2);
                        jSONObjectOptJSONObject = jSONObject;
                        ttVar5 = ttVar4;
                        strOptString = strOptString;
                        i3 = i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            int iTt = ttVar.tt();
            String strVe = ttVar.ve();
            ttVar5.c(iTt);
            ttVar3.c(iTt, strVe, ttVar5);
        }
    }

    private void c(com.byazt.hm.tt ttVar, com.byazt.dj.tt ttVar2, int i, bm bmVar, gu.tt ttVar3, com.byazt.ete.tt ttVar4) {
        if (ttVar != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(ttVar.n()).optJSONArray("ads");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    if (ttVar3 != null) {
                        ttVar3.c(-9, sp.c(-9), ttVar4);
                        return;
                    }
                    return;
                }
                int iLr = gt.tt().lr();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(i2).optJSONObject("creative");
                    if (jSONObjectOptJSONObject != null) {
                        JSONObject jSONObjectC = com.byazt.by.a.c(new JSONObject(jSONObjectOptJSONObject.optString("adm")), false, true);
                        if (jSONObjectC == null && ttVar3 != null) {
                            ttVar3.c(-9, sp.c(-9), ttVar4);
                        } else {
                            c cVarC = c.c(jSONObjectC, ttVar2, bmVar);
                            com.byazt.aas.uj.c(cVarC.x, i, iLr, ttVar2.or());
                            if (ttVar3 != null) {
                                ttVar3.c(cVarC.x, ttVar4);
                            }
                        }
                    } else if (ttVar3 != null) {
                        ttVar3.c(-9, sp.c(-9), ttVar4);
                    }
                }
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                if (ttVar3 != null) {
                    ttVar3.c(-9, sp.c(-9), ttVar4);
                }
            }
        }
    }

    private com.byazt.wo.c c(com.byazt.va.uj ujVar) {
        try {
            Object obj = ujVar.ve().get("load_time_model");
            if (obj instanceof com.byazt.wo.c) {
                com.byazt.wo.c cVar = (com.byazt.wo.c) obj;
                cVar.ve(true);
                return cVar;
            }
        } catch (Throwable unused) {
        }
        return new com.byazt.wo.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar, com.byazt.ete.tt ttVar2, gu.tt ttVar3, com.byazt.dj.tt ttVar4, bm bmVar, int i, int i2) {
        String str;
        long length;
        final JSONObject jSONObjectC;
        final boolean zBooleanValue;
        JSONObject jSONObject;
        com.byazt.wo.c cVar;
        long length2;
        if (ttVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!ttVar.i()) {
            int iTt = ttVar.tt();
            String strVe = ttVar.ve();
            ttVar2.c(iTt);
            ttVar3.c(iTt, strVe, ttVar2);
            com.byazt.dl.a.c().c(ttVar4 != null ? ttVar4.uj() : "", iTt, 0, ttVar4.or());
            com.byazt.ktv.tt.tt();
            return;
        }
        if (i2 == 1) {
            c(ttVar, ttVar4, i, bmVar, ttVar3, ttVar2);
            return;
        }
        if (i2 == 3) {
            c(ttVar, ttVar4, i, bmVar, ttVar3, ttVar2, ujVar);
            return;
        }
        com.byazt.wo.c cVarC = c(ujVar);
        cVarC.a(jCurrentTimeMillis);
        com.byazt.ukr.tt.c();
        try {
            final String strN = ttVar.n();
            if (i2 == 5) {
                byte[] bArrSl = ttVar.sl();
                Pair<Boolean, JSONObject> pairC = com.byazt.by.a.c(ttVar, "get_ads", true);
                jSONObjectC = (JSONObject) pairC.second;
                zBooleanValue = ((Boolean) pairC.first).booleanValue();
                if (zBooleanValue) {
                    length2 = TextUtils.isEmpty(strN) ? 0L : strN.getBytes(StandardCharsets.UTF_8).length;
                    ttVar2.c(strN);
                } else {
                    length2 = bArrSl == null ? 0L : bArrSl.length;
                }
                length = length2;
                if (com.byazt.zlb.tt.c != null && jSONObjectC != null) {
                    com.byazt.bwm.n.tt(new com.byazt.bwm.sp("logAdapter") { // from class: com.byazt.omf.gr.24
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj;
                            try {
                                String string = "";
                                if (zBooleanValue) {
                                    string = strN;
                                } else {
                                    Pair<Integer, JSONObject> pairC2 = com.byazt.by.a.c().c(jSONObjectC.toString(), false);
                                    if (pairC2 != null && (obj = pairC2.second) != null) {
                                        string = ((JSONObject) obj).toString();
                                    }
                                }
                                if (com.byazt.zlb.tt.c == null || TextUtils.isEmpty(string)) {
                                    return;
                                }
                                com.byazt.zlb.tt.c.uj("NetApiImpl", "response:");
                                com.byazt.zlb.tt.c.uj("NetApiImpl", string);
                            } catch (Exception e) {
                                com.byazt.nr.m.ve(e.getMessage());
                            }
                        }
                    });
                }
            } else {
                ttVar2.c(strN);
                com.byazt.zlb.tt ttVar5 = com.byazt.zlb.tt.c;
                if (ttVar5 != null) {
                    ttVar5.uj("NetApiImpl", "response:");
                    com.byazt.zlb.tt.c.uj("NetApiImpl", strN);
                }
                JSONObject jSONObject2 = new JSONObject(strN);
                length = TextUtils.isEmpty(strN) ? 0L : strN.getBytes(StandardCharsets.UTF_8).length;
                jSONObjectC = com.byazt.by.a.c(jSONObject2, false, true);
                zBooleanValue = false;
            }
            JSONObject jSONObject3 = jSONObjectC;
            cVarC.sp(length);
            if (jSONObject3 == null) {
                c(ttVar3, ttVar2);
                return;
            }
            com.byazt.tb.ve.tt(jSONObject3, 0);
            c cVarC2 = c.c(jSONObject3, ttVar4, bmVar);
            ttVar2.c(cVarC2.da);
            uj(cVarC2.i);
            int i3 = cVarC2.uj;
            if (i3 != 20000) {
                ttVar2.c(i3);
                ttVar2.tt(cVarC2.f28881a);
                ttVar3.c(cVarC2.uj, "reason: " + cVarC2.f28881a + "  message: " + cVarC2.n, ttVar2);
                com.byazt.dl.a.c().c(ttVar4 != null ? ttVar4.uj() : "", cVarC2.uj, cVarC2.f28881a, ttVar4.or());
                return;
            }
            com.byazt.ete.c cVar2 = cVarC2.x;
            if (cVar2 == null) {
                c(ttVar3, ttVar2);
                return;
            }
            cVar2.c(jSONObject3);
            cVarC.tt(System.currentTimeMillis());
            if (bmVar != null) {
                cVar = cVarC;
                jSONObject = jSONObject3;
                str = "NetApiImpl";
                try {
                    c(ttVar2, cVarC.i() - bmVar.x, cVarC2.c, cVarC.a() - cVarC.i(), cVarC.tt() - cVarC.a());
                } catch (Throwable th) {
                    th = th;
                    com.byazt.nr.m.ve(str, "get ad error: ", th);
                    c(ttVar3, ttVar2);
                    return;
                }
            } else {
                jSONObject = jSONObject3;
                cVar = cVarC;
                str = "NetApiImpl";
            }
            ttVar3.c(cVarC2.x, ttVar2);
            for (ic icVar : cVarC2.x.tt()) {
                if (bmVar != null) {
                    icVar.md(bmVar.tt());
                    icVar.bn().c(bmVar.c);
                    icVar.bn().tt(1);
                }
                if (com.byazt.ic.c.c(icVar) || com.byazt.ic.c.uj(icVar)) {
                    com.byazt.cph.tt.c().c(this.c, com.byazt.ic.c.i(icVar));
                }
            }
            if (cVar.t() && cVarC2.x.tt() != null && !cVarC2.x.tt().isEmpty()) {
                ic icVar2 = cVarC2.x.tt().get(r10);
                com.byazt.omf.uj.c().c(icVar2);
                String strTt = nb.tt(i);
                com.byazt.wo.c cVar3 = cVar;
                cVar3.tt(i2 != 5);
                cVar3.c(i2 != 5 || zBooleanValue);
                cVar3.n(ttVar.a());
                cVar3.uj(ttVar.sp());
                cVar3.c(cVarC2.c);
                com.byazt.gqp.sl slVarT = ttVar.t();
                if (slVarT != null) {
                    cVar3.da(slVarT.c);
                    cVar3.sl(slVarT.tt);
                    cVar3.t(slVarT.ve);
                    cVar3.u(slVarT.uj);
                    cVar3.yp(slVarT.n);
                }
                c(bmVar, icVar2, strTt, cVar3);
            }
            com.byazt.rh.tt.c().c(jSONObject);
            com.byazt.ktv.tt.tt();
        } catch (Throwable th2) {
            th = th2;
            str = "NetApiImpl";
        }
    }

    private void c(bm bmVar, ic icVar, String str, com.byazt.wo.c cVar) {
        long jTt;
        long j;
        if (gt.tt().hj() && cVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (bmVar != null) {
                try {
                    if (bmVar.x > 0) {
                        jSONObject.put("client_start_time", cVar.i() - bmVar.x);
                        jTt = cVar.tt() - bmVar.x;
                    } else {
                        jTt = 0;
                    }
                    if (bmVar.i > 0) {
                        jSONObject.put("real_user_duration", cVar.tt() - bmVar.i);
                        jSONObject.put("switch_st1_time", bmVar.x - bmVar.i);
                    }
                    j = jTt;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j = 0;
            }
            jSONObject.put("net_send_time", cVar.n() - cVar.i());
            jSONObject.put("net_rcv_time", cVar.uj() - cVar.n());
            jSONObject.put("net_callback_time", cVar.a() - cVar.uj());
            jSONObject.put("network_time", cVar.a() - cVar.i());
            jSONObject.put("sever_time", cVar.c());
            jSONObject.put("client_end_time", cVar.tt() - cVar.a());
            if (cVar.da() > 0) {
                jSONObject.put("req_body_length", cVar.da());
            }
            if (cVar.x() > 0) {
                jSONObject.put("res_body_length", cVar.x());
            }
            if (!TextUtils.isEmpty(cVar.sl())) {
                jSONObject.put("x-pglcypher", cVar.sl());
            }
            jSONObject.put("cypher_v", cVar.rh());
            jSONObject.put("armor_s", cVar.my());
            long jVe = cVar.ve();
            if (jVe > 0) {
                jSONObject.put("raw_req_length", jVe);
            }
            int i = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.byazt.by.ve.c().a());
            if (!cVar.sp()) {
                i = 2;
            }
            jSONObject.put("has_base64", i);
            jSONObject.put("req_build_opt", com.byazt.by.ve.c().sp());
            jSONObject.put("is_boost", com.byazt.xo.c.n());
            jSONObject.put("opt_config", String.valueOf(gt.tt().bw()));
            jSONObject.put("report_index", tt.getAndIncrement());
            if (cVar.m() > 0) {
                jSONObject.put("net_whqueue", cVar.yp() - cVar.u());
                jSONObject.put("net_wtqueue", cVar.z() - cVar.yp());
                jSONObject.put("net_oconn", cVar.nu() - cVar.m());
                jSONObject.put("net_bconn", cVar.m() - cVar.z());
            }
            try {
                JSONObject jSONObjectC = bmVar.z.c(-1L);
                Iterator<String> itKeys = jSONObjectC.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectC.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.byazt.ddx.uj.c(icVar, str, "load_ad_time", j, jSONObject);
        }
    }

    @Override // com.byazt.omf.gu
    public void c(com.byazt.vo.tt ttVar, List<com.byazt.nc.a> list) {
        JSONObject jSONObjectTt;
        if (com.byazt.ogz.i.c() && (jSONObjectTt = tt(ttVar, list)) != null) {
            sv svVar = new sv(com.byazt.hy.n.c().tt().a());
            svVar.c(nb.sl("/api/ad/union/dislike_event/"));
            svVar.ve(jSONObjectTt, com.byazt.dyf.tt.AD_TAG_DISLIKE);
            svVar.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.25
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar2) {
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                }
            });
        }
    }

    private String c(List<com.byazt.nc.a> list) {
        if (list.get(0).getId().equals("0:00")) {
            return list.get(0).getName();
        }
        return null;
    }

    public static void c(gu.tt ttVar, com.byazt.ete.tt ttVar2) {
        ttVar2.c(-1);
        ttVar.c(-1, sp.c(-1), ttVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(gu.n nVar) {
        nVar.c(-1, sp.c(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(gu.uj ujVar) {
        ujVar.c(-1, sp.c(-1));
    }

    private JSONObject c(com.byazt.dj.tt ttVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject, "keywords", x.m().gr());
            jSONObject.put("protection_of_minors", x.m().aw());
            if (!com.byazt.by.uj.c().sp(i)) {
                com.byazt.qh.tt.tt(this.c, jSONObject);
            }
            String strTt = tt(ttVar);
            if (!TextUtils.equals("[]", strTt)) {
                c(jSONObject, "data", strTt);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray c(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("name", "can_use_sensor");
                jSONObject.put("value", str);
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                return jSONArray;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return jSONArray;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONArray.put(jSONArray.length(), jSONObject);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(0, jSONObject);
        return jSONArray2;
    }

    private static String c(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            JSONArray jSONArrayTt = tt(c((JSONArray) null, str2), str2);
            if (jSONArrayTt == null) {
                return null;
            }
            return jSONArrayTt.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(jSONObjectOptJSONObject.optString("name"), "is_shake_ads")) {
                    if (TextUtils.equals("0", str2)) {
                        jSONObjectOptJSONObject.put("value", "0");
                        x.m().tt("0");
                    } else {
                        x.m().tt(jSONObjectOptJSONObject.optString("value"));
                    }
                    z = true;
                }
            }
            if (!z) {
                jSONArray = tt(jSONArray, str2);
            }
            JSONArray jSONArrayC = c(jSONArray, str2);
            return jSONArrayC == null ? str : jSONArrayC.toString();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return str;
        }
    }

    private static JSONArray c(JSONArray jSONArray) throws JSONException {
        if (p.x() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    String strOptString = jSONObject2.optString("name", null);
                    if (!"device_id".equals(strOptString)) {
                        if ("game_adapter_did".equals(strOptString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put("name", "device_id");
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject c(com.byazt.dj.tt ttVar, int i, bm bmVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", ttVar.uj());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, ttVar.my());
            jSONObject.put("show_seq", ttVar.rh());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", x.m().pu());
            jSONObject.put("download_type", 0);
            jSONObject.put("show_time", com.byazt.qw.ve.ve().c(ttVar.uj()));
            JSONObject jSONObjectC = com.byazt.vvt.ve.c(i, ttVar.or());
            if (jSONObjectC != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObjectC.toString());
                    com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c(i);
                    com.byazt.ete.x.n nVarNu = veVarC != null ? veVarC.nu() : null;
                    if (nVarNu != null && nVarNu.tt() && nVarNu.ve() > 0) {
                        long jC = com.byazt.wi.tt.c().c(i, ttVar.uj());
                        if (jC > 0) {
                            jSONObject2.put("dynamic_tmax", jC);
                        }
                        jSONObject2.put("dynamic_tmax_type", nVarNu.n());
                    }
                    jSONObjectC = jSONObject2;
                } catch (Throwable unused) {
                }
                jSONObject.put("ca_interval_info", jSONObjectC);
            }
            Object objTt = com.byazt.vvt.ve.tt(i, ttVar.uj());
            if (objTt != null) {
                jSONObject.put("client_cache_info", objTt);
            }
            if (!TextUtils.isEmpty(ttVar.c()) || !TextUtils.isEmpty(ttVar.tt()) || !TextUtils.isEmpty(ttVar.ve()) || com.byazt.zlb.ve.c()) {
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(ttVar.c())) {
                    jSONObject3.put(MediationConstant.EXTRA_ADID, ttVar.c());
                }
                if (!TextUtils.isEmpty(ttVar.tt())) {
                    jSONObject3.put("creative_id", ttVar.tt());
                }
                if (ttVar.ve() != null) {
                    jSONObject3.put(LoginConstants.EXT, ttVar.ve());
                }
                com.byazt.zlb.ve.c(jSONObject3, ttVar.uj());
                jSONObject.put("preview_ads", jSONObject3);
            }
            if (com.byazt.zlb.ve.c() && x.m().tx()) {
                com.byazt.zlb.ve.tt(jSONObject, ttVar.uj());
            }
            x.ve veVarIu = x.m().iu();
            if (veVarIu != null && nb.x().equals("com.pangolin_demo.toutiao")) {
                veVarIu.c(jSONObject);
            }
            int iT = 1;
            if (i == 3 || i == 4) {
                if (bmVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("publisher_timeout_control", bmVar.da);
                    jSONObject4.put("time_out_control", bmVar.sl);
                    jSONObject4.put("time_out", bmVar.t);
                    jSONObject.put("tmax", jSONObject4);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (bmVar != null) {
                jSONObject.put("render_method", bmVar.sp);
                int i2 = bmVar.sp;
                if (i2 == 1) {
                    if (uj(ttVar)) {
                        c(i, jSONObject);
                    } else {
                        c(jSONObject, "accepted_size", ttVar.a(), ttVar.sp());
                    }
                } else if (i2 == 2) {
                    if (ttVar.x() > 0.0f && ttVar.i() > 0.0f) {
                        c(jSONObject, "accepted_size", pf.ve(this.c, ttVar.x()), pf.ve(this.c, ttVar.i()));
                    } else if (uj(ttVar)) {
                        c(i, jSONObject);
                    } else {
                        c(jSONObject, "accepted_size", ttVar.a(), ttVar.sp());
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                c(jSONObject, "accepted_size", ttVar.a(), ttVar.sp());
            }
            jSONObject.put("ptpl_ids", com.byazt.by.tt.c().c(ttVar.uj(), i));
            jSONObject.put("ptpl_ids_v3", com.byazt.by.tt.c().tt(ttVar.uj(), i));
            if (i == 5 || i == 9) {
                String string = com.byazt.vif.uj.c(x.m().rl(), "ad_show_real_size").getString(ttVar.uj(), null);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("real_size", new JSONObject(string));
                }
            }
            jSONObject.put("pos", nb.n(i));
            jSONObject.put("is_support_dpl", ttVar.da());
            jSONObject.put("if_support_render_control", ttVar.sl() ? 1 : 0);
            jSONObject.put("support_icon_style", (p.uj < 5900 || !ttVar.yv()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", gt.tt().x(nb.tt(ttVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (bmVar != null && (obj = bmVar.u) != null) {
                jSONObject.put("session_params", obj);
            }
            int iT2 = ttVar.t();
            if (i == 7) {
                if (com.byazt.ete.or.c()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.byazt.ete.or.n());
                }
                if (com.byazt.ete.or.ve()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.byazt.ete.or.sp());
                }
                if (com.byazt.ete.or.uj()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.byazt.ete.or.sp());
                }
                iT2 = 1;
            }
            if (i == 8) {
                boolean z = gt.tt().z(ttVar.uj());
                boolean zC = com.byazt.dl.uj.c(ttVar.uj());
                if (!z) {
                    jSONObject.put("refresh_control", 0);
                } else if (zC) {
                    jSONObject.put("refresh_control", 0);
                    com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.omf.gr.2
                        @Override // com.byazt.ee.c
                        public com.byazt.qal.c c() throws Exception {
                            JSONObject jSONObject5 = new JSONObject();
                            try {
                                jSONObject5.put("cid", "");
                            } catch (JSONException e) {
                                com.byazt.nr.m.c(e);
                            }
                            return com.byazt.qal.tt.tt().c("refresh_max").tt(jSONObject5.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", gt.tt().ly());
                }
                if (com.byazt.ete.or.tt()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.byazt.ete.or.a());
                }
            } else {
                iT = iT2;
            }
            if (bmVar != null && bmVar.f28481a != null) {
                iT = ttVar.t();
            }
            jSONObject.put("ad_count", iT);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    private void c(int i, JSONObject jSONObject) {
        if (tt(i)) {
            c(jSONObject, "accepted_size", pf.uj(this.c), pf.n(this.c));
        } else {
            c(jSONObject, "accepted_size", 640, 320);
        }
    }

    private void c(JSONObject jSONObject, String str, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i > 0 && i2 > 0) {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
            } else {
                jSONObject2.put("width", 640);
                jSONObject2.put("height", 320);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, String str, float f, float f2) {
        if (f <= 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f);
            jSONObject2.put("height", (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.omf.gu
    public void c(JSONObject jSONObject, final gu.n nVar) {
        if (!com.byazt.ogz.i.c()) {
            if (nVar != null) {
                nVar.c(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || nVar == null) {
                return;
            }
            sv svVar = new sv(com.byazt.hy.n.c().tt().a());
            svVar.c(nb.sl("/api/ad/union/sdk/reward_video/reward/"));
            svVar.ve(jSONObject, "verify");
            svVar.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.3
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    if (ttVar != null) {
                        if (!ttVar.i()) {
                            String strC = sp.c(-2);
                            int iTt = ttVar.tt();
                            if (!ttVar.i() && !TextUtils.isEmpty(ttVar.ve())) {
                                strC = ttVar.ve();
                            }
                            nVar.c(iTt, strC);
                            return;
                        }
                        try {
                            Object obj = com.byazt.by.a.c(ttVar, "verify", false).second;
                            uj ujVarC = uj.c(obj != null ? (JSONObject) obj : new JSONObject(ttVar.n()));
                            int i = ujVarC.c;
                            if (i != 20000) {
                                nVar.c(i, sp.c(i));
                                return;
                            } else if (ujVarC.ve == null) {
                                gr.this.c(nVar);
                                return;
                            } else {
                                nVar.c(ujVarC);
                                return;
                            }
                        } catch (Exception e) {
                            com.byazt.nr.m.c(e);
                        }
                    }
                    gr.this.c(nVar);
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    nVar.c(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.byazt.omf.gu
    public void c(JSONObject jSONObject, final gu.uj ujVar) {
        if (!com.byazt.ogz.i.c()) {
            if (ujVar != null) {
                ujVar.c(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || ujVar == null) {
                return;
            }
            JSONObject jSONObjectC = com.byazt.nr.c.c(jSONObject);
            com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
            nVarTt.c(nb.sl("/api/ad/union/sdk/reward_video/live_room/reward"));
            nVarTt.ve(jSONObjectC.toString());
            nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.4
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar2, com.byazt.hm.tt ttVar) {
                    if (ttVar != null) {
                        if (!ttVar.i() || TextUtils.isEmpty(ttVar.n())) {
                            String strC = sp.c(-2);
                            int iTt = ttVar.tt();
                            if (!ttVar.i() && !TextUtils.isEmpty(ttVar.ve())) {
                                strC = ttVar.ve();
                            }
                            ujVar.c(iTt, strC);
                            return;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(ttVar.n());
                            String strVe = jSONObject2.optInt("cypher", -1) == 3 ? com.byazt.nr.c.ve(jSONObject2.optString("message")) : null;
                            if (!TextUtils.isEmpty(strVe)) {
                                try {
                                    jSONObject2 = new JSONObject(strVe);
                                } catch (Throwable unused) {
                                }
                            }
                            ve veVarC = ve.c(jSONObject2);
                            int i = veVarC.c;
                            if (i != 20000) {
                                ujVar.c(i, sp.c(i));
                                return;
                            } else if (veVarC.ve == null) {
                                gr.this.c(ujVar);
                                return;
                            } else {
                                ujVar.c(veVarC);
                                return;
                            }
                        } catch (JSONException e) {
                            com.byazt.nr.m.c(e);
                        }
                    }
                    gr.this.c(ujVar);
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar2, IOException iOException) {
                    ujVar.c(-2, iOException.getMessage());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00e2 A[PHI: r1
      0x00e2: PHI (r1v9 java.lang.String) = (r1v8 java.lang.String), (r1v11 java.lang.String) binds: [B:31:0x00c9, B:36:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.omf.gu
    public String c(com.byazt.dj.tt ttVar, boolean z, int i) {
        int iGt;
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        bm bmVar = new bm();
        String strTt = bmVar.tt();
        c(ttVar, strTt);
        qy qyVar = bmVar.z;
        if (3 == ttVar.gt()) {
            bmVar.x = System.currentTimeMillis();
            bmVar.sp = 2;
        }
        if (z) {
            bmVar.sp = 2;
        }
        if (1 == ttVar.m() || 2 == ttVar.m()) {
            bmVar.sp = 2;
        }
        if (bmVar.sp != 2 && gt.tt().i(ttVar.uj())) {
            bmVar.sp = 2;
        }
        if (ttVar.gt() > 0) {
            iGt = ttVar.gt();
        } else {
            iGt = i > 0 ? i : 0;
        }
        JSONObject jSONObjectC = c(ttVar, bmVar, iGt, true, 4, false, strTt);
        qyVar.tt("adbody_time");
        c(ttVar, bmVar, iGt);
        qyVar.tt("prefetch_time");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("User-Agent", ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(false));
            qyVar.tt("request_headers_time");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", jSONObjectC);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        Pair<Integer, JSONObject> pairC = com.byazt.by.a.c().c(jSONObject.toString(), true);
        qyVar.tt("encry_time");
        try {
            com.byazt.ukr.yp.c().c(i, qyVar);
        } catch (Throwable unused) {
        }
        String strOptString = "";
        if (pairC == null) {
            iIntValue = 3;
        } else {
            Object obj = pairC.second;
            strOptString = obj != null ? ((JSONObject) obj).optString("message") : "";
            Object obj2 = pairC.first;
            if (obj2 != null) {
                iIntValue = ((Integer) obj2).intValue();
            } else {
                iIntValue = 3;
            }
        }
        if (iIntValue != 3) {
            return "0000000004" + strOptString;
        }
        return "0000000003" + strOptString;
    }

    private void c(final com.byazt.dj.tt ttVar, String str) {
        String string = UUID.randomUUID().toString();
        com.byazt.lh.tt ttVar2 = (com.byazt.lh.tt) com.byazt.ip.n.c(0);
        ttVar2.tt(string, ttVar.or());
        ttVar2.c(string, new com.byazt.ky.ve());
        ttVar2.c(str, string);
        ttVar2.c(string, new com.byazt.ip.uj.c() { // from class: com.byazt.omf.gr.5
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar3) {
                com.byazt.dj.tt ttVar4;
                if (!(ttVar3 instanceof com.byazt.ha.tt) || (ttVar4 = ttVar) == null) {
                    return;
                }
                com.byazt.ha.tt ttVar5 = (com.byazt.ha.tt) ttVar3;
                ttVar5.c = ttVar4;
                ttVar5.x = ttVar4.uj();
                ttVar5.sp = ttVar.gt();
            }
        });
        ttVar2.c(string, com.byazt.hi.tt.STARTED);
    }

    private boolean c(com.byazt.dj.tt ttVar, bm bmVar, int i) {
        boolean zC = gt.tt().c(ttVar.uj());
        if (zC) {
            n(ttVar, bmVar, i, new gu.tt() { // from class: com.byazt.omf.gr.6
                @Override // com.byazt.omf.gu.tt
                public void c(int i2, String str, com.byazt.ete.tt ttVar2) {
                    com.byazt.ukr.yp.c().c(i2);
                }

                @Override // com.byazt.omf.gu.tt
                public void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar2) {
                    com.byazt.ukr.yp.c().c(0);
                }
            });
        }
        return zC;
    }

    private void c(boolean z, JSONObject jSONObject, String str) throws Exception {
        String strC = com.byazt.lvl.c.c().c(z, str);
        String strOptString = "0";
        String str2 = null;
        if (strC != null && !TextUtils.isEmpty(strC)) {
            if (TextUtils.equals(strC, "0")) {
                str2 = "0";
            } else if (TextUtils.equals(strC, "1")) {
                str2 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(strC);
                jSONObject.putOpt("cache_info", jSONObject2);
                strOptString = jSONObject2.optString("req_id");
            }
        }
        com.byazt.ukr.yp.c().c(str, strOptString, str2, false);
    }

    @Override // com.byazt.omf.gu
    public String c(com.byazt.dj.tt ttVar) {
        return c(ttVar, false, -1);
    }

    @Override // com.byazt.omf.gu
    public void c(String str, String str2, final gu.c cVar) {
        if (!com.byazt.ogz.i.c()) {
            if (cVar != null) {
                cVar.c(false, -1L, 0L);
                return;
            }
            return;
        }
        if (str == null || str2 == null || cVar == null) {
            return;
        }
        JSONObject jSONObjectC = com.byazt.dbo.uj.c(str, str2);
        sv svVar = new sv(com.byazt.hy.n.c().tt().a());
        String strSl = nb.sl("/api/ad/union/sdk/material/check/");
        try {
            if (TextUtils.isEmpty(new URL(strSl).getQuery())) {
                strSl = strSl + "?abort_aes=1";
            } else {
                strSl = strSl + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        svVar.c(strSl);
        svVar.ve(jSONObjectC, "check_ad");
        svVar.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.7
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                if (ttVar != null) {
                    long j = -1;
                    if (!ttVar.i()) {
                        cVar.c(false, ttVar.tt() != 0 ? ttVar.tt() : -1L, ttVar.da());
                        return;
                    }
                    boolean z = false;
                    if (ttVar.n() != null) {
                        try {
                            tt ttVarC = tt.c(new JSONObject(ttVar.n()));
                            j = ttVarC.c;
                            z = ttVarC.tt;
                        } catch (JSONException e2) {
                            com.byazt.nr.m.c(e2);
                        }
                    }
                    cVar.c(z, j, ttVar.da());
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                cVar.c(false, 0L, 0L);
            }
        });
    }

    @Override // com.byazt.omf.gu
    public void c(JSONObject jSONObject, final com.byazt.dbo.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sv svVar = new sv(com.byazt.hy.n.c().tt().a());
        String strSl = nb.sl("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(strSl).getQuery())) {
                strSl = strSl + "?abort_aes=1";
            } else {
                strSl = strSl + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        svVar.c(strSl);
        svVar.ve(jSONObject, "checkAndCorrectAd");
        svVar.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.8
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar2) {
                long j;
                if (ttVar2 != null) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (ttVar2.i()) {
                        try {
                            Object obj = com.byazt.by.a.c(ttVar2, "checkAndCorrectAd", false).second;
                            com.byazt.dbo.n nVarC = null;
                            JSONObject jSONObject2 = obj != null ? (JSONObject) obj : null;
                            if (jSONObject2 != null) {
                                try {
                                    nVarC = com.byazt.dbo.n.c(jSONObject2);
                                    j = nVarC != null ? nVarC.c : -1L;
                                } catch (Exception e2) {
                                    com.byazt.nr.m.c(e2);
                                    j = -1;
                                }
                            } else {
                                j = -1;
                            }
                            ttVar.c(nVarC, j, jCurrentTimeMillis2);
                            return;
                        } catch (Exception unused) {
                        }
                    }
                    ttVar.c(null, ttVar2.tt() != 0 ? ttVar2.tt() : -1L, jCurrentTimeMillis2);
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                ttVar.c(null, -1L, 0L);
            }
        });
    }

    @Override // com.byazt.omf.gu
    public com.byazt.ku.c c(int i) {
        String strIs;
        com.byazt.ku.c cVarUj = null;
        if (!com.byazt.ogz.i.c()) {
            return null;
        }
        if (i == 2) {
            strIs = gt.tt().jt();
        } else {
            strIs = gt.tt().is();
        }
        if (TextUtils.isEmpty(strIs)) {
            return null;
        }
        com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
        veVarVe.c(qp.tt(strIs));
        com.byazt.hm.tt ttVarC = veVarVe.c();
        if (ttVarC != null) {
            try {
                if (ttVarC.i()) {
                    if (i == 2) {
                        cVarUj = com.byazt.seg.tt.n(ttVarC.n());
                    } else {
                        cVarUj = com.byazt.ku.c.uj(ttVarC.n());
                    }
                }
            } catch (Exception unused) {
            }
        }
        return cVarUj;
    }

    @Override // com.byazt.omf.gu
    public com.byazt.ete.uj c(final ic icVar, String str) {
        String strSy;
        String strP;
        if (icVar != null) {
            strSy = icVar.sy();
            strP = nb.p(icVar);
        } else {
            strSy = null;
            strP = null;
        }
        com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
        veVarVe.c("https://" + gt.tt().nl() + "/customer/api/app/pkg_info");
        veVarVe.c("convert_id", strSy);
        veVarVe.c("package_name", strP);
        veVarVe.c("download_url", com.byazt.bzd.i.tt(str));
        String str2 = strSy + LoginConstants.UNDER_LINE + strP + LoginConstants.UNDER_LINE + str;
        com.byazt.ete.uj ujVarC = com.byazt.yih.c.c(str2);
        if (ujVarC != null) {
            return ujVarC;
        }
        final com.byazt.hm.tt[] ttVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.9
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                ttVarArr[0] = ttVar;
                countDownLatch.countDown();
            }

            @Override // com.byazt.mh.c
            public void c(final com.byazt.va.uj ujVar, final IOException iOException) {
                countDownLatch.countDown();
                com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.omf.gr.9.1
                    @Override // com.byazt.ee.c
                    public com.byazt.qal.c c() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        com.byazt.va.uj ujVar2 = ujVar;
                        if (ujVar2 != null) {
                            jSONObject.putOpt("net_extra", ujVar2.uj());
                        }
                        IOException iOException2 = iOException;
                        if (iOException2 != null) {
                            jSONObject.putOpt("io_error", iOException2.getMessage());
                        }
                        com.byazt.qal.tt<com.byazt.qal.tt> ttVarTt = com.byazt.qal.tt.tt();
                        ic icVar2 = icVar;
                        return ttVarTt.x(icVar2 != null ? icVar2.w_() : "").c("pkg_info_failed").tt(jSONObject.toString());
                    }
                }, "pkg_info_failed");
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.byazt.nr.m.c(e);
        }
        try {
            com.byazt.hm.tt ttVar = ttVarArr[0];
            if (ttVar != null && ttVar.i() && !TextUtils.isEmpty(ttVarArr[0].n()) && new JSONObject(ttVarArr[0].n()).optInt("code", -1) == 0) {
                com.byazt.ete.uj ujVar = new com.byazt.ete.uj(new JSONObject(ttVarArr[0].n()));
                com.byazt.yih.c.c(str2, ujVar);
                return ujVar;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.byazt.omf.gu
    public void c(final hq hqVar, final String str, final String str2, final gu.ve veVar, final int i, final long j) {
        if (veVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("get_wlink") { // from class: com.byazt.omf.gr.10
                @Override // java.lang.Runnable
                public void run() {
                    gr.this.tt(hqVar, str, str2, veVar, i, j);
                }
            });
        } else {
            tt(hqVar, str, str2, veVar, i, j);
        }
    }

    private JSONObject c(hq hqVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", hqVar.ve());
            jSONObject.put("site_id", hqVar.uj());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.byazt.omf.gu
    public void c(String str) {
        n(str);
    }

    @Override // com.byazt.omf.gu
    public void c(final JSONObject jSONObject, final gu.ve<com.byazt.hm.tt> veVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.bwm.n.c().execute(new Runnable() { // from class: com.byazt.omf.gr.14
                @Override // java.lang.Runnable
                public void run() {
                    gr.this.tt(jSONObject, (gu.ve<com.byazt.hm.tt>) veVar);
                }
            });
        } else {
            tt(jSONObject, veVar);
        }
    }

    @Override // com.byazt.omf.gu
    public void c(final Function<SparseArray<Object>, Object> function) {
        com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
        nVarTt.c("https://" + x.m().v() + "/ad_union_qa/sdk/query_config_list");
        nVarTt.tt("x-pglcypher", "4");
        nVarTt.tt("x-ad-sdk-version", p.n);
        nVarTt.tt("x-plugin-version", "7.6.1.1");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", x.m().rl());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", p.n);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
        } catch (Throwable unused) {
        }
        byte[] bArrC = com.byazt.aas.da.c(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        final com.byazt.dna.n nVarTt2 = com.byazt.aas.gr.tt();
        if (nVarTt2 == null) {
            c(function, -4, "armor service init fail");
        } else {
            nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, nVarTt2.encrypt(bArrC));
            nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.15
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    Function function2 = function;
                    if (function2 == null || ttVar == null) {
                        gr.this.c((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                        return;
                    }
                    String strTt = com.byazt.aas.da.tt((TextUtils.equals(ttVar.uj().get(e.f), OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE) || TextUtils.equals(ttVar.uj().get("x-pglcypher"), "4")) ? nVarTt2.decrypt(ttVar.sl()) : ttVar.n().getBytes());
                    if (TextUtils.isEmpty(strTt)) {
                        gr.this.c((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(strTt);
                        int iOptInt = jSONObject2.optInt("code", -1);
                        String strOptString = jSONObject2.optString("message");
                        if (iOptInt != 0) {
                            gr.this.c((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                            return;
                        }
                        String strOptString2 = jSONObject2.optString("data");
                        if (TextUtils.isEmpty(strOptString2)) {
                            gr.this.c((Function<SparseArray<Object>, Object>) function, iOptInt, "response data is empty");
                        } else {
                            gr.this.c((Function<SparseArray<Object>, Object>) function, strOptString2);
                        }
                    } catch (JSONException unused2) {
                        gr.this.c((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                    }
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    gr.this.c((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.byazt.yxi.uj.c().c(10000).c(Void.class).c(0, str).tt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Function<SparseArray<Object>, Object> function, int i, String str) {
        if (function != null) {
            function.apply(com.byazt.yxi.uj.c().c(10001).c(Void.class).c(0, Integer.valueOf(i)).c(1, str).tt());
        }
    }

    @Override // com.byazt.omf.gu
    public void c(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
        nVarTt.c("https://" + x.m().v() + "/ad_union_qa/sdk/get_ad_config");
        nVarTt.tt("x-pglcypher", "4");
        nVarTt.tt("x-ad-sdk-version", p.n);
        nVarTt.tt("x-plugin-version", "7.6.1.1");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", x.m().rl());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", p.n);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            byte[] bArrC = com.byazt.aas.da.c(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
            final com.byazt.dna.n nVarTt2 = com.byazt.aas.gr.tt();
            if (nVarTt2 == null) {
                c(function, -4, "armor service init fail");
            } else {
                nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, nVarTt2.encrypt(bArrC));
                nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.omf.gr.16
                    @Override // com.byazt.mh.c
                    public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                        String strTt;
                        int iOptInt = -1;
                        if (ttVar == null) {
                            gr.this.c((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                            return;
                        }
                        String str = ttVar.uj().get(e.f);
                        String str2 = ttVar.uj().get("x-pglcypher");
                        String strOptString = "";
                        if (TextUtils.equals(str, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE) || TextUtils.equals(str2, "4")) {
                            strTt = com.byazt.aas.da.tt(nVarTt2.decrypt(ttVar.sl()));
                            if (TextUtils.isEmpty(strTt)) {
                                strOptString = "data is null";
                            } else {
                                PluginValueSet pluginValueSetTt = com.byazt.yxi.ve.tt(function);
                                if (!TextUtils.isEmpty(strTt) && function != null && pluginValueSetTt != null && TextUtils.equals((CharSequence) pluginValueSetTt.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    x.m().c(new x.ve(map, strTt));
                                }
                                iOptInt = 0;
                            }
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(ttVar.n());
                                iOptInt = jSONObject2.optInt("code");
                                String strOptString2 = jSONObject2.optString("message");
                                try {
                                    strOptString = jSONObject2.optString("data");
                                    PluginValueSet pluginValueSetTt2 = com.byazt.yxi.ve.tt(function);
                                    if (!TextUtils.isEmpty(strOptString) && function != null && pluginValueSetTt2 != null && TextUtils.equals((CharSequence) pluginValueSetTt2.objectValue(0, String.class), "GetAdConfigImpl")) {
                                        x.m().c(new x.ve(map, strOptString));
                                    }
                                } catch (JSONException unused) {
                                }
                                String str3 = strOptString;
                                strOptString = strOptString2;
                                strTt = str3;
                            } catch (JSONException unused2) {
                                strTt = "";
                            }
                        }
                        if (iOptInt == 0) {
                            gr.this.c((Function<SparseArray<Object>, Object>) function, strTt);
                        } else {
                            gr.this.c((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                        }
                    }

                    @Override // com.byazt.mh.c
                    public void c(com.byazt.va.uj ujVar, IOException iOException) {
                        gr.this.c((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
