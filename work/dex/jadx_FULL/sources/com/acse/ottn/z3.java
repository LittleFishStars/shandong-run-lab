package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f23312a;
    public static TextView b;
    public static TextView c;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23313a;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack b;

        public a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23313a = activity;
            this.b = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z3.a(this.f23313a, z3.f23312a);
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f23313a, 10010);
            this.b.onOpen();
        }
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23314a;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack b;

        public b(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23314a = activity;
            this.b = onClickCallBack;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            z3.c.setText(((j / 1000) - 1) + "秒");
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            if (this.f23314a.isFinishing() || !z3.f23312a.isShowing()) {
                return;
            }
            z3.a(this.f23314a, z3.f23312a);
            this.b.onDismiss();
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23315a;
        public final /* synthetic */ AcseHelpManager.OnClickCallBack b;

        public c(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f23315a = activity;
            this.b = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z3.a(this.f23315a, z3.f23312a);
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f23315a, 10010);
            this.b.onOpen();
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.save_monery_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        Spanned spannedFromHtml = Html.fromHtml("<b><big><big><big><font color=#4D230A> 购物省钱神器</font></big></big></big></b><font color=#90713A>  体验机会</font>");
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_content);
        b = textView;
        textView.setText(spannedFromHtml);
        ((TextView) viewInflate.findViewById(R.id.tv_content2)).setText("自动发现隐藏优惠券,淘宝、京东最高省80%!");
        c = (TextView) viewInflate.findViewById(R.id.iv_dismiss);
        viewInflate.findViewById(R.id.rl_content).setOnClickListener(new a(activity, onClickCallBack));
        n0.a().b(11000, 1000, new b(activity, onClickCallBack));
        viewInflate.findViewById(R.id.tv_open).setOnClickListener(new c(activity, onClickCallBack));
        AlertDialog alertDialogCreate = builder.create();
        f23312a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f23312a);
        return f23312a;
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
