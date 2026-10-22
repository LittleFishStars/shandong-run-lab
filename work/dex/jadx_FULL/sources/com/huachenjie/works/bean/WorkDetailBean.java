package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Size;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.utils.LocalVideoUtils;
import com.zj.adlib.fe9;
import com.zj.adlib.h46;
import com.zj.adlib.s72;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u008b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\t\u0010Y\u001a\u00020\u0004HÆ\u0003J\t\u0010Z\u001a\u00020\u0004HÆ\u0003J\t\u0010[\u001a\u00020\u0011HÆ\u0003J\t\u0010\\\u001a\u00020\u0013HÆ\u0003J\t\u0010]\u001a\u00020\u0004HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010CJ\t\u0010b\u001a\u00020\tHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010f\u001a\u00020\u001bHÆ\u0003J\t\u0010g\u001a\u00020\u001bHÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\t\u0010i\u001a\u00020\u0004HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010$HÆ\u0003J\t\u0010k\u001a\u00020\u0004HÆ\u0003J\t\u0010l\u001a\u00020\u0004HÆ\u0003J\t\u0010m\u001a\u00020\tHÆ\u0003J\t\u0010n\u001a\u00020\u0004HÆ\u0003J\t\u0010o\u001a\u00020\u0004HÆ\u0003J\t\u0010p\u001a\u00020\rHÆ\u0003J\t\u0010q\u001a\u00020\u0004HÆ\u0003J\u0094\u0002\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010sJ\t\u0010t\u001a\u00020\tHÖ\u0001J\u0013\u0010u\u001a\u00020\u001b2\b\u0010v\u001a\u0004\u0018\u00010wHÖ\u0003J\u0006\u0010x\u001a\u00020\u0004J\u0006\u0010y\u001a\u00020\u0004J\u0006\u0010z\u001a\u00020\u0004J\u0006\u0010{\u001a\u00020\u0004J\u0006\u0010|\u001a\u00020\u0004J\u0006\u0010}\u001a\u00020\u0004J\u0006\u0010~\u001a\u00020\u007fJ\u0012\u0010\u0080\u0001\u001a\u00020\u00042\u0007\u0010\u0081\u0001\u001a\u00020\tH\u0002J\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0083\u00010\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0087\u0001\u001a\u00020\u001bH\u0002J\u0007\u0010\u0088\u0001\u001a\u00020\u0004J\u0007\u0010\u0089\u0001\u001a\u00020\u0004J\u0007\u0010\u008a\u0001\u001a\u00020\u0004J\u0007\u0010\u008b\u0001\u001a\u00020\tJ\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u0007\u0010\u008e\u0001\u001a\u00020\u0004J\u0007\u0010\u008f\u0001\u001a\u00020\tJ\u0007\u0010\u0090\u0001\u001a\u00020\u0004J\u0007\u0010\u0091\u0001\u001a\u00020\tJ\u0007\u0010\u0092\u0001\u001a\u00020\tJ\u0007\u0010\u0093\u0001\u001a\u00020\u001bJ\u0007\u0010\u0094\u0001\u001a\u00020\u001bJ\u0007\u0010\u0095\u0001\u001a\u00020\u001bJ\n\u0010\u0096\u0001\u001a\u00020\tHÖ\u0001J\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u001a\u0010\u0099\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u001b2\u0007\u0010\u009b\u0001\u001a\u00020\tJ\u0011\u0010\u009c\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u009d\u0001\u001a\u00020\tJ\u0011\u0010\u009e\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001bJ\u001a\u0010 \u0001\u001a\u00030\u0098\u00012\u0007\u0010¡\u0001\u001a\u00020\u001b2\u0007\u0010\u009b\u0001\u001a\u00020\tJ\u0011\u0010¢\u0001\u001a\u00030\u0098\u00012\u0007\u0010£\u0001\u001a\u00020\tJ\u0007\u0010¤\u0001\u001a\u00020\u001bJ\u0007\u0010¥\u0001\u001a\u00020\u001bJ\u0007\u0010¦\u0001\u001a\u00020\u001bJ\u0007\u0010§\u0001\u001a\u00020\u001bJ\n\u0010¨\u0001\u001a\u00020\u0004HÖ\u0001J\u001e\u0010©\u0001\u001a\u00030\u0098\u00012\b\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020\tHÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010)R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010IR\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010IR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010/\"\u0004\bM\u00101R\u001a\u0010\u001f\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00106\"\u0004\bO\u00108R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010!\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010)\"\u0004\bT\u0010IR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010+R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010+R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bW\u0010X¨\u0006\u00ad\u0001"}, d2 = {"Lcom/huachenjie/works/bean/WorkDetailBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Landroid/os/Parcelable;", yj7.g.WORKS_NO, "", "title", "content", "woksType", "attachmentType", "", "channelNo", "channelName", "attachmentInfo", "Lcom/huachenjie/works/bean/AttachmentBean;", RequestParameters.SUBRESOURCE_LOCATION, "lastUpdateTime", "userInfo", "Lcom/huachenjie/base/bean/UserInfoBean;", "interactInfo", "Lcom/huachenjie/works/bean/InteractBean;", "popularityValue", "goodsRecommend", "Lcom/huachenjie/works/bean/GoodsRecommendData;", "startPosition", "textContent", "", "showLookMore", "", "statusBarHeight", "closeContent", "expandContent", "textExpand", "fromMine", "visit", "categoryTag", "worksPromotionInfo", "Lcom/huachenjie/works/bean/WorksPromotionInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/huachenjie/works/bean/AttachmentBean;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/UserInfoBean;Lcom/huachenjie/works/bean/InteractBean;Ljava/lang/String;Lcom/huachenjie/works/bean/GoodsRecommendData;ILjava/lang/CharSequence;Ljava/lang/Boolean;ILjava/lang/CharSequence;Ljava/lang/CharSequence;ZZILjava/lang/String;Lcom/huachenjie/works/bean/WorksPromotionInfo;)V", "getAttachmentInfo", "()Lcom/huachenjie/works/bean/AttachmentBean;", "getAttachmentType", "()I", "getCategoryTag", "()Ljava/lang/String;", "getChannelName", "getChannelNo", "getCloseContent", "()Ljava/lang/CharSequence;", "setCloseContent", "(Ljava/lang/CharSequence;)V", "getContent", "getExpandContent", "setExpandContent", "getFromMine", "()Z", "setFromMine", "(Z)V", "getGoodsRecommend", "()Lcom/huachenjie/works/bean/GoodsRecommendData;", "getInteractInfo", "()Lcom/huachenjie/works/bean/InteractBean;", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "getLastUpdateTime", "getLocation", "getPopularityValue", "getShowLookMore", "()Ljava/lang/Boolean;", "setShowLookMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStartPosition", "setStartPosition", "(I)V", "getStatusBarHeight", "setStatusBarHeight", "getTextContent", "setTextContent", "getTextExpand", "setTextExpand", "getTitle", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/base/bean/UserInfoBean;", "getVisit", "setVisit", "getWoksType", "getWorksNo", "getWorksPromotionInfo", "()Lcom/huachenjie/works/bean/WorksPromotionInfo;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/huachenjie/works/bean/AttachmentBean;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/UserInfoBean;Lcom/huachenjie/works/bean/InteractBean;Ljava/lang/String;Lcom/huachenjie/works/bean/GoodsRecommendData;ILjava/lang/CharSequence;Ljava/lang/Boolean;ILjava/lang/CharSequence;Ljava/lang/CharSequence;ZZILjava/lang/String;Lcom/huachenjie/works/bean/WorksPromotionInfo;)Lcom/huachenjie/works/bean/WorkDetailBean;", "describeContents", "equals", "other", "", "formatAttentionTag", "formatAuthorNo", "formatAvatarFrameUrl", "formatAvatarUrl", "formatChannelName", "formatCommentCount", "formatContent", "Landroid/text/SpannableString;", "formatCount", "count", "formatCoverBean", "Lcom/huachenjie/works/bean/WorkImageBean;", "formatImageList", "", "formatIsAttention", "formatIsContact", "formatNickName", "formatPublishTime", "formatShareCount", "formatTagBackground", "formatVideoSize", "Landroid/util/Size;", "formatVideoUrl", "formatViolationIcon", "formatViolationText", "getRecommendGoodNum", "getShareCount", "hasCollected", "hasFollowed", "hasLiked", "hashCode", "replaceVideoPath", "", "setCollected", "collected", "quantity", "setCommentCount", "commentCount", "setFollowed", "followed", "setLiked", "liked", "setShareCount", "shareCount", "showAttentionTag", "showCategoryTag", "showChannelName", "showVideoViolation", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWorkDetailBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkDetailBean.kt\ncom/huachenjie/works/bean/WorkDetailBean\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,398:1\n1#2:399\n*E\n"})
public final /* data */ class WorkDetailBean implements MultiItemEntity, Parcelable {

    @NotNull
    public static final Parcelable.Creator<WorkDetailBean> CREATOR = new Creator();

    @NotNull
    private final AttachmentBean attachmentInfo;
    private final int attachmentType;

    @NotNull
    private final String categoryTag;

    @NotNull
    private final String channelName;

    @NotNull
    private final String channelNo;

    @Nullable
    private CharSequence closeContent;

    @NotNull
    private final String content;

    @Nullable
    private CharSequence expandContent;
    private boolean fromMine;

    @Nullable
    private final GoodsRecommendData goodsRecommend;

    @NotNull
    private final InteractBean interactInfo;

    @NotNull
    private final String lastUpdateTime;

    @NotNull
    private final String location;

    @NotNull
    private final String popularityValue;

    @Nullable
    private Boolean showLookMore;
    private int startPosition;
    private int statusBarHeight;

    @Nullable
    private CharSequence textContent;
    private boolean textExpand;

    @NotNull
    private final String title;

    @NotNull
    private final UserInfoBean userInfo;
    private int visit;

    @NotNull
    private final String woksType;

    @NotNull
    private final String worksNo;

    @Nullable
    private final WorksPromotionInfo worksPromotionInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkDetailBean createFromParcel(@NotNull Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i = parcel.readInt();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            AttachmentBean attachmentBeanCreateFromParcel = AttachmentBean.CREATOR.createFromParcel(parcel);
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            UserInfoBean userInfoBean = (UserInfoBean) parcel.readParcelable(WorkDetailBean.class.getClassLoader());
            InteractBean interactBeanCreateFromParcel = InteractBean.CREATOR.createFromParcel(parcel);
            String string9 = parcel.readString();
            GoodsRecommendData goodsRecommendDataCreateFromParcel = parcel.readInt() == 0 ? null : GoodsRecommendData.CREATOR.createFromParcel(parcel);
            int i2 = parcel.readInt();
            CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new WorkDetailBean(string, string2, string3, string4, i, string5, string6, attachmentBeanCreateFromParcel, string7, string8, userInfoBean, interactBeanCreateFromParcel, string9, goodsRecommendDataCreateFromParcel, i2, charSequence, boolValueOf, parcel.readInt(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? WorksPromotionInfo.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkDetailBean[] newArray(int i) {
            return new WorkDetailBean[i];
        }
    }

    public WorkDetailBean() {
        this(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, false, false, 0, null, null, 33554431, null);
    }

    public WorkDetailBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull String str5, @NotNull String str6, @NotNull AttachmentBean attachmentBean, @NotNull String str7, @NotNull String str8, @NotNull UserInfoBean userInfoBean, @NotNull InteractBean interactBean, @NotNull String str9, @Nullable GoodsRecommendData goodsRecommendData, int i2, @Nullable CharSequence charSequence, @Nullable Boolean bool, int i3, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, boolean z, boolean z2, int i4, @NotNull String str10, @Nullable WorksPromotionInfo worksPromotionInfo) {
        Intrinsics.checkNotNullParameter(str, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str4, "woksType");
        Intrinsics.checkNotNullParameter(str5, "channelNo");
        Intrinsics.checkNotNullParameter(str6, "channelName");
        Intrinsics.checkNotNullParameter(attachmentBean, "attachmentInfo");
        Intrinsics.checkNotNullParameter(str7, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(str8, "lastUpdateTime");
        Intrinsics.checkNotNullParameter(userInfoBean, "userInfo");
        Intrinsics.checkNotNullParameter(interactBean, "interactInfo");
        Intrinsics.checkNotNullParameter(str9, "popularityValue");
        Intrinsics.checkNotNullParameter(str10, "categoryTag");
        this.worksNo = str;
        this.title = str2;
        this.content = str3;
        this.woksType = str4;
        this.attachmentType = i;
        this.channelNo = str5;
        this.channelName = str6;
        this.attachmentInfo = attachmentBean;
        this.location = str7;
        this.lastUpdateTime = str8;
        this.userInfo = userInfoBean;
        this.interactInfo = interactBean;
        this.popularityValue = str9;
        this.goodsRecommend = goodsRecommendData;
        this.startPosition = i2;
        this.textContent = charSequence;
        this.showLookMore = bool;
        this.statusBarHeight = i3;
        this.closeContent = charSequence2;
        this.expandContent = charSequence3;
        this.textExpand = z;
        this.fromMine = z2;
        this.visit = i4;
        this.categoryTag = str10;
        this.worksPromotionInfo = worksPromotionInfo;
    }

    private final String formatCount(int count) {
        if (count < 10000) {
            return String.valueOf(count);
        }
        return h46.f42049a.j(Float.valueOf(count / 10000.0f), 1) + 'W';
    }

    private final boolean formatIsAttention() {
        return this.userInfo.getRelation() == 2 || this.userInfo.getRelation() == 3;
    }

    private final boolean formatIsContact() {
        return this.userInfo.getContactsFlag() == 1 || this.userInfo.getContactsFlag() == 2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWorksNo() {
        return this.worksNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final InteractBean getInteractInfo() {
        return this.interactInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final GoodsRecommendData getGoodsRecommend() {
        return this.goodsRecommend;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getStartPosition() {
        return this.startPosition;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getShowLookMore() {
        return this.showLookMore;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final CharSequence getCloseContent() {
        return this.closeContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final CharSequence getExpandContent() {
        return this.expandContent;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getTextExpand() {
        return this.textExpand;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getFromMine() {
        return this.fromMine;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getVisit() {
        return this.visit;
    }

    @NotNull
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getCategoryTag() {
        return this.categoryTag;
    }

    @Nullable
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final WorksPromotionInfo getWorksPromotionInfo() {
        return this.worksPromotionInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getWoksType() {
        return this.woksType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final AttachmentBean getAttachmentInfo() {
        return this.attachmentInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final WorkDetailBean copy(@NotNull String worksNo, @NotNull String title, @NotNull String content, @NotNull String woksType, int attachmentType, @NotNull String channelNo, @NotNull String channelName, @NotNull AttachmentBean attachmentInfo, @NotNull String location, @NotNull String lastUpdateTime, @NotNull UserInfoBean userInfo, @NotNull InteractBean interactInfo, @NotNull String popularityValue, @Nullable GoodsRecommendData goodsRecommend, int startPosition, @Nullable CharSequence textContent, @Nullable Boolean showLookMore, int statusBarHeight, @Nullable CharSequence closeContent, @Nullable CharSequence expandContent, boolean textExpand, boolean fromMine, int visit, @NotNull String categoryTag, @Nullable WorksPromotionInfo worksPromotionInfo) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(woksType, "woksType");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(attachmentInfo, "attachmentInfo");
        Intrinsics.checkNotNullParameter(location, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(lastUpdateTime, "lastUpdateTime");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(interactInfo, "interactInfo");
        Intrinsics.checkNotNullParameter(popularityValue, "popularityValue");
        Intrinsics.checkNotNullParameter(categoryTag, "categoryTag");
        return new WorkDetailBean(worksNo, title, content, woksType, attachmentType, channelNo, channelName, attachmentInfo, location, lastUpdateTime, userInfo, interactInfo, popularityValue, goodsRecommend, startPosition, textContent, showLookMore, statusBarHeight, closeContent, expandContent, textExpand, fromMine, visit, categoryTag, worksPromotionInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkDetailBean)) {
            return false;
        }
        WorkDetailBean workDetailBean = (WorkDetailBean) other;
        return Intrinsics.areEqual(this.worksNo, workDetailBean.worksNo) && Intrinsics.areEqual(this.title, workDetailBean.title) && Intrinsics.areEqual(this.content, workDetailBean.content) && Intrinsics.areEqual(this.woksType, workDetailBean.woksType) && this.attachmentType == workDetailBean.attachmentType && Intrinsics.areEqual(this.channelNo, workDetailBean.channelNo) && Intrinsics.areEqual(this.channelName, workDetailBean.channelName) && Intrinsics.areEqual(this.attachmentInfo, workDetailBean.attachmentInfo) && Intrinsics.areEqual(this.location, workDetailBean.location) && Intrinsics.areEqual(this.lastUpdateTime, workDetailBean.lastUpdateTime) && Intrinsics.areEqual(this.userInfo, workDetailBean.userInfo) && Intrinsics.areEqual(this.interactInfo, workDetailBean.interactInfo) && Intrinsics.areEqual(this.popularityValue, workDetailBean.popularityValue) && Intrinsics.areEqual(this.goodsRecommend, workDetailBean.goodsRecommend) && this.startPosition == workDetailBean.startPosition && Intrinsics.areEqual(this.textContent, workDetailBean.textContent) && Intrinsics.areEqual(this.showLookMore, workDetailBean.showLookMore) && this.statusBarHeight == workDetailBean.statusBarHeight && Intrinsics.areEqual(this.closeContent, workDetailBean.closeContent) && Intrinsics.areEqual(this.expandContent, workDetailBean.expandContent) && this.textExpand == workDetailBean.textExpand && this.fromMine == workDetailBean.fromMine && this.visit == workDetailBean.visit && Intrinsics.areEqual(this.categoryTag, workDetailBean.categoryTag) && Intrinsics.areEqual(this.worksPromotionInfo, workDetailBean.worksPromotionInfo);
    }

    @NotNull
    public final String formatAttentionTag() {
        if (formatIsContact()) {
            return "好友";
        }
        return formatIsAttention() ? fe9.a.ATTENTION : "";
    }

    @NotNull
    public final String formatAuthorNo() {
        String appUserCode;
        UserInfoBean userInfoBean = this.userInfo;
        return (userInfoBean == null || (appUserCode = userInfoBean.getAppUserCode()) == null) ? "" : appUserCode;
    }

    @NotNull
    public final String formatAvatarFrameUrl() {
        return this.userInfo.getAvatarFrameImgUrl();
    }

    @NotNull
    public final String formatAvatarUrl() {
        return this.userInfo.getAvatar();
    }

    @NotNull
    public final String formatChannelName() {
        if (!showChannelName()) {
            return "";
        }
        return '@' + this.channelName;
    }

    @NotNull
    public final String formatCommentCount() {
        return this.interactInfo.getCommentCount() == 0 ? "评论" : formatCount(this.interactInfo.getCommentCount());
    }

    @NotNull
    public final SpannableString formatContent() {
        return new SpannableString(this.content);
    }

    @NotNull
    public final WorkImageBean formatCoverBean() {
        WorkImageBean workImageBean;
        Object next;
        int i = this.attachmentType;
        if (i != 2) {
            return (i != 1 || this.attachmentInfo.getImageList().isEmpty() || (workImageBean = this.attachmentInfo.getImageList().get(0)) == null) ? new WorkImageBean(null, null, false, null, 0, 0, 0.0f, false, 255, null) : workImageBean;
        }
        Iterator<T> it = this.attachmentInfo.getImageList().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((WorkImageBean) next).getCover());
        WorkImageBean workImageBean2 = (WorkImageBean) next;
        return workImageBean2 == null ? new WorkImageBean(null, null, false, null, 0, 0, 0.0f, false, 255, null) : workImageBean2;
    }

    @NotNull
    public final List<WorkImageBean> formatImageList() {
        return this.attachmentType == 1 ? this.attachmentInfo.getImageList() : new ArrayList();
    }

    @NotNull
    public final String formatNickName() {
        return this.userInfo.getNickName();
    }

    @NotNull
    public final String formatPublishTime() {
        String strP = s72.p(this.lastUpdateTime);
        Intrinsics.checkNotNullExpressionValue(strP, "formatWorkPublishTime(lastUpdateTime)");
        return strP;
    }

    @NotNull
    public final String formatShareCount() {
        return this.interactInfo.getShareCount() == 0 ? "分享" : formatCount(this.interactInfo.getShareCount());
    }

    public final int formatTagBackground() {
        if (formatIsContact()) {
            return R.drawable.works_bg_item_tag_contact;
        }
        if (formatIsAttention()) {
            return R.drawable.works_bg_item_tag_attention;
        }
        return 0;
    }

    @NotNull
    public final Size formatVideoSize() {
        return new Size(this.attachmentInfo.getVideo().getWidth(), this.attachmentInfo.getVideo().getHeight());
    }

    @NotNull
    public final String formatVideoUrl() {
        return this.attachmentType == 2 ? this.attachmentInfo.getVideo().getPath() : "";
    }

    public final int formatViolationIcon() {
        List<WorkImageBean> imageList;
        WorkVideoBean video;
        if (this.attachmentType != 2) {
            return 0;
        }
        AttachmentBean attachmentBean = this.attachmentInfo;
        if ((attachmentBean == null || (video = attachmentBean.getVideo()) == null || !video.getDelFlag()) ? false : true) {
            return R.drawable.works_ic_work_violation_video;
        }
        AttachmentBean attachmentBean2 = this.attachmentInfo;
        if (attachmentBean2 == null || (imageList = attachmentBean2.getImageList()) == null || !(true ^ imageList.isEmpty()) || !imageList.get(0).getDelFlag()) {
            return 0;
        }
        return R.drawable.works_ic_work_violation_image;
    }

    @NotNull
    public final String formatViolationText() {
        List<WorkImageBean> imageList;
        WorkVideoBean video;
        if (this.attachmentType != 2) {
            return "";
        }
        AttachmentBean attachmentBean = this.attachmentInfo;
        if ((attachmentBean == null || (video = attachmentBean.getVideo()) == null || !video.getDelFlag()) ? false : true) {
            return "视频违规已被删除";
        }
        AttachmentBean attachmentBean2 = this.attachmentInfo;
        return (attachmentBean2 == null || (imageList = attachmentBean2.getImageList()) == null || !(true ^ imageList.isEmpty()) || !imageList.get(0).getDelFlag()) ? "" : "封面违规已被删除";
    }

    @NotNull
    public final AttachmentBean getAttachmentInfo() {
        return this.attachmentInfo;
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getCategoryTag() {
        return this.categoryTag;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @Nullable
    public final CharSequence getCloseContent() {
        return this.closeContent;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final CharSequence getExpandContent() {
        return this.expandContent;
    }

    public final boolean getFromMine() {
        return this.fromMine;
    }

    @Nullable
    public final GoodsRecommendData getGoodsRecommend() {
        return this.goodsRecommend;
    }

    @NotNull
    public final InteractBean getInteractInfo() {
        return this.interactInfo;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    public final int getRecommendGoodNum() {
        GoodsRecommendData goodsRecommendData = this.goodsRecommend;
        if (goodsRecommendData != null) {
            return goodsRecommendData.formatGoodRecommendNum();
        }
        return 0;
    }

    public final int getShareCount() {
        return this.interactInfo.getShareCount();
    }

    @Nullable
    public final Boolean getShowLookMore() {
        return this.showLookMore;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    @Nullable
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    public final boolean getTextExpand() {
        return this.textExpand;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public final int getVisit() {
        return this.visit;
    }

    @NotNull
    public final String getWoksType() {
        return this.woksType;
    }

    @NotNull
    public final String getWorksNo() {
        return this.worksNo;
    }

    @Nullable
    public final WorksPromotionInfo getWorksPromotionInfo() {
        return this.worksPromotionInfo;
    }

    public final boolean hasCollected() {
        return this.interactInfo.getCollected();
    }

    public final boolean hasFollowed() {
        return this.interactInfo.getFollowed();
    }

    public final boolean hasLiked() {
        return this.interactInfo.getLiked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v41, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44, types: [int] */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((this.worksNo.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.woksType.hashCode()) * 31) + Integer.hashCode(this.attachmentType)) * 31) + this.channelNo.hashCode()) * 31) + this.channelName.hashCode()) * 31) + this.attachmentInfo.hashCode()) * 31) + this.location.hashCode()) * 31) + this.lastUpdateTime.hashCode()) * 31) + this.userInfo.hashCode()) * 31) + this.interactInfo.hashCode()) * 31) + this.popularityValue.hashCode()) * 31;
        GoodsRecommendData goodsRecommendData = this.goodsRecommend;
        int iHashCode2 = (((iHashCode + (goodsRecommendData == null ? 0 : goodsRecommendData.hashCode())) * 31) + Integer.hashCode(this.startPosition)) * 31;
        CharSequence charSequence = this.textContent;
        int iHashCode3 = (iHashCode2 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        Boolean bool = this.showLookMore;
        int iHashCode4 = (((iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31) + Integer.hashCode(this.statusBarHeight)) * 31;
        CharSequence charSequence2 = this.closeContent;
        int iHashCode5 = (iHashCode4 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.expandContent;
        int iHashCode6 = (iHashCode5 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
        boolean z = this.textExpand;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode6 + r1) * 31;
        boolean z2 = this.fromMine;
        int iHashCode7 = (((((i + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.visit)) * 31) + this.categoryTag.hashCode()) * 31;
        WorksPromotionInfo worksPromotionInfo = this.worksPromotionInfo;
        return iHashCode7 + (worksPromotionInfo != null ? worksPromotionInfo.hashCode() : 0);
    }

    public final void replaceVideoPath() {
        if (this.attachmentType == 2 && this.attachmentInfo.getVideo().getStatus() == 2) {
            WorkVideoBean video = this.attachmentInfo.getVideo();
            String strB = LocalVideoUtils.f14946a.b(this.worksNo);
            if (strB == null) {
                strB = this.attachmentInfo.getVideo().getPath();
            }
            video.setPath(strB);
        }
    }

    public final void setCloseContent(@Nullable CharSequence charSequence) {
        this.closeContent = charSequence;
    }

    public final void setCollected(boolean collected, int quantity) {
        this.interactInfo.setCollected(collected);
        this.interactInfo.setCollecteCount(quantity);
    }

    public final void setCommentCount(int commentCount) {
        this.interactInfo.setCommentCount(commentCount);
    }

    public final void setExpandContent(@Nullable CharSequence charSequence) {
        this.expandContent = charSequence;
    }

    public final void setFollowed(boolean followed) {
        this.interactInfo.setFollowed(followed);
    }

    public final void setFromMine(boolean z) {
        this.fromMine = z;
    }

    public final void setLiked(boolean liked, int quantity) {
        this.interactInfo.setLiked(liked);
        this.interactInfo.setLikeCount(quantity);
    }

    public final void setShareCount(int shareCount) {
        this.interactInfo.setShareCount(shareCount);
    }

    public final void setShowLookMore(@Nullable Boolean bool) {
        this.showLookMore = bool;
    }

    public final void setStartPosition(int i) {
        this.startPosition = i;
    }

    public final void setStatusBarHeight(int i) {
        this.statusBarHeight = i;
    }

    public final void setTextContent(@Nullable CharSequence charSequence) {
        this.textContent = charSequence;
    }

    public final void setTextExpand(boolean z) {
        this.textExpand = z;
    }

    public final void setVisit(int i) {
        this.visit = i;
    }

    public final boolean showAttentionTag() {
        return formatIsContact() || formatIsAttention();
    }

    public final boolean showCategoryTag() {
        return !TextUtils.isEmpty(this.categoryTag);
    }

    public final boolean showChannelName() {
        return !TextUtils.isEmpty(this.channelName);
    }

    public final boolean showVideoViolation() {
        List<WorkImageBean> imageList;
        WorkVideoBean video;
        if (this.attachmentType != 2) {
            return false;
        }
        AttachmentBean attachmentBean = this.attachmentInfo;
        if ((attachmentBean == null || (video = attachmentBean.getVideo()) == null || !video.getDelFlag()) ? false : true) {
            return true;
        }
        AttachmentBean attachmentBean2 = this.attachmentInfo;
        return attachmentBean2 != null && (imageList = attachmentBean2.getImageList()) != null && (imageList.isEmpty() ^ true) && imageList.get(0).getDelFlag();
    }

    @NotNull
    public String toString() {
        return "WorkDetailBean(worksNo=" + this.worksNo + ", title=" + this.title + ", content=" + this.content + ", woksType=" + this.woksType + ", attachmentType=" + this.attachmentType + ", channelNo=" + this.channelNo + ", channelName=" + this.channelName + ", attachmentInfo=" + this.attachmentInfo + ", location=" + this.location + ", lastUpdateTime=" + this.lastUpdateTime + ", userInfo=" + this.userInfo + ", interactInfo=" + this.interactInfo + ", popularityValue=" + this.popularityValue + ", goodsRecommend=" + this.goodsRecommend + ", startPosition=" + this.startPosition + ", textContent=" + ((Object) this.textContent) + ", showLookMore=" + this.showLookMore + ", statusBarHeight=" + this.statusBarHeight + ", closeContent=" + ((Object) this.closeContent) + ", expandContent=" + ((Object) this.expandContent) + ", textExpand=" + this.textExpand + ", fromMine=" + this.fromMine + ", visit=" + this.visit + ", categoryTag=" + this.categoryTag + ", worksPromotionInfo=" + this.worksPromotionInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.worksNo);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.woksType);
        parcel.writeInt(this.attachmentType);
        parcel.writeString(this.channelNo);
        parcel.writeString(this.channelName);
        this.attachmentInfo.writeToParcel(parcel, flags);
        parcel.writeString(this.location);
        parcel.writeString(this.lastUpdateTime);
        parcel.writeParcelable(this.userInfo, flags);
        this.interactInfo.writeToParcel(parcel, flags);
        parcel.writeString(this.popularityValue);
        GoodsRecommendData goodsRecommendData = this.goodsRecommend;
        if (goodsRecommendData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            goodsRecommendData.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.startPosition);
        TextUtils.writeToParcel(this.textContent, parcel, flags);
        Boolean bool = this.showLookMore;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.statusBarHeight);
        TextUtils.writeToParcel(this.closeContent, parcel, flags);
        TextUtils.writeToParcel(this.expandContent, parcel, flags);
        parcel.writeInt(this.textExpand ? 1 : 0);
        parcel.writeInt(this.fromMine ? 1 : 0);
        parcel.writeInt(this.visit);
        parcel.writeString(this.categoryTag);
        WorksPromotionInfo worksPromotionInfo = this.worksPromotionInfo;
        if (worksPromotionInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            worksPromotionInfo.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ WorkDetailBean(String str, String str2, String str3, String str4, int i, String str5, String str6, AttachmentBean attachmentBean, String str7, String str8, UserInfoBean userInfoBean, InteractBean interactBean, String str9, GoodsRecommendData goodsRecommendData, int i2, CharSequence charSequence, Boolean bool, int i3, CharSequence charSequence2, CharSequence charSequence3, boolean z, boolean z2, int i4, String str10, WorksPromotionInfo worksPromotionInfo, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? "" : str2, (i5 & 4) != 0 ? "" : str3, (i5 & 8) != 0 ? "" : str4, (i5 & 16) != 0 ? 1 : i, (i5 & 32) != 0 ? "" : str5, (i5 & 64) != 0 ? "" : str6, (i5 & 128) != 0 ? new AttachmentBean(null, null, 3, null) : attachmentBean, (i5 & 256) != 0 ? "" : str7, (i5 & 512) != 0 ? "" : str8, (i5 & 1024) != 0 ? new UserInfoBean(null, null, null, null, null, null, null, null, 0, false, 0, null, null, false, false, 32767, null) : userInfoBean, (i5 & 2048) != 0 ? new InteractBean(false, 0, 0, false, false, 0, 0, 127, null) : interactBean, (i5 & 4096) != 0 ? "" : str9, (i5 & 8192) != 0 ? null : goodsRecommendData, (i5 & 16384) != 0 ? 1 : i2, (i5 & 32768) != 0 ? null : charSequence, (i5 & 65536) != 0 ? Boolean.FALSE : bool, (i5 & 131072) != 0 ? 22 : i3, (i5 & 262144) != 0 ? null : charSequence2, (i5 & 524288) != 0 ? null : charSequence3, (i5 & 1048576) != 0 ? false : z, (i5 & 2097152) == 0 ? z2 : false, (i5 & 4194304) != 0 ? 1 : i4, (i5 & 8388608) != 0 ? "" : str10, (i5 & 16777216) != 0 ? null : worksPromotionInfo);
    }
}
