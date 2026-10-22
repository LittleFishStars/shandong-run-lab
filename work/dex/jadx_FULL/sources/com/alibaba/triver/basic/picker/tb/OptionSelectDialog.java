package com.alibaba.triver.basic.picker.tb;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.picker.PickerFragment;
import com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter;
import com.alibaba.triver.basic.picker.library.view.ScrollPickerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OptionSelectDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScrollPickerView f24737a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private String f;
    private String g;
    private String h;
    private String[] i;
    private String[] j;
    private int k;
    private int l;
    private PickerFragment.b m;
    private PickerFragment.a n;
    private boolean o = true;

    private List<a> c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int i = 0;
        for (String str : strArr) {
            a aVar = new a();
            aVar.f24742a = i;
            aVar.b = str;
            i++;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity(), R.style.TbBottomDialog);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.view_tb_option_select_dialog);
        this.b = (LinearLayout) dialog.findViewById(R.id.triver_tb_option_select_list_container);
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.setCancelable(true);
        a(dialog);
        a();
        return dialog;
    }

    private void a(Dialog dialog) {
        this.c = (TextView) dialog.findViewById(R.id.triver_tb_option_select_title);
        this.d = (TextView) dialog.findViewById(R.id.triver_tb_option_select_button);
        this.e = (ImageView) dialog.findViewById(R.id.triver_tb_option_select_close_button);
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(this.f);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(this.g);
        }
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.tb.OptionSelectDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OptionSelectDialog.this.n != null) {
                    OptionSelectDialog.this.n.a(false);
                }
                OptionSelectDialog.this.dismiss();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.tb.OptionSelectDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OptionSelectDialog.this.n != null) {
                    OptionSelectDialog.this.n.a(true);
                }
                OptionSelectDialog.this.dismiss();
            }
        });
    }

    public void b(String str) {
        this.h = str;
    }

    public void b(String[] strArr) {
        this.j = strArr;
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(String str) {
        this.g = str;
    }

    private void a() {
        if (this.o) {
            ScrollPickerView scrollPickerViewA = a(true, c(this.i), this.k);
            LinearLayout linearLayout = this.b;
            if (linearLayout != null) {
                linearLayout.addView(scrollPickerViewA);
                return;
            }
            return;
        }
        List<a> listC = c(this.i);
        List<a> listC2 = c(this.j);
        ScrollPickerView scrollPickerViewA2 = a(true, listC, this.k);
        ScrollPickerView scrollPickerViewA3 = a(false, listC2, this.l);
        LinearLayout linearLayout2 = this.b;
        if (linearLayout2 != null) {
            ((FrameLayout) linearLayout2.findViewById(R.id.triver_tb_option_select_list_container_1)).addView(scrollPickerViewA2);
            ((FrameLayout) this.b.findViewById(R.id.triver_tb_option_select_list_container_2)).addView(scrollPickerViewA3);
        }
    }

    private ScrollPickerView a(final boolean z, List<a> list, int i) {
        ScrollPickerView scrollPickerView = new ScrollPickerView(getActivity());
        scrollPickerView.setTbPicker(true);
        scrollPickerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        scrollPickerView.setAdapter(new ScrollPickerAdapter.c(getActivity()).a(list).a(1).b(4).a("#ED5275").a(new b()).a(new ScrollPickerAdapter.a() { // from class: com.alibaba.triver.basic.picker.tb.OptionSelectDialog.4
            @Override // com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter.a
            public void a(View view) {
            }
        }).a(new ScrollPickerAdapter.b() { // from class: com.alibaba.triver.basic.picker.tb.OptionSelectDialog.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            View f24740a = null;

            @Override // com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter.b
            public void a(View view) {
                if (!view.equals(this.f24740a)) {
                    View view2 = this.f24740a;
                    if (view2 != null) {
                        view2.setBackgroundColor(Color.parseColor("#EFEFEF"));
                    }
                    this.f24740a = view;
                    view.setBackgroundColor(Color.parseColor("#EFD9D0"));
                }
                if (OptionSelectDialog.this.m != null) {
                    try {
                        a aVar = (a) view.getTag();
                        OptionSelectDialog.this.m.a(z, aVar.b, aVar.f24742a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).a());
        scrollPickerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((LinearLayoutManager) scrollPickerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        return scrollPickerView;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(String[] strArr) {
        this.i = strArr;
    }

    public void a(PickerFragment.b bVar) {
        this.m = bVar;
    }

    public void a(PickerFragment.a aVar) {
        this.n = aVar;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(boolean z) {
        this.o = z;
    }
}
