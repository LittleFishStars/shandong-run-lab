package cj.mobile.wm;

import android.content.Context;
import android.os.Build;
import cj.mobile.wm.common.bean.ActionReqBean;
import cj.mobile.wm.common.bean.AppConfigReqBean;
import cj.mobile.wm.common.bean.ScreenSize;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.DeviceUtils;
import cj.mobile.wm.common.utils.PrivateInfoHelper;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.okhttp.utils.AesUtil;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexk {
    public static final String dexa = "dexk";

    /* JADX WARN: Code duplicated, block: B:39:0x0258 A[Catch: all -> 0x02a3, TryCatch #2 {all -> 0x02a3, blocks: (B:3:0x0077, B:27:0x01cc, B:32:0x01fb, B:37:0x0237, B:39:0x0258, B:40:0x025f, B:44:0x0288, B:36:0x021d, B:31:0x01e1, B:26:0x01b2, B:22:0x018f, B:18:0x016b, B:14:0x013b, B:10:0x0118, B:28:0x01d1, B:23:0x01a9, B:41:0x0270, B:5:0x0104, B:7:0x0108, B:15:0x0155, B:11:0x0132, B:33:0x0209, B:19:0x0185), top: B:54:0x0077, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    public static AppConfigReqBean dexa(Context context, String str, String str2) {
        AppConfigReqBean.DataBean.Networks networks;
        String strMd5Decode = AesUtil.md5Decode(str2 + str);
        AppConfigReqBean appConfigReqBean = new AppConfigReqBean();
        appConfigReqBean.setSign(strMd5Decode);
        appConfigReqBean.setApptoken(str);
        AppConfigReqBean.DataBean dataBean = new AppConfigReqBean.DataBean();
        AppConfigReqBean.DataBean.App app = new AppConfigReqBean.DataBean.App();
        app.setAppName(Utils.getAppName(context.getApplicationContext()) + "");
        app.setPkgName(context.getApplicationContext().getPackageName() + "");
        app.setAppVersion(Utils.getVersionName(context) + "");
        dataBean.setApp(app);
        try {
            AppConfigReqBean.DataBean.Device device = new AppConfigReqBean.DataBean.Device();
            device.setTimezone(Utils.getTimeZone());
            device.setOsType(1);
            device.setDeviceType(DeviceUtils.getDeviceType(context.getApplicationContext()));
            device.setOsVersion(String.valueOf(Build.VERSION.RELEASE));
            device.setLanguage(Locale.getDefault().getLanguage());
            device.setResolution(DeviceUtils.getDeviceResolution(context.getApplicationContext(), true));
            device.setMac(PrivateInfoHelper.getMac(context));
            device.setVendor(Build.BRAND);
            device.setModel(Build.MODEL);
            device.setDpi(String.valueOf(DeviceUtils.getDeviceDensity(context.getApplicationContext())));
            device.setXdpi(String.valueOf(context.getApplicationContext().getResources().getDisplayMetrics().xdpi));
            device.setYdpi(String.valueOf(context.getApplicationContext().getResources().getDisplayMetrics().ydpi));
            device.setAndroidId(PrivateInfoHelper.getAndroidId(context));
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    device.setImei(PrivateInfoHelper.getIMEI(context));
                    device.setMeid(PrivateInfoHelper.getMEID(context));
                    try {
                        device.setOaid(PrivateInfoHelper.getOaid(context));
                    } catch (Throwable th) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!PBJE!gbjm!") + th);
                    }
                    try {
                        device.setFingerprint(ConstantInfo.deviceFingerprint);
                        device.setBoot_mark(ConstantInfo.bootMark);
                        device.setUpdate_mark(ConstantInfo.updateMark);
                        device.setCtzid(ConstantInfo.wmId);
                    } catch (Throwable th2) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!DoBeje!gbjm!") + th2);
                    }
                    try {
                        device.setPpi((int) DeviceUtils.getDeviceDensity(context));
                    } catch (Throwable th3) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!Qqj!gbjm!") + th3);
                    }
                    try {
                        device.setUa(Utils.getUserAgent(context));
                    } catch (Throwable th4) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!VB!gbjm!") + th4);
                    }
                    ScreenSize screenSize = new ScreenSize();
                    try {
                        screenSize.setHeight(DeviceUtils.getWindowHeight(context));
                        screenSize.setWidth(DeviceUtils.getWindowWidth(context));
                    } catch (Throwable th5) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!tdsffo!tj{f!gbjm!") + th5);
                    }
                    device.setScreenSize(screenSize);
                    device.setOrientation(DeviceUtils.getDeviceOrientation(context.getApplicationContext()));
                    try {
                        float deviceDensity = DeviceUtils.getDeviceDensity(context.getApplicationContext());
                        device.setDensity(String.valueOf(deviceDensity));
                        device.setPxratio(deviceDensity);
                    } catch (Throwable th6) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!Qysbujp!gbjm!") + th6);
                    }
                    dataBean.setDevice(device);
                    networks = new AppConfigReqBean.DataBean.Networks();
                    networks.setConnectionType(PrivateInfoHelper.getConnectType(context));
                    networks.setMcc(PrivateInfoHelper.getMCC(context));
                    networks.setMnc(PrivateInfoHelper.getMNC(context));
                    if (Build.VERSION.SDK_INT <= 28) {
                        networks.setImsi(PrivateInfoHelper.getIMSI(context));
                    }
                    networks.setOperator(PrivateInfoHelper.getOperator(context));
                    networks.setOperatorType(PrivateInfoHelper.getOperatorType(context));
                    dataBean.setNetwork(networks);
                    try {
                        AppConfigReqBean.DataBean.Gps gps = new AppConfigReqBean.DataBean.Gps();
                        gps.setLatitude(PrivateInfoHelper.getLatitude(context));
                        gps.setLongitude(PrivateInfoHelper.getLongitude(context));
                        dataBean.setGps(gps);
                    } catch (Throwable th7) {
                        DebugLog.W(dexa, dexc.dexa("ifbeCfbo!HQT!gbjm!") + th7);
                    }
                } else {
                    device.setOaid(PrivateInfoHelper.getOaid(context));
                    device.setFingerprint(ConstantInfo.deviceFingerprint);
                    device.setBoot_mark(ConstantInfo.bootMark);
                    device.setUpdate_mark(ConstantInfo.updateMark);
                    device.setCtzid(ConstantInfo.wmId);
                    device.setPpi((int) DeviceUtils.getDeviceDensity(context));
                    device.setUa(Utils.getUserAgent(context));
                    ScreenSize screenSize2 = new ScreenSize();
                    screenSize2.setHeight(DeviceUtils.getWindowHeight(context));
                    screenSize2.setWidth(DeviceUtils.getWindowWidth(context));
                    device.setScreenSize(screenSize2);
                    device.setOrientation(DeviceUtils.getDeviceOrientation(context.getApplicationContext()));
                    float deviceDensity2 = DeviceUtils.getDeviceDensity(context.getApplicationContext());
                    device.setDensity(String.valueOf(deviceDensity2));
                    device.setPxratio(deviceDensity2);
                    dataBean.setDevice(device);
                    networks = new AppConfigReqBean.DataBean.Networks();
                    networks.setConnectionType(PrivateInfoHelper.getConnectType(context));
                    networks.setMcc(PrivateInfoHelper.getMCC(context));
                    networks.setMnc(PrivateInfoHelper.getMNC(context));
                    if (Build.VERSION.SDK_INT <= 28) {
                        networks.setImsi(PrivateInfoHelper.getIMSI(context));
                    }
                    networks.setOperator(PrivateInfoHelper.getOperator(context));
                    networks.setOperatorType(PrivateInfoHelper.getOperatorType(context));
                    dataBean.setNetwork(networks);
                    AppConfigReqBean.DataBean.Gps gps2 = new AppConfigReqBean.DataBean.Gps();
                    gps2.setLatitude(PrivateInfoHelper.getLatitude(context));
                    gps2.setLongitude(PrivateInfoHelper.getLongitude(context));
                    dataBean.setGps(gps2);
                }
            } catch (Throwable th8) {
                DebugLog.W(dexa, dexc.dexa("ifbeCfbo!JNFJ!gbjm!") + th8);
            }
        } catch (Throwable th9) {
            DebugLog.W(dexa, dexc.dexa("hfuBqqDpogjhSfrCfbo!gbjm!") + th9);
            ReportUtils.exReport(context, 999981, dexc.dexa("鰸粃楅葇楲鵦"), dexc.dexa("滕蕩ꆎ辯鰸粃狦痈矅漻楲鵦)hfuBqqDpogjhSfrCfbo*;") + th9);
        }
        appConfigReqBean.setData(dataBean);
        return appConfigReqBean;
    }

    public static void dexa(Context context, ActionReqBean actionReqBean) {
        if (Build.VERSION.SDK_INT <= 28) {
            actionReqBean.setImei(PrivateInfoHelper.getIMEI(context));
        }
        actionReqBean.setOaid(PrivateInfoHelper.getOaid(context));
        actionReqBean.setApp_version(Utils.getVersionName(context));
        actionReqBean.setBrand(Build.BRAND);
        actionReqBean.setModel(Build.MODEL);
        actionReqBean.setOs_version(String.valueOf(Build.VERSION.RELEASE));
    }
}
