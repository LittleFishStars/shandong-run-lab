package com.fl.saas.config.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.fl.saas.config.oaid.impl.OAIDFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DeviceID implements IGetter {
    private Context application;
    private String clientId;
    private String oaid;

    public static class Holder {
        static final DeviceID INSTANCE = new DeviceID();

        private Holder() {
        }
    }

    private DeviceID() {
    }

    public static String calculateHash(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            OAIDLog.print(e);
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidID(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String getClientId() {
        String str = Holder.INSTANCE.clientId;
        return str == null ? "" : str;
    }

    public static String getClientIdMD5() {
        return calculateHash(getClientId(), "MD5");
    }

    public static String getClientIdSHA1() {
        return calculateHash(getClientId(), "SHA-1");
    }

    public static String getGUID(Context context) {
        String uuidFromSystemSettings = getUuidFromSystemSettings(context);
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromExternalStorage(context);
        }
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromSharedPreferences(context);
        }
        if (!TextUtils.isEmpty(uuidFromSystemSettings)) {
            return uuidFromSystemSettings;
        }
        String string = UUID.randomUUID().toString();
        OAIDLog.print("Generate uuid by random: " + string);
        saveUuidToSharedPreferences(context, string);
        saveUuidToSystemSettings(context, string);
        saveUuidToExternalStorage(context, string);
        return string;
    }

    private static File getGuidFile(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT <= 29 && context != null && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            z = true;
        }
        if (z && "mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String getIMEI(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            String imei = telephonyManager.getImei();
            return TextUtils.isEmpty(imei) ? telephonyManager.getMeid() : imei;
        } catch (Error | Exception e) {
            OAIDLog.print(e);
            return "";
        }
    }

    public static String getOAID() {
        String str = Holder.INSTANCE.oaid;
        return str == null ? "" : str;
    }

    public static void getOAID(Context context, IGetter iGetter) {
        OAIDFactory.create(context).doGet(iGetter);
    }

    public static String getPseudoID() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BOARD.length() % 10);
        sb.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb.append(Build.DEVICE.length() % 10);
        sb.append(Build.DISPLAY.length() % 10);
        sb.append(Build.HOST.length() % 10);
        sb.append(Build.ID.length() % 10);
        sb.append(Build.MANUFACTURER.length() % 10);
        sb.append(Build.BRAND.length() % 10);
        sb.append(Build.MODEL.length() % 10);
        sb.append(Build.PRODUCT.length() % 10);
        sb.append(Build.BOOTLOADER.length() % 10);
        sb.append(Build.HARDWARE.length() % 10);
        sb.append(Build.TAGS.length() % 10);
        sb.append(Build.TYPE.length() % 10);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    public static String getUniqueID(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 29) {
            str = "IMEI/MEID not allowed on Android 10+";
        } else {
            if (context == null) {
                return "";
            }
            if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                return getIMEI(context);
            }
            str = "android.permission.READ_PHONE_STATE not granted";
        }
        OAIDLog.print(str);
        return "";
    }

    private static String getUuidFromExternalStorage(Context context) {
        String line = "";
        if (context == null) {
            return "";
        }
        File guidFile = getGuidFile(context);
        if (guidFile != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(guidFile));
                try {
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                OAIDLog.print(e);
            }
        }
        OAIDLog.print("Get uuid from external storage: " + line);
        return line;
    }

    private static String getUuidFromSharedPreferences(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        OAIDLog.print("Get uuid from shared preferences: " + string);
        return string;
    }

    private static String getUuidFromSystemSettings(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        OAIDLog.print("Get uuid from system settings: " + string);
        return string;
    }

    public static String getWidevineID() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Error | Exception e) {
            OAIDLog.print(e);
            return "";
        }
    }

    public static void register(Context context) {
        if (context == null) {
            return;
        }
        DeviceID deviceID = Holder.INSTANCE;
        deviceID.application = context;
        String uniqueID = getUniqueID(context);
        if (TextUtils.isEmpty(uniqueID)) {
            getOAID(context, deviceID);
            return;
        }
        deviceID.clientId = uniqueID;
        OAIDLog.print("Client id is IMEI/MEID: " + deviceID.clientId);
    }

    private static void saveUuidToExternalStorage(Context context, String str) {
        if (context == null) {
            return;
        }
        File guidFile = getGuidFile(context);
        if (guidFile == null) {
            OAIDLog.print("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(guidFile));
            try {
                if (!guidFile.exists()) {
                    guidFile.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                OAIDLog.print("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    private static void saveUuidToSharedPreferences(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        OAIDLog.print("Save uuid to shared preferences: " + str);
    }

    private static void saveUuidToSystemSettings(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Settings.System.canWrite(context)) {
            try {
                Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
                OAIDLog.print("Save uuid to system settings: " + str);
                return;
            } catch (Exception e) {
                e = e;
            }
        } else {
            e = "android.permission.WRITE_SETTINGS not granted";
        }
        OAIDLog.print(e);
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    @Override // com.fl.saas.config.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException("OAID is empty"));
            return;
        }
        this.clientId = str;
        this.oaid = str;
        OAIDLog.print("Client id is OAID/AAID: " + this.clientId);
    }

    @Override // com.fl.saas.config.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
        StringBuilder sb;
        String str;
        String widevineID = getWidevineID();
        if (TextUtils.isEmpty(widevineID)) {
            String androidID = getAndroidID(this.application);
            if (TextUtils.isEmpty(androidID)) {
                this.clientId = getGUID(this.application);
                sb = new StringBuilder();
                str = "Client id is GUID: ";
            } else {
                this.clientId = androidID;
                sb = new StringBuilder();
                str = "Client id is AndroidID: ";
            }
        } else {
            this.clientId = widevineID;
            sb = new StringBuilder();
            str = "Client id is WidevineID: ";
        }
        sb.append(str);
        sb.append(this.clientId);
        OAIDLog.print(sb.toString());
    }
}
