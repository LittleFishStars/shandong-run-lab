package com.huachenjie.channel.page.manage_channel.basic;

import android.content.Context;
import android.text.TextUtils;
import com.huachenjie.channel.R;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.u66;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM$saveData$2", f = "ManageBasicInfoVM.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class ManageBasicInfoVM$saveData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ManageBasicInfoVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageBasicInfoVM$saveData$2(ManageBasicInfoVM manageBasicInfoVM, String str, Context context, Continuation<? super ManageBasicInfoVM$saveData$2> continuation) {
        super(2, continuation);
        this.this$0 = manageBasicInfoVM;
        this.$channelNo = str;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(final ManageBasicInfoVM manageBasicInfoVM, Ref.BooleanRef booleanRef, ChannelBasicInfo channelBasicInfo, Ref.BooleanRef booleanRef2, String str, List list) {
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            BaseViewModelExtKt.b(manageBasicInfoVM, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM$saveData$2$1$1
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    manageBasicInfoVM.c();
                    return Boolean.FALSE;
                }
            }, null, new ManageBasicInfoVM$saveData$2$1$2(booleanRef, list, channelBasicInfo, booleanRef2, str, manageBasicInfoVM, null), 11, null);
        } else {
            fv5.b(ys8.e(R.string.channel_edit_info_upload_error));
            manageBasicInfoVM.c();
        }
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageBasicInfoVM$saveData$2(this.this$0, this.$channelNo, this.$context, continuation);
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
            final ChannelBasicInfo value = this.this$0.i().getValue();
            if (value == null) {
                return Unit.INSTANCE;
            }
            this.this$0.g();
            ArrayList arrayList = new ArrayList();
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (!TextUtils.isEmpty(value.getLogo()) && !StringsKt.startsWith$default(value.getLogo(), "http", false, 2, (Object) null)) {
                booleanRef.element = true;
                arrayList.add(value.getLogo());
            }
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            if (!TextUtils.isEmpty(value.getCoverUrl()) && !StringsKt.startsWith$default(value.getCoverUrl(), "http", false, 2, (Object) null)) {
                booleanRef2.element = true;
                arrayList.add(value.getCoverUrl());
            }
            if (!arrayList.isEmpty()) {
                Context context = this.$context;
                UploadFileType uploadFileType = UploadFileType.UPLOAD_CHANNEL_CHANNEL;
                final ManageBasicInfoVM manageBasicInfoVM = this.this$0;
                final String str = this.$channelNo;
                u66.e(context, uploadFileType, arrayList, new MultipleUploadCallback() { // from class: com.huachenjie.channel.page.manage_channel.basic.a
                    @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
                    public final void c(List list) {
                        ManageBasicInfoVM$saveData$2.invokeSuspend$lambda$0(manageBasicInfoVM, booleanRef, value, booleanRef2, str, list);
                    }
                });
                return Unit.INSTANCE;
            }
            RequestModel requestModel = RequestModel.f33012a;
            String str2 = this.$channelNo;
            String logo = value.getLogo();
            String coverUrl = value.getCoverUrl();
            String coverHue = value.getCoverHue();
            String value2 = this.this$0.j().getValue();
            String channelDescription = value.getChannelDescription();
            this.label = 1;
            if (requestModel.F0(str2, logo, coverUrl, coverHue, value2, channelDescription, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.b(ys8.e(R.string.channel_manage_channel_update_success));
        this.this$0.c();
        this.this$0.k().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
