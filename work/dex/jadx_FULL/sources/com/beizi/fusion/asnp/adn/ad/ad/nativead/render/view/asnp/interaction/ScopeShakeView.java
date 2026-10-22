package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import androidx.constraintlayout.motion.widget.Key;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeIndicateArrowView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
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
public class ScopeShakeView extends ScopeInteractionViewGroup implements je {
    private ImageView f;
    private ScopeIndicateArrowView g;
    private RelativeLayout h;
    private AnimatorSet i;
    private boolean j;
    private TextView k;
    private TextView l;
    private String m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModel f27023a;

        public a(ViewModel viewModel) {
            this.f27023a = viewModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iMin = Math.min(ScopeShakeView.this.h.getMeasuredHeight(), ScopeShakeView.this.h.getMeasuredWidth());
            un.a(ScopeShakeView.this.getContext(), ScopeShakeView.this.h, this.f27023a.getBgColor(), no.i(this.f27023a.getBorderSize()), this.f27023a.getBorderColor(), un.a(this.f27023a.getBorderRadius(), iMin));
            ScopeShakeView.this.b(iMin, this.f27023a);
            ScopeShakeView.this.a(iMin, this.f27023a);
            ScopeShakeView.this.a(iMin);
        }
    }

    public ScopeShakeView(Context context) {
        super(context);
        this.j = false;
        this.m = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.g == null || this.b.getInteractionModel() == null) {
            return;
        }
        if (this.b.getInteractionModel().getFeedbackAnimation() == 0) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        int i2 = (int) (((double) i) * 0.7d);
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.g.setLayoutParams(layoutParams);
        this.g.setLineWidth(i / 30);
    }

    private void b() {
        ViewModel viewModel;
        RenderModel renderModel = this.b;
        if (renderModel == null || (viewModel = renderModel.getViewModel()) == null) {
            return;
        }
        this.h.post(new a(viewModel));
    }

    private void c() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.asnp_interaction_shake_view, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(viewInflate, layoutParams);
        this.h = (RelativeLayout) viewInflate.findViewById(R.id.adscope_isv_container_rl);
        this.f = (ImageView) viewInflate.findViewById(R.id.adscope_isv_img_iv);
        this.g = (ScopeIndicateArrowView) viewInflate.findViewById(R.id.adscope_isv_indicate_arrow_view);
        this.k = (TextView) viewInflate.findViewById(R.id.adscope_isv_title);
        this.l = (TextView) viewInflate.findViewById(R.id.adscope_isv_sub_title);
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
            TextView textView = this.k;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(textColor));
                this.k.setTextSize(2, fontSize);
                this.k.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(textColor));
                this.l.setTextSize(2, fontSize - 4);
                this.l.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        }
    }

    private void e() {
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.i = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.i = animatorSet2;
        animatorSet2.addListener(new mh(animatorSet2));
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        setBackgroundColor(0);
        RenderModel renderModel = this.b;
        if (renderModel != null) {
            aVar.b(renderModel.getId());
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        b();
        d();
        a();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionViewGroup, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.i = null;
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        e();
        xc xcVar = this.e;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).a(z);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        if (!z) {
            a();
        }
        xc xcVar = this.e;
        if (xcVar == null || !(xcVar instanceof mn)) {
            return;
        }
        ((mn) xcVar).k();
    }

    public void setMaxProgress(int i) {
        ScopeIndicateArrowView scopeIndicateArrowView = this.g;
        if (scopeIndicateArrowView != null) {
            scopeIndicateArrowView.setMaxProgress(i);
        }
    }

    public void setProgress(int i) {
        ScopeIndicateArrowView scopeIndicateArrowView = this.g;
        if (scopeIndicateArrowView != null) {
            scopeIndicateArrowView.setCurrentProgress(i);
        }
    }

    @Override // com.beizi.fusion.je
    public void setRenderWithDownload(boolean z) {
        this.j = z;
    }

    @Override // com.beizi.fusion.je
    public void updateByInteractiveStatus(String str) {
        if (this.m.equals(str)) {
            return;
        }
        this.m = str;
        c(str);
    }

    public ScopeShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.m = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, ViewModel viewModel) {
        RelativeLayout relativeLayout = this.h;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            this.h.setLayoutParams(layoutParams);
            if (no.d(viewModel.getBgColor())) {
                un.a(getContext(), this.h, viewModel.getBgColor(), 0, null, i / 2);
            } else {
                un.a(getContext(), this.h, "#66333333", 0, null, i / 2);
            }
        }
    }

    public ScopeShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.m = "";
    }

    public ScopeShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.j = false;
        this.m = "";
    }

    private void c(String str) {
        String strA = a(str);
        String strB = b(str);
        a(this.k, strA);
        a(this.l, strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ViewModel viewModel) {
        ImageView imageView = this.f;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            int i2 = (int) (((double) i) * 0.5d);
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.f.setLayoutParams(layoutParams);
            String imageURL = viewModel.getImageURL();
            if (TextUtils.isEmpty(imageURL)) {
                return;
            }
            mf.a(getContext()).b(imageURL).b(false).a(this.f);
        }
    }

    private String b(String str) {
        RenderModel renderModel = this.b;
        return (renderModel == null || renderModel.getViewModel() == null) ? "" : a(a(this.b.getViewModel().getInteractiveSubTitle()), str);
    }

    private void a() {
        try {
            AnimatorSet animatorSet = this.i;
            if (animatorSet == null || !animatorSet.isRunning()) {
                ArrayList arrayList = new ArrayList();
                a(arrayList, 0.0f, 30.0f);
                a(arrayList, 30.0f, 0.0f);
                a(arrayList, 0.0f, -30.0f);
                a(arrayList, -30.0f, 0.0f);
                if (arrayList.isEmpty()) {
                    return;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.i = animatorSet2;
                animatorSet2.addListener(new mh(animatorSet2));
                this.i.playSequentially(arrayList);
                this.i.start();
            }
        } catch (Exception e) {
            om.a(e);
        }
    }

    private void a(List list, float f, float f2) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f, Key.ROTATION, f, f2);
            objectAnimatorOfFloat.setDuration(100);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
    }

    private String a(String str) {
        RenderModel renderModel = this.b;
        return (renderModel == null || renderModel.getViewModel() == null) ? "" : a(a(this.b.getViewModel().getInteractiveTitle()), str);
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
        if (this.j) {
            return statusTitleModel.getDownload();
        }
        return statusTitleModel.getNormal();
    }
}
