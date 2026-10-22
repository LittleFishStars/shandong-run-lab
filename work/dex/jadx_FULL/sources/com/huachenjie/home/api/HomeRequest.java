package com.huachenjie.home.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.home.bean.AccountInspirationBean;
import com.huachenjie.home.bean.AdPopupBean;
import com.huachenjie.home.bean.CompleteTaskBean;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.EleAuthUrlBean;
import com.huachenjie.home.bean.GoodStuffBannerBean;
import com.huachenjie.home.bean.GoodStuffBean;
import com.huachenjie.home.bean.GoodStuffPickData;
import com.huachenjie.home.bean.HomeData;
import com.huachenjie.home.bean.HomeSearchBannerData;
import com.huachenjie.home.bean.InspirationRecordBean;
import com.huachenjie.home.bean.JackpotAwardBean;
import com.huachenjie.home.bean.PointsGoodsBean;
import com.huachenjie.home.bean.ReceiveRewardBean;
import com.huachenjie.home.bean.SignConfigBean;
import com.huachenjie.home.bean.reward.ChangeRewardBean;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import com.huachenjie.works.bean.BuddyCardListBean;
import com.huachenjie.works.bean.BuddyTypeBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\bR\u0010SJ\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0005J\u0015\u0010!\u001a\u0004\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0005J\u0015\u0010\"\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0005J\u001b\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0005J\u0015\u0010&\u001a\u0004\u0018\u00010%H\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J+\u0010+\u001a\u0004\u0018\u00010*2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010)\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J%\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u0004\u0018\u000102H\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u0015\u00105\u001a\u0004\u0018\u000104H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u0010\u0005J#\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b7\u00108J#\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b9\u00108J\u0015\u0010;\u001a\u0004\u0018\u00010:H\u0086@ø\u0001\u0000¢\u0006\u0004\b;\u0010\u0005J-\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0015\u0010@\u001a\u0004\u0018\u00010?H\u0086@ø\u0001\u0000¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010B\u001a\u0004\u0018\u00010AH\u0086@ø\u0001\u0000¢\u0006\u0004\bB\u0010\u0005J\u0013\u0010C\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\bC\u0010\u0005J\u0015\u0010E\u001a\u0004\u0018\u00010DH\u0086@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u0005J\u0013\u0010F\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\bF\u0010\u0005J\u0013\u0010G\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\bG\u0010\u0005J\u0015\u0010I\u001a\u0004\u0018\u00010HH\u0086@ø\u0001\u0000¢\u0006\u0004\bI\u0010\u0005J%\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\bM\u0010>J#\u0010Q\u001a\u00020P2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\bQ\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Lcom/huachenjie/home/api/HomeRequest;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/home/api/HomeApi;", "Lcom/huachenjie/home/bean/HomeSearchBannerData;", j.b, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/HomeData;", t.d, "", "deviceType", "deviceNumber", "Lcom/huachenjie/home/bean/GoodStuffPickData;", "j", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pageNum", "zoneNo", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/home/bean/GoodStuffBean;", "i", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword", "x", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshTime", "", "historyData", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "t", "(ILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/reward/ChangeRewardBean;", "s", "Lcom/huachenjie/home/bean/reward/HomeRewardBean;", "n", "w", "Lcom/huachenjie/home/bean/DailyTasksBean;", "d", "Lcom/huachenjie/home/bean/EleAuthUrlBean;", y6b.f, "", "taskConfigNoList", "requestId", "Lcom/huachenjie/home/bean/CompleteTaskBean;", "A", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskNo", "viewedAd", "Lcom/huachenjie/home/bean/ReceiveRewardBean;", "y", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/AccountInspirationBean;", j.o, "Lcom/huachenjie/base/bean/LotteryDrawBean;", "B", "Lcom/huachenjie/home/bean/InspirationRecordBean;", "q", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "Lcom/huachenjie/home/bean/JackpotAwardBean;", "m", "Lcom/huachenjie/home/bean/PointsGoodsBean;", "r", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/AdPopupBean;", "k", "Lcom/huachenjie/home/bean/GoodStuffBannerBean;", y6b.g, "v", "Lcom/huachenjie/home/bean/SignConfigBean;", "u", "C", "D", "Lcom/huachenjie/works/bean/BuddyTypeBean;", "f", "scopeType", "buddyTypeCode", "Lcom/huachenjie/works/bean/BuddyCardListBean;", "e", "buddyCode", "applyMessage", "", "c", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class HomeRequest extends BaseRepository<HomeApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HomeRequest f34197a = new HomeRequest();

    @Nullable
    public final Object A(@NotNull List<String> list, @NotNull String str, @NotNull Continuation<? super CompleteTaskBean> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("data", list);
        linkedHashMap.put("requestId", str);
        String jSONString = JSON.toJSONString(linkedHashMap);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new HomeRequest$requestCompleteTask$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object B(@NotNull Continuation<? super LotteryDrawBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$requestLotteryPage$2(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object C(@NotNull Continuation<? super Integer> continuation) {
        HomeRequest$submitSign$1 homeRequest$submitSign$1;
        if (continuation instanceof HomeRequest$submitSign$1) {
            homeRequest$submitSign$1 = (HomeRequest$submitSign$1) continuation;
            int i = homeRequest$submitSign$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                homeRequest$submitSign$1.label = i - Integer.MIN_VALUE;
            } else {
                homeRequest$submitSign$1 = new HomeRequest$submitSign$1(this, continuation);
            }
        } else {
            homeRequest$submitSign$1 = new HomeRequest$submitSign$1(this, continuation);
        }
        Object objA = homeRequest$submitSign$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = homeRequest$submitSign$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            HomeRequest$submitSign$result$1 homeRequest$submitSign$result$1 = new HomeRequest$submitSign$result$1(null);
            homeRequest$submitSign$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, homeRequest$submitSign$result$1, homeRequest$submitSign$1);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        JSONObject jSONObject = (JSONObject) objA;
        return Boxing.boxInt(jSONObject != null ? jSONObject.getIntValue("rewardAmount") : 0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object D(@NotNull Continuation<? super Integer> continuation) {
        HomeRequest$submitVideoReward$1 homeRequest$submitVideoReward$1;
        if (continuation instanceof HomeRequest$submitVideoReward$1) {
            homeRequest$submitVideoReward$1 = (HomeRequest$submitVideoReward$1) continuation;
            int i = homeRequest$submitVideoReward$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                homeRequest$submitVideoReward$1.label = i - Integer.MIN_VALUE;
            } else {
                homeRequest$submitVideoReward$1 = new HomeRequest$submitVideoReward$1(this, continuation);
            }
        } else {
            homeRequest$submitVideoReward$1 = new HomeRequest$submitVideoReward$1(this, continuation);
        }
        Object objA = homeRequest$submitVideoReward$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = homeRequest$submitVideoReward$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            HomeRequest$submitVideoReward$result$1 homeRequest$submitVideoReward$result$1 = new HomeRequest$submitVideoReward$result$1(null);
            homeRequest$submitVideoReward$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, homeRequest$submitVideoReward$result$1, homeRequest$submitVideoReward$1);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        JSONObject jSONObject = (JSONObject) objA;
        return Boxing.boxInt(jSONObject != null ? jSONObject.getIntValue("rewardAmount") : 0);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) {
        Object objA = BaseRepositoryExtKt.a(this, new HomeRequest$applyBuddy$2(str, str2, null), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super PageEntity<DailyTasksBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryAvailableTasksList$2(null), continuation);
    }

    @Nullable
    public final Object e(int i, @NotNull String str, @NotNull Continuation<? super BuddyCardListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryBuddyHome$2(i, str, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super BuddyTypeBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryBuddyTypeList$2(null), continuation);
    }

    @Nullable
    public final Object g(@NotNull Continuation<? super EleAuthUrlBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryEleAuthUrl$2(null), continuation);
    }

    @Nullable
    public final Object h(@NotNull Continuation<? super GoodStuffBannerBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryGoodStuffBannerList$2(null), continuation);
    }

    @Nullable
    public final Object i(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super PageEntity<GoodStuffBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryGoodStuffList$2(i, str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object j(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super GoodStuffPickData> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryGoodStuffPick$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object k(@NotNull Continuation<? super AdPopupBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryHomeAdPopup$2(null), continuation);
    }

    @Nullable
    public final Object l(@NotNull Continuation<? super HomeData> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryHomeData$2(null), continuation);
    }

    @Nullable
    public final Object m(@NotNull Continuation<? super JackpotAwardBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryHomeJackpotAward$2(null), continuation);
    }

    @Nullable
    public final Object n(@NotNull Continuation<? super HomeRewardBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryHomeReward$2(null), continuation);
    }

    @Nullable
    public final Object o(@NotNull Continuation<? super HomeSearchBannerData> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryHomeSearchBanner$2(null), continuation);
    }

    @Nullable
    public final Object p(int i, @NotNull Continuation<? super PageEntity<InspirationRecordBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryInspirationConsumeList$2(i, null), continuation);
    }

    @Nullable
    public final Object q(int i, @NotNull Continuation<? super PageEntity<InspirationRecordBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryInspirationGetList$2(i, null), continuation);
    }

    @Nullable
    public final Object r(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<PointsGoodsBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryPointsGoodsList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object s(@NotNull Continuation<? super ChangeRewardBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryRewardList$2(null), continuation);
    }

    @Nullable
    public final Object t(int i, @Nullable String str, boolean z, @NotNull Continuation<? super PageEntity<RewardInfoBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryRewardRecord$2(i, str, z, null), continuation);
    }

    @Nullable
    public final Object u(@NotNull Continuation<? super SignConfigBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$querySignStatus$2(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object v(@NotNull Continuation<? super Boolean> continuation) {
        HomeRequest$querySignTodayStatus$1 homeRequest$querySignTodayStatus$1;
        if (continuation instanceof HomeRequest$querySignTodayStatus$1) {
            homeRequest$querySignTodayStatus$1 = (HomeRequest$querySignTodayStatus$1) continuation;
            int i = homeRequest$querySignTodayStatus$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                homeRequest$querySignTodayStatus$1.label = i - Integer.MIN_VALUE;
            } else {
                homeRequest$querySignTodayStatus$1 = new HomeRequest$querySignTodayStatus$1(this, continuation);
            }
        } else {
            homeRequest$querySignTodayStatus$1 = new HomeRequest$querySignTodayStatus$1(this, continuation);
        }
        Object objA = homeRequest$querySignTodayStatus$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = homeRequest$querySignTodayStatus$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            HomeRequest$querySignTodayStatus$result$1 homeRequest$querySignTodayStatus$result$1 = new HomeRequest$querySignTodayStatus$result$1(null);
            homeRequest$querySignTodayStatus$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, homeRequest$querySignTodayStatus$result$1, homeRequest$querySignTodayStatus$1);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        JSONObject jSONObject = (JSONObject) objA;
        Boolean bool = jSONObject != null ? jSONObject.getBoolean("todaySigned") : null;
        return Boxing.boxBoolean(bool != null ? bool.booleanValue() : true);
    }

    @Nullable
    public final Object w(@NotNull Continuation<? super String> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryTasksRequestId$2(null), continuation);
    }

    @Nullable
    public final Object x(@NotNull String str, int i, @NotNull String str2, @NotNull Continuation<? super PageEntity<GoodStuffBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$queryUnionGoodsSearch$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object y(@NotNull String str, int i, @NotNull Continuation<? super ReceiveRewardBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$receiveReward$2(str, i, null), continuation);
    }

    @Nullable
    public final Object z(@NotNull Continuation<? super AccountInspirationBean> continuation) {
        return BaseRepositoryExtKt.a(this, new HomeRequest$requestAccountInspiration$2(null), continuation);
    }
}
