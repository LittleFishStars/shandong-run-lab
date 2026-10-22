package com.cicada.player.utils.ass;

import android.content.Context;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TextViewPool {
    private Context mContext;
    private List<AssTextView> idelTextViewList = new ArrayList();
    private List<AssTextView> busyTextViewList = new ArrayList();

    public TextViewPool(Context context) {
        this.mContext = context;
    }

    public AssTextView obtain() {
        AssTextView assTextView;
        if (this.idelTextViewList.isEmpty()) {
            assTextView = new AssTextView(this.mContext);
        } else {
            assTextView = this.idelTextViewList.get(0);
            this.idelTextViewList.remove(assTextView);
        }
        this.busyTextViewList.add(assTextView);
        return assTextView;
    }

    public void recycle(AssTextView assTextView) {
        if (assTextView == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) assTextView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(assTextView);
        }
        this.busyTextViewList.remove(assTextView);
        this.idelTextViewList.add(assTextView);
    }
}
