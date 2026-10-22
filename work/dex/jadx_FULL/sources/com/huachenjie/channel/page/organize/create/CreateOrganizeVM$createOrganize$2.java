package com.huachenjie.channel.page.organize.create;

import android.text.TextUtils;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.channel.api.RequestModel;
import com.zj.adlib.fv5;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.organize.create.CreateOrganizeVM$createOrganize$2", f = "CreateOrganizeVM.kt", i = {}, l = {62, 69}, m = "invokeSuspend", n = {}, s = {})
public final class CreateOrganizeVM$createOrganize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $clubCode;
    int label;
    final /* synthetic */ CreateOrganizeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateOrganizeVM$createOrganize$2(String str, CreateOrganizeVM createOrganizeVM, String str2, Continuation<? super CreateOrganizeVM$createOrganize$2> continuation) {
        super(2, continuation);
        this.$clubCode = str;
        this.this$0 = createOrganizeVM;
        this.$channelNo = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreateOrganizeVM$createOrganize$2(this.$clubCode, this.this$0, this.$channelNo, continuation);
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
            if (TextUtils.isEmpty(this.$clubCode)) {
                RequestModel requestModel = RequestModel.f33012a;
                String value = this.this$0.r().getValue();
                String str = value == null ? "" : value;
                List<ImagePickBean> value2 = this.this$0.o().getValue();
                Intrinsics.checkNotNull(value2);
                String url = value2.get(0).getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "coverList.value!!.get(0).url");
                String value3 = this.this$0.m().getValue();
                String str2 = value3 == null ? "" : value3;
                String str3 = this.$channelNo;
                this.label = 1;
                if (requestModel.m(str, url, str2, str3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                RequestModel requestModel2 = RequestModel.f33012a;
                String value4 = this.this$0.r().getValue();
                if (value4 == null) {
                    value4 = "";
                }
                List<ImagePickBean> value5 = this.this$0.o().getValue();
                Intrinsics.checkNotNull(value5);
                String url2 = value5.get(0).getUrl();
                Intrinsics.checkNotNullExpressionValue(url2, "coverList.value!!.get(0).url");
                String value6 = this.this$0.m().getValue();
                if (value6 == null) {
                    value6 = "";
                }
                String str4 = this.$channelNo;
                String str5 = this.$clubCode;
                Intrinsics.checkNotNull(str5);
                this.label = 2;
                if (requestModel2.I0(value4, url2, value6, str4, str5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.b("创建成功~");
        this.this$0.p().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
