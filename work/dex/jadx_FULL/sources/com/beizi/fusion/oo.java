package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.Configurator;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class oo {
    public static String a(Context context, String str, EventBean eventBean) {
        RequestInfo requestInfo = RequestInfo.getInstance(context);
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        DevInfo devInfo = requestInfo.getDevInfo();
        EnvInfo envInfo = requestInfo.getEnvInfo();
        if (eventBean != null) {
            try {
                if (!TextUtils.isEmpty(eventBean.getSessionID())) {
                    str = str.replace("__SESSIONID__", eventBean.getSessionID());
                }
                if (!TextUtils.isEmpty(eventBean.getReqId())) {
                    str = str.replace("__EVENTID__", eventBean.getReqId());
                }
                if (!TextUtils.isEmpty(eventBean.getEventCode())) {
                    str = str.replace("__EVENTCODE__", eventBean.getEventCode());
                }
                if (!TextUtils.isEmpty(eventBean.getAdType())) {
                    str = str.replace("__ADTYPE__", eventBean.getAdType());
                }
                if (!TextUtils.isEmpty(eventBean.getAppId())) {
                    str = str.replace("__PLATFORMAPPID__", eventBean.getAppId());
                }
                if (!TextUtils.isEmpty(eventBean.getSpaceId())) {
                    str = str.replace("__PLATFORMPACEID__", eventBean.getSpaceId());
                }
                if (!TextUtils.isEmpty(eventBean.getEventTime())) {
                    str = str.replace("__EVENTTIME__", eventBean.getEventTime());
                }
                if (!TextUtils.isEmpty(eventBean.getReserveTime())) {
                    str = str.replace("__RESERVETIME__", eventBean.getReserveTime());
                }
                if (!TextUtils.isEmpty(eventBean.getError())) {
                    str = str.replace("__ERRINFO__", eventBean.getError());
                }
                if (!TextUtils.isEmpty(eventBean.getExtra())) {
                    str = str.replace("__EXTRA__", eventBean.getExtra());
                }
                if (!TextUtils.isEmpty(eventBean.getErrorCode())) {
                    str = str.replace("__ERRORCODE__", eventBean.getErrorCode());
                }
                if (!TextUtils.isEmpty(eventBean.getBeiZiBaseId())) {
                    str = str.replace("__BASEID__", eventBean.getBeiZiBaseId());
                }
                if (!TextUtils.isEmpty(String.valueOf(eventBean.getBeiZiSrcType()))) {
                    str = str.replace("__SRCTYPE__", String.valueOf(eventBean.getBeiZiSrcType()));
                }
                if (!TextUtils.isEmpty(eventBean.getBeiZiPrice())) {
                    str = str.replace("__PRICE__", eventBean.getBeiZiPrice());
                }
                if (!TextUtils.isEmpty(eventBean.getBidPrice())) {
                    str = str.replace("__BIDPRICE__", eventBean.getBidPrice());
                }
                if (!TextUtils.isEmpty(eventBean.getBuyerId())) {
                    str = str.replace("__BUYERID__", eventBean.getBuyerId());
                }
                if (!TextUtils.isEmpty(eventBean.getBuyerAppId())) {
                    str = str.replace("__BUYERAPPID__", eventBean.getBuyerAppId());
                }
                if (!TextUtils.isEmpty(eventBean.getBuyerSpaceId())) {
                    str = str.replace("__BUYERSPACEID__", eventBean.getBuyerSpaceId());
                }
                if (!TextUtils.isEmpty(eventBean.getForwardId())) {
                    str = str.replace("__FORWARDID__", eventBean.getForwardId());
                }
                if (!TextUtils.isEmpty(eventBean.getParentId())) {
                    str = str.replace("__PARENTFORWARDID__", eventBean.getParentId());
                }
                if (!TextUtils.isEmpty(eventBean.getLevel())) {
                    str = str.replace("__FORWARDLEVEL__", eventBean.getLevel());
                }
                if (!TextUtils.isEmpty(eventBean.getBuyerSpaceUuId())) {
                    str = str.replace("__BUYERSPACEUUID__", eventBean.getBuyerSpaceUuId());
                }
                if (!TextUtils.isEmpty(eventBean.getSkipType())) {
                    str = str.replace("__SKIPTYPE__", eventBean.getSkipType());
                }
                if (!TextUtils.isEmpty(eventBean.getClickType())) {
                    str = str.replace("__CLICKTYPE__", eventBean.getClickType());
                }
                if (!TextUtils.isEmpty(eventBean.getGdtVersion())) {
                    str = str.replace("__GDTVERSION__", eventBean.getGdtVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getCsjVersion())) {
                    str = str.replace("__CSJVERSION__", eventBean.getCsjVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getKsVersion())) {
                    str = str.replace("__KSVERSION__", eventBean.getKsVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getBaiduVersion())) {
                    str = str.replace("__BAIDUVERSION__", eventBean.getBaiduVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getImbVersion())) {
                    str = str.replace("__INMOBIVERSION__", eventBean.getImbVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getGmVersion())) {
                    str = str.replace("__GMADVERSION__", eventBean.getGmVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getJdVersion())) {
                    str = str.replace("__JADYUNVERSION__", eventBean.getJdVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getMtgVersion())) {
                    str = str.replace("__MTGVERSION__", eventBean.getMtgVersion());
                }
                if (!TextUtils.isEmpty(eventBean.getComponentSsid())) {
                    str = str.replace("__COMPONENTSSID__", eventBean.getComponentSsid());
                }
                if (!TextUtils.isEmpty(eventBean.getBzComponentSsid())) {
                    str = str.replace("__BZCOMPONENTSSID__", eventBean.getBzComponentSsid());
                }
                if (!TextUtils.isEmpty(eventBean.getPlatformFilterSsid())) {
                    str = str.replace("__PLATFORMFILTERSSID__", eventBean.getPlatformFilterSsid());
                }
                if (!TextUtils.isEmpty(eventBean.getChannelFilterSsid())) {
                    str = str.replace("__CHANNELFILTERSSID__", eventBean.getChannelFilterSsid());
                }
                if (!TextUtils.isEmpty(eventBean.getRenderViewSsid())) {
                    str = str.replace("__RENDERVIEWSSID__", eventBean.getRenderViewSsid());
                }
                if (!TextUtils.isEmpty(eventBean.getScrollClickUuid())) {
                    str = str.replace("__SCROLLCLICKUUID__", eventBean.getScrollClickUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getShakeViewUuid())) {
                    str = str.replace("__SHAKEVIEWUUID__", eventBean.getShakeViewUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getRegionalClickUuid())) {
                    str = str.replace("__REGIONALCLICKUUID__", eventBean.getRegionalClickUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getFullScreenClickUuid())) {
                    str = str.replace("__FULLSCREENCLICKUUID__", eventBean.getFullScreenClickUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getRollViewUuid())) {
                    str = str.replace("__ROLLVIEWUUID__", eventBean.getRollViewUuid());
                }
                String isClickEye = eventBean.getIsClickEye();
                if (!TextUtils.isEmpty(isClickEye)) {
                    str = str.replace("__ZOOMOUTAD__", isClickEye);
                }
                if (!TextUtils.isEmpty(eventBean.getCallBackStrategyUuid())) {
                    str = str.replace("__BACKSTRATEGYUUID__", eventBean.getCallBackStrategyUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getDislikeUuid())) {
                    str = str.replace("__DISLIKEUUID__", eventBean.getDislikeUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getEulerAngleUuid())) {
                    str = str.replace("__EULERANGLEUUID__", eventBean.getEulerAngleUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getComplain())) {
                    String eventCode = eventBean.getEventCode();
                    if (!TextUtils.isEmpty(eventCode) && "290.500".equals(eventCode)) {
                        str = str.replace("__COMPLAIN__", eventBean.getComplain());
                    }
                }
                if (!TextUtils.isEmpty(eventBean.getWinPrice())) {
                    String eventCode2 = eventBean.getEventCode();
                    if (!TextUtils.isEmpty(eventCode2) && ("280.260".equals(eventCode2) || "280.270".equals(eventCode2))) {
                        str = str.replace("__WIN_PRICE__", eventBean.getWinPrice());
                    }
                }
                if (!TextUtils.isEmpty(eventBean.getSecondPrice())) {
                    String eventCode3 = eventBean.getEventCode();
                    if (!TextUtils.isEmpty(eventCode3) && "280.260".equals(eventCode3)) {
                        str = str.replace("__SECOND_PRICE__", eventBean.getSecondPrice());
                    }
                }
                if (!TextUtils.isEmpty(eventBean.getAdnId())) {
                    String eventCode4 = eventBean.getEventCode();
                    if (!TextUtils.isEmpty(eventCode4) && ("280.260".equals(eventCode4) || "280.270".equals(eventCode4))) {
                        str = str.replace("__ADN_ID__", eventBean.getAdnId());
                    }
                }
                if (!TextUtils.isEmpty(eventBean.getHighestLossPrice())) {
                    String eventCode5 = eventBean.getEventCode();
                    if (!TextUtils.isEmpty(eventCode5) && "280.260".equals(eventCode5)) {
                        str = str.replace("__HIGHEST_LOSS_PRICE__", eventBean.getHighestLossPrice());
                    }
                }
                if (!TextUtils.isEmpty(eventBean.getLossReason())) {
                    String eventCode6 = eventBean.getEventCode();
                    if (!TextUtils.isEmpty(eventCode6) && "280.270".equals(eventCode6)) {
                        str = str.replace("__LOSS_REASON__", eventBean.getLossReason());
                    }
                }
                if (!TextUtils.isEmpty(eventBean.getIsCacheAd())) {
                    str = str.replace("__IS_CACHE__", eventBean.getIsCacheAd());
                }
                if (!TextUtils.isEmpty(eventBean.getCacheTime())) {
                    str = str.replace("__CACHE_TIME__", eventBean.getCacheTime());
                }
                if (!TextUtils.isEmpty(eventBean.getNativeRuleUuid())) {
                    str = str.replace("__NATIVERULEUUID__", eventBean.getNativeRuleUuid());
                }
                if (!TextUtils.isEmpty(eventBean.getIsImageSpeed())) {
                    str = str.replace("__IS_IMAGE_SPEED__", eventBean.getIsImageSpeed());
                }
                if (!TextUtils.isEmpty(eventBean.getIsFiveVersion())) {
                    str = str.replace("__IS_FIVE_VERSION__", eventBean.getIsFiveVersion());
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("BeiZis", "info:" + e.getMessage());
                return str;
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }
        if (!TextUtils.isEmpty(requestInfo.getAppId())) {
            str = str.replace("__APPID__", requestInfo.getAppId());
        }
        if (!TextUtils.isEmpty(requestInfo.getChannelStr())) {
            str = str.replace("__CHANNELSTRING__", requestInfo.getChannelStr());
        }
        if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
            str = str.replace("__CUSTOMOAID__", requestInfo.getCustomOaid());
        }
        String configVersion = ResponseInfo.getInstance(context).getConfigVersion();
        if (!TextUtils.isEmpty(configVersion)) {
            str = str.replace("__CONFIGVERSION__", configVersion);
        }
        Configurator configurator = ResponseInfo.getInstance(context).getConfigurator();
        if (configurator != null && !TextUtils.isEmpty(configurator.getVersion())) {
            str = str.replace("__CONFIGURATORCONFIGVERSION__", configurator.getVersion());
        }
        Manager manager = ResponseInfo.getInstance(context).getManager();
        if (manager != null && !TextUtils.isEmpty(manager.getConfigVersion())) {
            str = str.replace("__MANAGERCONFIGVERSION__", manager.getConfigVersion());
        }
        Messenger messenger = ResponseInfo.getInstance(context).getMessenger();
        if (messenger != null && !TextUtils.isEmpty(messenger.getConfigVersion())) {
            str = str.replace("__MESSENGERCONFIGVERSION__", messenger.getConfigVersion());
        }
        if (!TextUtils.isEmpty(devInfo.getPlatform())) {
            str = str.replace("__PLATFORM__", devInfo.getPlatform());
        }
        if (!TextUtils.isEmpty(requestInfo.getPackageName())) {
            str = str.replace("__PACKAGENAME__", requestInfo.getPackageName());
        }
        if (!TextUtils.isEmpty(requestInfo.getInstallTime())) {
            str = str.replace("__INSTALLTIME__", requestInfo.getInstallTime());
        }
        if (!TextUtils.isEmpty(requestInfo.getUpdateTime())) {
            str = str.replace("__UPDATETIME__", requestInfo.getUpdateTime()).replace("__UPLOADTIME__", String.valueOf(System.currentTimeMillis()));
        }
        if (!TextUtils.isEmpty(requestInfo.getAppVersion())) {
            str = str.replace("__APPVERSION__", requestInfo.getAppVersion());
        }
        if (!TextUtils.isEmpty(requestInfo.getAppVersionCode())) {
            str = str.replace("__APPVERSIONCODE__", requestInfo.getAppVersionCode());
        }
        if (!TextUtils.isEmpty(requestInfo.getSdkVersion())) {
            str = str.replace("__SDKVERSION__", requestInfo.getSdkVersion());
        }
        if (!TextUtils.isEmpty(devInfo.getSdkUID())) {
            str = str.replace("__SDKUID__", devInfo.getSdkUID());
        }
        if (!TextUtils.isEmpty(devInfo.getSdkUIDOrig())) {
            str = str.replace("__SDKUIDORIG__", devInfo.getSdkUIDOrig());
        }
        if (!TextUtils.isEmpty(devInfo.getOaid())) {
            str = str.replace("__OAID__", devInfo.getOaid());
        } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
            str = str.replace("__OAID__", requestInfo.getCustomOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getHonorOaid())) {
            str = str.replace("__HONOROAID__", devInfo.getHonorOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getGaid())) {
            str = str.replace("__GAID__", devInfo.getGaid());
        }
        if (!TextUtils.isEmpty(devInfo.getSmOaid())) {
            str = str.replace("__SMOAID__", devInfo.getSmOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getCnOaid())) {
            str = str.replace("__CNOAID__", devInfo.getCnOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getMsaOaid())) {
            str = str.replace("__MSAOAID__", devInfo.getMsaOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getOs())) {
            str = str.replace("__OS__", devInfo.getOs());
        }
        if (!TextUtils.isEmpty(devInfo.getDevType())) {
            str = str.replace("__DEVTYPE__", devInfo.getDevType());
        }
        if (!TextUtils.isEmpty(devInfo.getBrand())) {
            str = str.replace("__BRAND__", devInfo.getBrand());
        }
        if (!TextUtils.isEmpty(devInfo.getModel())) {
            str = str.replace("__MODEL__", devInfo.getModel());
        }
        if (!TextUtils.isEmpty(devInfo.getResolution())) {
            str = str.replace("__RESOLUTION__", devInfo.getResolution());
        }
        if (!TextUtils.isEmpty(devInfo.getScreenSize())) {
            str = str.replace("__SCREENSIZE__", devInfo.getScreenSize());
        }
        if (!TextUtils.isEmpty(devInfo.getLanguage())) {
            str = str.replace("__LANGUAGE__", devInfo.getLanguage());
        }
        if (!TextUtils.isEmpty(devInfo.getDensity())) {
            str = str.replace("__DENSITY__", devInfo.getDensity());
        }
        if (!TextUtils.isEmpty(devInfo.getRoot())) {
            str = str.replace("__ROOT__", devInfo.getRoot());
        }
        if (!TextUtils.isEmpty(devInfo.getRomVersion())) {
            str = str.replace("__ROMVERSION__", devInfo.getRomVersion());
        }
        if (!TextUtils.isEmpty(envInfo.getUserAgent())) {
            str = str.replace("__USERAGENT__", envInfo.getUserAgent());
        }
        if (!TextUtils.isEmpty(envInfo.getNet())) {
            str = str.replace("__NET__", envInfo.getNet());
        }
        if (!TextUtils.isEmpty(envInfo.getIsp())) {
            str = str.replace("__ISP__", envInfo.getIsp());
        }
        if (!TextUtils.isEmpty(envInfo.isDeveloperMode())) {
            str = str.replace("__DEVELOPERMODE__", envInfo.isDeveloperMode());
        }
        if (!TextUtils.isEmpty(envInfo.isIsDebugApk())) {
            str = str.replace("__ISDEBUGAPK__", envInfo.isIsDebugApk());
        }
        if (!TextUtils.isEmpty(envInfo.isIsDebugConnected())) {
            str = str.replace("__ISDEBUGCONNECTED__", envInfo.isIsDebugConnected());
        }
        if (!TextUtils.isEmpty(envInfo.isIsWifiProxy())) {
            str = str.replace("__ISWIFIPROXY__", envInfo.isIsWifiProxy());
        }
        AppEventId appEventId = AppEventId.getInstance(context);
        if (appEventId != null) {
            if (!TextUtils.isEmpty(appEventId.getAppStart())) {
                str = str.replace("__APPSTART__", appEventId.getAppStart());
            }
            if (!TextUtils.isEmpty(appEventId.getAppSdkInit())) {
                str = str.replace("__APPSDKINIT__", appEventId.getAppSdkInit());
            }
            if (!TextUtils.isEmpty(appEventId.getAppSplashRequest())) {
                str = str.replace("__APPSPLASHREQUEST__", appEventId.getAppSplashRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppNativeRequest())) {
                str = str.replace("__APPNATIVEREQUEST__", appEventId.getAppNativeRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppRewardedVideoRequest())) {
                str = str.replace("__APPREWARDEDVIDEOREQUEST__", appEventId.getAppRewardedVideoRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppFullScreenVideoRequest())) {
                str = str.replace("__APPFULLSCREENVIDEOREQUEST__", appEventId.getAppFullScreenVideoRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppBannerRequest())) {
                str = str.replace("__APPBANNERREQUEST__", appEventId.getAppBannerRequest());
            }
        }
        if (!TextUtils.isEmpty(envInfo.isIsLockScreen())) {
            str = str.replace("__ISLOCKSCREEN__", envInfo.isIsLockScreen());
        }
        if (!TextUtils.isEmpty(envInfo.isIsVpn())) {
            str = str.replace("__ISVPN__", envInfo.isIsVpn());
        }
        if (!TextUtils.isEmpty(envInfo.isIsSimulator())) {
            str = str.replace("__ISSIMULATOR__", envInfo.isIsSimulator());
        }
        return !TextUtils.isEmpty(requestInfo.getForbidSensor()) ? str.replace("__FORBID_SENSOR__", requestInfo.getForbidSensor()) : str;
    }

    public static String b() {
        return new StringBuilder("BUHDA").reverse().toString();
    }

    public static String a(Context context, String str, EventBean eventBean, String str2) {
        String strA = a(context, str, eventBean);
        try {
            return !TextUtils.isEmpty(str2) ? strA.replace("__APPLINKS__", str2) : strA;
        } catch (Exception e) {
            e.printStackTrace();
            return strA;
        }
    }

    public static String a(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String a() {
        String string = UUID.randomUUID().toString();
        try {
            return a(string);
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
    }

    public static String a(List list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append((String) list.get(i));
            sb.append("\"");
        }
        sb.append("]");
        return sb.toString();
    }
}
