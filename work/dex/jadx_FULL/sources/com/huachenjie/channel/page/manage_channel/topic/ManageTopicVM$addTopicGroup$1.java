package com.huachenjie.channel.page.manage_channel.topic;

import android.app.Dialog;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.topic.ManageTopicVM$addTopicGroup$1", f = "ManageTopicVM.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class ManageTopicVM$addTopicGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ String $subjectCategoryName;
    int label;
    final /* synthetic */ ManageTopicVM this$0;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"com/huachenjie/channel/page/manage_channel/topic/ManageTopicVM$addTopicGroup$1$a", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "", "a", "Ljava/lang/Void;", "d", "()Ljava/lang/Void;", "childNode", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BaseNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public final Void childNode;

        @Nullable
        /* JADX INFO: renamed from: d, reason: from getter */
        public Void getChildNode() {
            return this.childNode;
        }

        @Override // com.chad.library.adapter.base.entity.node.BaseNode
        public /* bridge */ /* synthetic */ List getChildNode() {
            return (List) getChildNode();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageTopicVM$addTopicGroup$1(String str, String str2, ManageTopicVM manageTopicVM, Dialog dialog, Continuation<? super ManageTopicVM$addTopicGroup$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.$subjectCategoryName = str2;
        this.this$0 = manageTopicVM;
        this.$dialog = dialog;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageTopicVM$addTopicGroup$1(this.$channelNo, this.$subjectCategoryName, this.this$0, this.$dialog, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            String str2 = this.$subjectCategoryName;
            this.label = 1;
            obj = requestModel.p(str, str2, this);
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
        if (jSONObject == null) {
            return Unit.INSTANCE;
        }
        String string = jSONObject.getString("subjectCategoryNo");
        ManageTopicAdapter value = this.this$0.n().getValue();
        if (value != null) {
            String str3 = this.$subjectCategoryName;
            Intrinsics.checkNotNullExpressionValue(string, "subjectCategoryNo");
            MyChannelTopicGroup myChannelTopicGroup = new MyChannelTopicGroup(string, str3, CollectionsKt.emptyList());
            List<BaseNode> childNode = myChannelTopicGroup.getChildNode();
            if (childNode != null) {
                Boxing.boxBoolean(childNode.add(new a()));
            }
            value.addData((BaseNode) myChannelTopicGroup);
        }
        this.$dialog.dismiss();
        this.this$0.o().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
