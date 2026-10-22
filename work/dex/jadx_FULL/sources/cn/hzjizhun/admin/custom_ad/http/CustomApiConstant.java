package cn.hzjizhun.admin.custom_ad.http;

import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.bean.ExtendChannel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomApiConstant {
    private static volatile String channel_ad_key = null;
    private static final String default_channel_ad_key = "aeskeyisverygood";

    public static synchronized String getKey() {
        if (TextUtils.isEmpty(channel_ad_key)) {
            List<ExtendChannel> extendChannelList = JZAdSdk.getInstance().getExtendChannelList();
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

    public static synchronized String getOutFunctionInsertScreenUrl(String str) {
        return FunctionConfig.instance().getChannelUrl(str) + "/getInFuction/" + JZAdSdk.getInstance().getAppId();
    }

    public static synchronized String getOutFunctionUrl(String str) {
        return FunctionConfig.instance().getChannelUrl(str) + "/getOutFuction/" + JZAdSdk.getInstance().getAppId();
    }

    public static synchronized String getUrl(String str) {
        return FunctionConfig.instance().getChannelUrl(str) + "/getAd/" + JZAdSdk.getInstance().getAppId();
    }
}
