package com.alibaba.triver.open.prefetch.expr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.IUserInfoExtension;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25073a = "ExprParser";
    private static final Map<String, b> b = new HashMap();
    private static final Map<String, InterfaceC0174a> c = new HashMap();
    private static com.alibaba.triver.open.prefetch.expr.b d = new com.alibaba.triver.open.prefetch.expr.b() { // from class: com.alibaba.triver.open.prefetch.expr.a.1
        @Override // com.alibaba.triver.open.prefetch.expr.b
        public a a(ExprParserParams exprParserParams) {
            return new a(exprParserParams);
        }
    };
    private ExprParserParams e;

    /* JADX INFO: renamed from: com.alibaba.triver.open.prefetch.expr.a$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25074a;

        static {
            int[] iArr = new int[PrefetchParamsExpression.values().length];
            f25074a = iArr;
            try {
                iArr[PrefetchParamsExpression.APP_DEVICEID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25074a[PrefetchParamsExpression.APP_UTDID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25074a[PrefetchParamsExpression.APP_TTID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25074a[PrefetchParamsExpression.LOGIN_USERID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25074a[PrefetchParamsExpression.OS_MODEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25074a[PrefetchParamsExpression.OS_VERSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25074a[PrefetchParamsExpression.FILE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25074a[PrefetchParamsExpression.URL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25074a[PrefetchParamsExpression.FOREACH_QUERY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25074a[PrefetchParamsExpression.FOREACH_INTENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25074a[PrefetchParamsExpression.INTENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f25074a[PrefetchParamsExpression.EXT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f25074a[PrefetchParamsExpression.KV_EXT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.triver.open.prefetch.expr.a$a, reason: collision with other inner class name */
    public interface InterfaceC0174a {
        JSONObject a(Context context, Intent intent);
    }

    public interface b {
        String a(Context context);
    }

    public static boolean a(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return false;
        }
        b.put(str, bVar);
        return true;
    }

    private String b(String str) {
        try {
            if (c() == null) {
                return null;
            }
            Map<String, String[]> map = this.e.subParam;
            String[] strArr = map == null ? null : map.get(str);
            if (strArr != null && strArr.length >= 1) {
                Uri uriC = c();
                String queryParameter = uriC.getQueryParameter("page");
                String queryParameter2 = uriC.getQueryParameter("query");
                if (!TextUtils.isEmpty(queryParameter)) {
                    return Uri.parse(queryParameter).getQueryParameter(strArr[0]);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    new LinkedHashMap();
                    for (String str2 : queryParameter2.split("&")) {
                        String[] strArrSplit = str2.split("=");
                        if (strArr[0].equals(strArrSplit[0])) {
                            return strArrSplit[1];
                        }
                    }
                }
                return c().getQueryParameter(strArr[0]);
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(f25073a, "parseUrlParams error", th);
            return null;
        }
    }

    private String c(String str) {
        try {
            Intent intent = this.e.intent;
            Bundle extras = intent == null ? null : intent.getExtras();
            if (extras == null) {
                return null;
            }
            Map<String, String[]> map = this.e.subParam;
            String[] strArr = map == null ? null : map.get(str);
            if (strArr != null && strArr.length >= 1) {
                return extras.getString(strArr[0]);
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(f25073a, "parseIntentParams error", th);
            return null;
        }
    }

    private String d(String str) {
        b bVar;
        Map<String, String[]> map = this.e.subParam;
        String[] strArr = map == null ? null : map.get(str);
        if (strArr == null || strArr.length < 1 || (bVar = b.get(strArr[0])) == null) {
            return null;
        }
        return bVar.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    private JSONObject e(String str) {
        InterfaceC0174a interfaceC0174a;
        Map<String, String[]> map = this.e.subParam;
        String[] strArr = map == null ? null : map.get(str);
        if (strArr == null || strArr.length < 1 || (interfaceC0174a = c.get(strArr[0])) == null) {
            return null;
        }
        return interfaceC0174a.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), this.e.intent);
    }

    private a(ExprParserParams exprParserParams) {
        this.e = exprParserParams;
    }

    public static boolean a(String str, InterfaceC0174a interfaceC0174a) {
        if (TextUtils.isEmpty(str) || interfaceC0174a == null) {
            return false;
        }
        c.put(str, interfaceC0174a);
        return true;
    }

    public static boolean a(com.alibaba.triver.open.prefetch.expr.b bVar) {
        if (bVar == null) {
            return false;
        }
        d = bVar;
        return true;
    }

    public static a a(ExprParserParams exprParserParams) {
        return d.a(exprParserParams);
    }

    private Uri c() {
        ExprParserParams exprParserParams = this.e;
        if (exprParserParams.uri == null) {
            try {
                exprParserParams.uri = Uri.parse(exprParserParams.targetUrl);
            } catch (Throwable th) {
                RVLogger.e(f25073a, "parse url error, url=" + this.e.targetUrl, th);
            }
        }
        return this.e.uri;
    }

    public Object a(String str, String str2) {
        PrefetchParamsExpression byExpression = PrefetchParamsExpression.getByExpression(str2);
        return byExpression == null ? str2 : a(str, byExpression);
    }

    public Object a(String str, Object obj) {
        if (!(obj instanceof PrefetchParamsExpression)) {
            return obj;
        }
        switch (AnonymousClass2.f25074a[((PrefetchParamsExpression) obj).ordinal()]) {
            case 1:
            case 2:
                return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("utdId");
            case 3:
                return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("ttid");
            case 4:
                IUserInfoExtension iUserInfoExtension = (IUserInfoExtension) ExtensionPoint.as(IUserInfoExtension.class).create();
                if (iUserInfoExtension != null) {
                    return iUserInfoExtension.getUserId();
                }
                return null;
            case 5:
                return Build.MODEL;
            case 6:
                return String.valueOf(Build.VERSION.SDK_INT);
            case 7:
                return a(str);
            case 8:
                return b(str);
            case 9:
                return a();
            case 10:
                return b();
            case 11:
                return c(str);
            case 12:
                return d(str);
            case 13:
                return e(str);
            default:
                return obj.toString();
        }
    }

    private JSONObject b() {
        try {
            Intent intent = this.e.intent;
            Bundle extras = intent == null ? null : intent.getExtras();
            if (extras != null && !extras.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (String str : extras.keySet()) {
                    List<String> list = this.e.blacklist;
                    if (list == null || !list.contains(str)) {
                        jSONObject.put(str, (Object) extras.getString(str));
                    }
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(f25073a, "foreachQueryIntent error", th);
            return null;
        }
    }

    private String a(String str) {
        SharedPreferences sharedPreferences;
        try {
            Map<String, String[]> map = this.e.subParam;
            String[] strArr = map == null ? null : map.get(str);
            if (strArr != null && strArr.length >= 2 && (sharedPreferences = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSharedPreferences(strArr[0], 0)) != null) {
                return sharedPreferences.getString(strArr[1], null);
            }
        } catch (Throwable th) {
            RVLogger.e(f25073a, "parseFileValue error", th);
        }
        return null;
    }

    private JSONObject a() {
        Set<String> queryParameterNames;
        try {
            Uri uriC = c();
            if (uriC != null && (queryParameterNames = uriC.getQueryParameterNames()) != null && !queryParameterNames.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (String str : queryParameterNames) {
                    List<String> list = this.e.blacklist;
                    if (list == null || !list.contains(str)) {
                        jSONObject.put(str, (Object) uriC.getQueryParameter(str));
                    }
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(f25073a, "parseUrlParams error", th);
            return null;
        }
    }
}
