package com.huachenjie.common.reconfig.baseView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.R;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002&'B\u0007¢\u0006\u0004\b#\u0010$J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u001a\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/huachenjie/common/reconfig/baseView/IBaseView;", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "", "showAllowingStateLoss", "", "getWidth", "getHeight", "getGravity", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "initStyle", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onStart", "show", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setDialogFragmentListener", "mListener", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "<init>", "()V", "Companion", "a", "DialogFragmentListener", "common_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseDialogFragment extends DialogFragment implements IBaseView {
    public static final int MATCH = -1;
    public static final int WARP = -2;

    @Nullable
    private DialogFragmentListener mListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onDismiss", "", "onShow", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DialogFragmentListener {
        default void onDismiss() {
        }

        default void onShow() {
        }
    }

    private final void showAllowingStateLoss(FragmentManager manager, String tag) {
        try {
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        try {
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        FragmentTransaction fragmentTransactionBeginTransaction = manager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "manager.beginTransaction()");
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.add(this, tag);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public int getGravity() {
        return 17;
    }

    public abstract int getHeight();

    public abstract int getWidth();

    public void initStyle() {
        setStyle(1, R.style.dialog_style);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initStyle();
        super.onCreate(savedInstanceState);
        b(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getLayoutResID(), container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        DialogFragmentListener dialogFragmentListener = this.mListener;
        if (dialogFragmentListener != null) {
            dialogFragmentListener.onDismiss();
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = getGravity();
        }
        int width = getWidth();
        if (width != -2) {
            if (width != -1) {
                if (attributes != null) {
                    attributes.width = width;
                }
            } else if (attributes != null) {
                attributes.width = -1;
            }
        } else if (attributes != null) {
            attributes.width = -2;
        }
        int height = getHeight();
        if (height != -2) {
            if (height != -1) {
                if (attributes != null) {
                    attributes.height = height;
                }
            } else if (attributes != null) {
                attributes.height = -1;
            }
        } else if (attributes != null) {
            attributes.height = -2;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        DialogFragmentListener dialogFragmentListener = this.mListener;
        if (dialogFragmentListener != null) {
            dialogFragmentListener.onShow();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        onViewCreated();
    }

    public final void setDialogFragmentListener(@NotNull DialogFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.mListener = listener;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (manager.isStateSaved()) {
            showAllowingStateLoss(manager, tag);
        } else {
            super.show(manager, tag);
        }
    }

    public void onViewCreated() {
        initView();
        initData();
    }
}
