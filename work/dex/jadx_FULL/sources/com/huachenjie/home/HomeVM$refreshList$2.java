package com.huachenjie.home;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.ActivityInfo;
import com.huachenjie.works.bean.OfficialActivityBean;
import com.huachenjie.works.external.bean.WorkActivityItemBean;
import com.huachenjie.works.external.bean.WorkCoverBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.HomeVM$refreshList$2", f = "HomeVM.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
public final class HomeVM$refreshList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeVM$refreshList$2(HomeVM homeVM, Continuation<? super HomeVM$refreshList$2> continuation) {
        super(2, continuation);
        this.this$0 = homeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeVM$refreshList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String title;
        ActivityInfo activityInfo;
        String logoUrl;
        ActivityInfo activityInfo2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            this.label = 1;
            obj = requestModel.w(1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OfficialActivityBean officialActivityBean = (OfficialActivityBean) obj;
        if ((officialActivityBean != null ? officialActivityBean.getActivityInfo() : null) != null) {
            WorkActivityItemBean workActivityItemBean = new WorkActivityItemBean();
            if (officialActivityBean == null || (activityInfo2 = officialActivityBean.getActivityInfo()) == null || (title = activityInfo2.getTitle()) == null) {
                title = "";
            }
            workActivityItemBean.setTitle(title);
            workActivityItemBean.setCoverImg(new WorkCoverBean((officialActivityBean == null || (activityInfo = officialActivityBean.getActivityInfo()) == null || (logoUrl = activityInfo.getLogoUrl()) == null) ? "" : logoUrl, 0, 0, 0, 14, null));
            this.this$0.T(workActivityItemBean);
        } else {
            HomeVM.U(this.this$0, null, 1, null);
        }
        return Unit.INSTANCE;
    }
}
