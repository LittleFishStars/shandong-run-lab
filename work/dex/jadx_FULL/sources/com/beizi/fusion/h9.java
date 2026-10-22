package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class h9 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h9 f27360a = new h9();
    }

    private h9() {
    }

    public static h9 a() {
        return a.f27360a;
    }

    public pa b(Context context, AdItemModel adItemModel, pa.a aVar) {
        if (adItemModel != null) {
            return a(context, adItemModel, aVar);
        }
        return null;
    }

    private pa a(Context context, AdItemModel adItemModel, pa.a aVar) {
        return new wl(context, adItemModel, aVar);
    }
}
