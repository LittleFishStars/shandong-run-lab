package com.byazt.ouz;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.v;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 110})
public class qy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.byazt.xj.ve<View>> f28922a;
    public double c;
    public NativeExpressView i;
    public String n;
    public boolean sp = true;
    public int tt;
    public int uj;
    public List<com.byazt.ete.m> ve;
    public int x;

    public qy(ic icVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.byazt.ete.m mVarC;
        this.uj = -1;
        this.x = -1;
        this.i = nativeExpressView;
        this.x = nb.c(icVar);
        if (jSONObject != null) {
            this.c = jSONObject.optDouble("slide_threshold", AudioStats.AUDIO_AMPLITUDE_NONE);
            this.tt = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, 30);
            this.uj = jSONObject.optInt("type", -1);
            this.n = jSONObject.optString("rgb_color");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rects");
            if (jSONArrayOptJSONArray != null) {
                this.ve = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (mVarC = com.byazt.ete.m.c(jSONObjectOptJSONObject)) != null) {
                        this.ve.add(mVarC);
                    }
                }
            }
        }
        List<com.byazt.ete.m> list = this.ve;
        com.byazt.nr.m.c("xdy", "priority:" + this.x + " dirction:" + this.tt + " type:" + this.uj + " hold:" + this.c + " size:" + (list != null ? list.size() : 0));
    }

    public void c(NativeExpressView nativeExpressView) {
        if (this.ve != null) {
            Context context = nativeExpressView.getContext();
            for (com.byazt.ete.m mVar : this.ve) {
                View siteGestureView = new SiteGestureView(context, new v(this.uj, this.c, this.tt, this.x), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pf.ve(context, (float) mVar.ve), pf.ve(context, (float) mVar.uj));
                layoutParams.leftMargin = pf.ve(context, (float) mVar.c);
                layoutParams.topMargin = pf.ve(context, (float) mVar.tt);
                try {
                    if (!TextUtils.isEmpty(this.n) && com.byazt.nr.m.ve()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.n));
                    }
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
                com.byazt.nr.m.c("xdy", "(" + mVar.c + "," + mVar.tt + "," + mVar.ve + "," + mVar.uj + ")");
            }
        }
    }

    public void tt() {
        this.i.gt();
    }

    public void uj() {
        this.sp = false;
    }

    public boolean ve() {
        return this.sp;
    }

    public boolean c() {
        View viewI;
        List<com.byazt.xj.ve<View>> list = this.f28922a;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.byazt.xj.ve<View> veVar : this.f28922a) {
            if (veVar != null && (viewI = veVar.i()) != null && viewI.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void c(List<com.byazt.xj.ve<View>> list) {
        this.f28922a = list;
    }

    public void c(MotionEvent motionEvent) {
        this.i.c(motionEvent);
    }

    public void c(View view, int i, com.byazt.sr.ve veVar, v vVar) {
        NativeExpressView nativeExpressView = this.i;
        if (nativeExpressView != null) {
            nativeExpressView.c(view, i, veVar, vVar);
        }
    }
}
