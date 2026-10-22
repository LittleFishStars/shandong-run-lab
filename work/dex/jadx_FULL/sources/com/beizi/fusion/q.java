package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.Analyse2ConfigModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.InitTraceModel;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.constant.DeviceIdType;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q implements q9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27663a;
    private final ve b;
    private String c;

    public class a implements mc {
        public a() {
        }

        @Override // com.beizi.fusion.mc
        public void a(ConfigResponseModel configResponseModel, g.a aVar, boolean z) {
            if (configResponseModel == null || g.a.EXPIRED == aVar) {
                return;
            }
            q.this.a(configResponseModel);
            q.this.c();
            q qVar = q.this;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            qVar.a(30L, 300L, timeUnit);
            q qVar2 = q.this;
            ve veVar = qVar2.b;
            if (veVar != null) {
                veVar.a(30L, 300L, timeUnit, qVar2.c);
            }
        }
    }

    public q(Context context) {
        this.f27663a = context.getApplicationContext();
        this.b = (ve) ym.a().b(context);
    }

    private void b(ConfigResponseModel configResponseModel) {
        Analyse2ConfigModel analyse2ConfigModel = configResponseModel.getAnalyse2ConfigModel();
        if (analyse2ConfigModel != null) {
            this.c = analyse2ConfigModel.getVersionMd5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ((fb) cn.a().b(this.f27663a)).d(new Runnable() { // from class: com.zj.adlib.kmb
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f42859a.b();
            }
        });
    }

    @Override // com.beizi.fusion.q9
    public void a() {
        ((g) h.a().b(this.f27663a)).a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ConfigResponseModel configResponseModel) {
        g gVar;
        b(configResponseModel);
        if (this.b == null || (gVar = (g) h.a().b(this.f27663a)) == null) {
            return;
        }
        v vVarA = gVar.a();
        InitTraceModel initTraceModelB = gVar.b();
        try {
            Objects.requireNonNull(initTraceModelB);
            String startID = initTraceModelB.getStartID();
            String strE = vVarA.e();
            Objects.requireNonNull(strE);
            if (TextUtils.isEmpty(startID) || TextUtils.isEmpty(strE)) {
                return;
            }
            JSONObject jSONObjectB = mg.b();
            mg.a(jSONObjectB, "start_id", startID);
            mg.a(jSONObjectB, "app_id", strE);
            mg.a(jSONObjectB, "custom_id", m0.e());
            JSONObject jSONObjectB2 = mg.b();
            mg.a(jSONObjectB2, PtgRewardConstant.REWARD_PARAMS.USER_ID, vVarA.w());
            mg.a(jSONObjectB2, "user_custom_data", vVarA.t());
            n nVar = (n) o.a().b(this.f27663a);
            yb ybVarB = nVar != null ? nVar.b() : null;
            if (ybVarB != null) {
                mg.a(jSONObjectB2, DeviceIdType.OAID, ybVarB.getOAID());
            }
            mg.a(jSONObjectB2, "said", m0.a(this.f27663a));
            mg.a(jSONObjectB2, "lmt", (vVarA.d() ? 1 : 0) + "");
            JSONObject jSONObjectB3 = mg.b();
            mg.a(jSONObjectB3, "version", m0.c());
            mg.a(jSONObjectB, RichTextUtils.USER_SCHEME, jSONObjectB2);
            mg.a(jSONObjectB, "sdk", jSONObjectB3);
            Analyse2ConfigModel analyse2ConfigModel = configResponseModel.getAnalyse2ConfigModel();
            mg.a(jSONObjectB, "logStrategy", analyse2ConfigModel != null ? analyse2ConfigModel.asJsonObject() : mg.b());
            this.b.a(f3.c(jSONObjectB.toString()));
        } catch (Exception e) {
            om.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() throws Throwable {
        List<h6> listB = j.b(this.f27663a);
        StringBuilder sb = new StringBuilder();
        sb.append("上报历史崩溃日志...");
        sb.append(listB != null ? Integer.valueOf(listB.size()) : " null ");
        om.a("ASNPEventReporter", sb.toString());
        if (listB == null || listB.isEmpty()) {
            return;
        }
        JSONArray jSONArrayA = mg.a();
        for (h6 h6Var : listB) {
            JSONObject jSONObjectB = mg.b();
            mg.a(jSONObjectB, "affiliated", h6Var.a());
            mg.a(jSONObjectB, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, h6Var.b());
            mg.a(jSONObjectB, "time", h6Var.c());
            jSONArrayA.put(jSONObjectB);
        }
        ve veVar = this.b;
        if (veVar != null) {
            veVar.a(f3.c(jSONArrayA.toString()), this.c, m0.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(u7 u7Var, InitTraceModel initTraceModel) {
        Map<String, String> macrosReplaceMap = k0.a(this.f27663a, u7Var, initTraceModel).getMacrosReplaceMap();
        if (macrosReplaceMap != null) {
            JSONObject jSONObjectB = mg.b();
            mg.a(jSONObjectB, "event_id", macrosReplaceMap.get("__EVENT_ID__"));
            mg.a(jSONObjectB, "event_code", macrosReplaceMap.get("__EVENT_CODE__"));
            mg.a(jSONObjectB, "event_time", macrosReplaceMap.get("__EVENT_TIME__"));
            mg.a(jSONObjectB, HiAnalyticsConstant.BI_KEY_COST_TIME, macrosReplaceMap.get("__COST_TIME__"));
            mg.a(jSONObjectB, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, macrosReplaceMap.get("__AD_ERROR_CODE__"));
            mg.a(jSONObjectB, "error_info", macrosReplaceMap.get("__AD_ERROR_INFO__"));
            this.b.b(f3.c(jSONObjectB.toString()), this.c, m0.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(u7 u7Var, AdTraceModel adTraceModel) {
        Map<String, String> macrosReplaceMap = k0.a(this.f27663a, u7Var, adTraceModel).getMacrosReplaceMap();
        if (macrosReplaceMap != null) {
            JSONArray jSONArrayA = f.a(this.f27663a).a();
            JSONObject jSONObjectB = mg.b();
            mg.a(jSONObjectB, "event_id", macrosReplaceMap.get("__EVENT_ID__"));
            mg.a(jSONObjectB, "event_code", macrosReplaceMap.get("__EVENT_CODE__"));
            mg.a(jSONObjectB, "event_time", macrosReplaceMap.get("__EVENT_TIME__"));
            mg.a(jSONObjectB, HiAnalyticsConstant.BI_KEY_COST_TIME, macrosReplaceMap.get("__COST_TIME__"));
            mg.a(jSONObjectB, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, macrosReplaceMap.get("__AD_ERROR_CODE__"));
            mg.a(jSONObjectB, "error_info", macrosReplaceMap.get("__AD_ERROR_INFO__"));
            mg.a(jSONObjectB, "beta_hits", jSONArrayA);
            mg.a(jSONObjectB, "dsp_id", macrosReplaceMap.get("__DSP_ID__"));
            mg.a(jSONObjectB, "order_id", macrosReplaceMap.get("__ORDER_ID__"));
            mg.a(jSONObjectB, "creative_id", macrosReplaceMap.get("__CREATIVE_ID__"));
            mg.a(jSONObjectB, "material_id", macrosReplaceMap.get("__MATERIAL_ID__"));
            mg.a(jSONObjectB, "scheme_id", macrosReplaceMap.get("__ADN_RENDER_ID__"));
            mg.a(jSONObjectB, "click_type", macrosReplaceMap.get("__CLICK_TYPE__"));
            mg.a(jSONObjectB, "ecpm", macrosReplaceMap.get("__PRICE__"));
            JSONObject jSONObjectB2 = mg.b();
            mg.a(jSONObjectB2, "space_id", macrosReplaceMap.get("__SPACE_ID__"));
            mg.a(jSONObjectB2, "session_id", macrosReplaceMap.get("__SESSION_ID__"));
            mg.a(jSONObjectB2, "cache_session_id", macrosReplaceMap.get("__CACHE_SESSION_ID__"));
            mg.a(jSONObjectB2, "ad_type", macrosReplaceMap.get("__AD_TYPE__"));
            mg.a(jSONObjectB2, "currency", macrosReplaceMap.get("__CURRENCY__"));
            mg.a(jSONObjectB2, "custom_data", macrosReplaceMap.get("__USER_CUSTOM_DATA__"));
            mg.a(jSONObjectB2, "time_out", macrosReplaceMap.get("__MAX_WAIT_TIME__"));
            mg.a(jSONObjectB2, "quantity", macrosReplaceMap.get("__QUANTITY__"));
            mg.a(jSONObjectB, "asnp", jSONObjectB2);
            this.b.b(f3.c(jSONObjectB.toString()), this.c, m0.e());
        }
    }

    public void a(long j, long j2, TimeUnit timeUnit) {
        ve veVar = this.b;
        if (veVar != null) {
            veVar.a(j, j2, timeUnit, m0.e());
        }
    }

    @Override // com.beizi.fusion.q9
    public void a(final u7 u7Var, final InitTraceModel initTraceModel) {
        if (this.b != null) {
            ((fb) cn.a().b(this.f27663a)).d(new Runnable() { // from class: com.zj.adlib.omb
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18676a.b(u7Var, initTraceModel);
                }
            });
        }
    }

    @Override // com.beizi.fusion.q9
    public void a(final u7 u7Var, final AdTraceModel adTraceModel) {
        if (this.b != null) {
            ((fb) cn.a().b(this.f27663a)).d(new Runnable() { // from class: com.zj.adlib.mmb
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18263a.b(u7Var, adTraceModel);
                }
            });
        }
    }
}
