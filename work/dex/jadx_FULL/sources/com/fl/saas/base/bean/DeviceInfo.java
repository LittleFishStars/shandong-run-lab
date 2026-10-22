package com.fl.saas.base.bean;

import android.os.Build;
import androidx.annotation.Keep;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.OaidUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Keep
public class DeviceInfo {
    private static final String os = "Android";
    private String boot_mark;
    private String update_mark;
    private String verCodeOfAG;
    private String verCodeOfHms;
    private static final String osv = DeviceUtil.getDeviceSystemVersion();
    private static final int devicetype = DeviceUtil.isTablet() ? 1 : 0;
    private static final String brand = DeviceUtil.getDeviceBrand();
    private static final float density = DeviceUtil.getScreenDensity();
    private final String connectiontype = DeviceUtil.getNetworkType();
    private final String carrier = DeviceUtil.getOperators();
    private final int orientation = DeviceUtil.getOrientation();
    private final int sw = DeviceUtil.getMobileWidth();
    private final int sh = DeviceUtil.getMobileHeight();
    private final String model = DeviceUtil.getDeviceModel();
    private final String imei = DeviceUtil.getImei();
    private final String oaid = OaidUtils.getOaid();
    private final String androidid = DeviceUtil.getAndroidID();
    private final String mac = DeviceUtil.getMacAddress();
    private final String mark = DeviceUtil.getDeviceMANUFACTURER();
    private final int api_level = Build.VERSION.SDK_INT;

    public DeviceInfo() {
        try {
            this.boot_mark = DeviceUtil.getBootMark();
            this.update_mark = DeviceUtil.getUpdateMark();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.verCodeOfHms = DeviceUtil.directGetHmsVersionCode();
        this.verCodeOfAG = DeviceUtil.directGetAgVersionCode();
    }

    public static DeviceInfo create() {
        return new DeviceInfo();
    }
}
