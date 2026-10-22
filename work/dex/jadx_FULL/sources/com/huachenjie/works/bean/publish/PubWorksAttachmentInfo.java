package com.huachenjie.works.bean.publish;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorksAttachmentInfo;", "", "video", "Lcom/huachenjie/works/bean/publish/PubWorksAttachmentVideoInfo;", "imageList", "", "Lcom/huachenjie/works/bean/publish/PubWorksAttachmentImgInfo;", "(Lcom/huachenjie/works/bean/publish/PubWorksAttachmentVideoInfo;Ljava/util/List;)V", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "getVideo", "()Lcom/huachenjie/works/bean/publish/PubWorksAttachmentVideoInfo;", "setVideo", "(Lcom/huachenjie/works/bean/publish/PubWorksAttachmentVideoInfo;)V", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorksAttachmentInfo {

    @NotNull
    private List<PubWorksAttachmentImgInfo> imageList;

    @Nullable
    private PubWorksAttachmentVideoInfo video;

    /* JADX WARN: Multi-variable type inference failed */
    public PubWorksAttachmentInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PubWorksAttachmentInfo(@Nullable PubWorksAttachmentVideoInfo pubWorksAttachmentVideoInfo, @NotNull List<PubWorksAttachmentImgInfo> list) {
        Intrinsics.checkNotNullParameter(list, "imageList");
        this.video = pubWorksAttachmentVideoInfo;
        this.imageList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PubWorksAttachmentInfo copy$default(PubWorksAttachmentInfo pubWorksAttachmentInfo, PubWorksAttachmentVideoInfo pubWorksAttachmentVideoInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            pubWorksAttachmentVideoInfo = pubWorksAttachmentInfo.video;
        }
        if ((i & 2) != 0) {
            list = pubWorksAttachmentInfo.imageList;
        }
        return pubWorksAttachmentInfo.copy(pubWorksAttachmentVideoInfo, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PubWorksAttachmentVideoInfo getVideo() {
        return this.video;
    }

    @NotNull
    public final List<PubWorksAttachmentImgInfo> component2() {
        return this.imageList;
    }

    @NotNull
    public final PubWorksAttachmentInfo copy(@Nullable PubWorksAttachmentVideoInfo video, @NotNull List<PubWorksAttachmentImgInfo> imageList) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        return new PubWorksAttachmentInfo(video, imageList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PubWorksAttachmentInfo)) {
            return false;
        }
        PubWorksAttachmentInfo pubWorksAttachmentInfo = (PubWorksAttachmentInfo) other;
        return Intrinsics.areEqual(this.video, pubWorksAttachmentInfo.video) && Intrinsics.areEqual(this.imageList, pubWorksAttachmentInfo.imageList);
    }

    @NotNull
    public final List<PubWorksAttachmentImgInfo> getImageList() {
        return this.imageList;
    }

    @Nullable
    public final PubWorksAttachmentVideoInfo getVideo() {
        return this.video;
    }

    public int hashCode() {
        PubWorksAttachmentVideoInfo pubWorksAttachmentVideoInfo = this.video;
        return ((pubWorksAttachmentVideoInfo == null ? 0 : pubWorksAttachmentVideoInfo.hashCode()) * 31) + this.imageList.hashCode();
    }

    public final void setImageList(@NotNull List<PubWorksAttachmentImgInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.imageList = list;
    }

    public final void setVideo(@Nullable PubWorksAttachmentVideoInfo pubWorksAttachmentVideoInfo) {
        this.video = pubWorksAttachmentVideoInfo;
    }

    @NotNull
    public String toString() {
        return "PubWorksAttachmentInfo(video=" + this.video + ", imageList=" + this.imageList + ')';
    }

    public /* synthetic */ PubWorksAttachmentInfo(PubWorksAttachmentVideoInfo pubWorksAttachmentVideoInfo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : pubWorksAttachmentVideoInfo, (i & 2) != 0 ? new ArrayList() : list);
    }
}
