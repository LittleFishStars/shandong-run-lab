package com.fl.saas.adx.base.download;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.fl.saas.AbstractC1419l;
import com.fl.saas.AbstractC1437u;
import com.fl.saas.C1415j;
import com.fl.saas.F;
import com.fl.saas.R;
import com.fl.saas.adx.base.activity.h5.FLH5Activity;
import com.fl.saas.adx.base.widget.DownloadProgressTextView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.ipd.dsp.internal.b1.b;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadTipDialog extends Dialog {
    public static final String HTML_END = "</body>\n</html>";
    public static final String HTML_HEAD = "<!DOCTYPE html>\n<html id=\"html\">\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" />\n<meta HTTP-EQUIV=\"pragma\" CONTENT=\"no-cache\">\n</head>\n<body>";
    private boolean canClickDownLoad;
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

    /* JADX INFO: renamed from: com.fl.saas.adx.base.download.DownloadTipDialog$4, reason: invalid class name */
    public class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ C1415j val$AdxInfo;

        public AnonymousClass4(C1415j c1415j) {
            this.val$AdxInfo = c1415j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            DownloadTipDialog.this.isDownload = true;
            if (DownloadTipDialog.this.mLinstener != null) {
                DownloadTipDialog.this.mLinstener.onClick();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DownloadTipDialog.this.canClickDownLoad) {
                DownloadTipDialog.this.canClickDownLoad = false;
                if (DownloadTipDialog.this.isDownloadSuccess) {
                    DownloadTipDialog.this.canClickDownLoad = true;
                    if (TextUtils.isEmpty(DownloadTipDialog.this.downloadFilePath)) {
                        return;
                    }
                    File file = new File(DownloadTipDialog.this.downloadFilePath);
                    if (file.exists()) {
                        AbstractC1419l.a(DownloadTipDialog.this.mContext, file, this.val$AdxInfo);
                        return;
                    }
                    return;
                }
                if (!"立即下载".equals(DownloadTipDialog.this.tvConfirm.getCurrentText().toString())) {
                    Intent intent = new Intent();
                    intent.setAction(DownloadTipDialog.this.isDownload ? F.t : F.s);
                    intent.putExtra("downLoadUrl", DownloadTipDialog.this.downLoadUrl);
                    DownloadTipDialog.this.mContext.sendBroadcast(intent);
                    return;
                }
                if (TextUtils.isEmpty(DownloadTipDialog.this.downLoadUrl)) {
                    Toast.makeText(DownloadTipDialog.this.mContext, "下载链接为空", 0).show();
                    return;
                }
                if (AbstractC1437u.f30196a) {
                    DownloadTipDialog.this.mContext.sendBroadcast(new Intent(F.w));
                }
                DeviceUtil.postUIDelayed(100L, new Runnable() { // from class: com.fl.saas.adx.base.download.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30102a.lambda$onClick$0();
                    }
                });
            }
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
                if (F.s.equals(action)) {
                    DownloadTipDialog.this.isDownload = true;
                } else {
                    if (F.t.equals(action)) {
                        DownloadTipDialog.this.isDownload = false;
                        DownloadTipDialog.this.canClickDownLoad = true;
                        DownloadTipDialog.this.tvConfirm.setState(2);
                        DownloadTipDialog.this.tvConfirm.setCurrentText(b.a.n);
                        return;
                    }
                    if (F.u.equals(action)) {
                        DownloadTipDialog.this.isDownload = false;
                        DownloadTipDialog.this.isDownloadSuccess = false;
                        DownloadTipDialog.this.downloadProgress = 0;
                        DownloadTipDialog.this.canClickDownLoad = true;
                        DownloadTipDialog.this.tvConfirm.setCurrentText("立即下载");
                        DownloadTipDialog.this.dismiss();
                        return;
                    }
                    if (F.v.equals(action)) {
                        DownloadTipDialog.this.canClickDownLoad = true;
                        Toast.makeText(context, "下载失败,重新点击下载", 0).show();
                        return;
                    }
                    if (!F.x.equals(action)) {
                        if (F.y.equals(action)) {
                            DownloadTipDialog.this.isDownloadSuccess = true;
                            DownloadTipDialog.this.canClickDownLoad = true;
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

    /* JADX WARN: Code duplicated, block: B:38:0x015b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0167  */
    /* JADX WARN: Code duplicated, block: B:42:0x0183  */
    /* JADX WARN: Code duplicated, block: B:43:0x018f  */
    /* JADX WARN: Code duplicated, block: B:46:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:47:0x01c5  */
    public DownloadTipDialog(@NonNull Context context, final C1415j c1415j, OnAgreeClickListener onAgreeClickListener) {
        View.OnClickListener onClickListener;
        TextView textView;
        TextView textView2;
        int mobileWidth;
        super(context);
        this.canClickDownLoad = true;
        this.mContext = context.getApplicationContext();
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
        if (c1415j == null) {
            dismiss();
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.fl_adx_download_tip, (ViewGroup) null);
        this.downLoadUrl = !TextUtils.isEmpty(c1415j.z0) ? c1415j.z0 : c1415j.x0;
        this.tvConfirm = (DownloadProgressTextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.iv_yd_saas_download_tip_close);
        ImageView imageView2 = (ImageView) this.mRootView.findViewById(R.id.iv_yd_saas_s2s_download_icon);
        if (TextUtils.isEmpty(c1415j.x1)) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(imageView2, c1415j.x1);
        }
        TextView textView3 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_name);
        if (TextUtils.isEmpty(c1415j.C0)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(c1415j.C0);
            textView3.setVisibility(0);
        }
        TextView textView4 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_advertiser);
        if (TextUtils.isEmpty(c1415j.D0)) {
            textView4.setVisibility(8);
        } else {
            textView4.setText(c1415j.D0);
            textView4.setVisibility(0);
        }
        TextView textView5 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_version);
        if (TextUtils.isEmpty(c1415j.E0)) {
            textView5.setVisibility(8);
        } else {
            textView5.setText(c1415j.E0);
            textView5.setVisibility(0);
        }
        TextView textView6 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_permission);
        textView6.getPaint().setFlags(8);
        if (TextUtils.isEmpty(c1415j.G0)) {
            if (!TextUtils.isEmpty(c1415j.G0) || TextUtils.isEmpty(c1415j.I0)) {
                textView6.setVisibility(8);
            } else {
                textView6.setVisibility(0);
                onClickListener = new View.OnClickListener() { // from class: com.fl.saas.adx.base.download.DownloadTipDialog.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FLH5Activity.launch(DownloadTipDialog.this.mContext, DownloadTipDialog.this.spliceHtml(c1415j), true);
                    }
                };
            }
            textView = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_privacy);
            textView.getPaint().setFlags(8);
            if (TextUtils.isEmpty(c1415j.H0)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.download.DownloadTipDialog.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FLH5Activity.launch(DownloadTipDialog.this.mContext, c1415j.H0);
                    }
                });
            }
            textView2 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_function);
            textView2.getPaint().setFlags(8);
            if (TextUtils.isEmpty(c1415j.J0)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zq2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f46319a.lambda$new$0(c1415j, view);
                    }
                });
            }
            this.tvConfirm.setCurrentText("立即下载");
            this.tvConfirm.setOnClickListener(new AnonymousClass4(c1415j));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.download.DownloadTipDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DownloadTipDialog.this.tvConfirm.setCurrentText(DownloadTipDialog.this.isDownloadSuccess ? b.a.o : "立即下载");
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
        onClickListener = new View.OnClickListener() { // from class: com.fl.saas.adx.base.download.DownloadTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FLH5Activity.launch(DownloadTipDialog.this.mContext, c1415j.G0);
            }
        };
        textView6.setOnClickListener(onClickListener);
        textView = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_privacy);
        textView.getPaint().setFlags(8);
        if (TextUtils.isEmpty(c1415j.H0)) {
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.download.DownloadTipDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FLH5Activity.launch(DownloadTipDialog.this.mContext, c1415j.H0);
                }
            });
        } else {
            textView.setVisibility(8);
        }
        textView2 = (TextView) this.mRootView.findViewById(R.id.tv_yd_saas_s2s_download_function);
        textView2.getPaint().setFlags(8);
        if (TextUtils.isEmpty(c1415j.J0)) {
            textView2.setVisibility(0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f46319a.lambda$new$0(c1415j, view);
                }
            });
        } else {
            textView2.setVisibility(8);
        }
        this.tvConfirm.setCurrentText("立即下载");
        this.tvConfirm.setOnClickListener(new AnonymousClass4(c1415j));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.download.DownloadTipDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadTipDialog.this.tvConfirm.setCurrentText(DownloadTipDialog.this.isDownloadSuccess ? b.a.o : "立即下载");
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
    public /* synthetic */ void lambda$new$0(C1415j c1415j, View view) {
        FLH5Activity.launch(this.mContext, c1415j.J0);
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
        this.canClickDownLoad = true;
        this.tvConfirm.setState(1);
        this.tvConfirm.setProgressText("正在下载", this.downloadProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String spliceHtml(C1415j c1415j) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (c1415j != null) {
            try {
                if (TextUtils.isEmpty(c1415j.I0)) {
                    sb2 = new StringBuilder("<div>暂未获取到权限列表，请稍后再试</div>");
                } else {
                    JSONArray jSONArray = new JSONArray(c1415j.I0);
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
                intentFilter.addAction(F.s);
                intentFilter.addAction(F.t);
                intentFilter.addAction(F.u);
                intentFilter.addAction(F.v);
                intentFilter.addAction(F.x);
                intentFilter.addAction(F.y);
                if (Build.VERSION.SDK_INT >= 34) {
                    this.mContext.registerReceiver(this.dialogUIUpdateReceiver, intentFilter, 2);
                } else {
                    this.mContext.registerReceiver(this.dialogUIUpdateReceiver, intentFilter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.xq2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f45876a.lambda$show$1(dialogInterface);
            }
        });
    }
}
