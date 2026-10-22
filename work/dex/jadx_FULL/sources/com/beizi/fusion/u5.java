package com.beizi.fusion;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class u5 extends Dialog {
    private static e c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f27812a;
    private int b;

    public interface b {
        void a();

        void a(String str);
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27820a;
        String b;

        public c() {
        }

        public void a(int i) {
            this.f27820a = i;
        }

        public String a() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public interface d {
        void a(View view, int i, String str);
    }

    public class e extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f27821a;
        public d b;

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f27822a;
            final /* synthetic */ String b;

            public a(RecyclerView.ViewHolder viewHolder, String str) {
                this.f27822a = viewHolder;
                this.b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.b.a(this.f27822a.itemView, this.f27822a.getLayoutPosition(), this.b);
            }
        }

        public class b extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private TextView f27823a;
            private View b;

            public b(View view) {
                super(view);
                this.f27823a = (TextView) view.findViewById(R.id.dislike_item_multi_one_title);
                this.b = view.findViewById(R.id.complaint_reason_item_divider);
            }
        }

        public e(Context context, List list) {
            this.f27821a = list;
        }

        public void a(d dVar) {
            this.b = dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f27821a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return u5.this.b;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String strA = ((c) this.f27821a.get(i)).a();
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.f27823a.setText(strA);
                if (this.f27821a.size() > 0 && i == this.f27821a.size() - 1) {
                    bVar.b.setVisibility(8);
                }
            }
            if (this.b != null) {
                viewHolder.itemView.setOnClickListener(new a(viewHolder, strA));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_complaint_item_multi_one, viewGroup, false));
        }
    }

    public u5(Context context, int i) {
        super(context, i);
        this.f27812a = null;
        this.b = 1;
        List listA = a();
        this.f27812a = listA;
        c = new e(context, listA);
    }

    private List a() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"垃圾广告", "感觉有被冒犯或被歧视", "广告涉及欺诈造假", "广告涉及色情暴力", "广告涉及违禁商品/服务", "对广告内容不感兴趣"};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            c cVar = new c();
            cVar.a(str);
            cVar.a(this.b);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RecyclerView f27813a;
        private ImageView b;
        private TextView c;
        private RelativeLayout d;
        private RelativeLayout e;
        private EditText f;
        private TextView g;
        private Button h;
        private View i;
        private u5 j;
        private b k;
        private boolean l;

        /* JADX INFO: renamed from: com.beizi.fusion.u5$a$a, reason: collision with other inner class name */
        public class C0324a implements d {
            public C0324a() {
            }

            @Override // com.beizi.fusion.u5.d
            public void a(View view, int i, String str) {
                a.this.a(str);
            }
        }

        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f27815a;

            public b(Context context) {
                this.f27815a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                aVar.l = true;
                aVar.a(this.f27815a, aVar.f);
            }
        }

        public class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f27816a;

            public c(Context context) {
                this.f27816a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                if (aVar.l) {
                    aVar.l = false;
                    aVar.a(this.f27816a, aVar.f);
                    return;
                }
                u5 u5Var = aVar.j;
                if (u5Var != null) {
                    u5Var.dismiss();
                }
                b bVar = a.this.k;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        public class d implements TextWatcher {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f27817a;

            public d(Context context) {
                this.f27817a = context;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String string = charSequence.toString();
                int length = charSequence.length();
                if (string.isEmpty()) {
                    a.this.h.setBackground(ContextCompat.getDrawable(this.f27817a, R.drawable.beizi_complaint_button_disable_shape));
                    a.this.h.setTextColor(this.f27817a.getResources().getColor(android.R.color.white));
                    a.this.h.setEnabled(false);
                } else {
                    a.this.h.setBackground(ContextCompat.getDrawable(this.f27817a, R.drawable.beizi_complaint_button_enable_shape));
                    a.this.h.setTextColor(this.f27817a.getResources().getColor(android.R.color.black));
                    a.this.h.setEnabled(true);
                }
                a.this.g.setText(String.valueOf(length));
            }
        }

        public class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(a.this.f.getText().toString());
            }
        }

        public class f extends TimerTask {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f27819a;
            final /* synthetic */ EditText b;

            public f(Context context, EditText editText) {
                this.f27819a = context;
                this.b = editText;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f27819a.getSystemService("input_method");
                inputMethodManager.showSoftInput(this.b, 2);
                inputMethodManager.toggleSoftInput(2, 1);
            }
        }

        public a(Context context) {
            this.j = new u5(context, R.style.beizi_ad_custom_dialog);
            View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_complaint_dialog, (ViewGroup) null, false);
            this.i = viewInflate;
            this.j.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            this.f27813a = (RecyclerView) this.i.findViewById(R.id.dislike_reasons_list_recycleview);
            this.b = (ImageView) this.i.findViewById(R.id.complaint_dialog_close_view);
            this.c = (TextView) this.i.findViewById(R.id.complaint_other_suggest_view);
            this.d = (RelativeLayout) this.i.findViewById(R.id.complaint_normal_ui);
            this.e = (RelativeLayout) this.i.findViewById(R.id.complaint_other_suggest_layout);
            this.f = (EditText) this.i.findViewById(R.id.complaint_input_other_edittext);
            this.g = (TextView) this.i.findViewById(R.id.complaint_other_suggest_number_textview);
            this.h = (Button) this.i.findViewById(R.id.complaint_other_suggest_submit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f27813a.setLayoutManager(linearLayoutManager);
            u5.c.a(new C0324a());
            this.f27813a.setAdapter(u5.c);
            this.c.setOnClickListener(new b(context));
            this.b.setOnClickListener(new c(context));
            this.f.addTextChangedListener(new d(context));
            this.h.setOnClickListener(new e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            b bVar;
            if (!TextUtils.isEmpty(str) && (bVar = this.k) != null) {
                bVar.a(str);
            }
            u5 u5Var = this.j;
            if (u5Var != null) {
                u5Var.dismiss();
            }
            kh.d("BeiZisAd", str + " 被点击了");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, EditText editText) {
            if (this.l) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                a(context, true, editText);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                a(context, false, editText);
            }
        }

        private void a(Context context, boolean z, EditText editText) {
            if (z) {
                editText.requestFocus();
                new Timer().schedule(new f(context, editText), 100L);
            } else {
                editText.clearFocus();
                ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }

        public a a(b bVar) {
            this.k = bVar;
            return this;
        }

        public u5 a() {
            this.j.setContentView(this.i);
            this.j.setCancelable(true);
            this.j.setCanceledOnTouchOutside(false);
            return this.j;
        }
    }
}
