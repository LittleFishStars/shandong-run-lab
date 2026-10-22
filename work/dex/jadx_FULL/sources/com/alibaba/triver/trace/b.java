package com.alibaba.triver.trace;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.taobao.tlog.adapter.AdapterForTraceLog;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25193a = "TR_REMOTE_LOG";
    private static StringBuilder b = new StringBuilder();

    /* JADX INFO: renamed from: com.alibaba.triver.trace.b$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25194a;

        static {
            int[] iArr = new int[IRemoteLogProxy.LogLevel.values().length];
            f25194a = iArr;
            try {
                iArr[IRemoteLogProxy.LogLevel.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25194a[IRemoteLogProxy.LogLevel.Info.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25194a[IRemoteLogProxy.LogLevel.Debug.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25194a[IRemoteLogProxy.LogLevel.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25194a[IRemoteLogProxy.LogLevel.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a(String str) {
        StringBuilder sb = b;
        if (sb != null) {
            sb.append(str);
            sb.append("\n");
        }
    }

    public static String b() {
        StringBuilder sb = b;
        return sb != null ? sb.toString() : "";
    }

    public static void a() {
        if (b != null) {
            b = new StringBuilder();
        }
    }

    public static void b(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        try {
            a(IRemoteLogProxy.LogLevel.Error, str, "error", str2, str3, "", "", str4, str5, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2, String str3, Page page, JSONObject jSONObject) {
        String appId;
        String strValueOf = "";
        if (page != null) {
            try {
                appId = page.getApp() == null ? "" : page.getApp().getAppId();
            } catch (Throwable unused) {
                return;
            }
        }
        if (page != null) {
            strValueOf = String.valueOf(page.getPageId());
        }
        a(IRemoteLogProxy.LogLevel.Debug, str, SQLiteMTAHelper.TABLE_POINT, str2, str3, appId, strValueOf, "0", "", jSONObject);
    }

    private static void a(IRemoteLogProxy.LogLevel logLevel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("moduleName", (Object) str);
            try {
                jSONObject2.put("time", (Object) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
            } catch (Throwable unused) {
            }
            jSONObject2.put(str2, (Object) str3);
            jSONObject2.put("ID", (Object) (str4 + LoginConstants.UNDER_LINE + str));
            jSONObject2.put("PID", (Object) str4);
            jSONObject2.put("errorCode", (Object) str7);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, (Object) str8);
            JSONObject jSONObject3 = jSONObject == null ? new JSONObject() : jSONObject;
            jSONObject3.put("appId", (Object) str5);
            jSONObject3.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, (Object) str6);
            jSONObject2.put(LoginConstants.EXT, (Object) jSONObject3);
            int i = AnonymousClass1.f25194a[logLevel.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                RVLogger.e(f25193a, jSONObject2.toJSONString());
                AdapterForTraceLog.event(str4, str6, str, System.currentTimeMillis(), str3, str7, str8, jSONObject2.toJSONString());
                a(jSONObject2.toJSONString());
            }
        } catch (Throwable unused2) {
        }
    }

    private static void a(IRemoteLogProxy.LogLevel logLevel, String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("moduleName", (Object) str);
            try {
                jSONObject2.put("time", (Object) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
            } catch (Throwable unused) {
            }
            jSONObject2.put(str2, (Object) str3);
            jSONObject2.put("ID", (Object) (str4 + LoginConstants.UNDER_LINE + str));
            jSONObject2.put("PID", (Object) str4);
            jSONObject2.put("appId", (Object) str5);
            jSONObject2.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, (Object) str6);
            jSONObject2.put(LoginConstants.EXT, (Object) (jSONObject == null ? new JSONObject() : jSONObject));
            int i = AnonymousClass1.f25194a[logLevel.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                RVLogger.e(f25193a, jSONObject2.toJSONString());
                AdapterForTraceLog.event(str4, str6, str, System.currentTimeMillis(), str3, "", "", jSONObject2.toJSONString());
                a(jSONObject2.toJSONString());
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(String str, String str2, String str3, JSONObject jSONObject) {
        try {
            a(IRemoteLogProxy.LogLevel.Debug, str, "event", str2, str3, "", "", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, App app, Page page, JSONObject jSONObject) {
        String appId;
        String strValueOf = "";
        if (app == null) {
            appId = "";
        } else {
            try {
                appId = app.getAppId();
            } catch (Throwable unused) {
                return;
            }
        }
        if (page != null) {
            strValueOf = String.valueOf(page.getPageId());
        }
        a(IRemoteLogProxy.LogLevel.Debug, str, "event", str2, str3, appId, strValueOf, jSONObject);
    }

    public static void a(String str, String str2, String str3, Page page, JSONObject jSONObject) {
        String appId;
        String strValueOf = "";
        if (page != null) {
            try {
                appId = page.getApp() == null ? "" : page.getApp().getAppId();
            } catch (Throwable unused) {
                return;
            }
        }
        if (page != null) {
            strValueOf = String.valueOf(page.getPageId());
        }
        a(IRemoteLogProxy.LogLevel.Debug, str, "event", str2, str3, appId, strValueOf, jSONObject);
    }

    public static void a(String str, String str2, String str3, App app, JSONObject jSONObject) {
        String appId;
        if (app == null) {
            appId = "";
        } else {
            try {
                appId = app.getAppId();
            } catch (Throwable unused) {
                return;
            }
        }
        a(IRemoteLogProxy.LogLevel.Debug, str, "event", str2, str3, appId, "", jSONObject);
    }

    public static void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        try {
            a(IRemoteLogProxy.LogLevel.Debug, str, "event", str2, str3, str4, "", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        try {
            a(IRemoteLogProxy.LogLevel.Debug, str, "event", str2, str3, str4, str5, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, Page page, String str4, String str5, JSONObject jSONObject) {
        String appId;
        String strValueOf = "";
        if (page != null) {
            try {
                appId = page.getApp() == null ? "" : page.getApp().getAppId();
            } catch (Throwable unused) {
                return;
            }
        }
        if (page != null) {
            strValueOf = String.valueOf(page.getPageId());
        }
        a(IRemoteLogProxy.LogLevel.Error, str, "error", str2, str3, appId, strValueOf, str4, str5, jSONObject);
    }

    public static void a(String str, String str2, String str3, App app, String str4, String str5, JSONObject jSONObject) {
        String appId;
        if (app == null) {
            appId = "";
        } else {
            try {
                appId = app.getAppId();
            } catch (Throwable unused) {
                return;
            }
        }
        a(IRemoteLogProxy.LogLevel.Error, str, "error", str2, str3, appId, "", str4, str5, jSONObject);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        try {
            a(IRemoteLogProxy.LogLevel.Error, str, "error", str2, str3, str4, "", str5, str6, jSONObject);
        } catch (Throwable unused) {
        }
    }
}
