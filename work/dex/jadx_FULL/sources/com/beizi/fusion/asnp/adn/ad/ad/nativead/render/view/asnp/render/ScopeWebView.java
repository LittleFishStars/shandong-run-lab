package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.he;
import com.beizi.fusion.no;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeWebView extends BasicWebView implements he {
    private String b;
    protected RenderModel c;
    protected AssetModel d;
    private ScopeExpressContainer e;

    public ScopeWebView(@NonNull Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.he
    public void bindAssetModel(AssetModel assetModel) {
        this.d = assetModel;
    }

    @Override // com.beizi.fusion.he
    public void bindRenderModel(RenderModel renderModel) {
        this.c = renderModel;
    }

    @Override // com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        if (aVar != null) {
            aVar.b(this.c.getId());
        }
    }

    @Override // com.beizi.fusion.he
    public ScopeExpressContainer getExpressRoot() {
        return this.e;
    }

    @Override // com.beizi.fusion.he
    public int getLayer() {
        return this.c.getLayer();
    }

    @Override // com.beizi.fusion.he
    public String getScopeViewID() {
        return this.b;
    }

    @Override // com.beizi.fusion.he
    public void onViewDestroy() {
    }

    @Override // com.beizi.fusion.he
    public void onViewPause(boolean z) {
    }

    @Override // com.beizi.fusion.he
    public void onViewResume(boolean z) {
    }

    @Override // com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        this.e = scopeExpressContainer;
    }

    @Override // com.beizi.fusion.he
    public void setScopeViewID(String str) {
        this.b = str;
        setId(no.i(str));
    }

    public ScopeWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
