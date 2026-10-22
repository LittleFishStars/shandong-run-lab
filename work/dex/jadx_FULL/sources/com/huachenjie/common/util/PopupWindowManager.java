package com.huachenjie.common.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.annotation.LayoutRes;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class PopupWindowManager {
    protected ImageView imgClose;
    protected ViewGroup mContentView;
    protected Context mContext;
    protected FrameLayout mLayoutCustomer;
    protected OnPopupListener mListener;
    protected PopupWindow mPopupWindow;

    public interface OnPopupListener {
        void a();

        void onClose();

        void onDismiss();
    }

    public PopupWindowManager(Context context, @LayoutRes int rootResId, @LayoutRes int customerResId) {
        if (context == null) {
            return;
        }
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) onCreateView(context, rootResId);
        this.mContentView = viewGroup;
        viewGroup.setFocusableInTouchMode(true);
        this.mContentView.setOnKeyListener(new View.OnKeyListener() { // from class: com.zj.adlib.bv6
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f40845a.lambda$new$0(view, i, keyEvent);
            }
        });
        ImageView imageView = (ImageView) this.mContentView.findViewById(R.id.img_close);
        this.imgClose = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.cv6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41047a.lambda$new$1(view);
                }
            });
        }
        this.mLayoutCustomer = (FrameLayout) this.mContentView.findViewById(R.id.fl_customer_container);
        initCustomerView(customerResId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopupWindow$2() {
        OnPopupListener onPopupListener = this.mListener;
        if (onPopupListener != null) {
            onPopupListener.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(View view, int i, KeyEvent keyEvent) {
        PopupWindow popupWindow;
        if (i != 4 || (popupWindow = this.mPopupWindow) == null || !popupWindow.isShowing()) {
            return false;
        }
        this.mPopupWindow.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
        OnPopupListener onPopupListener = this.mListener;
        if (onPopupListener != null) {
            onPopupListener.onClose();
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception unused) {
        }
    }

    public ViewGroup getCustomerViewContainer() {
        return this.mLayoutCustomer;
    }

    public OnPopupListener getPopupListener() {
        return this.mListener;
    }

    public abstract void initCustomerView(int customerResId);

    public void initPopupWindow(int width, int height, Drawable backgroundDrawable, boolean focusable) {
        this.mPopupWindow = new PopupWindow(this.mContentView, width, height, focusable);
        setBackgroundDrawable(backgroundDrawable);
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.zj.adlib.av6
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f40620a.lambda$initPopupWindow$2();
            }
        });
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    public View onCreateView(Context context, int resId) {
        return LayoutInflater.from(context).inflate(resId, (ViewGroup) null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setBackgroundDrawable(drawable);
    }

    public void setPopupListener(OnPopupListener listener) {
        this.mListener = listener;
    }

    public void showAsDropDown(View parent, int xoff, int yoff) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.showAsDropDown(parent, xoff, yoff);
    }
}
