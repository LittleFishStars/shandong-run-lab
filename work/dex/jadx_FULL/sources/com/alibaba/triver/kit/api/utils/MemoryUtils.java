package com.alibaba.triver.kit.api.utils;

import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MemoryUtils {
    private static long getNumberByString(String str) {
        try {
            return Long.parseLong(str, 10);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long getVmSize() {
        return getNumberByString(loadMemoryInfo().get("vmsize"));
    }

    public static Map<String, String> loadMemoryInfo() {
        Map<String, String> map = new HashMap<>();
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec("cat /proc/" + Process.myPid() + "/status");
                map = parseMemInfo(IOUtils.read(processExec.getInputStream()));
                Log.e("MemoryInfo", map.toString());
                try {
                    processExec.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return map;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (processExec != null) {
                    try {
                        processExec.destroy();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return map;
            }
        } catch (Throwable th) {
            if (processExec != null) {
                try {
                    processExec.destroy();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static Pair<String, String> parseKV(String str) {
        String str2;
        String str3;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(u15.f19942b);
        if (strArrSplit.length == 2) {
            str3 = strArrSplit[0];
            str2 = strArrSplit[1];
        } else {
            str2 = null;
            str3 = null;
        }
        if (str2 == null) {
            return null;
        }
        return new Pair<>(str3, removeKbInString(str2.trim().toLowerCase()));
    }

    private static Map<String, String> parseMemInfo(String str) {
        HashMap map = new HashMap();
        if (str == null) {
            return map;
        }
        for (String str2 : str.split("\n")) {
            Pair<String, String> kv = parseKV(str2);
            if (kv != null) {
                map.put(((String) kv.first).toLowerCase(), kv.second);
            }
        }
        return map;
    }

    private static String removeKbInString(String str) {
        if (str == null) {
            return null;
        }
        return !str.contains("kb") ? str : str.substring(0, str.indexOf("kb")).trim();
    }

    public static void startUpdateMemInfo(final App app) {
        if (app == null) {
            return;
        }
        final long vmSize = getVmSize();
        final boolean zIsAppInJSIWorkerBlackList = TROrangeController.isAppInJSIWorkerBlackList(app);
        final boolean zNeedForceUseV8Worker = TROrangeController.needForceUseV8Worker(app);
        final boolean zEnableJSIWorkerByAppIdAndTemplateId = TROrangeController.enableJSIWorkerByAppIdAndTemplateId(app);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.alibaba.triver.kit.api.utils.MemoryUtils.1
            private int count = 0;
            private long biggestVMSize = 0;

            private void stopTask() {
                try {
                    timer.cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (this.biggestVMSize == 0) {
                    this.biggestVMSize = vmSize;
                }
                if (this.count > 10) {
                    stopTask();
                    return;
                }
                if (app.isExited() || app.isDestroyed()) {
                    stopTask();
                    return;
                }
                this.count++;
                long vmSize2 = MemoryUtils.getVmSize();
                if (vmSize2 < this.biggestVMSize) {
                    return;
                }
                RVLogger.e("VmSize", "firstSize : " + vmSize + "  new vmSize : " + vmSize2 + "  more : " + (vmSize2 - vmSize));
                LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData == null || vmSize2 == 0) {
                    return;
                }
                subMonitorData.setStartMemory(Long.toString(vmSize));
                subMonitorData.updateHighMemory(Long.toString(vmSize2));
                if (zNeedForceUseV8Worker || zIsAppInJSIWorkerBlackList || !zEnableJSIWorkerByAppIdAndTemplateId) {
                    subMonitorData.setABTestTag(0);
                } else {
                    subMonitorData.setABTestTag(1);
                }
                this.biggestVMSize = vmSize2;
            }
        }, 1000L, 1000L);
    }
}
