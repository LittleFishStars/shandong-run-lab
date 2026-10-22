package com.byazt.p;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.byazt.nr.m;
import com.byazt.s.yp;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 350, 15})
public class uj {
    public static final String c = "uj";
    public static List<yp> tt = new ArrayList();
    public static AlertDialog uj;
    public static com.byazt.y.c ve;

    private static boolean tt() {
        return ((NotificationManager) com.byazt.zz.ve.ic().getSystemService("notification")).areNotificationsEnabled();
    }

    public static boolean c() {
        try {
            return tt();
        } catch (Throwable th) {
            m.c(th);
            return true;
        }
    }

    public static synchronized void c(boolean z) {
        try {
            AlertDialog alertDialog = uj;
            if (alertDialog != null) {
                alertDialog.cancel();
                uj = null;
            }
            for (yp ypVar : tt) {
                if (ypVar != null) {
                    if (z) {
                        ypVar.c();
                    } else {
                        ypVar.tt();
                    }
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void tt(@NonNull Activity activity, @NonNull yp ypVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = c;
                    com.byazt.y.c cVar = (com.byazt.y.c) fragmentManager.findFragmentByTag(str);
                    ve = cVar;
                    if (cVar == null) {
                        ve = new com.byazt.y.c();
                        fragmentManager.beginTransaction().add(ve, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            m.c(th);
                        }
                    }
                    ve.c();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    m.c(th2);
                    ypVar.c();
                    return;
                } catch (Throwable th3) {
                    m.c(th3);
                    return;
                }
            }
        }
        ypVar.c();
    }

    public static synchronized void c(@NonNull final Activity activity, @NonNull final yp ypVar) {
        if (ypVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    tt.add(ypVar);
                    AlertDialog alertDialog = uj;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        uj = new AlertDialog.Builder(activity).setTitle("设置").setMessage("为了您能在方便地在通知栏控制下载任务，请到设置中开启通知，如果不需要可直接下载").setPositiveButton("去设置", new DialogInterface.OnClickListener() { // from class: com.byazt.p.uj.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                uj.tt(activity, ypVar);
                                dialogInterface.cancel();
                                AlertDialog unused = uj.uj = null;
                            }
                        }).setNegativeButton("立即下载", new DialogInterface.OnClickListener() { // from class: com.byazt.p.uj.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                uj.c(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.byazt.p.uj.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    uj.c(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable th) {
                m.c(th);
                c(false);
                return;
            }
        }
        ypVar.tt();
    }

    public static void c(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.byazt.k.c.c(i).tt("enable_target_34") <= 0 || c()) {
            return;
        }
        Context contextIc = com.byazt.zz.ve.ic();
        try {
            Intent intent = new Intent(contextIc, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(268435456);
            contextIc.startActivity(intent);
        } catch (Throwable th) {
            com.byazt.x.c.n(c, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
