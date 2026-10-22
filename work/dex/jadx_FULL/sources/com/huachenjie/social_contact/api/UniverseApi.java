package com.huachenjie.social_contact.api;

import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.social_contact.bean.BuyStarDrillInfo;
import com.huachenjie.social_contact.bean.CrystalPageInfo;
import com.huachenjie.social_contact.bean.DrinkCategory;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import com.huachenjie.social_contact.bean.EmojiPropBean;
import com.huachenjie.social_contact.bean.EmojiStickerAddResultBean;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.bean.EmojiStickerDetailBean;
import com.huachenjie.social_contact.bean.EmojiStickerDownloadBean;
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
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J,\u0010\u0007\u001a&\u0012 \u0012\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006\u0018\u00010\u0003\u0018\u00010\u0002H'J&\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH'J\u0018\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0018\u00010\u0002H'J \u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'J>\u0010\u0017\u001a\u001a\u0012\u0014\u0012\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u0011H'J$\u0010\u0019\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\u0018\u001a\u00020\bH'J8\u0010\u001b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\u0018\u001a\u00020\b2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u001a\u001a\u00020\u0011H'J$\u0010\u001e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\u001c\u001a\u00020\bH'J\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00030\u0002H'J&\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0018\u00010\u00030\u00022\b\b\u0001\u0010!\u001a\u00020\bH'J\u0016\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00030\u0002H'J \u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010'\u001a\u00020\bH'J \u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010'\u001a\u00020\bH'J$\u0010+\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010*\u001a\u00020\bH'J$\u0010-\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010,\u001a\u00020\bH'J$\u0010.\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010,\u001a\u00020\bH'J\u001a\u00100\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010\u0003\u0018\u00010\u0002H'J\u001a\u00101\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u0002H'J\u001a\u00103\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010\u0003\u0018\u00010\u0002H'J,\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\n\b\u0001\u00104\u001a\u0004\u0018\u00010\b2\b\b\u0001\u00105\u001a\u00020\u0011H'J\u001a\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00150\u00030\u0002H'J\u001a\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00150\u00030\u0002H'JD\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00150\u00030\u00022\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\b2\b\b\u0001\u00105\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u0011H'J\u001e\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'J\u001e\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'J \u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010@\u001a\u00020\bH'J\u001e\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u00030\u00022\b\b\u0001\u0010@\u001a\u00020\bH'J\u001e\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u00030\u00022\b\b\u0001\u0010@\u001a\u00020\bH'J4\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010@\u001a\u00020\b2\b\b\u0001\u0010E\u001a\u00020\b2\b\b\u0001\u0010F\u001a\u00020\u0011H'J\u001e\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00030\u00022\b\b\u0001\u0010@\u001a\u00020\bH'J \u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010@\u001a\u00020\bH'J \u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'J \u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'J \u0010M\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'J!\u0010P\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020O\u0018\u00010\u00150NH§@ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ?\u0010T\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020S\u0018\u00010\u00150N2\b\b\u0001\u0010\u0013\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u00112\b\b\u0001\u0010R\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ%\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010N2\b\b\u0001\u0010V\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Lcom/huachenjie/social_contact/api/UniverseApi;", "", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Ljava/util/ArrayList;", "Lcom/huachenjie/social_contact/bean/MirrorDimensionBean;", "Lkotlin/collections/ArrayList;", "F", "", "alumniId", "Lcom/huachenjie/social_contact/bean/SearchResultBean;", "C", "Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", "r", "Lokhttp3/RequestBody;", "body", "f", "", "noticeType", "pageNum", "pageSize", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/NoticeBean;", "s", "noticeCode", "i", "readType", "q", "packCode", "Lcom/huachenjie/social_contact/bean/SuperPackInfo;", "k", "Lcom/huachenjie/social_contact/bean/IPDataBean;", t.d, "metaverseModelCode", "", "Lcom/huachenjie/social_contact/bean/SuitDataBean;", "D", "Lcom/huachenjie/social_contact/bean/GameDataBean;", "t", "metaverseGameIconCode", "J", "u", "metaverseIpCode", y6b.f, "metaversePartCode", "m", "e", "Lcom/huachenjie/social_contact/bean/CrystalPageInfo;", "d", "a", "Lcom/huachenjie/social_contact/bean/BuyStarDrillInfo;", "j", "wearCode", "type", "G", "Lcom/huachenjie/social_contact/bean/EmojiPropBean;", "w", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "B", ShareEmojiFriendDialog.EMOJI_BAG_NAME, "n", "Lcom/huachenjie/social_contact/bean/EmojiStickerAddResultBean;", "v", "c", "emojiBagCode", "x", "Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "K", "E", "reportReason", "reportType", "p", "Lcom/huachenjie/social_contact/bean/EmojiStickerDownloadBean;", "A", "I", j.b, "y", "b", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/huachenjie/social_contact/bean/DrinkCategory;", "H", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "categoryCode", "Lcom/huachenjie/social_contact/bean/DrinkDetailBean;", y6b.g, "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drinkId", j.o, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public interface UniverseApi {
    @FormUrlEncoded
    @POST("run-front/emoji/download")
    @NotNull
    Observable<BaseEntity<EmojiStickerDownloadBean>> A(@Field("emojiBagCode") @NotNull String emojiBagCode);

    @POST("run-front/emoji/listHotEmojiBag")
    @NotNull
    Observable<BaseEntity<PageEntity<EmojiStickerBean>>> B();

    @FormUrlEncoded
    @POST("run-front/api/user/alumni/search")
    @Nullable
    Observable<BaseEntity<SearchResultBean>> C(@Field("alumniId") @Nullable String alumniId);

    @FormUrlEncoded
    @POST("run-front/cultivate/modelList")
    @NotNull
    Observable<BaseEntity<List<SuitDataBean>>> D(@Field("metaverseModelCode") @NotNull String metaverseModelCode);

    @FormUrlEncoded
    @POST("run-front/emoji/getEmojiList")
    @NotNull
    Observable<BaseEntity<EmojiStickerDetailBean>> E(@Field("emojiBagCode") @NotNull String emojiBagCode);

    @POST("run-front/metaverse/friend/friendList")
    @Nullable
    Observable<BaseEntity<ArrayList<MirrorDimensionBean>>> F();

    @FormUrlEncoded
    @POST("run-front/cultivate/wear/unselect")
    @NotNull
    Observable<BaseEntity<Object>> G(@Field("wearCode") @Nullable String wearCode, @Field("type") int type);

    @POST("run-front/space/energy/drinkCategories")
    @Nullable
    Object H(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<PageEntity<DrinkCategory>>> continuation);

    @FormUrlEncoded
    @POST("run-front/emoji/delDownload")
    @NotNull
    Observable<BaseEntity<Object>> I(@Field("emojiBagCode") @NotNull String emojiBagCode);

    @FormUrlEncoded
    @POST("run-front/gameIcon/unlock")
    @NotNull
    Observable<BaseEntity<Object>> J(@Field("metaverseGameIconCode") @NotNull String metaverseGameIconCode);

    @FormUrlEncoded
    @POST("run-front/emoji/getEmojiBagDetail")
    @NotNull
    Observable<BaseEntity<EmojiStickerDetailBean>> K(@Field("emojiBagCode") @NotNull String emojiBagCode);

    @POST("run-front/cultivate/exchangeCrystal")
    @Nullable
    Observable<BaseEntity<Object>> a();

    @POST("run-front/api/social/live/postReport/add")
    @NotNull
    Observable<BaseEntity<Object>> b(@Body @NotNull RequestBody body);

    @POST("run-front/emoji/updateEmojiBag")
    @NotNull
    Observable<BaseEntity<EmojiStickerAddResultBean>> c(@Body @NotNull RequestBody body);

    @POST("run-front/cultivate/exchangeCrystalPage")
    @Nullable
    Observable<BaseEntity<CrystalPageInfo>> d();

    @FormUrlEncoded
    @POST("run-front/cultivate/wearPart")
    @Nullable
    Observable<BaseEntity<Object>> e(@Field("metaversePartCode") @NotNull String metaversePartCode);

    @POST("run-front/metaverse/user/reportUser")
    @NotNull
    Observable<BaseEntity<Object>> f(@Body @NotNull RequestBody body);

    @FormUrlEncoded
    @POST("run-front/cultivate/wearIp")
    @Nullable
    Observable<BaseEntity<Object>> g(@Field("metaverseIpCode") @NotNull String metaverseIpCode);

    @FormUrlEncoded
    @POST("run-front/space/energy/drinkList")
    @Nullable
    Object h(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("categoryCode") int i3, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<PageEntity<DrinkDetailBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/notice/receiveNoticeGift")
    @Nullable
    Observable<BaseEntity<Object>> i(@Field("noticeCode") @NotNull String noticeCode);

    @POST("run-front/cultivate/buyStarDrill")
    @Nullable
    Observable<BaseEntity<BuyStarDrillInfo>> j();

    @FormUrlEncoded
    @POST("run-front/store/cultivate/getSuperPackInfo")
    @Nullable
    Observable<BaseEntity<SuperPackInfo>> k(@Field("packCode") @NotNull String packCode);

    @POST("run-front/cultivate/ipList")
    @NotNull
    Observable<BaseEntity<IPDataBean>> l();

    @FormUrlEncoded
    @POST("run-front/cultivate/unlockPart")
    @Nullable
    Observable<BaseEntity<Object>> m(@Field("metaversePartCode") @NotNull String metaversePartCode);

    @FormUrlEncoded
    @POST("run-front/emoji/listEmojiBag")
    @NotNull
    Observable<BaseEntity<PageEntity<EmojiStickerBean>>> n(@Field(ShareEmojiFriendDialog.EMOJI_BAG_NAME) @Nullable String emojiBagName, @Field("type") int type, @Field("pageNum") int pageNum, @Field("pageSize") int pageSize);

    @POST("run-front/api/works/report")
    @NotNull
    Observable<BaseEntity<Object>> o(@Body @NotNull RequestBody body);

    @FormUrlEncoded
    @POST("run-front/emoji/report")
    @NotNull
    Observable<BaseEntity<Object>> p(@Field("emojiBagCode") @NotNull String emojiBagCode, @Field("reportReason") @NotNull String reportReason, @Field("reportType") int reportType);

    @FormUrlEncoded
    @POST("run-front/notice/readNotice")
    @Nullable
    Observable<BaseEntity<Object>> q(@Field("noticeCode") @NotNull String noticeCode, @Field("noticeType") int noticeType, @Field("readType") int readType);

    @POST("run-front/cultivate/getUserCultivateInfo")
    @Nullable
    Observable<BaseEntity<UserCultivateInfo>> r();

    @FormUrlEncoded
    @POST("run-front/notice/pageNoticeV3")
    @Nullable
    Observable<BaseEntity<PageEntity<NoticeBean>>> s(@Field("noticeType") int noticeType, @Field("pageNum") int pageNum, @Field("pageSize") int pageSize);

    @POST("run-front/gameIcon/listGameIcon")
    @NotNull
    Observable<BaseEntity<GameDataBean>> t();

    @FormUrlEncoded
    @POST("run-front/gameIcon/wear")
    @NotNull
    Observable<BaseEntity<Object>> u(@Field("metaverseGameIconCode") @NotNull String metaverseGameIconCode);

    @POST("run-front/emoji/addEmojiBag")
    @NotNull
    Observable<BaseEntity<EmojiStickerAddResultBean>> v(@Body @NotNull RequestBody body);

    @POST("run-front/emoji/getProp")
    @NotNull
    Observable<BaseEntity<PageEntity<EmojiPropBean>>> w();

    @FormUrlEncoded
    @POST("run-front/emoji/deleteEmojiBag")
    @NotNull
    Observable<BaseEntity<Object>> x(@Field("emojiBagCode") @NotNull String emojiBagCode);

    @POST("run-front/api/social/quote/report")
    @NotNull
    Observable<BaseEntity<Object>> y(@Body @NotNull RequestBody body);

    @FormUrlEncoded
    @POST("run-front/space/energy/purchaseDrink")
    @Nullable
    Object z(@Field("drinkId") @NotNull String str, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Object>> continuation);
}
