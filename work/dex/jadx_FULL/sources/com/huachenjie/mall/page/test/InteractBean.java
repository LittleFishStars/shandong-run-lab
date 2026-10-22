package com.huachenjie.mall.page.test;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u00062"}, d2 = {"Lcom/huachenjie/mall/page/test/InteractBean;", "Landroid/os/Parcelable;", "collected", "", "collecteCount", "", "commentCount", "followed", "liked", "likeCount", "shareCount", "(ZIIZZII)V", "getCollecteCount", "()I", "setCollecteCount", "(I)V", "getCollected", "()Z", "setCollected", "(Z)V", "getCommentCount", "setCommentCount", "getFollowed", "setFollowed", "getLikeCount", "setLikeCount", "getLiked", "setLiked", "getShareCount", "setShareCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InteractBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<InteractBean> CREATOR = new a();
    private int collecteCount;
    private boolean collected;
    private int commentCount;
    private boolean followed;
    private int likeCount;
    private boolean liked;
    private int shareCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<InteractBean> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InteractBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InteractBean(parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final InteractBean[] newArray(int i) {
            return new InteractBean[i];
        }
    }

    public InteractBean() {
        this(false, 0, 0, false, false, 0, 0, 127, null);
    }

    public InteractBean(boolean z, int i, int i2, boolean z2, boolean z3, int i3, int i4) {
        this.collected = z;
        this.collecteCount = i;
        this.commentCount = i2;
        this.followed = z2;
        this.liked = z3;
        this.likeCount = i3;
        this.shareCount = i4;
    }

    public static /* synthetic */ InteractBean copy$default(InteractBean interactBean, boolean z, int i, int i2, boolean z2, boolean z3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z = interactBean.collected;
        }
        if ((i5 & 2) != 0) {
            i = interactBean.collecteCount;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = interactBean.commentCount;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            z2 = interactBean.followed;
        }
        boolean z4 = z2;
        if ((i5 & 16) != 0) {
            z3 = interactBean.liked;
        }
        boolean z5 = z3;
        if ((i5 & 32) != 0) {
            i3 = interactBean.likeCount;
        }
        int i8 = i3;
        if ((i5 & 64) != 0) {
            i4 = interactBean.shareCount;
        }
        return interactBean.copy(z, i6, i7, z4, z5, i8, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCollected() {
        return this.collected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCollecteCount() {
        return this.collecteCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCommentCount() {
        return this.commentCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFollowed() {
        return this.followed;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getShareCount() {
        return this.shareCount;
    }

    @NotNull
    public final InteractBean copy(boolean collected, int collecteCount, int commentCount, boolean followed, boolean liked, int likeCount, int shareCount) {
        return new InteractBean(collected, collecteCount, commentCount, followed, liked, likeCount, shareCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractBean)) {
            return false;
        }
        InteractBean interactBean = (InteractBean) other;
        return this.collected == interactBean.collected && this.collecteCount == interactBean.collecteCount && this.commentCount == interactBean.commentCount && this.followed == interactBean.followed && this.liked == interactBean.liked && this.likeCount == interactBean.likeCount && this.shareCount == interactBean.shareCount;
    }

    public final int getCollecteCount() {
        return this.collecteCount;
    }

    public final boolean getCollected() {
        return this.collected;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z = this.collected;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((r0 * 31) + Integer.hashCode(this.collecteCount)) * 31) + Integer.hashCode(this.commentCount)) * 31;
        boolean z2 = this.followed;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.liked;
        return ((((i + (z3 ? 1 : z3)) * 31) + Integer.hashCode(this.likeCount)) * 31) + Integer.hashCode(this.shareCount);
    }

    public final void setCollecteCount(int i) {
        this.collecteCount = i;
    }

    public final void setCollected(boolean z) {
        this.collected = z;
    }

    public final void setCommentCount(int i) {
        this.commentCount = i;
    }

    public final void setFollowed(boolean z) {
        this.followed = z;
    }

    public final void setLikeCount(int i) {
        this.likeCount = i;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
    }

    public final void setShareCount(int i) {
        this.shareCount = i;
    }

    @NotNull
    public String toString() {
        return "InteractBean(collected=" + this.collected + ", collecteCount=" + this.collecteCount + ", commentCount=" + this.commentCount + ", followed=" + this.followed + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", shareCount=" + this.shareCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.collected ? 1 : 0);
        parcel.writeInt(this.collecteCount);
        parcel.writeInt(this.commentCount);
        parcel.writeInt(this.followed ? 1 : 0);
        parcel.writeInt(this.liked ? 1 : 0);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.shareCount);
    }

    public /* synthetic */ InteractBean(boolean z, int i, int i2, boolean z2, boolean z3, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? false : z2, (i5 & 16) != 0 ? false : z3, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? 0 : i4);
    }
}
