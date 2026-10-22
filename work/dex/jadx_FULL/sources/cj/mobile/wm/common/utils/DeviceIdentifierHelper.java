package cj.mobile.wm.common.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.IdUtils;
import cj.mobile.wm.common.utils.DeviceIdentifierHelper;
import cj.mobile.wm.dexc;
import com.bun.miitmdid.core.ErrorCode;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.zj.adlib.c49;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeviceIdentifierHelper {
    public static final int MAX_QUERY_COUNT = 2;
    public static final int TIME_OUT = 60;
    public static String imei;
    public static final String TAG = dexc.dexa("XN`JefoujgjfsIfmqfs");
    public static final String OAID_FAIL_CERT_ERROR = dexc.dexa("dfsu.fssps");
    public static final String OAID_FAIL_CONFIGFILE_ERROR = dexc.dexa("dpogjh.fssps");
    public static final String OAID_FAIL_MANUFACTURER_NOSUPPORT = dexc.dexa("nbovgbduvsfs.opu.tvqqpsu");
    public static final String OAID_FAIL_SDK_CALL_ERROR = dexc.dexa("tel.dbmm.fssps");
    public static final String OAID_DEFAULT_LIMITED = dexc.dexa("jt.mjnjufe");
    public static final String OAID_DEFAULT_DEVICE_NOT_SUPPORT = dexc.dexa("efwjdf.opu.tvqqpsu");
    public static final String OAID_DEFAULT_EMPTY = dexc.dexa("jt.fnquz");
    public static final String OAID_DEFAULT_ID_SUPPLIER_IS_NULL = dexc.dexa("JeTvqqmjfs.jt.ovmm");
    public static final String OAID_DEFAULT_UNKNOWN = dexc.dexa("volopxo");
    public static final String TARGET_CLASS_NAME = dexc.dexa("dpn/cvo/njjuneje/dpsf/NejeTelIfmqfs");
    public static String resultOAID = "";
    public static String msaOAID = "";
    public static String mmOAID = "";
    public static int msaQueryNum = 0;
    public static boolean mmChannelIsQuerying = false;
    public static boolean msaChannelIsQuerying = false;
    public static List<String> ERROR_LIST = Arrays.asList(dexc.dexa("dfsu.fssps"), dexc.dexa("dpogjh.fssps"), dexc.dexa("nbovgbduvsfs.opu.tvqqpsu"), dexc.dexa("tel.dbmm.fssps"), dexc.dexa("jt.mjnjufe"), dexc.dexa("efwjdf.opu.tvqqpsu"), dexc.dexa("jt.fnquz"), dexc.dexa("JeTvqqmjfs.jt.ovmm"), dexc.dexa("volopxo"));

    public static void asyncQueryOAID(Context context) {
        DebugLog.oaid_all(dexc.dexa("gspn!rvfsz"));
        asyncQueryOAIDByMM(context);
        asyncQueryOAIDByMSA(context);
    }

    public static void asyncQueryOAIDByMM(Context context) {
        if (mmChannelIsQuerying) {
            DebugLog.oaid_all(dexc.dexa("nn!jt!rvfszjoh"));
            return;
        }
        mmChannelIsQuerying = true;
        long elapsedRealTime = Utils.getElapsedRealTime();
        mmOAID = IdUtils.getOaid(context);
        mmChannelIsQuerying = false;
        DebugLog.oaid_all(dexc.dexa("nn!rvfsz!epof!") + convertOAID(mmOAID) + Utils.getCostTime(elapsedRealTime));
        if (TextUtils.isEmpty(mmOAID)) {
            return;
        }
        if (!isValidOaid(msaOAID)) {
            updateResultOAID(mmOAID, dexc.dexa("nn"));
        }
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l6"), mmOAID, true);
    }

    public static void asyncQueryOAIDByMSA(Context context) {
        try {
            if (!isMSAAvailable(TARGET_CLASS_NAME)) {
                DebugLog.oaid_w(dexc.dexa("ntb!mjcsbsz!opu!fyjtu"));
                return;
            }
            DebugLog.oaid_w(dexc.dexa("ntb!wfstjpo!") + MdidSdkHelper.SDK_VERSION_CODE);
            if (msaChannelIsQuerying) {
                DebugLog.oaid_w(dexc.dexa("ntb!jt!rvfszjoh"));
                return;
            }
            msaQueryNum++;
            DebugLog.oaid_all(dexc.dexa("ntb!ep!rvfsz-ovn>") + msaQueryNum);
            if (msaQueryNum > 2) {
                DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gsfrvfodz!mjnju"));
                return;
            }
            msaChannelIsQuerying = true;
            try {
                final long elapsedRealTime = Utils.getElapsedRealTime();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                switch (MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: cj.mobile.wm.common.utils.DeviceIdentifierHelper.1
                    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                    public void OnSupport(boolean z, IdSupplier idSupplier) {
                        DebugLog.oaid_all(dexc.dexa("ntb!rvfsz!PoTvqqpsu)pme*"));
                        if (z && idSupplier != null && idSupplier.isSupported()) {
                            String oaid = idSupplier.getOAID();
                            DeviceIdentifierHelper.msaOAID = oaid;
                            if (DeviceIdentifierHelper.isValidOaid(oaid)) {
                                DeviceIdentifierHelper.updateResultOAID(DeviceIdentifierHelper.msaOAID, dexc.dexa("ntb.pme"));
                                DebugLog.oaid_all(dexc.dexa("ntb!rvfsz!epof!") + DeviceIdentifierHelper.convertOAID(DeviceIdentifierHelper.msaOAID) + Utils.getCostTime(elapsedRealTime));
                            } else {
                                DeviceIdentifierHelper.msaOAID = dexc.dexa("jt.fnquz");
                                DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-wbmvf!jt!fnquz"));
                            }
                        } else if (idSupplier == null) {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("JeTvqqmjfs.jt.ovmm");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-JeTvqqmjfs!jt!ovmm"));
                        } else if (z && idSupplier.isSupported()) {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("volopxo");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-volopxo"));
                        } else {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("efwjdf.opu.tvqqpsu");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-efwjdf!opu!tvqqpsu"));
                        }
                        countDownLatch.countDown();
                    }

                    public void onSupport(IdSupplier idSupplier) {
                        DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!PoTvqqpsu)ofx*"));
                        if (idSupplier != null && idSupplier.isSupported() && !idSupplier.isLimited()) {
                            String oaid = idSupplier.getOAID();
                            DeviceIdentifierHelper.msaOAID = oaid;
                            if (DeviceIdentifierHelper.isValidOaid(oaid)) {
                                DeviceIdentifierHelper.updateResultOAID(DeviceIdentifierHelper.msaOAID, dexc.dexa("ntb.ofx"));
                                DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!epof!") + DeviceIdentifierHelper.convertOAID(DeviceIdentifierHelper.msaOAID) + Utils.getCostTime(elapsedRealTime));
                            } else {
                                DeviceIdentifierHelper.msaOAID = dexc.dexa("jt.fnquz");
                                DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-wbmvf!jt!fnquz"));
                            }
                        } else if (idSupplier == null) {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("JeTvqqmjfs.jt.ovmm");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-JeTvqqmjfs!jt!ovmm"));
                        } else if (!idSupplier.isSupported()) {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("efwjdf.opu.tvqqpsu");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-efwjdf!opu!tvqqpsu"));
                        } else if (idSupplier.isLimited()) {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("jt.mjnjufe");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-jt!mjnjufe"));
                        } else {
                            DeviceIdentifierHelper.msaOAID = dexc.dexa("volopxo");
                            DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-volopxo"));
                        }
                        countDownLatch.countDown();
                    }
                })) {
                    case ErrorCode.INIT_ERROR_BEGIN /* 1008610 */:
                        DebugLog.oaid_all(dexc.dexa("ntb!rvfsz!sftvmu!pl"));
                        break;
                    case ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT /* 1008611 */:
                        DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!nbovgbduvsfs!opu!tvqqpsu"));
                        msaOAID = OAID_FAIL_MANUFACTURER_NOSUPPORT;
                        countDownLatch.countDown();
                        break;
                    case ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT /* 1008612 */:
                        DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!efwjdf!opu!tvqqpsu"));
                        msaOAID = OAID_DEFAULT_DEVICE_NOT_SUPPORT;
                        countDownLatch.countDown();
                        break;
                    case ErrorCode.INIT_ERROR_LOAD_CONFIGFILE /* 1008613 */:
                        DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!dpogjh!gjmf!fssps"));
                        msaOAID = OAID_FAIL_CONFIGFILE_ERROR;
                        countDownLatch.countDown();
                        break;
                    case ErrorCode.INIT_ERROR_RESULT_DELAY /* 1008614 */:
                        DebugLog.oaid_all(dexc.dexa("ntb!rvfsz!sftvmu!efmbz"));
                        break;
                    case ErrorCode.INIT_HELPER_CALL_ERROR /* 1008615 */:
                        DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!dbmm!fssps"));
                        msaOAID = OAID_FAIL_SDK_CALL_ERROR;
                        countDownLatch.countDown();
                        break;
                    case 1008616:
                        DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!dfsu!fssps"));
                        msaOAID = OAID_FAIL_CERT_ERROR;
                        countDownLatch.countDown();
                        break;
                }
                try {
                    countDownLatch.await(60L, TimeUnit.SECONDS);
                    DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!bxbju!ujnfpvu!ps!rvfsz!epof"));
                } catch (Throwable th) {
                    DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-") + th);
                }
            } catch (Throwable th2) {
                DebugLog.oaid_w(dexc.dexa("ntb!rvfsz!gbjm-") + th2.getMessage());
            }
        } catch (Throwable th3) {
            DebugLog.oaid_w(dexc.dexa("ntb!wfstjpo!") + th3);
        }
    }

    public static String convertOAID(String str) {
        return (str == null || str.length() <= 10) ? str : str.substring(0, 10);
    }

    public static /* synthetic */ void dexa(Context context, long j) {
        resultOAID = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l6"), true);
        DebugLog.oaid_all(dexc.dexa("gspn!tq!") + convertOAID(resultOAID) + Utils.getCostTime(j));
        asyncQueryOAID(context);
    }

    public static String fetchOAIDFromCache(Context context) {
        if (isValidOaid(resultOAID)) {
            DebugLog.oaid_all(dexc.dexa("qbtt"));
        } else {
            fetchOAIDFromFile(context);
        }
        return resultOAID;
    }

    public static void fetchOAIDFromFile(final Context context) {
        final long elapsedRealTime = Utils.getElapsedRealTime();
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.xl2
            @Override // java.lang.Runnable
            public final void run() {
                DeviceIdentifierHelper.dexa(context, elapsedRealTime);
            }
        });
    }

    public static String getImei(Context context) {
        ThreadUtils.isUIThread(dexc.dexa("XN`JefoujgjfsIfmqfs.hfuJnfj"));
        if (!TextUtils.isEmpty(imei)) {
            DebugLog.W(TAG, dexc.dexa("JNFJ!JT!WBMJE!") + imei);
            return imei;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(dexc.dexa("qipof"));
        try {
            Method method = telephonyManager.getClass().getMethod(dexc.dexa("hfuJnfj"), Integer.TYPE);
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
            DebugLog.W(TAG, dexc.dexa("hfu!jnfj!gbjm-") + th);
            try {
                String deviceId = telephonyManager.getDeviceId();
                imei = deviceId;
                return deviceId;
            } catch (Throwable th2) {
                DebugLog.W(TAG, dexc.dexa("hfu!jnfj!gbjm-") + th2);
                return "";
            }
        }
    }

    public static String getOaid(Context context) {
        return fetchOAIDFromCache(context);
    }

    public static boolean isMSAAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isValidOaid(String str) {
        return (TextUtils.isEmpty(str) || ERROR_LIST.contains(str)) ? false : true;
    }

    public static void updateResultOAID(String str, String str2) {
        DebugLog.oaid_all(dexc.dexa("vqebuf!gspn!") + str2 + dexc.dexa(c49.f40900a) + convertOAID(str));
        resultOAID = str;
    }
}
