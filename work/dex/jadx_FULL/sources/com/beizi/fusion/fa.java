package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class fa extends za {
    public fa(Context context) {
        super(context);
    }

    public String a(ConfigResponseModel configResponseModel) {
        if (configResponseModel != null && configResponseModel.getRequestUrl() != null) {
            String adURL = configResponseModel.getRequestUrl().getAdURL();
            if (!TextUtils.isEmpty(adURL)) {
                return adURL;
            }
        }
        return a();
    }

    private String a() {
        g gVar = (g) h.a().b(this.f28103a);
        if (gVar == null) {
            return null;
        }
        v vVarA = gVar.a();
        return f3.c(((vVarA == null || !vVarA.z()) ? "aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FwaS92My9hZC9nZXRBZA==" : "aHR0cHM6Ly9zZGstYXBpLmFkbi1wbHVzLmNvbS5jbi9hcGkvdjMvYWQvZ2V0QWQ=").getBytes());
    }
}
