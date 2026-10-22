package com.beizi.fusion.asnp.adn.ad.widget.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.permission.PermissionModel;
import com.beizi.fusion.mg;
import com.google.android.material.tabs.TabLayout;
import com.huawei.hms.push.AttributionReporter;
import com.zj.adlib.u15;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ASNPDlInfoDetailActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TabLayout f27071a;
    private TextView b;
    private TextView c;
    private FrameLayout d;
    private BasicWebView e;
    private String f;
    private Map g;
    private final String[] h = {"introduction", "privacy", AttributionReporter.SYSTEM_PERMISSION};
    private int i = -1;

    public class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            ASNPDlInfoDetailActivity aSNPDlInfoDetailActivity = ASNPDlInfoDetailActivity.this;
            if (aSNPDlInfoDetailActivity.i != position) {
                aSNPDlInfoDetailActivity.a(position);
                ASNPDlInfoDetailActivity.this.i = position;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            ASNPDlInfoDetailActivity.this.i = tab.getPosition();
            ASNPDlInfoDetailActivity aSNPDlInfoDetailActivity = ASNPDlInfoDetailActivity.this;
            aSNPDlInfoDetailActivity.a(aSNPDlInfoDetailActivity.i);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27073a;
        private final String b;

        private b(String str, String str2) {
            this.f27073a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            if (TextUtils.isEmpty(this.b)) {
                return false;
            }
            return this.b.startsWith("http");
        }
    }

    private void a(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            if ("introduction".equalsIgnoreCase(str)) {
                i = 0;
            } else if ("privacy".equalsIgnoreCase(str)) {
                i = 1;
            } else {
                i = AttributionReporter.SYSTEM_PERMISSION.equals(str) ? 2 : -1;
            }
            TabLayout tabLayout = this.f27071a;
            if (tabLayout != null && i != -1) {
                tabLayout.selectTab(tabLayout.getTabAt(i));
                return;
            }
        }
        d();
    }

    private void b() {
        Intent intent = getIntent();
        if (intent == null) {
            a();
            return;
        }
        if (a(intent)) {
            a();
            return;
        }
        String stringExtra = intent.getStringExtra("whichTab");
        if (TextUtils.isEmpty(stringExtra)) {
            d();
        } else {
            a(stringExtra);
        }
    }

    private void c() {
        this.d = (FrameLayout) findViewById(R.id.asnp_download_detail_layout);
        this.b = (TextView) findViewById(R.id.asnp_download_detail_title);
        this.e = (BasicWebView) findViewById(R.id.asnp_download_detail_web);
        this.c = (TextView) findViewById(R.id.asnp_download_detail_content);
        ((ImageView) findViewById(R.id.asnp_download_detail_back)).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.sq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44750a.a(view);
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.asnp_download_detail_tab);
        this.f27071a = tabLayout;
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
    }

    private void d() {
        a("introduction");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.asnp_download_detail_layout);
        c();
        b();
    }

    private boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("dlm");
        if (!TextUtils.isEmpty(stringExtra) && mg.a(stringExtra)) {
            DownloadInfoModel downloadInfoModel = new DownloadInfoModel(mg.c(stringExtra));
            if (!downloadInfoModel.hasParseException()) {
                this.f = downloadInfoModel.getName();
                ArrayMap arrayMap = new ArrayMap();
                this.g = arrayMap;
                arrayMap.put("introduction", new b(downloadInfoModel.getAppIntroduction(), ""));
                this.g.put("privacy", new b(downloadInfoModel.getPolicy(), downloadInfoModel.getPolicyUrl()));
                this.g.put(AttributionReporter.SYSTEM_PERMISSION, new b(a(downloadInfoModel.getPermission()), downloadInfoModel.getPermissionUrl()));
                return false;
            }
        }
        return true;
    }

    private void a() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private String a(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PermissionModel permissionModel = (PermissionModel) it.next();
                String title = permissionModel.getTitle();
                String describe = permissionModel.getDescribe();
                sb.append(title);
                sb.append(u15.f19942b);
                sb.append(describe);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        b bVar;
        this.b.setText(this.f);
        if (i < 3) {
            String str = this.h[i];
            Map map = this.g;
            if (map == null || (bVar = (b) map.get(str)) == null) {
                return;
            }
            if (bVar.a()) {
                this.d.setVisibility(8);
                this.e.setVisibility(4);
                this.e.loadUrl(bVar.b);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.c.setText(bVar.f27073a);
            }
        }
    }
}
