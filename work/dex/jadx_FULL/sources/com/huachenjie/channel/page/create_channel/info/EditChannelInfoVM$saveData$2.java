package com.huachenjie.channel.page.create_channel.info;

import android.content.Context;
import com.huachenjie.channel.R;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.pf6;
import com.zj.adlib.u66;
import com.zj.adlib.ys8;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.create_channel.info.EditChannelInfoVM$saveData$2", f = "EditChannelInfoVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EditChannelInfoVM$saveData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelClassificationNo;
    final /* synthetic */ String $channelName;
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $childChannelClassificationNo;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $coverImageUrl;
    final /* synthetic */ String $logo;
    int label;
    final /* synthetic */ EditChannelInfoVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditChannelInfoVM$saveData$2(EditChannelInfoVM editChannelInfoVM, Context context, String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super EditChannelInfoVM$saveData$2> continuation) {
        super(2, continuation);
        this.this$0 = editChannelInfoVM;
        this.$context = context;
        this.$logo = str;
        this.$coverImageUrl = str2;
        this.$channelClassificationNo = str3;
        this.$childChannelClassificationNo = str4;
        this.$channelName = str5;
        this.$channelNo = str6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(final EditChannelInfoVM editChannelInfoVM, String str, String str2, String str3, String str4, List list) {
        if (list.size() == 2 && ((pf6) list.get(0)).f() && ((pf6) list.get(1)).f()) {
            BaseViewModelExtKt.b(editChannelInfoVM, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.create_channel.info.EditChannelInfoVM$saveData$2$1$1
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    editChannelInfoVM.c();
                    return Boolean.FALSE;
                }
            }, null, new EditChannelInfoVM$saveData$2$1$2(list, str, str2, str3, str4, editChannelInfoVM, null), 11, null);
        } else {
            fv5.b(ys8.e(R.string.channel_edit_info_upload_error));
            editChannelInfoVM.c();
        }
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EditChannelInfoVM$saveData$2(this.this$0, this.$context, this.$logo, this.$coverImageUrl, this.$channelClassificationNo, this.$childChannelClassificationNo, this.$channelName, this.$channelNo, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.g();
        Context context = this.$context;
        UploadFileType uploadFileType = UploadFileType.UPLOAD_CHANNEL_CHANNEL;
        List listListOf = CollectionsKt.listOf(new String[]{this.$logo, this.$coverImageUrl});
        final EditChannelInfoVM editChannelInfoVM = this.this$0;
        final String str = this.$channelClassificationNo;
        final String str2 = this.$childChannelClassificationNo;
        final String str3 = this.$channelName;
        final String str4 = this.$channelNo;
        u66.e(context, uploadFileType, listListOf, new MultipleUploadCallback() { // from class: com.huachenjie.channel.page.create_channel.info.a
            @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
            public final void c(List list) {
                EditChannelInfoVM$saveData$2.invokeSuspend$lambda$0(editChannelInfoVM, str, str2, str3, str4, list);
            }
        });
        return Unit.INSTANCE;
    }
}
