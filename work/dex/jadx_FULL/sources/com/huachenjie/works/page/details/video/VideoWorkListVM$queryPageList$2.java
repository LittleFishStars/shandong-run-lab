package com.huachenjie.works.page.details.video;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.WorkDetailBean;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.details.video.VideoWorkListVM$queryPageList$2", f = "VideoWorkListVM.kt", i = {}, l = {91, 97}, m = "invokeSuspend", n = {}, s = {})
public final class VideoWorkListVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoWorkListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoWorkListVM$queryPageList$2(VideoWorkListVM videoWorkListVM, Continuation<? super VideoWorkListVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = videoWorkListVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VideoWorkListVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RequestModel requestModel = RequestModel.f36762a;
        int iT = this.this$0.getPageNum();
        String strU = this.this$0.getRefreshTime();
        MutableLiveData<String> mutableLiveDataZ = this.this$0.z();
        if (mutableLiveDataZ == null || (value = mutableLiveDataZ.getValue()) == null) {
            value = "";
        }
        this.label = 1;
        obj = requestModel.I0(iT, strU, value, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        PageEntity<WorkDetailBean> pageEntity = (PageEntity) obj;
        if (pageEntity == null) {
            pageEntity = new PageEntity<>();
            pageEntity.setList(CollectionsKt.emptyList());
            pageEntity.setHasNext(false);
        }
        this.this$0.C(false);
        VideoWorkListVM videoWorkListVM = this.this$0;
        this.label = 2;
        if (videoWorkListVM.j(pageEntity, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
