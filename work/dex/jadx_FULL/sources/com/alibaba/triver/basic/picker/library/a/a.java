package com.alibaba.triver.basic.picker.library.a;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.picker.library.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements b<String> {
    @Override // com.alibaba.triver.basic.picker.library.b
    public int a() {
        return R.layout.my_scroll_picker_item_layout;
    }

    @Override // com.alibaba.triver.basic.picker.library.b
    public void a(@NonNull View view, @Nullable String str) {
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText(str);
        view.setTag(str);
        textView.setTextSize(18.0f);
    }

    @Override // com.alibaba.triver.basic.picker.library.b
    public void a(@NonNull View view, boolean z) {
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setTextSize(z ? 18.0f : 14.0f);
        textView.setTextColor(Color.parseColor(z ? "#ED5275" : "#000000"));
    }
}
