package com.alibaba.ariver.jsapi.actionsheet;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint;
import com.alibaba.ariver.app.api.point.dialog.CreateActionSheetParam;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.point.PageBackInterceptPoint;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionSheetBridgeExtension implements PageBackInterceptPoint, BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24117a = "AriverAPI:ActionSheetBridgeExtension";
    private boolean b = false;
    private Dialog c;
    private ActionSheetPoint d;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        Dialog dialog = this.c;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        this.c.cancel();
        return true;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void actionSheet(@BindingApiContext(required = true) ApiContext apiContext, @BindingNode(Page.class) Page page, @BindingParam({"title"}) String str, @BindingParam({"cancelBtn"}) String str2, @BindingParam({"btns"}) JSONArray jSONArray, @BindingParam({"badges"}) JSONArray jSONArray2, @BindingCallback final BridgeCallback bridgeCallback) {
        String[] strArr;
        JSONObject jSONObject;
        a();
        Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        ActionSheetPoint actionSheetPoint = (ActionSheetPoint) ExtensionPoint.as(ActionSheetPoint.class).node(page).nullable().create();
        this.d = actionSheetPoint;
        int i = 0;
        int i2 = 1;
        if (actionSheetPoint == null) {
            RVLogger.d(f24117a, "actionSheet use default");
            if (jSONArray == null || jSONArray.isEmpty()) {
                strArr = null;
            } else {
                strArr = new String[jSONArray.size()];
                while (i < jSONArray.size()) {
                    strArr[i] = jSONArray.getString(i);
                    i++;
                }
            }
            if (strArr == null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            }
            AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.actionsheet.ActionSheetBridgeExtension.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ActionSheetBridgeExtension.this.a();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("success", (Object) "true");
                    jSONObject2.put("index", (Object) Integer.valueOf(i3));
                    bridgeCallback.sendJSONResponse(jSONObject2);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.jsapi.actionsheet.ActionSheetBridgeExtension.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("success", (Object) "true");
                    jSONObject2.put("index", (Object) (-1));
                    bridgeCallback.sendJSONResponse(jSONObject2);
                }
            }).create();
            this.c = alertDialogCreate;
            alertDialogCreate.show();
            this.b = true;
            return;
        }
        RVLogger.d(f24117a, "actionSheet use actionSheetPoint");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray != null && !jSONArray.isEmpty()) {
            if (jSONArray2 == null || jSONArray2.isEmpty()) {
                i2 = 0;
            } else {
                for (int i3 = 0; i3 < jSONArray2.size(); i3++) {
                    try {
                        jSONObject = jSONArray2.getJSONObject(i3);
                    } catch (Throwable unused) {
                        jSONObject = new JSONObject();
                        jSONObject.put("index", "-1");
                    }
                    arrayList2.add(jSONObject);
                }
            }
            while (i < jSONArray.size()) {
                arrayList.add((String) jSONArray.get(i));
                i++;
            }
            i = i2;
        }
        String strTrim = str.trim();
        Dialog actionSheet = this.d.getActionSheet(i == 0 ? new CreateActionSheetParam(activity, arrayList, null, strTrim, bridgeCallback) : new CreateActionSheetParam(activity, arrayList, arrayList2, strTrim, bridgeCallback));
        this.c = actionSheet;
        if (actionSheet != null) {
            actionSheet.show();
        }
    }

    @Override // com.alibaba.ariver.engine.api.point.PageBackInterceptPoint
    public boolean interceptBackEvent(GoBackCallback goBackCallback) {
        return a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        a();
        ActionSheetPoint actionSheetPoint = this.d;
        if (actionSheetPoint != null) {
            actionSheetPoint.onRelease();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
