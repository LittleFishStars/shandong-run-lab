package com.meishu.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.meishu_ad.view.ListViewForScrollView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class MeishuDownloadDetailActivity extends SafeAppCompatActivity {
    private static final String TAG = "MeishuDownloadDetailAct";
    private TextView app_feature;
    private LinearLayout app_feature_ll;
    private String app_intor_url;
    private TextView app_intro;
    private LinearLayout app_intro_ll;
    private TextView app_name;
    private LinearLayout app_name_ll;
    private LinearLayout app_permiss_ll;
    private TextView app_permiss_tv;
    private List<MeishuAdInfo.PermissionBean> app_permission;
    private String app_permission_url;
    private String app_privacy;
    private TextView app_size;
    private LinearLayout app_size_ll;
    private TextView app_ver;
    private LinearLayout app_ver_ll;
    private TextView developer;
    private LinearLayout developer_ll;
    private DownloadDialogBean downloadBean;
    private ImageView mBack;
    private ListViewForScrollView mListView;
    private TextView mTitle;
    private List<Object> mlist = new ArrayList();
    private TextView payment_types;
    private LinearLayout payment_types_ll;
    private LinearLayout private_agreement_ll;
    private TextView private_agreement_tv;
    private float score;

    public static class MyAdapter extends BaseAdapter {
        private List<MeishuAdInfo.PermissionBean> permissionList;

        public MyAdapter(List<MeishuAdInfo.PermissionBean> list) {
            this.permissionList = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.permissionList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.permissionList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            MeishuAdInfo.PermissionBean permissionBean;
            View viewInflate = View.inflate(viewGroup.getContext(), R.layout.ms_item_list, null);
            try {
                TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_list_name);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_list_desc);
                List<MeishuAdInfo.PermissionBean> list = this.permissionList;
                if (list != null && list.size() > 0 && (permissionBean = this.permissionList.get(i)) != null) {
                    if (TextUtils.isEmpty(permissionBean.getDesc())) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        textView2.setText(permissionBean.getDesc());
                    }
                    if (TextUtils.isEmpty(permissionBean.getTitle())) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(permissionBean.getTitle());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return viewInflate;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        TextView textView;
        Intent intent = getIntent();
        this.downloadBean = intent.getSerializableExtra("download_bean");
        String stringExtra = intent.getStringExtra("page_title");
        if (!TextUtils.isEmpty(stringExtra) && (textView = this.mTitle) != null) {
            textView.setText(stringExtra);
        }
        DownloadDialogBean downloadDialogBean = this.downloadBean;
        if (downloadDialogBean != null) {
            if (TextUtils.isEmpty(downloadDialogBean.getApp_name())) {
                this.app_name_ll.setVisibility(8);
            } else {
                this.app_name.setText(this.downloadBean.getApp_name());
            }
            if (!TextUtils.isEmpty(this.downloadBean.getApp_intro())) {
                this.app_intro.setText(this.downloadBean.getApp_intro());
            } else if (TextUtils.isEmpty(this.downloadBean.getApp_intor_url())) {
                this.app_intro_ll.setVisibility(8);
            } else {
                String app_intor_url = this.downloadBean.getApp_intor_url();
                this.app_intor_url = app_intor_url;
                this.app_intro.setText(app_intor_url);
                this.app_intro.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuDownloadDetailActivity.2
                    public void safeOnClick(View view) {
                        MeishuDownloadDetailActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MeishuDownloadDetailActivity.this.app_intor_url)));
                    }
                });
            }
            if (TextUtils.isEmpty(this.downloadBean.getApp_feature())) {
                this.app_feature_ll.setVisibility(8);
            } else {
                this.app_feature.setText(this.downloadBean.getApp_feature());
            }
            if (TextUtils.isEmpty(this.downloadBean.getPayment_types())) {
                this.payment_types_ll.setVisibility(8);
            } else {
                this.payment_types.setText(this.downloadBean.getPayment_types());
            }
            if (TextUtils.isEmpty(this.downloadBean.getApp_ver())) {
                this.app_ver_ll.setVisibility(8);
            } else {
                this.app_ver.setText(this.downloadBean.getApp_ver());
            }
            if (TextUtils.isEmpty(this.downloadBean.getApp_size())) {
                this.app_size_ll.setVisibility(8);
            } else {
                this.app_size.setText(this.downloadBean.getApp_size());
            }
            if (TextUtils.isEmpty(this.downloadBean.getDeveloper())) {
                this.developer_ll.setVisibility(8);
            } else {
                this.developer.setText(this.downloadBean.getDeveloper());
            }
            if (this.downloadBean.getApp_permission() != null) {
                this.app_permission = this.downloadBean.getApp_permission();
                initPrivacy();
            } else if (!TextUtils.isEmpty(this.downloadBean.getApp_permission_url())) {
                this.app_permiss_ll.setVisibility(0);
                String app_permission_url = this.downloadBean.getApp_permission_url();
                this.app_permission_url = app_permission_url;
                this.app_permiss_tv.setText(app_permission_url);
                this.app_permiss_tv.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuDownloadDetailActivity.3
                    public void safeOnClick(View view) {
                        MeishuDownloadDetailActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MeishuDownloadDetailActivity.this.app_permission_url)));
                    }
                });
            }
            if (TextUtils.isEmpty(this.downloadBean.getApp_private_agreement())) {
                return;
            }
            this.private_agreement_ll.setVisibility(0);
            final String app_private_agreement = this.downloadBean.getApp_private_agreement();
            this.private_agreement_tv.setText(app_private_agreement);
            this.private_agreement_tv.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuDownloadDetailActivity.4
                public void safeOnClick(View view) {
                    try {
                        Intent intent2 = new Intent((Context) MeishuDownloadDetailActivity.this, (Class<?>) MeishuWebviewActivity.class);
                        intent2.putExtra("EXTRA_AD_DURL_KEY", new String[]{app_private_agreement});
                        MeishuDownloadDetailActivity.this.startActivity(intent2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initPrivacy() {
        List app_permission = this.downloadBean.getApp_permission();
        this.mlist.clear();
        if (app_permission == null || app_permission.size() <= 0) {
            return;
        }
        this.mListView.setAdapter(new MyAdapter(app_permission));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.mBack = (ImageView) findViewById(R.id.ms_ic_back);
        this.mTitle = (TextView) findViewById(R.id.ms_detail_title);
        this.mListView = findViewById(R.id.ms_listView);
        this.app_name = (TextView) findViewById(R.id.ms_app_name);
        this.app_name_ll = (LinearLayout) findViewById(R.id.ms_app_name_ll);
        this.app_intro = (TextView) findViewById(R.id.ms_app_intro);
        this.app_intro_ll = (LinearLayout) findViewById(R.id.ms_app_intro_ll);
        this.app_feature = (TextView) findViewById(R.id.ms_app_feature);
        this.app_feature_ll = (LinearLayout) findViewById(R.id.ms_app_feature_ll);
        this.payment_types = (TextView) findViewById(R.id.ms_payment_types);
        this.payment_types_ll = (LinearLayout) findViewById(R.id.ms_payment_types_ll);
        this.app_ver = (TextView) findViewById(R.id.ms_app_ver);
        this.app_ver_ll = (LinearLayout) findViewById(R.id.ms_app_ver_ll);
        this.app_size = (TextView) findViewById(R.id.ms_app_size);
        this.app_size_ll = (LinearLayout) findViewById(R.id.ms_app_size_ll);
        this.developer = (TextView) findViewById(R.id.ms_developer);
        this.developer_ll = (LinearLayout) findViewById(R.id.ms_developer_ll);
        this.app_permiss_ll = (LinearLayout) findViewById(R.id.ms_app_Permiss_ll);
        this.app_permiss_tv = (TextView) findViewById(R.id.ms_app_permiss_tv);
        this.private_agreement_ll = (LinearLayout) findViewById(R.id.ms_app_private_agrement_ll);
        this.private_agreement_tv = (TextView) findViewById(R.id.ms_app_private_agrement_tv);
        this.mBack.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuDownloadDetailActivity.1
            public void safeOnClick(View view) {
                MeishuDownloadDetailActivity.this.finish();
            }
        });
    }

    public static void startActivity(Context context, DownloadDialogBean downloadDialogBean) {
        startActivity(context, downloadDialogBean, null);
    }

    private String trimLeft(String str) {
        char[] charArray = str.toCharArray();
        if (charArray == null || charArray.length <= 0) {
            return "";
        }
        for (int i = 0; i < charArray.length && ':' == charArray[i]; i++) {
            charArray[i] = ' ';
        }
        return String.valueOf(charArray).trim();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        setContentView(R.layout.ms_activity_meishu_download_detail);
        initView();
        initData();
    }

    public static void startActivity(Context context, DownloadDialogBean downloadDialogBean, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) MeishuDownloadDetailActivity.class);
            intent.putExtra("download_bean", (Serializable) downloadDialogBean);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("page_title", str);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
