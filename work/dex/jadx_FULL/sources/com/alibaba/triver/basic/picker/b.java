package com.alibaba.triver.basic.picker;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.triver.basic.api.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements com.alibaba.triver.basic.picker.library.b<a> {
    @Override // com.alibaba.triver.basic.picker.library.b
    public int a() {
        return R.layout.my_scroll_picker_item_layout;
    }

    @Override // com.alibaba.triver.basic.picker.library.b
    public void a(@NonNull View view, @Nullable a aVar) {
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        if (aVar != null) {
            textView.setText(aVar.b);
            view.setTag(aVar);
        } else {
            textView.setText("");
            view.setTag(null);
        }
    }

    @Override // com.alibaba.triver.basic.picker.library.b
    public void a(@NonNull View view, boolean z) {
        ((TextView) view.findViewById(R.id.tv_content)).setTextColor(Color.parseColor(z ? "#589AAA" : "#342434"));
    }
}
