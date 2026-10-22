package com.huachenjie.run.api;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.common.bean.BaseListData;
import com.huachenjie.common.bean.CheckRunConfig;
import com.huachenjie.common.bean.CurrentActivityData;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.bean.SunshineRecordRealData;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.bean.UsableGeoFence;
import com.huachenjie.run.bean.ActivityRunListBean;
import com.huachenjie.run.bean.AiRecordDetailBean;
import com.huachenjie.run.bean.DanmuBean;
import com.huachenjie.run.bean.HomeJackpotBriefBean;
import com.huachenjie.run.bean.NearRunStd;
import com.huachenjie.run.bean.OutsideDeductionRecordBean;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.bean.RunFinishBannerData;
import com.huachenjie.run.bean.RunPlanListBean;
import com.huachenjie.run.bean.RunRewardBean;
import com.huachenjie.run.bean.SunshineRankingData;
import com.huachenjie.run.bean.VenueRecordDetailBean;
import com.huachenjie.run.bean.VideoInfoData;
import com.huachenjie.run.bean.WaitReceiveMedalBean;
import com.huachenjie.run.bean.WearableDeductionRecordBean;
import com.huachenjie.run.bean.WearableDeductionSummaryBean;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.free.FreeRunActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JG\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\bH§@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0013\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'J'\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\b2\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J.\u0010\u0018\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005H'J/\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f0\b2\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0015J%\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\b2\b\b\u0001\u0010\u001a\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0015J'\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\b2\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001dH§@ø\u0001\u0000¢\u0006\u0004\b \u0010!J?\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\b$\u0010%Ji\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\b2\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010'\u001a\u00020\u00022\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010)\u001a\u00020\u00052\b\b\u0001\u0010*\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J1\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\b2\u0014\b\u0001\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.H§@ø\u0001\u0000¢\u0006\u0004\b1\u00102J}\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\b2\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u00104\u001a\u0002032\b\b\u0001\u00105\u001a\u0002032\b\b\u0001\u0010'\u001a\u0002062\b\b\u0001\u00108\u001a\u0002072\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010*\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J1\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\b2\b\b\u0001\u0010<\u001a\u00020\u00022\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J&\u0010?\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'J&\u0010@\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'J&\u0010A\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'J3\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\b2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ%\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0\b2\b\b\u0001\u0010E\u001a\u000206H§@ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ,\u0010K\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010I\u0018\u00010\u0011\u0018\u00010\u00102\b\b\u0001\u0010E\u001a\u000206H'J\u001b\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\bH§@ø\u0001\u0000¢\u0006\u0004\bL\u0010\u000fJ#\u0010N\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010\f0\bH§@ø\u0001\u0000¢\u0006\u0004\bN\u0010\u000fJ'\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\n\b\u0001\u0010O\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0015J:\u0010T\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010\u0011\u0018\u00010\u00102\b\b\u0001\u0010Q\u001a\u00020\u00022\b\b\u0001\u0010R\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H'JN\u0010V\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010\u0011\u0018\u00010\u00102\b\b\u0001\u0010Q\u001a\u00020\u00022\b\b\u0001\u0010R\u001a\u00020\u00022\b\b\u0001\u0010U\u001a\u00020\u00022\b\b\u0001\u0010<\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H'J=\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W0\b2\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010*\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ%\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0\b2\b\b\u0001\u0010Z\u001a\u000207H§@ø\u0001\u0000¢\u0006\u0004\b\\\u0010]J%\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010_0\b2\b\b\u0001\u0010^\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b`\u0010\u0015JW\u0010c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020b\u0018\u00010a0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010<\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bc\u0010dJA\u0010f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020e\u0018\u00010a0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bf\u0010gJA\u0010i\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020h\u0018\u00010a0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bi\u0010gJM\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020j\u0018\u00010a0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bk\u0010\u000bJ'\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0\b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0015JA\u0010o\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020n\u0018\u00010a0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\bo\u0010gJ\u001b\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0\bH§@ø\u0001\u0000¢\u0006\u0004\bq\u0010\u000fJ%\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0004\br\u0010!J\u001b\u0010t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010s0\bH§@ø\u0001\u0000¢\u0006\u0004\bt\u0010\u000fJ\u001b\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010u0\bH§@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u000fJ\u001b\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\bH§@ø\u0001\u0000¢\u0006\u0004\bv\u0010\u000fJ\u001b\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0\bH§@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, d2 = {"Lcom/huachenjie/run/api/ISunshineApi;", "", "", "pageSize", "pageNum", "", "semesterCode", "runPlanCode", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/huachenjie/common/bean/SunshineRecordRealData;", "D", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/huachenjie/common/bean/SemesterBean;", y6b.f, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/run/bean/RunPlanListBean;", "j", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "schoolCode", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "I", "H", "activityFenceCode", "Lcom/alibaba/fastjson/JSONObject;", "B", "Lokhttp3/RequestBody;", "body", "Lcom/huachenjie/common/bean/UsableGeoFence;", "k", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecordCode", "problemContent", "J", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subSchoolCode", FreeRunActivity.y, "activityCode", "fenceCode", "sportType", "Lcom/huachenjie/common/bean/CheckRunConfig;", t.d, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "map", "Lcom/huachenjie/common/bean/UnfinishedRun;", "s", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "lat", "lng", "", "", ReadyActivity.t, "Lcom/huachenjie/common/bean/StartRunEntity;", "K", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDJZLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "type", "n", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "F", "a", "Lcom/huachenjie/run/bean/RunDetailEntity;", "q", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Lcom/huachenjie/run/bean/NearRunStd;", "p", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/BaseListData;", "Lcom/huachenjie/run/bean/VideoInfoData;", "M", "L", "Lcom/huachenjie/run/bean/DanmuBean;", "v", "content", "G", "sex", "scope", "Lcom/huachenjie/run/bean/SunshineRankingData;", "x", "rankCycle", j.b, "Lcom/huachenjie/common/bean/SunshineRunDetail;", "d", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentSemester", "Lcom/huachenjie/run/bean/ActivityRunListBean;", "u", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sunRunActivityCode", "Lcom/huachenjie/common/bean/ActivityRunDetailBean;", "i", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/run/bean/RunRewardBean;", "m", "(IILjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/AiRecordDetailBean;", "r", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/run/bean/VenueRecordDetailBean;", y6b.g, "Lcom/huachenjie/run/bean/OutsideDeductionRecordBean;", "y", "Lcom/huachenjie/run/bean/WearableDeductionSummaryBean;", "C", "Lcom/huachenjie/run/bean/WearableDeductionRecordBean;", "f", "Lcom/huachenjie/run/bean/RunFinishBannerData;", "w", "E", "Lcom/huachenjie/run/bean/WaitReceiveMedalBean;", j.o, "Lcom/huachenjie/common/bean/CurrentActivityData;", "A", "Lcom/huachenjie/run/bean/HomeJackpotBriefBean;", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public interface ISunshineApi {
    @POST("run-front/run/getPreRunCheckIn")
    @Nullable
    Object A(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/school/filterSchoolActivityFence")
    @Nullable
    Object B(@Field("activityFenceCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/huawei/health/deduction/summary")
    @Nullable
    Object C(@Field("runPlanCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<WearableDeductionSummaryBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/pageSunRunRecord")
    @Nullable
    Object D(@Field("pageSize") int i, @Field("pageNum") int i2, @Field("semesterCode") @Nullable String str, @Field("runPlanCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<SunshineRecordRealData>> continuation);

    @POST("run-front/api/ema/answer/submit")
    @Nullable
    Object E(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/run/abnormalFinishActivityRun")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<JSONObject>> F(@Body @Nullable RequestBody body);

    @FormUrlEncoded
    @POST("run-front/run/sendBarrage")
    @Nullable
    Object G(@Field("content") @Nullable String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/school/querySchoolFences")
    @Nullable
    Object H(@Field("schoolCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<List<GeoFenceDetail>>> continuation);

    @FormUrlEncoded
    @POST("run-front/school/querySchoolFences")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<List<GeoFenceDetail>>> I(@Field("schoolCode") @Nullable String schoolCode);

    @FormUrlEncoded
    @POST("run-front/run/appealRunRecord")
    @Nullable
    Object J(@Field("runRecordCode") @Nullable String str, @Field("problemContent") @Nullable String str2, @Field("semesterCode") @Nullable String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/startSunRun_v2")
    @Nullable
    Object K(@Field("schoolCode") @Nullable String str, @Field("fenceCode") @Nullable String str2, @Field("activityCode") @Nullable String str3, @Field("lat") double d, @Field("lng") double d2, @Field(FreeRunActivity.y) long j, @Field(ReadyActivity.t) boolean z, @Field("runPlanCode") @Nullable String str4, @Field("sportType") int i, @NotNull Continuation<? super BaseEntity<StartRunEntity>> continuation);

    @POST("run-front/run/getDefaultBarrage")
    @Nullable
    Object L(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/common/runVideo")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<BaseListData<VideoInfoData>>> M(@Field("time") long t);

    @POST("run-front/run/finishFreeRun")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<JSONObject>> a(@Body @Nullable RequestBody body);

    @POST("run-front/api/jackpot/award/home")
    @Nullable
    Object b(@NotNull Continuation<? super BaseEntity<HomeJackpotBriefBean>> continuation);

    @POST("run-front/run/abnormalFinishSunRun")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<JSONObject>> c(@Body @Nullable RequestBody body);

    @FormUrlEncoded
    @POST("run-front/run/querySunRunAbstractInfoV2")
    @Nullable
    Object d(@Field("semesterCode") @Nullable String str, @Field("runPlanCode") @Nullable String str2, @Field("sportType") int i, @NotNull Continuation<? super BaseEntity<SunshineRunDetail>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/plan/selectList")
    @Nullable
    Object e(@Field("semesterCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<RunPlanListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/huawei/health/deduction/records")
    @Nullable
    Object f(@Field("pageSize") int i, @Field("pageNum") int i2, @Field("runPlanCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<WearableDeductionRecordBean>>> continuation);

    @POST("run-front/attend/semesterSelector")
    @Nullable
    Object g(@NotNull Continuation<? super BaseEntity<List<SemesterBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/stadiumDeductionList")
    @Nullable
    Object h(@Field("pageSize") int i, @Field("pageNum") int i2, @Field("runPlanCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<VenueRecordDetailBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/activity/activityDetail")
    @Nullable
    Object i(@Field("sunRunActivityCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<ActivityRunDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/plan/selectList")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<RunPlanListBean>> j(@Field("semesterCode") @Nullable String semesterCode);

    @POST("run-front/school/filterUsableFence")
    @Nullable
    Object k(@Body @Nullable RequestBody requestBody, @NotNull Continuation<? super BaseEntity<UsableGeoFence>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/checkSunRunConfig")
    @Nullable
    Object l(@Field("schoolCode") @Nullable String str, @Field("subSchoolCode") @Nullable String str2, @Field(FreeRunActivity.y) int i, @Field("activityCode") @Nullable String str3, @Field("runPlanCode") @Nullable String str4, @Field("fenceCode") @NotNull String str5, @Field("sportType") int i2, @NotNull Continuation<? super BaseEntity<CheckRunConfig>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/listUserReward")
    @Nullable
    Object m(@Field("pageSize") int i, @Field("pageNum") int i2, @Field("semesterCode") @Nullable String str, @Field("runPlanCode") @Nullable String str2, @Field("type") int i3, @NotNull Continuation<? super BaseEntity<PageEntity<RunRewardBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/resume")
    @Nullable
    Object n(@Field("sportType") int i, @Field("runRecordCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/rank/distance")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<SunshineRankingData>> o(@Field("sex") int sex, @Field("scope") int scope, @Field("rankCycle") int rankCycle, @Field("type") int type, @Field("runPlanCode") @Nullable String runPlanCode);

    @FormUrlEncoded
    @POST("run-front/run/querySchoolRunSummary")
    @Nullable
    Object p(@Field("time") long j, @NotNull Continuation<? super BaseEntity<NearRunStd>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/runRecordDetail")
    @Nullable
    Object q(@Field("runRecordCode") @Nullable String str, @Field("semesterCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<RunDetailEntity>> continuation);

    @FormUrlEncoded
    @POST("run-front/ai/aiRecordDetail")
    @Nullable
    Object r(@Field("pageSize") int i, @Field("pageNum") int i2, @Field("runPlanCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<AiRecordDetailBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/queryUnFinishRun")
    @Nullable
    Object s(@FieldMap @NotNull Map<String, String> map, @NotNull Continuation<? super BaseEntity<UnfinishedRun>> continuation);

    @POST("run-front/activity/getCurrent")
    @Nullable
    Object t(@NotNull Continuation<? super BaseEntity<CurrentActivityData>> continuation);

    @FormUrlEncoded
    @POST("run-front/activity/activityList")
    @Nullable
    Object u(@Field("currentSemester") boolean z, @NotNull Continuation<? super BaseEntity<ActivityRunListBean>> continuation);

    @POST("run-front/run/getLatestBarrage")
    @Nullable
    Object v(@NotNull Continuation<? super BaseEntity<List<DanmuBean>>> continuation);

    @POST("run-front/api/mall/basic/banner/runFinish")
    @Nullable
    Object w(@NotNull Continuation<? super BaseEntity<RunFinishBannerData>> continuation);

    @FormUrlEncoded
    @POST("run-front/rank/runProgress")
    @Nullable
    Observable<huachenjie.sdk.http.BaseEntity<SunshineRankingData>> x(@Field("sex") int sex, @Field("scope") int scope, @Field("runPlanCode") @Nullable String runPlanCode);

    @FormUrlEncoded
    @POST("run-front/outside/deduction/records")
    @Nullable
    Object y(@Field("pageSize") int i, @Field("pageNum") int i2, @Field("semesterCode") @Nullable String str, @Field("runPlanCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<OutsideDeductionRecordBean>>> continuation);

    @POST("run-front/run/sunRunMedal/waitReceiveMedal")
    @Nullable
    Object z(@NotNull Continuation<? super BaseEntity<WaitReceiveMedalBean>> continuation);
}
