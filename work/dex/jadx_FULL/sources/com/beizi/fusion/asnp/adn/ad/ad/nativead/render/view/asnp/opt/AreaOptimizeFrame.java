package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.par.ClickAreaParams;
import com.beizi.fusion.gn;
import com.beizi.fusion.hf;
import com.beizi.fusion.no;
import com.beizi.fusion.vk;
import com.beizi.fusion.xc;
import com.beizi.fusion.yk;
import com.ipd.dsp.internal.e1.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AreaOptimizeFrame extends BaseOptimizeFrame {
    private final ClickAreaParams d;
    private yk e;

    public class a implements vk.b {
        public a() {
        }

        @Override // com.beizi.fusion.vk.b
        public void a(View view, MotionEvent motionEvent) {
            hf hfVarF;
            View view2 = AreaOptimizeFrame.this.c;
            if (!(view2 instanceof ScopeExpressContainer) || (hfVarF = ScopeExpressContainer.d.f((ScopeExpressContainer) view2)) == null) {
                return;
            }
            hfVarF.a(view, AreaOptimizeFrame.this.c, motionEvent);
        }
    }

    public class b extends yk {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // com.beizi.fusion.yk
        public void a(long j) {
        }

        @Override // com.beizi.fusion.yk
        public void c() {
        }

        @Override // com.beizi.fusion.yk
        public void d() {
            AreaOptimizeFrame areaOptimizeFrame = AreaOptimizeFrame.this;
            areaOptimizeFrame.e = null;
            areaOptimizeFrame.removeFromParent();
        }
    }

    public AreaOptimizeFrame(@NonNull Context context, @NonNull OptimizeModel optimizeModel) {
        super(context, optimizeModel);
        this.d = optimizeModel.getClickArea();
        b();
    }

    private FrameLayout.LayoutParams a() {
        ClickAreaParams clickAreaParams;
        int iF;
        int iD;
        if (this.c == null || (clickAreaParams = this.d) == null) {
            return null;
        }
        int reference = clickAreaParams.getReference();
        if (reference == 0) {
            iF = this.c.getWidth();
            iD = this.c.getHeight();
        } else {
            iF = 0;
            iD = 0;
        }
        if (reference == 1) {
            iF = gn.f(this.c.getContext());
            iD = gn.d(this.c.getContext());
        }
        int iA = a(iF, this.d.getWidth());
        int iA2 = a(iD, this.d.getHeight());
        if (iA <= 0 || iA2 <= 0) {
            return null;
        }
        Rect rect = new Rect();
        this.c.getGlobalVisibleRect(rect);
        int[] iArrA = a(this.d.getVerticalSpace(), this.d.getHorizontalSpace(), rect, iA, iA2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA2);
        layoutParams.topMargin = iArrA[0];
        layoutParams.leftMargin = iArrA[1];
        return layoutParams;
    }

    private void b() {
        int duration;
        ClickAreaParams clickAreaParams = this.d;
        if (clickAreaParams == null || (duration = clickAreaParams.getDuration()) <= 0) {
            return;
        }
        this.e = new b(duration, 1000L);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.BaseOptimizeFrame
    public void addToWindow() {
        ViewGroup viewGroup;
        FrameLayout.LayoutParams layoutParamsA;
        onViewReappear();
        View view = this.c;
        if (view != null) {
            View rootView = view.getRootView();
            if (!(rootView instanceof ViewGroup) || (viewGroup = (ViewGroup) rootView.findViewById(R.id.content)) == null || (layoutParamsA = a()) == null) {
                return;
            }
            viewGroup.addView(this, layoutParamsA);
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.BaseOptimizeFrame
    public void bindInteractionForm(xc xcVar) {
        super.bindInteractionForm(xcVar);
        if (xcVar instanceof vk) {
            ((vk) xcVar).a((vk.b) new a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        yk ykVar = this.e;
        if (ykVar != null) {
            ykVar.g();
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.BaseOptimizeFrame
    public void onViewHide() {
        super.onViewHide();
        removeFromParent();
    }

    private int[] a(String str, String str2, Rect rect, int i, int i2) {
        int[] iArr = new int[2];
        if (str.equalsIgnoreCase(f.l)) {
            iArr[0] = rect.top;
        }
        if (str.equalsIgnoreCase(f.n)) {
            iArr[0] = rect.bottom - i2;
        }
        if (str.equalsIgnoreCase("center")) {
            int i3 = rect.top;
            iArr[0] = (i3 + ((rect.bottom - i3) / 2)) - (i2 / 2);
        }
        if (str2.equalsIgnoreCase("left")) {
            iArr[1] = rect.left;
        }
        if (str2.equalsIgnoreCase("right")) {
            iArr[1] = rect.right - i;
        }
        if (str2.equalsIgnoreCase("center")) {
            int i4 = rect.left;
            iArr[1] = (i4 + ((rect.right - i4) / 2)) - (i / 2);
        }
        return iArr;
    }

    private int a(int i, String str) {
        if (no.f(str)) {
            return (int) (i * no.k(str));
        }
        return no.i(str);
    }
}
