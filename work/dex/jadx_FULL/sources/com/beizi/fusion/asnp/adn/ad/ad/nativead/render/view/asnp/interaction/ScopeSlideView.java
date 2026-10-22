package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTitleModel;
import com.beizi.fusion.en;
import com.beizi.fusion.he;
import com.beizi.fusion.je;
import com.beizi.fusion.no;
import com.beizi.fusion.yl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeSlideView extends ScopeInteractionViewGroup implements je {
    private ImageView f;
    private ImageView g;
    private en h;
    private TextView i;
    private TextView j;
    private String k;
    private boolean l;
    private RelativeLayout m;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScopeSlideView.this.a(ScopeSlideView.this.getLayoutParams());
            ScopeSlideView.this.a();
            ScopeSlideView.this.e();
        }
    }

    public class b extends en {
        private final String b;

        public b(int i, int i2, String str) {
            super(i, i2, 1000L);
            this.b = str;
            a(-1, 1);
        }

        @Override // com.beizi.fusion.en
        public void a(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ScopeSlideView scopeSlideView = ScopeSlideView.this;
            ImageView imageView = scopeSlideView.g;
            if (imageView == null || scopeSlideView.f == null) {
                return;
            }
            imageView.layout(iIntValue, imageView.getTop(), ScopeSlideView.this.g.getWidth() + iIntValue, ScopeSlideView.this.g.getBottom());
            if ("slideleft".equalsIgnoreCase(this.b)) {
                ImageView imageView2 = ScopeSlideView.this.f;
                imageView2.layout(iIntValue, imageView2.getTop(), ScopeSlideView.this.f.getRight(), ScopeSlideView.this.f.getBottom());
            } else {
                ImageView imageView3 = ScopeSlideView.this.f;
                imageView3.layout(imageView3.getLeft(), ScopeSlideView.this.f.getTop(), iIntValue, ScopeSlideView.this.f.getBottom());
            }
        }
    }

    public class c extends en {
        private final String b;

        private c(int i, int i2, String str) {
            super(i, i2, 1000L);
            this.b = str;
            a(-1, 1);
        }

        @Override // com.beizi.fusion.en
        public void a(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ScopeSlideView scopeSlideView = ScopeSlideView.this;
            ImageView imageView = scopeSlideView.g;
            if (imageView == null || scopeSlideView.f == null) {
                return;
            }
            imageView.layout(imageView.getLeft(), iIntValue, ScopeSlideView.this.g.getRight(), ScopeSlideView.this.g.getHeight() + iIntValue);
            if ("slideup".equalsIgnoreCase(this.b)) {
                ImageView imageView2 = ScopeSlideView.this.f;
                imageView2.layout(imageView2.getLeft(), iIntValue, ScopeSlideView.this.f.getRight(), ScopeSlideView.this.f.getBottom());
            } else {
                ImageView imageView3 = ScopeSlideView.this.f;
                imageView3.layout(imageView3.getLeft(), ScopeSlideView.this.f.getTop(), ScopeSlideView.this.f.getRight(), iIntValue);
            }
        }
    }

    public ScopeSlideView(Context context) {
        super(context);
    }

    private int a(TextView textView) {
        if (textView == null || textView.getVisibility() == 8) {
            return 0;
        }
        return yl.a.a(getContext(), textView);
    }

    private void b() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.asnp_interaction_slide_view, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        addView(viewInflate, layoutParams);
        this.m = (RelativeLayout) viewInflate.findViewById(R.id.guild_layout);
        this.f = (ImageView) viewInflate.findViewById(R.id.slide_basic_line);
        this.g = (ImageView) viewInflate.findViewById(R.id.slide_guide_icon);
        this.i = (TextView) viewInflate.findViewById(R.id.main_title);
        this.j = (TextView) viewInflate.findViewById(R.id.sub_title);
    }

    private void c() {
        en enVar = this.h;
        if (enVar != null) {
            enVar.b();
        }
    }

    private String d(String str) {
        RenderModel renderModel = this.b;
        return (renderModel == null || renderModel.getViewModel() == null) ? "" : a(a(this.b.getViewModel().getInteractiveSubTitle()), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        en enVar = this.h;
        if (enVar != null) {
            enVar.c();
        }
    }

    private void f() {
        String strC = c("Normal");
        if (this.i != null) {
            if (TextUtils.isEmpty(strC)) {
                this.i.setVisibility(8);
            } else {
                this.i.setText(strC);
            }
        }
        String strD = d("Normal");
        if (this.j != null) {
            if (TextUtils.isEmpty(strD)) {
                this.j.setVisibility(8);
            } else {
                this.j.setText(strD);
            }
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        super.fillContent(aVar);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        d();
        f();
        post(new a());
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        c();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        e();
    }

    @Override // com.beizi.fusion.je
    public void setRenderWithDownload(boolean z) {
        this.l = z;
    }

    @Override // com.beizi.fusion.je
    public void updateByInteractiveStatus(String str) {
        f();
    }

    public ScopeSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup.LayoutParams layoutParams) {
        RenderModel renderModel;
        if (layoutParams == null || (renderModel = this.b) == null || renderModel.getInteractionModel() == null) {
            return;
        }
        int iA = (layoutParams.height - a(this.i)) - a(this.j);
        String animationType = this.b.getViewModel().getAnimationType();
        this.k = animationType;
        if (TextUtils.isEmpty(animationType)) {
            this.k = "slideup";
        }
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = iA;
        if (!TextUtils.isEmpty(this.k)) {
            if (b(this.k) && "slidedown".equalsIgnoreCase(this.k)) {
                this.f.setRotation(180.0f);
            }
            if (a(this.k)) {
                if ("slideright".equalsIgnoreCase(this.k)) {
                    this.f.setRotation(90.0f);
                }
                if ("slideleft".equalsIgnoreCase(this.k)) {
                    this.f.setRotation(270.0f);
                }
            }
        }
        this.m.setLayoutParams(layoutParams2);
    }

    private String c(String str) {
        RenderModel renderModel = this.b;
        return (renderModel == null || renderModel.getViewModel() == null) ? "" : a(a(this.b.getViewModel().getInteractiveTitle()), str);
    }

    public ScopeSlideView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void d() {
        if (this.b.getViewModel() != null) {
            String textColor = this.b.getViewModel().getTextColor();
            if (!no.d(textColor)) {
                textColor = "#FFFFFFFF";
            }
            int fontSize = this.b.getViewModel().getFontSize();
            if (fontSize == 0) {
                fontSize = 20;
            }
            TextView textView = this.i;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(textColor));
                this.i.setTextSize(2, fontSize);
                this.i.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(textColor));
                this.j.setTextSize(2, fontSize - 4);
                this.j.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        }
    }

    private boolean b(String str) {
        return "slidedown".equalsIgnoreCase(str) || "slideup".equalsIgnoreCase(str);
    }

    private boolean a(String str) {
        return "slideleft".equalsIgnoreCase(str) || "slideright".equalsIgnoreCase(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int bottom;
        int top;
        int bottom2;
        int height;
        String str = this.k;
        int iHashCode = str.hashCode();
        if (iHashCode != -2119261172) {
            if (iHashCode == -795991597) {
                str.equals("slidedown");
            } else if (iHashCode != -795763400) {
                if (iHashCode == 1106799371 && str.equals("slideright")) {
                    bottom = this.f.getLeft();
                    bottom2 = this.f.getRight();
                    height = this.g.getWidth();
                }
                top = bottom2 - height;
            } else if (str.equals("slideleft")) {
                bottom = this.f.getRight() - this.g.getWidth();
                top = this.f.getLeft();
            }
            bottom = this.f.getTop();
            bottom2 = this.f.getBottom();
            height = this.g.getHeight();
            top = bottom2 - height;
        } else if (str.equals("slideup")) {
            bottom = this.f.getBottom() - this.g.getHeight();
            top = this.f.getTop();
        } else {
            bottom = this.f.getTop();
            bottom2 = this.f.getBottom();
            height = this.g.getHeight();
            top = bottom2 - height;
        }
        int i = bottom;
        int i2 = top;
        if ("slideleft".equalsIgnoreCase(this.k) || "slideright".equalsIgnoreCase(this.k)) {
            this.h = new b(i, i2, this.k);
        }
        if ("slideup".equalsIgnoreCase(this.k) || "slidedown".equalsIgnoreCase(this.k)) {
            this.h = new c(i, i2, this.k);
        }
    }

    private String a(StatusParamModel statusParamModel, String str) {
        if (statusParamModel == null) {
            return "";
        }
        if ("Normal".equals(str)) {
            return statusParamModel.getNormal();
        }
        if ("Passive".equals(str)) {
            return statusParamModel.getPassivation();
        }
        return "Cooling".equals(str) ? statusParamModel.getCool() : "";
    }

    private StatusParamModel a(StatusTitleModel statusTitleModel) {
        if (statusTitleModel == null) {
            return null;
        }
        if (this.l) {
            return statusTitleModel.getDownload();
        }
        return statusTitleModel.getNormal();
    }
}
