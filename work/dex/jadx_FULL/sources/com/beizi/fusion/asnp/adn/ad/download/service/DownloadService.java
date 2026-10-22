package com.beizi.fusion.asnp.adn.ad.download.service;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.beizi.fusion.d8;
import com.beizi.fusion.j0;
import com.beizi.fusion.no;
import com.beizi.fusion.qh;
import com.beizi.fusion.t9;
import com.beizi.fusion.wf;
import com.beizi.fusion.x9;
import com.byazt.tk.AdBaseConstants;
import com.fl.saas.base.cache.DatabaseHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DownloadService extends Service implements com.beizi.fusion.asnp.adn.ad.download.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f27062a;
    private d b;
    private c c;
    private Map d;
    private Map e;

    public class a implements com.beizi.fusion.asnp.adn.ad.download.service.a.b {
        public a() {
        }

        @Override // com.beizi.fusion.asnp.adn.ad.download.service.a.b
        public void a(com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a) {
            DownloadService.this.a(c0298a, x9.a.DOWNLOAD_CONTINUE);
        }

        @Override // com.beizi.fusion.asnp.adn.ad.download.service.a.b
        public void b(com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a) {
            DownloadService.this.a(c0298a, x9.a.DOWNLOAD_FAILED);
        }

        @Override // com.beizi.fusion.asnp.adn.ad.download.service.a.b
        public void c(com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a) {
            DownloadService.this.a(c0298a, x9.a.DOWNLOAD_PAUSE);
        }
    }

    public class b extends Binder {
        public b() {
        }

        public com.beizi.fusion.asnp.adn.ad.download.service.a a() {
            return DownloadService.this;
        }
    }

    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        private long[] a(Map map) {
            if (map == null || map.isEmpty()) {
                return null;
            }
            Set setKeySet = map.keySet();
            long[] jArr = new long[setKeySet.size()];
            Iterator it = setKeySet.iterator();
            int i = 0;
            while (it.hasNext()) {
                jArr[i] = ((Long) it.next()).longValue();
                i++;
            }
            return jArr;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a;
            super.onChange(z);
            DownloadManager downloadManager = (DownloadManager) DownloadService.this.getApplicationContext().getSystemService("download");
            Cursor cursorQuery = null;
            try {
                long[] jArrA = a(DownloadService.this.e);
                if (jArrA != null && jArrA.length > 0) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(jArrA);
                    cursorQuery = downloadManager.query(query);
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("status"));
                        Map map = DownloadService.this.e;
                        if (map != null && map.containsKey(Long.valueOf(j)) && (c0298a = (com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a) DownloadService.this.e.get(Long.valueOf(j))) != null) {
                            c0298a.a(i);
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (IllegalArgumentException unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }

    public static class e extends Handler {
        private e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        Object[] objArr = 0;
        this.b = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        if (Build.VERSION.SDK_INT > 32) {
            getApplicationContext().registerReceiver(this.b, intentFilter, 2);
        } else {
            getApplicationContext().registerReceiver(this.b, intentFilter);
        }
        this.c = new c(new e(getMainLooper()));
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        if (contentResolver != null) {
            contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.c);
        }
    }

    private void b() {
        ContentResolver contentResolver;
        if (this.b != null) {
            getApplicationContext().unregisterReceiver(this.b);
        }
        if (this.c == null || (contentResolver = getApplicationContext().getContentResolver()) == null) {
            return;
        }
        contentResolver.unregisterContentObserver(this.c);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f27062a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f27062a = new b();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public class d extends BroadcastReceiver {
        private d() {
        }

        private boolean a(Context context, Uri uri) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(uri, AdBaseConstants.MIME_APK);
            return wf.c(context, intent);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298aA;
            Uri uriA;
            if (intent != null) {
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (longExtra <= 0 || (uriA = a(context, longExtra, (c0298aA = a(longExtra)))) == null) {
                    return;
                }
                DownloadService.this.a(c0298aA, x9.a.DOWNLOAD_COMPLETE);
                if (a(context, uriA)) {
                    DownloadService.this.a(c0298aA, x9.a.INSTALL_START);
                }
            }
        }

        private com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a a(long j) {
            Map map = DownloadService.this.e;
            if (map == null || !map.containsKey(Long.valueOf(j))) {
                return null;
            }
            return (com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a) DownloadService.this.e.get(Long.valueOf(j));
        }

        private Uri a(Context context, long j, com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a) {
            if (c0298a == null) {
                return null;
            }
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), no.b(c0298a.b()));
            String strA = c0298a.a();
            if (!file.exists() || !a(file, strA)) {
                return null;
            }
            try {
                return FileProvider.getUriForFile(context, String.format("%s.bz.fileprovider", context.getPackageName()), file);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private boolean a(File file, String str) {
            if (file != null) {
                return TextUtils.isEmpty(str) || str.equalsIgnoreCase(d8.a(file));
            }
            return false;
        }

        private Uri a(DownloadManager downloadManager, long j) {
            int columnIndexOrThrow;
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j);
            query.setFilterByStatus(8);
            try {
                Cursor cursorQuery = downloadManager.query(query);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst() && (columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("local_uri")) >= 0) {
                            String string = cursorQuery.getString(columnIndexOrThrow);
                            if (!TextUtils.isEmpty(string)) {
                                Uri uri = Uri.parse(string);
                                cursorQuery.close();
                                return uri;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (cursorQuery == null) {
                    return null;
                }
                cursorQuery.close();
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.download.service.a
    public void a(com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a) {
        if (c0298a == null || a(c0298a.b())) {
            return;
        }
        c0298a.a(new a());
        long jA = a(c0298a.b(), c0298a.c());
        if (jA > 0) {
            a(c0298a, x9.a.DOWNLOAD_START);
            c0298a.a(jA);
            this.d.put(qh.a(c0298a.b()), Long.valueOf(jA));
            this.e.put(Long.valueOf(jA), c0298a);
        }
    }

    private boolean a(String str) {
        Long l;
        String strA = qh.a(str);
        return this.d.containsKey(strA) && (l = (Long) this.d.get(strA)) != null && l.longValue() > 0;
    }

    private long a(String str, String str2) {
        DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService("download");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        if (TextUtils.isEmpty(str2)) {
            str2 = no.b(str);
        }
        request.setTitle(str2);
        request.setVisibleInDownloadsUi(true);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, no.b(str));
        return downloadManager.enqueue(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a c0298a, x9.a aVar) {
        if (c0298a != null) {
            ((t9) j0.a().b(getApplicationContext())).a(aVar, c0298a.d(), c0298a.e());
        }
    }
}
