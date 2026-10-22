package com.huachenjie.login.page.info.portrait;

import android.content.Context;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.bean.RegisterConfigBean;
import com.huachenjie.login.bean.RegisterConfigHeadBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.pg3;
import com.zj.adlib.u66;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\"\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00158\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R%\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0\u00158\u0006¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018¨\u0006("}, d2 = {"Lcom/huachenjie/login/page/info/portrait/ChoosePortraitVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "", RenderCallContext.TYPE_CALLBACK, j.b, "Lcom/bumptech/glide/request/RequestOptions;", "a", "Lcom/bumptech/glide/request/RequestOptions;", "i", "()Lcom/bumptech/glide/request/RequestOptions;", "avatarOptions", "", "Lcom/huachenjie/login/bean/RegisterConfigHeadBean;", "Ljava/util/List;", "k", "()Ljava/util/List;", "configHeadList", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "localPortraitPath", "b", "j", "chooseConfigHead", "Lcom/huachenjie/login/page/info/portrait/ChoosePortraitAdapter;", "c", "m", "portraitAdapter", "", "kotlin.jvm.PlatformType", "d", "n", "selectIndex", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ChoosePortraitVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> localPortraitPath;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RequestOptions avatarOptions;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<RegisterConfigHeadBean> configHeadList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RegisterConfigHeadBean> chooseConfigHead;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChoosePortraitAdapter> portraitAdapter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selectIndex;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/login/page/info/portrait/ChoosePortraitVM$a", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Function1<String, Unit> f10106a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super String, Unit> function1) {
            this.f10106a = function1;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            ChoosePortraitVM.this.c();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            ChoosePortraitVM.this.j().setValue(new RegisterConfigHeadBean(null, fileUrl == null ? "" : fileUrl));
            Function1<String, Unit> function1 = this.f10106a;
            if (fileUrl == null) {
                fileUrl = "";
            }
            function1.invoke(fileUrl);
            ChoosePortraitVM.this.c();
        }
    }

    public ChoosePortraitVM() {
        List<RegisterConfigHeadBean> headImgList;
        RequestOptions requestOptionsDiskCacheStrategy = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
        Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy, "circleCropTransform()\n  …gy(DiskCacheStrategy.ALL)");
        this.avatarOptions = requestOptionsDiskCacheStrategy;
        RegisterConfigBean registerConfigBeanC = pg3.f18845a.c();
        this.configHeadList = (registerConfigBeanC == null || (headImgList = registerConfigBeanC.getHeadImgList()) == null) ? CollectionsKt.emptyList() : headImgList;
        this.localPortraitPath = new MutableLiveData<>();
        this.chooseConfigHead = new MutableLiveData<>();
        this.portraitAdapter = new MutableLiveData<>();
        this.selectIndex = new MutableLiveData<>(-2);
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final RequestOptions getAvatarOptions() {
        return this.avatarOptions;
    }

    @NotNull
    public final MutableLiveData<RegisterConfigHeadBean> j() {
        return this.chooseConfigHead;
    }

    @NotNull
    public final List<RegisterConfigHeadBean> k() {
        return this.configHeadList;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.localPortraitPath;
    }

    @NotNull
    public final MutableLiveData<ChoosePortraitAdapter> m() {
        return this.portraitAdapter;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.selectIndex;
    }

    public final void o(@NotNull Context context, @NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        g();
        u66.d(context, UploadFileType.UPLOAD_AVATAR, this.localPortraitPath.getValue(), new a(callback));
    }
}
