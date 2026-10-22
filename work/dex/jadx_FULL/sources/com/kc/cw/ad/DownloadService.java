package com.kc.cw.ad;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.c.n;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class DownloadService extends Service {
    private static com.kc.cw.ad.internal.c.c.a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f38645a;
    private String b;
    private DownloadManager c;
    private a d;
    private b e;
    private HashMap<String, com.kc.cw.ad.d.b> g;
    private HashMap<String, Boolean> h;
    private HashMap<Long, String> i;

    @Keep
    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DownloadService f38647a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DownloadService downloadService, Handler handler) {
            super(handler);
            this.f38647a = downloadService;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursorQuery = null;
            try {
                cursorQuery = this.f38647a.c.query(new DownloadManager.Query().setFilterById(this.f38647a.f38645a));
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    f.a(com.google.android.exoplayer2.offline.DownloadService.u, "onChange status：" + i);
                    if (i == 1) {
                        this.f38647a.b(com.kc.cw.ad.d.c.a(this.f38647a).a());
                    }
                    iArr[0] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                    iArr[1] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                    iArr[2] = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    f.a(com.google.android.exoplayer2.offline.DownloadService.u, "progress：" + iArr[0] + WVNativeCallbackUtil.SEPERATER + iArr[1]);
                }
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    @Keep
    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DownloadService f38648a;

        private b(DownloadService downloadService) {
            this.f38648a = downloadService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor cursorQuery = downloadManager.query(query);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        DownloadService downloadService = this.f38648a;
                        downloadService.a(Long.valueOf(downloadService.f38645a));
                    } else if (cursorQuery.getInt(cursorQuery.getColumnIndex("status")) == 8) {
                        this.f38648a.a(context, longExtra);
                    }
                }
            } catch (Throwable th) {
                f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }

    private void a() {
        try {
            getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.d);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            registerReceiver(this.e, intentFilter, 2);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "onReceived...download finish...begin install！");
        HashMap<Long, String> map = this.i;
        if (map == null || this.g == null) {
            return;
        }
        String str = map.get(Long.valueOf(j));
        HashMap<String, Boolean> map2 = this.h;
        if (map2 != null) {
            map2.put(str, Boolean.FALSE);
        }
        com.kc.cw.ad.d.b bVar = this.g.get(str);
        if (bVar != null) {
            if (bVar.h() != null) {
                n.a(bVar.h().b());
            }
            a(context, Long.valueOf(j), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Long l, com.kc.cw.ad.d.b bVar) {
        try {
            com.kc.cw.ad.d.c.a(context).b(false);
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            Uri uriForFile = FileProvider.getUriForFile(context, this.b, new File(bVar.d(), bVar.b()));
            intent.addFlags(3);
            if (uriForFile != null) {
                f.a(com.google.android.exoplayer2.offline.DownloadService.u, "uri......" + uriForFile);
                intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                c(bVar);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void a(com.kc.cw.ad.d.b bVar) {
        String str;
        String str2;
        synchronized (this) {
            HashMap<String, Boolean> map = this.h;
            if (map != null && map.get(bVar.c()) != null && Boolean.TRUE.equals(this.h.get(bVar.c()))) {
                f.a(com.google.android.exoplayer2.offline.DownloadService.u, "downloading..." + bVar.c() + "...please not repeat click");
                Toast.makeText(getApplicationContext(), "正在下载…请勿重复点击", 0).show();
                return;
            }
            File file = new File(bVar.d(), bVar.b());
            if (file.exists()) {
                try {
                    com.kc.cw.ad.d.c.a(this).b(false);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    Uri uriForFile = FileProvider.getUriForFile(this, bVar.g(), file);
                    intent.addFlags(3);
                    if (uriForFile != null) {
                        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "uri......" + uriForFile);
                        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                        startActivity(intent);
                        c(bVar);
                    }
                } catch (Exception e) {
                    e = e;
                    str = "OctopusAd";
                    str2 = "An Exception Caught";
                    f.a(str, str2, e);
                }
            } else {
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(bVar.a()));
                    request.setTitle(bVar.e());
                    request.setDescription(bVar.f());
                    request.setNotificationVisibility(1);
                    request.setDestinationUri(Uri.fromFile(file));
                    request.setMimeType(AdBaseConstants.MIME_APK);
                    this.f38645a = this.c.enqueue(request);
                    f.b(com.google.android.exoplayer2.offline.DownloadService.u, "mReqId:" + this.f38645a);
                    HashMap<Long, String> map2 = this.i;
                    if (map2 != null) {
                        map2.put(Long.valueOf(this.f38645a), bVar.c());
                    }
                    HashMap<String, Boolean> map3 = this.h;
                    if (map3 != null) {
                        map3.put(bVar.c(), Boolean.TRUE);
                    }
                    Toast.makeText(getApplicationContext(), "已开始下载…", 0).show();
                    f.a(com.google.android.exoplayer2.offline.DownloadService.u, "BEGIN_DOWNLOAD!");
                    if (bVar.h() != null) {
                        n.a(bVar.h().a());
                    }
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                    try {
                        if (!TextUtils.isEmpty(bVar.a()) && bVar.a().contains("http")) {
                            HashMap<String, Boolean> map4 = this.h;
                            if (map4 != null) {
                                map4.put(bVar.c(), Boolean.TRUE);
                            }
                            Intent intent2 = new Intent();
                            intent2.setAction("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(bVar.a()));
                            intent2.setFlags(268435456);
                            startActivity(intent2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = "OctopusAd";
                        str2 = "An Exception Caught";
                        f.a(str, str2, e);
                    }
                }
            }
        }
    }

    private static File b(Context context, long j) {
        Cursor cursorQuery;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j != -1) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j);
            query.setFilterByStatus(8);
            if (downloadManager != null && (cursorQuery = downloadManager.query(query)) != null) {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null) {
                        file = new File(path);
                    }
                }
                cursorQuery.close();
            }
        }
        return file;
    }

    private void b() {
        if (this.d != null) {
            getContentResolver().unregisterContentObserver(this.d);
            this.d = null;
            f.a(com.google.android.exoplayer2.offline.DownloadService.u, "unregisterContentObserver()");
        }
        b bVar = this.e;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.e = null;
            f.a(com.google.android.exoplayer2.offline.DownloadService.u, "unregisterReceiver()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.kc.cw.ad.d.b bVar) {
        if (bVar == null) {
            return;
        }
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "--appUpdate downloadApk start--");
        com.kc.cw.ad.internal.c.c.a aVarA = com.kc.cw.ad.internal.c.c.a();
        f = aVarA;
        aVarA.a(new com.kc.cw.ad.internal.c.c.b(this, bVar) { // from class: com.kc.cw.ad.DownloadService.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final com.kc.cw.ad.d.b f38646a;
            final DownloadService b;

            {
                this.b = this;
                this.f38646a = bVar;
            }

            @Override // com.kc.cw.ad.internal.c.c.b
            public void a(int i) {
                f.a(com.google.android.exoplayer2.offline.DownloadService.u, "--appUpdate downloadApk onFail--");
                try {
                    String strA = this.f38646a.a();
                    if (TextUtils.isEmpty(strA) || !strA.contains("http")) {
                        return;
                    }
                    if (this.b.h != null) {
                        this.b.h.put(this.f38646a.c(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strA));
                    intent.setFlags(268435456);
                    this.b.startActivity(intent);
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }

            @Override // com.kc.cw.ad.internal.c.c.b
            public void a(long j, long j2) {
            }

            @Override // com.kc.cw.ad.internal.c.c.b
            public boolean a(File file) {
                return true;
            }

            @Override // com.kc.cw.ad.internal.c.c.b
            public void b(File file) {
                f.a(com.google.android.exoplayer2.offline.DownloadService.u, "--appUpdate downloadApk onSuccess--");
                if (this.b.h != null) {
                    this.b.h.put(this.f38646a.c(), Boolean.FALSE);
                }
                this.b.a(this.b.getApplicationContext(), (Long) (-1L), this.f38646a);
            }
        });
        f.a(new com.kc.cw.ad.internal.c.c.d(bVar.a(), bVar.d(), bVar.b()));
    }

    private void c() {
        String strG;
        com.kc.cw.ad.d.b bVarA = com.kc.cw.ad.d.c.a(this).a();
        if (bVarA == null) {
            return;
        }
        HashMap<String, com.kc.cw.ad.d.b> map = this.g;
        if (map != null) {
            map.put(bVarA.c(), bVarA);
        }
        HashMap<String, Boolean> map2 = this.h;
        if (map2 != null && map2.get(bVarA.c()) == null) {
            f.a(com.google.android.exoplayer2.offline.DownloadService.u, "not have package status...");
            this.h.put(bVarA.c(), Boolean.FALSE);
        }
        if (SSAd.getCustomController() != null && !TextUtils.isEmpty(SSAd.getCustomController().getAuthorities())) {
            strG = SSAd.getCustomController().getAuthorities();
        } else if (TextUtils.isEmpty(bVarA.g())) {
            strG = getPackageName() + ".ssad.provider";
        } else {
            strG = bVarA.g();
        }
        this.b = strG;
        bVarA.a(this.b);
        com.kc.cw.ad.d.b.c.a(bVarA.d());
        a(bVarA);
    }

    private void c(com.kc.cw.ad.d.b bVar) {
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "BEGIN_INSTALL!");
        if (bVar.h() != null) {
            n.a(bVar.h().c());
        }
    }

    private void d() {
        com.kc.cw.ad.internal.c.c.a aVar = f;
        if (aVar != null) {
            aVar.a();
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        com.kc.cw.ad.d.c.a(this).f();
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "releaseResources()");
    }

    public void a(Long l) {
        try {
            HashMap<Long, String> map = this.i;
            if (map != null) {
                String str = map.get(l);
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, Boolean> map2 = this.h;
                    if (map2 != null) {
                        map2.put(str, Boolean.FALSE);
                    }
                    HashMap<String, com.kc.cw.ad.d.b> map3 = this.g;
                    if (map3 != null) {
                        map3.remove(str);
                    }
                }
            }
            DownloadManager downloadManager = this.c;
            if (downloadManager == null || l == null) {
                return;
            }
            downloadManager.remove(l.longValue());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "DownloadService onCreate()");
        this.c = (DownloadManager) getSystemService("download");
        this.d = new a(this, new Handler());
        this.e = new b();
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "DownloadService onDestroy()");
        b();
        d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 1;
        }
        f.a(com.google.android.exoplayer2.offline.DownloadService.u, "DownloadService onStartCommand()");
        c();
        return super.onStartCommand(intent, i, i2);
    }
}
