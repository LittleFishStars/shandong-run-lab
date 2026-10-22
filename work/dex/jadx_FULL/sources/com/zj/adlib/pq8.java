package com.zj.adlib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.dialog.OnViewCreateListener;
import com.huachenjie.common.callback.VoidCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class pq8 {
    public static /* synthetic */ void e(VoidCallback voidCallback, View view) {
        if (voidCallback != null) {
            voidCallback.a();
        }
    }

    public static /* synthetic */ void f(VoidCallback voidCallback, View view) {
        if (voidCallback != null) {
            voidCallback.a();
        }
    }

    public static /* synthetic */ void g(CompoundButton compoundButton, boolean z) {
        r90.d0(!z);
    }

    public static /* synthetic */ void h(Context context, View view) {
        View viewFindViewById = view.findViewById(R.id.confirm_dialog_container);
        if (viewFindViewById instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) viewFindViewById;
            int i = linearLayout.getChildCount() == 2 ? 1 : 2;
            CheckBox checkBox = new CheckBox(context);
            checkBox.setText("不再提示");
            checkBox.setButtonDrawable((Drawable) null);
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.base_selector_checkbox);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                checkBox.setCompoundDrawables(drawable, null, null, null);
                checkBox.setCompoundDrawablePadding(jj8.a(8.0f));
            }
            checkBox.setTextColor(ContextCompat.getColorStateList(context, R.color.color_base_checkbox));
            checkBox.setChecked(false);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.lq8
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    pq8.g(compoundButton, z);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = jj8.a(24.0f);
            layoutParams.bottomMargin = jj8.a(20.0f);
            layoutParams.gravity = GravityCompat.START;
            checkBox.setLayoutParams(layoutParams);
            linearLayout.addView(checkBox, i);
        }
    }

    public static void i(final Context context, String title, CharSequence content, boolean cancellable, String cancelText, String confirmText, @Nullable final VoidCallback cancelCallback, final VoidCallback confirmCallback) {
        if (r90.z()) {
            ws1.Z(context).U(R.style.confirm_dialog_theme).R(R.layout.dialog_confirm_box).X(title).Q(content).F(cancelText).N(confirmText).G(cancellable).C(new View.OnClickListener() { // from class: com.zj.adlib.mq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    pq8.e(cancelCallback, view);
                }
            }).J(new View.OnClickListener() { // from class: com.zj.adlib.nq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    pq8.f(confirmCallback, view);
                }
            }).a(new OnViewCreateListener() { // from class: com.zj.adlib.oq8
                @Override // com.huachenjie.base.widget.dialog.OnViewCreateListener
                public final void a(View view) {
                    pq8.h(context, view);
                }
            }).Y();
        } else if (confirmCallback != null) {
            confirmCallback.a();
        }
    }
}
