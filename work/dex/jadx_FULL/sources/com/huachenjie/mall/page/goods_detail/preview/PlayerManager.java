package com.huachenjie.mall.page.goods_detail.preview;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.source.UrlSource;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.mall.page.goods_detail.preview.PlayerManager;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0015\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b4\u00105J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\"R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010$R$\u0010*\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010)R$\u0010-\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010)R*\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010$\u001a\u0004\b0\u0010)\"\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/PlayerManager;", "", "", "m", "j", "Landroid/view/TextureView;", "textureView", "", "showCover", "i", "", "url", "w", "", t.d, "duration", "v", "autoPlay", "y", "u", "fromUser", "s", "Lcom/huachenjie/mall/page/goods_detail/preview/PlayerStatusListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, y6b.g, "t", "Lcom/aliyun/player/AliPlayer;", "a", "Lcom/aliyun/player/AliPlayer;", "aliPlayer", "Landroid/graphics/SurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "currentSurfaceTexture", "", "Ljava/util/List;", "listeners", "Z", "pausedByAuto", "<set-?>", "b", "k", "()Z", "prepared", "c", "r", "isPlaying", "value", "d", "q", "x", "(Z)V", "isMute", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPlayerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerManager.kt\ncom/huachenjie/mall/page/goods_detail/preview/PlayerManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n1855#2,2:217\n1855#2,2:219\n1855#2,2:221\n1855#2,2:223\n*S KotlinDebug\n*F\n+ 1 PlayerManager.kt\ncom/huachenjie/mall/page/goods_detail/preview/PlayerManager\n*L\n152#1:217,2\n70#1:219,2\n81#1:221,2\n96#1:223,2\n*E\n"})
public final class PlayerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Lazy<PlayerManager> f11131a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<PlayerManager>() { // from class: com.huachenjie.mall.page.goods_detail.preview.PlayerManager$Companion$instance$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PlayerManager m545invoke() {
            return new PlayerManager(null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SurfaceTexture currentSurfaceTexture;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AliPlayer aliPlayer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public List<PlayerStatusListener> listeners;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean pausedByAuto;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public boolean prepared;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean isPlaying;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean isMute;

    /* JADX INFO: renamed from: com.huachenjie.mall.page.goods_detail.preview.PlayerManager$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/PlayerManager$a;", "", "Lcom/huachenjie/mall/page/goods_detail/preview/PlayerManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/huachenjie/mall/page/goods_detail/preview/PlayerManager;", "instance", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PlayerManager a() {
            return (PlayerManager) PlayerManager.f11131a.getValue();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"com/huachenjie/mall/page/goods_detail/preview/PlayerManager$b", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextureView f35214a;

        public b(TextureView textureView) {
            this.f35214a = textureView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            PlayerManager.this.currentSurfaceTexture = surface;
            AliPlayer aliPlayer = PlayerManager.this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.setSurface(new Surface(this.f35214a.getSurfaceTexture()));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            AliPlayer aliPlayer;
            Intrinsics.checkNotNullParameter(surface, "surface");
            if (!Intrinsics.areEqual(PlayerManager.this.currentSurfaceTexture, surface) || (aliPlayer = PlayerManager.this.aliPlayer) == null) {
                return true;
            }
            aliPlayer.setSurface(null);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliPlayer aliPlayer = PlayerManager.this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.surfaceChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    public PlayerManager() {
        this.listeners = new ArrayList();
    }

    public /* synthetic */ PlayerManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void n(PlayerManager playerManager) {
        Intrinsics.checkNotNullParameter(playerManager, "this$0");
        playerManager.prepared = true;
        Iterator<T> it = playerManager.listeners.iterator();
        while (it.hasNext()) {
            ((PlayerStatusListener) it.next()).onHideCover();
        }
    }

    public static final void o(PlayerManager playerManager, int i) {
        Intrinsics.checkNotNullParameter(playerManager, "this$0");
        if (i != 6) {
            if (i != 7) {
                return;
            }
            playerManager.pausedByAuto = false;
            playerManager.isPlaying = false;
            playerManager.prepared = false;
            return;
        }
        AliPlayer aliPlayer = playerManager.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.seekTo(0L);
        }
        playerManager.pausedByAuto = false;
        playerManager.isPlaying = false;
        playerManager.prepared = false;
        Iterator<T> it = playerManager.listeners.iterator();
        while (it.hasNext()) {
            ((PlayerStatusListener) it.next()).onShowCover();
        }
    }

