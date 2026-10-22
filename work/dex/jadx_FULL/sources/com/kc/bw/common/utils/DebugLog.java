package com.kc.bw.common.utils;

import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.o61;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DebugLog {
    public static final int LOG_LEVEL_D = 0;
    public static final int LOG_LEVEL_E = 2;
    public static final int LOG_LEVEL_I = 3;
    public static final int LOG_LEVEL_W = 1;
    public static StringBuffer sb = new StringBuffer();
    public static int segmentSize = 3072;

    public static void D(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_d(str, str2);
        }
    }

    public static void E(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_d(str, str2);
        }
    }

    public static void E(String str, Object... objArr) {
        if (ConstantInfo.isDebug()) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = dexg.dexa("ydn}");
                }
                sb.setLength(0);
                int length = objArr.length;
                for (int i = 1; i < length; i++) {
                    StringBuffer stringBuffer = sb;
                    stringBuffer.append(dexg.dexa(">>>?"));
                    stringBuffer.append(objArr[i]);
                }
                release_e(str, sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void I(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_i(str, str2);
        }
    }

    public static void W(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_w(str, str2);
        }
    }

    public static void common_all(String str) {
        printLog(str, dexg.dexa("ldcx`mph>>"), 0);
    }

    public static void common_d(String str) {
        if (ConstantInfo.isDebug()) {
            common_all(str);
        }
    }

    public static void common_debug(String... strArr) {
    }

    public static void common_e(String str) {
        printLog(str, dexg.dexa("ldcx`mph>>"), 2);
    }

    public static void common_w(String str) {
        printLog(str, dexg.dexa("ldcx`mph>>"), 1);
    }

    public static void common_weak(String str) {
        printLog(str, dexg.dexa("ydn}"), 0);
    }

    public static void hook_w(String str) {
        printLog(str, dexg.dexa("yll}"), 1);
    }

    public static void hook_weak(String str) {
        printLog(str, dexg.dexa("yll}"), 0);
    }

    public static void init_weak(String str) {
        printLog(str, dexg.dexa("joju}"), 0);
    }

    public static void inst_d(String str) {
        printLog(str, dexg.dexa("jotu}"), 0);
    }

    public static void inst_w(String str) {
        printLog(str, dexg.dexa("jotu}"), 1);
    }

    public static void loadPlugin(String str) {
        printLog(str, dexg.dexa("qmh}"), 0);
    }

    public static void loadPlugin_e(String str) {
        printLog(str, dexg.dexa("qmh}"), 2);
    }

    public static void oaid_all(String str) {
        printLog(str, dexg.dexa("ype}"), 0);
    }

    public static void oaid_w(String str) {
        printLog(str, dexg.dexa("ype}"), 1);
    }

    public static void printLog(String str, String str2, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = dexg.dexa("=ovmm?");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = dexg.dexa("ydn}");
            }
            if (str.length() > segmentSize) {
                while (true) {
                    int length = str.length();
                    int i2 = segmentSize;
                    if (length <= i2) {
                        break;
                    }
                    String strSubstring = str.substring(0, i2);
                    str = str.replace(strSubstring, "");
                    if (i == 0) {
                        Log.d(str2, strSubstring);
                    } else if (i == 1) {
                        Log.w(str2, strSubstring);
                    } else if (i == 2) {
                        Log.e(str2, strSubstring);
                    } else if (i == 3) {
                        Log.i(str2, strSubstring);
                    }
                }
            }
            if (i == 0) {
                Log.d(str2, str);
                return;
            }
            if (i == 1) {
                Log.w(str2, str);
            } else if (i == 2) {
                Log.e(str2, str);
            } else {
                if (i != 3) {
                    return;
                }
                Log.i(str2, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void printThreadLog(String str, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = dexg.dexa("=ovmm?");
            }
            if (str.length() > segmentSize) {
                while (true) {
                    int length = str.length();
                    int i2 = segmentSize;
                    if (length <= i2) {
                        break;
                    }
                    String strSubstring = str.substring(0, i2);
                    str = str.replace(strSubstring, "");
                    String str2 = dexg.dexa(o61.h) + Thread.currentThread().getName() + dexg.dexa("^") + strSubstring;
                    if (i == 0) {
                        Log.d(dexg.dexa("ldcx`mph>>"), str2);
                    } else if (i == 1) {
                        Log.w(dexg.dexa("ldcx`mph>>"), str2);
                    } else if (i == 2) {
                        Log.e(dexg.dexa("ldcx`mph>>"), str2);
                    } else if (i == 3) {
                        Log.i(dexg.dexa("ldcx`mph>>"), str2);
                    }
                }
            }
            String str3 = dexg.dexa(o61.h) + Thread.currentThread().getName() + dexg.dexa("^") + str;
            if (i == 0) {
                Log.d(dexg.dexa("ldcx`mph>>"), str3);
                return;
            }
            if (i == 1) {
                Log.w(dexg.dexa("ldcx`mph>>"), str3);
            } else if (i == 2) {
                Log.e(dexg.dexa("ldcx`mph>>"), str3);
            } else {
                if (i != 3) {
                    return;
                }
                Log.i(dexg.dexa("ldcx`mph>>"), str3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void release_d(String str, String str2) {
        printThreadLog(str2, 0);
    }

    public static void release_e(String str, String str2) {
        printThreadLog(str2, 2);
    }

    public static void release_i(String str, String str2) {
        printThreadLog(str2, 3);
    }

    public static void release_w(String str, String str2) {
        printThreadLog(str2, 1);
    }
}
