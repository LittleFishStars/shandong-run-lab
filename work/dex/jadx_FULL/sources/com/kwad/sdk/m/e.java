package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.utils.ab;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class e {

    public interface a {
        void a(String str, long j, long j2, String str2, String str3);

        void onError(String str);
    }

    public static void a(String str, final String str2, final a aVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                aVar.onError("getPluginByClass is null");
                return;
            }
            final PluginListener pluginListener = (PluginListener) ab.getField(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    ab.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.m.e.1
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.d.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.onError(Log.getStackTraceString(th));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(str2)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.d.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String strQ = e.q(content);
                                    long jR = e.r(content);
                                    long jS = e.s(content);
                                    String strT = e.t(content);
                                    String strU = e.u(content);
                                    a aVar3 = aVar;
                                    if (aVar3 != null) {
                                        aVar3.a(strQ, jS, jR, strT, strU);
                                    }
                                } catch (Throwable unused) {
                                }
                                pluginListener.onReportIssue(issue);
                            } else if (TextUtils.equals(method.getName(), "onInit")) {
                                pluginListener.onInit((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStop")) {
                                pluginListener.onStop((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onDestroy")) {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                            } else {
                                try {
                                    method.invoke(pluginListener, objArr);
                                } catch (Throwable th2) {
                                    com.kwad.sdk.core.d.c.e("perfMonitor.RangerInjector", Log.getStackTraceString(th2));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (Exception e) {
                    aVar.onError(Log.getStackTraceString(e));
                }
            }
        } catch (Exception e2) {
            aVar.onError(Log.getStackTraceString(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long r(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("time");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(JSONObject jSONObject) {
        try {
            return jSONObject.optString("process");
        } catch (Exception unused) {
            return "";
        }
    }
}
