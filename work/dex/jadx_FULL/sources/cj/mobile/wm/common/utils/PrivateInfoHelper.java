package cj.mobile.wm.common.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import cj.mobile.wm.common.runnable.HasReturnRunnable;
import cj.mobile.wm.common.utils.DeviceUtils;
import cj.mobile.wm.common.utils.PrivateInfoHelper;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PrivateInfoHelper {
    public static final String TAG = dexc.dexa("QsjwbufJogpIfmqfs");
    public static String cacheOaid = "";
    public static String operator = "";
    public static int operatorType = 0;
    public static String mnc = "";
    public static String mcc = "";
    public static String latitude = "";
    public static String longitude = "";
    public static int locationAccuracy = 0;
    public static String imei = "";
    public static String androidId = "";
    public static String imsi = "";
    public static String meid = "";
    public static String macAddress = "";
    public static BeanInfo beanInfo = null;

    public static class BeanInfo {
        public long operator = 0;
        public long operatorType = 0;
        public long mnc = 0;
        public long mcc = 0;
        public long gps = 0;
        public long oaid = -1;
        public long androidId = 0;
        public long mac = 0;
        public long imsi = 0;
        public long imei = 0;
        public long meid = 0;
        public long appList = 0;

        public long getAndroidId() {
            return this.androidId;
        }

        public long getAppList() {
            return this.appList;
        }

        public long getGps() {
            return this.gps;
        }

        public long getImei() {
            return this.imei;
        }

        public long getImsi() {
            return this.imsi;
        }

        public long getMac() {
            return this.mac;
        }

        public long getMcc() {
            return this.mcc;
        }

        public long getMeid() {
            return this.meid;
        }

        public long getMnc() {
            return this.mnc;
        }

        public long getOaid() {
            return this.oaid;
        }

        public long getOperator() {
            return this.operator;
        }

        public long getOperatorType() {
            return this.operatorType;
        }

        public BeanInfo setAndroidId(long j) {
            this.androidId = j;
            return this;
        }

        public BeanInfo setAppList(long j) {
            this.appList = j;
            return this;
        }

        public BeanInfo setGps(long j) {
            this.gps = j;
            return this;
        }

        public BeanInfo setImei(long j) {
            this.imei = j;
            return this;
        }

        public BeanInfo setImsi(long j) {
            this.imsi = j;
            return this;
        }

        public BeanInfo setMac(long j) {
            this.mac = j;
            return this;
        }

        public BeanInfo setMcc(long j) {
            this.mcc = j;
            return this;
        }

        public BeanInfo setMeid(long j) {
            this.meid = j;
            return this;
        }

        public BeanInfo setMnc(long j) {
            this.mnc = j;
            return this;
        }

        public BeanInfo setOaid(long j) {
            this.oaid = j;
            return this;
        }

        public BeanInfo setOperator(long j) {
            this.operator = j;
            return this;
        }

        public BeanInfo setOperatorType(long j) {
            this.operatorType = j;
            return this;
        }

        public String toString() {
            return dexc.dexa("CfboJogp|pqfsbups>") + this.operator + dexc.dexa("-!pqfsbupsUzqf>") + this.operatorType + dexc.dexa("-!nod>") + this.mnc + dexc.dexa("-!ndd>") + this.mcc + dexc.dexa("-!hqt>") + this.gps + dexc.dexa("-!pbje>") + this.oaid + dexc.dexa("-!jnfj>") + this.imei + dexc.dexa("-!boespjeJe>") + this.androidId + dexc.dexa("-!nbd>") + this.mac + dexc.dexa("-!jntj>") + this.imsi + dexc.dexa("-!bqqMjtu>") + this.appList + dexc.dexa("-!nfje>") + this.meid + '}';
        }
    }

    public static String convertOAID(String str) {
        return (str == null || str.length() <= 10) ? str : str.substring(0, 10);
    }

    public static /* synthetic */ String dexb(Context context) {
        String imei2 = DeviceIdentifierHelper.getImei(context);
        return (!TextUtils.isEmpty(imei2) || TextUtils.isEmpty(ConstantInfo.getDevImei())) ? imei2 : ConstantInfo.getDevImei();
    }

    public static /* synthetic */ String dexd(Context context) {
        double latitude2 = new LocationUtils().getLatitude(context.getApplicationContext());
        if (latitude2 <= AudioStats.AUDIO_AMPLITUDE_NONE && ConstantInfo.getDevWMLocation() != null) {
            latitude2 = ConstantInfo.getDevWMLocation().getLatitude();
        }
        return String.valueOf(latitude2);
    }

    public static /* synthetic */ String dexe(Context context) {
        float accuracy = new LocationUtils().getAccuracy(context.getApplicationContext());
        if (accuracy <= 0.0f && ConstantInfo.getDevWMLocation() != null) {
            accuracy = ConstantInfo.getDevWMLocation().getAccuracy();
        }
        return String.valueOf(accuracy);
    }

    public static /* synthetic */ String dexf(Context context) {
        double longitude2 = new LocationUtils().getLongitude(context.getApplicationContext());
        if (longitude2 <= AudioStats.AUDIO_AMPLITUDE_NONE && ConstantInfo.getDevWMLocation() != null) {
            longitude2 = ConstantInfo.getDevWMLocation().getLongitude();
        }
        return String.valueOf(longitude2);
    }

    public static /* synthetic */ String dexj(Context context) {
        String macAddress2 = DeviceUtils.getMacAddress(context.getApplicationContext());
        return (!TextUtils.isEmpty(macAddress2) || TextUtils.isEmpty(ConstantInfo.getDevMacAddress())) ? macAddress2 : ConstantInfo.getDevMacAddress();
    }

    public static /* synthetic */ String dexk(Context context) {
        String oaid = DeviceIdentifierHelper.getOaid(context.getApplicationContext());
        if (TextUtils.isEmpty(oaid) && !TextUtils.isEmpty(ConstantInfo.getDevOaid())) {
            oaid = ConstantInfo.getDevOaid();
        }
        if (TextUtils.isEmpty(cacheOaid)) {
            cacheOaid = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l5"), "", true);
            DebugLog.oaid_all(dexc.dexa("smdp!") + convertOAID(cacheOaid));
        }
        if (!TextUtils.isEmpty(oaid) && !oaid.equals(cacheOaid)) {
            SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l5"), oaid, true);
            cacheOaid = oaid;
            DebugLog.oaid_all(dexc.dexa("vmp!") + convertOAID(cacheOaid));
        }
        return cacheOaid;
    }

    public static String getAndroidId(final Context context) {
        if (!ConstantInfo.isCanUsePhoneState()) {
            DebugLog.common_debug(dexc.dexa("hfuBoespjeJe!qfsnjttjpo!efojfe"));
        } else if (TextUtils.isEmpty(androidId)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                androidId = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l36"), true, privateInfo != null ? privateInfo.getAndroidId() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.kz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return DeviceUtils.getAndroidId(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_debug(dexc.dexa("hfuBoespjeJe!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuBoespjeJe!gbjm!!"), th);
            }
        }
        return androidId;
    }

    public static long getAppList(Context context) {
        BeanInfo privateInfo = getPrivateInfo(context);
        if (privateInfo != null) {
            return privateInfo.getAppList();
        }
        return 0L;
    }

    public static int getConnectType(Context context) {
        if (ConstantInfo.isCanUseNetworkState()) {
            return DeviceUtils.getConnectType(context);
        }
        DebugLog.W(TAG, dexc.dexa("hfuDpoofduUzqf!qfsnjttjpo!efojfe"));
        return 0;
    }

    public static String getIMEI(final Context context) {
        if (!ConstantInfo.isCanUsePhoneState()) {
            if (!TextUtils.isEmpty(ConstantInfo.getDevImei())) {
                imei = ConstantInfo.getDevImei();
            }
            DebugLog.common_debug(dexc.dexa("hfuJNFJ!qfsnjttjpo!efojfe-efwJnfj"), imei);
        } else if (TextUtils.isEmpty(imei)) {
            try {
                long elapsedRealTime = Utils.getElapsedRealTime();
                BeanInfo privateInfo = getPrivateInfo(context);
                long imei2 = privateInfo != null ? privateInfo.getImei() : 0L;
                HasReturnRunnable hasReturnRunnable = new HasReturnRunnable() { // from class: com.zj.adlib.wy6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return PrivateInfoHelper.dexb(context);
                    }
                };
                Context applicationContext = context.getApplicationContext();
                String str = TAG;
                imei = CacheInfoUtil.getInfo(applicationContext, str, dexc.dexa("nn`tq`l35"), true, imei2, hasReturnRunnable);
                long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
                if (elapsedRealTime2 > 10) {
                    DebugLog.W(str, dexc.dexa("hfuJNFJ!") + elapsedRealTime2 + dexc.dexa("!nt"));
                }
            } catch (Throwable th) {
                DebugLog.W(TAG, dexc.dexa("hfuJNFJ!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuJNFJ!gbjm!"), th);
            }
        }
        return imei;
    }

    public static String getIMSI(final Context context) {
        if (!ConstantInfo.isCanUsePhoneState()) {
            DebugLog.common_debug(dexc.dexa("hfuJNTJ!qfsnjttjpo!efojfe"));
        } else if (TextUtils.isEmpty(imsi)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                imsi = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l38"), true, privateInfo != null ? privateInfo.getImsi() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.yy6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return DeviceUtils.getIMSI(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_debug(dexc.dexa("hfuJNTJ!gbjm!") + th);
            }
        }
        return imsi;
    }

    public static String getLatitude(final Context context) {
        if (!ConstantInfo.isCanUseLocation()) {
            if (ConstantInfo.getDevWMLocation() != null) {
                latitude = String.valueOf(ConstantInfo.getDevWMLocation().getLatitude());
            }
            DebugLog.common_w(dexc.dexa("hfuMbujuvef!qfsnjttjpo!efojfe-efwMbujuvef>") + latitude);
        } else if (TextUtils.isEmpty(latitude)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                latitude = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l32"), true, privateInfo != null ? privateInfo.getGps() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.oz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return PrivateInfoHelper.dexd(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuMbujuvef!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuMbujuvef!gbjm!"), th);
            }
        }
        return latitude;
    }

    public static int getLocationAccuracy(final Context context) {
        if (!ConstantInfo.isCanUseLocation()) {
            if (ConstantInfo.getDevWMLocation() != null) {
                locationAccuracy = (int) ConstantInfo.getDevWMLocation().getAccuracy();
            }
            DebugLog.common_w(dexc.dexa("hfuMpdbujpoBddvsbdz!qfsnjttjpo!efojfe-efwMpdbujpoBddvsbdz>") + locationAccuracy + "");
        } else if (locationAccuracy == 0) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                String info = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l34"), false, privateInfo != null ? privateInfo.getGps() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.sz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return PrivateInfoHelper.dexe(context);
                    }
                });
                if (!TextUtils.isEmpty(info)) {
                    locationAccuracy = Double.valueOf(info).intValue();
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuMpdbujpoBddvsbdz!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuMpdbujpoBddvsbdz!gbjm!"), th);
            }
        }
        return locationAccuracy;
    }

    public static String getLongitude(final Context context) {
        if (!ConstantInfo.isCanUseLocation()) {
            if (ConstantInfo.getDevWMLocation() != null) {
                longitude = String.valueOf(ConstantInfo.getDevWMLocation().getLongitude());
            }
            DebugLog.common_w(dexc.dexa("hfuMpohjuvef!qfsnjttjpo!efojfe-efwMpohjuvef>") + longitude);
        } else if (TextUtils.isEmpty(longitude)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                longitude = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l33"), true, privateInfo != null ? privateInfo.getGps() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.az6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return PrivateInfoHelper.dexf(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuMpohjuvef!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuMpohjuvef!gbjm!!"), th);
            }
        }
        return longitude;
    }

    public static String getMCC(final Context context) {
        if (!ConstantInfo.isCanUseNetworkState()) {
            DebugLog.common_debug(dexc.dexa("hfuNDD!qfsnjttjpo!efojfe"));
        } else if (TextUtils.isEmpty(mcc)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                mcc = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l31"), false, privateInfo != null ? privateInfo.getMcc() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.iz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return DeviceUtils.getMcc(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_debug(TAG, dexc.dexa("hfuNDD!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuNDD!gbjm!"), th);
            }
        }
        return mcc;
    }

    public static String getMEID(final Context context) {
        if (!ConstantInfo.isCanUsePhoneState()) {
            DebugLog.common_debug(dexc.dexa("hfuNFJE!qfsnjttjpo!efojfe"));
        } else if (TextUtils.isEmpty(meid)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                meid = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l39"), true, privateInfo != null ? privateInfo.getMeid() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.gz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return DeviceUtils.getMEID(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_debug(TAG, dexc.dexa("hfuNFJE!gbjm!") + th);
            }
        }
        return meid;
    }

    public static String getMNC(final Context context) {
        if (!ConstantInfo.isCanUseNetworkState()) {
            DebugLog.common_debug(TAG, dexc.dexa("hfuNOD!qfsnjttjpo!efojfe"));
        } else if (TextUtils.isEmpty(mnc)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                mnc = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l2:"), false, privateInfo != null ? privateInfo.getMnc() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.uz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return DeviceUtils.getMnc(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_debug(TAG, dexc.dexa("hfuNOD!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuNOD!gbjm!"), th);
            }
        }
        return mnc;
    }

    public static String getMac(final Context context) {
        if (!ConstantInfo.isCanUseWifiState()) {
            if (!TextUtils.isEmpty(ConstantInfo.getDevMacAddress())) {
                macAddress = ConstantInfo.getDevMacAddress();
            }
            DebugLog.W(TAG, dexc.dexa("hfu!nbd!qfsnjttjpo!efojfe-efwNbd>") + macAddress);
        } else if (TextUtils.isEmpty(macAddress)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                macAddress = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l37"), true, privateInfo != null ? privateInfo.getMac() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.qz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return PrivateInfoHelper.dexj(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, dexc.dexa("hfuNbd!fssps;") + th);
                reportErrorInfo(context, dexc.dexa("鯿楈Nbdꈈ꜇楲鵦)hfuNbd*-"), th);
            }
        }
        return macAddress;
    }

    public static String getOaid(final Context context) {
        if (ConstantInfo.isCanUseOaid()) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                cacheOaid = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l27"), true, privateInfo != null ? privateInfo.getOaid() : -1L, new HasReturnRunnable() { // from class: com.zj.adlib.mz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return PrivateInfoHelper.dexk(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.oaid_w(dexc.dexa("hpg!") + th);
                reportErrorInfo(context, dexc.dexa("hfu!pbje!gbjm-"), th);
            }
        } else {
            DebugLog.oaid_w(dexc.dexa("qfsnjttjpo!efojfe"));
            if (TextUtils.isEmpty(cacheOaid)) {
                cacheOaid = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l5"), "", true);
                DebugLog.oaid_all(dexc.dexa("smdp!") + convertOAID(cacheOaid));
            }
            if (TextUtils.isEmpty(ConstantInfo.getDevOaid())) {
                DebugLog.oaid_w(dexc.dexa("efw!pje!jt!fnquz"));
            } else {
                String devOaid = ConstantInfo.getDevOaid();
                DebugLog.oaid_all(dexc.dexa("epw!") + convertOAID(devOaid));
                if (!devOaid.equals(cacheOaid)) {
                    SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l5"), devOaid, true);
                    cacheOaid = devOaid;
                    DebugLog.oaid_all(dexc.dexa("vmp!") + convertOAID(cacheOaid));
                }
            }
        }
        return cacheOaid;
    }

    public static String getOperator(final Context context) {
        if (TextUtils.isEmpty(operator)) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                operator = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l28"), false, privateInfo != null ? privateInfo.getOperator() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.cz6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return DeviceUtils.getOperator(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.common_debug(TAG, dexc.dexa("hfuPqfsbups!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuPqfsbups!gbjm!"), th);
            }
        }
        return operator;
    }

    public static int getOperatorType(final Context context) {
        if (operatorType == 0) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                String info = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, dexc.dexa("nn`tq`l29"), false, privateInfo != null ? privateInfo.getOperatorType() : 0L, new HasReturnRunnable() { // from class: com.zj.adlib.ez6
                    @Override // cj.mobile.wm.common.runnable.HasReturnRunnable
                    public final Object run() {
                        return String.valueOf(DeviceUtils.getOperatorType(context.getApplicationContext()));
                    }
                });
                if (!TextUtils.isEmpty(info)) {
                    operatorType = Integer.parseInt(info);
                }
            } catch (Throwable th) {
                DebugLog.common_debug(TAG, dexc.dexa("hfuPqfsbupsUzqf!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuPqfsbupsUzqf!gbjm!"), th);
            }
        }
        return operatorType;
    }

    public static BeanInfo getPrivateInfo(Context context) {
        if (beanInfo == null) {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l26"), true);
            if (TextUtils.isEmpty(preferencesString)) {
                return null;
            }
            beanInfo = (BeanInfo) GsonUtils.getInstance().fromJson(preferencesString, BeanInfo.class);
        }
        return beanInfo;
    }

    public static void putPrivateInfo(Context context, BeanInfo beanInfo2) {
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l26"), GsonUtils.getInstance().toJson(beanInfo2), true);
    }

    public static void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 900024, dexc.dexa("鯿楈���炰ꈈ꜇楲鵦"), str + (th != null ? th.toString() : ""));
    }
}
