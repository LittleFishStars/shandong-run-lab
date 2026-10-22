package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"AppCompatCustomView"})
public class ComplianceTextView extends TextView {
    private String avA;
    private String avB;
    private int avC;
    private String avv;
    private String avw;
    private String avx;
    private String avy;
    private String avz;
    private AdTemplate mAdTemplate;

    @ColorInt
    private int textColor;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.avC = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, 154);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (as.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.avw = "功能";
        this.avx = "权限";
        this.avy = "隐私";
        AdInfo.DownloadSafeInfo downloadSafeInfo = adInfoEO.downloadSafeInfo;
        this.avz = downloadSafeInfo.appPermissionInfoUrl;
        this.avB = downloadSafeInfo.appPrivacyUrl;
        this.avA = downloadSafeInfo.introductionInfoUrl;
        if (this.avC > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (as.VM()) {
                layoutParams.width = -1;
            } else {
                layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), this.avC);
            }
            setLayoutParams(layoutParams);
        }
        post(new bi() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = adInfoEO.downloadSafeInfo;
                complianceTextView.a(downloadSafeInfo2.appName, TextUtils.isEmpty(downloadSafeInfo2.corporationName) ? "" : adInfoEO.downloadSafeInfo.corporationName, TextUtils.isEmpty(adInfoEO.downloadSafeInfo.recordNumber) ? "" : adInfoEO.downloadSafeInfo.recordNumber, adInfoEO.downloadSafeInfo.appVersion, ComplianceTextView.this.avw, ComplianceTextView.this.avx, ComplianceTextView.this.avy);
            }
        });
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str4);
        }
        if (!TextUtils.isEmpty(this.avA)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C1220a().aY("功能介绍").aZ(ComplianceTextView.this.avA).aQ(true).aY(ComplianceTextView.this.mAdTemplate).ua());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.avz)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C1220a().aY("权限信息").aZ(ComplianceTextView.this.avz).aQ(true).aY(ComplianceTextView.this.mAdTemplate).ua());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.avB)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str7);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C1220a().aY("隐私政策").aZ(ComplianceTextView.this.avB).aQ(true).aY(ComplianceTextView.this.mAdTemplate).ua());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avv = "...\n";
        this.avC = 154;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int width;
        boolean z;
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        getContext();
        if (!as.VM()) {
            width = (this.avC - getPaddingLeft()) - getPaddingRight();
            z = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z = false;
        }
        if (width < 0) {
            return;
        }
        if (!z && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float fMeasureText = width - paint.measureText(str);
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            strSubstring = str2;
            sb.append(str2);
            if (paint.measureText(sb.toString()) > fMeasureText && fMeasureText > 0.0f) {
                while (strSubstring.length() > 1) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                    sb.setLength(0);
                    sb.append(" ");
                    sb.append(strSubstring);
                    sb.append(this.avv);
                    if (paint.measureText(sb.toString()) <= fMeasureText) {
                        break;
                    }
                }
            } else {
                this.avv = "";
            }
        } else {
            strSubstring = str2;
            this.avv = "";
        }
        b(str, strSubstring + this.avv, str3, str4, str5, str6, str7);
        requestLayout();
    }
}
