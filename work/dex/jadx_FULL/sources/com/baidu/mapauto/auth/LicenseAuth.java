package com.baidu.mapauto.auth;

import android.content.Context;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.util.LogUtil;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LicenseAuth {
    public static volatile LicenseAuth b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthCore f26592a = new AuthCore();

    public static LicenseAuth getInstance() {
        if (b == null) {
            synchronized (LicenseAuth.class) {
                if (b == null) {
                    b = new LicenseAuth();
                }
            }
        }
        return b;
    }

    public void loadAuth(Context context, String str, String str2, String str3, String str4, int i, ILicenseAuthListener iLicenseAuthListener) {
        loadAuth(context, str, str2, str3, str4, null, i, null, iLicenseAuthListener);
    }

    public void loadAuth(Context context, String str, String str2, String str3, String str4, int i, Map<String, Object> map, ILicenseAuthListener iLicenseAuthListener) {
        loadAuth(context, str, str2, str3, str4, null, i, map, iLicenseAuthListener);
    }

    public void loadAuth(Context context, String str, String str2, String str3, String str4, String str5, int i, Map<String, Object> map, ILicenseAuthListener iLicenseAuthListener) {
        String str6;
        AuthCore authCore = this.f26592a;
        Context applicationContext = context.getApplicationContext();
        AuthCore.AuthParam authParam = new AuthCore.AuthParam(str, str2, str3, str4, str5, map);
        authCore.getClass();
        LogUtil.getInstance().i(AuthCore.TAG, "开始授权");
        AuthCore.b bVar = new AuthCore.b(iLicenseAuthListener);
        if (applicationContext == null) {
            str6 = "context 不可以为空";
        } else {
            if (authParam.a(i)) {
                authCore.g = authParam.b();
                authCore.h = authParam.d();
                authCore.i = authParam.c();
                if (authCore.b == null) {
                    synchronized (AuthCore.class) {
                        if (authCore.b == null) {
                            authCore.b = new com.baidu.mapauto.auth.data.license.impl.b(new com.baidu.mapauto.auth.store.a(applicationContext));
                        }
                    }
                }
                if (authCore.e == null) {
                    synchronized (AuthCore.class) {
                        if (authCore.e == null) {
                            authCore.e = new com.baidu.mapauto.auth.process.a(3, authCore.f26588a, authCore.b);
                        }
                    }
                }
                if (authCore.f == null) {
                    synchronized (AuthCore.class) {
                        if (authCore.f == null) {
                            authCore.f = new com.baidu.mapauto.auth.process.b(3, authCore.f26588a, authCore.b);
                        }
                    }
                }
                if (authCore.b instanceof com.baidu.mapauto.auth.data.license.impl.b) {
                    com.baidu.mapauto.auth.data.license.impl.b bVar2 = authCore.b;
                    String strB = authParam.b();
                    authParam.c();
                    authParam.e();
                    Object obj = authParam.get("function_name");
                    if (obj instanceof String) {
                    }
                    String strD = authParam.d();
                    bVar2.getClass();
                    bVar2.b = strB + strD;
                }
                authCore.c.submit(new b(authCore, i, bVar, authParam));
                return;
            }
            str6 = "参数错误, 请确保 ak, channel, serviceName 、 file 类型下时的 deviceId 不为空";
        }
        bVar.onError(-1002, str6);
    }

    public Map<String, Integer> loadLocalAuth(Context context, String str, String str2, int i) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f26592a.a(context, null, null, null, str, str2, i);
    }

    public Map<String, Integer> loadLocalAuth(Context context, String str, String str2, String str3, int i) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f26592a.a(context, null, null, str, str2, str3, i);
    }

    public Map<String, Integer> loadLocalAuth(Context context, String str, String str2, String str3, String str4, String str5, int i) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f26592a.a(context, str, str3, str2, str4, str5, i);
    }

    public void setDebug(Boolean bool) {
        LogUtil.getInstance().openLog(bool);
    }
}
