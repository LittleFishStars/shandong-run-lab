package com.zj.adlib;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import huachenjie.sdk.logcat.LogLevel;
import huachenjie.sdk.logcat.LogTransaction;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f40886a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f15675a = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f15676a = 3000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Context f15677a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Handler f15678a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HandlerThread f15679a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ei4 f15680a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f15681a = "Logcat";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, Object> f15682a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f15683a = false;
    public static final char b = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f15684b = 5;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static long f15685b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Handler f15686b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static HandlerThread f15687b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Map<String, LinkedBlockingDeque<String>> f15689b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f15690b = false;
    public static final char c = 4;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f15691c = 4000;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static Handler f15692c = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static HandlerThread f15693c = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f15694c = " ";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f15695c = false;
    public static final char d = '\b';

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static int f15696d = 0;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static String f15697d = null;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f15698d = false;
    public static final char e = 16;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f15699e = "[Verbose]";

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static boolean f15700e = false;
    public static final char f = 0;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f15701f = "[Debug]";

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static boolean f15702f = false;
    public static final char g = 31;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f15703g = "[Info]";

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static boolean f15704g = false;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f15705h = "[Warning]";

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f15706i = "[Error]";
    public static final String j = "->";
    public static final String k = "huachenjieAppLog";
    public static String m = null;
    public static final String n = ".log";
    public static final String o = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String p = "yyyy_MM_dd_HH";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f15688b = System.getProperty("line.separator");
    public static char h = 31;
    public static char i = 31;
    public static String l = "";

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            c25.Q();
            sendEmptyMessageDelayed(0, 3000L);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f40887a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String[] f15707a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public b(String[] strArr, String[] strArr2, String str, Object obj, String str2, String str3, int i) {
            this.f15707a = strArr;
            this.b = strArr2;
            this.f = str;
            this.f40887a = obj;
            this.g = str2;
            this.h = str3;
            this.K = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c25.h == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = c25.f15697d != null;
            if (z) {
                sb.append(c25.f15697d);
            }
            String[] strArr = this.f15707a;
            if (strArr != null && strArr.length != 0) {
                for (int i = 0; i < this.f15707a.length; i++) {
                    if (i == 0 && z) {
                        sb.append(c25.j);
                    }
                    sb.append(this.f15707a[i]);
                    if (i < this.f15707a.length - 1) {
                        sb.append(c25.j);
                    }
                }
            } else if (!z) {
                sb.append(c25.f15681a);
            }
            String string = sb.toString();
            String strF = new px6.a().j(this.b).k(this.f).c(this.f40887a).a(this.g).d(this.h).f();
            c25.M(this.K, string, strF);
            c25.P(this.K, string, strF);
        }
    }

    public c25() {
        throw new UnsupportedOperationException();
    }

    public static synchronized void A() {
        f15689b = new HashMap();
        if (f15687b == null) {
            HandlerThread handlerThread = new HandlerThread("PrintFileLogThread");
            f15687b = handlerThread;
            handlerThread.start();
            f15686b = new Handler(f15687b.getLooper());
            Log.i(f15681a, f15687b.getName() + "#" + f15687b.getThreadId() + " is starting");
        }
        if (f15693c == null) {
            HandlerThread handlerThread2 = new HandlerThread("WriteFileThread");
            f15693c = handlerThread2;
            handlerThread2.start();
            a aVar = new a(f15693c.getLooper());
            f15692c = aVar;
            aVar.sendEmptyMessageDelayed(0, 3000L);
            Log.i(f15681a, f15693c.getName() + "#" + f15693c.getThreadId() + " is starting");
        }
    }

    public static synchronized void B() {
        if (f15679a == null) {
            HandlerThread handlerThread = new HandlerThread("PrintLogThread");
            f15679a = handlerThread;
            handlerThread.start();
            f15678a = new Handler(f15679a.getLooper());
            Log.i(f15681a, f15679a.getName() + "#" + f15679a.getThreadId() + " is starting");
        }
    }

    public static void C(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        f15677a = applicationContext;
        m = applicationContext.getPackageName();
        D(context, n());
    }

    public static void D(@NonNull Context context, @NonNull ss1 ss1Var) {
        Context applicationContext = context.getApplicationContext();
        f15677a = applicationContext;
        m = applicationContext.getPackageName();
        B();
        String str = ss1Var.f19638a;
        if (str == null || "".equals(str.trim())) {
            n();
        } else {
            j(ss1Var.f19638a);
        }
        Character ch = ss1Var.f19637a;
        if (ch != null) {
            h = ch.charValue();
        }
        Character ch2 = ss1Var.b;
        if (ch2 != null) {
            char cCharValue = ch2.charValue();
            i = cCharValue;
            if (cCharValue == 0) {
                HandlerThread handlerThread = f15687b;
                if (handlerThread != null) {
                    handlerThread.quit();
                    f15686b = null;
                    f15689b = null;
                }
                HandlerThread handlerThread2 = f15693c;
                if (handlerThread2 != null) {
                    handlerThread2.quit();
                    f15692c = null;
                }
            } else {
                A();
            }
        }
        f15697d = ss1Var.f19641b;
        ei4 ei4Var = f15680a;
        if (ei4Var != null) {
            ei4Var.k();
        }
        ei4 ei4Var2 = ss1Var.f19636a;
        if (ei4Var2 != null) {
            f15680a = ei4Var2;
        }
        Map<String, Object> map = ss1Var.f19639a;
        if (map != null) {
            f15682a = map;
        }
        f15696d = ss1Var.f44765a;
        f15685b = TimeUnit.DAYS.toMillis(f15696d);
        f15683a = ss1Var.f19640a;
        f15690b = ss1Var.f19642b;
        f15695c = ss1Var.c;
        f15698d = ss1Var.d;
        f15700e = ss1Var.e;
        f15702f = ss1Var.f;
        f15704g = ss1Var.g;
    }

    public static boolean E() {
        return f15677a != null;
    }

    @NonNull
    public static o41 G() {
        return new o41();
    }

    public static void H(int i2, Object obj, String... strArr) {
        J(i2, null, obj, strArr);
    }

    public static void I(int i2, Object obj, String[] strArr, String str, String... strArr2) {
        K(i2, null, obj, strArr, str, strArr2);
    }

    public static void J(int i2, String str, Object obj, String... strArr) {
        K(i2, str, obj, null, null, strArr);
    }

    public static void K(int i2, String str, Object obj, String[] strArr, String str2, String... strArr2) {
        L(i2, str, null, strArr, str2, "", obj, strArr2);
    }

    public static void L(int i2, @Nullable String str, @Nullable String str2, @Nullable String[] strArr, @Nullable String str3, String str4, Object obj, String... strArr2) {
        if (f15677a == null) {
            return;
        }
        if ((h & i2) != 0) {
            O(i2, obj, str, str2, strArr, str3, strArr2);
        }
        if (str4 != null) {
            a0(i2, obj, str, str2, strArr, str3, str4, strArr2);
        } else if (f15683a || h(strArr2)) {
            a0(i2, obj, str, str2, strArr, str3, "", strArr2);
        }
    }

    public static void M(int i2, String str, String str2) {
        if (f15680a != null) {
            String str3 = new SimpleDateFormat(o).format(new Date());
            Process.myPid();
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(" ");
            if (i2 == 1) {
                sb.append(f15699e);
            } else if (i2 == 2) {
                sb.append(f15701f);
            } else if (i2 == 4) {
                sb.append(f15703g);
            } else if (i2 == 8) {
                sb.append(f15705h);
            } else if (i2 == 16) {
                sb.append(f15706i);
            }
            ei4 ei4Var = f15680a;
            sb.append(str);
            sb.append(u15.f19942b);
            sb.append(" ");
            sb.append(str2);
            ei4Var.j(sb.toString());
        }
    }

    public static void N(int i2, String str, List<String> list) {
        if (f15680a != null) {
            LinkedList linkedList = new LinkedList();
            String str2 = new SimpleDateFormat(o).format(new Date());
            Process.myPid();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" ");
            if (i2 == 1) {
                sb.append(f15699e);
            } else if (i2 == 2) {
                sb.append(f15701f);
            } else if (i2 == 4) {
                sb.append(f15703g);
            } else if (i2 == 8) {
                sb.append(f15705h);
            } else if (i2 == 16) {
                sb.append(f15706i);
            }
            sb.append(str);
            sb.append(u15.f19942b);
            sb.append(" ");
            String string = sb.toString();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                linkedList.add(string + it.next());
            }
        }
    }

    public static void O(int i2, Object obj, @Nullable String str, @Nullable String str2, @Nullable String[] strArr, @Nullable String str3, @Nullable String... strArr2) {
        i();
        if (strArr == null) {
            strArr = px6.f(w());
        }
        String[] strArr3 = strArr;
        if (TextUtils.isEmpty(str3)) {
            str3 = Thread.currentThread().getName();
        }
        f15678a.post(new b(strArr2, strArr3, str3, obj, str, str2, i2));
    }

    public static void P(int i2, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList();
        if (str2.length() > 4000) {
            int i3 = 0;
            while (i3 < str2.length()) {
                int iMin = Math.min(i3 + 4000, str2.length());
                arrayList.add(str2.substring(i3, iMin));
                i3 = iMin;
            }
        } else {
            arrayList.add(str2);
        }
        for (String str3 : arrayList) {
            if (i2 == 1) {
                Log.v(str, str3);
            } else if (i2 == 2) {
                Log.d(str, str3);
            } else if (i2 == 4) {
                Log.i(str, str3);
            } else if (i2 == 8) {
                Log.w(str, str3);
            } else if (i2 == 16) {
                Log.e(str, str3);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f7 A[Catch: InterruptedException -> 0x0109, IOException -> 0x0113, TRY_LEAVE, TryCatch #7 {IOException -> 0x0113, InterruptedException -> 0x0109, blocks: (B:46:0x00f1, B:48:0x00f7), top: B:80:0x00f1 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x000a A[SYNTHETIC] */
    public static void Q() {
        File externalStorageDirectory;
        FileWriter fileWriter;
        for (String strV : f15689b.keySet()) {
            LinkedBlockingDeque<String> linkedBlockingDeque = f15689b.get(strV);
            if (linkedBlockingDeque.size() > 0) {
                if (strV.equals("Default")) {
                    strV = v();
                }
                String str = strV;
                BufferedWriter bufferedWriter = null;
                try {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    externalStorageDirectory = null;
                }
                if (externalStorageDirectory == null || !externalStorageDirectory.exists()) {
                    Log.i(f15681a, "Not mount SD card!");
                } else {
                    File file = new File(l);
                    if (file.exists()) {
                        File[] fileArrListFiles = file.listFiles();
                        Date date = new Date();
                        ArrayList arrayList = new ArrayList();
                        boolean zDelete = false;
                        for (File file2 : fileArrListFiles) {
                            long jLastModified = file2.lastModified();
                            String name = file2.getName();
                            if (date.getTime() - jLastModified >= f15685b && (zDelete = file2.delete())) {
                                Log.i(f15681a, "deleteUnusedLogEntries is " + name);
                                arrayList.add(file2.getAbsolutePath());
                            }
                        }
                        if (zDelete) {
                            MediaScannerConnection.scanFile(f15677a, (String[]) arrayList.toArray(new String[0]), null, null);
                        }
                        File file3 = new File(l, str);
                        if (!file3.exists()) {
                            try {
                                if (file3.createNewFile()) {
                                    MediaScannerConnection.scanFile(f15677a, new String[]{file3.getAbsolutePath()}, null, null);
                                }
                                if (file3.exists()) {
                                    try {
                                        fileWriter = new FileWriter(file3, true);
                                        bufferedWriter = new BufferedWriter(fileWriter);
                                        while (!linkedBlockingDeque.isEmpty()) {
                                            try {
                                                bufferedWriter.write(linkedBlockingDeque.take());
                                                bufferedWriter.write(f15688b);
                                                bufferedWriter.flush();
                                            } catch (IOException e3) {
                                                Log.i(f15681a, "objBufferedWriter.write or objBufferedWriter.flush failed");
                                                e3.printStackTrace();
                                            } catch (InterruptedException e4) {
                                                Log.i(f15681a, "queue take error!");
                                                e4.printStackTrace();
                                            }
                                        }
                                    } catch (IOException e5) {
                                        Log.i(f15681a, "New FileWriter Instance failed");
                                        e5.printStackTrace();
                                        fileWriter = null;
                                    }
                                } else {
                                    Log.i(f15681a, "Create log file failed!");
                                }
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        } else if (file3.exists()) {
                            Log.i(f15681a, "Create log file failed!");
                        } else {
                            fileWriter = new FileWriter(file3, true);
                            bufferedWriter = new BufferedWriter(fileWriter);
                            while (!linkedBlockingDeque.isEmpty()) {
                                bufferedWriter.write(linkedBlockingDeque.take());
                                bufferedWriter.write(f15688b);
                                bufferedWriter.flush();
                            }
                        }
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                    } else {
                        Log.i(f15681a, "LogTransaction savePath invalid!");
                    }
                }
                fileWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
        }
    }

    public static String R(String str, String str2) {
        if (str.length() >= 400 && f15680a.l(str, str2)) {
            return f15680a.e(str2);
        }
        return null;
    }

    public static LogTransaction S() {
        return new huachenjie.sdk.logcat.a(LogLevel.Verbose);
    }

    public static void T(Object obj) {
        H(1, obj, new String[0]);
    }

    public static void U(String str, Object obj) {
        H(1, obj, str);
    }

    public static LogTransaction V() {
        return new huachenjie.sdk.logcat.a(LogLevel.Warn);
    }

    public static void W(Object obj) {
        H(8, obj, new String[0]);
    }

    public static void X(String str, Object obj) {
        H(8, obj, str);
    }

    public static void Y() {
        Z(true);
    }

    public static void Z(boolean z) {
        if (z) {
            f15692c.sendEmptyMessage(0);
        } else {
            Q();
        }
    }

    public static void a0(final int i2, final Object obj, @Nullable final String str, @Nullable final String str2, @Nullable String[] strArr, @Nullable String str3, @Nullable final String str4, final String... strArr2) {
        Handler handler;
        final String[] strArrF = strArr == null ? px6.f(w()) : strArr;
        final String name = TextUtils.isEmpty(str3) ? Thread.currentThread().getName() : str3;
        if ((i & i2) == 0 || (handler = f15686b) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zj.adlib.b25
            @Override // java.lang.Runnable
            public final void run() {
                c25.t(strArrF, name, i2, obj, str, str2, str4, strArr2);
            }
        });
    }

    public static void g(String str, @Nullable String str2) {
        LinkedBlockingDeque<String> linkedBlockingDeque;
        if (TextUtils.isEmpty(str) || f15689b == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Default";
        }
        if (f15689b.containsKey(str2)) {
            linkedBlockingDeque = f15689b.get(str2);
        } else {
            LinkedBlockingDeque<String> linkedBlockingDeque2 = new LinkedBlockingDeque<>();
            f15689b.put(str2, linkedBlockingDeque2);
            linkedBlockingDeque = linkedBlockingDeque2;
        }
        try {
            linkedBlockingDeque.put(str);
        } catch (InterruptedException e2) {
            Log.i(f15681a, "queue put error!");
            e2.printStackTrace();
        }
    }

    public static boolean h(String... strArr) {
        Map<String, Object> map;
        StringBuilder sb = new StringBuilder();
        String str = f15697d;
        boolean z = str != null;
        if (z) {
            sb.append(str);
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 == 0 && z) {
                    sb.append(j);
                }
                sb.append(strArr[i2]);
                if (i2 < strArr.length - 1) {
                    sb.append(j);
                }
            }
        }
        if (sb.length() <= 0 || (map = f15682a) == null || map.isEmpty()) {
            return false;
        }
        return f15682a.containsKey(sb.toString());
    }

    public static void i() {
        if (f15678a == null) {
            synchronized (c25.class) {
                if (f15678a == null) {
                    B();
                }
            }
        }
    }

    public static void j(@NonNull String str) {
        if ("".equals(l.trim())) {
            File file = new File(str);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    Log.i(f15681a, "Create log folder success!");
                } else {
                    Log.i(f15681a, "Create log folder failed!");
                }
            }
            l = str;
        }
    }

    public static LogTransaction k() {
        return new huachenjie.sdk.logcat.a(LogLevel.Debug);
    }

    public static void l(Object obj) {
        H(2, obj, new String[0]);
    }

    public static void m(String str, Object obj) {
        H(2, obj, str);
    }

    public static ss1 n() {
        o41 o41VarG = G();
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted_ro".equals(externalStorageState)) {
            Log.w(f15681a, "Not allow write SD card!");
        } else if ("mounted".equals(externalStorageState)) {
            File cacheDir = f15677a.getCacheDir();
            if (cacheDir != null) {
                String str = cacheDir.getAbsolutePath() + File.separator + k;
                o41VarG.f18555a = str;
                j(str);
            } else {
                Log.e(f15681a, "externalCacheDir is null!");
                o41VarG.g(0);
            }
        } else {
            Log.w(f15681a, "Not mount SD card!");
        }
        return new ss1(o41VarG);
    }

    public static LogTransaction o() {
        return new huachenjie.sdk.logcat.a(LogLevel.Error);
    }

    public static void p(Object obj) {
        H(16, obj, new String[0]);
    }

    public static void q(Object obj, String[] strArr, String str) {
        I(16, obj, strArr, str, new String[0]);
    }

    public static void r(String str, Object obj) {
        H(16, obj, str);
    }

    public static void s(String str, Object obj, String[] strArr, String str2) {
        I(16, obj, strArr, str2, str);
    }

    public static void t(String[] strArr, String str, int i2, Object obj, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String... strArr2) {
        if (i == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str5 = f15697d;
        boolean z = str5 != null;
        if (z) {
            sb.append(str5);
        }
        if (strArr2 != null && strArr2.length != 0) {
            for (int i3 = 0; i3 < strArr2.length; i3++) {
                if (i3 == 0 && z) {
                    sb.append(j);
                }
                sb.append(strArr2[i3]);
                if (i3 < strArr2.length - 1) {
                    sb.append(j);
                }
            }
        } else if (!z) {
            sb.append(f15681a);
        }
        StringBuilder sb2 = new StringBuilder();
        String str6 = new SimpleDateFormat(o).format(new Date());
        if (f15695c) {
            sb2.append(str6);
            sb2.append(" ");
        }
        if (f15700e) {
            if (i2 == 1) {
                sb2.append(f15699e);
            } else if (i2 == 2) {
                sb2.append(f15701f);
            } else if (i2 == 4) {
                sb2.append(f15703g);
            } else if (i2 == 8) {
                sb2.append(f15705h);
            } else if (i2 == 16) {
                sb2.append(f15706i);
            }
            if (!f15702f) {
                sb2.append(" ");
            }
        }
        if (f15702f) {
            sb2.append(sb.toString());
        }
        sb2.append(u15.f19942b);
        sb2.append(" ");
        String strF = new px6.a().j(strArr).k(str).c(obj).a(str2).d(str3).f();
        if (i2 == 1) {
            g(sb2.toString() + strF, str4);
            return;
        }
        if (i2 == 2) {
            g(sb2.toString() + strF, str4);
            return;
        }
        if (i2 == 4) {
            g(sb2.toString() + strF, str4);
            return;
        }
        if (i2 == 8) {
            g(sb2.toString() + strF, str4);
            return;
        }
        if (i2 != 16) {
            return;
        }
        g(sb2.toString() + strF, str4);
        Y();
    }

    public static String u() {
        return f15680a.d();
    }

    public static String v() {
        try {
            return (new SimpleDateFormat(p).format(Calendar.getInstance().getTime()) + LoginConstants.UNDER_LINE + (Calendar.getInstance().get(12) / 5)) + n;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "2022_01_01_00_00";
        }
    }

    public static StackTraceElement[] w() {
        return Thread.currentThread().getStackTrace();
    }

    public static LogTransaction x() {
        return new huachenjie.sdk.logcat.a(LogLevel.Info);
    }

    public static void y(Object obj) {
        H(4, obj, new String[0]);
    }

    public static void z(String str, Object obj) {
        H(4, obj, str);
    }
}
