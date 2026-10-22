package com.aliyun.svideosdk.editor.e;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.aliyun.svideosdk.common.struct.asset.TypefaceConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class e {

    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".ttf");
        }
    }

    private static int a(TextView textView) {
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return (int) (fontMetrics.descent - fontMetrics.ascent);
    }

    private static TypefaceConfig a(String str) {
        TypefaceConfig typefaceConfig;
        if (TextUtils.isEmpty(str)) {
            return new TypefaceConfig();
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                typefaceConfig = new TypefaceConfig(Typeface.createFromFile(str));
            } else {
                File parentFile = file.getParentFile();
                String[] list = parentFile.list(new a());
                if (list == null || list.length <= 0) {
                    typefaceConfig = new TypefaceConfig();
                } else {
                    File file2 = new File(parentFile, list[0]);
                    if (file2.exists()) {
                        typefaceConfig = new TypefaceConfig(Typeface.createFromFile(file2));
                    } else {
                        Log.e("AliYunLog", "Font file[" + file2.getAbsolutePath() + "] not exist!");
                        typefaceConfig = new TypefaceConfig();
                    }
                }
            }
            return typefaceConfig;
        } catch (Exception e) {
            Log.e("AliYunLog", "Load font error!", e);
            return new TypefaceConfig();
        }
    }

    public static d.c a(Context context, String str, c cVar, int i, int i2) {
        com.aliyun.svideosdk.editor.e.f.b bVar = new com.aliyun.svideosdk.editor.e.f.b(context);
        bVar.setMaxLines(1);
        bVar.setMinTextSize(8);
        bVar.setTextSize(cVar.e(), cVar.d());
        bVar.setMaxTextSize(96.0f);
        bVar.setText(str);
        bVar.setTypeface(a(cVar.a()).typeface);
        int i3 = i / 10;
        int i4 = i / 20;
        bVar.measure(View.MeasureSpec.makeMeasureSpec((i - i3) - ((int) (i4 + ((new Random().nextInt(100) / 100.0f) * ((i / 5) - i4)))), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        bVar.layout(0, 0, bVar.getMeasuredWidth(), bVar.getMeasuredHeight());
        d.c cVar2 = new d.c();
        cVar2.f25717a = (int) bVar.getTextSize();
        cVar2.f = b(bVar);
        int iA = a(bVar);
        cVar2.g = iA;
        int i5 = cVar2.f;
        cVar2.d = i5;
        cVar2.e = iA;
        cVar2.b = i3 + (i5 / 2);
        cVar2.c = i2 / 2;
        return cVar2;
    }

    private static int b(TextView textView) {
        Layout layout = textView.getLayout();
        return layout != null ? layout.getWidth() : textView.getMeasuredWidth();
    }
}
