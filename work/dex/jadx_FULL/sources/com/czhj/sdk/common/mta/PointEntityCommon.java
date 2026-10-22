package com.czhj.sdk.common.mta;

import android.location.Location;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.network.Networking;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class PointEntityCommon extends PointEntitySuper {
    public String getBattery_level() {
        return String.format("%.2f", ClientMetadata.getInstance().getBatteryLevel());
    }

    public String getBattery_save_enabled() {
        return String.valueOf(ClientMetadata.getInstance().getBatterySaveEnable());
    }

    public String getBattery_state() {
        return String.valueOf(ClientMetadata.getInstance().getBatteryState());
    }

    public String getBrand() {
        return ClientMetadata.getDeviceBrand();
    }

    public String getBrowser() {
        return Networking.getUserAgent();
    }

    public String getCheight() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenHeightDip());
    }

    public String getClientpixel() {
        return String.format("%sx%s", Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().widthPixels), Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().heightPixels));
    }

    public String getClienttype() {
        return ClientMetadata.getDeviceModel();
    }

    public String getCwidth() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenWidthDip());
    }

    public String getDevice_type() {
        return ClientMetadata.getInstance().isTablet() ? "5" : "4";
    }

    public String getDheight() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip());
    }

    public String getDwidth() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip());
    }

    public String getIsEmulator() {
        return ClientMetadata.isEmulator() ? "1" : "0";
    }

    public String getLat() {
        DeviceContext deviceContext = getDeviceContext();
        Location location = deviceContext == null ? ClientMetadata.getInstance().getLocation() : deviceContext.getLocation();
        if (location == null) {
            return null;
        }
        return String.valueOf(location.getLatitude());
    }

    public String getLng() {
        DeviceContext deviceContext = getDeviceContext();
        Location location = deviceContext == null ? ClientMetadata.getInstance().getLocation() : deviceContext.getLocation();
        if (location == null) {
            return null;
        }
        return String.valueOf(location.getLongitude());
    }

    public String getPkgname() {
        return ClientMetadata.getInstance().getAppPackageName();
    }

    public String getResolution() {
        return String.format("%sx%s", Integer.valueOf(ClientMetadata.getInstance().getRealMetrics().widthPixels), Integer.valueOf(ClientMetadata.getInstance().getRealMetrics().heightPixels));
    }

    public String getScreenangle() {
        return String.valueOf(Math.abs(ClientMetadata.getInstance().getOrientationInt().intValue() - 1) * 90);
    }

    public String getScreendensity() {
        return String.valueOf(ClientMetadata.getInstance().getDensityDpi());
    }

    public String getTargetSdkVersion() {
        return ClientMetadata.getInstance().getTargetSdkVersion();
    }

    public String getVender() {
        return ClientMetadata.getDeviceManufacturer();
    }

    public String getWifi_id() {
        String wifiName = ClientMetadata.getInstance().getWifiName();
        return TextUtils.isEmpty(wifiName) ? wifiName : Base64.encodeToString(ClientMetadata.getInstance().getWifiName().getBytes(), 2);
    }

    public String getWifi_mac() {
        return ClientMetadata.getInstance().getWifimac();
    }
}
