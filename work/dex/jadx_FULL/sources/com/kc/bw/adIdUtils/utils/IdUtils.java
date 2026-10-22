package com.kc.bw.adIdUtils.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kc.bw.adIdUtils.cnadid.CNAdidHelper;
import com.kc.bw.adIdUtils.oaid.DeviceID;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class IdUtils {
    public static final String TAG = dexg.dexa("XN`") + IdUtils.class.getSimpleName();
    public static String miitOaid = "";
    public static String cnAdId = "";
    public static String imei = "";

    public static String getCnAdid(Context context) {
        try {
            if (TextUtils.isEmpty(cnAdId)) {
                cnAdId = CNAdidHelper.getInstance().readCNAdid(context);
                OAIDLog.print(dexg.dexa("hfuDoBeje.....") + cnAdId);
                if (TextUtils.isEmpty(cnAdId)) {
                    cnAdId = "";
                }
            }
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("hfuDoBeje!fssps;") + th);
        }
        return cnAdId;
    }

    public static String getIMEI(Context context) {
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(dexg.dexa("qipof"));
        try {
            try {
                Method method = telephonyManager.getClass().getMethod(dexg.dexa("hfuJnfj"), Integer.TYPE);
                String str = (String) method.invoke(telephonyManager, 0);
                String str2 = (String) method.invoke(telephonyManager, 1);
                if (TextUtils.isEmpty(str2)) {
                    imei = str;
                    return str;
                }
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                if (str.compareTo(str2) <= 0) {
                    imei = str;
                } else {
                    imei = str2;
                }
                return imei;
            } catch (Throwable unused) {
                return "";
            }
        } catch (Throwable unused2) {
            String deviceId = telephonyManager.getDeviceId();
            imei = deviceId;
            return deviceId;
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(miitOaid)) {
            return miitOaid;
        }
        try {
            if (TextUtils.isEmpty(miitOaid)) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                DeviceID.getOAID(context, new IGetter(countDownLatch) { // from class: com.kc.bw.adIdUtils.utils.IdUtils.1
                    public final CountDownLatch val$latch;

                    {
                        this.val$latch = countDownLatch;
                    }

                    @Override // com.kc.bw.adIdUtils.oaid.IGetter
                    public void onOAIDGetComplete(String str) {
                        OAIDLog.print(dexg.dexa("PBJEꈈ꜇母牑期鱄)poPBJEHfuDpnqmfuf*!") + str);
                        String unused = IdUtils.miitOaid = str;
                        this.val$latch.countDown();
                    }

                    @Override // com.kc.bw.adIdUtils.oaid.IGetter
                    public void onOAIDGetError(Exception exc) {
                        OAIDLog.print(dexg.dexa("PBJEꈈ꜇楲鵦期鱄)poPBJEHfuFssps*!") + exc);
                        this.val$latch.countDown();
                    }
                });
                try {
                    countDownLatch.await(200L, TimeUnit.MILLISECONDS);
                    OAIDLog.print(dexg.dexa("ꈈ꜇變濆311nt扱睠-牗遆ꈈ꜇輔瞠"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return miitOaid;
        } catch (Throwable unused) {
            return "";
        }
    }
}
