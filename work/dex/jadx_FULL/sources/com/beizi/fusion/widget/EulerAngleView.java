package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.widget.Key;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.vn;
import com.beizi.fusion.z3;
import com.google.android.exoplayer2.source.rtsp.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EulerAngleView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27941a;
    private Context b;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean c;
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean d;
    private LinearLayout e;
    private RelativeLayout f;
    private ImageView g;
    private ShakeArcView h;
    private TextView i;
    private TextView j;
    private float k;
    private float l;
    private float m;
    private int n;
    private int o;
    private int p;
    private double q;
    private double r;
    private double s;
    private String t;
    private String u;
    private String v;
    private AnimatorSet w;
    private Boolean x;

    public class a implements z3.c {
        public a() {
        }

        @Override // com.beizi.fusion.z3.c
        public void a() {
        }

        @Override // com.beizi.fusion.z3.c
        public void a(Bitmap bitmap) {
            try {
                ImageView imageView = EulerAngleView.this.g;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                AnimatorSet animatorSet = EulerAngleView.this.w;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public EulerAngleView(Context context) {
        super(context);
        this.f27941a = false;
        this.k = 60.0f;
        this.l = 60.0f;
        this.m = 30.0f;
        this.n = 350;
        this.q = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.r = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.s = AudioStats.AUDIO_AMPLITUDE_NONE;
        init(context);
    }

    private void a(List list, String str, float f, float f2) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, str, f, f2);
            objectAnimatorOfFloat.setDuration(this.n);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildEulerAngleView() {
        String downloadSubTitle;
        TextView textView;
        TextView textView2;
        List<String> imgs;
        try {
            if (this.c == null) {
                return;
            }
            View.inflate(getContext(), R.layout.beizi_interaction_euler_angle_view, this);
            this.e = (LinearLayout) findViewById(R.id.bz_eav_container_ll);
            this.f = (RelativeLayout) findViewById(R.id.bz_eav_img_container_rl);
            this.g = (ImageView) findViewById(R.id.bz_eav_img_iv);
            this.h = (ShakeArcView) findViewById(R.id.bz_eav_sav_iv);
            this.i = (TextView) findViewById(R.id.bz_eav_title_tv);
            this.j = (TextView) findViewById(R.id.bz_eav_subtitle_tv);
            RelativeLayout relativeLayout = this.f;
            if (relativeLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.width = this.o;
                layoutParams.height = this.p;
                this.f.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.width = (int) (((double) this.o) * 0.35d);
                double d = this.p;
                layoutParams2.height = (int) (0.5d * d);
                layoutParams2.setMargins(0, 0, 0, (int) (d * 0.2d));
                this.g.setLayoutParams(layoutParams2);
            }
            ShakeArcView shakeArcView = this.h;
            if (shakeArcView != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) shakeArcView.getLayoutParams();
                layoutParams3.width = (int) (((double) Math.min(this.o, this.p)) * 0.7d);
                layoutParams3.height = (int) (((double) Math.min(this.o, this.p)) * 0.7d);
                this.h.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(this.t)) {
                    this.h.setArrowDirection(0);
                } else if (("1".equals(this.u) && "1".equals(this.v)) || ((TextUtils.isEmpty(this.u) && "1".equals(this.v)) || (TextUtils.isEmpty(this.v) && "1".equals(this.u)))) {
                    this.h.setArrowDirection(1);
                } else if (("2".equals(this.u) && "2".equals(this.v)) || ((TextUtils.isEmpty(this.u) && "2".equals(this.v)) || (TextUtils.isEmpty(this.v) && "2".equals(this.u)))) {
                    this.h.setArrowDirection(2);
                }
                try {
                    this.h.setLineWidth(Math.min(this.o, this.p) / 30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean = this.d;
            String color = eulerAngleRenderBean != null ? eulerAngleRenderBean.getColor() : "#66333333";
            String title = null;
            if (!TextUtils.isEmpty(color) && color.startsWith("#")) {
                vn.a(this.f, color, 0, null, this.o / 2);
            }
            AdSpacesBean.BuyerBean.EulerAngleStyleBean style = this.c.getStyle();
            String str = (style == null || (imgs = style.getImgs()) == null || imgs.size() <= 0) ? null : imgs.get(0);
            if (!TextUtils.isEmpty(str)) {
                z3.a(this.b).b(str, new a());
            }
            ShakeArcView shakeArcView2 = this.h;
            if (shakeArcView2 != null) {
                shakeArcView2.setMaxProgress(100.0d);
            }
            if (style != null) {
                title = style.getTitle();
                if (this.x.booleanValue()) {
                    downloadSubTitle = style.getDownloadSubTitle();
                    if (TextUtils.isEmpty(downloadSubTitle)) {
                        downloadSubTitle = "下载应用";
                    }
                } else {
                    downloadSubTitle = style.getSubTitle();
                }
            } else {
                downloadSubTitle = null;
            }
            if (!TextUtils.isEmpty(title) && (textView2 = this.i) != null) {
                textView2.setText(title);
                this.i.setTextColor(Color.parseColor("#FFFFFFFF"));
                this.i.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            if (TextUtils.isEmpty(downloadSubTitle) || (textView = this.j) == null) {
                return;
            }
            textView.setText(downloadSubTitle);
            this.j.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.j.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f27941a) {
            return;
        }
        this.b = context;
        this.f27941a = true;
    }

    public void onDestroy() {
        try {
            this.b = null;
            AnimatorSet animatorSet = this.w;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.w = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAngle(double d, double d2, double d3) {
        this.q = d;
        this.r = d2;
        this.s = d3;
    }

    public void setAnimationViewWidthAndHeight(int i, int i2) {
        this.o = i;
        this.p = i2;
    }

    public void setCurrentProgress(double d, double d2, double d3) {
        try {
            if (this.h != null) {
                double d4 = this.q;
                double dAbs = AudioStats.AUDIO_AMPLITUDE_NONE;
                double dAbs2 = (d4 <= AudioStats.AUDIO_AMPLITUDE_NONE || ((!"2".equals(this.t) || d <= AudioStats.AUDIO_AMPLITUDE_NONE) && !(("1".equals(this.t) && d < AudioStats.AUDIO_AMPLITUDE_NONE) || "0".equals(this.t) || "3".equals(this.t)))) ? 0.0d : (Math.abs(d) * 100.0d) / this.q;
                double dAbs3 = (this.r <= AudioStats.AUDIO_AMPLITUDE_NONE || ((!"2".equals(this.u) || d2 >= AudioStats.AUDIO_AMPLITUDE_NONE) && !(("1".equals(this.u) && d2 > AudioStats.AUDIO_AMPLITUDE_NONE) || "0".equals(this.u) || "3".equals(this.u)))) ? 0.0d : (Math.abs(d2) * 100.0d) / this.r;
                if (this.s > AudioStats.AUDIO_AMPLITUDE_NONE && (("2".equals(this.v) && d3 > AudioStats.AUDIO_AMPLITUDE_NONE) || (("1".equals(this.v) && d3 < AudioStats.AUDIO_AMPLITUDE_NONE) || "0".equals(this.v) || "3".equals(this.v)))) {
                    dAbs = (Math.abs(d3) * 100.0d) / this.s;
                }
                this.h.setCurrentProgress(Math.max(Math.max(dAbs2, dAbs3), dAbs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.x = bool;
    }

    public void setEulerAngleRenderBean(AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean) {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            this.d = eulerAngleRenderBean;
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        String direction = eulerAngleRuleBean.getDirection();
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.t = direction;
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.u = direction;
                        } else if (j.o.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.v = direction;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEulerAngleViewRuleBean(AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean) {
        this.c = eulerAngleViewRuleBean;
    }

    public void startContinuousRotations() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null && eulerAngleRuleBean.getAngle() != AudioStats.AUDIO_AMPLITUDE_NONE) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationX", 0.0f, -this.k);
                                a(arrayList, "rotationX", -this.k, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationX", 0.0f, this.k);
                                a(arrayList, "rotationX", this.k, 0.0f);
                            } else {
                                a(arrayList, "rotationX", 0.0f, this.k);
                                a(arrayList, "rotationX", this.k, 0.0f);
                                a(arrayList, "rotationX", 0.0f, -this.k);
                                a(arrayList, "rotationX", -this.k, 0.0f);
                            }
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationY", 0.0f, -this.l);
                                a(arrayList, "rotationY", -this.l, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationY", 0.0f, this.l);
                                a(arrayList, "rotationY", this.l, 0.0f);
                            } else {
                                a(arrayList, "rotationY", 0.0f, this.l);
                                a(arrayList, "rotationY", this.l, 0.0f);
                                a(arrayList, "rotationY", 0.0f, -this.l);
                                a(arrayList, "rotationY", -this.l, 0.0f);
                            }
                        } else if (j.o.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, Key.ROTATION, 0.0f, -this.m);
                                a(arrayList, Key.ROTATION, -this.m, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, Key.ROTATION, 0.0f, this.m);
                                a(arrayList, Key.ROTATION, this.m, 0.0f);
                            } else {
                                a(arrayList, Key.ROTATION, 0.0f, this.m);
                                a(arrayList, Key.ROTATION, this.m, 0.0f);
                                a(arrayList, Key.ROTATION, 0.0f, -this.m);
                                a(arrayList, Key.ROTATION, -this.m, 0.0f);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.w = animatorSet;
                    animatorSet.addListener(new b());
                    this.w.playSequentially(arrayList);
                    this.w.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EulerAngleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27941a = false;
        this.k = 60.0f;
        this.l = 60.0f;
        this.m = 30.0f;
        this.n = 350;
        this.q = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.r = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.s = AudioStats.AUDIO_AMPLITUDE_NONE;
        init(context);
    }

    public EulerAngleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27941a = false;
        this.k = 60.0f;
        this.l = 60.0f;
        this.m = 30.0f;
        this.n = 350;
        this.q = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.r = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.s = AudioStats.AUDIO_AMPLITUDE_NONE;
        init(context);
    }
}
