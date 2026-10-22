package com.byazt.cc;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.oz;
import com.byazt.ete.zb;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.nr.zm;
import com.byazt.omf.gt;
import com.byazt.yj.gr;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 15})
public class uj extends ve implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f28350a;
    public RelativeLayout da;
    public RelativeLayout gt;
    public View.OnClickListener gu;
    public FrameLayout i;
    public View m;
    public TextView my;
    public com.byazt.nc.sp n;
    public RelativeLayout nu;
    public zm qy;
    public TextView rh;
    public TextView rl;
    public ImageView sl;
    public ImageView sp;
    public TextView t;
    public TextView u;
    public View x;
    public TextView yp;
    public TextView z;

    @Override // com.byazt.cc.ve
    public String c() {
        return "splash_card_show";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == 2114387553) {
            i = 0;
        } else if (view.getId() == 2114387561) {
            i = 1;
        } else if (view.getId() == 2114387556) {
            i = 2;
        } else if (view.getId() == 2114387555) {
            i = 3;
        } else {
            i = view.getId() == 2114387554 ? 4 : 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.byazt.ddx.uj.tt(this.ve, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e) {
            m.c(e);
        }
        View.OnClickListener onClickListener = this.gu;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable a() {
        return new Runnable() { // from class: com.byazt.cc.uj.8
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.sp.getWidth() == 0 || uj.this.sp.getHeight() == 0) {
                    return;
                }
                uj.this.sp.animate().scaleX(uj.this.f28350a.getWidth() / uj.this.sp.getWidth()).scaleY(uj.this.f28350a.getHeight() / uj.this.sp.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.byazt.cc.uj.8.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        uj.this.sp.setVisibility(8);
                        uj.this.f28350a.setVisibility(0);
                        uj.this.i.setScaleX(0.0f);
                        uj.this.i.setScaleY(0.0f);
                        uj.this.i.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        uj.this.t.setScaleX(0.0f);
                        uj.this.t.setScaleY(0.0f);
                        uj.this.t.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        uj.this.u.setScaleX(0.0f);
                        uj.this.u.setScaleY(0.0f);
                        uj.this.u.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        uj.this.nu.setScaleX(0.0f);
                        uj.this.nu.setScaleY(0.0f);
                        uj.this.nu.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        uj ujVar = uj.this;
                        i.c cVar = ujVar.uj;
                        if (cVar != null) {
                            cVar.c(oz.a(ujVar.ve));
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        };
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.f28350a = relativeLayout2;
        relativeLayout2.setId(2114387562);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.f28350a.setClipChildren(false);
        this.f28350a.setVisibility(4);
        this.f28350a.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f28350a);
        ImageView imageView = new ImageView(context);
        this.x = imageView;
        imageView.setId(2114387561);
        this.x.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.f28350a.addView(this.x);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387560);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.f28350a.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.yp = textView;
        textView.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = pf.ve(context, 8.0f);
        layoutParams3.bottomMargin = pf.ve(context, 10.0f);
        layoutParams3.rightMargin = pf.ve(context, 4.0f);
        this.yp.setLayoutParams(layoutParams3);
        z.c(this.c, "tt_splash_card_feedback_bg", this.yp, 320);
        this.yp.setGravity(17);
        this.yp.setText("反馈");
        this.yp.setTextColor(Color.parseColor("#99FFFFFF"));
        this.yp.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.yp);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.da = relativeLayout4;
        relativeLayout4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387560);
        this.da.setLayoutParams(layoutParams4);
        this.da.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.f28350a.addView(this.da);
        FrameLayout frameLayout = new FrameLayout(context);
        this.i = frameLayout;
        frameLayout.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = pf.ve(context, -42.0f);
        this.i.setElevation(pf.ve(context, 3.0f));
        this.i.setLayoutParams(layoutParams5);
        this.da.addView(this.i);
        ImageView imageView2 = new ImageView(context);
        this.sl = imageView2;
        imageView2.setId(2114387556);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(pf.ve(context, 2.0f), pf.ve(context, 2.0f), pf.ve(context, 2.0f), pf.ve(context, 2.0f));
        this.sl.setLayoutParams(layoutParams6);
        this.i.addView(this.sl);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iVe = pf.ve(context, 6.0f);
        gradientDrawable.setCornerRadius(iVe);
        gradientDrawable.setStroke(iVe / 3, -1);
        view.setBackground(gradientDrawable);
        this.i.addView(view);
        TextView textView2 = new TextView(context);
        this.t = textView2;
        textView2.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387557);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = pf.ve(context, 16.0f);
        this.t.setLayoutParams(layoutParams7);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setMaxLines(1);
        this.t.setTextColor(Color.parseColor("#161823"));
        this.t.setTextSize(2, 20.0f);
        this.da.addView(this.t);
        TextView textView3 = new TextView(context);
        this.u = textView3;
        textView3.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387555);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(pf.ve(context, 42.0f));
        layoutParams8.setMarginEnd(pf.ve(context, 42.0f));
        layoutParams8.topMargin = pf.ve(context, 8.0f);
        this.u.setLayoutParams(layoutParams8);
        this.u.setEllipsize(TextUtils.TruncateAt.END);
        this.u.setGravity(1);
        this.u.setMaxLines(2);
        this.u.setTextColor(Color.parseColor("#90161823"));
        this.u.setTextSize(2, 14.0f);
        this.da.addView(this.u);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.nu = relativeLayout5;
        relativeLayout5.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387554);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = pf.ve(context, 36.0f);
        this.nu.setLayoutParams(layoutParams9);
        z.c(this.c, "tt_splash_card_btn_bg", this.nu, 320);
        this.nu.setGravity(17);
        this.da.addView(this.nu);
        TextView textView4 = new TextView(context);
        this.rh = textView4;
        textView4.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.rh.setLayoutParams(layoutParams10);
        this.rh.setEllipsize(TextUtils.TruncateAt.END);
        this.rh.setMaxLines(1);
        this.rh.setTextColor(Color.parseColor("#FFFFFF"));
        this.rh.setTextSize(2, 14.0f);
        this.rh.setTypeface(Typeface.defaultFromStyle(1));
        this.nu.addView(this.rh);
        TextView textView5 = new TextView(context);
        this.my = textView5;
        textView5.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387552);
        layoutParams11.addRule(14);
        this.my.setLayoutParams(layoutParams11);
        this.my.setEllipsize(TextUtils.TruncateAt.END);
        this.my.setMaxLines(1);
        this.my.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.my.setTextSize(2, 11.0f);
        this.nu.addView(this.my);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.gt = relativeLayout6;
        relativeLayout6.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387554);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = pf.ve(context, 36.0f);
        this.gt.setLayoutParams(layoutParams12);
        z.c(this.c, "tt_splash_card_btn_bg", this.gt, 320);
        this.gt.setVisibility(8);
        this.da.addView(this.gt);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.gt.addView(relativeLayout7);
        View imageView3 = new ImageView(context);
        imageView3.setId(2114387549);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        z.c(this.c, "tt_splash_card_shake", imageView3, 160);
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.rl = textView6;
        textView6.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = pf.ve(context, 8.0f);
        layoutParams15.addRule(1, 2114387549);
        layoutParams15.addRule(15);
        this.rl.setLayoutParams(layoutParams15);
        this.rl.setEllipsize(TextUtils.TruncateAt.END);
        this.rl.setTypeface(Typeface.defaultFromStyle(1));
        this.rl.setMaxLines(1);
        this.rl.setTextColor(Color.parseColor("#FFFFFF"));
        this.rl.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.rl);
        TextView textView7 = new TextView(context);
        this.z = textView7;
        textView7.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(pf.ve(context, 8.0f));
        layoutParams16.bottomMargin = pf.ve(context, 8.0f);
        this.z.setLayoutParams(layoutParams16);
        com.byazt.fh.uj.c(this.c, 1, this.z);
        this.da.addView(this.z);
        ImageView imageView4 = new ImageView(context);
        this.m = imageView4;
        imageView4.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387562);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = pf.ve(context, 48.0f);
        this.m.setLayoutParams(layoutParams17);
        z.c(this.c, "tt_splash_card_close", this.m, 320);
        relativeLayout.addView(this.m);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.sp = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387545);
        this.sp.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.sp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.sp);
        return relativeLayout;
    }

    public void n() {
        i.c cVar = this.uj;
        if (cVar == null) {
            return;
        }
        if (this.n == null) {
            this.n = new com.byazt.dyf.tt(cVar.getActivity(), this.ve.wq(), "splash_ad", true, com.byazt.xky.tt.c());
            com.byazt.tl.ve.c(this.uj.getActivity(), this.ve, (com.byazt.dyf.tt) this.n);
        }
        this.n.setDislikeSource("splash_card");
        this.n.showDislikeDialog();
    }

    @Override // com.byazt.cc.ve
    public void tt() {
        if (oz.x(this.ve)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.byazt.ddx.uj.tt(this.ve, "splash_ad", "splash_card_close", jSONObject);
                i.c cVar = this.uj;
                if (cVar != null) {
                    cVar.tt();
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public String uj() {
        ic icVar = this.ve;
        return (icVar == null || TextUtils.isEmpty(icVar.v_())) ? "" : this.ve.v_();
    }

    public String ve() {
        ic icVar = this.ve;
        if (icVar == null) {
            return "";
        }
        if (TextUtils.isEmpty(icVar.an())) {
            return (this.ve.z() == null || TextUtils.isEmpty(this.ve.z().ve())) ? "" : this.ve.z().ve();
        }
        return this.ve.an();
    }

    @Override // com.byazt.cc.ve
    public void c(Context context, ViewGroup viewGroup, ic icVar) {
        super.c(context, viewGroup, icVar);
        View viewC = c(this.c);
        if (viewC == null) {
            return;
        }
        this.tt.addView(viewC);
        this.f28350a.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.cc.uj.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), pf.ve(gt.getContext(), 18.0f));
            }
        });
        this.f28350a.setClipToOutline(true);
        this.sp.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.cc.uj.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), pf.ve(gt.getContext(), 28.0f));
            }
        });
        this.sp.setClipToOutline(true);
        pf.c(this.z, this.ve);
        List<zb> listPa = this.ve.pa();
        if (listPa != null && listPa.size() > 0) {
            com.byazt.xky.tt.c(listPa.get(0)).type(2).config(Bitmap.Config.ARGB_8888).to(new gr<Bitmap>() { // from class: com.byazt.cc.uj.3
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(com.byazt.yj.m<Bitmap> mVar) {
                    Bitmap result = mVar.getResult();
                    if (result == null) {
                        return;
                    }
                    try {
                        if (result.getConfig() == Bitmap.Config.RGB_565) {
                            result = result.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap bitmapC = com.byazt.or.tt.c(uj.this.c, result, 10);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(uj.this.c.getResources(), bitmapC);
                    com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.cc.uj.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (uj.this.x != null) {
                                uj.this.x.setBackground(bitmapDrawable);
                            }
                            if (uj.this.sp != null) {
                                uj.this.sp.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
        com.byazt.xky.tt.c(this.ve.te()).to(this.sl);
        this.t.setText(ve());
        this.u.setText(uj());
        this.yp.setVisibility(this.ve.fe() ? 0 : 8);
        this.yp.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.cc.uj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                uj.this.n();
            }
        });
        this.rh.setText(oz.uj(this.ve));
        this.my.setText(oz.ve(this.ve));
        c(this.ve);
    }

    private void c(ic icVar) {
        if (icVar == null || this.f28350a == null || oz.n(icVar) != 1) {
            return;
        }
        pf.c((View) this.gt, 0);
        pf.c((View) this.nu, 8);
        TextView textView = this.rl;
        if (textView != null) {
            textView.setText(oz.uj(icVar));
        }
        if (this.qy == null) {
            this.qy = new zm(gt.getContext(), 1, com.byazt.omf.x.m().uj());
        }
        this.qy.tt(this.ve.br());
        this.qy.c(this.ve.lv());
        this.qy.tt(this.ve.yx());
        this.qy.a(this.ve.pe());
        this.qy.c(icVar.ge());
        this.qy.ve(icVar.cy());
        this.qy.n(icVar.e());
        this.qy.c(new zm.c() { // from class: com.byazt.cc.uj.5
            @Override // com.byazt.nr.zm.c
            public void c(int i) {
                if (uj.this.gu == null || !uj.this.f28350a.isShown() || i != 1 || uj.this.gu == null) {
                    return;
                }
                if (uj.this.gu instanceof com.byazt.hkv.c) {
                    ((com.byazt.vis.c) ((com.byazt.hkv.c) uj.this.gu).c(com.byazt.vis.c.class)).c();
                }
                uj.this.gu.onClick(uj.this.f28350a);
            }
        });
        zm zmVar = this.qy;
        ic icVar2 = this.ve;
        zmVar.c(icVar2 != null ? icVar2.eo() : 0);
    }

    @Override // com.byazt.cc.ve
    public void c(com.byazt.hkv.c cVar) {
        if (cVar == null) {
            return;
        }
        this.gu = cVar;
        if (oz.sp(this.ve)) {
            this.f28350a.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.sl.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.da.setOnClickListener(this);
        }
        this.nu.setOnClickListener(this);
    }

    @Override // com.byazt.cc.ve
    public void c(com.byazt.un.uj ujVar, i.c cVar) {
        super.c(ujVar, cVar);
        this.tt.post(new Runnable() { // from class: com.byazt.cc.uj.6
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.f28350a.isAttachedToWindow()) {
                    uj.this.a().run();
                } else {
                    uj ujVar2 = uj.this;
                    ujVar2.tt.postDelayed(ujVar2.a(), 20L);
                }
            }
        });
        if (this.uj != null) {
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.cc.uj.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.byazt.ddx.uj.tt(uj.this.ve, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e) {
                        m.c(e);
                    }
                    uj.this.uj.tt();
                }
            });
        }
        oz.i(this.ve);
    }

    @Override // com.byazt.cc.ve
    public void c(boolean z) {
        super.c(z);
        i.c cVar = this.uj;
        if (cVar == null) {
            return;
        }
        if (z) {
            cVar.c(-1L);
        } else {
            cVar.c();
        }
        zm zmVar = this.qy;
        if (zmVar != null) {
            if (z) {
                ic icVar = this.ve;
                zmVar.c(icVar != null ? icVar.eo() : 0);
            } else {
                ic icVar2 = this.ve;
                zmVar.tt(icVar2 != null ? icVar2.eo() : 0);
            }
        }
    }
}
