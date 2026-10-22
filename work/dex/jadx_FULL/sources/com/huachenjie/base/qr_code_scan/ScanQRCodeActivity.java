package com.huachenjie.base.qr_code_scan;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.utils.TextUtils;
import com.google.zxing.android.activity.CaptureActivity;
import com.hjq.permissions.Permission;
import com.huachenjie.base.R;
import com.huachenjie.base.qr_code_scan.ScanQRCodeActivity;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.dn1;
import com.zj.adlib.fv5;
import com.zj.adlib.vo6;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/ScanQRCodeActivity;", "Lcom/google/zxing/android/activity/CaptureActivity;", "Landroid/os/Bundle;", "icicle", "", "onCreate", "initView", "", "result", "Z", "u0", "o0", "", "n0", bo.g, "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public abstract class ScanQRCodeActivity extends CaptureActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public MediaPickerLauncher picker;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/base/qr_code_scan/ScanQRCodeActivity$a", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "base_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nScanQRCodeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanQRCodeActivity.kt\ncom/huachenjie/base/qr_code_scan/ScanQRCodeActivity$onCreate$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1855#2,2:92\n*S KotlinDebug\n*F\n+ 1 ScanQRCodeActivity.kt\ncom/huachenjie/base/qr_code_scan/ScanQRCodeActivity$onCreate$1\n*L\n28#1:92,2\n*E\n"})
    public static final class a implements MediaPickerListener {
        public a() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof MediaPickerResult.Success) {
                List<String> listG = ((MediaPickerResult.Success) result).g();
                ScanQRCodeActivity scanQRCodeActivity = ScanQRCodeActivity.this;
                Iterator<T> it = listG.iterator();
                while (it.hasNext()) {
                    scanQRCodeActivity.o0(dn1.i((String) it.next()));
                }
                return;
            }
            if (result instanceof MediaPickerResult.a) {
                ScanQRCodeActivity.this.g0();
            } else if (result instanceof MediaPickerResult.Error) {
                fv5.b(((MediaPickerResult.Error) result).f());
                ScanQRCodeActivity.this.g0();
            }
        }
    }

    public static final void q0(ScanQRCodeActivity scanQRCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(scanQRCodeActivity, "this$0");
        scanQRCodeActivity.finish();
    }

    public static final void r0(ScanQRCodeActivity scanQRCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(scanQRCodeActivity, "this$0");
        scanQRCodeActivity.u0();
    }

    public static final void s0(ScanQRCodeActivity scanQRCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(scanQRCodeActivity, "this$0");
        scanQRCodeActivity.u0();
    }

    public static final void t0(ScanQRCodeActivity scanQRCodeActivity, boolean z) {
        Intrinsics.checkNotNullParameter(scanQRCodeActivity, "this$0");
        if (z) {
            scanQRCodeActivity.h0();
        }
    }

    @Override // com.google.zxing.android.activity.CaptureActivity
    public void Z(@Nullable String result) {
        if (TextUtils.isEmpty(result)) {
            return;
        }
        o0(result);
    }

    public final void initView() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.gv7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQRCodeActivity.q0(this.f41994a, view);
            }
        });
        findViewById(R.id.iv_scan_album).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.hv7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQRCodeActivity.r0(this.f42214a, view);
            }
        });
        findViewById(R.id.tv_scan_album).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.iv7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQRCodeActivity.s0(this.f42453a, view);
            }
        });
    }

    public abstract boolean n0(@Nullable String result);

    public final void o0(@Nullable String result) {
        if (n0(result)) {
            p0(result);
        } else {
            fv5.b("二维码错误，请重试");
            g0();
        }
    }

    @Override // com.google.zxing.android.activity.CaptureActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_qr_code_pre);
        this.picker = MediaPicker.w(this, new a());
        initView();
        vo6.j(this, Permission.CAMERA, "为了您能正常使用扫描二维码功能，我们需要访问您终端设备的摄像头权限", new PermissionResultListener() { // from class: com.zj.adlib.fv7
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                ScanQRCodeActivity.t0(this.f41766a, z);
            }
        });
    }

    public abstract void p0(@Nullable String result);

    public final void u0() {
        i0();
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.w(mediaPickerLauncher, 0, 0, false, 0.0f, 0.0f, false, 63, null);
    }
}
