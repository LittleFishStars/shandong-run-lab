package com.fl.saas.config.utils;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.fl.saas.base.bean.PMControlBean;
import com.fl.saas.com.HonorOaidHelper;
import com.fl.saas.config.oaid.DeviceID;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class OaidUtils {
    private static boolean isCanUseOAID = true;
    private static String oaid = "";

    /* JADX INFO: renamed from: com.fl.saas.config.utils.OaidUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements IGetter {
        final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context) {
            this.val$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onOAIDGetComplete$0(Context context) {
            try {
                HonorOaidHelper.OaidResult oaid = HonorOaidHelper.getOaid(context);
                String strHnid = oaid.oaid;
                if (TextUtils.isEmpty(strHnid) || strHnid.contains("0000")) {
                    strHnid = OaidUtils.hnid(context);
                }
                if (TextUtils.isEmpty(OaidUtils.oaid) || !OaidUtils.oaid.equals(strHnid)) {
                    String unused = OaidUtils.oaid = oaid.oaid;
                    SPUtil.getInstance().putString(DeviceIdType.OAID, strHnid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogcatUtil.d("YDSDK", "honor-oaid: " + OaidUtils.oaid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onOAIDGetError$1(Context context) {
            try {
                HonorOaidHelper.OaidResult oaid = HonorOaidHelper.getOaid(context);
                String strHnid = oaid.oaid;
                if (TextUtils.isEmpty(strHnid) || strHnid.contains("0000")) {
                    strHnid = OaidUtils.hnid(context);
                }
                if (TextUtils.isEmpty(OaidUtils.oaid) || !OaidUtils.oaid.equals(strHnid)) {
                    String unused = OaidUtils.oaid = oaid.oaid;
                    SPUtil.getInstance().putString(DeviceIdType.OAID, strHnid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogcatUtil.d("YDSDK", "honor-oaid: " + OaidUtils.oaid);
        }

        @Override // com.fl.saas.config.oaid.IGetter
        public void onOAIDGetComplete(String str) {
            if (TextUtils.isEmpty(OaidUtils.oaid) || !OaidUtils.oaid.equals(str)) {
                String unused = OaidUtils.oaid = str;
                SPUtil.getInstance().putString(DeviceIdType.OAID, str);
            }
            if ((TextUtils.isEmpty(str) || str.contains("0000")) && "HONOR".equalsIgnoreCase(DeviceUtil.getDeviceBrand())) {
                ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstance();
                final Context context = this.val$context;
                threadPoolManager.addTask(new Runnable() { // from class: com.fl.saas.config.utils.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        OaidUtils.AnonymousClass1.lambda$onOAIDGetComplete$0(context);
                    }
                });
            }
            LogcatUtil.d("YDSDK", "oaid: " + OaidUtils.oaid);
        }

        @Override // com.fl.saas.config.oaid.IGetter
        public void onOAIDGetError(Exception exc) {
            LogcatUtil.d("YDSDK", "oaidGetError: " + exc.getMessage());
            if ("HONOR".equalsIgnoreCase(DeviceUtil.getDeviceBrand())) {
                ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstance();
                final Context context = this.val$context;
                threadPoolManager.addTask(new Runnable() { // from class: com.fl.saas.config.utils.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        OaidUtils.AnonymousClass1.lambda$onOAIDGetError$1(context);
                    }
                });
            }
            LogcatUtil.d("YDSDK", "oaid: " + OaidUtils.oaid);
        }
    }

    public static String getOaid() {
        return oaid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hnid(Context context) {
        try {
            return TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), DeviceIdType.OAID)) ? Settings.Secure.getString(context.getContentResolver(), DeviceIdType.OAID) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void init() {
        try {
            PMControlBean pMControlBean = DeviceUtil.controlBean;
            if (pMControlBean != null) {
                if (!pMControlBean.isCanGetOaid()) {
                    return;
                }
            } else if (!isCanUseOAID) {
                return;
            }
            if (TextUtils.isEmpty(oaid)) {
                oaid = SPUtil.getInstance().getString(DeviceIdType.OAID, "");
                Context context = DeviceUtil.getContext();
                if (context == null) {
                    return;
                }
                load(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isIsCanUseOAID() {
        return isCanUseOAID;
    }

    private static void load(Context context) {
        try {
            DeviceID.getOAID(context, new AnonymousClass1(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIsCanUseOAID(boolean z) {
        isCanUseOAID = z;
    }

    public static void setOaid(String str) {
        oaid = str;
    }
}
