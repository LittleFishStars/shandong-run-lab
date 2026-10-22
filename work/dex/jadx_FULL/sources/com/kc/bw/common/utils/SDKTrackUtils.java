package com.kc.bw.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.kc.bw.common.bean.SdkTrackEventBean;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SDKTrackUtils {
    public static final String TAG = dexg.dexa("UsbdlVujmt");
    public static volatile SDKTrackUtils sdkTrackUtils;

    public static /* synthetic */ void dexa(String str, SdkTrackEventBean sdkTrackEventBean, Context context) {
        if (ConstantInfo.sdkTrackEventMap.containsKey(str)) {
            return;
        }
        ConstantInfo.sdkTrackEventMap.put(str, sdkTrackEventBean);
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexg.dexa("nn`tq`l3"), GsonUtils.getInstance().toJson(ConstantInfo.sdkTrackEventMap));
    }

    public static SDKTrackUtils getInstance() {
        if (sdkTrackUtils == null) {
            synchronized (SDKTrackUtils.class) {
                try {
                    if (sdkTrackUtils == null) {
                        sdkTrackUtils = new SDKTrackUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sdkTrackUtils;
    }

    private void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 999961, dexg.dexa("睭東轔殙ꆎ辯鰼懚楲鵦"), str + (th != null ? th.toString() : ""));
    }

    public void addSdkTrackReportBean(final Context context, final String str, final SdkTrackEventBean sdkTrackEventBean, String str2) {
        synchronized (this) {
            if (ConstantInfo.sdkTrackEventMap == null) {
                ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
            }
            ThreadUtils.runOnThreadPool(new Runnable(str, sdkTrackEventBean, context) { // from class: com.kc.bw.common.utils.SDKTrackUtils$$ExternalSyntheticLambda0
                public final String f$0;
                public final SdkTrackEventBean f$1;
                public final Context f$2;

                {
                    this.f$0 = str;
                    this.f$1 = sdkTrackEventBean;
                    this.f$2 = context;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    SDKTrackUtils.dexa(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    public void addTrackBean(Context context, String str, SdkTrackEventBean.EventBean eventBean, String str2) {
        synchronized (this) {
            if (ConstantInfo.sdkTrackEventMap == null) {
                ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
            }
            if (ConstantInfo.sdkTrackEventMap.containsKey(str)) {
                ConstantInfo.sdkTrackEventMap.get(str).addEvent(eventBean);
                SharedPreferencesHelper.getInstance(context).savePreferencesString(dexg.dexa("nn`tq`l3"), GsonUtils.getInstance().toJson(ConstantInfo.sdkTrackEventMap));
            } else {
                DebugLog.W(TAG, dexg.dexa("\\beeUsbdlCfbo!sfrvftuJe!opu!fyjut^!�") + str);
            }
        }
    }

    public void cleanSdkTrackReportBean(Context context) {
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexg.dexa("nn`tq`l3"), "");
    }

    public ConcurrentHashMap<String, SdkTrackEventBean> getSdkTrackReportBeanMap(Context context) {
        try {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexg.dexa("nn`tq`l3"), "");
            if (!TextUtils.isEmpty(preferencesString)) {
                return (ConcurrentHashMap) GsonUtils.getInstance().fromJson(preferencesString, new TypeToken<ConcurrentHashMap<String, SdkTrackEventBean>>(this) { // from class: com.kc.bw.common.utils.SDKTrackUtils.1
                    public final SDKTrackUtils this$0;

                    {
                        this.this$0 = this;
                    }
                });
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("mpdbm!usbdlJogp!sfbe!gbjmfe-") + th);
            reportErrorInfo(context, dexg.dexa("睭東栌胺疱环鰼搗楲鵦)hfuTelUsbdlSfqpsuCfboNbq*-"), th);
        }
        return null;
    }

    public boolean isRecordedEvent(String str, SdkTrackEventBean.TrackEventEnum trackEventEnum) {
        List<SdkTrackEventBean.EventBean> track_event;
        if (!ConstantInfo.sdkTrackEventMap.containsKey(str) || (track_event = ConstantInfo.sdkTrackEventMap.get(str).getTrack_event()) == null || track_event.isEmpty()) {
            return false;
        }
        Iterator<SdkTrackEventBean.EventBean> it = track_event.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == trackEventEnum) {
                return true;
            }
        }
        return false;
    }
}
