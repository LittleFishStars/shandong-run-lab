package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;
import com.beizi.fusion.dm;
import com.beizi.fusion.he;
import com.beizi.fusion.vk;
import com.beizi.fusion.xc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BaseOptimizeFrame extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final OptimizeModel f27027a;
    private xc b;
    protected View c;

    public BaseOptimizeFrame(@NonNull Context context, OptimizeModel optimizeModel) {
        super(context);
        this.f27027a = optimizeModel;
    }

    public void addToWindow() {
        xc xcVar = this.b;
        if (xcVar != null) {
            xcVar.a();
        }
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this, this.c.getLayoutParams());
            }
        }
    }

    public void bindInteractionForm(xc xcVar) {
        this.b = xcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void linkedTo(View view) {
        ScopeExpressContainer expressRoot;
        this.c = view;
        if (view instanceof ScopeExpressContainer) {
            setTag(dm.a(getContext(), "scope_root_container"), view);
        } else {
            if (!(view instanceof he) || (expressRoot = ((he) view).getExpressRoot()) == null) {
                return;
            }
            setTag(dm.a(getContext(), "scope_root_container"), expressRoot);
        }
    }

    public void onViewHide() {
        xc xcVar = this.b;
        if (xcVar != null) {
            xcVar.b();
        }
    }

    public void onViewReappear() {
        xc xcVar = this.b;
        if (xcVar != null) {
            xcVar.a();
        }
    }

    public void removeFromParent() {
        ScopeExpressContainer.d.a(this);
        xc xcVar = this.b;
        if (xcVar instanceof vk) {
            ((vk) xcVar).e();
        }
    }
}
