package com.huachenjie.channel.page.manage_channel.topic;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.ge7;
import com.zj.adlib.pf6;
import com.zj.adlib.u66;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004JO\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00158\u0006¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001aR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00158\u0006¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00158\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic/CreateTopicVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroid/content/Context;", "context", "", "channelNo", "topicGroupCode", "", "k", "m", t.d, "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopic;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onSuccess", "Lkotlin/Function0;", TriverEmbedVideoView.b, "s", "(Landroid/content/Context;Lcom/huachenjie/channel/bean/my_channel/MyChannelTopic;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "b", "r", "topic", "", "c", "n", "addFlag", "d", "p", "editFlag", "e", j.b, "deleteFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateTopicVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MyChannelTopic> topic = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> addFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> editFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> deleteFlag = new MutableLiveData<>();

    public static final void t(Function0 function0, final CreateTopicVM createTopicVM, MyChannelTopic myChannelTopic, Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function0, "$onError");
        Intrinsics.checkNotNullParameter(createTopicVM, "this$0");
        Intrinsics.checkNotNullParameter(myChannelTopic, "$bean");
        Intrinsics.checkNotNullParameter(function1, "$onSuccess");
        Intrinsics.checkNotNullExpressionValue(list, "fileInfoList");
        boolean z = false;
        pf6 pf6Var = (pf6) CollectionsKt.getOrNull(list, 0);
        if (pf6Var != null && pf6Var.f()) {
            z = true;
        }
        if (z) {
            BaseViewModelExtKt.b(createTopicVM, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$uploadFile$2$1
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    this.this$0.c();
                    return Boolean.FALSE;
                }
            }, null, new CreateTopicVM$uploadFile$2$2(myChannelTopic, list, function1, null), 11, null);
        } else {
            function0.invoke();
        }
    }

    public final void k(@NotNull Context context, @NotNull String channelNo, @NotNull String topicGroupCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(topicGroupCode, "topicGroupCode");
        MyChannelTopic value = this.topic.getValue();
        if (value != null) {
            value.setSubjectName(StringsKt.trim(value.getSubjectName()).toString());
        }
        MyChannelTopic value2 = this.topic.getValue();
        if (ys8.h(value2 != null ? value2.getSubjectName() : null)) {
            fv5.b(ys8.e(R.string.channel_manage_topic_name_input));
            return;
        }
        MyChannelTopic value3 = this.topic.getValue();
        List<String> listC = ge7.c("[\\s#]", value3 != null ? value3.getSubjectName() : null);
        Intrinsics.checkNotNullExpressionValue(listC, "getMatches(\"[\\\\s#]\", topic.value?.subjectName)");
        if (!listC.isEmpty()) {
            fv5.b(ys8.e(R.string.channel_manage_topic_name_error));
        } else {
            BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$addTopic$2
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    this.this$0.c();
                    return Boolean.FALSE;
                }
            }, null, new CreateTopicVM$addTopic$3(this, context, channelNo, topicGroupCode, null), 11, null);
        }
    }

    public final void l(@NotNull String channelNo, @NotNull String topicGroupCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(topicGroupCode, "topicGroupCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new CreateTopicVM$deleteTopic$1(channelNo, topicGroupCode, this, null), 14, null);
    }

    public final void m(@NotNull Context context, @NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$editTopic$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.c();
                return Boolean.FALSE;
            }
        }, null, new CreateTopicVM$editTopic$2(this, context, channelNo, null), 11, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.addFlag;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.deleteFlag;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.editFlag;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> q() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<MyChannelTopic> r() {
        return this.topic;
    }

    public final Object s(Context context, final MyChannelTopic myChannelTopic, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(myChannelTopic.getSubjectImg()) && !StringsKt.startsWith$default(myChannelTopic.getSubjectImg(), "http", false, 2, (Object) null)) {
            arrayList.add(myChannelTopic.getSubjectImg());
        }
        if (arrayList.isEmpty()) {
            Object objInvoke = function1.invoke(continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        u66.e(context, UploadFileType.UPLOAD_CHANEL_SUBJECT, arrayList, new MultipleUploadCallback() { // from class: com.zj.adlib.tx1
            @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
            public final void c(List list) {
                CreateTopicVM.t(function0, this, myChannelTopic, function1, list);
            }
        });
        return Unit.INSTANCE;
    }
}
