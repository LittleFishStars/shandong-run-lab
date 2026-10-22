package com.huachenjie.channel.page.create_channel.info;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.channel.api.RequestModel;
import com.zj.adlib.pf6;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.create_channel.info.EditChannelInfoVM$saveData$2$1$2", f = "EditChannelInfoVM.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"fileUrl"}, s = {"L$0"})
public final class EditChannelInfoVM$saveData$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelClassificationNo;
    final /* synthetic */ String $channelName;
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $childChannelClassificationNo;
    final /* synthetic */ List<pf6> $fileInfoList;
    Object L$0;
    int label;
    final /* synthetic */ EditChannelInfoVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditChannelInfoVM$saveData$2$1$2(List<pf6> list, String str, String str2, String str3, String str4, EditChannelInfoVM editChannelInfoVM, Continuation<? super EditChannelInfoVM$saveData$2$1$2> continuation) {
        super(2, continuation);
        this.$fileInfoList = list;
        this.$channelClassificationNo = str;
        this.$childChannelClassificationNo = str2;
        this.$channelName = str3;
        this.$channelNo = str4;
        this.this$0 = editChannelInfoVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EditChannelInfoVM$saveData$2$1$2(this.$fileInfoList, this.$channelClassificationNo, this.$childChannelClassificationNo, this.$channelName, this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strE = this.$fileInfoList.get(0).e();
            RequestModel requestModel = RequestModel.f33012a;
            String str2 = this.$channelClassificationNo;
            String str3 = this.$childChannelClassificationNo;
            Intrinsics.checkNotNullExpressionValue(strE, "fileUrl");
            String str4 = this.$channelName;
            Intrinsics.checkNotNull(str4);
            String str5 = this.$channelNo;
            String strE2 = this.$fileInfoList.get(1).e();
            Intrinsics.checkNotNullExpressionValue(strE2, "fileInfoList[1].fileUrl");
            String coverHue = this.this$0.getCoverHue();
            this.L$0 = strE;
            this.label = 1;
            Object objJ = requestModel.j(str2, str3, strE, str4, str5, strE2, coverHue, this);
            if (objJ == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = strE;
            obj = objJ;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject = (JSONObject) obj;
        MutableLiveData<Pair<String, String>> mutableLiveDataM = this.this$0.m();
        String string = jSONObject != null ? jSONObject.getString("channelNo") : null;
        if (string == null) {
            string = "";
        }
        mutableLiveDataM.setValue(new Pair<>(string, str));
        this.this$0.c();
        return Unit.INSTANCE;
    }
}
