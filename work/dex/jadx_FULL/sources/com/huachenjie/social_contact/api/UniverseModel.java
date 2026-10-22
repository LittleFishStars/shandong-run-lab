package com.huachenjie.social_contact.api;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.bean.BuyStarDrillInfo;
import com.huachenjie.social_contact.bean.CrystalPageInfo;
import com.huachenjie.social_contact.bean.EmojiPropBean;
import com.huachenjie.social_contact.bean.EmojiStickerAddResultBean;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.bean.EmojiStickerDetailBean;
import com.huachenjie.social_contact.bean.EmojiStickerDownloadBean;
import com.huachenjie.social_contact.bean.EmojiStickerFileBean;
import com.huachenjie.social_contact.bean.GameDataBean;
import com.huachenjie.social_contact.bean.IPDataBean;
import com.huachenjie.social_contact.bean.MirrorDimensionBean;
import com.huachenjie.social_contact.bean.NoticeBean;
import com.huachenjie.social_contact.bean.SearchResultBean;
import com.huachenjie.social_contact.bean.SuitDataBean;
import com.huachenjie.social_contact.bean.SuperPackInfo;
import com.huachenjie.social_contact.bean.UserCultivateInfo;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.lo7;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bX\u0010YJ \u0010\u0007\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u0004J\"\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\u00050\u00042\u0006\u0010\n\u001a\u00020\u0002J\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00050\u0004J\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0005\u0018\u00010\u0004J\u0018\u0010\u0015\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0018\u00010\u0004J\u0018\u0010\u0017\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0005\u0018\u00010\u0004J&\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0018\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00050\u0004J\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001c0\u00050\u0004J2\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001c0\u00050\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019J0\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00050\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000bJ8\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00050\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000bJ\u001c\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010)\u001a\u00020\u0002J\u001a\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00050\u00042\u0006\u0010)\u001a\u00020\u0002J\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00050\u00042\u0006\u0010)\u001a\u00020\u0002J,\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010)\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0019J\u001a\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00050\u00042\u0006\u0010)\u001a\u00020\u0002J\u001c\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010)\u001a\u00020\u0002J\u0016\u00106\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u000205\u0018\u00010\u0005\u0018\u00010\u0004J*\u0010:\u001a&\u0012 \u0012\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000208\u0018\u000107j\n\u0012\u0004\u0012\u000208\u0018\u0001`9\u0018\u00010\u0005\u0018\u00010\u0004J\"\u0010=\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010\u0002J>\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010>\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020\u00192\u000e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bJ.\u0010D\u001a\u001a\u0012\u0014\u0012\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001c\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010B\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019J\"\u0010F\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010\u0002J2\u0010H\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010\u00022\u0006\u0010B\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u0019J \u0010J\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010I\u001a\u00020\u0002J \u0010K\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010I\u001a\u00020\u0002J \u0010L\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010I\u001a\u00020\u0002JH\u0010O\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\b\u0010M\u001a\u0004\u0018\u00010\u00022\b\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u00192\u000e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bJF\u0010P\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010M\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u00192\u000e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bJF\u0010R\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00042\u0006\u0010M\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u00192\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010T\u001a\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/huachenjie/social_contact/api/UniverseModel;", "", "", "packCode", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/social_contact/bean/SuperPackInfo;", "p", "Lcom/huachenjie/social_contact/bean/IPDataBean;", "n", "metaverseModelCode", "", "Lcom/huachenjie/social_contact/bean/SuitDataBean;", j.b, "Lcom/huachenjie/social_contact/bean/GameDataBean;", "u", "metaverseGameIconCode", "D", "G", "Lcom/huachenjie/social_contact/bean/CrystalPageInfo;", y6b.g, y6b.f, "Lcom/huachenjie/social_contact/bean/BuyStarDrillInfo;", "b", "wearCode", "", "type", "c", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/EmojiPropBean;", "k", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "s", ShareEmojiFriendDialog.EMOJI_BAG_NAME, "pageNum", "r", "emojiBagIcon", "Lcom/huachenjie/social_contact/bean/EmojiStickerFileBean;", "emojiList", "Lcom/huachenjie/social_contact/bean/EmojiStickerAddResultBean;", "a", "emojiBagCode", "F", "e", "Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "i", "j", "reportReason", "reportType", "y", "Lcom/huachenjie/social_contact/bean/EmojiStickerDownloadBean;", "f", "d", "Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", "q", "Ljava/util/ArrayList;", "Lcom/huachenjie/social_contact/bean/MirrorDimensionBean;", "Lkotlin/collections/ArrayList;", t.d, "alumniId", "Lcom/huachenjie/social_contact/bean/SearchResultBean;", "C", UserConstants.CHAT_PARAMS.g, "reportDesc", "imgUrlList", "A", "noticeType", "Lcom/huachenjie/social_contact/bean/NoticeBean;", "t", "noticeCode", "w", "readType", "v", "code", "E", "I", "H", "bizNo", UserConstants.CHAT_PARAMS.h, "B", "x", "imageList", j.o, "Lcom/huachenjie/social_contact/api/UniverseApi;", "Lkotlin/Lazy;", "m", "()Lcom/huachenjie/social_contact/api/UniverseApi;", "iApi", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UniverseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy iApi = LazyKt.lazy(new Function0<UniverseApi>() { // from class: com.huachenjie.social_contact.api.UniverseModel$iApi$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UniverseApi m756invoke() {
            return (UniverseApi) lo7.e().d(UniverseApi.class);
        }
    });

    @NotNull
    public final Observable<BaseEntity<Object>> A(@NotNull String reportUserId, @Nullable String reportDesc, int reportType, @NotNull List<String> imgUrlList) {
        Intrinsics.checkNotNullParameter(reportUserId, UserConstants.CHAT_PARAMS.g);
        Intrinsics.checkNotNullParameter(imgUrlList, "imgUrlList");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(reportUserId)) {
            map.put(UserConstants.CHAT_PARAMS.g, reportUserId);
        }
        if (!TextUtils.isEmpty(reportDesc)) {
            Intrinsics.checkNotNull(reportDesc);
            map.put("reportDesc", reportDesc);
        }
        map.put("reportType", Integer.valueOf(reportType));
        map.put("imgUrlList", imgUrlList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return m().f(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @NotNull
    public final Observable<BaseEntity<Object>> B(@Nullable String bizNo, @Nullable String reportDesc, int reportType, int reportSource, @NotNull List<String> imgUrlList) {
        Intrinsics.checkNotNullParameter(imgUrlList, "imgUrlList");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(bizNo)) {
            Intrinsics.checkNotNull(bizNo);
            map.put("bizNo", bizNo);
        }
        if (!TextUtils.isEmpty(reportDesc)) {
            Intrinsics.checkNotNull(reportDesc);
            map.put("reportDesc", reportDesc);
        }
        map.put("reportType", Integer.valueOf(reportType));
        map.put(UserConstants.CHAT_PARAMS.h, Integer.valueOf(reportSource));
        map.put("imgUrlList", imgUrlList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return m().o(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @Nullable
    public final Observable<BaseEntity<SearchResultBean>> C(@Nullable String alumniId) {
        return m().C(alumniId);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> D(@NotNull String metaverseGameIconCode) {
        Intrinsics.checkNotNullParameter(metaverseGameIconCode, "metaverseGameIconCode");
        return m().J(metaverseGameIconCode);
    }

    @Nullable
    public final Observable<BaseEntity<Object>> E(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return m().m(code);
    }

    @NotNull
    public final Observable<BaseEntity<EmojiStickerAddResultBean>> F(@NotNull String emojiBagName, @NotNull String emojiBagCode, @NotNull String emojiBagIcon, @NotNull List<EmojiStickerFileBean> emojiList) {
        Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiBagIcon, "emojiBagIcon");
        Intrinsics.checkNotNullParameter(emojiList, "emojiList");
        HashMap map = new HashMap();
        map.put(ShareEmojiFriendDialog.EMOJI_BAG_NAME, emojiBagName);
        map.put("emojiBagCode", emojiBagCode);
        map.put("emojiBagIcon", emojiBagIcon);
        map.put("emojiList", emojiList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return m().c(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @NotNull
    public final Observable<BaseEntity<Object>> G(@NotNull String metaverseGameIconCode) {
        Intrinsics.checkNotNullParameter(metaverseGameIconCode, "metaverseGameIconCode");
        return m().u(metaverseGameIconCode);
    }

    @Nullable
    public final Observable<BaseEntity<Object>> H(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return m().g(code);
    }

    @Nullable
    public final Observable<BaseEntity<Object>> I(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return m().e(code);
    }

    @NotNull
    public final Observable<BaseEntity<EmojiStickerAddResultBean>> a(@NotNull String emojiBagName, @NotNull String emojiBagIcon, @NotNull List<EmojiStickerFileBean> emojiList) {
        Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(emojiBagIcon, "emojiBagIcon");
        Intrinsics.checkNotNullParameter(emojiList, "emojiList");
        HashMap map = new HashMap();
        map.put(ShareEmojiFriendDialog.EMOJI_BAG_NAME, emojiBagName);
        map.put("emojiBagIcon", emojiBagIcon);
        map.put("emojiList", emojiList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return m().v(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @Nullable
    public final Observable<BaseEntity<BuyStarDrillInfo>> b() {
        return m().j();
    }

    @NotNull
    public final Observable<BaseEntity<Object>> c(@Nullable String wearCode, int type) {
        return m().G(wearCode, type);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> d(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        return m().I(emojiBagCode);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> e(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        return m().x(emojiBagCode);
    }

    @NotNull
    public final Observable<BaseEntity<EmojiStickerDownloadBean>> f(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        return m().A(emojiBagCode);
    }

    @Nullable
    public final Observable<BaseEntity<Object>> g() {
        return m().a();
    }

    @Nullable
    public final Observable<BaseEntity<CrystalPageInfo>> h() {
        return m().d();
    }

    @NotNull
    public final Observable<BaseEntity<EmojiStickerDetailBean>> i(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        return m().K(emojiBagCode);
    }

    @NotNull
    public final Observable<BaseEntity<EmojiStickerDetailBean>> j(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        return m().E(emojiBagCode);
    }

    @NotNull
    public final Observable<BaseEntity<PageEntity<EmojiPropBean>>> k() {
        return m().w();
    }

    @Nullable
    public final Observable<BaseEntity<ArrayList<MirrorDimensionBean>>> l() {
        return m().F();
    }

    public final UniverseApi m() {
        Object value = this.iApi.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-iApi>(...)");
        return (UniverseApi) value;
    }

    @NotNull
    public final Observable<BaseEntity<IPDataBean>> n() {
        return m().l();
    }

    @NotNull
    public final Observable<BaseEntity<List<SuitDataBean>>> o(@NotNull String metaverseModelCode) {
        Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
        return m().D(metaverseModelCode);
    }

    @Nullable
    public final Observable<BaseEntity<SuperPackInfo>> p(@NotNull String packCode) {
        Intrinsics.checkNotNullParameter(packCode, "packCode");
        return m().k(packCode);
    }

    @Nullable
    public final Observable<BaseEntity<UserCultivateInfo>> q() {
        return m().r();
    }

    @NotNull
    public final Observable<BaseEntity<PageEntity<EmojiStickerBean>>> r(@Nullable String emojiBagName, int type, int pageNum) {
        return m().n(emojiBagName, type, pageNum, 10);
    }

    @NotNull
    public final Observable<BaseEntity<PageEntity<EmojiStickerBean>>> s() {
        return m().B();
    }

    @Nullable
    public final Observable<BaseEntity<PageEntity<NoticeBean>>> t(int noticeType, int pageNum) {
        return m().s(noticeType, pageNum, 10);
    }

    @NotNull
    public final Observable<BaseEntity<GameDataBean>> u() {
        return m().t();
    }

    @Nullable
    public final Observable<BaseEntity<Object>> v(@Nullable String noticeCode, int noticeType, int readType) {
        UniverseApi universeApiM = m();
        Intrinsics.checkNotNull(noticeCode);
        return universeApiM.q(noticeCode, noticeType, readType);
    }

    @Nullable
    public final Observable<BaseEntity<Object>> w(@Nullable String noticeCode) {
        UniverseApi universeApiM = m();
        Intrinsics.checkNotNull(noticeCode);
        return universeApiM.i(noticeCode);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> x(@NotNull String bizNo, @Nullable String reportDesc, int reportType, int reportSource, @NotNull List<String> imgUrlList) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        Intrinsics.checkNotNullParameter(imgUrlList, "imgUrlList");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(bizNo)) {
            map.put("bizNo", bizNo);
        }
        if (!TextUtils.isEmpty(reportDesc)) {
            Intrinsics.checkNotNull(reportDesc);
            map.put("reportDesc", reportDesc);
        }
        map.put("reportType", Integer.valueOf(reportType));
        map.put(UserConstants.CHAT_PARAMS.h, Integer.valueOf(reportSource));
        map.put("imgUrlList", imgUrlList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return m().y(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @NotNull
    public final Observable<BaseEntity<Object>> y(@NotNull String emojiBagCode, @NotNull String reportReason, int reportType) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(reportReason, "reportReason");
        return m().p(emojiBagCode, reportReason, reportType);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> z(@NotNull String bizNo, @Nullable String reportDesc, int reportType, int reportSource, @NotNull List<String> imageList) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(bizNo)) {
            map.put("bizNo", bizNo);
        }
        if (!TextUtils.isEmpty(reportDesc)) {
            Intrinsics.checkNotNull(reportDesc);
            map.put("reportDesc", reportDesc);
        }
        map.put("reportType", Integer.valueOf(reportType));
        map.put(UserConstants.CHAT_PARAMS.h, Integer.valueOf(reportSource));
        map.put("imageList", imageList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return m().b(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }
}
