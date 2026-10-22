package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.bd;
import com.beizi.fusion.ic;
import com.beizi.fusion.yk;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeCapsuleCloseView extends ScopeInteractionTextView implements ic {
    private yk j;
    private bd k;
    private boolean l;

    public class a extends yk {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.beizi.fusion.yk
        public void a(long j) {
            ScopeCapsuleCloseView.this.a(j);
        }

        @Override // com.beizi.fusion.yk
        public void c() {
            ScopeCapsuleCloseView.this.b();
            ScopeCapsuleCloseView.this.l = false;
        }

        @Override // com.beizi.fusion.yk
        public void d() {
            ScopeCapsuleCloseView.this.c();
            ScopeCapsuleCloseView scopeCapsuleCloseView = ScopeCapsuleCloseView.this;
            scopeCapsuleCloseView.l = false;
            scopeCapsuleCloseView.j = null;
        }
    }

    public ScopeCapsuleCloseView(@NonNull Context context) {
        super(context);
        this.l = false;
    }

    public void a(long j) {
        setText(String.format(Locale.ENGLISH, "%d %s", Integer.valueOf((int) (j / 1000)), this.d.getViewModel().getTitle()));
    }

    @Override // com.beizi.fusion.ic
    public void addExtraExecutor(bd bdVar) {
        this.k = bdVar;
    }

    public void b() {
    }

    public void c() {
        bd bdVar = this.k;
        if (bdVar != null) {
            bdVar.a(this);
        }
    }

    public void d() {
    }

    public int getCountDownTime() {
        RenderModel renderModel = this.d;
        return (renderModel == null || renderModel.getInteractionModel() == null || this.d.getInteractionModel().getCountDownTime() < 1000) ? getDefaultCountDownTime() : this.d.getInteractionModel().getCountDownTime();
    }

    public int getDefaultCountDownTime() {
        return 5000;
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        yk ykVar = this.j;
        if (ykVar != null) {
            ykVar.a();
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView, com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView, com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        yk ykVar = this.j;
        if (ykVar == null || this.l) {
            return;
        }
        ykVar.g();
        this.l = true;
    }

    public ScopeCapsuleCloseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView
    public void a() {
        if (getCountDownTime() > 0) {
            this.j = new a(getCountDownTime() + 500, 1000L);
        } else {
            d();
        }
    }

    public ScopeCapsuleCloseView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = false;
    }
}
