package com.kwad.sdk.liteapi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.kwad.sdk.api.a.b;
import com.kwad.sdk.liteapi.oaid.OADIDSDKHelper;
import com.kwad.sdk.liteapi.oaid.helpers.ASUSDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.HONORDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.HWDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.LenovoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.MeizuDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.NubiaDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.OppoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.SamsungDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.VivoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.XiaomiDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.ZTEDeviceIDHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteOAIDHelper {
    private static final String KEY_OAID = "kasd_oaid_key";
    private static final String TAG = "OAIDHelper";
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    public static String getAppOAID(Context context) {
        if (LiteSDKDeviceController.useOaidDisable() && !TextUtils.isEmpty(LiteSDKDeviceController.getDevOaid())) {
            return LiteSDKDeviceController.getDevOaid();
        }
        if (TextUtils.isEmpty(sOAID) && !LiteSDKDeviceController.useOaidDisable()) {
            initAsync(context);
            return sOAID;
        }
        return sOAID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:61:0x00d3  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void getOAIDNormal(Context context) {
        byte b;
        if (!TextUtils.isEmpty(sOAID) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (!upperCase.equals("LENOVO")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case -1712043046:
                    if (!upperCase.equals("SAMSUNG")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case -1706170181:
                    if (!upperCase.equals("XIAOMI")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -1134767290:
                    if (!upperCase.equals("BLACKSHARK")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case -602397472:
                    if (!upperCase.equals("ONEPLUS")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 89163:
                    if (!upperCase.equals("ZTE")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 2018896:
                    if (!upperCase.equals("ASUS")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 2432928:
                    if (!upperCase.equals("OPPO")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 2555124:
                    if (!upperCase.equals("SSUI")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.q;
                    }
                    break;
                case 2634924:
                    if (!upperCase.equals("VIVO")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 68924490:
                    if (!upperCase.equals("HONOR")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 73239724:
                    if (!upperCase.equals("MEIZU")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 74632627:
                    if (!upperCase.equals("NUBIA")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 630905871:
                    if (!upperCase.equals("MOTOLORA")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 976565563:
                    if (!upperCase.equals("FERRMEOS")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.p;
                    }
                    break;
                case 2141820391:
                    if (!upperCase.equals("HUAWEI")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    sOAID = new HWDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 1:
                    sOAID = new HONORDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    sOAID = new XiaomiDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    sOAID = new OppoDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 6:
                    sOAID = new VivoDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 7:
                case 8:
                    sOAID = new LenovoDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 9:
                    sOAID = new MeizuDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 10:
                    sOAID = new NubiaDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 11:
                    sOAID = new SamsungDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 12:
                    sOAID = new ASUSDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 13:
                case 14:
                case 15:
                    sOAID = new ZTEDeviceIDHelper(applicationContext).getOAID();
                    break;
            }
            LiteApiLogger.i(TAG, "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
        } catch (Throwable th) {
            LiteApiLogger.printStackTraceOnly(th);
        }
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new b() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                if (TextUtils.isEmpty(LiteOAIDHelper.sOAID)) {
                    LiteOAIDHelper.getOAIDNormal(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.1
                            @Override // com.kwad.sdk.liteapi.oaid.OADIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused = LiteOAIDHelper.sOAID = str;
                            }
                        });
                    } else if (LiteOADIDSDKHelper25.isSupport()) {
                        LiteOADIDSDKHelper25.getOAId(context, new LiteOADIDSDKHelper25.a() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.2
                            @Override // com.kwad.sdk.liteapi.LiteOADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused = LiteOAIDHelper.sOAID = str;
                            }
                        });
                    }
                    LiteOAIDHelper.sInitIng.set(false);
                }
            }
        });
    }

    public static String obtainCurrent() {
        return sOAID;
    }
}
