package com.kc.dw.ad.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.kc.dw.activity.SsdDownloadDetailActivity;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.safe.SafeAppCompatActivity;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.DownloadUtils;
import com.kc.dw.core.utils.i0;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownLoadDialogActivity extends SafeAppCompatActivity {
    public static com.kc.dw.platform.ad_adapter.c x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f39176a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public View t;
    public List<SsdAdInfo.PermissionBean> u;
    public String v;
    public String w;

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnClick(View view) {
        try {
            if (view.getId() == R.id.ssd_dialog_download_appdetail) {
                DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                downloadDialogBean.setApp_name(this.j);
                downloadDialogBean.setApp_feature(this.n);
                downloadDialogBean.setApp_intro(this.m);
                downloadDialogBean.setApp_privacy(this.r);
                downloadDialogBean.setApp_size(this.q);
                downloadDialogBean.setDeveloper(this.l);
                downloadDialogBean.setPayment_types(this.o);
                downloadDialogBean.setApp_permission(this.u);
                downloadDialogBean.setApp_permission_url(this.v);
                downloadDialogBean.setApp_intor_url(this.w);
                SsdDownloadDetailActivity.startActivity(this, downloadDialogBean);
                return;
            }
            if (view.getId() == R.id.ssd_dialog_download_privacy) {
                try {
                    String str = this.s;
                    Intent intent = new Intent(this, (Class<?>) SsdWebviewActivity.class);
                    intent.putExtra("EXTRA_AD_DURL_KEY", new String[]{str});
                    startActivity(intent);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (view.getId() == R.id.ssd_dialog_download_downloadBtn) {
                String[] strArrA = com.kc.dw.core.utils.f.a(x.a().getDn_start(), x);
                String[] strArrA2 = com.kc.dw.core.utils.f.a(x.a().getDn_succ(), x);
                String[] strArrA3 = com.kc.dw.core.utils.f.a(x.a().getDn_inst_start(), x);
                String[] strArrA4 = com.kc.dw.core.utils.f.a(x.a().getDn_inst_succ(), x);
                String appName = x.a().getAppName();
                if (appName == null) {
                    appName = "";
                }
                String str2 = appName;
                Map<Integer, i0> map = DownloadUtils.h;
                DownloadUtils.b.f39340a.a(getApplicationContext(), x.a().getdUrl()[0], str2, this.i, strArrA, strArrA2, strArrA3, strArrA4);
                Toast.makeText(this, com.ipd.dsp.internal.b1.b.a.l, 0).show();
            } else if (view.getId() != R.id.ssd_dialog_download_cancel) {
                return;
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        AdSlot adSlotA;
        super.safeOnCreate(bundle);
        setContentView(getResources().getConfiguration().orientation == 2 ? R.layout.ssd_dialog_download_landscape : R.layout.ssd_dialog_download);
        this.f39176a = (ImageView) findViewById(R.id.ssd_dialog_download_imageview);
        this.b = (TextView) findViewById(R.id.ssd_dialog_download_title);
        this.c = (TextView) findViewById(R.id.ssd_dialog_download_version);
        this.d = (TextView) findViewById(R.id.ssd_dialog_download_owner);
        this.e = (TextView) findViewById(R.id.ssd_dialog_download_appdetail);
        this.t = findViewById(R.id.ssd_dialog_download_divider);
        this.f = (TextView) findViewById(R.id.ssd_dialog_download_privacy);
        this.g = (TextView) findViewById(R.id.ssd_dialog_download_downloadBtn);
        this.h = (TextView) findViewById(R.id.ssd_dialog_download_cancel);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        com.kc.dw.platform.ad_adapter.c cVar = x;
        if (cVar != null && (adSlotA = cVar.a()) != null) {
            try {
                this.j = adSlotA.getAppName();
                this.i = adSlotA.getPackageName();
                this.k = adSlotA.getIcon();
                this.l = adSlotA.getDeveloper();
                this.m = adSlotA.getApp_intro();
                this.n = adSlotA.getApp_feature();
                this.o = adSlotA.getPayment_types();
                this.p = adSlotA.getApp_ver();
                this.q = adSlotA.getApp_size();
                this.r = adSlotA.getApp_privacy();
                this.s = adSlotA.getPrivacy_agreement();
                if (adSlotA instanceof BaseAdSlot) {
                    this.u = ((BaseAdSlot) adSlotA).getApp_permission();
                    this.v = ((BaseAdSlot) adSlotA).getApp_permission_url();
                    this.w = ((BaseAdSlot) adSlotA).getApp_intor_url();
                }
            } catch (Exception e) {
                StringBuilder sbA = com.kc.dw.activity.a.a("DownLoadDialog: ");
                sbA.append(e.getMessage());
                Log.e("DownLoadDialog", sbA.toString());
                e.printStackTrace();
            }
        }
        try {
            boolean z = false;
            if (!TextUtils.isEmpty(this.k)) {
                com.kc.dw.core.bquery.d dVar = new com.kc.dw.core.bquery.d((Context) null);
                dVar.d = this.f39176a;
                dVar.a(this.k, false);
            }
            if (TextUtils.isEmpty(this.j)) {
                this.b.setVisibility(8);
            } else {
                this.b.setText(this.j);
            }
            if (TextUtils.isEmpty(this.p)) {
                this.c.setVisibility(8);
            } else {
                this.c.setText("版本号 ：" + this.p);
            }
            if (TextUtils.isEmpty(this.l)) {
                this.d.setVisibility(8);
            } else {
                this.d.setText("开发者 ：" + this.l);
            }
            if (TextUtils.isEmpty(this.s)) {
                this.t.setVisibility(8);
                this.f.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(this.n) && TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.q) && TextUtils.isEmpty(this.l) && TextUtils.isEmpty(this.o)) {
                z = true;
            }
            if (z) {
                this.t.setVisibility(8);
                this.e.setVisibility(8);
            }
        } catch (Exception e2) {
            StringBuilder sbA2 = com.kc.dw.activity.a.a("initData: ");
            sbA2.append(e2.getMessage());
            Log.e("DownLoadDialog", sbA2.toString());
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        x = null;
    }
}
