package com.byazt.sgn;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 130})
public class m extends AlertDialog {
    public Context c;
    public String tt;
    public c uj;
    public boolean ve;

    public interface c {
        void c(String str);

        void tt(String str);
    }

    public m(Context context, String str) {
        super(context);
        this.c = context;
        this.tt = str;
        this.ve = TextUtils.isEmpty(str);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        c cVar = this.uj;
        if (cVar == null) {
            return;
        }
        cVar.tt(this.tt);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.vfu.sp.tt(this);
        setCanceledOnTouchOutside(false);
        if (this.c == null) {
            this.c = gt.getContext();
        }
        c();
    }

    private void c() {
        setContentView(tt());
    }

    private View tt() {
        LinearLayout linearLayout = new LinearLayout(this.c);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-16777216);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int iVe = pf.ve(this.c, 10.0f) * 2;
        TextView textView2 = new TextView(this.c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iVe;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int iVe2 = pf.ve(this.c, 25.0f);
        int iVe3 = pf.ve(this.c, 8.0f);
        if (!this.ve) {
            Button button = new Button(this.c);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(iVe2, iVe3, iVe2, iVe3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(pf.ve(this.c, 230.0f), -2);
            layoutParams4.topMargin = iVe;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.m.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.dismiss();
                    if (m.this.uj == null) {
                        return;
                    }
                    m.this.uj.c(m.this.tt);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.c);
        button2.setBackgroundColor(-65536);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(pf.ve(this.c, 230.0f), -2);
        layoutParams5.topMargin = iVe;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(iVe2, iVe3, iVe2, iVe3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.dismiss();
                if (m.this.uj == null) {
                    return;
                }
                m.this.uj.tt(m.this.tt);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public void c(c cVar) {
        this.uj = cVar;
    }
}
