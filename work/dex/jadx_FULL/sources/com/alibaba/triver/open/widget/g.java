package com.alibaba.triver.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.model.NavigatorBarAnimType;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements ITitleBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f25097a;
    protected TRiverTitleView b;
    private Page c;

    public g(Context context) {
        this.f25097a = context;
        this.b = new TRiverTitleView(this.f25097a);
        a();
    }

    public void a() {
        this.b.addRightAction(new d());
        this.b.addBottomAction(new f());
        this.b.setOnCloseClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((Activity) view.getContext()).finish();
            }
        });
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addLeftButton(Drawable drawable, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addLeftButton(String str, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addLeftText(String str, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addRightButton(Drawable drawable, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addRightButton(String str, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addRightText(String str, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addRightText(String str, Map<String, Object> map) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void attachPage(Page page) {
        this.c = page;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void clearBottomButtons() {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            tRiverTitleView.clearBottomAction();
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void clearCenterButtons() {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            tRiverTitleView.clearCenterActions();
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void clearLeftButtons() {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            tRiverTitleView.clearLeftActions();
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void clearRightButtons() {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            tRiverTitleView.clearRightActions();
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void enableFavor() {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public <T> T getAction(Class<T> cls) {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            return (T) tRiverTitleView.getAction(cls);
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public int getBarHeight() {
        return 0;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public View getContentView() {
        return this.b;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public View getDivider() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public long getTitleColor() {
        return 0L;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean hideBackButton() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean hideBackHome() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean hideShareMenu() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean hideTitleBar(NavigatorBarAnimType navigatorBarAnimType) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean isTranslucent() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void onDestroy() {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void onHide() {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void onShow() {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void removeAction(Action action) {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            tRiverTitleView.removeAction(action);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void reset() {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void resetBackground() {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void resetTitle(Page page) {
        clearBottomButtons();
        clearCenterButtons();
        clearLeftButtons();
        clearRightButtons();
        a();
        attachPage(page);
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setAlpha(int i) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setBackButton(String str) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setBorderBottomColor(String str) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setLogo(String str) {
        this.b.setLogo(str);
        return true;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setStyle(String str) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setTitle(String str, String str2, Drawable drawable, String str3) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setTitle(String str, String str2, String str3, String str4) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void setTitleBarBgColor(String str) {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void setTitleBarBgDrawable(Drawable drawable) {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void setTitleBarBgDrawable(String str) {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setTranslucent(boolean z) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean showBackButton() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean showBackToHomepage() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean showTitleBar(NavigatorBarAnimType navigatorBarAnimType) {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setLogo(Drawable drawable) {
        this.b.setLogo(drawable);
        return true;
    }
}
