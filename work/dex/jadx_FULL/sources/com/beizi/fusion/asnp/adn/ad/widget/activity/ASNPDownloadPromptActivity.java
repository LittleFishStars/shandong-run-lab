package com.beizi.fusion.asnp.adn.ad.widget.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.permission.PermissionModel;
import com.beizi.fusion.fh;
import com.beizi.fusion.fp;
import com.beizi.fusion.mf;
import com.beizi.fusion.mg;
import com.beizi.fusion.om;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ASNPDownloadPromptActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f27074a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private ExpandableListView f;
    private LinearLayout g;
    private LinearLayout h;
    private FrameLayout i;
    private DownloadInfoModel j;
    private int k = -1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27075a;
        private final String b;
        private final String c;

        private a(String str, String str2, String str3) {
            this.f27075a = str2;
            this.b = str3;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            if (TextUtils.isEmpty(this.b)) {
                return false;
            }
            return this.b.startsWith("http");
        }
    }

    public static class b extends BaseExpandableListAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27076a;
        private final List b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f27077a;
            BasicWebView b;
        }

        /* JADX INFO: renamed from: com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPDownloadPromptActivity$b$b, reason: collision with other inner class name */
        public static class C0299b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f27078a;
            ImageView b;
            View c;
        }

        private b(Context context, List list) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.f27076a = context;
            arrayList.clear();
            arrayList.addAll(list);
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i, int i2) {
            return this.b.get(i);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i, int i2) {
            return i2;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f27076a).inflate(R.layout.asnp_download_dialog_expand_child_item, (ViewGroup) null);
                aVar = new a();
                aVar.f27077a = (TextView) view.findViewById(R.id.addeci_content_tv);
                aVar.b = (BasicWebView) view.findViewById(R.id.addeci_content_wb);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            a aVar2 = (a) this.b.get(i);
            if (aVar2.a()) {
                aVar.f27077a.setVisibility(8);
                if (TextUtils.isEmpty(aVar2.b)) {
                    aVar.b.setVisibility(8);
                    return view;
                }
                aVar.b.setVisibility(0);
                aVar.b.loadUrl(aVar2.b);
                return view;
            }
            aVar.b.setVisibility(8);
            if (TextUtils.isEmpty(aVar2.f27075a)) {
                aVar.f27077a.setVisibility(8);
                return view;
            }
            aVar.f27077a.setText(aVar2.f27075a);
            aVar.f27077a.setVisibility(0);
            try {
                aVar.f27077a.setTextColor(Color.parseColor(fp.a().a("#8C8C8C")));
            } catch (Exception unused) {
            }
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i) {
            return 1;
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return this.b.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i) {
            return i;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            C0299b c0299b;
            if (view == null) {
                view = LayoutInflater.from(this.f27076a).inflate(R.layout.asnp_download_dialog_expand_parent_item, (ViewGroup) null);
                c0299b = new C0299b();
                c0299b.f27078a = (TextView) view.findViewById(R.id.addep_title_tv);
                c0299b.b = (ImageView) view.findViewById(R.id.addep_fold_iv);
                c0299b.c = view.findViewById(R.id.addep_item_divider_view);
                view.setTag(c0299b);
            } else {
                c0299b = (C0299b) view.getTag();
            }
            c0299b.f27078a.setText(((a) this.b.get(i)).c);
            if (z) {
                c0299b.f27078a.setTextColor(Color.parseColor("#FF8E15"));
                c0299b.b.setBackgroundResource(R.mipmap.asnp_icon_arrow_unfold);
            } else {
                try {
                    c0299b.f27078a.setTextColor(Color.parseColor(fp.a().a("#333333")));
                } catch (Exception e) {
                    om.a(e);
                }
                c0299b.b.setBackgroundResource(R.mipmap.asnp_icon_arrow_fold);
            }
            if (i == 0) {
                c0299b.c.setVisibility(8);
            } else {
                c0299b.c.setVisibility(0);
            }
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i, int i2) {
            return false;
        }
    }

    private void a() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("download_info_key");
            if (TextUtils.isEmpty(stringExtra) || !mg.a(stringExtra)) {
                return;
            }
            DownloadInfoModel downloadInfoModel = new DownloadInfoModel(mg.c(stringExtra));
            if (downloadInfoModel.hasParseException()) {
                return;
            }
            this.j = downloadInfoModel;
        }
    }

    private void b() {
        this.i = (FrameLayout) findViewById(R.id.adscope_download_dialog_total_layout);
        this.h = (LinearLayout) findViewById(R.id.adscope_download_dialog_linear);
        View viewFindViewById = findViewById(R.id.adscope_download_dialog_divider_view);
        this.d = (ImageView) findViewById(R.id.adscope_download_dialog_close_iv);
        this.e = (ImageView) findViewById(R.id.adscope_download_dialog_icon_iv);
        this.f27074a = (TextView) findViewById(R.id.adscope_download_dialog_name_tv);
        this.b = (TextView) findViewById(R.id.adscope_download_dialog_version_tv);
        this.c = (TextView) findViewById(R.id.adscope_download_dialog_developer_tv);
        this.f = (ExpandableListView) findViewById(R.id.adscope_download_dialog_expand_lv);
        this.g = (LinearLayout) findViewById(R.id.adscope_download_dialog_download_ll);
        this.f.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() { // from class: com.zj.adlib.uq
            @Override // android.widget.ExpandableListView.OnGroupExpandListener
            public final void onGroupExpand(int i) {
                this.f45204a.a(i);
            }
        });
        try {
            this.h.setBackgroundColor(Color.parseColor(fp.a().a("#FFFFFF")));
            viewFindViewById.setBackgroundColor(Color.parseColor(fp.a().a("#CCCCCC")));
            this.d.setImageTintList(ColorStateList.valueOf(Color.parseColor(fp.a().a("#000000"))));
            this.f27074a.setTextColor(Color.parseColor(fp.a().a("#000000")));
            this.b.setTextColor(Color.parseColor(fp.a().a("#8C8C8C")));
            this.c.setTextColor(Color.parseColor(fp.a().a("#8C8C8C")));
        } catch (Exception e) {
            om.a(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45417a.a(view);
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45659a.b(view);
            }
        });
        DownloadInfoModel downloadInfoModel = this.j;
        if (downloadInfoModel == null) {
            return;
        }
        if (this.e != null && !TextUtils.isEmpty(downloadInfoModel.getIconUrl())) {
            mf.a(this).b(this.j.getIconUrl()).b(true).a(this.e);
        }
        if (this.f27074a != null && !TextUtils.isEmpty(this.j.getName())) {
            this.f27074a.setText(this.j.getName());
        }
        if (this.b != null && !TextUtils.isEmpty(this.j.getVersion())) {
            this.b.setText(String.format("%s %s", getString(R.string.adscope_version_code), this.j.getVersion()));
        }
        if (this.c != null && !TextUtils.isEmpty(this.j.getDeveloper())) {
            this.c.setText(String.format("%s %s", getString(R.string.adscope_developer), this.j.getDeveloper()));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(getString(R.string.adscope_app_permission), a(this.j.getPermission()), this.j.getPermissionUrl()));
        arrayList.add(new a(getString(R.string.adscope_app_privacy_policy), this.j.getPolicy(), this.j.getPolicyUrl()));
        arrayList.add(new a(getString(R.string.adscope_app_intro_info), this.j.getAppIntroduction(), this.j.getAppIntroduction()));
        this.f.setAdapter(new b(this, arrayList));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        a();
        setContentView(R.layout.asnp_download_dialog);
        b();
        c();
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
    public /* synthetic */ void a(int i) {
        int i2 = this.k;
        if (i2 != -1) {
            this.f.collapseGroup(i2);
        }
        this.k = i;
    }

    private void a(boolean z) {
        Intent intent = new Intent();
        intent.setAction("com.asnp.ad.ACTION_DOWNLOAD_PROMPT_RESULT");
        if (z) {
            intent.putExtra("prompt", "confirm");
        } else {
            intent.putExtra("prompt", "cancel");
        }
        finish();
        fh.a(getApplicationContext()).a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(false);
    }
}
