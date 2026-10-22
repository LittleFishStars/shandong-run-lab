package com.efs.sdk.base.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVParams;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f29562a;
    String b;
    String c;
    public String d;
    public int e;
    public String f;
    public byte g;
    public String h;
    String i;
    String j;
    String k;
    String l;
    String m = "";
    String n = "";
    public long o = 0;

    public static c a() {
        c cVar = new c();
        cVar.f29562a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.m = ControllerCenter.getGlobalEnvStruct().getLogUid();
        cVar.n = ControllerCenter.getGlobalEnvStruct().getLogDid();
        cVar.j = BuildConfig.VERSION_NAME;
        cVar.c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.i = String.valueOf(com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion);
        cVar.k = "2.0.2";
        return cVar;
    }

    public final String b() {
        a.a();
        String strValueOf = String.valueOf(a.b() / 1000);
        String strBase64EncodeToStr = EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(this.l + strValueOf, this.b));
        String strBase64EncodeToStr2 = EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(EncodeUtil.base64DecodeToStr(this.m.getBytes()) + LoginConstants.UNDER_LINE + strValueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put(NativeCallContext.DOMAIN_APP, this.f29562a);
        treeMap.put("sd", strBase64EncodeToStr);
        treeMap.put("logud", strBase64EncodeToStr2);
        String strA = a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        if (!TextUtils.isEmpty(strA)) {
            String strBase64EncodeToStr3 = EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(strA + LoginConstants.UNDER_LINE + strValueOf, this.b));
            treeMap.put("wl_dd", strBase64EncodeToStr3);
            treeMap.put("logdd", strBase64EncodeToStr3);
        }
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put(com.alipay.sdk.m.m.b.m, this.d);
        }
        if (this.g != 0) {
            treeMap.put("de", String.valueOf(this.e));
            treeMap.put("type", this.h);
            String str = this.f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long jB = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(jB), Integer.valueOf(new Random(jB).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.i);
        treeMap.put("os", "android");
        treeMap.put("sver", this.i);
        treeMap.put(RVParams.TOOLBAR_MENU, strValueOf);
        treeMap.put("ver", this.c);
        treeMap.put("um_sdk_ver", this.k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        String strMd5 = EncodeUtil.md5(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(strMd5);
        Log.d("efs.config", sb.toString());
        return EncodeUtil.urlEncode(sb.toString());
    }

    private static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }
}
