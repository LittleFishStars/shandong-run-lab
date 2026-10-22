package com.hjq.permissions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class AndroidManifestInfo {

    @Nullable
    ApplicationInfo applicationInfo;
    String packageName;

    @Nullable
    UsesSdkInfo usesSdkInfo;

    @NonNull
    final List<PermissionInfo> permissionInfoList = new ArrayList();

    @NonNull
    final List<ActivityInfo> activityInfoList = new ArrayList();

    @NonNull
    final List<ServiceInfo> serviceInfoList = new ArrayList();

    public static final class ActivityInfo {
        String name;
        boolean supportsPictureInPicture;
    }

    public static final class ApplicationInfo {
        String name;
        boolean requestLegacyExternalStorage;
    }

    public static final class PermissionInfo {
        private static final int REQUESTED_PERMISSION_NEVER_FOR_LOCATION;
        int maxSdkVersion;
        String name;
        int usesPermissionFlags;

        static {
            if (AndroidVersion.isAndroid12()) {
                REQUESTED_PERMISSION_NEVER_FOR_LOCATION = 65536;
            } else {
                REQUESTED_PERMISSION_NEVER_FOR_LOCATION = 65536;
            }
        }

        public boolean neverForLocation() {
            return (this.usesPermissionFlags & REQUESTED_PERMISSION_NEVER_FOR_LOCATION) != 0;
        }
    }

    public static final class ServiceInfo {
        String name;
        String permission;
    }

    public static final class UsesSdkInfo {
        int minSdkVersion;
    }
}
