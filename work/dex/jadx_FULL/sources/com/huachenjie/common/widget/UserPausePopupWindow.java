package com.huachenjie.common.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.huachenjie.common.R;
import com.huachenjie.common.util.PopupWindowManager;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class UserPausePopupWindow extends PopupWindowManager {
    private TextView mTvPauseWarn;

    public UserPausePopupWindow(Context context, @LayoutRes int rootResId, @LayoutRes int customerResId) {
        super(context, rootResId, customerResId);
    }

    @Override // com.huachenjie.common.util.PopupWindowManager
    public void initCustomerView(int customerResId) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        View viewOnCreateView = onCreateView(context, customerResId);
        if (viewOnCreateView != null) {
            this.mTvPauseWarn = (TextView) viewOnCreateView.findViewById(R.id.tv_pause_warn);
            getCustomerViewContainer().addView(viewOnCreateView);
        }
        viewOnCreateView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.UserPausePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (UserPausePopupWindow.this.getPopupListener() != null) {
                    UserPausePopupWindow.this.getPopupListener().a();
                }
            }
        });
    }

    public void setLastedDuration(long duration) {
        Context context = this.mContext;
        if (((context instanceof Activity) && ((Activity) context).isDestroyed()) || this.mTvPauseWarn == null) {
            return;
        }
        this.mTvPauseWarn.setText(String.format(this.mContext.getString(R.string.user_pause_warn), s72.k(duration)));
    }

    @Override // com.huachenjie.common.util.PopupWindowManager
    public void showAsDropDown(View parent, int xoff, int yoff) {
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        super.showAsDropDown(parent, xoff, yoff);
    }
}
