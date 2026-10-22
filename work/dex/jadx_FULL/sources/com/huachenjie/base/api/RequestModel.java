package com.huachenjie.base.api;

import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.EntryTypeUrlBean;
import com.huachenjie.base.bean.InspirationWidgetInfo;
import com.huachenjie.base.bean.LetterData;
import com.huachenjie.base.bean.UserThirdInfo;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.CustomerServerStatusData;
import com.huachenjie.common.bean.VersionUpgrade;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.sj8;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0005J\u001d\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0005J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001d\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010\u000eJ\u0015\u0010!\u001a\u0004\u0018\u00010\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0005J\u0015\u0010#\u001a\u0004\u0018\u00010\"H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0005J\u001d\u0010%\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010\u000eJ-\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J-\u0010,\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b,\u0010+J-\u00100\u001a\u0004\u0018\u00010\u00192\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u0004\u0018\u000102H\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005R\u001b\u00108\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/huachenjie/base/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/base/api/BaseApi;", "Lcom/huachenjie/base/bean/InspirationWidgetInfo;", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/VersionUpgrade;", y6b.f, "Lcom/huachenjie/common/bean/CommonUserInfo;", t.d, "", "interactJson", "", "q", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "Lcom/huachenjie/common/bean/CustomerServerStatusData;", y6b.g, "", "source", "Lcom/huachenjie/base/bean/UserThirdInfo;", j.b, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authAgreementCode", "status", "", "f", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entryType", "Lcom/huachenjie/base/bean/EntryTypeUrlBean;", "m", "faceImg", "s", "c", "Lcom/huachenjie/base/bean/LetterData;", "i", "schoolLetterRelationCode", "p", "lotteryNo", "inspiration", "awardNo", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "d", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "runRecordCode", "bizNo", "freeDetailNo", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/BrandPromotionConfigBean;", "k", "b", "Lkotlin/Lazy;", "j", "()Lcom/huachenjie/base/api/BaseApi;", "skipSslApi", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<BaseApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f32789a = new RequestModel();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final Lazy skipSslApi = LazyKt.lazy(new Function0<BaseApi>() { // from class: com.huachenjie.base.api.RequestModel$skipSslApi$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseApi m210invoke() {
            return (BaseApi) sj8.a.a(BaseApi.class);
        }
    });

    @Nullable
    public final Object c(@NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$authUserFace$2(null), continuation);
    }

    @Nullable
    public final Object d(@NotNull String str, int i, @NotNull String str2, @NotNull Continuation<? super RewardInfoBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$awardDraw$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object e(@NotNull String str, int i, @NotNull String str2, @NotNull Continuation<? super RewardInfoBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$awardExchange$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull String str, int i, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$bindAuthAgreementNew$2(str, i, null), continuation);
    }

    @Nullable
    public final Object g(@NotNull Continuation<? super VersionUpgrade> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkUpgrade$2(null), continuation);
    }

    @Nullable
    public final Object h(@NotNull Continuation<? super CustomerServerStatusData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getCustomerServerStatus$2(null), continuation);
    }

    @Nullable
    public final Object i(@NotNull Continuation<? super LetterData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getImportantLetterList$2(null), continuation);
    }

    public final BaseApi j() {
        return (BaseApi) skipSslApi.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object k(@NotNull Continuation<? super BrandPromotionConfigBean> continuation) {
        RequestModel$queryBrandPromotionConfig$1 requestModel$queryBrandPromotionConfig$1;
        if (continuation instanceof RequestModel$queryBrandPromotionConfig$1) {
            requestModel$queryBrandPromotionConfig$1 = (RequestModel$queryBrandPromotionConfig$1) continuation;
            int i = requestModel$queryBrandPromotionConfig$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                requestModel$queryBrandPromotionConfig$1.label = i - Integer.MIN_VALUE;
            } else {
                requestModel$queryBrandPromotionConfig$1 = new RequestModel$queryBrandPromotionConfig$1(this, continuation);
            }
        } else {
            requestModel$queryBrandPromotionConfig$1 = new RequestModel$queryBrandPromotionConfig$1(this, continuation);
        }
        Object objA = requestModel$queryBrandPromotionConfig$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = requestModel$queryBrandPromotionConfig$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            RequestModel$queryBrandPromotionConfig$config$1 requestModel$queryBrandPromotionConfig$config$1 = new RequestModel$queryBrandPromotionConfig$config$1(null);
            requestModel$queryBrandPromotionConfig$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, requestModel$queryBrandPromotionConfig$config$1, requestModel$queryBrandPromotionConfig$1);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        BrandPromotionConfigBean brandPromotionConfigBean = (BrandPromotionConfigBean) objA;
        if (brandPromotionConfigBean == null) {
            ai9.a();
        } else {
            ai9.q(brandPromotionConfigBean);
        }
        return brandPromotionConfigBean;
    }

    @Nullable
    public final Object l(@NotNull Continuation<? super CommonUserInfo> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCommonUserInfo$2(null), continuation);
    }

    @Nullable
    public final Object m(int i, @NotNull Continuation<? super EntryTypeUrlBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryEntryUrl$2(i, null), continuation);
    }

    @Nullable
    public final Object n(@NotNull Continuation<? super InspirationWidgetInfo> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryInspirationWidgetInfo$2(null), continuation);
    }

    @Nullable
    public final Object o(int i, @NotNull Continuation<? super UserThirdInfo> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryUserThirdInfoNew$2(i, null), continuation);
    }

    @Nullable
    public final Object p(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$readSchoolLetter$2(str, null), continuation);
    }

    @Nullable
    public final Object q(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateInteractEvent$2(RequestBody.Companion.create(str, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object r(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateRankingInteractEvent$2(RequestBody.Companion.create(str, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object s(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateUserFace$2(str, null), continuation);
    }

    @Nullable
    public final Object t(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$uploadFreeDetail$2(str, str2, str3, null), continuation);
    }
}
