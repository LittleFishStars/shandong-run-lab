package com.huachenjie.common.dialog;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.byazt.tk.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hjq.permissions.Permission;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.bean.VersionUpgrade;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.SystemConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.ltmb.ltadsdk.core.download.SYDownloadManager;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.hq2;
import com.zj.adlib.n76;
import com.zj.adlib.r90;
import com.zj.adlib.sh9;
import huachenjie.sdk.http.download.DownloadCallback;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = RoutePathConstants.Common.d)
public class VersionUpgradeDialog extends BaseActivity {
    public static final int L = 3001;
    public static final int M = 3002;
    public static final String t = "VersionUpgradeDialog";
    public static final String x = "versionUpgrade";
    public static final String y = "requestUpgradeInfo";
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VersionUpgrade f33814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressDialog f8774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public UpgradeListener f8775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final gq1 f8776a = new gq1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f8777a;
    public Dialog e;

    public interface UpgradeListener {
        void a();

        void onCancel();
    }

    public class a extends BizSubscriber<VersionUpgrade> {
        public a() {
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            VersionUpgradeDialog.this.y0(null);
        }

        public void onCCSuccess(VersionUpgrade data) {
            VersionUpgradeDialog.this.y0(data);
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            VersionUpgradeDialog.this.A0();
        }
    }

