package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.coroutines.DataBindingUtil;
import com.huachenjie.common.R;
import com.huachenjie.common.databinding.LayoutBottomIconViewBinding;
import com.zj.adlib.jj8;
import com.zj.adlib.xf7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class BottomIconView extends LinearLayout {
    private LayoutBottomIconViewBinding binding;

    public static class BottomIconBean {
        private Drawable checkedIconRes;
        private Drawable iconRes;
        private String text;

        @ColorInt
        private int textColor = -7829112;

        @ColorInt
        private int checkedTextColor = -15592431;
        private int textSize = jj8.a(10.0f);
        private int checkedTextSize = jj8.a(14.0f);
        private int iconSize = jj8.a(28.0f);
        private int checkedIconSize = jj8.a(44.0f);
        private boolean showRedDot = false;

        public BottomIconBean(@DrawableRes int iconRes, @DrawableRes int checkedIconRes, String text) {
            this.iconRes = xf7.f(iconRes);
            this.checkedIconRes = xf7.f(checkedIconRes);
            this.text = text;
        }

        public Drawable getCheckedIconRes() {
            return this.checkedIconRes;
        }

        public int getCheckedIconSize() {
            return this.checkedIconSize;
        }

        public int getCheckedTextColor() {
            return this.checkedTextColor;
        }

        public int getCheckedTextSize() {
            return this.checkedTextSize;
        }

        public Drawable getIconRes() {
            return this.iconRes;
        }

        public int getIconSize() {
            return this.iconSize;
        }

        public String getText() {
            return this.text;
        }

        public int getTextColor() {
            return this.textColor;
        }

        public int getTextSize() {
            return this.textSize;
        }

        public boolean isShowRedDot() {
            return this.showRedDot;
        }

        public void setCheckedIconRes(Drawable checkedIconRes) {
            this.checkedIconRes = checkedIconRes;
        }

        public void setCheckedIconSize(int checkedIconSize) {
            this.checkedIconSize = checkedIconSize;
        }

        public void setCheckedTextColor(int checkedTextColor) {
            this.checkedTextColor = checkedTextColor;
        }

        public void setCheckedTextSize(int checkedTextSize) {
            this.checkedTextSize = checkedTextSize;
        }

        public void setIconRes(Drawable iconRes) {
            this.iconRes = iconRes;
        }

        public void setIconSize(int iconSize) {
            this.iconSize = iconSize;
        }

        public void setShowRedDot(boolean showRedDot) {
            this.showRedDot = showRedDot;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setTextColor(int textColor) {
            this.textColor = textColor;
        }

        public void setTextSize(int textSize) {
            this.textSize = textSize;
        }
    }

    public BottomIconView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.binding = (LayoutBottomIconViewBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_bottom_icon_view, this, true);
    }

    public void checkRedDot(boolean selected) {
        BottomIconBean iconBean = getIconBean();
        if (selected) {
            this.binding.f8648a.setVisibility(8);
            if (!iconBean.showRedDot) {
                this.binding.b.setVisibility(8);
                return;
            } else {
                this.binding.b.setVisibility(0);
                this.binding.b.animate().alpha(1.0f).setDuration(200L).start();
                return;
            }
        }
        this.binding.b.setVisibility(8);
        this.binding.b.setAlpha(0.0f);
        if (iconBean.showRedDot) {
            this.binding.f8648a.setVisibility(0);
        } else {
            this.binding.f8648a.setVisibility(8);
        }
    }

    public BottomIconBean getIconBean() {
        return this.binding.g();
    }

    public void setIconBean(BottomIconBean bean) {
        this.binding.l(bean);
        this.binding.f8646a.setPivotX(bean.getIconSize() / 2.0f);
        this.binding.f8646a.setPivotY(bean.getIconSize());
    }

    public void setIconDrawables(Drawable icon, Drawable checkedIcon) {
        BottomIconBean iconBean = getIconBean();
        if (iconBean == null) {
            return;
        }
        iconBean.setIconRes(icon);
        iconBean.setCheckedIconRes(checkedIcon);
        this.binding.l(iconBean);
        this.binding.executePendingBindings();
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        BottomIconBean iconBean = getIconBean();
        this.binding.setChecked(Boolean.valueOf(selected));
        if (selected) {
            this.binding.f8647a.setTypeface(ResourcesCompat.getFont(getContext(), R.font.shandong_pht3));
            this.binding.f8646a.animate().scaleX(iconBean.getCheckedIconSize() / iconBean.getIconSize()).scaleY(iconBean.getCheckedIconSize() / iconBean.getIconSize()).setDuration(200L).start();
        } else {
            this.binding.f8647a.setTypeface(Typeface.DEFAULT);
            this.binding.f8646a.setScaleX(1.0f);
            this.binding.f8646a.setScaleY(1.0f);
        }
        checkRedDot(selected);
    }

    public BottomIconView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
}
