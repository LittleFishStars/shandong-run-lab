package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ce {

    public static class a {
        public static ce a(Context context, ba baVar) {
            return baVar.b() == d.UNIFIED ? new dn(context, baVar) : new zm(context, baVar);
        }
    }

    View a();

    boolean a(AdItemModel adItemModel);

    void b();

    void c();
}
