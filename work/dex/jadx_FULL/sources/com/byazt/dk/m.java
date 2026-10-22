package com.byazt.dk;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.byazt.aas.nb;
import com.byazt.ar.AdDownloadController;
import com.byazt.ar.AdDownloadEventConfig;
import com.byazt.ar.AdDownloadModel;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.e.DeepLink;
import com.byazt.hv.TTDownloadField;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ou.DownloadMarketInterceptor;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.ou.OnItemClickListener;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;
import com.byazt.z.DownloadHandlerService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.coremedia.iso.boxes.MetaBox;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 130})
public final class m extends com.byazt.fb.uj {
    public static volatile m c;
    public Function<SparseArray<Object>, Object> i;
    public final Context tt;
    public Map<Integer, AdDownloadModel.Builder> ve = new ConcurrentHashMap();
    public Map<Integer, AdDownloadModel> uj = new ConcurrentHashMap();
    public Map<Integer, AdDownloadController.Builder> n = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, AdDownloadController> f28412a = new ConcurrentHashMap();
    public Map<Integer, AdDownloadEventConfig.Builder> sp = new ConcurrentHashMap();
    public Map<Integer, AdDownloadEventConfig> x = new ConcurrentHashMap();

    private m(Context context) {
        this.tt = context;
    }

    private int a(int i) {
        return i + 1;
    }

