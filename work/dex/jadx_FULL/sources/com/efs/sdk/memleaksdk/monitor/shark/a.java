package com.efs.sdk.memleaksdk.monitor.shark;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.memleaksdk.MemLeakManager;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.efs.sdk.memleaksdk.monitor.UMonitorConfigJava;
import com.efs.sdk.memleaksdk.monitor.UMonitorReporter;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {
    public static void a(final Context context, final EfsReporter efsReporter) {
        if (context == null) {
            Log.e("JavaMonitorManager", "JavaMonitorManager init failed: context is null.");
            return;
        }
        try {
            if (MemLeakManager.getMemLeakConfigManager() == null || !MemLeakManager.getMemLeakConfigManager().enableTracer()) {
                return;
            }
            UMonitor.init((Application) context.getApplicationContext());
            UMonitor.initJavaMonitor(new UMonitorConfigJava.Builder().setHeapThreshold(0.8f).setEnableHprofDumpAnalysis(true).setReporter(new UMonitorReporter() { // from class: com.efs.sdk.memleaksdk.monitor.internal.a.1
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.efs.sdk.memleaksdk.monitor.UMonitorReporter
                public void onJavaHeap(File file, JSONObject jSONObject) {
                    try {
                        EfsJSONLog efsJSONLog = new EfsJSONLog("memanalysisperf");
                        efsJSONLog.put("analysis_json", jSONObject);
                        efsJSONLog.put("diskInfo", df.b(context));
                        efsJSONLog.put("batteryInfo", df.a(context));
                        efsJSONLog.put("memInfo", df.b());
                        efsJSONLog.put("memoryInfo", df.a());
                        efsJSONLog.put("um_custom_info", MemLeakManager.getUMCustomInfo());
                        try {
                            String strOnGetCallbackInfo = MemLeakManager.getMemLeakClient().onGetCallbackInfo("um_user_string");
                            if (MemLeakManager.getMemLeakClient() != null && !TextUtils.isEmpty(strOnGetCallbackInfo)) {
                                efsJSONLog.put("um_user_string", strOnGetCallbackInfo);
                            }
                            String strOnGetCallbackInfo2 = MemLeakManager.getMemLeakClient().onGetCallbackInfo("um_action_log");
                            if (MemLeakManager.getMemLeakClient() != null && !TextUtils.isEmpty(strOnGetCallbackInfo2)) {
                                efsJSONLog.put("um_action_log", strOnGetCallbackInfo2);
                            }
                            String customMappingJsonStr = InnerCustomMappingManager.getCustomMappingJsonStr();
                            if (!TextUtils.isEmpty(customMappingJsonStr)) {
                                efsJSONLog.put("um_custom_mapping", customMappingJsonStr);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        EfsReporter efsReporter2 = efsReporter;
                        if (efsReporter2 != null) {
                            efsReporter2.send(efsJSONLog);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }).build());
            UMonitor.startJavaMonitor(2000L);
        } catch (Throwable unused) {
        }
    }
}
