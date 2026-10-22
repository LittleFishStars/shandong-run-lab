package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contrarywind.view.WheelView;
import com.huachenjie.run.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogIndexPickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f35540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WheelView f11727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11729a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public RunDialogIndexPickerBinding(@NonNull BLLinearLayout rootView, @NonNull CheckBox cbRemember, @NonNull TextView tvCancel, @NonNull TextView tvSave, @NonNull BLTextView tvStartRun, @NonNull TextView tvTitle, @NonNull WheelView wheelView) {
        this.f11728a = rootView;
        this.f35540a = cbRemember;
        this.f11726a = tvCancel;
        this.b = tvSave;
        this.f11729a = tvStartRun;
        this.c = tvTitle;
        this.f11727a = wheelView;
    }

    @NonNull
    public static RunDialogIndexPickerBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.cb_remember;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
        if (checkBox != null) {
            i = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_save;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_start_run))) != null) {
                    i = R.id.tv_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.wheel_view;
                        WheelView wheelView = (WheelView) ViewBindings.findChildViewById(rootView, i);
                        if (wheelView != null) {
                            return new RunDialogIndexPickerBinding((BLLinearLayout) rootView, checkBox, textView, textView2, bLTextViewFindChildViewById, textView3, wheelView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogIndexPickerBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogIndexPickerBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_index_picker, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.f11728a;
    }
}
