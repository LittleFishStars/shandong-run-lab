package com.beizi.fusion;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class wm extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f27987a;
    private RelativeLayout b;
    private RecyclerView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private RelativeLayout g;
    private RelativeLayout h;
    private EditText i;
    private TextView j;
    private TextView k;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence != null) {
                wm.this.a(!charSequence.toString().isEmpty());
                wm.this.j.setText(String.valueOf(charSequence.length()));
            } else {
                wm.this.a(false);
                wm.this.j.setText("0");
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27989a;
        private e b;

        public b(Context context) {
            this.f27989a = context;
        }

        public b a(e eVar) {
            this.b = eVar;
            return this;
        }

        public Dialog a() {
            return new wm(this);
        }
    }

    public static class c extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27990a;
        private final String[] b;
        private f c;

        private c(Context context) {
            this.f27990a = context;
            this.b = context.getResources().getStringArray(R.array.complain_list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f fVar) {
            this.c = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            String[] strArr = this.b;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(d dVar, String str, View view) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(view, dVar.getLayoutPosition(), str);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final d dVar, int i) {
            String[] strArr = this.b;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            final String str = strArr[i];
            dVar.f27991a.setText(str);
            dVar.f27991a.setTextColor(Color.parseColor(fp.a().a("#000000")));
            if (i == this.b.length - 1) {
                dVar.b.setVisibility(8);
            }
            dVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.br
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f27115a.a(dVar, str, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public d onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new d(View.inflate(this.f27990a, R.layout.asnp_complain_item_multi_one, null));
        }
    }

    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f27991a;
        private final View b;

        public d(View view) {
            super(view);
            this.f27991a = (TextView) view.findViewById(R.id.complain_item_multi_one_title);
            this.b = view.findViewById(R.id.complain_reason_item_divider);
        }
    }

    public interface e extends DialogInterface.OnDismissListener, DialogInterface.OnCancelListener, DialogInterface.OnShowListener {
        void a(String str);
    }

    public interface f {
        void a(View view, int i, String str);
    }

    private wm(b bVar) {
        this(bVar.f27989a, R.style.adscope_complaint_dialog);
        this.f27987a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i, String str) {
        a(str);
    }

    private void b() {
        View viewInflate = View.inflate(getContext(), R.layout.asnp_complain_dialog, null);
        addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        this.b = (RelativeLayout) viewInflate.findViewById(R.id.complain_dialog_container_rl);
        this.c = (RecyclerView) viewInflate.findViewById(R.id.complain_reasons_list_recycleview);
        this.d = (ImageView) viewInflate.findViewById(R.id.complain_dialog_close_view);
        this.e = (TextView) viewInflate.findViewById(R.id.complain_other_suggest_view);
        this.f = (TextView) viewInflate.findViewById(R.id.complain_other_suggest_title);
        this.g = (RelativeLayout) viewInflate.findViewById(R.id.complain_normal_ui);
        this.h = (RelativeLayout) viewInflate.findViewById(R.id.complain_other_suggest_layout);
        this.i = (EditText) viewInflate.findViewById(R.id.complain_input_other_edittext);
        this.j = (TextView) viewInflate.findViewById(R.id.complain_other_suggest_number_textview);
        this.k = (TextView) viewInflate.findViewById(R.id.complain_other_suggest_submit);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.c.setLayoutManager(linearLayoutManager);
        try {
            d();
        } catch (Exception unused) {
        }
    }

    private void c() {
        c cVar = new c(getContext());
        cVar.a(new f() { // from class: com.beizi.fusion.ar
            @Override // com.beizi.fusion.wm.f
            public final void a(View view, int i, String str) {
                this.f27021a.a(view, i, str);
            }
        });
        this.c.setAdapter(cVar);
    }

    private void d() {
        try {
            if (fp.a().b()) {
                this.b.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.asnp_complaint_dialog_shape_black));
            } else {
                this.b.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.asnp_complaint_dialog_shape));
            }
            this.e.setHintTextColor(Color.parseColor(fp.a().a("#666666")));
            this.i.setHintTextColor(Color.parseColor(fp.a().a("#0A0A0A")));
            this.i.setTextColor(Color.parseColor(fp.a().a("#000000")));
            this.f.setTextColor(Color.parseColor(fp.a().a("#000000")));
            un.a(getContext(), this.k, fp.a().a("#B4B4B4"), 0, "", 10);
            un.a(getContext(), this.i, fp.a().a("#F3F3F3"), 0, "", 3);
        } catch (Exception e2) {
            om.a(e2);
        }
    }

    private void e() {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.axb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40635a.a(view);
            }
        });
        this.i.addTextChangedListener(new a());
    }

    private void f() {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.cxb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41063a.b(view);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dxb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41303a.c(view);
            }
        });
    }

    private void g() {
        if (this.g.getVisibility() == 0) {
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            c(this.i);
        } else {
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            a(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        g();
    }

    private wm(Context context, int i) {
        super(context, i);
        b();
        c();
        e();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        String str;
        int i;
        if (z) {
            str = "#3380FF";
            i = -16777216;
        } else {
            str = "#B4B4B4";
            i = -1;
        }
        un.a(getContext(), this.k, str, 0, "", 10);
        this.k.setTextColor(i);
        this.k.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a(this.i.getText().toString());
    }

    private void a(EditText editText) {
        editText.clearFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void c(final EditText editText) {
        editText.requestFocus();
        new Handler().postDelayed(new Runnable() { // from class: com.zj.adlib.bxb
            @Override // java.lang.Runnable
            public final void run() {
                this.f15654a.b(editText);
            }
        }, 100L);
    }

    private void a(String str) {
        e eVar = this.f27987a.b;
        if (eVar != null) {
            eVar.a(str);
        }
        a();
    }

    private void a() {
        if (isShowing()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.h.getVisibility() == 4) {
            g();
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput(editText, 2);
        inputMethodManager.toggleSoftInput(2, 1);
    }
}
