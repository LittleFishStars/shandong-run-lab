package com.czhj.sdk.common.models;

import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.TimeZone;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ModelBuilderCreator {
    private static WXProgramReq wxProgramReq;

    public static AdSlot.Builder createAdSlot() {
        return new AdSlot.Builder();
    }

    public static App.Builder createApp() {
        App.Builder builder = new App.Builder();
        try {
            if (ClientMetadata.getInstance().getAppPackageName() != null) {
                builder.app_package(ClientMetadata.getInstance().getAppPackageName());
            }
            builder.orientation(ClientMetadata.getInstance().getOrientationInt());
            String appName = ClientMetadata.getInstance().getAppName();
            if (!TextUtils.isEmpty(appName)) {
                builder.name(appName);
            }
            builder.support_http = Boolean.valueOf(NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted());
            String appVersion = ClientMetadata.getInstance().getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                builder.app_version(createVersion(appVersion).build());
            }
            builder.idfv("android");
            builder.sdk_ext_cap.add(3);
            builder.install_time(Long.valueOf(ClientMetadata.getInstance().getInstallTime()));
        } catch (Throwable th) {
            SigmobLog.e("App Builder failed", th);
        }
        return builder;
    }

    public static Device.Builder createDevice() {
        return createDevice(null);
    }

    public static Device.Builder createDevice(DeviceContext deviceContext) {
        Device.Builder builder = new Device.Builder();
        builder.device_type(Integer.valueOf(ClientMetadata.getInstance().isTablet() ? 5 : 4));
        builder.os_type(2);
        try {
            Size.Builder builder2 = new Size.Builder();
            builder2.height = Integer.valueOf(ClientMetadata.getInstance().getRealMetrics().heightPixels);
            builder2.width = Integer.valueOf(ClientMetadata.getInstance().getRealMetrics().widthPixels);
            builder.resolution(builder2.build());
            builder.battery_level(ClientMetadata.getInstance().getBatteryLevel());
            builder.battery_state(ClientMetadata.getInstance().getBatteryState());
            builder.battery_save_enabled(ClientMetadata.getInstance().getBatterySaveEnable());
            builder.dpi(Integer.valueOf(ClientMetadata.getInstance().getDensityDpi()));
            builder.os_version(createVersion(ClientMetadata.getDeviceOsVersion()).build());
            builder.vendor(ClientMetadata.getDeviceManufacturer());
            builder.is_root(Boolean.valueOf(ClientMetadata.isRoot()));
            Size.Builder builderWidth = new Size.Builder().height(ClientMetadata.getInstance().getDeviceScreenHeightDip()).width(ClientMetadata.getInstance().getDeviceScreenWidthDip());
            if (!TextUtils.isEmpty(ClientMetadata.getDeviceModel())) {
                builder.model(ClientMetadata.getDeviceModel());
            }
            builder.screen_size(builderWidth.build());
            builder.geo(createGeo(deviceContext).build());
            String deviceName = ClientMetadata.getInstance().getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                builder.device_name(deviceName);
            }
            builder.start_timestamp(ClientMetadata.getBootSystemTime());
            builder.android_api_level(ClientMetadata.getDeviceOSLevel());
            builder.mem_size(ClientMetadata.getInstance().getSystemTotalMemorySize());
            if (deviceContext == null || deviceContext.allowReadSpaceSize()) {
                builder.disk_size(Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
                builder.total_disk_size(Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
                builder.free_disk_size(Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                String sDCardPath = ClientMetadata.getInstance().getSDCardPath();
                if (!TextUtils.isEmpty(sDCardPath)) {
                    builder.sd_total_disk_size(Long.valueOf(new File(sDCardPath).getTotalSpace()));
                    builder.sd_free_disk_size(Long.valueOf(new File(sDCardPath).getFreeSpace()));
                }
            }
            String bootId = ClientMetadata.getInstance().getBootId();
            if (!TextUtils.isEmpty(bootId)) {
                builder.boot_mark(bootId);
            }
            String updateId = ClientMetadata.getInstance().getUpdateId();
            if (!TextUtils.isEmpty(updateId)) {
                builder.update_mark(updateId);
            }
            RomUtils.RomInfo romInfo = RomUtils.getRomInfo();
            if (romInfo != null) {
                builder.rom_name(romInfo.getName());
                Version.Builder builderCreateVersion = createVersion(romInfo.getVersion());
                builderCreateVersion.version_str(romInfo.getVersion());
                builder.rom_version(builderCreateVersion.build());
            }
        } catch (Throwable th) {
            SigmobLog.e("Device Builder failed", th);
        }
        return builder;
    }

    public static DeviceId.Builder createDeviceId() {
        return createDeviceId(null);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0105 A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #2 {all -> 0x0109, blocks: (B:56:0x00f7, B:58:0x0105), top: B:88:0x00f7, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x012c A[Catch: all -> 0x0130, TRY_LEAVE, TryCatch #0 {all -> 0x0130, blocks: (B:62:0x0122, B:64:0x012c), top: B:84:0x0122, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0149 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0151  */
    /* JADX WARN: Code duplicated, block: B:72:0x0153  */
    /* JADX WARN: Code duplicated, block: B:75:0x016c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static DeviceId.Builder createDeviceId(DeviceContext deviceContext) {
        boolean z;
        String vaid;
        String oaid_api;
        DeviceId.Builder builder = new DeviceId.Builder();
        try {
            String androidId = deviceContext == null ? ClientMetadata.getInstance().getAndroidId() : deviceContext.getAndroidId();
            if (!TextUtils.isEmpty(androidId)) {
                builder.android_id(androidId);
            }
            String udid = ClientMetadata.getInstance().getUDID();
            if (!TextUtils.isEmpty(udid)) {
                builder.udid(udid);
            }
            String advertisingId = ClientMetadata.getInstance().getAdvertisingId();
            if (!TextUtils.isEmpty(advertisingId)) {
                builder.gaid(advertisingId);
            }
            String uid = ClientMetadata.getUid();
            if (!TextUtils.isEmpty(uid)) {
                builder.uid(uid);
            }
            String deviceId = deviceContext == null ? ClientMetadata.getInstance().getDeviceId() : deviceContext.getImei();
            if (!TextUtils.isEmpty(deviceId)) {
                builder.imei(deviceId);
            }
            String deviceSerial = ClientMetadata.getInstance().getDeviceSerial();
            if (!TextUtils.isEmpty(deviceSerial)) {
                builder.android_uuid(deviceSerial);
            }
            String imsi = ClientMetadata.getInstance().getIMSI();
            if (!TextUtils.isEmpty(imsi)) {
                builder.imsi(imsi);
            }
            String deviceId2 = deviceContext == null ? ClientMetadata.getInstance().getDeviceId(0) : deviceContext.getImei1();
            if (!TextUtils.isEmpty(deviceId2)) {
                builder.imei1(deviceId2);
            }
            String deviceId3 = deviceContext == null ? ClientMetadata.getInstance().getDeviceId(1) : deviceContext.getImei2();
            if (!TextUtils.isEmpty(deviceId3)) {
                builder.imei2(deviceId3);
            }
            String deviceBrand = ClientMetadata.getDeviceBrand();
            if (!TextUtils.isEmpty(deviceBrand)) {
                builder.brand(deviceBrand);
            }
            try {
                String oaid = deviceContext == null ? ClientMetadata.getInstance().getOAID() : deviceContext.getOaid();
                if (TextUtils.isEmpty(oaid)) {
                    oaid_api = ClientMetadata.getInstance().getOAID_API();
                    if (TextUtils.isEmpty(oaid_api)) {
                        vaid = ClientMetadata.getVAID();
                        if (!TextUtils.isEmpty(vaid)) {
                            builder.vaid(vaid);
                            if (deviceContext != null) {
                                if (deviceContext.isCustomPhoneState()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                builder.is_custom_imei(Boolean.valueOf(z));
                                builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                                builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                            }
                        } else if (deviceContext != null) {
                            if (deviceContext.isCustomPhoneState()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            builder.is_custom_imei(Boolean.valueOf(z));
                            builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                            builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                        }
                    } else {
                        builder.oaid_api(oaid_api);
                        vaid = ClientMetadata.getVAID();
                        if (!TextUtils.isEmpty(vaid)) {
                            builder.vaid(vaid);
                            if (deviceContext != null) {
                                if (deviceContext.isCustomPhoneState()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                builder.is_custom_imei(Boolean.valueOf(z));
                                builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                                builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                            }
                        } else if (deviceContext != null) {
                            if (deviceContext.isCustomPhoneState()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            builder.is_custom_imei(Boolean.valueOf(z));
                            builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                            builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                        }
                    }
                } else {
                    builder.oaid(oaid);
                    try {
                        oaid_api = ClientMetadata.getInstance().getOAID_API();
                        if (TextUtils.isEmpty(oaid_api)) {
                            builder.oaid_api(oaid_api);
                            try {
                                vaid = ClientMetadata.getVAID();
                                if (!TextUtils.isEmpty(vaid)) {
                                    builder.vaid(vaid);
                                    if (deviceContext != null) {
                                        try {
                                            if (deviceContext.isCustomPhoneState()) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            builder.is_custom_imei(Boolean.valueOf(z));
                                            builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                                            builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                                        } catch (Throwable th) {
                                            SigmobLog.e("getCustomController " + th.getMessage());
                                        }
                                    }
                                } else if (deviceContext != null) {
                                    if (deviceContext.isCustomPhoneState()) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    builder.is_custom_imei(Boolean.valueOf(z));
                                    builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                                    builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                                }
                            } catch (Throwable th2) {
                                SigmobLog.e("getVAID " + th2.getMessage());
                            }
                        } else {
                            vaid = ClientMetadata.getVAID();
                            if (!TextUtils.isEmpty(vaid)) {
                                builder.vaid(vaid);
                                if (deviceContext != null) {
                                    if (deviceContext.isCustomPhoneState()) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    builder.is_custom_imei(Boolean.valueOf(z));
                                    builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                                    builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                                }
                            } else if (deviceContext != null) {
                                if (deviceContext.isCustomPhoneState()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                builder.is_custom_imei(Boolean.valueOf(z));
                                builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                                builder.is_custom_android_id(Boolean.valueOf(deviceContext.isCustomAndroidId() ? false : true));
                            }
                        }
                    } catch (Throwable th3) {
                        SigmobLog.e("getOAID_API " + th3.getMessage());
                    }
                }
            } catch (Throwable th4) {
                SigmobLog.e("getOAID " + th4.getMessage());
            }
        } catch (Throwable th5) {
            SigmobLog.e("DeviceId Builder failed", th5);
        }
        return builder;
    }

    public static Geo.Builder createGeo() {
        return createGeo(null);
    }

    public static Geo.Builder createGeo(DeviceContext deviceContext) {
        Geo.Builder builder = new Geo.Builder();
        try {
            builder.country(ClientMetadata.getInstance().getDeviceLocale().getCountry());
            builder.language(ClientMetadata.getInstance().getDeviceLocale().getLanguage().toUpperCase());
            Location location = deviceContext == null ? ClientMetadata.getInstance().getLocation() : deviceContext.getLocation();
            if (location != null) {
                builder.lat(Float.valueOf((float) location.getLatitude()));
                builder.lon(Float.valueOf((float) location.getLongitude()));
                builder.accuracy(location.hasAccuracy() ? Double.valueOf(location.getAccuracy()) : Double.valueOf(500.0d));
            }
            builder.timeZone(TimeZone.getDefault().getID());
            builder.secondsFromGMT(String.valueOf(TimeZone.getDefault().getRawOffset()));
        } catch (Throwable th) {
            SigmobLog.e("Geo Builder failed", th);
        }
        return builder;
    }

    public static Network.Builder createNetwork() {
        return createNetwork(null);
    }

    public static Network.Builder createNetwork(DeviceContext deviceContext) {
        Network.Builder builder = new Network.Builder();
        ClientMetadata clientMetadata = ClientMetadata.getInstance();
        try {
            builder.connection_type(Integer.valueOf(clientMetadata.getActiveNetworkType()));
            String userAgent = Networking.getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                builder.ua(userAgent);
            }
            String macAddress = ClientMetadata.getMacAddress();
            if (!TextUtils.isEmpty(macAddress)) {
                builder.mac(macAddress);
            }
            String wifimac = clientMetadata.getWifimac();
            if (!TextUtils.isEmpty(wifimac)) {
                builder.wifi_mac(wifimac);
            }
            String wifiName = clientMetadata.getWifiName();
            if (!TextUtils.isEmpty(wifiName)) {
                builder.wifi_id(wifiName);
            }
            String networkOperatorForUrl = deviceContext == null ? clientMetadata.getNetworkOperatorForUrl() : deviceContext.getCarrier();
            if (!TextUtils.isEmpty(networkOperatorForUrl)) {
                builder.operator(networkOperatorForUrl);
            }
            String networkOperatorName = deviceContext == null ? clientMetadata.getNetworkOperatorName() : deviceContext.getCarrierName();
            if (!TextUtils.isEmpty(networkOperatorName)) {
                builder.carrier_name(networkOperatorName);
            }
            if (deviceContext != null) {
                builder.is_custom_operator_code(Boolean.valueOf(deviceContext.isCustomOperatorCode()));
                builder.is_custom_operator_name(Boolean.valueOf(deviceContext.isCustomOperatorName()));
            }
        } catch (Throwable th) {
            SigmobLog.e("Network Builder failed", th);
        }
        return builder;
    }

    private static Version.Builder createVersion(int i, int i2, int i3) {
        Version.Builder builder = new Version.Builder();
        builder.major(Integer.valueOf(i));
        builder.micro(Integer.valueOf(i2));
        builder.minor(Integer.valueOf(i3));
        return builder;
    }

    public static Version.Builder createVersion(String str) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length <= 2) {
                if (strArrSplit.length > 1) {
                    i3 = Integer.parseInt(strArrSplit[0]);
                    i2 = Integer.parseInt(strArrSplit[1]);
                } else if (strArrSplit.length > 0) {
                    i2 = 0;
                    i4 = Integer.parseInt(strArrSplit[0]);
                    i = 0;
                } else {
                    i = 0;
                    i2 = 0;
                }
                return createVersion(i4, i, i2).version_str(str);
            }
            i3 = Integer.parseInt(strArrSplit[0]);
            i2 = Integer.parseInt(strArrSplit[1]);
            i4 = Integer.parseInt(strArrSplit[2]);
            i = i4;
            i4 = i3;
        } catch (Throwable unused) {
        }
        return createVersion(i4, i, i2).version_str(str);
    }

    public static WXProgramReq createWXProgramReq() {
        WXProgramReq wXProgramReq = wxProgramReq;
        if (wXProgramReq != null) {
            return wXProgramReq;
        }
        final WXProgramReq.Builder builder = new WXProgramReq.Builder();
        FutureTask futureTask = new FutureTask(new Runnable() { // from class: com.czhj.sdk.common.models.ModelBuilderCreator.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Method method = WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class);
                    method.setAccessible(true);
                    Object objInvoke = method.invoke(WXAPIFactory.class, ClientMetadata.getInstance().getContext(), "");
                    Method method2 = objInvoke.getClass().getMethod("isWXAppInstalled", new Class[0]);
                    method2.setAccessible(true);
                    boolean zBooleanValue = ((Boolean) method2.invoke(objInvoke, new Object[0])).booleanValue();
                    Method method3 = objInvoke.getClass().getMethod("getWXAppSupportAPI", new Class[0]);
                    method3.setAccessible(true);
                    int iIntValue = ((Integer) method3.invoke(objInvoke, new Object[0])).intValue();
                    Field declaredField = Build.class.getDeclaredField("SDK_INT");
                    declaredField.setAccessible(true);
                    int iIntValue2 = ((Integer) declaredField.get(null)).intValue();
                    builder.wx_installed(Boolean.valueOf(zBooleanValue));
                    builder.wx_api_ver(Integer.valueOf(iIntValue));
                    builder.opensdk_ver(String.valueOf(iIntValue2));
                } catch (Throwable th) {
                    SigmobLog.e("createWXProgramReq failed" + th.getMessage());
                }
            }
        }, builder);
        ThreadPoolFactory.getFixIOExecutor().submit(futureTask);
        try {
            wxProgramReq = ((WXProgramReq.Builder) futureTask.get(200L, TimeUnit.MILLISECONDS)).build();
        } catch (Throwable unused) {
        }
        return wxProgramReq;
    }
}
