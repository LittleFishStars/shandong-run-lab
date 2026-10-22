package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f23067a;
    public static ImageView b;
    public static TextView c;
    public static TextView d;
    public static TextView e;
    public static TextView f;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f23068a;
        public final /* synthetic */ Activity b;

        public a(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f23068a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j4.d.getVisibility() == 0) {
                AcseHelpManager.OnClickCallBack onClickCallBack = this.f23068a;
                if (onClickCallBack != null) {
                    onClickCallBack.onDismiss();
                }
            } else {
                AcseHelpManager.OnClickCallBack onClickCallBack2 = this.f23068a;
                if (onClickCallBack2 != null) {
                    onClickCallBack2.onOpen();
                }
            }
            j4.a(this.b, j4.f23067a);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f23069a;
        public final /* synthetic */ Activity b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f23069a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q2.b().a("warning_start_run");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f23069a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            j4.a(this.b, j4.f23067a);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f23070a;
        public final /* synthetic */ Activity b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f23070a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f23070a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            j4.a(this.b, j4.f23067a);
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.shandong_warning_dialog, (ViewGroup) null);
        b = (ImageView) viewInflate.findViewById(R.id.iv_dismiss);
        c = (TextView) viewInflate.findViewById(R.id.tv_button);
        d = (TextView) viewInflate.findViewById(R.id.tv_but2);
        e = (TextView) viewInflate.findViewById(R.id.tv_content);
        f = (TextView) viewInflate.findViewById(R.id.tv_version_info);
        d.setVisibility(0);
        c.setTextColor(Color.parseColor("#999999"));
        c.setBackground(null);
        h0.a().a(activity, f, e);
        h0.a().a(activity, (TextView) null, c);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            f.setText(activity.getString(R.string.warning_dialog_title));
            if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
                e.setText(activity.getString(R.string.sd_warning_message));
                c.setText("继续开启权限");
            } else {
                e.setText(activity.getString(R.string.warning_message));
                c.setText(activity.getString(R.string.warning_commit));
            }
            d.setText(activity.getString(R.string.warning_cancle));
        } else {
            d.setText(str3);
            c.setText(str4);
            e.setText(str2);
            f.setText(str);
        }
        h0.a().f(activity, d);
        c.setOnClickListener(new a(onClickCallBack, activity));
        d.setOnClickListener(new b(onClickCallBack, activity));
        b.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        f23067a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f23067a);
        return f23067a;
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
