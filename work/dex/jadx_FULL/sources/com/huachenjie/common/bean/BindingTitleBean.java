package com.huachenjie.common.bean;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import com.huachenjie.common.R;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BindingTitleBean {
    private float alpha;
    private View.OnClickListener backClick;

    @DrawableRes
    private int backIconResId;
    private boolean backShow;

    @ColorInt
    private Integer backTintColor;

    @ColorInt
    private int background;
    private View.OnClickListener leftSubIconClick;

    @DrawableRes
    private int leftSubIconResId;
    private boolean leftSubIconShow;

    @ColorInt
    private Integer leftSubIconTintColor;

    @IdRes
    private int rightButtonBackground;
    private String rightButtonText;

    @ColorInt
    private int rightButtonTextColor;
    private View.OnClickListener rightIconClick;

    @IdRes
    private int rightIconResId;

    @ColorInt
    private Integer rightIconTintColor;
    private View.OnClickListener rightSubIconClick;

    @IdRes
    private int rightSubIconResId;

    @ColorInt
    private Integer rightSubIconTintColor;
    private View.OnClickListener rightTextClick;
    private boolean showDivider;
    private boolean showRightIcon;
    private boolean showRightIconNew;
    private boolean showRightSubIcon;
    private boolean showRightSubIconNew;
    private boolean showRightText;
    private int statusBarHeight = 0;
    private String titleName = "";

    @ColorInt
    private int titleTextColor;

    public BindingTitleBean() {
        int i = R.color.white;
        this.titleTextColor = zn1.a(i);
        this.backShow = true;
        this.backTintColor = null;
        this.backIconResId = R.drawable.ic_back;
        this.leftSubIconShow = false;
        this.leftSubIconTintColor = null;
        this.leftSubIconResId = R.drawable.ic_home;
        this.showDivider = false;
        this.background = zn1.a(R.color.transparent);
        this.showRightText = false;
        this.rightButtonText = "";
        this.rightButtonTextColor = zn1.a(i);
        this.showRightIcon = false;
        this.showRightIconNew = false;
        this.rightIconResId = 0;
        this.rightIconTintColor = null;
        this.showRightSubIcon = false;
        this.showRightSubIconNew = false;
        this.rightSubIconResId = 0;
        this.rightSubIconTintColor = null;
        this.alpha = 1.0f;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public View.OnClickListener getBackClick() {
        return this.backClick;
    }

    public int getBackIconResId() {
        return this.backIconResId;
    }

    public Integer getBackTintColor() {
        return this.backTintColor;
    }

    public int getBackground() {
        return this.background;
    }

    public View.OnClickListener getLeftSubIconClick() {
        return this.leftSubIconClick;
    }

    public int getLeftSubIconResId() {
        return this.leftSubIconResId;
    }

    public Integer getLeftSubIconTintColor() {
        return this.leftSubIconTintColor;
    }

    public int getRightButtonBackground() {
        return this.rightButtonBackground;
    }

    public String getRightButtonText() {
        return this.rightButtonText;
    }

    public int getRightButtonTextColor() {
        return this.rightButtonTextColor;
    }

    public View.OnClickListener getRightIconClick() {
        return this.rightIconClick;
    }

    public int getRightIconResId() {
        return this.rightIconResId;
    }

    public Integer getRightIconTintColor() {
        return this.rightIconTintColor;
    }

    public View.OnClickListener getRightSubIconClick() {
        return this.rightSubIconClick;
    }

    public int getRightSubIconResId() {
        return this.rightSubIconResId;
    }

    public Integer getRightSubIconTintColor() {
        return this.rightSubIconTintColor;
    }

    public View.OnClickListener getRightTextClick() {
        return this.rightTextClick;
    }

    public int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public int getTitleTextColor() {
        return this.titleTextColor;
    }

    public boolean isBackShow() {
        return this.backShow;
    }

    public boolean isLeftSubIconShow() {
        return this.leftSubIconShow;
    }

    public boolean isShowDivider() {
        return this.showDivider;
    }

    public boolean isShowRightIcon() {
        return this.showRightIcon;
    }

    public boolean isShowRightIconNew() {
        return this.showRightIconNew;
    }

    public boolean isShowRightSubIcon() {
        return this.showRightSubIcon;
    }

    public boolean isShowRightSubIconNew() {
        return this.showRightSubIconNew;
    }

    public boolean isShowRightText() {
        return this.showRightText;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public BindingTitleBean setBackClick(View.OnClickListener backClick) {
        this.backClick = backClick;
        return this;
    }

    public BindingTitleBean setBackIconResId(int backIconResId) {
        this.backIconResId = backIconResId;
        return this;
    }

    public BindingTitleBean setBackShow(boolean backShow) {
        this.backShow = backShow;
        return this;
    }

    public BindingTitleBean setBackTintColor(Integer backTintColor) {
        this.backTintColor = backTintColor;
        return this;
    }

    public BindingTitleBean setBackground(int background) {
        this.background = background;
        return this;
    }

    public BindingTitleBean setLeftSubIconClick(View.OnClickListener leftSubIconClick) {
        this.leftSubIconClick = leftSubIconClick;
        return this;
    }

    public BindingTitleBean setLeftSubIconResId(int leftSubIconResId) {
        this.leftSubIconResId = leftSubIconResId;
        return this;
    }

    public BindingTitleBean setLeftSubIconShow(boolean leftSubIconShow) {
        this.leftSubIconShow = leftSubIconShow;
        return this;
    }

    public BindingTitleBean setLeftSubIconTintColor(Integer leftSubIconTintColor) {
        this.leftSubIconTintColor = leftSubIconTintColor;
        return this;
    }

    public BindingTitleBean setRightButtonBackground(int rightButtonBackground) {
        this.rightButtonBackground = rightButtonBackground;
        return this;
    }

    public BindingTitleBean setRightButtonText(String rightButtonText) {
        this.rightButtonText = rightButtonText;
        return this;
    }

    public BindingTitleBean setRightButtonTextColor(int rightButtonTextColor) {
        this.rightButtonTextColor = rightButtonTextColor;
        return this;
    }

    public BindingTitleBean setRightIconClick(View.OnClickListener rightIconClick) {
        this.rightIconClick = rightIconClick;
        return this;
    }

    public BindingTitleBean setRightIconResId(int rightIconResId) {
        this.rightIconResId = rightIconResId;
        return this;
    }

    public BindingTitleBean setRightIconTintColor(Integer rightIconTintColor) {
        this.rightIconTintColor = rightIconTintColor;
        return this;
    }

    public BindingTitleBean setRightSubIconClick(View.OnClickListener rightSubIconClick) {
        this.rightSubIconClick = rightSubIconClick;
        return this;
    }

    public BindingTitleBean setRightSubIconResId(int rightSubIconResId) {
        this.rightSubIconResId = rightSubIconResId;
        return this;
    }

    public BindingTitleBean setRightSubIconTintColor(Integer rightSubIconTintColor) {
        this.rightSubIconTintColor = rightSubIconTintColor;
        return this;
    }

    public BindingTitleBean setRightTextClick(View.OnClickListener rightTextClick) {
        this.rightTextClick = rightTextClick;
        return this;
    }

    public BindingTitleBean setShowDivider(boolean showDivider) {
        this.showDivider = showDivider;
        return this;
    }

    public BindingTitleBean setShowRightIcon(boolean showRightIcon) {
        this.showRightIcon = showRightIcon;
        return this;
    }

    public BindingTitleBean setShowRightIconNew(boolean showRightIconNew) {
        this.showRightIconNew = showRightIconNew;
        return this;
    }

    public BindingTitleBean setShowRightSubIcon(boolean showRightSubIcon) {
        this.showRightSubIcon = showRightSubIcon;
        return this;
    }

    public BindingTitleBean setShowRightSubIconNew(boolean showRightSubIconNew) {
        this.showRightSubIconNew = showRightSubIconNew;
        return this;
    }

    public BindingTitleBean setShowRightText(boolean showRightText) {
        this.showRightText = showRightText;
        return this;
    }

    public BindingTitleBean setStatusBarHeight(int statusBarHeight) {
        this.statusBarHeight = statusBarHeight;
        return this;
    }

    public BindingTitleBean setTitleName(String titleName) {
        this.titleName = titleName;
        return this;
    }

    public BindingTitleBean setTitleTextColor(@ColorInt int titleTextColor) {
        this.titleTextColor = titleTextColor;
        return this;
    }
}
