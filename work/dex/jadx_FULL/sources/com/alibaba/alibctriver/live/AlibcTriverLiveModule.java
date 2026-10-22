package com.alibaba.alibctriver.live;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.alibctriver.api.AlibcTriverLiveProxy;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.taobao.adapter.d;
import com.taobao.media.c;
import com.taobao.mediaplay.MediaPlayControlContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AlibcTriverLiveModule implements AlibcTriverLiveProxy {
    @Override // com.alibaba.alibctriver.api.AlibcTriverLiveProxy
    public void initTbLive() {
        c.a = null;
        c.b = new com.taobao.mediaplay.a.c() { // from class: com.alibaba.alibctriver.live.AlibcTriverLiveModule.1
            public int a() {
                return Integer.MAX_VALUE;
            }

            public boolean a(MediaPlayControlContext mediaPlayControlContext) {
                return false;
            }
        };
        c.c = new d() { // from class: com.alibaba.alibctriver.live.AlibcTriverLiveModule.2
            public String a() {
                String netWorkType = NetWorkUtils.getNetWorkType(AlibcBaseTradeCommon.context);
                return TextUtils.isEmpty(netWorkType) ? NetworkUtil.NETWORK_TYPE_4G : netWorkType;
            }

            public boolean b() {
                return NetWorkUtils.isNetWorkAvailable(AlibcBaseTradeCommon.context);
            }
        };
        c.d = null;
    }
}
