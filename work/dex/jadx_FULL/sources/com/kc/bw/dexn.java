package com.kc.bw;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.bw.appsdkdex.utils.HttpNetUtils;
import com.kc.bw.common.bean.ActionReqBean;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.ThreadUtils;
import com.kc.bw.common.utils.Utils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class dexn {
    public static ConcurrentHashMap<String, dexb> dexa = new ConcurrentHashMap<>();
    public static Timer dexb = new Timer();
    public static final int dexc = 0;
    public static final int dexd = 500;
    public static final int dexe = -1;
    public static final int dexf = 0;
    public static final int dexg = 1;

    @Keep
    public class dexa extends TimerTask {
        public final dexb dexa;
        public final Context dexb;

        public dexa(dexb dexbVar, Context context) {
            this.dexa = dexbVar;
            this.dexb = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            dexn.dexa(this.dexa, this.dexb);
        }
    }

    @Keep
    public static class dexb {
        public String dexa;
        public String dexb;
        public int dexc;
        public boolean dexd;
        public TimerTask dexe;
        public int dexf;

        public int dexa() {
            return this.dexf;
        }

        public void dexa(int i) {
            this.dexf = i;
        }

        public void dexa(String str) {
            this.dexb = str;
        }

        public void dexa(TimerTask timerTask) {
            this.dexe = timerTask;
        }

        public void dexa(boolean z) {
            this.dexd = z;
        }

        public String dexb() {
            return this.dexb;
        }

        public void dexb(int i) {
            this.dexc = i;
        }

        public void dexb(String str) {
            this.dexa = str;
        }

        public int dexc() {
            return this.dexc;
        }

        public String dexd() {
            return this.dexa;
        }

        public TimerTask dexe() {
            return this.dexe;
        }

        public boolean dexf() {
            return this.dexd;
        }
    }

    public static int dexa(String str) {
        for (Integer num : ConstantInfo.Config.schemeMap.keySet()) {
            if (Objects.equals(ConstantInfo.Config.schemeMap.get(num), str)) {
                return num.intValue();
            }
        }
        return -1;
    }

    public static void dexa() {
        ConcurrentHashMap<String, dexb> concurrentHashMap = dexa;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, dexb>> it = dexa.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().dexe().cancel();
        }
        dexa.clear();
    }

    public static void dexa(Context context, String str) {
        int iDexb = dexb(str);
        if (iDexb != -1) {
            if (iDexb != 0) {
                return;
            } else {
                dexa();
            }
        }
        dexb(context, str);
    }

    public static void dexa(dexb dexbVar) {
        ConcurrentHashMap<String, dexb> concurrentHashMap;
        if (dexbVar == null || (concurrentHashMap = dexa) == null || concurrentHashMap.isEmpty() || !dexa.containsKey(dexbVar.dexb())) {
            return;
        }
        dexa.remove(dexbVar.dexb());
        dexbVar.dexe().cancel();
    }

    public static void dexa(dexb dexbVar, int i, boolean z) {
        ActionReqBean actionReqBean = new ActionReqBean();
        actionReqBean.setRequest_id(dexbVar.dexd());
        actionReqBean.setAndroid_scheme_id(dexbVar.dexc());
        actionReqBean.setTime_interval(i * 500);
        actionReqBean.setDp_success(z);
        HttpNetUtils.getInstance().reportAction(actionReqBean);
    }

    public static void dexa(dexb dexbVar, Context context) {
        try {
            int iDexa = dexbVar.dexa();
            if (((long) dexbVar.dexa()) * 500 < ((long) ConstantInfo.Config.appWakeupCheckDuration) * 1000) {
                if (Utils.isRunningForeground(context)) {
                    dexbVar.dexa(iDexa + 1);
                } else if (!dexbVar.dexf()) {
                    dexbVar.dexa(true);
                    dexa(dexbVar, iDexa, true);
                    dexa(dexbVar);
                }
            } else if (!dexbVar.dexf()) {
                dexbVar.dexa(true);
                dexa(dexbVar);
                dexa(dexbVar, iDexa, false);
            }
        } catch (Throwable unused) {
            dexa(dexbVar);
        }
    }

    public static int dexb(String str) {
        if (dexb()) {
            return dexa.containsKey(str) ? 1 : 0;
        }
        return -1;
    }

    public static void dexb(Context context, String str) {
        String str2;
        ConcurrentHashMap<String, dexb> concurrentHashMap = dexa;
        if (concurrentHashMap == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        dexb dexbVar = new dexb();
        final dexa dexaVar = new dexa(dexbVar, context);
        try {
            str2 = UUID.randomUUID().toString() + dexg.dexa(Consts.DOT) + System.currentTimeMillis();
        } catch (Throwable unused) {
            str2 = System.currentTimeMillis() + "";
        }
        dexbVar.dexb(str2);
        dexbVar.dexa(str);
        dexbVar.dexb(dexa(str));
        dexbVar.dexa(dexaVar);
        dexbVar.dexa(0);
        dexa.put(str, dexbVar);
        ThreadUtils.runOnThreadPool(new Runnable(dexaVar) { // from class: com.kc.bw.dexn$$ExternalSyntheticLambda0
            public final TimerTask f$0;

            {
                this.f$0 = dexaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                dexn.dexb.schedule(this.f$0, 0L, 500L);
            }
        });
    }

    public static boolean dexb() {
        ConcurrentHashMap<String, dexb> concurrentHashMap = dexa;
        return (concurrentHashMap == null || concurrentHashMap.isEmpty()) ? false : true;
    }
}
