package com.alibaba.triver.open.container;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.view.EmbedPageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends EmbedPageContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f25042a;
    private Handler b;
    private Context c;
    private ViewGroup d;
    private boolean e;
    private Page f;
    private Runnable g;

    public a(FragmentActivity fragmentActivity, c cVar) {
        super(fragmentActivity);
        this.b = new Handler(Looper.getMainLooper());
        this.g = new Runnable() { // from class: com.alibaba.triver.open.container.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.e) {
                    a.this.f25042a.a("AC_RENDER_TIMEOUT", "渲染超时");
                }
                a.this.e = true;
                RVLogger.w("OpenEmbedPageContext", "AC_RENDER_TIMEOUT");
            }
        };
        this.f25042a = cVar;
        this.c = fragmentActivity;
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public void addRenderView(View view) {
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.d = frameLayout;
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.f25042a.b(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f25042a.c(), 1073741824));
        ViewGroup viewGroup = this.d;
        viewGroup.layout(0, 0, viewGroup.getMeasuredWidth(), this.d.getMeasuredHeight());
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.container.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EngineUtils.sendToRender(a.this.f.getRender(), EngineUtils.getWorker(a.this.f.getApp().getEngineProxy()), "onBcComponentClick", null, null);
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.triver.open.container.a.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f25044a = 0;
            public static final int b = 1;
            public static final int c = 2;
            public static final int d = 3;
            private int f = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        int i = this.f;
                        if (i != 2) {
                            this.f = 0;
                            EngineUtils.sendToRender(a.this.f.getRender(), EngineUtils.getWorker(a.this.f.getApp().getEngineProxy()), "onBcComponentClick", null, null);
                        } else if (i == 2) {
                            this.f = 0;
                        } else {
                            this.f = 3;
                        }
                    } else if (action != 2) {
                        this.f = 3;
                    } else {
                        int i2 = this.f;
                        if (i2 == 1 || i2 == 2) {
                            this.f = 2;
                        } else {
                            this.f = 3;
                        }
                    }
                } else if (this.f == 0) {
                    this.f = 1;
                } else {
                    this.f = 3;
                }
                return false;
            }
        });
        this.b.postDelayed(this.g, 5000L);
        this.d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.f.getApp(), PerfId.viewShow);
        this.b.post(new Runnable() { // from class: com.alibaba.triver.open.container.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.d.measure(View.MeasureSpec.makeMeasureSpec(a.this.f25042a.b(), 1073741824), View.MeasureSpec.makeMeasureSpec(a.this.f25042a.c(), 1073741824));
                a.this.d.layout(0, 0, a.this.d.getMeasuredWidth(), a.this.d.getMeasuredHeight());
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public void attachPage(Page page) {
        page.getStartParams().putString(RVParams.SESSION_ID, "session_" + page.getApp().getAppId() + LoginConstants.UNDER_LINE + page.getApp().hashCode());
        page.getStartParams().putBoolean(RVParams.isTinyApp, true);
        this.f = page;
    }

    @Override // com.alibaba.ariver.app.view.EmbedPageContext, com.alibaba.ariver.app.api.PageContext
    @Nullable
    public Activity getActivity() {
        Context context = this.c;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public int getContentViewHeight() {
        c cVar = this.f25042a;
        if (cVar != null) {
            return cVar.c();
        }
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public int getContentViewWidth() {
        c cVar = this.f25042a;
        if (cVar != null) {
            return cVar.b();
        }
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public ViewGroup getView() {
        return null;
    }

    public void b() {
        RVLogger.w("OpenEmbedPageContext", "createComponent");
        if (this.f25042a == null || this.e) {
            return;
        }
        try {
            this.b.removeCallbacks(this.g);
            this.b.post(new Runnable() { // from class: com.alibaba.triver.open.container.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.e) {
                        a.this.f25042a.a(a.this.d);
                    }
                    a.this.e = true;
                }
            });
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    public void a() {
        this.b.postDelayed(new Runnable() { // from class: com.alibaba.triver.open.container.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.f25042a.a();
            }
        }, 100L);
    }
}
