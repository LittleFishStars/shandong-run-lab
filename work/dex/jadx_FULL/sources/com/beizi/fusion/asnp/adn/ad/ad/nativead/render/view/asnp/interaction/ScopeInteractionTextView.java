package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.m8;
import com.beizi.fusion.mn;
import com.beizi.fusion.xc;
import com.beizi.fusion.zc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeInteractionTextView extends ScopeTextView implements zc {
    private xc i;

    public ScopeInteractionTextView(@NonNull Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.zc
    public void bindInteractionForm(xc xcVar) {
        this.i = xcVar;
        RenderModel renderModel = this.d;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return;
        }
        this.i.a(this.d.getInteractionModel());
    }

    public String getActionType() {
        RenderModel renderModel = this.d;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.d.getInteractionModel().getExecution();
    }

    public String getInteractionType() {
        RenderModel renderModel = this.d;
        if (renderModel == null || renderModel.getInteractionModel() == null) {
            return null;
        }
        return this.d.getInteractionModel().getBindEvent();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xc xcVar = this.i;
        if (xcVar != null) {
            xcVar.a();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xc xcVar = this.i;
        if (xcVar != null) {
            xcVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        xc xcVar = this.i;
        if (xcVar != null && (xcVar instanceof m8) && ((m8) xcVar).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        xc xcVar = this.i;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).a(z);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        xc xcVar = this.i;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).k();
    }

    public ScopeInteractionTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeInteractionTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
