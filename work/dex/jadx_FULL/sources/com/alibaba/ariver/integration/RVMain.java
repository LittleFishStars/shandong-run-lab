package com.alibaba.ariver.integration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.proxy.RVSinglePageAppProxy;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.ipc.server.e;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.integration.resource.d;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RVMain {
    private static final String TAG = "AriverInt:Main";
    private static LongSparseArray<RVAppRecord> appRecords = new LongSparseArray<>();

    public interface a {
        void a(Fragment fragment);
    }

    static {
        IpcChannelManager.getInstance().registerClientListener(new IpcChannelManager.ClientListener() { // from class: com.alibaba.ariver.integration.RVMain.1
            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public void onRegister(long j, IIpcChannel iIpcChannel) {
                RVLogger.d(RVMain.TAG, "onClient register: " + j);
            }

            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public void onUnRegister(long j) {
                RVLogger.d(RVMain.TAG, "onClient unRegister: " + j);
                e.a().a(j);
                RVMain.removeAppRecord(j);
            }
        });
    }

    public static synchronized void createFragment(Context context, String str, Bundle bundle, @Nullable Bundle bundle2, a aVar) {
        RVLogger.d(TAG, "createFragment: " + str);
        RVInitializer.init(context);
        RVInitializer.setupOptimize();
        Bundle bundleClone = BundleUtils.clone(bundle);
        RVAppRecord rVAppRecordGenerate = RVAppRecord.generate(str, bundleClone, BundleUtils.clone(bundle2));
        rVAppRecordGenerate.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(bundleClone, "url"));
        rVAppRecordGenerate.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        appRecords.put(rVAppRecordGenerate.getStartToken(), rVAppRecordGenerate);
        RVClientStarter rVClientStarter = (RVClientStarter) RVProxy.get(RVClientStarter.class);
        PrepareContext prepareContext = new PrepareContext(context, rVAppRecordGenerate.getAppId(), rVAppRecordGenerate.getStartParams(), rVAppRecordGenerate.getSceneParams());
        com.alibaba.ariver.integration.resource.b bVar = new com.alibaba.ariver.integration.resource.b(rVAppRecordGenerate, prepareContext, aVar);
        final PrepareController prepareControllerCreatePrepareController = rVClientStarter.createPrepareController(prepareContext, bVar);
        if (prepareControllerCreatePrepareController == null) {
            bVar.startApp(new PrepareCallbackParam(prepareContext));
        } else {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.3
                @Override // java.lang.Runnable
                public void run() {
                    prepareControllerCreatePrepareController.start();
                }
            });
        }
    }

    public static void createPage(Activity activity, String str, boolean z, Bundle bundle, Bundle bundle2, b bVar) {
        RVLogger.d(TAG, "createPage: " + str);
        bundle.putString("appId", str);
        RVAppRecord rVAppRecordGenerate = RVAppRecord.generate(str, BundleUtils.clone(bundle), BundleUtils.clone(bundle2));
        RVInitializer.init(activity.getApplicationContext());
        RVInitializer.setupOptimize();
        rVAppRecordGenerate.getStartParams().putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_CREATE_PAGE);
        rVAppRecordGenerate.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(rVAppRecordGenerate.getStartParams(), "url"));
        rVAppRecordGenerate.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        appRecords.put(rVAppRecordGenerate.getStartToken(), rVAppRecordGenerate);
        PrepareContext prepareContext = new PrepareContext(activity, str, rVAppRecordGenerate.getStartParams(), rVAppRecordGenerate.getSceneParams());
        com.alibaba.ariver.integration.resource.c cVar = new com.alibaba.ariver.integration.resource.c(activity, rVAppRecordGenerate, prepareContext, bVar);
        final PrepareController prepareControllerCreatePrepareController = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).createPrepareController(prepareContext, cVar);
        if (!z || prepareControllerCreatePrepareController == null) {
            cVar.startApp(new PrepareCallbackParam(prepareContext));
        } else {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.5
                @Override // java.lang.Runnable
                public void run() {
                    prepareControllerCreatePrepareController.start();
                }
            });
        }
    }

    public static Page createPageSync(Activity activity, String str, boolean z, Bundle bundle, Bundle bundle2) {
        Bundle bundleClone = BundleUtils.clone(bundle);
        Bundle bundleClone2 = BundleUtils.clone(bundle2);
        RVInitializer.init(activity.getApplicationContext());
        RVAppRecord rVAppRecordGenerate = RVAppRecord.generate(str, bundleClone, bundleClone2);
        Bundle startParams = rVAppRecordGenerate.getStartParams();
        Bundle sceneParams = rVAppRecordGenerate.getSceneParams();
        startParams.putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(startParams, "url"));
        startParams.putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        startParams.putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_CREATE_PAGE);
        appRecords.put(rVAppRecordGenerate.getStartToken(), rVAppRecordGenerate);
        PrepareContext prepareContext = new PrepareContext(activity, str, startParams, sceneParams);
        if (z) {
            AppInfoQuery appInfoQuery = new AppInfoQuery(str);
            String string = BundleUtils.getString(prepareContext.getStartParams(), "appVersion");
            if (!TextUtils.isEmpty(string)) {
                appInfoQuery.version(string);
            }
            if (AppInfoScene.isDevSource(prepareContext.getStartParams())) {
                appInfoQuery.scene(AppInfoScene.extractScene(prepareContext.getStartParams()));
                appInfoQuery.version(AppInfoScene.extractSceneVersion(prepareContext.getStartParams()));
            }
            prepareContext.setAppInfoQuery(appInfoQuery);
            AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(appInfoQuery);
            if (!(appModel != null)) {
                return null;
            }
            prepareContext.setOriginHasAppInfo(true);
            prepareContext.setupAppInfo(appModel);
        }
        App appStartApp = ((AppManager) RVProxy.get(AppManager.class)).startApp(str, prepareContext.getStartParams(), prepareContext.getSceneParams());
        RVSinglePageAppProxy rVSinglePageAppProxy = (RVSinglePageAppProxy) RVProxy.get(RVSinglePageAppProxy.class);
        appStartApp.bindContext(rVSinglePageAppProxy.createAppContext(appStartApp, activity));
        Page pagePreCreatePage = appStartApp.preCreatePage();
        pagePreCreatePage.bindContext(rVSinglePageAppProxy.createPageContext(appStartApp, activity));
        appStartApp.start();
        return pagePreCreatePage;
    }

    public static void filterStartParams(Bundle bundle) {
        if (bundle == null || TextUtils.isEmpty(bundle.getString(RVStartParams.KEY_PAGE_ALIAS)) || !bundle.containsKey("page")) {
            return;
        }
        bundle.remove(RVStartParams.KEY_PAGE_ALIAS);
    }

    public static synchronized RVAppRecord getAppRecord(long j) {
        return appRecords.get(j);
    }

    public static synchronized List<RVAppRecord> getAppRecords(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = appRecords.size();
        for (int i = 0; i < size; i++) {
            RVAppRecord rVAppRecordValueAt = appRecords.valueAt(i);
            if (rVAppRecordValueAt != null && TextUtils.equals(str, rVAppRecordValueAt.getAppId())) {
                arrayList.add(rVAppRecordValueAt);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void removeAppRecord(long j) {
        RVLogger.d(TAG, "removeAppRecord: " + j);
        appRecords.remove(j);
    }

    public static synchronized void startApp(Context context, @NonNull RVAppRecord rVAppRecord) {
        RVInitializer.init(context);
        RVInitializer.setupOptimize();
        RVLogger.d(TAG, "startApp: " + rVAppRecord.getAppId());
        rVAppRecord.getStartParams().putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_START_APP);
        rVAppRecord.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(rVAppRecord.getStartParams(), "url"));
        rVAppRecord.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_preparePhase_before);
        RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_preparePhase_setup);
        appRecords.put(rVAppRecord.getStartToken(), rVAppRecord);
        RVClientStarter rVClientStarter = (RVClientStarter) RVProxy.get(RVClientStarter.class);
        PrepareContext prepareContext = new PrepareContext(context, rVAppRecord.getAppId(), rVAppRecord.getStartParams(), rVAppRecord.getSceneParams());
        com.alibaba.ariver.integration.resource.a aVar = new com.alibaba.ariver.integration.resource.a(rVAppRecord, prepareContext);
        final PrepareController prepareControllerCreatePrepareController = rVClientStarter.createPrepareController(prepareContext, aVar);
        if (prepareControllerCreatePrepareController == null) {
            aVar.startApp(new PrepareCallbackParam(prepareContext));
        } else {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.2
                @Override // java.lang.Runnable
                public void run() {
                    RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare);
                    prepareControllerCreatePrepareController.start();
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare);
                }
            });
        }
    }

    public static void startPage(Context context, RVAppRecord rVAppRecord, boolean z) {
        RVLogger.d(TAG, "startPage: " + rVAppRecord.getAppId());
        RVInitializer.init(context.getApplicationContext());
        RVInitializer.setupOptimize();
        rVAppRecord.getStartParams().putString(RVStartParams.KEY_START_SCENE, RVStartParams.START_SCENE_START_PAGE);
        rVAppRecord.getStartParams().putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(rVAppRecord.getStartParams(), "url"));
        rVAppRecord.getSceneParams().putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        appRecords.put(rVAppRecord.getStartToken(), rVAppRecord);
        PrepareContext prepareContext = new PrepareContext(context, rVAppRecord.getAppId(), rVAppRecord.getStartParams(), rVAppRecord.getSceneParams());
        d dVar = new d(rVAppRecord, prepareContext);
        final PrepareController prepareControllerCreatePrepareController = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).createPrepareController(prepareContext, dVar);
        if (!z || prepareControllerCreatePrepareController == null) {
            dVar.startApp(new PrepareCallbackParam(prepareContext));
        } else {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.integration.RVMain.4
                @Override // java.lang.Runnable
                public void run() {
                    prepareControllerCreatePrepareController.start();
                }
            });
        }
    }

    @Deprecated
    public static synchronized RVAppRecord getAppRecord(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int size = appRecords.size();
        for (int i = 0; i < size; i++) {
            RVAppRecord rVAppRecordValueAt = appRecords.valueAt(i);
            if (rVAppRecordValueAt != null && TextUtils.equals(str, rVAppRecordValueAt.getAppId())) {
                return rVAppRecordValueAt;
            }
        }
        return null;
    }

    public static synchronized LongSparseArray<RVAppRecord> getAppRecords() {
        return appRecords;
    }

    public static synchronized void startApp(Context context, String str, Bundle bundle, @Nullable Bundle bundle2) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Main_startApp);
        RVLogger.d(TAG, "startApp: " + str);
        filterStartParams(bundle);
        startApp(context, RVAppRecord.generate(str, BundleUtils.clone(bundle), BundleUtils.clone(bundle2)));
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Main_startApp);
    }
}
