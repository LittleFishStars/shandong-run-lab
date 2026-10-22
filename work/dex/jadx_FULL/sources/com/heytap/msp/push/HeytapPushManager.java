package com.heytap.msp.push;

import android.content.Context;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.notification.PushNotificationManager;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class HeytapPushManager {
    public static void cancelNotification(JSONObject jSONObject) {
        PushService.getInstance().cancelNotification(jSONObject);
    }

    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(JSONObject jSONObject) {
        PushService.getInstance().clearNotificationType(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject jSONObject) {
        PushService.getInstance().clearNotifications(jSONObject);
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        PushService.getInstance().disableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        PushService.getInstance().enableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        PushService.getInstance().getAppNotificationSwitch(iGetAppNotificationCallBackService);
    }

    public static String getMcsPackageName(Context context) {
        return PushService.getInstance().getMcsPackageName(context);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        PushService.getInstance().getNotificationStatus(jSONObject);
    }

    public static ICallBackResultService getPushCallback() {
        return PushService.getInstance().getPushCallback();
    }

    public static PushNotificationManager getPushNotificationManager() {
        return PushNotificationManager.getInstance();
    }

    public static void getPushStatus() {
        PushService.getInstance().getPushStatus();
    }

    public static int getPushVersionCode() {
        return PushService.getInstance().getPushVersionCode();
    }

    public static String getPushVersionName() {
        return PushService.getInstance().getPushVersionName();
    }

    public static String getReceiveSdkAction(Context context) {
        return PushService.getInstance().getReceiveSdkAction(context);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject jSONObject) {
        PushService.getInstance().getRegister(jSONObject);
    }

    public static String getRegisterID() {
        return PushService.getInstance().getRegisterID();
    }

    public static int getSDKVersionCode() {
        return PushService.getSDKVersionCode();
    }

    public static String getSDKVersionName() {
        return PushService.getSDKVersionName();
    }

    public static void init(Context context, boolean z) {
        PushService.getInstance().init(context, z);
    }

    public static boolean isSupportPush(Context context) {
        return PushService.getInstance().isSupportPushByClient(context);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        PushService.getInstance().openNotificationSettings(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject jSONObject) {
        PushService.getInstance().pausePush(jSONObject);
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        PushService.getInstance().register(context, str, str2, jSONObject, iCallBackResultService);
    }

    @Deprecated
    public static void requestNotificationPermission() {
        PushService.getInstance().requestNotificationPermission();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject jSONObject) {
        PushService.getInstance().resumePush(jSONObject);
    }

    public static void setAppKeySecret(String str, String str2) {
        PushService.getInstance().setAppKeySecret(str, str2);
    }

    public static void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    public static void setNotificationType(int i, JSONObject jSONObject) {
        PushService.getInstance().setNotificationType(i, jSONObject);
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        PushService.getInstance().setPushCallback(iCallBackResultService);
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        PushService.getInstance().setPushTime(list, i, i2, i3, i4, jSONObject);
    }

    public static void setRegisterID(String str) {
        PushService.getInstance().setRegisterID(str);
    }

    public static void statisticEvent(Context context, String str, DataMessage dataMessage) {
        StatisticUtils.statisticEvent(context, str, dataMessage);
    }

    @Deprecated
    public static void statisticMessage(Context context, MessageStat messageStat) {
        StatUtil.statisticMessage(context, messageStat);
    }

    @Deprecated
    public static void statisticMessage(Context context, List<MessageStat> list) {
        StatUtil.statisticMessage(context, list);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        PushService.getInstance().unRegister(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(JSONObject jSONObject) {
        PushService.getInstance().unRegister(jSONObject);
    }
}
