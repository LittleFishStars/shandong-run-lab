package com.huachenjie.home.page.draw;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.huachenjie.base.bean.ThemeConfigBean;
import com.huachenjie.common.widget.BottomIconView;
import com.zj.adlib.r90;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u0017H\u0002R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/huachenjie/home/page/draw/LotteryThemeConfigManager;", "", "Lcom/huachenjie/base/bean/ThemeConfigBean;", "d", "Landroid/widget/ImageView;", "imageView", "", "url", "", "fallbackRes", "", "i", "Lcom/huachenjie/common/widget/BottomIconView;", "flashCoinsTab", "f", "Landroid/content/Context;", "context", "config", "", "c", "j", "targetView", "imageUrl", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "onReady", y6b.g, "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "e", "()Landroidx/lifecycle/MutableLiveData;", "themeConfig", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nLotteryThemeConfigManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LotteryThemeConfigManager.kt\ncom/huachenjie/home/page/draw/LotteryThemeConfigManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1726#2,3:154\n766#2:157\n857#2,2:158\n1855#2,2:160\n*S KotlinDebug\n*F\n+ 1 LotteryThemeConfigManager.kt\ncom/huachenjie/home/page/draw/LotteryThemeConfigManager\n*L\n131#1:154,3\n143#1:157\n143#1:158,2\n143#1:160,2\n*E\n"})
public final class LotteryThemeConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final LotteryThemeConfigManager f9607a = new LotteryThemeConfigManager();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final MutableLiveData<ThemeConfigBean> themeConfig = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/home/page/draw/LotteryThemeConfigManager$a", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "", "onResourceReady", "placeholder", "onLoadCleared", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends CustomTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Drawable, Unit> f34345a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Drawable, Unit> function1) {
            this.f34345a = function1;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable placeholder) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
        }

        public void onResourceReady(@NotNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.f34345a.invoke(resource);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/home/page/draw/LotteryThemeConfigManager$b", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "", "onResourceReady", "errorDrawable", "onLoadFailed", "placeholder", "onLoadCleared", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends CustomTarget<Drawable> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f34346a;
        public final /* synthetic */ String f;

        public b(ImageView imageView, int i, String str) {
            this.f34346a = imageView;
            this.K = i;
            this.f = str;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable placeholder) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable errorDrawable) {
            this.f34346a.setImageResource(this.K);
            LotteryThemeConfigManager lotteryThemeConfigManager = LotteryThemeConfigManager.f9607a;
            Context context = this.f34346a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            lotteryThemeConfigManager.j(context, this.f);
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
        }

        public void onResourceReady(@NotNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.f34346a.setImageDrawable(resource);
        }
    }

    public static final void g(BottomIconView bottomIconView, Ref.ObjectRef<Drawable> objectRef, Ref.ObjectRef<Drawable> objectRef2) {
        BottomIconView.BottomIconBean iconBean = bottomIconView.getIconBean();
        if (iconBean == null) {
            return;
        }
        Object obj = objectRef.element;
        if (obj == null && objectRef2.element == null) {
            return;
        }
        Drawable iconRes = (Drawable) obj;
        if (iconRes == null) {
            iconRes = iconBean.getIconRes();
        }
        Drawable checkedIconRes = (Drawable) objectRef2.element;
        if (checkedIconRes == null) {
            checkedIconRes = iconBean.getCheckedIconRes();
        }
        bottomIconView.setIconDrawables(iconRes, checkedIconRes);
    }

    public final boolean c(@NotNull Context context, @NotNull ThemeConfigBean config) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        List listListOf = CollectionsKt.listOf(new String[]{config.getPageBgUrl(), config.getPagePromoUrl(), config.getBottomNavText(), config.getBottomNavImgUrl(), config.getBottomNavUnselectedImgUrl(), config.getLotteryDescUrl()});
        if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!StringsKt.isBlank((String) it.next())) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        if (z) {
            r90.b();
            themeConfig.setValue(new ThemeConfigBean(null, null, null, null, null, null, null, null, null, null, 1023, null));
            return false;
        }
        r90.T(new Gson().toJson(config));
        List listListOf2 = CollectionsKt.listOf(new String[]{config.getPageBgUrl(), config.getPagePromoUrl(), config.getBottomNavImgUrl(), config.getBottomNavUnselectedImgUrl(), config.getLotteryDescUrl()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf2) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Glide.with(context.getApplicationContext()).load((String) it2.next()).diskCacheStrategy(DiskCacheStrategy.ALL).preload();
        }
        themeConfig.setValue(config);
        return true;
    }

    @NotNull
    public final ThemeConfigBean d() {
        String strP = r90.p();
        Intrinsics.checkNotNullExpressionValue(strP, "configJson");
        if (StringsKt.isBlank(strP)) {
            return new ThemeConfigBean(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }
        try {
            ThemeConfigBean themeConfigBean = (ThemeConfigBean) new Gson().fromJson(strP, ThemeConfigBean.class);
            return themeConfigBean == null ? new ThemeConfigBean(null, null, null, null, null, null, null, null, null, null, 1023, null) : themeConfigBean;
        } catch (RuntimeException unused) {
            return new ThemeConfigBean(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }
    }

    @NotNull
    public final MutableLiveData<ThemeConfigBean> e() {
        return themeConfig;
    }

    public final void f(@NotNull final BottomIconView flashCoinsTab) {
        Intrinsics.checkNotNullParameter(flashCoinsTab, "flashCoinsTab");
        ThemeConfigBean themeConfigBeanD = d();
        String bottomNavImgUrl = themeConfigBeanD.getBottomNavImgUrl();
        String bottomNavUnselectedImgUrl = themeConfigBeanD.getBottomNavUnselectedImgUrl();
        if (StringsKt.isBlank(bottomNavImgUrl) && StringsKt.isBlank(bottomNavUnselectedImgUrl)) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (!StringsKt.isBlank(bottomNavUnselectedImgUrl)) {
            h(flashCoinsTab, bottomNavUnselectedImgUrl, new Function1<Drawable, Unit>() { // from class: com.huachenjie.home.page.draw.LotteryThemeConfigManager$loadCachedFlashCoinsNavIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Drawable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Drawable drawable) {
                    Intrinsics.checkNotNullParameter(drawable, "drawable");
                    Ref.ObjectRef<Drawable> objectRef3 = objectRef;
                    objectRef3.element = drawable;
                    LotteryThemeConfigManager.g(flashCoinsTab, objectRef3, objectRef2);
                }
            });
        }
        if (!StringsKt.isBlank(bottomNavImgUrl)) {
            h(flashCoinsTab, bottomNavImgUrl, new Function1<Drawable, Unit>() { // from class: com.huachenjie.home.page.draw.LotteryThemeConfigManager$loadCachedFlashCoinsNavIcon$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Drawable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Drawable drawable) {
                    Intrinsics.checkNotNullParameter(drawable, "drawable");
                    Ref.ObjectRef<Drawable> objectRef3 = objectRef2;
                    objectRef3.element = drawable;
                    LotteryThemeConfigManager.g(flashCoinsTab, objectRef, objectRef3);
                }
            });
        }
    }

    public final void h(BottomIconView targetView, String imageUrl, Function1<? super Drawable, Unit> onReady) {
        Glide.with(targetView).load(imageUrl).into(new a(onReady));
    }

    public final void i(@Nullable ImageView imageView, @NotNull String url, @DrawableRes int fallbackRes) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (imageView == null) {
            return;
        }
        Glide.with(imageView).clear(imageView);
        if (StringsKt.isBlank(url)) {
            imageView.setImageResource(fallbackRes);
        } else {
            imageView.setImageResource(fallbackRes);
            Glide.with(imageView).load(url).into(new b(imageView, fallbackRes, url));
        }
    }

    public final void j(Context context, String url) {
        Glide.with(context.getApplicationContext()).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).preload();
    }
}
