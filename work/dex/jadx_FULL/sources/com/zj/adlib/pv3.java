package com.zj.adlib;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.igexin.push.config.c;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {com.google.android.gms.internal.base.zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class pv3 extends qv3 {

    @NonNull
    public static final String f = "com.google.android.gms";

    @GuardedBy("mLock")
    public String e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f18942a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pv3 f44065a = new pv3();
    public static final int b = qv3.f44306a;

    @NonNull
    public static final Task M(@NonNull HasApiKey hasApiKey, @NonNull HasApiKey... hasApiKeyArr) {
        yw6.m(hasApiKey, "Requested API must not be null.");
        for (HasApiKey hasApiKey2 : hasApiKeyArr) {
            yw6.m(hasApiKey2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return a.y().B(arrayList);
    }

    @NonNull
    public static pv3 x() {
        return f44065a;
    }

    public boolean A(@NonNull Activity activity, int i, int i2) {
        return B(activity, i, i2, null);
    }

    public boolean B(@NonNull Activity activity, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogT = t(activity, i, i2, onCancelListener);
        if (dialogT == null) {
            return false;
        }
        H(activity, dialogT, sv3.f19652d, onCancelListener);
        return true;
    }

    public void C(@NonNull Context context, int i) {
        I(context, i, null, g(context, i, 0, "n"));
    }

    public void D(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        I(context, connectionResult.getErrorCode(), null, w(context, connectionResult));
    }

    @Nullable
    public final Dialog E(@NonNull Context context, int i, zag zagVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(b2c.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strC = b2c.c(context, i);
        if (strC != null) {
            builder.setPositiveButton(strC, zagVar);
        }
        String strG = b2c.g(context, i);
        if (strG != null) {
            builder.setTitle(strG);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i)), new IllegalArgumentException());
        return builder.create();
    }

    @NonNull
    public final Dialog F(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(b2c.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        H(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    @Nullable
    public final zabx G(Context context, zabw zabwVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(zabwVar);
        zao.a(context, zabxVar, intentFilter);
        zabxVar.a(context);
        if (n(context, "com.google.android.gms")) {
            return zabxVar;
        }
        zabwVar.a();
        zabxVar.b();
        return null;
    }

    public final void H(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.b(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    public final void I(Context context, int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        int i2;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null), new IllegalArgumentException());
        if (i == 18) {
            J(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strF = b2c.f(context, i);
        String strE = b2c.e(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) yw6.l(context.getSystemService("notification"));
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strF).setStyle(new NotificationCompat.BigTextStyle().bigText(strE));
        if (cm2.k(context)) {
            yw6.r(is6.i());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (cm2.l(context)) {
                style.addAction(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strE);
        }
        if (is6.n()) {
            yw6.r(is6.n());
            synchronized (f18942a) {
                str2 = this.e;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String strB = b2c.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", strB, 4));
                } else if (!strB.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(strB);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            style.setChannelId(str2);
        }
        Notification notificationBuild = style.build();
        if (i == 1 || i == 2 || i == 3) {
            b.f5621a.set(false);
            i2 = b.c;
        } else {
            i2 = b.b;
        }
        notificationManager.notify(i2, notificationBuild);
    }

    public final void J(Context context) {
        new y1c(this, context).sendEmptyMessageDelayed(1, c.l);
    }

    public final boolean K(@NonNull Activity activity, @NonNull LifecycleFragment lifecycleFragment, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogE = E(activity, i, zag.c(lifecycleFragment, e(activity, i, "d"), 2), onCancelListener);
        if (dialogE == null) {
            return false;
        }
        H(activity, dialogE, sv3.f19652d, onCancelListener);
        return true;
    }

    public final boolean L(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i) {
        PendingIntent pendingIntentW;
        if (kb4.a(context) || (pendingIntentW = w(context, connectionResult)) == null) {
            return false;
        }
        I(context, connectionResult.getErrorCode(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentW, i, true), d5c.f41112a | 134217728));
        return true;
    }

    @Override // com.zj.adlib.qv3
    @ShowFirstParty
    @KeepForSdk
    public int c(@NonNull Context context) {
        return super.c(context);
    }

    @Override // com.zj.adlib.qv3
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent e(@Nullable Context context, int i, @Nullable String str) {
        return super.e(context, i, str);
    }

    @Override // com.zj.adlib.qv3
    @Nullable
    public PendingIntent f(@NonNull Context context, int i, int i2) {
        return super.f(context, i, i2);
    }

    @Override // com.zj.adlib.qv3
    @NonNull
    public final String h(int i) {
        return super.h(i);
    }

    @Override // com.zj.adlib.qv3
    @HideFirstParty
    public int j(@NonNull Context context) {
        return super.j(context);
    }

    @Override // com.zj.adlib.qv3
    @ShowFirstParty
    @KeepForSdk
    public int k(@NonNull Context context, int i) {
        return super.k(context, i);
    }

    @Override // com.zj.adlib.qv3
    public final boolean o(int i) {
        return super.o(i);
    }

    @NonNull
    public Task<Void> q(@NonNull GoogleApi<?> googleApi, @NonNull GoogleApi<?>... googleApiArr) {
        return M(googleApi, googleApiArr).w(new SuccessContinuation() { // from class: com.zj.adlib.a1c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task a(Object obj) {
                int i = pv3.b;
                return com.google.android.gms.tasks.a.e(null);
            }
        });
    }

    @NonNull
    public Task<Void> r(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        return M(hasApiKey, hasApiKeyArr).w(new SuccessContinuation() { // from class: com.zj.adlib.c0c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task a(Object obj) {
                int i = pv3.b;
                return com.google.android.gms.tasks.a.e(null);
            }
        });
    }

    @Nullable
    public Dialog s(@NonNull Activity activity, int i, int i2) {
        return t(activity, i, i2, null);
    }

    @Nullable
    public Dialog t(@NonNull Activity activity, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return E(activity, i, zag.a(activity, e(activity, i, "d"), i2), onCancelListener);
    }

    @Nullable
    public Dialog u(@NonNull Fragment fragment, int i, int i2) {
        return v(fragment, i, i2, null);
    }

    @Nullable
    public Dialog v(@NonNull Fragment fragment, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return E(fragment.requireContext(), i, zag.b(fragment, e(fragment.requireContext(), i, "d"), i2), onCancelListener);
    }

    @Nullable
    public PendingIntent w(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        return connectionResult.hasResolution() ? connectionResult.getResolution() : f(context, connectionResult.getErrorCode(), 0);
    }

    @NonNull
    @MainThread
    public Task<Void> y(@NonNull Activity activity) {
        int i = b;
        yw6.g("makeGooglePlayServicesAvailable must be called from the main thread");
        int iK = k(activity, i);
        if (iK == 0) {
            return com.google.android.gms.tasks.a.e(null);
        }
        i2c i2cVarQ = i2c.q(activity);
        i2cVarQ.p(new ConnectionResult(iK, null), 0);
        return i2cVarQ.r();
    }

    @TargetApi(26)
    public void z(@NonNull Context context, @NonNull String str) {
        if (is6.n()) {
            yw6.l(((NotificationManager) yw6.l(context.getSystemService("notification"))).getNotificationChannel(str));
        }
        synchronized (f18942a) {
            this.e = str;
        }
    }
}
