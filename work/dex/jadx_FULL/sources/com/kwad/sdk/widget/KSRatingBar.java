package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class KSRatingBar extends LinearLayout {
    private boolean btj;
    private boolean btk;
    private int btl;
    private int btm;
    private a btn;
    private float bto;
    private float btp;
    private float btq;
    private Drawable btr;
    private Drawable bts;
    private Drawable btt;
    private boolean btu;
    private int y;

    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.btu = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.btt = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.btr = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.bts = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.bto = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.btp = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.btq = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.btl = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.btm = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.btj = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.btk = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i = 0; i < this.btl; i++) {
            ImageView imageViewD = D(context, this.btu);
            imageViewD.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.btj) {
                        if (!KSRatingBar.this.btk) {
                            KSRatingBar kSRatingBar = KSRatingBar.this;
                            kSRatingBar.setStar(kSRatingBar.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.btn != null) {
                                a unused = KSRatingBar.this.btn;
                                KSRatingBar.this.indexOfChild(view);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.y % 2 == 0) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                        } else {
                            KSRatingBar kSRatingBar3 = KSRatingBar.this;
                            kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view) + 0.5f);
                        }
                        if (KSRatingBar.this.btn != null) {
                            if (KSRatingBar.this.y % 2 == 0) {
                                a unused2 = KSRatingBar.this.btn;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                            } else {
                                a unused3 = KSRatingBar.this.btn;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                            }
                        }
                    }
                }
            });
            addView(imageViewD);
        }
        setStar(this.btm);
    }

    private ImageView D(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.bto), Math.round(this.btp)));
        imageView.setPadding(0, 0, Math.round(this.btq), 0);
        if (z) {
            imageView.setImageDrawable(this.btr);
        } else {
            imageView.setImageDrawable(this.bts);
        }
        return imageView;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    public void setImagePadding(float f) {
        this.btq = f;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.btn = aVar;
    }

    public void setStar(float f) {
        int i = (int) f;
        float fFloatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.btl;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.bts);
        }
        if (fFloatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.btt);
            int i4 = this.btl;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                } else {
                    ((ImageView) getChildAt(i4)).setImageDrawable(this.btr);
                }
            }
        } else {
            int i5 = this.btl;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                } else {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.btr);
                }
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.btr = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.bts = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.btt = drawable;
    }

    public void setStarImageHeight(float f) {
        this.btp = f;
    }

    public void setStarImageWidth(float f) {
        this.bto = f;
    }

    public void setTotalStarCount(int i) {
        this.btl = i;
    }

    public void setmClickable(boolean z) {
        this.btj = z;
    }
}
