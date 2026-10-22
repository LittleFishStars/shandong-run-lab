package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.ali.auth.third.login.LoginConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f23134a;
    public static ImageView b;
    public static TextView c;
    public static TextView d;
    public static TextView e;
    public static TextView f;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23135a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack d;

        public a(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23135a = activity;
            this.b = str;
            this.c = str2;
            this.d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q0.a(this.f23135a, q0.f23134a);
            q2.b().a(this.b + LoginConstants.UNDER_LINE + this.c + "_close");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.d;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23136a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack d;

        public b(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23136a = activity;
            this.b = str;
            this.c = str2;
            this.d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q0.a(this.f23136a, q0.f23134a);
            q2.b().a(this.b + LoginConstants.UNDER_LINE + this.c + "_open");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.d;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23137a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack d;

        public c(String str, String str2, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23137a = str;
            this.b = str2;
            this.c = activity;
            this.d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q2.b().a(this.f23137a + LoginConstants.UNDER_LINE + this.b + "_dismiss");
            q0.a(this.c, q0.f23134a);
            AcseHelpManager.OnClickCallBack onClickCallBack = this.d;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
        }
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.custon_dialog, (ViewGroup) null);
        b = (ImageView) viewInflate.findViewById(R.id.iv_dismiss);
        c = (TextView) viewInflate.findViewById(R.id.tv_button);
        d = (TextView) viewInflate.findViewById(R.id.tv_but2);
        e = (TextView) viewInflate.findViewById(R.id.tv_content);
        f = (TextView) viewInflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str3)) {
            d.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            c.setText(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            e.setText(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            f.setText(str);
        }
        h0.a().b(activity, d);
        c.setOnClickListener(new a(activity, str3, str4, onClickCallBack));
        d.setOnClickListener(new b(activity, str3, str4, onClickCallBack));
        b.setOnClickListener(new c(str3, str4, activity, onClickCallBack));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        f23134a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f23134a);
        return f23134a;
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception unused) {
        }
    }
}
