package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.letter.ImportantLettersDialog;
import com.huachenjie.base.dialog.letter.ImportantLettersVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class DialogLetterImportantBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebView f32822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f7011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ImportantLettersDialog.a f7012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ImportantLettersVM f7013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7015a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public DialogLetterImportantBinding(Object _bindingComponent, View _root, int _localFieldCount, BLLinearLayout llContainer, NestedScrollView scrollView, BLTextView tvButton, TextView tvDes, TextView tvIndex, TextView tvTime, TextView tvTitle, WebView webHtml) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7014a = llContainer;
        this.f7011a = scrollView;
        this.f7015a = tvButton;
        this.f7010a = tvDes;
        this.b = tvIndex;
        this.c = tvTime;
        this.d = tvTitle;
        this.f32822a = webHtml;
    }

    public static DialogLetterImportantBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogLetterImportantBinding d(@NonNull View view, @Nullable Object component) {
        return (DialogLetterImportantBinding) ViewDataBinding.bind(component, view, R.layout.dialog_letter_important);
    }

    @NonNull
    public static DialogLetterImportantBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogLetterImportantBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogLetterImportantBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogLetterImportantBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_letter_important, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static DialogLetterImportantBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogLetterImportantBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_letter_important, null, false, component);
    }

    @Nullable
    public ImportantLettersDialog.a f() {
        return this.f7012a;
    }

    @Nullable
    public ImportantLettersVM g() {
        return this.f7013a;
    }

    public abstract void l(@Nullable ImportantLettersDialog.a click);

    public abstract void m(@Nullable ImportantLettersVM vm);
}
