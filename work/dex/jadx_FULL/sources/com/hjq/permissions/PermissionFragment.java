package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class PermissionFragment extends Fragment implements Runnable {
    private static final String REQUEST_CODE = "request_code";
    private static final List<Integer> REQUEST_CODE_ARRAY = new ArrayList();
    private static final String REQUEST_PERMISSIONS = "request_permissions";

    @Nullable
    private OnPermissionCallback mCallBack;
    private boolean mDangerousRequest;

    @Nullable
    private OnPermissionInterceptor mInterceptor;
    private boolean mRequestFlag;
    private int mScreenOrientation;
    private boolean mSpecialRequest;

    /* JADX INFO: renamed from: com.hjq.permissions.PermissionFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements OnPermissionCallback {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ List val$allPermissions;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ ArrayList val$secondPermissions;

        public AnonymousClass2(Activity activity, ArrayList arrayList, List list, int i) {
            this.val$activity = activity;
            this.val$secondPermissions = arrayList;
            this.val$allPermissions = list;
            this.val$requestCode = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onGranted$0(Activity activity, final ArrayList arrayList, final List list, final int i) {
            PermissionFragment.launch(activity, arrayList, new OnPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.2.1
            }, new OnPermissionCallback() { // from class: com.hjq.permissions.PermissionFragment.2.2
                @Override // com.hjq.permissions.OnPermissionCallback
                public void onDenied(@NonNull List<String> list2, boolean z) {
                    if (PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            iArr[i2] = PermissionUtils.containsPermission(arrayList, (String) list.get(i2)) ? -1 : 0;
                        }
                        PermissionFragment.this.onRequestPermissionsResult(i, (String[]) list.toArray(new String[0]), iArr);
                    }
                }

                @Override // com.hjq.permissions.OnPermissionCallback
                public void onGranted(@NonNull List<String> list2, boolean z) {
                    if (z && PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[list.size()];
                        Arrays.fill(iArr, 0);
                        PermissionFragment.this.onRequestPermissionsResult(i, (String[]) list.toArray(new String[0]), iArr);
                    }
                }
            });
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onDenied(@NonNull List<String> list, boolean z) {
            if (PermissionFragment.this.isAdded()) {
                int[] iArr = new int[this.val$allPermissions.size()];
                Arrays.fill(iArr, -1);
                PermissionFragment.this.onRequestPermissionsResult(this.val$requestCode, (String[]) this.val$allPermissions.toArray(new String[0]), iArr);
            }
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onGranted(@NonNull List<String> list, boolean z) {
            if (z && PermissionFragment.this.isAdded()) {
                long j = AndroidVersion.isAndroid13() ? 150L : 0L;
                final Activity activity = this.val$activity;
                final ArrayList arrayList = this.val$secondPermissions;
                final List list2 = this.val$allPermissions;
                final int i = this.val$requestCode;
                PermissionUtils.postDelayed(new Runnable() { // from class: com.hjq.permissions.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6829a.lambda$onGranted$0(activity, arrayList, list2, i);
                    }
                }, j);
            }
        }
    }

    public static void launch(@NonNull Activity activity, @NonNull List<String> list, @NonNull OnPermissionInterceptor onPermissionInterceptor, @Nullable OnPermissionCallback onPermissionCallback) {
        int iNextInt;
        List<Integer> list2;
        PermissionFragment permissionFragment = new PermissionFragment();
        Random random = new Random();
        do {
            iNextInt = random.nextInt((int) Math.pow(2.0d, 8.0d));
            list2 = REQUEST_CODE_ARRAY;
        } while (list2.contains(Integer.valueOf(iNextInt)));
        list2.add(Integer.valueOf(iNextInt));
        Bundle bundle = new Bundle();
        bundle.putInt(REQUEST_CODE, iNextInt);
        if (list instanceof ArrayList) {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, (ArrayList) list);
        } else {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, new ArrayList<>(list));
        }
        permissionFragment.setArguments(bundle);
        permissionFragment.setRetainInstance(true);
        permissionFragment.setRequestFlag(true);
        permissionFragment.setOnPermissionCallback(onPermissionCallback);
        permissionFragment.setOnPermissionInterceptor(onPermissionInterceptor);
        permissionFragment.attachByActivity(activity);
    }

    public void attachByActivity(@NonNull Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void detachByActivity(@NonNull Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        ArrayList<String> stringArrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.mDangerousRequest || i != arguments.getInt(REQUEST_CODE) || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        this.mDangerousRequest = true;
        PermissionUtils.postActivityResult(stringArrayList, this);
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.mScreenOrientation = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        PermissionUtils.lockActivityOrientation(activity);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.mScreenOrientation != -1 || activity.getRequestedOrientation() == -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.mInterceptor == null || i != arguments.getInt(REQUEST_CODE)) {
            return;
        }
        OnPermissionCallback onPermissionCallback = this.mCallBack;
        this.mCallBack = null;
        OnPermissionInterceptor onPermissionInterceptor = this.mInterceptor;
        this.mInterceptor = null;
        REQUEST_CODE_ARRAY.remove(Integer.valueOf(i));
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = PermissionApi.recheckPermissionResult(activity, strArr[i2], iArr[i2] == 0) ? 0 : -1;
        }
        ArrayList arrayListAsArrayList = PermissionUtils.asArrayList(strArr);
        detachByActivity(activity);
        List<String> grantedPermissions = PermissionApi.getGrantedPermissions(arrayListAsArrayList, iArr);
        if (grantedPermissions.size() == arrayListAsArrayList.size()) {
            onPermissionInterceptor.grantedPermissionRequest(activity, arrayListAsArrayList, grantedPermissions, true, onPermissionCallback);
            onPermissionInterceptor.finishPermissionRequest(activity, arrayListAsArrayList, false, onPermissionCallback);
            return;
        }
        List<String> deniedPermissions = PermissionApi.getDeniedPermissions(arrayListAsArrayList, iArr);
        onPermissionInterceptor.deniedPermissionRequest(activity, arrayListAsArrayList, deniedPermissions, PermissionApi.isDoNotAskAgainPermissions(activity, deniedPermissions), onPermissionCallback);
        if (!grantedPermissions.isEmpty()) {
            onPermissionInterceptor.grantedPermissionRequest(activity, arrayListAsArrayList, grantedPermissions, false, onPermissionCallback);
        }
        onPermissionInterceptor.finishPermissionRequest(activity, arrayListAsArrayList, false, onPermissionCallback);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachByActivity(getActivity());
        } else {
            if (this.mSpecialRequest) {
                return;
            }
            this.mSpecialRequest = true;
            requestSpecialPermission();
        }
    }

    public void requestDangerousPermission() {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i = arguments.getInt(REQUEST_CODE);
        ArrayList<String> stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS);
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (!AndroidVersion.isAndroid6()) {
            int size = stringArrayList.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = PermissionApi.isGrantedPermission(activity, stringArrayList.get(i2)) ? 0 : -1;
            }
            onRequestPermissionsResult(i, (String[]) stringArrayList.toArray(new String[0]), iArr);
            return;
        }
        if (AndroidVersion.isAndroid13() && stringArrayList.size() >= 2 && PermissionUtils.containsPermission(stringArrayList, Permission.BODY_SENSORS_BACKGROUND)) {
            ArrayList arrayList = new ArrayList(stringArrayList);
            arrayList.remove(Permission.BODY_SENSORS_BACKGROUND);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList, i);
            return;
        }
        if (AndroidVersion.isAndroid10() && stringArrayList.size() >= 2 && PermissionUtils.containsPermission(stringArrayList, Permission.ACCESS_BACKGROUND_LOCATION)) {
            ArrayList arrayList2 = new ArrayList(stringArrayList);
            arrayList2.remove(Permission.ACCESS_BACKGROUND_LOCATION);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList2, i);
        } else {
            if (!AndroidVersion.isAndroid10() || !PermissionUtils.containsPermission(stringArrayList, Permission.ACCESS_MEDIA_LOCATION) || !PermissionUtils.containsPermission(stringArrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), i);
                return;
            }
            ArrayList arrayList3 = new ArrayList(stringArrayList);
            arrayList3.remove(Permission.ACCESS_MEDIA_LOCATION);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList3, i);
        }
    }

    public void requestSpecialPermission() {
        ArrayList<String> stringArrayList;
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        boolean z = false;
        for (int size = stringArrayList.size() - 1; size >= 0; size--) {
            String str = stringArrayList.get(size);
            if (PermissionApi.isSpecialPermission(str) && !PermissionApi.isGrantedPermission(activity, str) && (AndroidVersion.isAndroid11() || !PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE))) {
                StartActivityManager.startActivityForResult(this, PermissionApi.getSmartPermissionIntent(activity, PermissionUtils.asArrayList(str)), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
        }
        if (z) {
            return;
        }
        requestDangerousPermission();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            requestDangerousPermission();
        }
    }

    public void setOnPermissionCallback(@Nullable OnPermissionCallback onPermissionCallback) {
        this.mCallBack = onPermissionCallback;
    }

    public void setOnPermissionInterceptor(@Nullable OnPermissionInterceptor onPermissionInterceptor) {
        this.mInterceptor = onPermissionInterceptor;
    }

    public void setRequestFlag(boolean z) {
        this.mRequestFlag = z;
    }

    public void splitTwiceRequestPermission(@NonNull Activity activity, @NonNull List<String> list, @NonNull List<String> list2, int i) {
        ArrayList arrayList = new ArrayList(list);
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.remove(it.next());
        }
        launch(activity, list2, new OnPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.1
        }, new AnonymousClass2(activity, arrayList, list, i));
    }
}
