package com.alibaba.triver.content;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ViewUtils;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarBadgeModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.ui.BaseTabBar;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.R;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.point.PushPagePoint;
import com.alibaba.triver.kit.api.proxy.IDarkModeProxy;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.ResourceUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends BaseTabBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TriverTabLayout f24809a;
    private TriverTabLayout.c b;
    private Context c;
    private AppContext d;
    private TriverTabLayout.f e;
    private App f;

    public d(Context context, App app, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        super(app, iFragmentManager);
        this.c = context;
        this.d = app.getAppContext();
        TriverTabLayout triverTabLayout = new TriverTabLayout(context);
        this.f24809a = triverTabLayout;
        triverTabLayout.setSelectedTabIndicatorHeight(0);
        this.f = app;
        viewGroup.addView(this.f24809a, new ViewGroup.LayoutParams(-1, ViewUtils.specToLayoutParam(this.d.getViewSpecProvider().getTabBarHeightSpec())));
        this.b = new TriverTabLayout.c() { // from class: com.alibaba.triver.content.d.1
            @Override // com.alibaba.triver.content.TriverTabLayout.c
            public void a(TriverTabLayout.f fVar) {
                d.this.switchTab(fVar.d(), 2);
            }

            @Override // com.alibaba.triver.content.TriverTabLayout.c
            public void b(TriverTabLayout.f fVar) {
            }

            @Override // com.alibaba.triver.content.TriverTabLayout.c
            public void c(TriverTabLayout.f fVar) {
                d.this.switchTab(fVar.d(), 2);
            }
        };
        if (RVProxy.get(IDarkModeProxy.class) == null || !((IDarkModeProxy) RVProxy.get(IDarkModeProxy.class)).isDarkModeEnable(context)) {
            return;
        }
        ((IDarkModeProxy) RVProxy.get(IDarkModeProxy.class)).disableForceDark(viewGroup);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void addTabItem(int i, TabBarItemModel tabBarItemModel, boolean z) {
        super.addTabItem(i, tabBarItemModel, z);
        TriverTabLayout.f fVarA = this.f24809a.b().a(tabBarItemModel);
        fVarA.a(View.inflate(this.c, R.layout.triver_view_tabbar, null));
        this.f24809a.a(fVarA, i, z);
        a(fVarA, tabBarItemModel, z);
    }

    public void b(int i) {
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        if (fVarA != null) {
            a((TextView) fVarA.b().findViewById(R.id.triver_message_view), false);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void changeTabBarStyle(TabBarModel tabBarModel, @Nullable Integer num) {
        super.changeTabBarStyle(tabBarModel, num);
        a(tabBarModel.getTextColor() != null ? tabBarModel.getTextColor().intValue() : 0, tabBarModel.getSelectedColor() != null ? tabBarModel.getSelectedColor().intValue() : 0, tabBarModel.getBackgroundColor());
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void create(Page page) {
        this.f24809a.b(this.b);
        super.create(page);
        this.f24809a.a(this.b);
        long backgroundColor = getTabbarModel().getBackgroundColor();
        if (backgroundColor <= 16777215) {
            backgroundColor |= -16777216;
        }
        int i = (int) backgroundColor;
        if (Color.alpha(i) != 255) {
            ((com.alibaba.triver.app.d) this.d).a(true);
        } else {
            ((com.alibaba.triver.app.d) this.d).a(false);
        }
        this.f24809a.setBackgroundColor(i);
        TriverTabLayout.f fVarA = this.f24809a.a(getCurrentIndex());
        this.e = fVarA;
        a(fVarA, (TabBarItemModel) fVarA.a(), true);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void hide(@Nullable Animation animation) {
        super.hide(animation);
        if (this.f24809a.getVisibility() == 8) {
            return;
        }
        if (animation == null) {
            this.f24809a.setVisibility(8);
            return;
        }
        this.f24809a.clearAnimation();
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.triver.content.d.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                d.this.f24809a.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        this.f24809a.startAnimation(animation);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void init(TabBarModel tabBarModel) {
        super.init(tabBarModel);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public void onSwitchTab(int i, int i2) {
        super.onSwitchTab(i, i2);
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        TabBarItemModel tabBarItemModel = (TabBarItemModel) fVarA.a();
        if (tabBarItemModel == null) {
            return;
        }
        if (fVarA != this.e) {
            a(fVarA, tabBarItemModel, true);
            TriverTabLayout.f fVar = this.e;
            if (fVar != null) {
                a(fVar, (TabBarItemModel) fVar.a(), false);
            }
        }
        this.e = fVarA;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabBarBadge(int i) {
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        if (fVarA != null) {
            a((TextView) fVarA.b().findViewById(R.id.triver_message_view), 0);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabItem(int i) {
        super.removeTabItem(i);
        this.f24809a.b(i);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void reset() {
        super.reset();
        this.f24809a.c();
        this.e = null;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabBarBadge(int i, TabBarBadgeModel tabBarBadgeModel) {
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        if (fVarA != null) {
            String badgeText = tabBarBadgeModel.getBadgeText();
            if (TextUtils.isEmpty(badgeText)) {
                a(i);
                return;
            }
            try {
                int i2 = Integer.parseInt(badgeText);
                if (i2 == 0) {
                    b(i);
                } else {
                    a((TextView) fVarA.b().findViewById(R.id.triver_message_view), i2);
                }
            } catch (Exception e) {
                RVLogger.e("TriverTabBar", "setTabBarBadge error", e);
            }
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabItem(int i, TabBarItemModel tabBarItemModel) {
        super.setTabItem(i, tabBarItemModel);
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        if (fVarA != null) {
            a(fVarA, tabBarItemModel, fVarA == this.e);
            fVarA.a(tabBarItemModel);
            TabBarItemModel tabBarItemModel2 = getTabbarModel().getItems().get(i);
            if (!TextUtils.isEmpty(tabBarItemModel.getName())) {
                tabBarItemModel2.setName(tabBarItemModel.getName());
            }
            if (!TextUtils.isEmpty(tabBarItemModel.getIcon())) {
                tabBarItemModel2.setIcon(tabBarItemModel.getIcon());
            }
            if (!TextUtils.isEmpty(tabBarItemModel.getActiveIcon())) {
                tabBarItemModel2.setActiveIcon(tabBarItemModel.getActiveIcon());
            }
            if (!TextUtils.isEmpty(tabBarItemModel.getUrl())) {
                tabBarItemModel2.setUrl(tabBarItemModel.getUrl());
            }
            if (!TextUtils.isEmpty(tabBarItemModel.getTag())) {
                tabBarItemModel2.setTag(tabBarItemModel.getTag());
            }
            if (TextUtils.isEmpty(tabBarItemModel.getLaunchParamsTag())) {
                return;
            }
            tabBarItemModel2.setLaunchParamsTag(tabBarItemModel.getLaunchParamsTag());
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void show(Page page, @Nullable Animation animation) {
        super.show(page, animation);
        if (this.f24809a.getVisibility() == 0) {
            return;
        }
        if (animation == null) {
            this.f24809a.setVisibility(0);
            return;
        }
        this.f24809a.setVisibility(0);
        this.f24809a.clearAnimation();
        this.f24809a.startAnimation(animation);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean switchTab(int i, int i2) {
        TabBarItemModel tabBarItemModel;
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        if (fVarA == null || (tabBarItemModel = (TabBarItemModel) fVarA.a()) == null || !((PushPagePoint) ExtensionPoint.as(PushPagePoint.class).create()).switchTab(new com.alibaba.triver.app.e(this.f), a(this.f, tabBarItemModel.getUrl()))) {
            return super.switchTab(i, i2);
        }
        return false;
    }

    private void a(TriverTabLayout.f fVar, TabBarItemModel tabBarItemModel, boolean z) {
        String icon;
        View viewB = fVar.b();
        if (viewB == null) {
            return;
        }
        TextView textView = (TextView) viewB.findViewById(R.id.triver_tab_name);
        ImageView imageView = (ImageView) viewB.findViewById(R.id.triver_tab_image);
        textView.setText(tabBarItemModel.getName());
        if (z) {
            textView.setTextColor((getTabbarModel().getSelectedColor() != null ? getTabbarModel().getSelectedColor().intValue() : 0) | (-16777216));
            icon = tabBarItemModel.getActiveIcon();
        } else {
            textView.setTextColor((getTabbarModel().getTextColor() != null ? getTabbarModel().getTextColor().intValue() : 0) | (-16777216));
            icon = tabBarItemModel.getIcon();
        }
        if (TextUtils.isEmpty(icon)) {
            return;
        }
        String string = BundleUtils.getString(this.f.getStartParams(), "onlineHost");
        if (ResourceUtils.a(icon, string) != ResourceUtils.ResourceType.INTERNAL) {
            ((IImageProxy) RVProxy.get(IImageProxy.class)).setImageUrl(imageView, icon, null);
            return;
        }
        if (!icon.startsWith(string)) {
            icon = FileUtils.combinePath(string, icon);
        }
        Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(icon).build());
        if (resourceLoad == null) {
            return;
        }
        byte[] bytes = resourceLoad.getBytes();
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
    }

    private String a(App app, String str) {
        if (app.getStartParams() != null) {
            String string = app.getStartParams().getString(TRiverConstants.KEY_ORI_URL);
            if (!TextUtils.isEmpty(string)) {
                return Uri.parse(string).buildUpon().appendQueryParameter("page", Uri.parse(str).getFragment()).build().toString();
            }
        }
        return str;
    }

    public void a(int i) {
        TriverTabLayout.f fVarA = this.f24809a.a(i);
        if (fVarA != null) {
            a((TextView) fVarA.b().findViewById(R.id.triver_message_view), true);
        }
    }

    private void a(int i, int i2, long j) {
        if (j <= 16777215) {
            j |= -16777216;
        }
        int i3 = (int) j;
        if (Color.alpha(i3) != 255) {
            ((com.alibaba.triver.app.d) this.d).a(true);
        } else {
            ((com.alibaba.triver.app.d) this.d).a(false);
        }
        this.f24809a.setBackgroundColor(i3);
        int tabCount = this.f24809a.getTabCount();
        for (int i4 = 0; i4 < tabCount; i4++) {
            TriverTabLayout.f fVarA = this.f24809a.a(i4);
            if (fVarA != null) {
                if (fVarA == this.e) {
                    ((TextView) fVarA.b().findViewById(R.id.triver_tab_name)).setTextColor(i2 | (-16777216));
                } else {
                    ((TextView) fVarA.b().findViewById(R.id.triver_tab_name)).setTextColor(i | (-16777216));
                }
            }
        }
    }

    private void a(TextView textView, int i) {
        if (i <= 0) {
            textView.setText("");
            textView.setBackgroundResource(0);
            textView.setVisibility(8);
            return;
        }
        if (i <= 99) {
            textView.setText(i + "");
            textView.setBackgroundResource(R.drawable.triver_tabbar_message_more_bg);
            textView.setVisibility(0);
            int iDp2px = CommonUtils.dp2px(16);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.height = iDp2px;
            marginLayoutParams.width = -2;
            textView.setLayoutParams(marginLayoutParams);
            return;
        }
        textView.setText("99+");
        textView.setBackgroundResource(R.drawable.triver_tabbar_message_more_bg);
        textView.setVisibility(0);
        int iDp2px2 = CommonUtils.dp2px(16);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams2.height = iDp2px2;
        marginLayoutParams2.width = -2;
        textView.setLayoutParams(marginLayoutParams2);
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setText("");
            textView.setBackgroundResource(R.drawable.triver_tabbar_message_dot_bg);
            textView.setVisibility(0);
            int iDp2px = CommonUtils.dp2px(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.height = iDp2px;
            marginLayoutParams.width = iDp2px;
            textView.setLayoutParams(marginLayoutParams);
            return;
        }
        textView.setText("");
        textView.setBackgroundResource(0);
        textView.setVisibility(8);
    }
}
