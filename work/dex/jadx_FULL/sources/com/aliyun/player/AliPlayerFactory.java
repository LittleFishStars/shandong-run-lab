package com.aliyun.player;

import android.content.Context;
import android.os.Build;
import com.aliyun.player.a.a;
import com.aliyun.player.nativeclass.NativeExternalPlayer;
import com.aliyun.player.nativeclass.NativePlayerBase;
import com.aliyun.private_service.PrivateService;
import com.aliyun.utils.DeviceInfoUtils;
import com.cicada.player.utils.ContentDataSource;
import com.cicada.player.utils.media.MediaCodecUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliPlayerFactory {
    private static List<DeviceInfo> sInnerBlackList = new ArrayList();

    public enum BlackType {
        HW_Decode_H264,
        HW_Decode_HEVC
    }

    public static class DeviceInfo {
        public String model;
    }

    public enum SupportFeatureType {
        FeatureDolbyAudio
    }

    static {
        initInnerBlackList();
        addBlackList(BlackType.HW_Decode_H264, sInnerBlackList);
        ApasaraExternalPlayer.registerExternalPlayer(new a());
    }

    public static void addBlackDevice(BlackType blackType, DeviceInfo deviceInfo) {
        if (deviceInfo == null || blackType == null) {
            return;
        }
        String str = Build.MODEL;
        if ((blackType == BlackType.HW_Decode_H264 || blackType == BlackType.HW_Decode_HEVC) && str.equals(deviceInfo.model)) {
            NativePlayerBase.setBlackType(blackType.ordinal());
        }
    }

    public static void addBlackList(BlackType blackType, List<DeviceInfo> list) {
        if (list == null) {
            return;
        }
        Iterator<DeviceInfo> it = list.iterator();
        while (it.hasNext()) {
            addBlackDevice(blackType, it.next());
        }
    }

    public static AliListPlayer createAliListPlayer(Context context) {
        return createAliListPlayer(context, null);
    }

    public static AliListPlayer createAliListPlayer(Context context, String str) {
        PrivateService.preInitService(context);
        NativeExternalPlayer.setContext(context);
        ContentDataSource.setContext(context);
        return new ApsaraVideoListPlayer(context, str);
    }

    public static AliLiveShiftPlayer createAliLiveShiftPlayer(Context context) {
        return createAliLiveShiftPlayer(context, null);
    }

    public static AliLiveShiftPlayer createAliLiveShiftPlayer(Context context, String str) {
        PrivateService.preInitService(context);
        NativeExternalPlayer.setContext(context);
        ContentDataSource.setContext(context);
        return new ApsaraLiveShiftPlayer(context, str);
    }

    public static AliPlayer createAliPlayer(Context context) {
        return createAliPlayer(context, null);
    }

    public static AliPlayer createAliPlayer(Context context, String str) {
        PrivateService.preInitService(context);
        NativeExternalPlayer.setContext(context);
        ContentDataSource.setContext(context);
        return new ApsaraVideoPlayer(context, str);
    }

    public static String getDeviceUUID() {
        return DeviceInfoUtils.getDeviceUUID();
    }

    public static String getSdkVersion() {
        return NativePlayerBase.getSdkVersion();
    }

    private static void initInnerBlackList() {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.model = "Lenovo K320t";
        sInnerBlackList.add(deviceInfo);
    }

    public static boolean isFeatureSupport(SupportFeatureType supportFeatureType) {
        if (supportFeatureType == SupportFeatureType.FeatureDolbyAudio) {
            return MediaCodecUtils.isDolbyAudioSupport();
        }
        return false;
    }

    public static void setConvertURLCallback(IPlayer.ConvertURLCallback convertURLCallback) {
        NativePlayerBase.setConvertURLCb(convertURLCallback);
    }
}