    public class c extends DialogUtil.PositiveNegativeClickListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            super.a();
            if (VersionUpgradeDialog.this.f8775a != null) {
                VersionUpgradeDialog.this.f8775a.onCancel();
            }
            VersionUpgradeDialog.this.A0();
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            VersionUpgradeDialog.this.x0();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VersionUpgradeDialog.this.x0();
        }
    }

    public class e extends DownloadCallback {
        public e() {
        }

        public void a(int code, String message) {
            if (VersionUpgradeDialog.this.f8774a != null) {
                VersionUpgradeDialog.this.f8774a.dismiss();
            }
        }

        public void b() {
            super.b();
        }

        public void c(long hasWrite, long totalLength) {
            if (VersionUpgradeDialog.this.f8774a != null) {
                VersionUpgradeDialog.this.f8774a.update(BigDecimal.valueOf(hasWrite).divide(BigDecimal.valueOf(totalLength), 2, 4).multiply(BigDecimal.valueOf(100L)).intValue());
            }
        }

        public void e(File file) {
            VersionUpgradeDialog.this.f8777a = file;
            VersionUpgradeDialog versionUpgradeDialog = VersionUpgradeDialog.this;
            versionUpgradeDialog.s0(versionUpgradeDialog.f33814a.isForceUpdate());
            if (VersionUpgradeDialog.this.f8774a != null) {
                VersionUpgradeDialog.this.f8774a.dismiss();
            }
        }
    }

    public final void A0() {
        Intent intent = new Intent();
        intent.putExtra(SystemConstants.UPGRADE_PARAMS.f33722a, SystemConstants.UPGRADE_PARAMS.b);
        setResult(0, intent);
        finish();
    }

    public void B0(UpgradeListener listener) {
        this.f8775a = listener;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return 0;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
        this.f33814a = (VersionUpgrade) intent.getParcelableExtra(x);
        if (intent.getBooleanExtra(y, false)) {
            n76.e(this, this.f8776a.e()).p5(new a());
        } else {
            y0(this.f33814a);
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f8774a = new ProgressDialog(((BaseActivity) this).c);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3002) {
            if (resultCode == -1) {
                s0(this.f33814a.isForceUpdate());
                return;
            }
            fv5.a(R.string.install_failed);
            if (this.f33814a.isForceUpdate()) {
                return;
            }
            A0();
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.e;
        if (dialog != null) {
            dialog.dismiss();
        }
        ProgressDialog progressDialog = this.f8774a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        this.f8775a = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 3001) {
            if (permissions != null && permissions.length > 0 && grantResults[0] == 0) {
                z0(this.f33814a.isForceUpdate());
                return;
            }
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + ((BaseActivity) this).c.getPackageName()));
            startActivityForResult(intent, 3002);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void s0(boolean isForce) {
        if (((BaseActivity) this).c.getPackageManager().canRequestPackageInstalls()) {
            z0(isForce);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Permission.REQUEST_INSTALL_PACKAGES}, 3001);
        }
    }

    public final void t0(String url) {
        this.f8774a.show();
        hq2.j(((BaseActivity) this).c, url, new e());
    }

    public final String u0(String url) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        int iLastIndexOf2 = url.lastIndexOf(35);
        if (iLastIndexOf2 > 0) {
            url = url.substring(0, iLastIndexOf2);
        }
        int iLastIndexOf3 = url.lastIndexOf(63);
        if (iLastIndexOf3 > 0) {
            url = url.substring(0, iLastIndexOf3);
        }
        int iLastIndexOf4 = url.lastIndexOf(47);
        if (iLastIndexOf4 >= 0) {
            url = url.substring(iLastIndexOf4 + 1);
        }
        return (url.isEmpty() || (iLastIndexOf = url.lastIndexOf(46)) < 0) ? "" : url.substring(iLastIndexOf + 1);
    }

    public final void v0(String url) {
        String strSubstring = url.substring(url.lastIndexOf("=") + 1);
        if (url.indexOf("market://") == 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.addFlags(268435456);
            try {
                if (intent.resolveActivity(((BaseActivity) this).c.getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=" + strSubstring)));
                }
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void w0(String url) {
        if (url.indexOf("http://") == 0 || url.indexOf("https://") == 0) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void x0() {
        String downloadUrl = this.f33814a.getDownloadUrl();
        String strU0 = u0(downloadUrl);
        if (downloadUrl.indexOf("market://") == 0) {
            v0(downloadUrl);
            if (!this.f33814a.isForceUpdate()) {
                A0();
            }
            UpgradeListener upgradeListener = this.f8775a;
            if (upgradeListener != null) {
                upgradeListener.a();
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(strU0) && SYDownloadManager.DOWNLOAD_TYPE_APK.equals(strU0)) {
            t0(downloadUrl);
            UpgradeListener upgradeListener2 = this.f8775a;
            if (upgradeListener2 != null) {
                upgradeListener2.a();
                return;
            }
            return;
        }
        if (downloadUrl.indexOf("http://") != 0 && downloadUrl.indexOf("https://") != 0) {
            A0();
            return;
        }
        w0(downloadUrl);
        if (!this.f33814a.isForceUpdate()) {
            A0();
        }
        UpgradeListener upgradeListener3 = this.f8775a;
        if (upgradeListener3 != null) {
            upgradeListener3.a();
        }
    }

    public final void y0(VersionUpgrade versionUpgrade) {
        if (versionUpgrade == null || !versionUpgrade.isHaveUpdate()) {
            A0();
            return;
        }
        this.f33814a = versionUpgrade;
        boolean z = !versionUpgrade.isForceUpdate();
        View viewInflate = View.inflate(this, R.layout.dialog_new_version, null);
        this.F = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.H = textView;
        textView.setText(!TextUtils.isEmpty(versionUpgrade.getUpdateTitle()) ? versionUpgrade.getUpdateTitle() : "");
        this.F.setText(TextUtils.isEmpty(versionUpgrade.getUpdateDescription()) ? "" : versionUpgrade.getUpdateDescription());
        if (versionUpgrade.isForceUpdate()) {
            this.e = new CustomizeViewDialog.Builder().setDialogWidth(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME).setMessageView(viewInflate).setCancelable(z).setCanceledOnTouchOutside(z).setClickPositiveKeepShow(true).setPositive(((BaseActivity) this).c.getString(R.string.upgrade_immediately), new d()).create(this);
        } else {
            this.e = new CustomizeViewDialog.Builder().setDialogWidth(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME).setMessageView(viewInflate).setCancelable(z).setCanceledOnTouchOutside(z).setNegative(((BaseActivity) this).c.getString(R.string.ignore_upgrade)).setPositive(((BaseActivity) this).c.getString(R.string.upgrade_immediately)).setClickPositiveKeepShow(true).setPositiveNegativeClickListener(new c()).setOnDismissListener(new b()).create(this);
        }
        this.e.show();
        r90.h0(versionUpgrade.getNewVersion());
        r90.g0(System.currentTimeMillis());
    }

    public final void z0(boolean isForce) {
        File file = this.f8777a;
        if (file == null || !file.exists()) {
            fv5.a(R.string.install_failed);
            A0();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setFlags(1);
        intent.setDataAndType(sh9.i(((BaseActivity) this).c, this.f8777a), AdBaseConstants.MIME_APK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
        if (isForce) {
            return;
        }
        A0();
    }
}
