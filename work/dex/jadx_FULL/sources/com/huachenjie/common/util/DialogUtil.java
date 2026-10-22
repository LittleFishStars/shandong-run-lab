package com.huachenjie.common.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.R;
import com.huachenjie.common.dialog.IconAlertDialog;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.zj.adlib.jj8;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class DialogUtil {

    public interface EditDialogConfirmListener {
        void a(Dialog dialog, String content);
    }

    public static abstract class PositiveNegativeClickListener {
        public void a() {
        }

        public abstract void b();
    }

    public interface SingleClickListener {
        void onClicked();
    }

    public static Dialog A(Activity activity, String title, String content, String leftButton, String rightButton, boolean cancelable, PositiveNegativeClickListener listener) {
        return B(activity, title, content, leftButton, rightButton, cancelable, cancelable, listener);
    }

    public static Dialog B(Activity activity, String title, String content, String leftButton, String rightButton, boolean touchCancelable, boolean backCancelable, final PositiveNegativeClickListener clickListener) {
        CustomizeViewDialog customizeViewDialogCreate = l(title, content, leftButton, rightButton, touchCancelable, backCancelable, clickListener, false).create(activity);
        customizeViewDialogCreate.show();
        return customizeViewDialogCreate;
    }

    public static Dialog C(Activity activity, String title, String hint, String content, int maxLength, int inputType, final EditDialogConfirmListener listener) {
        final Dialog dialog = new Dialog(activity, R.style.base_dialog_theme);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setDimAmount(0.3f);
        dialog.setContentView(R.layout.dialog_edit_view);
        ((TextView) dialog.findViewById(R.id.tvTitle)).setText(title);
        final EditText editText = (EditText) dialog.findViewById(R.id.etContent);
        editText.setText(content);
        editText.setHint(hint);
        if (maxLength >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        }
        editText.setInputType(inputType);
        dialog.getWindow().setSoftInputMode(5);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        TextView textView = (TextView) dialog.findViewById(R.id.tv_horizontal_negative);
        textView.setTextColor(zn1.a(R.color.color_8997A4));
        textView.setText(OptionsPickerHelper.e);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.um2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        TextView textView2 = (TextView) dialog.findViewById(R.id.tv_horizontal_positive);
        textView2.setTextColor(zn1.a(R.color.hcj_theme_txt_color));
        textView2.setText("确定");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vm2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogUtil.e(listener, dialog, editText, view);
            }
        });
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = jj8.b(312.0f, activity);
        window.setAttributes(attributes);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.wm2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogUtil.f(dialog, dialogInterface);
            }
        });
        dialog.show();
        return dialog;
    }

    public static Dialog D(Activity activity, String title, String hint, String content, int maxLength, EditDialogConfirmListener listener) {
        return C(activity, title, hint, content, maxLength, 1, listener);
    }

    public static Dialog E(Activity activity, String title, String content, String negativeTxt, String positiveTxt, int iconBgResId, int iconImageResId, boolean touchCancelable, boolean backCancelable, final PositiveNegativeClickListener clickListener) {
        IconAlertDialog iconAlertDialogK = new IconAlertDialog.f().L(320).M(iconBgResId).N(iconImageResId).b0(title).O(content).R(negativeTxt).V(positiveTxt).I(backCancelable).J(touchCancelable).Z(clickListener).k(activity);
        iconAlertDialogK.show();
        return iconAlertDialogK;
    }

    public static Dialog F(Activity activity, String content) {
        return J(activity, content, null, activity.getString(R.string.ok), false, false, null);
    }

    public static Dialog G(Activity activity, String content, String button, SingleClickListener listener) {
        return J(activity, content, null, button, false, false, listener);
    }

    public static Dialog H(Activity activity, String title, String content, String button, SingleClickListener listener) {
        return J(activity, title, content, button, false, false, listener);
    }

    public static Dialog I(Activity activity, String title, String content, String button, boolean cancelable, SingleClickListener listener) {
        return J(activity, title, content, button, cancelable, cancelable, listener);
    }

    public static Dialog J(Activity activity, String title, String content, String button, boolean touchCancelable, boolean backCancelable, final SingleClickListener clickListener) {
        CustomizeViewDialog.Builder builderU;
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || (builderU = u(title, content, button, touchCancelable, backCancelable, clickListener)) == null) {
            return null;
        }
        CustomizeViewDialog customizeViewDialogCreate = builderU.create(activity);
        customizeViewDialogCreate.show();
        return customizeViewDialogCreate;
    }

    public static Dialog K(Activity activity, String title, String content, String negativeButton, String positiveButton, boolean touchCancelable, boolean backCancelable, final PositiveNegativeClickListener clickListener) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        CustomizeViewDialog customizeViewDialogCreate = new CustomizeViewDialog.Builder().setDialogWidth(320).setTitle(title).setMessage(content).setPositive(positiveButton).setNegative(negativeButton).setCancelable(backCancelable).setCanceledOnTouchOutside(touchCancelable).setPositiveNegativeClickListener(clickListener).setOrientation(1).create(activity);
        customizeViewDialogCreate.show();
        return customizeViewDialogCreate;
    }

    public static /* synthetic */ void e(EditDialogConfirmListener editDialogConfirmListener, Dialog dialog, EditText editText, View view) {
        if (editDialogConfirmListener != null) {
            editDialogConfirmListener.a(dialog, editText.getText().toString());
        }
    }

    public static /* synthetic */ void f(Dialog dialog, DialogInterface dialogInterface) {
        KeyboardUtils.l(dialog.getWindow());
    }

    public static CustomizeViewDialog.Builder g(String content, String rightButton, PositiveNegativeClickListener listener) {
        return l(null, content, ys8.e(R.string.cancel), rightButton, true, true, listener, false);
    }

    public static CustomizeViewDialog.Builder h(String content, String leftButton, String rightButton, PositiveNegativeClickListener listener) {
        return l(null, content, leftButton, rightButton, true, true, listener, false);
    }

    public static CustomizeViewDialog.Builder i(String title, String content, String leftButton, String rightButton, PositiveNegativeClickListener listener) {
        return l(title, content, leftButton, rightButton, true, true, listener, false);
    }

    public static CustomizeViewDialog.Builder j(String title, String content, String leftButton, String rightButton, PositiveNegativeClickListener listener, boolean isNotKeep) {
        return l(title, content, leftButton, rightButton, true, true, listener, isNotKeep);
    }

    public static CustomizeViewDialog.Builder k(String title, String content, String leftButton, String rightButton, boolean cancelable, PositiveNegativeClickListener listener) {
        return l(title, content, leftButton, rightButton, cancelable, cancelable, listener, false);
    }

    public static CustomizeViewDialog.Builder l(String title, String content, String leftButton, String rightButton, boolean touchCancelable, boolean backCancelable, final PositiveNegativeClickListener clickListener, boolean isKeepOnActiveClicked) {
        return new CustomizeViewDialog.Builder().setDialogWidth(320).setTitle(title).setMessage(content).setPositive(rightButton).setNegative(leftButton).setCancelable(backCancelable).setClickPositiveKeepShow(isKeepOnActiveClicked).setCanceledOnTouchOutside(touchCancelable).setPositiveNegativeClickListener(clickListener);
    }

    public static Dialog m(Activity activity) {
        return n(activity, null);
    }

    public static Dialog n(Activity activity, String message) {
        return o(activity, message, true);
    }

    public static Dialog o(Activity activity, String message, boolean cancelable) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        Dialog dialog = new Dialog(activity, R.style.base_dialog_theme);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.getWindow().setDimAmount(0.0f);
        dialog.setContentView(R.layout.layout_loading_view);
        w(dialog, message);
        return dialog;
    }

    public static Dialog p(Activity activity, boolean cancelable) {
        return o(activity, null, cancelable);
    }

    public static CustomizeViewDialog.Builder q(String content) {
        return u(content, null, ys8.e(R.string.ok), false, false, null);
    }

    public static CustomizeViewDialog.Builder r(String content, String button, SingleClickListener listener) {
        return u(content, null, button, false, false, listener);
    }

    public static CustomizeViewDialog.Builder s(String title, String content, String button, SingleClickListener listener) {
        return u(title, content, button, false, false, listener);
    }

    public static CustomizeViewDialog.Builder t(String title, String content, String button, boolean cancelable, SingleClickListener listener) {
        return u(title, content, button, cancelable, cancelable, listener);
    }

    public static CustomizeViewDialog.Builder u(String title, String content, String button, boolean touchCancelable, boolean backCancelable, final SingleClickListener clickListener) {
        return new CustomizeViewDialog.Builder().setDialogWidth(320).setTitle(title).setMessage(content).setPositive(button).setCancelable(backCancelable).setCanceledOnTouchOutside(touchCancelable).setSingleClickListener(clickListener);
    }

    public static Dialog v(Activity activity, String message, boolean cancelable) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        Dialog dialog = new Dialog(activity, R.style.base_dialog_theme);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.getWindow().setDimAmount(0.3f);
        dialog.setContentView(R.layout.layout_loading_view);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_message);
        if (TextUtils.isEmpty(message)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(message);
        }
        return dialog;
    }

    public static Dialog w(Dialog dialog, String message) {
        if (dialog == null) {
            return null;
        }
        View viewFindViewById = dialog.findViewById(R.id.llRoot);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_message);
        if (TextUtils.isEmpty(message)) {
            textView.setVisibility(8);
            viewFindViewById.setBackground(null);
        } else {
            viewFindViewById.setBackgroundResource(R.drawable.shape_rectangle_loading_dialog_bg);
            textView.setVisibility(0);
            textView.setText(message);
        }
        return dialog;
    }

    public static Dialog x(Activity activity, String content, String rightButton, PositiveNegativeClickListener listener) {
        return B(activity, null, content, activity.getString(R.string.cancel), rightButton, true, true, listener);
    }

    public static Dialog y(Activity activity, String content, String leftButton, String rightButton, PositiveNegativeClickListener listener) {
        return B(activity, null, content, leftButton, rightButton, true, true, listener);
    }

    public static Dialog z(Activity activity, String title, String content, String leftButton, String rightButton, PositiveNegativeClickListener listener) {
        return B(activity, title, content, leftButton, rightButton, true, true, listener);
    }
}
