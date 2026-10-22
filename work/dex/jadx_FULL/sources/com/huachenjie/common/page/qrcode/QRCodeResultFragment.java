package com.huachenjie.common.page.qrcode;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment;", "Landroidx/fragment/app/Fragment;", "", "showAlbum", "", "startScan", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", "getListener", "()Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", "setListener", "(Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;)V", "<init>", "()V", "Companion", "a", "ScanResultListener", "common_release"}, k = 1, mv = {1, 8, 0})
public final class QRCodeResultFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTRA_SHOW_ALBUM = "extra_show_album";
    public static final int REQUEST_CODE = 0;

    @NotNull
    public static final String TAG = "QRCodeResultFragment";
    public ScanResultListener listener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", "", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "", "result", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface ScanResultListener {
        void a(@Nullable AppCompatActivity activity, @NotNull String result);
    }

    /* JADX INFO: renamed from: com.huachenjie.common.page.qrcode.QRCodeResultFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$a;", "", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment;", "a", "", "EXTRA_SHOW_ALBUM", "Ljava/lang/String;", "", "REQUEST_CODE", "I", "TAG", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QRCodeResultFragment a(@NotNull AppCompatActivity activity) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            if (activity.getSupportFragmentManager().findFragmentByTag(QRCodeResultFragment.TAG) instanceof QRCodeResultFragment) {
                Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(QRCodeResultFragment.TAG);
                Intrinsics.checkNotNull(fragmentFindFragmentByTag, "null cannot be cast to non-null type com.huachenjie.common.page.qrcode.QRCodeResultFragment");
                return (QRCodeResultFragment) fragmentFindFragmentByTag;
            }
            QRCodeResultFragment qRCodeResultFragment = new QRCodeResultFragment();
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            supportFragmentManager.beginTransaction().add(qRCodeResultFragment, QRCodeResultFragment.TAG).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return qRCodeResultFragment;
        }
    }

    public static /* synthetic */ void startScan$default(QRCodeResultFragment qRCodeResultFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        qRCodeResultFragment.startScan(z);
    }

    @NotNull
    public final ScanResultListener getListener() {
        ScanResultListener scanResultListener = this.listener;
        if (scanResultListener != null) {
            return scanResultListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == -1 && data != null) {
            String stringExtra = data.getStringExtra("result");
            if (this.listener != null) {
                ScanResultListener listener = getListener();
                AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                listener.a(appCompatActivity, stringExtra);
            }
        }
    }

    public final void setListener(@NotNull ScanResultListener scanResultListener) {
        Intrinsics.checkNotNullParameter(scanResultListener, "<set-?>");
        this.listener = scanResultListener;
    }

    public final void startScan(boolean showAlbum) {
        Intent intent = new Intent(getContext(), (Class<?>) WeChatQRCodeActivity.class);
        intent.putExtra(EXTRA_SHOW_ALBUM, showAlbum);
        startActivityForResult(intent, 0);
    }
}
