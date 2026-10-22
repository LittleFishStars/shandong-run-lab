package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coroutines.BindingAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class aw9 {
    public static /* synthetic */ void b(View view, CharSequence charSequence) {
        Drawable drawable;
        try {
            TextPaint paint = ((ExpandableTextView) view).getPaint();
            int width = view.getWidth();
            int textMinLine = ((ExpandableTextView) view).getTextMinLine();
            int textMaxLine = ((ExpandableTextView) view).getTextMaxLine();
            int buttonTextColor = ((ExpandableTextView) view).getButtonTextColor();
            boolean closeInNewLine = ((ExpandableTextView) view).getCloseInNewLine();
            int expandableIcon = ((ExpandableTextView) view).getExpandableIcon();
            boolean showExpandText = ((ExpandableTextView) view).getShowExpandText();
            try {
                drawable = view.getContext().getDrawable(expandableIcon);
            } catch (Exception unused) {
                drawable = null;
            }
            ExpandableText expandableTextD = v39.d(charSequence, paint, width, textMinLine, textMaxLine, buttonTextColor, closeInNewLine, drawable, showExpandText);
            ((ExpandableTextView) view).setExpandText(expandableTextD.e(), expandableTextD.f());
            ((ExpandableTextView) view).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BindingAdapter(requireAll = false, value = {"avatarFrameUrl", "frameOption"})
    public static void c(View view, String avatarFrameUrl, RequestOptions frameOption) {
        if (view instanceof AvatarView) {
            if (frameOption == null) {
                ((AvatarView) view).loadAvatarFrame(avatarFrameUrl);
            } else {
                ((AvatarView) view).loadAvatarFrame(avatarFrameUrl, frameOption);
            }
        }
    }

    @BindingAdapter(requireAll = false, value = {AvatarFragment.AVATAR_URL, "noPlaceholder", "avatarOption"})
    public static void d(View view, String avatarUrl, boolean noPlaceholder, RequestOptions avatarOption) {
        if (view instanceof AvatarView) {
            if (noPlaceholder) {
                ((AvatarView) view).loadAvatar(avatarUrl, ju3.c);
            } else if (avatarOption == null) {
                ((AvatarView) view).loadAvatar(avatarUrl);
            } else {
                ((AvatarView) view).loadAvatar(avatarUrl, avatarOption);
            }
        }
    }

    @BindingAdapter({"backgroundGradientColor"})
    public static void e(View view, int backgroundColor) {
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(backgroundColor);
        } else {
            view.setBackgroundColor(backgroundColor);
        }
    }

    @BindingAdapter({"expandableText"})
    public static void f(final View view, final CharSequence expandText) {
        if (view != null && (view instanceof ExpandableTextView)) {
            view.postDelayed(new Runnable() { // from class: com.zj.adlib.xv9
                @Override // java.lang.Runnable
                public final void run() {
                    aw9.b(view, expandText);
                }
            }, 64L);
        }
    }

    @BindingAdapter({"layoutWeight"})
    public static void g(View view, int layoutWeight) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof LinearLayout.LayoutParams)) {
            return;
        }
        ((LinearLayout.LayoutParams) layoutParams).weight = layoutWeight;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter(requireAll = false, value = {"gifUrl", "option", "resId"})
    public static void h(ImageView view, final String url, RequestOptions requestOptions, int resId) {
        RequestBuilder<Drawable> requestBuilderLoad;
        RequestManager requestManagerWith = Glide.with(view);
        if (url != null && url.endsWith(".gif")) {
            requestManagerWith.asGif();
        }
        requestManagerWith.load(url == null ? "" : url);
        if (TextUtils.isEmpty(url)) {
            requestBuilderLoad = requestManagerWith.load(Integer.valueOf(resId));
        } else {
            if (url == null) {
                url = "";
            }
            requestBuilderLoad = requestManagerWith.load(url);
        }
        if (requestOptions != null) {
            requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptions);
        }
        requestBuilderLoad.into(view);
    }

    @BindingAdapter({"webpUrl"})
    public static void i(ImageView view, final String url) {
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(view).load(url == null ? "" : url);
        if (url != null && url.endsWith(".webp")) {
            requestBuilderLoad.optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new CenterCrop()));
        }
        requestBuilderLoad.into(view);
    }
}
