package com.huachenjie.works.bean.publish;

import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorksAttachmentImgInfo;", "Lcom/huachenjie/works/bean/publish/PubWorksAttachmentVideoInfo;", "path", "", AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, "", "coverType", "", "(Ljava/lang/String;ZI)V", "getCover", "()Z", "setCover", "(Z)V", "getCoverType", "()I", "setCoverType", "(I)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorksAttachmentImgInfo extends PubWorksAttachmentVideoInfo {
    private boolean cover;
    private int coverType;

    @NotNull
    private String path;

    public PubWorksAttachmentImgInfo() {
        this(null, false, 0, 7, null);
    }

    public /* synthetic */ PubWorksAttachmentImgInfo(String str, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ PubWorksAttachmentImgInfo copy$default(PubWorksAttachmentImgInfo pubWorksAttachmentImgInfo, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pubWorksAttachmentImgInfo.path;
        }
        if ((i2 & 2) != 0) {
            z = pubWorksAttachmentImgInfo.cover;
        }
        if ((i2 & 4) != 0) {
            i = pubWorksAttachmentImgInfo.coverType;
        }
        return pubWorksAttachmentImgInfo.copy(str, z, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCover() {
        return this.cover;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCoverType() {
        return this.coverType;
    }

    @NotNull
    public final PubWorksAttachmentImgInfo copy(@NotNull String path, boolean cover, int coverType) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new PubWorksAttachmentImgInfo(path, cover, coverType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PubWorksAttachmentImgInfo)) {
            return false;
        }
        PubWorksAttachmentImgInfo pubWorksAttachmentImgInfo = (PubWorksAttachmentImgInfo) other;
        return Intrinsics.areEqual(this.path, pubWorksAttachmentImgInfo.path) && this.cover == pubWorksAttachmentImgInfo.cover && this.coverType == pubWorksAttachmentImgInfo.coverType;
    }

    public final boolean getCover() {
        return this.cover;
    }

    public final int getCoverType() {
        return this.coverType;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = this.path.hashCode() * 31;
        boolean z = this.cover;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + Integer.hashCode(this.coverType);
    }

    public final void setCover(boolean z) {
        this.cover = z;
    }

    public final void setCoverType(int i) {
        this.coverType = i;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    @NotNull
    public String toString() {
        return "PubWorksAttachmentImgInfo(path=" + this.path + ", cover=" + this.cover + ", coverType=" + this.coverType + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PubWorksAttachmentImgInfo(@NotNull String str, boolean z, int i) {
        super(null, null, 0, 0, 15, null);
        Intrinsics.checkNotNullParameter(str, "path");
        this.path = str;
        this.cover = z;
        this.coverType = i;
    }
}
