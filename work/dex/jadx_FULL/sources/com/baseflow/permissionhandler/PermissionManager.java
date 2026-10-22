package com.baseflow.permissionhandler;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.hjq.permissions.Permission;
import com.zj.adlib.go6;
import com.zj.adlib.wo6;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class PermissionManager implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Activity f26841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Context f1225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public RequestPermissionsSuccessCallback f1226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<Integer, Integer> f1227a;

    @FunctionalInterface
    public interface CheckPermissionsSuccessCallback {
        void onSuccess(int i);
    }

    @FunctionalInterface
    public interface RequestPermissionsSuccessCallback {
        void onSuccess(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    public interface ShouldShowRequestPermissionRationaleSuccessCallback {
        void onSuccess(boolean z);
    }

    public PermissionManager(@NonNull Context context) {
        this.f1225a = context;
    }

    public final int a() {
        List<String> listC = wo6.c(this.f1225a, 21);
        if (!(listC == null || listC.isEmpty())) {
            return 1;
        }
        Log.d(go6.f16832a, "Bluetooth permission missing in manifest");
        return 0;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 33) {
            return NotificationManagerCompat.from(this.f1225a).areNotificationsEnabled() ? 1 : 0;
        }
        if (this.f1225a.checkSelfPermission(Permission.POST_NOTIFICATIONS) == 0) {
            return 1;
        }
        return wo6.b(this.f26841a, Permission.POST_NOTIFICATIONS);
    }

    public void c(int i, CheckPermissionsSuccessCallback checkPermissionsSuccessCallback) {
        checkPermissionsSuccessCallback.onSuccess(d(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int d(int i) {
        if (i == 17) {
            return b();
        }
        if (i == 21) {
            return a();
        }
        if ((i == 30 || i == 28 || i == 29) && Build.VERSION.SDK_INT < 31) {
            return a();
        }
        if ((i == 37 || i == 0) && !e()) {
            return 0;
        }
        List<String> listC = wo6.c(this.f1225a, i);
        if (listC == null) {
            Log.d(go6.f16832a, "No android specific permissions needed for: " + i);
            return 1;
        }
        if (listC.size() == 0) {
            Log.d(go6.f16832a, "No permissions found in manifest for: " + listC + i);
            return (i != 22 || Build.VERSION.SDK_INT >= 30) ? 0 : 2;
        }
        if ((this.f1225a.getApplicationInfo().targetSdkVersion >= 23) != false) {
            HashSet hashSet = new HashSet();
            for (String str : listC) {
                if (i == 16) {
                    String packageName = this.f1225a.getPackageName();
                    PowerManager powerManager = (PowerManager) this.f1225a.getSystemService("power");
                    if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                        hashSet.add(0);
                    } else {
                        hashSet.add(1);
                    }
                } else if (i == 22) {
                    if (Build.VERSION.SDK_INT < 30) {
                        hashSet.add(2);
                    }
                    hashSet.add(Integer.valueOf(Environment.isExternalStorageManager() ? 1 : 0));
                } else if (i == 23) {
                    hashSet.add(Integer.valueOf(Settings.canDrawOverlays(this.f1225a) ? 1 : 0));
                } else if (i == 24) {
                    hashSet.add(Integer.valueOf(this.f1225a.getPackageManager().canRequestPackageInstalls() ? 1 : 0));
                } else if (i == 27) {
                    hashSet.add(Integer.valueOf(((NotificationManager) this.f1225a.getSystemService("notification")).isNotificationPolicyAccessGranted() ? 1 : 0));
                } else if (i == 34) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        hashSet.add(Integer.valueOf(((AlarmManager) this.f1225a.getSystemService(NotificationCompat.CATEGORY_ALARM)).canScheduleExactAlarms() ? 1 : 0));
                    } else {
                        hashSet.add(1);
                    }
                } else if (i == 9 || i == 32) {
                    int iCheckSelfPermission = ContextCompat.checkSelfPermission(this.f1225a, str);
                    if ((Build.VERSION.SDK_INT >= 34 ? ContextCompat.checkSelfPermission(this.f1225a, Permission.READ_MEDIA_VISUAL_USER_SELECTED) : iCheckSelfPermission) == 0 && iCheckSelfPermission == -1) {
                        hashSet.add(3);
                    } else if (iCheckSelfPermission == 0) {
                        hashSet.add(1);
                    } else {
                        hashSet.add(Integer.valueOf(wo6.b(this.f26841a, str)));
                    }
                } else if (ContextCompat.checkSelfPermission(this.f1225a, str) != 0) {
                    hashSet.add(Integer.valueOf(wo6.b(this.f26841a, str)));
                }
            }
            if (!hashSet.isEmpty()) {
                return wo6.j(hashSet).intValue();
            }
        }
        return 1;
    }

    public final boolean e() {
        List<String> listC = wo6.c(this.f1225a, 37);
        boolean z = listC != null && listC.contains(Permission.WRITE_CALENDAR);
        boolean z2 = listC != null && listC.contains(Permission.READ_CALENDAR);
        if (z && z2) {
            return true;
        }
        if (!z) {
            Log.d(go6.f16832a, "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z2) {
            Log.d(go6.f16832a, "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    public final void f(String str, int i) {
        if (this.f26841a == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f26841a.getPackageName()));
        }
        this.f26841a.startActivityForResult(intent, i);
        this.K++;
    }

    public void g(@Nullable Activity activity) {
        this.f26841a = activity;
    }

    public void h(int i, ShouldShowRequestPermissionRationaleSuccessCallback shouldShowRequestPermissionRationaleSuccessCallback, ErrorCallback errorCallback) {
        Activity activity = this.f26841a;
        if (activity == null) {
            Log.d(go6.f16832a, "Unable to detect current Activity.");
            errorCallback.onError("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> listC = wo6.c(activity, i);
        if (listC == null) {
            Log.d(go6.f16832a, "No android specific permissions needed for: " + i);
            shouldShowRequestPermissionRationaleSuccessCallback.onSuccess(false);
            return;
        }
        if (!listC.isEmpty()) {
            shouldShowRequestPermissionRationaleSuccessCallback.onSuccess(ActivityCompat.shouldShowRequestPermissionRationale(this.f26841a, listC.get(0)));
            return;
        }
        Log.d(go6.f16832a, "No permissions found in manifest for: " + i + " no need to show request rationale");
        shouldShowRequestPermissionRationaleSuccessCallback.onSuccess(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int i3;
        int iCanScheduleExactAlarms;
        Activity activity = this.f26841a;
        boolean z = false;
        z = false;
        if (activity == null) {
            return false;
        }
        if (this.f1227a == null) {
            this.K = 0;
            return false;
        }
        if (i == 209) {
            String packageName = this.f1225a.getPackageName();
            PowerManager powerManager = (PowerManager) this.f1225a.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                z = true;
            }
            i3 = 16;
            iCanScheduleExactAlarms = z;
        } else if (i == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            i3 = 22;
            iCanScheduleExactAlarms = Environment.isExternalStorageManager();
        } else if (i == 211) {
            i3 = 23;
            iCanScheduleExactAlarms = Settings.canDrawOverlays(activity);
        } else if (i == 212) {
            i3 = 24;
            iCanScheduleExactAlarms = activity.getPackageManager().canRequestPackageInstalls();
        } else if (i == 213) {
            i3 = 27;
            iCanScheduleExactAlarms = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
        } else {
            if (i != 214) {
                return false;
            }
            i3 = 34;
            iCanScheduleExactAlarms = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM)).canScheduleExactAlarms() : true;
        }
        this.f1227a.put(Integer.valueOf(i3), Integer.valueOf(iCanScheduleExactAlarms));
        int i4 = this.K - 1;
        this.K = i4;
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback = this.f1226a;
        if (requestPermissionsSuccessCallback != null && i4 == 0) {
            requestPermissionsSuccessCallback.onSuccess(this.f1227a);
        }
        return true;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int iG;
        if (i != 24) {
            this.K = 0;
            return false;
        }
        if (this.f1227a == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            Log.w(go6.f16832a, "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
            return false;
        }
        List listAsList = Arrays.asList(strArr);
        int iIndexOf = listAsList.indexOf(Permission.WRITE_CALENDAR);
        if (iIndexOf >= 0) {
            int iK = wo6.k(this.f26841a, Permission.WRITE_CALENDAR, iArr[iIndexOf]);
            this.f1227a.put(36, Integer.valueOf(iK));
            int iIndexOf2 = listAsList.indexOf(Permission.READ_CALENDAR);
            if (iIndexOf2 >= 0) {
                int iIntValue = wo6.i(Integer.valueOf(iK), Integer.valueOf(wo6.k(this.f26841a, Permission.READ_CALENDAR, iArr[iIndexOf2]))).intValue();
                this.f1227a.put(37, Integer.valueOf(iIntValue));
                this.f1227a.put(0, Integer.valueOf(iIntValue));
            }
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (!str.equals(Permission.WRITE_CALENDAR) && !str.equals(Permission.READ_CALENDAR) && (iG = wo6.g(str)) != 20) {
                int i3 = iArr[i2];
                if (iG == 8) {
                    this.f1227a.put(8, wo6.i(this.f1227a.get(8), Integer.valueOf(wo6.k(this.f26841a, str, i3))));
                } else if (iG == 7) {
                    if (!this.f1227a.containsKey(7)) {
                        this.f1227a.put(7, Integer.valueOf(wo6.k(this.f26841a, str, i3)));
                    }
                    if (!this.f1227a.containsKey(14)) {
                        this.f1227a.put(14, Integer.valueOf(wo6.k(this.f26841a, str, i3)));
                    }
                } else if (iG == 4) {
                    int iK2 = wo6.k(this.f26841a, str, i3);
                    if (!this.f1227a.containsKey(4)) {
                        this.f1227a.put(4, Integer.valueOf(iK2));
                    }
                } else if (iG == 3) {
                    int iK3 = wo6.k(this.f26841a, str, i3);
                    if (Build.VERSION.SDK_INT < 29 && !this.f1227a.containsKey(4)) {
                        this.f1227a.put(4, Integer.valueOf(iK3));
                    }
                    if (!this.f1227a.containsKey(5)) {
                        this.f1227a.put(5, Integer.valueOf(iK3));
                    }
                    this.f1227a.put(Integer.valueOf(iG), Integer.valueOf(iK3));
                } else if (iG == 9 || iG == 32) {
                    this.f1227a.put(Integer.valueOf(iG), Integer.valueOf(d(iG)));
                } else if (!this.f1227a.containsKey(Integer.valueOf(iG))) {
                    this.f1227a.put(Integer.valueOf(iG), Integer.valueOf(wo6.k(this.f26841a, str, i3)));
                }
            }
        }
        int length = this.K - iArr.length;
        this.K = length;
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback = this.f1226a;
        if (requestPermissionsSuccessCallback == null || length != 0) {
            return true;
        }
        requestPermissionsSuccessCallback.onSuccess(this.f1227a);
        return true;
    }

    public void requestPermissions(List<Integer> list, RequestPermissionsSuccessCallback requestPermissionsSuccessCallback, ErrorCallback errorCallback) {
        if (this.K > 0) {
            errorCallback.onError("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
            return;
        }
        if (this.f26841a == null) {
            Log.d(go6.f16832a, "Unable to detect current Activity.");
            errorCallback.onError("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        this.f1226a = requestPermissionsSuccessCallback;
        this.f1227a = new HashMap();
        this.K = 0;
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            if (d(num.intValue()) != 1) {
                List<String> listC = wo6.c(this.f26841a, num.intValue());
                if (listC != null && !listC.isEmpty()) {
                    int i = Build.VERSION.SDK_INT;
                    if (num.intValue() == 16) {
                        f("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", 209);
                    } else if (i >= 30 && num.intValue() == 22) {
                        f("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", 210);
                    } else if (num.intValue() == 23) {
                        f("android.settings.action.MANAGE_OVERLAY_PERMISSION", 211);
                    } else if (num.intValue() == 24) {
                        f("android.settings.MANAGE_UNKNOWN_APP_SOURCES", 212);
                    } else if (num.intValue() == 27) {
                        f("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", 213);
                    } else if (i >= 31 && num.intValue() == 34) {
                        f("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", go6.g);
                    } else if (num.intValue() != 37 && num.intValue() != 0) {
                        arrayList.addAll(listC);
                        this.K += listC.size();
                    } else if (e()) {
                        arrayList.add(Permission.WRITE_CALENDAR);
                        arrayList.add(Permission.READ_CALENDAR);
                        this.K += 2;
                    } else {
                        this.f1227a.put(num, 0);
                    }
                } else if (!this.f1227a.containsKey(num)) {
                    num.intValue();
                    this.f1227a.put(num, 0);
                    if (num.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                        this.f1227a.put(num, 0);
                    } else {
                        this.f1227a.put(num, 2);
                    }
                }
            } else if (!this.f1227a.containsKey(num)) {
                this.f1227a.put(num, 1);
            }
        }
        if (arrayList.size() > 0) {
            ActivityCompat.requestPermissions(this.f26841a, (String[]) arrayList.toArray(new String[0]), 24);
        }
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback2 = this.f1226a;
        if (requestPermissionsSuccessCallback2 == null || this.K != 0) {
            return;
        }
        requestPermissionsSuccessCallback2.onSuccess(this.f1227a);
    }
}
