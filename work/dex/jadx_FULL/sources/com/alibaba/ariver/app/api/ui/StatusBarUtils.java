package com.alibaba.ariver.app.api.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Window;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.gyf.immersionbar.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StatusBarUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23824a = "StatusBarUtils";
    private static int b;

    public static int getStatusBarHeight(Context context) {
        if (b < 3) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(b.f6802a, "dimen", "android"));
            b = dimensionPixelSize;
            if (dimensionPixelSize < 3 && (context instanceof Activity)) {
                try {
                    Rect rect = new Rect();
                    ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    b = rect.top;
                    RVLogger.d(f23824a, " status bar height rect height = " + b);
                } catch (Throwable unused) {
                }
            }
        }
        return b;
    }

    public static boolean isConfigSupport() {
        return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_supportStatusBar", true);
    }

    public static boolean isSupport() {
        return true;
    }

    @TargetApi(21)
    public static void setTransparentColor(Activity activity, int i) {
        if (!isSupport() || activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1280);
        window.setStatusBarColor(i);
    }
}
