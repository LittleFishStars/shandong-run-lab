package com.efs.sdk.h5pagesdk;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class H5ConfigMananger {
    private EfsReporter b;
    private Context mContext;
    private final String TAG = "H5ConfigMananger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29624a = 0;
    private int c = 0;
    private boolean d = false;

    public H5ConfigMananger(Context context, EfsReporter efsReporter) {
        this.mContext = context;
        this.b = efsReporter;
        efsReporter.getAllSdkConfig(new String[]{"apm_native_h5perf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.h5pagesdk.H5ConfigMananger.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                try {
                    Object obj = map.get("apm_native_h5perf_sampling_rate");
                    if (obj != null) {
                        H5ConfigMananger.this.c = Integer.parseInt(obj.toString());
                        H5ConfigMananger h5ConfigMananger = H5ConfigMananger.this;
                        h5ConfigMananger.d = H5ConfigMananger.a(h5ConfigMananger.c);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public String generateLaunchOptions() {
        if (!this.d && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            if (!H5Manager.isDebug) {
                return "";
            }
            Log.e("H5ConfigMananger", "采样未命中，并且不处于集成测试模式");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sample", this.c);
            if (this.d) {
                jSONObject.put("sampleResult", "Y");
            } else {
                jSONObject.put("sampleResult", "N");
            }
            Context context = this.mContext;
            if (context != null) {
                jSONObject.put("appName", context.getApplicationInfo().packageName);
            }
            jSONObject.put("bridgeVersion", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean isH5TracerEnable() {
        return this.d;
    }

    public void sendData(final String str) {
        if (this.d || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            a.execute(new Runnable() { // from class: com.efs.sdk.h5pagesdk.H5ConfigMananger.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (H5ConfigMananger.this.b == null) {
                        return;
                    }
                    EfsJSONLog efsJSONLog = new EfsJSONLog("nativeh5perf");
                    efsJSONLog.put("wk_native_h5log", str);
                    H5ConfigMananger.this.b.send(efsJSONLog);
                }
            });
        }
    }

    public static /* synthetic */ boolean a(int i) {
        if (SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i != 0) {
            return i == 100 || new Random().nextInt(100) <= i;
        }
        return false;
    }
}
