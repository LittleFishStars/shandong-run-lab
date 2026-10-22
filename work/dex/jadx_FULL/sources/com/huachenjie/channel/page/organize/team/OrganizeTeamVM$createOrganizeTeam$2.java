package com.huachenjie.channel.page.organize.team;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import java.util.List;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.organize.team.OrganizeTeamVM$createOrganizeTeam$2", f = "OrganizeTeamVM.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class OrganizeTeamVM$createOrganizeTeam$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $clubCode;
    final /* synthetic */ String $teamTitle;
    int label;
    final /* synthetic */ OrganizeTeamVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeTeamVM$createOrganizeTeam$2(String str, String str2, String str3, OrganizeTeamVM organizeTeamVM, Continuation<? super OrganizeTeamVM$createOrganizeTeam$2> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.$clubCode = str2;
        this.$teamTitle = str3;
        this.this$0 = organizeTeamVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeTeamVM$createOrganizeTeam$2(this.$channelNo, this.$clubCode, this.$teamTitle, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        OrganizeTeamAdapter value;
        List<OrganizeTeamBean> data;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            String str2 = this.$clubCode;
            String str3 = this.$teamTitle;
            this.label = 1;
            obj = requestModel.n(str, str2, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OrganizeTeamBean organizeTeamBean = (OrganizeTeamBean) obj;
        if (organizeTeamBean == null) {
            return Unit.INSTANCE;
        }
        OrganizeTeamAdapter value2 = this.this$0.k().getValue();
        int size = (value2 == null || (data = value2.getData()) == null) ? 0 : data.size();
        organizeTeamBean.setTeamTitle(this.$teamTitle);
        this.this$0.m().setValue(organizeTeamBean);
        if (size == 0 && (value = this.this$0.k().getValue()) != null) {
            value.f();
        }
        OrganizeTeamAdapter value3 = this.this$0.k().getValue();
        if (value3 != null) {
            value3.addData(0, organizeTeamBean);
        }
        return Unit.INSTANCE;
    }
}
