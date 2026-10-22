package com.bwt.top.custom_ad.http;

import android.text.TextUtils;
import com.bwt.top.AdPlatforms;
import com.bwt.top.AdSdk;
import com.bwt.top.api.ApiManager;
import com.bwt.top.bean.ExtendChannel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CustomApiConstant {
    private static volatile String channel_ad_key = null;
    private static final String default_channel_ad_key = "aeskeyisverygood";

    public static synchronized String getKey() {
        if (TextUtils.isEmpty(channel_ad_key)) {
            List<ExtendChannel> extendChannelList = AdSdk.getInstance().getExtendChannelList();
            if (extendChannelList != null && extendChannelList.size() > 0) {
                for (ExtendChannel extendChannel : extendChannelList) {
                    if (extendChannel != null && !TextUtils.isEmpty(extendChannel.getType()) && AdPlatforms.channel.name().equals(extendChannel.getType().toLowerCase()) && !TextUtils.isEmpty(extendChannel.getKey())) {
                        channel_ad_key = extendChannel.getKey();
                    }
                }
            }
            if (TextUtils.isEmpty(channel_ad_key)) {
                channel_ad_key = default_channel_ad_key;
            }
        }
        return channel_ad_key;
    }

    public static synchronized String getUrl(String str) {
        return ApiManager.getChannelUrl(str) + "/getAd/" + AdSdk.getInstance().getAppId();
    }
}
