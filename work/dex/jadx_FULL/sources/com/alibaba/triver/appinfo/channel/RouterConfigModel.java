package com.alibaba.triver.appinfo.channel;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RouterConfigModel implements Serializable {
    public Map<String, ChannelModel> channels;
    public String defaultChannel;
    public String deployVersion;
    public String protocolVersion;
    public List<PriorityModel> routerStrategies;

    public static class BasePriority implements Serializable {
        public String channelName;
    }

    public static class ChannelModel implements Serializable {
        public String api;
        public GuardConfig guardConfig;
        public String name;
        public String onlineHost;
        public String preHost;
        public String type;
        public String version;
    }

    public static class GuardConfig implements Serializable {
        public String channel;
        public List<String> errorCode;
    }

    public static class PriorityModel implements Serializable {
        public List<BasePriority> data;
        public String name;
        public int weight;
    }

    public static class RatioPriority extends BasePriority {
        public int ratioEnd;
        public int ratioStart;
    }

    public static class UrlParamsPriority extends RatioPriority {
        public String containsQuery;
    }

    public static class WhiteListPriority extends BasePriority {
        public List<String> appIds;
    }

    public ChannelModel findChannelByName(String str) {
        if (this.channels == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.channels.get(str);
    }

    public ChannelModel getDefaultChannel() {
        return findChannelByName(this.defaultChannel);
    }
}
