package com.alibaba.triver.kit.api.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.model.NavigatorBarAnimType;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITitleView {
    public static final int CENTER = 2;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    void addBottomAction(Action action);

    void addCenterAction(Action action, int i);

    void addLeftAction(Action action);

    void addRightAction(Action action);

    void attachPage(Page page);

    void clearBottomAction();

    void clearCenterActions();

    void clearLeftActions();

    void clearRightActions();

    <T> T getAction(Class<T> cls);

    List<Action> getActions();

    Drawable getContentBgDrawable();

    View getContentView();

    Context getContext();

    void hideTitleBar(NavigatorBarAnimType navigatorBarAnimType);

    void removeAction(Action action);

    void setLogo(String str);

    void setStyle(String str);

    void setTitle(String str);

    void setTitleBarBgColor(int i);

    void setTitleBarBgDrawable(Drawable drawable);

    void showTitleBar(NavigatorBarAnimType navigatorBarAnimType);
}
