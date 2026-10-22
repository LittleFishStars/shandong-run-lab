package com.huachenjie.works.external.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.m.c0.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.works.R;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b.\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B«\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b¢\u0006\u0002\u0010\u0018J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020\u0004H\u0002J\u0006\u0010C\u001a\u00020\u0006J\u0006\u0010D\u001a\u00020\bJ\u0006\u0010E\u001a\u00020>J\u0006\u0010F\u001a\u00020\u0006J\u0006\u0010G\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\u0006J\u0006\u0010I\u001a\u00020\u0006J\u0006\u0010J\u001a\u00020\u0004J\u0006\u0010K\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020\u0004J\u0006\u0010M\u001a\u00020\u0004J\u0006\u0010N\u001a\u00020\u0004J\u0006\u0010O\u001a\u00020\u0004J\u0006\u0010P\u001a\u00020\u0004J\u0006\u0010Q\u001a\u00020\u0004J\u0006\u0010R\u001a\u00020\u0004J\u0019\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010-R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001e¨\u0006X"}, d2 = {"Lcom/huachenjie/works/external/bean/WorkItemBean;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "violation", "", "workSize", "", yj7.g.WORKS_NO, "", "type", "woksType", "coverImg", "Lcom/huachenjie/works/external/bean/WorkCoverBean;", "title", "tagList", "", "avatar", "userName", "popularityValue", "attachmentType", "contactsFlag", "relation", "visit", "categoryTag", "(ZILjava/lang/String;IILcom/huachenjie/works/external/bean/WorkCoverBean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;)V", "getAttachmentType", "()I", "setAttachmentType", "(I)V", "getAvatar", "()Ljava/lang/String;", "getCategoryTag", "getContactsFlag", "getCoverImg", "()Lcom/huachenjie/works/external/bean/WorkCoverBean;", "setCoverImg", "(Lcom/huachenjie/works/external/bean/WorkCoverBean;)V", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "getPopularityValue", "getRelation", "getTagList", "()Ljava/util/List;", "getTitle", d.p, "(Ljava/lang/String;)V", "getType", "getUserName", "getViolation", "()Z", "setViolation", "(Z)V", "getVisit", "setVisit", "getWoksType", "getWorkSize", "setWorkSize", "getWorksNo", "describeContents", "formatAttentionIcon", "formatAttentionTag", "formatChannelName", "", "formatCoverUrl", "", "formatIsAttention", "formatIsContact", "formatTagBackground", "formatTagText", "formatTitle", "formatViolationIcon", "formatViolationText", "getHeight", "getWidth", "showAttentionTag", "showCategoryTag", "showChannelName", "showImage", "showLocalVideoIcon", "showTag", "showTitle", "showVideoIcon", "showViolation", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class WorkItemBean implements Parcelable, MultiItemEntity {

    @NotNull
    public static final Parcelable.Creator<WorkItemBean> CREATOR = new Creator();
    private int attachmentType;

    @NotNull
    private final String avatar;

    @NotNull
    private final String categoryTag;
    private final int contactsFlag;

    @NotNull
    private WorkCoverBean coverImg;

    @NotNull
    private final String popularityValue;
    private final int relation;

    @NotNull
    private final List<String> tagList;

    @NotNull
    private String title;
    private final int type;

    @NotNull
    private final String userName;
    private boolean violation;
    private int visit;
    private final int woksType;
    private int workSize;

    @NotNull
    private final String worksNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WorkItemBean(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), WorkCoverBean.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkItemBean[] newArray(int i) {
            return new WorkItemBean[i];
        }
    }

    public WorkItemBean() {
        this(false, 0, null, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, null, 65535, null);
    }

    public WorkItemBean(boolean z, int i, @NotNull String str, int i2, int i3, @NotNull WorkCoverBean workCoverBean, @NotNull String str2, @NotNull List<String> list, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i4, int i5, int i6, int i7, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(workCoverBean, "coverImg");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "tagList");
        Intrinsics.checkNotNullParameter(str3, "avatar");
        Intrinsics.checkNotNullParameter(str4, "userName");
        Intrinsics.checkNotNullParameter(str5, "popularityValue");
        Intrinsics.checkNotNullParameter(str6, "categoryTag");
        this.violation = z;
        this.workSize = i;
        this.worksNo = str;
        this.type = i2;
        this.woksType = i3;
        this.coverImg = workCoverBean;
        this.title = str2;
        this.tagList = list;
        this.avatar = str3;
        this.userName = str4;
        this.popularityValue = str5;
        this.attachmentType = i4;
        this.contactsFlag = i5;
        this.relation = i6;
        this.visit = i7;
        this.categoryTag = str6;
    }

    private final boolean formatIsAttention() {
        int i = this.relation;
        return i == 2 || i == 3;
    }

    private final boolean formatIsContact() {
        int i = this.contactsFlag;
        return i == 1 || i == 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int formatAttentionIcon() {
        if (formatIsContact()) {
            return R.drawable.works_ic_item_work_relation_friend;
        }
        if (formatIsAttention()) {
            return R.drawable.works_ic_item_work_relation_attention;
        }
        return 0;
    }

    @NotNull
    public final String formatAttentionTag() {
        if (formatIsContact()) {
            return "我的好友";
        }
        return formatIsAttention() ? "关注的TA" : "";
    }

    @NotNull
    public final CharSequence formatChannelName() {
        if (this.type == 6 || this.tagList.isEmpty() || TextUtils.isEmpty(this.tagList.get(0))) {
            return "";
        }
        return '@' + this.tagList.get(0);
    }

    @NotNull
    public final Object formatCoverUrl() {
        if (this.type != 1 && TextUtils.isEmpty(this.coverImg.getPath())) {
            return Integer.valueOf(R.drawable.works_bg_work_image_placeholder);
        }
        return this.coverImg.getPath();
    }

    public final int formatTagBackground() {
        if (this.woksType == 1) {
            return R.drawable.works_bg_item_tag_official;
        }
        if (this.violation) {
            return R.drawable.works_bg_item_tag_violation;
        }
        return 0;
    }

    @NotNull
    public final String formatTagText() {
        if (this.woksType == 1) {
            return "官方";
        }
        return this.violation ? "违规" : "";
    }

    @NotNull
    public final CharSequence formatTitle() {
        if (TextUtils.isEmpty(this.title)) {
            return "";
        }
        int i = this.type;
        if (i != 1) {
            if (i == 2) {
                return '#' + this.title;
            }
            if (i == 3) {
                return '@' + this.title;
            }
            if (i != 6) {
                return "";
            }
        }
        return this.title;
    }

    public final int formatViolationIcon() {
        int i = this.attachmentType;
        if (i == 1) {
            return R.drawable.works_ic_work_violation_image;
        }
        if (i != 2) {
            return 0;
        }
        return R.drawable.works_ic_work_violation_video;
    }

    @NotNull
    public final String formatViolationText() {
        int i = this.attachmentType;
        if (i != 1) {
            return i != 2 ? "" : "视频违规已被删除";
        }
        return "照片违规已被删除";
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getCategoryTag() {
        return this.categoryTag;
    }

    public final int getContactsFlag() {
        return this.contactsFlag;
    }

    @NotNull
    public final WorkCoverBean getCoverImg() {
        return this.coverImg;
    }

    public final int getHeight() {
        return this.coverImg.getHeight();
    }

    public int getItemType() {
        return 0;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    public final int getRelation() {
        return this.relation;
    }

    @NotNull
    public final List<String> getTagList() {
        return this.tagList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    public final boolean getViolation() {
        return this.violation;
    }

    public final int getVisit() {
        return this.visit;
    }

    public final int getWidth() {
        return this.coverImg.getWidth();
    }

    public final int getWoksType() {
        return this.woksType;
    }

    public final int getWorkSize() {
        return this.workSize;
    }

    @NotNull
    public final String getWorksNo() {
        return this.worksNo;
    }

    public final void setAttachmentType(int i) {
        this.attachmentType = i;
    }

    public final void setCoverImg(@NotNull WorkCoverBean workCoverBean) {
        Intrinsics.checkNotNullParameter(workCoverBean, "<set-?>");
        this.coverImg = workCoverBean;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setViolation(boolean z) {
        this.violation = z;
    }

    public final void setVisit(int i) {
        this.visit = i;
    }

    public final void setWorkSize(int i) {
        this.workSize = i;
    }

    public final boolean showAttentionTag() {
        return formatIsContact() || formatIsAttention();
    }

    public final boolean showCategoryTag() {
        return !TextUtils.isEmpty(this.categoryTag);
    }

    public final boolean showChannelName() {
        return !TextUtils.isEmpty(formatChannelName());
    }

    public final boolean showImage() {
        if (this.type == 1) {
            return !TextUtils.isEmpty(this.coverImg.getPath());
        }
        return true;
    }

    public final boolean showLocalVideoIcon() {
        return showImage() && showVideoIcon();
    }

    public final boolean showTag() {
        return this.woksType == 1 || this.violation;
    }

    public final boolean showTitle() {
        return !TextUtils.isEmpty(formatTitle());
    }

    public final boolean showVideoIcon() {
        return this.attachmentType == 2;
    }

    public final boolean showViolation() {
        if (this.type == 1) {
            return this.coverImg.getStatus() != 0 || TextUtils.isEmpty(this.coverImg.getPath());
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.violation ? 1 : 0);
        parcel.writeInt(this.workSize);
        parcel.writeString(this.worksNo);
        parcel.writeInt(this.type);
        parcel.writeInt(this.woksType);
        this.coverImg.writeToParcel(parcel, flags);
        parcel.writeString(this.title);
        parcel.writeStringList(this.tagList);
        parcel.writeString(this.avatar);
        parcel.writeString(this.userName);
        parcel.writeString(this.popularityValue);
        parcel.writeInt(this.attachmentType);
        parcel.writeInt(this.contactsFlag);
        parcel.writeInt(this.relation);
        parcel.writeInt(this.visit);
        parcel.writeString(this.categoryTag);
    }

    public /* synthetic */ WorkItemBean(boolean z, int i, String str, int i2, int i3, WorkCoverBean workCoverBean, String str2, List list, String str3, String str4, String str5, int i4, int i5, int i6, int i7, String str6, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z, (i8 & 2) != 0 ? 0 : i, (i8 & 4) != 0 ? "" : str, (i8 & 8) != 0 ? 0 : i2, (i8 & 16) != 0 ? 0 : i3, (i8 & 32) != 0 ? new WorkCoverBean(null, 0, 0, 0, 15, null) : workCoverBean, (i8 & 64) != 0 ? "" : str2, (i8 & 128) != 0 ? new ArrayList() : list, (i8 & 256) != 0 ? "" : str3, (i8 & 512) != 0 ? "" : str4, (i8 & 1024) != 0 ? "" : str5, (i8 & 2048) != 0 ? 0 : i4, (i8 & 4096) != 0 ? 0 : i5, (i8 & 8192) != 0 ? 0 : i6, (i8 & 16384) != 0 ? 0 : i7, (i8 & 32768) != 0 ? "" : str6);
    }
}
