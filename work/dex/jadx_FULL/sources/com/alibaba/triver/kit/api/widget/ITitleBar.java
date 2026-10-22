package com.alibaba.triver.kit.api.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.model.NavigatorBarAnimType;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITitleBar {
    boolean addLeftButton(Drawable drawable, View.OnClickListener onClickListener);

    boolean addLeftButton(String str, View.OnClickListener onClickListener);

    boolean addLeftText(String str, View.OnClickListener onClickListener);

    boolean addRightButton(Drawable drawable, View.OnClickListener onClickListener);

    boolean addRightButton(String str, View.OnClickListener onClickListener);

    boolean addRightText(String str, View.OnClickListener onClickListener);

    boolean addRightText(String str, Map<String, Object> map);

    void attachPage(Page page);

    void clearBottomButtons();

    void clearCenterButtons();

    void clearLeftButtons();

    void clearRightButtons();

    void enableFavor();

    <T> T getAction(Class<T> cls);

    int getBarHeight();

    View getContentView();

    View getDivider();

    long getTitleColor();

    boolean hideBackButton();

    boolean hideBackHome();

    boolean hideShareMenu();

    boolean hideTitleBar(NavigatorBarAnimType navigatorBarAnimType);

    boolean isTranslucent();

    void onDestroy();

    void onHide();

    void onShow();

    void removeAction(Action action);

    void reset();

    void resetBackground();

    void resetTitle(Page page);

    boolean setAlpha(int i);

    boolean setBackButton(String str);

    boolean setBorderBottomColor(String str);

    boolean setLogo(Drawable drawable);

    boolean setLogo(String str);

    boolean setStyle(String str);

    boolean setTitle(String str, String str2, Drawable drawable, String str3);

    boolean setTitle(String str, String str2, String str3, String str4);

    void setTitleBarBgColor(String str);

    void setTitleBarBgDrawable(Drawable drawable);

    void setTitleBarBgDrawable(String str);

    boolean setTranslucent(boolean z);

    boolean showBackButton();

    boolean showBackToHomepage();

    boolean showTitleBar(NavigatorBarAnimType navigatorBarAnimType);
}
