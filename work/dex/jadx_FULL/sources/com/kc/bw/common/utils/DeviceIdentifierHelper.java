package com.kc.bw.common.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bun.miitmdid.core.ErrorCode;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.kc.bw.adIdUtils.utils.IdUtils;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DeviceIdentifierHelper {
    public static final int TIME_OUT = 200;
    public static String imei;
    public static final String TAG = dexg.dexa("XN`JefoujgjfsIfmqfs");
    public static final String OAID_FAIL_CERT_ERROR = dexg.dexa("dfsu.fssps");
    public static final String OAID_FAIL_CONFIGFILE_ERROR = dexg.dexa("dpogjh.fssps");
    public static final String OAID_FAIL_MANUFACTURER_NOSUPPORT = dexg.dexa("nbovgbduvsfs.opu.tvqqpsu");
    public static final String OAID_FAIL_SDK_CALL_ERROR = dexg.dexa("tel.dbmm.fssps");
    public static final String OAID_DEFAULT_LIMITED = dexg.dexa("jt.mjnjufe");
    public static final String OAID_DEFAULT_DEVICE_NOT_SUPPORT = dexg.dexa("efwjdf.opu.tvqqpsu");
    public static final String OAID_DEFAULT_EMPTY = dexg.dexa("jt.fnquz");
    public static final String OAID_DEFAULT_ID_SUPPLIER_IS_NULL = dexg.dexa("JeTvqqmjfs.jt.ovmm");
    public static final String OAID_DEFAULT_UNKNOWN = dexg.dexa("volopxo");
    public static final String TARGET_CLASS_NAME = dexg.dexa("dpn/cvo/njjuneje/dpsf/NejeTelIfmqfs");
    public static String oaid = "";
    public static String msaOaid = "";
    public static boolean isCollecting = false;
    public static String[] ERROR_LIST = {dexg.dexa("dfsu.fssps"), dexg.dexa("dpogjh.fssps"), dexg.dexa("nbovgbduvsfs.opu.tvqqpsu"), dexg.dexa("tel.dbmm.fssps"), dexg.dexa("jt.mjnjufe"), dexg.dexa("efwjdf.opu.tvqqpsu"), dexg.dexa("jt.fnquz"), dexg.dexa("JeTvqqmjfs.jt.ovmm"), dexg.dexa("volopxo")};

    public static void asyncCollectOAIDByMM(Context context) {
        DebugLog.oaid_all(dexg.dexa("btzod!dpmmfdujpo!cz!nn"));
        if (isCollecting) {
            DebugLog.oaid_all(dexg.dexa("dpmmfdujoh!cz!nn"));
        } else {
            isCollecting = true;
            ThreadUtils.runOnThreadPool(new Runnable(context) { // from class: com.kc.bw.common.utils.DeviceIdentifierHelper.2
                public final Context val$context;

                {
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String oaid2 = IdUtils.getOaid(this.val$context);
                    DebugLog.oaid_all(dexg.dexa("ep!dpmmfdujpo!foe!cz!nn!") + DeviceIdentifierHelper.convertOAID(oaid2));
                    if (!TextUtils.isEmpty(oaid2)) {
                        SharedPreferencesHelper.getInstance(this.val$context).savePreferencesString(dexg.dexa("nn`tq`l6"), oaid2, true);
                    }
                    DeviceIdentifierHelper.isCollecting = false;
                }
            });
        }
    }

    public static boolean checkerOaid() {
        return (TextUtils.isEmpty(oaid) || Arrays.asList(ERROR_LIST).contains(oaid)) ? false : true;
    }

    public static String collectOAIDByMSA(Context context) {
        String strDexa;
        DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb"));
        try {
            if (!isMSAAvailable(TARGET_CLASS_NAME)) {
                DebugLog.oaid_w(dexg.dexa("ntb!mjcsbsz!opu!fyjtu"));
                return "";
            }
            DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb!wfstjpo!") + MdidSdkHelper.SDK_VERSION_CODE);
            try {
                long elapsedRealTime = Utils.getElapsedRealTime();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                switch (MdidSdkHelper.InitSdk(context, true, new IIdentifierListener(elapsedRealTime, countDownLatch) { // from class: com.kc.bw.common.utils.DeviceIdentifierHelper.1
                    public final CountDownLatch val$latch;
                    public final long val$startTime;

                    {
                        this.val$startTime = elapsedRealTime;
                        this.val$latch = countDownLatch;
                    }

                    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                    public void OnSupport(boolean z, IdSupplier idSupplier) {
                        String str;
                        DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb!PoTvqqpsu)pme*"));
                        if (z && idSupplier != null && idSupplier.isSupported()) {
                            String oaid2 = idSupplier.getOAID();
                            DeviceIdentifierHelper.msaOaid = oaid2;
                            if (TextUtils.isEmpty(oaid2)) {
                                DeviceIdentifierHelper.msaOaid = dexg.dexa("jt.fnquz");
                                str = "dpmmfdujpo!cz!ntb!gbjm-wbmvf!jt!fnquz";
                            } else {
                                DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb!tvddftt-dptu>") + Utils.getCostTime(this.val$startTime) + dexg.dexa(c49.f40900a) + DeviceIdentifierHelper.convertOAID(DeviceIdentifierHelper.msaOaid));
                            }
                            this.val$latch.countDown();
                        }
                        if (idSupplier == null) {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("JeTvqqmjfs.jt.ovmm");
                            str = "dpmmfdujpo!cz!ntb!gbjm-JeTvqqmjfs!jt!ovmm";
                        } else if (z && idSupplier.isSupported()) {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("volopxo");
                            str = "dpmmfdujpo!cz!ntb!gbjm-volopxo";
                        } else {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("efwjdf.opu.tvqqpsu");
                            str = "dpmmfdujpo!cz!ntb!gbjm-efwjdf!opu!tvqqpsu";
                        }
                        DebugLog.oaid_w(dexg.dexa(str));
                        this.val$latch.countDown();
                    }

                    public void onSupport(IdSupplier idSupplier) {
                        String str;
                        DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb!PoTvqqpsu)ofx*"));
                        if (idSupplier != null && idSupplier.isSupported() && !idSupplier.isLimited()) {
                            String oaid2 = idSupplier.getOAID();
                            DeviceIdentifierHelper.msaOaid = oaid2;
                            if (TextUtils.isEmpty(oaid2)) {
                                DeviceIdentifierHelper.msaOaid = dexg.dexa("jt.fnquz");
                                str = "dpmmfdujpo!cz!ntb!gbjm-wbmvf!jt!fnquz";
                            } else {
                                DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb!tvddftt-dptu>") + Utils.getCostTime(this.val$startTime) + dexg.dexa(c49.f40900a) + DeviceIdentifierHelper.convertOAID(DeviceIdentifierHelper.msaOaid));
                            }
                            this.val$latch.countDown();
                        }
                        if (idSupplier == null) {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("JeTvqqmjfs.jt.ovmm");
                            str = "dpmmfdujpo!cz!ntb!gbjm-JeTvqqmjfs!jt!ovmm";
                        } else if (!idSupplier.isSupported()) {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("efwjdf.opu.tvqqpsu");
                            str = "dpmmfdujpo!cz!ntb!gbjm-efwjdf!opu!tvqqpsu";
                        } else if (idSupplier.isLimited()) {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("jt.mjnjufe");
                            str = "dpmmfdujpo!cz!ntb!gbjm-jt!mjnjufe";
                        } else {
                            DeviceIdentifierHelper.msaOaid = dexg.dexa("volopxo");
                            str = "dpmmfdujpo!cz!ntb!gbjm-volopxo";
                        }
                        DebugLog.oaid_w(dexg.dexa(str));
                        this.val$latch.countDown();
                    }
                })) {
                    case ErrorCode.INIT_ERROR_BEGIN /* 1008610 */:
                        strDexa = dexg.dexa("dpmmfdujpo!cz!ntb!sftvmu!pl");
                        DebugLog.oaid_all(strDexa);
                        break;
                    case ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT /* 1008611 */:
                        DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!nbovgbduvsfs!opu!tvqqpsu"));
                        msaOaid = OAID_FAIL_MANUFACTURER_NOSUPPORT;
                        countDownLatch.countDown();
                        break;
                    case ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT /* 1008612 */:
                        DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!efwjdf!opu!tvqqpsu"));
                        msaOaid = OAID_DEFAULT_DEVICE_NOT_SUPPORT;
                        countDownLatch.countDown();
                        break;
                    case ErrorCode.INIT_ERROR_LOAD_CONFIGFILE /* 1008613 */:
                        DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!dpogjh!gjmf!fssps"));
                        msaOaid = OAID_FAIL_CONFIGFILE_ERROR;
                        countDownLatch.countDown();
                        break;
                    case ErrorCode.INIT_ERROR_RESULT_DELAY /* 1008614 */:
                        strDexa = dexg.dexa("dpmmfdujpo!cz!ntb!sftvmu!efmbz");
                        DebugLog.oaid_all(strDexa);
                        break;
                    case ErrorCode.INIT_HELPER_CALL_ERROR /* 1008615 */:
                        DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!dbmm!fssps"));
                        msaOaid = OAID_FAIL_SDK_CALL_ERROR;
                        countDownLatch.countDown();
                        break;
                    case 1008616:
                        DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!dfsu!fssps"));
                        msaOaid = OAID_FAIL_CERT_ERROR;
                        countDownLatch.countDown();
                        break;
                }
                try {
                    countDownLatch.await(200L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!gbjm!") + th);
                }
            } catch (Throwable th2) {
                DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!gbjm!") + th2.getMessage());
            }
            return msaOaid;
        } catch (Throwable th3) {
            DebugLog.oaid_w(dexg.dexa("dpmmfdujpo!cz!ntb!wfstjpo!") + th3);
        }
    }

    public static String convertOAID(String str) {
        return (str == null || str.length() <= 10) ? str : str.substring(0, 10);
    }

    public static String getImei(Context context) {
        ThreadUtils.isUIThread(dexg.dexa("XN`JefoujgjfsIfmqfs.hfuJnfj"));
        if (!TextUtils.isEmpty(imei)) {
            DebugLog.W(TAG, dexg.dexa("JNFJ!JT!WBMJE!") + imei);
            return imei;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(dexg.dexa("qipof"));
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
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfu!jnfj!gbjm-") + th);
            try {
                String deviceId = telephonyManager.getDeviceId();
                imei = deviceId;
                return deviceId;
            } catch (Throwable th2) {
                DebugLog.W(TAG, dexg.dexa("hfu!jnfj!gbjm-") + th2);
                return "";
            }
        }
    }

    public static String getOaid(Context context) {
        String str;
        String strDexa;
        if (checkerOaid()) {
            strDexa = dexg.dexa("qbtt");
        } else {
            try {
                asyncCollectOAIDByMM(context);
                oaid = collectOAIDByMSA(context);
            } catch (Throwable th) {
                DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!pje!gbjm!") + th);
            }
            if (checkerOaid()) {
                str = "dpmmfdujpo!cz!ntb!tvddftt";
            } else {
                DebugLog.oaid_all(dexg.dexa("dpmmfdujpo!cz!ntb!gbjm-vtf!nn!diboofm"));
                String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexg.dexa("nn`tq`l6"), true);
                if (TextUtils.isEmpty(preferencesString)) {
                    str = "nn!diboofm!jowbmje";
                } else {
                    oaid = preferencesString;
                }
                strDexa = dexg.dexa("gjobm!pje!wbmvf!") + convertOAID(oaid);
            }
            DebugLog.oaid_all(dexg.dexa(str));
            strDexa = dexg.dexa("gjobm!pje!wbmvf!") + convertOAID(oaid);
        }
        DebugLog.oaid_all(strDexa);
        return oaid;
    }

    public static boolean isMSAAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
