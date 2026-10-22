package com.kc.cw.ad.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o {
    public static void a(l lVar) {
        if (a()) {
            ThreadUtils.runOnLogThreadPool(new Runnable(lVar) { // from class: com.kc.cw.ad.internal.o.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final l f39049a;

                {
                    this.f39049a = lVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String strA;
                    try {
                        Context contextL = q.a().l();
                        if (contextL != null && this.f39049a != null) {
                            JSONObject jSONObject = new JSONObject();
                            String strA2 = this.f39049a.a();
                            if (TextUtils.isEmpty(strA2)) {
                                return;
                            }
                            jSONObject.put("type", strA2);
                            if (strA2.equals("INIT") || strA2.equals("CFG")) {
                                jSONObject.put("appId", this.f39049a.b());
                            } else {
                                jSONObject.put("slotId", this.f39049a.f());
                                jSONObject.put("reqId", this.f39049a.e());
                                if (!strA2.equals("REQ") && !strA2.equals("LOAD")) {
                                    jSONObject.put("ptime", this.f39049a.g());
                                }
                            }
                            if (strA2.equals("REQ")) {
                                jSONObject.put("retryReq", this.f39049a.d());
                            }
                            if (strA2.equals("RES")) {
                                jSONObject.put("bid", this.f39049a.h());
                            }
                            if (strA2.equals("IMP") || strA2.equals("CLK")) {
                                jSONObject.put(RenderCallContext.TYPE_CALLBACK, this.f39049a.i());
                            }
                            if (strA2.equals("INIT") || strA2.equals("CFG") || strA2.equals("REWARD") || strA2.equals("CHANGECONFIG")) {
                                jSONObject.put("result", this.f39049a.c());
                            }
                            if (!TextUtils.isEmpty(this.f39049a.j())) {
                                jSONObject.put("extra", this.f39049a.j());
                            }
                            jSONObject.put("appVersion", com.kc.cw.ad.d.b.i.e(contextL));
                            jSONObject.put("brand", Build.BRAND);
                            jSONObject.put(ze1.k, Build.MODEL);
                            jSONObject.put("os", "Android");
                            jSONObject.put("bundle", contextL.getPackageName());
                            jSONObject.put("deviceId", SSAd.getOaid(contextL));
                            jSONObject.put("sdkVersion", "2.6.1.8");
                            jSONObject.put("osv", Build.VERSION.RELEASE + LoginConstants.UNDER_LINE + Build.VERSION.SDK_INT);
                            StringBuilder sb = new StringBuilder();
                            sb.append(q.a().n());
                            sb.append("/sdk/logReport");
                            String string = sb.toString();
                            Boolean bool = (Boolean) com.kc.cw.ad.internal.c.o.c(contextL, "encrypt", Boolean.TRUE);
                            if (bool == null || bool.booleanValue()) {
                                strA = com.kc.cw.ad.d.b.a.a(com.kc.cw.ad.d.b.e.a(), jSONObject.toString());
                                if (strA == null) {
                                    strA = "";
                                }
                            } else {
                                string = string + "?test=1";
                                strA = jSONObject.toString();
                            }
                            com.kc.cw.ad.d.b.d.a(string, strA.getBytes());
                        }
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            });
        }
    }

    private static boolean a() {
        return com.kc.cw.ad.internal.c.o.a(q.a().l(), "logReportFlag", false);
    }
}