    private DownloadController a(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private Function<SparseArray<Object>, Object> c() {
        Function<SparseArray<Object>, Object> function = this.i;
        if (function != null) {
            return function;
        }
        Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(3);
        this.i = functionA;
        if (functionA == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("n", com.byazt.omf.x.m().nb());
        this.i.apply(com.byazt.yxi.uj.c().c(159).c(Map.class).c(0, map).tt());
        return this.i;
    }

    private OnItemClickListener da(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private DownloadMarketInterceptor i(Object obj) {
        if (obj instanceof DownloadMarketInterceptor) {
            return (DownloadMarketInterceptor) obj;
        }
        return null;
    }

    public static m instance(Context context) {
        if (c == null) {
            synchronized (m.class) {
                if (c == null) {
                    c = new m(context);
                }
            }
        }
        return c;
    }

    private AdDownloadEventConfig n(int i) {
        return this.x.get(Integer.valueOf(i));
    }

    private IDownloadButtonClickListener sl(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private boolean sp(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private AdDownloadModel.Builder tt(int i) {
        return this.ve.get(Integer.valueOf(i));
    }

    private AdDownloadController uj(int i) {
        return this.f28412a.get(Integer.valueOf(i));
    }

    private AdDownloadModel ve(int i) {
        return this.uj.get(Integer.valueOf(i));
    }

    private com.byazt.ocd.c x(Object obj) {
        if (obj instanceof Function) {
            return new com.byazt.ocd.c(obj);
        }
        return null;
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return i == -99999986 ? (T) values().sparseArray() : (T) call(i, pluginValueSet, cls);
    }

    public boolean autoInstallWithoutNotification(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return false;
        }
        return adDownloadModelVe.autoInstallWithoutNotification();
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i != 20) {
            return (T) callMethod(cls, i, (pluginValueSet == null || pluginValueSet.objectValue(0, Map.class) == null) ? new HashMap<>() : (Map) pluginValueSet.objectValue(0, Map.class));
        }
        init((Bundle) pluginValueSet.objectValue(0, Bundle.class));
        return null;
    }

    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        Object obj = map.get("hashCode");
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        DownloadModel downloadModelVe = ve(iIntValue);
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(z.c(getActivity(map.get(TTDownloadField.TT_ACTIVITY)), x(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) z.tt().a();
            case 2:
                try {
                    return (T) Boolean.valueOf(z.c((String) map.get("tagIntercept"), (String) map.get("label"), new JSONObject((String) map.get(MetaBox.TYPE)), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                z.c(((Integer) map.get("hid")).intValue());
                return null;
            case 4:
                z.tt().c(downloadModelVe == null ? (String) map.get("downloadUrl") : downloadModelVe.getDownloadUrl(), iIntValue);
                c(iIntValue);
                return null;
            case 5:
                if (downloadModelVe == null) {
                    downloadModelVe = uj(map.get("downloadModel"));
                }
                DownloadStatusChangeListener downloadStatusChangeListenerTt = tt(map.get("downloadStatusChangeListener"));
                DownloadController downloadControllerUj = uj(iIntValue);
                if (downloadControllerUj == null) {
                    downloadControllerUj = a(map.get("downloadController"));
                }
                com.byazt.su.tt ttVarVe = ve(map.get("marketStatusChangeListener"));
                if (ttVarVe != null && (downloadControllerUj instanceof AdDownloadController)) {
                    ((AdDownloadController) downloadControllerUj).setMarketStatusChangeListener(ttVarVe);
                }
                z.tt().c(this.tt, iIntValue, downloadStatusChangeListenerTt, downloadModelVe);
                return null;
            case 6:
                return (T) Boolean.valueOf(z.c(this.tt, downloadModelVe == null ? (String) map.get("downloadUrl") : downloadModelVe.getDownloadUrl()));
            case 7:
                z.ve();
                return null;
            case 8:
                z.tt().c(downloadModelVe == null ? (String) map.get("downloadUrl") : downloadModelVe.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                z.c(((Integer) map.get("hid")).intValue(), (ve.c) map.get("onEventLogHandler"));
                return null;
            case 10:
                z.c((String) map.get("downloadPath"));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case 138:
            case 155:
            case 156:
            case 159:
            case 161:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get("uri");
                if (downloadModelVe == null) {
                    downloadModelVe = uj(map.get("downloadModel"));
                }
                AdDownloadEventConfig adDownloadEventConfigN = n(iIntValue);
                DownloadEventConfig downloadEventConfigN = adDownloadEventConfigN == null ? n(map.get("downloadEventConfig")) : adDownloadEventConfigN;
                DownloadController downloadControllerUj2 = uj(iIntValue);
                if (downloadControllerUj2 == null) {
                    downloadControllerUj2 = a(map.get("downloadController"));
                }
                Activity activity = getActivity(map.get(TTDownloadField.TT_ACTIVITY));
                Context context = ((downloadControllerUj2 instanceof AdDownloadController) && activity != null && sp(map.get("open_market_in_app"))) ? activity : this.tt;
                IDownloadButtonClickListener iDownloadButtonClickListenerSl = sl(map.get("downloadButtonClickListener"));
                return c(iDownloadButtonClickListenerSl) ? (T) Boolean.valueOf(z.c(context, uri, downloadModelVe, downloadEventConfigN, downloadControllerUj2, iDownloadButtonClickListenerSl)) : (T) Boolean.valueOf(z.c(context, uri, downloadModelVe, downloadEventConfigN, downloadControllerUj2));
            case 13:
                boolean zBooleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get(TRiverConstants.KEY_ENVIRONMENT_USERAGENT);
                if (downloadModelVe == null) {
                    downloadModelVe = uj(map.get("downloadModel"));
                }
                DownloadModel downloadModel = downloadModelVe;
                DownloadEventConfig downloadEventConfigN2 = n(iIntValue);
                if (downloadEventConfigN2 == null) {
                    downloadEventConfigN2 = n(map.get("downloadEventConfig"));
                }
                DownloadController downloadControllerUj3 = uj(iIntValue);
                if (downloadControllerUj3 == null) {
                    downloadControllerUj3 = a(map.get("downloadController"));
                }
                DownloadController downloadController = downloadControllerUj3;
                DownloadStatusChangeListener downloadStatusChangeListenerTt2 = tt(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerSl2 = sl(map.get("downloadButtonClickListener"));
                if (c(iDownloadButtonClickListenerSl2)) {
                    z.tt().n().c(this.tt, str, zBooleanValue, downloadModel, downloadEventConfigN2, downloadController, downloadStatusChangeListenerTt2, iIntValue, iDownloadButtonClickListenerSl2);
                    return null;
                }
                z.tt().n().c(this.tt, str, zBooleanValue, downloadModel, downloadEventConfigN2, downloadController, downloadStatusChangeListenerTt2, iIntValue);
                return null;
            case 14:
                return (T) Boolean.valueOf(z.tt().n().c(this.tt, downloadModelVe == null ? ((Long) map.get("id")).longValue() : downloadModelVe.getId(), downloadModelVe == null ? (String) map.get("logExtra") : downloadModelVe.getLogExtra(), (DownloadStatusChangeListener) null, iIntValue));
            case 15:
                return (T) Boolean.valueOf(z.c((Uri) map.get("uri")));
            case 16:
                String downloadUrl = downloadModelVe == null ? (String) map.get("downloadUrl") : downloadModelVe.getDownloadUrl();
                long jLongValue = downloadModelVe == null ? ((Long) map.get("id")).longValue() : downloadModelVe.getId();
                int iIntValue2 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig downloadEventConfigN3 = n(iIntValue);
                if (downloadEventConfigN3 == null) {
                    downloadEventConfigN3 = n(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig = downloadEventConfigN3;
                DownloadController downloadControllerUj4 = uj(iIntValue);
                if (downloadControllerUj4 == null) {
                    downloadControllerUj4 = a(map.get("downloadController"));
                }
                Activity activity2 = getActivity(map.get(TTDownloadField.TT_ACTIVITY));
                boolean zSp = sp(map.get("open_market_in_app"));
                if ((downloadControllerUj4 instanceof AdDownloadController) && activity2 != null && zSp) {
                    ((AdDownloadController) downloadControllerUj4).setWeakActivity(activity2);
                }
                z.tt().c(downloadUrl, jLongValue, iIntValue2, downloadEventConfig, downloadControllerUj4);
                return null;
            case 17:
                String downloadUrl2 = downloadModelVe == null ? (String) map.get("downloadUrl") : downloadModelVe.getDownloadUrl();
                long jLongValue2 = ((Long) map.get("id")).longValue();
                int iIntValue3 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig downloadEventConfigN4 = n(iIntValue);
                if (downloadEventConfigN4 == null) {
                    downloadEventConfigN4 = n(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig2 = downloadEventConfigN4;
                DownloadController downloadControllerUj5 = uj(iIntValue);
                if (downloadControllerUj5 == null) {
                    downloadControllerUj5 = a(map.get("downloadController"));
                }
                OnItemClickListener onItemClickListenerDa = da(map.get("itemClickListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerSl3 = sl(map.get("downloadButtonClickListener"));
                Activity activity3 = getActivity(map.get(TTDownloadField.TT_ACTIVITY));
                boolean zSp2 = sp(map.get("open_market_in_app"));
                if ((downloadControllerUj5 instanceof AdDownloadController) && activity3 != null && zSp2) {
                    ((AdDownloadController) downloadControllerUj5).setWeakActivity(activity3);
                }
                z.tt().c(downloadUrl2, jLongValue2, iIntValue3, downloadEventConfig2, downloadControllerUj5, onItemClickListenerDa, iDownloadButtonClickListenerSl3);
                return null;
            case 18:
                T t = (T) Boolean.valueOf(z.tt().n().c(downloadModelVe == null ? ((Long) map.get("id")).longValue() : downloadModelVe.getId(), iIntValue));
                c(iIntValue);
                return t;
            case 19:
                return (T) Boolean.valueOf(z.tt().n().c(downloadModelVe == null ? ((Long) map.get("id")).longValue() : downloadModelVe.getId()));
            case 23:
                if (!((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    c(iIntValue, map);
                    return null;
                }
                AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                this.ve.put(Integer.valueOf(iIntValue), builder);
                this.uj.put(Integer.valueOf(iIntValue), builder.build());
                return null;
            case 24:
                c(iIntValue, (String) map.get("appIcon"), (String) map.get("appName"), (String) map.get(ALPParamConstant.PACKAGENAME));
                return null;
            case 25:
                c(iIntValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                return null;
            case 26:
                c(iIntValue, ((Integer) map.get("downloadMode")).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(sp(iIntValue));
            case 28:
                c(iIntValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), i(map.get("downloadMarketInterceptor")));
                return null;
            case 29:
                ve(iIntValue, map);
                return null;
            case 30:
                setDownloadScene(iIntValue, ((Integer) map.get("downloadScene")).intValue());
                return null;
            case 31:
                setIsShowToast(iIntValue, ((Boolean) map.get("isShowToast")).booleanValue());
                return null;
            case 32:
                tt(iIntValue, map);
                return null;
            case 33:
                return (T) Integer.valueOf(getLinkMode(iIntValue));
            case 34:
                return (T) Boolean.valueOf(isEnableBackDialog(iIntValue));
            case 35:
                return (T) Boolean.valueOf(isAddToDownloadManage(iIntValue));
            case 36:
                return (T) getExtraClickOperation(iIntValue);
            case 37:
                return (T) Boolean.valueOf(isEnableMultipleDownload(iIntValue));
            case 38:
                return (T) Integer.valueOf(getDownloadChunkCount(iIntValue));
            case 39:
                return (T) Boolean.valueOf(shouldUseNewWebView(iIntValue));
            case 40:
                return (T) Integer.valueOf(getInterceptFlag(iIntValue));
            case 41:
                return (T) getExtraJson(iIntValue);
            case 42:
                return (T) getExtraObject(iIntValue);
            case 44:
                setLinkMode(iIntValue, ((Integer) map.get("linkMode")).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(enableShowComplianceDialog(iIntValue));
            case 46:
                setEnableShowComplianceDialog(iIntValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(isAutoDownloadOnCardShow(iIntValue));
            case 48:
                return (T) Boolean.valueOf(enableNewActivity(iIntValue));
            case 49:
                setIsAutoDownloadOnCardShow(iIntValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                return null;
            case 50:
                setEnableNewActivity(iIntValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(enableAH(iIntValue));
            case 52:
                return (T) Boolean.valueOf(enableAM(iIntValue));
            case 53:
                setExtraObject(iIntValue, map.get("extraObject"));
                return null;
            case 54:
                setExtraJson(iIntValue, (JSONObject) map.get("extraJson"));
                return null;
            case 55:
                return (T) Boolean.valueOf(enableOppoAutoDownload(iIntValue));
            case 56:
                uj(iIntValue, map);
                return null;
            case 57:
                return (T) String.valueOf(getRefer(iIntValue));
            case 58:
                return (T) String.valueOf(getClickButtonTag(iIntValue));
            case 59:
                return (T) String.valueOf(getClickItemTag(iIntValue));
            case 60:
                return (T) String.valueOf(getClickLabel(iIntValue));
            case 61:
                return (T) String.valueOf(getClickStartLabel(iIntValue));
            case 62:
                return (T) String.valueOf(getClickPauseLabel(iIntValue));
            case 63:
                return (T) String.valueOf(getClickContinueLabel(iIntValue));
            case 64:
                return (T) String.valueOf(getClickInstallLabel(iIntValue));
            case 65:
                return (T) String.valueOf(getStorageDenyLabel(iIntValue));
            case 66:
                return (T) getExtraEventObject(iIntValue);
            case 67:
                return (T) Integer.valueOf(getDownloadScene(iIntValue));
            case 68:
                return (T) Boolean.valueOf(isEnableClickEvent(iIntValue));
            case 69:
                return (T) Boolean.valueOf(isEnableV3Event(iIntValue));
            case 70:
                return (T) getEventConfigExtraJson(iIntValue);
            case 71:
                return (T) getParamsJson(iIntValue);
            case 72:
                setExtraEventObject(iIntValue, map.get("extraEventObject"));
                return null;
            case 73:
                setClickButtonTag(iIntValue, (String) map.get("clickButtonTag"));
                return null;
            case 74:
                setEventConfigExtraJson(iIntValue, (JSONObject) map.get("eventConfigExtraJson"));
                return null;
            case 75:
                setParamsJson(iIntValue, (JSONObject) map.get("paramsJson"));
                return null;
            case 76:
                setClickItemTag(iIntValue, (String) map.get("clickItemTag"));
                return null;
            case 78:
                setRefer(iIntValue, (String) map.get("refer"));
                return null;
            case 79:
                setQuickAppEventTag(iIntValue, (String) map.get("quickAppEventTag"));
                return null;
            case 80:
                n(iIntValue, map);
                return null;
            case 81:
                return (T) Long.valueOf(getId(iIntValue));
            case 82:
                return (T) String.valueOf(getMd5(iIntValue));
            case 83:
                return (T) Long.valueOf(getExpectFileLength(iIntValue));
            case 84:
                return (T) Long.valueOf(getExtraValue(iIntValue));
            case 85:
                return (T) String.valueOf(getDownloadUrl(iIntValue));
            case 86:
                return (T) getBackupUrls(iIntValue);
            case 87:
                return (T) String.valueOf(getNotificationJumpUrl(iIntValue));
            case 88:
                return (T) String.valueOf(getName(iIntValue));
            case 89:
                return (T) String.valueOf(getMimeType(iIntValue));
            case 90:
                return (T) getHeaders(iIntValue);
            case 91:
                return (T) Boolean.valueOf(isShowToast(iIntValue));
            case 92:
                return (T) Boolean.valueOf(isShowNotification(iIntValue));
            case 93:
                return (T) Boolean.valueOf(isNeedWifi(iIntValue));
            case 94:
                return (T) Boolean.valueOf(isInExternalPublicDir(iIntValue));
            case 95:
                return (T) Boolean.valueOf(isVisibleInDownloadsUi(iIntValue));
            case 96:
                return (T) String.valueOf(getFilePath(iIntValue));
            case 97:
                return (T) String.valueOf(getFileName(iIntValue));
            case 98:
                forceWifi(iIntValue);
                return null;
            case 99:
                return (T) getDownloadSettings(iIntValue);
            case 100:
                forceHideToast(iIntValue);
                return null;
            case 101:
                forceHideNotification(iIntValue);
                return null;
            case 102:
                return (T) Boolean.valueOf(needIndependentProcess(iIntValue));
            case 103:
                return (T) Integer.valueOf(getVersionCode(iIntValue));
            case 104:
                return (T) String.valueOf(getVersionName(iIntValue));
            case 105:
                return (T) Boolean.valueOf(isAd(iIntValue));
            case 106:
                return (T) String.valueOf(getLogExtra(iIntValue));
            case 107:
                return (T) String.valueOf(getPackageName(iIntValue));
            case 108:
                return (T) String.valueOf(getAppIcon(iIntValue));
            case 109:
                return (T) getDeepLink(iIntValue);
            case 110:
                return (T) getClickTrackUrl(iIntValue);
            case 111:
                return (T) getExtra(iIntValue);
            case 112:
                return (T) Integer.valueOf(getModelType(iIntValue));
            case 113:
                return (T) getQuickAppModel(iIntValue);
            case 114:
                return (T) Boolean.valueOf(autoInstallWithoutNotification(iIntValue));
            case 115:
                return (T) Boolean.valueOf(shouldDownloadWithPatchApply(iIntValue));
            case 116:
                return (T) Integer.valueOf(getExecutorGroup(iIntValue));
            case 117:
                return (T) Integer.valueOf(getFunnelType(iIntValue));
            case 118:
                return (T) String.valueOf(getStartToast(iIntValue));
            case 119:
                return (T) String.valueOf(getSdkMonitorScene(iIntValue));
            case 120:
                return (T) Boolean.valueOf(isAutoInstall(iIntValue));
            case 121:
                return (T) Boolean.valueOf(distinctDir(iIntValue));
            case 122:
                return (T) Boolean.valueOf(enablePause(iIntValue));
            case 123:
                setMd5(iIntValue, (String) map.get(TKDownloadReason.KSAD_TK_MD5));
                return null;
            case 124:
                setExpectFileLength(iIntValue, ((Long) map.get("expectFileLength")).longValue());
                return null;
            case 125:
                setNeedWifi(iIntValue, ((Boolean) map.get("needWifi")).booleanValue());
                return null;
            case 127:
                setExtraValue(iIntValue, ((Long) map.get("extraValue")).longValue());
                return null;
            case 128:
                setAppName(iIntValue, (String) map.get("appName"));
                return null;
            case 129:
                setExtra(iIntValue, (JSONObject) map.get("extraJson"));
                return null;
            case 130:
                setStartToast(iIntValue, (String) map.get("startToast"));
                return null;
            case 131:
                setSdkMonitorScene(iIntValue, (String) map.get("sdkMonitorScene"));
                return null;
            case 132:
                setId(iIntValue, ((Long) map.get("id")).longValue());
                return null;
            case 133:
                setIsAd(iIntValue, ((Boolean) map.get("isAd")).booleanValue());
                return null;
            case 134:
                setModelType(iIntValue, ((Integer) map.get("modelType")).intValue());
                return null;
            case 135:
                setLogExtra(iIntValue, (String) map.get("logExtra"));
                return null;
            case 136:
                setPackageName(iIntValue, (String) map.get(ALPParamConstant.PACKAGENAME));
                return null;
            case 137:
                setAppIcon(iIntValue, (String) map.get("appIcon"));
                return null;
            case 139:
                setClickTrackUrl(iIntValue, (List) map.get("clickTrackUrl"));
                return null;
            case 140:
                setDownloadUrl(iIntValue, (String) map.get("downloadUrl"));
                return null;
            case 141:
                setBackupUrls(iIntValue, (List) map.get("backupUrls"));
                return null;
            case 142:
                setNotificationJumpUrl(iIntValue, (String) map.get("notificationJumpUrl"));
                return null;
            case 143:
                setMimeType(iIntValue, (String) map.get("mimeType"));
                return null;
            case 144:
                setHeaders(iIntValue, (Map) map.get("headers"));
                return null;
            case 145:
                setIsShowNotification(iIntValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                return null;
            case 146:
                setFilePath(iIntValue, (String) map.get("filePath"));
                return null;
            case 147:
                setFileName(iIntValue, (String) map.get("fileName"));
                return null;
            case 148:
                setNeedIndependentProcess(iIntValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                return null;
            case 149:
                setVersionCode(iIntValue, ((Integer) map.get("versionCode")).intValue());
                return null;
            case 150:
                setVersionName(iIntValue, (String) map.get("versionName"));
                return null;
            case 151:
                setQuickAppModel(iIntValue, new com.byazt.e.uj.c().c((String) map.get("quickAppModelOpenUrl")).tt((String) map.get("quickAppModelExtraData")).c());
                return null;
            case 152:
                setAutoInstallWithoutNotification(iIntValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                return null;
            case 153:
                setFunnelType(iIntValue, ((Integer) map.get("funnelType")).intValue());
                return null;
            case 154:
                c(iIntValue, i(map.get("downloadMarketInterceptor")));
                return null;
            case 157:
                Object obj2 = map.get("s");
                if (obj2 instanceof Service) {
                    com.byazt.zz.ve.c((Context) obj2);
                }
                return null;
            case 158:
                try {
                    Object obj3 = map.get("i");
                    map.get("c");
                    if (obj3 instanceof Intent) {
                        if (TextUtils.equals(((Intent) obj3).getAction(), "com.csj.install")) {
                            c((Intent) obj3);
                        } else {
                            ((Intent) obj3).setComponent(new ComponentName(com.byazt.zz.ve.ic(), (Class<?>) DownloadHandlerService.class));
                            com.byazt.zz.ve.ic().startService((Intent) obj3);
                        }
                    }
                    break;
                } catch (Exception e) {
                    com.byazt.ukr.yp.c().c("start_service", e);
                }
                return null;
            case 160:
                c(map);
                return null;
            case 162:
                Object obj4 = map.get(ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
                if (obj4 instanceof com.byazt.ocd.tt) {
                    z.c((com.byazt.ocd.tt) obj4);
                }
                return null;
        }
    }

    public boolean distinctDir(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return false;
        }
        return adDownloadModelVe.distinctDir();
    }

    public boolean enableAH(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.enableAH();
    }

    public boolean enableAM(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.enableAM();
    }

    public boolean enableNewActivity(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.enableNewActivity();
    }

    public boolean enableOppoAutoDownload(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.enableOppoAutoDownload();
    }

    public boolean enablePause(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return true;
        }
        return adDownloadModelVe.enablePause();
    }

    public boolean enableShowComplianceDialog(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.enableShowComplianceDialog();
    }

    public void forceHideNotification(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.forceHideNotification();
    }

    public void forceHideToast(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.forceHideToast();
    }

    public void forceWifi(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.forceWifi();
    }

    public String getAppIcon(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getAppIcon();
    }

    public List<String> getBackupUrls(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getBackupUrls();
    }

    public String getClickButtonTag(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickButtonTag();
    }

    public String getClickContinueLabel(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickPauseLabel();
    }

    public String getClickInstallLabel(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickInstallLabel();
    }

    public String getClickItemTag(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickItemTag();
    }

    public String getClickLabel(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickLabel();
    }

    public String getClickPauseLabel(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickPauseLabel();
    }

    public String getClickStartLabel(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getClickStartLabel();
    }

    public List<String> getClickTrackUrl(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getClickTrackUrl();
    }

    public DeepLink getDeepLink(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getDeepLink();
    }

    public int getDownloadChunkCount(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return 1;
        }
        return adDownloadControllerUj.getDowloadChunkCount();
    }

    public int getDownloadScene(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return 0;
        }
        return adDownloadEventConfigN.getDownloadScene();
    }

    public JSONObject getDownloadSettings(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getDownloadSettings();
    }

    public String getDownloadUrl(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getDownloadUrl();
    }

    public JSONObject getEventConfigExtraJson(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return null;
        }
        return adDownloadEventConfigN.getExtraJson();
    }

    public int getExecutorGroup(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 2;
        }
        return adDownloadModelVe.getExecutorGroup();
    }

    public long getExpectFileLength(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 0L;
        }
        return adDownloadModelVe.getExpectFileLength();
    }

    public JSONObject getExtra(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getExtra();
    }

    public Object getExtraClickOperation(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return null;
        }
        return adDownloadControllerUj.getExtraClickOperation();
    }

    public Object getExtraEventObject(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return null;
        }
        return adDownloadEventConfigN.getExtraEventObject();
    }

    public JSONObject getExtraJson(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return null;
        }
        return adDownloadControllerUj.getExtraJson();
    }

    public Object getExtraObject(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return null;
        }
        return adDownloadControllerUj.getExtraObject();
    }

    public long getExtraValue(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 0L;
        }
        return adDownloadModelVe.getExtraValue();
    }

    public String getFileName(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getFileName();
    }

    public String getFilePath(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getFilePath();
    }

    public int getFunnelType(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 1;
        }
        return adDownloadModelVe.getFunnelType();
    }

    public Map<String, String> getHeaders(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getHeaders();
    }

    public long getId(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 0L;
        }
        return adDownloadModelVe.getId();
    }

    public int getInterceptFlag(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return 0;
        }
        return adDownloadControllerUj.getInterceptFlag();
    }

    public int getLinkMode(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return 0;
        }
        return adDownloadControllerUj.getLinkMode();
    }

    public String getLogExtra(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getLogExtra();
    }

    public String getMd5(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getMd5();
    }

    public String getMimeType(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getMimeType();
    }

    public int getModelType(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 0;
        }
        return adDownloadModelVe.getModelType();
    }

    public String getName(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getName();
    }

    public String getNotificationJumpUrl(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getNotificationJumpUrl();
    }

    public String getPackageName(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getPackageName();
    }

    public JSONObject getParamsJson(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return null;
        }
        return adDownloadEventConfigN.getParamsJson();
    }

    public com.byazt.e.uj getQuickAppModel(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.getQuickAppModel();
    }

    public String getRefer(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getRefer();
    }

    public String getSdkMonitorScene(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getStartToast();
    }

    public String getStartToast(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getStartToast();
    }

    public String getStorageDenyLabel(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        return adDownloadEventConfigN == null ? "" : adDownloadEventConfigN.getStorageDenyLabel();
    }

    public int getVersionCode(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return 0;
        }
        return adDownloadModelVe.getVersionCode();
    }

    public String getVersionName(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? "" : adDownloadModelVe.getVersionName();
    }

    public void init(Bundle bundle) {
        z.c(this.tt);
        c();
    }

    public boolean isAd(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return true;
        }
        return adDownloadModelVe.isAd();
    }

    public boolean isAddToDownloadManage(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.isAddToDownloadManage();
    }

    public boolean isAutoDownloadOnCardShow(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.isAutoDownloadOnCardShow();
    }

    public boolean isAutoInstall(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return true;
        }
        return adDownloadModelVe.isAutoInstall();
    }

    public boolean isEnableBackDialog(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.isEnableBackDialog();
    }

    public boolean isEnableClickEvent(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return true;
        }
        return adDownloadEventConfigN.isEnableClickEvent();
    }

    public boolean isEnableMultipleDownload(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.isEnableMultipleDownload();
    }

    public boolean isEnableV3Event(int i) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return false;
        }
        return adDownloadEventConfigN.isEnableV3Event();
    }

    public boolean isInExternalPublicDir(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return false;
        }
        return adDownloadModelVe.isInExternalPublicDir();
    }