    public static final void p(PlayerManager playerManager, InfoBean infoBean) {
        Intrinsics.checkNotNullParameter(playerManager, "this$0");
        Intrinsics.checkNotNullParameter(infoBean, "infoBean");
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            for (PlayerStatusListener playerStatusListener : playerManager.listeners) {
                long extraValue = infoBean.getExtraValue();
                AliPlayer aliPlayer = playerManager.aliPlayer;
                playerStatusListener.onProgressChanged(extraValue, aliPlayer != null ? aliPlayer.getDuration() : 0L);
            }
        }
    }

    public final void h(@NotNull PlayerStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.listeners.add(listener);
    }

    public final void i(@NotNull TextureView textureView, boolean showCover) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        if (textureView.isAvailable()) {
            this.currentSurfaceTexture = textureView.getSurfaceTexture();
            AliPlayer aliPlayer = this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.setSurface(new Surface(textureView.getSurfaceTexture()));
            }
        }
        textureView.setSurfaceTextureListener(new b(textureView));
        if (showCover) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((PlayerStatusListener) it.next()).onShowCover();
            }
        }
    }

    public final void j() {
        this.pausedByAuto = false;
        this.isPlaying = false;
        this.prepared = false;
        x(false);
        this.listeners.clear();
        this.currentSurfaceTexture = null;
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.setSurface(null);
        }
        AliPlayer aliPlayer2 = this.aliPlayer;
        if (aliPlayer2 != null) {
            aliPlayer2.release();
        }
        this.aliPlayer = null;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getPrepared() {
        return this.prepared;
    }

    public final long l() {
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            return aliPlayer.getDuration();
        }
        return 0L;
    }

    public final void m() {
        AliPlayerGlobalSettings.enableLocalCache(true, 0, Utils.a().getCacheDir().getAbsolutePath() + "/video");
        AliPlayer aliPlayerCreateAliPlayer = AliPlayerFactory.createAliPlayer(Utils.a());
        aliPlayerCreateAliPlayer.setTraceId("DisableAnalytics");
        aliPlayerCreateAliPlayer.setAutoPlay(true);
        aliPlayerCreateAliPlayer.setLoop(false);
        aliPlayerCreateAliPlayer.getConfig().mPositionTimerIntervalMs = 1000;
        aliPlayerCreateAliPlayer.getConfig().mClearFrameWhenStop = false;
        aliPlayerCreateAliPlayer.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FIT);
        aliPlayerCreateAliPlayer.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.zj.adlib.bt6
            @Override // com.aliyun.player.IPlayer.OnPreparedListener
            public final void onPrepared() {
                PlayerManager.n(this.f40834a);
            }
        });
        aliPlayerCreateAliPlayer.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.zj.adlib.ct6
            @Override // com.aliyun.player.IPlayer.OnStateChangedListener
            public final void onStateChanged(int i) {
                PlayerManager.o(this.f41040a, i);
            }
        });
        aliPlayerCreateAliPlayer.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.zj.adlib.dt6
            @Override // com.aliyun.player.IPlayer.OnInfoListener
            public final void onInfo(InfoBean infoBean) {
                PlayerManager.p(this.f41273a, infoBean);
            }
        });
        this.aliPlayer = aliPlayerCreateAliPlayer;
    }

    public final boolean q() {
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            return aliPlayer.isMute();
        }
        return false;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void s(boolean fromUser) {
        this.pausedByAuto = !fromUser;
        if (fromUser) {
            this.isPlaying = false;
        }
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
    }

    public final void t(@NotNull PlayerStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.listeners.remove(listener);
    }

    public final void u() {
        if (this.pausedByAuto && this.isPlaying) {
            this.pausedByAuto = false;
            AliPlayer aliPlayer = this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.start();
            }
        }
    }

    public final void v(long duration) {
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.seekTo(duration, IPlayer.SeekMode.Accurate);
        }
    }

    public final void w(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.pausedByAuto = false;
        this.isPlaying = false;
        this.prepared = false;
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            UrlSource urlSource = new UrlSource();
            urlSource.setUri(url);
            aliPlayer.setDataSource(urlSource);
        }
    }

    public final void x(boolean z) {
        this.isMute = z;
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setMute(z);
    }

    public final void y(boolean autoPlay) {
        if (this.isPlaying) {
            u();
            return;
        }
        this.isPlaying = true;
        if (autoPlay) {
            x(true);
        }
        if (this.prepared) {
            AliPlayer aliPlayer = this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.start();
                return;
            }
            return;
        }
        AliPlayer aliPlayer2 = this.aliPlayer;
        if (aliPlayer2 != null) {
            aliPlayer2.prepare();
        }
    }
}
