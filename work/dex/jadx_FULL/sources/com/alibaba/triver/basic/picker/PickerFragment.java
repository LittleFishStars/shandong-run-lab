package com.alibaba.triver.basic.picker;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter;
import com.alibaba.triver.basic.picker.library.view.ScrollPickerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PickerFragment extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f24723a;
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private View e;
    private boolean f = true;
    private String g;
    private String h;
    private String i;
    private String[] j;
    private String[] k;
    private int l;
    private int m;
    private b n;
    private a o;

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void a(boolean z, String str, int i);
    }

    private List<com.alibaba.triver.basic.picker.a> c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int i = 0;
        for (String str : strArr) {
            com.alibaba.triver.basic.picker.a aVar = new com.alibaba.triver.basic.picker.a();
            aVar.f24729a = i;
            aVar.b = str;
            i++;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.view_picker_layout, viewGroup, false);
        this.e = viewInflate;
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f24723a = (TextView) this.e.findViewById(R.id.picker_title);
        this.b = (TextView) this.e.findViewById(R.id.picker_confirm);
        this.c = (TextView) this.e.findViewById(R.id.picker_cancel);
        this.d = (LinearLayout) this.e.findViewById(R.id.picker_container);
        this.f24723a.setText(this.g);
        this.b.setText(this.h);
        this.c.setText(this.i);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.PickerFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PickerFragment.this.o != null) {
                    PickerFragment.this.o.a(true);
                }
                PickerFragment.this.dismiss();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.PickerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PickerFragment.this.o.a(false);
                PickerFragment.this.dismiss();
            }
        });
        a();
    }

    public void a() {
        if (this.f) {
            List<com.alibaba.triver.basic.picker.a> listC = c(this.j);
            ScrollPickerView scrollPickerView = new ScrollPickerView(getActivity());
            scrollPickerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            scrollPickerView.setAdapter(new ScrollPickerAdapter.c(getActivity()).a(listC).a(2).b(5).a("#ED5275").a(new com.alibaba.triver.basic.picker.b()).a(new ScrollPickerAdapter.b() { // from class: com.alibaba.triver.basic.picker.PickerFragment.3
                @Override // com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter.b
                public void a(View view) {
                    com.alibaba.triver.basic.picker.a aVar = (com.alibaba.triver.basic.picker.a) view.getTag();
                    if (PickerFragment.this.n == null || aVar == null) {
                        return;
                    }
                    PickerFragment.this.n.a(true, aVar.b, aVar.f24729a);
                }
            }).a());
            this.d.addView(scrollPickerView);
            scrollPickerView.scrollToPosition(this.l);
            ((LinearLayoutManager) scrollPickerView.getLayoutManager()).scrollToPositionWithOffset(this.l, 0);
            return;
        }
        List<com.alibaba.triver.basic.picker.a> listC2 = c(this.j);
        ScrollPickerView scrollPickerView2 = new ScrollPickerView(getActivity());
        scrollPickerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        scrollPickerView2.setAdapter(new ScrollPickerAdapter.c(getActivity()).a(listC2).a(2).b(5).a("#ED5275").a(new com.alibaba.triver.basic.picker.b()).a(new ScrollPickerAdapter.b() { // from class: com.alibaba.triver.basic.picker.PickerFragment.4
            @Override // com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter.b
            public void a(View view) {
                com.alibaba.triver.basic.picker.a aVar = (com.alibaba.triver.basic.picker.a) view.getTag();
                if (PickerFragment.this.n != null) {
                    PickerFragment.this.n.a(true, aVar.b, aVar.f24729a);
                }
            }
        }).a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 16, 0);
        scrollPickerView2.setLayoutParams(layoutParams);
        this.d.addView(scrollPickerView2);
        ((LinearLayoutManager) scrollPickerView2.getLayoutManager()).scrollToPositionWithOffset(this.l, 0);
        List<com.alibaba.triver.basic.picker.a> listC3 = c(this.k);
        ScrollPickerView scrollPickerView3 = new ScrollPickerView(getActivity());
        scrollPickerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        scrollPickerView3.setAdapter(new ScrollPickerAdapter.c(getActivity()).a(listC3).a(2).b(5).a("#ED5275").a(new com.alibaba.triver.basic.picker.b()).a(new ScrollPickerAdapter.b() { // from class: com.alibaba.triver.basic.picker.PickerFragment.5
            @Override // com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter.b
            public void a(View view) {
                com.alibaba.triver.basic.picker.a aVar = (com.alibaba.triver.basic.picker.a) view.getTag();
                if (PickerFragment.this.n != null) {
                    PickerFragment.this.n.a(false, aVar.b, aVar.f24729a);
                }
            }
        }).a());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(16, 0, 0, 0);
        scrollPickerView3.setLayoutParams(layoutParams2);
        this.d.addView(scrollPickerView3);
        ((LinearLayoutManager) scrollPickerView3.getLayoutManager()).scrollToPositionWithOffset(this.m, 0);
    }

    public void b(String str) {
        this.h = str;
    }

    public void b(String[] strArr) {
        this.k = strArr;
    }

    public void b(int i) {
        this.m = i;
    }

    public void c(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(String[] strArr) {
        this.j = strArr;
    }

    public void a(int i) {
        this.l = i;
    }

    public void a(b bVar) {
        this.n = bVar;
    }

    public void a(a aVar) {
        this.o = aVar;
    }
}
