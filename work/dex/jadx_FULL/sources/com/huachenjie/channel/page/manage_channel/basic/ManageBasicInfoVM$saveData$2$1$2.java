package com.huachenjie.channel.page.manage_channel.basic;

import com.huachenjie.channel.R;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.zj.adlib.fv5;
import com.zj.adlib.pf6;
import com.zj.adlib.ys8;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM$saveData$2$1$2", f = "ManageBasicInfoVM.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class ManageBasicInfoVM$saveData$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ List<pf6> $fileInfoList;
    final /* synthetic */ ChannelBasicInfo $info;
    final /* synthetic */ Ref.BooleanRef $isCoverImgUrlUpload;
    final /* synthetic */ Ref.BooleanRef $isLogoUrlUpload;
    int label;
    final /* synthetic */ ManageBasicInfoVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageBasicInfoVM$saveData$2$1$2(Ref.BooleanRef booleanRef, List<pf6> list, ChannelBasicInfo channelBasicInfo, Ref.BooleanRef booleanRef2, String str, ManageBasicInfoVM manageBasicInfoVM, Continuation<? super ManageBasicInfoVM$saveData$2$1$2> continuation) {
        super(2, continuation);
        this.$isLogoUrlUpload = booleanRef;
        this.$fileInfoList = list;
        this.$info = channelBasicInfo;
        this.$isCoverImgUrlUpload = booleanRef2;
        this.$channelNo = str;
        this.this$0 = manageBasicInfoVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageBasicInfoVM$saveData$2$1$2(this.$isLogoUrlUpload, this.$fileInfoList, this.$info, this.$isCoverImgUrlUpload, this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x008d  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String str2;
        String str3;
        String coverHue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strE = null;
            boolean z = false;
            if (this.$isLogoUrlUpload.element) {
                List<pf6> list = this.$fileInfoList;
                Intrinsics.checkNotNullExpressionValue(list, "fileInfoList");
                pf6 pf6Var = (pf6) CollectionsKt.getOrNull(list, 0);
                if (pf6Var != null && pf6Var.f()) {
                    String strE2 = this.$fileInfoList.get(0).e();
                    this.$info.setLogo(strE2);
                    str = strE2;
                } else {
                    str = null;
                }
            } else {
                str = null;
            }
            if (this.$isCoverImgUrlUpload.element) {
                if (this.$isLogoUrlUpload.element) {
                    coverHue = null;
                } else {
                    List<pf6> list2 = this.$fileInfoList;
                    Intrinsics.checkNotNullExpressionValue(list2, "fileInfoList");
                    pf6 pf6Var2 = (pf6) CollectionsKt.getOrNull(list2, 0);
                    if (pf6Var2 != null && pf6Var2.f()) {
                        strE = this.$fileInfoList.get(0).e();
                        coverHue = this.$info.getCoverHue();
                        this.$info.setCoverUrl(strE);
                    } else {
                        coverHue = null;
                    }
                }
                if (this.$isLogoUrlUpload.element) {
                    List<pf6> list3 = this.$fileInfoList;
                    Intrinsics.checkNotNullExpressionValue(list3, "fileInfoList");
                    pf6 pf6Var3 = (pf6) CollectionsKt.getOrNull(list3, 1);
                    if (pf6Var3 != null && pf6Var3.f()) {
                        z = true;
                    }
                    if (z) {
                        strE = this.$fileInfoList.get(1).e();
                        coverHue = this.$info.getCoverHue();
                        this.$info.setCoverUrl(strE);
                    }
                }
                str3 = coverHue;
                str2 = strE;
            } else {
                str2 = null;
                str3 = null;
            }
            RequestModel requestModel = RequestModel.f33012a;
            String str4 = this.$channelNo;
            String value = this.this$0.j().getValue();
            String channelDescription = this.$info.getChannelDescription();
            this.label = 1;
            if (requestModel.F0(str4, str, str2, str3, value, channelDescription, this) == coroutine_suspended) {
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
