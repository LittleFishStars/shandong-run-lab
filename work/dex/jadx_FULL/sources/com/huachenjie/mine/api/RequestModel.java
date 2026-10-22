package com.huachenjie.mine.api;

import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huachenjie.base.bean.MineMateData;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
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
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u0010AJ\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J/\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0007J;\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ;\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ;\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ/\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0010J/\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0010J/\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0010J\u001b\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0007J\u001d\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0007J\u001d\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0007J\u001d\u0010/\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0007J\u001d\u00101\u001a\u0004\u0018\u00010)2\u0006\u00100\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0007J\u001d\u00103\u001a\u0004\u0018\u00010)2\u0006\u00102\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0007J\u0015\u00104\u001a\u0004\u0018\u00010)H\u0086@ø\u0001\u0000¢\u0006\u0004\b4\u0010'J/\u00105\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u0010\u0010J/\u00106\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0010J/\u00107\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b7\u0010\u0010J7\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b:\u0010\u001bJ\u0015\u0010<\u001a\u0004\u0018\u00010;H\u0086@ø\u0001\u0000¢\u0006\u0004\b<\u0010'J#\u0010>\u001a\u0004\u0018\u00010)2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0086@ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/huachenjie/mine/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/mine/api/MineApi;", "", "appUserCode", "Lcom/huachenjie/mine/bean/MineData;", "F", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/base/bean/MineMateData;", "G", "", "pageNum", "refreshTime", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/external/bean/FansBean;", "i", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", y6b.f, "wearCode", "type", "Lcom/google/gson/JsonObject;", "c", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", MyThemeActivity.t, "M", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "A", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "u", "Lcom/huachenjie/works/external/bean/ChannelBean;", "q", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "y", "Lcom/huachenjie/works/bean/PostItemBean;", "w", "", "Lcom/huachenjie/mine/bean/AvatarFrameBean;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "code", "", "N", "L", "Lcom/huachenjie/mine/bean/AccountWrittenBean;", "d", UserConstants.USER_PARAMS.b, "I", AvatarFragment.AVATAR_URL, "H", "slogan", "J", "e", j.b, "k", "m", ShowcaseFragment.USER_NO, "Lcom/huachenjie/mall/external/bean/CommodityBean;", "C", "Lcom/huachenjie/mine/bean/UserTagBean;", "E", "tagNoList", "K", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<MineApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f35285a = new RequestModel();

    public static /* synthetic */ Object B(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.A(i, str, str2, continuation);
    }

    public static /* synthetic */ Object D(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.C(i, str, str2, continuation);
    }

    public static /* synthetic */ Object h(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.g(i, str, continuation);
    }

    public static /* synthetic */ Object j(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.i(i, str, continuation);
    }

    public static /* synthetic */ Object l(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.k(i, str, continuation);
    }

    public static /* synthetic */ Object n(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.m(i, str, continuation);
    }

    public static /* synthetic */ Object p(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.o(i, str, continuation);
    }

    public static /* synthetic */ Object r(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.q(i, str, continuation);
    }

    public static /* synthetic */ Object t(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.s(i, str, str2, continuation);
    }

    public static /* synthetic */ Object v(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.u(i, str, str2, continuation);
    }

    public static /* synthetic */ Object x(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.w(i, str, continuation);
    }

    public static /* synthetic */ Object z(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.y(i, str, continuation);
    }

    @Nullable
    public final Object A(int i, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMyWorksList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object C(int i, @NotNull String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<CommodityBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryShowcaseList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object E(@NotNull Continuation<? super UserTagBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryUserTagList$2(null), continuation);
    }

    @Nullable
    public final Object F(@Nullable String str, @NotNull Continuation<? super MineData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestMineInfo$2(str, null), continuation);
    }

    @Nullable
    public final Object G(@Nullable String str, @NotNull Continuation<? super MineMateData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestMineMetaInfo$2(str, null), continuation);
    }

    @Nullable
    public final Object H(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$saveUserAvatar$2(str, null), continuation);
    }

    @Nullable
    public final Object I(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$saveUserNickname$2(str, null), continuation);
    }

    @Nullable
    public final Object J(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$saveUserSlogan$2(str, null), continuation);
    }

    @Nullable
    public final Object K(@NotNull List<String> list, @NotNull Continuation<Object> continuation) {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("tagNoList", list));
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(mapMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(map)");
        return BaseRepositoryExtKt.a(this, new RequestModel$settingsTag$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object L(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$unlockMetaverseAvatarFrame$2(str, null), continuation);
    }

    @Nullable
    public final Object M(@NotNull String str, @NotNull Continuation<? super JsonObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateCustomThemeImg$2(str, null), continuation);
    }

    @Nullable
    public final Object N(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$wearMetaverseAvatarFrame$2(str, null), continuation);
    }

    @Nullable
    public final Object c(@NotNull String str, int i, @NotNull Continuation<? super JsonObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$cancelWear$2(str, i, null), continuation);
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull Continuation<? super AccountWrittenBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkAccount$2(str, null), continuation);
    }

    @Nullable
    public final Object e(@NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$clearHistory$2(null), continuation);
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super List<AvatarFrameBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$listMetaverseAvatarFrame$2(null), continuation);
    }

    @Nullable
    public final Object g(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<FansBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryAttentionsList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object i(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<FansBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryFansList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object k(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<ChannelBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHistoryChannelList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object m(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<ChannelTopicBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHistorySubjectList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object o(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHistoryWorksList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object q(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<ChannelBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMyChannelList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object s(int i, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMyCollectedWorksList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object u(int i, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMyLikeWorksList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object w(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<PostItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMyPostList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object y(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<ChannelTopicBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMySubjectList$2(i, str, null), continuation);
    }
}
