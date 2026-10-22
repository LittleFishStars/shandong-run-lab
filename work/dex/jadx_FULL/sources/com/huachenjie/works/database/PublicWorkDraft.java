package com.huachenjie.works.database;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.zj.adlib.xh9;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Entity(tableName = "public_work_draft")
@Parcelize
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b<\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018J\t\u0010P\u001a\u00020\u0006HÖ\u0001J\u0019\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR$\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010+\"\u0004\bH\u0010-R \u0010I\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR \u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010K\"\u0004\bO\u0010M¨\u0006V"}, d2 = {"Lcom/huachenjie/works/database/PublicWorkDraft;", "Landroid/os/Parcelable;", "id", "", "updateTime", "attachmentType", "", "title", "", "content", "mediaPath", "picListReplace", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "videoMediaReplace", "channelReplace", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "locationReplace", "Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "permissionType", "isNewWork", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "tagNo", "(JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/huachenjie/works/bean/publish/PubWorkMediaData;Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;IZLjava/lang/String;Ljava/lang/String;)V", "getAttachmentType", "()I", "setAttachmentType", "(I)V", "getCategoryNo", "()Ljava/lang/String;", "setCategoryNo", "(Ljava/lang/String;)V", xh9.WEBSITE_PARAMS_CHANNEL, "getChannel", "()Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "setChannel", "(Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;)V", "getChannelReplace", "setChannelReplace", "getContent", "setContent", "getId", "()J", "setId", "(J)V", "()Z", "setNewWork", "(Z)V", RequestParameters.SUBRESOURCE_LOCATION, "getLocation", "()Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "setLocation", "(Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;)V", "getLocationReplace", "setLocationReplace", "getMediaPath", "setMediaPath", "getPermissionType", "setPermissionType", "picList", "getPicList", "()Ljava/util/List;", "setPicList", "(Ljava/util/List;)V", "getPicListReplace", "setPicListReplace", "getTagNo", "setTagNo", "getTitle", d.p, "getUpdateTime", "setUpdateTime", "videoMedia", "getVideoMedia", "()Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "setVideoMedia", "(Lcom/huachenjie/works/bean/publish/PubWorkMediaData;)V", "getVideoMediaReplace", "setVideoMediaReplace", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PublicWorkDraft implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PublicWorkDraft> CREATOR = new Creator();
    private int attachmentType;

    @Nullable
    private String categoryNo;

    @TypeConverters({PubWorkChannelTypeConverter.class})
    @ColumnInfo(name = xh9.WEBSITE_PARAMS_CHANNEL)
    @Nullable
    private PubWorkChannelBean channel;

    @Ignore
    @Nullable
    private PubWorkChannelBean channelReplace;

    @NotNull
    private String content;

    @PrimaryKey(autoGenerate = true)
    private long id;

    @Ignore
    private boolean isNewWork;

    @TypeConverters({PubWorkLocationTypeConverter.class})
    @ColumnInfo(name = RequestParameters.SUBRESOURCE_LOCATION)
    @Nullable
    private PubWorkLocationItemBean location;

    @Ignore
    @Nullable
    private PubWorkLocationItemBean locationReplace;

    @NotNull
    private String mediaPath;
    private int permissionType;

    @TypeConverters({PubWorkMediaListTypeConverter.class})
    @ColumnInfo(name = "pic_list")
    @NotNull
    private List<PubWorkMediaData> picList;

    @Ignore
    @NotNull
    private List<PubWorkMediaData> picListReplace;

    @Nullable
    private String tagNo;

    @NotNull
    private String title;
    private long updateTime;

    @TypeConverters({PubWorkMediaTypeConverter.class})
    @ColumnInfo(name = "video_media")
    @Nullable
    private PubWorkMediaData videoMedia;

    @Ignore
    @Nullable
    private PubWorkMediaData videoMediaReplace;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PublicWorkDraft> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PublicWorkDraft createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            int i = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(PubWorkMediaData.CREATOR.createFromParcel(parcel));
            }
            return new PublicWorkDraft(j, j2, i, string, string2, string3, arrayList, parcel.readInt() == 0 ? null : PubWorkMediaData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PubWorkChannelBean.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? PubWorkLocationItemBean.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PublicWorkDraft[] newArray(int i) {
            return new PublicWorkDraft[i];
        }
    }

    public PublicWorkDraft() {
        this(0L, 0L, 0, null, null, null, null, null, null, null, 0, false, null, null, 16383, null);
    }

    public PublicWorkDraft(long j, long j2, int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<PubWorkMediaData> list, @Nullable PubWorkMediaData pubWorkMediaData, @Nullable PubWorkChannelBean pubWorkChannelBean, @Nullable PubWorkLocationItemBean pubWorkLocationItemBean, int i2, boolean z, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "mediaPath");
        Intrinsics.checkNotNullParameter(list, "picListReplace");
        this.id = j;
        this.updateTime = j2;
        this.attachmentType = i;
        this.title = str;
        this.content = str2;
        this.mediaPath = str3;
        this.picListReplace = list;
        this.videoMediaReplace = pubWorkMediaData;
        this.channelReplace = pubWorkChannelBean;
        this.locationReplace = pubWorkLocationItemBean;
        this.permissionType = i2;
        this.isNewWork = z;
        this.categoryNo = str4;
        this.tagNo = str5;
        this.picList = CollectionsKt.emptyList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @Nullable
    public final String getCategoryNo() {
        return this.categoryNo;
    }

    @Nullable
    public final PubWorkChannelBean getChannel() {
        return this.channel;
    }

    @Nullable
    public final PubWorkChannelBean getChannelReplace() {
        return this.channelReplace;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final PubWorkLocationItemBean getLocation() {
        return this.location;
    }

    @Nullable
    public final PubWorkLocationItemBean getLocationReplace() {
        return this.locationReplace;
    }

    @NotNull
    public final String getMediaPath() {
        return this.mediaPath;
    }

    public final int getPermissionType() {
        return this.permissionType;
    }

    @NotNull
    public final List<PubWorkMediaData> getPicList() {
        return this.picList;
    }

    @NotNull
    public final List<PubWorkMediaData> getPicListReplace() {
        return this.picListReplace;
    }

    @Nullable
    public final String getTagNo() {
        return this.tagNo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    public final PubWorkMediaData getVideoMedia() {
        return this.videoMedia;
    }

    @Nullable
    public final PubWorkMediaData getVideoMediaReplace() {
        return this.videoMediaReplace;
    }

    /* JADX INFO: renamed from: isNewWork, reason: from getter */
    public final boolean getIsNewWork() {
        return this.isNewWork;
    }

    public final void setAttachmentType(int i) {
        this.attachmentType = i;
    }

    public final void setCategoryNo(@Nullable String str) {
        this.categoryNo = str;
    }

    public final void setChannel(@Nullable PubWorkChannelBean pubWorkChannelBean) {
        this.channel = pubWorkChannelBean;
    }

    public final void setChannelReplace(@Nullable PubWorkChannelBean pubWorkChannelBean) {
        this.channelReplace = pubWorkChannelBean;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setLocation(@Nullable PubWorkLocationItemBean pubWorkLocationItemBean) {
        this.location = pubWorkLocationItemBean;
    }

    public final void setLocationReplace(@Nullable PubWorkLocationItemBean pubWorkLocationItemBean) {
        this.locationReplace = pubWorkLocationItemBean;
    }

    public final void setMediaPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaPath = str;
    }

    public final void setNewWork(boolean z) {
        this.isNewWork = z;
    }

    public final void setPermissionType(int i) {
        this.permissionType = i;
    }

    public final void setPicList(@NotNull List<PubWorkMediaData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.picList = list;
    }

    public final void setPicListReplace(@NotNull List<PubWorkMediaData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.picListReplace = list;
    }

    public final void setTagNo(@Nullable String str) {
        this.tagNo = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public final void setVideoMedia(@Nullable PubWorkMediaData pubWorkMediaData) {
        this.videoMedia = pubWorkMediaData;
    }

    public final void setVideoMediaReplace(@Nullable PubWorkMediaData pubWorkMediaData) {
        this.videoMediaReplace = pubWorkMediaData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.updateTime);
        parcel.writeInt(this.attachmentType);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.mediaPath);
        List<PubWorkMediaData> list = this.picListReplace;
        parcel.writeInt(list.size());
        Iterator<PubWorkMediaData> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        PubWorkMediaData pubWorkMediaData = this.videoMediaReplace;
        if (pubWorkMediaData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            pubWorkMediaData.writeToParcel(parcel, flags);
        }
        PubWorkChannelBean pubWorkChannelBean = this.channelReplace;
        if (pubWorkChannelBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            pubWorkChannelBean.writeToParcel(parcel, flags);
        }
        PubWorkLocationItemBean pubWorkLocationItemBean = this.locationReplace;
        if (pubWorkLocationItemBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            pubWorkLocationItemBean.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.permissionType);
        parcel.writeInt(this.isNewWork ? 1 : 0);
        parcel.writeString(this.categoryNo);
        parcel.writeString(this.tagNo);
    }

    public /* synthetic */ PublicWorkDraft(long j, long j2, int i, String str, String str2, String str3, List list, PubWorkMediaData pubWorkMediaData, PubWorkChannelBean pubWorkChannelBean, PubWorkLocationItemBean pubWorkLocationItemBean, int i2, boolean z, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) == 0 ? j2 : 0L, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list, (i3 & 128) != 0 ? null : pubWorkMediaData, (i3 & 256) != 0 ? null : pubWorkChannelBean, (i3 & 512) == 0 ? pubWorkLocationItemBean : null, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? false : z, (i3 & 4096) != 0 ? "" : str4, (i3 & 8192) != 0 ? "" : str5);
    }
}
