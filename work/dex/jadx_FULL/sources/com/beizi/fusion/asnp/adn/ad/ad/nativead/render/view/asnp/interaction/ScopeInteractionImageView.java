package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeImageView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.m8;
import com.beizi.fusion.mn;
import com.beizi.fusion.xc;
import com.beizi.fusion.zc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeInteractionImageView extends ScopeImageView implements zc {
    private xc l;

    public ScopeInteractionImageView(@NonNull Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.zc
    public void bindInteractionForm(xc xcVar) {
        this.l = xcVar;
        RenderModel renderModel = this.h;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return;
        }
        this.l.a(this.h.getInteractionModel());
    }

    @Override // com.beizi.fusion.zc
    public String getActionType() {
        RenderModel renderModel = this.h;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.h.getInteractionModel().getExecution();
    }

    @Override // com.beizi.fusion.zc
    public String getInteractionType() {
        RenderModel renderModel = this.h;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.h.getInteractionModel().getBindEvent();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xc xcVar = this.l;
        if (xcVar != null) {
            xcVar.a();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xc xcVar = this.l;
        if (xcVar != null) {
            xcVar.b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        xc xcVar = this.l;
        if (xcVar != null && (xcVar instanceof m8) && ((m8) xcVar).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeImageView, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        xc xcVar = this.l;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).a(z);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeImageView, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        xc xcVar = this.l;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).k();
    }

    public ScopeInteractionImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeInteractionImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
