package com.huachenjie.mall.bean.goods_detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailOneGoodsComment;", "Landroid/os/Parcelable;", "commentInfo", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailCommentInfo;", UserConstants.USER_PARAMS.b, "", AvatarFragment.AVATAR_URL, "goodsCommentCount", "", "status", "", "(Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailCommentInfo;Ljava/lang/String;Ljava/lang/String;IZ)V", "getAvatarUrl", "()Ljava/lang/String;", "getCommentInfo", "()Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailCommentInfo;", "getGoodsCommentCount", "()I", "getNickName", "getStatus", "()Z", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsDetailOneGoodsComment implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailOneGoodsComment> CREATOR = new Creator();

    @Nullable
    private final String avatarUrl;

    @Nullable
    private final GoodsDetailCommentInfo commentInfo;
    private final int goodsCommentCount;

    @Nullable
    private final String nickName;
    private final boolean status;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailOneGoodsComment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailOneGoodsComment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoodsDetailOneGoodsComment(parcel.readInt() == 0 ? null : GoodsDetailCommentInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailOneGoodsComment[] newArray(int i) {
            return new GoodsDetailOneGoodsComment[i];
        }
    }

    public GoodsDetailOneGoodsComment() {
        this(null, null, null, 0, false, 31, null);
    }

    public GoodsDetailOneGoodsComment(@Nullable GoodsDetailCommentInfo goodsDetailCommentInfo, @Nullable String str, @Nullable String str2, int i, boolean z) {
        this.commentInfo = goodsDetailCommentInfo;
        this.nickName = str;
        this.avatarUrl = str2;
        this.goodsCommentCount = i;
        this.status = z;
    }

    public static /* synthetic */ GoodsDetailOneGoodsComment copy$default(GoodsDetailOneGoodsComment goodsDetailOneGoodsComment, GoodsDetailCommentInfo goodsDetailCommentInfo, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            goodsDetailCommentInfo = goodsDetailOneGoodsComment.commentInfo;
        }
        if ((i2 & 2) != 0) {
            str = goodsDetailOneGoodsComment.nickName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = goodsDetailOneGoodsComment.avatarUrl;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = goodsDetailOneGoodsComment.goodsCommentCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z = goodsDetailOneGoodsComment.status;
        }
        return goodsDetailOneGoodsComment.copy(goodsDetailCommentInfo, str3, str4, i3, z);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GoodsDetailCommentInfo getCommentInfo() {
        return this.commentInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getGoodsCommentCount() {
        return this.goodsCommentCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    @NotNull
    public final GoodsDetailOneGoodsComment copy(@Nullable GoodsDetailCommentInfo commentInfo, @Nullable String nickName, @Nullable String avatarUrl, int goodsCommentCount, boolean status) {
        return new GoodsDetailOneGoodsComment(commentInfo, nickName, avatarUrl, goodsCommentCount, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailOneGoodsComment)) {
            return false;
        }
        GoodsDetailOneGoodsComment goodsDetailOneGoodsComment = (GoodsDetailOneGoodsComment) other;
        return Intrinsics.areEqual(this.commentInfo, goodsDetailOneGoodsComment.commentInfo) && Intrinsics.areEqual(this.nickName, goodsDetailOneGoodsComment.nickName) && Intrinsics.areEqual(this.avatarUrl, goodsDetailOneGoodsComment.avatarUrl) && this.goodsCommentCount == goodsDetailOneGoodsComment.goodsCommentCount && this.status == goodsDetailOneGoodsComment.status;
    }

    @Nullable
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Nullable
    public final GoodsDetailCommentInfo getCommentInfo() {
        return this.commentInfo;
    }

    public final int getGoodsCommentCount() {
        return this.goodsCommentCount;
    }

    @Nullable
    public final String getNickName() {
        return this.nickName;
    }

    public final boolean getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        GoodsDetailCommentInfo goodsDetailCommentInfo = this.commentInfo;
        int iHashCode = (goodsDetailCommentInfo == null ? 0 : goodsDetailCommentInfo.hashCode()) * 31;
        String str = this.nickName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatarUrl;
        int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.goodsCommentCount)) * 31;
        boolean z = this.status;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    @NotNull
    public String toString() {
        return "GoodsDetailOneGoodsComment(commentInfo=" + this.commentInfo + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", goodsCommentCount=" + this.goodsCommentCount + ", status=" + this.status + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        GoodsDetailCommentInfo goodsDetailCommentInfo = this.commentInfo;
        if (goodsDetailCommentInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            goodsDetailCommentInfo.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatarUrl);
        parcel.writeInt(this.goodsCommentCount);
        parcel.writeInt(this.status ? 1 : 0);
    }

    public /* synthetic */ GoodsDetailOneGoodsComment(GoodsDetailCommentInfo goodsDetailCommentInfo, String str, String str2, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : goodsDetailCommentInfo, (i2 & 2) != 0 ? null : str, (i2 & 4) == 0 ? str2 : null, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z);
    }
}
