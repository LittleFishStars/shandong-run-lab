package com.byazt.ff;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.nr.z;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 142, 1011})
public class TTRatingBar2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28541a;
    public LinearLayout c;
    public int i;
    public double n;
    public int sp;
    public LinearLayout tt;
    public int uj;
    public int ve;
    public int x;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new LinearLayout(getContext());
        this.tt = new LinearLayout(getContext());
        this.c.setOrientation(0);
        this.c.setGravity(GravityCompat.START);
        this.tt.setOrientation(0);
        this.tt.setGravity(GravityCompat.START);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ve, this.uj);
        layoutParams.leftMargin = this.f28541a;
        layoutParams.topMargin = this.sp;
        layoutParams.rightMargin = this.x;
        layoutParams.bottomMargin = this.i;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c.measure(i, i2);
        double dFloor = Math.floor(this.n);
        int i3 = this.f28541a;
        int i4 = this.x + i3;
        int i5 = this.ve;
        this.tt.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.n - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.c.getMeasuredHeight(), 1073741824));
    }

    public void setRating(double d) {
        this.n = d;
    }

    public void c(int i, int i2) {
        this.ve = i2;
        this.uj = i;
    }

    public void c() {
        removeAllViews();
        z.c(getContext(), "tt_ratingbar_full_star2", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ff.TTRatingBar2.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.tt.addView(starImageView);
                }
            }
        }, 320);
        z.c(getContext(), "tt_ratingbar_empty_star2", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ff.TTRatingBar2.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.c.addView(starImageView);
                }
            }
        }, 320);
        addView(this.c);
        addView(this.tt);
        requestLayout();
    }

    public void c(int i, int i2, int i3, int i4) {
        this.f28541a = i;
        this.sp = i2;
        this.x = i3;
        this.i = i4;
    }
}
