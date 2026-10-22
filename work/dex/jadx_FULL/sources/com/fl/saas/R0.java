package com.fl.saas;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.baidu.location.LocationConst;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class R0 {
    private static R0 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f30084a;

    public class a implements T {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1424n0 f30085a;
        final /* synthetic */ String b;

        public a(InterfaceC1424n0 interfaceC1424n0, String str) {
            this.f30085a = interfaceC1424n0;
            this.b = str;
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("requestAdxResponse");
            R0.this.a(str, this.f30085a, this.b);
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.e(exc.getMessage());
            InterfaceC1424n0 interfaceC1424n0 = this.f30085a;
            if (interfaceC1424n0 == null) {
                return;
            }
            interfaceC1424n0.onAdFailed(FLError.create(20403, exc.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, InterfaceC1424n0 interfaceC1424n0, String str2) {
        InterfaceC1424n0 interfaceC1424n1 = interfaceC1424n0;
        if (interfaceC1424n1 == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            interfaceC1424n1.onAdFailed(FLError.create(20401, "return null-string response"));
            return;
        }
        try {
            JSONObject jSONObjectA = AbstractC1420l0.a(str);
            int iOptInt = jSONObjectA.optInt("code", -1);
            String strOptString = jSONObjectA.optString("req_id");
            if (iOptInt == -1) {
                interfaceC1424n1.onAdFailed(FLError.create(20401, "ret==" + iOptInt));
                return;
            }
            String reqID = DeviceUtil.getReqID(str2);
            JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("ads");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                try {
                    if (jSONArrayOptJSONArray.length() > 0) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            C1415j c1415jA = a(jSONArrayOptJSONArray.optJSONObject(i));
                            c1415jA.g = strOptString;
                            c1415jA.i = str2;
                            c1415jA.r = reqID;
                            c1415jA.K0 = jSONObjectA.optInt("auto_play_type", 1);
                            arrayList.add(c1415jA);
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    interfaceC1424n1.onAdFailed(FLError.create(20401, e.getMessage()));
                }
            }
            if (arrayList.isEmpty()) {
                interfaceC1424n1.onAdFailed(FLError.create(20401, "adInfoList is empty"));
                return;
            }
            int iOptInt2 = jSONObjectA.optInt("draw_type", 0);
            int iOptInt3 = jSONObjectA.optInt("video_orientation", 0);
            int iOptInt4 = jSONObjectA.optInt("is_muted");
            int iOptInt5 = jSONObjectA.optInt("video_auto_play");
            int iOptInt6 = jSONObjectA.optInt("template_type_id");
            int iOptInt7 = jSONObjectA.optInt("left_right_margin");
            int iOptInt8 = jSONObjectA.optInt("top_bottom_margin");
            double dOptDouble = jSONObjectA.optDouble("click_callback_ratio", 100.0d);
            int iOptInt9 = jSONObjectA.optInt("server_verify", 0);
            try {
                int iOptInt10 = jSONObjectA.optInt("server_verify_time", 0);
                int iOptInt11 = jSONObjectA.optInt("resp_area_ratio");
                int iOptInt12 = jSONObjectA.optInt("close_button_freq");
                int iOptInt13 = jSONObjectA.optInt("close_button_interval");
                String strOptString2 = jSONObjectA.optString("display_effective_count");
                String strOptString3 = jSONObjectA.optString("is_download", "A");
                String strOptString4 = jSONObjectA.optString("hotspot");
                int iOptInt14 = jSONObjectA.optInt("hotspot_type");
                int i2 = iOptInt10;
                int iOptInt15 = jSONObjectA.optInt("sensitivity", 50);
                int iOptInt16 = jSONObjectA.optInt("scale_type");
                int i3 = iOptInt15;
                int iOptInt17 = jSONObjectA.optInt("cp_style");
                String strOptString5 = jSONObjectA.optString("cp_close_button", "S");
                int iOptInt18 = jSONObjectA.optInt("count_down");
                int iOptInt19 = jSONObjectA.optInt("button_size");
                int iOptInt20 = jSONObjectA.optInt("button_position");
                String strOptString6 = jSONObjectA.optString("close_button_type", "A");
                String strOptString7 = jSONObjectA.optString("auto_close");
                int iOptInt21 = jSONObjectA.optInt("close_countdown");
                int iOptInt22 = jSONObjectA.optInt("only_button");
                int iOptInt23 = jSONObjectA.optInt("ad_size");
                int iOptInt24 = jSONObjectA.optInt("is_full_screen");
                int iOptInt25 = jSONObjectA.optInt(com.alipay.sdk.m.c0.d.x);
                int iOptInt26 = jSONObjectA.optInt("refresh_time");
                int iOptInt27 = jSONObjectA.optInt("accept_quick_app");
                int iOptInt28 = jSONObjectA.optInt("browser_jump");
                int iOptInt29 = jSONObjectA.optInt("animate_start_time");
                int iOptInt30 = jSONObjectA.optInt("animate_time");
                String str3 = strOptString6;
                int iOptInt31 = jSONObjectA.optInt("preview_mode", 0);
                int iOptInt32 = jSONObjectA.optInt("rd_type", 1);
                int iOptInt33 = jSONObjectA.optInt("rd_countdown", 15);
                int iOptInt34 = jSONObjectA.optInt("rd_skip_time", -1);
                int iOptInt35 = jSONObjectA.optInt("rd_click_time", -1);
                int iOptInt36 = jSONObjectA.optInt("rd_auto_type", 2);
                int iOptInt37 = jSONObjectA.optInt("rd_auto_time", 0);
                String strOptString8 = jSONObjectA.optString("rd_autoskip_sts", "S");
                int i4 = iOptInt37;
                int iOptInt38 = jSONObjectA.optInt("display_mask", 1);
                int iOptInt39 = jSONObjectA.optInt("enable_native_wakeup", 0);
                int iOptInt40 = jSONObjectA.optInt("post_click_strategy", 0);
                int iOptInt41 = jSONObjectA.optInt("bdt", 0);
                int iOptInt42 = jSONObjectA.optInt("skip_button", 0);
                String str4 = "S";
                double dOptDouble2 = jSONObjectA.optDouble("interstitial_bg_alpha", 40.0d);
                String strOptString9 = jSONObjectA.optString("task_type");
                double d = dOptDouble2;
                int iOptInt43 = jSONObjectA.optInt("load_materials", 0);
                String str5 = strOptString9;
                int iOptInt44 = jSONObjectA.optInt("mif", 0);
                int iOptInt45 = jSONObjectA.optInt("is_mit", 0);
                int iOptInt46 = jSONObjectA.optInt("mip", 0);
                String strOptString10 = jSONObjectA.optString("mit_id", "");
                int i5 = 0;
                while (i5 < arrayList.size()) {
                    ((C1415j) arrayList.get(i5)).L0 = iOptInt2;
                    ((C1415j) arrayList.get(i5)).N0 = iOptInt3;
                    ((C1415j) arrayList.get(i5)).O0 = iOptInt4;
                    ((C1415j) arrayList.get(i5)).K0 = iOptInt5;
                    ((C1415j) arrayList.get(i5)).t0 = iOptInt6;
                    ((C1415j) arrayList.get(i5)).u0 = iOptInt7;
                    ((C1415j) arrayList.get(i5)).v0 = iOptInt8;
                    ((C1415j) arrayList.get(i5)).j2 = dOptDouble;
                    int i6 = iOptInt2;
                    int i7 = iOptInt42;
                    ((C1415j) arrayList.get(i5)).M = i7;
                    C1415j c1415j = (C1415j) arrayList.get(i5);
                    iOptInt42 = i7;
                    boolean z = true;
                    if (iOptInt9 != 1) {
                        z = false;
                    }
                    c1415j.p0 = z;
                    int i8 = i2;
                    ((C1415j) arrayList.get(i5)).q0 = i8;
                    int i9 = iOptInt9;
                    int i10 = iOptInt11;
                    ((C1415j) arrayList.get(i5)).I = i10;
                    iOptInt11 = i10;
                    int i11 = iOptInt12;
                    ((C1415j) arrayList.get(i5)).J = i11;
                    iOptInt12 = i11;
                    int i12 = iOptInt13;
                    ((C1415j) arrayList.get(i5)).K = i12;
                    iOptInt13 = i12;
                    String str6 = strOptString2;
                    ((C1415j) arrayList.get(i5)).L = str6;
                    ((C1415j) arrayList.get(i5)).D = iOptInt16;
                    strOptString2 = str6;
                    int i13 = iOptInt17;
                    ((C1415j) arrayList.get(i5)).M0 = i13;
                    iOptInt17 = i13;
                    String str7 = strOptString5;
                    ((C1415j) arrayList.get(i5)).u = str7;
                    strOptString5 = str7;
                    int i14 = iOptInt18;
                    ((C1415j) arrayList.get(i5)).v = i14;
                    iOptInt18 = i14;
                    int i15 = iOptInt19;
                    ((C1415j) arrayList.get(i5)).w = i15;
                    iOptInt19 = i15;
                    int i16 = iOptInt20;
                    ((C1415j) arrayList.get(i5)).a(i16);
                    iOptInt20 = i16;
                    String str8 = str3;
                    ((C1415j) arrayList.get(i5)).a(str8);
                    str3 = str8;
                    String str9 = strOptString7;
                    ((C1415j) arrayList.get(i5)).F = str9;
                    strOptString7 = str9;
                    int i17 = iOptInt21;
                    ((C1415j) arrayList.get(i5)).G = i17;
                    iOptInt21 = i17;
                    int i18 = iOptInt22;
                    ((C1415j) arrayList.get(i5)).H = i18;
                    iOptInt22 = i18;
                    int i19 = iOptInt23;
                    ((C1415j) arrayList.get(i5)).P = i19;
                    iOptInt23 = i19;
                    int i20 = iOptInt24;
                    ((C1415j) arrayList.get(i5)).Q = i20;
                    iOptInt24 = i20;
                    int i21 = iOptInt25;
                    ((C1415j) arrayList.get(i5)).e0 = i21;
                    iOptInt25 = i21;
                    int i22 = iOptInt26;
                    ((C1415j) arrayList.get(i5)).f0 = i22;
                    iOptInt26 = i22;
                    int i23 = iOptInt27;
                    ((C1415j) arrayList.get(i5)).g0 = i23;
                    iOptInt27 = i23;
                    int i24 = iOptInt28;
                    ((C1415j) arrayList.get(i5)).h0 = i24;
                    iOptInt28 = i24;
                    int i25 = iOptInt29;
                    ((C1415j) arrayList.get(i5)).N = i25;
                    iOptInt29 = i25;
                    int i26 = iOptInt30;
                    ((C1415j) arrayList.get(i5)).O = i26;
                    iOptInt30 = i26;
                    String str10 = strOptString4;
                    ((C1415j) arrayList.get(i5)).B = str10;
                    strOptString4 = str10;
                    int i27 = iOptInt14;
                    ((C1415j) arrayList.get(i5)).C = i27;
                    iOptInt14 = i27;
                    int i28 = i3;
                    ((C1415j) arrayList.get(i5)).x = i28;
                    i3 = i28;
                    String str11 = strOptString3;
                    String str12 = str4;
                    if (str12.equals(str11)) {
                        ((C1415j) arrayList.get(i5)).g2 = false;
                    }
                    int i29 = iOptInt31;
                    ((C1415j) arrayList.get(i5)).q2 = i29;
                    iOptInt31 = i29;
                    int i30 = iOptInt32;
                    ((C1415j) arrayList.get(i5)).R = i30;
                    iOptInt32 = i30;
                    int i31 = iOptInt33;
                    ((C1415j) arrayList.get(i5)).S = i31;
                    iOptInt33 = i31;
                    int i32 = iOptInt34;
                    ((C1415j) arrayList.get(i5)).T = i32;
                    iOptInt34 = i32;
                    int i33 = iOptInt35;
                    ((C1415j) arrayList.get(i5)).U = i33;
                    iOptInt35 = i33;
                    int i34 = iOptInt36;
                    ((C1415j) arrayList.get(i5)).V = i34;
                    iOptInt36 = i34;
                    int i35 = i4;
                    ((C1415j) arrayList.get(i5)).W = i35;
                    i4 = i35;
                    String str13 = strOptString8;
                    ((C1415j) arrayList.get(i5)).X = str13;
                    strOptString8 = str13;
                    int i36 = iOptInt38;
                    ((C1415j) arrayList.get(i5)).Y = i36;
                    iOptInt38 = i36;
                    int i37 = iOptInt40;
                    ((C1415j) arrayList.get(i5)).l0 = i37;
                    iOptInt40 = i37;
                    int i38 = iOptInt39;
                    ((C1415j) arrayList.get(i5)).m0 = i38;
                    iOptInt39 = i38;
                    int i39 = iOptInt41;
                    ((C1415j) arrayList.get(i5)).n0 = i39;
                    ((C1415j) arrayList.get(i5)).x2 = iOptInt43;
                    int i40 = iOptInt43;
                    int i41 = iOptInt44;
                    ((C1415j) arrayList.get(i5)).v2 = i41;
                    iOptInt44 = i41;
                    int i42 = iOptInt45;
                    ((C1415j) arrayList.get(i5)).t2 = i42;
                    iOptInt45 = i42;
                    int i43 = iOptInt46;
                    ((C1415j) arrayList.get(i5)).u2 = i43;
                    ((C1415j) arrayList.get(i5)).w2 = strOptString10;
                    iOptInt46 = i43;
                    String str14 = str5;
                    ((C1415j) arrayList.get(i5)).m = str14;
                    String str15 = strOptString10;
                    double d2 = d;
                    ((C1415j) arrayList.get(i5)).n = d2;
                    ((C1415j) arrayList.get(i5)).k();
                    i5++;
                    d = d2;
                    iOptInt43 = i40;
                    strOptString10 = str15;
                    str5 = str14;
                    iOptInt41 = i39;
                    iOptInt9 = i9;
                    i2 = i8;
                    iOptInt2 = i6;
                    str4 = str12;
                    strOptString3 = str11;
                }
                interfaceC1424n0.a(arrayList);
            } catch (Exception e2) {
                e = e2;
                interfaceC1424n1 = interfaceC1424n0;
                e.printStackTrace();
                interfaceC1424n1.onAdFailed(FLError.create(20401, e.getMessage()));
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private C1415j a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        C1415j c1415j = new C1415j();
        c1415j.l = this.f30084a;
        c1415j.y = jSONObject.optString("adv_name", "广告");
        c1415j.w0 = jSONObject.optString("ac_type");
        c1415j.d = jSONObject.optInt("price");
        c1415j.x0 = jSONObject.optString("landing_page");
        c1415j.y0 = jSONObject.optString("deeplink_url");
        c1415j.z0 = jSONObject.optString("download_url");
        c1415j.A0 = jSONObject.optString("app_package");
        c1415j.C0 = jSONObject.optString("app_name");
        c1415j.D0 = jSONObject.optString("advertiser_name");
        c1415j.E0 = jSONObject.optString(AlibcCommonConstant.APP_VERSION);
        c1415j.F0 = jSONObject.optString("package_size_bytes");
        c1415j.G0 = jSONObject.optString("permissions_url");
        c1415j.J0 = jSONObject.optString("app_intro_url");
        c1415j.B0 = jSONObject.optString("ad_logo");
        c1415j.H0 = jSONObject.optString("privacy_agreement");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permission_list");
        if (jSONArrayOptJSONArray != null) {
            c1415j.I0 = jSONArrayOptJSONArray.toString();
        }
        c1415j.A1 = jSONObject.optString("wx_app_id");
        c1415j.B1 = jSONObject.optString("wx_mini_pro_id");
        c1415j.C1 = jSONObject.optString("wx_mini_pro_path");
        c1415j.D1 = jSONObject.optInt("validityTime", 1800);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("creative");
        C1415j.c cVar = new C1415j.c();
        if (jSONObjectOptJSONObject2 != null) {
            String strOptString = jSONObjectOptJSONObject2.optString("cid");
            c1415j.z = strOptString;
            cVar.f30178a = strOptString;
            cVar.b = jSONObjectOptJSONObject2.optInt("ctype");
            cVar.c = jSONObjectOptJSONObject2.optString("title");
            c1415j.o0 = jSONObjectOptJSONObject2.optString("title");
            cVar.d = jSONObjectOptJSONObject2.optString("desc");
            c1415j.s1 = jSONObjectOptJSONObject2.optString("desc");
            cVar.e = jSONObjectOptJSONObject2.optString("button");
            cVar.f = jSONObjectOptJSONObject2.optString("brand");
            jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("video");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("imgs");
            ArrayList arrayList = new ArrayList();
            C1415j.d dVar = new C1415j.d();
            if (jSONArrayOptJSONArray2 != null) {
                for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i);
                    dVar.f30179a = jSONObjectOptJSONObject3.optString("url");
                    dVar.b = jSONObjectOptJSONObject3.optInt("width");
                    dVar.c = jSONObjectOptJSONObject3.optInt("height");
                    arrayList.add(dVar);
                    if (i == 0) {
                        c1415j.p1 = jSONObjectOptJSONObject3.optString("url");
                        c1415j.v1 = jSONObjectOptJSONObject3.optInt("width");
                        c1415j.w1 = jSONObjectOptJSONObject3.optInt("height");
                    }
                }
            }
            cVar.h = arrayList;
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject(RemoteMessageConst.Notification.ICON);
            C1415j.d dVar2 = new C1415j.d();
            if (jSONObjectOptJSONObject4 != null) {
                dVar2.f30179a = jSONObjectOptJSONObject4.optString("url");
                dVar2.b = jSONObjectOptJSONObject4.optInt("width");
                dVar2.c = jSONObjectOptJSONObject4.optInt("height");
                cVar.i = dVar2;
                c1415j.x1 = jSONObjectOptJSONObject4.optString("url");
            }
        } else {
            jSONObjectOptJSONObject = null;
        }
        C1415j.e eVar = new C1415j.e();
        if (jSONObjectOptJSONObject != null) {
            eVar.f30180a = jSONObjectOptJSONObject.optString("video_url");
            c1415j.t1 = jSONObjectOptJSONObject.optString("video_url");
            eVar.b = jSONObjectOptJSONObject.optInt("width");
            eVar.c = jSONObjectOptJSONObject.optInt("height");
            eVar.d = jSONObjectOptJSONObject.optInt("duration");
            c1415j.X1 = jSONObjectOptJSONObject.optInt("duration");
            eVar.e = jSONObjectOptJSONObject.optLong("size");
            eVar.g = jSONObjectOptJSONObject.optString("end_url");
            c1415j.u1 = jSONObjectOptJSONObject.optString("end_url");
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject(AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
            if (jSONObjectOptJSONObject5 != null) {
                C1415j.d dVar3 = new C1415j.d();
                dVar3.f30179a = jSONObjectOptJSONObject5.optString("url");
                dVar3.b = jSONObjectOptJSONObject5.optInt("width");
                dVar3.c = jSONObjectOptJSONObject5.optInt("height");
                eVar.f = dVar3;
            }
            cVar.g = eVar;
        }
        c1415j.P0 = cVar;
        C1415j.a aVar = new C1415j.a();
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("ad_interactio_mode");
        if (jSONObjectOptJSONObject6 != null) {
            aVar.f30176a = jSONObjectOptJSONObject6.optString("normalclick", "");
            aVar.b = jSONObjectOptJSONObject6.optString("shake", "");
            aVar.c = jSONObjectOptJSONObject6.optString("slideclick", "");
            aVar.d = jSONObjectOptJSONObject6.optString("twist", "");
        }
        c1415j.l2 = aVar;
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("notice_success_urls");
        if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                c1415j.k1.add(jSONArrayOptJSONArray3.optString(i2));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("notice_failed_urls");
        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray4.length(); i3++) {
                c1415j.l1.add(jSONArrayOptJSONArray4.optString(i3));
            }
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("imp_notice_urls");
        if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray5.length(); i4++) {
                c1415j.Q0.add(jSONArrayOptJSONArray5.optString(i4));
            }
        }
        JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("click_notice_urls");
        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray6.length(); i5++) {
                c1415j.R0.add(jSONArrayOptJSONArray6.optString(i5));
            }
        }
        JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("dpsuccess_notice_urls");
        if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray7.length(); i6++) {
                c1415j.S0.add(jSONArrayOptJSONArray7.optString(i6));
            }
        }
        JSONArray jSONArrayOptJSONArray8 = jSONObject.optJSONArray("video_end_notice_urls");
        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() > 0) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray8.length(); i7++) {
                c1415j.T0.add(jSONArrayOptJSONArray8.optString(i7));
            }
        }
        JSONArray jSONArrayOptJSONArray9 = jSONObject.optJSONArray("download_start_notice_urls");
        if (jSONArrayOptJSONArray9 != null && jSONArrayOptJSONArray9.length() > 0) {
            for (int i8 = 0; i8 < jSONArrayOptJSONArray9.length(); i8++) {
                c1415j.U0.add(jSONArrayOptJSONArray9.optString(i8));
            }
        }
        JSONArray jSONArrayOptJSONArray10 = jSONObject.optJSONArray("download_end_notice_urls");
        if (jSONArrayOptJSONArray10 != null && jSONArrayOptJSONArray10.length() > 0) {
            for (int i9 = 0; i9 < jSONArrayOptJSONArray10.length(); i9++) {
                c1415j.V0.add(jSONArrayOptJSONArray10.optString(i9));
            }
        }
        JSONArray jSONArrayOptJSONArray11 = jSONObject.optJSONArray("install_start_notice_urls");
        if (jSONArrayOptJSONArray11 != null && jSONArrayOptJSONArray11.length() > 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray11.length(); i10++) {
                c1415j.W0.add(jSONArrayOptJSONArray11.optString(i10));
            }
        }
        JSONArray jSONArrayOptJSONArray12 = jSONObject.optJSONArray("install_end_notice_urls");
        if (jSONArrayOptJSONArray12 != null && jSONArrayOptJSONArray12.length() > 0) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray12.length(); i11++) {
                c1415j.X0.add(jSONArrayOptJSONArray12.optString(i11));
            }
        }
        JSONArray jSONArrayOptJSONArray13 = jSONObject.optJSONArray("open_notice_urls");
        if (jSONArrayOptJSONArray13 != null && jSONArrayOptJSONArray13.length() > 0) {
            for (int i12 = 0; i12 < jSONArrayOptJSONArray13.length(); i12++) {
                c1415j.Y0.add(jSONArrayOptJSONArray13.optString(i12));
            }
        }
        JSONArray jSONArrayOptJSONArray14 = jSONObject.optJSONArray("video_view_urls");
        if (jSONArrayOptJSONArray14 != null && jSONArrayOptJSONArray14.length() > 0) {
            for (int i13 = 0; i13 < jSONArrayOptJSONArray14.length(); i13++) {
                c1415j.Z0.add(jSONArrayOptJSONArray14.optString(i13));
            }
        }
        JSONArray jSONArrayOptJSONArray15 = jSONObject.optJSONArray("close");
        if (jSONArrayOptJSONArray15 != null && jSONArrayOptJSONArray15.length() > 0) {
            for (int i14 = 0; i14 < jSONArrayOptJSONArray15.length(); i14++) {
                c1415j.a1.add(jSONArrayOptJSONArray15.optString(i14));
            }
        }
        JSONArray jSONArrayOptJSONArray16 = jSONObject.optJSONArray("video_start_notice_urls");
        if (jSONArrayOptJSONArray16 != null && jSONArrayOptJSONArray16.length() > 0) {
            for (int i15 = 0; i15 < jSONArrayOptJSONArray16.length(); i15++) {
                c1415j.b1.add(jSONArrayOptJSONArray16.optString(i15));
            }
        }
        JSONArray jSONArrayOptJSONArray17 = jSONObject.optJSONArray("video_pause_notice_urls");
        if (jSONArrayOptJSONArray17 != null && jSONArrayOptJSONArray17.length() > 0) {
            for (int i16 = 0; i16 < jSONArrayOptJSONArray17.length(); i16++) {
                c1415j.f1.add(jSONArrayOptJSONArray17.optString(i16));
            }
        }
        JSONArray jSONArrayOptJSONArray18 = jSONObject.optJSONArray("video_fullscreen_notice_urls");
        if (jSONArrayOptJSONArray18 != null && jSONArrayOptJSONArray18.length() > 0) {
            for (int i17 = 0; i17 < jSONArrayOptJSONArray18.length(); i17++) {
                c1415j.g1.add(jSONArrayOptJSONArray18.optString(i17));
            }
        }
        JSONArray jSONArrayOptJSONArray19 = jSONObject.optJSONArray("video_continue_notice_urls");
        if (jSONArrayOptJSONArray19 != null && jSONArrayOptJSONArray19.length() > 0) {
            for (int i18 = 0; i18 < jSONArrayOptJSONArray19.length(); i18++) {
                c1415j.h1.add(jSONArrayOptJSONArray19.optString(i18));
            }
        }
        JSONArray jSONArrayOptJSONArray20 = jSONObject.optJSONArray("video_skip_notice_urls");
        if (jSONArrayOptJSONArray20 != null && jSONArrayOptJSONArray20.length() > 0) {
            for (int i19 = 0; i19 < jSONArrayOptJSONArray20.length(); i19++) {
                c1415j.i1.add(jSONArrayOptJSONArray20.optString(i19));
            }
        }
        JSONArray jSONArrayOptJSONArray21 = jSONObject.optJSONArray("video_mute_notice_urls");
        if (jSONArrayOptJSONArray21 != null && jSONArrayOptJSONArray21.length() > 0) {
            for (int i20 = 0; i20 < jSONArrayOptJSONArray21.length(); i20++) {
                c1415j.j1.add(jSONArrayOptJSONArray21.optString(i20));
            }
        }
        JSONArray jSONArrayOptJSONArray22 = jSONObject.optJSONArray("video_first_quartile_notice_urls");
        if (jSONArrayOptJSONArray22 != null && jSONArrayOptJSONArray22.length() > 0) {
            for (int i21 = 0; i21 < jSONArrayOptJSONArray22.length(); i21++) {
                c1415j.c1.add(jSONArrayOptJSONArray22.optString(i21));
            }
        }
        JSONArray jSONArrayOptJSONArray23 = jSONObject.optJSONArray("video_midpoint_notice_urls");
        if (jSONArrayOptJSONArray23 != null && jSONArrayOptJSONArray23.length() > 0) {
            for (int i22 = 0; i22 < jSONArrayOptJSONArray23.length(); i22++) {
                c1415j.d1.add(jSONArrayOptJSONArray23.optString(i22));
            }
        }
        JSONArray jSONArrayOptJSONArray24 = jSONObject.optJSONArray("video_third_quartile_notice_urls");
        if (jSONArrayOptJSONArray24 != null && jSONArrayOptJSONArray24.length() > 0) {
            for (int i23 = 0; i23 < jSONArrayOptJSONArray24.length(); i23++) {
                c1415j.e1.add(jSONArrayOptJSONArray24.optString(i23));
            }
        }
        JSONArray jSONArrayOptJSONArray25 = jSONObject.optJSONArray("app_installed_notice_urls");
        if (jSONArrayOptJSONArray25 != null && jSONArrayOptJSONArray25.length() > 0) {
            for (int i24 = 0; i24 < jSONArrayOptJSONArray25.length(); i24++) {
                c1415j.m1.add(jSONArrayOptJSONArray25.optString(i24));
            }
        }
        JSONArray jSONArrayOptJSONArray26 = jSONObject.optJSONArray("dp_attempt_notice_urls");
        if (jSONArrayOptJSONArray26 != null && jSONArrayOptJSONArray26.length() > 0) {
            for (int i25 = 0; i25 < jSONArrayOptJSONArray26.length(); i25++) {
                c1415j.n1.add(jSONArrayOptJSONArray26.optString(i25));
            }
        }
        JSONArray jSONArrayOptJSONArray27 = jSONObject.optJSONArray("dpfail_notice_urls");
        if (jSONArrayOptJSONArray27 != null && jSONArrayOptJSONArray27.length() > 0) {
            for (int i26 = 0; i26 < jSONArrayOptJSONArray27.length(); i26++) {
                c1415j.o1.add(jSONArrayOptJSONArray27.optString(i26));
            }
        }
        c1415j.i0 = jSONObject.optInt("is_black", 0);
        return c1415j;
    }

    public static R0 a() {
        if (b == null) {
            synchronized (R0.class) {
                b = new R0();
            }
        }
        return b;
    }

    public void a(String str, String str2, boolean z, InterfaceC1424n0 interfaceC1424n0) {
        LogcatUtil.d("requestAd:" + str2);
        this.f30084a = DeviceUtil.getBootTime();
        if (TextUtils.isEmpty(str)) {
            if (interfaceC1424n0 == null) {
                return;
            }
            interfaceC1424n0.onAdFailed(FLError.create(20403, "placeId null"));
        } else {
            C1401c.c().a(CommConstant.API.NEW_API_BID, new HashMap(), AbstractC1417k.e(a(str2, str, z).toString()), new a(interfaceC1424n0, str));
        }
    }

    private JSONObject a(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.putOpt(LocationConst.HDYawConst.KEY_HD_YAW_LINK_ID, str);
            }
            jSONObject.putOpt("id", DeviceUtil.getReqID(str2));
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", str2);
            jSONObject.putOpt("mit", Integer.valueOf(AbstractC1447z.c()));
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("is_hot_start", Integer.valueOf(z ? 1 : 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
