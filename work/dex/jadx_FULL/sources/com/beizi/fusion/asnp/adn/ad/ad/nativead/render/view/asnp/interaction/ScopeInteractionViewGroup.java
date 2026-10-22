package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.m8;
import com.beizi.fusion.xc;
import com.beizi.fusion.zc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeInteractionViewGroup extends ScopeViewGroup implements zc {
    protected xc e;

    public ScopeInteractionViewGroup(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.zc
    public void bindInteractionForm(xc xcVar) {
        this.e = xcVar;
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return;
        }
        this.e.a(this.b.getInteractionModel());
    }

    @Override // com.beizi.fusion.zc
    public String getActionType() {
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.b.getInteractionModel().getExecution();
    }

    @Override // com.beizi.fusion.zc
    public String getInteractionType() {
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.b.getInteractionModel().getBindEvent();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xc xcVar = this.e;
        if (xcVar != null) {
            xcVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xc xcVar = this.e;
        if (xcVar != null) {
            xcVar.b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        xc xcVar = this.e;
        if (xcVar != null && (xcVar instanceof m8) && ((m8) xcVar).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public ScopeInteractionViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeInteractionViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeInteractionViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
