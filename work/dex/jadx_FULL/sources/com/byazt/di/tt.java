package com.byazt.di;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.ar.AdDownloadController;
import com.byazt.ar.AdDownloadEventConfig;
import com.byazt.ar.AdDownloadModel;
import com.byazt.bv.BaseConstants;
import com.byazt.gq.t;
import com.byazt.hu.sl;
import com.byazt.hu.u;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 13})
public class tt implements com.byazt.pk.tt {
    public static String c = "tt";
    public static volatile tt tt;
    public da ve = da.c(t.getContext());

    private tt() {
    }

    public static DownloadEventConfig ve() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog tt(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (c(downloadModel.getId())) {
            if (z2) {
                c(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                tt(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.ve.c(context, i, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) u.c(downloadEventConfig, ve());
        final DownloadController downloadController2 = (DownloadController) u.c(downloadController, tt());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.byazt.lr.tt.c().c(downloadModel)) ? true : (t.i().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.ve.c(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        sl.c(c, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogTt = t.ve().tt(new com.byazt.e.tt.c(context).c(downloadModel.getName()).tt("确认要下载此应用吗？").ve("确认").uj(OptionsPickerHelper.e).c(new com.byazt.e.tt.InterfaceC0394tt() { // from class: com.byazt.di.tt.2
            @Override // com.byazt.e.tt.InterfaceC0394tt
            public void c(DialogInterface dialogInterface) {
                tt.this.ve.c(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.byazt.zn.c.c().c("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.e.tt.InterfaceC0394tt
            public void tt(DialogInterface dialogInterface) {
                com.byazt.zn.c.c().c("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.e.tt.InterfaceC0394tt
            public void ve(DialogInterface dialogInterface) {
                com.byazt.zn.c.c().c("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }
        }).c(0).c());
        com.byazt.zn.c.c().c("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogTt;
    }

    public static tt c() {
        if (tt == null) {
            synchronized (tt.class) {
                if (tt == null) {
                    tt = new tt();
                }
            }
        }
        return tt;
    }

    @Override // com.byazt.pk.tt
    public Dialog c(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return c(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.byazt.pk.tt
    public Dialog c(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return c(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog c(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return c(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog c(final Context context, final String str, final boolean z, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.byazt.dm.tt.c(new com.byazt.dm.tt.c<Dialog>() { // from class: com.byazt.di.tt.1
            @Override // com.byazt.dm.tt.c
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Dialog tt() {
                return tt.this.tt(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.byazt.pk.tt
    public boolean c(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(j);
        if (ttVarUj != null) {
            this.ve.c(context, i, downloadStatusChangeListener, ttVarUj.y());
            return true;
        }
        DownloadModel downloadModelC = com.byazt.nn.a.c().c(j);
        if (downloadModelC == null) {
            return false;
        }
        this.ve.c(context, i, downloadStatusChangeListener, downloadModelC);
        return true;
    }

    @Override // com.byazt.pk.tt
    public boolean c(long j, int i) {
        DownloadModel downloadModelC = com.byazt.nn.a.c().c(j);
        if (downloadModelC == null) {
            return false;
        }
        this.ve.c(downloadModelC.getDownloadUrl(), i);
        return true;
    }

    public void c(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelC = com.byazt.nn.a.c().c(j);
        com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(j);
        if (downloadModelC == null && ttVarUj != null) {
            downloadModelC = ttVarUj.y();
        }
        if (downloadModelC == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.byazt.su.uj) && !(downloadController instanceof com.byazt.su.ve)) {
            downloadEventConfig.setDownloadScene(1);
            this.ve.c(downloadModelC.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        } else {
            tt(j);
        }
    }

    public void tt(long j) {
        DownloadModel downloadModelC = com.byazt.nn.a.c().c(j);
        com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(j);
        if (downloadModelC == null && ttVarUj != null) {
            downloadModelC = ttVarUj.y();
        }
        if (downloadModelC == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigTt = com.byazt.nn.a.c().tt(j);
        DownloadController downloadControllerVe = com.byazt.nn.a.c().ve(j);
        if (downloadEventConfigTt instanceof com.byazt.su.uj) {
            downloadEventConfigTt = null;
        }
        if (downloadControllerVe instanceof com.byazt.su.ve) {
            downloadControllerVe = null;
        }
        if (ttVarUj == null) {
            if (downloadEventConfigTt == null) {
                downloadEventConfigTt = ve();
            }
            if (downloadControllerVe == null) {
                downloadControllerVe = tt();
            }
        } else {
            if (downloadEventConfigTt == null) {
                downloadEventConfigTt = new AdDownloadEventConfig.Builder().setClickButtonTag(ttVarUj.da()).setRefer(ttVarUj.i()).setIsEnableV3Event(ttVarUj.u()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerVe == null) {
                downloadControllerVe = ttVarUj.j();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigTt;
        downloadEventConfig.setDownloadScene(1);
        this.ve.c(downloadModelC.getDownloadUrl(), j, 2, downloadEventConfig, downloadControllerVe);
    }

    @Override // com.byazt.pk.tt
    public boolean c(long j) {
        return (com.byazt.nn.a.c().c(j) == null && com.byazt.nn.a.c().uj(j) == null) ? false : true;
    }

    @Override // com.byazt.pk.tt
    public boolean c(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return c(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.byazt.pk.tt
    public boolean c(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.byazt.dm.tt.c(new com.byazt.dm.tt.c<Boolean>() { // from class: com.byazt.di.tt.3
            @Override // com.byazt.dm.tt.c
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean tt() {
                return Boolean.valueOf(tt.this.tt(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController c(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tt(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadControllerTt = downloadController;
        if (!com.byazt.ki.c.c(uri) || t.i().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? t.getContext() : context;
        String strTt = com.byazt.ki.c.tt(uri);
        if (downloadModel == null) {
            return com.byazt.hu.i.c(context2, strTt).getType() == 5;
        }
        if (!TextUtils.isEmpty(strTt) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strTt);
        }
        if (downloadControllerTt != null) {
            downloadControllerTt.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerTt = c(true);
        } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
            downloadControllerTt = c(true);
        } else {
            downloadControllerTt = tt();
        }
        com.byazt.nn.n nVar = new com.byazt.nn.n(downloadModel.getId(), downloadModel, (DownloadEventConfig) u.c(downloadEventConfig, ve()), downloadControllerTt);
        com.byazt.nn.a.c().c(nVar.tt);
        com.byazt.nn.a.c().c(nVar.c, nVar.ve);
        com.byazt.nn.a.c().c(nVar.c, nVar.uj);
        if (u.c(downloadModel) && com.byazt.k.c.ve().tt("app_link_opt") == 1 && com.byazt.us.c.c(nVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        u.c(jSONObject, "market_url", uri.toString());
        u.c(jSONObject, "download_scene", (Object) 1);
        com.byazt.su.tt marketStatusChangeListener = nVar.uj.getMarketStatusChangeListener();
        com.byazt.zn.c.c().tt("market_click_open", jSONObject, nVar);
        com.byazt.nn.sp spVarC = com.byazt.hu.i.c(context2, nVar, strTt);
        String strC = u.c(spVarC.tt(), "open_market");
        if (spVarC.getType() == 5) {
            com.byazt.us.c.c(strC, jSONObject, nVar, true);
            return true;
        }
        if (spVarC.getType() != 6) {
            return true;
        }
        u.c(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(spVarC.c()));
        if (marketStatusChangeListener != null) {
            marketStatusChangeListener.tt();
        }
        com.byazt.zn.c.c().tt("market_open_failed", jSONObject, nVar);
        if (com.byazt.gq.i.c(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController tt() {
        return c(false);
    }
}
