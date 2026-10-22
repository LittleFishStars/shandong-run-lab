package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gq {
    private static volatile gq e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27353a;
    private String b;
    private Boolean c;
    private volatile IWXAPI d;

    private gq(Context context) {
        this.f27353a = context.getApplicationContext();
    }

    public static gq a(Context context) {
        if (e == null) {
            synchronized (gq.class) {
                if (e == null) {
                    e = new gq(context);
                }
            }
        }
        return e;
    }

    public boolean b(Context context) {
        if (d()) {
            String strA = a();
            if (!TextUtils.isEmpty(strA)) {
                return a(strA).isWXAppInstalled();
            }
        }
        return xk.c(context, "com.tencent.mm");
    }

    public String c() {
        if (!d()) {
            return "";
        }
        String strA = a();
        return !TextUtils.isEmpty(strA) ? String.valueOf(a(strA).getWXAppSupportAPI()) : "";
    }

    public boolean d() {
        if (this.c == null) {
            this.c = Boolean.valueOf(pl.a("com.tencent.mm.opensdk.openapi.IWXAPI"));
        }
        return this.c.booleanValue();
    }

    public String b() {
        if (!d()) {
            return "";
        }
        try {
            return String.valueOf(638067200);
        } catch (Exception unused) {
            return "";
        }
    }

    public String a() {
        ConfigResponseModel configResponseModelA;
        if (!d()) {
            return "";
        }
        if (TextUtils.isEmpty(this.b) && (configResponseModelA = ((g) h.a().b(this.f27353a)).a(false)) != null && configResponseModelA.getExtraConfigModel() != null) {
            String wxOpenApiKey = configResponseModelA.getExtraConfigModel().getWxOpenApiKey();
            if (!TextUtils.isEmpty(wxOpenApiKey)) {
                this.b = wxOpenApiKey;
            }
        }
        return this.b;
    }

    public boolean b(String str) {
        if (d() && !TextUtils.isEmpty(str)) {
            String strA = a();
            if (!TextUtils.isEmpty(strA)) {
                IWXAPI iwxapiA = a(strA);
                WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
                req.businessType = "nativeOpenAdCanvas";
                req.extInfo = str;
                return iwxapiA.sendReq(req);
            }
        }
        return false;
    }

    private IWXAPI a(String str) {
        if (this.d == null) {
            synchronized (gq.class) {
                if (this.d == null) {
                    this.d = WXAPIFactory.createWXAPI(this.f27353a, str);
                }
            }
        }
        return this.d;
    }

    public boolean a(String str, String str2, String str3) {
        if (d() && !TextUtils.isEmpty(str)) {
            String strA = a();
            if (!TextUtils.isEmpty(strA)) {
                IWXAPI iwxapiA = a(strA);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                req.path = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                req.extData = str3;
                return iwxapiA.sendReq(req);
            }
        }
        return false;
    }
}
