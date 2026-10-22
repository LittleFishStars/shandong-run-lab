package com.alibaba.alibcprotocol.route.config;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.NetworkChangeReceiver;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.manager.AlibcInterceptCenter;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.model.SuiteDO;
import com.alibaba.alibcprotocol.route.model.SuiteMiscDO;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.alibctriver.AlibcTriverSDK;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23623a = "AlibcConfigService";
    private static volatile AlibcConfigService b;
    private ConfigDO c;
    private PageDO d;
    private boolean e;
    private NetworkChangeReceiver f = new NetworkChangeReceiver();

    private AlibcConfigService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a() {
        ArrayList arrayList = new ArrayList(AlibcProtocolConstant.COMPONENT_LIST.length);
        Collections.addAll(arrayList, AlibcProtocolConstant.COMPONENT_LIST);
        if (arrayList.size() > 0) {
            if (arrayList.contains("applink_sdk")) {
                AlibcInterceptCenter.registerInterceptor("applink_sdk", AlibcProtocolUtils.APPLINK_INTERCEPTOR_CLASS);
            } else {
                AlibcInterceptCenter.unRegisterInterceptor("applink_sdk");
            }
            if (arrayList.contains("login_sdk")) {
                AlibcInterceptCenter.registerInterceptor("login_sdk", AlibcProtocolUtils.LOGIN_INTERCEPTOR_CLASS);
            } else {
                AlibcInterceptCenter.unRegisterInterceptor("login_sdk");
            }
            if (arrayList.contains("ucc_login_sdk")) {
                AlibcInterceptCenter.registerInterceptor("ucc_login_sdk", AlibcProtocolUtils.UCC_LOGIN_INTERCEPTOR_CLASS);
            } else {
                AlibcInterceptCenter.unRegisterInterceptor("ucc_login_sdk");
            }
            if (arrayList.contains("webview_sdk")) {
                AlibcInterceptCenter.registerInterceptor("webview_sdk", AlibcProtocolUtils.H5_INTERCEPTOR_CLASS);
            } else {
                AlibcInterceptCenter.unRegisterInterceptor("webview_sdk");
            }
        }
    }

    public static /* synthetic */ void access$000(AlibcConfigService alibcConfigService, PageDO pageDO) {
        if (pageDO == null) {
            return;
        }
        try {
            Map<String, Object> map = AlibcTradeContext.getInstance().extParams;
            if (map != null) {
                Object obj = map.get("preload");
                if ((obj instanceof Boolean) && !((Boolean) obj).booleanValue()) {
                    return;
                }
            }
        } catch (Throwable th) {
            AlibcLogger.e(f23623a, "parse param exception: " + th.getMessage());
        }
        if (alibcConfigService.e) {
            return;
        }
        alibcConfigService.e = true;
        List<SuiteDO> suites = pageDO.getSuites();
        if (suites == null || suites.isEmpty()) {
            return;
        }
        try {
            AlibcTriverSDK.class.getMethod("preloadResource", Context.class, List.class).invoke(null, AlibcBaseTradeCommon.context, suites);
        } catch (Exception e) {
            AlibcLogger.e(f23623a, "class invoke exception: " + e.getMessage());
        }
    }

    public static /* synthetic */ int access$200(AlibcConfigService alibcConfigService, ConfigDO configDO) {
        return a(configDO);
    }

    public static /* synthetic */ int access$300(AlibcConfigService alibcConfigService, ConfigDO configDO) {
        return b(configDO);
    }

    private static int b(ConfigDO configDO) {
        MiscDO misc;
        if (configDO == null || (misc = configDO.getMisc()) == null || TextUtils.isEmpty(misc.getMonitorSampling()) || !TextUtils.isDigitsOnly(misc.getMonitorSampling())) {
            return 500;
        }
        return Integer.parseInt(misc.getMonitorSampling());
    }

    public static AlibcConfigService getInstance() {
        if (b == null) {
            synchronized (AlibcConfigService.class) {
                if (b == null) {
                    b = new AlibcConfigService();
                }
            }
        }
        return b;
    }

    public ConfigDO getConfig() {
        return this.c;
    }

    public boolean getLoginDegrade(boolean z) {
        MiscDO misc;
        ConfigDO configDO = this.c;
        return (configDO == null || (misc = configDO.getMisc()) == null) ? z : "YES".equals(misc.getLoginDegarade());
    }

    public PageDO getPage() {
        return this.d;
    }

    public void init(Context context) {
        try {
            ConfigDO configDO = (ConfigDO) CacheUtil.getData(AlibcProtocolConstant.BC_CONFIG_KEY);
            this.c = configDO;
            if (configDO == null) {
                ConfigDO configDO2 = (ConfigDO) JSON.parseObject("{\"bizPattern\":[{\"bizCode\":\"detail\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao.com/cm/snap/index\\\\.html(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*)\",\"^http(s)?://detail(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*)\",\"^https?://m\\\\.duanqu\\\\.com\\\\?(((_ariver_appid=(3000000002138642|3000000002164331).*)(page=plugin-private%3[a|A]%2[f|F]%2[f|F](3000000002019601|3000000002163031)%2[f|F]pages%2[f|F]index%2[f|F]index.*))|((page=plugin-private%3[a|A]%2[f|F]%2[f|F](3000000002019601|3000000002163031)%2[f|F]pages%2[f|F]index%2[f|F]index.*)(_ariver_appid=(3000000002138642|3000000002164331).*)))\",\"^https?://m\\\\.duanqu\\\\.com\\\\?.*3000000003562961.*\",\"^https?://m\\\\.duanqu\\\\.com\\\\?.*3000000003742312.*\"]},{\"bizCode\":\"shop\",\"pattern\":[\"^http(s)?://shop\\\\.(.*)\\\\.taobao.com/shop/shop_index.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.tmall.com/shop/shop_index.htm(.*)\",\"^http(s)?://shop(.*)\\\\.(.*)\\\\.taobao.com/shop/shopIndex.htm(.*)\"]},{\"bizCode\":\"order\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cart/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/order\\\\.htm(.*)\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirmOrderWap\\\\.htm(.*)\"]},{\"bizCode\":\"cart\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/cart\\\\.htm(.*)\",\"^http(s)?://cart\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/myCart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/bag\\\\.htm(.*)\",\"^https?://m\\\\.duanqu\\\\.com\\\\?(((_ariver_appid=(3000000002138642|3000000002164331).*)(page=plugin-private%3[a|A]%2[f|F]%2[f|F](3000000002029101|3000000002162974)%2[f|F]pages%2[f|F]index%2[f|F]index.*))|((page=plugin-private%3[a|A]%2[f|F]%2[f|F](3000000002029101|3000000002162974)%2[f|F]pages%2[f|F]index%2[f|F]index.*)(_ariver_appid=(3000000002138642|3000000002164331).*)))\",\"^https?://m\\\\.duanqu\\\\.com\\\\?.*3000000003562962.*\",\"^https?://m\\\\.duanqu\\\\.com\\\\?.*3000000003738162.*\"]},{\"bizCode\":\"olist\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/olist\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/olist/index\\\\.htm(.*)\"]},{\"bizCode\":\"logout\",\"pattern\":[\"^http(s)?://login\\\\.(.*)\\\\.taobao\\\\.com/logout(.*)$\"]},{\"bizCode\":\"login\",\"pattern\":[\"^http(s)?://login(\\\\..*)?\\\\.taobao.com(.*login.*)$\",\"^http(s)?://login\\\\.tmall\\\\.com(.*)$\",\"^http(s)?://login.taobao.com/member/login.jhtml(.*)$\"]},{\"bizCode\":\"alipay\",\"pattern\":[\"^http(s)?://(maliprod|mclient|premcgw)\\\\.alipay\\\\.com/w/(trade_pay|batch_payment)\\\\.do(.*)$\",\"^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/w/(trade_pay|batch_payment)\\\\.do(.*)$\",\"^http(s)?://(maliprod|mclient)\\\\.alipay\\\\.com/(trade_pay|batch_payment)\\\\.do(.*)$\",\"^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/(trade_pay|batch_payment)\\\\.do(.*)$\"]},{\"bizCode\":\"alipayReceipt\",\"pattern\":[\".*://safepay.*\"]}],\"routeConfig\":[{\"match\":\"(^http(s)?://login(\\\\..*)?\\\\.taobao.com(.*)$)|(^http(s)?://login\\\\.tmall\\\\.com(.*)$)|(^http(s)?://login.taobao.com/member/login.jhtml(.*)$)|(^http(s)?://login\\\\.(.*)\\\\.taobao\\\\.com/logout(.*)$)|(^http(s)?://(maliprod|mclient|premcgw)\\\\.alipay\\\\.com/w/(trade_pay|batch_payment)\\\\.do(.*)$)|(^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/w/(trade_pay|batch_payment)\\\\.do(.*)$)|(^http(s)?://(maliprod|mclient)\\\\.alipay\\\\.com/(trade_pay|batch_payment)\\\\.do(.*)$)|(^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/(trade_pay|batch_payment)\\\\.do(.*)$)|(.*wapp.m.taobao.com.*)|(^https?://temai\\\\.m\\\\.taobao\\\\.com/index\\\\.htm.*$)|(^https?://temai\\\\.m\\\\.taobao\\\\.com/search\\\\.htm.*$)|(^https?://mo\\\\.m\\\\.taobao\\\\.com/union/chaojidanpin20181201.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/union/pinpaitemaib.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/activity_newer.*$)|(^https?://oauth(\\\\.m)?\\\\.taobao\\\\.com/authorize.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/inviter/register.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/inviter/offline-verify.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/inviter/recruit.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/nv/haiwaiju/mtp\\\\.htm.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/o/juhuasuanliyid/mtp\\\\.htm.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/o/fcdp2017/mtp\\\\.htm.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/other/lftnew/mtp\\\\.htm.*$)|(^https?://uland\\\\.taobao\\\\.com/semm/tbsearch.*$)|(^https?://download\\\\.taobaocdn\\\\.com/.*\\\\.apk.*$)\",\"index\":[],\"action\":[{\"openType\":\"h5\",\"param\":{}}]},{\"match\":\"(^http(s)?://h5\\\\.(.*)\\\\.taobao.com/cm/snap/index\\\\.html(.*))|(^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*))|(^http(s)?://detail\\\\.(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*))\",\"index\":[],\"action\":[{\"openType\":\"native\",\"param\":{\"clientPage\":\"detail\"}}]},{\"match\":\"(^http(s)?://shop\\\\.(.*)\\\\.taobao.com/shop/shop_index.htm(.*))|(^http(s)?://shop\\\\.(.*)\\\\.tmall.com/shop/shop_index.htm(.*))|(^http(s)?://shop(.*)\\\\.(.*)\\\\.taobao.com/shop/shopIndex.htm(.*))\",\"index\":[],\"action\":[{\"openType\":\"native\",\"param\":{\"clientPage\":\"shop\"}}]},{\"match\":\"^https?:\\\\/\\\\/(([^/\\\\?#]+\\\\.)*((rantu|aligames|fliggy|youku|taobao|jaeapp|cainiao|guoguo-app|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|duanqu|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688)\\\\.com|(tb|tbcdn|weibo|mashort|mybank|ba\\\\.ugame\\\\.uc|game\\\\.uc)\\\\.cn|(ele)\\\\.(me|cc)|lwurl\\\\.to|taobao\\\\.net|tdd\\\\.la|yao\\\\.95095\\\\.com|tmall\\\\.hk|ahd\\\\.so|atb\\\\.so|mshare\\\\.cc|juhs\\\\.me|xianyu\\\\.mobi)([\\\\?|#|/].*)?|go(/.*)?)$\",\"index\":[],\"action\":[{\"openType\":\"native\",\"param\":{}}]}],\"forbidByCode\":[],\"urlTypeConfig\":[{\"type\":\"h5\",\"pattern\":[\"reg1\",\"reg2\"]},{\"type\":\"miniapp\",\"pattern\":[\"^http(s)?://m.duanqu.com(.*)\",\"^http(s)?://.*hybrid.miniapp.taobao.com.*\"]}],\"sign\":\"ce6976f4416b6fe0afb198da0c8d8d27\",\"version\":\"1.0\",\"codeConfig\":[],\"misc\":{\"urlApi\":\"https://baichuan-sdk.taobao.com/4.0.0.2/android/codes.htm?appKey=28113487&appVersion=1.0.0\",\"failMode\":\"download\",\"isNeedAlipay\":\"YES\",\"sampling\":\"10000\",\"extConfigApi\":\"mtop://mtop.baichuan.suite.app.ext.get?version=1.0\",\"loginDegarade\":\"NO\",\"al\":\"1\",\"isSyncForTaoke\":\"YES\"},\"addParamUrls\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cm/snap/index\\\\.html(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/bag\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cart/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/olist\\\\.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.taobao\\\\.com/shop/shopIndex\\\\.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.taobao\\\\.com/shop/shop_index\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/trade/detail\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/olist/index\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/cart/index\\\\.htm(.*)\",\"^http(s)?://detail\\\\.(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*)\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirmOrderWap\\\\.htm(.*)\",\"^http(s)?://((?!(login|buy|s.click))\\\\.)(.*)\\\\.tmall\\\\.com(.*)$\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirm_order_wap\\\\.htm(.*)\",\"^http(s)?://cart\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/myCart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/order\\\\.htm(.*)\"]}", ConfigDO.class);
                this.c = configDO2;
                setConfig(configDO2);
            }
            AlibcUserTracker alibcUserTracker = AlibcUserTracker.getInstance();
            if (alibcUserTracker != null) {
                alibcUserTracker.setSampling(a(this.c));
                alibcUserTracker.setMonitorSampling(b(this.c));
            }
            a();
            PageDO pageDO = (PageDO) CacheUtil.getData(AlibcProtocolConstant.BC_SUITE_KEY);
            this.d = pageDO;
            if (pageDO != null) {
                setPage(pageDO);
            }
        } catch (Exception e) {
            AlibcLogger.e(f23623a, "parse json object exception: " + e.getMessage());
        }
        requestConfig(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        context.registerReceiver(this.f, intentFilter);
    }

    public void refreshConfig(Context context, String str) {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            com.alibaba.alibcprotocol.route.config.a aVar = new com.alibaba.alibcprotocol.route.config.a(context);
            if (AlibcProtocolConstant.REQUEST_BASE_CONFIG.equals(str)) {
                aVar.a(AlibcProtocolConstant.REQUEST_BASE_CONFIG, new a());
            } else if (AlibcProtocolConstant.REQUEST_SUITE_CONFIG.equals(str)) {
                aVar.a(AlibcProtocolConstant.REQUEST_SUITE_CONFIG, new b());
            }
        }
    }

    public void requestConfig(Context context) {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            com.alibaba.alibcprotocol.route.config.a aVar = new com.alibaba.alibcprotocol.route.config.a(context);
            aVar.a(AlibcProtocolConstant.REQUEST_BASE_CONFIG, new a());
            aVar.a(AlibcProtocolConstant.REQUEST_SUITE_CONFIG, new b());
        }
    }

    public void setConfig(ConfigDO configDO) {
        this.c = configDO;
        CacheUtil.setData(AlibcProtocolConstant.BC_CONFIG_KEY, configDO);
    }

    public void setPage(PageDO pageDO) {
        this.d = pageDO;
        CacheUtil.setData(AlibcProtocolConstant.BC_SUITE_KEY, pageDO);
    }

    public void unregisterReceiver(Context context) {
        try {
            NetworkChangeReceiver networkChangeReceiver = this.f;
            if (networkChangeReceiver != null) {
                context.unregisterReceiver(networkChangeReceiver);
                this.f = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class b implements com.alibaba.alibcprotocol.route.config.a.InterfaceC0126a {
        public b() {
        }

        @Override // com.alibaba.alibcprotocol.route.config.a.InterfaceC0126a
        public final void a(Object obj, String str) {
            if (obj != null) {
                PageDO pageDO = (PageDO) obj;
                HashMap map = new HashMap();
                map.put("cost", str + "ms");
                AlibcLogger.saveLog("baichuan", "SUITE_CONFIG_REQUEST_SUCCESS", "SUITE_CONFIG_REQUEST", "suite config request success", map, "normal");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.SIGN, (Object) pageDO.getSign());
                jSONObject.put("costTime", (Object) str);
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_SUITE_CONFIG, "", "", jSONObject);
                AlibcConfigService.this.setPage(pageDO);
                AlibcConfigService.access$000(AlibcConfigService.this, pageDO);
                final SuiteMiscDO misc = pageDO.getMisc();
                if (misc == null || !"true".equalsIgnoreCase(misc.getLogEnable())) {
                    return;
                }
                ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.alibcprotocol.route.config.AlibcConfigService.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AlibcLogger.uploadLogFile(misc.getLogUrl(), misc.getLogLevel(), misc.getMaxHistroy() <= 0 ? 1 : misc.getMaxHistroy());
                    }
                });
            }
        }

        @Override // com.alibaba.alibcprotocol.route.config.a.InterfaceC0126a
        public final void a(int i, String str, String str2) {
            HashMap map = new HashMap();
            map.put("cost", str2 + "ms");
            map.put("errorCode", String.valueOf(i));
            map.put("errorMsg", str);
            AlibcLogger.saveLog("baichuan", "SUITE_CONFIG_REQUEST_FAIL", "SUITE_CONFIG_REQUEST", 1000 == i ? "suite data is tampered" : "suite data request fail", map, "error");
            PageDO page = AlibcConfigService.getInstance().getPage();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UserTrackConstant.SIGN, (Object) (page != null ? page.getSign() : ""));
            jSONObject.put("costTime", (Object) str2);
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_SUITE_CONFIG, String.valueOf(i), str, jSONObject);
            AlibcConfigService alibcConfigService = AlibcConfigService.this;
            AlibcConfigService.access$000(alibcConfigService, alibcConfigService.d);
        }
    }

    public class a implements com.alibaba.alibcprotocol.route.config.a.InterfaceC0126a {
        public a() {
        }

        @Override // com.alibaba.alibcprotocol.route.config.a.InterfaceC0126a
        public final void a(Object obj, String str) {
            if (obj != null) {
                ConfigDO configDO = (ConfigDO) obj;
                AlibcUserTracker alibcUserTracker = AlibcUserTracker.getInstance();
                if (alibcUserTracker != null) {
                    alibcUserTracker.setSampling(AlibcConfigService.access$200(AlibcConfigService.this, configDO));
                    alibcUserTracker.setMonitorSampling(AlibcConfigService.access$300(AlibcConfigService.this, configDO));
                }
                HashMap map = new HashMap();
                map.put("cost", str + "ms");
                AlibcLogger.saveLog("baichuan", "BASE_CONFIG_REQUEST_SUCCESS", "BASE_CONFIG_REQUEST", "base config request success", map, "normal");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.SIGN, (Object) configDO.getSign());
                jSONObject.put("costTime", (Object) str);
                jSONObject.put(UserTrackConstant.CONFIG_VER, (Object) configDO.getConfig_ver());
                jSONObject.put(UserTrackConstant.CONFIG_VER_OLD, (Object) (AlibcConfigService.this.c != null ? AlibcConfigService.this.c.getConfig_ver() : ""));
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_BASE_CONFIG, "", "", jSONObject);
                AlibcConfigService alibcConfigService = AlibcConfigService.this;
                AlibcConfigService.a();
                AlibcConfigService.this.setConfig(configDO);
            }
        }

        @Override // com.alibaba.alibcprotocol.route.config.a.InterfaceC0126a
        public final void a(int i, String str, String str2) {
            HashMap map = new HashMap();
            map.put("cost", str2 + "ms");
            map.put("errorCode", String.valueOf(i));
            map.put("errorMsg", str);
            AlibcLogger.saveLog("baichuan", "BASE_CONFIG_REQUEST_FAIL", "BASE_CONFIG_REQUEST", 1000 == i ? "base config data is tampered" : "base config data request fail", map, "error");
            ConfigDO config = AlibcConfigService.getInstance().getConfig();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UserTrackConstant.SIGN, (Object) (config != null ? config.getSign() : ""));
            jSONObject.put("costTime", (Object) str2);
            jSONObject.put(UserTrackConstant.CONFIG_VER_OLD, (Object) (config != null ? config.getConfig_ver() : ""));
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_BASE_CONFIG, String.valueOf(i), str, jSONObject);
        }
    }

    private static int a(ConfigDO configDO) {
        MiscDO misc;
        if (configDO == null || (misc = configDO.getMisc()) == null || TextUtils.isEmpty(misc.getSampling()) || !TextUtils.isDigitsOnly(misc.getSampling())) {
            return 10000;
        }
        return Integer.parseInt(misc.getSampling());
    }
}
