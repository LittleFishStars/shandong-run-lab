package com.baichuan.nb_trade.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.param.AlibcDegradeType;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.model.ActionDO;
import com.alibaba.alibcprotocol.route.model.ParamDO;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.byazt.hv.TTDownloadField;
import com.ta.utdid2.device.UTDevice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcBizUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26233a = "AlibcBizUtils";

    public static String a(int i) {
        BufferedReader bufferedReader;
        String str;
        StringBuilder sb;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
                try {
                    String line = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(line)) {
                        line = line.trim();
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        AlibcLogger.e(f26233a, "close reader exception: " + e.getMessage());
                    }
                    return line;
                } catch (Exception e2) {
                    e = e2;
                    AlibcLogger.e(f26233a, "read kernel for process name exception: " + e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e = e3;
                            str = f26233a;
                            sb = new StringBuilder("close reader exception: ");
                            sb.append(e.getMessage());
                            AlibcLogger.e(str, sb.toString());
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable unused) {
                    AlibcLogger.e(f26233a, "catch oom exception");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e = e4;
                            str = f26233a;
                            sb = new StringBuilder("close reader exception: ");
                            sb.append(e.getMessage());
                            AlibcLogger.e(str, sb.toString());
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        AlibcLogger.e(f26233a, "close reader exception: " + e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean assertInComponents(String str) {
        for (String str2 : AlibcProtocolConstant.COMPONENT_LIST) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z'))) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Object> buildResult(AlibcJsEnum alibcJsEnum) {
        HashMap map = new HashMap(16);
        map.put("errorCode", Integer.valueOf(alibcJsEnum.getCode()));
        map.put("errorMsg", alibcJsEnum.getMsg());
        return map;
    }

    public static String generateRecoverId() {
        StringBuilder sb = new StringBuilder(50);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strReplace = UTDevice.getUtdid(AlibcBaseTradeCommon.context).replace("+", Consts.DOT);
        int iNextInt = new Random(System.nanoTime()).nextInt(Integer.MAX_VALUE);
        sb.append(strReplace);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(jCurrentTimeMillis);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(iNextInt);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(AlibcBaseTradeCommon.getAppKey());
        return sb.toString();
    }

    public static String getChannel(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        String str3 = str + str2;
        if (b(str3)) {
            return str3;
        }
        AlibcLogger.e(f26233a, "channel chars must be in [0-9][a-z][A-Z]: " + str3);
        return "0";
    }

    public static String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
            String strA = a(Process.myPid());
            if (TextUtils.isEmpty(strA) || !strA.contains(context.getPackageName())) {
                return null;
            }
            return strA;
        } catch (Exception e) {
            AlibcLogger.e(f26233a, "get running app processes exception: " + e.getMessage());
        }
    }

    public static String getTargetUrl(RouteRequest routeRequest) {
        ParamDO param;
        List<ActionDO> actionList = routeRequest.getActionList();
        if (actionList != null && actionList.size() > 0) {
            for (ActionDO actionDO : actionList) {
                if ("native".equals(actionDO.getOpenType()) && (param = actionDO.getParam()) != null) {
                    String targetPath = param.getTargetPath();
                    if (!TextUtils.isEmpty(targetPath)) {
                        return targetPath;
                    }
                }
            }
        }
        return routeRequest.getRawUrl();
    }

    public static String setUrlByDegradeType(AlibcDegradeType alibcDegradeType, String str, String str2) {
        return (TextUtils.isEmpty(str) || !AlibcDegradeType.H5.equals(alibcDegradeType)) ? str2 : str;
    }
}
