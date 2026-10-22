package com.huachenjie.works.page.broadcast_floor;

import android.content.Context;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.BroadcastFloorBean;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.u66;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J,\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u00138\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R%\u0010\"\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001f0\u001f0\u00138\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00138\u0006¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "r", "s", "Landroid/content/Context;", "context", "", "content", "Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "image", "Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "voice", "q", "localPath", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "type", "t", "(Landroid/content/Context;Ljava/lang/String;Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/bean/BroadcastFloorBean;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "broadcastFloorBean", "", "kotlin.jvm.PlatformType", "b", "p", "showSurvey", "", "c", "m", BroadcastFloorFragment.BROADCAST_RANGE, "d", "n", "publishFlag", "e", j.b, "resultQuestionnaire", "f", "Ljava/lang/String;", "requestId", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BroadcastFloorVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BroadcastFloorBean> broadcastFloorBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showSurvey = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> broadcastRange = new MutableLiveData<>(2);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> publishFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> resultQuestionnaire = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String requestId = "";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/broadcast_floor/BroadcastFloorVM$a", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f37208a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<String> f14876a;

        public a(Ref.ObjectRef<String> objectRef, CountDownLatch countDownLatch) {
            this.f14876a = objectRef;
            this.f37208a = countDownLatch;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            this.f37208a.countDown();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            Ref.ObjectRef<String> objectRef = this.f14876a;
            if (fileUrl == null) {
                fileUrl = "";
            }
            objectRef.element = fileUrl;
            this.f37208a.countDown();
        }
    }

    @NotNull
    public final MutableLiveData<BroadcastFloorBean> l() {
        return this.broadcastFloorBean;
    }

    @NotNull
    public final MutableLiveData<Integer> m() {
        return this.broadcastRange;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.publishFlag;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.resultQuestionnaire;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.showSurvey;
    }

    public final void q(@NotNull Context context, @Nullable String content, @Nullable BroadcastFloorMessageImageBean image, @Nullable BroadcastFloorMessageVoiceBean voice) {
        Intrinsics.checkNotNullParameter(context, "context");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorVM$publishQuote$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() == 21001) {
                    fv5.b(resultException.getMessage());
                    this.this$0.n().setValue(Boolean.FALSE);
                    z = true;
                } else {
                    this.this$0.s();
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new BroadcastFloorVM$publishQuote$2(image, voice, content, this, context, null), 10, null);
    }

    public final void r() {
        BaseViewModelExtKt.b(this, false, false, null, null, new BroadcastFloorVM$queryBroadcastFloor$1(this, null), 15, null);
    }

    public final void s() {
        BaseViewModelExtKt.b(this, false, false, null, null, new BroadcastFloorVM$queryQuoteRequestId$1(this, null), 15, null);
    }

    public final Object t(Context context, String str, UploadFileType uploadFileType, Continuation<? super String> continuation) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        u66.d(context, uploadFileType, str, new a(objectRef, countDownLatch));
        countDownLatch.await();
        return objectRef.element;
    }
}
