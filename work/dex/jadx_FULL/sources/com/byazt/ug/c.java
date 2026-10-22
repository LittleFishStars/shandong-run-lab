package com.byazt.ug;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.my;
import com.byazt.bp.tt;
import com.byazt.nbs.da;
import com.byazt.nbs.sp;
import com.byazt.nbs.x;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.p;
import com.byazt.qv.ve;
import com.byazt.va.uj;
import com.byazt.vx.a;
import com.byazt.vx.eo;
import com.byazt.vx.n;
import com.byazt.vx.rl;
import com.byazt.vx.sl;
import com.byazt.vx.yv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_POST_DETAIL_LIKE, 20})
public class c {
    public static volatile c c;

    /* JADX INFO: renamed from: com.byazt.ug.c$c, reason: collision with other inner class name */
    public interface InterfaceC0540c {
        void c(sp spVar);

        void c(com.byazt.pp.c cVar);
    }

    public static int c(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private JSONObject tt() {
        if (TextUtils.isEmpty(tt.tt().nu())) {
            return null;
        }
        try {
            return new JSONObject(tt.tt().nu());
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    private void ve(JSONObject jSONObject) {
        n nVarC = a.c(tt.getContext());
        if (nVarC != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", nVarC.c);
                jSONObject2.put("longitude", nVarC.tt);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private String c(Map<String, com.byazt.db.c> map, Context context, com.byazt.ll.tt ttVar, da daVar, Map<String, Object> map2) {
        if (ttVar != null && daVar != null) {
            if (TextUtils.equals("baidu", daVar.z())) {
                com.byazt.dv.tt ttVarC = com.byazt.dv.tt.c(daVar, (com.byazt.pq.c) null);
                com.byazt.db.c cVarC = ve.c(ttVarC, ttVar, (com.byazt.db.tt) null);
                if (cVarC == null) {
                    return "";
                }
                try {
                    map.put(String.format("%1$s_%2$s_%3$s", ttVar.c(), ttVar.gt(), daVar.rh()), cVarC);
                    return cVarC.getBiddingToken(context, ttVarC, ttVar);
                } catch (Throwable unused) {
                    return "";
                }
            }
            return com.byazt.px.c.c(map2, daVar.z());
        }
        com.byazt.eu.tt.tt("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
        return "";
    }

    private JSONObject tt(com.byazt.ll.tt ttVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iMy = ttVar.my();
            jSONObject.put("id", ttVar.gt());
            jSONObject.put("adtype", iMy);
            jSONObject.put("pos", c(iMy));
            if (p.uj < 7500) {
                c(jSONObject, "accepted_size", ttVar.qy(), ttVar.gu());
            } else {
                c(jSONObject, "accepted_size", com.byazt.pp.n.c(tt.getContext(), ttVar.u()), com.byazt.pp.n.c(tt.getContext(), ttVar.yp()));
            }
            jSONObject.put("is_support_dpl", ttVar.zm());
            int iGr = ttVar.gr();
            int i = 1;
            if (iGr <= 0) {
                iGr = 1;
            }
            if (iGr > 3) {
                iGr = 3;
            }
            if (iMy != 7 && iMy != 8) {
                i = iGr;
            }
            jSONObject.put("ad_count", i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.byazt.bp.c.t().u());
            jSONObject.put("name", com.byazt.bp.c.t().my());
            tt(jSONObject);
            ve(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public void c(Map<String, com.byazt.db.c> map, Context context, com.byazt.pl.ve veVar, final InterfaceC0540c interfaceC0540c) {
        JSONObject jSONObject;
        com.byazt.va.n nVar;
        com.byazt.ll.tt ttVar = veVar.c;
        List<da> list = veVar.tt;
        List<com.byazt.yl.ve> list2 = veVar.ve;
        com.byazt.nbs.tt ttVar2 = veVar.uj;
        int i = veVar.n;
        boolean z = veVar.f28947a;
        final long j = veVar.sp;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.va.n nVarTt = com.byazt.yp.tt.c().tt().tt();
        nVarTt.c(com.byazt.bp.ve.ve());
        String strX = com.byazt.bp.c.t().x();
        if (!TextUtils.isEmpty(strX)) {
            nVarTt.tt("X-Tt-Env", strX);
            nVarTt.tt("x-use-ppe", "1");
        }
        nVarTt.tt("User-Agent", com.byazt.yl.tt.c);
        final boolean z2 = !tt.tt().sp();
        if (z2) {
            nVarTt.tt("x-pglcypher", "4");
            nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, eo.tt(c(map, context, ttVar, list, list2, ttVar2, i, z, jSONObject2, false, j)));
            com.byazt.tjo.a.c(jSONObject2, "0-encrypt", j);
            if (nVarTt.n() != null && nVarTt.n().n != null) {
                eo.c(com.byazt.bp.ve.ve(), nVarTt.n().n, true);
            }
            nVar = nVarTt;
            jSONObject = jSONObject2;
        } else {
            String strC = c(map, context, ttVar, list, list2, ttVar2, i, z, jSONObject2, true, j);
            com.byazt.tjo.a.c(jSONObject, "0-encrypt", j);
            nVar = nVarTt;
            nVar.ve(strC);
            if (nVar.n() != null && nVar.n().uj != null) {
                jSONObject = jSONObject2;
                eo.c(com.byazt.bp.ve.ve(), nVar.n().uj, true);
            }
        }
        jSONObject = jSONObject2;
        jSONObject = jSONObject2;
        final JSONObject jSONObject3 = jSONObject;
        nVar.c(new com.byazt.mh.c() { // from class: com.byazt.ug.c.1
            @Override // com.byazt.mh.c
            public void c(uj ujVar, com.byazt.hm.tt ttVar3) {
                JSONObject jSONObject4;
                JSONObject jSONObject5;
                com.byazt.tjo.a.c(jSONObject3, "0-net", j);
                if (ttVar3 == null) {
                    com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onResponse...response is null");
                    c.this.c(-1, "response is null", interfaceC0540c, z2);
                    return;
                }
                int iTt = ttVar3.tt();
                if (eo.c(ttVar3)) {
                    eo.c(com.byazt.bp.ve.ve(), ttVar3.sl(), false);
                    String strC2 = eo.c(ttVar3.sl());
                    com.byazt.tjo.a.c(jSONObject3, "0-decrypt", j);
                    if (TextUtils.isEmpty(strC2)) {
                        com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onResponse...response v4 is empty");
                        c.this.c(iTt, "response is empty", interfaceC0540c, z2);
                        return;
                    }
                    try {
                        c.this.c(new JSONObject(strC2), jSONObject3, interfaceC0540c, z2, j);
                        return;
                    } catch (Throwable th) {
                        c.this.c(81014, th.getMessage(), interfaceC0540c, z2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(ttVar3.n())) {
                    com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onResponse...response is empty");
                    c.this.c(iTt, "response is empty", interfaceC0540c, z2);
                    return;
                }
                try {
                    eo.c(com.byazt.bp.ve.ve(), ttVar3.n(), false);
                    JSONObject jSONObject6 = new JSONObject(ttVar3.n());
                    int iOptInt = jSONObject6.optInt("cypher", -1);
                    String strOptString = jSONObject6.optString("message");
                    if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
                        int iOptInt2 = jSONObject6.optInt("status_code", -2);
                        int iOptInt3 = jSONObject6.optInt(MediationConstant.KEY_REASON, -2);
                        String strOptString2 = jSONObject6.optString("desc");
                        com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding onResponse error ");
                        c.this.c(iOptInt2, "reason is " + iOptInt3 + "，desc is " + strOptString2, interfaceC0540c, z2);
                        return;
                    }
                    if (iOptInt == 2) {
                        String strC3 = eo.c(strOptString);
                        com.byazt.tjo.a.c(jSONObject3, "0-decrypt", j);
                        if (TextUtils.isEmpty(strC3)) {
                            jSONObject5 = null;
                        } else {
                            try {
                                jSONObject5 = new JSONObject(strC3);
                            } catch (Throwable th2) {
                                com.byazt.eu.tt.c("ServerBiddingHelper", ">>>>> server bidding data error: " + th2.toString());
                                jSONObject5 = null;
                            }
                        }
                        jSONObject4 = jSONObject5;
                    } else {
                        if (iOptInt == 1) {
                            String strTt = com.byazt.vx.c.tt(strOptString, com.byazt.vx.tt.c());
                            com.byazt.tjo.a.c(jSONObject3, "0-decrypt", j);
                            if (!TextUtils.isEmpty(strTt)) {
                                try {
                                    jSONObject5 = new JSONObject(strTt);
                                } catch (Throwable th3) {
                                    com.byazt.eu.tt.c("ServerBiddingHelper", "server bidding data error: ", th3);
                                    jSONObject5 = null;
                                }
                            }
                            jSONObject4 = jSONObject5;
                        } else if (iOptInt == 0) {
                            jSONObject4 = new JSONObject(strOptString);
                        }
                        jSONObject5 = null;
                        jSONObject4 = jSONObject5;
                    }
                    c.this.c(jSONObject4, jSONObject3, interfaceC0540c, z2, j);
                } catch (Throwable th4) {
                    c.this.c(81006, th4.getMessage(), interfaceC0540c, z2);
                }
            }

            @Override // com.byazt.mh.c
            public void c(uj ujVar, IOException iOException) {
                int i2 = iOException instanceof SocketTimeoutException ? 44405 : 44404;
                com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onError...errorCode=".concat(String.valueOf(i2)));
                c.this.c(i2, "request fail " + iOException.getMessage(), interfaceC0540c, z2);
            }
        });
    }

    private void tt(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", eo.c());
            jSONObject.put("version_code", eo.tt());
            jSONObject.put("version", eo.ve());
        } catch (Exception unused) {
        }
    }

    private String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.byazt.id.c cVarC = com.byazt.px.c.c(str);
            if (cVarC != null) {
                return cVarC.getNetworkSdkVersion();
            }
            com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(str);
            if (ujVarC == null) {
                return null;
            }
            return ujVarC.getNetworkSdkVersion();
        } catch (Throwable th) {
            m.c(th);
            com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            return null;
        }
    }

    private void c(boolean z, long j) {
        yv.c(z ? "v4Enc_exchange" : "v2Enc_exchange", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str, InterfaceC0540c interfaceC0540c, boolean z) {
        yv.c(z ? "v4Enc_exchange" : "v2Enc_exchange", false, 0L, "code = " + i + "，msg = " + str);
        c(interfaceC0540c, new com.byazt.pp.c(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0540c interfaceC0540c, boolean z, long j) {
        String str;
        JSONArray jSONArray;
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str3 = "ServerBiddingHelper";
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                sp spVar = new sp();
                spVar.c(jSONObject2);
                spVar.ve(jSONObject.optString("request_id"));
                spVar.n(jSONObject.optString("server_bidding_extra"));
                spVar.uj(jSONObject.optString("server_request_id"));
                x xVar = new x();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("winner");
                String str4 = "price";
                if (jSONObjectOptJSONObject != null) {
                    xVar.tt(jSONObjectOptJSONObject.optInt("req_bidding_type"));
                    xVar.ve(jSONObjectOptJSONObject.optString("price"));
                    xVar.uj(jSONObjectOptJSONObject.optString("load_price"));
                    xVar.da(jSONObjectOptJSONObject.optString("adm"));
                    xVar.n(jSONObjectOptJSONObject.optString("name"));
                    xVar.sp(jSONObjectOptJSONObject.optString("app_id"));
                    xVar.a(jSONObjectOptJSONObject.optString("slot_id"));
                    xVar.x(jSONObjectOptJSONObject.optString("win_callback", null));
                    xVar.i(jSONObjectOptJSONObject.optString("fail_callback", null));
                    xVar.c(jSONObjectOptJSONObject.optInt("pricing_type", 1));
                    spVar.c(xVar);
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("winners");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    str = str3;
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        try {
                            x xVar2 = new x();
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                            jSONArray = jSONArrayOptJSONArray;
                            try {
                                xVar2.tt(jSONObjectOptJSONObject2.optInt("req_bidding_type"));
                                xVar2.ve(jSONObjectOptJSONObject2.optString(str4));
                                xVar2.uj(jSONObjectOptJSONObject2.optString("load_price"));
                                xVar2.da(jSONObjectOptJSONObject2.optString("adm"));
                                xVar2.n(jSONObjectOptJSONObject2.optString("name"));
                                xVar2.sp(jSONObjectOptJSONObject2.optString("app_id"));
                                xVar2.a(jSONObjectOptJSONObject2.optString("slot_id"));
                                str4 = str4;
                                try {
                                    xVar2.x(jSONObjectOptJSONObject2.optString("win_callback", null));
                                    xVar2.i(jSONObjectOptJSONObject2.optString("fail_callback", null));
                                    xVar2.c(jSONObjectOptJSONObject2.optString("m_aid", null));
                                    xVar2.tt(jSONObjectOptJSONObject2.optString("ad_extra", null));
                                    try {
                                        xVar2.c(jSONObjectOptJSONObject2.optInt("pricing_type", 1));
                                        arrayList.add(xVar2);
                                        str2 = str3;
                                    } catch (Throwable th) {
                                        th = th;
                                        str2 = str3;
                                        com.byazt.eu.tt.c(str2, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str2 = str3;
                                com.byazt.eu.tt.c(str2, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                i++;
                                str3 = str2;
                                str4 = str4;
                                jSONArrayOptJSONArray = jSONArray;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            jSONArray = jSONArrayOptJSONArray;
                        }
                        i++;
                        str3 = str2;
                        str4 = str4;
                        jSONArrayOptJSONArray = jSONArray;
                    }
                    str = str3;
                    spVar.c(arrayList);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("auto_detail");
                if (jSONObjectOptJSONObject3 != null) {
                    spVar.c(jSONObjectOptJSONObject3.optString("est_price"));
                    spVar.c(jSONObjectOptJSONObject3.optInt("est_price_source"));
                    spVar.tt(jSONObjectOptJSONObject3.optString("bidding_ecpm"));
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("waterfall");
                if (jSONObjectOptJSONObject4 != null) {
                    sp.c cVar = new sp.c();
                    cVar.c(jSONObjectOptJSONObject4.optString("version"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("adn_rit_conf");
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            try {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                da daVar = new da();
                                daVar.ve(jSONObjectOptJSONObject5.optString(MediationConstant.EXTRA_ADN_NAME));
                                daVar.n(jSONObjectOptJSONObject5.optString("adn_slot_id"));
                                arrayList2.add(daVar);
                            } catch (Throwable th5) {
                                com.byazt.eu.tt.c(str, "new waterfallListJson parse error: " + th5.toString());
                            }
                        }
                    }
                    cVar.c(arrayList2);
                    spVar.c(cVar);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("invalid_non_server_bidding_results");
                ArrayList arrayList3 = new ArrayList();
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        try {
                            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
                            com.byazt.nbs.a aVar = new com.byazt.nbs.a();
                            aVar.c(jSONObjectOptJSONObject6.optString("name"));
                            aVar.tt(jSONObjectOptJSONObject6.optString("slot_id"));
                            aVar.c(jSONObjectOptJSONObject6.optInt("req_bidding_type"));
                            aVar.tt(jSONObjectOptJSONObject6.optInt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE));
                            aVar.ve(jSONObjectOptJSONObject6.optString("error_msg"));
                            aVar.uj(jSONObjectOptJSONObject6.optString("level_tag"));
                            arrayList3.add(aVar);
                        } catch (Throwable th6) {
                            com.byazt.eu.tt.c(str, "new invalid_non_server_bidding_results parse error: " + th6.toString());
                        }
                    }
                    spVar.tt(arrayList3);
                }
                com.byazt.tjo.a.c(jSONObject2, "0-parse", j);
                c(interfaceC0540c, spVar);
                c(z, jElapsedRealtime);
                return;
            }
            com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onResponse..data.string is null ");
            c(-1, "data.string is null", interfaceC0540c, z);
            return;
        }
        com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onResponse...data is null");
        c(-1, "data is null", interfaceC0540c, z);
    }

    private void c(sp spVar, String str) {
        JSONObject jSONObject;
        if (spVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int iOptInt = jSONObject2.optInt("cypher", -1);
            String strOptString = jSONObject2.optString("message");
            if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
                com.byazt.eu.tt.uj("ServerBiddingHelper", "m_meta onResponse error ");
                return;
            }
            JSONObject jSONObject3 = null;
            if (iOptInt == 4) {
                com.byazt.dna.n nVarA = eo.a();
                String strDecryptWithCBC = nVarA != null ? nVarA.decryptWithCBC(strOptString) : null;
                if (!TextUtils.isEmpty(strDecryptWithCBC)) {
                    try {
                        jSONObject = new JSONObject(strDecryptWithCBC);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th) {
                        m.c(th);
                        com.byazt.eu.tt.c("ServerBiddingHelper", ">>>>> m_meta data 4 error: " + th.toString());
                    }
                }
            } else if (iOptInt == 2) {
                String strC = eo.c(strOptString);
                if (!TextUtils.isEmpty(strC)) {
                    try {
                        jSONObject = new JSONObject(strC);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th2) {
                        m.c(th2);
                        com.byazt.eu.tt.c("ServerBiddingHelper", ">>>>> m_meta data 2 error: " + th2.toString());
                    }
                }
            } else if (iOptInt == 1) {
                String strTt = com.byazt.vx.c.tt(strOptString, com.byazt.vx.tt.c());
                if (!TextUtils.isEmpty(strTt)) {
                    try {
                        jSONObject = new JSONObject(strTt);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th3) {
                        com.byazt.eu.tt.c("ServerBiddingHelper", "m_meta data 1 error: ", th3);
                    }
                }
            } else if (iOptInt == 0) {
                jSONObject3 = new JSONObject(strOptString);
            }
            if (jSONObject3 != null) {
                if (!TextUtils.isEmpty(jSONObject3.toString())) {
                    spVar.ve(jSONObject3.optString("request_id"));
                    spVar.n(jSONObject3.optString("server_bidding_extra"));
                    spVar.uj(jSONObject3.optString("server_request_id"));
                    return;
                }
                com.byazt.eu.tt.uj("ServerBiddingHelper", "m_meta..data.string is null ");
                return;
            }
            com.byazt.eu.tt.uj("ServerBiddingHelper", "m_meta...data is null");
        } catch (Throwable th4) {
            com.byazt.eu.tt.uj("ServerBiddingHelper", "m_meta onResponse throwable ：".concat(String.valueOf(th4.toString())));
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    private x c(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("m_adm");
        Object objOpt = jSONObject.opt("extra_data_and_no_parse");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(strOptString);
            int iOptInt = jSONObject3.optInt("cypher", -1);
            String strOptString2 = jSONObject3.optString("message");
            if (iOptInt < 0 || TextUtils.isEmpty(strOptString2)) {
                com.byazt.eu.tt.uj("ServerBiddingHelper", "adm winner data onResponse error ");
                return null;
            }
            if (iOptInt == 4) {
                com.byazt.dna.n nVarA = eo.a();
                String strDecryptWithCBC = nVarA != null ? nVarA.decryptWithCBC(strOptString2) : null;
                if (TextUtils.isEmpty(strDecryptWithCBC)) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(strDecryptWithCBC);
                    } catch (Throwable th) {
                        m.c(th);
                        com.byazt.eu.tt.c("ServerBiddingHelper", ">>>>> adm winner data 4 error: " + th.toString());
                        jSONObject2 = null;
                    }
                }
            } else if (iOptInt == 2) {
                String strC = eo.c(strOptString2);
                if (TextUtils.isEmpty(strC)) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(strC);
                    } catch (Throwable th2) {
                        com.byazt.eu.tt.c("ServerBiddingHelper", ">>>>> adm winner data 2 error: " + th2.toString());
                        jSONObject2 = null;
                    }
                }
            } else if (iOptInt == 1) {
                String strTt = com.byazt.vx.c.tt(strOptString2, com.byazt.vx.tt.c());
                if (TextUtils.isEmpty(strTt)) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(strTt);
                    } catch (Throwable th3) {
                        com.byazt.eu.tt.c("ServerBiddingHelper", ">>>>> adm winner data error: " + th3.toString());
                        jSONObject2 = null;
                    }
                }
            } else if (iOptInt == 0) {
                jSONObject2 = new JSONObject(strOptString2);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                if (!TextUtils.isEmpty(jSONObject2.toString())) {
                    x xVar = new x();
                    xVar.tt(jSONObject2.optInt("req_bidding_type"));
                    xVar.ve(jSONObject2.optString("price"));
                    xVar.uj(jSONObject2.optString("load_price"));
                    xVar.da(jSONObject2.optString("adm"));
                    xVar.n(jSONObject2.optString("name"));
                    xVar.sp(jSONObject2.optString("app_id"));
                    xVar.a(jSONObject2.optString("slot_id"));
                    xVar.x(jSONObject2.optString("win_callback", null));
                    xVar.i(jSONObject2.optString("fail_callback", null));
                    xVar.c(jSONObject2.optString("m_aid", null));
                    xVar.tt(jSONObject2.optString("ad_extra", null));
                    xVar.c(jSONObject2.optInt("pricing_type", 1));
                    xVar.c(objOpt);
                    return xVar;
                }
                com.byazt.eu.tt.uj("ServerBiddingHelper", "adm winner data.string is null ");
                return null;
            }
            com.byazt.eu.tt.uj("ServerBiddingHelper", "adm winner data is null");
            return null;
        } catch (Throwable th4) {
            com.byazt.eu.tt.uj("ServerBiddingHelper", "adm winner onResponse throwable ：".concat(String.valueOf(th4.toString())));
            return null;
        }
    }

    public void c(String str, InterfaceC0540c interfaceC0540c) {
        if (!TextUtils.isEmpty(str)) {
            try {
                sp spVar = new sp();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
                String strOptString = jSONObject.optString("m_meta");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            x xVarC = c(jSONArrayOptJSONArray.optJSONObject(i));
                            if (xVarC != null) {
                                arrayList.add(xVarC);
                            }
                        } catch (Throwable th) {
                            com.byazt.eu.tt.c("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        }
                    }
                    spVar.c(arrayList);
                }
                c(spVar, strOptString);
                c(interfaceC0540c, spVar);
                return;
            } catch (Throwable th2) {
                String string = th2.toString();
                com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding onResponse throwable ：".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    string = com.byazt.pp.c.c(-1);
                }
                c(interfaceC0540c, new com.byazt.pp.c(-1, string));
                return;
            }
        }
        com.byazt.eu.tt.uj("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        c(interfaceC0540c, new com.byazt.pp.c(-1, "response is invalid"));
    }

    private void c(final InterfaceC0540c interfaceC0540c, final com.byazt.pp.c cVar) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.ug.c.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0540c interfaceC0540c2 = interfaceC0540c;
                if (interfaceC0540c2 != null) {
                    interfaceC0540c2.c(cVar);
                }
            }
        });
    }

    private void c(final InterfaceC0540c interfaceC0540c, final sp spVar) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.ug.c.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0540c interfaceC0540c2 = interfaceC0540c;
                if (interfaceC0540c2 != null) {
                    interfaceC0540c2.c(spVar);
                }
            }
        });
    }

    private JSONObject c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public String c(Map<String, com.byazt.db.c> map, Context context, com.byazt.ll.tt ttVar, List<da> list, com.byazt.nbs.tt ttVar2, int i, boolean z, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (context == null) {
            return "";
        }
        try {
            jSONObject2 = new JSONObject(c(map, context, ttVar, list, null, ttVar2, i, z, jSONObject, false, SystemClock.elapsedRealtime()));
        } catch (Exception e) {
            m.c(e);
            jSONObject2 = null;
        }
        com.byazt.dna.n nVarA = eo.a();
        if (nVarA != null) {
            return nVarA.encryptBody(jSONObject2).toString();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16291. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private java.lang.String c(java.util.Map<java.lang.String, com.byazt.db.c> r37, android.content.Context r38, com.byazt.ll.tt r39, java.util.List<com.byazt.nbs.da> r40, java.util.List<com.byazt.yl.ve> r41, com.byazt.nbs.tt r42, int r43, boolean r44, org.json.JSONObject r45, boolean r46, long r47) {
        /*
            Method dump skipped, instruction units count: 1629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.ug.c.c(java.util.Map, android.content.Context, com.byazt.ll.tt, java.util.List, java.util.List, com.byazt.nbs.tt, int, boolean, org.json.JSONObject, boolean, long):java.lang.String");
    }

    private String c(com.byazt.ll.tt ttVar, da daVar) {
        String strC = ttVar != null ? ttVar.c() : null;
        if (daVar == null) {
            return strC;
        }
        return (strC + LoginConstants.UNDER_LINE) + daVar.rh();
    }

    private String c(JSONObject jSONObject, boolean z, boolean z2) {
        if (!z2) {
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        JSONObject jSONObjectC = eo.c(jSONObject);
        if (jSONObjectC == null) {
            return null;
        }
        try {
            jSONObjectC.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
        } catch (Exception unused2) {
        }
        return jSONObjectC.toString();
    }

    private JSONObject c(com.byazt.ll.tt ttVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", ttVar.c());
            jSONObject.put("ad_sdk_version", com.byazt.yl.tt.tt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.yl.tt.uj());
            jSONObject.put("source_type", NativeCallContext.DOMAIN_APP);
            jSONObject.put(NativeCallContext.DOMAIN_APP, ve());
            JSONObject jSONObjectC = rl.c(tt.getContext());
            if (jSONObjectC != null && ttVar.d() > 0) {
                jSONObjectC.put("orientation", ttVar.d());
            }
            jSONObject.put("device", jSONObjectC);
            jSONObject.put("ua", com.byazt.yl.tt.c);
            jSONObject.put(LoginConstants.IP, my.c());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(tt(ttVar));
            jSONObject.put("adslots", jSONArray);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (ttVar.gt() != null && ttVar.c() != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(ttVar.gt()).concat(ttVar.c());
            }
            jSONObject.put("req_sign", sl.c(strConcat));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void c(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }
}
