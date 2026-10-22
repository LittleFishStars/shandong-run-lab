package com.fl.saas.s2s.sdk.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.ConfigParseUtil;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.YdAppBackgroundUtil;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommJumpHelper {
    private static CommJumpHelper sInstance;
    private DownloadTipDialog downloadTipDialog;
    private AdSource mAdSource;

    private CommJumpHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: deepLinkJump, reason: merged with bridge method [inline-methods] */
    public void lambda$jump2App$2(Context context, AdInfoPoJo adInfoPoJo) {
        String strGdtReplac;
        QuickAppHelper quickAppHelper;
        String str;
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (adInfoPoJo.deep_url.contains("m.taobao.com")) {
                intent.setFlags(805339136);
            } else {
                intent.setFlags(268435456);
            }
            intent.setData(Uri.parse(adInfoPoJo.deep_url));
            if (DeviceUtil.deviceCanHandleIntent(intent)) {
                YdAppBackgroundUtil.getInstance().setClickAdSource(this.mAdSource);
                CommReportHelper.getInstance().reportDeepLinkInstalled(adInfoPoJo);
                CommReportHelper.getInstance().reportDeepLinkAttempt(adInfoPoJo);
                if (!ConfigParseUtil.launchApp(context, intent, adInfoPoJo.deep_url, adInfoPoJo.bdt)) {
                    context.startActivity(intent);
                }
                CommReportHelper.getInstance().reportDeepLink(adInfoPoJo);
                adInfoPoJo.clickIsDp = "1";
                if (adInfoPoJo.post_click_strategy != 1) {
                    return;
                }
                strGdtReplac = CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo);
                quickAppHelper = QuickAppHelper.getInstance();
                str = adInfoPoJo.place_id;
            } else {
                if (!ConfigParseUtil.launchApp(context, intent, adInfoPoJo.deep_url, adInfoPoJo.bdt)) {
                    context.startActivity(intent);
                }
                YdAppBackgroundUtil.getInstance().setClickAdSource(this.mAdSource);
                CommReportHelper.getInstance().reportDeepLinkInstalled(adInfoPoJo);
                CommReportHelper.getInstance().reportDeepLinkAttempt(adInfoPoJo);
                CommReportHelper.getInstance().reportDeepLink(adInfoPoJo);
                adInfoPoJo.clickIsDp = "1";
                if (adInfoPoJo.post_click_strategy != 1) {
                    return;
                }
                strGdtReplac = CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo);
                quickAppHelper = QuickAppHelper.getInstance();
                str = adInfoPoJo.place_id;
            }
            YdH5Activity.launchWithEnableQuickApp(context, strGdtReplac, quickAppHelper.enableQuickApp(str));
        } catch (Exception e) {
            adInfoPoJo.dp_result = 1;
            if (adInfoPoJo.dp_reason != 2) {
                adInfoPoJo.dp_reason = 3;
            }
            CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            YdH5Activity.launchWithEnableQuickApp(context, CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo), QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id));
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gdtClick(Context context, AdInfoPoJo adInfoPoJo, String str) {
        if (context == null || adInfoPoJo == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (adInfoPoJo.ac_type.equals("5")) {
                if (str.contains("qz_gdt=")) {
                    adInfoPoJo.clickId = str.substring(str.indexOf("qz_gdt=") + 7);
                }
                jump2App(context, adInfoPoJo);
            } else if (adInfoPoJo.ac_type.equals("6")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("ret", -1) == 0) {
                        adInfoPoJo.clickId = jSONObject.optJSONObject("data").optString("clickid");
                        jumpAndDownload(context, adInfoPoJo);
                    } else {
                        jump2H5(context, adInfoPoJo);
                    }
                } catch (Throwable unused) {
                    jump2H5(context, adInfoPoJo);
                }
            }
        } catch (Throwable unused2) {
            jump2H5(context, adInfoPoJo);
        }
    }

    public static CommJumpHelper getInstance() {
        if (sInstance == null) {
            synchronized (CommJumpHelper.class) {
                sInstance = new CommJumpHelper();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startDownload, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$jump2Download$1(Context context, AdInfoPoJo adInfoPoJo) {
        String str = !TextUtils.isEmpty(adInfoPoJo.download_url) ? adInfoPoJo.download_url : adInfoPoJo.click_url;
        CommClickHelper.getInstance().report(context, adInfoPoJo, 4);
        CommClickHelper.getInstance().downloadAPK(context, adInfoPoJo, str);
    }

    private void startGdtClick(final Context context, final AdInfoPoJo adInfoPoJo) {
        List<String> list = adInfoPoJo.click_notice_urls;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = adInfoPoJo.click_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(true, CommReportHelper.getInstance().gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommJumpHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    exc.printStackTrace();
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    CommJumpHelper.this.gdtClick(context, adInfoPoJo, str);
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    CommJumpHelper.this.gdtClick(context, adInfoPoJo, str);
                }
            });
        }
    }

    public void dismissDownLoadDialog() {
        try {
            DownloadTipDialog downloadTipDialog = this.downloadTipDialog;
            if (downloadTipDialog == null || !downloadTipDialog.isShowing()) {
                return;
            }
            this.downloadTipDialog.dismiss();
            this.downloadTipDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
            this.downloadTipDialog = null;
        }
    }

    public void jump(Context context, AdInfoPoJo adInfoPoJo, AdSource adSource) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        this.mAdSource = adSource;
        String str = adInfoPoJo.ac_type;
        if (str.equals("1")) {
            jumpAndDownload(context, adInfoPoJo);
            return;
        }
        if (str.equals("5") || str.equals("6")) {
            startGdtClick(context, adInfoPoJo);
            return;
        }
        if (str.equals("3")) {
            jump2App(context, adInfoPoJo);
        } else if (str.equals("7")) {
            jump2MiniProgram(context, adInfoPoJo);
        } else {
            jump2H5(context, adInfoPoJo);
        }
    }

    public void jump2App(final Context context, final AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(adInfoPoJo.deep_url)) {
                YdH5Activity.launchWithEnableQuickApp(context, CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo), QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id));
            } else if (QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id) || !QuickAppHelper.getInstance().urlIntercept(adInfoPoJo.deep_url)) {
                lambda$jump2App$2(context, adInfoPoJo);
            } else if (QuickAppHelper.getInstance().getQuickAppInterceptionType() == 1) {
                new YdCommonDialog(context).setTitle("跳转提示").setContent("想要打开“快应用”\n是否允许").setCanDismiss(false).setCancelName("拒绝").setSubmitName("允许").setOnSubmitListener(new YdCommonDialog.OnSubmitListener() { // from class: com.zj.adlib.go1
                    @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
                    public final void onClick() {
                        this.f16831a.lambda$jump2App$2(context, adInfoPoJo);
                    }
                }).show();
            }
        } catch (Exception e) {
            adInfoPoJo.dp_result = 1;
            if (adInfoPoJo.dp_reason != 2) {
                adInfoPoJo.dp_reason = 3;
            }
            CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            YdH5Activity.launchWithEnableQuickApp(context, CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo), QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id));
            e.printStackTrace();
        }
    }

    public void jump2Download(final Context context, final AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        if (adInfoPoJo.isShowDownloadDialog) {
            try {
                if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                    Activity topActivity = DeviceUtil.getTopActivity();
                    if (topActivity == null || topActivity.isFinishing()) {
                        lambda$jump2Download$1(context, adInfoPoJo);
                        return;
                    } else if (this.downloadTipDialog == null) {
                        this.downloadTipDialog = new DownloadTipDialog(context, adInfoPoJo, new DownloadTipDialog.OnAgreeClickListener() { // from class: com.zj.adlib.fo1
                            @Override // com.fl.saas.s2s.sdk.helper.DownloadTipDialog.OnAgreeClickListener
                            public final void onClick() {
                                this.f16591a.lambda$jump2Download$1(context, adInfoPoJo);
                            }
                        });
                    }
                } else if (this.downloadTipDialog == null) {
                    this.downloadTipDialog = new DownloadTipDialog(context, adInfoPoJo, new DownloadTipDialog.OnAgreeClickListener() { // from class: com.zj.adlib.eo1
                        @Override // com.fl.saas.s2s.sdk.helper.DownloadTipDialog.OnAgreeClickListener
                        public final void onClick() {
                            this.f16366a.lambda$jump2Download$0(context, adInfoPoJo);
                        }
                    });
                }
                this.downloadTipDialog.show();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        lambda$jump2Download$1(context, adInfoPoJo);
    }

    public void jump2H5(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        jump2App(context, adInfoPoJo);
    }

    public void jump2MiniProgram(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, adInfoPoJo.wxAppId);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = adInfoPoJo.miniProgramOriginId;
            if (!TextUtils.isEmpty(adInfoPoJo.miniPath) && adInfoPoJo.miniPath.trim().length() > 0) {
                req.path = adInfoPoJo.miniPath;
            }
            req.miniprogramType = 0;
            iwxapiCreateWXAPI.sendReq(req);
        } catch (Throwable th) {
            jump2H5(context, adInfoPoJo);
            th.printStackTrace();
        }
    }

    public void jumpAndDownload(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(adInfoPoJo.deep_url)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (adInfoPoJo.deep_url.contains("m.taobao.com")) {
                    intent.setFlags(805339136);
                } else {
                    intent.setFlags(268435456);
                }
                intent.setData(Uri.parse(adInfoPoJo.deep_url));
                if (DeviceUtil.deviceCanHandleIntent(intent)) {
                    CommReportHelper.getInstance().reportDeepLinkInstalled(adInfoPoJo);
                    CommReportHelper.getInstance().reportDeepLinkAttempt(adInfoPoJo);
                    if (!ConfigParseUtil.launchApp(context, intent, adInfoPoJo.deep_url, adInfoPoJo.bdt)) {
                        context.startActivity(intent);
                    }
                    CommReportHelper.getInstance().reportDeepLink(adInfoPoJo);
                    adInfoPoJo.clickIsDp = "1";
                    return;
                }
                adInfoPoJo.dp_reason = 2;
                CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            }
            jump2Download(context, adInfoPoJo);
        } catch (Exception e) {
            adInfoPoJo.dp_result = 1;
            if (adInfoPoJo.dp_reason != 2) {
                adInfoPoJo.dp_reason = 3;
            }
            CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            jump2Download(context, adInfoPoJo);
            e.printStackTrace();
        }
    }
}
