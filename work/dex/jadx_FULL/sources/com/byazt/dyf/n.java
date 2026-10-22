package com.byazt.dyf;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ff.FlowLayout;
import com.byazt.nc.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 746, 46})
public class n extends BaseAdapter {
    public com.byazt.dyf.c c;
    public boolean n;
    public final List<a> tt;
    public c uj;
    public final Context ve;

    public interface c {
        void c(int i, a aVar);
    }

    @com.byazt.zqa.c(c = {0, 1, 746, 934})
    public class tt {
        public ImageView c;
        public TextView tt;
        public FrameLayout uj;
        public FlowLayout ve;

        private tt() {
        }
    }

    public n(Context context, List<a> list, boolean z, com.byazt.dyf.c cVar) {
        this.n = z;
        this.c = cVar;
        this.tt = list == null ? new ArrayList(0) : new ArrayList(list);
        this.ve = context != null ? context.getApplicationContext() : context;
    }

    private TextView tt() {
        TextView textView = new TextView(this.ve);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.byazt.pr.uj ujVarTt = com.byazt.pr.c.tt();
        marginLayoutParams.setMargins(0, 0, ujVarTt.c(this.ve, 8.0f), ujVarTt.c(this.ve, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iC = ujVarTt.c(this.ve, 21.0f);
        int iC2 = ujVarTt.c(this.ve, 6.0f);
        textView.setPadding(iC, iC2, iC, iC2);
        GradientDrawable gradientDrawableC = c(Color.parseColor("#0A161823"));
        gradientDrawableC.setCornerRadius(ujVarTt.c(this.ve, 4.0f));
        textView.setBackground(gradientDrawableC);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a> list = this.tt;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.tt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewTt;
        tt ttVar;
        FrameLayout frameLayout;
        com.byazt.dyf.c cVar;
        String str;
        if (view == null) {
            ttVar = new tt();
            viewTt = com.byazt.vfu.uj.tt(this.ve, this.n);
            ttVar.tt = (TextView) viewTt.findViewById(2047279094);
            ttVar.ve = (FlowLayout) viewTt.findViewById(2047279092);
            if (this.n) {
                ttVar.c = (ImageView) viewTt.findViewById(2047279093);
                ttVar.uj = (FrameLayout) viewTt.findViewById(2047279091);
            }
            viewTt.setTag(ttVar);
        } else {
            viewTt = view;
            ttVar = (tt) view.getTag();
        }
        a aVar = this.tt.get(i);
        String id = aVar.getId();
        ImageView imageView = ttVar.c;
        if (imageView != null && id != null && (cVar = this.c) != null) {
            switch (id) {
                case "4:1":
                    str = "bu_fd_no_interest";
                    break;
                case "6:0":
                    str = "bu_fd_report";
                    break;
                case "7:1":
                    str = "bu_fd_no_close";
                    break;
                default:
                    str = "bu_fd_other";
                    break;
            }
            cVar.c(imageView, "dislike/" + str + ".png");
        }
        FrameLayout frameLayout2 = ttVar.uj;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        ttVar.tt.setText(aVar.getName());
        if (aVar.hasSecondOptions()) {
            ttVar.ve.removeAllViews();
            List<a> options = aVar.getOptions();
            for (int i2 = 0; i2 < options.size(); i2++) {
                final a aVar2 = options.get(i2);
                TextView textViewTt = tt();
                textViewTt.setText(aVar2.getName());
                textViewTt.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.dyf.n.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (n.this.uj != null) {
                            n.this.uj.c(i, aVar2);
                        }
                    }
                });
                ttVar.ve.addView(textViewTt);
            }
            ttVar.ve.setVisibility(0);
        } else if ("99:1".equals(aVar.getId()) && this.n && (frameLayout = ttVar.uj) != null) {
            frameLayout.removeAllViews();
            ttVar.uj.setVisibility(0);
            ttVar.uj.addView(c(i, aVar));
            ttVar.ve.setVisibility(8);
        } else {
            ttVar.tt.setBackground(c());
            ttVar.ve.setVisibility(8);
        }
        return viewTt;
    }

    private StateListDrawable c() {
        GradientDrawable gradientDrawableC = c(Color.parseColor("#FDE6E6E6"));
        GradientDrawable gradientDrawableC2 = c(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawableC);
        stateListDrawable.addState(new int[0], gradientDrawableC2);
        return stateListDrawable;
    }

    private GradientDrawable c(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private View c(final int i, final a aVar) {
        com.byazt.pr.uj ujVarTt = com.byazt.pr.c.tt();
        LinearLayout linearLayout = new LinearLayout(this.ve);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        TextView textView = new TextView(this.ve);
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setText("无法关闭、展示异常等问题，需复制广告ID，在应用内反馈上报问题");
        textView.setTextColor(Color.parseColor("#80161823"));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.ve);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.dyf.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.uj != null) {
                    n.this.uj.c(i, aVar);
                }
            }
        });
        textView2.setText("点击复制广告ID");
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        GradientDrawable gradientDrawableC = c(Color.parseColor("#0A161823"));
        gradientDrawableC.setCornerRadius(ujVarTt.c(this.ve, 4.0f));
        textView2.setBackground(gradientDrawableC);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ujVarTt.c(this.ve, 32.0f));
        layoutParams.setMargins(0, ujVarTt.c(this.ve, 12.0f), 0, ujVarTt.c(this.ve, 12.0f));
        linearLayout.addView(textView2, layoutParams);
        linearLayout.setClickable(false);
        return linearLayout;
    }

    public void c(c cVar) {
        this.uj = cVar;
    }

    public void c(List<a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.tt.clear();
        this.tt.addAll(list);
        notifyDataSetChanged();
    }
}
