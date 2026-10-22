package com.alibaba.alibcprotocol.route.config;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.model.Environment;
import com.alibaba.baichuan.trade.common.network.DefaultRetryPolicy;
import com.alibaba.baichuan.trade.common.network.HttpRequest;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.fastjson.JSON;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23628a = "a";
    private Context b;

    /* JADX INFO: renamed from: com.alibaba.alibcprotocol.route.config.a$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23630a;

        static {
            int[] iArr = new int[Environment.values().length];
            f23630a = iArr;
            try {
                iArr[Environment.PRE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23630a[Environment.TEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.alibcprotocol.route.config.a$a, reason: collision with other inner class name */
    public interface InterfaceC0126a {
        void a(int i, String str, String str2);

        void a(Object obj, String str);
    }

    public a(Context context) {
        this.b = context;
    }

    public final void a(final String str, final InterfaceC0126a interfaceC0126a) {
        ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new Thread() { // from class: com.alibaba.alibcprotocol.route.config.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                a.a(a.a(str), str, interfaceC0126a);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    public static /* synthetic */ String a(String str) {
        String str2;
        int i = AnonymousClass2.f23630a[AlibcBaseTradeCommon.getEnvironment().ordinal()];
        if (i != 1) {
            if (i == 2) {
                str2 = "https://test-baichuan-sdk.alibaba.net/%s/%s/%s/%s/fg_rule.htm";
            } else if (AlibcProtocolConstant.REQUEST_SUITE_CONFIG.equals(str)) {
                str2 = "https://baichuan-sdk.taobao.com/%s/android/codes.htm";
            } else if (AlibcProtocolConstant.REQUEST_BASE_CONFIG.equals(str)) {
                str2 = "https://baichuan-sdk.alicdn.com/%s/%s/%s/%s/fg_rule.htm";
            } else {
                str2 = "";
            }
        } else if (AlibcProtocolConstant.REQUEST_SUITE_CONFIG.equals(str)) {
            str2 = "https://pre-baichuan-sdk.taobao.com/%s/android/codes.htm";
        } else if (AlibcProtocolConstant.REQUEST_BASE_CONFIG.equals(str)) {
            str2 = "https://pre-baichuan-sdk.taobao.com/%s/%s/%s/%s/fg_rule.htm";
        } else {
            str2 = "";
        }
        if (!AlibcProtocolConstant.REQUEST_SUITE_CONFIG.equals(str)) {
            return AlibcProtocolConstant.REQUEST_BASE_CONFIG.equals(str) ? String.format(str2, "5.0.2.5", AlibcBaseTradeCommon.getAppKey(), "1.0.0", "android") : str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(str2, "5.0.2.5"));
        sb.append("?appKey=");
        sb.append(AlibcBaseTradeCommon.getAppKey());
        sb.append("&appVersion=1.0.0&utdid=");
        sb.append(AlibcBaseTradeCommon.getUtdid());
        Map<String, Object> userInfo = ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).getUserInfo();
        if (userInfo != null) {
            sb.append("&openid=");
            sb.append(userInfo.get("userId"));
        }
        return sb.toString();
    }

    public static /* synthetic */ void a(String str, String str2, InterfaceC0126a interfaceC0126a) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strStreamToString = NetWorkUtils.streamToString(NetWorkUtils.get(new HttpRequest(new DefaultRetryPolicy(1), str, null)).getInputStream(), "UTF-8");
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (AlibcProtocolConstant.REQUEST_BASE_CONFIG.equals(str2) && !TextUtils.isEmpty(strStreamToString)) {
                ConfigDO configDO = (ConfigDO) JSON.parseObject(strStreamToString, ConfigDO.class);
                AlibcCommonConstant.BASE_CONFIG_REQUEST_SUCCESS = true;
                if (configDO != null) {
                    if (AlibcProtocolUtils.verifySignValid(configDO.getSign(), strStreamToString)) {
                        interfaceC0126a.a(configDO, String.valueOf(jCurrentTimeMillis2));
                        return;
                    } else {
                        interfaceC0126a.a(1000, AlibcProtocolConstant.DATA_VERIFY_FAIL_MSG, String.valueOf(jCurrentTimeMillis2));
                        return;
                    }
                }
                interfaceC0126a.a(1400, AlibcProtocolConstant.DATA_PULL_IS_NULL_MSG, String.valueOf(jCurrentTimeMillis2));
                return;
            }
            if (!AlibcProtocolConstant.REQUEST_SUITE_CONFIG.equals(str2) || TextUtils.isEmpty(strStreamToString)) {
                return;
            }
            PageDO pageDO = (PageDO) JSON.parseObject(strStreamToString, PageDO.class);
            AlibcCommonConstant.SUITE_CONFIG_REQUEST_SUCCESS = true;
            if (pageDO != null) {
                if (AlibcProtocolUtils.verifySignValid(pageDO.getSign(), strStreamToString)) {
                    interfaceC0126a.a(pageDO, String.valueOf(jCurrentTimeMillis2));
                    return;
                } else {
                    interfaceC0126a.a(1000, AlibcProtocolConstant.DATA_VERIFY_FAIL_MSG, String.valueOf(jCurrentTimeMillis2));
                    return;
                }
            }
            interfaceC0126a.a(1400, AlibcProtocolConstant.DATA_PULL_IS_NULL_MSG, String.valueOf(jCurrentTimeMillis2));
        } catch (Exception e) {
            interfaceC0126a.a(-1, e.getMessage(), "");
        }
    }
}
