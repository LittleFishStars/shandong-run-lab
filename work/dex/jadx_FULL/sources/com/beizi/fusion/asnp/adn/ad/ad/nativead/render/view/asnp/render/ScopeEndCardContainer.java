package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeEndCardContainer extends ScopeViewGroup {
    public ScopeEndCardContainer(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        super.setExpressRoot(scopeExpressContainer);
        ScopeExpressContainer.d.a(scopeExpressContainer, (ViewGroup) this);
    }

    public ScopeEndCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeEndCardContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeEndCardContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
