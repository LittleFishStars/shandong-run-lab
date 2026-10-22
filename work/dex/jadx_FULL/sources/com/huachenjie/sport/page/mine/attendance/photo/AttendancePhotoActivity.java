package com.huachenjie.sport.page.mine.attendance.photo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.photo.AttendancePhotoActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.u66;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.v)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/photo/AttendancePhotoActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/attendance/photo/AttendancePhotoVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "j0", "", "filePath", "k0", "h0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "Lcom/huachenjie/common/bean/ClockTimeData;", "Lcom/huachenjie/common/bean/ClockTimeData;", "clockTimeData", "x", "Ljava/lang/String;", "code", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePhotoActivity extends BaseVmActivity<AttendancePhotoVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.i)
    @JvmField
    @Nullable
    public ClockTimeData clockTimeData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.k)
    @JvmField
    @Nullable
    public String code;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/photo/AttendancePhotoActivity$a;", "", "Landroid/view/View;", "v", "", "b", "c", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/attendance/photo/AttendancePhotoActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            AttendancePhotoActivity.this.finish();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            String value = ((AttendancePhotoVM) ((BaseVmActivity) AttendancePhotoActivity.this).f8507a).h().getValue();
            if (value == null) {
                value = "";
            }
            if (TextUtils.isEmpty(value)) {
                AttendancePhotoActivity.this.j0();
                return;
            }
            Intent intent = new Intent();
            ClockTimeData clockTimeData = AttendancePhotoActivity.this.clockTimeData;
            intent.putExtra(UserConstants.MINE_PARAMS.j, clockTimeData != null ? clockTimeData.getOutsideConfigCode() : null);
            intent.putExtra(UserConstants.MINE_PARAMS.k, AttendancePhotoActivity.this.code);
            String value2 = ((AttendancePhotoVM) ((BaseVmActivity) AttendancePhotoActivity.this).f8507a).h().getValue();
            intent.putExtra(UserConstants.MINE_PARAMS.l, value2 != null ? value2 : "");
            ClockTimeData clockTimeData2 = AttendancePhotoActivity.this.clockTimeData;
            intent.putExtra(UserConstants.MINE_PARAMS.m, clockTimeData2 != null ? clockTimeData2.getLng() : null);
            ClockTimeData clockTimeData3 = AttendancePhotoActivity.this.clockTimeData;
            intent.putExtra(UserConstants.MINE_PARAMS.n, clockTimeData3 != null ? clockTimeData3.getLat() : null);
            AttendancePhotoActivity.this.setResult(-1, intent);
            AttendancePhotoActivity.this.finish();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ((AttendancePhotoVM) ((BaseVmActivity) AttendancePhotoActivity.this).f8507a).h().setValue("");
            AttendancePhotoActivity.this.j0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/photo/AttendancePhotoActivity$b", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements MediaPickerListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof MediaPickerResult.Success) {
                String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
                if (str == null) {
                    return;
                }
                AttendancePhotoActivity.this.k0(str);
                return;
            }
            if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                return;
            }
            fv5.b(((MediaPickerResult.Error) result).f());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/sport/page/mine/attendance/photo/AttendancePhotoActivity$c", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements UploadCallback {
        public c() {
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            fv5.b("图片上传失败");
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            if (TextUtils.isEmpty(fileUrl)) {
                fv5.b("图片上传失败");
            } else {
                ((AttendancePhotoVM) ((BaseVmActivity) AttendancePhotoActivity.this).f8507a).h().setValue(fileUrl);
            }
        }
    }

    public static final void i0(AttendancePhotoActivity attendancePhotoActivity, View view) {
        Intrinsics.checkNotNullParameter(attendancePhotoActivity, "this$0");
        attendancePhotoActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_attendance_photo), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void h0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((AttendancePhotoVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((AttendancePhotoVM) ((BaseVmActivity) this).f8507a).i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("上传照片").setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(R.color.black))).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.rc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendancePhotoActivity.i0(this.f44416a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        this.picker = MediaPicker.w(this, new b());
        h0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.g0(mediaPickerLauncher, "为了能够正常考勤打卡，我们需要访问您终端设备的相机权限", 1080, 1024, false, 0.0f, 0.0f, 56, null);
    }

    public final void k0(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        u66.d(getContext(), UploadFileType.UPLOAD_OUTSIDE_ATTENDANCE, filePath, new c());
    }
}
