package com.fl.saas;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceStateUtil;
import com.fl.saas.adx.util.DeviceUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fl.saas.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1408f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C1408f0 f30164a;

    /* JADX INFO: renamed from: com.fl.saas.f0$a */
    public class a implements T {
        public a() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("code", 1) == 0) {
                    String strOptString = jSONObject.optString("status");
                    if ("A".equals(strOptString)) {
                        String strOptString2 = jSONObject.optString("value");
                        if (TextUtils.isEmpty(strOptString2) || "null".equalsIgnoreCase(strOptString2)) {
                            AbstractC1447z.b();
                        } else {
                            C1408f0.this.a(strOptString2);
                        }
                    } else if ("D".equals(strOptString)) {
                        AbstractC1447z.a();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            exc.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.f0$b */
    public class b implements T {
        public b() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                final String strOptString = new JSONObject(str).optString("content");
                c1.a().b(new Runnable() { // from class: com.fl.saas.l1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1447z.b(strOptString);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
        }
    }

    private C1408f0() {
    }

    private JSONObject c() {
        int iA = 0;
        int iA2 = S0.a().a("key_zz_number", 0);
        if (iA2 > 0) {
            String strA = S0.a().a("key_zz_value", "");
            if (!TextUtils.isEmpty(strA)) {
                iA = AbstractC1447z.a(strA);
            }
        } else {
            iA = iA2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", DeviceUtil.getReqID(""));
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("dpVersion", Integer.valueOf(iA));
            jSONObject.putOpt("sdkPackageName", CommConstant.SdkVersion.SDK_PACKAGE_NAME);
            JSONObject deviceInfo = DeviceUtil.getDeviceInfo();
            deviceInfo.put("usbEnabled", DeviceStateUtil.isDeveloperOptionsEnabled(DeviceUtil.getContext()) ? 1 : 0);
            deviceInfo.put("proxyEnabled", DeviceStateUtil.isNetworkProxyEnabled(DeviceUtil.getContext()) ? 1 : 0);
            deviceInfo.put("rootEnabled", DeviceStateUtil.isDeviceRooted() ? 1 : 0);
            deviceInfo.put("isDebug", DeviceStateUtil.isDebug() ? 1 : 0);
            deviceInfo.put("hasSimCard", DeviceStateUtil.hasSimCard(DeviceUtil.getContext()) ? 1 : 0);
            jSONObject.putOpt("device", deviceInfo);
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(String str) {
        C1401c.c().a("http://39.107.124.86/api/dp/content?md5=" + str, new b());
    }

    public void b() {
        C1401c.c().a("http://39.107.124.86/api/dp/config", AbstractC1417k.e(c().toString()), new a());
    }

    public static C1408f0 a() {
        if (f30164a == null) {
            synchronized (C1408f0.class) {
                f30164a = new C1408f0();
            }
        }
        return f30164a;
    }
}
