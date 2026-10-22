package com.byazt.nc;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 67})
public abstract class u extends x {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(140001, com.byazt.lq.uj.c(new Supplier<t>() { // from class: com.byazt.nc.u.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public t get() {
                return u.this.getVideoCoverImage();
            }
        }));
        cVarC.c(140002, com.byazt.lq.uj.c(new Supplier<Bitmap>() { // from class: com.byazt.nc.u.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return u.this.getAdLogo();
            }
        }));
        cVarC.c(140003, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.u.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getTitle();
            }
        }));
        cVarC.c(140004, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.u.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getDescription();
            }
        }));
        cVarC.c(140018, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.u.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getButtonText();
            }
        }));
        cVarC.c(140005, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.u.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.getAppScore());
            }
        }));
        cVarC.c(140006, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.u.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.getAppCommentNum());
            }
        }));
        cVarC.c(140007, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.u.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.getAppSize());
            }
        }));
        cVarC.c(140008, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.u.18
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getSource();
            }
        }));
        cVarC.c(140009, com.byazt.lq.uj.c(new Supplier<t>() { // from class: com.byazt.nc.u.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public t get() {
                return u.this.getIcon();
            }
        }));
        cVarC.c(140010, com.byazt.lq.uj.c(new Supplier<List<t>>() { // from class: com.byazt.nc.u.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public List<t> get() {
                return u.this.getImageList();
            }
        }));
        cVarC.c(140011, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.u.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.getInteractionType());
            }
        }));
        cVarC.c(140012, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.u.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.getImageMode());
            }
        }));
        cVarC.c(140013, com.byazt.lq.uj.c(new Supplier<uj>() { // from class: com.byazt.nc.u.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public uj get() {
                return u.this.getDislikeInfo();
            }
        }));
        cVarC.c(140014, com.byazt.lq.uj.c(new Supplier<ve>() { // from class: com.byazt.nc.u.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ve get() {
                return u.this.getComplianceInfo();
            }
        }));
        cVarC.c(140015, com.byazt.lq.uj.c(new Supplier<n>() { // from class: com.byazt.nc.u.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public n get() {
                return u.this.getDownloadStatusController();
            }
        }));
        cVarC.c(140016, com.byazt.lq.uj.c(new Supplier<View>() { // from class: com.byazt.nc.u.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public View get() {
                return u.this.getAdView();
            }
        }));
        cVarC.c(140017, com.byazt.lq.uj.c(new Supplier<Map<String, Object>>() { // from class: com.byazt.nc.u.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return u.this.getMediaExtraInfo();
            }
        }));
        return cVarC.tt();
    }

    public abstract void destroy();

    public abstract Bitmap getAdLogo();

    public abstract View getAdView();

    public abstract int getAppCommentNum();

    public abstract int getAppScore();

    public abstract int getAppSize();

    public abstract String getButtonText();

    public abstract ve getComplianceInfo();

    public abstract String getDescription();

    public abstract sp getDislikeDialog(Activity activity);

    public abstract sp getDislikeDialog(Dialog dialog, Integer[] numArr);

    public abstract uj getDislikeInfo();

    public abstract n getDownloadStatusController();

    public abstract t getIcon();

    public abstract List<t> getImageList();

    public abstract int getImageMode();

    public abstract int getInteractionType();

    public abstract String getLifecycleId();

    public abstract Map<String, Object> getMediaExtraInfo();

    public abstract com.byazt.sbm.n getMediationManager();

    public abstract String getSource();

    public abstract String getTitle();

    public abstract t getVideoCoverImage();

    public abstract void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.lsp.c cVar, com.byazt.am.uj ujVar);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, View view, com.byazt.lsp.c cVar);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.lsp.c cVar);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.lsp.c cVar);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.lsp.c cVar);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.lsp.c cVar);

    public abstract void render();

    public abstract void setActivityForDownloadApp(Activity activity);

    public abstract void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar);

    public abstract void setDislikeDialog(Dialog dialog, Integer[] numArr);

    public abstract void setDownloadListener(com.byazt.ocd.ve veVar);

    public abstract void setEasyPlayWidgetListener(com.byazt.lsp.tt ttVar);

    public abstract void setExpressRenderListener(com.byazt.lsp.ve veVar);

    public abstract void showInteractionExpressAd(Activity activity);

    public abstract void uploadDislikeEvent(String str);

    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.nc.x, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return values().sparseArray();
        }
        switch (iIntValue) {
            case 140101:
                return getDislikeDialog((Activity) pluginValueSetTt.objectValue(0, Activity.class));
            case 140102:
                Dialog dialog = (Dialog) pluginValueSetTt.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) pluginValueSetTt.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                return getDislikeDialog(dialog, numArr);
            case 140103:
                registerViewForInteraction((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class), (View) pluginValueSetTt.objectValue(1, View.class), new com.byazt.lsp.c((Function) pluginValueSetTt.objectValue(2, Function.class)));
                return null;
            case 140104:
                registerViewForInteraction((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class), (List) pluginValueSetTt.objectValue(1, List.class), (List) pluginValueSetTt.objectValue(2, List.class), new com.byazt.lsp.c((Function) pluginValueSetTt.objectValue(3, Function.class)));
                return null;
            case 140105:
                registerViewForInteraction((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class), (List) pluginValueSetTt.objectValue(1, List.class), (List) pluginValueSetTt.objectValue(2, List.class), (View) pluginValueSetTt.objectValue(3, View.class), new com.byazt.lsp.c((Function) pluginValueSetTt.objectValue(4, Function.class)));
                return null;
            case 140106:
                registerViewForInteraction((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class), (List) pluginValueSetTt.objectValue(1, List.class), (List) pluginValueSetTt.objectValue(2, List.class), (List) pluginValueSetTt.objectValue(3, List.class), (View) pluginValueSetTt.objectValue(4, View.class), new com.byazt.lsp.c((Function) pluginValueSetTt.objectValue(5, Function.class)));
                return null;
            case 140107:
                registerViewForInteraction((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class), (List<View>) pluginValueSetTt.objectValue(1, List.class), (List<View>) pluginValueSetTt.objectValue(2, List.class), (List<View>) pluginValueSetTt.objectValue(3, List.class), (List<View>) pluginValueSetTt.objectValue(4, List.class), (View) pluginValueSetTt.objectValue(5, View.class), new com.byazt.lsp.c((Function) pluginValueSetTt.objectValue(6, Function.class)));
                return null;
            case 140108:
                setDownloadListener(new com.byazt.ocd.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 140109:
                setActivityForDownloadApp((Activity) pluginValueSetTt.objectValue(0, Activity.class));
                return null;
            case 140110:
                render();
                return null;
            case 140111:
                setExpressRenderListener(new com.byazt.lsp.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 140112:
                setDislikeCallback((Activity) pluginValueSetTt.objectValue(0, Activity.class), new com.byazt.dhf.c((Function) pluginValueSetTt.objectValue(1, Function.class)));
                return null;
            case 140113:
                Dialog dialog2 = (Dialog) pluginValueSetTt.objectValue(0, Dialog.class);
                Integer[] numArr2 = (Integer[]) pluginValueSetTt.arrayValue(1, Integer.class);
                if (numArr2 == null) {
                    numArr2 = new Integer[0];
                }
                setDislikeDialog(dialog2, numArr2);
                return null;
            case 140114:
                destroy();
                return null;
            case 140115:
                pluginValueSetTt.objectValue(0, Activity.class);
                return null;
            case 140116:
                return getMediationManager();
            case 140117:
                registerViewForInteraction((Activity) pluginValueSetTt.objectValue(0, Activity.class), (ViewGroup) pluginValueSetTt.objectValue(1, ViewGroup.class), (List<View>) pluginValueSetTt.objectValue(2, List.class), (List<View>) pluginValueSetTt.objectValue(3, List.class), (List<View>) pluginValueSetTt.objectValue(4, List.class), new com.byazt.lsp.c((Function) pluginValueSetTt.objectValue(5, Function.class)), new com.byazt.am.uj((Function) pluginValueSetTt.objectValue(6, Function.class)));
                return null;
            case 140118:
                uploadDislikeEvent((String) pluginValueSetTt.objectValue(0, String.class));
                return null;
            case 140119:
                setEasyPlayWidgetListener(new com.byazt.lsp.tt((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
