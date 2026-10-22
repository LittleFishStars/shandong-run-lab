package com.huachenjie.channel.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/bean/BaseChannelBean;", "", "()V", "avatarList", "", "", "getAvatarList", "()Ljava/util/List;", "channelName", "getChannelName", "()Ljava/lang/String;", "channelNo", "getChannelNo", "channelUserValue", "getChannelUserValue", "coverUrl", "getCoverUrl", "popularityValue", "getPopularityValue", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseChannelBean {

    @NotNull
    private final String channelName = "";

    @NotNull
    private final String channelNo = "";

    @NotNull
    private final String coverUrl = "";

    @NotNull
    private final String channelUserValue = "";

    @NotNull
    private final String popularityValue = "";

    @NotNull
    private final List<String> avatarList = new ArrayList();

    @NotNull
    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getChannelUserValue() {
        return this.channelUserValue;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }
}
