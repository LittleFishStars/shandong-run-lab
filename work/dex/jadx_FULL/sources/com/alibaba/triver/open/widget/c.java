package com.alibaba.triver.open.widget;

import android.R;
import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.kit.api.widget.action.IAppNameAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends Action implements IAppNameAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f25088a;
    private Page b;

    @Override // com.alibaba.triver.kit.api.widget.Action
    public void attatchPage(Page page) {
        super.attatchPage(page);
        this.b = page;
    }

    @Override // com.alibaba.triver.kit.api.widget.action.IAppNameAction
    public long getTitleColor() {
        return this.f25088a.getCurrentTextColor();
    }

    @Override // com.alibaba.triver.kit.api.widget.Action
    public View getView(Context context) {
        if (this.f25088a == null) {
            this.f25088a = new TextView(context);
            this.f25088a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f25088a.setLines(1);
            this.f25088a.setMaxLines(1);
            this.f25088a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
            this.f25088a.setEllipsize(TextUtils.TruncateAt.END);
            this.f25088a.setTextColor(context.getResources().getColor(R.color.white));
            this.f25088a.setTextSize(1, 18.0f);
            this.f25088a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.b != null && c.this.b.getApp() != null) {
                        c.this.b.getApp().sendGlobalEvent(RVEvents.TITLE_CLICK, null);
                    }
                    if (c.this.b != null) {
                        c.this.b.scrollToTop();
                    }
                }
            });
        }
        return this.f25088a;
    }

    @Override // com.alibaba.triver.kit.api.widget.action.IAppNameAction
    public void resetWith(boolean z) {
    }

    @Override // com.alibaba.triver.kit.api.widget.action.IAppNameAction
    public void setAppNameVisible(int i) {
    }

    @Override // com.alibaba.triver.kit.api.widget.action.IAppNameAction
    public void setName(String str) {
        TextView textView = this.f25088a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.Action
    public void setStyle(String str) {
        TextView textView = this.f25088a;
        if (textView != null) {
            textView.setTextColor(isDark(str) ? -16777216 : -1);
        }
    }
}
