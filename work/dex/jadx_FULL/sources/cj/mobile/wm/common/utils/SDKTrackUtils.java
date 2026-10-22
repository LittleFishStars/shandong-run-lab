package cj.mobile.wm.common.utils;

import android.content.Context;
import android.text.TextUtils;
import cj.mobile.wm.common.bean.SdkTrackEventBean;
import cj.mobile.wm.common.utils.SDKTrackUtils;
import cj.mobile.wm.dexc;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SDKTrackUtils {
    public static final String TAG = dexc.dexa("UsbdlVujmt");
    public static volatile SDKTrackUtils sdkTrackUtils;

    public static /* synthetic */ void dexa(String str, SdkTrackEventBean sdkTrackEventBean, Context context) {
        if (ConstantInfo.sdkTrackEventMap.containsKey(str)) {
            return;
        }
        ConstantInfo.sdkTrackEventMap.put(str, sdkTrackEventBean);
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l3"), GsonUtils.getInstance().toJson(ConstantInfo.sdkTrackEventMap));
    }

    public static SDKTrackUtils getInstance() {
        if (sdkTrackUtils == null) {
            synchronized (SDKTrackUtils.class) {
                if (sdkTrackUtils == null) {
                    sdkTrackUtils = new SDKTrackUtils();
                }
            }
        }
        return sdkTrackUtils;
    }

    private void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 999961, dexc.dexa("睭東轔殙ꆎ辯鰼懚楲鵦"), str + (th != null ? th.toString() : ""));
    }

    public synchronized void addSdkTrackReportBean(final Context context, final String str, final SdkTrackEventBean sdkTrackEventBean, String str2) {
        if (ConstantInfo.sdkTrackEventMap == null) {
            ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
        }
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.gr7
            @Override // java.lang.Runnable
            public final void run() {
                SDKTrackUtils.dexa(str, sdkTrackEventBean, context);
            }
        });
    }

    public synchronized void addTrackBean(Context context, String str, SdkTrackEventBean.EventBean eventBean, String str2) {
        if (ConstantInfo.sdkTrackEventMap == null) {
            ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
        }
        if (ConstantInfo.sdkTrackEventMap.containsKey(str)) {
            ConstantInfo.sdkTrackEventMap.get(str).addEvent(eventBean);
            SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l3"), GsonUtils.getInstance().toJson(ConstantInfo.sdkTrackEventMap));
        } else {
            DebugLog.W(TAG, dexc.dexa("\\beeUsbdlCfbo!sfrvftuJe!opu!fyjut^!�") + str);
        }
    }

    public void cleanSdkTrackReportBean(Context context) {
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l3"), "");
    }

    public ConcurrentHashMap<String, SdkTrackEventBean> getSdkTrackReportBeanMap(Context context) {
        try {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l3"), "");
            if (!TextUtils.isEmpty(preferencesString)) {
                return (ConcurrentHashMap) GsonUtils.getInstance().fromJson(preferencesString, new TypeToken<ConcurrentHashMap<String, SdkTrackEventBean>>() { // from class: cj.mobile.wm.common.utils.SDKTrackUtils.1
                });
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexc.dexa("mpdbm!usbdlJogp!sfbe!gbjmfe-") + th);
            reportErrorInfo(context, dexc.dexa("睭東栌胺疱环鰼搗楲鵦)hfuTelUsbdlSfqpsuCfboNbq*-"), th);
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
