package com.huachenjie.channel.bean;

import com.huachenjie.base.bean.ImageBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/channel/bean/PublishClubMsgRequestBean;", "", "messageTitle", "", "clubCode", "messageContent", "imgList", "", "Lcom/huachenjie/base/bean/ImageBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getClubCode", "()Ljava/lang/String;", "getImgList", "()Ljava/util/List;", "getMessageContent", "getMessageTitle", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PublishClubMsgRequestBean {

    @NotNull
    private final String clubCode;

    @NotNull
    private final List<ImageBean> imgList;

    @NotNull
    private final String messageContent;

    @NotNull
    private final String messageTitle;

    public PublishClubMsgRequestBean() {
        this(null, null, null, null, 15, null);
    }

    public PublishClubMsgRequestBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<ImageBean> list) {
        Intrinsics.checkNotNullParameter(str, "messageTitle");
        Intrinsics.checkNotNullParameter(str2, "clubCode");
        Intrinsics.checkNotNullParameter(str3, "messageContent");
        Intrinsics.checkNotNullParameter(list, "imgList");
        this.messageTitle = str;
        this.clubCode = str2;
        this.messageContent = str3;
        this.imgList = list;
    }

    @NotNull
    public final String getClubCode() {
        return this.clubCode;
    }

    @NotNull
    public final List<ImageBean> getImgList() {
        return this.imgList;
    }

    @NotNull
    public final String getMessageContent() {
        return this.messageContent;
    }

    @NotNull
    public final String getMessageTitle() {
        return this.messageTitle;
    }

    public /* synthetic */ PublishClubMsgRequestBean(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}
