package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
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
public class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f23280a;
    public static ImageView b;
    public static TextView c;
    public static TextView d;
    public static ImageView e;
    public static ImageView f;
    public static RelativeLayout g;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f23281a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack c;

        public a(boolean z, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23281a = z;
            this.b = activity;
            this.c = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f23281a) {
                try {
                    w3.f23280a.dismiss();
                } catch (Exception unused) {
                }
                c5.a(this.b, this.c);
                return;
            }
            q2.b().a("not_now");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.c;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
            try {
                w3.f23280a.dismiss();
            } catch (Exception unused2) {
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f23282a;
        public final /* synthetic */ Activity b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f23282a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q2.b().a("not_now");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f23282a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            w3.a(this.b, w3.f23280a);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f23283a;
        public final /* synthetic */ Activity b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f23283a = onClickCallBack;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f23283a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            q2.b().a("click_now_start");
            w3.a(this.b, w3.f23280a);
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

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, str, str2, str3, str4, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, boolean z, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, z, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, boolean z, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.seeding_running_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(activity.getString(R.string.invite_title));
        }
        b = (ImageView) viewInflate.findViewById(R.id.iv_dismiss);
        d = (TextView) viewInflate.findViewById(R.id.tv_but2);
        if (!TextUtils.isEmpty(str3)) {
            d.setText(str3);
        } else {
            d.setText(activity.getString(R.string.invite_commit));
        }
        q2.b().a("show_run_dialog");
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_icon);
        e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        c = (TextView) viewInflate.findViewById(R.id.tv_button);
        f = (ImageView) viewInflate.findViewById(R.id.iv_icon1);
        g = (RelativeLayout) viewInflate.findViewById(R.id.rl_bg);
        h0.a().a(activity, (RelativeLayout) viewInflate.findViewById(R.id.rl_b));
        if (!TextUtils.isEmpty(str4)) {
            c.setText(str4);
        } else {
            c.setText(activity.getString(R.string.invite_cancle));
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(str2);
        } else if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            textView2.setText(activity.getString(R.string.invite_message));
        } else {
            textView2.setText("请先开启必要权限，以便于持续稳定，准确完整地记录您运动期间的数据！");
        }
        h0.a().c(activity, c);
        h0.a().b(activity, d);
        h0.a().a(activity, e, f);
        h0.a().a(activity, textView, textView2);
        h0.a().a(activity, (TextView) null, c);
        c.setOnClickListener(new a(z, activity, onClickCallBack));
        b.setOnClickListener(new b(onClickCallBack, activity));
        d.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        f23280a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f23280a);
        return f23280a;
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
}
