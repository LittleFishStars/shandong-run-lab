package com.huachenjie.run.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.CheckRunConfig;
import com.huachenjie.common.bean.CurrentActivityData;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.bean.SunshineRecordRealData;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.bean.UsableGeoFence;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.run.api.ISunshineApi;
import com.huachenjie.run.bean.ActivityRunListBean;
import com.huachenjie.run.bean.AiRecordDetailBean;
import com.huachenjie.run.bean.DanmuBean;
import com.huachenjie.run.bean.EmaSelectionBean;
import com.huachenjie.run.bean.HomeJackpotBriefBean;
import com.huachenjie.run.bean.NearRunStd;
import com.huachenjie.run.bean.OutsideDeductionRecordBean;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.bean.RunFinishBannerData;
import com.huachenjie.run.bean.RunPlanListBean;
import com.huachenjie.run.bean.RunRewardBean;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.bean.VenueRecordDetailBean;
import com.huachenjie.run.bean.WaitReceiveMedalBean;
import com.huachenjie.run.bean.WearableDeductionRecordBean;
import com.huachenjie.run.bean.WearableDeductionSummaryBean;
import com.huachenjie.run.page.free.FreeRunActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\bf\u0010gJ\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018J3\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J+\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0018J)\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J-\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001d\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b0\u0010%J-\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001dJ\u0015\u00104\u001a\u0004\u0018\u000103H\u0086@ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0006J\u0015\u00106\u001a\u0004\u0018\u000105H\u0086@ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0006J)\u0010:\u001a\u00020 2\u0006\u00107\u001a\u00020\u000e2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u0004\u0018\u00010<H\u0086@ø\u0001\u0000¢\u0006\u0004\b=\u0010\u0006J#\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u00032\u0006\u0010>\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b@\u0010%J\u001d\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010A\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\bC\u0010%J\u0015\u0010E\u001a\u0004\u0018\u00010DH\u0086@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u0006J\u001b\u0010G\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bG\u0010\u0006J\u001b\u0010I\u001a\u00020 2\u0006\u0010H\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\bI\u0010%J\u001b\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0006J)\u0010N\u001a\u0004\u0018\u00010M2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?0KH\u0086@ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u001d\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010+\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJU\u0010X\u001a\u0004\u0018\u00010W2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010S\u001a\u0004\u0018\u00010\u000e2\u0006\u0010T\u001a\u00020\f2\b\u0010U\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\u001d\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010[\u001a\u00020ZH\u0086@ø\u0001\u0000¢\u0006\u0004\b]\u0010^J'\u0010`\u001a\u0004\u0018\u00010_2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b`\u0010\u0018J\u001d\u0010b\u001a\u0004\u0018\u00010_2\u0006\u0010a\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\bb\u0010%J\u0015\u0010c\u001a\u0004\u0018\u00010_H\u0086@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u0006J\u0015\u0010e\u001a\u0004\u0018\u00010dH\u0086@ø\u0001\u0000¢\u0006\u0004\be\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lcom/huachenjie/run/model/RunRequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/run/api/ISunshineApi;", "", "Lcom/huachenjie/common/bean/SemesterBean;", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "currentSemester", "Lcom/huachenjie/run/bean/ActivityRunListBean;", "n", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pageNum", "", "semesterCode", "runPlanCode", "type", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/run/bean/RunRewardBean;", "r", "(ILjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/AiRecordDetailBean;", "p", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/VenueRecordDetailBean;", j.o, "Lcom/huachenjie/run/bean/OutsideDeductionRecordBean;", "s", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecordCode", "problemContent", "", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/WearableDeductionSummaryBean;", "C", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/WearableDeductionRecordBean;", "B", "Lcom/huachenjie/run/bean/RunDetailEntity;", "t", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sportType", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "x", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/RunPlanListBean;", "v", "Lcom/huachenjie/common/bean/SunshineRecordRealData;", "y", "Lcom/huachenjie/run/bean/WaitReceiveMedalBean;", "A", "Lcom/huachenjie/run/bean/RunFinishBannerData;", "u", "answerNo", "Lcom/huachenjie/run/bean/EmaSelectionBean;", "selections", "F", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/CurrentActivityData;", y6b.g, "schoolCode", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "w", "sunRunActivityCode", "Lcom/huachenjie/common/bean/ActivityRunDetailBean;", j.b, "Lcom/huachenjie/run/bean/NearRunStd;", "m", "Lcom/huachenjie/run/bean/DanmuBean;", t.d, "content", "D", "k", "", "fenceMap", "Lcom/huachenjie/common/bean/UsableGeoFence;", y6b.f, "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/UnfinishedRun;", "e", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subSchoolCode", FreeRunActivity.y, "activityCode", "fenceCode", "Lcom/huachenjie/common/bean/CheckRunConfig;", "d", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/StartRunPageParam;", "param", "Lcom/huachenjie/common/bean/StartRunEntity;", "E", "(Lcom/huachenjie/run/bean/StartRunPageParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/alibaba/fastjson/JSONObject;", "G", "activityFenceCode", "f", "i", "Lcom/huachenjie/run/bean/HomeJackpotBriefBean;", "q", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunRequestModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunRequestModel.kt\ncom/huachenjie/run/model/RunRequestModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,369:1\n1603#2,9:370\n1855#2:379\n1856#2:381\n1612#2:382\n766#2:383\n857#2,2:384\n1#3:380\n*S KotlinDebug\n*F\n+ 1 RunRequestModel.kt\ncom/huachenjie/run/model/RunRequestModel\n*L\n278#1:370,9\n278#1:379\n278#1:381\n278#1:382\n283#1:383\n283#1:384,2\n278#1:380\n*E\n"})
public final class RunRequestModel extends BaseRepository<ISunshineApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RunRequestModel f35764a = new RunRequestModel();

    @Nullable
    public final Object A(@NotNull Continuation<? super WaitReceiveMedalBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryWaitReceiveMedal$2(null), continuation);
    }

    @Nullable
    public final Object B(int i, @NotNull String str, @NotNull Continuation<? super PageEntity<WearableDeductionRecordBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryWearableDeductionRecords$2(i, str, null), continuation);
    }

    @Nullable
    public final Object C(@NotNull String str, @NotNull Continuation<? super WearableDeductionSummaryBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryWearableDeductionSummary$2(str, null), continuation);
    }

    @Nullable
    public final Object D(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objA = BaseRepositoryExtKt.a(this, new RunRequestModel$sendBarrage$2(str, null), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Nullable
    public final Object E(@NotNull StartRunPageParam startRunPageParam, @NotNull Continuation<? super StartRunEntity> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$startSunRun$2(startRunPageParam, null), continuation);
    }

    @Nullable
    public final Object F(@NotNull String str, @NotNull List<EmaSelectionBean> list, @NotNull Continuation<? super Unit> continuation) {
        Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("answerNo", str), TuplesKt.to("selections", list)});
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType mediaType = MediaType.Companion.get(FastJsonJsonView.DEFAULT_CONTENT_TYPE);
        String jSONString = JSON.toJSONString(mapMapOf);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(bodyMap)");
        Object objA = BaseRepositoryExtKt.a(this, new RunRequestModel$submitEmaAnswer$2(companion.create(mediaType, jSONString), null), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Nullable
    public final Object G(int i, @Nullable String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$sunshineRunResume$2(i, str, null), continuation);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super Unit> continuation) {
        Object objA = BaseRepositoryExtKt.a(this, new RunRequestModel$appeal$2(str, str2, str3, null), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Nullable
    public final Object d(@Nullable String str, @Nullable String str2, int i, @Nullable String str3, @Nullable String str4, @NotNull String str5, int i2, @NotNull Continuation<? super CheckRunConfig> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$checkSunRunConfig$2(str, str2, i, str3, str4, str5, i2, null), continuation);
    }

    @Nullable
    public final Object e(int i, @NotNull Continuation<? super UnfinishedRun> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$checkUnfinishedRun$2(i, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$filterSchoolActivityFence$2(str, null), continuation);
    }

    @Nullable
    public final Object g(@NotNull Map<String, ? extends GeoFenceDetail> map, @NotNull Continuation<? super UsableGeoFence> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(TuplesKt.to("fenceCodeList", new ArrayList(map.keySet()))));
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType mediaType = MediaType.Companion.get(FastJsonJsonView.DEFAULT_CONTENT_TYPE);
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RunRequestModel$filterUsableFence$2(companion.create(mediaType, jSONString), null), continuation);
    }

    @Nullable
    public final Object h(@NotNull Continuation<? super CurrentActivityData> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$getCurrentActivity$2(null), continuation);
    }

    @Nullable
    public final Object i(@NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$getPreRunCheckIn$2(null), continuation);
    }

    @Nullable
    public final Object j(@NotNull Continuation<? super List<SemesterBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$getSemesterList$2(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object k(@NotNull Continuation<? super List<String>> continuation) {
        RunRequestModel$loadDefaultBarrage$1 runRequestModel$loadDefaultBarrage$1;
        if (continuation instanceof RunRequestModel$loadDefaultBarrage$1) {
            runRequestModel$loadDefaultBarrage$1 = (RunRequestModel$loadDefaultBarrage$1) continuation;
            int i = runRequestModel$loadDefaultBarrage$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                runRequestModel$loadDefaultBarrage$1.label = i - Integer.MIN_VALUE;
            } else {
                runRequestModel$loadDefaultBarrage$1 = new RunRequestModel$loadDefaultBarrage$1(this, continuation);
            }
        } else {
            runRequestModel$loadDefaultBarrage$1 = new RunRequestModel$loadDefaultBarrage$1(this, continuation);
        }
        Object objA = runRequestModel$loadDefaultBarrage$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = runRequestModel$loadDefaultBarrage$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            RunRequestModel$loadDefaultBarrage$data$1 runRequestModel$loadDefaultBarrage$data$1 = new RunRequestModel$loadDefaultBarrage$data$1(null);
            runRequestModel$loadDefaultBarrage$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, runRequestModel$loadDefaultBarrage$data$1, runRequestModel$loadDefaultBarrage$1);
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
        if (jSONObject == null) {
            return null;
        }
        Object obj = jSONObject.get("defaultList");
        if (!(obj instanceof List)) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String string = next instanceof String ? (String) next : next != null ? next.toString() : null;
            if (string != null) {
                arrayList.add(string);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object l(@NotNull Continuation<? super List<DanmuBean>> continuation) {
        RunRequestModel$loadLatestBarrage$1 runRequestModel$loadLatestBarrage$1;
        if (continuation instanceof RunRequestModel$loadLatestBarrage$1) {
            runRequestModel$loadLatestBarrage$1 = (RunRequestModel$loadLatestBarrage$1) continuation;
            int i = runRequestModel$loadLatestBarrage$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                runRequestModel$loadLatestBarrage$1.label = i - Integer.MIN_VALUE;
            } else {
                runRequestModel$loadLatestBarrage$1 = new RunRequestModel$loadLatestBarrage$1(this, continuation);
            }
        } else {
            runRequestModel$loadLatestBarrage$1 = new RunRequestModel$loadLatestBarrage$1(this, continuation);
        }
        Object objA = runRequestModel$loadLatestBarrage$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = runRequestModel$loadLatestBarrage$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            RunRequestModel$loadLatestBarrage$2 runRequestModel$loadLatestBarrage$2 = new RunRequestModel$loadLatestBarrage$2(null);
            runRequestModel$loadLatestBarrage$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, runRequestModel$loadLatestBarrage$2, runRequestModel$loadLatestBarrage$1);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        List list = (List) objA;
        if (list != null) {
            return CollectionsKt.filterNotNull(list);
        }
        return null;
    }

    @Nullable
    public final Object m(@NotNull Continuation<? super NearRunStd> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$nearbyRunStd$2(null), continuation);
    }

    @Nullable
    public final Object n(boolean z, @NotNull Continuation<? super ActivityRunListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryActivityList$2(z, null), continuation);
    }

    @Nullable
    public final Object o(@NotNull String str, @NotNull Continuation<? super ActivityRunDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryActivityRunDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object p(int i, @NotNull String str, @NotNull Continuation<? super PageEntity<AiRecordDetailBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryAiRecordDetail$2(i, str, null), continuation);
    }

    @Nullable
    public final Object q(@NotNull Continuation<? super HomeJackpotBriefBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryHomeJackpotAward$2(null), continuation);
    }

    @Nullable
    public final Object r(int i, @Nullable String str, @Nullable String str2, int i2, @NotNull Continuation<? super PageEntity<RunRewardBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryListUserReward$2(i, str, str2, i2, null), continuation);
    }

    @Nullable
    public final Object s(int i, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<OutsideDeductionRecordBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryOutsideDeductionRecords$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object t(@Nullable String str, @Nullable String str2, @NotNull Continuation<? super RunDetailEntity> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryRunDetail$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object u(@NotNull Continuation<? super RunFinishBannerData> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryRunFinishBanner$2(null), continuation);
    }

    @Nullable
    public final Object v(@NotNull String str, @NotNull Continuation<? super RunPlanListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryRunPlanList$2(str, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object w(@NotNull String str, @NotNull Continuation<? super List<? extends GeoFenceDetail>> continuation) {
        RunRequestModel$querySchoolFences$1 runRequestModel$querySchoolFences$1;
        if (continuation instanceof RunRequestModel$querySchoolFences$1) {
            runRequestModel$querySchoolFences$1 = (RunRequestModel$querySchoolFences$1) continuation;
            int i = runRequestModel$querySchoolFences$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                runRequestModel$querySchoolFences$1.label = i - Integer.MIN_VALUE;
            } else {
                runRequestModel$querySchoolFences$1 = new RunRequestModel$querySchoolFences$1(this, continuation);
            }
        } else {
            runRequestModel$querySchoolFences$1 = new RunRequestModel$querySchoolFences$1(this, continuation);
        }
        Object objA = runRequestModel$querySchoolFences$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = runRequestModel$querySchoolFences$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            RunRequestModel$querySchoolFences$2 runRequestModel$querySchoolFences$2 = new RunRequestModel$querySchoolFences$2(str, null);
            runRequestModel$querySchoolFences$1.label = 1;
            objA = BaseRepositoryExtKt.a(this, runRequestModel$querySchoolFences$2, runRequestModel$querySchoolFences$1);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        List list = (List) objA;
        if (list != null) {
            return CollectionsKt.filterNotNull(list);
        }
        return null;
    }

    @Nullable
    public final Object x(@NotNull String str, @NotNull String str2, int i, @NotNull Continuation<? super SunshineRunDetail> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$querySunRunAbstractInfo$2(str, str2, i, null), continuation);
    }

    @Nullable
    public final Object y(int i, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super SunshineRecordRealData> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$querySunshineRecordList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object z(int i, @NotNull String str, @NotNull Continuation<? super PageEntity<VenueRecordDetailBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RunRequestModel$queryVenueRecordDetail$2(i, str, null), continuation);
    }
}
