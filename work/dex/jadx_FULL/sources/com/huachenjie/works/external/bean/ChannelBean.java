package com.huachenjie.works.external.bean;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.works.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0019\u001a\u00020\u0001J\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/external/bean/ChannelBean;", "", "coverImgUrl", "", "channelName", "channelNo", "avatar", "popularityValue", "followedCount", "channelType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAvatar", "()Ljava/lang/String;", "getChannelName", "getChannelNo", "getChannelType", "()I", "getCoverImgUrl", "getFollowedCount", "formatterFollowedCount", "getFormatterFollowedCount", "formatterPopularity", "getFormatterPopularity", "getPopularityValue", "formatCoverUrl", "showOfficial", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChannelBean {

    @NotNull
    private final String avatar;

    @NotNull
    private final String channelName;

    @NotNull
    private final String channelNo;
    private final int channelType;

    @NotNull
    private final String coverImgUrl;

    @NotNull
    private final String followedCount;

    @NotNull
    private final String popularityValue;

    public ChannelBean() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    public ChannelBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i) {
        Intrinsics.checkNotNullParameter(str, "coverImgUrl");
        Intrinsics.checkNotNullParameter(str2, "channelName");
        Intrinsics.checkNotNullParameter(str3, "channelNo");
        Intrinsics.checkNotNullParameter(str4, "avatar");
        Intrinsics.checkNotNullParameter(str5, "popularityValue");
        Intrinsics.checkNotNullParameter(str6, "followedCount");
        this.coverImgUrl = str;
        this.channelName = str2;
        this.channelNo = str3;
        this.avatar = str4;
        this.popularityValue = str5;
        this.followedCount = str6;
        this.channelType = i;
    }

    @NotNull
    public final Object formatCoverUrl() {
        return TextUtils.isEmpty(this.coverImgUrl) ? Integer.valueOf(R.drawable.works_bg_channel_image_placeholder) : this.coverImgUrl;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    public final String getFollowedCount() {
        return this.followedCount;
    }

    @NotNull
    public final String getFormatterFollowedCount() {
        String string = Utils.a().getString(R.string.works_search_search_channel_follow, this.followedCount);
        Intrinsics.checkNotNullExpressionValue(string, "getApp()\n               …el_follow, followedCount)");
        return string;
    }

    @NotNull
    public final String getFormatterPopularity() {
        String string = Utils.a().getString(R.string.works_search_search_channel_hot, this.popularityValue);
        Intrinsics.checkNotNullExpressionValue(string, "getApp()\n               …nel_hot, popularityValue)");
        return string;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    public final boolean showOfficial() {
        int i = this.channelType;
        return i == 1 || i == 2 || i == 3;
    }

    public /* synthetic */ ChannelBean(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) == 0 ? str6 : "", (i2 & 64) != 0 ? 0 : i);
    }
}
