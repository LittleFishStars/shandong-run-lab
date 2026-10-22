package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeIndicateArrowView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTitleModel;
import com.beizi.fusion.he;
import com.beizi.fusion.je;
import com.beizi.fusion.mf;
import com.beizi.fusion.mh;
import com.beizi.fusion.mn;
import com.beizi.fusion.no;
import com.beizi.fusion.om;
import com.beizi.fusion.un;
import com.beizi.fusion.xc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeEulerAngleView extends ScopeInteractionViewGroup implements je {
    public static final String EULER_ANGLE_DIRECTION_ANTICLOCKWISE = "2";
    public static final String EULER_ANGLE_DIRECTION_BIDIRECTIONAL = "0";
    public static final String EULER_ANGLE_DIRECTION_CLOCKWISE = "1";
    public static final String EULER_ANGLE_DIRECTION_REGULATORY = "3";
    private final String f;
    private final String g;
    private final String h;
    private RelativeLayout i;
    private ImageView j;
    private ScopeIndicateArrowView k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private AnimatorSet o;
    private boolean p;
    private Object q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModel f27022a;

        public a(ViewModel viewModel) {
            this.f27022a = viewModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iMin = Math.min(ScopeEulerAngleView.this.i.getMeasuredHeight(), ScopeEulerAngleView.this.i.getMeasuredWidth());
            un.a(ScopeEulerAngleView.this.getContext(), ScopeEulerAngleView.this.i, this.f27022a.getBgColor(), no.i(this.f27022a.getBorderSize()), this.f27022a.getBorderColor(), un.a(this.f27022a.getBorderRadius(), iMin));
            ScopeEulerAngleView.this.c(iMin);
            ScopeEulerAngleView.this.a(iMin);
            ScopeEulerAngleView.this.b(iMin);
        }
    }

    public ScopeEulerAngleView(Context context) {
        super(context);
        this.f = "rotationX";
        this.g = "rotationY";
        this.h = Key.ROTATION;
        this.q = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ImageView imageView = this.j;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            double d = i;
            layoutParams.width = (int) (0.35d * d);
            layoutParams.height = (int) (d * 0.5d);
            this.j.setLayoutParams(layoutParams);
        }
        String imageURL = this.b.getViewModel().getImageURL();
        if (TextUtils.isEmpty(imageURL)) {
            return;
        }
        mf.a(getContext()).b(imageURL).b(false).a(this.j);
    }

    private void b() {
        View viewInflate = View.inflate(getContext(), R.layout.asnp_interaction_euler_angle_view, null);
        this.i = (RelativeLayout) viewInflate.findViewById(R.id.adscope_ieav_container_rl);
        this.j = (ImageView) viewInflate.findViewById(R.id.adscope_ieav_img_iv);
        ScopeIndicateArrowView scopeIndicateArrowView = (ScopeIndicateArrowView) viewInflate.findViewById(R.id.adscope_ieav_indicate_arrow_view);
        this.k = scopeIndicateArrowView;
        scopeIndicateArrowView.setMaxProgress(100.0d);
        this.l = (LinearLayout) viewInflate.findViewById(R.id.adscope_ieav_title_container_ll);
        this.m = (TextView) viewInflate.findViewById(R.id.adscope_ieav_title_tv);
        this.n = (TextView) viewInflate.findViewById(R.id.adscope_ieav_subtitle_tv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(viewInflate, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            this.i.setLayoutParams(layoutParams);
            String bgColor = this.b.getViewModel().getBgColor();
            int i2 = i / 2;
            if (no.d(bgColor)) {
                un.a(getContext(), this.i, bgColor, 0, null, i2);
            } else {
                un.a(getContext(), this.i, "#66333333", 0, null, i2);
            }
        }
    }

    private void d() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.o = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.o = animatorSet2;
        animatorSet2.addListener(new mh(animatorSet2));
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        if (this.b != null) {
            setBackgroundColor(0);
            aVar.b(this.b.getId());
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        c();
        a();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionViewGroup, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.o = null;
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewDestroy() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.o.removeAllListeners();
        }
        this.o = null;
        super.onViewDestroy();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        xc xcVar = this.e;
        if (xcVar != null && (xcVar instanceof mn)) {
            ((mn) xcVar).a(z);
        }
        d();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        xc xcVar = this.e;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).k();
    }

    public void setCurrentProgress(double d) {
        try {
            ScopeIndicateArrowView scopeIndicateArrowView = this.k;
            if (scopeIndicateArrowView != null) {
                scopeIndicateArrowView.setCurrentProgress(d);
            }
        } catch (Exception e) {
            om.a(e);
        }
    }

    @Override // com.beizi.fusion.je
    public void setRenderWithDownload(boolean z) {
        this.p = z;
    }

    public void startInteractionAnimation(String str, String str2, String str3) {
        try {
            AnimatorSet animatorSet = this.o;
            if (animatorSet == null || !animatorSet.isRunning()) {
                a(str, str2, str3);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a(str, "rotationX"));
                arrayList.addAll(a(str2, "rotationY"));
                arrayList.addAll(a(str3, Key.ROTATION));
                if (arrayList.isEmpty()) {
                    return;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.o = animatorSet2;
                animatorSet2.addListener(new mh(animatorSet2));
                this.o.playSequentially(arrayList);
                this.o.start();
            }
        } catch (Exception e) {
            om.a(e);
        }
    }

    @Override // com.beizi.fusion.je
    public void updateByInteractiveStatus(String str) {
        if (this.q.equals(str)) {
            return;
        }
        this.q = str;
        c(str);
    }

    public ScopeEulerAngleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = "rotationX";
        this.g = "rotationY";
        this.h = Key.ROTATION;
        this.q = "";
    }

    public ScopeEulerAngleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = "rotationX";
        this.g = "rotationY";
        this.h = Key.ROTATION;
        this.q = "";
    }

    private void c() {
        if (this.b.getViewModel() != null) {
            String textColor = this.b.getViewModel().getTextColor();
            if (!no.d(textColor)) {
                textColor = "#FFFFFFFF";
            }
            int fontSize = this.b.getViewModel().getFontSize();
            if (fontSize == 0) {
                fontSize = 20;
            }
            TextView textView = this.m;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(textColor));
                this.m.setTextSize(2, fontSize);
                this.m.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(textColor));
                this.n.setTextSize(2, fontSize - 4);
                this.n.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        }
    }

    private List a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            float f = ("rotationX".equalsIgnoreCase(str2) || "rotationY".equalsIgnoreCase(str2)) ? 60.0f : 30.0f;
            ArrayList arrayList = new ArrayList();
            if ("2".equalsIgnoreCase(str)) {
                float f2 = -f;
                a(arrayList, str2, 0.0f, f2);
                a(arrayList, str2, f2, 0.0f);
                return arrayList;
            }
            if ("1".equalsIgnoreCase(str)) {
                a(arrayList, str2, 0.0f, f);
                a(arrayList, str2, f, 0.0f);
                return arrayList;
            }
            a(arrayList, str2, 0.0f, f);
            a(arrayList, str2, f, 0.0f);
            float f3 = -f;
            a(arrayList, str2, 0.0f, f3);
            a(arrayList, str2, f3, 0.0f);
            return arrayList;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        try {
            if (this.k == null) {
                return;
            }
            InteractionModel interactionModel = this.b.getInteractionModel();
            if ((interactionModel != null ? interactionModel.getFeedbackAnimation() : 0) == 0) {
                this.k.setVisibility(8);
                return;
            }
            this.k.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            int i2 = (int) (((double) i) * 0.7d);
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.k.setLayoutParams(layoutParams);
            this.k.setLineWidth(i / 30);
        } catch (Exception e) {
            om.a(e);
        }
    }

    public ScopeEulerAngleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = "rotationX";
        this.g = "rotationY";
        this.h = Key.ROTATION;
        this.q = "";
    }

    private void c(String str) {
        boolean z;
        String strA = a(str);
        String strB = b(str);
        try {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            boolean z2 = true;
            if (this.m == null || TextUtils.isEmpty(strA)) {
                z = false;
            } else if (!TextUtils.isEmpty(strA)) {
                this.m.setVisibility(0);
                this.m.setText(strA);
                z = false;
            } else {
                this.m.setVisibility(8);
                z = true;
            }
            if (this.n == null) {
                z2 = z;
            } else if (!TextUtils.isEmpty(strB)) {
                this.n.setVisibility(0);
                this.n.setText(strB);
                z2 = z;
            } else {
                this.n.setVisibility(8);
            }
            if (z2) {
                a();
            }
        } catch (Exception e) {
            om.a(e);
        }
    }

    private String b(String str) {
        RenderModel renderModel = this.b;
        return (renderModel == null || renderModel.getViewModel() == null) ? "" : a(a(this.b.getViewModel().getInteractiveSubTitle()), str);
    }

    private void a(List list, String str, float f, float f2) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.j, str, f, f2);
            objectAnimatorOfFloat.setDuration(350);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e) {
            om.a(e);
        }
    }

    private void a() {
        ViewModel viewModel;
        RenderModel renderModel = this.b;
        if (renderModel == null || (viewModel = renderModel.getViewModel()) == null) {
            return;
        }
        this.i.post(new a(viewModel));
    }

    private void a(String str, String str2, String str3) {
        try {
            if (this.k == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.k.setArrowDirection(0);
                return;
            }
            if (("1".equals(str2) && "1".equals(str3)) || ((TextUtils.isEmpty(str2) && "1".equals(str3)) || (TextUtils.isEmpty(str3) && "1".equals(str2)))) {
                this.k.setArrowDirection(1);
                return;
            }
            if (("2".equals(str2) && "2".equals(str3)) || ((TextUtils.isEmpty(str2) && "2".equals(str3)) || (TextUtils.isEmpty(str3) && "2".equals(str2)))) {
                this.k.setArrowDirection(2);
            } else {
                this.k.setArrowDirection(0);
            }
        } catch (Exception e) {
            om.a(e);
        }
    }

    private String a(String str) {
        RenderModel renderModel = this.b;
        return (renderModel == null || renderModel.getViewModel() == null) ? "" : a(a(this.b.getViewModel().getInteractiveTitle()), str);
    }

    private StatusParamModel a(StatusTitleModel statusTitleModel) {
        if (statusTitleModel == null) {
            return null;
        }
        if (this.p) {
            return statusTitleModel.getDownload();
        }
        return statusTitleModel.getNormal();
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
}
