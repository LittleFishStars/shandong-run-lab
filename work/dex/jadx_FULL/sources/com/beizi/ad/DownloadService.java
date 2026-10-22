package com.beizi.ad;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.a8;
import com.beizi.fusion.bm;
import com.beizi.fusion.e8;
import com.beizi.fusion.fh;
import com.beizi.fusion.g7;
import com.beizi.fusion.kh;
import com.byazt.tk.AdBaseConstants;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class DownloadService extends Service {
    private static g7.a j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f26854a;
    private String b;
    private DownloadManager c;
    private b d;
    private c e;
    private HashMap f;
    private HashMap g;
    private HashMap h;
    private ApkBean i;

    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursorQuery = null;
            try {
                cursorQuery = DownloadService.this.c.query(new DownloadManager.Query().setFilterById(DownloadService.this.f26854a));
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "onChange status：" + i);
                    if (i == 1) {
                        DownloadService downloadService = DownloadService.this;
                        downloadService.b(downloadService.i);
                    }
                    iArr[0] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                    iArr[1] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                    iArr[2] = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "progress：" + iArr[0] + WVNativeCallbackUtil.SEPERATER + iArr[1] + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "onReceived...download finish...begin install！");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                DownloadService downloadService = DownloadService.this;
                HashMap map = downloadService.h;
                if (map != null && downloadService.f != null) {
                    String str = (String) map.get(Long.valueOf(longExtra));
                    HashMap map2 = DownloadService.this.g;
                    if (map2 != null) {
                        map2.put(str, Boolean.FALSE);
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.f.get(str);
                    if (apkBean != null) {
                        if (apkBean.getmFollowTrackExt() != null) {
                            bm.a(apkBean.getmFollowTrackExt().e());
                        }
                        if (context.getPackageManager().canRequestPackageInstalls()) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        } else {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a() {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.d);
        if (Build.VERSION.SDK_INT >= 31) {
            registerReceiver(this.e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
        } else {
            registerReceiver(this.e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    private void a(String str) {
    }

    private void b() {
        g7.a aVar = j;
        if (aVar != null) {
            aVar.destroy();
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "releaseResources()");
    }

    private void c() {
        getContentResolver().unregisterContentObserver(this.d);
        unregisterReceiver(this.e);
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "unregister()");
    }

    private void d(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "BEGIN_INSTALL!");
        if (apkBean.getmFollowTrackExt() != null) {
            bm.a(apkBean.getmFollowTrackExt().b());
        }
        if (!TextUtils.isEmpty(apkBean.getPkgName()) && apkBean.isSendLocalBroadcast()) {
            a(apkBean.getPkgName());
        }
    }

    private void e(ApkBean apkBean) {
        try {
            if (!TextUtils.isEmpty(apkBean.getPkgName()) && apkBean.isSendLocalBroadcast()) {
                fh fhVarA = fh.a(this);
                Intent intent = new Intent("com.beizi.fusion.download.receiver");
                intent.putExtra("pkName", apkBean.getPkgName());
                fhVarA.a(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "DownloadService onCreate()");
        this.c = (DownloadManager) getSystemService("download");
        this.d = new b(new Handler());
        this.e = new c();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "DownloadService onDestroy()");
        c();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundleExtra;
        if (intent == null) {
            return 2;
        }
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "DownloadService onStartCommand()");
        try {
            if (intent.getExtras() != null && (bundleExtra = intent.getBundleExtra("data")) != null && bundleExtra.containsKey("apkBean")) {
                this.i = (ApkBean) bundleExtra.getSerializable("apkBean");
            }
            c(this.i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2;
    }

    private void c(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        HashMap map = this.f;
        if (map != null) {
            map.put(apkBean.getPkgName(), apkBean);
        }
        HashMap map2 = this.g;
        if (map2 != null && map2.get(apkBean.getPkgName()) == null) {
            kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "not have package status...");
            this.g.put(apkBean.getPkgName(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(apkBean.getAuthorities())) {
            this.b = getPackageName() + ".bz.fileprovider";
        } else {
            this.b = apkBean.getAuthorities();
        }
        a8.a(apkBean.getDownloadPath());
        a(apkBean);
    }

    public class a implements g7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ApkBean f26855a;

        public a(ApkBean apkBean) {
            this.f26855a = apkBean;
        }

        @Override // com.beizi.fusion.g7.b
        public void a(long j, long j2) {
        }

        @Override // com.beizi.fusion.g7.b
        public void a(File file) {
            kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "--appUpdate downloadApk onSuccess--");
            HashMap map = DownloadService.this.g;
            if (map != null) {
                map.put(this.f26855a.getPkgName(), Boolean.FALSE);
            }
            DownloadService.this.a(DownloadService.this.getApplicationContext(), -1L, this.f26855a);
        }

        @Override // com.beizi.fusion.g7.b
        public boolean b(File file) {
            return true;
        }

        @Override // com.beizi.fusion.g7.b
        public void a(int i) {
            kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "--appUpdate downloadApk onFail--");
            try {
                String apkUrl = this.f26855a.getApkUrl();
                if (TextUtils.isEmpty(apkUrl) || !apkUrl.contains("http")) {
                    return;
                }
                HashMap map = DownloadService.this.g;
                if (map != null) {
                    map.put(this.f26855a.getPkgName(), Boolean.TRUE);
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(apkUrl));
                intent.setFlags(268435456);
                DownloadService.this.startActivity(intent);
            } catch (Exception e) {
                kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "skip browser fail:" + e);
            }
        }
    }

    private synchronized void a(ApkBean apkBean) {
        e(apkBean);
        HashMap map = this.g;
        if (map != null && map.get(apkBean.getPkgName()) != null && ((Boolean) this.g.get(apkBean.getPkgName())).booleanValue()) {
            kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "downloading..." + apkBean.getPkgName() + "...please not repeat click");
            return;
        }
        File file = new File(apkBean.getDownloadPath(), apkBean.getPkgName() + ".zip");
        if (file.exists()) {
            file.delete();
            kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "apkCacheFile......remove:" + file.exists());
        }
        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
        if (file2.exists()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                Uri uriForFile = FileProvider.getUriForFile(this, apkBean.getAuthorities(), file2);
                intent.addFlags(3);
                if (uriForFile != null) {
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                    startActivity(intent);
                    d(apkBean);
                    return;
                }
            } catch (Exception e) {
                Log.d("lance", "apkFile.exists():" + e);
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkBean.getApkUrl()));
            request.setTitle(apkBean.getApkTittleName());
            request.setDescription(apkBean.getApkDesc());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType(AdBaseConstants.MIME_APK);
            this.f26854a = this.c.enqueue(request);
            kh.d(com.google.android.exoplayer2.offline.DownloadService.u, "mReqId:" + this.f26854a);
            HashMap map2 = this.h;
            if (map2 != null) {
                map2.put(Long.valueOf(this.f26854a), apkBean.getPkgName());
            }
            HashMap map3 = this.g;
            if (map3 != null) {
                map3.put(apkBean.getPkgName(), Boolean.TRUE);
            }
            Toast.makeText(this, "已开始下载…", 0).show();
            kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "BEGIN_DOWNLOAD!");
            if (apkBean.getmFollowTrackExt() != null) {
                bm.a(apkBean.getmFollowTrackExt().a());
            }
        } catch (Exception e2) {
            Log.d("lance", "DownloadManager download fail:" + e2);
            try {
                if (!TextUtils.isEmpty(apkBean.getApkUrl()) && apkBean.getApkUrl().contains("http")) {
                    HashMap map4 = this.g;
                    if (map4 != null) {
                        map4.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(apkBean.getApkUrl()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                }
            } catch (Exception e3) {
                Log.d("lance", "skip browser fail:" + e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "--appUpdate downloadApk start--");
        g7.a aVarA = g7.a();
        j = aVarA;
        aVarA.a(new a(apkBean));
        j.a(new g7.d(apkBean.getApkUrl(), apkBean.getDownloadPath(), apkBean.getApkName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Long l, ApkBean apkBean) {
        try {
            File file = new File(apkBean.getDownloadPath(), apkBean.getPkgName() + ".zip");
            if (file.exists()) {
                String fileMD5 = apkBean.getFileMD5();
                String strA = e8.a(file.getAbsolutePath());
                if (TextUtils.isEmpty(fileMD5) || fileMD5.equals(strA)) {
                    if (file.exists()) {
                        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                        file.renameTo(file2);
                        kh.a(com.google.android.exoplayer2.offline.DownloadService.u, "apkFile......raName:" + file2.exists());
                    }
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    Uri uriForFile = FileProvider.getUriForFile(context, this.b, new File(apkBean.getDownloadPath(), apkBean.getApkName()));
                    intent.addFlags(3);
                    if (uriForFile != null) {
                        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                        context.startActivity(intent);
                        d(apkBean);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File a(Context context, long j2) {
        Cursor cursorQuery;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j2 != -1) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j2);
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
}
