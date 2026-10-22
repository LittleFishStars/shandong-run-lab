package com.kc.aw.download;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.blankj.utilcode.util.f;
import com.ipd.dsp.internal.b1.b;
import com.kc.aw._d5;
import com.kc.aw._d8;
import com.kc.aw._d9;
import com.kc.aw._da;
import com.kc.aw._ds;
import com.kc.aw._g6;
import com.kc.aw._h9;
import com.kc.aw.download.beans.RequestInfo;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadService extends Service {
    public static final int _e;
    public static final int _f;
    public static final HashMap _g;
    public static final HashSet _h;
    public static final HashSet _i;
    public final _b _a = new _b(_e, _f, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
    public final HashMap<String, _d> _b = new HashMap<>();
    public final HashMap<String, List<_d>> _c = new HashMap<>();
    public final HashMap<String, _d8> _d = new HashMap<>(100);

    @Keep
    public final class _a implements _d9 {
        public final RequestInfo _a;
        public final DownloadService _b;

        public _a(DownloadService downloadService, RequestInfo requestInfo) {
            this._b = downloadService;
            this._a = requestInfo;
        }

        public final void _a(boolean z, String str, _d8 _d8Var) {
            List<_d> listRemove;
            if (!z) {
                DownloadService downloadService = this._b;
                RequestInfo requestInfo = this._a;
                RuntimeException runtimeException = new RuntimeException("download metadata fail");
                int i = DownloadService._e;
                downloadService.getClass();
                DownloadService._a(requestInfo, runtimeException);
                return;
            }
            synchronized (this._b._d) {
                this._b._d.put(str, _d8Var);
            }
            synchronized (this._b._c) {
                listRemove = this._b._c.remove(str);
            }
            if (listRemove != null) {
                for (_d _dVar : listRemove) {
                    _b _bVar = this._b._a;
                    _bVar.getClass();
                    _ds _dsVar = _dVar._d;
                    int i2 = _dsVar != null ? _dsVar._g : 47;
                    if (i2 == 45 || i2 == 47) {
                        _dsVar._g = 42;
                        Intent intent = new Intent();
                        intent.setAction(_dVar._c._d);
                        intent.putExtra("download_extra", _dVar._d);
                        _dVar._b.sendBroadcast(intent);
                        _bVar.execute(_dVar);
                    }
                }
            }
        }
    }

    @Keep
    public static final class _b extends ThreadPoolExecutor {
        public _b(int i, int i2, TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(i, i2, 0L, timeUnit, blockingQueue);
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final RequestInfo _a;
        public final _d9 _b;
        public final DownloadService _c;

        public _c(DownloadService downloadService, RequestInfo requestInfo, _a _aVar) {
            this._c = downloadService;
            this._a = requestInfo;
            this._b = _aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                DownloadService downloadService = this._c;
                RequestInfo requestInfo = this._a;
                _d8 _d8Var_a = DownloadService._a(downloadService, requestInfo._c, requestInfo._a, requestInfo._b);
                _d9 _d9Var = this._b;
                if (_d9Var != null) {
                    ((_a) _d9Var)._a(true, this._a._c, _d8Var_a);
                }
            } catch (Exception e) {
                _d9 _d9Var2 = this._b;
                if (_d9Var2 != null) {
                    ((_a) _d9Var2)._a(false, this._a._c, null);
                }
                DownloadService downloadService2 = this._c;
                RequestInfo requestInfo2 = this._a;
                int i = DownloadService._e;
                downloadService2.getClass();
                DownloadService._a(requestInfo2, e);
            }
        }
    }

    @Keep
    public final class _d implements Runnable {
        public String _a;
        public final Context _b;
        public final _d5 _c;
        public final _ds _d;
        public final _g6 _e;
        public boolean _f;
        public int _g;
        public final Messenger _h;
        public final RequestInfo _i;
        public final DownloadService _j;

        @Keep
        public final class _a implements Runnable {
            public int _a = -1;
            public final _d _b;

            public _a(_d _dVar) {
                this._b = _dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i = this._a;
                _d _dVar = this._b;
                int i2 = _dVar._g;
                if (i != i2) {
                    _d._a(_dVar, _dVar._c, i2);
                    this._a = this._b._g;
                }
                Handler handler = com.kc.aw.lib.utils._d._b;
                handler.removeCallbacks(this);
                handler.postDelayed(this, 1000L);
            }
        }

        @Keep
        public final class _b implements Runnable {
            public final _d _a;

            public _b(_d _dVar) {
                this._a = _dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                _d _dVar = this._a;
                DownloadService._a(_dVar._j, _dVar.hashCode());
            }
        }

        public _d(DownloadService downloadService, Context context, String str, Messenger messenger, RequestInfo requestInfo, _d5 _d5Var, _g6 _g6Var) {
            long j_a;
            this._j = downloadService;
            this._b = context;
            this._c = _d5Var;
            this._e = _g6Var;
            this._h = messenger;
            this._a = str;
            this._i = requestInfo;
            _ds _dsVar = new _ds();
            this._d = _dsVar;
            _dsVar._b(_d5Var._b());
            _dsVar._a(str);
            if (_d5Var._a() != null) {
                _d5Var._a().getName();
            }
            _dsVar._c(_d5Var._a() == null ? null : _d5Var._a().getAbsolutePath());
            _ds _dsVar_b = _g6Var._b(_d5Var._b());
            long j = 0;
            if (_dsVar_b != null) {
                j_a = _dsVar_b._a();
                long j_e = _dsVar_b._e();
                if (j_a == 0) {
                    if (_d5Var._a() != null && _d5Var._a().exists()) {
                        _d5Var._a().delete();
                    }
                } else if (_d5Var._a() != null && !_d5Var._a().exists()) {
                    _g6Var._a(_d5Var._b());
                    j_a = 0;
                }
                j = j_e;
            } else {
                j_a = 0;
            }
            _dsVar._b(j);
            _dsVar._a(j_a);
        }

        public static void _a(_d _dVar, _d5 _d5Var, int i) {
            int i2;
            String str;
            if (_h9._a(_dVar._j.getApplicationContext())) {
                NotificationManager notificationManager = (NotificationManager) _dVar._j.getSystemService(NotificationManager.class);
                if (notificationManager.getNotificationChannel("ptg_download_channel") == null) {
                    NotificationChannel notificationChannel = new NotificationChannel("ptg_download_channel", "下载", 2);
                    notificationChannel.setDescription("下载信息通知");
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.getNotificationChannel("ptg_download_channel");
                }
                RemoteViews remoteViews = new RemoteViews(PtgAdSdk.getContext().getPackageName(), R.layout.aw_download_progress);
                remoteViews.setProgressBar(R.id.ptg_progress, 100, i, false);
                if (TextUtils.isEmpty(_dVar._a)) {
                    _dVar._a = "下载管理";
                }
                remoteViews.setTextViewText(R.id.ptg_text_title, _dVar._a);
                if (i != 0) {
                    if (i >= 100) {
                        i2 = R.id.ptgNotifyTextContent;
                        str = "已完成下载";
                    } else {
                        remoteViews.setTextViewText(R.id.ptgNotifyTextContent, "已下载" + i + "%");
                    }
                    Intent intent = new Intent(_dVar._j.getPackageName() + ".ptg.action.download.cancel");
                    intent.putExtra("download_extra", _d5Var);
                    PendingIntent service = PendingIntent.getService(_dVar._b, 10000, intent, f.a.c);
                    int i3 = R.id.ptg_controller_btn;
                    remoteViews.setOnClickPendingIntent(i3, service);
                    remoteViews.setViewVisibility(i3, 0);
                    Notification notificationBuild = new NotificationCompat.Builder(PtgAdSdk.getContext(), "ptg_download_channel").setSmallIcon(R.drawable.aw_ic_download).setTicker("准备下载...").setShowWhen(false).setCustomContentView(remoteViews).build();
                    notificationBuild.flags = 32;
                    DownloadService._a(_dVar._j, _dVar.hashCode(), notificationBuild);
                }
                i2 = R.id.ptgNotifyTextContent;
                str = b.a.l;
                remoteViews.setTextViewText(i2, str);
                Intent intent2 = new Intent(_dVar._j.getPackageName() + ".ptg.action.download.cancel");
                intent2.putExtra("download_extra", _d5Var);
                PendingIntent service2 = PendingIntent.getService(_dVar._b, 10000, intent2, f.a.c);
                int i4 = R.id.ptg_controller_btn;
                remoteViews.setOnClickPendingIntent(i4, service2);
                remoteViews.setViewVisibility(i4, 0);
                Notification notificationBuild2 = new NotificationCompat.Builder(PtgAdSdk.getContext(), "ptg_download_channel").setSmallIcon(R.drawable.aw_ic_download).setTicker("准备下载...").setShowWhen(false).setCustomContentView(remoteViews).build();
                notificationBuild2.flags = 32;
                DownloadService._a(_dVar._j, _dVar.hashCode(), notificationBuild2);
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x058e */
        /* JADX WARN: Bottom block not found for handler: all -> 0x05ab */
        /* JADX WARN: Code duplicated, block: B:342:0x05ed A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:343:0x05ef A[Catch: IOException -> 0x05ea, TryCatch #51 {IOException -> 0x05ea, blocks: (B:339:0x05e6, B:343:0x05ef, B:345:0x05f4), top: B:499:0x05e6 }] */
        /* JADX WARN: Code duplicated, block: B:345:0x05f4 A[Catch: IOException -> 0x05ea, TRY_LEAVE, TryCatch #51 {IOException -> 0x05ea, blocks: (B:339:0x05e6, B:343:0x05ef, B:345:0x05f4), top: B:499:0x05e6 }] */
        /* JADX WARN: Code duplicated, block: B:350:0x0600 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:359:0x0621 A[Catch: all -> 0x0687, TRY_ENTER, TryCatch #46 {, blocks: (B:351:0x0602, B:352:0x0606, B:355:0x0616, B:359:0x0621, B:360:0x0625, B:362:0x062b, B:364:0x0637, B:369:0x066b, B:370:0x066c, B:372:0x0678, B:373:0x0685, B:353:0x0607, B:354:0x0615), top: B:494:0x0602, inners: #34 }] */
        /* JADX WARN: Code duplicated, block: B:362:0x062b A[Catch: all -> 0x0687, TryCatch #46 {, blocks: (B:351:0x0602, B:352:0x0606, B:355:0x0616, B:359:0x0621, B:360:0x0625, B:362:0x062b, B:364:0x0637, B:369:0x066b, B:370:0x066c, B:372:0x0678, B:373:0x0685, B:353:0x0607, B:354:0x0615), top: B:494:0x0602, inners: #34 }] */
        /* JADX WARN: Code duplicated, block: B:372:0x0678 A[Catch: all -> 0x0687, TryCatch #46 {, blocks: (B:351:0x0602, B:352:0x0606, B:355:0x0616, B:359:0x0621, B:360:0x0625, B:362:0x062b, B:364:0x0637, B:369:0x066b, B:370:0x066c, B:372:0x0678, B:373:0x0685, B:353:0x0607, B:354:0x0615), top: B:494:0x0602, inners: #34 }] */
        /* JADX WARN: Code duplicated, block: B:390:0x06b8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:391:0x06ba A[Catch: IOException -> 0x06b5, TryCatch #31 {IOException -> 0x06b5, blocks: (B:387:0x06b1, B:391:0x06ba, B:393:0x06bf), top: B:476:0x06b1 }] */
        /* JADX WARN: Code duplicated, block: B:393:0x06bf A[Catch: IOException -> 0x06b5, TRY_LEAVE, TryCatch #31 {IOException -> 0x06b5, blocks: (B:387:0x06b1, B:391:0x06ba, B:393:0x06bf), top: B:476:0x06b1 }] */
        /* JADX WARN: Code duplicated, block: B:398:0x06cb A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:407:0x06ec A[Catch: all -> 0x0752, TRY_ENTER, TryCatch #23 {, blocks: (B:399:0x06cd, B:400:0x06d1, B:403:0x06e1, B:407:0x06ec, B:408:0x06f0, B:410:0x06f6, B:412:0x0702, B:417:0x0736, B:418:0x0737, B:420:0x0743, B:421:0x0750, B:401:0x06d2, B:402:0x06e0), top: B:467:0x06cd, inners: #13 }] */
        /* JADX WARN: Code duplicated, block: B:410:0x06f6 A[Catch: all -> 0x0752, TryCatch #23 {, blocks: (B:399:0x06cd, B:400:0x06d1, B:403:0x06e1, B:407:0x06ec, B:408:0x06f0, B:410:0x06f6, B:412:0x0702, B:417:0x0736, B:418:0x0737, B:420:0x0743, B:421:0x0750, B:401:0x06d2, B:402:0x06e0), top: B:467:0x06cd, inners: #13 }] */
        /* JADX WARN: Code duplicated, block: B:420:0x0743 A[Catch: all -> 0x0752, TryCatch #23 {, blocks: (B:399:0x06cd, B:400:0x06d1, B:403:0x06e1, B:407:0x06ec, B:408:0x06f0, B:410:0x06f6, B:412:0x0702, B:417:0x0736, B:418:0x0737, B:420:0x0743, B:421:0x0750, B:401:0x06d2, B:402:0x06e0), top: B:467:0x06cd, inners: #13 }] */
        /* JADX WARN: Code duplicated, block: B:450:0x06d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:467:0x06cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:476:0x06b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:482:0x0607 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:488:0x06e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:494:0x0602 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:499:0x05e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:505:0x061c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:528:0x0702 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:530:0x06f0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:533:0x0637 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:535:0x0625 A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v10 */
        /* JADX WARN: Type inference failed for: r14v11 */
        /* JADX WARN: Type inference failed for: r14v12 */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r14v4, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r14v8 */
        /* JADX WARN: Type inference failed for: r14v9 */
        /* JADX WARN: Type inference failed for: r24v1 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v15, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r3v33 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v78 */
        /* JADX WARN: Type inference failed for: r3v79 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r4v24 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v71 */
        /* JADX WARN: Type inference failed for: r4v72 */
        /* JADX WARN: Type inference failed for: r4v73 */
        /* JADX WARN: Type inference failed for: r4v74 */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v32 */
        /* JADX WARN: Type inference failed for: r5v34 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r5v83 */
        /* JADX WARN: Type inference failed for: r5v84 */
        /* JADX WARN: Type inference failed for: r5v85 */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v43 */
        /* JADX WARN: Type inference failed for: r6v44 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v15, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v22 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v25 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r7v68 */
        /* JADX WARN: Type inference failed for: r7v69 */
        /* JADX WARN: Type inference failed for: r7v72 */
        /* JADX WARN: Type inference failed for: r7v73 */
        /* JADX WARN: Type inference failed for: r7v74 */
        /* JADX WARN: Type inference failed for: r7v75 */
        /* JADX WARN: Type inference failed for: r7v76 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void _a() throws Throwable {
            _a _aVar;
            Exception exc;
            Exception exc2;
            Throwable th;
            Exception exc3;
            ?? r14;
            Throwable th2;
            ?? r7;
            ?? r6;
            Exception exc4;
            ?? r4;
            ?? r3;
            ?? r15;
            Throwable th3;
            ?? r8;
            ?? r9;
            Exception exc5;
            ?? r5;
            ?? r10;
            Exception exc6;
            ?? r11;
            ?? r12;
            ?? r13;
            List<_d> list;
            _ds _dsVar_b;
            ?? r16;
            ?? r17;
            List<_d> list2;
            _ds _dsVar_b2;
            _d8 _d8Var;
            Exception exc7;
            Exception exc8;
            RandomAccessFile randomAccessFile;
            Throwable th4;
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            InputStream inputStream2;
            HttpURLConnection httpURLConnection2;
            Throwable th5;
            List<_d> list3;
            List<_d> list4;
            List<_d> list5;
            this._d._a(43);
            ?? r18 = 0;
            exc = null;
            Exception exc9 = null;
            _a(this._d, null);
            if (_h9._a(this._j.getApplicationContext())) {
                _aVar = new _a(this);
                Handler handler = com.kc.aw.lib.utils._d._b;
                handler.removeCallbacks(_aVar);
                handler.postDelayed(_aVar, 1000L);
            } else {
                _aVar = null;
            }
            try {
                try {
                    synchronized (this._j._d) {
                        try {
                            _d8Var = (_d8) this._j._d.get(this._c._c());
                        } catch (Throwable th6) {
                            th = th6;
                            exc = null;
                            while (true) {
                                try {
                                    break;
                                } catch (Exception e) {
                                    e = e;
                                    exc3 = e;
                                    Exception exc10 = exc;
                                    Exception exc11 = exc10;
                                    r14 = exc11;
                                    r13 = exc10;
                                    r12 = exc;
                                    r11 = exc11;
                                    try {
                                        this._d._a(47);
                                        _g6 _g6Var = this._e;
                                        _ds _dsVar = this._d;
                                        try {
                                            _g6Var._a.put(_dsVar._a, _dsVar);
                                            _a(this._d, exc3);
                                            exc3.printStackTrace();
                                            com.kc.aw.lib.utils._d._a(_aVar);
                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                            if (r12 != 0) {
                                                try {
                                                    r12.close();
                                                    if (r13 != 0) {
                                                        r13.close();
                                                    }
                                                    if (r11 != 0) {
                                                        r11.disconnect();
                                                    }
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    synchronized (DownloadService._h) {
                                                        if (r14 != 0) {
                                                            synchronized (DownloadService._g) {
                                                                list = (List) DownloadService._g.get(r14.getAbsolutePath());
                                                                if (r14.exists()) {
                                                                    try {
                                                                        r14.deleteOnExit();
                                                                    } catch (Throwable unused) {
                                                                    }
                                                                }
                                                                if (list != null) {
                                                                    for (_d _dVar : list) {
                                                                        _dsVar_b = _dVar._b();
                                                                        if (_dsVar_b != null) {
                                                                            _dsVar_b._a(this._d._a());
                                                                            _dsVar_b._b(this._d._d());
                                                                            _dsVar_b._c(this._d._c());
                                                                            _dsVar_b._b(this._d._e());
                                                                            _dsVar_b._a(this._d._b());
                                                                            _dVar._a(_dsVar_b, exc3);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (!TextUtils.isEmpty(this._c._c())) {
                                                            DownloadService._h.remove(this._c._c());
                                                        }
                                                        return;
                                                    }
                                                }
                                            } else {
                                                if (r13 != 0) {
                                                    r13.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.disconnect();
                                                }
                                            }
                                            synchronized (DownloadService._h) {
                                                if (r14 != 0) {
                                                    synchronized (DownloadService._g) {
                                                        list = (List) DownloadService._g.get(r14.getAbsolutePath());
                                                        if (r14.exists()) {
                                                            r14.deleteOnExit();
                                                        }
                                                        if (list != null) {
                                                            while (r2.hasNext()) {
                                                                _dsVar_b = _dVar._b();
                                                                if (_dsVar_b != null) {
                                                                    _dsVar_b._a(this._d._a());
                                                                    _dsVar_b._b(this._d._d());
                                                                    _dsVar_b._c(this._d._c());
                                                                    _dsVar_b._b(this._d._e());
                                                                    _dsVar_b._a(this._d._b());
                                                                    _dVar._a(_dsVar_b, exc3);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                                return;
                                            }
                                        } catch (Throwable th7) {
                                            ?? r24 = r12;
                                            exc5 = exc3;
                                            r18 = r13;
                                            th3 = th7;
                                            r9 = r24;
                                            r8 = r11;
                                            r15 = r14;
                                        }
                                    } catch (Throwable th8) {
                                        th2 = th8;
                                        r6 = r12;
                                        exc4 = exc3;
                                        r3 = r14;
                                        r4 = r13;
                                        r7 = r11;
                                        r15 = r3;
                                        r18 = r4;
                                        th3 = th2;
                                        exc5 = exc4;
                                        r9 = r6;
                                        r8 = r7;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    exc2 = exc;
                                }
                            }
                            throw th;
                        }
                    }
                    if (_d8Var == null) {
                        try {
                            synchronized (this._j._d) {
                                _d8Var = (_d8) this._j._d.get(this._c._c());
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            exc2 = null;
                            th2 = th;
                            Exception exc12 = exc2;
                            Exception exc13 = exc12;
                            Exception exc14 = exc13;
                            r7 = exc14;
                            r3 = exc12;
                            r4 = exc13;
                            exc4 = exc2;
                            r6 = exc14;
                            r15 = r3;
                            r18 = r4;
                            th3 = th2;
                            exc5 = exc4;
                            r9 = r6;
                            r8 = r7;
                        }
                    }
                    try {
                        if (_d8Var == null) {
                            this._d._a(47);
                            _a(this._d, new RuntimeException("request download metadata fail"));
                            com.kc.aw.lib.utils._d._a(_aVar);
                            com.kc.aw.lib.utils._d._c(new _b(this));
                            synchronized (DownloadService._h) {
                                if (!TextUtils.isEmpty(this._c._c())) {
                                    DownloadService._h.remove(this._c._c());
                                }
                            }
                            return;
                        }
                        String str_b = _d8Var._b();
                        long j_c = _d8Var._c();
                        String str_a = _d8Var._a();
                        File file_a = this._c._a();
                        if (file_a == null) {
                            file_a = _da._a(this._b, str_a);
                        }
                        if (file_a != null) {
                            _ds _dsVar2 = this._d;
                            file_a.getName();
                            _dsVar2.getClass();
                            this._d._c(file_a.getAbsolutePath());
                        }
                        if (j_c <= 0) {
                            if (file_a != null && file_a.exists()) {
                                file_a.delete();
                            }
                            this._e._a(this._c._b());
                            this._d._a(47);
                            _a(this._d, new RuntimeException("download file length is 0 byte"));
                            com.kc.aw.lib.utils._d._a(_aVar);
                            com.kc.aw.lib.utils._d._c(new _b(this));
                            synchronized (DownloadService._h) {
                                if (!TextUtils.isEmpty(this._c._c())) {
                                    DownloadService._h.remove(this._c._c());
                                }
                            }
                            return;
                        }
                        this._d._b(j_c);
                        if (file_a != null && file_a.exists() && file_a.length() == j_c) {
                            this._d._a(file_a.length());
                            this._d._b(100);
                            this._d._a(46);
                            _g6 _g6Var2 = this._e;
                            _ds _dsVar3 = this._d;
                            _g6Var2._a.put(_dsVar3._a, _dsVar3);
                            _a(this._d, null);
                            com.kc.aw.lib.utils._d._a(_aVar);
                            com.kc.aw.lib.utils._d._c(new _b(this));
                            synchronized (DownloadService._h) {
                                if (!TextUtils.isEmpty(this._c._c())) {
                                    DownloadService._h.remove(this._c._c());
                                }
                            }
                            return;
                        }
                        File file = new File(file_a.getAbsolutePath() + ".tmp");
                        try {
                            synchronized (DownloadService._h) {
                                try {
                                    if (file.exists()) {
                                        if (DownloadService._h.contains(this._c._c())) {
                                            synchronized (DownloadService._g) {
                                                List arrayList = (List) DownloadService._g.get(file.getAbsolutePath());
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList();
                                                    DownloadService._g.put(file.getAbsolutePath(), arrayList);
                                                }
                                                arrayList.add(this);
                                            }
                                            com.kc.aw.lib.utils._d._a(_aVar);
                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                            synchronized (DownloadService._h) {
                                                synchronized (DownloadService._g) {
                                                    list5 = (List) DownloadService._g.get(file.getAbsolutePath());
                                                }
                                                if (file.exists()) {
                                                    try {
                                                        file.deleteOnExit();
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                                if (list5 != null) {
                                                    for (_d _dVar2 : list5) {
                                                        _ds _dsVar_b3 = _dVar2._b();
                                                        if (_dsVar_b3 != null) {
                                                            _dsVar_b3._a(this._d._a());
                                                            _dsVar_b3._b(this._d._d());
                                                            _dsVar_b3._c(this._d._c());
                                                            _dsVar_b3._b(this._d._e());
                                                            _dsVar_b3._a(this._d._b());
                                                            _dVar2._a(_dsVar_b3, null);
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                            }
                                            return;
                                        }
                                        file.deleteOnExit();
                                    }
                                    if (!TextUtils.isEmpty(this._c._c())) {
                                        DownloadService._h.add(this._c._c());
                                    }
                                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                                    try {
                                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str_b).openConnection();
                                        try {
                                            httpURLConnection3.setConnectTimeout(10000);
                                            httpURLConnection3.setRequestProperty("Connection", com.google.common.net.b.t0);
                                            httpURLConnection3.setReadTimeout(10000);
                                            httpURLConnection3.setRequestProperty("Range", "bytes=0-");
                                            httpURLConnection3.connect();
                                            inputStream = httpURLConnection3.getInputStream();
                                            float f = j_c;
                                            int i = (int) ((f / 100.0f) + 0.5f);
                                            if (i <= 0) {
                                                i = 1;
                                            } else if (i > 8192) {
                                                i = 8192;
                                            }
                                            try {
                                                try {
                                                    byte[] bArr = new byte[i];
                                                    randomAccessFile2.seek(this._d._a());
                                                    long jUptimeMillis = SystemClock.uptimeMillis();
                                                    while (true) {
                                                        int i2 = inputStream.read(bArr);
                                                        if (i2 == -1) {
                                                            randomAccessFile = randomAccessFile2;
                                                            try {
                                                                file.renameTo(file_a);
                                                                if (file_a.exists()) {
                                                                    this._d._a(46);
                                                                    _g6 _g6Var3 = this._e;
                                                                    _ds _dsVar4 = this._d;
                                                                    try {
                                                                        _g6Var3._a.put(_dsVar4._a, _dsVar4);
                                                                        try {
                                                                            _a(this._d, null);
                                                                            com.kc.aw.lib.utils._d._a(_aVar);
                                                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                                                            try {
                                                                                randomAccessFile.close();
                                                                                inputStream.close();
                                                                                httpURLConnection3.disconnect();
                                                                            } catch (IOException e3) {
                                                                                e3.printStackTrace();
                                                                            }
                                                                            synchronized (DownloadService._h) {
                                                                                synchronized (DownloadService._g) {
                                                                                    list3 = (List) DownloadService._g.get(file.getAbsolutePath());
                                                                                }
                                                                                if (file.exists()) {
                                                                                    try {
                                                                                        file.deleteOnExit();
                                                                                    } catch (Throwable unused3) {
                                                                                    }
                                                                                }
                                                                                if (list3 != null) {
                                                                                    for (_d _dVar3 : list3) {
                                                                                        _ds _dsVar_b4 = _dVar3._b();
                                                                                        if (_dsVar_b4 != null) {
                                                                                            _dsVar_b4._a(this._d._a());
                                                                                            _dsVar_b4._b(this._d._d());
                                                                                            _dsVar_b4._c(this._d._c());
                                                                                            _dsVar_b4._b(this._d._e());
                                                                                            _dsVar_b4._a(this._d._b());
                                                                                            _dVar3._a(_dsVar_b4, null);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                                                    DownloadService._h.remove(this._c._c());
                                                                                }
                                                                            }
                                                                            return;
                                                                        } catch (Throwable th11) {
                                                                            th = th11;
                                                                            exc8 = null;
                                                                            th5 = th;
                                                                            th4 = th5;
                                                                            httpURLConnection = httpURLConnection3;
                                                                            th3 = th4;
                                                                            exc6 = exc8;
                                                                            r5 = inputStream;
                                                                            r10 = randomAccessFile;
                                                                            r17 = httpURLConnection;
                                                                            r16 = file;
                                                                            com.kc.aw.lib.utils._d._a(_aVar);
                                                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                                                            if (r10 != 0) {
                                                                                r10.close();
                                                                                if (r5 != 0) {
                                                                                    r5.close();
                                                                                }
                                                                                if (r17 != 0) {
                                                                                    r17.disconnect();
                                                                                }
                                                                            } else {
                                                                                if (r5 != 0) {
                                                                                    r5.close();
                                                                                }
                                                                                if (r17 != 0) {
                                                                                    r17.disconnect();
                                                                                }
                                                                            }
                                                                            synchronized (DownloadService._h) {
                                                                                if (r16 != 0) {
                                                                                    synchronized (DownloadService._g) {
                                                                                        list2 = (List) DownloadService._g.get(r16.getAbsolutePath());
                                                                                        if (r16.exists()) {
                                                                                            r16.deleteOnExit();
                                                                                        }
                                                                                        if (list2 != null) {
                                                                                            for (_d _dVar4 : list2) {
                                                                                                _dsVar_b2 = _dVar4._b();
                                                                                                if (_dsVar_b2 != null) {
                                                                                                    _dsVar_b2._a(this._d._a());
                                                                                                    _dsVar_b2._b(this._d._d());
                                                                                                    _dsVar_b2._c(this._d._c());
                                                                                                    _dsVar_b2._b(this._d._e());
                                                                                                    _dsVar_b2._a(this._d._b());
                                                                                                    _dVar4._a(_dsVar_b2, exc6);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                                                    DownloadService._h.remove(this._c._c());
                                                                                }
                                                                                throw th3;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th12) {
                                                                        th = th12;
                                                                        exc8 = null;
                                                                    }
                                                                } else {
                                                                    exc8 = null;
                                                                    try {
                                                                        throw new RuntimeException("tmp file rename fail");
                                                                    } catch (Throwable th13) {
                                                                        th = th13;
                                                                    }
                                                                }
                                                            } catch (Throwable th14) {
                                                                th = th14;
                                                                exc8 = null;
                                                            }
                                                            th4 = th;
                                                            httpURLConnection = httpURLConnection3;
                                                            th3 = th4;
                                                            exc6 = exc8;
                                                            r5 = inputStream;
                                                            r10 = randomAccessFile;
                                                            r17 = httpURLConnection;
                                                            r16 = file;
                                                            com.kc.aw.lib.utils._d._a(_aVar);
                                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                                            if (r10 != 0) {
                                                                r10.close();
                                                                if (r5 != 0) {
                                                                    r5.close();
                                                                }
                                                                if (r17 != 0) {
                                                                    r17.disconnect();
                                                                }
                                                            } else {
                                                                if (r5 != 0) {
                                                                    r5.close();
                                                                }
                                                                if (r17 != 0) {
                                                                    r17.disconnect();
                                                                }
                                                            }
                                                            synchronized (DownloadService._h) {
                                                                if (r16 != 0) {
                                                                    synchronized (DownloadService._g) {
                                                                        list2 = (List) DownloadService._g.get(r16.getAbsolutePath());
                                                                    }
                                                                    if (r16.exists()) {
                                                                        r16.deleteOnExit();
                                                                    }
                                                                    if (list2 != null) {
                                                                        while (r3.hasNext()) {
                                                                            _dsVar_b2 = _dVar4._b();
                                                                            if (_dsVar_b2 != null) {
                                                                                _dsVar_b2._a(this._d._a());
                                                                                _dsVar_b2._b(this._d._d());
                                                                                _dsVar_b2._c(this._d._c());
                                                                                _dsVar_b2._b(this._d._e());
                                                                                _dsVar_b2._a(this._d._b());
                                                                                _dVar4._a(_dsVar_b2, exc6);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                                    DownloadService._h.remove(this._c._c());
                                                                }
                                                            }
                                                            throw th3;
                                                        }
                                                        try {
                                                            if (this._f) {
                                                                try {
                                                                    this._d._a(45);
                                                                    this._f = false;
                                                                    _g6 _g6Var4 = this._e;
                                                                    _ds _dsVar5 = this._d;
                                                                    try {
                                                                        _g6Var4._a.put(_dsVar5._a, _dsVar5);
                                                                        _a(this._d, exc9);
                                                                        httpURLConnection3.disconnect();
                                                                        randomAccessFile2.close();
                                                                        inputStream.close();
                                                                        com.kc.aw.lib.utils._d._a(_aVar);
                                                                        com.kc.aw.lib.utils._d._c(new _b(this));
                                                                        try {
                                                                            randomAccessFile2.close();
                                                                            inputStream.close();
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (IOException e4) {
                                                                            e4.printStackTrace();
                                                                        }
                                                                        synchronized (DownloadService._h) {
                                                                            synchronized (DownloadService._g) {
                                                                                list4 = (List) DownloadService._g.get(file.getAbsolutePath());
                                                                            }
                                                                            if (file.exists()) {
                                                                                try {
                                                                                    file.deleteOnExit();
                                                                                } catch (Throwable unused4) {
                                                                                }
                                                                            }
                                                                            if (list4 != null) {
                                                                                for (_d _dVar5 : list4) {
                                                                                    _ds _dsVar_b5 = _dVar5._b();
                                                                                    if (_dsVar_b5 != null) {
                                                                                        _dsVar_b5._a(this._d._a());
                                                                                        _dsVar_b5._b(this._d._d());
                                                                                        _dsVar_b5._c(this._d._c());
                                                                                        _dsVar_b5._b(this._d._e());
                                                                                        _dsVar_b5._a(this._d._b());
                                                                                        _dVar5._a(_dsVar_b5, exc9);
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (!TextUtils.isEmpty(this._c._c())) {
                                                                                DownloadService._h.remove(this._c._c());
                                                                            }
                                                                        }
                                                                        return;
                                                                    } catch (Exception e5) {
                                                                        exc3 = e5;
                                                                        randomAccessFile = randomAccessFile2;
                                                                        inputStream2 = inputStream;
                                                                        httpURLConnection2 = httpURLConnection3;
                                                                        r13 = inputStream2;
                                                                        r12 = randomAccessFile;
                                                                        r11 = httpURLConnection2;
                                                                        r14 = file;
                                                                        this._d._a(47);
                                                                        _g6 _g6Var5 = this._e;
                                                                        _ds _dsVar6 = this._d;
                                                                        _g6Var5._a.put(_dsVar6._a, _dsVar6);
                                                                        _a(this._d, exc3);
                                                                        exc3.printStackTrace();
                                                                        com.kc.aw.lib.utils._d._a(_aVar);
                                                                        com.kc.aw.lib.utils._d._c(new _b(this));
                                                                        if (r12 != 0) {
                                                                            r12.close();
                                                                            if (r13 != 0) {
                                                                                r13.close();
                                                                            }
                                                                            if (r11 != 0) {
                                                                                r11.disconnect();
                                                                            }
                                                                        } else {
                                                                            if (r13 != 0) {
                                                                                r13.close();
                                                                            }
                                                                            if (r11 != 0) {
                                                                                r11.disconnect();
                                                                            }
                                                                        }
                                                                        synchronized (DownloadService._h) {
                                                                            if (r14 != 0) {
                                                                                synchronized (DownloadService._g) {
                                                                                    list = (List) DownloadService._g.get(r14.getAbsolutePath());
                                                                                    if (r14.exists()) {
                                                                                        r14.deleteOnExit();
                                                                                    }
                                                                                    if (list != null) {
                                                                                        while (r2.hasNext()) {
                                                                                            _dsVar_b = _dVar._b();
                                                                                            if (_dsVar_b != null) {
                                                                                                _dsVar_b._a(this._d._a());
                                                                                                _dsVar_b._b(this._d._d());
                                                                                                _dsVar_b._c(this._d._c());
                                                                                                _dsVar_b._b(this._d._e());
                                                                                                _dsVar_b._a(this._d._b());
                                                                                                _dVar._a(_dsVar_b, exc3);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (!TextUtils.isEmpty(this._c._c())) {
                                                                                DownloadService._h.remove(this._c._c());
                                                                            }
                                                                            return;
                                                                        }
                                                                    } catch (Throwable th15) {
                                                                        th5 = th15;
                                                                        exc8 = exc9;
                                                                        randomAccessFile = randomAccessFile2;
                                                                    }
                                                                } catch (Exception e6) {
                                                                    exc3 = e6;
                                                                }
                                                            } else {
                                                                randomAccessFile2.write(bArr, 0, i2);
                                                                _ds _dsVar7 = this._d;
                                                                long j = jUptimeMillis;
                                                                long j2 = i2;
                                                                randomAccessFile = randomAccessFile2;
                                                                try {
                                                                    try {
                                                                        _dsVar7._a(_dsVar7._a() + j2);
                                                                        this._d._a(44);
                                                                        int i_a = (int) (((this._d._a() + j2) / f) * 100.0f);
                                                                        this._g = i_a;
                                                                        if (i_a > 100) {
                                                                            this._g = 100;
                                                                        }
                                                                        this._d._b(this._g);
                                                                        if (SystemClock.uptimeMillis() - j >= 1000) {
                                                                            long jUptimeMillis2 = SystemClock.uptimeMillis();
                                                                            _g6 _g6Var6 = this._e;
                                                                            _ds _dsVar8 = this._d;
                                                                            try {
                                                                                try {
                                                                                    _g6Var6._a.put(_dsVar8._a, _dsVar8);
                                                                                    _a(this._d, null);
                                                                                    jUptimeMillis = jUptimeMillis2;
                                                                                } catch (Throwable th16) {
                                                                                    th = th16;
                                                                                    th4 = th;
                                                                                    exc8 = null;
                                                                                    httpURLConnection = httpURLConnection3;
                                                                                    th3 = th4;
                                                                                    exc6 = exc8;
                                                                                    r5 = inputStream;
                                                                                    r10 = randomAccessFile;
                                                                                    r17 = httpURLConnection;
                                                                                    r16 = file;
                                                                                    com.kc.aw.lib.utils._d._a(_aVar);
                                                                                    com.kc.aw.lib.utils._d._c(new _b(this));
                                                                                    if (r10 != 0) {
                                                                                        try {
                                                                                            r10.close();
                                                                                            if (r5 != 0) {
                                                                                                r5.close();
                                                                                            }
                                                                                            if (r17 != 0) {
                                                                                                r17.disconnect();
                                                                                            }
                                                                                        } catch (IOException e7) {
                                                                                            e7.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (r5 != 0) {
                                                                                            r5.close();
                                                                                        }
                                                                                        if (r17 != 0) {
                                                                                            r17.disconnect();
                                                                                        }
                                                                                    }
                                                                                    synchronized (DownloadService._h) {
                                                                                        if (r16 != 0) {
                                                                                            synchronized (DownloadService._g) {
                                                                                                list2 = (List) DownloadService._g.get(r16.getAbsolutePath());
                                                                                                if (r16.exists()) {
                                                                                                    try {
                                                                                                        r16.deleteOnExit();
                                                                                                    } catch (Throwable unused5) {
                                                                                                    }
                                                                                                }
                                                                                                if (list2 != null) {
                                                                                                    while (r3.hasNext()) {
                                                                                                        _dsVar_b2 = _dVar4._b();
                                                                                                        if (_dsVar_b2 != null) {
                                                                                                            _dsVar_b2._a(this._d._a());
                                                                                                            _dsVar_b2._b(this._d._d());
                                                                                                            _dsVar_b2._c(this._d._c());
                                                                                                            _dsVar_b2._b(this._d._e());
                                                                                                            _dsVar_b2._a(this._d._b());
                                                                                                            _dVar4._a(_dsVar_b2, exc6);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (!TextUtils.isEmpty(this._c._c())) {
                                                                                            DownloadService._h.remove(this._c._c());
                                                                                        }
                                                                                        throw th3;
                                                                                    }
                                                                                }
                                                                            } catch (Exception e8) {
                                                                                e = e8;
                                                                                exc3 = e;
                                                                                inputStream2 = inputStream;
                                                                                httpURLConnection2 = httpURLConnection3;
                                                                                r13 = inputStream2;
                                                                                r12 = randomAccessFile;
                                                                                r11 = httpURLConnection2;
                                                                                r14 = file;
                                                                                this._d._a(47);
                                                                                _g6 _g6Var7 = this._e;
                                                                                _ds _dsVar9 = this._d;
                                                                                _g6Var7._a.put(_dsVar9._a, _dsVar9);
                                                                                _a(this._d, exc3);
                                                                                exc3.printStackTrace();
                                                                                com.kc.aw.lib.utils._d._a(_aVar);
                                                                                com.kc.aw.lib.utils._d._c(new _b(this));
                                                                                if (r12 != 0) {
                                                                                    r12.close();
                                                                                    if (r13 != 0) {
                                                                                        r13.close();
                                                                                    }
                                                                                    if (r11 != 0) {
                                                                                        r11.disconnect();
                                                                                    }
                                                                                } else {
                                                                                    if (r13 != 0) {
                                                                                        r13.close();
                                                                                    }
                                                                                    if (r11 != 0) {
                                                                                        r11.disconnect();
                                                                                    }
                                                                                }
                                                                                synchronized (DownloadService._h) {
                                                                                    if (r14 != 0) {
                                                                                        synchronized (DownloadService._g) {
                                                                                            list = (List) DownloadService._g.get(r14.getAbsolutePath());
                                                                                            if (r14.exists()) {
                                                                                                r14.deleteOnExit();
                                                                                            }
                                                                                            if (list != null) {
                                                                                                while (r2.hasNext()) {
                                                                                                    _dsVar_b = _dVar._b();
                                                                                                    if (_dsVar_b != null) {
                                                                                                        _dsVar_b._a(this._d._a());
                                                                                                        _dsVar_b._b(this._d._d());
                                                                                                        _dsVar_b._c(this._d._c());
                                                                                                        _dsVar_b._b(this._d._e());
                                                                                                        _dsVar_b._a(this._d._b());
                                                                                                        _dVar._a(_dsVar_b, exc3);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (!TextUtils.isEmpty(this._c._c())) {
                                                                                        DownloadService._h.remove(this._c._c());
                                                                                    }
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            jUptimeMillis = j;
                                                                        }
                                                                        exc9 = null;
                                                                        randomAccessFile2 = randomAccessFile;
                                                                    } catch (Throwable th17) {
                                                                        th = th17;
                                                                    }
                                                                } catch (Exception e9) {
                                                                    e = e9;
                                                                    exc3 = e;
                                                                    inputStream2 = inputStream;
                                                                    httpURLConnection2 = httpURLConnection3;
                                                                    r13 = inputStream2;
                                                                    r12 = randomAccessFile;
                                                                    r11 = httpURLConnection2;
                                                                    r14 = file;
                                                                    this._d._a(47);
                                                                    _g6 _g6Var8 = this._e;
                                                                    _ds _dsVar10 = this._d;
                                                                    _g6Var8._a.put(_dsVar10._a, _dsVar10);
                                                                    _a(this._d, exc3);
                                                                    exc3.printStackTrace();
                                                                    com.kc.aw.lib.utils._d._a(_aVar);
                                                                    com.kc.aw.lib.utils._d._c(new _b(this));
                                                                    if (r12 != 0) {
                                                                        r12.close();
                                                                        if (r13 != 0) {
                                                                            r13.close();
                                                                        }
                                                                        if (r11 != 0) {
                                                                            r11.disconnect();
                                                                        }
                                                                    } else {
                                                                        if (r13 != 0) {
                                                                            r13.close();
                                                                        }
                                                                        if (r11 != 0) {
                                                                            r11.disconnect();
                                                                        }
                                                                    }
                                                                    synchronized (DownloadService._h) {
                                                                        if (r14 != 0) {
                                                                            synchronized (DownloadService._g) {
                                                                                list = (List) DownloadService._g.get(r14.getAbsolutePath());
                                                                            }
                                                                            if (r14.exists()) {
                                                                                r14.deleteOnExit();
                                                                            }
                                                                            if (list != null) {
                                                                                while (r2.hasNext()) {
                                                                                    _dsVar_b = _dVar._b();
                                                                                    if (_dsVar_b != null) {
                                                                                        _dsVar_b._a(this._d._a());
                                                                                        _dsVar_b._b(this._d._d());
                                                                                        _dsVar_b._c(this._d._c());
                                                                                        _dsVar_b._b(this._d._e());
                                                                                        _dsVar_b._a(this._d._b());
                                                                                        _dVar._a(_dsVar_b, exc3);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (!TextUtils.isEmpty(this._c._c())) {
                                                                            DownloadService._h.remove(this._c._c());
                                                                        }
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            randomAccessFile = randomAccessFile2;
                                                        }
                                                        th4 = th5;
                                                        httpURLConnection = httpURLConnection3;
                                                        th3 = th4;
                                                        exc6 = exc8;
                                                        r5 = inputStream;
                                                        r10 = randomAccessFile;
                                                        r17 = httpURLConnection;
                                                        r16 = file;
                                                        com.kc.aw.lib.utils._d._a(_aVar);
                                                        com.kc.aw.lib.utils._d._c(new _b(this));
                                                        if (r10 != 0) {
                                                            r10.close();
                                                            if (r5 != 0) {
                                                                r5.close();
                                                            }
                                                            if (r17 != 0) {
                                                                r17.disconnect();
                                                            }
                                                        } else {
                                                            if (r5 != 0) {
                                                                r5.close();
                                                            }
                                                            if (r17 != 0) {
                                                                r17.disconnect();
                                                            }
                                                        }
                                                        synchronized (DownloadService._h) {
                                                            if (r16 != 0) {
                                                                synchronized (DownloadService._g) {
                                                                    list2 = (List) DownloadService._g.get(r16.getAbsolutePath());
                                                                    if (r16.exists()) {
                                                                        r16.deleteOnExit();
                                                                    }
                                                                    if (list2 != null) {
                                                                        while (r3.hasNext()) {
                                                                            _dsVar_b2 = _dVar4._b();
                                                                            if (_dsVar_b2 != null) {
                                                                                _dsVar_b2._a(this._d._a());
                                                                                _dsVar_b2._b(this._d._d());
                                                                                _dsVar_b2._c(this._d._c());
                                                                                _dsVar_b2._b(this._d._e());
                                                                                _dsVar_b2._a(this._d._b());
                                                                                _dVar4._a(_dsVar_b2, exc6);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!TextUtils.isEmpty(this._c._c())) {
                                                                DownloadService._h.remove(this._c._c());
                                                            }
                                                            throw th3;
                                                        }
                                                    }
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    randomAccessFile = randomAccessFile2;
                                                }
                                            } catch (Throwable th19) {
                                                th = th19;
                                                exc8 = exc9;
                                                randomAccessFile = randomAccessFile2;
                                            }
                                        } catch (Exception e11) {
                                            inputStream2 = null;
                                            randomAccessFile = randomAccessFile2;
                                            exc3 = e11;
                                            httpURLConnection2 = httpURLConnection3;
                                        } catch (Throwable th20) {
                                            exc8 = null;
                                            randomAccessFile = randomAccessFile2;
                                            th4 = th20;
                                            inputStream = null;
                                            httpURLConnection = httpURLConnection3;
                                        }
                                    } catch (Exception e12) {
                                        inputStream2 = null;
                                        randomAccessFile = randomAccessFile2;
                                        exc3 = e12;
                                        httpURLConnection2 = null;
                                    } catch (Throwable th21) {
                                        exc8 = null;
                                        randomAccessFile = randomAccessFile2;
                                        th4 = th21;
                                        httpURLConnection = null;
                                        inputStream = null;
                                    }
                                } catch (Throwable th22) {
                                    th = th22;
                                    exc7 = null;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Exception e13) {
                                            e = e13;
                                            exc3 = e;
                                            Exception exc15 = exc7;
                                            r11 = exc15;
                                            r13 = exc15;
                                            r12 = exc7;
                                            r14 = file;
                                            this._d._a(47);
                                            _g6 _g6Var9 = this._e;
                                            _ds _dsVar11 = this._d;
                                            _g6Var9._a.put(_dsVar11._a, _dsVar11);
                                            _a(this._d, exc3);
                                            exc3.printStackTrace();
                                            com.kc.aw.lib.utils._d._a(_aVar);
                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                            if (r12 != 0) {
                                                r12.close();
                                                if (r13 != 0) {
                                                    r13.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.disconnect();
                                                }
                                            } else {
                                                if (r13 != 0) {
                                                    r13.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.disconnect();
                                                }
                                            }
                                            synchronized (DownloadService._h) {
                                                if (r14 != 0) {
                                                    synchronized (DownloadService._g) {
                                                        list = (List) DownloadService._g.get(r14.getAbsolutePath());
                                                        if (r14.exists()) {
                                                            r14.deleteOnExit();
                                                        }
                                                        if (list != null) {
                                                            while (r2.hasNext()) {
                                                                _dsVar_b = _dVar._b();
                                                                if (_dsVar_b != null) {
                                                                    _dsVar_b._a(this._d._a());
                                                                    _dsVar_b._b(this._d._d());
                                                                    _dsVar_b._c(this._d._c());
                                                                    _dsVar_b._b(this._d._e());
                                                                    _dsVar_b._a(this._d._b());
                                                                    _dVar._a(_dsVar_b, exc3);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                                return;
                                            }
                                        } catch (Throwable th23) {
                                            th = th23;
                                            th3 = th;
                                            Exception exc16 = exc7;
                                            Exception exc17 = exc16;
                                            r17 = exc17;
                                            r10 = exc16;
                                            r5 = exc7;
                                            exc6 = exc17;
                                            r16 = file;
                                            com.kc.aw.lib.utils._d._a(_aVar);
                                            com.kc.aw.lib.utils._d._c(new _b(this));
                                            if (r10 != 0) {
                                                r10.close();
                                                if (r5 != 0) {
                                                    r5.close();
                                                }
                                                if (r17 != 0) {
                                                    r17.disconnect();
                                                }
                                            } else {
                                                if (r5 != 0) {
                                                    r5.close();
                                                }
                                                if (r17 != 0) {
                                                    r17.disconnect();
                                                }
                                            }
                                            synchronized (DownloadService._h) {
                                                if (r16 != 0) {
                                                    synchronized (DownloadService._g) {
                                                        list2 = (List) DownloadService._g.get(r16.getAbsolutePath());
                                                        if (r16.exists()) {
                                                            r16.deleteOnExit();
                                                        }
                                                        if (list2 != null) {
                                                            while (r3.hasNext()) {
                                                                _dsVar_b2 = _dVar4._b();
                                                                if (_dsVar_b2 != null) {
                                                                    _dsVar_b2._a(this._d._a());
                                                                    _dsVar_b2._b(this._d._d());
                                                                    _dsVar_b2._c(this._d._c());
                                                                    _dsVar_b2._b(this._d._e());
                                                                    _dsVar_b2._a(this._d._b());
                                                                    _dVar4._a(_dsVar_b2, exc6);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                                throw th3;
                                            }
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e14) {
                            e = e14;
                            exc7 = null;
                        } catch (Throwable th24) {
                            th = th24;
                            exc7 = null;
                        }
                    } catch (Throwable th25) {
                        th3 = th25;
                        exc5 = null;
                        r9 = 0;
                        r8 = 0;
                        r15 = 0;
                        Exception exc18 = exc5;
                        r5 = r18;
                        r10 = r9;
                        exc6 = exc18;
                        r17 = r8;
                        r16 = r15;
                    }
                } catch (Throwable th26) {
                    exc2 = null;
                    th = th26;
                }
            } catch (Exception e15) {
                e = e15;
                exc = null;
            }
            th2 = th;
            Exception exc19 = exc2;
            Exception exc110 = exc19;
            Exception exc111 = exc110;
            r7 = exc111;
            r3 = exc19;
            r4 = exc110;
            exc4 = exc2;
            r6 = exc111;
            r15 = r3;
            r18 = r4;
            th3 = th2;
            exc5 = exc4;
            r9 = r6;
            r8 = r7;
            Exception exc112 = exc5;
            r5 = r18;
            r10 = r9;
            exc6 = exc112;
            r17 = r8;
            r16 = r15;
            com.kc.aw.lib.utils._d._a(_aVar);
            com.kc.aw.lib.utils._d._c(new _b(this));
            if (r10 != 0) {
                r10.close();
                if (r5 != 0) {
                    r5.close();
                }
                if (r17 != 0) {
                    r17.disconnect();
                }
            } else {
                if (r5 != 0) {
                    r5.close();
                }
                if (r17 != 0) {
                    r17.disconnect();
                }
            }
            synchronized (DownloadService._h) {
                if (r16 != 0) {
                    synchronized (DownloadService._g) {
                        list2 = (List) DownloadService._g.get(r16.getAbsolutePath());
                        if (r16.exists()) {
                            r16.deleteOnExit();
                        }
                        if (list2 != null) {
                            while (r3.hasNext()) {
                                _dsVar_b2 = _dVar4._b();
                                if (_dsVar_b2 != null) {
                                    _dsVar_b2._a(this._d._a());
                                    _dsVar_b2._b(this._d._d());
                                    _dsVar_b2._c(this._d._c());
                                    _dsVar_b2._b(this._d._e());
                                    _dsVar_b2._a(this._d._b());
                                    _dVar4._a(_dsVar_b2, exc6);
                                }
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(this._c._c())) {
                    DownloadService._h.remove(this._c._c());
                }
                throw th3;
            }
        }

        public final void _a(_ds _dsVar, Exception exc) {
            if (this._h != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = _dsVar;
                Bundle bundle = new Bundle();
                messageObtain.setData(bundle);
                if (exc != null) {
                    bundle.putSerializable("error_extra", exc);
                }
                bundle.putInt("download_status_extra", _dsVar._g);
                bundle.putInt("download_progress", _dsVar._f);
                bundle.putLong("download_total_bytes", _dsVar._d);
                bundle.putLong("download_current_bytes", _dsVar._e);
                bundle.putString("download_file_name", _dsVar._b);
                bundle.putString("download_path_extra", _dsVar._c);
                try {
                    this._h.send(messageObtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        public final _ds _b() {
            return this._d;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            _a();
        }
    }

    static {
        int iMax = Math.max(3, Runtime.getRuntime().availableProcessors() / 2);
        _e = iMax;
        _f = iMax * 2;
        _g = new HashMap();
        _h = new HashSet();
        _i = new HashSet();
    }

    public static _d8 _a(DownloadService downloadService, String str, String str2, String str3) throws IOException {
        downloadService.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.connect();
        String string = httpURLConnection.getURL().toString();
        long contentLength = httpURLConnection.getContentLength();
        String str_a = _da._a(str2, str3);
        httpURLConnection.disconnect();
        return new _d8(contentLength, string, str_a);
    }

    public static void _a(DownloadService downloadService, int i) {
        downloadService.getClass();
        NotificationManagerCompat.from(PtgAdSdk.getContext()).cancel(i);
        HashSet hashSet = _i;
        synchronized (hashSet) {
            hashSet.remove(Integer.valueOf(i));
            if (hashSet.size() == 0) {
                downloadService.stopForeground(true);
            }
        }
    }

    public static void _a(DownloadService downloadService, int i, Notification notification) {
        downloadService.getClass();
        NotificationManagerCompat.from(PtgAdSdk.getContext()).notify(i, notification);
        HashSet hashSet = _i;
        synchronized (hashSet) {
            hashSet.add(Integer.valueOf(i));
        }
        downloadService.startForeground(i, notification);
    }

    public static void _a(RequestInfo requestInfo, Exception exc) {
        if (requestInfo == null || requestInfo._e == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = requestInfo._c;
        Bundle bundle = new Bundle();
        messageObtain.setData(bundle);
        bundle.putSerializable("error_extra", exc);
        bundle.putInt("download_progress", 0);
        bundle.putString("download_file_name", requestInfo._f._a);
        bundle.putString("download_path_extra", "");
        bundle.putInt("download_status_extra", 47);
        try {
            requestInfo._e.send(messageObtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void _a(RequestInfo requestInfo, String str) {
        if (requestInfo == null || requestInfo._e == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = requestInfo._c;
        Bundle bundle = new Bundle();
        messageObtain.setData(bundle);
        bundle.putInt("download_progress", 100);
        bundle.putString("download_path_extra", str);
        bundle.putString("download_file_name", requestInfo._f._a);
        bundle.putLong("download_total_bytes", requestInfo._f._e);
        bundle.putInt("download_status_extra", 46);
        try {
            requestInfo._e.send(messageObtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x010b A[Catch: all -> 0x0198, TryCatch #1 {, blocks: (B:3:0x0001, B:4:0x0005, B:8:0x0013, B:10:0x0017, B:12:0x001b, B:14:0x0023, B:15:0x0036, B:17:0x003a, B:19:0x0042, B:21:0x0058, B:24:0x007e, B:30:0x0089, B:32:0x008d, B:34:0x0093, B:36:0x009b, B:37:0x00ad, B:40:0x00b8, B:41:0x00c1, B:43:0x00c5, B:70:0x012d, B:72:0x0131, B:73:0x0133, B:92:0x0190, B:93:0x0191, B:44:0x00de, B:46:0x00e2, B:50:0x00ea, B:55:0x00f3, B:58:0x00f9, B:61:0x0107, B:63:0x010b, B:65:0x0111, B:66:0x011b, B:20:0x0049, B:98:0x0197, B:5:0x0006, B:6:0x0010, B:74:0x0134, B:76:0x013e, B:78:0x0147, B:88:0x018c, B:83:0x0151, B:84:0x0171, B:86:0x017d, B:87:0x0189), top: B:104:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0111 A[Catch: all -> 0x0198, TryCatch #1 {, blocks: (B:3:0x0001, B:4:0x0005, B:8:0x0013, B:10:0x0017, B:12:0x001b, B:14:0x0023, B:15:0x0036, B:17:0x003a, B:19:0x0042, B:21:0x0058, B:24:0x007e, B:30:0x0089, B:32:0x008d, B:34:0x0093, B:36:0x009b, B:37:0x00ad, B:40:0x00b8, B:41:0x00c1, B:43:0x00c5, B:70:0x012d, B:72:0x0131, B:73:0x0133, B:92:0x0190, B:93:0x0191, B:44:0x00de, B:46:0x00e2, B:50:0x00ea, B:55:0x00f3, B:58:0x00f9, B:61:0x0107, B:63:0x010b, B:65:0x0111, B:66:0x011b, B:20:0x0049, B:98:0x0197, B:5:0x0006, B:6:0x0010, B:74:0x0134, B:76:0x013e, B:78:0x0147, B:88:0x018c, B:83:0x0151, B:84:0x0171, B:86:0x017d, B:87:0x0189), top: B:104:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x011b A[Catch: all -> 0x0198, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:4:0x0005, B:8:0x0013, B:10:0x0017, B:12:0x001b, B:14:0x0023, B:15:0x0036, B:17:0x003a, B:19:0x0042, B:21:0x0058, B:24:0x007e, B:30:0x0089, B:32:0x008d, B:34:0x0093, B:36:0x009b, B:37:0x00ad, B:40:0x00b8, B:41:0x00c1, B:43:0x00c5, B:70:0x012d, B:72:0x0131, B:73:0x0133, B:92:0x0190, B:93:0x0191, B:44:0x00de, B:46:0x00e2, B:50:0x00ea, B:55:0x00f3, B:58:0x00f9, B:61:0x0107, B:63:0x010b, B:65:0x0111, B:66:0x011b, B:20:0x0049, B:98:0x0197, B:5:0x0006, B:6:0x0010, B:74:0x0134, B:76:0x013e, B:78:0x0147, B:88:0x018c, B:83:0x0151, B:84:0x0171, B:86:0x017d, B:87:0x0189), top: B:104:0x0001, inners: #0, #2 }] */
    public final void _a(RequestInfo requestInfo) {
        _d8 _d8Var;
        File file;
        int i;
        synchronized (this) {
            _d5 _d5Var = requestInfo._f;
            synchronized (this._d) {
                _d8Var = this._d.get(requestInfo._c);
            }
            if (_d8Var != null) {
                _d5 _d5Var2 = requestInfo._f;
                if (_d5Var2 != null && _d5Var2._c == null && !TextUtils.isEmpty(_d8Var._c)) {
                    requestInfo._f._c = new File(_da._a(getApplicationContext()), _d8Var._c);
                }
                if (requestInfo._f != null && !TextUtils.isEmpty(_d8Var._c)) {
                    requestInfo._f._e = _d8Var._b;
                }
            } else {
                this._a.execute(new _c(this, requestInfo, new _a(this, requestInfo)));
            }
            _d _dVar = this._b.get(_d5Var._b());
            _g6 _g6Var = new _g6();
            _ds _dsVar_b = _g6Var._b(_d5Var._b());
            if (_dVar == null) {
                if (_dsVar_b != null && (i = _dsVar_b._g) != 44 && i != 43 && i == 46) {
                    File file2 = _d5Var._c;
                    if (file2 != null && file2.exists()) {
                        if (!TextUtils.isEmpty(_d5Var._d)) {
                            Intent intent = new Intent();
                            intent.setAction(_d5Var._d);
                            intent.putExtra("download_extra", _dsVar_b);
                            sendBroadcast(intent);
                        }
                        _a(requestInfo, _d5Var._c.getAbsolutePath());
                        return;
                    }
                    _g6Var._a.remove(_d5Var._b());
                }
                if (requestInfo._d == 10) {
                    _d _dVar2 = new _d(this, this, requestInfo._a, requestInfo._e, requestInfo, _d5Var, _g6Var);
                    this._b.put(_d5Var._b(), _dVar2);
                    _dVar = _dVar2;
                }
            } else {
                _ds _dsVar = _dVar._d;
                if ((_dsVar != null ? _dsVar._g : 47) == 46) {
                    file = _d5Var._c;
                    if (file != null) {
                        if (file.exists()) {
                            _a(requestInfo, _d5Var._c.getAbsolutePath());
                        } else {
                            _dVar._f = true;
                            this._b.remove(_d5Var._b());
                            _a(requestInfo);
                        }
                        return;
                    }
                } else {
                    if ((_dsVar != null ? _dsVar._g : 47) == 44) {
                        file = _d5Var._c;
                        if (file != null) {
                            if (file.exists()) {
                                _a(requestInfo, _d5Var._c.getAbsolutePath());
                            } else {
                                _dVar._f = true;
                                this._b.remove(_d5Var._b());
                                _a(requestInfo);
                            }
                            return;
                        }
                    } else {
                        if ((_dsVar != null ? _dsVar._g : 47) == 47) {
                            this._b.remove(_d5Var._b());
                            _a(requestInfo);
                            return;
                        }
                    }
                }
            }
            if (_dVar != null) {
                if (requestInfo._d == 10) {
                    synchronized (this._d) {
                        if (this._d.containsKey(requestInfo._c)) {
                            _b _bVar = this._a;
                            _bVar.getClass();
                            _ds _dsVar2 = _dVar._d;
                            int i2 = _dsVar2 != null ? _dsVar2._g : 47;
                            if (i2 == 45 || i2 == 47) {
                                _dsVar2._g = 42;
                                Intent intent2 = new Intent();
                                intent2.setAction(_dVar._c._d);
                                intent2.putExtra("download_extra", _dVar._d);
                                _dVar._b.sendBroadcast(intent2);
                                _bVar.execute(_dVar);
                            }
                        } else {
                            List<_d> arrayList = this._c.get(requestInfo._c);
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                                this._c.put(requestInfo._c, arrayList);
                            }
                            arrayList.add(_dVar);
                        }
                    }
                } else {
                    _dVar._f = true;
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        _d _dVar;
        if (intent != null) {
            String action = intent.getAction();
            if (action == null || TextUtils.isEmpty(action) || !action.endsWith(".ptg.action.download.cancel")) {
                synchronized (this) {
                    if (intent.hasExtra("service_intent_extra")) {
                        ArrayList<RequestInfo> parcelableArrayListExtra = null;
                        try {
                            parcelableArrayListExtra = intent.getParcelableArrayListExtra("service_intent_extra");
                            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                                for (RequestInfo requestInfo : parcelableArrayListExtra) {
                                    try {
                                        _a(requestInfo);
                                    } catch (Exception e) {
                                        _a(requestInfo, e);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (parcelableArrayListExtra != null) {
                                for (RequestInfo requestInfo2 : parcelableArrayListExtra) {
                                    if (requestInfo2 != null) {
                                        _a(requestInfo2, e2);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                _d5 _d5Var = (_d5) intent.getSerializableExtra("download_extra");
                if (_d5Var != null && (_dVar = this._b.get(_d5Var._b())) != null) {
                    _dVar._f = true;
                    this._b.remove(_d5Var._b());
                    RequestInfo requestInfo3 = _dVar._i;
                    requestInfo3._d = 11;
                    _a(requestInfo3);
                    if (requestInfo3._e != null) {
                        Message messageObtain = Message.obtain();
                        messageObtain.obj = requestInfo3._c;
                        Bundle bundle = new Bundle();
                        messageObtain.setData(bundle);
                        bundle.putInt("download_progress", 0);
                        bundle.putInt("download_status_extra", 48);
                        try {
                            requestInfo3._e.send(messageObtain);
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
