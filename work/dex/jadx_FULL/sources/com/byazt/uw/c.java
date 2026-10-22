package com.byazt.uw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.ou.u;
import com.byazt.su.DownloadModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1715, 20})
public class c implements u {
    @Override // com.byazt.ou.u
    public void c(int i, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.byazt.ou.u
    public Dialog tt(@NonNull com.byazt.e.tt ttVar) {
        return c(ttVar);
    }

    private static Dialog c(final com.byazt.e.tt ttVar) {
        if (ttVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(ttVar.c).setTitle(ttVar.tt).setMessage(ttVar.ve).setPositiveButton(ttVar.uj, new DialogInterface.OnClickListener() { // from class: com.byazt.uw.c.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.byazt.e.tt.InterfaceC0394tt interfaceC0394tt = ttVar.x;
                if (interfaceC0394tt != null) {
                    interfaceC0394tt.c(dialogInterface);
                }
            }
        }).setNegativeButton(ttVar.n, new DialogInterface.OnClickListener() { // from class: com.byazt.uw.c.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.byazt.e.tt.InterfaceC0394tt interfaceC0394tt = ttVar.x;
                if (interfaceC0394tt != null) {
                    interfaceC0394tt.tt(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(ttVar.f28440a);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.uw.c.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                com.byazt.e.tt.InterfaceC0394tt interfaceC0394tt = ttVar.x;
                if (interfaceC0394tt != null) {
                    interfaceC0394tt.ve(dialogInterface);
                }
            }
        });
        Drawable drawable = ttVar.sp;
        if (drawable != null) {
            alertDialogShow.setIcon(drawable);
        }
        return alertDialogShow;
    }
}
