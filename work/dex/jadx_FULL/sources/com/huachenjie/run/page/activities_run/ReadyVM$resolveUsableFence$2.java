package com.huachenjie.run.page.activities_run;

import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.UsableGeoFence;
import com.huachenjie.run.model.RunRequestModel;
import com.zj.adlib.i4a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.activities_run.ReadyVM$resolveUsableFence$2", f = "ReadyVM.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nReadyVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadyVM.kt\ncom/huachenjie/run/page/activities_run/ReadyVM$resolveUsableFence$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,255:1\n1#2:256\n*E\n"})
public final class ReadyVM$resolveUsableFence$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GeoFenceDetail> $fenceList;
    final /* synthetic */ Map<String, GeoFenceDetail> $located;
    int label;
    final /* synthetic */ ReadyVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReadyVM$resolveUsableFence$2(Map<String, ? extends GeoFenceDetail> map, ReadyVM readyVM, List<? extends GeoFenceDetail> list, Continuation<? super ReadyVM$resolveUsableFence$2> continuation) {
        super(2, continuation);
        this.$located = map;
        this.this$0 = readyVM;
        this.$fenceList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReadyVM$resolveUsableFence$2(this.$located, this.this$0, this.$fenceList, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String fenceCode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            Map<String, GeoFenceDetail> map = this.$located;
            this.label = 1;
            obj = runRequestModel.g(map, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        UsableGeoFence usableGeoFence = (UsableGeoFence) obj;
        GeoFenceDetail geoFenceDetail = null;
        if (usableGeoFence != null && (fenceCode = usableGeoFence.getFenceCode()) != null) {
            if (!(fenceCode.length() > 0)) {
                fenceCode = null;
            }
            if (fenceCode != null) {
                geoFenceDetail = this.$located.get(fenceCode);
            }
        }
        if (geoFenceDetail == null) {
            i4a.c("没有匹配到对应的围栏！");
        }
        ReadyVM readyVM = this.this$0;
        if (geoFenceDetail == null) {
            geoFenceDetail = (GeoFenceDetail) CollectionsKt.firstOrNull(this.$fenceList);
        }
        readyVM.o(geoFenceDetail);
        return Unit.INSTANCE;
    }
}
