package com.beizi.fusion;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.download.service.DownloadService;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.LinkModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i1 extends g1 {
    private cc f;

    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("prompt");
                LinkModel linkModelC = i1.this.c();
                if ("cancel".equals(stringExtra) && linkModelC != null) {
                    i1.this.a(context, linkModelC);
                }
                if ("confirm".equals(stringExtra) && linkModelC != null) {
                    i1.this.b(context, linkModelC);
                }
            }
            i1.this.b(context.getApplicationContext(), this);
        }
    }

    public static class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27378a;
        private final com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a b;

        private b(Context context, String str, DownloadInfoModel downloadInfoModel, String str2, AdTraceModel adTraceModel) {
            this.f27378a = context.getApplicationContext();
            this.b = new com.beizi.fusion.asnp.adn.ad.download.service.a.C0298a(str, downloadInfoModel, str2, adTraceModel);
        }

        private void a(IBinder iBinder) {
            com.beizi.fusion.asnp.adn.ad.download.service.a aVarA;
            if (!(iBinder instanceof DownloadService.b) || (aVarA = ((DownloadService.b) iBinder).a()) == null) {
                return;
            }
            aVarA.a(this.b);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a(iBinder);
            this.f27378a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context, LinkModel linkModel) {
        if (!TextUtils.isEmpty(linkModel.getMarketURL()) && d(context, linkModel.getMarketURL())) {
            return true;
        }
        if (TextUtils.isEmpty(linkModel.getDownloadURL())) {
            return false;
        }
        return a(linkModel.getDownloadURL(), this.b.getDownloadInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkModel c() {
        NativeModel nativeModel = this.b;
        if (nativeModel == null || nativeModel.getLink() == null) {
            return null;
        }
        return this.b.getLink();
    }

    private boolean d(Context context, String str) {
        return a(context, str);
    }

    private boolean e() {
        DownloadInfoModel downloadInfoModelB;
        LinkModel linkModelC = c();
        if (linkModelC != null && linkModelC.getInteractType() == 1) {
            String marketURL = linkModelC.getMarketURL();
            String downloadURL = linkModelC.getDownloadURL();
            if ((!TextUtils.isEmpty(marketURL) || !TextUtils.isEmpty(downloadURL)) && (downloadInfoModelB = b()) != null && downloadInfoModelB.isConformanceByDlInfo()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.beizi.fusion.aa
    public w9 a() {
        cc ccVar = new cc();
        this.f = ccVar;
        return ccVar;
    }

    @Override // com.beizi.fusion.g1, com.beizi.fusion.j1, com.beizi.fusion.ha
    public void a(LinkModel linkModel, View view, int i) {
        if (linkModel != null) {
            if (TextUtils.isEmpty(linkModel.getDeeplink()) || !a(view.getContext(), linkModel.getDeeplink())) {
                if (e()) {
                    if (a(i)) {
                        if (c(view.getContext(), linkModel.getDownloadURL())) {
                            return;
                        }
                    } else if (b(view.getContext(), linkModel)) {
                        return;
                    }
                }
                super.a(linkModel, view, i);
            }
        }
    }

    private boolean c(Context context, String str) {
        if (b() == null) {
            return false;
        }
        a aVar = new a();
        a(context, aVar);
        DownloadInfoModel downloadInfo = this.b.getDownloadInfo();
        if (downloadInfo == null) {
            return false;
        }
        boolean zA = wf.a(context, str, downloadInfo.toJsonString());
        if (!zA) {
            b(context, aVar);
        }
        return zA;
    }

    private DownloadInfoModel b() {
        NativeModel nativeModel = this.b;
        if (nativeModel == null || nativeModel.getDownloadInfo() == null) {
            return null;
        }
        return this.b.getDownloadInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, a aVar) {
        if (context != null) {
            fh.a(context.getApplicationContext()).a(aVar);
        }
    }

    private boolean a(int i) {
        LinkModel linkModelC = c();
        return (i == 0 || linkModelC == null || !linkModelC.showDownloadPrompt()) ? false : true;
    }

    @Override // com.beizi.fusion.j1
    public Bundle a(LinkModel linkModel) {
        if (linkModel != null && !TextUtils.isEmpty(linkModel.getLandingPageURL()) && b() != null) {
            LinkModel linkModelC = c();
            boolean z = linkModelC != null ? !linkModelC.shouldWebIntercept() : false;
            Bundle bundleA = super.a(linkModelC);
            bundleA.putBoolean("allow", z);
            return bundleA;
        }
        return super.a(linkModel);
    }

    private boolean a(String str, DownloadInfoModel downloadInfoModel) {
        if (!no.e(str)) {
            return false;
        }
        wf.a(this.c, new b(this.c, str, downloadInfoModel, this.d, this.f.b()));
        return true;
    }

    private void a(Context context, a aVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.asnp.ad.ACTION_DOWNLOAD_PROMPT_RESULT");
        if (context != null) {
            fh.a(context.getApplicationContext()).a(aVar, intentFilter);
        }
    }
}
