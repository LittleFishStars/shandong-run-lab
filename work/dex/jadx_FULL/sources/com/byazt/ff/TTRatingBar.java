package com.byazt.ff;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.nr.z;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 142, 1993})
public class TTRatingBar extends LinearLayout {
    public int c;
    public float n;
    public int tt;
    public float uj;
    public float ve;

    public TTRatingBar(Context context) {
        super(context);
        this.c = 5;
        this.tt = 0;
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.ve), Math.round(this.uj)));
        imageView.setPadding(0, 0, Math.round(this.n), 0);
        return imageView;
    }

    public int getStarEmptyNum() {
        return this.tt;
    }

    public int getStarFillNum() {
        return this.c;
    }

    public float getStarImageHeight() {
        return this.uj;
    }

    public float getStarImagePadding() {
        return this.n;
    }

    public float getStarImageWidth() {
        return this.ve;
    }

    public void setStarEmptyNum(int i) {
        this.tt = i;
    }

    public void setStarFillNum(int i) {
        this.c = i;
    }

    public void setStarImageHeight(float f) {
        this.uj = f;
    }

    public void setStarImagePadding(float f) {
        this.n = f;
    }

    public void setStarImageWidth(float f) {
        this.ve = f;
    }

    private void c(Context context) {
        setOrientation(0);
        this.ve = c(context, 15.0f);
        this.uj = c(context, 15.0f);
        this.n = c(context, 5.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        z.c(getContext(), "tt_star_empty_bg", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ff.TTRatingBar.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar.this.getContext().getResources(), bitmap);
                for (int i = 0; i < TTRatingBar.this.getStarEmptyNum(); i++) {
                    ImageView starImageView = TTRatingBar.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar.this.addView(starImageView);
                }
            }
        }, 320);
    }

    private int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void c() {
        removeAllViews();
        z.c(getContext(), "tt_star_full_bg", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ff.TTRatingBar.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar.this.getContext().getResources(), bitmap);
                for (int i = 0; i < TTRatingBar.this.getStarFillNum(); i++) {
                    ImageView starImageView = TTRatingBar.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar.this.addView(starImageView);
                }
                TTRatingBar.this.tt();
            }
        }, 320);
    }
}
