package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface he {

    public interface a {
        void a(String str);

        void b(String str);
    }

    void bindAssetModel(AssetModel assetModel);

    void bindRenderModel(RenderModel renderModel);

    void fillContent(a aVar);

    Context getContext();

    ScopeExpressContainer getExpressRoot();

    int getLayer();

    String getScopeViewID();

    void onViewDestroy();

    void onViewPause(boolean z);

    void onViewResume(boolean z);

    void setExpressRoot(ScopeExpressContainer scopeExpressContainer);

    void setScopeViewID(String str);
}
