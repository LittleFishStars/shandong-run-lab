package com.huachenjie.works.page.share.choose_team;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.ChatGroupBean;
import com.huachenjie.works.bean.ChatTeamBean;
import com.huachenjie.works.bean.ChatTeamHeaderBean;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.huachenjie.works.page.share.choose_team.ChooseTeamVM$queryFriendList$2", f = "ChooseTeamVM.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nChooseTeamVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChooseTeamVM.kt\ncom/huachenjie/works/page/share/choose_team/ChooseTeamVM$queryFriendList$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1855#2,2:64\n*S KotlinDebug\n*F\n+ 1 ChooseTeamVM.kt\ncom/huachenjie/works/page/share/choose_team/ChooseTeamVM$queryFriendList$2\n*L\n51#1:64,2\n*E\n"})
public final class ChooseTeamVM$queryFriendList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ ChooseTeamVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseTeamVM$queryFriendList$2(String str, ChooseTeamVM chooseTeamVM, Continuation<? super ChooseTeamVM$queryFriendList$2> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = chooseTeamVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseTeamVM$queryFriendList$2(this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChooseTeamAdapter value;
        ChooseTeamAdapter value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            String str = this.$channelNo;
            this.label = 1;
            obj = requestModel.G0(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null || pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
            ChooseTeamAdapter value3 = this.this$0.j().getValue();
            if (value3 != null) {
                value3.i();
            }
        } else {
            MutableLiveData<ChooseTeamAdapter> mutableLiveDataJ = this.this$0.j();
            if (mutableLiveDataJ != null && (value2 = mutableLiveDataJ.getValue()) != null) {
                value2.h();
            }
            ArrayList arrayList = new ArrayList();
            List<ChatGroupBean> list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "data.list");
            for (ChatGroupBean chatGroupBean : list) {
                List<ChatTeamBean> teamList = chatGroupBean.getTeamList();
                boolean z = false;
                if (teamList != null && (!teamList.isEmpty())) {
                    z = true;
                }
                if (z) {
                    arrayList.add(new ChatTeamHeaderBean(chatGroupBean.getChannelName()));
                    arrayList.addAll(chatGroupBean.getTeamList());
                }
            }
            MutableLiveData<ChooseTeamAdapter> mutableLiveDataJ2 = this.this$0.j();
            if (mutableLiveDataJ2 != null && (value = mutableLiveDataJ2.getValue()) != null) {
                value.setList(arrayList);
            }
        }
        return Unit.INSTANCE;
    }
}
