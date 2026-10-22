package com.huachenjie.channel.page.team_member_manage;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.im.bean.TeamMemberBean;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.team_member_manage.TeamMemberManageVM$dissolveSubjectGroup$1", f = "TeamMemberManageVM.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nTeamMemberManageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TeamMemberManageVM.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageVM$dissolveSubjectGroup$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1549#2:112\n1620#2,3:113\n*S KotlinDebug\n*F\n+ 1 TeamMemberManageVM.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageVM$dissolveSubjectGroup$1\n*L\n96#1:112\n96#1:113,3\n*E\n"})
public final class TeamMemberManageVM$dissolveSubjectGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectGroupNo;
    int label;
    final /* synthetic */ TeamMemberManageVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeamMemberManageVM$dissolveSubjectGroup$1(TeamMemberManageVM teamMemberManageVM, String str, Continuation<? super TeamMemberManageVM$dissolveSubjectGroup$1> continuation) {
        super(2, continuation);
        this.this$0 = teamMemberManageVM;
        this.$subjectGroupNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TeamMemberManageVM$dissolveSubjectGroup$1(this.this$0, this.$subjectGroupNo, continuation);
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
            List<TeamMemberBean> listQ = this.this$0.q();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listQ, 10));
            Iterator<T> it = listQ.iterator();
            while (it.hasNext()) {
                String accId = ((TeamMemberBean) it.next()).getAccId();
                if (accId == null) {
                    accId = "";
                }
                arrayList.add(accId);
            }
            List<String> mutableList = CollectionsKt.toMutableList(arrayList);
            String value = this.this$0.u().getValue();
            if (value != null) {
                Boxing.boxBoolean(mutableList.remove(value));
            }
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$subjectGroupNo;
            this.label = 1;
            if (requestModel.x(str, mutableList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.o().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
