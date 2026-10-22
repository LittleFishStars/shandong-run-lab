package com.alibaba.ariver.commonability.device.jsapi.nfc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.commonability.device.jsapi.nfc.service.TinyAppHostApduService;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HCEBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23961a = "HCEBridgeExtension";
    private static final int b = 13000;
    private static final int c = 13001;
    private static final int d = 13002;
    private static final int e = 13003;
    private static final int f = 13005;
    private static final int g = 13006;
    private static final int h = 13007;
    private static final int i = 13008;
    private static final String m = "hCEMessage";
    private ResultReceiver j;
    private ResultReceiver k;
    private CardEmulation l;
    private boolean n = false;
    private BridgeCallback o;

    private BridgeResponse a(Context context) {
        if (!this.n) {
            return new BridgeResponse.Error(h, "请先调用 startHCE");
        }
        this.n = !this.l.removeAidsForService(new ComponentName(context, (Class<?>) TinyAppHostApduService.class), "other");
        return BridgeResponse.SUCCESS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bundle bundle, BridgeCallback bridgeCallback, Page page) {
        try {
            int i2 = bundle.getInt(b.c, 0);
            RVLogger.d(f23961a, "onDeactivateMessage... reason = " + i2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("messageType", (Object) 2);
            jSONObject.put(MediationConstant.KEY_REASON, (Object) Integer.valueOf(i2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            EngineUtils.sendToRender(page.getRender(), m, jSONObject2, null);
        } catch (Exception unused) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(i, AlibcProtocolConstant.UNKNOWN_ERROR));
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getHCEState(@BindingCallback BridgeCallback bridgeCallback) {
        a(a(), bridgeCallback);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return;
        }
        a(rVEnvironmentService.getApplicationContext());
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
    public void sendHCEMessage(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String string;
        this.o = bridgeCallback;
        if (!this.n) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(h, "请先调用 startHCE"));
        }
        if (jSONObject != null) {
            try {
                string = jSONObject.getString("data");
            } catch (Exception e2) {
                RVLogger.e(f23961a, "sendHCEMessage fail", e2);
                this.o.sendBridgeResponse(new BridgeResponse.Error(i, AlibcProtocolConstant.UNKNOWN_ERROR));
                return;
            }
        } else {
            string = "";
        }
        RVLogger.d(f23961a, "sendHCEMessage... " + string);
        byte[] bArrA = a.a(string);
        if (bArrA == null) {
            this.o.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        }
        if (this.k == null) {
            this.o.sendBridgeResponse(new BridgeResponse.Error(i, AlibcProtocolConstant.UNKNOWN_ERROR));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray(b.b, bArrA);
        this.k.send(10000, bundle);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void startHCE(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        JSONArray jSONArray;
        String str = "other";
        int iA = a();
        this.o = bridgeCallback;
        if (iA != 0) {
            a(iA, bridgeCallback);
            return;
        }
        if (jSONObject != null) {
            try {
                jSONArray = jSONObject.getJSONArray("aidList");
            } catch (Exception unused) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(g, "注册 AID 失败"));
                return;
            }
        } else {
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.size() <= 0) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(e, "AID 列表参数格式错误"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        String appId = apiContext.getAppId();
        String string = CommonUtils.getString(jSONObject, "category");
        if (TextUtils.equals(string, "other") || TextUtils.equals(string, "payment")) {
            str = string;
        }
        ComponentName componentName = new ComponentName(apiContext.getActivity(), (Class<?>) TinyAppHostApduService.class);
        CardEmulation cardEmulation = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(apiContext.getActivity()));
        this.l = cardEmulation;
        this.n = cardEmulation.registerAidsForService(componentName, str, arrayList);
        Intent intent = new Intent(apiContext.getActivity(), (Class<?>) TinyAppHostApduService.class);
        intent.putExtra(b.f23963a, a(page));
        intent.putExtra(b.f, appId);
        intent.putExtra("key_time_limit", 10000);
        intent.putStringArrayListExtra(b.d, arrayList);
        apiContext.getActivity().startService(intent);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse stopHCE(@BindingApiContext ApiContext apiContext) {
        return a(apiContext.getActivity());
    }

    private void a(int i2, BridgeCallback bridgeCallback) {
        if (i2 == 1) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(b, "当前设备不支持 NFC"));
            return;
        }
        if (i2 == 2) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(d, "当前设备支持 NFC，但不支持HCE"));
        } else if (i2 == 3) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(c, "当前设备支持 NFC，但系统NFC开关未开启"));
        } else if (i2 == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    private int a() {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        boolean zB = a.b(applicationContext);
        boolean zA = a.a(applicationContext);
        boolean zC = a.c(applicationContext);
        RVLogger.d(f23961a, "getHCEState... isNfcFeature = " + zB + " isNfcEnable = " + zC + " isSystemFeatureHCE = " + zA);
        if (!zB) {
            return 1;
        }
        if (zA) {
            return !zC ? 3 : 0;
        }
        return 2;
    }

    private ResultReceiver a(final Page page) {
        if (this.j == null) {
            this.j = new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.alibaba.ariver.commonability.device.jsapi.nfc.HCEBridgeExtension.1
                @Override // android.os.ResultReceiver
                public void onReceiveResult(int i2, Bundle bundle) {
                    RVLogger.d(HCEBridgeExtension.f23961a, "onReceiveResult... resultCode = " + i2);
                    if (i2 == 10000) {
                        HCEBridgeExtension hCEBridgeExtension = HCEBridgeExtension.this;
                        hCEBridgeExtension.a(bundle, hCEBridgeExtension.o, page);
                        return;
                    }
                    if (i2 == 10002) {
                        HCEBridgeExtension hCEBridgeExtension2 = HCEBridgeExtension.this;
                        hCEBridgeExtension2.b(bundle, hCEBridgeExtension2.o, page);
                        return;
                    }
                    if (i2 == HCEBridgeExtension.f) {
                        HCEBridgeExtension.this.o.sendBridgeResponse(new BridgeResponse.Error(HCEBridgeExtension.f, "返回的指令不合法"));
                        return;
                    }
                    if (i2 != 10019) {
                        if (i2 == 10020) {
                            HCEBridgeExtension.this.k = null;
                            RVLogger.d(HCEBridgeExtension.f23961a, "onReceiveResult... service destroy");
                            return;
                        }
                        return;
                    }
                    bundle.setClassLoader(getClass().getClassLoader());
                    HCEBridgeExtension.this.k = (ResultReceiver) bundle.getParcelable(b.f23963a);
                    if (!HCEBridgeExtension.this.n || HCEBridgeExtension.this.k == null) {
                        HCEBridgeExtension.this.o.sendBridgeResponse(new BridgeResponse.Error(HCEBridgeExtension.g, "注册 AID 失败"));
                    } else {
                        RVLogger.d(HCEBridgeExtension.f23961a, "onReceiveResult... service send receiver connected!!");
                        HCEBridgeExtension.this.o.sendBridgeResponse(BridgeResponse.SUCCESS);
                    }
                }
            };
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle, BridgeCallback bridgeCallback, Page page) {
        try {
            byte[] byteArray = bundle.getByteArray(b.b);
            if (byteArray != null && byteArray.length > 0) {
                String strA = a.a(byteArray);
                RVLogger.d(f23961a, "onApduMessage... " + strA);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("messageType", (Object) 1);
                jSONObject.put("data", (Object) strA);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                EngineUtils.sendToRender(page.getRender(), m, jSONObject2, null);
                return;
            }
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(f, "返回的指令不合法"));
        } catch (Exception unused) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(i, AlibcProtocolConstant.UNKNOWN_ERROR));
        }
    }
}
