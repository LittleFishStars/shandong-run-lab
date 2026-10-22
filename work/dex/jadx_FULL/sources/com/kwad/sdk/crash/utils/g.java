package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.baidu.location.BDLocation;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.y;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g {
    private static final String TAG = "g";
    private static final File bgo = new File("/proc/self/fd");
    private static final File bgp = new File("/proc/self/task");

    private g() {
    }

    public static void F(File file) throws Throwable {
        try {
            d.a(SystemUtil.ge(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, "-b", "events", "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, "-b", "events", "-d", "-f", file.getPath()}, 0);
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public static void G(File file) {
        if (file == null) {
            return;
        }
        try {
            y.N(file);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public static void H(File file) throws Throwable {
        try {
            y.U(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String strB = b(entry.getValue());
                            if (strB.isEmpty()) {
                                strB = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(strB);
                            bufferedWriter2.newLine();
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e5);
        }
    }

    public static void I(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = ab.getField(ab.a(ProcessUtils.ACTIVITY_THREAD, ProcessUtils.CURRENT_ACTIVITY_THREAD, new Object[0]), "mAppThread");
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 1006632960);
            ParcelFileDescriptor fileDescriptor = parcelFileDescriptorOpen;
            if (!SystemUtil.ge(26)) {
                fileDescriptor = parcelFileDescriptorOpen.getFileDescriptor();
            }
            if (SystemUtil.ge(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                ab.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.ge(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                ab.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.ge(19)) {
                Boolean bool5 = Boolean.TRUE;
                ab.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor parcelFileDescriptorOpen2 = ParcelFileDescriptor.open(file, 973078528);
            ParcelFileDescriptor fileDescriptor2 = parcelFileDescriptorOpen2;
            if (!SystemUtil.ge(26)) {
                fileDescriptor2 = parcelFileDescriptorOpen2.getFileDescriptor();
            }
            ab.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.Qd().getContext())});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private static int QN() {
        File[] fileArrListFiles;
        File file = bgo;
        az.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            return fileArrListFiles.length;
        }
        return 0;
    }

    public static void a(ExceptionMessage exceptionMessage, int i) {
        com.kwad.sdk.crash.h hVarQj = com.kwad.sdk.crash.e.Qd().Qj();
        if (hVarQj == null) {
            com.kwad.sdk.core.d.c.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = hVarQj.pr().toString();
        }
    }

    private static double aS(long j) {
        return BigDecimal.valueOf((j >> 20) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String am(@NonNull String str, String str2) {
        az.hY(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) throws Throwable {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    private static String cA(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String string = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(string);
            sb.append(sb2.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i++;
                sb.append("\nClassLoader " + i + " : " + classLoader.toString());
            }
            if (string != null) {
                String[] strArrSplit = string.split("\"");
                if (strArrSplit.length >= 2) {
                    sb.append("\n====path: " + strArrSplit[1] + ", length: " + gK(strArrSplit[1]));
                }
            }
        }
        return sb.toString();
    }

    private static String cy(Context context) {
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = context.getResources().getAssets().open("apk.json");
                String string = new JSONObject(h.d(inputStreamOpen)).getString("task_id");
                b.closeQuietly(inputStreamOpen);
                return string;
            } catch (Throwable th) {
                b.closeQuietly((Closeable) null);
                throw th;
            }
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            b.closeQuietly(inputStreamOpen);
            return "";
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
            b.closeQuietly(inputStreamOpen);
            return "";
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            b.closeQuietly(inputStreamOpen);
            return "";
        }
    }

    private static String cz(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.Qd().getSdkVersion() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + cA(context) + "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        return sb.toString();
    }

    public static void d(File file, File file2) throws Throwable {
        BufferedReader bufferedReader;
        try {
            y.U(file);
            y.U(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                bufferedWriter2.write(line);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            b.closeQuietly(bufferedReader);
        } catch (IOException e7) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
        }
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.Qd().Qg();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.Qd().getSdkVersion();
    }

    public static String gI(String str) {
        return str.contains(Consts.DOT) ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String gJ(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long gK(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static String gL(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        return sb.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains(c49.f40900a)) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean w(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    public static String x(Throwable th) throws Throwable {
        String string = th.toString();
        Closeable closeable = null;
        StringWriter stringWriter = null;
        try {
            try {
                StringWriter stringWriter2 = new StringWriter();
                try {
                    PrintWriter printWriter = new PrintWriter(stringWriter2);
                    f.a(th, printWriter);
                    string = stringWriter2.toString();
                    b.closeQuietly(stringWriter2);
                    closeable = printWriter;
                } catch (Exception e) {
                    e = e;
                    stringWriter = stringWriter2;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    b.closeQuietly(stringWriter);
                    closeable = stringWriter;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = stringWriter2;
                    b.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return string;
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.Qd().Qk();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.Qd().Qh()));
        exceptionMessage.mBuildConfigInfo = cz(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = cy(context);
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) throws Throwable {
        String strX = x(th);
        if (th instanceof StackOverflowError) {
            strX = gL(strX);
        }
        exceptionMessage.mCrashDetail = strX.replaceAll("[\n\t]", "#");
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!com.kwad.sdk.crash.d.bea.matcher(absolutePath).matches() && !com.kwad.sdk.crash.d.beb.matcher(absolutePath).matches()) {
            Matcher matcher = com.kwad.sdk.crash.d.bec.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.bed.matcher(absolutePath);
            if (matcher.matches()) {
                exceptionMessage.mVirtualApp = matcher.group(1);
                return;
            } else if (matcher2.matches()) {
                exceptionMessage.mVirtualApp = matcher2.group(1);
                return;
            } else {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            }
        }
        exceptionMessage.mVirtualApp = context.getPackageName();
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (w(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) throws Throwable {
        SystemUtil.a aVarWF = SystemUtil.WF();
        aVarWF.bqP = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        aVarWF.bqL = SystemUtil.WE();
        long pss = Debug.getPss();
        aVarWF.bqO = pss;
        memoryInfo.mTotalMB = (int) (aVarWF.bqL / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.bdZ / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (aVarWF.bqP / 1048576);
        memoryInfo.mVssMB = (int) (aVarWF.bqM / 1024);
        memoryInfo.mRssMB = (int) (aVarWF.bqN / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = aVarWF.mThreadsCount;
        memoryInfo.mFdCount = QN();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.ep(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] fileArrListFiles = bgo.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    try {
                        memoryInfo.mFds.add(Os.readlink(file.getPath()));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (aVarWF.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static boolean b(com.kwad.sdk.crash.model.b bVar) {
        boolean z = (bVar.beD & 2) != 0;
        com.kwad.sdk.core.d.c.d(TAG, "isNativeOpen:" + z);
        return z;
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] fileArrListFiles = bgp.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.J(new File(file, "comm"));
            } catch (IOException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = am(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = aS(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(1024L)) {
                diskInfo.mDataAvailableGB = aS(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && !be.useStoragePermissionDisable() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = aS(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = aS(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) throws Throwable {
        String line;
        try {
            y.U(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!line.isEmpty());
                    }
                    b.closeQuietly(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e5);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, boolean z) {
        a(file, charSequence, Charset.defaultCharset(), z);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    private static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStreamA = null;
        try {
            fileOutputStreamA = y.a(file, z);
            h.a(str, fileOutputStreamA, charset);
            a(fileOutputStreamA);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } finally {
            b.closeQuietly(fileOutputStreamA);
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    public static boolean a(com.kwad.sdk.crash.model.b bVar) {
        boolean z = (bVar.beD & 1) != 0;
        com.kwad.sdk.core.d.c.d(TAG, "isAnrOpen:" + z);
        return z;
    }
}
