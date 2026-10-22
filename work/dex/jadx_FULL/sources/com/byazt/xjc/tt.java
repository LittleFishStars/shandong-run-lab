package com.byazt.xjc;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.dqg.RewardFullBaseLayout;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.or;
import com.byazt.fh.a;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 511, 13})
public class tt implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29181a;
    public int da;
    public TranslateAnimation gt;
    public int i;
    public boolean m;
    public LinearLayout my;
    public TextView n;
    public SmallSlideView nu;
    public LinearLayout rh;
    public int sl;
    public int sp;
    public TextView t;
    public final c.InterfaceC0577c tt;
    public TextView u;
    public ve ve;
    public int x;
    public int yp;
    public LinearLayout z;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public boolean uj = true;
    public boolean rl = false;
    public boolean qy = false;
    public boolean gu = false;

    /* JADX INFO: renamed from: com.byazt.xjc.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 511, 28})
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tt.this.tt.c().c(new RewardFullBaseLayout.c() { // from class: com.byazt.xjc.tt.1.1
                @Override // com.byazt.dqg.RewardFullBaseLayout.c
                public void c() {
                    uj ujVar = new uj();
                    ujVar.c = false;
                    ujVar.ve = true;
                    ujVar.uj = true;
                    tt.this.tt.c().c();
                    tt.this.tt.getActivity().c(3, ujVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tt.this.my.getLayoutParams();
            layoutParams.bottomMargin = -tt.this.my.getMeasuredHeight();
            tt.this.my.setLayoutParams(layoutParams);
            tt.this.my.setVisibility(0);
            tt.this.gt = new TranslateAnimation(0.0f, 0.0f, 0.0f, -tt.this.my.getMeasuredHeight());
            tt.this.gt.setDuration(300L);
            tt.this.gt.setRepeatCount(3);
            tt.this.gt.setRepeatMode(2);
            tt.this.gt.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.xjc.tt.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (tt.this.rl) {
                        tt.this.my.postDelayed(new Runnable() { // from class: com.byazt.xjc.tt.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (tt.this.rl && tt.this.gt != null) {
                                    tt.this.tt.c().getSceneFrameContainer().startAnimation(tt.this.gt);
                                }
                            }
                        }, 2000L);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    tt.this.nu.c();
                }
            });
            if (tt.this.gt != null) {
                tt.this.tt.c().getSceneFrameContainer().startAnimation(tt.this.gt);
            }
        }
    }

    public tt(c.InterfaceC0577c interfaceC0577c) {
        this.tt = interfaceC0577c;
    }

    private void da() {
        String str;
        this.sp = this.tt.n() + (or.i() / 1000);
        this.rh = new LinearLayout(this.tt.getActivity());
        int iVe = pf.ve(this.tt.getActivity(), 10.0f);
        this.rh.setPadding(iVe, iVe, iVe, iVe);
        this.rh.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.byazt.pr.c.tt().c(this.tt.getActivity(), 12.0f));
        this.rh.setBackground(gradientDrawable);
        this.nu = new SmallSlideView(this.tt.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pf.ve(this.tt.getActivity(), 80.0f), pf.ve(this.tt.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.rh.addView(this.nu, layoutParams);
        TextView textView = new TextView(this.tt.getActivity());
        if (or.da() > 0) {
            str = "上滑继续观看\n提前" + or.da() + "秒领奖";
        } else {
            str = "上滑继续观看\n才能领奖哦";
        }
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.rh.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(pf.ve(this.tt.getActivity(), 160.0f), pf.ve(this.tt.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.tt.c().addView(this.rh, layoutParams2);
        this.my = new LinearLayout(this.tt.getActivity());
        ImageView imageView = new ImageView(this.tt.getActivity());
        z.c((Context) this.tt.getActivity(), "tt_ic_back_light", imageView, 320);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = pf.ve(this.tt.getActivity(), 10.0f);
        layoutParams3.bottomMargin = pf.ve(this.tt.getActivity(), 10.0f);
        this.my.addView(imageView, layoutParams3);
        this.tt.c().getSceneFrameContainer().setClipChildren(false);
        this.my.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.tt.c().getSceneFrameContainer().addView(this.my, layoutParams4);
        this.rl = true;
        this.my.post(new AnonymousClass1());
    }

    public void i() {
        TextView textView = this.n;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.n.getParent()).removeView(this.n);
        this.n = null;
    }

    @Override // com.byazt.xjc.c
    public void sp() {
        int i;
        int i2;
        if (c(3)) {
            return;
        }
        if (this.sp > 0 && this.tt.n() >= this.sp) {
            this.sp = 0;
            uj ujVar = new uj();
            ujVar.c = false;
            ujVar.ve = false;
            ujVar.uj = true;
            this.tt.getActivity().c(3, ujVar);
        }
        if (this.t != null && (i2 = this.x) > 0) {
            this.x = Math.max(0, i2 - 1);
            TextView textView = this.t;
            StringBuilder sb = new StringBuilder();
            sb.append(this.x);
            textView.setText(sb.toString());
            if (this.x == 0) {
                uj ujVar2 = new uj();
                ujVar2.c = false;
                ujVar2.ve = false;
                ujVar2.uj = true;
                this.tt.getActivity().c(1, ujVar2);
                a();
            }
        }
        if (this.t != null) {
            if (or.u() == 1 && or.c(this.tt.ve()) != 1 && !this.m && this.tt.i() && this.tt.x()) {
                uj ujVar3 = new uj();
                ujVar3.c = false;
                ujVar3.ve = false;
                ujVar3.uj = true;
                this.tt.getActivity().c(2, ujVar3);
            }
            if (this.i > 0 || this.yp > 0) {
                if (or.u() != 1) {
                    this.i = Math.max(0, this.i - 1);
                    TextView textView2 = this.t;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.i);
                    textView2.setText(sb2.toString());
                    if (this.i == 0) {
                        uj ujVar4 = new uj();
                        ujVar4.c = false;
                        ujVar4.ve = false;
                        ujVar4.uj = true;
                        this.tt.getActivity().c(2, ujVar4);
                        a();
                    }
                } else if (this.tt.i()) {
                    int iMax = Math.max(0, this.yp - 1);
                    this.yp = iMax;
                    if (iMax == 0) {
                        a();
                    }
                } else {
                    this.i = Math.max(0, this.i - 1);
                    TextView textView3 = this.t;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.i);
                    textView3.setText(sb3.toString());
                    if (this.i == 0) {
                        uj ujVar5 = new uj();
                        ujVar5.c = false;
                        ujVar5.ve = false;
                        ujVar5.uj = true;
                        this.tt.getActivity().c(2, ujVar5);
                        a();
                    }
                }
            }
        }
        int i3 = this.sl;
        if (i3 > 0) {
            int iMax2 = Math.max(0, i3 - 1);
            this.sl = iMax2;
            if (iMax2 == 0) {
                this.tt.c(-1, this.da);
                return;
            }
            return;
        }
        if (this.t == null || (i = this.da) <= 0) {
            return;
        }
        this.da = Math.max(0, i - 1);
        TextView textView4 = this.t;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.da);
        textView4.setText(sb4.toString());
        if (this.da == 0) {
            a();
            this.t = null;
            this.tt.sl();
        }
    }

    public void x() {
        int iA = this.tt.a();
        String strConcat = "继续看" + iA + "秒可领取奖励";
        ve veVar = this.ve;
        if (veVar != null) {
            if (veVar.ve() > 0) {
                if (iA <= 0) {
                    strConcat = "成功加速" + this.ve.ve() + "秒，奖励已下发";
                } else {
                    strConcat = "加速成功！".concat(String.valueOf(strConcat));
                }
            } else if (iA <= 0) {
                i();
                return;
            }
        }
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(strConcat);
        }
        int i = this.f29181a;
        if (i <= 0) {
            i();
            return;
        }
        this.f29181a = i - 1;
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.postDelayed(new Runnable() { // from class: com.byazt.xjc.tt.3
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.x();
                }
            }, 500L);
        }
    }

    @Override // com.byazt.xjc.c
    public void a() {
        if (this.z != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.xjc.tt.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    tt.this.z.removeAllViews();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.z.startAnimation(alphaAnimation);
        }
    }

    @Override // com.byazt.xjc.c
    public boolean n() {
        return this.c.get();
    }

    @Override // com.byazt.xjc.c
    public int tt() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.sp();
        }
        return 0;
    }

    @Override // com.byazt.xjc.c
    public boolean uj() {
        return this.ve != null;
    }

    @Override // com.byazt.xjc.c
    public void ve() {
        if (or.u() == 1 && this.gu && this.t != null && this.u != null && !TextUtils.isEmpty(or.sl())) {
            this.t.setText("");
            this.u.setText(or.sl());
            int iT = or.t();
            this.yp = iT;
            if (iT == 0) {
                this.i = 0;
                a();
            }
        }
        if (this.rl && c(3)) {
            SmallSlideView smallSlideView = this.nu;
            if (smallSlideView != null) {
                smallSlideView.tt();
            }
            TranslateAnimation translateAnimation = this.gt;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.rh;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.tt.c().removeView(this.rh);
            }
            LinearLayout linearLayout2 = this.my;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.tt.c().getSceneFrameContainer().removeView(this.my);
            }
            this.tt.c().c();
            this.tt.c(3);
            this.rl = false;
        }
    }

    private void tt(final int i, int i2, int i3) {
        if (i == 1) {
            this.x = i2;
        } else if (i == 2) {
            i2++;
            this.i = i2;
        } else if (i == -1) {
            this.da = i2;
            if (i3 > 0) {
                this.sl = i3;
                return;
            }
            this.sl = 0;
        } else {
            i2 = 0;
        }
        LinearLayout linearLayout = this.z;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.tt.getActivity());
            this.z = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.z.setOrientation(0);
            this.z.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.tt.getActivity().getWindow().getDecorView()).addView(this.z, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.tt.getActivity());
        this.t = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.t.setText(String.valueOf(i2));
        this.t.setTypeface(Typeface.DEFAULT_BOLD);
        this.t.setTextSize(2, 14.0f);
        this.z.addView(this.t);
        TextView textView2 = new TextView(this.tt.getActivity());
        this.u = textView2;
        textView2.setTextColor(-1);
        this.u.setTypeface(Typeface.DEFAULT_BOLD);
        this.u.setSingleLine();
        this.u.setEllipsize(TextUtils.TruncateAt.END);
        this.u.setText(or.a(this.tt.ve()));
        this.u.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(pf.ve(this.tt.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.z.addView(this.u, layoutParams2);
        TextView textView3 = new TextView(this.tt.getActivity());
        textView3.setText(OptionsPickerHelper.e);
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextSize(2, 13.0f);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xjc.tt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = i;
                tt.this.m = true;
                int i5 = i;
                if (i5 == 1) {
                    tt.this.x = 0;
                } else if (i5 == 2) {
                    tt.this.i = 0;
                    tt.this.yp = 0;
                } else if (i5 == -1) {
                    tt.this.da = 0;
                    i4 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i4);
                } catch (JSONException unused) {
                }
                yp.c().c(tt.this.tt.ve(), "stats_switch_tip_cancel", jSONObject);
                tt.this.a();
                tt.this.tt.da();
            }
        });
        this.z.addView(textView3);
        this.z.setPadding(pf.ve(this.tt.getActivity(), 20.0f), pf.ve(this.tt.getActivity(), 16.0f), pf.ve(this.tt.getActivity(), 20.0f), pf.z(this.tt.getActivity()));
        this.z.setClickable(false);
        if (i == 1) {
            this.qy = true;
        } else if (i == 2) {
            this.gu = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, pf.ve(this.tt.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.z.startAnimation(translateAnimation);
    }

    @Override // com.byazt.xjc.c
    public void c(ve veVar, int i, uj ujVar) {
        ic icVar = null;
        try {
            JSONArray jSONArray = new JSONArray(this.tt.ve().hl());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                ic icVarC = com.byazt.omf.c.c(jSONArray.getJSONObject(i2));
                if (c(icVarC, i)) {
                    try {
                        jSONArray.remove(i2);
                        icVarC.sv(jSONArray.toString());
                        icVar = icVarC;
                        break;
                    } catch (JSONException e) {
                        e = e;
                        icVar = icVarC;
                        m.c(e);
                    }
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
        if (icVar != null) {
            if (i == 1 && ujVar != null && ujVar.c) {
                if (this.qy) {
                    return;
                }
                this.tt.c(i, ujVar.tt);
                return;
            }
            if (i == 2 && ujVar != null && ujVar.c) {
                if (this.gu) {
                    return;
                }
                this.tt.c(i, ujVar.tt);
                return;
            }
            if (i == 3 && ujVar != null && ujVar.c) {
                if (this.rl) {
                    return;
                }
                this.tt.c(i, ujVar.tt);
                return;
            }
            com.byazt.dj.tt ttVarC = com.byazt.lvl.c.c().c(icVar, nb.c(icVar, ""));
            if (this.tt.tt()) {
                com.byazt.yi.ve veVar2 = new com.byazt.yi.ve(gt.getContext(), icVar, ttVarC);
                veVar2.setInsertAdBundle(veVar);
                veVar2.showRewardVideoAd(this.tt.getActivity());
            } else {
                com.byazt.yi.tt ttVar = new com.byazt.yi.tt(gt.getContext(), icVar, ttVarC);
                ttVar.setInsertAdBundle(veVar);
                ttVar.showFullScreenVideoAd(this.tt.getActivity());
            }
            this.c.set(true);
        }
    }

    private boolean c(ic icVar, int i) {
        if (i == 1) {
            return or.c(this.tt.tt(), icVar, true);
        }
        if (i != 2) {
            return i == 3 && or.tt(icVar, true);
        }
        return or.c(icVar, true);
    }

    @Override // com.byazt.xjc.c
    public void c(ve veVar) {
        this.ve = veVar;
    }

    @Override // com.byazt.xjc.c
    public int c() {
        ve veVar = this.ve;
        if (veVar != null) {
            return Math.max(0, veVar.tt() - this.ve.ve());
        }
        return 0;
    }

    @Override // com.byazt.xjc.c
    public void c(boolean z) {
        this.uj = z;
    }

    @Override // com.byazt.xjc.c
    public int c(int i, boolean z) {
        if (!this.uj || c(i)) {
            return 0;
        }
        if (i == 1) {
            if (or.c(this.tt.ve()) != 1) {
                return 0;
            }
            if (!z) {
                if (!or.c(this.tt.tt(), uj() ? this.tt.uj() : ic.ve(this.tt.ve()), this.tt.n())) {
                    return 0;
                }
            }
            return i;
        }
        if (i == 2) {
            if (or.tt(this.tt.ve()) != 1) {
                return 0;
            }
            if (!z && this.tt.sp() && or.u() == 0) {
                return 0;
            }
            if (or.u() == 1) {
                if (this.m) {
                    return 0;
                }
                if (this.tt.i()) {
                    if (this.tt.x()) {
                        return i;
                    }
                    return 0;
                }
            }
            if (z || or.c(this.tt.n(), this.tt.ve(), this.tt.tt())) {
                return i;
            }
            return 0;
        }
        if (i != 3 || or.ve(this.tt.ve()) != 1 || this.tt.x()) {
            return 0;
        }
        if (z || or.c(this.tt.n(), this.tt.ve())) {
            return i;
        }
        return 0;
    }

    @Override // com.byazt.xjc.c
    public void tt(boolean z) {
        this.sl = 0;
        if (z) {
            this.da = 0;
        }
    }

    @Override // com.byazt.xjc.c
    public boolean c(int i) {
        if (this.tt.i()) {
            return kp.md(this.tt.ve()) == a.n || (kp.md(this.tt.ve()) == a.f28542a && !this.tt.x());
        }
        return false;
    }

    @Override // com.byazt.xjc.c
    public void c(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.n == null) {
            this.n = pf.yp(this.tt.getActivity());
        }
        if (this.n.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        this.f29181a = or.x() * 2;
        frameLayout.addView(this.n);
        x();
    }

    @Override // com.byazt.xjc.c
    public void c(int i, int i2, int i3) {
        if (i == -1 || i == 1 || i == 2) {
            tt(i, i2, i3);
        } else {
            if (i != 3) {
                return;
            }
            da();
        }
    }
}
