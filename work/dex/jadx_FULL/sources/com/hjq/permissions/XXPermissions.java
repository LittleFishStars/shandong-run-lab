package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class XXPermissions {
    public static final int REQUEST_CODE = 1025;
    private static Boolean sCheckMode;
    private static OnPermissionInterceptor sInterceptor;

    @Nullable
    private Boolean mCheckMode;

    @Nullable
    private final Context mContext;

    @Nullable
    private OnPermissionInterceptor mInterceptor;

    @NonNull
    private final List<String> mPermissions = new ArrayList();

    private XXPermissions(@Nullable Context context) {
        this.mContext = context;
    }

    public static boolean containsSpecial(@NonNull String... strArr) {
        return containsSpecial(PermissionUtils.asArrayList(strArr));
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull String... strArr) {
        return getDenied(context, PermissionUtils.asArrayList(strArr));
    }

    public static OnPermissionInterceptor getInterceptor() {
        if (sInterceptor == null) {
            sInterceptor = new OnPermissionInterceptor() { // from class: com.hjq.permissions.XXPermissions.1
            };
        }
        return sInterceptor;
    }

    private boolean isCheckMode(@NonNull Context context) {
        if (this.mCheckMode == null) {
            if (sCheckMode == null) {
                sCheckMode = Boolean.valueOf(PermissionUtils.isDebugMode(context));
            }
            this.mCheckMode = sCheckMode;
        }
        return this.mCheckMode.booleanValue();
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull String... strArr) {
        return isDoNotAskAgainPermissions(activity, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isGranted(@NonNull Context context, @NonNull String... strArr) {
        return isGranted(context, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isSpecial(@NonNull String str) {
        return PermissionApi.isSpecialPermission(str);
    }

    public static void setCheckMode(boolean z) {
        sCheckMode = Boolean.valueOf(z);
    }

    public static void setInterceptor(OnPermissionInterceptor onPermissionInterceptor) {
        sInterceptor = onPermissionInterceptor;
    }

    public static void startPermissionActivity(@NonNull Context context) {
        startPermissionActivity(context, new ArrayList(0));
    }

    public static XXPermissions with(@NonNull Context context) {
        return new XXPermissions(context);
    }

    public XXPermissions interceptor(@Nullable OnPermissionInterceptor onPermissionInterceptor) {
        this.mInterceptor = onPermissionInterceptor;
        return this;
    }

    public XXPermissions permission(@Nullable String str) {
        if (str == null || PermissionUtils.containsPermission(this.mPermissions, str)) {
            return this;
        }
        this.mPermissions.add(str);
        return this;
    }

    public void request(@Nullable OnPermissionCallback onPermissionCallback) {
        if (this.mContext == null) {
            return;
        }
        if (this.mInterceptor == null) {
            this.mInterceptor = getInterceptor();
        }
        Context context = this.mContext;
        OnPermissionInterceptor onPermissionInterceptor = this.mInterceptor;
        ArrayList arrayList = new ArrayList(this.mPermissions);
        boolean zIsCheckMode = isCheckMode(context);
        Activity activityFindActivity = PermissionUtils.findActivity(context);
        if (PermissionChecker.checkActivityStatus(activityFindActivity, zIsCheckMode) && PermissionChecker.checkPermissionArgument(arrayList, zIsCheckMode)) {
            if (zIsCheckMode) {
                AndroidManifestInfo androidManifestInfo = PermissionUtils.getAndroidManifestInfo(context);
                PermissionChecker.checkMediaLocationPermission(context, arrayList);
                PermissionChecker.checkStoragePermission(context, arrayList, androidManifestInfo);
                PermissionChecker.checkBodySensorsPermission(arrayList);
                PermissionChecker.checkLocationPermission(arrayList);
                PermissionChecker.checkPictureInPicturePermission(activityFindActivity, arrayList, androidManifestInfo);
                PermissionChecker.checkNotificationListenerPermission(arrayList, androidManifestInfo);
                PermissionChecker.checkNearbyDevicesPermission(arrayList, androidManifestInfo);
                PermissionChecker.checkReadMediaVisualUserSelectedPermission(arrayList);
                PermissionChecker.checkTargetSdkVersion(context, arrayList);
                PermissionChecker.checkManifestPermissions(context, arrayList, androidManifestInfo);
            }
            PermissionChecker.optimizeDeprecatedPermission(arrayList);
            if (!PermissionApi.isGrantedPermissions(context, arrayList)) {
                onPermissionInterceptor.launchPermissionRequest(activityFindActivity, arrayList, onPermissionCallback);
            } else {
                onPermissionInterceptor.grantedPermissionRequest(activityFindActivity, arrayList, arrayList, true, onPermissionCallback);
                onPermissionInterceptor.finishPermissionRequest(activityFindActivity, arrayList, true, onPermissionCallback);
            }
        }
    }

    public boolean revokeOnKill() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        List<String> list = this.mPermissions;
        if (list.isEmpty() || !AndroidVersion.isAndroid13()) {
            return false;
        }
        try {
            if (list.size() == 1) {
                context.revokeSelfPermissionOnKill(list.get(0));
            } else {
                context.revokeSelfPermissionsOnKill(list);
            }
            return true;
        } catch (IllegalArgumentException e) {
            if (isCheckMode(context)) {
                throw e;
            }
            e.printStackTrace();
            return false;
        }
    }

    public XXPermissions unchecked() {
        this.mCheckMode = Boolean.FALSE;
        return this;
    }

    public static boolean containsSpecial(@NonNull List<String> list) {
        return PermissionApi.containsSpecialPermission(list);
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull String[]... strArr) {
        return getDenied(context, PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull String[]... strArr) {
        return isDoNotAskAgainPermissions(activity, PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isGranted(@NonNull Context context, @NonNull String[]... strArr) {
        return isGranted(context, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull String... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayList(strArr));
    }

    public static XXPermissions with(@NonNull Fragment fragment) {
        return with(fragment.getActivity());
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull List<String> list) {
        return PermissionApi.getDeniedPermissions(context, list);
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull List<String> list) {
        return PermissionApi.isDoNotAskAgainPermissions(activity, list);
    }

    public static boolean isGranted(@NonNull Context context, @NonNull List<String> list) {
        return PermissionApi.isGrantedPermissions(context, list);
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull String[]... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayLists(strArr));
    }

    public static XXPermissions with(@NonNull androidx.fragment.app.Fragment fragment) {
        return with(fragment.getActivity());
    }

    public XXPermissions permission(@Nullable String... strArr) {
        return permission(PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull List<String> list) {
        Activity activityFindActivity = PermissionUtils.findActivity(context);
        if (activityFindActivity != null) {
            startPermissionActivity(activityFindActivity, list);
            return;
        }
        Intent smartPermissionIntent = PermissionApi.getSmartPermissionIntent(context, list);
        if (!(context instanceof Activity)) {
            smartPermissionIntent.addFlags(268435456);
        }
        StartActivityManager.startActivity(context, smartPermissionIntent);
    }

    public XXPermissions permission(@Nullable String[]... strArr) {
        return permission(PermissionUtils.asArrayLists(strArr));
    }

    public XXPermissions permission(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!PermissionUtils.containsPermission(this.mPermissions, str)) {
                    this.mPermissions.add(str);
                }
            }
        }
        return this;
    }

    public static void startPermissionActivity(@NonNull Activity activity) {
        startPermissionActivity(activity, (List<String>) new ArrayList(0));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String[]... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list) {
        startPermissionActivity(activity, list, 1025);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list, int i) {
        StartActivityManager.startActivityForResult(activity, PermissionApi.getSmartPermissionIntent(activity, list), i);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String str, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(activity, PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String[] strArr, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(activity, PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        if (list.isEmpty()) {
            StartActivityManager.startActivity(activity, PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            PermissionPageFragment.launch(activity, list, onPermissionPageCallback);
        }
    }

    public static void startPermissionActivity(@NonNull Fragment fragment) {
        startPermissionActivity(fragment, new ArrayList(0));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String[]... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list) {
        startPermissionActivity(fragment, list, 1025);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list, int i) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            StartActivityManager.startActivity(fragment, PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            StartActivityManager.startActivityForResult(fragment, PermissionApi.getSmartPermissionIntent(activity, list), i);
        }
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String str, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String[] strArr, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        Activity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (AndroidVersion.isAndroid4_2() && activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            StartActivityManager.startActivity(fragment, PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            PermissionPageFragment.launch(activity, list, onPermissionPageCallback);
        }
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment) {
        startPermissionActivity(fragment, new ArrayList());
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String[]... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list) {
        startPermissionActivity(fragment, list, 1025);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list, int i) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            StartActivityManager.startActivity(fragment, PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            StartActivityManager.startActivityForResult(fragment, PermissionApi.getSmartPermissionIntent(activity, list), i);
        }
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String str, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String[] strArr, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (AndroidVersion.isAndroid4_2() && activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            StartActivityManager.startActivity(fragment, PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            PermissionPageFragment.launch(activity, list, onPermissionPageCallback);
        }
    }
}
