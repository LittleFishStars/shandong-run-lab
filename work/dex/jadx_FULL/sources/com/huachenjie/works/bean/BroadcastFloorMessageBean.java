package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.h46;
import com.zj.adlib.s72;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J¥\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\t\u0010C\u001a\u00020\tHÖ\u0001J\u0013\u0010D\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\u0006\u0010G\u001a\u00020\u0003J\u0006\u0010H\u001a\u00020\u0003J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\tH\u0002J\u0006\u0010K\u001a\u00020\u0003J\u0006\u0010L\u001a\u00020\u0003J\u0006\u0010M\u001a\u00020\u0003J\u0006\u0010N\u001a\u00020\tJ\u0006\u0010O\u001a\u00020\tJ\t\u0010P\u001a\u00020\tHÖ\u0001J\u0006\u0010Q\u001a\u00020\u000eJ\u0006\u0010R\u001a\u00020\u000eJ\u0006\u0010S\u001a\u00020\u000eJ\t\u0010T\u001a\u00020\u0003HÖ\u0001J\u0019\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006Z"}, d2 = {"Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", "Landroid/os/Parcelable;", yj7.g.BROADCAST_QUOTE_NO, "", UserConstants.USER_PARAMS.b, "appUserCode", "avatar", "avatarFrameImgUrl", "attachmentType", "", "content", "lastUpdateTime", "likedCount", "liked", "", "commentCount", "image", "Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "voice", "Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "isMatched", "textContent", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IZILcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;ZLjava/lang/CharSequence;)V", "getAppUserCode", "()Ljava/lang/String;", "getAttachmentType", "()I", "getAvatar", "getAvatarFrameImgUrl", "getCommentCount", "setCommentCount", "(I)V", "getContent", "getImage", "()Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "()Z", "setMatched", "(Z)V", "getLastUpdateTime", "getLiked", "setLiked", "getLikedCount", "getNickName", "getQuoteNo", "getTextContent", "()Ljava/lang/CharSequence;", "setTextContent", "(Ljava/lang/CharSequence;)V", "getVoice", "()Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatAudioUrl", "formatCommentCount", "formatCount", "count", "formatImageUrl", "formatPublishTime", "formatVoiceDurationStr", "getHeight", "getWidth", "hashCode", "showImage", "showText", "showVoice", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BroadcastFloorMessageBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BroadcastFloorMessageBean> CREATOR = new Creator();

    @NotNull
    private final String appUserCode;
    private final int attachmentType;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;
    private int commentCount;

    @NotNull
    private final String content;

    @Nullable
    private final BroadcastFloorMessageImageBean image;
    private boolean isMatched;

    @NotNull
    private final String lastUpdateTime;
    private boolean liked;
    private final int likedCount;

    @NotNull
    private final String nickName;

    @NotNull
    private final String quoteNo;

    @Nullable
    private CharSequence textContent;

    @Nullable
    private final BroadcastFloorMessageVoiceBean voice;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BroadcastFloorMessageBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BroadcastFloorMessageBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BroadcastFloorMessageBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt() == 0 ? null : BroadcastFloorMessageImageBean.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? BroadcastFloorMessageVoiceBean.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BroadcastFloorMessageBean[] newArray(int i) {
            return new BroadcastFloorMessageBean[i];
        }
    }

    public BroadcastFloorMessageBean() {
        this(null, null, null, null, null, 0, null, null, 0, false, 0, null, null, false, null, 32767, null);
    }

    public BroadcastFloorMessageBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, @NotNull String str6, @NotNull String str7, int i2, boolean z, int i3, @Nullable BroadcastFloorMessageImageBean broadcastFloorMessageImageBean, @Nullable BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean, boolean z2, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, yj7.g.BROADCAST_QUOTE_NO);
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "appUserCode");
        Intrinsics.checkNotNullParameter(str4, "avatar");
        Intrinsics.checkNotNullParameter(str5, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str6, "content");
        Intrinsics.checkNotNullParameter(str7, "lastUpdateTime");
        this.quoteNo = str;
        this.nickName = str2;
        this.appUserCode = str3;
        this.avatar = str4;
        this.avatarFrameImgUrl = str5;
        this.attachmentType = i;
        this.content = str6;
        this.lastUpdateTime = str7;
        this.likedCount = i2;
        this.liked = z;
        this.commentCount = i3;
        this.image = broadcastFloorMessageImageBean;
        this.voice = broadcastFloorMessageVoiceBean;
        this.isMatched = z2;
        this.textContent = charSequence;
    }

    private final String formatCount(int count) {
        if (count < 10000) {
            return String.valueOf(count);
        }
        return h46.f42049a.j(Float.valueOf(count / 10000.0f), 1) + 'W';
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuoteNo() {
        return this.quoteNo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final BroadcastFloorMessageImageBean getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final BroadcastFloorMessageVoiceBean getVoice() {
        return this.voice;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsMatched() {
        return this.isMatched;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getLikedCount() {
        return this.likedCount;
    }

    @NotNull
    public final BroadcastFloorMessageBean copy(@NotNull String quoteNo, @NotNull String nickName, @NotNull String appUserCode, @NotNull String avatar, @NotNull String avatarFrameImgUrl, int attachmentType, @NotNull String content, @NotNull String lastUpdateTime, int likedCount, boolean liked, int commentCount, @Nullable BroadcastFloorMessageImageBean image, @Nullable BroadcastFloorMessageVoiceBean voice, boolean isMatched, @Nullable CharSequence textContent) {
        Intrinsics.checkNotNullParameter(quoteNo, yj7.g.BROADCAST_QUOTE_NO);
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(lastUpdateTime, "lastUpdateTime");
        return new BroadcastFloorMessageBean(quoteNo, nickName, appUserCode, avatar, avatarFrameImgUrl, attachmentType, content, lastUpdateTime, likedCount, liked, commentCount, image, voice, isMatched, textContent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BroadcastFloorMessageBean)) {
            return false;
        }
        BroadcastFloorMessageBean broadcastFloorMessageBean = (BroadcastFloorMessageBean) other;
        return Intrinsics.areEqual(this.quoteNo, broadcastFloorMessageBean.quoteNo) && Intrinsics.areEqual(this.nickName, broadcastFloorMessageBean.nickName) && Intrinsics.areEqual(this.appUserCode, broadcastFloorMessageBean.appUserCode) && Intrinsics.areEqual(this.avatar, broadcastFloorMessageBean.avatar) && Intrinsics.areEqual(this.avatarFrameImgUrl, broadcastFloorMessageBean.avatarFrameImgUrl) && this.attachmentType == broadcastFloorMessageBean.attachmentType && Intrinsics.areEqual(this.content, broadcastFloorMessageBean.content) && Intrinsics.areEqual(this.lastUpdateTime, broadcastFloorMessageBean.lastUpdateTime) && this.likedCount == broadcastFloorMessageBean.likedCount && this.liked == broadcastFloorMessageBean.liked && this.commentCount == broadcastFloorMessageBean.commentCount && Intrinsics.areEqual(this.image, broadcastFloorMessageBean.image) && Intrinsics.areEqual(this.voice, broadcastFloorMessageBean.voice) && this.isMatched == broadcastFloorMessageBean.isMatched && Intrinsics.areEqual(this.textContent, broadcastFloorMessageBean.textContent);
    }

    @NotNull
    public final String formatAudioUrl() {
        String path;
        BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean = this.voice;
        return (broadcastFloorMessageVoiceBean == null || (path = broadcastFloorMessageVoiceBean.getPath()) == null) ? "" : path;
    }

    @NotNull
    public final String formatCommentCount() {
        int i = this.commentCount;
        return i == 0 ? "评论" : formatCount(i);
    }

    @NotNull
    public final String formatImageUrl() {
        String path;
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean = this.image;
        return (broadcastFloorMessageImageBean == null || (path = broadcastFloorMessageImageBean.getPath()) == null) ? "" : path;
    }

    @NotNull
    public final String formatPublishTime() {
        String strB = s72.b(this.lastUpdateTime);
        Intrinsics.checkNotNullExpressionValue(strB, "formatBroadcastFloorPublishTime(lastUpdateTime)");
        return strB;
    }

    @NotNull
    public final String formatVoiceDurationStr() {
        StringBuilder sb = new StringBuilder();
        BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean = this.voice;
        sb.append(broadcastFloorMessageVoiceBean != null ? broadcastFloorMessageVoiceBean.getVoiceTime() : 0);
        sb.append('s');
        return sb.toString();
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getHeight() {
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean = this.image;
        if (broadcastFloorMessageImageBean != null) {
            return broadcastFloorMessageImageBean.getHeight();
        }
        return 0;
    }

    @Nullable
    public final BroadcastFloorMessageImageBean getImage() {
        return this.image;
    }

    @NotNull
    public final String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final int getLikedCount() {
        return this.likedCount;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getQuoteNo() {
        return this.quoteNo;
    }

    @Nullable
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    @Nullable
    public final BroadcastFloorMessageVoiceBean getVoice() {
        return this.voice;
    }

    public final int getWidth() {
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean = this.image;
        if (broadcastFloorMessageImageBean != null) {
            return broadcastFloorMessageImageBean.getWidth();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((this.quoteNo.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.appUserCode.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + Integer.hashCode(this.attachmentType)) * 31) + this.content.hashCode()) * 31) + this.lastUpdateTime.hashCode()) * 31) + Integer.hashCode(this.likedCount)) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + Integer.hashCode(this.commentCount)) * 31;
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean = this.image;
        int iHashCode3 = (iHashCode2 + (broadcastFloorMessageImageBean == null ? 0 : broadcastFloorMessageImageBean.hashCode())) * 31;
        BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean = this.voice;
        int iHashCode4 = (iHashCode3 + (broadcastFloorMessageVoiceBean == null ? 0 : broadcastFloorMessageVoiceBean.hashCode())) * 31;
        boolean z2 = this.isMatched;
        int i = (iHashCode4 + (z2 ? 1 : z2)) * 31;
        CharSequence charSequence = this.textContent;
        return i + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public final boolean isMatched() {
        return this.isMatched;
    }

    public final void setCommentCount(int i) {
        this.commentCount = i;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
    }

    public final void setMatched(boolean z) {
        this.isMatched = z;
    }

    public final void setTextContent(@Nullable CharSequence charSequence) {
        this.textContent = charSequence;
    }

    public final boolean showImage() {
        return this.attachmentType == 1 && this.image != null;
    }

    public final boolean showText() {
        return !TextUtils.isEmpty(this.textContent);
    }

    public final boolean showVoice() {
        return this.attachmentType == 3 && this.voice != null;
    }

    @NotNull
    public String toString() {
        return "BroadcastFloorMessageBean(quoteNo=" + this.quoteNo + ", nickName=" + this.nickName + ", appUserCode=" + this.appUserCode + ", avatar=" + this.avatar + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", attachmentType=" + this.attachmentType + ", content=" + this.content + ", lastUpdateTime=" + this.lastUpdateTime + ", likedCount=" + this.likedCount + ", liked=" + this.liked + ", commentCount=" + this.commentCount + ", image=" + this.image + ", voice=" + this.voice + ", isMatched=" + this.isMatched + ", textContent=" + ((Object) this.textContent) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.quoteNo);
        parcel.writeString(this.nickName);
        parcel.writeString(this.appUserCode);
        parcel.writeString(this.avatar);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeInt(this.attachmentType);
        parcel.writeString(this.content);
        parcel.writeString(this.lastUpdateTime);
        parcel.writeInt(this.likedCount);
        parcel.writeInt(this.liked ? 1 : 0);
        parcel.writeInt(this.commentCount);
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean = this.image;
        if (broadcastFloorMessageImageBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            broadcastFloorMessageImageBean.writeToParcel(parcel, flags);
        }
        BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean = this.voice;
        if (broadcastFloorMessageVoiceBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            broadcastFloorMessageVoiceBean.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isMatched ? 1 : 0);
        TextUtils.writeToParcel(this.textContent, parcel, flags);
    }

    public /* synthetic */ BroadcastFloorMessageBean(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, int i2, boolean z, int i3, BroadcastFloorMessageImageBean broadcastFloorMessageImageBean, BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean, boolean z2, CharSequence charSequence, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? "" : str4, (i4 & 16) != 0 ? "" : str5, (i4 & 32) != 0 ? 0 : i, (i4 & 64) != 0 ? "" : str6, (i4 & 128) == 0 ? str7 : "", (i4 & 256) != 0 ? 0 : i2, (i4 & 512) != 0 ? false : z, (i4 & 1024) != 0 ? 0 : i3, (i4 & 2048) != 0 ? null : broadcastFloorMessageImageBean, (i4 & 4096) != 0 ? null : broadcastFloorMessageVoiceBean, (i4 & 8192) != 0 ? false : z2, (i4 & 16384) == 0 ? charSequence : null);
    }
}
