package com.huachenjie.college.page.sport;

import com.huachenjie.college.bean.CampusApplicationBean;
import com.huachenjie.college.bean.FitnessPermissionBean;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.sport.CollegeVM$getCampusApplication$2", f = "CollegeVM.kt", i = {0, 1}, l = {87, 88}, m = "invokeSuspend", n = {"permissionDeferred", GoodsSpecificationPreviewActivity.z}, s = {"L$0", "L$0"})
public final class CollegeVM$getCampusApplication$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CollegeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollegeVM$getCampusApplication$2(CollegeVM collegeVM, Continuation<? super CollegeVM$getCampusApplication$2> continuation) {
        super(2, continuation);
        this.this$0 = collegeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CollegeVM$getCampusApplication$2 collegeVM$getCampusApplication$2 = new CollegeVM$getCampusApplication$2(this.this$0, continuation);
        collegeVM$getCampusApplication$2.L$0 = obj;
        return collegeVM$getCampusApplication$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0084  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Deferred deferredB;
        List arrayList;
        List list;
        List list2;
        FitnessPermissionBean fitnessPermissionBean;
        boolean z;
        CollegeAdapter value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                deferredB = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            fitnessPermissionBean = (FitnessPermissionBean) obj;
            z = false;
            if (fitnessPermissionBean != null && !fitnessPermissionBean.getFitnessScoreVisible()) {
                z = true;
            }
            if (!(!z)) {
                CollectionsKt.removeAll(list, new Function1<CampusApplicationBean, Boolean>() { // from class: com.huachenjie.college.page.sport.CollegeVM$getCampusApplication$2.1
                    @NotNull
                    public final Boolean invoke(CampusApplicationBean campusApplicationBean) {
                        return Boolean.valueOf(campusApplicationBean.getSubType() == 5);
                    }
                });
            }
            list.add(new CampusApplicationBean("扫一扫", null, 1, -1, null, 18, null));
            value = this.this$0.i().getValue();
            if (value != null) {
                value.setList(list);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Deferred deferredB2 = v41.b(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CollegeVM$getCampusApplication$2$appDeferred$1(null), 3, (Object) null);
        deferredB = v41.b(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CollegeVM$getCampusApplication$2$permissionDeferred$1(null), 3, (Object) null);
        this.L$0 = deferredB;
        this.label = 1;
        obj = deferredB2.H(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null || (list2 = pageEntity.getList()) == null || (arrayList = CollectionsKt.toMutableList(list2)) == null) {
            arrayList = new ArrayList();
        }
        this.L$0 = arrayList;
        this.label = 2;
        Object objH = deferredB.H(this);
        if (objH == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = arrayList;
        obj = objH;
        fitnessPermissionBean = (FitnessPermissionBean) obj;
        z = false;
        if (fitnessPermissionBean != null) {
            z = true;
        }
        if (!(!z)) {
            CollectionsKt.removeAll(list, new Function1<CampusApplicationBean, Boolean>() { // from class: com.huachenjie.college.page.sport.CollegeVM$getCampusApplication$2.1
                @NotNull
                public final Boolean invoke(CampusApplicationBean campusApplicationBean) {
                    return Boolean.valueOf(campusApplicationBean.getSubType() == 5);
                }
            });
        }
        list.add(new CampusApplicationBean("扫一扫", null, 1, -1, null, 18, null));
        value = this.this$0.i().getValue();
        if (value != null) {
            value.setList(list);
        }
        return Unit.INSTANCE;
    }
}
