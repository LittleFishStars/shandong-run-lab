package android.taobao.windvane.embed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c extends BaseEmbedView {
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public View generateView(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundColor(-7829368);
        textView.setText("Empty View");
        textView.setTextColor(-65536);
        textView.setTextSize(30.0f);
        textView.setGravity(17);
        return textView;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return "empty";
    }
}
