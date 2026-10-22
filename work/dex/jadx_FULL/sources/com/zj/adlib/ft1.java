package com.zj.adlib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.dialog.OnConfirmListener;
import com.huachenjie.base.widget.dialog.OnSaveInputListener;
import com.huachenjie.base.widget.dialog.OnViewCreateListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.noober.background.drawable.DrawableCreator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ft1 {

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41750a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicReference f16611a;

        public a(final AtomicReference val$inputText, final View val$mClear) {
            this.f16611a = val$inputText;
            this.f41750a = val$mClear;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            this.f16611a.set(s.toString());
            this.f41750a.setVisibility(TextUtils.isEmpty(s.toString()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    public static Dialog A(Context context, String content, String confirmText, View.OnClickListener confirmClickListener) {
        return q(context, "", content, "", confirmText, confirmClickListener);
    }

    public static Dialog B(Context context, String title, String content, String confirmText) {
        return q(context, title, content, "", confirmText, null);
    }

    public static ws1 g(Context context) {
        return ws1.Z(context).U(R.style.confirm_dialog_theme).R(R.layout.dialog_confirm_box).a(new OnViewCreateListener() { // from class: com.zj.adlib.et1
            @Override // com.huachenjie.base.widget.dialog.OnViewCreateListener
            public final void a(View view) {
                ft1.i(view);
            }
        });
    }

    public static ws1 h(Context context) {
        return g(context).N("确认").F(OptionsPickerHelper.e);
    }

    public static /* synthetic */ void i(View view) {
        TextView textView;
        TextView textView2 = (TextView) view.findViewById(R.id.confirm_dialog_title);
        if (textView2 == null || textView2.getVisibility() != 8 || (textView = (TextView) view.findViewById(R.id.confirm_dialog_content)) == null || textView.getLayoutParams() == null || !(textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.bottomMargin = cr2.c(view.getContext(), 40.0f);
        textView.setLayoutParams(marginLayoutParams);
        textView.setTextSize(16.0f);
    }

    public static /* synthetic */ void j(AtomicReference atomicReference, OnSaveInputListener onSaveInputListener, AtomicReference atomicReference2, Dialog dialog, View view) {
        if (atomicReference.get() != null) {
            KeyboardUtils.k((View) atomicReference.get());
        }
        onSaveInputListener.a(dialog, (String) atomicReference2.get());
    }

    public static /* synthetic */ void k(AtomicReference atomicReference, View view) {
        if (atomicReference.get() != null) {
            KeyboardUtils.k((View) atomicReference.get());
        }
    }

    public static /* synthetic */ void n(CharSequence charSequence, AtomicReference atomicReference, String str, int i, AtomicReference atomicReference2, View view) {
        final EditText editText = (EditText) view.findViewById(R.id.confirm_dialog_content);
        View viewFindViewById = view.findViewById(R.id.confirm_dialog_content_clear);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zs1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                editText.setText("");
            }
        });
        if (!TextUtils.isEmpty(charSequence)) {
            viewFindViewById.setVisibility(0);
        }
        atomicReference.set(editText);
        editText.setVisibility(0);
        editText.setText(charSequence);
        editText.setHint(str);
        editText.setHintTextColor(Color.parseColor("#C1C1C1"));
        if (i > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
        editText.addTextChangedListener(new a(atomicReference2, viewFindViewById));
        editText.post(new Runnable() { // from class: com.zj.adlib.at1
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardUtils.s(editText);
            }
        });
    }

    public static Dialog o(Context context, CharSequence content, String cancelText, String confirmText, View.OnClickListener confirmClickListener) {
        return q(context, "", content, cancelText, confirmText, confirmClickListener);
    }

    public static Dialog p(Context context, String content, View.OnClickListener confirmClickListener) {
        return q(context, "", content, OptionsPickerHelper.e, "确认", confirmClickListener);
    }

    public static Dialog q(Context context, String title, CharSequence content, String cancelText, String confirmText, View.OnClickListener confirmClickListener) {
        return s(context, title, content, false, cancelText, confirmText, null, confirmClickListener);
    }

    public static Dialog r(Context context, String title, CharSequence content, String cancelText, String confirmText, View.OnClickListener cancelClickListener, View.OnClickListener confirmClickListener) {
        return s(context, title, content, false, cancelText, confirmText, cancelClickListener, confirmClickListener);
    }

    public static Dialog s(Context context, String title, CharSequence content, boolean cancellable, String cancelText, String confirmText, View.OnClickListener cancelClickListener, View.OnClickListener confirmClickListener) {
        return t(context, title, content, cancellable, cancelText, confirmText, false, cancelClickListener, confirmClickListener);
    }

    public static Dialog t(Context context, String title, CharSequence content, boolean cancellable, String cancelText, String confirmText, boolean isRedConfirm, View.OnClickListener cancelClickListener, View.OnClickListener confirmClickListener) {
        ws1 ws1VarJ = g(context).X(title).Q(content).F(cancelText).G(cancellable).C(cancelClickListener).N(confirmText).J(confirmClickListener);
        if (isRedConfirm) {
            ws1VarJ.K(-1);
            ws1VarJ.H(new DrawableCreator.Builder().setSolidColor(Color.parseColor("#FF3B3B")).setCornersRadius(cr2.c(context, 20.0f)).build());
        }
        return ws1VarJ.Y();
    }

    public static Dialog u(Context context, String content, String confirmText, View.OnClickListener confirmClickListener) {
        return q(context, "", content, OptionsPickerHelper.e, confirmText, confirmClickListener);
    }

    public static Dialog v(Context context, String content, String confirmText, View.OnClickListener cancelClickListener, View.OnClickListener confirmClickListener) {
        return s(context, "", content, false, OptionsPickerHelper.e, confirmText, cancelClickListener, confirmClickListener);
    }

    public static void w(Context context, String title, CharSequence content, String hintText, int maxLength, OnSaveInputListener onSaveInputListener) {
        x(context, title, content, hintText, maxLength, OptionsPickerHelper.e, OptionsPickerHelper.f, onSaveInputListener);
    }

    public static void x(Context context, String title, final CharSequence content, final String hintText, final int maxLength, String cancelText, String confirmText, final OnSaveInputListener onSaveInputListener) {
        final AtomicReference atomicReference = new AtomicReference(TextUtils.isEmpty(content) ? "" : content.toString());
        final AtomicReference atomicReference2 = new AtomicReference();
        ws1.Z(context).U(R.style.confirm_dialog_theme).R(R.layout.dialog_input_box).X(title).Q(content).F(cancelText).N(confirmText).L(new OnConfirmListener() { // from class: com.zj.adlib.bt1
            @Override // com.huachenjie.base.widget.dialog.OnConfirmListener
            public final void a(Dialog dialog, View view) {
                ft1.j(atomicReference2, onSaveInputListener, atomicReference, dialog, view);
            }
        }).C(new View.OnClickListener() { // from class: com.zj.adlib.ct1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ft1.k(atomicReference2, view);
            }
        }).a(new OnViewCreateListener() { // from class: com.zj.adlib.dt1
            @Override // com.huachenjie.base.widget.dialog.OnViewCreateListener
            public final void a(View view) {
                ft1.n(content, atomicReference2, hintText, maxLength, atomicReference, view);
            }
        }).Y();
    }

    public static void y(Context context, String title, CharSequence content, String hintText, OnSaveInputListener onSaveInputListener) {
        w(context, title, content, hintText, -1, onSaveInputListener);
    }

    public static Dialog z(Context context, String content, String confirmText) {
        return q(context, "", content, "", confirmText, null);
    }
}
