package com.byazt.dk;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 158})
public class sl {

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 925})
    public static class c implements DialogInterface {
        private c() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }

    private static AlertDialog c(Activity activity, final com.byazt.dk.c cVar) {
        return new com.byazt.sgn.da(activity).c(cVar.c).tt(cVar.tt).ve(cVar.ve).uj(cVar.uj).c(cVar.n).c(new com.byazt.sgn.da.c() { // from class: com.byazt.dk.sl.2
            @Override // com.byazt.sgn.da.c
            public void c(Dialog dialog) {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.c(dialog);
                }
            }

            @Override // com.byazt.sgn.da.c
            public void tt(Dialog dialog) {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.tt(dialog);
                }
            }
        }).c(new DialogInterface.OnCancelListener() { // from class: com.byazt.dk.sl.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.ve(dialogInterface);
                }
            }
        });
    }

    public static void c(WeakReference<Context> weakReference, boolean z, final com.byazt.dk.c cVar) {
        com.byazt.aas.n.c cVar2 = new com.byazt.aas.n.c() { // from class: com.byazt.dk.sl.3
            @Override // com.byazt.aas.n.c
            public void c() {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.c(new c());
                }
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.tt(new c());
                }
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.ve(new c());
                }
            }
        };
        if (z) {
            com.byazt.aas.n.c(weakReference.get(), String.valueOf(cVar.hashCode()), cVar.c, cVar.tt, cVar.ve, cVar.uj, cVar2);
        } else {
            com.byazt.aas.n.c(weakReference.get(), String.valueOf(cVar.hashCode()), cVar.c, cVar.tt, cVar2);
        }
    }

    public static AlertDialog c(Activity activity, boolean z, com.byazt.dk.c cVar) {
        if (z) {
            AlertDialog alertDialogC = c(activity, cVar);
            if (activity != null && !activity.isFinishing()) {
                alertDialogC.show();
            }
            return alertDialogC;
        }
        return c(activity, R.style.Theme.DeviceDefault.Light.Dialog, cVar);
    }

    private static AlertDialog c(Activity activity, int i, final com.byazt.dk.c cVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(cVar.c).setMessage(cVar.tt).setPositiveButton(cVar.ve, new DialogInterface.OnClickListener() { // from class: com.byazt.dk.sl.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.c(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.uj, new DialogInterface.OnClickListener() { // from class: com.byazt.dk.sl.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.tt(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.dk.sl.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                tt ttVar = cVar.f28411a;
                if (ttVar != null) {
                    ttVar.ve(dialogInterface);
                }
            }
        });
        Drawable drawable = cVar.n;
        if (drawable != null) {
            onCancelListener.setIcon(drawable);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }
}
