package com.huachenjie.mall.page.course_detail;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.EpisodeItemBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.course_detail.CourseDetailVM$queryVideoUrl$1", f = "CourseDetailVM.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class CourseDetailVM$queryVideoUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EpisodeItemBean $episodeItem;
    final /* synthetic */ String $orderItemNo;
    int label;
    final /* synthetic */ CourseDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseDetailVM$queryVideoUrl$1(EpisodeItemBean episodeItemBean, String str, CourseDetailVM courseDetailVM, Continuation<? super CourseDetailVM$queryVideoUrl$1> continuation) {
        super(2, continuation);
        this.$episodeItem = episodeItemBean;
        this.$orderItemNo = str;
        this.this$0 = courseDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CourseDetailVM$queryVideoUrl$1(this.$episodeItem, this.$orderItemNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String episodeItemNo = this.$episodeItem.getEpisodeItemNo();
            String str = this.$orderItemNo;
            this.label = 1;
            obj = mallModel.f0(episodeItemNo, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            CourseDetailVM courseDetailVM = this.this$0;
            EpisodeItemBean episodeItemBean = this.$episodeItem;
            courseDetailVM.t(courseDetailVM.k().getValue());
            EpisodeItemBean episodeItemBeanN = courseDetailVM.getLastPlayItem();
            if (episodeItemBeanN != null) {
                episodeItemBeanN.setPlaying(false);
            }
            episodeItemBean.setVideoUrl(jSONObject.getString(VideoPlayerActivity.t));
            episodeItemBean.setPlaying(true);
            if (episodeItemBean.getSeeDuration() == episodeItemBean.getVideoDuration()) {
                episodeItemBean.updateSeeDuration(0L);
            }
            courseDetailVM.k().setValue(episodeItemBean);
            courseDetailVM.o().setValue(Boxing.boxInt(2));
        }
        return Unit.INSTANCE;
    }
}
