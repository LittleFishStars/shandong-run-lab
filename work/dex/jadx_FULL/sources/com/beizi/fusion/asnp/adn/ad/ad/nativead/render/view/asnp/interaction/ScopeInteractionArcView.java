package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeArcView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.SlideModel;
import com.beizi.fusion.he;
import com.beizi.fusion.m8;
import com.beizi.fusion.mn;
import com.beizi.fusion.xc;
import com.beizi.fusion.zc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeInteractionArcView extends ScopeArcView implements zc {
    private xc x;
    private boolean y;

    public ScopeInteractionArcView(Context context) {
        super(context);
        this.y = false;
    }

    @Override // com.beizi.fusion.zc
    public void bindInteractionForm(xc xcVar) {
        SlideModel slideModel;
        this.x = xcVar;
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return;
        }
        InteractionModel interactionModel = this.b.getInteractionModel();
        this.x.a(interactionModel);
        if (interactionModel == null || (slideModel = interactionModel.getSlideModel()) == null) {
            return;
        }
        slideModel.getSlideDirection("Normal");
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeArcView, com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeSimpleView, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        super.fillContent(aVar);
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

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeArcView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xc xcVar = this.x;
        if (xcVar != null) {
            xcVar.a();
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeArcView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xc xcVar = this.x;
        if (xcVar != null) {
            xcVar.b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.y = false;
            if (!a(motionEvent.getX(), motionEvent.getY())) {
                return true;
            }
            this.y = true;
        }
        if (motionEvent.getAction() == 1 && !this.y) {
            return true;
        }
        xc xcVar = this.x;
        if (xcVar != null && (xcVar instanceof m8) && ((m8) xcVar).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeSimpleView, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        xc xcVar = this.x;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).a(z);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeSimpleView, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        xc xcVar = this.x;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).k();
    }

    public ScopeInteractionArcView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = false;
    }

    public ScopeInteractionArcView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = false;
    }
}
