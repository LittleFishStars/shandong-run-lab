package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f27856a;
    private b b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.beizi.fusion.v5$a$a, reason: collision with other inner class name */
        public class C0325a implements u5.b {
            public C0325a() {
            }

            @Override // com.beizi.fusion.u5.b
            public void a() {
            }

            @Override // com.beizi.fusion.u5.b
            public void a(String str) {
                b bVar = v5.this.b;
                if (bVar != null) {
                    bVar.a(str);
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Context context = v5.this.f27856a.getContext();
                View rootView = v5.this.f27856a.getRootView();
                if (rootView != null) {
                    context = rootView.getContext();
                }
                u5.a aVar = new u5.a(context);
                aVar.a(new C0325a());
                aVar.a().show();
            } catch (Exception e) {
                jh.b("BeiZis", "e ：" + e);
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public void a(Context context, ViewGroup viewGroup, String str) {
        try {
            a(context, str);
            TextView textView = this.f27856a;
            if (textView != null) {
                viewGroup.addView(textView);
            }
        } catch (Exception unused) {
        }
    }

    private void a(Context context, String str) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            this.f27856a = textView;
            textView.setText("投诉");
            this.f27856a.setTextColor(Color.parseColor("#FFFFFF"));
            vn.a(this.f27856a, "#99000000", 0, "", 30);
            if ("1".equals(str)) {
                this.f27856a.setTextSize(2, 13.0f);
                this.f27856a.setPadding(so.a(context, 12.0f), so.a(context, 1.0f), so.a(context, 12.0f), so.a(context, 1.0f));
                layoutParams.leftMargin = 18;
                layoutParams.topMargin = 18;
            } else if ("2".equals(str)) {
                this.f27856a.setTextSize(2, 13.0f);
                this.f27856a.setPadding(so.a(context, 12.0f), so.a(context, 1.0f), so.a(context, 12.0f), so.a(context, 1.0f));
                layoutParams.leftMargin = so.a(context, 16.0f);
                layoutParams.topMargin = so.a(context, 16.0f);
            } else if ("3".equals(str)) {
                this.f27856a.setTextSize(2, 10.0f);
                this.f27856a.setPadding(so.a(context, 11.0f), so.a(context, 1.0f), so.a(context, 11.0f), so.a(context, 1.0f));
                layoutParams.leftMargin = 16;
                layoutParams.topMargin = 16;
            }
            this.f27856a.setLayoutParams(layoutParams);
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        try {
            this.f27856a.setOnClickListener(new a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(b bVar) {
        this.b = bVar;
    }
}
