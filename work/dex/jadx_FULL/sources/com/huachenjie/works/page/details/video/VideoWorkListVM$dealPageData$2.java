package com.huachenjie.works.page.details.video;

import com.huachenjie.works.bean.WorkDetailBean;
import com.igexin.push.g.o;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.details.video.VideoWorkListVM$dealPageData$2", f = "VideoWorkListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nVideoWorkListVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoWorkListVM.kt\ncom/huachenjie/works/page/details/video/VideoWorkListVM$dealPageData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n1855#2,2:172\n*S KotlinDebug\n*F\n+ 1 VideoWorkListVM.kt\ncom/huachenjie/works/page/details/video/VideoWorkListVM$dealPageData$2\n*L\n105#1:172,2\n*E\n"})
public final class VideoWorkListVM$dealPageData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageEntity<WorkDetailBean> $data;
    final /* synthetic */ List<String> $urlList;
    int label;
    final /* synthetic */ VideoWorkListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoWorkListVM$dealPageData$2(PageEntity<WorkDetailBean> pageEntity, VideoWorkListVM videoWorkListVM, List<String> list, Continuation<? super VideoWorkListVM$dealPageData$2> continuation) {
        super(2, continuation);
        this.$data = pageEntity;
        this.this$0 = videoWorkListVM;
        this.$urlList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VideoWorkListVM$dealPageData$2(this.$data, this.this$0, this.$urlList, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int iIntValue;
        boolean zBooleanValue;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<WorkDetailBean> list = this.$data.getList();
        if (list == null) {
            return null;
        }
        VideoWorkListVM videoWorkListVM = this.this$0;
        List<String> list2 = this.$urlList;
        for (WorkDetailBean workDetailBean : list) {
            Integer value = videoWorkListVM.e().b().getValue();
            if (value == null) {
                iIntValue = 22;
            } else {
                Intrinsics.checkNotNullExpressionValue(value, "uiLiveData.statusBarHeight.value ?: 22");
                iIntValue = value.intValue();
            }
            workDetailBean.setStatusBarHeight(iIntValue);
            if (workDetailBean.getAttachmentType() == 2) {
                workDetailBean.replaceVideoPath();
                list2.add(workDetailBean.formatVideoUrl());
                Intrinsics.checkNotNullExpressionValue(workDetailBean, o.f);
                videoWorkListVM.l(workDetailBean);
            }
            Boolean value2 = videoWorkListVM.o().getValue();
            if (value2 == null) {
                zBooleanValue = false;
            } else {
                Intrinsics.checkNotNullExpressionValue(value2, "fromMine.value ?: false");
                zBooleanValue = value2.booleanValue();
            }
            workDetailBean.setFromMine(zBooleanValue);
        }
        return Unit.INSTANCE;
    }
}
