package com.zj.adlib;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/zj/adlib/hg0;", "", "Landroid/view/View;", "view", "Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "b", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class hg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final hg0 f42120a = new hg0();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/zj/adlib/hg0$a", "Lcom/huachenjie/im/audio/ImAudioPlayCallback;", "", "uuid", "", "b", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements ImAudioPlayCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f42121a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BroadcastFloorMessageBean f16983a;

        public a(View view, BroadcastFloorMessageBean broadcastFloorMessageBean) {
            this.f42121a = view;
            this.f16983a = broadcastFloorMessageBean;
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void a(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            hg0.f42120a.b(this.f42121a, this.f16983a);
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void b(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            View view = this.f42121a;
            if (view instanceof ViewGroup) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) view;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) viewGroup.findViewById(R.id.jsonAudio);
                if (lottieAnimationView != null) {
                    Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "findViewById<LottieAnimationView>(R.id.jsonAudio)");
                    lottieAnimationView.playAnimation();
                }
                ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ivIcon);
                if (imageView != null) {
                    Intrinsics.checkNotNullExpressionValue(imageView, "findViewById<ImageView>(R.id.ivIcon)");
                    imageView.setImageResource(R.drawable.works_ic_broadcast_message_voice_stop);
                }
            }
        }
    }

    public final void a(@NotNull View view, @NotNull BroadcastFloorMessageBean bean) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        i4a.c("playAudio ??? " + view);
        if (view instanceof ViewGroup) {
            String audioUrl = bean.formatAudioUrl();
            f64.b().i(((ViewGroup) view).getContext(), audioUrl, m55.c(audioUrl), new a(view, bean));
        }
    }

    public final void b(@NotNull View view, @NotNull BroadcastFloorMessageBean bean) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        f64.b().k(m55.c(bean.formatAudioUrl()));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) viewGroup.findViewById(R.id.jsonAudio);
            if (lottieAnimationView != null) {
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "findViewById<LottieAnimationView>(R.id.jsonAudio)");
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setProgress(0.0f);
            }
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ivIcon);
            if (imageView != null) {
                Intrinsics.checkNotNullExpressionValue(imageView, "findViewById<ImageView>(R.id.ivIcon)");
                imageView.setImageResource(R.drawable.works_ic_broadcast_message_voice_start);
            }
        }
    }
}
