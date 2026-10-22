package cj.mobile.wm.permission;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import cj.mobile.wm.permission.androidsupport.ActivityCompat;
import cj.mobile.wm.permission.androidsupport.PermissionChecker;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMPermission {
    public static final String TAG = "WMPermission";
    public PermissionFragment mPermissionFragment;

    public WMPermission(Activity activity) {
        PermissionFragment permissionFragment = (PermissionFragment) activity.getFragmentManager().findFragmentByTag("WMPermission");
        this.mPermissionFragment = permissionFragment;
        if (permissionFragment == null) {
            this.mPermissionFragment = new PermissionFragment();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction().add(this.mPermissionFragment, "WMPermission").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public static List<String> findDeniedPermissions(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!isGranted(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static List<String> findShowRationalePermissions(Activity activity, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean isGranted(Context context, String str) {
        return !isMarshmallow() || PermissionChecker.checkSelfPermission(context, str) == 0;
    }

    public static boolean isMarshmallow() {
        return true;
    }

    public static String[] toArray(List<String> list) {
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static PermissionRequest.Builder with(Activity activity) {
        return new PermissionRequest.Builder(new WMPermission(activity));
    }

    public boolean check(PermissionRequest permissionRequest) {
        if (!isMarshmallow()) {
            return true;
        }
        for (String str : permissionRequest.permissions) {
            if (!isGranted(this.mPermissionFragment.getContext(), str)) {
                return false;
            }
        }
        return true;
    }

    public void request(PermissionRequest permissionRequest) {
        OnRequestCallback onRequestCallback = permissionRequest.onRequestCallback;
        if (!isMarshmallow()) {
            onRequestCallback.onAllowed();
            return;
        }
        if (findDeniedPermissions(this.mPermissionFragment.getContext(), permissionRequest.permissions).isEmpty()) {
            onRequestCallback.onAllowed();
        } else {
            this.mPermissionFragment.requestPermissions(permissionRequest);
        }
    }
}
