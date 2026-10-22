package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.SeedWebViewActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f23016a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f23017a;
        public final /* synthetic */ Activity b;

        public a(e eVar, Activity activity) {
            this.f23017a = eVar;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f23017a.onOpen();
            g4.a(this.b, g4.f23016a);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23018a;

        public b(Activity activity) {
            this.f23018a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g4.a(this.f23018a, g4.f23016a);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23019a;

        public c(Activity activity) {
            this.f23019a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f23019a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().c(this.f23019a));
            this.f23019a.startActivity(intent);
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23020a;

        public d(Activity activity) {
            this.f23020a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f23020a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().e(this.f23020a));
            this.f23020a.startActivity(intent);
        }
    }

    public interface e {
        void onDismiss();

        void onOpen();
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

    public static AlertDialog a(Activity activity, e eVar) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.main_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_but2);
        textView.setOnClickListener(new a(eVar, activity));
        ((TextView) viewInflate.findViewById(R.id.tv_button)).setOnClickListener(new b(activity));
        ((TextView) viewInflate.findViewById(R.id.title)).setText("请先同意" + l0.b);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_privacy);
        textView2.setOnClickListener(new c(activity));
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_service);
        textView3.setOnClickListener(new d(activity));
        h0.a().e(activity, textView3);
        h0.a().e(activity, textView2);
        h0.a().e(activity, textView);
        AlertDialog alertDialogCreate = builder.create();
        f23016a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f23016a);
        return f23016a;
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
