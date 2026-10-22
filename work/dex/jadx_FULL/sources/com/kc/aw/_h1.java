package com.kc.aw;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.b;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.NotActiveException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h1 {
    public static final _f _a = new _f();
    public static final LinkedBlockingQueue _b = new LinkedBlockingQueue();
    public static final LinkedBlockingQueue _c = new LinkedBlockingQueue();
    public static final _b _d = new _b(TimeUnit.SECONDS, new ArrayBlockingQueue(60), new _a(), new ThreadPoolExecutor.CallerRunsPolicy());

    @Keep
    public final class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb_a = _jf._a("ClassNetUtils-");
            sb_a.append(this._a.getAndIncrement());
            Thread thread = new Thread(runnable, sb_a.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    @Keep
    public final class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, ArrayBlockingQueue arrayBlockingQueue, _a _aVar, ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy) {
            super(4, 10, 60L, timeUnit, arrayBlockingQueue, _aVar, callerRunsPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    @Keep
    public final class _c implements Runnable {

        @Keep
        public final class _a implements Runnable {
            public final _ee _a;

            public _a(_ee _eeVar) {
                this._a = _eeVar;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                try {
                    _h1._b(this._a);
                } catch (Exception unused) {
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    for (_ee _eeVar : (List) _h1._c.take()) {
                        if (_eeVar != null) {
                            _h1._d.execute(new _a(_eeVar));
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception unused2) {
                }
            }
        }
    }

    @Keep
    public final class _d implements Runnable {

        @Keep
        public final class _a implements Runnable {
            public final _ee _a;

            public _a(_ee _eeVar) {
                this._a = _eeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    _h1._a(this._a);
                } catch (Exception unused) {
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    _ee _eeVar = (_ee) _h1._b.take();
                    if (_eeVar != null) {
                        _h1._d.execute(new _a(_eeVar));
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception unused2) {
                }
            }
        }
    }

    @Keep
    public static final class _e implements Runnable {
        public final List<String> _a;
        public final HashMap<String, String> _b;

        public _e(List list) {
            this._a = list == null ? Collections.emptyList() : list;
            this._b = new HashMap<>();
        }

        @Override // java.lang.Runnable
        public final void run() {
            _h1._a(this._a, this._b);
        }
    }

    @Keep
    public static final class _f implements _eb {
        @Override // com.kc.aw._eb
        public final void _a(_ee _eeVar) {
        }

        @Override // com.kc.aw._eb
        public final void _a(_ee _eeVar, int i, String str) {
        }
    }

    static {
        Thread thread = new Thread(new _c(), "Report_Thread");
        Thread thread2 = new Thread(new _d(), "Simple_Thread");
        thread.setDaemon(true);
        thread.start();
        thread2.setDaemon(true);
        thread2.start();
    }

    public static InputStream _a(InputStream inputStream, String str) throws IOException {
        if (!"gzip".equals(str)) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[SYNTHETIC] */
    public static String _a(HttpURLConnection httpURLConnection) throws Throwable {
        Throwable th;
        InputStream errorStream;
        BufferedReader bufferedReader = null;
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            if (errorStream == null) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                    try {
                        errorStream.close();
                    } catch (IOException unused4) {
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (errorStream != null) {
                        throw th;
                    }
                    try {
                        errorStream.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            errorStream = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (errorStream != null) {
                throw th;
            }
            errorStream.close();
            throw th;
        }
    }

    public static void _a(_ee _eeVar) {
        String message;
        _eb _ebVar = _eeVar._h;
        if (_ebVar != null) {
            try {
                try {
                    _ebVar._a(_eeVar);
                    String str_c = _c(_eeVar);
                    if (TextUtils.isEmpty(str_c)) {
                        _ebVar._a(_eeVar, 0, null);
                    } else {
                        _ebVar._a(_eeVar, 1, str_c);
                    }
                } catch (_h0 e) {
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = "NetAPIException";
                    }
                    Logger.e(message2);
                    _ebVar._a(_eeVar, 0, message2);
                } catch (IOException e2) {
                    message = e2.getMessage();
                    if (message == null) {
                        message = "IOException: " + e2.getClass().getSimpleName();
                    }
                    Logger.e(message);
                    if (!PtgErrorCode.ILLEGAL_PATH.equals(message) && !PtgErrorCode.ILLEGAL_REQUEST.equals(message)) {
                        throw e2;
                    }
                    _ebVar._a(_eeVar, 0, message);
                } catch (Exception e3) {
                    message = e3.getMessage();
                    if (message == null) {
                        message = "Exception: " + e3.getClass().getSimpleName();
                    }
                    Logger.e(message);
                    _ebVar._a(_eeVar, 0, message);
                }
            } catch (Throwable th) {
                _eeVar._h = _a;
                throw th;
            }
        }
        _eeVar._h = _a;
    }

    public static void _a(String str) {
        if (str == null) {
            Logger.e(Logger.ILogger.TAG, "reportUrl is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        _a(arrayList, (HashMap<String, String>) null);
    }

    public static void _a(List<String> list, HashMap<String, String> map) {
        if (list == null) {
            Logger.e(Logger.ILogger.TAG, "reportUrlList is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            _ee _eeVar = new _ee(it.next());
            Random random = com.kc.aw.lib.utils._a._a;
            if (!(map == null || map.size() <= 0)) {
                _eeVar._a = new HashMap(map);
            }
            arrayList.add(_eeVar);
        }
        _c.offer(arrayList);
    }

    public static byte[] _a(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException unused2) {
                    throw th;
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused3) {
        }
        try {
            inputStream.close();
        } catch (IOException unused4) {
        }
        return byteArray;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0107  */
    public static void _b(_ee _eeVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        String string;
        String string2;
        InputStream inputStream = null;
        if (_eeVar != null) {
            try {
                if (TextUtils.isEmpty(_eeVar._c)) {
                    httpURLConnection = null;
                } else {
                    String str = _eeVar._c;
                    if (TextUtils.isEmpty(com.kc.aw.lib.utils._a._d)) {
                        StringBuilder sb = new StringBuilder();
                        for (char c : "\u0012\u000e\u000e\n@UU".toCharArray()) {
                            sb.append((char) (c ^ 'z'));
                        }
                        string = sb.toString();
                        com.kc.aw.lib.utils._a._d = string;
                    } else {
                        string = com.kc.aw.lib.utils._a._d;
                    }
                    if (!str.startsWith(string)) {
                        String str2 = _eeVar._c;
                        if (TextUtils.isEmpty(com.kc.aw.lib.utils._a._e)) {
                            StringBuilder sb2 = new StringBuilder();
                            for (char c2 : "\t\u0015\u0015\u0011\u0012[NN".toCharArray()) {
                                sb2.append((char) (c2 ^ 'a'));
                            }
                            string2 = sb2.toString();
                            com.kc.aw.lib.utils._a._e = string2;
                        } else {
                            string2 = com.kc.aw.lib.utils._a._e;
                        }
                        if (!str2.startsWith(string2)) {
                            httpURLConnection = null;
                        }
                    }
                    httpURLConnection = (HttpURLConnection) new URL(_eeVar._c).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setRequestProperty("Connection", b.t0);
                        HashMap map = _eeVar._a;
                        if (!(map == null || map.size() <= 0)) {
                            for (Map.Entry entry : _eeVar._a.entrySet()) {
                                String str3 = (String) entry.getKey();
                                String str4 = (String) entry.getValue();
                                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                                    httpURLConnection.setRequestProperty(str3, str4);
                                }
                            }
                        }
                        httpURLConnection.getResponseCode();
                        try {
                            inputStream = httpURLConnection.getInputStream();
                            do {
                            } while (inputStream.read(new byte[1024]) != -1);
                        } catch (IOException unused) {
                            InputStream errorStream = httpURLConnection.getErrorStream();
                            if (errorStream != null) {
                                try {
                                    do {
                                    } while (errorStream.read(new byte[1024]) != -1);
                                    errorStream.close();
                                } catch (Throwable th) {
                                    try {
                                        errorStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (httpURLConnection == null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } else {
            httpURLConnection = null;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x021a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0225 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:175:0x02b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0227 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0193  */
    /* JADX WARN: Code duplicated, block: B:78:0x019c  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b4 A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01cb A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d3 A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01dd A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01e5 A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01ed A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01f3 A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0201 A[Catch: all -> 0x0231, Exception -> 0x0234, IOException -> 0x0237, _h0 -> 0x0239, SocketTimeoutException -> 0x023c, TRY_LEAVE, TryCatch #20 {_h0 -> 0x0239, SocketTimeoutException -> 0x023c, IOException -> 0x0237, Exception -> 0x0234, all -> 0x0231, blocks: (B:76:0x0195, B:90:0x01b4, B:96:0x01f2, B:91:0x01cb, B:92:0x01d3, B:93:0x01dd, B:94:0x01e5, B:95:0x01ed, B:97:0x01f3, B:99:0x0201), top: B:195:0x0195 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:90:0x01b4, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static String _c(_ee _eeVar) throws Throwable {
        OutputStream outputStream;
        ?? r1;
        PrintWriter printWriter;
        OutputStream outputStream2;
        ?? r2;
        ?? r3;
        int responseCode;
        InputStream inputStream_a;
        ?? url = new URL(Uri.encode(_eeVar._c, "@#&=*+-_.,:!?()/~'%"));
        OutputStream outputStream3 = null;
        printWriter = null;
        OutputStream outputStream4 = null;
        outputStream3 = null;
        printWriter = null;
        ?? r4 = 0;
        outputStream3 = null;
        PrintWriter printWriter2 = null;
        try {
            try {
                ?? r5 = (HttpURLConnection) url.openConnection();
                try {
                    r5.setRequestProperty("Connection", b.t0);
                    r5.setRequestProperty("Accept-Encoding", "gzip");
                    for (Map.Entry entry : _eeVar._a.entrySet()) {
                        r5.setRequestProperty(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    }
                    r5.setRequestMethod(_eeVar._d);
                    boolean z = true;
                    r5.setDoInput(true);
                    int i = _eeVar._g;
                    if (i <= 0) {
                        i = 10000;
                    }
                    r5.setConnectTimeout(i);
                    int i2 = _eeVar._g;
                    r5.setReadTimeout(i2 > 0 ? i2 : 10000);
                    if (!"POST".equals(_eeVar._d)) {
                        outputStream = null;
                        printWriter = null;
                        responseCode = r5.getResponseCode();
                        if (responseCode != -1) {
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } else {
                            if (responseCode != 200) {
                                if (responseCode != 204) {
                                    throw new NotActiveException();
                                }
                                if (responseCode != 400) {
                                    throw new IOException(PtgErrorCode.ILLEGAL_REQUEST);
                                }
                                if (responseCode != 404) {
                                    throw new IOException(PtgErrorCode.ILLEGAL_PATH);
                                }
                                if (responseCode != 500) {
                                    throw new IOException(_a((HttpURLConnection) r5));
                                }
                                if (responseCode != 502) {
                                    throw new IOException(PtgErrorCode.ILLEGAL_SERVER);
                                }
                                throw new _h0("API_RESPONSE_" + responseCode, r5);
                            }
                            inputStream_a = _a(r5.getInputStream(), r5.getContentEncoding());
                            if (inputStream_a != null) {
                                byte[] bArr_a = _a(inputStream_a);
                                _eeVar._f = bArr_a;
                                String str = new String(bArr_a, "UTF-8");
                                if (printWriter != null) {
                                    printWriter.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                r5.disconnect();
                                return str;
                            }
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        }
                        r5.disconnect();
                        return null;
                    }
                    r5.setDoOutput(true);
                    if (TextUtils.isEmpty(_eeVar._e)) {
                        HashMap map = _eeVar._b;
                        Random random = com.kc.aw.lib.utils._a._a;
                        if (map != null && map.size() > 0) {
                            z = false;
                        }
                        if (z) {
                            outputStream = null;
                            printWriter = null;
                        } else {
                            String str2 = "BOUNDARY" + Long.toHexString(System.currentTimeMillis());
                            String str3 = "--" + str2 + "\r\n";
                            r5.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str2);
                            r5.connect();
                            outputStream2 = r5.getOutputStream();
                            try {
                                printWriter = new PrintWriter(outputStream2);
                                try {
                                    printWriter.write("\r\n");
                                    printWriter.write(str3);
                                    for (Map.Entry entry2 : _eeVar._b.entrySet()) {
                                        String str4 = (String) entry2.getKey();
                                        Object value = entry2.getValue();
                                        if (!TextUtils.isEmpty(str4)) {
                                            printWriter.write("Content-Disposition: form-data; name=\"" + str4 + "\"\r\n");
                                            printWriter.write("\r\n");
                                            printWriter.write(String.valueOf(value));
                                            printWriter.write("\r\n");
                                            printWriter.write(str3);
                                        }
                                    }
                                    printWriter.flush();
                                    if (printWriter.checkError()) {
                                        throw new IOException("Error writing multipart form data");
                                    }
                                    outputStream = outputStream2;
                                } catch (_h0 e) {
                                    e = e;
                                    r4 = r5;
                                    throw e;
                                } catch (SocketTimeoutException e2) {
                                    e = e2;
                                    outputStream3 = outputStream2;
                                    url = r5;
                                    Logger.e(e.getMessage());
                                    throw new _h0("TIMEOUT_API_RESPONSE: " + e.getMessage());
                                } catch (IOException e3) {
                                    e = e3;
                                    r4 = r5;
                                    throw e;
                                } catch (Exception e4) {
                                    e = e4;
                                    Logger.e(e.getMessage());
                                    throw new _h0("Unknown: " + e.getMessage());
                                } catch (Throwable th) {
                                    th = th;
                                    outputStream = outputStream2;
                                }
                            } catch (_h0 e5) {
                                e = e5;
                                printWriter = null;
                                r4 = r5;
                                throw e;
                            } catch (SocketTimeoutException e6) {
                                e = e6;
                                printWriter = null;
                            } catch (IOException e7) {
                                e = e7;
                                printWriter = null;
                                r4 = r5;
                                throw e;
                            } catch (Exception e8) {
                                e = e8;
                            } catch (Throwable th2) {
                                th = th2;
                                outputStream = outputStream2;
                                r1 = r5;
                            }
                            printWriter2 = printWriter;
                            r1 = r5;
                        }
                    } else {
                        outputStream = r5.getOutputStream();
                        try {
                            outputStream.write(_eeVar._e.getBytes("UTF-8"));
                            outputStream.flush();
                            printWriter = null;
                        } catch (_h0 e9) {
                            e = e9;
                            printWriter = null;
                            outputStream4 = outputStream;
                            outputStream2 = outputStream4;
                            r4 = r5;
                            try {
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream = outputStream2;
                                r3 = r4;
                                r5 = r3;
                                printWriter2 = printWriter;
                                r1 = r5;
                                if (printWriter2 != null) {
                                    try {
                                        printWriter2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (r1 != 0) {
                                    throw th;
                                }
                                r1.disconnect();
                                throw th;
                            }
                        } catch (SocketTimeoutException e10) {
                            e = e10;
                            printWriter = null;
                            outputStream3 = outputStream;
                            url = r5;
                            Logger.e(e.getMessage());
                            throw new _h0("TIMEOUT_API_RESPONSE: " + e.getMessage());
                        } catch (IOException e11) {
                            e = e11;
                            printWriter = null;
                            outputStream4 = outputStream;
                            outputStream2 = outputStream4;
                            r4 = r5;
                            throw e;
                        } catch (Exception e12) {
                            e = e12;
                            Logger.e(e.getMessage());
                            throw new _h0("Unknown: " + e.getMessage());
                        } catch (Throwable th4) {
                            th = th4;
                            printWriter = null;
                            r2 = r5;
                            r3 = r2;
                            r5 = r3;
                        }
                    }
                    try {
                        responseCode = r5.getResponseCode();
                        if (responseCode != -1) {
                            if (printWriter != null) {
                                try {
                                    printWriter.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } else {
                            if (responseCode != 200) {
                                if (responseCode != 204) {
                                    throw new NotActiveException();
                                }
                                if (responseCode != 400) {
                                    throw new IOException(PtgErrorCode.ILLEGAL_REQUEST);
                                }
                                if (responseCode != 404) {
                                    throw new IOException(PtgErrorCode.ILLEGAL_PATH);
                                }
                                if (responseCode != 500) {
                                    throw new IOException(_a((HttpURLConnection) r5));
                                }
                                if (responseCode != 502) {
                                    throw new IOException(PtgErrorCode.ILLEGAL_SERVER);
                                }
                                throw new _h0("API_RESPONSE_" + responseCode, r5);
                            }
                            inputStream_a = _a(r5.getInputStream(), r5.getContentEncoding());
                            if (inputStream_a != null) {
                                byte[] bArr_a2 = _a(inputStream_a);
                                _eeVar._f = bArr_a2;
                                String str5 = new String(bArr_a2, "UTF-8");
                                if (printWriter != null) {
                                    try {
                                        printWriter.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                r5.disconnect();
                                return str5;
                            }
                            if (printWriter != null) {
                                try {
                                    printWriter.close();
                                } catch (Exception unused6) {
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                        }
                        r5.disconnect();
                        return null;
                    } catch (_h0 e13) {
                        e = e13;
                        outputStream4 = outputStream;
                        outputStream2 = outputStream4;
                        r4 = r5;
                        throw e;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        outputStream3 = outputStream;
                        url = r5;
                        Logger.e(e.getMessage());
                        throw new _h0("TIMEOUT_API_RESPONSE: " + e.getMessage());
                    } catch (IOException e15) {
                        e = e15;
                        outputStream4 = outputStream;
                        outputStream2 = outputStream4;
                        r4 = r5;
                        throw e;
                    } catch (Exception e16) {
                        e = e16;
                        Logger.e(e.getMessage());
                        throw new _h0("Unknown: " + e.getMessage());
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (_h0 e17) {
                    e = e17;
                    printWriter = null;
                    outputStream2 = outputStream4;
                    r4 = r5;
                    throw e;
                } catch (SocketTimeoutException e18) {
                    e = e18;
                    printWriter = null;
                    url = r5;
                } catch (IOException e19) {
                    e = e19;
                    printWriter = null;
                    outputStream2 = outputStream4;
                    r4 = r5;
                    throw e;
                } catch (Exception e20) {
                    e = e20;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                    r1 = r5;
                }
            } catch (Throwable th7) {
                th = th7;
                outputStream = outputStream3;
                r2 = url;
            }
        } catch (_h0 e21) {
            e = e21;
            outputStream2 = null;
            printWriter = null;
            throw e;
        } catch (SocketTimeoutException e22) {
            e = e22;
            url = 0;
            printWriter = null;
        } catch (IOException e23) {
            e = e23;
            outputStream2 = null;
            printWriter = null;
            throw e;
        } catch (Exception e24) {
            e = e24;
        } catch (Throwable th8) {
            th = th8;
            outputStream = null;
            r1 = 0;
        }
        if (printWriter2 != null) {
            printWriter2.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
        if (r1 != 0) {
            throw th;
        }
        r1.disconnect();
        throw th;
    }
}
