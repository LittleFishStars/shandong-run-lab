package com.huachenjie.works.page.alumni.channel;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.R;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.huachenjie.works.external.bean.ChannelBean;
import huachenjie.sdk.http.PageEntity;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.channel.AlumniChannelVM$queryAlumniChannelList$1", f = "AlumniChannelVM.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class AlumniChannelVM$queryAlumniChannelList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $refreshTime;
    int label;
    final /* synthetic */ AlumniChannelVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlumniChannelVM$queryAlumniChannelList$1(String str, AlumniChannelVM alumniChannelVM, Continuation<? super AlumniChannelVM$queryAlumniChannelList$1> continuation) {
        super(2, continuation);
        this.$refreshTime = str;
        this.this$0 = alumniChannelVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AlumniChannelVM$queryAlumniChannelList$1(this.$refreshTime, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            String str = this.$refreshTime;
            this.label = 1;
            obj = requestModel.x(str, this);
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
        if (pageEntity != null && (list = pageEntity.getList()) != null) {
            AlumniChannelVM alumniChannelVM = this.this$0;
            AllChannelListAdapter value = alumniChannelVM.o().getValue();
            if (value != null) {
                value.setList(list);
            }
            if (list.isEmpty()) {
                return Unit.INSTANCE;
            }
            String coverImgUrl = ((ChannelBean) (list.size() > 1 ? list.get(1) : list.get(0))).getCoverImgUrl();
            MutableLiveData<Object> mutableLiveDataP = alumniChannelVM.p();
            boolean zIsEmpty = TextUtils.isEmpty(coverImgUrl);
            Object objBoxInt = coverImgUrl;
            if (zIsEmpty) {
                objBoxInt = Boxing.boxInt(R.drawable.works_ic_channel_header_empty);
            }
            mutableLiveDataP.setValue(objBoxInt);
        }
        return Unit.INSTANCE;
    }
}
