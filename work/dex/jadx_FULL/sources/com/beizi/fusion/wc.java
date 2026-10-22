package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.asnp.adn.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface wc extends ib {

    public static class a {
        public static wc a(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
            return new vf(context, adItemModel, baVar, adTraceModel);
        }
    }

    void a(Activity activity, ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer, List list);

    List c();

    bf d();

    String g();

    String getAdLogoUrl();

    String getDesc();

    String getIconUrl();

    String getTitle();

    String h();

    u0 i();
}
