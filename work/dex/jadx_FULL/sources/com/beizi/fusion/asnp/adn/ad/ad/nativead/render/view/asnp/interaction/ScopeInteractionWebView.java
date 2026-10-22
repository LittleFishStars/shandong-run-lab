package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeWebView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.xc;
import com.beizi.fusion.zc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeInteractionWebView extends ScopeWebView implements zc {
    public ScopeInteractionWebView(@NonNull Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.zc
    public void bindInteractionForm(xc xcVar) {
        RenderModel renderModel = this.c;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return;
        }
        xcVar.a(this.c.getInteractionModel());
    }

    @Override // com.beizi.fusion.zc
    public String getActionType() {
        RenderModel renderModel = this.c;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.c.getInteractionModel().getExecution();
    }

    @Override // com.beizi.fusion.zc
    public String getInteractionType() {
        RenderModel renderModel = this.c;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.c.getInteractionModel().getBindEvent();
    }

    public ScopeInteractionWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeInteractionWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeInteractionWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
