package com.byazt.dn;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.hkv.tt;
import com.byazt.nr.m;
import com.byazt.pm.a;
import com.byazt.sz.rh;
import com.byazt.sz.z;
import com.byazt.ux.n;
import com.byazt.xj.ve;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 35, 1680})
public class UgenBanner extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28415a;
    public z c;
    public WeakReference<ObjectAnimator> n;
    public View tt;
    public final AtomicBoolean uj;
    public boolean ve;

    public UgenBanner(Context context) {
        super(context);
        this.uj = new AtomicBoolean(false);
    }

    public void setTopMargin(int i) {
        this.f28415a = i;
    }

    public void tt() {
        View view = this.tt;
        if (view == null || this.ve) {
            return;
        }
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParamsGenerateDefaultLayoutParams == null) {
            layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        layoutParamsGenerateDefaultLayoutParams.topMargin = this.f28415a;
        addView(this.tt, layoutParamsGenerateDefaultLayoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tt, "translationY", -400.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
        this.n = new WeakReference<>(objectAnimatorOfFloat);
    }

    public void c(ic icVar, tt ttVar) {
        if (icVar.z() == null || TextUtils.isEmpty(icVar.z().ve())) {
            return;
        }
        c(my.yp(icVar), icVar, ttVar, icVar.z().ve(), icVar.v_(), TextUtils.isEmpty(icVar.tj()) ? "立即下载" : icVar.tj(), false);
    }

    public void c(com.byazt.seg.c cVar, final ic icVar, final tt ttVar, final String str, final String str2, final String str3, final boolean z) {
        if (cVar == null || this.uj.getAndSet(true) || icVar.te() == null || TextUtils.isEmpty(icVar.te().c())) {
            return;
        }
        n.c(cVar, new n.c() { // from class: com.byazt.dn.UgenBanner.1
            @Override // com.byazt.ux.n.c
            public void c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(RemoteMessageConst.Notification.ICON, icVar.te().c());
                    jSONObject2.put("app_name", str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException e) {
                    m.c(e);
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.tt = ugenBanner.c(jSONObject, jSONObject2, new rh() { // from class: com.byazt.dn.UgenBanner.1.1
                    @Override // com.byazt.sz.rh
                    public void c(com.byazt.sz.m mVar, rh.tt ttVar2, rh.c cVar2) {
                        if (mVar.ve() != null && "banner_click".equals(mVar.ve().optString("type"))) {
                            UgenBanner.this.tt.setTag(2114387594, Boolean.TRUE);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ttVar.c(UgenBanner.this.tt, null);
                            AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                            if (z) {
                                UgenBanner.this.c();
                            }
                        }
                    }

                    @Override // com.byazt.sz.rh
                    public void c(ve veVar, String str4, a.c cVar2) {
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.byazt.dn.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.tt();
            }
        }, 3000L);
    }

    public void c() {
        ObjectAnimator objectAnimator;
        this.ve = true;
        View view = this.tt;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.n;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View c(JSONObject jSONObject, JSONObject jSONObject2, rh rhVar) {
        z zVar = new z(getContext());
        this.c = zVar;
        ve<View> veVarC = zVar.c(jSONObject);
        this.c.c(rhVar);
        this.c.tt(jSONObject2);
        if (veVarC == null) {
            return null;
        }
        View viewI = veVarC.i();
        if (viewI != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(veVarC.or(), veVarC.cu());
            layoutParams.leftMargin = pf.ve(getContext(), 16.0f);
            layoutParams.rightMargin = pf.ve(getContext(), 16.0f);
            viewI.setLayoutParams(layoutParams);
        }
        return viewI;
    }
}
