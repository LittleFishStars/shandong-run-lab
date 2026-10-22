package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.he;
import com.beizi.fusion.no;
import com.beizi.fusion.un;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeSimpleView extends View implements he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27047a;
    protected RenderModel b;
    protected AssetModel c;
    private ScopeExpressContainer d;

    public ScopeSimpleView(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.he
    public void bindAssetModel(AssetModel assetModel) {
        this.c = assetModel;
    }

    public void bindRenderModel(RenderModel renderModel) {
        this.b = renderModel;
    }

    public void fillContent(he.a aVar) {
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getViewModel() == null) {
            return;
        }
        ViewModel viewModel = this.b.getViewModel();
        un.a(getContext(), this, viewModel.getBgColor(), no.i(viewModel.getBorderSize()), viewModel.getBorderColor(), un.a(viewModel.getBorderRadius(), getLayoutParams().height));
        aVar.b(this.b.getId());
    }

    @Override // com.beizi.fusion.he
    public ScopeExpressContainer getExpressRoot() {
        return this.d;
    }

    @Override // com.beizi.fusion.he
    public int getLayer() {
        return this.b.getLayer();
    }

    @Override // com.beizi.fusion.he
    public String getScopeViewID() {
        return this.f27047a;
    }

    @Override // com.beizi.fusion.he
    public void onViewDestroy() {
    }

    public void onViewPause(boolean z) {
    }

    public void onViewResume(boolean z) {
    }

    @Override // com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        this.d = scopeExpressContainer;
    }

    @Override // com.beizi.fusion.he
    public void setScopeViewID(String str) {
        this.f27047a = str;
        setId(no.i(str));
    }

    public ScopeSimpleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeSimpleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeSimpleView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
