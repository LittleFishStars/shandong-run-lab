package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.ipd.dsp.internal.e1.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e¢\u0006\u0002\u0010\u0012J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u0010HÆ\u0003Js\u00100\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000eHÆ\u0001J\t\u00101\u001a\u00020\u0010HÖ\u0001J\u0013\u00102\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0010HÖ\u0001J\t\u00106\u001a\u00020\u0006HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001e¨\u0006<"}, d2 = {"Lcom/huachenjie/works/bean/PostInfoBean;", "Landroid/os/Parcelable;", "imageList", "", "Lcom/huachenjie/works/bean/PostImageBean;", "postNo", "", "submitTime", "", "intervalTime", "content", "tag", "redPacket", "liked", "", "likeCount", "", f.l, "(Ljava/util/List;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZ)V", "getContent", "()Ljava/lang/String;", "getImageList", "()Ljava/util/List;", "getIntervalTime", "()J", "getLikeCount", "()I", "setLikeCount", "(I)V", "getLiked", "()Z", "setLiked", "(Z)V", "getPostNo", "getRedPacket", "getSubmitTime", "getTag", "getTop", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostInfoBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PostInfoBean> CREATOR = new Creator();

    @NotNull
    private final String content;

    @NotNull
    private final List<PostImageBean> imageList;
    private final long intervalTime;
    private int likeCount;
    private boolean liked;

    @NotNull
    private final String postNo;

    @NotNull
    private final String redPacket;
    private final long submitTime;

    @NotNull
    private final String tag;
    private final boolean top;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PostInfoBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostInfoBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PostImageBean.CREATOR.createFromParcel(parcel));
            }
            return new PostInfoBean(arrayList, parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostInfoBean[] newArray(int i) {
            return new PostInfoBean[i];
        }
    }

    public PostInfoBean() {
        this(null, null, 0L, 0L, null, null, null, false, 0, false, 1023, null);
    }

    public PostInfoBean(@NotNull List<PostImageBean> list, @NotNull String str, long j, long j2, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(str, "postNo");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "tag");
        Intrinsics.checkNotNullParameter(str4, "redPacket");
        this.imageList = list;
        this.postNo = str;
        this.submitTime = j;
        this.intervalTime = j2;
        this.content = str2;
        this.tag = str3;
        this.redPacket = str4;
        this.liked = z;
        this.likeCount = i;
        this.top = z2;
    }

    @NotNull
    public final List<PostImageBean> component1() {
        return this.imageList;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getTop() {
        return this.top;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPostNo() {
        return this.postNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getIntervalTime() {
        return this.intervalTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRedPacket() {
        return this.redPacket;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final PostInfoBean copy(@NotNull List<PostImageBean> imageList, @NotNull String postNo, long submitTime, long intervalTime, @NotNull String content, @NotNull String tag, @NotNull String redPacket, boolean liked, int likeCount, boolean top) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(redPacket, "redPacket");
        return new PostInfoBean(imageList, postNo, submitTime, intervalTime, content, tag, redPacket, liked, likeCount, top);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostInfoBean)) {
            return false;
        }
        PostInfoBean postInfoBean = (PostInfoBean) other;
        return Intrinsics.areEqual(this.imageList, postInfoBean.imageList) && Intrinsics.areEqual(this.postNo, postInfoBean.postNo) && this.submitTime == postInfoBean.submitTime && this.intervalTime == postInfoBean.intervalTime && Intrinsics.areEqual(this.content, postInfoBean.content) && Intrinsics.areEqual(this.tag, postInfoBean.tag) && Intrinsics.areEqual(this.redPacket, postInfoBean.redPacket) && this.liked == postInfoBean.liked && this.likeCount == postInfoBean.likeCount && this.top == postInfoBean.top;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<PostImageBean> getImageList() {
        return this.imageList;
    }

    public final long getIntervalTime() {
        return this.intervalTime;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    public final String getPostNo() {
        return this.postNo;
    }

    @NotNull
    public final String getRedPacket() {
        return this.redPacket;
    }

    public final long getSubmitTime() {
        return this.submitTime;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public final boolean getTop() {
        return this.top;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.imageList.hashCode() * 31) + this.postNo.hashCode()) * 31) + Long.hashCode(this.submitTime)) * 31) + Long.hashCode(this.intervalTime)) * 31) + this.content.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.redPacket.hashCode()) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + Integer.hashCode(this.likeCount)) * 31;
        boolean z2 = this.top;
        return iHashCode2 + (z2 ? 1 : z2);
    }

    public final void setLikeCount(int i) {
        this.likeCount = i;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
    }

    @NotNull
    public String toString() {
        return "PostInfoBean(imageList=" + this.imageList + ", postNo=" + this.postNo + ", submitTime=" + this.submitTime + ", intervalTime=" + this.intervalTime + ", content=" + this.content + ", tag=" + this.tag + ", redPacket=" + this.redPacket + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", top=" + this.top + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<PostImageBean> list = this.imageList;
        parcel.writeInt(list.size());
        Iterator<PostImageBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.postNo);
        parcel.writeLong(this.submitTime);
        parcel.writeLong(this.intervalTime);
        parcel.writeString(this.content);
        parcel.writeString(this.tag);
        parcel.writeString(this.redPacket);
        parcel.writeInt(this.liked ? 1 : 0);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.top ? 1 : 0);
    }

    public /* synthetic */ PostInfoBean(List list, String str, long j, long j2, String str2, String str3, String str4, boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j, (i2 & 8) == 0 ? j2 : 0L, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? "" : str3, (i2 & 64) == 0 ? str4 : "", (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? 0 : i, (i2 & 512) == 0 ? z2 : false);
    }
}
