package com.alibaba.ariver.app.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultViewSpecProvider implements ViewSpecProvider {
    private static boolean ISGET = false;
    private static int SCREEN_WIDTH = 0;
    private static final int TAB_BAR_HEIGHT_DP = 52;
    private static final String TAG = "AriverApp:DefaultViewSpecProvider";
    private static final int TITLE_BAR_HEIGHT_DP = 48;
    private Activity mActivity;

    public DefaultViewSpecProvider(Activity activity) {
        this.mActivity = activity;
    }

    private static void initWidthAndHeight(Context context) {
        if (ISGET) {
            return;
        }
        int screenWidth = DimensionUtil.getScreenWidth(context);
        int screenHeight = DimensionUtil.getScreenHeight(context);
        if (screenWidth < screenHeight) {
            SCREEN_WIDTH = screenWidth;
        } else {
            SCREEN_WIDTH = screenHeight;
        }
        ISGET = true;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getHeightSpec() {
        RVLogger.debug(TAG, "fragmentOptEnabled not calculate for getHeightSpec");
        return View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getPageHeightSpec(boolean z) {
        return View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE);
    }

    public int getTabBarHeight() {
        return DimensionUtil.dip2px(getActivity(), 52.0f);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getTabBarHeightSpec() {
        initWidthAndHeight(this.mActivity);
        int tabBarHeight = getTabBarHeight();
        RVLogger.debug(TAG, "getTabBarHeightSpec: " + tabBarHeight);
        return View.MeasureSpec.makeMeasureSpec(tabBarHeight, 1073741824);
    }

    public int getTitleBarHeight() {
        int titleBarRawHeight = getTitleBarRawHeight();
        return StatusBarUtils.isSupport() ? titleBarRawHeight + StatusBarUtils.getStatusBarHeight(getActivity()) : titleBarRawHeight;
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getTitleBarHeightSpec() {
        initWidthAndHeight(this.mActivity);
        int titleBarHeight = getTitleBarHeight();
        RVLogger.debug(TAG, "fragmentOptEnabled getTitleBarHeightSpec: " + titleBarHeight);
        return View.MeasureSpec.makeMeasureSpec(titleBarHeight, 1073741824);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getTitleBarRawHeight() {
        return DimensionUtil.dip2px(getActivity(), 48.0f);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getWidthSpec() {
        initWidthAndHeight(this.mActivity);
        RVLogger.debug(TAG, "fragmentOptEnabled getWidthSpec: " + SCREEN_WIDTH);
        return View.MeasureSpec.makeMeasureSpec(SCREEN_WIDTH, 1073741824);
    }
}
