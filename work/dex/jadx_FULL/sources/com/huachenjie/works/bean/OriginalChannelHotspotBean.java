package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.works.R;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CBQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JU\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\t\u00100\u001a\u00020\u001bHÖ\u0001J\u0013\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\b\u00104\u001a\u0004\u0018\u00010\u0003J\u0006\u00105\u001a\u00020\u001bJ\u0006\u00106\u001a\u00020\u0003J\u0006\u00107\u001a\u00020\u0003J\t\u00108\u001a\u00020\u001bHÖ\u0001J\b\u00109\u001a\u0004\u0018\u00010\u0003J\u0006\u0010:\u001a\u00020\u0013J\u0006\u0010;\u001a\u00020\u0013J\b\u0010<\u001a\u0004\u0018\u00010\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR \u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u00020\u001bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcom/huachenjie/works/bean/OriginalChannelHotspotBean;", "Landroid/os/Parcelable;", "coverImgUrl", "", "title", "blurb", "channelNo", "avatar", "ownerName", "worksLatest", "", "Lcom/huachenjie/works/bean/OriginalChannelHotspotWorksBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "getBlurb", "getChannelNo", "getCoverImgUrl", "isNewTab", "", "isNewTab$annotations", "()V", "()Z", "setNewTab", "(Z)V", "getOwnerName", "picWidthDp", "", "getPicWidthDp$annotations", "getPicWidthDp", "()I", "setPicWidthDp", "(I)V", "position", "getPosition$annotations", "getPosition", "setPosition", "getTitle", "getWorksLatest", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "other", "", "firstWorksUrl", "formatRankUrl", "formatterRank", "formatterRankColor", "hashCode", "secondWorksUrl", "showRankIcon", "showTextRank", "thirdWorksUrl", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OriginalChannelHotspotBean implements Parcelable {

    @NotNull
    private final String avatar;

    @NotNull
    private final String blurb;

    @NotNull
    private final String channelNo;

    @NotNull
    private final String coverImgUrl;
    private boolean isNewTab;

    @NotNull
    private final String ownerName;
    private int picWidthDp;
    private int position;

    @NotNull
    private final String title;

    @NotNull
    private final List<OriginalChannelHotspotWorksBean> worksLatest;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<OriginalChannelHotspotBean> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/huachenjie/works/bean/OriginalChannelHotspotBean$Companion;", "", "()V", "getOption", "Lcom/bumptech/glide/request/RequestOptions;", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RequestOptions getOption() {
            RequestOptions requestOptions = new RequestOptions();
            int i = R.drawable.works_bg_original_channel_default;
            RequestOptions requestOptionsTransforms = requestOptions.placeholder(i).error(i).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(4.0f)));
            Intrinsics.checkNotNullExpressionValue(requestOptionsTransforms, "RequestOptions()\n       …ers(SizeUtils.dp2px(4f)))");
            return requestOptionsTransforms;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OriginalChannelHotspotBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OriginalChannelHotspotBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(OriginalChannelHotspotWorksBean.CREATOR.createFromParcel(parcel));
            }
            return new OriginalChannelHotspotBean(string, string2, string3, string4, string5, string6, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OriginalChannelHotspotBean[] newArray(int i) {
            return new OriginalChannelHotspotBean[i];
        }
    }

    public OriginalChannelHotspotBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public OriginalChannelHotspotBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull List<OriginalChannelHotspotWorksBean> list) {
        Intrinsics.checkNotNullParameter(str, "coverImgUrl");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "blurb");
        Intrinsics.checkNotNullParameter(str4, "channelNo");
        Intrinsics.checkNotNullParameter(str5, "avatar");
        Intrinsics.checkNotNullParameter(str6, "ownerName");
        Intrinsics.checkNotNullParameter(list, "worksLatest");
        this.coverImgUrl = str;
        this.title = str2;
        this.blurb = str3;
        this.channelNo = str4;
        this.avatar = str5;
        this.ownerName = str6;
        this.worksLatest = list;
        this.picWidthDp = 100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OriginalChannelHotspotBean copy$default(OriginalChannelHotspotBean originalChannelHotspotBean, String str, String str2, String str3, String str4, String str5, String str6, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = originalChannelHotspotBean.coverImgUrl;
        }
        if ((i & 2) != 0) {
            str2 = originalChannelHotspotBean.title;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = originalChannelHotspotBean.blurb;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = originalChannelHotspotBean.channelNo;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = originalChannelHotspotBean.avatar;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = originalChannelHotspotBean.ownerName;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            list = originalChannelHotspotBean.worksLatest;
        }
        return originalChannelHotspotBean.copy(str, str7, str8, str9, str10, str11, list);
    }

    @JvmStatic
    @NotNull
    public static final RequestOptions getOption() {
        return INSTANCE.getOption();
    }

    public static /* synthetic */ void getPicWidthDp$annotations() {
    }

    public static /* synthetic */ void getPosition$annotations() {
    }

    public static /* synthetic */ void isNewTab$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBlurb() {
        return this.blurb;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOwnerName() {
        return this.ownerName;
    }

    @NotNull
    public final List<OriginalChannelHotspotWorksBean> component7() {
        return this.worksLatest;
    }

    @NotNull
    public final OriginalChannelHotspotBean copy(@NotNull String coverImgUrl, @NotNull String title, @NotNull String blurb, @NotNull String channelNo, @NotNull String avatar, @NotNull String ownerName, @NotNull List<OriginalChannelHotspotWorksBean> worksLatest) {
        Intrinsics.checkNotNullParameter(coverImgUrl, "coverImgUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blurb, "blurb");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(ownerName, "ownerName");
        Intrinsics.checkNotNullParameter(worksLatest, "worksLatest");
        return new OriginalChannelHotspotBean(coverImgUrl, title, blurb, channelNo, avatar, ownerName, worksLatest);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OriginalChannelHotspotBean)) {
            return false;
        }
        OriginalChannelHotspotBean originalChannelHotspotBean = (OriginalChannelHotspotBean) other;
        return Intrinsics.areEqual(this.coverImgUrl, originalChannelHotspotBean.coverImgUrl) && Intrinsics.areEqual(this.title, originalChannelHotspotBean.title) && Intrinsics.areEqual(this.blurb, originalChannelHotspotBean.blurb) && Intrinsics.areEqual(this.channelNo, originalChannelHotspotBean.channelNo) && Intrinsics.areEqual(this.avatar, originalChannelHotspotBean.avatar) && Intrinsics.areEqual(this.ownerName, originalChannelHotspotBean.ownerName) && Intrinsics.areEqual(this.worksLatest, originalChannelHotspotBean.worksLatest);
    }

    @Nullable
    public final String firstWorksUrl() {
        OriginalChannelHotspotWorksBean originalChannelHotspotWorksBean = (OriginalChannelHotspotWorksBean) CollectionsKt.firstOrNull(this.worksLatest);
        if (originalChannelHotspotWorksBean != null) {
            return originalChannelHotspotWorksBean.getCover();
        }
        return null;
    }

    public final int formatRankUrl() {
        int i = this.position;
        if (i == 0) {
            return R.drawable.works_ic_original_channel_rank1;
        }
        if (i == 1) {
            return R.drawable.works_ic_original_channel_rank2;
        }
        if (i != 2) {
            return -1;
        }
        return R.drawable.works_ic_original_channel_rank3;
    }

    @NotNull
    public final String formatterRank() {
        String strF = ys8.f(R.string.works_original_enter_rank, Integer.valueOf(this.position + 1));
        Intrinsics.checkNotNullExpressionValue(strF, "getString(R.string.works…enter_rank, position + 1)");
        return strF;
    }

    @NotNull
    public final String formatterRankColor() {
        int i = this.position;
        if (i == 0) {
            return "#FF762F";
        }
        if (i != 1) {
            return i != 2 ? "#2C3E50" : "#D48476";
        }
        return "#7F93B4";
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getBlurb() {
        return this.blurb;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    public final String getOwnerName() {
        return this.ownerName;
    }

    public final int getPicWidthDp() {
        return this.picWidthDp;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<OriginalChannelHotspotWorksBean> getWorksLatest() {
        return this.worksLatest;
    }

    public int hashCode() {
        return (((((((((((this.coverImgUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.blurb.hashCode()) * 31) + this.channelNo.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.ownerName.hashCode()) * 31) + this.worksLatest.hashCode();
    }

    /* JADX INFO: renamed from: isNewTab, reason: from getter */
    public final boolean getIsNewTab() {
        return this.isNewTab;
    }

    @Nullable
    public final String secondWorksUrl() {
        OriginalChannelHotspotWorksBean originalChannelHotspotWorksBean = (OriginalChannelHotspotWorksBean) CollectionsKt.getOrNull(this.worksLatest, 1);
        if (originalChannelHotspotWorksBean != null) {
            return originalChannelHotspotWorksBean.getCover();
        }
        return null;
    }

    public final void setNewTab(boolean z) {
        this.isNewTab = z;
    }

    public final void setPicWidthDp(int i) {
        this.picWidthDp = i;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final boolean showRankIcon() {
        return !this.isNewTab && this.position < 3;
    }

    public final boolean showTextRank() {
        if (this.isNewTab) {
            return false;
        }
        int i = this.position;
        return 3 <= i && i < 10;
    }

    @Nullable
    public final String thirdWorksUrl() {
        OriginalChannelHotspotWorksBean originalChannelHotspotWorksBean = (OriginalChannelHotspotWorksBean) CollectionsKt.getOrNull(this.worksLatest, 2);
        if (originalChannelHotspotWorksBean != null) {
            return originalChannelHotspotWorksBean.getCover();
        }
        return null;
    }

    @NotNull
    public String toString() {
        return "OriginalChannelHotspotBean(coverImgUrl=" + this.coverImgUrl + ", title=" + this.title + ", blurb=" + this.blurb + ", channelNo=" + this.channelNo + ", avatar=" + this.avatar + ", ownerName=" + this.ownerName + ", worksLatest=" + this.worksLatest + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.coverImgUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.blurb);
        parcel.writeString(this.channelNo);
        parcel.writeString(this.avatar);
        parcel.writeString(this.ownerName);
        List<OriginalChannelHotspotWorksBean> list = this.worksLatest;
        parcel.writeInt(list.size());
        Iterator<OriginalChannelHotspotWorksBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ OriginalChannelHotspotBean(String str, String str2, String str3, String str4, String str5, String str6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? new ArrayList() : list);
    }
}
