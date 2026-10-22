package com.alibaba.triver.basic.picker;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.picker.tb.OptionSelectDialog;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.igexin.assist.util.AssistUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PickerBridgeExtension implements BridgeExtension {

    public class a<T> {
        private T b;
        private T c;
        private int d;
        private int e;

        private a() {
            this.d = -1;
            this.e = -1;
        }

        public T a() {
            return this.b;
        }

        public void b(int i) {
            this.e = i;
        }

        public int c() {
            return this.e;
        }

        public T d() {
            return this.c;
        }

        public void a(int i) {
            this.d = i;
        }

        public int b() {
            return this.d;
        }

        public void a(T t) {
            this.b = t;
        }

        public void b(T t) {
            this.c = t;
        }
    }

    private String a(App app) {
        try {
            return ((AppModel) app.getData(AppModel.class)).getExtendInfos().getString("bizType");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean b(App app) {
        String strA = a(app);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return "4".equals(strA) || "2".equals(strA);
    }

    @ActionFilter
    public void beehiveMultilevelSelect(@BindingParam({"title"}) String str, @BindingParam({GoodsSpecificationPreviewActivity.z}) JSONArray jSONArray, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        if (jSONArray == null || jSONArray.size() == 0) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "data list is empty !"));
            return;
        }
        MultiLevelSelectPicker.MultiLevelSelectDialog multiLevelSelectDialog = new MultiLevelSelectPicker.MultiLevelSelectDialog();
        multiLevelSelectDialog.a(jSONArray);
        multiLevelSelectDialog.a(str);
        multiLevelSelectDialog.a(new MultiLevelSelectPicker.MultiLevelSelectDialog.b() { // from class: com.alibaba.triver.basic.picker.PickerBridgeExtension.3
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.alibaba.triver.basic.picker.MultiLevelSelectPicker.MultiLevelSelectDialog.b
            public void a(ArrayList<JSONObject> arrayList) {
                JSONArray jSONArray2 = new JSONArray();
                for (JSONObject jSONObject : arrayList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("name", (Object) jSONObject.getString("name"));
                    jSONArray2.add(jSONObject2);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", (Object) jSONArray2);
                jSONObject3.put("success", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject3);
            }

            @Override // com.alibaba.triver.basic.picker.MultiLevelSelectPicker.MultiLevelSelectDialog.b
            public void a() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
        multiLevelSelectDialog.show(apiContext.getActivity().getFragmentManager(), "beehiveMultilevelSelect");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ActionFilter
    public void beehiveOptionsPicker(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingNode(App.class) App app, @BindingCallback final BridgeCallback bridgeCallback) {
        String[] strArr = null;
        final a aVar = new a();
        String string = jSONObject.getString("title");
        JSONArray jSONArray = jSONObject.getJSONArray("optionsOne");
        String[] strArr2 = new String[jSONArray.size()];
        jSONArray.toArray(strArr2);
        JSONArray jSONArray2 = jSONObject.getJSONArray("optionsTwo");
        int size = jSONArray2 == null ? -1 : jSONArray2.size();
        if (size > 0) {
            strArr = new String[size];
            jSONArray2.toArray(strArr);
        }
        int intValue = jSONObject.getIntValue("selectedOneIndex");
        int intValue2 = jSONObject.getIntValue("selectedTwoIndex");
        String string2 = jSONObject.getString("positiveString");
        String string3 = jSONObject.getString("negativeString");
        final boolean z = strArr == null;
        if (string == null) {
            string = "选择器";
        }
        if (string2 == null) {
            string2 = "确定";
        }
        if (string3 == null) {
            string3 = OptionsPickerHelper.e;
        }
        aVar.a("");
        aVar.b("");
        Activity activity = apiContext.getActivity();
        PickerFragment.b bVar = new PickerFragment.b() { // from class: com.alibaba.triver.basic.picker.PickerBridgeExtension.1
            @Override // com.alibaba.triver.basic.picker.PickerFragment.b
            public void a(boolean z2, String str, int i) {
                if (z2) {
                    aVar.a(str);
                    aVar.a(i);
                } else {
                    aVar.b(str);
                    aVar.b(i);
                }
            }
        };
        PickerFragment.a aVar2 = new PickerFragment.a() { // from class: com.alibaba.triver.basic.picker.PickerBridgeExtension.2
            @Override // com.alibaba.triver.basic.picker.PickerFragment.a
            public void a(boolean z2) {
                if (!z2) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("selectedOneIndex", (Object) "");
                    jSONObject2.put("selectedOneOption", (Object) "");
                    jSONObject2.put("selectedTwoIndex", (Object) "");
                    jSONObject2.put("selectedTwoOption", (Object) "");
                    BridgeCallback bridgeCallback2 = bridgeCallback;
                    if (bridgeCallback2 != null) {
                        bridgeCallback2.sendJSONResponse(jSONObject2);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("selectedOneIndex", aVar.d == -1 ? "" : Integer.valueOf(aVar.d));
                jSONObject3.put("selectedOneOption", aVar.b);
                if (!z) {
                    jSONObject3.put("selectedTwoIndex", aVar.e != -1 ? Integer.valueOf(aVar.e) : "");
                    jSONObject3.put("selectedTwoOption", aVar.c);
                }
                BridgeCallback bridgeCallback3 = bridgeCallback;
                if (bridgeCallback3 != null) {
                    bridgeCallback3.sendJSONResponse(jSONObject3);
                }
            }
        };
        if (activity != null) {
            if (b(app) && TROrangeController.useTbStylePicker() && TRiverUtils.isTaobaoApp() && !a()) {
                OptionSelectDialog optionSelectDialog = new OptionSelectDialog();
                optionSelectDialog.a(string);
                optionSelectDialog.c(string2);
                optionSelectDialog.b(string3);
                optionSelectDialog.a(strArr2);
                optionSelectDialog.b(strArr);
                optionSelectDialog.a(intValue);
                optionSelectDialog.b(intValue2);
                optionSelectDialog.a(z);
                optionSelectDialog.a(bVar);
                optionSelectDialog.a(aVar2);
                optionSelectDialog.show(activity.getFragmentManager(), "Picker");
                return;
            }
            PickerFragment pickerFragment = new PickerFragment();
            pickerFragment.a(string);
            pickerFragment.b(string2);
            pickerFragment.c(string3);
            pickerFragment.a(strArr2);
            pickerFragment.b(strArr);
            pickerFragment.a(intValue);
            pickerFragment.b(intValue2);
            pickerFragment.a(z);
            pickerFragment.a(bVar);
            pickerFragment.a(aVar2);
            pickerFragment.show(activity.getFragmentManager(), "Picker");
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

    private boolean a() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return AssistUtils.BRAND_HW.equals(str.toLowerCase());
    }
}
