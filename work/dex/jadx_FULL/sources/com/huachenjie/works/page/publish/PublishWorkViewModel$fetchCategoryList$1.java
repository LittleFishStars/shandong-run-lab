package com.huachenjie.works.page.publish;

import androidx.p002lifecycle.MutableLiveData;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.RecommendWorksBean;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.publish.PublishWorkViewModel$fetchCategoryList$1", f = "PublishWorkViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPublishWorkViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorkViewModel.kt\ncom/huachenjie/works/page/publish/PublishWorkViewModel$fetchCategoryList$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,279:1\n1#2:280\n*E\n"})
public final class PublishWorkViewModel$fetchCategoryList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<RecommendWorksBean> $categoryList;
    final /* synthetic */ String $categoryNo;
    final /* synthetic */ String $tagNo;
    int label;
    final /* synthetic */ PublishWorkViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishWorkViewModel$fetchCategoryList$1(ArrayList<RecommendWorksBean> arrayList, PublishWorkViewModel publishWorkViewModel, String str, String str2, Continuation<? super PublishWorkViewModel$fetchCategoryList$1> continuation) {
        super(2, continuation);
        this.$categoryList = arrayList;
        this.this$0 = publishWorkViewModel;
        this.$categoryNo = str;
        this.$tagNo = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishWorkViewModel$fetchCategoryList$1(this.$categoryList, this.this$0, this.$categoryNo, this.$tagNo, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:35:0x006e->B:45:?, LOOP_END, SYNTHETIC] */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<RecommendWorksBean> list;
        String str;
        String str2;
        RecommendWorksBean recommendWorksBean;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Object obj2 = null;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<RecommendWorksBean> arrayList = this.$categoryList;
            if (arrayList == null || arrayList.isEmpty()) {
                RequestModel requestModel = RequestModel.f36762a;
                this.label = 1;
                obj = requestModel.s0(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                list = this.$categoryList;
            }
            MutableLiveData<RecommendWorksBean> mutableLiveDataY = this.this$0.y();
            str = this.$categoryNo;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                recommendWorksBean = (RecommendWorksBean) CollectionsKt.getOrNull(list, 0);
            } else {
                str2 = this.$categoryNo;
                for (Object obj3 : list) {
                    if (Intrinsics.areEqual(((RecommendWorksBean) obj3).getCategoryNo(), str2)) {
                        obj2 = obj3;
                        break;
                    }
                }
                recommendWorksBean = (RecommendWorksBean) obj2;
            }
            mutableLiveDataY.setValue(recommendWorksBean);
            this.this$0.u().setValue(list);
            this.this$0.q(this.$tagNo);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PageEntity pageEntity = (PageEntity) obj;
        list = pageEntity != null ? pageEntity.getList() : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        MutableLiveData<RecommendWorksBean> mutableLiveDataY2 = this.this$0.y();
        str = this.$categoryNo;
        if (str != null) {
            z = false;
        }
        if (z) {
            recommendWorksBean = (RecommendWorksBean) CollectionsKt.getOrNull(list, 0);
        } else {
            str2 = this.$categoryNo;
            while (r1.hasNext()) {
                if (Intrinsics.areEqual(((RecommendWorksBean) obj3).getCategoryNo(), str2)) {
                    obj2 = obj3;
                    break;
                }
            }
            recommendWorksBean = (RecommendWorksBean) obj2;
        }
        mutableLiveDataY2.setValue(recommendWorksBean);
        this.this$0.u().setValue(list);
        this.this$0.q(this.$tagNo);
        return Unit.INSTANCE;
    }
}
