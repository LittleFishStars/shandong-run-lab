package com.huachenjie.run.page.run_index;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.bean.SunshineRecordRealData;
import com.huachenjie.run.model.RunRequestModel;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import java.util.Collection;
import java.util.List;
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
@DebugMetadata(c = "com.huachenjie.run.page.run_index.RunIndexVM$queryRecordList$2", f = "RunIndexVM.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME}, m = "invokeSuspend", n = {"adapter"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nRunIndexVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunIndexVM.kt\ncom/huachenjie/run/page/run_index/RunIndexVM$queryRecordList$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
public final class RunIndexVM$queryRecordList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstPage;
    final /* synthetic */ String $runPlanCode;
    final /* synthetic */ String $semesterCode;
    Object L$0;
    int label;
    final /* synthetic */ RunIndexVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunIndexVM$queryRecordList$2(RunIndexVM runIndexVM, String str, String str2, boolean z, Continuation<? super RunIndexVM$queryRecordList$2> continuation) {
        super(2, continuation);
        this.this$0 = runIndexVM;
        this.$semesterCode = str;
        this.$runPlanCode = str2;
        this.$isFirstPage = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RunIndexVM$queryRecordList$2(this.this$0, this.$semesterCode, this.$runPlanCode, this.$isFirstPage, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RunIndexRecordAdapter runIndexRecordAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RunIndexRecordAdapter value = this.this$0.U().getValue();
            if (value == null) {
                return Unit.INSTANCE;
            }
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            int i2 = this.this$0.recordPageIndex;
            String str = this.$semesterCode;
            String str2 = this.$runPlanCode;
            this.L$0 = value;
            this.label = 1;
            Object objY = runRequestModel.y(i2, str, str2, this);
            if (objY == coroutine_suspended) {
                return coroutine_suspended;
            }
            runIndexRecordAdapter = value;
            obj = objY;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            runIndexRecordAdapter = (RunIndexRecordAdapter) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        SunshineRecordRealData sunshineRecordRealData = (SunshineRecordRealData) obj;
        if (sunshineRecordRealData == null) {
            return Unit.INSTANCE;
        }
        List<SportRecord> listEmptyList = sunshineRecordRealData.list;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (this.$isFirstPage) {
            List<SportRecord> list = listEmptyList;
            if (list.isEmpty()) {
                list = null;
            }
            runIndexRecordAdapter.setList(list);
            if (listEmptyList.isEmpty()) {
                runIndexRecordAdapter.i();
            } else {
                runIndexRecordAdapter.h();
            }
        } else {
            runIndexRecordAdapter.h();
            List<SportRecord> list2 = listEmptyList;
            if (!list2.isEmpty()) {
                runIndexRecordAdapter.addData((Collection) list2);
            }
        }
        if (sunshineRecordRealData.hasNext) {
            runIndexRecordAdapter.getLoadMoreModule().loadMoreComplete();
        } else {
            BaseLoadMoreModule.loadMoreEnd$default(runIndexRecordAdapter.getLoadMoreModule(), false, 1, null);
        }
        return Unit.INSTANCE;
    }
}
