package com.byazt.pro;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bzd.x;
import com.byazt.ete.ic;
import com.byazt.lbn.LazeLayout;
import com.byazt.nc.u;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.my;
import com.byazt.sbm.n;
import com.byazt.ukr.yp;
import com.byazt.un.NativeDrawVideoTsView;
import com.byazt.un.NativeVideoTsView;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 199, 54})
public class ve extends com.byazt.lq.c implements LazeLayout.c<NativeVideoTsView>, com.byazt.lbn.c<NativeVideoTsView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28959a;
    public boolean c;
    public volatile WeakReference<NativeVideoTsView> da;
    public LazeLayout i;
    public uj n;
    public CreativeContainer sl;
    public final ic sp;
    public com.byazt.lsp.c t;
    public Bitmap tt;
    public com.byazt.uz.c uj;
    public int ve;
    public com.byazt.dj.tt x;

    public ve(Context context, ic icVar, int i, com.byazt.dj.tt ttVar) {
        super(new uj(context, icVar, i, ttVar));
        this.i = null;
        this.da = null;
        this.t = new com.byazt.lsp.c(null) { // from class: com.byazt.pro.ve.3
            @Override // com.byazt.lsp.c
            public void c(View view, u uVar) {
                NativeVideoTsView nativeVideoTsView = ve.this.n.getNativeVideoTsView();
                if (nativeVideoTsView != null) {
                    nativeVideoTsView.sl();
                }
            }

            @Override // com.byazt.lsp.c
            public void tt(View view, u uVar) {
                NativeVideoTsView nativeVideoTsView = ve.this.n.getNativeVideoTsView();
                if (nativeVideoTsView != null) {
                    nativeVideoTsView.sl();
                }
            }

            @Override // com.byazt.lsp.c
            public void c(u uVar) {
                NativeVideoTsView nativeVideoTsView = ve.this.n.getNativeVideoTsView();
                if (nativeVideoTsView != null) {
                    nativeVideoTsView.gt();
                }
            }
        };
        this.x = ttVar;
        uj ujVar = (uj) getFeedAd();
        this.n = ujVar;
        this.sp = icVar;
        this.f28959a = context;
        ((com.byazt.kyz.ve) ujVar.getNativeAd()).setPluginAdInteractionListener(this.t);
        if (context == null || ic.ve(icVar) || !CreativeContainer.c(icVar)) {
            return;
        }
        this.sl = new CreativeContainer(context, icVar, ((com.byazt.kyz.ve) this.n.getNativeAd()).getInteractionManager());
    }

    @Override // com.byazt.lq.c, com.byazt.nc.u
    public void destroy() {
        NativeVideoTsView nativeVideoTsView;
        super.destroy();
        if (this.da != null && (nativeVideoTsView = this.da.get()) != null) {
            nativeVideoTsView.gt();
        }
        LazeLayout lazeLayout = this.i;
        if (lazeLayout != null) {
            lazeLayout.c();
        }
        CreativeContainer creativeContainer = this.sl;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
    }

    @Override // com.byazt.lq.c, com.byazt.nc.u
    public View getAdView() {
        ic icVar = this.sp;
        NativeVideoTsView nativeVideoTsViewInflate = null;
        if (icVar == null || this.f28959a == null) {
            return null;
        }
        com.byazt.iyp.tt.c(icVar.c());
        if (ic.tt(this.sp)) {
            yp.c().c(this.sp, 3, "valid invoke");
        }
        if (ic.ve(this.sp)) {
            if (!x.c()) {
                try {
                    nativeVideoTsViewInflate = inflate(this.f28959a);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewInflate != null) {
                    onFill(nativeVideoTsViewInflate);
                }
                return nativeVideoTsViewInflate;
            }
            this.i = new LazeLayout(this.f28959a, this, this);
        } else if (this.sl != null) {
            com.byazt.kyz.ve veVar = (com.byazt.kyz.ve) this.n.getNativeAd();
            if (veVar != null && veVar.getInteractionManager() != null) {
                veVar.getInteractionManager().c(this.sl);
            }
            return this.sl;
        }
        com.byazt.dz.uj.c().c(this.sp).c(this.n.getAdType()).tt(this.n.getCodeId());
        return this.i;
    }

    @Override // com.byazt.nc.u
    public String getLifecycleId() {
        ic icVar = this.sp;
        if (icVar != null) {
            return icVar.zm();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public n getMediationManager() {
        return new com.byazt.ah.ve();
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.lsp.c cVar, com.byazt.am.uj ujVar) {
        View adView;
        try {
            registerViewForInteraction(viewGroup, (List<View>) null, list, list2, list3, (View) null, cVar);
            if (ujVar != null) {
                View viewFindViewById = viewGroup.findViewById(ujVar.t());
                if (viewFindViewById != null && getAdLogo() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = pf.ve(viewGroup.getContext(), 38.0f);
                        layoutParams.height = pf.ve(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(getAdLogo());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(ujVar.sp());
                if (frameLayout == null || (adView = getAdView()) == null) {
                    return;
                }
                pf.x(adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView, -1, -1);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.nc.i
    public void setCanInterruptVideoPlay(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.nc.i
    public void setDrawVideoListener(com.byazt.uz.c cVar) {
        this.uj = cVar;
    }

    @Override // com.byazt.nc.u
    public void setEasyPlayWidgetListener(com.byazt.lsp.tt ttVar) {
        uj ujVar = this.n;
        if (ujVar != null) {
            ujVar.setEasyPlayWidgetListener(ttVar);
        }
    }

    @Override // com.byazt.nc.i
    public void setPauseIcon(Bitmap bitmap, int i) {
        this.tt = bitmap;
        this.ve = i;
        c();
    }

    private boolean c(int i) {
        int iA = gt.tt().a(i);
        if (3 == iA) {
            return false;
        }
        if (1 != iA || !rh.uj(this.f28959a)) {
            if (2 == iA) {
                if (!rh.n(this.f28959a) && !rh.uj(this.f28959a)) {
                    rh.a(this.f28959a);
                }
            } else if (5 == iA && !rh.uj(this.f28959a)) {
                rh.a(this.f28959a);
            }
        }
        return true;
    }

    @Override // com.byazt.lbn.c
    public NativeVideoTsView inflate(Context context) {
        NativeVideoTsView nativeVideoTsViewCreateNativeVideoTsView = this.n.createNativeVideoTsView(true);
        nativeVideoTsViewCreateNativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.uj() { // from class: com.byazt.pro.ve.1
            @Override // com.byazt.un.NativeVideoTsView.uj
            public void c(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                ve.this.n.c.c = z;
                ve.this.n.c.n = j;
                ve.this.n.c.f29083a = j2;
                ve.this.n.c.sp = j3;
                ve.this.n.c.uj = z2;
                ve.this.n.c.x = z3;
            }
        });
        nativeVideoTsViewCreateNativeVideoTsView.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.byazt.pro.ve.2
            @Override // com.byazt.un.NativeVideoTsView.c
            public void c(View view, int i) {
                my interactionManager = ((com.byazt.kyz.ve) ve.this.n.getNativeAd()).getInteractionManager();
                if (interactionManager != null) {
                    interactionManager.c(view, i);
                }
            }
        });
        nativeVideoTsViewCreateNativeVideoTsView.setVideoAdLoadListener(this.n);
        nativeVideoTsViewCreateNativeVideoTsView.setVideoAdInteractionListener(this.n);
        nativeVideoTsViewCreateNativeVideoTsView.setIsAutoPlay(c(nb.t(this.sp)));
        nativeVideoTsViewCreateNativeVideoTsView.setIsQuiet(this.sp.ab() == 1);
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) nativeVideoTsViewCreateNativeVideoTsView;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.c);
        Bitmap bitmap = this.tt;
        if (bitmap != null) {
            nativeDrawVideoTsView.c(bitmap, this.ve);
        }
        nativeVideoTsViewCreateNativeVideoTsView.setDrawVideoListener(this.uj);
        this.da = new WeakReference<>(nativeVideoTsViewCreateNativeVideoTsView);
        return nativeVideoTsViewCreateNativeVideoTsView;
    }

    @Override // com.byazt.lbn.LazeLayout.c
    public void onFill(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.c(0L, true, false);
        }
    }

    private void c() {
        int i = this.ve;
        if (i >= 200) {
            this.ve = 200;
        } else if (i <= 20) {
            this.ve = 20;
        }
    }
}
