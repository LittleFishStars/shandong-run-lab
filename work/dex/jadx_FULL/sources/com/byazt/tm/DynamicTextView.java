package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.byazt.aq.x;
import com.byazt.du.sl;
import com.byazt.nr.m;
import com.byazt.oq.AnimationText;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1174})
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.x += 6;
        if (this.t.pf()) {
            AnimationText animationText = new AnimationText(context, this.t.sp(), this.t.n(), 1, this.t.x());
            this.z = animationText;
            animationText.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.z = textView;
            textView.setIncludeFontPadding(false);
        }
        this.z.setTag(Integer.valueOf(getClickArea()));
        addView(this.z, getWidgetLayoutParams());
    }

    private void da() {
        int iC;
        if (TextUtils.equals(this.u.da().getType(), "source") || TextUtils.equals(this.u.da().getType(), "title") || TextUtils.equals(this.u.da().getType(), "text_star")) {
            int[] iArrTt = sl.tt(this.t.a(), this.t.n(), true);
            int iC2 = (int) com.byazt.or.x.c(getContext(), this.t.tt());
            int iC3 = (int) com.byazt.or.x.c(getContext(), this.t.ve());
            int iC4 = (int) com.byazt.or.x.c(getContext(), this.t.uj());
            int iC5 = (int) com.byazt.or.x.c(getContext(), this.t.c());
            int iMin = Math.min(iC2, iC5);
            if (TextUtils.equals(this.u.da().getType(), "source") && (iC = ((this.x - ((int) com.byazt.or.x.c(getContext(), this.t.n()))) - iC2) - iC5) > 1 && iC <= iMin * 2) {
                int i = iC / 2;
                this.z.setPadding(iC3, iC2 - i, iC4, iC5 - (iC - i));
                return;
            }
            int i2 = (((iArrTt[1] + iC2) + iC5) - this.x) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.z.setPadding(iC3, iC2 - i3, iC4, iC5 - (i2 - i3));
            } else if (i2 > iC2 + iC5) {
                final int i4 = (i2 - iC2) - iC5;
                this.z.setPadding(iC3, 0, iC4, 0);
                if (i4 <= ((int) com.byazt.or.x.c(getContext(), 1.0f)) + 1) {
                    ((TextView) this.z).setTextSize(this.t.n() - 1.0f);
                } else if (i4 <= (((int) com.byazt.or.x.c(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.z).setTextSize(this.t.n() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.byazt.tm.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.z.getLayoutParams();
                                DynamicTextView dynamicTextView = DynamicTextView.this;
                                layoutParams.height = dynamicTextView.x + i4;
                                dynamicTextView.z.setLayoutParams(layoutParams);
                                DynamicTextView.this.z.setTranslationY(-i4);
                                ((ViewGroup) DynamicTextView.this.z.getParent()).setClipChildren(false);
                                ((ViewGroup) DynamicTextView.this.z.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iC2 > iC5) {
                this.z.setPadding(iC3, iC2 - (i2 - iMin), iC4, iC5 - iMin);
            } else {
                this.z.setPadding(iC3, iC2 - iMin, iC4, iC5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.u.da().getType(), "fillButton")) {
            this.z.setTextAlignment(2);
            ((TextView) this.z).setGravity(17);
        }
    }

    private boolean i() {
        DynamicRootView dynamicRootView = this.yp;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.yp.getRenderRequest().t() == 4) ? false : true;
    }

    private void sl() {
        if (this.z instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                m.c(e);
                arrayList.add(text);
            }
            ((AnimationText) this.z).setMaxLines(1);
            ((AnimationText) this.z).setTextColor(this.t.sp());
            ((AnimationText) this.z).setTextSize(this.t.n());
            ((AnimationText) this.z).setAnimationText(arrayList);
            ((AnimationText) this.z).setAnimationType(this.t.sv());
            ((AnimationText) this.z).setAnimationDuration(this.t.bx() * 1000);
            ((AnimationText) this.z).c();
        }
    }

    public void c(TextView textView, int i) {
        textView.setText("(" + String.format("%1$s个评分", Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        String strA = this.t.a();
        if (TextUtils.isEmpty(strA)) {
            if (!com.byazt.sr.uj.c() && TextUtils.equals(this.u.da().getType(), "text_star")) {
                strA = "5";
            }
            if (!com.byazt.sr.uj.c() && TextUtils.equals(this.u.da().getType(), "score-count")) {
                strA = "6870";
            }
        }
        return (TextUtils.equals(this.u.da().getType(), "title") || TextUtils.equals(this.u.da().getType(), MediaFormat.KEY_SUBTITLE)) ? strA.replace("\n", "") : strA;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        int i;
        double d;
        super.x();
        if (TextUtils.isEmpty(getText())) {
            this.z.setVisibility(4);
            return true;
        }
        if (this.t.pf()) {
            sl();
            return true;
        }
        ((TextView) this.z).setText(this.t.a());
        ((TextView) this.z).setTextDirection(5);
        this.z.setTextAlignment(this.t.x());
        ((TextView) this.z).setTextColor(this.t.sp());
        ((TextView) this.z).setTextSize(this.t.n());
        if (this.t.qy()) {
            int iGu = this.t.gu();
            if (iGu > 0) {
                ((TextView) this.z).setLines(iGu);
                ((TextView) this.z).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.z).setMaxLines(1);
            ((TextView) this.z).setGravity(17);
            ((TextView) this.z).setEllipsize(TextUtils.TruncateAt.END);
        }
        x xVar = this.u;
        if (xVar != null && xVar.da() != null) {
            if (com.byazt.sr.uj.c() && i() && (TextUtils.equals(this.u.da().getType(), "text_star") || TextUtils.equals(this.u.da().getType(), "score-count") || TextUtils.equals(this.u.da().getType(), "score-count-type-1") || TextUtils.equals(this.u.da().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.u.da().getType(), "score-count") || TextUtils.equals(this.u.da().getType(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.byazt.sr.uj.c()) {
                        setVisibility(8);
                        return true;
                    }
                    this.z.setVisibility(0);
                }
                if (TextUtils.equals(this.u.da().getType(), "score-count-type-2")) {
                    ((TextView) this.z).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.z).setGravity(17);
                    return true;
                }
                c((TextView) this.z, i);
            } else if (TextUtils.equals(this.u.da().getType(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    m.uj("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < AudioStats.AUDIO_AMPLITUDE_NONE || d > 5.0d) {
                    if (com.byazt.sr.uj.c()) {
                        setVisibility(8);
                        return true;
                    }
                    this.z.setVisibility(0);
                }
                ((TextView) this.z).setIncludeFontPadding(false);
                ((TextView) this.z).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.u.da().getType())) {
                ((TextView) this.z).setText("功能 | 权限 | 隐私");
            } else if (TextUtils.equals(this.u.da().getType(), "development-name")) {
                ((TextView) this.z).setText("开发者：" + getText());
            } else if (TextUtils.equals(this.u.da().getType(), "app-version")) {
                ((TextView) this.z).setText("版本号：V" + getText());
            } else {
                ((TextView) this.z).setText(getText());
            }
            this.z.setTextAlignment(this.t.x());
            ((TextView) this.z).setGravity(this.t.i());
            if (com.byazt.sr.uj.c()) {
                da();
            }
        }
        return true;
    }
}
