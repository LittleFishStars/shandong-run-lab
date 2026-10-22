package com.huachenjie.channel.bean.my_channel;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020$HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$HÖ\u0001R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8VX\u0096\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u00060"}, d2 = {"Lcom/huachenjie/channel/bean/my_channel/MyChannelTopic;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "Landroid/os/Parcelable;", yj7.b.SUBJECT_NO, "", "subjectName", "subjectImg", "subjectGroupList", "", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicChat;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode$annotations", "()V", "getChildNode", "()Ljava/util/List;", "setChildNode", "(Ljava/util/List;)V", "getSubjectGroupList$annotations", "getSubjectGroupList", "getSubjectImg", "()Ljava/lang/String;", "setSubjectImg", "(Ljava/lang/String;)V", "getSubjectName", "setSubjectName", "getSubjectNo", "setSubjectNo", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyChannelTopic extends BaseExpandNode implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MyChannelTopic> CREATOR = new Creator();

    @Nullable
    private List<BaseNode> childNode;

    @NotNull
    private final List<MyChannelTopicChat> subjectGroupList;

    @NotNull
    private String subjectImg;

    @NotNull
    private String subjectName;

    @NotNull
    private String subjectNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MyChannelTopic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyChannelTopic createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MyChannelTopic(parcel.readString(), parcel.readString(), parcel.readString(), null, 8, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyChannelTopic[] newArray(int i) {
            return new MyChannelTopic[i];
        }
    }

    public MyChannelTopic() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ MyChannelTopic(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyChannelTopic copy$default(MyChannelTopic myChannelTopic, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = myChannelTopic.subjectNo;
        }
        if ((i & 2) != 0) {
            str2 = myChannelTopic.subjectName;
        }
        if ((i & 4) != 0) {
            str3 = myChannelTopic.subjectImg;
        }
        if ((i & 8) != 0) {
            list = myChannelTopic.subjectGroupList;
        }
        return myChannelTopic.copy(str, str2, str3, list);
    }

    public static /* synthetic */ void getChildNode$annotations() {
    }

    public static /* synthetic */ void getSubjectGroupList$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectImg() {
        return this.subjectImg;
    }

    @NotNull
    public final List<MyChannelTopicChat> component4() {
        return this.subjectGroupList;
    }

    @NotNull
    public final MyChannelTopic copy(@NotNull String subjectNo, @NotNull String subjectName, @NotNull String subjectImg, @NotNull List<MyChannelTopicChat> subjectGroupList) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(subjectImg, "subjectImg");
        Intrinsics.checkNotNullParameter(subjectGroupList, "subjectGroupList");
        return new MyChannelTopic(subjectNo, subjectName, subjectImg, subjectGroupList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyChannelTopic)) {
            return false;
        }
        MyChannelTopic myChannelTopic = (MyChannelTopic) other;
        return Intrinsics.areEqual(this.subjectNo, myChannelTopic.subjectNo) && Intrinsics.areEqual(this.subjectName, myChannelTopic.subjectName) && Intrinsics.areEqual(this.subjectImg, myChannelTopic.subjectImg) && Intrinsics.areEqual(this.subjectGroupList, myChannelTopic.subjectGroupList);
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        if (this.childNode == null) {
            this.childNode = CollectionsKt.toMutableList(this.subjectGroupList);
        }
        return this.childNode;
    }

    @NotNull
    public final List<MyChannelTopicChat> getSubjectGroupList() {
        return this.subjectGroupList;
    }

    @NotNull
    public final String getSubjectImg() {
        return this.subjectImg;
    }

    @NotNull
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    public int hashCode() {
        return (((((this.subjectNo.hashCode() * 31) + this.subjectName.hashCode()) * 31) + this.subjectImg.hashCode()) * 31) + this.subjectGroupList.hashCode();
    }

    public void setChildNode(@Nullable List<BaseNode> list) {
        this.childNode = list;
    }

    public final void setSubjectImg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectImg = str;
    }

    public final void setSubjectName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectName = str;
    }

    public final void setSubjectNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectNo = str;
    }

    @NotNull
    public String toString() {
        return "MyChannelTopic(subjectNo=" + this.subjectNo + ", subjectName=" + this.subjectName + ", subjectImg=" + this.subjectImg + ", subjectGroupList=" + this.subjectGroupList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.subjectNo);
        parcel.writeString(this.subjectName);
        parcel.writeString(this.subjectImg);
    }

    public MyChannelTopic(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<MyChannelTopicChat> list) {
        Intrinsics.checkNotNullParameter(str, yj7.b.SUBJECT_NO);
        Intrinsics.checkNotNullParameter(str2, "subjectName");
        Intrinsics.checkNotNullParameter(str3, "subjectImg");
        Intrinsics.checkNotNullParameter(list, "subjectGroupList");
        this.subjectNo = str;
        this.subjectName = str2;
        this.subjectImg = str3;
        this.subjectGroupList = list;
    }
}
