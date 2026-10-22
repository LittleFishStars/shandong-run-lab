package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.bd;
import com.beizi.fusion.ic;
import com.beizi.fusion.m8;
import com.beizi.fusion.mn;
import com.beizi.fusion.xc;
import com.beizi.fusion.zc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeInteractionVideoView extends ScopeVideoView implements zc, ic {
    private xc x;
    private bd y;

    public ScopeInteractionVideoView(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.ic
    public void addExtraExecutor(bd bdVar) {
        this.y = bdVar;
    }

    @Override // com.beizi.fusion.zc
    public void bindInteractionForm(xc xcVar) {
        this.x = xcVar;
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return;
        }
        this.x.a(this.b.getInteractionModel());
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

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView
    public void h() {
        super.h();
        bd bdVar = this.y;
        if (bdVar != null) {
            bdVar.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xc xcVar = this.x;
        if (xcVar != null) {
            xcVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xc xcVar = this.x;
        if (xcVar != null) {
            xcVar.b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        xc xcVar = this.x;
        if (xcVar != null && (xcVar instanceof m8) && ((m8) xcVar).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView, com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        xc xcVar = this.x;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).a(z);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView, com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        xc xcVar = this.x;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).k();
    }

    public ScopeInteractionVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeInteractionVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScopeInteractionVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
