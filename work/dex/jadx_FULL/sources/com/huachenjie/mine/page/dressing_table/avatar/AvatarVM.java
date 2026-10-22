package com.huachenjie.mine.page.dressing_table.avatar;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.u66;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0002H\u0002R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00060\u00060\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u00110\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "m", "Landroid/content/Context;", "context", "", "path", "n", t.d, "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", AvatarFragment.AVATAR_URL, "", "b", "k", "saveSuccess", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class AvatarVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> avatarUrl = new MutableLiveData<>("");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> saveSuccess = new MutableLiveData<>(Boolean.FALSE);

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mine/page/dressing_table/avatar/AvatarVM$a", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UploadCallback {
        public a() {
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            AvatarVM.this.c();
            AvatarVM.this.l();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            AvatarVM.this.c();
            if (TextUtils.isEmpty(fileUrl)) {
                AvatarVM.this.l();
            } else {
                AvatarVM.this.j().setValue(fileUrl);
                AvatarVM.this.m();
            }
        }
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.avatarUrl;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.saveSuccess;
    }

    public final void l() {
        fv5.b("上传头像失败");
    }

    public final void m() {
        if (TextUtils.isEmpty(this.avatarUrl.getValue())) {
            fv5.b("头像保存失败");
        } else {
            BaseViewModelExtKt.b(this, true, false, null, null, new AvatarVM$saveUserAvatar$1(this, null), 14, null);
        }
    }

    public final void n(@NotNull Context context, @NotNull String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        g();
        u66.d(context, UploadFileType.UPLOAD_AVATAR, path, new a());
    }
}