    public boolean isNeedWifi(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return false;
        }
        return adDownloadModelVe.isNeedWifi();
    }

    public boolean isShowNotification(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return true;
        }
        return adDownloadModelVe.isShowNotification();
    }

    public boolean isShowToast(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return true;
        }
        return adDownloadModelVe.isShowToast();
    }

    public boolean isVisibleInDownloadsUi(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return false;
        }
        return adDownloadModelVe.isInExternalPublicDir();
    }

    public boolean needIndependentProcess(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return false;
        }
        return adDownloadModelVe.needIndependentProcess();
    }

    @Deprecated
    public AdDownloadModel setAdId(int i, long j) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setAdId(j);
    }

    public AdDownloadModel setAppIcon(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setAppIcon(str);
    }

    public void setAppName(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setAppName(str);
    }

    public AdDownloadModel setAutoInstallWithoutNotification(int i, boolean z) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel setBackupUrls(int i, List<String> list) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setBackupUrls(list);
    }

    public void setClickButtonTag(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setClickButtonTag(str);
    }

    public void setClickItemTag(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setClickItemTag(str);
    }

    public AdDownloadModel setClickTrackUrl(int i, List<String> list) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setClickTrackUrl(list);
    }

    public AdDownloadModel setDeepLink(int i, DeepLink deepLink) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setDeepLink(deepLink);
    }

    public void setDownloadScene(int i, int i2) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setDownloadScene(i2);
    }

    public AdDownloadModel setDownloadUrl(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setDownloadUrl(str);
    }

    public void setEnableNewActivity(int i, boolean z) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (this.f28412a == null) {
            return;
        }
        adDownloadControllerUj.setEnableNewActivity(z);
    }

    public void setEnableShowComplianceDialog(int i, boolean z) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setEnableShowComplianceDialog(z);
    }

    public void setEventConfigExtraJson(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setExtraJson(jSONObject);
    }

    public void setExpectFileLength(int i, long j) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setExpectFileLength(j);
    }

    public void setExtra(int i, JSONObject jSONObject) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setExtra(jSONObject);
    }

    public void setExtraEventObject(int i, Object obj) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setExtraEventObject(obj);
    }

    public void setExtraJson(int i, JSONObject jSONObject) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setExtraJson(jSONObject);
    }

    public void setExtraObject(int i, Object obj) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setExtraObject(obj);
    }

    public void setExtraValue(int i, long j) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setExtraValue(j);
    }

    public AdDownloadModel setFileName(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setFileName(str);
    }

    public AdDownloadModel setFilePath(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setFilePath(str);
    }

    public AdDownloadModel setFileUriProvider(int i, IDownloadFileUriProvider iDownloadFileUriProvider) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setFileUriProvider(iDownloadFileUriProvider);
    }

    public AdDownloadModel setFunnelType(int i, int i2) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setFunnelType(i2);
    }

    public AdDownloadModel setHeaders(int i, Map<String, String> map) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setHeaders(map);
    }

    public AdDownloadModel setId(int i, long j) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setId(j);
    }

    public AdDownloadModel setIsAd(int i, boolean z) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setIsAd(z);
    }

    public void setIsAutoDownloadOnCardShow(int i, boolean z) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setIsAutoDownloadOnCardShow(z);
    }

    public AdDownloadModel setIsShowNotification(int i, boolean z) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setIsShowNotification(z);
    }

    public void setIsShowToast(int i, boolean z) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setIsShowToast(z);
    }

    public void setLinkMode(int i, int i2) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setLinkMode(i2);
    }

    public AdDownloadModel setLogExtra(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setLogExtra(str);
    }

    public void setMd5(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setMd5(str);
    }

    public AdDownloadModel setMimeType(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setMimeType(str);
    }

    public AdDownloadModel setModelType(int i, int i2) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setModelType(i2);
    }

    public AdDownloadModel setNeedIndependentProcess(int i, boolean z) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setNeedIndependentProcess(z);
    }

    public void setNeedWifi(int i, boolean z) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setNeedWifi(z);
    }

    public AdDownloadModel setNotificationJumpUrl(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setNotificationJumpUrl(str);
    }

    public AdDownloadModel setPackageName(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setPackageName(str);
    }

    public void setParamsJson(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setParamsJson(jSONObject);
    }

    public void setQuickAppEventTag(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setQuickAppEventTag(str);
    }

    public AdDownloadModel setQuickAppModel(int i, com.byazt.e.uj ujVar) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setQuickAppModel(ujVar);
    }

    public void setRefer(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigN = n(i);
        if (adDownloadEventConfigN == null) {
            return;
        }
        adDownloadEventConfigN.setRefer(str);
    }

    public void setSdkMonitorScene(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setSdkMonitorScene(str);
    }

    public void setStartToast(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return;
        }
        adDownloadModelVe.setStartToast(str);
    }

    public AdDownloadModel setVersionCode(int i, int i2) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setVersionCode(i2);
    }

    public AdDownloadModel setVersionName(int i, String str) {
        AdDownloadModel adDownloadModelVe = ve(i);
        if (adDownloadModelVe == null) {
            return null;
        }
        return adDownloadModelVe.setVersionName(str);
    }

    public boolean shouldDownloadWithPatchApply(int i) {
        AdDownloadModel adDownloadModelVe = ve(i);
        return adDownloadModelVe == null ? com.byazt.ki.tt.c(com.byazt.k.c.c(getDownloadSettings(i)), getMimeType(i)) : adDownloadModelVe.shouldDownloadWithPatchApply();
    }

    public boolean shouldUseNewWebView(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return false;
        }
        return adDownloadControllerUj.shouldUseNewWebView();
    }

    public PluginValueSet values() {
        return com.byazt.rl.c.c().c(0, z.c).c(1, Boolean.valueOf(z.tt)).c(10000, 3).tt();
    }

    private DownloadEventConfig n(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private static boolean tt() {
        try {
            try {
                Field declaredField = com.byazt.di.uj.class.getDeclaredField("tt");
                declaredField.setAccessible(true);
                return declaredField.get(null) instanceof Integer;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Field declaredField2 = com.byazt.di.uj.class.getDeclaredField("c");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(null);
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                return iIntValue > 107000925 || (iIntValue <= 4061200 && iIntValue > 3000000);
            }
        }
    }

    private DownloadModel uj(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private com.byazt.su.tt ve(Object obj) {
        if (obj instanceof com.byazt.su.tt) {
            return (com.byazt.su.tt) obj;
        }
        return null;
    }

    private int sp(int i) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return 0;
        }
        return adDownloadControllerUj.getDownloadMode();
    }

    private void n(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long jLongValue = ((Long) map.get("expectFileLength")).longValue();
        String str = (String) map.get(TKDownloadReason.KSAD_TK_MD5);
        long jLongValue2 = ((Long) map.get("extraValue")).longValue();
        boolean zBooleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int iIntValue = ((Integer) map.get("modelType")).intValue();
        List<String> list = (List) map.get("clickTrackUrl");
        List<String> list2 = (List) map.get("backupUrls");
        String str2 = (String) map.get("notificationJumpUrl");
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean zBooleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str4 = (String) map.get("fileName");
        int iIntValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get("versionName");
        String str6 = (String) map.get("quickAppModelOpenUrl");
        com.byazt.e.uj ujVarC = new com.byazt.e.uj.c().c(str6).tt((String) map.get("quickAppModelExtraData")).c();
        int iIntValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str7 = (String) map.get("startToast");
        String str8 = (String) map.get("sdkMonitorScene");
        boolean zBooleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long jLongValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get("appIcon");
        boolean zBooleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        String str10 = (String) map.get("logExtra");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get("downloadUrl");
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get(ALPParamConstant.PACKAGENAME);
        boolean zBooleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str15 = (String) map.get("openUrl");
        String str16 = (String) map.get("webTitle");
        String str17 = (String) map.get("webUrl");
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(jLongValue).setMd5(str).setId(jLongValue3).setExtraValue(jLongValue2).setIsAd(zBooleanValue).setModelType(iIntValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(zBooleanValue2).setIsShowNotification(zBooleanValue7).setNeedWifi(zBooleanValue3).setFileName(str4).setVersionCode(iIntValue2).setVersionName(str5).setQuickAppModel(ujVarC).setAutoInstallWithoutNotification(zBooleanValue8).setExecutorGroup(iIntValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(zBooleanValue4).setDistinctDir(zBooleanValue5).setEnablePause(zBooleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.byazt.dk.m.2
            @Override // com.byazt.c.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return m.this.c(str18, str19);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(zBooleanValue9);
        fileUriProvider.setDeepLink(c(jLongValue3, str15, str16, str17));
        this.ve.put(Integer.valueOf(i), fileUriProvider);
        this.uj.put(Integer.valueOf(i), fileUriProvider.build());
    }

    private void uj(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickLabel");
        int iIntValue = ((Integer) map.get("downloadScene")).intValue();
        String str4 = (String) map.get("refer");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("paramsJson");
        String str5 = (String) map.get("clickStartLabel");
        String str6 = (String) map.get("clickContinueLabel");
        String str7 = (String) map.get("clickPauseLabel");
        String str8 = (String) map.get("storageDenyLabel");
        String str9 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(zBooleanValue).setDownloadScene(iIntValue).setIsEnableV3Event(zBooleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.sp.put(Integer.valueOf(i), paramsJson);
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.x.put(Integer.valueOf(i), paramsJson.build());
    }

    private void ve(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickStartLabel");
        String str4 = (String) map.get("clickContinueLabel");
        String str5 = (String) map.get("clickPauseLabel");
        String str6 = (String) map.get("storageDenyLabel");
        String str7 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(zBooleanValue).setIsEnableV3Event(zBooleanValue2);
        this.sp.put(Integer.valueOf(i), isEnableV3Event);
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.x.put(Integer.valueOf(i), isEnableV3Event.build());
    }

    private void c(int i) {
        this.ve.remove(Integer.valueOf(i));
        this.uj.remove(Integer.valueOf(i));
        this.n.remove(Integer.valueOf(i));
        this.f28412a.remove(Integer.valueOf(i));
        this.sp.remove(Integer.valueOf(i));
        this.x.remove(Integer.valueOf(i));
    }

    private DownloadStatusChangeListener tt(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    private void tt(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int iIntValue = ((Integer) map.get("linkMode")).intValue();
        int iIntValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean zBooleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        map.get("extraOperation");
        boolean zBooleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int iIntValue3 = ((Integer) map.get("interceptFlag")).intValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        Object obj = map.get("extraObject");
        boolean zBooleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean zBooleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(iIntValue).setDownloadMode(iIntValue2).setIsEnableBackDialog(zBooleanValue).setIsAddToDownloadManage(zBooleanValue2).setShouldUseNewWebView(zBooleanValue3).setInterceptFlag(iIntValue3).setExtraJson(jSONObject).setExtraObject(obj).setEnableShowComplianceDialog(zBooleanValue4).setIsAutoDownloadOnCardShow(zBooleanValue5).setEnableNewActivity(zBooleanValue6).setEnableAH(zBooleanValue7).setEnableAM(zBooleanValue8).setEnableOppoAutoDownload(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.n.put(Integer.valueOf(i), enableOppoAutoDownload);
        this.f28412a.put(Integer.valueOf(i), enableOppoAutoDownload.build());
    }

    private void c(Intent intent) {
        String str;
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean zTt = nb.tt(stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.tt.getSystemService("notification");
        com.byazt.qt.c cVar = new com.byazt.qt.c();
        cVar.sp(stringExtra);
        cVar.uj(stringExtra2);
        cVar.ve(stringExtra3);
        String str2 = "success";
        if (zTt) {
            com.byazt.hu.i.c(stringExtra3);
            str = "open";
        } else {
            str2 = com.byazt.z.uj.c(this.tt, intExtra) ? "success" : "failure";
            str = "install";
        }
        com.byazt.yih.n.c("notification", cVar, str, "click_other", null, str2);
        notificationManager.cancel(a(intExtra));
    }

    private void c(int i, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setDownloadMarketInterceptor(downloadMarketInterceptor);
    }

    private static boolean c(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            return false;
        }
        if (TextUtils.equals(p.x, "internal")) {
            return tt();
        }
        return true;
    }

    private AdDownloadModel.Builder c(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.byazt.dk.m.1
            @Override // com.byazt.c.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return m.this.c(str10, str11);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(c(j, str7, str8, str9));
        return fileUriProvider;
    }

    private void c(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> functionC = c();
        if (functionC == null) {
            com.byazt.nr.m.uj("xgc_dl", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            return;
        }
        try {
            Map map2 = (Map) functionC.apply(com.byazt.yxi.uj.c().c(161).c(Map.class).c(0, map).tt());
            if (map2 != null) {
                Notification notification = (Notification) map2.get("notification");
                NotificationManager notificationManager = (NotificationManager) gt.getContext().getSystemService("notification");
                Object obj = map.get("install_download_id");
                notificationManager.notify(a(obj instanceof Integer ? ((Integer) obj).intValue() : 0), notification);
            }
        } catch (Throwable th) {
            com.byazt.nr.m.uj("xgc_dl", "e:" + th.getMessage());
            com.byazt.ukr.yp.c().c("csj_install_notification", th);
        }
    }

    public Map<String, Object> c(Object obj) {
        HashMap map = new HashMap();
        map.put("params", obj);
        Function<SparseArray<Object>, Object> functionC = c();
        if (functionC == null) {
            return null;
        }
        return (Map) functionC.apply(com.byazt.yxi.uj.c().c(156).c(Map.class).c(0, map).tt());
    }

    public Uri c(String str, String str2) {
        HashMap map = new HashMap();
        map.put("custom_authority", str);
        map.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> functionC = c();
        if (functionC == null) {
            return null;
        }
        return (Uri) functionC.apply(com.byazt.yxi.uj.c().c(155).c(Uri.class).c(0, map).tt());
    }

    private DeepLink c(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void c(int i, String str, String str2, String str3) {
        AdDownloadModel.Builder builderTt = tt(i);
        if (builderTt == null) {
            return;
        }
        this.uj.put(Integer.valueOf(i), builderTt.setAppIcon(str).setAppName(str2).setPackageName(str3).build());
    }

    private void c(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder builderC = c(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get(ALPParamConstant.PACKAGENAME), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.ve.put(Integer.valueOf(i), builderC);
        this.uj.put(Integer.valueOf(i), builderC.build());
    }

    private void c(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.n.put(Integer.valueOf(i), isAddToDownloadManage);
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            isAddToDownloadManage.setEnableAM(z3);
        }
        this.f28412a.put(Integer.valueOf(i), isAddToDownloadManage.build());
    }

    private void c(int i, int i2) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        adDownloadControllerUj.setDownloadMode(i2);
    }

    private void c(int i, boolean z, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerUj = uj(i);
        if (adDownloadControllerUj == null) {
            return;
        }
        try {
            adDownloadControllerUj.setDownloadMarketInterceptor(downloadMarketInterceptor);
            adDownloadControllerUj.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }
}
