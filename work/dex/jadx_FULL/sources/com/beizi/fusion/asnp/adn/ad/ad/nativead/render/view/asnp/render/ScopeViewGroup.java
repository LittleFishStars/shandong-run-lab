package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.fp;
import com.beizi.fusion.he;
import com.beizi.fusion.no;
import com.beizi.fusion.un;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeViewGroup extends RelativeLayout implements he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27061a;
    protected RenderModel b;
    protected AssetModel c;
    private ScopeExpressContainer d;

    public ScopeViewGroup(Context context) {
        super(context);
    }

    private void a(boolean z) {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt instanceof he) {
                    ((he) childAt).onViewPause(z);
                }
            }
        }
    }

    private void b(boolean z) {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt instanceof he) {
                    ((he) childAt).onViewResume(z);
                }
            }
        }
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
        if (renderModel != null) {
            ViewModel viewModel = renderModel.getViewModel();
            if (viewModel != null) {
                un.a(getContext(), this, fp.a().a(viewModel.getBgColor()), no.i(viewModel.getBorderSize()), viewModel.getBorderColor(), un.a(viewModel.getBorderRadius(), getLayoutParams().height));
            }
            aVar.b(this.b.getId());
        }
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
        return this.f27061a;
    }

    public void onViewDestroy() {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt instanceof he) {
                    ((he) childAt).onViewDestroy();
                }
            }
        }
    }

    public void onViewPause(boolean z) {
        a(z);
    }

    public void onViewResume(boolean z) {
        b(z);
    }

    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        this.d = scopeExpressContainer;
    }

    @Override // com.beizi.fusion.he
    public void setScopeViewID(String str) {
        this.f27061a = str;
        setId(no.i(str));
    }

    public ScopeViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
