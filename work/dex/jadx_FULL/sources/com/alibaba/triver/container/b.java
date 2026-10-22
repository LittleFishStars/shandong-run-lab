package com.alibaba.triver.container;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.app.e;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.model.FrameType;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.triver_render.view.refresh.RefreshHeader;
import com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout;
import com.alibaba.triver.triver_render.view.refresh.d;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.view.TriverPageRootView;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements PageContainer {
    private static final String c = "TriverPageContainer";
    private Context d;
    private TriverPageRootView e;
    private boolean f;
    private boolean g;
    private TriverSwipeRefreshLayout h;
    private App i;
    private boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TriverSwipeRefreshLayout.c f24789a = new TriverSwipeRefreshLayout.c() { // from class: com.alibaba.triver.container.b.1
        @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.c
        public boolean a() {
            try {
                if (b.this.j) {
                    return false;
                }
                b.this.j = true;
                EngineUtils.sendToRender(b.this.i.getActivePage().getRender(), EngineUtils.getWorker(b.this.i.getEngineProxy()), RVEvents.PULL_INTERCEPT, null, null);
                return false;
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                return false;
            }
        }

        @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.c
        public void b() {
            b.this.j = false;
        }

        @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.c
        public void c() {
            try {
                EngineUtils.sendToRender(b.this.i.getActivePage().getRender(), EngineUtils.getWorker(b.this.i.getEngineProxy()), RVEvents.FIRE_PULL_TO_REFRESH, null, null);
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
        }
    };
    TriverSwipeRefreshLayout.c b = new TriverSwipeRefreshLayout.c() { // from class: com.alibaba.triver.container.b.2
        @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.c
        public boolean a() {
            try {
                if (b.this.j) {
                    return false;
                }
                b.this.j = true;
                EngineUtils.sendToRender(b.this.i.getActivePage().getRender(), EngineUtils.getWorker(b.this.i.getEngineProxy()), RVEvents.PULL_INTERCEPT, null, null);
                return false;
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                return false;
            }
        }

        @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.c
        public void b() {
            b.this.j = false;
        }

        @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.c
        public void c() {
        }
    };

    public b(Context context, App app) {
        this.d = context;
        this.e = new TriverPageRootView(this.d);
        this.i = app;
        this.h = new TriverSwipeRefreshLayout(this.d);
    }

    private void c(Page page) {
        this.g = true;
        this.f = false;
        if (page.getStartParams() != null && page.getStartParams().get(RVParams.LONG_PULL_REFRESH) != null) {
            try {
                this.f = "true".equals(String.valueOf(page.getStartParams().get(RVParams.LONG_PULL_REFRESH)));
            } catch (Exception e) {
                RVLogger.e(c, "setupRefreshLayout", e);
            }
        }
        if (page.getStartParams() != null && page.getStartParams().get(RVParams.LONG_CAN_PULL_DOWN) != null) {
            try {
                this.g = "true".equals(String.valueOf(page.getStartParams().get(RVParams.LONG_CAN_PULL_DOWN)));
            } catch (Exception e2) {
                RVLogger.e(c, "setupRefreshLayout", e2);
            }
        }
        if (this.f && this.g) {
            e(page);
        } else if (this.g) {
            d(page);
        } else {
            c();
        }
    }

    private void d(Page page) {
        this.h.a(true);
        int i = 0;
        this.h.b(false);
        this.h.c(false);
        this.h.setDistanceToRefresh(350);
        try {
            if (page.getStartParams() != null && page.getStartParams().get(RVParams.PULL_INTERCEPT_DISTANCE) != null) {
                i = page.getStartParams().getInt(RVParams.PULL_INTERCEPT_DISTANCE);
            }
            if (i > 0) {
                this.h.setPullRefreshDistance(i);
                this.h.setReachDistanceRefreshListener(this.b);
            }
        } catch (Exception e) {
            RVLogger.e(c, e);
        }
        this.h.setHeaderView(new d(this.d));
    }

    private void e(Page page) {
        this.h.a(true);
        int i = 0;
        this.h.b(false);
        this.h.c(false);
        e eVar = new e(this.i);
        if (!"AliApp".equals(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getAppGroup())) {
            this.h.setHeaderView(new com.alibaba.triver.triver_render.view.refresh.a(this.d));
        } else if (!FrameType.isTool(eVar.getAppFrameType()) || "14".equals(eVar.getAppSubType()) || TinyApp.SUB_TYPE_BRAND_ZONE.equals(eVar.getAppSubType())) {
            this.h.setHeaderView(new com.alibaba.triver.triver_render.view.refresh.e(this.d));
        } else {
            this.h.setHeaderView(new com.alibaba.triver.triver_render.view.refresh.b(this.d));
        }
        try {
            if (page.getStartParams() != null && page.getStartParams().get(RVParams.PULL_INTERCEPT_DISTANCE) != null) {
                i = page.getStartParams().getInt(RVParams.PULL_INTERCEPT_DISTANCE);
            }
            if (i > 0) {
                this.h.setPullRefreshDistance(i);
            }
        } catch (Exception e) {
            RVLogger.e(c, e);
        }
        this.h.setReachDistanceRefreshListener(this.f24789a);
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public void addRenderView(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (CommonUtils.isDowngradePullDownRefresh()) {
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.e.addView(view, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        this.h.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (this.h.getParent() != null && (this.h.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        this.e.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public void attachPage(Page page) {
        if (page != null && page.getApp() != null) {
            page.getStartParams().putString(RVParams.SESSION_ID, "session_" + page.getApp().getAppId() + LoginConstants.UNDER_LINE + page.getApp().hashCode());
            page.getStartParams().putBoolean(RVParams.isTinyApp, true);
        }
        if (!CommonUtils.isDowngradePullDownRefresh()) {
            c(page);
        }
        b(page);
        a(page);
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public ViewGroup getView() {
        return this.e;
    }

    private void b(Page page) {
        try {
            Integer numValueOf = (page.getStartParams() == null || !page.getStartParams().containsKey("backgroundColor")) ? null : Integer.valueOf(((Integer) page.getStartParams().get("backgroundColor")).intValue() | (-16777216));
            if (numValueOf != null) {
                a(numValueOf.intValue());
            }
        } catch (Exception e) {
            RVLogger.e(c, e);
        }
    }

    private void a(Page page) {
        try {
            String str = (page.getStartParams() == null || !page.getStartParams().containsKey("backgroundTextStyle")) ? null : (String) page.getStartParams().get("backgroundTextStyle");
            if (str != null) {
                b(str);
            }
        } catch (Exception e) {
            RVLogger.e(c, e);
        }
    }

    public void b() {
        this.h.setRefreshing(false);
    }

    public void a() {
        this.h.a(true, true);
    }

    public HashMap b(String str) {
        HashMap map = new HashMap();
        if (!this.g && !this.f) {
            map.put("errorMsg", "页面不支持pullRefresh");
            map.put("success", Boolean.FALSE);
            return map;
        }
        if (this.h != null && TextUtils.equals(str, "dark")) {
            this.h.getRefresHeader().a(RefreshHeader.RefreshHeaderStyle.DARK);
            map.put("success", Boolean.TRUE);
            return map;
        }
        if (this.h != null && TextUtils.equals(str, "light")) {
            this.h.getRefresHeader().a(RefreshHeader.RefreshHeaderStyle.NORMAL);
            map.put("success", Boolean.TRUE);
            return map;
        }
        map.put("success", Boolean.FALSE);
        map.put("errorMsg", "unknown param textStyle :" + str);
        return map;
    }

    public void a(boolean z, Page page) {
        if (z) {
            this.g = true;
            if (this.f) {
                e(page);
                return;
            } else {
                d(page);
                return;
            }
        }
        this.g = false;
        if (this.f) {
            b();
        }
        c();
    }

    private void c() {
        this.h.a(false);
        this.h.b(false);
        this.h.c(false);
        this.h.setPullRefreshDistance(0);
        this.h.setDistanceToRefresh(0);
        this.h.setHeaderView(new d(this.d));
    }

    public boolean a(int i) {
        try {
            if (!CommonUtils.isDowngradePullDownRefresh()) {
                this.h.setBackgroundColor(i);
                return true;
            }
            this.e.setBackgroundColor(i);
            return true;
        } catch (IllegalArgumentException e) {
            RVLogger.e(c, e);
            return false;
        } catch (NullPointerException e2) {
            RVLogger.e(c, e2);
            return false;
        }
    }

    public boolean a(String str) {
        try {
            return a(Color.parseColor(str));
        } catch (IllegalArgumentException e) {
            RVLogger.e(c, e);
            return false;
        } catch (NullPointerException e2) {
            RVLogger.e(c, e2);
            return false;
        }
    }
}
