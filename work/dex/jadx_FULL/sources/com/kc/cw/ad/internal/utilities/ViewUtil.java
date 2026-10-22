package com.kc.cw.ad.internal.utilities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.activity.BrowserAdActivity;
import com.kc.cw.ad.internal.c.t;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.model.AdLogoInfo;
import com.kc.cw.ad.model.ComplianceInfo;
import com.kc.cw.ad.utils.ThreadUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ViewUtil {
    public static FrameLayout createAdImageView(Context context, AdLogoInfo adLogoInfo, int i, int i2, float f) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(4);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        float f2 = 10.0f * f;
        int i3 = (int) f2;
        if (adLogoInfo != null) {
            q qVarA = q.a();
            if (adLogoInfo.getType() == AdLogoInfo.TYPE_PIC) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int iApplyDimension = (int) TypedValue.applyDimension(1, f * 14.0f, qVarA.r());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iApplyDimension * 2, iApplyDimension, i2 | 80);
                layoutParams.setMargins(0, 0, 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
                if (TextUtils.isEmpty(adLogoInfo.getAdurl()) || !adLogoInfo.getAdurl().endsWith("remdad.png")) {
                    ImageManager.with(context).load(adLogoInfo.getAdurl()).into(imageView);
                } else {
                    imageView.setImageResource(R.drawable.ss_logo_text);
                }
                frameLayout.addView(imageView);
            } else if (adLogoInfo.getType() == AdLogoInfo.TYPE_TEXT) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                appCompatTextView.setTextSize(2, f2);
                appCompatTextView.setTextColor(-1);
                appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
                appCompatTextView.setText(adLogoInfo.getAdurl());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, i2 | 80);
                layoutParams2.setMargins(0, 0, i * i3, 0);
                frameLayout.addView(appCompatTextView, layoutParams2);
            }
        }
        return frameLayout;
    }

    public static AppCompatTextView createComplianceView(Context context, ComplianceInfo complianceInfo, float f, boolean z) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        if (complianceInfo == null) {
            return appCompatTextView;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        appCompatTextView.setTextSize(8.0f * f);
        int i = (int) (f * 10.0f);
        if (z) {
            appCompatTextView.setPadding(i, i, i, i);
        } else {
            appCompatTextView.setPadding(i * 3, i, i * 16, i * 4);
        }
        String str = String.format("应用名称：%1$s | 开发者：%2$s | 应用版本：%3$s | 权限详情 | 隐私协议 | 功能介绍", complianceInfo.getAppName(), complianceInfo.getDeveloperName(), complianceInfo.getAppVersion());
        SpannableString spannableString = new SpannableString(str);
        ClickableSpan clickableSpan = new ClickableSpan(complianceInfo) { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.3
            final ComplianceInfo val$complianceInfo;

            {
                this.val$complianceInfo = complianceInfo;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ViewUtil.openLocalBrowser(this.val$complianceInfo.getPermissionsUrl(), 0);
            }
        };
        int iIndexOf = str.indexOf("权限详情");
        spannableString.setSpan(clickableSpan, iIndexOf, iIndexOf + 4, 17);
        ClickableSpan clickableSpan2 = new ClickableSpan(complianceInfo) { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.4
            final ComplianceInfo val$complianceInfo;

            {
                this.val$complianceInfo = complianceInfo;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ViewUtil.openLocalBrowser(this.val$complianceInfo.getPrivacyUrl(), 0);
            }
        };
        int iIndexOf2 = str.indexOf("隐私协议");
        spannableString.setSpan(clickableSpan2, iIndexOf2, iIndexOf2 + 4, 17);
        ClickableSpan clickableSpan3 = new ClickableSpan(complianceInfo) { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.5
            final ComplianceInfo val$complianceInfo;

            {
                this.val$complianceInfo = complianceInfo;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ViewUtil.openLocalBrowser(this.val$complianceInfo.getFunctionDescUrl(), 0);
            }
        };
        int iIndexOf3 = str.indexOf("功能介绍");
        spannableString.setSpan(clickableSpan3, iIndexOf3, iIndexOf3 + 4, 17);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 33);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
        appCompatTextView.setText(spannableString);
        return appCompatTextView;
    }

    public static AppCompatTextView createCountDown(Context context, int i, int i2, int i3, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setText(String.format(Locale.US, "跳过 %d", Integer.valueOf(i)));
        appCompatTextView.setTextColor(-1);
        float f2 = 12.0f * f;
        appCompatTextView.setTextSize(2, f2);
        appCompatTextView.setGravity(17);
        q qVarA = q.a();
        int iApplyDimension = (int) TypedValue.applyDimension(1, f2, qVarA.r());
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 4.0f * f, qVarA.r());
        appCompatTextView.setPadding(iApplyDimension, iApplyDimension2, iApplyDimension, iApplyDimension2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (i2 + 15) * f, qVarA.r()), (int) TypedValue.applyDimension(1, (i3 + 15) * f, qVarA.r()), 0);
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        try {
            appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ss_count_down_background));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
        return appCompatTextView;
    }

    public static AppCompatTextView createFeedBackButton(Context context, String str, int i, int i2, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setTextColor(-1);
        float f2 = 12.0f * f;
        appCompatTextView.setTextSize(2, f2);
        appCompatTextView.setText(R.string.octopus_feedback);
        appCompatTextView.setGravity(17);
        q qVarA = q.a();
        int iApplyDimension = (int) TypedValue.applyDimension(1, f2, qVarA.r());
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 4.0f * f, qVarA.r());
        appCompatTextView.setPadding(iApplyDimension, iApplyDimension2, iApplyDimension, iApplyDimension2);
        int iApplyDimension3 = (int) TypedValue.applyDimension(1, (i + 15) * f, qVarA.r());
        int iApplyDimension4 = (int) TypedValue.applyDimension(1, (i2 + 15) * f, qVarA.r());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388659);
        layoutParams.setMargins(iApplyDimension3, iApplyDimension4, 0, 0);
        appCompatTextView.setLayoutParams(layoutParams);
        try {
            appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ss_count_down_background));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
        return appCompatTextView;
    }

    public static ImageView createImageCloseButton(Context context, int i, float f) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ss_close);
        imageView.setBackgroundResource(R.drawable.ss_close_background);
        q qVarA = q.a();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 5.0f * f, qVarA.r());
        imageView.setPadding(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 24.0f * f, qVarA.r());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iApplyDimension2, iApplyDimension2, 8388661);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (i + 15) * f, qVarA.r()), (int) TypedValue.applyDimension(1, f * 15.0f, qVarA.r()), 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public static AppCompatTextView createInterstitialCountDown(Context context, int i, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.ss_text_selector));
        appCompatTextView.setTextSize(2, 13.0f * f);
        q qVarA = q.a();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 24.0f * f, qVarA.r());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iApplyDimension, iApplyDimension, 8388661);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (i + 15) * f, qVarA.r()), (int) TypedValue.applyDimension(1, f * 15.0f, qVarA.r()), 0);
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        try {
            appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ss_count_down_interstitial_background));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
        return appCompatTextView;
    }

    public static ProgressBar createLoadingView(Context context, float f) {
        ProgressBar progressBar = new ProgressBar(context);
        if (progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(-3355444, PorterDuff.Mode.SRC_IN);
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, f * 40.0f, q.a().r());
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(iApplyDimension, iApplyDimension, 17));
        return progressBar;
    }

    public static FrameLayout createLogoImageView(Context context, AdLogoInfo adLogoInfo, int i, float f) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(4);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        float f2 = 10.0f * f;
        int i2 = (int) f2;
        if (adLogoInfo != null) {
            q qVarA = q.a();
            if (adLogoInfo.getType() == AdLogoInfo.TYPE_PIC) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int iApplyDimension = (int) TypedValue.applyDimension(1, f * 14.0f, qVarA.r());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iApplyDimension, iApplyDimension, 8388693);
                layoutParams.setMargins(0, 0, i * i2, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
                if (TextUtils.isEmpty(adLogoInfo.getAdurl()) || !adLogoInfo.getAdurl().endsWith("octlogo.png")) {
                    ImageManager.with(context).load(adLogoInfo.getAdurl()).into(imageView);
                } else {
                    imageView.setImageResource(R.drawable.ss_logo);
                }
                frameLayout.addView(imageView);
            } else if (adLogoInfo.getType() == AdLogoInfo.TYPE_TEXT) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                appCompatTextView.setTextSize(2, f2);
                appCompatTextView.setTextColor(-1);
                appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
                appCompatTextView.setText(adLogoInfo.getAdurl());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 8388693);
                layoutParams2.setMargins(0, 0, 0, 0);
                frameLayout.addView(appCompatTextView, layoutParams2);
            }
        }
        return frameLayout;
    }

    public static AppCompatImageView createMuteButton(Context context, boolean z, int i, float f) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageResource(z ? R.drawable.ss_voice_off : R.drawable.ss_voice_on);
        q qVarA = q.a();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 24.0f * f, qVarA.r());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iApplyDimension, iApplyDimension, 8388659);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 15.0f * f, qVarA.r()), (int) TypedValue.applyDimension(1, (i + 15) * f, qVarA.r()), 0, 0);
        appCompatImageView.setLayoutParams(layoutParams);
        return appCompatImageView;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float getScreenHeightDp(Context context) {
        return px2dip(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    private static int getSystemUiVisibility() {
        return 5894;
    }

    public static void hideSystemTitleBarUI(Activity activity) {
        try {
            int systemUiVisibility = getSystemUiVisibility();
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static void openLocalBrowser(WebView webView, int i) {
        try {
            Context contextL = q.a().l();
            if (contextL != null && webView != null) {
                Intent intent = new Intent(contextL, (Class<?>) BrowserAdActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("REPEAT_NUM", i);
                BrowserAdActivity.f38841a.add(webView);
                contextL.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            BrowserAdActivity.f38841a.remove();
        } catch (Exception e) {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Exception initializing the redirect webview: " + e.getMessage());
        }
    }

    public static void openLocalBrowser(String str, int i) {
        ThreadUtils.runOnUIThread(new Runnable(str, i) { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.6
            final int val$repeatNum;
            final String val$url;

            {
                this.val$url = str;
                this.val$repeatNum = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Context contextL = q.a().l();
                    if (contextL != null && !TextUtils.isEmpty(this.val$url)) {
                        WebView webView = new WebView(new MutableContextWrapper(contextL));
                        t.a(webView);
                        webView.loadUrl(this.val$url);
                        Intent intent = new Intent(contextL, (Class<?>) BrowserAdActivity.class);
                        intent.setFlags(268435456);
                        intent.putExtra("REPEAT_NUM", this.val$repeatNum);
                        BrowserAdActivity.f38841a.add(webView);
                        contextL.startActivity(intent);
                    }
                } catch (ActivityNotFoundException unused) {
                    BrowserAdActivity.f38841a.remove();
                } catch (Exception e) {
                    com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Exception initializing the redirect webview: " + e.getMessage());
                }
            }
        });
    }

    public static void openSystemBrowser(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void removeChildFromParent(View view) {
        ThreadUtils.runOnUIThread(new Runnable(view) { // from class: com.kc.cw.ad.internal.utilities.ViewUtil.7
            final View val$view;

            {
                this.val$view = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    View view2 = this.val$view;
                    if (view2 == null || view2.getParent() == null) {
                        return;
                    }
                    ((ViewGroup) this.val$view.getParent()).removeView(this.val$view);
                } catch (Exception unused) {
                }
            }
        });
    }
}
