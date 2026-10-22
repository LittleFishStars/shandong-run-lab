package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class PermissionPageFragment extends Fragment implements Runnable {
    private static final String REQUEST_PERMISSIONS = "request_permissions";

    @Nullable
    private OnPermissionPageCallback mCallBack;
    private boolean mRequestFlag;
    private boolean mStartActivityFlag;

    public static void launch(@NonNull Activity activity, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        PermissionPageFragment permissionPageFragment = new PermissionPageFragment();
        Bundle bundle = new Bundle();
        if (list instanceof ArrayList) {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, (ArrayList) list);
        } else {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, new ArrayList<>(list));
        }
        permissionPageFragment.setArguments(bundle);
        permissionPageFragment.setRetainInstance(true);
        permissionPageFragment.setRequestFlag(true);
        permissionPageFragment.setOnPermissionPageCallback(onPermissionPageCallback);
        permissionPageFragment.attachByActivity(activity);
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
        if (i != 1025) {
            return;
        }
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        PermissionUtils.postActivityResult(stringArrayList, this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachByActivity(getActivity());
            return;
        }
        if (this.mStartActivityFlag) {
            return;
        }
        this.mStartActivityFlag = true;
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        StartActivityManager.startActivityForResult(this, PermissionApi.getSmartPermissionIntent(getActivity(), arguments.getStringArrayList(REQUEST_PERMISSIONS)), 1025);
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        if (isAdded() && (activity = getActivity()) != null) {
            OnPermissionPageCallback onPermissionPageCallback = this.mCallBack;
            this.mCallBack = null;
            if (onPermissionPageCallback == null) {
                detachByActivity(activity);
                return;
            }
            ArrayList<String> stringArrayList = getArguments().getStringArrayList(REQUEST_PERMISSIONS);
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                return;
            }
            if (PermissionApi.getGrantedPermissions(activity, stringArrayList).size() == stringArrayList.size()) {
                onPermissionPageCallback.onGranted();
            } else {
                onPermissionPageCallback.onDenied();
            }
            detachByActivity(activity);
        }
    }

    public void setOnPermissionPageCallback(@Nullable OnPermissionPageCallback onPermissionPageCallback) {
        this.mCallBack = onPermissionPageCallback;
    }

    public void setRequestFlag(boolean z) {
        this.mRequestFlag = z;
    }
}
