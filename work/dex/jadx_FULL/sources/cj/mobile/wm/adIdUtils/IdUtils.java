package cj.mobile.wm.adIdUtils;

import android.content.Context;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.oaid.DeviceID;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IdUtils {
    public static final int MAX_QUERY_COUNT = 2;
    public static String OAID = "";
    public static volatile boolean isQuerying = false;
    public static int mmQueryNum;

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(OAID)) {
            OAIDLog.print(dexc.dexa("nn!pbje!dbdif!wbmje-") + OAID);
            return OAID;
        }
        if (isQuerying) {
            OAIDLog.print(dexc.dexa("nn!pbje!jt!rvfszjoh"));
            return OAID;
        }
        mmQueryNum++;
        OAIDLog.print(dexc.dexa("nn!pbje!ep!rvfsz-ovn>") + mmQueryNum);
        if (mmQueryNum > 2) {
            OAIDLog.print(dexc.dexa("nn!pbje!rvfsz!gsfrvfodz!mjnju"));
            return OAID;
        }
        isQuerying = true;
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            DeviceID.getOAID(context, new IGetter() { // from class: cj.mobile.wm.adIdUtils.IdUtils.1
                @Override // cj.mobile.wm.adIdUtils.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    OAIDLog.print(dexc.dexa("poPBJEHfuDpnqmfuf!") + str);
                    IdUtils.OAID = str;
                    countDownLatch.countDown();
                }

                @Override // cj.mobile.wm.adIdUtils.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    OAIDLog.print(dexc.dexa("PBJEꈈ꜇楲鵦期鱄)poPBJEHfuFssps*!") + exc);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(60L, TimeUnit.SECONDS);
                OAIDLog.print(dexc.dexa("nn!pbje!rvfsz!bxbju!ujnfpvu!ps!rvfsz!epof"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("nn!pbje!rvfsz!gbjm-") + th);
        }
        resetQueryStatus();
        OAIDLog.print(dexc.dexa("nn!pbje!rvfsz!epof-pbje>") + OAID + dexc.dexa("-jtRvfszjoh>") + isQuerying);
        return OAID;
    }

    public static void resetQueryStatus() {
        isQuerying = false;
    }
}
