package com.alibaba.triver.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.alibaba.alibctriver.R;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.model.NavigatorBarAnimType;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.StatusBarUtils;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import com.alibaba.triver.kit.api.widget.ITransparentTitleView;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h implements ITitleBar, ITransparentTitleView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f25099a;
    protected TRiverTitleView b;
    protected Page c;
    protected boolean d;
    protected FrameLayout e;

    public h(Context context) {
        this.f25099a = context;
        this.b = new TRiverTitleView(this.f25099a);
        a();
        b();
    }

    private void b() {
        if (this.b.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        FrameLayout frameLayout = new FrameLayout(this.f25099a);
        this.e = frameLayout;
        frameLayout.setId(R.id.triver_title_bar_view_container);
        this.e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.e.addView(this.b);
    }

    private void c() {
        this.b.setOnBackClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((InputMethodManager) h.this.f25099a.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                } catch (Throwable unused) {
                }
                h.this.c.getApp().backPressed();
            }
        });
        if (this.c.getApp() != null) {
            this.b.setTitle(this.c.getApp().getAppName());
            this.b.setLogo(this.c.getApp().getAppLogo());
        }
        Page page = this.c;
        if (page == null || page.getWindowInfo() == null) {
            StatusBarUtils.changeStyle((Activity) this.b.getContext(), true);
            this.b.setStyle(null);
        } else {
            String str = this.c.getWindowInfo().navigationBarTextStyle;
            if (TextUtils.isEmpty(str)) {
                str = "dark";
            }
            StatusBarUtils.changeStyle((Activity) this.b.getContext(), "dark".equals(str));
            this.b.setStyle(str);
        }
        if (this.c.getWindowInfo() != null && this.c.getWindowInfo().defaultTitle != null) {
            this.b.setTitle(this.c.getWindowInfo().defaultTitle);
        }
        this.b.setTag(this.c.getWindowInfo() != null ? this.c.getWindowInfo().navigationBarTag : null);
        d();
        setTranslucent(this.c.getWindowInfo() != null && this.c.getWindowInfo().translucent);
    }

    private void d() {
        String str;
        String str2;
        if (this.c.getWindowInfo() != null) {
            str = this.c.getWindowInfo().titleBarColor;
            str2 = this.c.getWindowInfo().navigationBarBackgroundBg;
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            setTitleBarBgColor(str);
        } else {
            setTitleBarBgDrawable(str2);
        }
    }

    public void a() {
        this.b.addLeftAction(new b());
        this.b.addCenterAction(new c(), 0);
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
    public boolean addRightButton(String str, final View.OnClickListener onClickListener) {
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        };
        a aVar = (a) this.b.getAction(a.class);
        if (aVar != null) {
            aVar.a(str, onClickListener2);
            return true;
        }
        a aVar2 = new a();
        this.b.addRightAction(aVar2);
        aVar2.a(str, onClickListener2);
        return true;
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
        Iterator<Action> it = this.b.getActions().iterator();
        while (it.hasNext()) {
            it.next().attatchPage(page);
        }
        c();
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
        return this.b.getBarHeight();
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public View getContentView() {
        return this.e;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public View getDivider() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public long getTitleColor() {
        if (this.b.getContentBgDrawable() instanceof ColorDrawable) {
            return ((ColorDrawable) this.b.getContentBgDrawable()).getColor();
        }
        return 0L;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITransparentTitleView
    public String getTransparentTitle() {
        String string = BundleUtils.getString(this.c.getStartParams(), "transparentTitle");
        return (this.c.isHomePage() && TextUtils.equals(string, RVStartParams.TRANSPARENT_TITLE_ALWAYS)) ? "auto" : string;
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
        return this.d;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void onDestroy() {
        TRiverTitleView tRiverTitleView = this.b;
        if (tRiverTitleView != null) {
            tRiverTitleView.b();
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void onHide() {
        this.b.c();
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void onShow() {
        this.b.a();
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
        d();
        setTranslucent(this.c.getWindowInfo() == null ? false : this.c.getWindowInfo().translucent);
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void resetBackground() {
        d();
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
        if (!(this.b.getBackground() instanceof ColorDrawable) || ((ColorDrawable) this.b.getBackground()).getColor() != 0) {
            return true;
        }
        this.b.setTitleBarAlpha(i);
        return true;
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
        StatusBarUtils.changeStyle((Activity) this.b.getContext(), !"light".equals(str));
        this.b.setStyle(str);
        return true;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setTitle(String str, String str2, String str3, String str4) {
        if (this.c.isFirstTab()) {
            return false;
        }
        this.b.setTitle(str);
        return true;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void setTitleBarBgColor(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "#FFFFFF";
        }
        this.b.setTitleBarBgColor(CommonUtils.parseColor(str));
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void setTitleBarBgDrawable(Drawable drawable) {
        this.b.setTitleBarBgDrawable(drawable);
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public void setTitleBarBgDrawable(String str) {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setTranslucent(boolean z) {
        if (this.c.isHomePage()) {
            this.d = z;
            if (z) {
                this.b.setBackgroundColor(0);
                this.b.setTitleBarAlpha(0);
            } else {
                this.b.setBackgroundResource(android.R.color.white);
                this.b.setTitleBarAlpha(255);
            }
        } else if (this.c.getWindowInfo() == null || z) {
            this.b.setTitleBarAlpha(0);
            this.b.setBackgroundColor(0);
            this.d = true;
        } else {
            this.b.setBackgroundResource(android.R.color.white);
            this.b.setTitleBarAlpha(255);
            this.d = false;
        }
        if (this.d) {
            Page page = this.c;
            if (page == null || page.getWindowInfo() == null || !TextUtils.equals(this.c.getWindowInfo().navigationBarTextStyle, "light")) {
                Page page2 = this.c;
                if (page2 == null || page2.getWindowInfo() == null || !TextUtils.equals(this.c.getWindowInfo().navigationBarTextStyle, "dark")) {
                    this.e.setBackgroundResource(R.drawable.triver_miniapp_pri_titlebar_bg_light);
                    if (this.c.isHomePage() && this.c.getWindowInfo() != null && TextUtils.isEmpty(this.c.getWindowInfo().titleBarColor) && TextUtils.isEmpty(this.c.getWindowInfo().navigationBarTitleBg)) {
                        setTitleBarBgColor("#FFFFFF");
                    }
                } else {
                    this.e.setBackgroundResource(R.drawable.triver_miniapp_pri_titlebar_bg_light);
                    if (this.c.isHomePage() && TextUtils.isEmpty(this.c.getWindowInfo().titleBarColor) && TextUtils.isEmpty(this.c.getWindowInfo().navigationBarTitleBg)) {
                        setTitleBarBgColor("#FFFFFF");
                    }
                }
            } else {
                this.e.setBackgroundResource(R.drawable.triver_miniapp_pri_titlebar_bg_dark);
                if (this.c.isHomePage() && TextUtils.isEmpty(this.c.getWindowInfo().titleBarColor) && TextUtils.isEmpty(this.c.getWindowInfo().navigationBarTitleBg)) {
                    setTitleBarBgColor("#000000");
                }
            }
        }
        return true;
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

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean setTitle(String str, String str2, Drawable drawable, String str3) {
        if (str == null || this.c.isFirstTab()) {
            return false;
        }
        this.b.setTitle(str);
        return true;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleBar
    public boolean addRightButton(Drawable drawable, final View.OnClickListener onClickListener) {
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        };
        a aVar = (a) this.b.getAction(a.class);
        if (aVar == null) {
            a aVar2 = new a();
            this.b.addRightAction(aVar2);
            aVar2.a(drawable, onClickListener2);
            return true;
        }
        aVar.a(drawable, onClickListener2);
        return true;
    }
}
