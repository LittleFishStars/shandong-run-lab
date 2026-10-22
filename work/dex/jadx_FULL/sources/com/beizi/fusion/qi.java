package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.AreaOptimizeFrame;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.BaseOptimizeFrame;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.SlideOptimizeFrame;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.TouchOptimizeFrame;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.par.ClickAreaParams;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.par.SlideParams;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class qi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OptimizeModel f27690a;
    private final Context b;
    private dc c;
    private WeakReference d;
    private BaseOptimizeFrame e;
    private BaseOptimizeFrame f;
    private BaseOptimizeFrame g;
    private BaseOptimizeFrame h;
    private dd i;
    private final Handler j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27691a;

        public a(View view) {
            this.f27691a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f27691a.getContext();
            if (context == null || !(this.f27691a instanceof ViewGroup)) {
                return;
            }
            qi qiVar = qi.this;
            qiVar.f = qiVar.b(context);
            qi qiVar2 = qi.this;
            BaseOptimizeFrame baseOptimizeFrame = qiVar2.f;
            if (baseOptimizeFrame != null) {
                qiVar2.a("opt", baseOptimizeFrame);
                qi.this.f.addToWindow();
            }
            qi qiVar3 = qi.this;
            qiVar3.e = qiVar3.c(context);
            qi qiVar4 = qi.this;
            BaseOptimizeFrame baseOptimizeFrame2 = qiVar4.e;
            if (baseOptimizeFrame2 != null) {
                qiVar4.a("opts", baseOptimizeFrame2);
                qi.this.e.linkedTo(this.f27691a);
                qi.this.e.addToWindow();
            }
            qi qiVar5 = qi.this;
            qiVar5.h = qiVar5.b();
            qi qiVar6 = qi.this;
            BaseOptimizeFrame baseOptimizeFrame3 = qiVar6.h;
            if (baseOptimizeFrame3 != null) {
                qiVar6.a("optt", baseOptimizeFrame3);
                qi.this.h.linkedTo(this.f27691a);
                qi.this.h.addToWindow();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27692a;

        public b(View view) {
            this.f27692a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f27692a.getContext();
            if (context != null) {
                qi qiVar = qi.this;
                qiVar.g = qiVar.a(context);
                qi qiVar2 = qi.this;
                BaseOptimizeFrame baseOptimizeFrame = qiVar2.g;
                if (baseOptimizeFrame != null) {
                    qiVar2.a("opt", baseOptimizeFrame);
                    qi.this.g.linkedTo(this.f27692a);
                    qi.this.g.addToWindow();
                }
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseOptimizeFrame baseOptimizeFrame = qi.this.e;
            if (baseOptimizeFrame != null) {
                baseOptimizeFrame.removeFromParent();
            }
            BaseOptimizeFrame baseOptimizeFrame2 = qi.this.g;
            if (baseOptimizeFrame2 != null) {
                baseOptimizeFrame2.removeFromParent();
            }
            BaseOptimizeFrame baseOptimizeFrame3 = qi.this.f;
            if (baseOptimizeFrame3 != null) {
                baseOptimizeFrame3.removeFromParent();
            }
            BaseOptimizeFrame baseOptimizeFrame4 = qi.this.h;
            if (baseOptimizeFrame4 != null) {
                baseOptimizeFrame4.removeFromParent();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseOptimizeFrame baseOptimizeFrame = qi.this.g;
            if (baseOptimizeFrame != null) {
                baseOptimizeFrame.onViewHide();
            }
            BaseOptimizeFrame baseOptimizeFrame2 = qi.this.e;
            if (baseOptimizeFrame2 != null) {
                baseOptimizeFrame2.onViewHide();
            }
        }
    }

    public qi(Context context, OptimizeModel optimizeModel) {
        this.b = context.getApplicationContext();
        this.f27690a = optimizeModel;
        this.j = new Handler(context.getMainLooper());
    }

    public BaseOptimizeFrame a(Context context) {
        ClickAreaParams clickArea = this.f27690a.getClickArea();
        if (clickArea == null || !ml.a(clickArea.getRandomNum())) {
            return null;
        }
        return new AreaOptimizeFrame(context, this.f27690a);
    }

    public BaseOptimizeFrame b() {
        boolean zA = ml.a(this.f27690a.getTouchDownNum());
        boolean zA2 = ml.a(this.f27690a.getHoldSlideNum());
        if (zA || zA2) {
            return new TouchOptimizeFrame(this.b, this.f27690a, zA, zA2);
        }
        return null;
    }

    public BaseOptimizeFrame c(Context context) {
        SlideParams slide = this.f27690a.getSlide();
        if (slide == null || !ml.a(slide.getRandomNum())) {
            return null;
        }
        return new SlideOptimizeFrame(context, this.f27690a);
    }

    public void d() {
        BaseOptimizeFrame baseOptimizeFrame = this.e;
        if (baseOptimizeFrame != null) {
            baseOptimizeFrame.onViewReappear();
        }
    }

    public void e() {
        this.j.post(new c());
    }

    public void a(dc dcVar, Object obj) {
        if (dcVar instanceof ha) {
            this.c = dcVar;
        }
        if ((dcVar instanceof d1) && (obj instanceof View)) {
            this.d = new WeakReference((View) obj);
        }
    }

    public BaseOptimizeFrame b(Context context) {
        if (!ml.a(this.f27690a.getCloseClickNum())) {
            return null;
        }
        BaseOptimizeFrame baseOptimizeFrame = new BaseOptimizeFrame(context, this.f27690a);
        WeakReference weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        baseOptimizeFrame.linkedTo((View) this.d.get());
        return baseOptimizeFrame;
    }

    public void c() {
        this.j.post(new d());
    }

    public void a(View view) {
        this.j.post(new a(view));
        this.j.postDelayed(new b(view), a());
    }

    private long a() {
        OptimizeModel optimizeModel = this.f27690a;
        if (optimizeModel == null || optimizeModel.getClickArea() == null) {
            return 0L;
        }
        return this.f27690a.getClickArea().getNeedTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BaseOptimizeFrame baseOptimizeFrame) {
        xc xcVarA = xf.a(this.b, str, false);
        if (xcVarA != null) {
            xcVarA.a(this.f27690a);
            xcVarA.a(baseOptimizeFrame, null);
            xcVarA.a(this.c);
            if (xcVarA instanceof wa) {
                ((wa) xcVarA).d().a(this.i);
            }
            baseOptimizeFrame.bindInteractionForm(xcVarA);
        }
    }

    public void a(dd ddVar) {
        this.i = ddVar;
    }
}
