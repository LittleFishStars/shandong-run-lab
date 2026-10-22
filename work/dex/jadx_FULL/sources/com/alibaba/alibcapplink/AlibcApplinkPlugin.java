package com.alibaba.alibcapplink;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.CommonListenerManager;
import com.alibaba.alibcprotocol.base.AlibcEventManager;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.CommonListener;
import com.alibaba.alibcprotocol.base.ICommonListener;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.kwad.components.offline.api.IOfflineCompo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcApplinkPlugin extends AlibcApiPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23553a = "AlibcApplinkPlugin";

    private boolean b(String str, AlibcJsCallback alibcJsCallback) {
        if (AlibcBaseTradeCommon.context == null) {
            alibcJsCallback.fail(buildResult(AlibcJsEnum.PARAM_ERR, null));
            return true;
        }
        try {
            Map<String, Object> mapObj2MapObject = StringUtils.obj2MapObject(JSON.parse(str));
            if (mapObj2MapObject != null) {
                String strObj2String = StringUtils.obj2String(mapObj2MapObject.get("url"));
                HashMap map = new HashMap();
                map.put("url", strObj2String);
                Iterator<Map.Entry<String, ICommonListener>> it = AlibcEventManager.getListenerMap().entrySet().iterator();
                while (it.hasNext()) {
                    ICommonListener value = it.next().getValue();
                    if (value != null) {
                        value.onCallback(AlibcProtocolConstant.NAVIGATE_TO_OUTSIDE_TYPE, map);
                        alibcJsCallback.success(buildResult(AlibcJsEnum.SUCCESS, new HashMap(16)));
                    }
                }
            }
        } catch (Exception e) {
            AlibcLogger.e(f23553a, "parse params exception: " + e.getMessage());
        }
        return true;
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public boolean execute(String str, String str2, final AlibcJsCallback alibcJsCallback) {
        String strObj2String;
        Map<String, Object> mapObj2MapObject;
        String strObj2String2;
        String strObj2String3;
        if (!AlibcSdkManager.getInstance().supportComponent("applink_sdk")) {
            HashMap map = new HashMap(16);
            AlibcJsEnum alibcJsEnum = AlibcJsEnum.FAIL;
            alibcJsEnum.setCode(IOfflineCompo.Priority.HIGHEST);
            alibcJsEnum.setMsg("applink component not support!");
            alibcJsCallback.fail(buildResult(alibcJsEnum, map));
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallback == null) {
            Map<String, Object> mapBuildResult = buildResult(AlibcJsEnum.PARAM_ERR, null);
            if (alibcJsCallback != null) {
                alibcJsCallback.fail(mapBuildResult);
            }
            return false;
        }
        if (!AlibcSdkManager.getInstance().verifySdkExist("applink_sdk")) {
            AlibcLogger.e(f23553a, "applink is not exist!");
            alibcJsCallback.fail(buildResult(AlibcJsEnum.PARAM_ERR, null));
            return false;
        }
        str.hashCode();
        switch (str) {
            case "navigateToOutside":
                return b(str2, alibcJsCallback);
            case "jumpNative":
                Map<String, Object> params = AlibcProtocolUtils.parseParams(str2);
                if (params != null) {
                    strObj2String = StringUtils.obj2String(params.get("type"));
                    mapObj2MapObject = StringUtils.obj2MapObject(params.get("param"));
                    strObj2String2 = StringUtils.obj2String(params.get("url"));
                    strObj2String3 = StringUtils.obj2String(params.get("linkKey"));
                    StringUtils.obj2String(params.get("isNeedConvert"));
                } else {
                    strObj2String = null;
                    mapObj2MapObject = null;
                    strObj2String2 = null;
                    strObj2String3 = null;
                }
                if (TextUtils.isEmpty(strObj2String) || mapObj2MapObject == null) {
                    AlibcLogger.e(f23553a, "解析的参数为空: type = " + strObj2String + ", param = " + mapObj2MapObject);
                    alibcJsCallback.fail(buildResult(AlibcJsEnum.PARAM_ERR, null));
                    return false;
                }
                if (AlibcBaseTradeCommon.context == null) {
                    alibcJsCallback.fail(buildResult(AlibcJsEnum.PARAM_ERR, null));
                    return false;
                }
                HashMap map2 = new HashMap(16);
                map2.put("backUrl", a.a());
                map2.put("module", strObj2String);
                map2.put("clientType", strObj2String3);
                map2.put("degradeType", "Download");
                ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(AlibcTradeContext.getInstance().context, strObj2String2, map2, new AppLinkOpenCallback() { // from class: com.alibaba.alibcapplink.AlibcApplinkPlugin.1
                    @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                    public final void getLinkUrl(boolean z, String str3, String str4, int i) {
                        if (z) {
                            AlibcLogger.i(AlibcApplinkPlugin.f23553a, "唤端成功");
                            HashMap map3 = new HashMap(16);
                            map3.put("degradeUrl", str4);
                            alibcJsCallback.success(AlibcApplinkPlugin.this.buildResult(AlibcJsEnum.SUCCESS, map3));
                            return;
                        }
                        if (i == 310) {
                            AlibcLogger.e(AlibcApplinkPlugin.f23553a, "没有安装手淘: code = " + i);
                        } else {
                            AlibcLogger.e(AlibcApplinkPlugin.f23553a, "唤端失败: code = " + i);
                        }
                        HashMap map4 = new HashMap(16);
                        AlibcJsEnum alibcJsEnum2 = AlibcJsEnum.FAIL;
                        alibcJsEnum2.setCode(i);
                        alibcJsEnum2.setMsg("唤端失败");
                        alibcJsCallback.fail(AlibcApplinkPlugin.this.buildResult(alibcJsEnum2, map4));
                    }

                    @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                    public final void supportFail(String str3, String str4) {
                        AlibcLogger.e(AlibcApplinkPlugin.f23553a, "code = " + str3 + "msg = " + str4);
                    }
                });
                return true;
            case "pushWindow":
                return a(str2, alibcJsCallback);
            default:
                return true;
        }
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public String getPluginTag() {
        return "AliBCAppLink";
    }

    private boolean a(String str, AlibcJsCallback alibcJsCallback) {
        try {
            Map<String, Object> mapObj2MapObject = StringUtils.obj2MapObject(JSON.parse(str));
            if (mapObj2MapObject != null) {
                String strObj2String = StringUtils.obj2String(mapObj2MapObject.get("url"));
                if (TextUtils.isEmpty(strObj2String)) {
                    AlibcJsEnum alibcJsEnum = AlibcJsEnum.FAIL;
                    alibcJsEnum.setMsg("传入的url为空");
                    Map<String, Object> mapBuildResult = buildResult(alibcJsEnum, null);
                    if (alibcJsCallback != null) {
                        alibcJsCallback.fail(mapBuildResult);
                    }
                    return true;
                }
                Iterator<Map.Entry<String, CommonListener>> it = CommonListenerManager.getListenerMap().entrySet().iterator();
                while (it.hasNext()) {
                    CommonListener value = it.next().getValue();
                    if (value != null) {
                        value.openUrl("pushWindow", strObj2String);
                    }
                }
            }
        } catch (Throwable th) {
            AlibcLogger.e(f23553a, "found class exception: " + th.getMessage());
            AlibcJsEnum alibcJsEnum2 = AlibcJsEnum.FAIL;
            alibcJsEnum2.setMsg("解析异常");
            Map<String, Object> mapBuildResult2 = buildResult(alibcJsEnum2, null);
            if (alibcJsCallback != null) {
                alibcJsCallback.fail(mapBuildResult2);
            }
        }
        return true;
    }
}
