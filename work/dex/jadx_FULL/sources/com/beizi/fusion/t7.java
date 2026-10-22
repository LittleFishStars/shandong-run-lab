package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AMPSExtraLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.ASNPExtraLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseSimpleLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.init.AnalyseCrashModel;
import com.beizi.fusion.asnp.common.analyse2.base.model.init.AnalyseEventModel;
import com.beizi.fusion.asnp.common.analyse2.base.model.init.AnalyseInitConfigModel;
import com.beizi.fusion.asnp.common.analyse2.base.model.init.AnalyseLogStrategyModel;
import com.beizi.fusion.asnp.common.v2.crash.ScopeCrashLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class t7 implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2 f27777a;
    private final Context e;
    private final ja f;
    private a g;
    private final Map d = new HashMap();
    private final Map b = new HashMap();
    private final Map c = new HashMap();

    public static class a extends be {
        public a(Runnable runnable) {
            super(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j, long j2, TimeUnit timeUnit) {
            a(j, j2, timeUnit);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            c();
        }
    }

    public class b implements n2.c {

        public class a implements q2.a {
            public a() {
            }

            @Override // com.beizi.fusion.q2.a
            public void a() {
                t7.this.getClass();
            }
        }

        private b() {
        }

        @Override // com.beizi.fusion.n2.c
        public void a(List list, AnalyseEventModel analyseEventModel, String str, String str2) {
            fb fbVar = (fb) cn.a().b(t7.this.e);
            t7 t7Var = t7.this;
            q2 q2Var = new q2(t7Var.e, t7Var.f, t7Var.f27777a);
            q2Var.a(analyseEventModel.e(), str2, analyseEventModel.a(), str);
            q2Var.d(list);
            q2Var.a(new a());
            fbVar.d(q2Var);
        }
    }

    public t7(Context context) {
        this.e = context;
        this.f = new m2(context);
        this.f27777a = new p2(context);
    }

    @Override // com.beizi.fusion.ve
    public void a(String str) {
        AnalyseLogStrategyModel analyseLogStrategyModelB;
        synchronized (t7.class) {
            String strB = f3.b(str);
            if (!TextUtils.isEmpty(strB)) {
                AnalyseInitConfigModel analyseInitConfigModel = new AnalyseInitConfigModel(mg.c(strB));
                if (!analyseInitConfigModel.hasParseException() && (analyseLogStrategyModelB = analyseInitConfigModel.b()) != null) {
                    String version = analyseLogStrategyModelB.getVersion();
                    if (!TextUtils.isEmpty(version)) {
                        this.c.put(version, analyseInitConfigModel);
                        List eventModels = analyseLogStrategyModelB.getEventModels();
                        if (eventModels != null && !eventModels.isEmpty() && !this.b.containsKey(version)) {
                            o2 o2Var = new o2(version, analyseLogStrategyModelB.a(), analyseInitConfigModel.a(), eventModels, new b());
                            om.a("EventLoggerImpl2", "记录上报队列 tag: " + version);
                            this.b.put(version, o2Var);
                        }
                    }
                }
            }
        }
    }

    public synchronized j2 b(String str) {
        AnalyseInitConfigModel analyseInitConfigModel;
        if (TextUtils.isEmpty(str) || !this.c.containsKey(str) || (analyseInitConfigModel = (AnalyseInitConfigModel) this.c.get(str)) == null) {
            return null;
        }
        return analyseInitConfigModel.a(this.e, this.d);
    }

    @Override // com.beizi.fusion.ve
    public void b(String str, String str2, String str3) {
        AnalyseSimpleLog analyseSimpleLog;
        o2 o2Var;
        synchronized (t7.class) {
            JSONObject jSONObjectC = mg.c(f3.b(str));
            if (jSONObjectC == null) {
                analyseSimpleLog = null;
            } else if (jSONObjectC.has("amps")) {
                analyseSimpleLog = new AMPSExtraLog(jSONObjectC);
            } else if (jSONObjectC.has("asnp")) {
                analyseSimpleLog = new ASNPExtraLog(jSONObjectC);
            } else {
                analyseSimpleLog = new AnalyseSimpleLog(jSONObjectC);
            }
            if (analyseSimpleLog != null && this.b.containsKey(str2) && (o2Var = (o2) this.b.get(str2)) != null) {
                o2Var.a(analyseSimpleLog);
            }
        }
    }

    @Override // com.beizi.fusion.ve
    public void a(long j, long j2, TimeUnit timeUnit, String str) {
        om.a("EventLoggerImpl2", "上报历史日志...");
        a aVar = this.g;
        if (aVar != null) {
            aVar.d();
        } else {
            this.g = new a(new k2(this.e, this.f, this.f27777a));
        }
        this.g.b(j, j2, timeUnit);
    }

    @Override // com.beizi.fusion.ve
    public void a(String str, String str2, String str3) {
        AnalyseInitConfigModel analyseInitConfigModel;
        AnalyseLogStrategyModel analyseLogStrategyModelB;
        AnalyseCrashModel analyseCrashModelB;
        synchronized (t7.class) {
            JSONArray jSONArrayB = mg.b(f3.b(str));
            if (jSONArrayB != null && jSONArrayB.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayB.length(); i++) {
                    try {
                        JSONObject jSONObject = jSONArrayB.getJSONObject(i);
                        arrayList.add(new ScopeCrashLog(mg.d(jSONObject, "affiliated"), mg.d(jSONObject, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a), mg.d(jSONObject, "time")));
                    } catch (JSONException e) {
                        om.a(e);
                    }
                }
                if (this.c.containsKey(str2) && (analyseInitConfigModel = (AnalyseInitConfigModel) this.c.get(str2)) != null && (analyseLogStrategyModelB = analyseInitConfigModel.b()) != null && (analyseCrashModelB = analyseLogStrategyModelB.b()) != null) {
                    String url = analyseCrashModelB.getUrl();
                    String strA = analyseLogStrategyModelB.a();
                    if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(strA)) {
                        fb fbVar = (fb) cn.a().b(this.e);
                        q2 q2Var = new q2(this.e, this.f, this.f27777a);
                        q2Var.a(url, strA, null, str2);
                        q2Var.b(arrayList);
                        fbVar.d(q2Var);
                    }
                }
            }
        }
    }
}
