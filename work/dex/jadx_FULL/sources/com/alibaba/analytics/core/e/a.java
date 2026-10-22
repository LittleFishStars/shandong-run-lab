package com.alibaba.analytics.core.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.y;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SubscriptionManager f23778a = null;
    private static String aL = "Unknown";

    /* JADX INFO: renamed from: com.alibaba.analytics.core.e.a$a, reason: collision with other inner class name */
    public static class HandlerC0135a extends Handler {
        public HandlerC0135a(Looper looper) {
            super(looper);
        }

        public void b(Runnable runnable) {
            j.d();
            if (runnable == null) {
                return;
            }
            try {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = runnable;
                sendMessage(messageObtain);
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    try {
                        ((Runnable) obj).run();
                    } catch (Throwable th) {
                        j.e("NetworkOperatorUtil", th, new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                j.e("NetworkOperatorUtil", th2, new Object[0]);
            }
            super.handleMessage(message);
        }
    }

    public static synchronized void c(final Context context) throws Exception {
        if (f23778a == null) {
            Looper.prepare();
            new HandlerC0135a(Looper.getMainLooper()).b(new Runnable() { // from class: com.alibaba.analytics.core.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.d(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(22)
    public static synchronized void d(final Context context) {
        if (f23778a == null) {
            try {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                f23778a = subscriptionManager;
                if (subscriptionManager == null) {
                    j.d("NetworkOperatorUtil", "SubscriptionManager is null");
                } else {
                    f23778a.addOnSubscriptionsChangedListener(new SubscriptionManager.OnSubscriptionsChangedListener() { // from class: com.alibaba.analytics.core.e.a.2
                        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
                        public void onSubscriptionsChanged() {
                            super.onSubscriptionsChanged();
                            j.d("NetworkOperatorUtil", "onSubscriptionsChanged");
                            a.e(context);
                            j.d("NetworkOperatorUtil", "CurrentNetworkOperator", a.aL);
                            y.k(context);
                        }
                    });
                    j.d("NetworkOperatorUtil", "addOnSubscriptionsChangedListener");
                }
            } catch (Throwable th) {
                j.e("NetworkOperatorUtil", th, new Object[0]);
            }
        }
    }

    public static synchronized void e(Context context) {
        j.d("NetworkOperatorUtil", "updateNetworkOperatorName");
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                aL = "Unknown";
                return;
            }
            if (telephonyManager.getSimState() == 5) {
                String simOperator = telephonyManager.getSimOperator();
                if (TextUtils.isEmpty(simOperator)) {
                    String simOperatorName = telephonyManager.getSimOperatorName();
                    if (TextUtils.isEmpty(simOperatorName)) {
                        aL = "Unknown";
                        return;
                    } else {
                        aL = simOperatorName;
                        return;
                    }
                }
                if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007") && !simOperator.equals("46008")) {
                    if (!simOperator.equals("46001") && !simOperator.equals("46006") && !simOperator.equals("46009")) {
                        if (!simOperator.equals("46003") && !simOperator.equals("46005") && !simOperator.equals("46011")) {
                            String simOperatorName2 = telephonyManager.getSimOperatorName();
                            if (TextUtils.isEmpty(simOperatorName2)) {
                                aL = "Unknown";
                                return;
                            } else {
                                aL = simOperatorName2;
                                return;
                            }
                        }
                        aL = "中国电信";
                        return;
                    }
                    aL = "中国联通";
                    return;
                }
                aL = "中国移动";
                return;
            }
            aL = "Unknown";
        } catch (Exception e) {
            j.e("NetworkOperatorUtil", e, new Object[0]);
        }
    }

    public static synchronized String u() {
        return aL;
    }
}
