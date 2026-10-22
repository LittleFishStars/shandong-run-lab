package android.taobao.windvane.runtimepermission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import com.alibaba.triver.basic.api.RequestPermission;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class PermissionActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21238a = "PermissionActivity";
    private static final int b = 0;
    private static final int c = 123;

    private void a(final String[] strArr, String str) {
        if (!a(strArr) || TextUtils.isEmpty(str)) {
            ActivityCompat.requestPermissions(this, strArr, 0);
        } else {
            new AlertDialog.Builder(this).setPositiveButton("我知道了", new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.runtimepermission.PermissionActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.requestPermissions(PermissionActivity.this, strArr, 0);
                    dialogInterface.dismiss();
                }
            }).setMessage(str).setCancelable(false).show();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123) {
            a.a(i, i2, intent);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        try {
            frameLayout.setAlpha(0.0f);
        } catch (Throwable unused) {
        }
        setContentView(frameLayout);
        String[] stringArrayExtra = getIntent().getStringArrayExtra(RequestPermission.PERMISSIONS);
        String stringExtra = getIntent().getStringExtra("explain");
        if (stringArrayExtra == null || stringArrayExtra.length != 1 || !stringArrayExtra[0].equals(Permission.SYSTEM_ALERT_WINDOW)) {
            a(stringArrayExtra, stringExtra);
            return;
        }
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 123);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            a.a(i, strArr, iArr);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private boolean a(String[] strArr) {
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                return true;
            }
        }
        return false;
    }
}
