package com.kc.cw.ad.internal.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.d.b.i;
import com.kc.cw.ad.internal.c.c;
import com.kc.cw.ad.internal.c.n;
import com.kc.cw.ad.internal.utilities.ImageManager;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.model.ComplianceInfo;
import com.kc.cw.ad.utils.ThreadUtils;
import com.kc.cw.ad.widget.FlickerProgressBar;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38846a = "DownloadDialogActivity";
    private static c.a h;
    private long b;
    private String c;
    private DownloadManager d;
    private a e;
    private b f;
    private FlickerProgressBar g;
    private HashMap<String, com.kc.cw.ad.d.b> i;
    private HashMap<String, Boolean> j;
    private HashMap<Long, String> k;
    private com.kc.cw.ad.d.c l;
    private ComplianceInfo m;
    private boolean n;

    @Keep
    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DownloadDialogActivity f38855a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DownloadDialogActivity downloadDialogActivity, Handler handler) {
            super(handler);
            this.f38855a = downloadDialogActivity;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursorQuery = null;
            try {
                cursorQuery = this.f38855a.d.query(new DownloadManager.Query().setFilterById(this.f38855a.b));
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    iArr[0] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                    iArr[1] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                    iArr[2] = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    f.a(DownloadDialogActivity.f38846a, "progress：" + iArr[0] + WVNativeCallbackUtil.SEPERATER + iArr[1]);
                    if (iArr[1] > 0) {
                        DecimalFormat decimalFormat = new DecimalFormat("#.#");
                        decimalFormat.setRoundingMode(RoundingMode.DOWN);
                        this.f38855a.g.setProgress(Float.parseFloat(decimalFormat.format((iArr[0] * 100.0f) / iArr[1])));
                    }
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    f.a(DownloadDialogActivity.f38846a, "onChange status：" + i);
                    this.f38855a.g.setStatus(i);
                    if (1 == i) {
                        this.f38855a.c(com.kc.cw.ad.d.c.a(this.f38855a).a());
                    }
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
        final DownloadDialogActivity f38856a;

        private b(DownloadDialogActivity downloadDialogActivity) {
            this.f38856a = downloadDialogActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                f.c(DownloadDialogActivity.f38846a, "action：" + action);
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor cursorQuery = downloadManager.query(query);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        DownloadDialogActivity downloadDialogActivity = this.f38856a;
                        downloadDialogActivity.a(Long.valueOf(downloadDialogActivity.b));
                    } else if (cursorQuery.getInt(cursorQuery.getColumnIndex("status")) == 8) {
                        this.f38856a.a(context, longExtra);
                    }
                } else if ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(intent.getAction())) {
                    f.a(DownloadDialogActivity.f38846a, "NOTIFICATION_CLICKED");
                }
            } catch (Throwable th) {
                f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        f.a(f38846a, "onReceived...download finish...begin install！");
        HashMap<Long, String> map = this.k;
        if (map == null || this.i == null) {
            return;
        }
        String str = map.get(Long.valueOf(j));
        HashMap<String, Boolean> map2 = this.j;
        if (map2 != null) {
            map2.put(str, Boolean.FALSE);
        }
        com.kc.cw.ad.d.b bVar = this.i.get(str);
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
            Uri uriForFile = FileProvider.getUriForFile(context, this.c, new File(bVar.d(), bVar.b()));
            intent.addFlags(3);
            if (uriForFile != null) {
                f.a(f38846a, "uri......" + uriForFile);
                intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                b(bVar);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kc.cw.ad.d.b bVar) {
        String str;
        StringBuilder sb;
        String str2;
        HashMap<String, Boolean> map = this.j;
        if (map != null && map.get(bVar.c()) != null && Boolean.TRUE.equals(this.j.get(bVar.c()))) {
            f.a(f38846a, "downloading..." + bVar.c() + "...please not repeat click");
            a("正在下载…请勿重复点击");
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
                    f.a(f38846a, "uri......" + uriForFile);
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                    startActivity(intent);
                    b(bVar);
                    return;
                }
                return;
            } catch (Exception e) {
                e = e;
                str = f38846a;
                sb = new StringBuilder();
                str2 = "apkFile.exists():";
            }
        } else {
            try {
                if (this.n) {
                    a(Long.valueOf(this.b));
                    this.g.b();
                    this.n = false;
                    a("已取消下载");
                    return;
                }
                this.n = true;
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(bVar.a()));
                request.setTitle(bVar.e());
                request.setDescription(bVar.f());
                request.setNotificationVisibility(1);
                request.setDestinationUri(Uri.fromFile(file));
                request.setMimeType(AdBaseConstants.MIME_APK);
                this.b = this.d.enqueue(request);
                String str3 = f38846a;
                f.b(str3, "mReqId:" + this.b);
                HashMap<Long, String> map2 = this.k;
                if (map2 != null) {
                    map2.put(Long.valueOf(this.b), bVar.c());
                }
                HashMap<String, Boolean> map3 = this.j;
                if (map3 != null) {
                    map3.put(bVar.c(), Boolean.TRUE);
                }
                a("已开始下载…");
                f.a(str3, "BEGIN_DOWNLOAD!");
                if (bVar.h() != null) {
                    n.a(bVar.h().a());
                    return;
                }
                return;
            } catch (Exception e2) {
                f.a(f38846a, "DownloadManager download fail:" + e2);
                try {
                    if (TextUtils.isEmpty(bVar.a()) || !bVar.a().contains("http")) {
                        return;
                    }
                    HashMap<String, Boolean> map4 = this.j;
                    if (map4 != null) {
                        map4.put(bVar.c(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(bVar.a()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                    return;
                } catch (Exception e3) {
                    e = e3;
                    str = f38846a;
                    sb = new StringBuilder();
                    str2 = "skip browser fail:";
                }
            }
        }
        sb.append(str2);
        sb.append(e);
        f.c(str, sb.toString());
    }

    private void a(String str) {
        ThreadUtils.runOnUIThread(new Runnable(this, str) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.7

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f38853a;
            final DownloadDialogActivity b;

            {
                this.b = this;
                this.f38853a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(this.b.getApplicationContext(), this.f38853a, 0).show();
            }
        });
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
        try {
            if (this.l != null && this.m != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.SSAdAlertDialogStyle);
                View viewInflate = LayoutInflater.from(this).inflate(R.layout.ss_dialog_download, (ViewGroup) null);
                builder.setView(viewInflate);
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.setCanceledOnTouchOutside(false);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_app_icon);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_app_name);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_app_version);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_app_developer);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_app_permission);
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_app_privacy);
                TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_app_function);
                this.g = (FlickerProgressBar) viewInflate.findViewById(R.id.btn_download);
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_close);
                ImageManager.with(null).load(this.m.getAppIconURL()).into(imageView);
                textView.setText(this.m.getAppName());
                textView2.setText(String.format("版本号：%s", this.m.getAppVersion()));
                textView3.setText(String.format("开发者：%s", this.m.getDeveloperName()));
                com.kc.cw.ad.d.b bVarA = com.kc.cw.ad.d.c.a(this).a();
                if (bVarA != null && new File(bVarA.d(), bVarA.b()).exists()) {
                    this.g.setProgress(100.0f);
                    this.g.setStatus(8);
                }
                textView4.setPaintFlags(textView4.getPaintFlags() | 8);
                textView5.setPaintFlags(textView5.getPaintFlags() | 8);
                textView6.setPaintFlags(textView6.getPaintFlags() | 8);
                textView4.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final DownloadDialogActivity f38847a;

                    {
                        this.f38847a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (this.f38847a.m != null) {
                            ViewUtil.openLocalBrowser(this.f38847a.m.getPermissionsUrl(), 0);
                        }
                    }
                });
                textView5.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.2

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final DownloadDialogActivity f38848a;

                    {
                        this.f38848a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (this.f38848a.m != null) {
                            ViewUtil.openLocalBrowser(this.f38848a.m.getPrivacyUrl(), 0);
                        }
                    }
                });
                textView6.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.3

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final DownloadDialogActivity f38849a;

                    {
                        this.f38849a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (this.f38849a.m != null) {
                            ViewUtil.openLocalBrowser(this.f38849a.m.getFunctionDescUrl(), 0);
                        }
                    }
                });
                this.g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.4

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final DownloadDialogActivity f38850a;

                    {
                        this.f38850a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f38850a.c();
                    }
                });
                imageView2.setOnClickListener(new View.OnClickListener(this, alertDialogCreate) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.5

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final AlertDialog f38851a;
                    final DownloadDialogActivity b;

                    {
                        this.b = this;
                        this.f38851a = alertDialogCreate;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f38851a.cancel();
                        this.b.finish();
                    }
                });
                alertDialogCreate.show();
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void b(com.kc.cw.ad.d.b bVar) {
        f.a(f38846a, "BEGIN_INSTALL!");
        if (bVar.h() != null) {
            n.a(bVar.h().c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        f.c(f38846a, "startDownload");
        this.d = (DownloadManager) getSystemService("download");
        this.e = new a(this, new Handler());
        this.f = new b();
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        d();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.kc.cw.ad.d.b bVar) {
        if (bVar == null) {
            return;
        }
        f.a(f38846a, "--appUpdate downloadApk start--");
        c.a aVarA = c.a();
        h = aVarA;
        aVarA.a(new c.b(this, bVar) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final com.kc.cw.ad.d.b f38854a;
            final DownloadDialogActivity b;

            {
                this.b = this;
                this.f38854a = bVar;
            }

            @Override // com.kc.cw.ad.internal.c.c.b
            public void a(int i) {
                f.a(DownloadDialogActivity.f38846a, "--appUpdate downloadApk onFail--");
                try {
                    String strA = this.f38854a.a();
                    if (TextUtils.isEmpty(strA) || !strA.contains("http")) {
                        return;
                    }
                    if (this.b.j != null) {
                        this.b.j.put(this.f38854a.c(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strA));
                    intent.setFlags(268435456);
                    this.b.startActivity(intent);
                } catch (Exception e) {
                    f.a(DownloadDialogActivity.f38846a, "skip browser fail:" + e);
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
                f.a(DownloadDialogActivity.f38846a, "--appUpdate downloadApk onSuccess--");
                if (this.b.j != null) {
                    this.b.j.put(this.f38854a.c(), Boolean.FALSE);
                }
                this.b.a(this.b.getApplicationContext(), (Long) (-1L), this.f38854a);
            }
        });
        h.a(new c.d(bVar.a(), bVar.d(), bVar.b()));
    }

    private void d() {
        try {
            getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.e);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            registerReceiver(this.f, intentFilter, 2);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void e() {
        String strG;
        com.kc.cw.ad.d.b bVarA = com.kc.cw.ad.d.c.a(this).a();
        if (bVarA == null) {
            return;
        }
        HashMap<String, com.kc.cw.ad.d.b> map = this.i;
        if (map != null) {
            map.put(bVarA.c(), bVarA);
        }
        HashMap<String, Boolean> map2 = this.j;
        if (map2 != null && map2.get(bVarA.c()) == null) {
            f.a(f38846a, "not have package status...");
            this.j.put(bVarA.c(), Boolean.FALSE);
        }
        if (SSAd.getCustomController() != null && !TextUtils.isEmpty(SSAd.getCustomController().getAuthorities())) {
            strG = SSAd.getCustomController().getAuthorities();
        } else if (TextUtils.isEmpty(bVarA.g())) {
            strG = getPackageName() + ".ssad.provider";
        } else {
            strG = bVarA.g();
        }
        this.c = strG;
        bVarA.a(this.c);
        com.kc.cw.ad.d.b.c.a(bVarA.d());
        ThreadUtils.runOnThreadPool(new Runnable(this, bVarA) { // from class: com.kc.cw.ad.internal.activity.DownloadDialogActivity.6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final com.kc.cw.ad.d.b f38852a;
            final DownloadDialogActivity b;

            {
                this.b = this;
                this.f38852a = bVarA;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.a(this.f38852a);
            }
        });
    }

    private void f() {
        try {
            HashMap<Long, String> map = this.k;
            if (map == null || this.i == null) {
                return;
            }
            String str = map.get(Long.valueOf(this.b));
            if (i.d(this, str)) {
                com.kc.cw.ad.d.b bVar = this.i.get(str);
                if (bVar != null) {
                    File file = new File(bVar.d(), bVar.b());
                    if (file.exists() && file.delete()) {
                        f.a(f38846a, "apkFile delete success");
                    }
                    com.kc.cw.ad.d.c.a(this).b(true);
                    if (bVar.h() != null) {
                        n.a(bVar.h().d());
                    }
                    this.i.remove(str);
                }
                HashMap<String, com.kc.cw.ad.d.b> map2 = this.i;
                if (map2 == null || !map2.isEmpty()) {
                    return;
                }
                finish();
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void g() {
        if (this.e != null) {
            getContentResolver().unregisterContentObserver(this.e);
            this.e = null;
            f.a(f38846a, "unregisterContentObserver()");
        }
        b bVar = this.f;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.f = null;
            f.a(f38846a, "unregisterReceiver()");
        }
    }

    private void h() {
        c.a aVar = h;
        if (aVar != null) {
            aVar.a();
        }
        if (this.j != null) {
            this.j = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.k != null) {
            this.k = null;
        }
        com.kc.cw.ad.d.c.a(this).f();
        f.a(f38846a, "releaseResources()");
    }

    public void a(Long l) {
        try {
            HashMap<Long, String> map = this.k;
            if (map != null) {
                String str = map.get(l);
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, Boolean> map2 = this.j;
                    if (map2 != null) {
                        map2.put(str, Boolean.FALSE);
                    }
                    HashMap<String, com.kc.cw.ad.d.b> map3 = this.i;
                    if (map3 != null) {
                        map3.remove(str);
                    }
                }
            }
            DownloadManager downloadManager = this.d;
            if (downloadManager == null || l == null) {
                return;
            }
            downloadManager.remove(l.longValue());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.kc.cw.ad.d.c cVarA = com.kc.cw.ad.d.c.a(this);
        this.l = cVarA;
        this.m = cVarA.b();
        b();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f.a(f38846a, "DownloadService onDestroy()");
        com.kc.cw.ad.d.c cVar = this.l;
        if (cVar != null) {
            cVar.d();
        }
        try {
            g();
            h();
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        f();
    }
}
