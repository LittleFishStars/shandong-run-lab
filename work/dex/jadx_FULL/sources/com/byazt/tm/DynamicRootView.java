package com.byazt.tm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aq.a;
import com.byazt.aq.x;
import com.byazt.xl.sl;
import com.byazt.xl.u;
import com.byazt.xl.yp;
import com.byazt.xv.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1441})
public class DynamicRootView extends FrameLayout implements com.byazt.kn.uj, com.byazt.xv.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.wl.c f29066a;
    public final yp c;
    public int da;
    public ViewGroup i;
    public Context m;
    public DynamicBaseWidget n;
    public String nu;
    public Map<Integer, String> rh;
    public List<com.byazt.kn.ve> sl;
    public ThemeStatusBroadcastReceiver sp;
    public com.byazt.kn.n t;
    public boolean tt;
    public int u;
    public sl uj;
    public View ve;
    public com.byazt.kn.tt x;
    public int yp;
    public u z;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, u uVar, com.byazt.wl.c cVar) {
        super(context);
        this.i = null;
        this.da = 0;
        this.sl = new ArrayList();
        this.u = 0;
        this.yp = 0;
        this.m = context;
        yp ypVar = new yp();
        this.c = ypVar;
        ypVar.c(2);
        this.f29066a = cVar;
        cVar.c(this);
        this.sp = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.c(this);
        this.tt = z;
        this.z = uVar;
    }

    @Override // com.byazt.xv.c
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.n;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.c(i);
    }

    public void c(x xVar, int i) {
        this.n = c(xVar, this, i);
        this.c.c(true);
        this.c.c(this.n.n);
        this.c.tt(this.n.f29065a);
        this.c.c(this.ve);
        this.uj.c(this.c);
    }

    public String getBgColor() {
        return this.nu;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.rh;
    }

    public com.byazt.wl.c getDynamicClickListener() {
        return this.f29066a;
    }

    public int getLogoUnionHeight() {
        return this.u;
    }

    public sl getRenderListener() {
        return this.uj;
    }

    public u getRenderRequest() {
        return this.z;
    }

    public int getScoreCountWithIcon() {
        return this.yp;
    }

    public ViewGroup getTimeOut() {
        return this.i;
    }

    public List<com.byazt.kn.ve> getTimeOutListener() {
        return this.sl;
    }

    public int getTimedown() {
        return this.da;
    }

    public void setBgColor(String str) {
        this.nu = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.rh = map;
    }

    public void setDislikeView(View view) {
        this.f29066a.tt(view);
    }

    public void setLogoUnionHeight(int i) {
        this.u = i;
    }

    public void setMuteListener(com.byazt.kn.tt ttVar) {
        this.x = ttVar;
    }

    public void setRenderListener(sl slVar) {
        this.uj = slVar;
        this.f29066a.c(slVar);
    }

    public void setScoreCountWithIcon(int i) {
        this.yp = i;
    }

    @Override // com.byazt.kn.uj
    public void setSoundMute(boolean z) {
        com.byazt.kn.tt ttVar = this.x;
        if (ttVar != null) {
            ttVar.setSoundMute(z);
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.i = viewGroup;
    }

    public void setTimeOutListener(com.byazt.kn.ve veVar) {
        this.sl.add(veVar);
    }

    public void setTimeUpdate(int i) {
        this.t.setTimeUpdate(i);
    }

    public void setTimedown(int i) {
        this.da = i;
    }

    public void setVideoListener(com.byazt.kn.n nVar) {
        this.t = nVar;
    }

    public void tt() {
        c(this.n, 4);
    }

    public DynamicBaseWidget c(x xVar, ViewGroup viewGroup, int i) {
        if (xVar == null) {
            return null;
        }
        List<x> listSl = xVar.sl();
        DynamicBaseWidget dynamicBaseWidgetC = com.byazt.mt.tt.c(this.m, this, xVar);
        if (dynamicBaseWidgetC instanceof DynamicUnKnowView) {
            c(i == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        c(xVar);
        dynamicBaseWidgetC.c();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetC);
            c(viewGroup, xVar);
        }
        if (listSl == null || listSl.size() <= 0) {
            return null;
        }
        Iterator<x> it = listSl.iterator();
        while (it.hasNext()) {
            c(it.next(), dynamicBaseWidgetC, i);
        }
        return dynamicBaseWidgetC;
    }

    private void c(x xVar) {
        a aVarN;
        com.byazt.aq.n nVarDa = xVar.da();
        if (nVarDa == null || (aVarN = nVarDa.n()) == null) {
            return;
        }
        this.c.tt(aVarN.di());
    }

    private void c(ViewGroup viewGroup, x xVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !xVar.gr()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void c(double d, double d2, double d3, double d4, float f) {
        this.c.ve(d);
        this.c.uj(d2);
        this.c.n(d3);
        this.c.a(d4);
        this.c.c(f);
        this.c.tt(f);
        this.c.ve(f);
        this.c.uj(f);
    }

    public void c(int i, String str) {
        this.c.c(false);
        this.c.tt(i);
        this.c.c(str);
        this.uj.c(this.c);
    }

    public void c() {
        c(this.n, 0);
    }

    public void c(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            View view = dynamicBaseWidget.z;
            if (view != null) {
                view.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                c((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.byazt.kn.uj
    public void c(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.sl.size(); i3++) {
            if (this.sl.get(i3) != null) {
                this.sl.get(i3).c(charSequence, i == 1, i2, z);
            }
        }
    }
}
