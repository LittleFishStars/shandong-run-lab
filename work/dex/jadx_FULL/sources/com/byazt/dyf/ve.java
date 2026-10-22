package com.byazt.dyf;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ff.TTDislikeCommentLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 746, 54})
public class ve extends Dialog {
    public TTDislikeCommentLayout c;
    public EditText n;
    public final List<com.byazt.sif.c> tt;
    public com.byazt.sif.tt uj;
    public com.byazt.vo.tt ve;

    public ve(Context context, com.byazt.vo.tt ttVar) {
        super(context);
        this.tt = new ArrayList();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.ve = ttVar;
    }

    private void n() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ve();
        super.dismiss();
        com.byazt.sif.tt ttVar = this.uj;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.vfu.uj.c(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279090);
        this.c = tTDislikeCommentLayout;
        c(tTDislikeCommentLayout);
        n();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        tt();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    private void c(View view) {
        EditText editText = (EditText) view.findViewById(2047279085);
        this.n = editText;
        c(editText);
        final TextView textView = (TextView) view.findViewById(2047279086);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.dyf.ve.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = ve.this.n.getText().toString();
                if (string.length() <= 0 || string.isEmpty()) {
                    return;
                }
                Iterator it = ve.this.tt.iterator();
                while (it.hasNext()) {
                    if (((com.byazt.sif.c) it.next()).c(string, ve.this)) {
                        return;
                    }
                }
                com.byazt.vo.ve veVar = new com.byazt.vo.ve("0:00", string);
                com.byazt.pr.c.c().c(ve.this.ve, veVar);
                ve.this.uj.c(0, veVar);
                ve.this.dismiss();
            }
        });
        ((ImageView) view.findViewById(2047279088)).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.dyf.ve.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ve.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279084);
        this.n.addTextChangedListener(new TextWatcher() { // from class: com.byazt.dyf.ve.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int iRound = Math.round(charSequence.length());
                textView2.setText(String.valueOf(iRound));
                if (iRound > 0) {
                    textView.setTextColor(-16777216);
                    textView.setClickable(true);
                } else {
                    textView.setTextColor(-7829368);
                    textView.setClickable(false);
                }
            }
        });
    }

    public void tt() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.c;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public String uj() {
        EditText editText = this.n;
        return editText != null ? editText.getText().toString() : "";
    }

    public void ve() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.c;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null || (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }

    public static void c(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.byazt.dyf.ve.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }

    public void c(com.byazt.sif.c cVar) {
        this.tt.add(cVar);
    }

    public void c(com.byazt.vo.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        this.ve = ttVar;
    }

    public void c() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.c;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    public void c(com.byazt.sif.tt ttVar) {
        this.uj = ttVar;
    }
}
