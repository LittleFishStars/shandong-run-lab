package com.kc.bw.permission;

import android.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PermissionFragment extends Fragment {
    public final SparseArray<PermissionRequest> mPermissionRequests = new SparseArray<>();

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionRequest permissionRequest = this.mPermissionRequests.get(i);
        if (permissionRequest == null) {
            Log.e("WMPermission", "WMPermission.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
            return;
        }
        this.mPermissionRequests.remove(i);
        if (strArr.length == 0) {
            permissionRequest.onRequestCallback.onRefused(new DeniedResult(new ArrayList(), new ArrayList()));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (iArr[i2] != 0) {
                arrayList.add(strArr[i2]);
            }
        }
        if (arrayList.isEmpty()) {
            permissionRequest.onRequestCallback.onAllowed();
        } else {
            permissionRequest.onRequestCallback.onRefused(new DeniedResult(arrayList, WMPermission.findShowRationalePermissions(getActivity(), WMPermission.toArray(arrayList))));
        }
    }

    public void requestPermissions(PermissionRequest permissionRequest) {
        int i = permissionRequest.requestCode;
        if (this.mPermissionRequests.indexOfKey(i) < 0) {
            this.mPermissionRequests.put(i, permissionRequest);
            requestPermissions(WMPermission.toArray(WMPermission.findDeniedPermissions(getContext(), permissionRequest.permissions)), i);
            return;
        }
        Log.e("WMPermission", "WMPermission have a same requestCode " + i + " that not deal");
    }
}
