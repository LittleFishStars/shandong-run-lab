package com.kc.bw.adIdUtils.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class DeviceIdentifier {
    public static volatile String androidId;
    public static volatile String clientId;
    public static volatile String guid;
    public static volatile String imei;
    public static volatile String oaid;
    public static volatile String pseudoId;
    public static volatile boolean registered;
    public static volatile String widevineId;

    public static String getAndroidID(Context context) {
        if (androidId == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (androidId == null) {
                        androidId = DeviceID.getAndroidID(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (androidId == null) {
            androidId = "";
        }
        return androidId;
    }

    public static String getClientId() {
        if (TextUtils.isEmpty(clientId)) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (TextUtils.isEmpty(clientId)) {
                        clientId = DeviceID.getClientIdMD5();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (clientId == null) {
            clientId = "";
        }
        return clientId;
    }

    public static String getGUID(Context context) {
        if (guid == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (guid == null) {
                        guid = DeviceID.getGUID(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (guid == null) {
            guid = "";
        }
        return guid;
    }

    public static String getIMEI(Context context) {
        if (imei == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (imei == null) {
                        imei = DeviceID.getUniqueID(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (imei == null) {
            imei = "";
        }
        return imei;
    }

    public static String getOAID(Context context) {
        if (TextUtils.isEmpty(oaid)) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (TextUtils.isEmpty(oaid)) {
                        oaid = DeviceID.getOAID();
                        if (oaid == null || oaid.length() == 0) {
                            DeviceID.getOAID(context, new IGetter() { // from class: com.kc.bw.adIdUtils.oaid.DeviceIdentifier.1
                                @Override // com.kc.bw.adIdUtils.oaid.IGetter
                                public void onOAIDGetComplete(String str) {
                                    String unused = DeviceIdentifier.oaid = str;
                                }

                                @Override // com.kc.bw.adIdUtils.oaid.IGetter
                                public void onOAIDGetError(Exception exc) {
                                    String unused = DeviceIdentifier.oaid = "";
                                }
                            });
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (oaid == null) {
            oaid = "";
        }
        return oaid;
    }

    public static String getPseudoID() {
        if (pseudoId == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (pseudoId == null) {
                        pseudoId = DeviceID.getPseudoID();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (pseudoId == null) {
            pseudoId = "";
        }
        return pseudoId;
    }

    public static String getWidevineID() {
        if (widevineId == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (widevineId == null) {
                        widevineId = DeviceID.getWidevineID();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (widevineId == null) {
            widevineId = "";
        }
        return widevineId;
    }

    public static void register(Application application) {
        if (registered) {
            return;
        }
        synchronized (DeviceIdentifier.class) {
            try {
                if (!registered) {
                    DeviceID.register(application);
                    registered = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
