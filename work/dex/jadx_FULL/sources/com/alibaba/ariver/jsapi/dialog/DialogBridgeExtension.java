package com.alibaba.ariver.jsapi.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.dialog.AgreementConfirmPoint;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.CreatePromptParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.app.api.point.dialog.PromptPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.jsapi.R;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DialogBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24130a = "DialogBridgeExtension";

    private Map<String, CreateDialogParam.Agreement> a(App app, AgreementConfirmPoint agreementConfirmPoint, JSONArray jSONArray) {
        if (agreementConfirmPoint == null || app == null || jSONArray == null || jSONArray.size() == 0) {
            RVLogger.d(f24130a, "parseAgreementClick params error  ");
            return null;
        }
        HashMap map = new HashMap();
        for (Object obj : jSONArray) {
            if (obj != null && (obj instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = JSONUtils.getString(jSONObject, "tag");
                String string2 = JSONUtils.getString(jSONObject, "text");
                String string3 = JSONUtils.getString(jSONObject, "url");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    RVLogger.d(f24130a, "agreement args is empty");
                } else {
                    CreateDialogParam.Agreement agreement = new CreateDialogParam.Agreement();
                    agreement.tag = string;
                    agreement.text = string2;
                    agreement.url = string3;
                    if (agreementConfirmPoint.hasPermission(app, string3)) {
                        agreement.hasPermission = true;
                    } else {
                        RVLogger.d(f24130a, "agreement url no permission ");
                        agreement.hasPermission = false;
                    }
                    map.put(string, agreement);
                }
            }
        }
        return map;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void agreementConfirm(@BindingNode(App.class) final App app, @BindingParam(name = {"title"}) String str, @BindingParam(name = {"message"}) String str2, @BindingParam(name = {"okButton"}) String str3, @BindingParam(name = {"cancelButton"}) String str4, @BindingParam(name = {"align"}) String str5, @BindingParam(name = {"confirmColor"}) String str6, @BindingParam(name = {"cancelColor"}) String str7, @BindingParam(name = {"agreements"}) JSONArray jSONArray, @BindingCallback final BridgeCallback bridgeCallback) {
        Map<String, CreateDialogParam.Agreement> mapA;
        if (app.getAppContext() == null) {
            RVLogger.d(f24130a, "appContext is null");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        final AgreementConfirmPoint agreementConfirmPoint = (AgreementConfirmPoint) ExtensionPoint.as(AgreementConfirmPoint.class).node(app).create();
        if (agreementConfirmPoint == null) {
            RVLogger.d(f24130a, "agreementConfirmPoint is null");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(5, "not support"));
            return;
        }
        String str8 = TextUtils.isEmpty(str3) ? "确定" : str3;
        String str9 = TextUtils.isEmpty(str4) ? OptionsPickerHelper.e : str4;
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(app).create();
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, str8, str9, str5);
        if (jSONArray != null && (mapA = a(app, agreementConfirmPoint, jSONArray)) != null && !mapA.isEmpty()) {
            createDialogParam.agreements = mapA;
            createDialogParam.agreementListener = new CreateDialogParam.AgreementClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.1
                @Override // com.alibaba.ariver.app.api.point.dialog.CreateDialogParam.AgreementClickListener
                public void onClick(String str10) {
                    RVLogger.d(DialogBridgeExtension.f24130a, "onAgreementClick  url=" + str10);
                    agreementConfirmPoint.onAgreementClick(app, str10);
                }
            };
        }
        createDialogParam.positiveTextColor = str6;
        createDialogParam.cancelColor = str7;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        if (app.getAppContext() == null || app.getAppContext().getContext() == null || !(app.getAppContext().getContext() instanceof Activity)) {
            RVLogger.d(f24130a, "context is null ");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(3, "activity is not ready or has destroyed "));
        } else {
            Dialog dialogCreateDialog = dialogPoint.createDialog((Activity) app.getAppContext().getContext(), createDialogParam);
            if (dialogCreateDialog != null) {
                dialogCreateDialog.show();
            }
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void alert(@BindingNode(Page.class) Page page, @BindingParam(name = {"title"}) String str, @BindingParam(name = {"message"}) String str2, @BindingParam(name = {"button"}) String str3, @BindingParam(name = {"align"}) String str4, @BindingParam(name = {"confirmColor"}) String str5, @BindingParam(name = {"cancelColor"}) String str6, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        final Activity activity = page.getPageContext().getActivity();
        if (TextUtils.isEmpty(str3)) {
            str3 = LangResourceUtil.getString(page.getPageContext().getActivity(), R.string.ariver_jsapi_ok);
        }
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(page).create();
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, str3, null, str4);
        createDialogParam.cancelable = false;
        createDialogParam.positiveTextColor = str5;
        createDialogParam.cancelColor = str6;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null && !activity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                bridgeCallback.sendBridgeResponse(null);
            }
        };
        createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.9
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                bridgeCallback.sendBridgeResponse(null);
            }
        };
        Dialog dialogCreateDialog = dialogPoint.createDialog(activity, createDialogParam);
        if (dialogCreateDialog != null) {
            dialogCreateDialog.show();
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void confirm(@BindingNode(Page.class) Page page, @BindingParam(name = {"title"}) String str, @BindingParam(name = {"message"}) String str2, @BindingParam(name = {"okButton"}) String str3, @BindingParam(name = {"cancelButton"}) String str4, @BindingParam(name = {"align"}) String str5, @BindingParam(name = {"confirmColor"}) String str6, @BindingParam(name = {"cancelColor"}) String str7, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        final Activity activity = page.getPageContext().getActivity();
        String string = TextUtils.isEmpty(str3) ? LangResourceUtil.getString(page.getPageContext().getActivity(), R.string.ariver_jsapi_ok) : str3;
        String string2 = TextUtils.isEmpty(str4) ? LangResourceUtil.getString(page.getPageContext().getActivity(), R.string.ariver_jsapi_cancel) : str4;
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(page).create();
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, string, string2, str5);
        createDialogParam.cancelable = false;
        createDialogParam.positiveTextColor = str6;
        createDialogParam.cancelColor = str7;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null && !activity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null && !activity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.12
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        Dialog dialogCreateDialog = dialogPoint.createDialog(page.getPageContext().getActivity(), createDialogParam);
        if (dialogCreateDialog != null) {
            dialogCreateDialog.show();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void prompt(@BindingNode(Page.class) Page page, @BindingParam(name = {"title"}) String str, @BindingParam(name = {"message"}) String str2, @BindingParam(name = {"okButton"}) String str3, @BindingParam(name = {"cancelButton"}) String str4, @BindingParam(name = {"placeholder"}) String str5, @BindingParam(name = {"confirmColor"}) String str6, @BindingParam(name = {"cancelColor"}) String str7, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        final Activity activity = page.getPageContext().getActivity();
        String string = TextUtils.isEmpty(str3) ? LangResourceUtil.getString(page.getPageContext().getActivity(), R.string.ariver_jsapi_ok) : str3;
        String string2 = TextUtils.isEmpty(str4) ? LangResourceUtil.getString(page.getPageContext().getActivity(), R.string.ariver_jsapi_cancel) : str4;
        PromptPoint promptPoint = (PromptPoint) ExtensionPoint.as(PromptPoint.class).node(page).create();
        CreatePromptParam createPromptParam = new CreatePromptParam(str, str2, string, string2, str5);
        createPromptParam.cancelable = false;
        createPromptParam.positiveTextColor = str6;
        createPromptParam.cancelColor = str7;
        createPromptParam.positiveListener = new CreatePromptParam.PositiveListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.2
            @Override // com.alibaba.ariver.app.api.point.dialog.CreatePromptParam.PositiveListener
            public void onClick(DialogInterface dialogInterface, String str8) {
                if (dialogInterface != null && !activity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputValue", (Object) str8);
                jSONObject.put("ok", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        createPromptParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null && !activity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputValue", (Object) "");
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        createPromptParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputValue", (Object) "");
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        Dialog dialogCreateDialog = promptPoint.createDialog(page.getPageContext().getActivity(), createPromptParam);
        if (dialogCreateDialog != null) {
            dialogCreateDialog.show();
        }
    }
}
