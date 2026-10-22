package com.byazt.omf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 121})
public class cu {
    public static int c = -1;
    public static final HashSet<String> tt;
    public static final HashSet<String> ve;

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        tt = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        ve = hashSet2;
    }

    public static void c(final Context context, final com.byazt.nl.uj ujVar) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.cu.1
            @Override // java.lang.Runnable
            public void run() {
                cu.tt(context, ujVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(com.byazt.nl.uj ujVar) {
        if (ujVar == null) {
            return;
        }
        ujVar.setWebChromeClient(null);
        ujVar.setWebViewClient(null);
        View view = ujVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        ujVar.removeAllViews();
        try {
            ujVar.destroy();
        } catch (Throwable unused) {
        }
    }

    public static void c(final com.byazt.nl.uj ujVar) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.cu.2
            @Override // java.lang.Runnable
            public void run() {
                cu.ve(ujVar);
            }
        });
    }

    public static void tt(Context context, com.byazt.nl.uj ujVar) {
        if (context == null || ujVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                ujVar.loadUrl("about:blank");
                if (c > 0) {
                    View rootView = ujVar.getView().getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
