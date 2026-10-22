package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f22909a;
    public static ImageView b;
    public static ImageView c;
    public static TextView d;
    public static TextView e;
    public static TextView f;
    public static TextView g;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f22910a;
        public final /* synthetic */ Activity b;

        public a(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f22910a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c5.e.getVisibility() == 0) {
                AcseHelpManager.OnClickCallBack onClickCallBack = this.f22910a;
                if (onClickCallBack != null) {
                    onClickCallBack.onDismiss();
                }
            } else {
                AcseHelpManager.OnClickCallBack onClickCallBack2 = this.f22910a;
                if (onClickCallBack2 != null) {
                    onClickCallBack2.onOpen();
                }
            }
            c5.a(this.b, c5.f22909a);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f22911a;
        public final /* synthetic */ Activity b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f22911a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q2.b().a("warning_start_run");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f22911a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            c5.a(this.b, c5.f22909a);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f22912a;
        public final /* synthetic */ Activity b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f22912a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f22912a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            c5.a(this.b, c5.f22909a);
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.warning_dialog, (ViewGroup) null);
        b = (ImageView) viewInflate.findViewById(R.id.iv_dismiss);
        d = (TextView) viewInflate.findViewById(R.id.tv_button);
        e = (TextView) viewInflate.findViewById(R.id.tv_but2);
        c = (ImageView) viewInflate.findViewById(R.id.iv_icon);
        f = (TextView) viewInflate.findViewById(R.id.tv_content);
        g = (TextView) viewInflate.findViewById(R.id.tv_version_info);
        e.setVisibility(0);
        d.setTextColor(Color.parseColor("#999999"));
        d.setBackground(null);
        h0.a().a(activity, (RelativeLayout) viewInflate.findViewById(R.id.rl_bg));
        h0.a().a(activity, g, f);
        h0.a().a(activity, (TextView) null, d);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            g.setText(activity.getString(R.string.warning_dialog_title));
            if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
                f.setText(activity.getString(R.string.sd_warning_message));
                d.setText("继续开启权限");
            } else {
                f.setText(activity.getString(R.string.warning_message));
                d.setText(activity.getString(R.string.warning_commit));
            }
            e.setText(activity.getString(R.string.warning_cancle));
        } else {
            e.setText(str3);
            d.setText(str4);
            f.setText(str2);
            g.setText(str);
        }
        h0.a().f(activity, e);
        h0.a().b(activity, c);
        d.setOnClickListener(new a(onClickCallBack, activity));
        e.setOnClickListener(new b(onClickCallBack, activity));
        b.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        f22909a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f22909a);
        return f22909a;
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
