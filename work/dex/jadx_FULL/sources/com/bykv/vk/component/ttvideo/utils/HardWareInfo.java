package com.bykv.vk.component.ttvideo.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.byazt.nr.m;
import com.byazt.nys.tt;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class HardWareInfo {
    private static final int ATOM = 1;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 3;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 2;
    private static final int NEON = 0;
    private static int[] mArmArchitecture = new int[3];
    private static int mCpuType;

    private static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(tt.c(context).getParent());
    }

    public static int[] getCpuArchitecture() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.replace("\t", "").split(u15.f19942b);
                    if (strArrSplit.length == 2) {
                        String strTrim = strArrSplit[0].trim();
                        String strTrim2 = strArrSplit[1].trim();
                        if (strTrim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int iIndexOf = strTrim2.indexOf("ARMv") + 4; iIndexOf < strTrim2.length(); iIndexOf++) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(strTrim2.charAt(iIndexOf));
                                String string = sb2.toString();
                                if (!string.matches("\\d")) {
                                    break;
                                }
                                sb.append(string);
                            }
                            int[] iArr = mArmArchitecture;
                            iArr[0] = 1;
                            iArr[1] = Integer.parseInt(sb.toString());
                        } else if (strTrim.compareToIgnoreCase("Features") == 0) {
                            if (strTrim2.contains("neon")) {
                                mArmArchitecture[2] = 0;
                            }
                        } else if (strTrim.compareToIgnoreCase("model name") == 0) {
                            if (strTrim2.contains("Intel")) {
                                int[] iArr2 = mArmArchitecture;
                                iArr2[0] = 2;
                                iArr2[2] = 1;
                            }
                        } else if (strTrim.compareToIgnoreCase("cpu family") == 0) {
                            mArmArchitecture[1] = Integer.parseInt(strTrim2);
                        }
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    throw th;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            m.c(e);
        }
        return mArmArchitecture;
    }

    public static int getCpuFamily() {
        if (mCpuType == 0) {
            getCpuInfo();
            mCpuType = mArmArchitecture[0];
        }
        return mCpuType;
    }

    public static int[] getCpuInfo() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.replaceAll("\t", "").toLowerCase(Locale.US).split(u15.f19942b);
                    if (strArrSplit.length == 2) {
                        String strTrim = strArrSplit[0].trim();
                        String strTrim2 = strArrSplit[1].trim();
                        if (strTrim2 != null && strTrim != null) {
                            if (strTrim.compareTo("processor") == 0) {
                                if (strTrim2.contains("armv") || strTrim2.contains("aarch64")) {
                                    mArmArchitecture[0] = 1;
                                    break;
                                }
                                if (strTrim2.contains("intel")) {
                                    mArmArchitecture[0] = 2;
                                    break;
                                }
                            } else if (strTrim.compareToIgnoreCase("features") == 0) {
                                if (strTrim2.contains("neon") || strTrim2.contains("thumb") || strTrim2.contains("vfpv") || strTrim2.contains("asimd") || strTrim2.contains("simd")) {
                                    mArmArchitecture[0] = 1;
                                }
                            } else if (strTrim.compareToIgnoreCase("model name") != 0) {
                                continue;
                            } else {
                                if (strTrim2.contains("intel")) {
                                    mArmArchitecture[0] = 2;
                                    break;
                                }
                                if (strTrim2.contains("arm")) {
                                    mArmArchitecture[0] = 1;
                                    break;
                                }
                            }
                            return mArmArchitecture;
                        }
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    throw th;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            m.c(e);
        }
        return mArmArchitecture;
    }

    private static long getDirectoryAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String str) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    public static long getProcessCpuInfo() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String line = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] strArrSplit = line.split(" ");
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    m.c(e);
                }
                try {
                    return Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16]);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    return 0L;
                }
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        m.c(e2);
                    }
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        m.c(e3);
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long[] getSDCardSize(Context context) {
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long availableStorageSize = getAvailableStorageSize(context);
            jArr[0] = getTotalStorageSize(context);
            jArr[1] = availableStorageSize;
        }
        return jArr;
    }

    private static long getTotalStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryTotalSize(tt.c(context).getParent());
    }

    private static boolean isAndroidJB2() {
        return true;
    }
}
