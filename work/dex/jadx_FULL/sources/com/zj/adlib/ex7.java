package com.zj.adlib;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import com.amap.api.maps.MapView;
import com.huachenjie.common.widget.xScrollView.XScrollViewWithNested;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ex7 {
    public static Bitmap a(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        int height = origin.getHeight();
        int width = origin.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap b(LinearLayout linearLayout) {
        int height = 0;
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            height += linearLayout.getChildAt(i).getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(linearLayout.getWidth(), height, Bitmap.Config.ARGB_8888);
        linearLayout.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap c(ListView listview) {
        ListAdapter adapter = listview.getAdapter();
        int count = adapter.getCount();
        ArrayList arrayList = new ArrayList();
        int measuredHeight = 0;
        for (int i = 0; i < count; i++) {
            View view = adapter.getView(i, null, listview);
            view.measure(View.MeasureSpec.makeMeasureSpec(listview.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            arrayList.add(view.getDrawingCache());
            measuredHeight += view.getMeasuredHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(listview.getMeasuredWidth(), measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        int height = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Bitmap bitmap = (Bitmap) arrayList.get(i2);
            canvas.drawBitmap(bitmap, 0.0f, height, paint);
            height += bitmap.getHeight();
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap d(Bitmap mapBitmap, View contentView, int mapHeight, Bitmap mark) {
        int width = contentView.getWidth();
        int height = contentView.getHeight();
        if (height <= 0 && (contentView instanceof LinearLayout)) {
            LinearLayout linearLayout = (LinearLayout) contentView;
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                height += linearLayout.getChildAt(i).getHeight();
            }
        }
        if (width <= 0 || height <= 0) {
            return mapBitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (contentView.getBackground() != null) {
            contentView.getBackground().setBounds(0, 0, width, height);
            contentView.getBackground().draw(canvas);
        }
        if (mapBitmap != null && mapHeight > 0) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(mapBitmap, width, mapHeight, true);
            canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, (Paint) null);
            if (bitmapCreateScaledBitmap != mapBitmap && !bitmapCreateScaledBitmap.isRecycled()) {
                bitmapCreateScaledBitmap.recycle();
            }
        }
        if (contentView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) contentView;
            for (int i2 = 1; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    canvas.save();
                    canvas.translate(childAt.getLeft(), childAt.getTop());
                    childAt.draw(canvas);
                    canvas.restore();
                }
            }
        }
        if (mark != null) {
            canvas.drawBitmap(mark, jj8.a(15.0f), jj8.a(19.0f), (Paint) null);
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap e(Bitmap bitmap, MapView mapView, XScrollViewWithNested scrollView, Bitmap mark) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(mapView.getWidth(), scrollView.getWidth()), Math.max(mapView.getHeight(), i(scrollView)), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(h(scrollView), 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(mark, jj8.a(15.0f), jj8.a(19.0f), (Paint) null);
        return bitmapCreateBitmap;
    }

    public static Bitmap f(ScrollView scrollView) {
        int height = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            height += scrollView.getChildAt(i).getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(scrollView.getWidth(), height, Bitmap.Config.ARGB_8888);
        scrollView.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap g(WebView webView) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(webView.getWidth(), webView.getContentHeight(), Bitmap.Config.ARGB_8888);
        webView.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap h(XScrollViewWithNested scrollView) {
        int height = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            height += scrollView.getChildAt(i).getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(scrollView.getWidth(), height, Bitmap.Config.ARGB_8888);
        scrollView.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static int i(XScrollViewWithNested scrollView) {
        int height = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            height += scrollView.getChildAt(i).getHeight();
        }
        return height;
    }

    public static Bitmap j(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        return Bitmap.createBitmap(decorView.getDrawingCache());
    }
}
