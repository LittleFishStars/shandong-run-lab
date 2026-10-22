package com.kc.dw.ad.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.dw.ad.a0;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.utils.g0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends com.kc.dw.core.ad.a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39131a;
    public String b;
    public String[] c;
    public String d;
    public String e;
    public boolean f;
    public a0 g;
    public i h;
    public Context i;
    public boolean j;

    public g(i iVar) {
        super(null, "SSD");
        this.h = iVar;
    }

    @Override // com.kc.dw.ad.nativ.d, com.kc.dw.platform.ad_adapter.c
    public i a() {
        return this.h;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdSlot a() {
        return this.h;
    }

    @Override // com.kc.dw.ad.nativ.d
    public void a(Context context, ViewGroup viewGroup, List<View> list, com.kc.dw.platform.ad_adapter.recycler.f fVar) {
        if (!(context instanceof Activity)) {
            context = viewGroup.getContext();
        }
        this.i = context;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(new e(this, viewGroup, fVar));
            }
        }
    }

    @Override // com.kc.dw.ad.nativ.d
    public void a(ViewGroup viewGroup, h hVar, com.kc.dw.core.service.logrecord.util.a aVar) {
        a0 a0Var = this.g;
        if (aVar != null && aVar.b) {
            com.kc.dw.core.service.logrecord.a.a(5, "e4", aVar.f39321a);
        }
        a0Var.setPreparedStartPlayListener(new f(this, aVar, a0Var, hVar, viewGroup));
        this.h.D = System.currentTimeMillis();
        i iVar = this.h;
        String[] monitorUrl = iVar.getMonitorUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(this.h.C);
        sb.append(Consts.DOT);
        this.h.getClass();
        sb.append(0L);
        sb.append(Consts.DOT);
        sb.append(this.h.D);
        iVar.setMonitorUrl(g0.b(monitorUrl, sb.toString()));
        a0Var.setVideoPath(this.h.g);
    }

    @Override // com.kc.dw.ad.nativ.d
    public void b() {
        this.i = null;
        try {
            a0 a0Var = this.g;
            if (a0Var != null && (a0Var instanceof NormalMediaView)) {
                ((NormalMediaView) a0Var).c();
            }
            this.g = null;
            setInteractionListener(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.nativ.d
    public int getAdPatternType() {
        return this.f39131a;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdType getAdType() {
        return AdType.FEED;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public View getAdView() {
        return this.g.getVideoView();
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public Context getContext() {
        Context context = this.i;
        return context != null ? context : this.g.getVideoView().getContext();
    }

    @Override // com.kc.dw.ad.nativ.d
    public String getDesc() {
        return this.e;
    }

    @Override // com.kc.dw.ad.nativ.d
    public String getIconUrl() {
        return this.b;
    }

    @Override // com.kc.dw.ad.nativ.d
    public String[] getImgUrls() {
        return this.c;
    }

    @Override // com.kc.dw.ad.nativ.d, com.kc.dw.platform.ad_adapter.c
    public int getInteractionType() {
        return this.h.getInteractionType();
    }

    @Override // com.kc.dw.ad.nativ.d
    public a0 getMediaView() {
        return this.g;
    }

    @Override // com.kc.dw.ad.nativ.d
    public String getTitle() {
        return this.d;
    }
}
