package com.huachenjie.mine.bean;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import com.blankj.utilcode.util.SpanUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.R;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.jj8;
import com.zj.adlib.qk3;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003Jk\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002J\t\u0010.\u001a\u00020/HÖ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\u0006\u00104\u001a\u00020+J\u0006\u00105\u001a\u00020+J\u0006\u00106\u001a\u00020+J\t\u00107\u001a\u00020/HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0012R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006>"}, d2 = {"Lcom/huachenjie/mine/bean/MineData;", "Landroid/os/Parcelable;", "alumniId", "", "slogan", UserConstants.USER_PARAMS.b, "avatar", "followedCount", "likeCount", "followCount", "avatarFrameImgUrl", "tagList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAlumniId", "()Ljava/lang/String;", "getAvatar", "setAvatar", "(Ljava/lang/String;)V", "getAvatarFrameImgUrl", "setAvatarFrameImgUrl", "getFollowCount", "getFollowedCount", "getLikeCount", "getNickName", "setNickName", "getSlogan", "setSlogan", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "createSpan", "", "firstStr", "secondStr", "describeContents", "", "equals", "", "other", "", "formatterFollowCount", "formatterFollowedCount", "formatterLikeCount", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MineData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MineData> CREATOR = new Creator();

    @NotNull
    private final String alumniId;

    @NotNull
    private String avatar;

    @Nullable
    private String avatarFrameImgUrl;

    @NotNull
    private final String followCount;

    @NotNull
    private final String followedCount;

    @NotNull
    private final String likeCount;

    @NotNull
    private String nickName;

    @NotNull
    private String slogan;

    @NotNull
    private List<String> tagList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MineData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MineData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MineData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MineData[] newArray(int i) {
            return new MineData[i];
        }
    }

    public MineData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public MineData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "alumniId");
        Intrinsics.checkNotNullParameter(str2, "slogan");
        Intrinsics.checkNotNullParameter(str3, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str4, "avatar");
        Intrinsics.checkNotNullParameter(str5, "followedCount");
        Intrinsics.checkNotNullParameter(str6, "likeCount");
        Intrinsics.checkNotNullParameter(str7, "followCount");
        Intrinsics.checkNotNullParameter(list, "tagList");
        this.alumniId = str;
        this.slogan = str2;
        this.nickName = str3;
        this.avatar = str4;
        this.followedCount = str5;
        this.likeCount = str6;
        this.followCount = str7;
        this.avatarFrameImgUrl = str8;
        this.tagList = list;
    }

    private final CharSequence createSpan(String firstStr, String secondStr) {
        Typeface typefaceA = qk3.a("font/shandong_ding.ttf");
        SpannableString spannableString = new SpannableString(firstStr + q.a.i + secondStr);
        spannableString.setSpan(new SpanUtils.CustomTypefaceSpan(typefaceA), 0, firstStr.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(jj8.f(20.0f)), 0, firstStr.length(), 33);
        return spannableString;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlumniId() {
        return this.alumniId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSlogan() {
        return this.slogan;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFollowedCount() {
        return this.followedCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFollowCount() {
        return this.followCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final List<String> component9() {
        return this.tagList;
    }

    @NotNull
    public final MineData copy(@NotNull String alumniId, @NotNull String slogan, @NotNull String nickName, @NotNull String avatar, @NotNull String followedCount, @NotNull String likeCount, @NotNull String followCount, @Nullable String avatarFrameImgUrl, @NotNull List<String> tagList) {
        Intrinsics.checkNotNullParameter(alumniId, "alumniId");
        Intrinsics.checkNotNullParameter(slogan, "slogan");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(followedCount, "followedCount");
        Intrinsics.checkNotNullParameter(likeCount, "likeCount");
        Intrinsics.checkNotNullParameter(followCount, "followCount");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        return new MineData(alumniId, slogan, nickName, avatar, followedCount, likeCount, followCount, avatarFrameImgUrl, tagList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MineData)) {
            return false;
        }
        MineData mineData = (MineData) other;
        return Intrinsics.areEqual(this.alumniId, mineData.alumniId) && Intrinsics.areEqual(this.slogan, mineData.slogan) && Intrinsics.areEqual(this.nickName, mineData.nickName) && Intrinsics.areEqual(this.avatar, mineData.avatar) && Intrinsics.areEqual(this.followedCount, mineData.followedCount) && Intrinsics.areEqual(this.likeCount, mineData.likeCount) && Intrinsics.areEqual(this.followCount, mineData.followCount) && Intrinsics.areEqual(this.avatarFrameImgUrl, mineData.avatarFrameImgUrl) && Intrinsics.areEqual(this.tagList, mineData.tagList);
    }

    @NotNull
    public final CharSequence formatterFollowCount() {
        String str = this.followCount;
        String strE = ys8.e(R.string.mine_mine_info_attention);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.mine_mine_info_attention)");
        return createSpan(str, strE);
    }

    @NotNull
    public final CharSequence formatterFollowedCount() {
        String str = this.followedCount;
        String strE = ys8.e(R.string.mine_mine_info_fans);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.mine_mine_info_fans)");
        return createSpan(str, strE);
    }

    @NotNull
    public final CharSequence formatterLikeCount() {
        String str = this.likeCount;
        String strE = ys8.e(R.string.mine_mine_info_like);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.mine_mine_info_like)");
        return createSpan(str, strE);
    }

    @NotNull
    public final String getAlumniId() {
        return this.alumniId;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final String getFollowCount() {
        return this.followCount;
    }

    @NotNull
    public final String getFollowedCount() {
        return this.followedCount;
    }

    @NotNull
    public final String getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getSlogan() {
        return this.slogan;
    }

    @NotNull
    public final List<String> getTagList() {
        return this.tagList;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.alumniId.hashCode() * 31) + this.slogan.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.followedCount.hashCode()) * 31) + this.likeCount.hashCode()) * 31) + this.followCount.hashCode()) * 31;
        String str = this.avatarFrameImgUrl;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.tagList.hashCode();
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatarFrameImgUrl(@Nullable String str) {
        this.avatarFrameImgUrl = str;
    }

    public final void setNickName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void setSlogan(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.slogan = str;
    }

    public final void setTagList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tagList = list;
    }

    @NotNull
    public String toString() {
        return "MineData(alumniId=" + this.alumniId + ", slogan=" + this.slogan + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", followedCount=" + this.followedCount + ", likeCount=" + this.likeCount + ", followCount=" + this.followCount + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", tagList=" + this.tagList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.alumniId);
        parcel.writeString(this.slogan);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatar);
        parcel.writeString(this.followedCount);
        parcel.writeString(this.likeCount);
        parcel.writeString(this.followCount);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeStringList(this.tagList);
    }

    public /* synthetic */ MineData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "", (i & 256) != 0 ? new ArrayList() : list);
    }
}
