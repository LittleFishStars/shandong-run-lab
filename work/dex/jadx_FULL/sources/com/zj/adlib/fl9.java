package com.zj.adlib;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.ViewModelProvider;
import androidx.p002lifecycle.ViewModelStoreOwner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class fl9 {
    public static Activity a(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    public static Application b(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    @NonNull
    @MainThread
    public static ViewModelProvider c(@NonNull Fragment fragment) {
        return new ViewModelProvider(fragment.getViewModelStore(), ViewModelProvider.AndroidViewModelFactory.getInstance(b(a(fragment))));
    }

    @NonNull
    @MainThread
    public static ViewModelProvider d(@NonNull Fragment fragment, @NonNull ViewModelProvider.Factory factory) {
        b(a(fragment));
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider e(@NonNull FragmentActivity activity) {
        return new ViewModelProvider(activity.getViewModelStore(), ViewModelProvider.AndroidViewModelFactory.getInstance(b(activity)));
    }

    @NonNull
    @MainThread
    public static ViewModelProvider f(@NonNull FragmentActivity activity, @NonNull ViewModelProvider.Factory factory) {
        b(activity);
        return new ViewModelProvider(activity.getViewModelStore(), factory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @MainThread
    public static ViewModelProvider g(@NonNull Activity activity) {
        Application applicationB = b(activity);
        if (applicationB instanceof ViewModelStoreOwner) {
            return new ViewModelProvider((ViewModelStoreOwner) applicationB, ViewModelProvider.AndroidViewModelFactory.getInstance(applicationB));
        }
        return null;
    }

    @NonNull
    @MainThread
    public static ViewModelProvider h(@NonNull Activity activity, @NonNull ViewModelProvider.Factory factory) {
        ComponentCallbacks2 componentCallbacks2B = b(activity);
        if (componentCallbacks2B instanceof ViewModelStoreOwner) {
            return new ViewModelProvider((ViewModelStoreOwner) componentCallbacks2B, factory);
        }
        return null;
    }

    public static ViewModelProvider i(@NonNull Fragment fragment) {
        return g(a(fragment));
    }

    public static ViewModelProvider j(@NonNull Fragment fragment, @NonNull ViewModelProvider.Factory factory) {
        return h(a(fragment), factory);
    }
}
