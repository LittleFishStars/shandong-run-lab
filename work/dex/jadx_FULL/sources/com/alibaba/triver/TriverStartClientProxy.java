package com.alibaba.triver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.container.ContainerAnimModel;
import com.alibaba.triver.container.TriverFragment;
import com.alibaba.triver.container.TriverMainActivity;
import com.alibaba.triver.container.TriverSubActivity;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.resource.d;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.CommonUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverStartClientProxy implements RVClientStarter {
    @Override // com.alibaba.ariver.integration.proxy.RVClientStarter
    public synchronized Fragment createFragment(Context context, RVAppRecord rVAppRecord, Bundle bundle) {
        if (rVAppRecord != null) {
            LaunchMonitorData mainMonitorData = LaunchMonitorUtils.getMainMonitorData(rVAppRecord.getSceneParams());
            if (mainMonitorData != null) {
                mainMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_CONTAINER_START);
            }
        }
        bundle.putString("record_id", rVAppRecord.getAppId());
        bundle.putLong("record_token", rVAppRecord.getStartToken());
        rVAppRecord.getSceneParams().putLong(RVConstants.EXTRA_START_ACTIVITY_TIMESTAMP, SystemClock.elapsedRealtime());
        return Fragment.instantiate(context, TriverFragment.class.getName(), bundle);
    }

    @Override // com.alibaba.ariver.integration.proxy.RVClientStarter
    public PrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        return new d(prepareContext, prepareCallback);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x023b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0244  */
    /* JADX WARN: Code duplicated, block: B:109:0x0253  */
    /* JADX WARN: Code duplicated, block: B:111:0x025d  */
    @Override // com.alibaba.ariver.integration.proxy.RVClientStarter
    public Class<? extends Activity> startClient(Context context, RVAppRecord rVAppRecord, Intent intent) {
        long startToken;
        Bundle startParams;
        RVAppRecord rVAppRecord2;
        String str;
        boolean z;
        boolean z2;
        com.alibaba.triver.container.a.C0160a c0160aA;
        Class<? extends Activity> clsA;
        String str2;
        String sessionId;
        LaunchMonitorData mainMonitorData;
        Context applicationContext = context == null ? ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext() : context;
        Context context2 = !(applicationContext instanceof Activity) ? ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get() : applicationContext;
        if (context2 == null) {
            intent.addFlags(268435456);
            context2 = applicationContext;
        }
        if (rVAppRecord != null) {
            startParams = rVAppRecord.getStartParams();
            String appId = rVAppRecord.getAppId();
            startToken = rVAppRecord.getStartToken();
            RVAppRecord appRecord = (startParams == null || !BundleUtils.getBoolean(startParams, RVStartParams.KEY_RESTART, false)) ? null : RVMain.getAppRecord(BundleUtils.getLong(startParams, RVStartParams.KEY_RESTART_FROM_TOKEN));
            LaunchMonitorData mainMonitorData2 = LaunchMonitorUtils.getMainMonitorData(rVAppRecord.getSceneParams());
            if (mainMonitorData2 != null) {
                mainMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_CONTAINER_START);
            }
            RVAppRecord rVAppRecord3 = appRecord;
            str = appId;
            rVAppRecord2 = rVAppRecord3;
        } else {
            startToken = -1;
            startParams = null;
            rVAppRecord2 = null;
            str = null;
        }
        if (startParams != null) {
            Object obj = startParams.get(TRiverConstants.KEY_SUB_PROCESS);
            z2 = obj != null ? !Boolean.parseBoolean(obj.toString()) : true;
            z = startParams.getBoolean("hideAppLoading", false);
        } else {
            z = false;
            z2 = true;
        }
        if (TROrangeController.enableSubProcess(str)) {
            startParams.putBoolean(TRiverConstants.KEY_SUB_PROCESS, true);
            z2 = false;
        }
        if (z2) {
            c0160aA = null;
        } else {
            c0160aA = rVAppRecord2 != null ? com.alibaba.triver.container.a.a().a(applicationContext.getApplicationContext(), rVAppRecord, rVAppRecord2) : com.alibaba.triver.container.a.a().a(applicationContext.getApplicationContext(), rVAppRecord);
        }
        if (c0160aA != null) {
            Class<? extends TriverSubActivity> cls = c0160aA.f24784a;
            if (rVAppRecord != null && rVAppRecord.getSceneParams() != null) {
                rVAppRecord.getSceneParams().putString(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, TriverAppMonitorConstants.KEY_STAGE_SUB_PROCESS);
            }
            clsA = cls;
        } else {
            if (rVAppRecord != null && rVAppRecord.getSceneParams() != null) {
                rVAppRecord.getSceneParams().putString(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, TriverAppMonitorConstants.KEY_STAGE_MAIN_PROCESS);
            }
            clsA = TriverMainActivity.class;
        }
        RVLogger.d(Triver.TAG, "target class:" + clsA.getSimpleName());
        if (startParams != null) {
            try {
                String string = startParams.getString("transition");
                String string2 = startParams.getString(TRiverConstants.KEY_ORI_URL);
                if (!TextUtils.isEmpty(string2)) {
                    intent.setData(Uri.parse(string2));
                }
                str2 = string;
            } catch (Throwable th) {
                th = th;
                c0160aA = c0160aA;
                RVLogger.e(Triver.TAG, "startClient exception:", th);
                com.alibaba.triver.container.a.a().a(c0160aA);
                if (rVAppRecord != null) {
                    sessionId = TRiverUtils.getSessionId(rVAppRecord.getStartParams());
                } else {
                    sessionId = "";
                }
                com.alibaba.triver.trace.b.a(c.d, c.B, sessionId, str, "CONTAINER_START_ERROR", th.getMessage(), (JSONObject) null);
                if (rVAppRecord != null) {
                    mainMonitorData = LaunchMonitorUtils.getMainMonitorData(rVAppRecord.getSceneParams());
                    if (mainMonitorData != null) {
                        mainMonitorData.setErrorMessage("CONTAINER_START_ERROR");
                    }
                    LaunchMonitorUtils.commitMonitorInMain(rVAppRecord.getAppId(), rVAppRecord.getSceneParams(), rVAppRecord.getStartParams());
                }
                return clsA;
            }
        } else {
            str2 = null;
        }
        try {
            intent.putExtra("record_id", str);
            intent.putExtra("record_token", startToken);
            ContainerAnimModel containerAnimModel = new ContainerAnimModel();
            if (z) {
                if (!CommonUtils.closeHideAppLoading()) {
                    clsA = TriverSubActivity.a(clsA);
                    intent.putExtra("hideAppLoading", true);
                }
                intent.addFlags(65536);
                containerAnimModel.frontEnterAnim = 0;
                containerAnimModel.backgroundEnterAnim = 0;
                containerAnimModel.frontExitAnim = 0;
                containerAnimModel.backgroundExitAnim = 0;
            } else if ("present".equals(str2)) {
                containerAnimModel.frontEnterAnim = R.anim.triver_pri_enter_up_in;
                containerAnimModel.backgroundEnterAnim = R.anim.triver_pri_enter_scale;
                containerAnimModel.frontExitAnim = R.anim.triver_pri_exit_scale;
                containerAnimModel.backgroundExitAnim = R.anim.triver_pri_exit_down_out;
            } else if ("drop".equals(str2)) {
                containerAnimModel.frontEnterAnim = R.anim.triver_enter_down_in;
                containerAnimModel.backgroundEnterAnim = R.anim.triver_anim_temp;
                containerAnimModel.frontExitAnim = R.anim.triver_fade_out;
                containerAnimModel.backgroundExitAnim = R.anim.triver_anim_temp;
            } else {
                containerAnimModel.frontEnterAnim = R.anim.ariver_fragment_translate_in_left;
                containerAnimModel.backgroundEnterAnim = R.anim.ariver_fragment_translate_out_left;
                containerAnimModel.frontExitAnim = R.anim.ariver_fragment_translate_in_right;
                containerAnimModel.backgroundExitAnim = R.anim.ariver_fragment_translate_out_right;
            }
            intent.putExtra(TRiverConstants.KEY_CONTAINER_ANIM, containerAnimModel);
            if (rVAppRecord != null && rVAppRecord.getSceneParams() != null) {
                rVAppRecord.getSceneParams().putSerializable(TRiverConstants.KEY_CONTAINER_ANIM, containerAnimModel);
                rVAppRecord.getSceneParams().putLong(RVConstants.EXTRA_START_ACTIVITY_TIMESTAMP, SystemClock.elapsedRealtime());
            }
            intent.setClass(context2, clsA);
            ActivityOptionsCompat activityOptionsCompatMakeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(applicationContext, containerAnimModel.frontEnterAnim, containerAnimModel.backgroundEnterAnim);
            Integer numValueOf = (startParams == null || !startParams.containsKey(TRiverConstants.KEY_REQUEST_CODE)) ? null : Integer.valueOf(startParams.getInt(TRiverConstants.KEY_REQUEST_CODE));
            if (rVAppRecord2 != null) {
                intent.addFlags(65536);
                if (numValueOf == null || !(context2 instanceof Activity)) {
                    context2.startActivity(intent);
                } else {
                    ((Activity) context2).startActivityForResult(intent, numValueOf.intValue());
                }
            } else if (numValueOf == null || !(context2 instanceof Activity)) {
                context2.startActivity(intent, activityOptionsCompatMakeCustomAnimation.toBundle());
            } else {
                ((Activity) context2).startActivityForResult(intent, numValueOf.intValue(), activityOptionsCompatMakeCustomAnimation.toBundle());
            }
            RVLogger.d(Triver.TAG, "start finish");
        } catch (Throwable th2) {
            th = th2;
            RVLogger.e(Triver.TAG, "startClient exception:", th);
            com.alibaba.triver.container.a.a().a(c0160aA);
            if (rVAppRecord != null) {
                sessionId = TRiverUtils.getSessionId(rVAppRecord.getStartParams());
            } else {
                sessionId = "";
            }
            com.alibaba.triver.trace.b.a(c.d, c.B, sessionId, str, "CONTAINER_START_ERROR", th.getMessage(), (JSONObject) null);
            if (rVAppRecord != null) {
                mainMonitorData = LaunchMonitorUtils.getMainMonitorData(rVAppRecord.getSceneParams());
                if (mainMonitorData != null) {
                    mainMonitorData.setErrorMessage("CONTAINER_START_ERROR");
                }
                LaunchMonitorUtils.commitMonitorInMain(rVAppRecord.getAppId(), rVAppRecord.getSceneParams(), rVAppRecord.getStartParams());
            }
        }
        return clsA;
    }
}
