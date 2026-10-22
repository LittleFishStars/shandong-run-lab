package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface rd {

    public static class a {
        public static rd a(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
            return new ni(context, adItemModel, baVar, adTraceModel);
        }
    }

    AdTraceModel a();

    ba b();

    AdItemModel c();

    Context getContext();
}
