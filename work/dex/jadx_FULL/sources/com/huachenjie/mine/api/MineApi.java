package com.huachenjie.mine.api;

import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.JsonObject;
import com.huachenjie.base.bean.MineMateData;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mine.bean.AccountWrittenBean;
import com.huachenjie.mine.bean.AvatarFrameBean;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.bean.UserTagBean;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.mine.page.home.showcase.ShowcaseFragment;
import com.huachenjie.mine.page.my_theme.MyThemeActivity;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.external.bean.ChannelBean;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007JA\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012J1\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00042\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0007JK\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJK\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001eJK\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ?\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0012JA\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0012JA\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0012J!\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010'0\u0004H§@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J%\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010+\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0007J%\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010+\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0007J/\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u00022\b\b\u0001\u0010.\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b0\u00101J3\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b4\u00101J%\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u00105\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0007J\u001b\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0004\b7\u0010*J?\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0012J?\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012JA\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0012JK\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u000b2\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001b\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0\u0004H§@ø\u0001\u0000¢\u0006\u0004\b@\u0010*J%\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010B\u001a\u00020AH§@ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/huachenjie/mine/api/MineApi;", "", "", "assignUserId", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/huachenjie/mine/bean/MineData;", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "friendAppUserCode", "Lcom/huachenjie/base/bean/MineMateData;", "e", "", "pageNum", "pageSize", "refreshTime", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/external/bean/FansBean;", "f", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "wearCode", "type", "Lcom/google/gson/JsonObject;", "s", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", MyThemeActivity.t, j.o, "appUserCode", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "m", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n", "y", "Lcom/huachenjie/works/external/bean/ChannelBean;", "t", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "j", "Lcom/huachenjie/works/bean/PostItemBean;", "q", "", "Lcom/huachenjie/mine/bean/AvatarFrameBean;", y6b.f, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "code", "x", "u", "accid", "Lcom/huachenjie/mine/bean/AccountWrittenBean;", "w", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AvatarFragment.AVATAR_URL, UserConstants.USER_PARAMS.b, y6b.g, "slogan", j.b, "c", "p", "k", t.d, ShowcaseFragment.USER_NO, "Lcom/huachenjie/mall/external/bean/CommodityBean;", "v", "(ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mine/bean/UserTagBean;", "i", "Lokhttp3/RequestBody;", "body", "b", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mine_release"}, k = 1, mv = {1, 8, 0})
public interface MineApi {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryAttentionsList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.r(i, i2, str, continuation);
        }

        public static /* synthetic */ Object b(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryFansList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.f(i, i2, str, continuation);
        }

        public static /* synthetic */ Object c(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryHistoryChannelList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.k(i, i2, str, continuation);
        }

        public static /* synthetic */ Object d(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryHistorySubjectList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.l(i, i2, str, continuation);
        }

        public static /* synthetic */ Object e(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryHistoryWorksList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.p(i, i2, str, continuation);
        }

        public static /* synthetic */ Object f(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMyChannelList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.t(i, i2, str, continuation);
        }

        public static /* synthetic */ Object g(MineApi mineApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return mineApi.n(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMyCollectedWorksList");
        }

        public static /* synthetic */ Object h(MineApi mineApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return mineApi.y(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMyLikeWorksList");
        }

        public static /* synthetic */ Object i(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMyPostList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.q(i, i2, str, continuation);
        }

        public static /* synthetic */ Object j(MineApi mineApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMySubjectList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mineApi.j(i, i2, str, continuation);
        }

        public static /* synthetic */ Object k(MineApi mineApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return mineApi.m(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMyWorksList");
        }

        public static /* synthetic */ Object l(MineApi mineApi, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveUserInfo");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return mineApi.h(str, str2, continuation);
        }
    }

    @POST("run-front/api/user/tag/settings")
    @Nullable
    Object b(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/my/clearBrowse")
    @Nullable
    Object c(@NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/homePageUserInfo")
    @Nullable
    Object d(@Field("assignUserId") @Nullable String str, @NotNull Continuation<? super BaseEntity<MineData>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/homePageMetaInfo")
    @Nullable
    Object e(@Field("friendAppUserCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<MineMateData>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/fansList")
    @Nullable
    Object f(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<FansBean>>> continuation);

    @POST("run-front/photoFrame/list")
    @Nullable
    Object g(@NotNull Continuation<? super BaseEntity<List<AvatarFrameBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/account/updateUser")
    @Nullable
    Object h(@Field(AvatarFragment.AVATAR_URL) @Nullable String str, @Field(UserConstants.USER_PARAMS.b) @Nullable String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/user/tag/list")
    @Nullable
    Object i(@NotNull Continuation<? super BaseEntity<UserTagBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/subjectList")
    @Nullable
    Object j(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelTopicBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/channelBrowseList")
    @Nullable
    Object k(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/subjectBrowseList")
    @Nullable
    Object l(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelTopicBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/worksList")
    @Nullable
    Object m(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("appUserCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/collectionList")
    @Nullable
    Object n(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("appUserCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/updateSlogan")
    @Nullable
    Object o(@Field("slogan") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/worksBrowseList")
    @Nullable
    Object p(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/post/my")
    @Nullable
    Object q(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<PostItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/myFollowList")
    @Nullable
    Object r(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<FansBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/cultivate/wear/unselect")
    @Nullable
    Object s(@Field("wearCode") @Nullable String str, @Field("type") int i, @NotNull Continuation<? super BaseEntity<JsonObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/channelList")
    @Nullable
    Object t(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/photoFrame/unlock")
    @Nullable
    Object u(@Field("metaversePhotoFrameCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/commerce/showcase/goods/page")
    @Nullable
    Object v(@Field("pageNum") int i, @Field("refreshTime") @NotNull String str, @Field("pageSize") int i2, @Field(ShowcaseFragment.USER_NO) @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/accountWrittenOff")
    @Nullable
    Object w(@Field("appUserCode") @NotNull String str, @Field("accid") @NotNull String str2, @NotNull Continuation<? super BaseEntity<AccountWrittenBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/photoFrame/wear")
    @Nullable
    Object x(@Field("metaversePhotoFrameCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST(" run-front/api/my/likeList")
    @Nullable
    Object y(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("appUserCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/my/updateCustomThemeImg")
    @Nullable
    Object z(@Field(MyThemeActivity.t) @NotNull String str, @NotNull Continuation<? super BaseEntity<JsonObject>> continuation);
}
