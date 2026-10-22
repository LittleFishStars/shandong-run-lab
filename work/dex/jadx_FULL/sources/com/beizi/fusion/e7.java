package com.beizi.fusion;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.fusion.widget.dialog.dislike.FlowLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e7 extends Dialog {
    private static h d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f27215a;
    private int b;
    private int c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RecyclerView f27216a;
        private View b;
        private e7 c;
        private c d;

        /* JADX INFO: renamed from: com.beizi.fusion.e7$a$a, reason: collision with other inner class name */
        public class C0308a implements e {
            public C0308a() {
            }

            @Override // com.beizi.fusion.e7.e
            public void a(View view, int i) {
                e7 e7Var = a.this.c;
                if (e7Var != null) {
                    e7Var.dismiss();
                }
                c cVar = a.this.d;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }

        public a(Context context) {
            this.c = new e7(context, R.style.beizi_custom_dialog);
            View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_dislike_dialog, (ViewGroup) null, false);
            this.b = viewInflate;
            this.c.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            this.f27216a = (RecyclerView) this.b.findViewById(R.id.beizi_dislike_reasons_list_recycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f27216a.setLayoutManager(linearLayoutManager);
            e7.d.a(new C0308a());
            this.f27216a.setAdapter(e7.d);
            WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
            Point point = new Point();
            this.c.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
            attributes.width = (int) (((double) point.x) * 0.85d);
            attributes.gravity = 17;
            this.c.getWindow().setAttributes(attributes);
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public e7 a() {
            this.c.setContentView(this.b);
            this.c.setCancelable(true);
            this.c.setCanceledOnTouchOutside(true);
            return this.c;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27218a;
        String b;
        List c;

        public b() {
        }

        public void a(List list) {
            this.c = list;
        }

        public List b() {
            return this.c;
        }

        public void a(int i) {
            this.f27218a = i;
        }

        public String a() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public interface c {
        void a();
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f27219a;

        public d() {
        }

        public String a() {
            return this.f27219a;
        }

        public void a(String str) {
            this.f27219a = str;
        }
    }

    public interface e {
        void a(View view, int i);
    }

    public interface f {
        void a(View view, int i);
    }

    public class g extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f27220a;
        private Context b;
        private f c;

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27221a;

            public a(int i) {
                this.f27221a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f fVar = g.this.c;
                if (fVar != null) {
                    fVar.a(view, this.f27221a);
                }
            }
        }

        public class b extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f27222a;

            public b(View view) {
                super(view);
                this.f27222a = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview_item);
            }
        }

        public g(Context context, List list) {
            this.b = context;
            this.f27220a = list;
        }

        public void a(f fVar) {
            this.c = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f27220a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            b bVar = (b) viewHolder;
            bVar.f27222a.setText(((d) this.f27220a.get(i)).a());
            vn.a(bVar.itemView, "#FFFAF6F6", 0, "", 10);
            bVar.itemView.setOnClickListener(new a(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two_recycle_item, viewGroup, false));
        }
    }

    public class h extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f27223a;
        private List b;
        public e c;

        public class a implements f {
            public a() {
            }

            @Override // com.beizi.fusion.e7.f
            public void a(View view, int i) {
                e eVar = h.this.c;
                if (eVar != null) {
                    eVar.a(view, i);
                }
            }
        }

        public class b extends RecyclerView.ItemDecoration {
            public b() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                super.getItemOffsets(rect, view, recyclerView, state);
                rect.bottom = 30;
                rect.left = 60;
            }
        }

        public class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f27226a;

            public c(RecyclerView.ViewHolder viewHolder) {
                this.f27226a = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int layoutPosition = this.f27226a.getLayoutPosition();
                h hVar = h.this;
                if (e7.this.c != hVar.getItemViewType(layoutPosition)) {
                    h.this.c.a(this.f27226a.itemView, layoutPosition);
                }
            }
        }

        public class d extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private TextView f27227a;

            public d(View view) {
                super(view);
                this.f27227a = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_one_title);
            }
        }

        public class e extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private TextView f27228a;
            private RecyclerView b;

            public e(View view) {
                super(view);
                this.f27228a = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_title);
                this.b = (RecyclerView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview);
            }
        }

        public h(Context context, List list) {
            this.f27223a = context;
            this.b = list;
        }

        public void a(e eVar) {
            this.c = eVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (((b) this.b.get(i)).b() == null || ((b) this.b.get(i)).b().size() <= 0) ? e7.this.b : e7.this.c;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof d) {
                ((d) viewHolder).f27227a.setText(((b) this.b.get(i)).a());
            } else {
                e eVar = (e) viewHolder;
                eVar.f27228a.setText(((b) this.b.get(i)).a());
                eVar.b.setLayoutManager(new FlowLayoutManager());
                e7 e7Var = e7.this;
                g gVar = e7Var.new g(e7Var.getContext(), ((b) this.b.get(i)).b());
                eVar.b.setAdapter(gVar);
                gVar.a(new a());
                eVar.b.addItemDecoration(new b());
            }
            if (this.c != null) {
                viewHolder.itemView.setOnClickListener(new c(viewHolder));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return i == e7.this.b ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_one, viewGroup, false)) : new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two, viewGroup, false));
        }
    }

    public e7(Context context, int i) {
        super(context, i);
        this.f27215a = null;
        this.b = 1;
        this.c = 2;
        List listA = a();
        this.f27215a = listA;
        d = new h(context, listA);
    }

    private List a() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.a("内容无法正常展示（卡顿、黑白屏）");
        bVar.a(this.b);
        arrayList.add(bVar);
        b bVar2 = new b();
        bVar2.a("不感兴趣");
        bVar2.a(this.b);
        arrayList.add(bVar2);
        b bVar3 = new b();
        bVar3.a("无法关闭");
        bVar3.a(this.b);
        arrayList.add(bVar3);
        ArrayList arrayList2 = new ArrayList();
        d dVar = new d();
        dVar.a("疑似抄袭");
        arrayList2.add(dVar);
        d dVar2 = new d();
        dVar2.a("虚假欺诈");
        arrayList2.add(dVar2);
        d dVar3 = new d();
        dVar3.a("违法违规");
        arrayList2.add(dVar3);
        d dVar4 = new d();
        dVar4.a("低俗色情");
        arrayList2.add(dVar4);
        b bVar4 = new b();
        bVar4.a("举报广告");
        bVar4.a(arrayList2);
        bVar4.a(this.b);
        arrayList.add(bVar4);
        return arrayList;
    }
}
