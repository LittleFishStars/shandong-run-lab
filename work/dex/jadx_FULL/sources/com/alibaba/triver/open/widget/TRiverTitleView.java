package com.alibaba.triver.open.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.alibctriver.R;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.model.NavigatorBarAnimType;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.kit.api.widget.ITitleView;
import com.alibaba.triver.kit.api.widget.action.IAppLogoAction;
import com.alibaba.triver.kit.api.widget.action.IAppNameAction;
import com.alibaba.triver.kit.api.widget.action.IBackableAction;
import com.alibaba.triver.kit.api.widget.action.IBackgroundAction;
import com.alibaba.triver.kit.api.widget.action.ICloseableAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRiverTitleView extends LinearLayout implements ITitleView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f25085a;
    private ViewGroup b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private ViewGroup f;
    private List<Action> g;
    private Drawable h;
    private int i;
    private Context j;

    public TRiverTitleView(Context context) {
        super(context);
        this.g = new ArrayList();
        this.j = context;
        d();
    }

    private void d() {
        setId(R.id.triver_title_bar_view);
        setOrientation(1);
        setBackgroundResource(android.R.color.white);
        View.inflate(getContext(), R.layout.triver_navigationbar, this);
        this.b = (ViewGroup) findViewById(R.id.titlebar);
        View.inflate(getContext(), R.layout.triver_navigatorbar_bottom, this);
        this.f = (ViewGroup) findViewById(R.id.titleBarBottom);
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = ((IPageLoadProxy) RVProxy.get(IPageLoadProxy.class)).getDefaultTitleBarHeight(getContext(), null);
        this.b.setLayoutParams(layoutParams);
        int statusBarHeight = CommonUtils.getStatusBarHeight(getContext()) + 0;
        if ("1".equals(CommonUtils.get("ro.miui.notch"))) {
            statusBarHeight -= CommonUtils.dip2px(getContext(), 3.0f);
        }
        ViewGroup viewGroup = this.b;
        viewGroup.setPadding(viewGroup.getPaddingLeft(), statusBarHeight, 0, 0);
        this.d = (LinearLayout) findViewById(R.id.right_panel);
        this.c = (LinearLayout) findViewById(R.id.left_panel);
        this.e = (LinearLayout) findViewById(R.id.center_panel);
    }

    public void a() {
        for (Action action : this.g) {
            action.onShow();
            if (!TextUtils.isEmpty(this.f25085a)) {
                action.setStyle(this.f25085a);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void addBottomAction(Action action) {
        if (action != null) {
            action.location = 3;
            this.f.addView(action.getView(getContext()));
            this.g.add(action);
            if (TextUtils.isEmpty(this.f25085a)) {
                return;
            }
            action.setStyle(this.f25085a);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void addCenterAction(Action action, int i) {
        this.e.addView(action.getView(getContext()));
        if (!TextUtils.isEmpty(this.f25085a)) {
            action.setStyle(this.f25085a);
        }
        action.location = 2;
        this.g.add(action);
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void addLeftAction(Action action) {
        if (action != null) {
            action.location = 0;
            this.g.add(action);
            this.c.addView(action.getView(getContext()));
            if (TextUtils.isEmpty(this.f25085a)) {
                return;
            }
            action.setStyle(this.f25085a);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void addRightAction(Action action) {
        if (action != null) {
            this.g.add(action);
            action.location = 1;
            this.d.addView(action.getView(getContext()), 0);
            if (TextUtils.isEmpty(this.f25085a)) {
                return;
            }
            action.setStyle(this.f25085a);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void attachPage(Page page) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = ((IPageLoadProxy) RVProxy.get(IPageLoadProxy.class)).getDefaultTitleBarHeight(getContext(), page.getApp());
        this.b.setLayoutParams(layoutParams);
    }

    public void b() {
        Iterator<Action> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void c() {
        Iterator<Action> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onHide();
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void clearBottomAction() {
        this.f.removeAllViews();
        for (int size = this.g.size() - 1; size >= 0; size--) {
            if (this.g.get(size).location == 3) {
                this.g.remove(size);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void clearCenterActions() {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            if (this.g.get(size).location == 2) {
                this.g.remove(size);
            }
        }
        this.e.removeAllViews();
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void clearLeftActions() {
        this.c.removeAllViews();
        for (int size = this.g.size() - 1; size >= 0; size--) {
            if (this.g.get(size).location == 0) {
                this.g.remove(size);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void clearRightActions() {
        this.d.removeAllViews();
        for (int size = this.g.size() - 1; size >= 0; size--) {
            if (this.g.get(size).location == 1) {
                this.g.remove(size);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public <T> T getAction(Class<T> cls) {
        Iterator<Action> it = this.g.iterator();
        while (it.hasNext()) {
            T t = (T) ((Action) it.next());
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public List<Action> getActions() {
        return this.g;
    }

    public int getBarHeight() {
        return this.b.getLayoutParams().height;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public Drawable getContentBgDrawable() {
        return this.h;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public View getContentView() {
        return this;
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void hideTitleBar(NavigatorBarAnimType navigatorBarAnimType) {
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void removeAction(Action action) {
        if (action == null) {
            return;
        }
        this.g.remove(action);
        View view = action.getView(getContext());
        this.e.removeView(view);
        this.c.removeView(view);
        this.d.removeView(view);
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void setLogo(String str) {
        for (Object obj : this.g) {
            if (obj instanceof IAppLogoAction) {
                ((IAppLogoAction) obj).setLogo(str);
            }
        }
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        for (Object obj : this.g) {
            if (obj instanceof IBackableAction) {
                ((IBackableAction) obj).setOnBackClickListener(onClickListener);
            }
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        for (Object obj : this.g) {
            if (obj instanceof ICloseableAction) {
                ((ICloseableAction) obj).setOnCloseClickListener(onClickListener);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void setStyle(String str) {
        this.f25085a = str;
        Iterator<Action> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().setStyle(str);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void setTitle(String str) {
        for (Object obj : this.g) {
            if (obj instanceof IAppNameAction) {
                ((IAppNameAction) obj).setName(str);
            }
        }
    }

    public void setTitleBarAlpha(int i) {
        this.i = i;
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void setTitleBarBgColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        colorDrawable.setAlpha(this.i);
        this.h = colorDrawable;
        this.b.setBackground(colorDrawable);
        for (Object obj : this.g) {
            if (obj instanceof IBackgroundAction) {
                ((IBackgroundAction) obj).setTitleBarBgDrawable(this.h);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void setTitleBarBgDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setAlpha(this.i);
        }
        this.h = drawable;
        this.b.setBackground(drawable);
        for (Object obj : this.g) {
            if (obj instanceof IBackgroundAction) {
                ((IBackgroundAction) obj).setTitleBarBgDrawable(drawable);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.ITitleView
    public void showTitleBar(NavigatorBarAnimType navigatorBarAnimType) {
    }

    public void setLogo(Drawable drawable) {
        for (Object obj : this.g) {
            if (obj instanceof IAppLogoAction) {
                ((IAppLogoAction) obj).setLogo(drawable);
            }
        }
    }

    public TRiverTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList();
        this.j = context;
        d();
    }

    public TRiverTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.j = context;
        d();
    }
}
