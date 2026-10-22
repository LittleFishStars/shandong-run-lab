package com.huachenjie.works.external.bean;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.map.RouteOverlay;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 c2\u00020\u0001:\u0001cBÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0015HÆ\u0003J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003JÓ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010W\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010Y\u001a\u00020ZJ\u0018\u0010[\u001a\u00020Z2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0006H\u0002J\t\u0010]\u001a\u00020\u0006HÖ\u0001J\u0018\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u0006H\u0002J\u0006\u0010a\u001a\u00020\u000bJ\t\u0010b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR \u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u00102R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001dR\u001a\u00107\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010:R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001dR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010!\"\u0004\b?\u00102R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001d¨\u0006d"}, d2 = {"Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "", "avatar", "", "avatarFrameImgUrl", "commentType", "", "commentSubType", UserConstants.USER_PARAMS.b, "coverImg", "liked", "", yj7.g.WORKS_NO, "worksUserCode", yj7.g.BROADCAST_QUOTE_NO, "quoteUserCode", "commentNo", "commentUserCode", "content", "commentStatus", "messageTime", "", "readFlag", RemoteMessageConst.MSGID, "image", "Lcom/huachenjie/works/bean/comment/CommentImageBean;", "postNo", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJZLjava/lang/String;Lcom/huachenjie/works/bean/comment/CommentImageBean;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getAvatarFrameImgUrl", "getCommentNo", "getCommentStatus", "()Z", "getCommentSubType", "()I", "getCommentType", "getCommentUserCode", "getContent", "getCoverImg", "goodsIndexArray", "", "getGoodsIndexArray", "()Ljava/util/List;", "setGoodsIndexArray", "(Ljava/util/List;)V", "getImage", "()Lcom/huachenjie/works/bean/comment/CommentImageBean;", "getLiked", "setLiked", "(Z)V", "getMessageTime", "()J", "getMsgId", "getNickName", "noHtmlContent", "getNoHtmlContent", "setNoHtmlContent", "(Ljava/lang/String;)V", "getPostNo", "getQuoteNo", "getQuoteUserCode", "getReadFlag", "setReadFlag", "getWorksNo", "getWorksUserCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "formatterComment", "Landroid/text/SpannableString;", "getSpanString", "index", "hashCode", "initGoodsSpan", "", "spString", "showCommentImage", "toString", "Companion", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommentOnMeBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentOnMeBean.kt\ncom/huachenjie/works/external/bean/CommentOnMeBean\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,159:1\n1864#2,3:160\n*S KotlinDebug\n*F\n+ 1 CommentOnMeBean.kt\ncom/huachenjie/works/external/bean/CommentOnMeBean\n*L\n136#1:160,3\n*E\n"})
public final /* data */ class CommentOnMeBean {
    public static final int COMMENT_SUB_TYPE_COMMENT = 1;
    public static final int COMMENT_SUB_TYPE_REPLY = 2;
    public static final int COMMENT_TYPE_AT = 2;
    public static final int COMMENT_TYPE_COMMENT = 1;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private final String commentNo;
    private final boolean commentStatus;
    private final int commentSubType;
    private final int commentType;

    @NotNull
    private final String commentUserCode;

    @NotNull
    private final String content;

    @NotNull
    private final String coverImg;

    @NotNull
    private List<Integer> goodsIndexArray;

    @Nullable
    private final CommentImageBean image;
    private boolean liked;
    private final long messageTime;

    @NotNull
    private final String msgId;

    @NotNull
    private final String nickName;

    @NotNull
    private String noHtmlContent;

    @NotNull
    private final String postNo;

    @NotNull
    private final String quoteNo;

    @NotNull
    private final String quoteUserCode;
    private boolean readFlag;

    @NotNull
    private final String worksNo;

    @NotNull
    private final String worksUserCode;

    public CommentOnMeBean() {
        this(null, null, 0, 0, null, null, false, null, null, null, null, null, null, null, false, 0L, false, null, null, null, 1048575, null);
    }

    public CommentOnMeBean(@NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, boolean z2, long j, boolean z3, @NotNull String str12, @Nullable CommentImageBean commentImageBean, @NotNull String str13) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str3, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str4, "coverImg");
        Intrinsics.checkNotNullParameter(str5, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(str6, "worksUserCode");
        Intrinsics.checkNotNullParameter(str7, yj7.g.BROADCAST_QUOTE_NO);
        Intrinsics.checkNotNullParameter(str8, "quoteUserCode");
        Intrinsics.checkNotNullParameter(str9, "commentNo");
        Intrinsics.checkNotNullParameter(str10, "commentUserCode");
        Intrinsics.checkNotNullParameter(str11, "content");
        Intrinsics.checkNotNullParameter(str12, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(str13, "postNo");
        this.avatar = str;
        this.avatarFrameImgUrl = str2;
        this.commentType = i;
        this.commentSubType = i2;
        this.nickName = str3;
        this.coverImg = str4;
        this.liked = z;
        this.worksNo = str5;
        this.worksUserCode = str6;
        this.quoteNo = str7;
        this.quoteUserCode = str8;
        this.commentNo = str9;
        this.commentUserCode = str10;
        this.content = str11;
        this.commentStatus = z2;
        this.messageTime = j;
        this.readFlag = z3;
        this.msgId = str12;
        this.image = commentImageBean;
        this.postNo = str13;
        this.noHtmlContent = "";
        this.goodsIndexArray = new ArrayList();
    }

    private final SpannableString getSpanString(String content, int index) {
        SpannableString spannableString = new SpannableString(content);
        if (this.commentStatus) {
            spannableString.setSpan(new StyleSpan(1), index, content.length(), 33);
        } else if (!this.goodsIndexArray.isEmpty()) {
            initGoodsSpan(spannableString, index);
        }
        return spannableString;
    }

    private final void initGoodsSpan(SpannableString spString, int index) {
        int i = 0;
        boolean z = false;
        for (Object obj : this.goodsIndexArray) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int iIntValue = ((Number) obj).intValue();
            if (z) {
                z = false;
            } else {
                int i3 = iIntValue + index;
                RichTextUtils.f32968a.c(spString, i3, this.goodsIndexArray.get(i2).intValue() + index, 0.75f);
                spString.setSpan(new ForegroundColorSpan(Color.parseColor(RouteOverlay.f12338c)), i3, this.goodsIndexArray.get(i2).intValue() + index, 33);
                z = true;
            }
            i = i2;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getQuoteNo() {
        return this.quoteNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getQuoteUserCode() {
        return this.quoteUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCommentNo() {
        return this.commentNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCommentUserCode() {
        return this.commentUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getCommentStatus() {
        return this.commentStatus;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getMessageTime() {
        return this.messageTime;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final CommentImageBean getImage() {
        return this.image;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPostNo() {
        return this.postNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCommentType() {
        return this.commentType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCommentSubType() {
        return this.commentSubType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getWorksNo() {
        return this.worksNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getWorksUserCode() {
        return this.worksUserCode;
    }

    @NotNull
    public final CommentOnMeBean copy(@NotNull String avatar, @NotNull String avatarFrameImgUrl, int commentType, int commentSubType, @NotNull String nickName, @NotNull String coverImg, boolean liked, @NotNull String worksNo, @NotNull String worksUserCode, @NotNull String quoteNo, @NotNull String quoteUserCode, @NotNull String commentNo, @NotNull String commentUserCode, @NotNull String content, boolean commentStatus, long messageTime, boolean readFlag, @NotNull String msgId, @Nullable CommentImageBean image, @NotNull String postNo) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksUserCode, "worksUserCode");
        Intrinsics.checkNotNullParameter(quoteNo, yj7.g.BROADCAST_QUOTE_NO);
        Intrinsics.checkNotNullParameter(quoteUserCode, "quoteUserCode");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserCode, "commentUserCode");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(msgId, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        return new CommentOnMeBean(avatar, avatarFrameImgUrl, commentType, commentSubType, nickName, coverImg, liked, worksNo, worksUserCode, quoteNo, quoteUserCode, commentNo, commentUserCode, content, commentStatus, messageTime, readFlag, msgId, image, postNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentOnMeBean)) {
            return false;
        }
        CommentOnMeBean commentOnMeBean = (CommentOnMeBean) other;
        return Intrinsics.areEqual(this.avatar, commentOnMeBean.avatar) && Intrinsics.areEqual(this.avatarFrameImgUrl, commentOnMeBean.avatarFrameImgUrl) && this.commentType == commentOnMeBean.commentType && this.commentSubType == commentOnMeBean.commentSubType && Intrinsics.areEqual(this.nickName, commentOnMeBean.nickName) && Intrinsics.areEqual(this.coverImg, commentOnMeBean.coverImg) && this.liked == commentOnMeBean.liked && Intrinsics.areEqual(this.worksNo, commentOnMeBean.worksNo) && Intrinsics.areEqual(this.worksUserCode, commentOnMeBean.worksUserCode) && Intrinsics.areEqual(this.quoteNo, commentOnMeBean.quoteNo) && Intrinsics.areEqual(this.quoteUserCode, commentOnMeBean.quoteUserCode) && Intrinsics.areEqual(this.commentNo, commentOnMeBean.commentNo) && Intrinsics.areEqual(this.commentUserCode, commentOnMeBean.commentUserCode) && Intrinsics.areEqual(this.content, commentOnMeBean.content) && this.commentStatus == commentOnMeBean.commentStatus && this.messageTime == commentOnMeBean.messageTime && this.readFlag == commentOnMeBean.readFlag && Intrinsics.areEqual(this.msgId, commentOnMeBean.msgId) && Intrinsics.areEqual(this.image, commentOnMeBean.image) && Intrinsics.areEqual(this.postNo, commentOnMeBean.postNo);
    }

    @NotNull
    public final SpannableString formatterComment() {
        String string = this.commentStatus ? Utils.a().getString(R.string.works_comment_on_me_delete) : this.noHtmlContent;
        Intrinsics.checkNotNullExpressionValue(string, "if (commentStatus) {\n   …  noHtmlContent\n        }");
        int i = this.commentType;
        if (i == 2) {
            String string2 = Utils.a().getString(R.string.works_comment_on_me_type3, string);
            Intrinsics.checkNotNullExpressionValue(string2, "getApp().getString(R.str…_type3, formatterContent)");
            return getSpanString(string2, 5);
        }
        if (i == 1 && this.commentSubType == 2) {
            String string3 = Utils.a().getString(R.string.works_comment_on_me_type2, string);
            Intrinsics.checkNotNullExpressionValue(string3, "getApp().getString(R.str…_type2, formatterContent)");
            return getSpanString(string3, 5);
        }
        String string4 = Utils.a().getString(R.string.works_comment_on_me_type1, string);
        Intrinsics.checkNotNullExpressionValue(string4, "getApp().getString(R.str…_type1, formatterContent)");
        return getSpanString(string4, 5);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final String getCommentNo() {
        return this.commentNo;
    }

    public final boolean getCommentStatus() {
        return this.commentStatus;
    }

    public final int getCommentSubType() {
        return this.commentSubType;
    }

    public final int getCommentType() {
        return this.commentType;
    }

    @NotNull
    public final String getCommentUserCode() {
        return this.commentUserCode;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getCoverImg() {
        return this.coverImg;
    }

    @NotNull
    public final List<Integer> getGoodsIndexArray() {
        return this.goodsIndexArray;
    }

    @Nullable
    public final CommentImageBean getImage() {
        return this.image;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final long getMessageTime() {
        return this.messageTime;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getNoHtmlContent() {
        return this.noHtmlContent;
    }

    @NotNull
    public final String getPostNo() {
        return this.postNo;
    }

    @NotNull
    public final String getQuoteNo() {
        return this.quoteNo;
    }

    @NotNull
    public final String getQuoteUserCode() {
        return this.quoteUserCode;
    }

    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    public final String getWorksNo() {
        return this.worksNo;
    }

    @NotNull
    public final String getWorksUserCode() {
        return this.worksUserCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((this.avatar.hashCode() * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + Integer.hashCode(this.commentType)) * 31) + Integer.hashCode(this.commentSubType)) * 31) + this.nickName.hashCode()) * 31) + this.coverImg.hashCode()) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((((((iHashCode + r1) * 31) + this.worksNo.hashCode()) * 31) + this.worksUserCode.hashCode()) * 31) + this.quoteNo.hashCode()) * 31) + this.quoteUserCode.hashCode()) * 31) + this.commentNo.hashCode()) * 31) + this.commentUserCode.hashCode()) * 31) + this.content.hashCode()) * 31;
        boolean z2 = this.commentStatus;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r2) * 31) + Long.hashCode(this.messageTime)) * 31;
        boolean z3 = this.readFlag;
        int iHashCode4 = (((iHashCode3 + (z3 ? 1 : z3)) * 31) + this.msgId.hashCode()) * 31;
        CommentImageBean commentImageBean = this.image;
        return ((iHashCode4 + (commentImageBean == null ? 0 : commentImageBean.hashCode())) * 31) + this.postNo.hashCode();
    }

    public final void setGoodsIndexArray(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.goodsIndexArray = list;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
    }

    public final void setNoHtmlContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noHtmlContent = str;
    }

    public final void setReadFlag(boolean z) {
        this.readFlag = z;
    }

    public final boolean showCommentImage() {
        return this.image != null;
    }

    @NotNull
    public String toString() {
        return "CommentOnMeBean(avatar=" + this.avatar + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", commentType=" + this.commentType + ", commentSubType=" + this.commentSubType + ", nickName=" + this.nickName + ", coverImg=" + this.coverImg + ", liked=" + this.liked + ", worksNo=" + this.worksNo + ", worksUserCode=" + this.worksUserCode + ", quoteNo=" + this.quoteNo + ", quoteUserCode=" + this.quoteUserCode + ", commentNo=" + this.commentNo + ", commentUserCode=" + this.commentUserCode + ", content=" + this.content + ", commentStatus=" + this.commentStatus + ", messageTime=" + this.messageTime + ", readFlag=" + this.readFlag + ", msgId=" + this.msgId + ", image=" + this.image + ", postNo=" + this.postNo + ')';
    }

    public /* synthetic */ CommentOnMeBean(String str, String str2, int i, int i2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z2, long j, boolean z3, String str12, CommentImageBean commentImageBean, String str13, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? "" : str5, (i3 & 256) != 0 ? "" : str6, (i3 & 512) != 0 ? "" : str7, (i3 & 1024) != 0 ? "" : str8, (i3 & 2048) != 0 ? "" : str9, (i3 & 4096) != 0 ? "" : str10, (i3 & 8192) != 0 ? "" : str11, (i3 & 16384) != 0 ? false : z2, (i3 & 32768) != 0 ? 0L : j, (i3 & 65536) != 0 ? false : z3, (i3 & 131072) != 0 ? "" : str12, (i3 & 262144) != 0 ? null : commentImageBean, (i3 & 524288) != 0 ? "" : str13);
    }
}
