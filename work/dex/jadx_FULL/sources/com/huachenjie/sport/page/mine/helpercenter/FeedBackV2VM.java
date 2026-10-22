package com.huachenjie.sport.page.mine.helpercenter;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.FeedbackData;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.sport.R;
import com.huachenjie.sport.api.SportModel;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.u66;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00040\u00040\r8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR1\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0014*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d0\u001d0\r8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R(\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\u0015\u0010\u001b\"\u0004\b\"\u0010#R(\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b\u000f\u0010\u001b\"\u0004\b'\u0010#R(\u0010-\u001a\b\u0012\u0004\u0012\u00020)0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/FeedBackV2VM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroid/content/Context;", "context", "", "path", "", "s", y6b.g, "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", "sportModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "kotlin.jvm.PlatformType", "j", t.d, "opinions", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "m", "()Landroidx/lifecycle/MediatorLiveData;", "opinionsLength", "", "k", "imgUrls", "Lcom/huachenjie/common/bean/FeedbackData;", "b", "q", "(Landroidx/lifecycle/MediatorLiveData;)V", "feedbackInfo", "Lcom/huachenjie/sport/page/mine/helpercenter/FeedbackDetailsAdapter;", "c", "p", "adapter", "", "n", "r", "(Landroidx/lifecycle/MutableLiveData;)V", "showFeedbackFail", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class FeedBackV2VM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> opinionsLength;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public MediatorLiveData<FeedbackData> feedbackInfo;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public MediatorLiveData<FeedbackDetailsAdapter> adapter;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> opinions;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<String>> imgUrls;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> showFeedbackFail;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SportModel sportModel = new SportModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/helpercenter/FeedBackV2VM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {
        public a() {
            super(FeedBackV2VM.this, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            fv5.a(R.string.feedback_succeed);
            ActivityLifecycleManager.l().d(RoutePathConstants.Sport.k).finish();
        }

        public void onFailed(int code, @Nullable String message) {
            if (code == 5051) {
                FeedBackV2VM.this.n().setValue(Boolean.TRUE);
            } else {
                super.onFailed(code, message);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36682a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36682a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36682a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36682a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/sport/page/mine/helpercenter/FeedBackV2VM$c", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements UploadCallback {
        public c() {
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            FeedBackV2VM.this.d.setValue(Boolean.FALSE);
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            FeedBackV2VM.this.d.setValue(Boolean.FALSE);
            if (fileUrl != null) {
                FeedBackV2VM feedBackV2VM = FeedBackV2VM.this;
                List<String> value = feedBackV2VM.k().getValue();
                if (value != null) {
                    value.add(fileUrl);
                }
                feedBackV2VM.k().setValue(value);
            }
        }
    }

    public FeedBackV2VM() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.opinions = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.opinionsLength = mediatorLiveData;
        this.imgUrls = new MutableLiveData<>(new ArrayList());
        this.feedbackInfo = new MediatorLiveData<>();
        this.adapter = new MediatorLiveData<>();
        this.showFeedbackFail = new MutableLiveData<>();
        mediatorLiveData.addSource(mutableLiveData, new b(new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.mine.helpercenter.FeedBackV2VM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                FeedBackV2VM.this.m().setValue(str.length() + "/300");
            }
        }));
    }

    public final void h() {
        if (TextUtils.isEmpty(this.opinions.getValue())) {
            fv5.b("请输入反馈内容");
            return;
        }
        SportModel sportModel = this.sportModel;
        String value = this.opinions.getValue();
        Intrinsics.checkNotNull(value);
        List<String> value2 = this.imgUrls.getValue();
        Intrinsics.checkNotNull(value2);
        n76.d(sportModel.b(value, value2)).c(this).p5(new a());
    }

    @NotNull
    public final MediatorLiveData<FeedbackDetailsAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MediatorLiveData<FeedbackData> j() {
        return this.feedbackInfo;
    }

    @NotNull
    public final MutableLiveData<List<String>> k() {
        return this.imgUrls;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.opinions;
    }

    @NotNull
    public final MediatorLiveData<String> m() {
        return this.opinionsLength;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.showFeedbackFail;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> o() {
        return this.titleBean;
    }

    public final void p(@NotNull MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.adapter = mediatorLiveData;
    }

    public final void q(@NotNull MediatorLiveData<FeedbackData> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.feedbackInfo = mediatorLiveData;
    }

    public final void r(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.showFeedbackFail = mutableLiveData;
    }

    public final void s(@NotNull Context context, @NotNull String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        this.d.setValue(Boolean.TRUE);
        u66.d(context, UploadFileType.UPLOAD_FEEDBACK, path, new c());
    }
}
