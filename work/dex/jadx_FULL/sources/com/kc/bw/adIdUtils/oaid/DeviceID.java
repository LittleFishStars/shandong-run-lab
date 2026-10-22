package com.kc.bw.adIdUtils.oaid;

import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kc.bw.adIdUtils.oaid.impl.OAIDFactory;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class DeviceID implements IGetter {
    public Application application;
    public String clientId;
    public String oaid;

    @Keep
    public static class Holder {
        public static final DeviceID INSTANCE = new DeviceID();
    }

    public DeviceID() {
    }

    public static String calculateHash(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format(dexg.dexa("&13y"), Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable th) {
            OAIDLog.print(th);
            return "";
        }
    }

    public static String getAndroidID(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), dexg.dexa("boespje`je"))) == null || dexg.dexa(":885e67e793f65:d").equals(string)) ? "" : string;
    }

    public static String getClientId() {
        String str = Holder.INSTANCE.clientId;
        return str == null ? "" : str;
    }

    public static String getClientIdMD5() {
        return calculateHash(getClientId(), dexg.dexa("NE6"));
    }

    public static String getClientIdSHA1() {
        return calculateHash(getClientId(), dexg.dexa("TIB.2"));
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
        OAIDLog.print(dexg.dexa("Hfofsbuf!vvje!cz!sboepn;!") + string);
        saveUuidToSharedPreferences(context, string);
        saveUuidToSystemSettings(context, string);
        saveUuidToExternalStorage(context, string);
        return string;
    }

    public static File getGuidFile(Context context) {
        if ((Build.VERSION.SDK_INT < 30 && context != null && context.checkSelfPermission(dexg.dexa("boespje/qfsnjttjpo/XSJUF`FYUFSOBM`TUPSBHF")) == 0) && dexg.dexa("npvoufe").equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), dexg.dexa("Boespje0/HVJE`vvje"));
        }
        return null;
    }

    public static String getIMEI(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(dexg.dexa("qipof"));
            String imei = telephonyManager.getImei();
            return TextUtils.isEmpty(imei) ? telephonyManager.getMeid() : imei;
        } catch (Exception e) {
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
            str = "JNFJ0NFJE!opu!bmmpxfe!po!Boespje!21,";
        } else {
            if (context == null) {
                return "";
            }
            if (context.checkSelfPermission(dexg.dexa("boespje/qfsnjttjpo/SFBE`QIPOF`TUBUF")) == 0) {
                return getIMEI(context);
            }
            str = "boespje/qfsnjttjpo/SFBE`QIPOF`TUBUF!opu!hsboufe";
        }
        OAIDLog.print(dexg.dexa(str));
        return "";
    }

    public static String getUuidFromExternalStorage(Context context) {
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
            } catch (Throwable th3) {
                OAIDLog.print(th3);
            }
        }
        OAIDLog.print(dexg.dexa("Hfu!vvje!gspn!fyufsobm!tupsbhf;!") + line);
        return line;
    }

    public static String getUuidFromSharedPreferences(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences(dexg.dexa("HVJE"), 0).getString(dexg.dexa("vvje"), "");
        OAIDLog.print(dexg.dexa("Hfu!vvje!gspn!tibsfe!qsfgfsfodft;!") + string);
        return string;
    }

    public static String getUuidFromSystemSettings(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), dexg.dexa("HVJE`vvje"));
        OAIDLog.print(dexg.dexa("Hfu!vvje!gspn!tztufn!tfuujoht;!") + string);
        return string;
    }

    public static String getWidevineID() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray(dexg.dexa("efwjdfVojrvfJe"));
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(String.format(dexg.dexa("&13y"), Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            OAIDLog.print(e);
            return "";
        }
    }

    public static void register(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = Holder.INSTANCE;
        deviceID.application = application;
        String uniqueID = getUniqueID(application);
        if (TextUtils.isEmpty(uniqueID)) {
            getOAID(application, deviceID);
            return;
        }
        deviceID.clientId = uniqueID;
        OAIDLog.print(dexg.dexa("Dmjfou!je!jt!JNFJ0NFJE;!") + deviceID.clientId);
    }

    public static void saveUuidToExternalStorage(Context context, String str) {
        if (context == null) {
            return;
        }
        File guidFile = getGuidFile(context);
        if (guidFile == null) {
            OAIDLog.print(dexg.dexa("VVJE!gjmf!jo!fyufsobm!tupsbhf!jt!ovmm"));
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
                OAIDLog.print(dexg.dexa("Tbwf!vvje!up!fyufsobm!tupsbhf;!") + str);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            OAIDLog.print(th3);
        }
    }

    public static void saveUuidToSharedPreferences(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(dexg.dexa("HVJE"), 0).edit().putString(dexg.dexa("vvje"), str).apply();
        OAIDLog.print(dexg.dexa("Tbwf!vvje!up!tibsfe!qsfgfsfodft;!") + str);
    }

    public static void saveUuidToSystemSettings(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Settings.System.canWrite(context)) {
            try {
                Settings.System.putString(context.getContentResolver(), dexg.dexa("HVJE`vvje"), str);
                OAIDLog.print(dexg.dexa("Tbwf!vvje!up!tztufn!tfuujoht;!") + str);
                return;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            th = dexg.dexa("boespje/qfsnjttjpo/XSJUF`TFUUJOHT!opu!hsboufe");
        }
        OAIDLog.print(th);
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    @Override // com.kc.bw.adIdUtils.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException(dexg.dexa("PBJE!jt!fnquz")));
            return;
        }
        this.clientId = str;
        this.oaid = str;
        OAIDLog.print(dexg.dexa("Dmjfou!je!jt!PBJE0BBJE;!") + this.clientId);
    }

    @Override // com.kc.bw.adIdUtils.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
        StringBuilder sb;
        String str;
        String widevineID = getWidevineID();
        if (TextUtils.isEmpty(widevineID)) {
            String androidID = getAndroidID(this.application);
            if (TextUtils.isEmpty(androidID)) {
                this.clientId = getGUID(this.application);
                sb = new StringBuilder();
                str = "Dmjfou!je!jt!HVJE;!";
            } else {
                this.clientId = androidID;
                sb = new StringBuilder();
                str = "Dmjfou!je!jt!BoespjeJE;!";
            }
        } else {
            this.clientId = widevineID;
            sb = new StringBuilder();
            str = "Dmjfou!je!jt!XjefwjofJE;!";
        }
        sb.append(dexg.dexa(str));
        sb.append(this.clientId);
        OAIDLog.print(sb.toString());
    }
}
