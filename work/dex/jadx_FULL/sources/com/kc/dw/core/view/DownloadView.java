package com.kc.dw.core.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kc.dw.activity.SsdDownloadDetailActivity;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.LayoutBean;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.LogUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadView {
    private static final String TAG = "DownloadView";

    private void setImage(View view, int i, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView == null || TextUtils.isEmpty(str)) {
                return;
            }
            new d(imageView).a(str, false).d(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setText(View view, int i, String str) {
        try {
            TextView textView = (TextView) view.findViewById(i);
            if (textView == null || TextUtils.isEmpty(str)) {
                return;
            }
            d dVar = new d(textView);
            View view2 = dVar.d;
            if (view2 instanceof TextView) {
                ((TextView) view2).setText(str);
            }
            dVar.d(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleDownloadView(View view, BaseAdSlot baseAdSlot) {
        if (baseAdSlot == null || view == null) {
            return;
        }
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + baseAdSlot.getInteractionType());
            if (baseAdSlot.getInteractionType() == 1) {
                TextView textView = (TextView) view.findViewById(R.id.ssd_download_layer_textview);
                textView.setVisibility(0);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                    sb.append("应用名称：");
                    sb.append(baseAdSlot.getAppName());
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_ver())) {
                    sb.append(" 应用版本：");
                    sb.append(baseAdSlot.getApp_ver());
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_size())) {
                    sb.append(" 应用大小：");
                    sb.append(baseAdSlot.getApp_size());
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getDeveloper())) {
                    sb.append(" 开发者：");
                    sb.append(baseAdSlot.getDeveloper());
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_permission_url()) || baseAdSlot.getApp_permission() != null) {
                    sb.append(" 权限详情>");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getPrivacy_agreement())) {
                    sb.append(" 隐私协议 > ");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_intor_url()) || !TextUtils.isEmpty(baseAdSlot.getApp_intro())) {
                    sb.append(" 功能介绍>");
                }
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    textView.setVisibility(8);
                } else if (string.endsWith("|")) {
                    string.substring(0, string.length() - 1);
                }
                textView.setText(string);
                textView.setOnClickListener(new m(this, baseAdSlot, view) { // from class: com.kc.dw.core.view.DownloadView.1
                    public final DownloadView this$0;
                    public final View val$adRoot;
                    public final BaseAdSlot val$adSlot;

                    {
                        this.this$0 = this;
                        this.val$adSlot = baseAdSlot;
                        this.val$adRoot = view;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view2) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.val$adSlot.getAppName());
                            downloadDialogBean.setApp_feature(this.val$adSlot.getApp_feature());
                            downloadDialogBean.setApp_intro(this.val$adSlot.getApp_intro());
                            downloadDialogBean.setApp_privacy(this.val$adSlot.getApp_privacy());
                            downloadDialogBean.setApp_size(this.val$adSlot.getApp_size());
                            downloadDialogBean.setDeveloper(this.val$adSlot.getDeveloper());
                            downloadDialogBean.setPayment_types(this.val$adSlot.getPayment_types());
                            downloadDialogBean.setApp_permission(this.val$adSlot.getApp_permission());
                            downloadDialogBean.setApp_permission_url(this.val$adSlot.getApp_permission_url());
                            downloadDialogBean.setApp_intor_url(this.val$adSlot.getApp_intor_url());
                            downloadDialogBean.setApp_private_agreement(this.val$adSlot.getPrivacy_agreement());
                            SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void handleFeedDownloadView(View view, BaseAdSlot baseAdSlot, LayoutBean.StyleBean styleBean) {
        if (baseAdSlot == null || view == null) {
            return;
        }
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + baseAdSlot.getInteractionType());
            if (baseAdSlot.getInteractionType() == 1) {
                TextView textView = (TextView) view.findViewById(R.id.ssd_download_layer_textview);
                textView.setVisibility(0);
                StringBuilder sb = new StringBuilder();
                if (styleBean != null) {
                    if (styleBean.getType() == 301 || styleBean.getType() == 401) {
                        if (!TextUtils.isEmpty(baseAdSlot.getDeveloper())) {
                            sb.append(" ");
                            sb.append(baseAdSlot.getDeveloper());
                            sb.append(" |");
                        }
                    } else if (styleBean.getType() == 501) {
                        if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                            sb.append(" ");
                            sb.append(baseAdSlot.getAppName());
                            sb.append(" |");
                        }
                        if (!TextUtils.isEmpty(baseAdSlot.getDeveloper())) {
                            sb.append(" ");
                            sb.append(baseAdSlot.getDeveloper());
                            sb.append(" |");
                        }
                    }
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_permission_url()) || baseAdSlot.getApp_permission() != null) {
                    sb.append(" 权限");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getPrivacy_agreement())) {
                    sb.append(" 隐私");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_intor_url()) || !TextUtils.isEmpty(baseAdSlot.getApp_intro())) {
                    sb.append(" 功能");
                }
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    textView.setVisibility(8);
                } else if (string.endsWith("|")) {
                    string = string.substring(0, string.length() - 1);
                }
                if (string.startsWith(" ")) {
                    string = string.substring(1);
                }
                textView.setText(string);
                textView.setOnClickListener(new m(this, baseAdSlot, view) { // from class: com.kc.dw.core.view.DownloadView.2
                    public final DownloadView this$0;
                    public final View val$adRoot;
                    public final BaseAdSlot val$adSlot;

                    {
                        this.this$0 = this;
                        this.val$adSlot = baseAdSlot;
                        this.val$adRoot = view;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view2) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.val$adSlot.getAppName());
                            downloadDialogBean.setApp_feature(this.val$adSlot.getApp_feature());
                            downloadDialogBean.setApp_intro(this.val$adSlot.getApp_intro());
                            downloadDialogBean.setApp_privacy(this.val$adSlot.getApp_privacy());
                            downloadDialogBean.setApp_size(this.val$adSlot.getApp_size());
                            downloadDialogBean.setDeveloper(this.val$adSlot.getDeveloper());
                            downloadDialogBean.setPayment_types(this.val$adSlot.getPayment_types());
                            downloadDialogBean.setApp_permission(this.val$adSlot.getApp_permission());
                            downloadDialogBean.setApp_permission_url(this.val$adSlot.getApp_permission_url());
                            downloadDialogBean.setApp_intor_url(this.val$adSlot.getApp_intor_url());
                            downloadDialogBean.setApp_private_agreement(this.val$adSlot.getPrivacy_agreement());
                            SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                setImage(view, R.id.ms_download_layer_app_logo, baseAdSlot.getIcon());
                setText(view, R.id.ms_download_layer_app_name, baseAdSlot.getAppName());
                setText(view, R.id.ms_download_layer_app_developer, baseAdSlot.getDeveloper());
                new d(view).b(R.id.ms_download_layer_layout).d(0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
