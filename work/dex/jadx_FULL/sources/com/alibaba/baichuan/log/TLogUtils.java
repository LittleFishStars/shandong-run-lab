package com.alibaba.baichuan.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.aliyun.tea.logging.DefaultLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TLogUtils {
    public static String DATE_TO_STRING_SHORT_PATTERN = "yyyyMMdd";

    public static boolean checkNetworkIsWifi(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean cleanDir(File file) {
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        boolean zCleanDir = true;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                zCleanDir &= cleanDir(file2);
            }
        }
        return zCleanDir;
    }

    public static LogLevel convertLogLevel(String str) {
        LogLevel logLevel = LogLevel.L;
        if (DefaultLogger.ERROR.equalsIgnoreCase(str)) {
            return LogLevel.E;
        }
        if (DefaultLogger.WARN.equalsIgnoreCase(str)) {
            return LogLevel.W;
        }
        if ("INFO".equalsIgnoreCase(str)) {
            return LogLevel.I;
        }
        if (DefaultLogger.DEBUG.equalsIgnoreCase(str)) {
            return LogLevel.D;
        }
        return "VERBOSE".equalsIgnoreCase(str) ? LogLevel.V : logLevel;
    }

    public static String[] getDays(Integer num) {
        if (num.intValue() == 0) {
            return null;
        }
        Long l = 86400000L;
        try {
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            int iIntValue = num.intValue();
            Long[] lArr = new Long[iIntValue];
            String[] strArr = new String[num.intValue()];
            for (int i = 0; i < num.intValue(); i++) {
                lArr[i] = Long.valueOf(lValueOf.longValue() - (((long) i) * l.longValue()));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_SHORT_PATTERN);
            for (int i2 = 0; i2 < iIntValue; i2++) {
                strArr[i2] = simpleDateFormat.format(new Date(lArr[i2].longValue()));
            }
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getFilePath(String str, Integer num) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str) || TLogInitializer.getInstance().getFileDir() == null) {
            return null;
        }
        File file = new File(TLogInitializer.getInstance().getFileDir());
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                String name = fileArrListFiles[i].getName();
                if (!name.endsWith("mmap2")) {
                    if (name.equals(str)) {
                        arrayList.add(fileArrListFiles[i].getAbsolutePath());
                    } else if (name.endsWith(str)) {
                        String dataInName = parseDataInName(name);
                        if (dataInName == null || arrayList.size() <= 0) {
                            arrayList.add(fileArrListFiles[i].getAbsolutePath());
                        } else {
                            int size = arrayList.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                String dataInName2 = parseDataInName(new File((String) arrayList.get(i2)).getName());
                                if (dataInName2 != null) {
                                    if (dataInName.compareTo(dataInName2) <= 0) {
                                        arrayList.add(i2, fileArrListFiles[i].getAbsolutePath());
                                        break;
                                    }
                                    if (i2 == size - 1) {
                                        arrayList.add(fileArrListFiles[i].getAbsolutePath());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (num.intValue() > 0 && arrayList != null && arrayList.size() > num.intValue()) {
            int size2 = arrayList.size() - num.intValue();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }

    public static String getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "NOT_NETWORK";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
        }
        if (type != 0) {
            return null;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NetworkUtil.NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NetworkUtil.NETWORK_TYPE_3G;
            case 13:
                return NetworkUtil.NETWORK_TYPE_4G;
            default:
                return null;
        }
    }

    public static Map<String, LogLevel> makeModule(String str) {
        HashMap map = null;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(TLogConstant.TLOG_MODULE_OFF)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit != null) {
            map = new HashMap();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("@");
                if (strArrSplit2 != null && strArrSplit2.length > 0) {
                    if (strArrSplit2.length == 1) {
                        map.put(strArrSplit2[0].toLowerCase(), LogLevel.E);
                    } else if (strArrSplit2.length == 2) {
                        map.put(strArrSplit2[0].toLowerCase(), convertLogLevel(strArrSplit2[1]));
                    }
                }
            }
        }
        return map;
    }

    public static String parseDataInName(String str) {
        String str2;
        int iIndexOf;
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit != null && strArrSplit.length == 3) {
            return strArrSplit[1];
        }
        if (strArrSplit == null || strArrSplit.length != 2 || (iIndexOf = (str2 = strArrSplit[1]).indexOf(Consts.DOT)) == -1) {
            return null;
        }
        return str2.substring(0, iIndexOf);
    }

    public static List<String> getFilePath(String str, int i, String[] strArr) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str) || TLogInitializer.getInstance().getFileDir() == null) {
            return null;
        }
        File file = new File(TLogInitializer.getInstance().getFileDir());
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                String name = fileArrListFiles[i2].getName();
                if (!name.endsWith("mmap2")) {
                    if (name.equals(str)) {
                        arrayList.add(fileArrListFiles[i2].getAbsolutePath());
                    } else if (name.startsWith(str)) {
                        if (strArr != null) {
                            for (String str2 : strArr) {
                                if (name.contains(str2)) {
                                    arrayList.add(fileArrListFiles[i2].getAbsolutePath());
                                }
                            }
                        } else {
                            String dataInName = parseDataInName(name);
                            if (dataInName != null && arrayList.size() > 0) {
                                int size = arrayList.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    String dataInName2 = parseDataInName(new File((String) arrayList.get(i3)).getName());
                                    if (dataInName2 != null) {
                                        if (dataInName.compareTo(dataInName2) <= 0) {
                                            arrayList.add(i3, fileArrListFiles[i2].getAbsolutePath());
                                            break;
                                        }
                                        if (i3 == size - 1) {
                                            arrayList.add(fileArrListFiles[i2].getAbsolutePath());
                                            break;
                                        }
                                    }
                                }
                            } else {
                                arrayList.add(fileArrListFiles[i2].getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
        if (i > 0 && arrayList != null && arrayList.size() > i) {
            int size2 = arrayList.size() - i;
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }
}
