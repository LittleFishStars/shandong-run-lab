package com.alibaba.ariver.console;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.console.a.c;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.DisplayUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DebugConsoleExtension implements View.OnClickListener, DebugConsolePoint, NodeAware<App> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24039a = "AriverRemoteDebug:DebugConsoleExtension";
    private static final String b = "onTinyDebugConsole";
    private WeakReference<App> c;
    private c d;
    private ViewGroup e;
    private com.alibaba.ariver.console.a.a f;
    private boolean g;

    private void a() {
        Activity activityE = e();
        if (activityE == null) {
            return;
        }
        if (this.g) {
            RVLogger.d(f24039a, "[createConsoleView] view creating!");
            return;
        }
        App appD = d();
        if (appD == null) {
            RVLogger.d(f24039a, "[createConsoleView] app is null.");
        } else {
            this.g = true;
            ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).initConsoleView(activityE, appD.getStartToken(), new a() { // from class: com.alibaba.ariver.console.DebugConsoleExtension.1
                @Override // com.alibaba.ariver.console.a
                public void a(c cVar) {
                    DebugConsoleExtension.this.d = cVar;
                    DebugConsoleExtension.this.b();
                    DebugConsoleExtension.this.g = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Activity activityE;
        c cVar = this.d;
        if (cVar == null || cVar.a() == null || (activityE = e()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activityE.findViewById(R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = DisplayUtils.getTitleAndStatusBarHeight(activityE);
        FrameLayout frameLayout = new FrameLayout(activityE);
        frameLayout.setVisibility(8);
        viewGroup.addView(frameLayout, layoutParams);
        frameLayout.setBackgroundColor(1996488704);
        frameLayout.bringToFront();
        frameLayout.setOnClickListener(this);
        this.e = frameLayout;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).getDebugConsoleViewHeight(activityE));
        layoutParams2.gravity = 80;
        frameLayout.addView(this.d.a(), layoutParams2);
    }

    private void c() {
        RVLogger.d(f24039a, "[initToggleButton]");
        Activity activityE = e();
        if (activityE == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activityE.findViewById(R.id.content);
        this.f = new com.alibaba.ariver.console.a.a(activityE);
        this.f.setBackgroundColor(((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).getConsoleToggleButtonColor(activityE));
        this.f.setText(com.alibaba.ariver.remotedebug.R.string.console_toggle_button_text);
        this.f.setTextSize(15.0f);
        this.f.setTextColor(-1);
        this.f.setPadding(18, 12, 18, 12);
        int titleAndStatusBarHeight = DisplayUtils.getTitleAndStatusBarHeight(activityE);
        this.f.a(DimensionUtil.getScreenWidth(activityE), DimensionUtil.getScreenHeight(activityE) - titleAndStatusBarHeight);
        this.f.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = 200;
        layoutParams.rightMargin = 30;
        viewGroup.addView(this.f, layoutParams);
        this.f.bringToFront();
    }

    @Nullable
    private App d() {
        WeakReference<App> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private Activity e() {
        AppContext appContext;
        App appD = d();
        if (appD == null || (appContext = appD.getAppContext()) == null) {
            return null;
        }
        Context context = appContext.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public boolean isDebugPanelExists() {
        return (this.d == null || this.g) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f) {
            toggleConsoleView();
        } else if (view == this.e) {
            toggleConsoleView();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void removeConsoleView() {
        Activity activityE = e();
        if (activityE == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activityE.findViewById(R.id.content);
        c cVar = this.d;
        if (cVar != null) {
            View viewA = cVar.a();
            if (viewA != null) {
                viewGroup.removeView(viewA);
            }
            this.d.b();
        }
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup.removeView(viewGroup2);
        }
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void sendMsgToConsoleView(JSONObject jSONObject) {
        c cVar = this.d;
        if (cVar == null) {
            return;
        }
        cVar.a(b, jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.c = weakReference;
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void showToggleButton(boolean z) {
        App appD = d();
        if (appD == null) {
            RVLogger.e(f24039a, "showToggleButton app is null.");
            return;
        }
        com.alibaba.ariver.console.a.a aVar = this.f;
        if (aVar == null && z) {
            c();
            ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).setToggleButtonVisible(appD.getAppId(), true);
            a();
        } else {
            if (aVar != null) {
                aVar.setVisibility(z ? 0 : 8);
            }
            ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).setToggleButtonVisible(appD.getAppId(), z);
        }
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void toggleConsoleView() {
        ViewGroup viewGroup = this.e;
        if (viewGroup == null || this.d == null || this.g) {
            RVLogger.e(f24039a, "Console View is not created!");
        } else {
            this.e.setVisibility(viewGroup.getVisibility() == 0 ? 8 : 0);
        }
    }
}
