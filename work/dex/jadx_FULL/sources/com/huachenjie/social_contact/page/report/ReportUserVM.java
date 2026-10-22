package com.huachenjie.social_contact.page.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.kernel.RVStartParams;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.api.UniverseModel;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.u66;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00128\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R%\u0010#\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00060\u00060\u00128\u0006¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020)0$8\u0006¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b\u001a\u0010'R%\u0010-\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00040\u00040\u00128\u0006¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b,\u0010\u0017R%\u0010/\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00060\u00060\u00128\u0006¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b.\u0010\u0017R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020)0$8\u0006¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b\u0014\u0010'R%\u00102\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00040\u00040\u00128\u0006¢\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b!\u0010\u0017¨\u00065"}, d2 = {"Lcom/huachenjie/social_contact/page/report/ReportUserVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroid/content/Context;", "context", "", RVStartParams.KEY_FROM_TYPE, "", "path", "", "s", UserConstants.CHAT_PARAMS.g, UserConstants.CHAT_PARAMS.f, UserConstants.CHAT_PARAMS.h, "r", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "messageModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/social_contact/page/report/ReportUserAdapter;", "j", y6b.g, "adapter", "Lcom/huachenjie/social_contact/page/report/ReportImageEvidenceAdapter;", "k", "imageAdapter", "kotlin.jvm.PlatformType", t.d, "m", "opinions", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "n", "()Landroidx/lifecycle/MediatorLiveData;", "opinionsLength", "", "b", "committing", j.b, "reportType", "p", "reportTypeStr", "c", "commitFinish", "imageCount", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReportUserVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportUserVM.kt\ncom/huachenjie/social_contact/page/report/ReportUserVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n1855#2,2:152\n*S KotlinDebug\n*F\n+ 1 ReportUserVM.kt\ncom/huachenjie/social_contact/page/report/ReportUserVM\n*L\n103#1:152,2\n*E\n"})
public final class ReportUserVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> opinionsLength;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> committing;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> commitFinish;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> opinions;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> reportType;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> reportTypeStr;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> imageCount;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final UniverseModel messageModel = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ReportUserAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ReportImageEvidenceAdapter> imageAdapter = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/social_contact/page/report/ReportUserVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "data", "", "onCCSuccess", "onFinish", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<Object> {
        public a() {
            super(true);
        }

        public void onCCSuccess(@Nullable Object data) {
            ReportUserVM.this.j().setValue(Boolean.FALSE);
            fv5.b("举报成功");
            ReportUserVM.this.i().setValue(Boolean.TRUE);
        }

        public void onFinish() {
            ReportUserVM.this.j().setValue(Boolean.FALSE);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36292a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36292a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36292a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36292a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/social_contact/page/report/ReportUserVM$c", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements UploadCallback {
        public c() {
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            ReportUserVM.this.d.setValue(Boolean.FALSE);
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            ReportImageEvidenceAdapter value;
            ReportUserVM.this.d.setValue(Boolean.FALSE);
            if (fileUrl == null || (value = ReportUserVM.this.k().getValue()) == null) {
                return;
            }
            int size = value.getData().size() - 1;
            if (size < 0) {
                value.addData(fileUrl);
            } else {
                value.addData(size, fileUrl);
            }
            Integer value2 = ReportUserVM.this.l().getValue();
            if (value2 == null) {
                value2 = 0;
            }
            ReportUserVM.this.l().setValue(Integer.valueOf(value2.intValue() + 1));
        }
    }

    public ReportUserVM() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.opinions = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.opinionsLength = mediatorLiveData;
        Boolean bool = Boolean.FALSE;
        this.committing = new MediatorLiveData<>(bool);
        this.reportType = new MutableLiveData<>(0);
        this.reportTypeStr = new MutableLiveData<>("");
        this.commitFinish = new MediatorLiveData<>(bool);
        this.imageCount = new MutableLiveData<>(0);
        mediatorLiveData.addSource(mutableLiveData, new b(new Function1<String, Unit>() { // from class: com.huachenjie.social_contact.page.report.ReportUserVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                ReportUserVM.this.n().setValue(str.length() + "/100");
            }
        }));
    }

    @NotNull
    public final MutableLiveData<ReportUserAdapter> h() {
        return this.adapter;
    }

    @NotNull
    public final MediatorLiveData<Boolean> i() {
        return this.commitFinish;
    }

    @NotNull
    public final MediatorLiveData<Boolean> j() {
        return this.committing;
    }

    @NotNull
    public final MutableLiveData<ReportImageEvidenceAdapter> k() {
        return this.imageAdapter;
    }

    @NotNull
    public final MutableLiveData<Integer> l() {
        return this.imageCount;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.opinions;
    }

    @NotNull
    public final MediatorLiveData<String> n() {
        return this.opinionsLength;
    }

    @NotNull
    public final MutableLiveData<Integer> o() {
        return this.reportType;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.reportTypeStr;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> q() {
        return this.titleBean;
    }

    public final void r(@NotNull String reportUserId, int fromType, @NotNull String reportCode, int reportSource) {
        Observable<BaseEntity<Object>> observableB;
        List<String> data;
        Intrinsics.checkNotNullParameter(reportUserId, UserConstants.CHAT_PARAMS.g);
        Intrinsics.checkNotNullParameter(reportCode, UserConstants.CHAT_PARAMS.f);
        Integer value = this.reportType.getValue();
        if ((value != null && value.intValue() == 0) || TextUtils.isEmpty(this.reportTypeStr.getValue())) {
            this.committing.setValue(Boolean.FALSE);
            fv5.b("请选择举报理由");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ReportImageEvidenceAdapter value2 = this.imageAdapter.getValue();
        if (value2 != null && (data = value2.getData()) != null) {
            for (String str : data) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.committing.setValue(Boolean.FALSE);
            fv5.b("请上传举报图片");
            return;
        }
        Integer value3 = this.reportType.getValue();
        if (value3 == null) {
            return;
        }
        int iIntValue = value3.intValue();
        if (fromType == 2) {
            observableB = this.messageModel.B(reportCode, this.opinions.getValue(), iIntValue, reportSource, arrayList);
        } else if (fromType != 3) {
            observableB = fromType != 4 ? this.messageModel.A(reportUserId, this.opinions.getValue(), iIntValue, arrayList) : this.messageModel.z(reportCode, this.opinions.getValue(), iIntValue, reportSource, arrayList);
        } else {
            observableB = this.messageModel.x(reportCode, this.opinions.getValue(), iIntValue, reportSource, arrayList);
        }
        n76.e(this, observableB).p5(new a());
    }

    public final void s(@NotNull Context context, int fromType, @NotNull String path) {
        UploadFileType uploadFileType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        if (fromType == 2) {
            uploadFileType = UploadFileType.UPLOAD_WORK_REPORT;
        } else if (fromType != 3) {
            uploadFileType = fromType != 4 ? UploadFileType.UPLOAD_STUDENT_REPORT : UploadFileType.UPLOAD_LIVE_REPORT;
        } else {
            uploadFileType = UploadFileType.UPLOAD_ALUMNI_SAY_REPORT;
        }
        this.d.setValue(Boolean.TRUE);
        u66.d(context, uploadFileType, path, new c());
    }
}
