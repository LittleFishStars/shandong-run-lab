package com.alibaba.triver.appinfo.channel;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.zj.adlib.xh9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24632a = "AppInfoCenter";
    private static a d;
    private RouterConfigModel b;
    private int c;
    private final Object e = new Object();

    public a() {
        this.c = -1;
        String utdid = Triver.getUtdid();
        if (TextUtils.isEmpty(utdid)) {
            return;
        }
        int iC = c(utdid);
        this.c = iC;
        if (iC < 0) {
            this.c = c(utdid);
        }
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        synchronized (this.e) {
            RouterConfigModel routerConfigModel = this.b;
            if (routerConfigModel == null) {
                return null;
            }
            return routerConfigModel.deployVersion;
        }
    }

    public RouterConfigModel.ChannelModel b(String str) {
        RouterConfigModel routerConfigModel;
        synchronized (this.e) {
            if (TextUtils.isEmpty(str) || (routerConfigModel = this.b) == null) {
                return null;
            }
            return routerConfigModel.findChannelByName(str);
        }
    }

    private boolean b(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.contains(str2);
    }

    private int c(String str) {
        int length = str.length();
        long jCharAt = 0;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                jCharAt = ((long) str.charAt(i)) + (((long) 131) * jCharAt);
            }
        }
        return (int) Math.abs((jCharAt & 2147483647L) % 10000);
    }

    public void a(String str) {
        JSONArray jSONArray;
        JSONArray<String> jSONArray2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.e) {
            try {
                try {
                    JSONObject object = JSON.parseObject(str);
                    if (object != null && !object.isEmpty()) {
                        JSONObject jSONObject = object.getJSONObject("channels");
                        if (jSONObject != null && !jSONObject.isEmpty()) {
                            HashMap map = new HashMap();
                            for (String str2 : jSONObject.keySet()) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                                if (jSONObject2 != null && !jSONObject2.isEmpty()) {
                                    RouterConfigModel.ChannelModel channelModel = new RouterConfigModel.ChannelModel();
                                    channelModel.name = str2;
                                    channelModel.type = jSONObject2.getString("type");
                                    channelModel.api = jSONObject2.getString("api");
                                    channelModel.version = jSONObject2.getString("version");
                                    channelModel.preHost = jSONObject2.getString("preHost");
                                    channelModel.onlineHost = jSONObject2.getString("onlineHost");
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("guardConfig");
                                    if (jSONObject3 != null) {
                                        String string = jSONObject3.getString(xh9.WEBSITE_PARAMS_CHANNEL);
                                        if (!TextUtils.isEmpty(string) && (jSONArray2 = jSONObject3.getJSONArray("errorCode")) != null) {
                                            ArrayList arrayList = new ArrayList();
                                            for (String str3 : jSONArray2) {
                                                try {
                                                    if (!TextUtils.isEmpty(str3)) {
                                                        arrayList.add(str3);
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                            if (!arrayList.isEmpty()) {
                                                RouterConfigModel.GuardConfig guardConfig = new RouterConfigModel.GuardConfig();
                                                guardConfig.channel = string;
                                                guardConfig.errorCode = arrayList;
                                                channelModel.guardConfig = guardConfig;
                                            }
                                        }
                                    }
                                    if (a(channelModel)) {
                                        map.put(str2, channelModel);
                                    }
                                }
                            }
                            if (map.isEmpty()) {
                                return;
                            }
                            RouterConfigModel routerConfigModel = new RouterConfigModel();
                            this.b = routerConfigModel;
                            routerConfigModel.channels = map;
                            routerConfigModel.deployVersion = object.getString("deployVersion");
                            this.b.protocolVersion = object.getString("protocolVersion");
                            this.b.defaultChannel = object.getString("defaultChannel");
                            RouterConfigModel routerConfigModel2 = this.b;
                            routerConfigModel2.defaultChannel = TextUtils.isEmpty(routerConfigModel2.defaultChannel) ? "mtop" : this.b.defaultChannel;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                JSONArray jSONArray3 = object.getJSONArray("routerStrategies");
                                if (jSONArray3 != null && !jSONArray3.isEmpty()) {
                                    for (Object obj : jSONArray3) {
                                        if (obj != null) {
                                            try {
                                                JSONObject jSONObject4 = (JSONObject) obj;
                                                String string2 = jSONObject4.getString("name");
                                                if (!TextUtils.isEmpty(string2) && (jSONArray = jSONObject4.getJSONArray("data")) != null && !jSONArray.isEmpty()) {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    for (Object obj2 : jSONArray) {
                                                        if (obj2 != null) {
                                                            try {
                                                                JSONObject jSONObject5 = (JSONObject) obj2;
                                                                String string3 = jSONObject5.getString("channelName");
                                                                if (!TextUtils.isEmpty(string3)) {
                                                                    if (TextUtils.equals(string2, "commonPriorities")) {
                                                                        RouterConfigModel.RatioPriority ratioPriority = new RouterConfigModel.RatioPriority();
                                                                        ratioPriority.channelName = string3;
                                                                        ratioPriority.ratioStart = jSONObject5.getInteger("ratioStart").intValue();
                                                                        ratioPriority.ratioEnd = jSONObject5.getInteger("ratioEnd").intValue();
                                                                        if (a(ratioPriority) && map.containsKey(string3)) {
                                                                            arrayList3.add(ratioPriority);
                                                                        }
                                                                    } else if (TextUtils.equals(string2, "appIdPriorities")) {
                                                                        RouterConfigModel.WhiteListPriority whiteListPriority = new RouterConfigModel.WhiteListPriority();
                                                                        whiteListPriority.channelName = string3;
                                                                        JSONArray jSONArray4 = jSONObject5.getJSONArray("appIds");
                                                                        if (jSONArray4 != null && !jSONArray4.isEmpty()) {
                                                                            whiteListPriority.appIds = JSONUtils.toStringArray(jSONArray4);
                                                                            if (map.containsKey(string3)) {
                                                                                arrayList3.add(whiteListPriority);
                                                                            }
                                                                        }
                                                                    } else if (TextUtils.equals(string2, "urlParamsPriorities")) {
                                                                        RouterConfigModel.UrlParamsPriority urlParamsPriority = new RouterConfigModel.UrlParamsPriority();
                                                                        urlParamsPriority.channelName = string3;
                                                                        urlParamsPriority.ratioStart = jSONObject5.getInteger("ratioStart").intValue();
                                                                        urlParamsPriority.ratioEnd = jSONObject5.getInteger("ratioEnd").intValue();
                                                                        urlParamsPriority.containsQuery = jSONObject5.getString("containsQuery");
                                                                        if (a(urlParamsPriority) && map.containsKey(string3)) {
                                                                            arrayList3.add(urlParamsPriority);
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Exception unused2) {
                                                            }
                                                        }
                                                    }
                                                    RouterConfigModel.PriorityModel priorityModel = new RouterConfigModel.PriorityModel();
                                                    priorityModel.name = string2;
                                                    priorityModel.data = arrayList3;
                                                    Integer integer = jSONObject4.getInteger("weight");
                                                    if (integer != null) {
                                                        priorityModel.weight = integer.intValue();
                                                        a(arrayList2, priorityModel);
                                                    }
                                                }
                                            } catch (Exception unused3) {
                                            }
                                        }
                                    }
                                    this.b.routerStrategies = arrayList2;
                                }
                            } catch (Exception e) {
                                RVLogger.e(f24632a, "parse routerStrategies error", e);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception e2) {
                RVLogger.e(f24632a, "parse config error", e2);
            }
        }
    }

    public RouterConfigModel.ChannelModel a(String str, String str2) {
        List<RouterConfigModel.BasePriority> list;
        if (this.b == null) {
            String customConfigsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getCustomConfigsByGroup(TRiverConstants.ORANGE_GROUP_APP_INFO_ROUTER_CONFIG);
            if (TextUtils.isEmpty(customConfigsByGroup)) {
                return null;
            }
            a(customConfigsByGroup);
            if (this.b == null) {
                return null;
            }
        }
        synchronized (this.e) {
            List<RouterConfigModel.PriorityModel> list2 = this.b.routerStrategies;
            if (list2 != null && !list2.isEmpty()) {
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    RouterConfigModel.PriorityModel priorityModel = list2.get(i);
                    if (priorityModel != null && (list = priorityModel.data) != null) {
                        for (RouterConfigModel.BasePriority basePriority : list) {
                            if (basePriority instanceof RouterConfigModel.WhiteListPriority) {
                                RouterConfigModel.WhiteListPriority whiteListPriority = (RouterConfigModel.WhiteListPriority) basePriority;
                                List<String> list3 = whiteListPriority.appIds;
                                if (list3 != null && list3.contains(str)) {
                                    return this.b.findChannelByName(whiteListPriority.channelName);
                                }
                            } else if (basePriority instanceof RouterConfigModel.UrlParamsPriority) {
                                RouterConfigModel.UrlParamsPriority urlParamsPriority = (RouterConfigModel.UrlParamsPriority) basePriority;
                                String str3 = urlParamsPriority.containsQuery;
                                if (str3 != null && b(str2, str3)) {
                                    int i2 = urlParamsPriority.ratioStart;
                                    int i3 = this.c;
                                    if (i2 < i3 && urlParamsPriority.ratioEnd > i3) {
                                        return this.b.findChannelByName(urlParamsPriority.channelName);
                                    }
                                    return this.b.getDefaultChannel();
                                }
                            } else if (basePriority instanceof RouterConfigModel.RatioPriority) {
                                RouterConfigModel.RatioPriority ratioPriority = (RouterConfigModel.RatioPriority) basePriority;
                                int i4 = ratioPriority.ratioStart;
                                int i5 = this.c;
                                if (i4 < i5 && ratioPriority.ratioEnd > i5) {
                                    return this.b.findChannelByName(ratioPriority.channelName);
                                }
                                return this.b.getDefaultChannel();
                            }
                        }
                    }
                }
                return this.b.getDefaultChannel();
            }
            return this.b.getDefaultChannel();
        }
    }

    private boolean a(RouterConfigModel.ChannelModel channelModel) {
        if (TextUtils.isEmpty(channelModel.type)) {
            return false;
        }
        if (TextUtils.equals(channelModel.type, "mtop") && TextUtils.isEmpty(channelModel.api)) {
            return false;
        }
        return (TextUtils.equals(channelModel.type, "http") && TextUtils.isEmpty(channelModel.onlineHost)) ? false : true;
    }

    private boolean a(RouterConfigModel.RatioPriority ratioPriority) {
        return ratioPriority.ratioEnd > ratioPriority.ratioStart;
    }

    private boolean a(RouterConfigModel.UrlParamsPriority urlParamsPriority) {
        return urlParamsPriority.ratioEnd > urlParamsPriority.ratioStart && !TextUtils.isEmpty(urlParamsPriority.containsQuery);
    }

    private void a(List<RouterConfigModel.PriorityModel> list, RouterConfigModel.PriorityModel priorityModel) {
        if (list.size() == 0) {
            list.add(priorityModel);
            return;
        }
        if (priorityModel.weight > list.get(0).weight) {
            list.add(0, priorityModel);
            return;
        }
        int size = list.size();
        int i = 1;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (priorityModel.weight > list.get(i).weight) {
                break;
            } else {
                i++;
            }
        }
        if (i > 0) {
            list.add(i, priorityModel);
        } else {
            list.add(priorityModel);
        }
    }
}
