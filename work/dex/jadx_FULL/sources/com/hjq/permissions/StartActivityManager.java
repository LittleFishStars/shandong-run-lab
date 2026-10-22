package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class StartActivityManager {
    private static final String SUB_INTENT_KEY = "sub_intent_key";

    public interface StartActivityDelegate {
        void startActivity(@NonNull Intent intent);

        void startActivityForResult(@NonNull Intent intent, int i);
    }

    public static class StartActivityDelegateActivityImpl implements StartActivityDelegate {
        private final Activity mActivity;

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivity(@NonNull Intent intent) {
            this.mActivity.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivityForResult(@NonNull Intent intent, int i) {
            this.mActivity.startActivityForResult(intent, i);
        }

        private StartActivityDelegateActivityImpl(@NonNull Activity activity) {
            this.mActivity = activity;
        }
    }

    public static class StartActivityDelegateContextImpl implements StartActivityDelegate {
        private final Context mContext;

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivity(@NonNull Intent intent) {
            this.mContext.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivityForResult(@NonNull Intent intent, int i) {
            Activity activityFindActivity = PermissionUtils.findActivity(this.mContext);
            if (activityFindActivity != null) {
                activityFindActivity.startActivityForResult(intent, i);
            } else {
                startActivity(intent);
            }
        }

        private StartActivityDelegateContextImpl(@NonNull Context context) {
            this.mContext = context;
        }
    }

    public static class StartActivityDelegateFragmentImpl implements StartActivityDelegate {
        private final Fragment mFragment;

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivity(@NonNull Intent intent) {
            this.mFragment.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivityForResult(@NonNull Intent intent, int i) {
            this.mFragment.startActivityForResult(intent, i);
        }

        private StartActivityDelegateFragmentImpl(@NonNull Fragment fragment) {
            this.mFragment = fragment;
        }
    }

    public static class StartActivityDelegateSupportFragmentImpl implements StartActivityDelegate {
        private final androidx.fragment.app.Fragment mFragment;

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivity(@NonNull Intent intent) {
            this.mFragment.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.StartActivityDelegate
        public void startActivityForResult(@NonNull Intent intent, int i) {
            this.mFragment.startActivityForResult(intent, i);
        }

        private StartActivityDelegateSupportFragmentImpl(@NonNull androidx.fragment.app.Fragment fragment) {
            this.mFragment = fragment;
        }
    }

    public static Intent addSubIntentToMainIntent(@Nullable Intent intent, @Nullable Intent intent2) {
        if (intent == null && intent2 != null) {
            return intent2;
        }
        if (intent2 == null) {
            return intent;
        }
        getDeepSubIntent(intent).putExtra(SUB_INTENT_KEY, intent2);
        return intent;
    }

    public static Intent getDeepSubIntent(@NonNull Intent intent) {
        Intent subIntentInSuperIntent = getSubIntentInSuperIntent(intent);
        return subIntentInSuperIntent != null ? getDeepSubIntent(subIntentInSuperIntent) : intent;
    }

    public static Intent getSubIntentInSuperIntent(@NonNull Intent intent) {
        return AndroidVersion.isAndroid13() ? (Intent) intent.getParcelableExtra(SUB_INTENT_KEY, Intent.class) : (Intent) intent.getParcelableExtra(SUB_INTENT_KEY);
    }

    public static boolean startActivity(@NonNull Context context, Intent intent) {
        return startActivity(new StartActivityDelegateContextImpl(context), intent);
    }

    public static boolean startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i) {
        return startActivityForResult(new StartActivityDelegateActivityImpl(activity), intent, i);
    }

    public static boolean startActivity(@NonNull Activity activity, Intent intent) {
        return startActivity(new StartActivityDelegateActivityImpl(activity), intent);
    }

    public static boolean startActivityForResult(@NonNull Fragment fragment, @NonNull Intent intent, int i) {
        return startActivityForResult(new StartActivityDelegateFragmentImpl(fragment), intent, i);
    }

    public static boolean startActivity(@NonNull Fragment fragment, Intent intent) {
        return startActivity(new StartActivityDelegateFragmentImpl(fragment), intent);
    }

    public static boolean startActivityForResult(@NonNull androidx.fragment.app.Fragment fragment, @NonNull Intent intent, int i) {
        return startActivityForResult(new StartActivityDelegateSupportFragmentImpl(fragment), intent, i);
    }

    public static boolean startActivity(@NonNull androidx.fragment.app.Fragment fragment, Intent intent) {
        return startActivity(new StartActivityDelegateSupportFragmentImpl(fragment), intent);
    }

    public static boolean startActivityForResult(@NonNull StartActivityDelegate startActivityDelegate, @NonNull Intent intent, int i) {
        try {
            startActivityDelegate.startActivityForResult(intent, i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent subIntentInSuperIntent = getSubIntentInSuperIntent(intent);
            if (subIntentInSuperIntent == null) {
                return false;
            }
            return startActivityForResult(startActivityDelegate, subIntentInSuperIntent, i);
        }
    }

    public static boolean startActivity(@NonNull StartActivityDelegate startActivityDelegate, @NonNull Intent intent) {
        try {
            startActivityDelegate.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent subIntentInSuperIntent = getSubIntentInSuperIntent(intent);
            if (subIntentInSuperIntent == null) {
                return false;
            }
            return startActivity(startActivityDelegate, subIntentInSuperIntent);
        }
    }
}
