package com.huachenjie.base.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.huachenjie.base.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class OperatePopupWindow extends PopupWindow implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short f32984a = 1001;
    public static final short b = 1002;
    public static final short c = 1003;
    public static final String f = "delete";
    public static final String g = "copy";
    public static final String h = "read";
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f7324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnClickCallback f7325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f7326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String> f7327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7328a;

    public interface OnClickCallback {
        void a(View view, int operateCode, Object params);
    }

    public OperatePopupWindow(Context context, int statusBarHeight) {
        super(context);
        this.f7327a = new ArrayList<>();
        this.L = statusBarHeight;
        g(context);
    }

    public final void a() {
        View view = this.f7324a;
        if (view == null) {
            return;
        }
        int i = R.id.iv_index_top;
        int i2 = 0;
        view.findViewById(i).setVisibility(this.f7328a ? 0 : 8);
        View view2 = this.f7324a;
        int i3 = R.id.iv_index_bottom;
        view2.findViewById(i3).setVisibility(this.f7328a ? 8 : 0);
        View viewFindViewById = this.f7328a ? this.f7324a.findViewById(i) : this.f7324a.findViewById(i3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.leftMargin = this.K;
        viewFindViewById.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) this.f7324a.findViewById(R.id.ll_container);
        linearLayout.removeAllViews();
        for (String str : this.f7327a) {
            if (i2 > 0) {
                linearLayout.addView(c(linearLayout.getContext()));
            }
            linearLayout.addView(b(linearLayout.getContext(), str));
            i2++;
        }
    }

    public final View b(Context context, String name) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 74.0f, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 70.0f, context.getResources().getDisplayMetrics()));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setTag(name);
        linearLayout.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics()));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(e(name));
        linearLayout.addView(imageView, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        textView.setText(f(name));
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        layoutParams3.topMargin = (int) TypedValue.applyDimension(1, 6.0f, context.getResources().getDisplayMetrics());
        linearLayout.addView(textView, layoutParams3);
        return linearLayout;
    }

    public final View c(Context context) {
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics()), -1);
        layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics());
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics());
        view.setBackgroundColor(Color.parseColor("#545454"));
        view.setLayoutParams(layoutParams);
        return view;
    }

    public final int d(View view) {
        Object tag;
        if (view == null || (tag = view.getTag()) == null || !(tag instanceof String)) {
            return 0;
        }
        switch ((String) tag) {
            case "delete":
                return 1001;
            case "copy":
                return 1002;
            case "read":
                return 1003;
            default:
                return 0;
        }
    }

    public final int e(String name) {
        if (TextUtils.isEmpty(name)) {
            return 0;
        }
        name.hashCode();
        switch (name) {
            case "delete":
                return R.mipmap.ic_chat_operate_delete;
            case "copy":
                return R.mipmap.ic_chat_operate_copy;
            case "read":
                return R.mipmap.ic_chat_operate_read;
            default:
                return 0;
        }
    }

    public final String f(String name) {
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        name.hashCode();
        switch (name) {
            case "delete":
                return "删除";
            case "copy":
                return "复制";
            case "read":
                return "已读";
            default:
                return "";
        }
    }

    public final void g(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.popupwindow_delete_chat, (ViewGroup) null);
        this.f7324a = viewInflate;
        setContentView(viewInflate);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setTouchable(true);
        a();
    }

    public void h(OnClickCallback callback) {
        this.f7325a = callback;
    }

    public void i(Object params) {
        this.f7326a = params;
    }

    public void j(View mTagView, String... items) {
        if (isShowing()) {
            return;
        }
        this.f7327a.clear();
        for (String str : items) {
            this.f7327a.add(str);
        }
        int width = mTagView.getWidth();
        int height = mTagView.getHeight();
        int[] iArr = new int[2];
        mTagView.getLocationInWindow(iArr);
        float fApplyDimension = TypedValue.applyDimension(1, 74.0f, mTagView.getResources().getDisplayMetrics());
        float fApplyDimension2 = TypedValue.applyDimension(1, 10.0f, mTagView.getResources().getDisplayMetrics());
        boolean z = ((float) (iArr[1] - this.L)) < fApplyDimension;
        this.f7328a = z;
        int i = z ? 0 : (int) (-(height + fApplyDimension));
        this.K = (int) (((this.f7327a.size() * fApplyDimension) - fApplyDimension2) / 2.0f);
        int size = ((int) (width - (fApplyDimension * this.f7327a.size()))) / 2;
        a();
        showAsDropDown(mTagView, size, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        dismiss();
        OnClickCallback onClickCallback = this.f7325a;
        if (onClickCallback != null) {
            onClickCallback.a(v, d(v), this.f7326a);
        }
    }
}
