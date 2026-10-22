package com.huachenjie.login.page.info.university;

import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.BindVisitorBean;
import com.huachenjie.login.bean.GradeBean;
import com.huachenjie.login.bean.VisitorHeadBean;
import com.huachenjie.login.bean.VisitorRequestBean;
import com.zj.adlib.pg3;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.page.info.university.ChooseUniversityVM$generateAlumnus$1", f = "ChooseUniversityVM.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseUniversityVM$generateAlumnus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChooseUniversityVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseUniversityVM$generateAlumnus$1(ChooseUniversityVM chooseUniversityVM, Continuation<? super ChooseUniversityVM$generateAlumnus$1> continuation) {
        super(2, continuation);
        this.this$0 = chooseUniversityVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseUniversityVM$generateAlumnus$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String key;
        String idNumber;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = "";
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f34611a;
            SchoolInfo value = this.this$0.n().getValue();
            String schoolCode = value != null ? value.getSchoolCode() : null;
            String str2 = schoolCode == null ? "" : schoolCode;
            pg3 pg3Var = pg3.f18845a;
            String strValueOf = String.valueOf(pg3Var.f());
            String strB = pg3Var.b();
            VisitorHeadBean visitorHeadBean = new VisitorHeadBean(pg3Var.d(), pg3.portraitUrl);
            GradeBean value2 = this.this$0.k().getValue();
            VisitorRequestBean visitorRequestBean = new VisitorRequestBean(str2, strValueOf, strB, visitorHeadBean, (value2 == null || (key = value2.getKey()) == null) ? "" : key, pg3.com.huachenjie.common.constants.UserConstants.USER_PARAMS.b java.lang.String);
            this.label = 1;
            obj = requestModel.d(visitorRequestBean, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BindVisitorBean bindVisitorBean = (BindVisitorBean) obj;
        if (bindVisitorBean != null && (idNumber = bindVisitorBean.getIdNumber()) != null) {
            str = idNumber;
        }
        pg3.alumnusId = str;
        this.this$0.j().setValue(pg3.alumnusId);
        return Unit.INSTANCE;
    }
}
