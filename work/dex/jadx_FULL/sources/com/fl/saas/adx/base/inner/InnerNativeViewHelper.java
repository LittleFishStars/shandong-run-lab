package com.fl.saas.adx.base.inner;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.adx.api.mixNative.NativeAdAppInfo;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.base.activity.h5.FLH5Activity;
import com.fl.saas.adx.base.inner.InnerNativeViewHelper;
import com.fl.saas.b1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InnerNativeViewHelper {
    @Nullable
    public static TextView createAppInfoView(final Context context, NativeMaterial nativeMaterial) {
        final NativeAdAppInfo adAppInfo;
        if (!nativeMaterial.isNativeAppAd() || (adAppInfo = nativeMaterial.getAdAppInfo()) == null) {
            return null;
        }
        int color = Color.parseColor("#000000");
        SpannableStringBuilder spannableStringBuilderBuild = new ClickSpannable().setSeparator(" | ").setGenericColor(color).setText("应用名称：", adAppInfo.getAppName()).setText("应用版本：", adAppInfo.getAppVersion()).setText("开发者：", adAppInfo.getPublisher()).nextCondition(new b1() { // from class: com.zj.adlib.ba4
            @Override // com.fl.saas.b1
            public final Object a() {
                return InnerNativeViewHelper.lambda$createAppInfoView$0(adAppInfo);
            }
        }).setTextClick("权限详情 >", new Runnable() { // from class: com.zj.adlib.da4
            @Override // java.lang.Runnable
            public final void run() {
                InnerNativeViewHelper.lambda$createAppInfoView$1(adAppInfo, context);
            }
        }).nextCondition(new b1() { // from class: com.zj.adlib.fa4
            @Override // com.fl.saas.b1
            public final Object a() {
                return InnerNativeViewHelper.lambda$createAppInfoView$2(adAppInfo);
            }
        }).setTextClick("隐私协议 >", new Runnable() { // from class: com.zj.adlib.ha4
            @Override // java.lang.Runnable
            public final void run() {
                InnerNativeViewHelper.lambda$createAppInfoView$3(adAppInfo, context);
            }
        }).nextCondition(new b1() { // from class: com.zj.adlib.ja4
            @Override // com.fl.saas.b1
            public final Object a() {
                return InnerNativeViewHelper.lambda$createAppInfoView$4(adAppInfo);
            }
        }).setTextClick("功能介绍 > ", new Runnable() { // from class: com.zj.adlib.la4
            @Override // java.lang.Runnable
            public final void run() {
                InnerNativeViewHelper.lambda$createAppInfoView$5(adAppInfo, context);
            }
        }).build();
        if (spannableStringBuilderBuild.length() == 0) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(spannableStringBuilderBuild);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextSize(2, 10.0f);
        textView.setTextColor(color);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createAppInfoView$0(NativeAdAppInfo nativeAdAppInfo) {
        return Boolean.valueOf((TextUtils.isEmpty(nativeAdAppInfo.getAppPermissionUrl()) && nativeAdAppInfo.getPermissonClick() == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAppInfoView$1(NativeAdAppInfo nativeAdAppInfo, Context context) {
        if (nativeAdAppInfo.getPermissonClick() != null) {
            nativeAdAppInfo.getPermissonClick().onClick();
        } else {
            FLH5Activity.launch(context, nativeAdAppInfo.getAppPermissionUrl(), "权限详情");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createAppInfoView$2(NativeAdAppInfo nativeAdAppInfo) {
        return Boolean.valueOf((TextUtils.isEmpty(nativeAdAppInfo.getAppPrivacyUrl()) && nativeAdAppInfo.getAppPrivacyUrl() == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAppInfoView$3(NativeAdAppInfo nativeAdAppInfo, Context context) {
        if (nativeAdAppInfo.getPrivacyClick() != null) {
            nativeAdAppInfo.getPrivacyClick().onClick();
        } else {
            FLH5Activity.launch(context, nativeAdAppInfo.getAppPrivacyUrl(), "隐私协议");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createAppInfoView$4(NativeAdAppInfo nativeAdAppInfo) {
        return Boolean.valueOf((TextUtils.isEmpty(nativeAdAppInfo.getFunctionUrl()) && nativeAdAppInfo.getFunctionClick() == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAppInfoView$5(NativeAdAppInfo nativeAdAppInfo, Context context) {
        if (nativeAdAppInfo.getFunctionClick() != null) {
            nativeAdAppInfo.getFunctionClick().onClick();
        } else {
            FLH5Activity.launch(context, nativeAdAppInfo.getFunctionUrl(), "功能介绍");
        }
    }
}
