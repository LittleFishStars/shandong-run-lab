package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface vc extends ib {

    public static class a {
        public static vc a(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
            return (baVar == null || d.VIDEO != baVar.b()) ? new uf(context, adItemModel, baVar, adTraceModel) : new tf(context, adItemModel, baVar, adTraceModel);
        }
    }

    void a(de deVar);

    void k();
}
