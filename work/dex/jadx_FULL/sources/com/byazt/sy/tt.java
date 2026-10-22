package com.byazt.sy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.ete.m;
import com.byazt.ete.u;
import com.byazt.omf.gt;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 13})
public abstract class tt {
    public ic c;
    public c tt;
    public EasyPlayableContainer uj;
    public com.byazt.kyz.c ve;

    public tt(ic icVar, c cVar) {
        this.c = icVar;
        this.tt = cVar;
    }

    public abstract sp c();

    public abstract u tt();

    public void c(com.byazt.lsp.tt ttVar) {
        com.byazt.kyz.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(ttVar);
        }
    }

    public void c(final ViewGroup viewGroup, final View view, final View view2, final float[] fArr) {
        final HashMap map = new HashMap();
        final u uVarTt = tt();
        if (viewGroup == null || view == null) {
            com.byazt.rgb.a.ve(com.byazt.ip.sp.c(this.c), 2);
            ve.tt(this.c, uVarTt, false, 101, null);
        } else if (view2 == null) {
            com.byazt.rgb.a.ve(com.byazt.ip.sp.c(this.c), 2);
            ve.tt(this.c, uVarTt, false, 102, null);
        } else {
            view.post(new Runnable() { // from class: com.byazt.sy.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    m mVarC;
                    u uVar = uVarTt;
                    if (uVar == null) {
                        return;
                    }
                    if (uVar.tt()) {
                        boolean[] zArr = {true};
                        mVarC = uj.c(zArr, fArr, tt.this.ve, view.getWidth(), view.getHeight(), 0.8d);
                        if (!zArr[0]) {
                            com.byazt.rgb.a.ve(com.byazt.ip.sp.c(tt.this.c), 2);
                            tt ttVar = tt.this;
                            ttVar.c(ttVar.ve);
                            return;
                        }
                    } else {
                        mVarC = null;
                    }
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    tt.this.uj = new EasyPlayableContainer(gt.getContext(), tt.this.c(), mVarC, tt.this.c, uVarTt);
                    u uVar2 = uVarTt;
                    if (uVar2 instanceof ir) {
                        tt.this.uj.setIfStayTop(((ir) uVar2).a());
                    }
                    int iC = uVarTt.c();
                    if (iC == 1 || iC == 2) {
                        tt.this.uj.setTag("easy_play_tag");
                    } else if (iC == 3) {
                        tt.this.uj.setTag("overlay_tag");
                    } else if (iC == 4) {
                        tt.this.uj.setTag("effects_tag");
                    } else if (iC == 5) {
                        tt.this.uj.setTag("fullscreen_tag");
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    tt.this.uj.addView(view2, layoutParams);
                    map.put("container_name", viewGroup.getClass().getName());
                    map.put("enable_layout_restrict", Boolean.valueOf(gt.tt().bj()));
                    tt ttVar2 = tt.this;
                    if (!ttVar2.c(viewGroup, view, ttVar2.uj)) {
                        com.byazt.rgb.a.ve(com.byazt.ip.sp.c(tt.this.c), 2);
                        ve.tt(tt.this.c, uVarTt, false, 202, new JSONObject(map));
                        return;
                    }
                    EasyPlayableContainer.c(viewGroup);
                    if (uVarTt.c() == 1) {
                        tt ttVar3 = tt.this;
                        ttVar3.c(ttVar3.ve, mVarC);
                    }
                    com.byazt.rgb.a.ve(com.byazt.ip.sp.c(tt.this.c), 1);
                    ve.c(tt.this.c, uVarTt, true, new JSONObject(map));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(ViewGroup viewGroup, View view, View view2) {
        if (!uj.c(viewGroup) && viewGroup != null && view != null && view2 != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr);
            viewGroup.getLocationInWindow(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = iArr[1] - iArr2[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (width > 0 && height > 0) {
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                    layoutParams.setMargins(i, i2, 0, 0);
                    viewGroup.addView(view2, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width, height);
                    layoutParams2.setMargins(i, i2, 0, 0);
                    viewGroup.addView(view2, layoutParams2);
                } else {
                    uj.c(viewGroup, view2, width, height, i, i2);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.kyz.c cVar, m mVar) {
        if (cVar != null) {
            cVar.c(true, m.c(mVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.kyz.c cVar) {
        if (cVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, 1);
            } catch (JSONException e) {
                com.byazt.nr.m.tt("xeasy", e.getMessage());
            }
            cVar.c(false, jSONObject);
        }
    }
}
