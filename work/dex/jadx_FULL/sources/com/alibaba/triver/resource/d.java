package com.alibaba.triver.resource;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.prepare.controller.BasePrepareController;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.utils.CommonUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends BasePrepareController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25159a = "Ariver:LaunchPrepareController";
    private static final String b = "https://render.alipay.com/p/s/tinyapperror/?appId=%s&errorCode=%d";
    private static final int c = 1001;
    private static final int d = 50002;
    private AtomicBoolean e = new AtomicBoolean(true);
    private PrepareContext f;

    public d(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        bindContext(prepareContext, prepareCallback);
        this.f = prepareContext;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AppPrepareChecker());
        if (!CommonUtils.closeAppxForceUndate()) {
            arrayList.add(new i());
        }
        if (CommonUtils.isApkDebug()) {
            arrayList.add(new com.alibaba.triver.resource.debug.a());
        }
        setInterceptors(arrayList);
    }

    public PrepareStep a() {
        return this.currentExecutingStep;
    }

    @Override // com.alibaba.ariver.resource.prepare.controller.BasePrepareController, com.alibaba.ariver.resource.api.prepare.PrepareController
    public void moveToError(PrepareException prepareException) {
        super.moveToError(prepareException);
        PrepareCallback prepareCallback = this.callback;
        if (prepareCallback != null) {
            prepareCallback.prepareFail(this.context.getPrepareData(), prepareException);
        }
    }

    @Override // com.alibaba.ariver.resource.prepare.controller.BasePrepareController, com.alibaba.ariver.resource.api.prepare.PrepareController
    public void onGetAppInfo(@NonNull AppModel appModel) {
        super.onGetAppInfo(appModel);
        if (appModel.getAppInfoModel() == null) {
            return;
        }
        EntryInfo entryInfo = this.f.getEntryInfo();
        if (entryInfo == null) {
            entryInfo = new EntryInfo();
        }
        if (TextUtils.isEmpty(appModel.getAppInfoModel().getAlias())) {
            entryInfo.title = appModel.getAppInfoModel().getName();
        } else {
            entryInfo.title = appModel.getAppInfoModel().getAlias();
        }
        entryInfo.iconUrl = appModel.getAppInfoModel().getLogo();
        entryInfo.slogan = appModel.getAppInfoModel().getDesc();
        if (entryInfo.extraInfo == null) {
            entryInfo.extraInfo = new JSONObject();
        }
        if (appModel.getExtendInfos() != null) {
            entryInfo.extraInfo.put("extendInfo", appModel.getExtendInfos().m145clone());
            JSONObject jSONObject = appModel.getExtendInfos().getJSONObject("appLoadingConfig");
            if (jSONObject != null) {
                entryInfo.extraInfo.put("appLoadingConfig", jSONObject.m145clone());
            }
        } else {
            entryInfo.extraInfo.put("extendInfo", (Object) null);
        }
        this.context.setEntryInfo(entryInfo);
    }
}
