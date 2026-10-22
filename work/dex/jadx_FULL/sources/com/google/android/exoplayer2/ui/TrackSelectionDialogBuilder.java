package com.google.android.exoplayer2.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.da9;
import com.zj.adlib.sa9;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TrackSelectionDialogBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @StyleRes
    public int f31077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f4949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TrackNameProvider f4950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DialogCallback f4951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f4952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Comparator<com.google.android.exoplayer2.d> f4953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<p.a> f4954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<da9, sa9> f4955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4956a;
    public boolean b;
    public boolean c;
    public boolean d;

    public interface DialogCallback {
        void a(boolean z, Map<da9, sa9> map);
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, List<p.a> list, DialogCallback dialogCallback) {
        this.f4949a = context;
        this.f4952a = charSequence;
        this.f4954a = ImmutableList.copyOf((Collection) list);
        this.f4951a = dialogCallback;
        this.f4955a = Collections.emptyMap();
    }

    public static /* synthetic */ void f(Player player, int i, boolean z, Map map) {
        com.google.android.exoplayer2.trackselection.c.a aVarA = player.K().a();
        aVarA.l0(i, z);
        aVarA.E(i);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            aVarA.A((sa9) it.next());
        }
        player.L(aVarA.B());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int i) {
        this.f4951a.a(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }

    public Dialog c() {
        Dialog dialogD = d();
        return dialogD == null ? e() : dialogD;
    }

    @Nullable
    public final Dialog d() {
        try {
            Class cls = Integer.TYPE;
            Object objNewInstance = AlertDialog.Builder.class.getConstructor(Context.class, cls).newInstance(this.f4949a, Integer.valueOf(this.f31077a));
            View viewInflate = LayoutInflater.from((Context) AlertDialog.Builder.class.getMethod("getContext", new Class[0]).invoke(objNewInstance, new Object[0])).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
            DialogInterface.OnClickListener onClickListenerQ = q(viewInflate);
            AlertDialog.Builder.class.getMethod(com.alipay.sdk.m.c0.d.p, CharSequence.class).invoke(objNewInstance, this.f4952a);
            AlertDialog.Builder.class.getMethod("setView", View.class).invoke(objNewInstance, viewInflate);
            AlertDialog.Builder.class.getMethod("setPositiveButton", cls, DialogInterface.OnClickListener.class).invoke(objNewInstance, Integer.valueOf(android.R.string.ok), onClickListenerQ);
            AlertDialog.Builder.class.getMethod("setNegativeButton", cls, DialogInterface.OnClickListener.class).invoke(objNewInstance, Integer.valueOf(android.R.string.cancel), null);
            return (Dialog) AlertDialog.Builder.class.getMethod("create", new Class[0]).invoke(objNewInstance, new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public final Dialog e() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.f4949a, this.f31077a);
        View viewInflate = LayoutInflater.from(builder.getContext()).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
        return builder.setTitle(this.f4952a).setView(viewInflate).setPositiveButton(android.R.string.ok, q(viewInflate)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
    }

    public TrackSelectionDialogBuilder h(boolean z) {
        this.f4956a = z;
        return this;
    }

    public TrackSelectionDialogBuilder i(boolean z) {
        this.b = z;
        return this;
    }

    public TrackSelectionDialogBuilder j(boolean z) {
        this.d = z;
        return this;
    }

    public TrackSelectionDialogBuilder k(@Nullable sa9 sa9Var) {
        return l(sa9Var == null ? Collections.emptyMap() : ImmutableMap.of(sa9Var.f19559a, sa9Var));
    }

    public TrackSelectionDialogBuilder l(Map<da9, sa9> map) {
        this.f4955a = map;
        return this;
    }

    public TrackSelectionDialogBuilder m(boolean z) {
        this.c = z;
        return this;
    }

    public TrackSelectionDialogBuilder n(@StyleRes int i) {
        this.f31077a = i;
        return this;
    }

    public void o(@Nullable Comparator<com.google.android.exoplayer2.d> comparator) {
        this.f4953a = comparator;
    }

    public TrackSelectionDialogBuilder p(@Nullable TrackNameProvider trackNameProvider) {
        this.f4950a = trackNameProvider;
        return this;
    }

    public final DialogInterface.OnClickListener q(View view) {
        final TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.b);
        trackSelectionView.setAllowAdaptiveSelections(this.f4956a);
        trackSelectionView.setShowDisableOption(this.c);
        TrackNameProvider trackNameProvider = this.f4950a;
        if (trackNameProvider != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider);
        }
        trackSelectionView.init(this.f4954a, this.d, this.f4955a, this.f4953a, null);
        return new DialogInterface.OnClickListener() { // from class: com.zj.adlib.oa9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f43712a.g(trackSelectionView, dialogInterface, i);
            }
        };
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, final Player player, final int i) {
        this.f4949a = context;
        this.f4952a = charSequence;
        ImmutableList<p.a> immutableListC = player.s().c();
        this.f4954a = new ArrayList();
        for (int i2 = 0; i2 < immutableListC.size(); i2++) {
            p.a aVar = immutableListC.get(i2);
            if (aVar.getType() == i) {
                this.f4954a.add(aVar);
            }
        }
        this.f4955a = Collections.emptyMap();
        this.f4951a = new DialogCallback() { // from class: com.zj.adlib.pa9
            @Override // com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback
            public final void a(boolean z, Map map) {
                TrackSelectionDialogBuilder.f(player, i, z, map);
            }
        };
    }
}
