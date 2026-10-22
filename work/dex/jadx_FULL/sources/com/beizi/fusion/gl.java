package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.requrl.RequestUrlModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27350a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static gl f27351a = new gl();
    }

    private gl() {
        this.f27350a = false;
        if (a.f27351a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public synchronized void a(Context context, RequestUrlModel requestUrlModel) {
        if (!this.f27350a) {
            this.f27350a = true;
            if (requestUrlModel != null) {
                String preloadAdURL = requestUrlModel.getPreloadAdURL();
                String preloadImageUrl = requestUrlModel.getPreloadImageUrl();
                fb fbVar = (fb) cn.a().b(context.getApplicationContext());
                if (!TextUtils.isEmpty(preloadAdURL)) {
                    fbVar.b(new fl(context, preloadAdURL));
                }
                if (!TextUtils.isEmpty(preloadImageUrl)) {
                    fbVar.b(new hl(context, preloadImageUrl));
                }
            }
        }
    }

    public static gl a() {
        return a.f27351a;
    }
}
