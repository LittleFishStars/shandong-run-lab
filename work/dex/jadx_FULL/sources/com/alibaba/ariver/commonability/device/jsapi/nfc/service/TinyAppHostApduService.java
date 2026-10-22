package com.alibaba.ariver.commonability.device.jsapi.nfc.service;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.ali.auth.third.core.model.KernelMessageConstants;
import com.alibaba.ariver.commonability.device.jsapi.nfc.b;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@TargetApi(19)
public class TinyAppHostApduService extends HostApduService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23964a = "TinyApp_HostApduService";
    private String b = null;
    private ResultReceiver c;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        RVLogger.d(f23964a, "service onCreate");
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i) {
        String str;
        if (i == 0) {
            str = "DEACTIVATION_LINK_LOSS";
        } else {
            str = i == 1 ? "DEACTIVATION_DESELECTED" : "DEACTIVATION_UNKNOWN";
        }
        RVLogger.debug(f23964a, "onDeactivated, reason = " + str);
        if (this.c != null) {
            Bundle bundle = new Bundle();
            bundle.putString(b.f, this.b);
            bundle.putInt(b.e, 41);
            bundle.putInt(b.c, i);
            this.c.send(10002, bundle);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        RVLogger.d(f23964a, "service onDestroy");
        ResultReceiver resultReceiver = this.c;
        if (resultReceiver != null) {
            resultReceiver.send(KernelMessageConstants.PARAM_ERROR, null);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        RVLogger.d(f23964a, "service onStartCommand");
        if (intent == null) {
            return super.onStartCommand(null, i, i2);
        }
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(b.f23963a);
        this.c = resultReceiver;
        if (resultReceiver != null) {
            ResultReceiver resultReceiver2 = new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.alibaba.ariver.commonability.device.jsapi.nfc.service.TinyAppHostApduService.1
                @Override // android.os.ResultReceiver
                public void onReceiveResult(int i3, Bundle bundle) {
                    RVLogger.d(TinyAppHostApduService.f23964a, "onReceive apduCommand");
                    try {
                        TinyAppHostApduService.this.sendResponseApdu(bundle.getByteArray(b.b));
                    } catch (Exception e) {
                        RVLogger.d(TinyAppHostApduService.f23964a, "onReceive has exception" + e);
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putParcelable(b.f23963a, resultReceiver2);
            this.c.send(10019, bundle);
            RVLogger.d(f23964a, "service onStartCommand, get receiveReceiver success");
        }
        this.b = intent.getStringExtra(b.f);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(b.d);
        int intExtra = intent.getIntExtra("key_time_limit", 1500);
        int i3 = intExtra >= 1500 ? intExtra : 1500;
        if (i3 > 60000) {
            i3 = 60000;
        }
        RVLogger.d(f23964a, "aid_list = " + JSON.toJSONString(stringArrayListExtra) + " appId = " + this.b + " timeLimit = " + i3);
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        if (this.c == null) {
            RVLogger.e(f23964a, "processCommandApdu... resultReceiver is null");
            return null;
        }
        if (bArr == null) {
            RVLogger.e(f23964a, "processCommandApdu... commandApdu is null");
            this.c.send(13005, bundle);
            return null;
        }
        RVLogger.e(f23964a, "processCommandApdu...");
        Bundle bundle2 = new Bundle();
        bundle2.putByteArray(b.b, bArr);
        this.c.send(10000, bundle2);
        return null;
    }
}
