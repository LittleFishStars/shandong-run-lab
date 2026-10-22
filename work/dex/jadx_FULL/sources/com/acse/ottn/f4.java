package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.SeedWebViewActivity;
import com.acse.ottn.widget.ContinueSlideScrollView;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AlertDialog f22999a = null;
    public static ContinueSlideScrollView b = null;
    public static TimerTask c = null;
    public static final String d = "在使用“一键开启必要权限”服务前，请您仔细阅读我们的《用户协议》和《隐私政策》。请您知悉，您同意用户协议和隐私政策将代表您已了解我们提供的功能，以及功能运行所需的必要个人信息。我们在向您提供服务的过程中，除非单独获得您的同意和授权，否则将不会收集您的非必要个人信息。";
    public static final String e = "《用户协议》";
    public static final String f = "《隐私政策》";

    public class a implements ContinueSlideScrollView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f23000a;
        public final /* synthetic */ h b;
        public final /* synthetic */ Activity c;

        /* JADX INFO: renamed from: com.acse.ottn.f4$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0108a implements View.OnClickListener {
            public ViewOnClickListenerC0108a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b.onOpen();
                f4.a(a.this.c, f4.f22999a);
            }
        }

        public a(TextView textView, h hVar, Activity activity) {
            this.f23000a = textView;
            this.b = hVar;
            this.c = activity;
        }

        @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
        public void a() {
            if (f4.c != null) {
                f4.c.cancel();
                this.f23000a.setText("我已知晓并同意");
                this.f23000a.setOnClickListener(new ViewOnClickListenerC0108a());
                h0.a().e(this.c, this.f23000a);
            }
        }

        @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
        public void b() {
        }
    }

    public class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23002a;

        public b(Activity activity) {
            this.f23002a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f23002a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().e(this.f23002a));
            this.f23002a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            h0.a().a(this.f23002a, textPaint);
        }
    }

    public class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23003a;

        public c(Activity activity) {
            this.f23003a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f23003a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().c(this.f23003a));
            this.f23003a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            h0.a().a(this.f23003a, textPaint);
        }
    }

    public class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23004a;

        public d(Activity activity) {
            this.f23004a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f23004a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().d(this.f23004a));
            this.f23004a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            h0.a().a(this.f23004a, textPaint);
        }
    }

    public class e extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23005a;

        public e(Activity activity) {
            this.f23005a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f23005a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().b(this.f23005a));
            this.f23005a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            h0.a().a(this.f23005a, textPaint);
        }
    }

    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23008a;

        public g(Activity activity) {
            this.f23008a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f4.a(this.f23008a, f4.f22999a);
        }
    }

    public interface h {
        void onDismiss();

        void onOpen();
    }

    public class f implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f23006a;
        public final /* synthetic */ h b;
        public final /* synthetic */ Activity c;

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.b.onOpen();
                f4.a(f.this.c, f4.f22999a);
            }
        }

        public f(TextView textView, h hVar, Activity activity) {
            this.f23006a = textView;
            this.b = hVar;
            this.c = activity;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            this.f23006a.setText("请下拉阅读(" + (j / 1000) + "s)");
            this.f23006a.setOnClickListener(null);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            this.f23006a.setText("我已知晓并同意");
            this.f23006a.setOnClickListener(new a());
            h0.a().e(this.c, this.f23006a);
        }
    }

    public static AlertDialog a(Activity activity, h hVar) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.service_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_one);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_two);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_three);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_four);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_five);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_six);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.tv_seven);
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.tv_eight);
        TextView textView9 = (TextView) viewInflate.findViewById(R.id.tv_but2);
        h0.a().e(activity, textView9);
        TextView textView10 = (TextView) viewInflate.findViewById(R.id.tv_line);
        h0.a().a(activity, (TextView) viewInflate.findViewById(R.id.tv_line_short));
        h0.a().a(activity, textView10);
        b = (ContinueSlideScrollView) viewInflate.findViewById(R.id.info_scroll);
        TextView textView11 = (TextView) viewInflate.findViewById(R.id.tv_version_info);
        h0.a().a(activity, (RelativeLayout) viewInflate.findViewById(R.id.relativeLayout_bg));
        b.setScanScrollChangedListener(new a(textView9, hVar, activity));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(d);
        spannableStringBuilder.setSpan(new b(activity), 26, 32, 33);
        spannableStringBuilder.setSpan(new c(activity), 33, 39, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
        String string = activity.getResources().getString(R.string.one_pilcrow);
        String str = l0.f23074a;
        textView2.setText(String.format(string, str));
        textView3.setText(activity.getResources().getString(R.string.two_pilcrow));
        textView4.setText(String.format(activity.getResources().getString(R.string.three_pilcrow), str));
        textView5.setText(activity.getResources().getString(R.string.four_pilcrow));
        textView6.setText(String.format(activity.getResources().getString(R.string.five_pilcrow), str));
        textView7.setText(String.format(activity.getResources().getString(R.string.six_pilcrow), str));
        String str2 = String.format(activity.getResources().getString(R.string.seven_pilcrow), str);
        int iIndexOf = str2.indexOf(e);
        int iIndexOf2 = str2.indexOf(f);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2);
        spannableStringBuilder2.setSpan(new d(activity), iIndexOf, iIndexOf + 6, 33);
        spannableStringBuilder2.setSpan(new e(activity), iIndexOf2, iIndexOf2 + 6, 33);
        textView8.setMovementMethod(LinkMovementMethod.getInstance());
        textView8.setText(spannableStringBuilder2);
        c = n0.a().b(8000, 1000, new f(textView9, hVar, activity));
        TextView textView12 = (TextView) viewInflate.findViewById(R.id.tv_button);
        h0.a().a(activity, textView11, textView12);
        textView12.setOnClickListener(new g(activity));
        AlertDialog alertDialogCreate = builder.create();
        f22999a = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f22999a);
        return f22999a;
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
