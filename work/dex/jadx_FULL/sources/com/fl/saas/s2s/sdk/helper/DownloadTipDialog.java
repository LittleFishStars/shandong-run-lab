package com.fl.saas.s2s.sdk.helper;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil;
import com.fl.saas.s2s.sdk.helper.download.DownloadService;
import com.fl.saas.s2s.sdk.util.ApkUtils;
import com.fl.saas.s2s.sdk.widget.DownloadProgressTextView;
import com.ipd.dsp.internal.b1.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadTipDialog extends Dialog {
    public static final String HTML_END = "</body>\n</html>";
    public static final String HTML_HEAD = "<!DOCTYPE html>\n<html id=\"html\">\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" />\n<meta HTTP-EQUIV=\"pragma\" CONTENT=\"no-cache\">\n</head>\n<body>";
    private DialogUIUpdateReceiver dialogUIUpdateReceiver;
    private String downLoadUrl;
    private String downloadFilePath;
    private int downloadProgress;
    private boolean isDownload;
    private boolean isDownloadSuccess;
    private Context mContext;
    private OnAgreeClickListener mLinstener;
    private View mRootView;
    private DownloadProgressTextView tvConfirm;

    /* JADX INFO: renamed from: com.fl.saas.s2s.sdk.helper.DownloadTipDialog$5, reason: invalid class name */
    public class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ AdInfoPoJo val$adInfoPoJo;

        public AnonymousClass5(AdInfoPoJo adInfoPoJo) {
            this.val$adInfoPoJo = adInfoPoJo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            DownloadTipDialog.this.isDownload = true;
            if (DownloadTipDialog.this.mLinstener != null) {
                DownloadTipDialog.this.mLinstener.onClick();
            }
            DownloadTipDialog.this.setProgressText();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DownloadTipDialog.this.isDownloadSuccess) {
                if (TextUtils.isEmpty(DownloadTipDialog.this.downloadFilePath)) {
                    return;
                }
                File file = new File(DownloadTipDialog.this.downloadFilePath);
                if (file.exists()) {
                    ApkUtils.installAPk(DownloadTipDialog.this.mContext, file, this.val$adInfoPoJo);
                    return;
                }
                return;
            }
            if (!"立即下载".equals(DownloadTipDialog.this.tvConfirm.getCurrentText().toString())) {
                Intent intent = new Intent();
                intent.setAction(DownloadTipDialog.this.isDownload ? DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD : DownLoadSupportPauseUtil.YD_START_DOWNLOAD);
                intent.putExtra("downLoadUrl", DownloadTipDialog.this.downLoadUrl);
                DownloadTipDialog.this.mContext.sendBroadcast(intent);
                return;
            }
            if (TextUtils.isEmpty(DownloadTipDialog.this.downLoadUrl)) {
                Toast.makeText(DownloadTipDialog.this.mContext, "下载链接为空", 0).show();
                return;
            }
            if (DownloadService.isIntentServiceRunning) {
                DownloadTipDialog.this.mContext.sendBroadcast(new Intent(DownLoadSupportPauseUtil.YD_CANCEL_LAST_DOWNLOAD));
            }
            DeviceUtil.postUIDelayed(100L, new Runnable() { // from class: com.fl.saas.s2s.sdk.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30191a.lambda$onClick$0();
                }
            });
        }
    }

    public class DialogUIUpdateReceiver extends BroadcastReceiver {
        public DialogUIUpdateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_START_DOWNLOAD.equals(action)) {
                    DownloadTipDialog.this.isDownload = true;
                } else if (DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD.equals(action)) {
                    DownloadTipDialog.this.isDownload = false;
                    DownloadTipDialog.this.tvConfirm.setState(2);
                    DownloadTipDialog.this.tvConfirm.setCurrentText(b.a.n);
                    return;
                } else {
                    if (DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD.equals(action)) {
                        DownloadTipDialog.this.dismiss();
                        return;
                    }
                    if (!DownLoadSupportPauseUtil.YD_UPDATE_DOWNLOAD_PROGRESS.equals(action)) {
                        if (DownLoadSupportPauseUtil.YD_DOWNLOAD_SUCCESS.equals(action)) {
                            DownloadTipDialog.this.isDownloadSuccess = true;
                            DownloadTipDialog.this.tvConfirm.setState(0);
                            DownloadTipDialog.this.tvConfirm.setCurrentText(b.a.o);
                            DownloadTipDialog.this.downloadFilePath = intent.getStringExtra("downloadFilePath");
                            return;
                        }
                        return;
                    }
                    DownloadTipDialog.this.downloadProgress = intent.getIntExtra("progress", 0);
                }
                DownloadTipDialog.this.setProgressText();
            }
        }
    }

    public interface OnAgreeClickListener {
        void onClick();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0150  */
    /* JADX WARN: Code duplicated, block: B:39:0x015c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0178  */
    /* JADX WARN: Code duplicated, block: B:43:0x0184  */
    /* JADX WARN: Code duplicated, block: B:46:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x01ba  */
    public DownloadTipDialog(@NonNull Context context, final AdInfoPoJo adInfoPoJo, OnAgreeClickListener onAgreeClickListener) {
        View.OnClickListener onClickListener;
        TextView textView;
        TextView textView2;
        int mobileWidth;
        super(context);
        this.mContext = context;
        requestWindowFeature(1);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        this.mLinstener = onAgreeClickListener;
        if (adInfoPoJo == null) {
            dismiss();
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.s2s_sdk_download_tip, (ViewGroup) null);
        this.downLoadUrl = !TextUtils.isEmpty(adInfoPoJo.download_url) ? adInfoPoJo.download_url : adInfoPoJo.click_url;
        this.tvConfirm = (DownloadProgressTextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.iv_yd_saas_download_tip_close);
        final ImageView imageView2 = (ImageView) this.mRootView.findViewById(R.id.iv_yd_saas_s2s_download_icon);
        if (TextUtils.isEmpty(adInfoPoJo.logo_icon)) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            AdHttpUtils.getInstance().doGet(adInfoPoJo.logo_icon, new HttpCallbackBytesListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.1
                @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                public void onSuccess(byte[] bArr) {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(bArr));
                        if (bitmapDecodeStream.getWidth() > 0 && bitmapDecodeStream.getHeight() > 0) {
                            imageView2.setImageBitmap(bitmapDecodeStream);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
        TextView textView3 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_name);
        if (TextUtils.isEmpty(adInfoPoJo.app_name)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(adInfoPoJo.app_name);
            textView3.setVisibility(0);
        }
        TextView textView4 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_advertiser);
        if (TextUtils.isEmpty(adInfoPoJo.advertiser_name)) {
            textView4.setVisibility(8);
        } else {
            textView4.setText(adInfoPoJo.advertiser_name);
            textView4.setVisibility(0);
        }
        TextView textView5 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_version);
        if (TextUtils.isEmpty(adInfoPoJo.app_version)) {
            textView5.setVisibility(8);
        } else {
            textView5.setText(adInfoPoJo.app_version);
            textView5.setVisibility(0);
        }
        TextView textView6 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_permission);
        textView6.getPaint().setFlags(8);
        if (TextUtils.isEmpty(adInfoPoJo.permissions_url)) {
            if (!TextUtils.isEmpty(adInfoPoJo.permissions_url) || TextUtils.isEmpty(adInfoPoJo.permission_list)) {
                textView6.setVisibility(8);
            } else {
                textView6.setVisibility(0);
                onClickListener = new View.OnClickListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        YdH5Activity.launch(DownloadTipDialog.this.mContext, DownloadTipDialog.this.spliceHtml(adInfoPoJo), true);
                    }
                };
            }
            textView = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_privacy);
            textView.getPaint().setFlags(8);
            if (TextUtils.isEmpty(adInfoPoJo.privacy_agreement)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        YdH5Activity.launch(DownloadTipDialog.this.mContext, adInfoPoJo.privacy_agreement);
                    }
                });
            }
            textView2 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_function);
            textView2.getPaint().setFlags(8);
            if (TextUtils.isEmpty(adInfoPoJo.app_intro_url)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wq2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f20497a.lambda$new$0(adInfoPoJo, view);
                    }
                });
            }
            this.tvConfirm.setCurrentText("立即下载");
            this.tvConfirm.setOnClickListener(new AnonymousClass5(adInfoPoJo));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DownloadTipDialog.this.dismiss();
                }
            });
            if (DeviceUtil.getMobileWidth() > DeviceUtil.getMobileHeight()) {
                mobileWidth = (((int) (((double) DeviceUtil.getMobileHeight()) * 0.9d)) / 12) * 8;
            } else {
                mobileWidth = (int) (((double) DeviceUtil.getMobileWidth()) * 0.8d);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mobileWidth, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            relativeLayout.addView(this.mRootView, layoutParams);
            setContentView(relativeLayout);
        }
        textView6.setVisibility(0);
        onClickListener = new View.OnClickListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YdH5Activity.launch(DownloadTipDialog.this.mContext, adInfoPoJo.permissions_url);
            }
        };
        textView6.setOnClickListener(onClickListener);
        textView = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_privacy);
        textView.getPaint().setFlags(8);
        if (TextUtils.isEmpty(adInfoPoJo.privacy_agreement)) {
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    YdH5Activity.launch(DownloadTipDialog.this.mContext, adInfoPoJo.privacy_agreement);
                }
            });
        } else {
            textView.setVisibility(8);
        }
        textView2 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_function);
        textView2.getPaint().setFlags(8);
        if (TextUtils.isEmpty(adInfoPoJo.app_intro_url)) {
            textView2.setVisibility(0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20497a.lambda$new$0(adInfoPoJo, view);
                }
            });
        } else {
            textView2.setVisibility(8);
        }
        this.tvConfirm.setCurrentText("立即下载");
        this.tvConfirm.setOnClickListener(new AnonymousClass5(adInfoPoJo));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadTipDialog.this.dismiss();
            }
        });
        if (DeviceUtil.getMobileWidth() > DeviceUtil.getMobileHeight()) {
            mobileWidth = (((int) (((double) DeviceUtil.getMobileHeight()) * 0.9d)) / 12) * 8;
        } else {
            mobileWidth = (int) (((double) DeviceUtil.getMobileWidth()) * 0.8d);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(mobileWidth, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        relativeLayout.addView(this.mRootView, layoutParams2);
        setContentView(relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(AdInfoPoJo adInfoPoJo, View view) {
        YdH5Activity.launch(this.mContext, adInfoPoJo.app_intro_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(DialogInterface dialogInterface) {
        DialogUIUpdateReceiver dialogUIUpdateReceiver = this.dialogUIUpdateReceiver;
        if (dialogUIUpdateReceiver != null) {
            try {
                this.mContext.unregisterReceiver(dialogUIUpdateReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.dialogUIUpdateReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgressText() {
        this.tvConfirm.setState(1);
        this.tvConfirm.setProgressText("正在下载", this.downloadProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String spliceHtml(AdInfoPoJo adInfoPoJo) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (adInfoPoJo != null) {
            try {
                if (TextUtils.isEmpty(adInfoPoJo.permission_list)) {
                    sb2 = new StringBuilder("<div>暂未获取到权限列表，请稍后再试</div>");
                } else {
                    JSONArray jSONArray = new JSONArray(adInfoPoJo.permission_list);
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        String strOptString = jSONObjectOptJSONObject.optString("permission_name");
                        String strOptString2 = jSONObjectOptJSONObject.optString("permission_desc");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(" <li style=\"padding: 3px 0\">\n <span>");
                        i++;
                        sb3.append(i);
                        sb3.append(Consts.DOT);
                        sb3.append(strOptString);
                        sb3.append(": ");
                        sb3.append(strOptString2);
                        sb3.append("</span>\n </li>");
                        sb2.append(sb3.toString());
                    }
                }
                sb = new StringBuilder("<!DOCTYPE html>\n<html id=\"html\">\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" />\n<meta HTTP-EQUIV=\"pragma\" CONTENT=\"no-cache\">\n</head>\n<body>" + ((Object) sb2) + "</body>\n</html>");
            } catch (Throwable unused) {
                sb = new StringBuilder("<div>暂未获取到权限列表，请稍后再试</div>");
            }
        } else {
            sb2 = new StringBuilder("<div>暂未获取到权限列表，请稍后再试</div>");
            sb = new StringBuilder("<!DOCTYPE html>\n<html id=\"html\">\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" />\n<meta HTTP-EQUIV=\"pragma\" CONTENT=\"no-cache\">\n</head>\n<body>" + ((Object) sb2) + "</body>\n</html>");
        }
        return sb.toString();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DialogUIUpdateReceiver dialogUIUpdateReceiver = this.dialogUIUpdateReceiver;
        if (dialogUIUpdateReceiver != null) {
            try {
                this.mContext.unregisterReceiver(dialogUIUpdateReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.dialogUIUpdateReceiver = null;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            if (this.dialogUIUpdateReceiver == null) {
                this.dialogUIUpdateReceiver = new DialogUIUpdateReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_START_DOWNLOAD);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_UPDATE_DOWNLOAD_PROGRESS);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_DOWNLOAD_SUCCESS);
                if (Build.VERSION.SDK_INT > 33) {
                    this.mContext.registerReceiver(this.dialogUIUpdateReceiver, intentFilter, 2);
                } else {
                    this.mContext.registerReceiver(this.dialogUIUpdateReceiver, intentFilter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.yq2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f46096a.lambda$show$1(dialogInterface);
            }
        });
    }
}
