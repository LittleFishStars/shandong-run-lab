package com.kwad.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class e extends c {
    private int btA;
    private String btB;
    private int btC;
    private b btx;
    private String bty;
    private String btz;

    public static class a {
        private int btA;
        private String btB;
        private int btC;
        private b btx;
        private String bty;
        private String btz;
        private Context mContext;

        public a(@NonNull Context context) {
            this.mContext = context;
        }

        public final e XL() {
            return new e(this);
        }

        public final a a(b bVar) {
            this.btx = bVar;
            return this;
        }

        public final a iG(@NonNull String str) {
            this.bty = str;
            return this;
        }

        public final a iH(String str) {
            this.btz = str;
            return this;
        }

        public final a iI(String str) {
            this.btB = str;
            return this;
        }
    }

    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public e(a aVar) {
        super(aVar.mContext);
        a(aVar);
    }

    private View uU() {
        View viewInflate = LayoutInflater.from(m.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
        viewInflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.btx != null) {
                    e.this.btx.c(e.this);
                }
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_no_title_common_positive_btn);
        if (!TextUtils.isEmpty(this.btz)) {
            textView.setText(this.btz);
        }
        textView.setTextColor(this.btA);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.btx != null) {
                    e.this.btx.a(e.this);
                }
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.btB)) {
            textView2.setText(this.btB);
        }
        textView2.setTextColor(this.btC);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.btx != null) {
                    e.this.btx.b(e.this);
                }
            }
        });
        ((TextView) viewInflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.bty);
        return viewInflate;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(uU());
            setCanceledOnTouchOutside(true);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void a(a aVar) {
        if (aVar.mContext instanceof Activity) {
            setOwnerActivity((Activity) aVar.mContext);
        }
        this.btx = aVar.btx;
        this.bty = aVar.bty;
        this.btz = !TextUtils.isEmpty(aVar.btz) ? aVar.btz : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        this.btA = aVar.btA != 0 ? aVar.btA : aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        this.btB = !TextUtils.isEmpty(aVar.btB) ? aVar.btB : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        this.btC = aVar.btC != 0 ? aVar.btC : aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
    }
}
