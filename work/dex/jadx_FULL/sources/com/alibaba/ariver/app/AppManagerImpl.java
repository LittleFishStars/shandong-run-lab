package com.alibaba.ariver.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.point.app.AppCreatePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.proxy.RVAppFactory;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.ipd.dsp.internal.e1.b;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class AppManagerImpl extends NodeInstance implements AppManager {
    public static final Parcelable.Creator<AppManagerImpl> CREATOR = new Parcelable.Creator<AppManagerImpl>() { // from class: com.alibaba.ariver.app.AppManagerImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppManagerImpl createFromParcel(Parcel parcel) {
            return new AppManagerImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppManagerImpl[] newArray(int i) {
            return new AppManagerImpl[i];
        }
    };
    private final Stack<App> mAppStack;

    public AppManagerImpl() {
        this.mAppStack = new Stack<>();
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public synchronized void exitApp(long j) {
        App appFindApp = findApp(j);
        if (appFindApp != null) {
            appFindApp.exit();
            this.mAppStack.remove(appFindApp);
        }
        if (appFindApp != null) {
            removeChild(appFindApp);
        }
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public synchronized App findApp(long j) {
        return (App) getChild(j);
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public synchronized App findAppByToken(long j) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            App app = (App) getChildAt(i);
            if (app.getStartToken() == j) {
                return app;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public synchronized Stack<App> getAppStack() {
        Stack<App> stack;
        stack = new Stack<>();
        Iterator<App> it = this.mAppStack.iterator();
        while (it.hasNext()) {
            stack.push(it.next());
        }
        return stack;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public synchronized App preCreateApp(String str, Bundle bundle, Bundle bundle2) {
        AppNode appNodeCreateApp;
        appNodeCreateApp = ((RVAppFactory) RVProxy.get(RVAppFactory.class)).createApp();
        appNodeCreateApp.preCreateInit(str, bundle, bundle2);
        ((AppCreatePoint) ExtensionPoint.as(AppCreatePoint.class).node(appNodeCreateApp).create()).onAppCreate(appNodeCreateApp);
        pushChild(appNodeCreateApp);
        return appNodeCreateApp;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public synchronized App startApp(String str, Bundle bundle, Bundle bundle2) {
        App appFindAppByToken;
        RVLogger.printPerformanceLog(b.F, "Start create app");
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_App_createApp);
        appFindAppByToken = findAppByToken(BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN, 0L));
        if (appFindAppByToken != null) {
            appFindAppByToken.init(str, bundle, bundle2);
        } else {
            appFindAppByToken = ((RVAppFactory) RVProxy.get(RVAppFactory.class)).createApp();
            RVTraceUtils.traceEndSection(RVTraceKey.RV_App_createApp);
            appFindAppByToken.init(str, bundle, bundle2);
            pushChild(appFindAppByToken);
        }
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_App_onAppStart);
        ((AppStartPoint) ExtensionPoint.as(AppStartPoint.class).node(appFindAppByToken).create()).onAppStart(appFindAppByToken);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_App_onAppStart);
        this.mAppStack.push(appFindAppByToken);
        return appFindAppByToken;
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public AppManagerImpl(Parcel parcel) {
        super(parcel);
        this.mAppStack = new Stack<>();
    }
}
