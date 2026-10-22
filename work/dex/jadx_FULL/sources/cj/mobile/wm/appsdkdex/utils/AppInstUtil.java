package cj.mobile.wm.appsdkdex.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.appsdkdex.utils.AppInstUtil;
import cj.mobile.wm.common.bean.AndroidBundle;
import cj.mobile.wm.common.bean.FullInstBean;
import cj.mobile.wm.common.bean.InstReportBean;
import cj.mobile.wm.common.bean.MediationAppCfg;
import cj.mobile.wm.common.bean.NormalInstBean;
import cj.mobile.wm.common.bean.SdkMediationAppResp;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.DeviceUtils;
import cj.mobile.wm.common.utils.GsonUtils;
import cj.mobile.wm.common.utils.PermissionUtils;
import cj.mobile.wm.common.utils.PrivateInfoHelper;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.SharedPreferencesHelper;
import cj.mobile.wm.common.utils.ThreadUtils;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.dexc;
import cj.mobile.wm.permission.RomHelper;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInstUtil {
    public static int APP_INST_PRIORITY = 1;
    public static int instCheckType;
    public static long lastCheckedTime;

    public static InstReportBean buildInstReportBean(Context context, Set<String> set) {
        Set<String> totalInstPkgSet;
        InstReportBean instReportBean = null;
        try {
            FullInstBean fullInstBean = ConstantInfo.Config.fullInstBean;
            if (fullInstBean == null || (totalInstPkgSet = fullInstBean.getTotalInstPkgSet()) == null || totalInstPkgSet.isEmpty()) {
                DebugLog.inst_w(dexc.dexa("sfqpsuJotubmmfeJogp!gbjm-GvmmJotuCfbo!jt!ovmm"));
            } else {
                InstReportBean instReportBean2 = new InstReportBean();
                try {
                    Set<Integer> instIdSet = fullInstBean.getInstIdSet();
                    if (instIdSet == null || instIdSet.isEmpty()) {
                        DebugLog.inst_w(dexc.dexa("jotuJeTfu!jt!ovmm"));
                    } else {
                        instReportBean2.setInstall_app_ids(new ArrayList(instIdSet));
                    }
                    Set<Integer> unInstIdSet = fullInstBean.getUnInstIdSet();
                    if (unInstIdSet == null || unInstIdSet.isEmpty()) {
                        DebugLog.inst_w(dexc.dexa("voJotubmmfeJeTfu!jt!ovmm"));
                    } else {
                        instReportBean2.setUninstall_app_ids(new ArrayList(unInstIdSet));
                    }
                    Set<String> setFilterInstIdsFromTotal = filterInstIdsFromTotal(totalInstPkgSet, set);
                    if (setFilterInstIdsFromTotal == null || setFilterInstIdsFromTotal.isEmpty()) {
                        DebugLog.inst_w(dexc.dexa("jotuQlhTfu!jt!ovmm"));
                    } else {
                        instReportBean2.setInstall_app_bundles(new ArrayList(setFilterInstIdsFromTotal));
                    }
                    instReportBean2.setApp_version(Utils.getVersionName(context));
                    instReportBean2.setOs_version(Build.VERSION.RELEASE);
                    instReportBean2.setOaid(PrivateInfoHelper.getOaid(context));
                    try {
                        if (Build.VERSION.SDK_INT <= 28) {
                            instReportBean2.setImei(PrivateInfoHelper.getIMEI(context));
                        }
                    } catch (Throwable th) {
                        DebugLog.inst_w(dexc.dexa("tfuJnfj!gbjm-") + th);
                    }
                    instReportBean2.setAndroidId(PrivateInfoHelper.getAndroidId(context));
                    instReportBean2.setModel(DeviceUtils.getDeviceModel());
                    instReportBean2.setVendor(DeviceUtils.getDeviceVendor());
                    instReportBean2.setCtzid(ConstantInfo.wmId);
                    instReportBean2.setTrack_type(fullInstBean.getCheckType());
                    instReportBean2.setTrack_time(fullInstBean.getCheckedTime());
                    instReportBean = instReportBean2;
                } catch (Throwable th2) {
                    th = th2;
                    instReportBean = instReportBean2;
                    DebugLog.inst_w(dexc.dexa("sfqpsuJotubmmfeJogp!gbjm-") + th);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return instReportBean;
    }

    public static /* synthetic */ void dexa(SdkMediationAppResp sdkMediationAppResp) {
        SdkMediationAppResp sdkMediationAppRespFetchSdkMediationAppResp = fetchSdkMediationAppResp(sdkMediationAppResp);
        if (sdkMediationAppRespFetchSdkMediationAppResp == null) {
            DebugLog.inst_w(dexc.dexa("nfejbBqqSftq!jt!ovmm"));
            return;
        }
        MediationAppCfg app = sdkMediationAppRespFetchSdkMediationAppResp.getApp();
        if (app == null) {
            DebugLog.inst_w(dexc.dexa("nfejbBqqDpogjh!jt!ovmm"));
            return;
        }
        if (app.getCheckInstalledStatus() == 0) {
            DebugLog.inst_w(dexc.dexa("gvmmJotu!txjudi!pgg"));
            return;
        }
        int checkMaxLimit = app.getCheckMaxLimit();
        if (checkMaxLimit <= 0) {
            DebugLog.inst_w(dexc.dexa("gvmmJotu!nbyjnvn!jowbmje"));
            return;
        }
        List<AndroidBundle> bundle = sdkMediationAppRespFetchSdkMediationAppResp.getBundle();
        if (bundle == null || bundle.isEmpty()) {
            DebugLog.inst_w(dexc.dexa("gvmmJotu!cvoemft!jt!ovmm"));
        } else {
            doAsyncFullInstScan(bundle, checkMaxLimit, app.getRecheckDuration(), app.getCacheDuration());
        }
    }

    public static /* synthetic */ Set dexb(Map map) throws Exception {
        try {
            Set<String> setQueryFullInstPackages = queryFullInstPackages(null, map, 0, dexc.dexa("sfbmUjnfJotu"));
            if (setQueryFullInstPackages != null && !setQueryFullInstPackages.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : map.entrySet()) {
                    if (setQueryFullInstPackages.contains(entry.getValue())) {
                        hashSet.add((String) entry.getKey());
                    }
                }
                DebugLog.inst_d(dexc.dexa("sfbmUjnfJotu!rvfsz!epof-iju!") + hashSet.size());
                return hashSet;
            }
            DebugLog.inst_w(dexc.dexa("sfbmUjnfJotu!rvfsz!gbjm-jotuQlhMjtu!jt!ovmm"));
            return null;
        } catch (Throwable th) {
            DebugLog.inst_w(dexc.dexa("tubsuSfbmUjnfJotuTdbo!gbjm!") + Log.getStackTraceString(th));
            return null;
        }
    }

    public static void doAsyncFullInstScan(List<AndroidBundle> list, int i, int i2, int i3) {
        long elapsedRealTime = Utils.getElapsedRealTime();
        HashSet hashSet = null;
        Set<String> setQueryFullInstPackages = queryFullInstPackages(list, null, i, dexc.dexa("gvmmJotu"));
        if (setQueryFullInstPackages == null || setQueryFullInstPackages.isEmpty()) {
            DebugLog.inst_w(dexc.dexa("gvoJotu!rvfsz!gbjm-jotuQlhMjtu!jt!ovmm"));
            return;
        }
        FullInstBean fullInstBean = new FullInstBean();
        fullInstBean.setCheckType(instCheckType);
        fullInstBean.setTotalInstPkgSet(setQueryFullInstPackages);
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        int i4 = instCheckType;
        int i5 = 0;
        if (i4 == 1 || i4 == 2) {
            hashSet = new HashSet();
            while (i5 < list.size()) {
                String value = list.get(i5).getValue();
                if (setQueryFullInstPackages.contains(value)) {
                    hashSet2.add(Integer.valueOf(list.get(i5).getKey()));
                    hashSet.add(value);
                } else {
                    hashSet3.add(Integer.valueOf(list.get(i5).getKey()));
                }
                i5++;
            }
        } else if (i4 == 3) {
            List<AndroidBundle> realCheckList = getRealCheckList(list, i);
            if (realCheckList == null) {
                DebugLog.inst_w(dexc.dexa("sfbmDifdlMjtu!jowbmje"));
                return;
            }
            while (i5 < realCheckList.size()) {
                int key = realCheckList.get(i5).getKey();
                if (setQueryFullInstPackages.contains(realCheckList.get(i5).getValue())) {
                    hashSet2.add(Integer.valueOf(key));
                } else {
                    hashSet3.add(Integer.valueOf(key));
                }
                i5++;
            }
        }
        fullInstBean.setCheckedTime(System.currentTimeMillis());
        fullInstBean.setRecheckDuration(i2);
        fullInstBean.setCacheDuration(i3);
        fullInstBean.setInstIdSet(hashSet2);
        fullInstBean.setUnInstIdSet(hashSet3);
        ConstantInfo.Config.fullInstBean = fullInstBean;
        DebugLog.inst_d(dexc.dexa("gvmmJot!rvfsz!epof-") + instCheckType + dexc.dexa(c49.f40900a) + Utils.getCostTime(elapsedRealTime));
        if (i2 > 0 && i3 > 0) {
            saveFullInstResult(fullInstBean);
        }
        reportInstInfo(WMDexAdHelper.gapc(), hashSet);
    }

    public static SdkMediationAppResp fetchSdkMediationAppResp(SdkMediationAppResp sdkMediationAppResp) {
        if (sdkMediationAppResp == null) {
            String preferencesString = SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc()).getPreferencesString(SharedPreferencesHelper.ConfigType.EXT, dexc.dexa("nn`fyu`l2"));
            if (TextUtils.isEmpty(preferencesString) || (sdkMediationAppResp = (SdkMediationAppResp) GsonUtils.getInstance().fromJson(preferencesString, SdkMediationAppResp.class)) == null) {
                return null;
            }
        }
        return sdkMediationAppResp;
    }

    public static Set<String> filterInstIdsFromTotal(Set<String> set, Set<String> set2) {
        if (set2 == null || set2.isEmpty()) {
            DebugLog.inst_w(dexc.dexa("ijuJotuQlhTfu!jt!ovmm"));
            return set;
        }
        HashSet hashSet = new HashSet(set);
        DebugLog.inst_d(dexc.dexa("jtSfnpwf!") + hashSet.removeAll(set2));
        return hashSet;
    }

    public static Set<String> getNormalInstFromTotalInst(FullInstBean fullInstBean, Map<String, String> map) {
        HashSet hashSet = new HashSet();
        Set<String> totalInstPkgSet = fullInstBean.getTotalInstPkgSet();
        if (totalInstPkgSet != null && !totalInstPkgSet.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (totalInstPkgSet.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b3 A[ORIG_RETURN, RETURN] */
    public static Set<String> getNormalInstalledFromRealtimeScan(Map<String, String> map) {
        NormalInstBean normalInstBean;
        Set<String> normalInstIdSet;
        Set<String> setQueryFullInstPackages;
        String preferencesString = SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc()).getPreferencesString(SharedPreferencesHelper.ConfigType.EXT, dexc.dexa("nn`fyu`l4"));
        long jGenerateRoll64FromMap = Utils.generateRoll64FromMap(map);
        boolean z = true;
        if (!TextUtils.isEmpty(preferencesString) && (normalInstBean = (NormalInstBean) GsonUtils.getInstance().fromJson(preferencesString, NormalInstBean.class)) != null) {
            if (jGenerateRoll64FromMap != normalInstBean.getRoll64()) {
                DebugLog.inst_w(dexc.dexa("opsnbmJotu!difdlMjtu!ibt!dibohfe"));
            } else {
                DebugLog.inst_d(dexc.dexa("opsnbmJotu!dbdif!wbmje"));
                normalInstIdSet = normalInstBean.getNormalInstIdSet();
                z = false;
            }
            if (z) {
                return normalInstIdSet;
            }
            setQueryFullInstPackages = queryFullInstPackages(null, map, 0, dexc.dexa("opsnbmJotu"));
            if (setQueryFullInstPackages != null || setQueryFullInstPackages.isEmpty()) {
                DebugLog.inst_w(dexc.dexa("opsnbmJotu!rvfsz!gbjm-jotuQlhMjtu!jt!ovmm"));
                return null;
            }
            HashSet hashSet = new HashSet();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (setQueryFullInstPackages.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            saveNormalInstResult(hashSet, jGenerateRoll64FromMap);
            return hashSet;
        }
        DebugLog.inst_w(dexc.dexa("opsnbmJotu!dbdif!jowbmje"));
        normalInstIdSet = null;
        if (z) {
            return normalInstIdSet;
        }
        setQueryFullInstPackages = queryFullInstPackages(null, map, 0, dexc.dexa("opsnbmJotu"));
        if (setQueryFullInstPackages != null) {
        }
        DebugLog.inst_w(dexc.dexa("opsnbmJotu!rvfsz!gbjm-jotuQlhMjtu!jt!ovmm"));
        return null;
    }

    public static List<AndroidBundle> getRealCheckList(List<AndroidBundle> list, int i) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        int iMin = Math.min(Math.min(list.size(), i), 1500);
        DebugLog.inst_d(dexc.dexa("sfbmTdbo!tj{f!") + iMin);
        return iMin < list.size() ? list.subList(0, iMin) : list;
    }

    public static void initFullInst() {
        try {
            long elapsedRealTime = Utils.getElapsedRealTime();
            DebugLog.inst_d(dexc.dexa("jojuGvmmJotu"));
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc());
            SharedPreferencesHelper.ConfigType configType = SharedPreferencesHelper.ConfigType.EXT;
            String preferencesString = sharedPreferencesHelper.getPreferencesString(configType, dexc.dexa("nn`fyu`l3"), "");
            if (TextUtils.isEmpty(preferencesString)) {
                DebugLog.inst_w(dexc.dexa("gvmmJotuTus!jt!ovmm"));
                return;
            }
            FullInstBean fullInstBean = (FullInstBean) GsonUtils.getInstance().fromJson(preferencesString, FullInstBean.class);
            if (fullInstBean == null) {
                DebugLog.inst_w(dexc.dexa("gvmmJotuCfbo!jt!ovmm"));
                return;
            }
            if (fullInstBean.isNeedCleanCache()) {
                DebugLog.inst_w(dexc.dexa("dmfbs!gvmmJotu"));
                sharedPreferencesHelper.removeValueByKey(configType, dexc.dexa("nn`fyu`l3"));
                return;
            }
            ConstantInfo.Config.fullInstBean = fullInstBean;
            DebugLog.inst_d(dexc.dexa("jojuGvmmJotu!") + Utils.getCostTime(elapsedRealTime));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.inst_w(dexc.dexa("jojuGvmmJotu!gbjm!") + stackTraceString);
            ReportUtils.exReport(WMDexAdHelper.gapc(), 200017, dexc.dexa("TEL扞樌捗渳毊餆���炰扞樌捗楲鵦"), stackTraceString);
        }
    }

    public static boolean isNeedScanFullInst() {
        FullInstBean fullInstBean = ConstantInfo.Config.fullInstBean;
        boolean z = fullInstBean == null || fullInstBean.isNeedRecheck();
        if (z) {
            DebugLog.inst_d(dexc.dexa("offe!rvfsz"));
        }
        return z;
    }

    public static Set<String> queryAllInstPackages() {
        if (!ConstantInfo.isCanUseAppList()) {
            DebugLog.inst_w(dexc.dexa("hfuBqqMjtu!qfsnjttjpo!efojfe"));
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dexc.dexa("rvfsz!b!"));
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        DebugLog.inst_d(sb.toString());
        if (i >= 30) {
            if (!PermissionUtils.hasConfigQueryAllPackagesPermission(WMDexAdHelper.gapc())) {
                return null;
            }
            String manufacturer = RomHelper.getManufacturer();
            DebugLog.inst_d(dexc.dexa("nbovgbduvsfs!") + manufacturer);
            if (!manufacturer.equals(dexc.dexa("LOPXO")) && !PermissionUtils.hasRuntimeGetInstalledAppsPermission(WMDexAdHelper.gapc(), manufacturer)) {
                return null;
            }
        }
        Utils.getElapsedRealTime();
        Set<String> setQueryAllInstalledAppList = Utils.queryAllInstalledAppList(WMDexAdHelper.gapc());
        if (setQueryAllInstalledAppList != null) {
            DebugLog.inst_d(dexc.dexa("rvfsz!b!epof!") + setQueryAllInstalledAppList.size());
        }
        return setQueryAllInstalledAppList;
    }

    public static Set<String> queryFullInstPackages(List<AndroidBundle> list, Map<String, String> map, int i, String str) {
        int i2 = APP_INST_PRIORITY;
        if (i2 == 1) {
            DebugLog.inst_d(str + dexc.dexa("!rvfsz!2.?3.?4"));
            Set<String> setQueryVisibleInstPackages = queryVisibleInstPackages();
            if (setQueryVisibleInstPackages != null && setQueryVisibleInstPackages.size() > 1) {
                instCheckType = 1;
                return setQueryVisibleInstPackages;
            }
            Set<String> setQueryAllInstPackages = queryAllInstPackages();
            if (setQueryAllInstPackages != null && !setQueryAllInstPackages.isEmpty()) {
                instCheckType = 2;
                return setQueryAllInstPackages;
            }
        } else if (i2 == 2) {
            DebugLog.inst_d(str + dexc.dexa("!rvfsz!3.?2.?4"));
            Set<String> setQueryAllInstPackages2 = queryAllInstPackages();
            if (setQueryAllInstPackages2 != null && !setQueryAllInstPackages2.isEmpty()) {
                instCheckType = 2;
                return setQueryAllInstPackages2;
            }
            Set<String> setQueryVisibleInstPackages2 = queryVisibleInstPackages();
            if (setQueryVisibleInstPackages2 != null && setQueryVisibleInstPackages2.size() > 1) {
                instCheckType = 1;
                return setQueryVisibleInstPackages2;
            }
        }
        if (list != null && !list.isEmpty()) {
            list = getRealCheckList(list, i);
        }
        if ((list == null || list.isEmpty()) && (map == null || map.isEmpty())) {
            DebugLog.inst_d(dexc.dexa("sfbmDifdlMjtu!jowbmje"));
            return null;
        }
        Set<String> setQueryInstAppListByCheckList = queryInstAppListByCheckList(list, map);
        if (setQueryInstAppListByCheckList == null || setQueryInstAppListByCheckList.isEmpty()) {
            return null;
        }
        instCheckType = 3;
        return setQueryInstAppListByCheckList;
    }

    public static Set<String> queryInstAppListByCheckList(List<AndroidBundle> list, Map<String, String> map) {
        int size;
        DebugLog.inst_d(dexc.dexa("rvfsz!m"));
        if (list == null || list.isEmpty()) {
            size = (map == null || map.isEmpty()) ? 0 : map.size();
        } else {
            size = list.size();
        }
        if (size == 0) {
            DebugLog.inst_w(dexc.dexa("difdlTj{f!jowbmje"));
            return null;
        }
        long elapsedRealTime = Utils.getElapsedRealTime();
        Set<String> setQueryInstalledAppListByCheckList = Utils.queryInstalledAppListByCheckList(WMDexAdHelper.gapc(), list, map);
        if (setQueryInstalledAppListByCheckList != null) {
            DebugLog.inst_d(dexc.dexa("rvfsz!m!epof-") + setQueryInstalledAppListByCheckList.size() + dexc.dexa(c49.f40900a) + Utils.getCostTime(elapsedRealTime));
        }
        return setQueryInstalledAppListByCheckList;
    }

    public static Set<String> queryVisibleInstPackages() {
        DebugLog.inst_d(dexc.dexa("rvfsz!w"));
        long elapsedRealTime = Utils.getElapsedRealTime();
        Set<String> setQueryVisibleInstalledAppList = Utils.queryVisibleInstalledAppList(WMDexAdHelper.gapc());
        if (setQueryVisibleInstalledAppList != null) {
            DebugLog.inst_d(dexc.dexa("rvfsz!w!epof-") + setQueryVisibleInstalledAppList.size() + dexc.dexa(c49.f40900a) + Utils.getCostTime(elapsedRealTime));
        }
        return setQueryVisibleInstalledAppList;
    }

    public static void reportInstInfo(final Context context, final Set<String> set) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.w90
            @Override // java.lang.Runnable
            public final void run() {
                AppInstUtil.dexa(context, set);
            }
        });
    }

    public static void saveFullInstResult(final FullInstBean fullInstBean) {
        if (fullInstBean == null) {
            DebugLog.inst_w(dexc.dexa("tbwfGvmmJotuSftvmu!gbjm-ebub!jt!ovmm"));
        } else {
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.ca0
                @Override // java.lang.Runnable
                public final void run() {
                    SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc()).savePreferencesString(SharedPreferencesHelper.ConfigType.EXT, dexc.dexa("nn`fyu`l3"), GsonUtils.getInstance().toJson(fullInstBean));
                }
            });
        }
    }

    public static void saveNormalInstResult(final Set<String> set, final long j) {
        if (set == null || set.isEmpty()) {
            DebugLog.inst_w(dexc.dexa("tbwfOpsnbmJotuSftvmu!gbjm-opsnbmJotuJeTfu!jt!ovmm"));
        } else {
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.ea0
                @Override // java.lang.Runnable
                public final void run() {
                    AppInstUtil.dexa(set, j);
                }
            });
        }
    }

    public static void startDeliveryInstScan(Map<String, String> map, Map<String, String> map2) {
        if (Utils.getElapsedRealTime() - lastCheckedTime <= ConstantInfo.Config.DEFAULT_RECHECK_INTERVAL) {
            DebugLog.inst_w(dexc.dexa("efmjwfszJotu!ujnf!mjnju"));
            return;
        }
        lastCheckedTime = Utils.getElapsedRealTime();
        HashSet hashSet = new HashSet();
        if (map == null || map.isEmpty()) {
            DebugLog.inst_d(dexc.dexa("sfbmUjnfJotuMjtu!jt!ovmm"));
        } else {
            try {
                Set<String> set = startRealTimeInstScan(map).get(100L, TimeUnit.MILLISECONDS);
                if (set != null && !set.isEmpty()) {
                    hashSet.addAll(set);
                }
            } catch (Throwable th) {
                DebugLog.inst_w(dexc.dexa("sfbmUjnfJotu!rvfsz!ujnfpvu!") + th);
            }
        }
        if (map2 == null || map2.isEmpty()) {
            DebugLog.inst_d(dexc.dexa("opsnbmJotuMjtu!jt!ovmm"));
        } else {
            try {
                Set<String> set2 = startNormalInstScan(map2).get(100L, TimeUnit.MILLISECONDS);
                if (set2 != null && !set2.isEmpty()) {
                    hashSet.addAll(set2);
                }
            } catch (Throwable th2) {
                DebugLog.inst_w(dexc.dexa("opsnbmJotu!rvfsz!ujnfpvu!") + th2);
            }
        }
        ConstantInfo.Config.deliveryInstResult = !hashSet.isEmpty() ? TextUtils.join(dexc.dexa(c49.f40900a), hashSet) : "";
        DebugLog.inst_d(dexc.dexa("efmjwfszJotu!rvfsz!epof!") + Utils.getCostTime(lastCheckedTime));
    }

    public static Future<Set<String>> startNormalInstScan(final Map<String, String> map) {
        return ThreadUtils.runOnThreadPool(new Callable() { // from class: com.zj.adlib.ga0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AppInstUtil.dexa(map);
            }
        });
    }

    public static Future<Set<String>> startRealTimeInstScan(final Map<String, String> map) {
        return ThreadUtils.runOnThreadPool(new Callable() { // from class: com.zj.adlib.aa0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AppInstUtil.dexb(map);
            }
        });
    }

    public static void startSyncFullInstScan() {
        startSyncFullInstScan(null);
    }

    public static void startSyncFullInstScan(final SdkMediationAppResp sdkMediationAppResp) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.y90
            @Override // java.lang.Runnable
            public final void run() {
                AppInstUtil.dexa(sdkMediationAppResp);
            }
        });
    }

    public static /* synthetic */ Set dexa(Map map) throws Exception {
        Set<String> normalInstalledFromRealtimeScan;
        FullInstBean fullInstBean = ConstantInfo.Config.fullInstBean;
        if (fullInstBean != null) {
            normalInstalledFromRealtimeScan = getNormalInstFromTotalInst(fullInstBean, map);
        } else {
            normalInstalledFromRealtimeScan = getNormalInstalledFromRealtimeScan(map);
        }
        DebugLog.inst_d(dexc.dexa("opsnbmJotu!rvfsz!epof-iju!") + normalInstalledFromRealtimeScan.size());
        return normalInstalledFromRealtimeScan;
    }

    public static /* synthetic */ void dexa(Set set, long j) {
        NormalInstBean normalInstBean = new NormalInstBean();
        normalInstBean.setNormalInstIdSet(set);
        normalInstBean.setRoll64(j);
        SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc()).savePreferencesString(SharedPreferencesHelper.ConfigType.EXT, dexc.dexa("nn`fyu`l4"), GsonUtils.getInstance().toJson(normalInstBean));
    }

    public static /* synthetic */ void dexa(Context context, Set set) {
        InstReportBean instReportBeanBuildInstReportBean = buildInstReportBean(context, set);
        if (instReportBeanBuildInstReportBean == null) {
            DebugLog.inst_w(dexc.dexa("sfqpsuJotuJogp!gbjm-ebub!jt!ovmm"));
        } else {
            ReportUtils.reportInstInfo(instReportBeanBuildInstReportBean);
        }
    }
}
