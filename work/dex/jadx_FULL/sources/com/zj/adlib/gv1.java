package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class gv1 {
    @Nullable
    public static FragmentActivity a(Context context) {
        Activity activity = getActivity(context);
        if (activity == null || !(activity instanceof FragmentActivity)) {
            return null;
        }
        return (FragmentActivity) activity;
    }

    @Nullable
    public static FragmentManager b(Context context) {
        FragmentActivity fragmentActivityA = a(context);
        if (fragmentActivityA != null) {
            return fragmentActivityA.getSupportFragmentManager();
        }
        return null;
    }

    @Nullable
    public static Activity getActivity(View view) {
        if (view == null) {
            return null;
        }
        return getActivity(view.getContext());
    }

    @Nullable
    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                return (Activity) ((ContextWrapper) context).getBaseContext();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
