package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.ab3;
import com.zj.adlib.da9;
import com.zj.adlib.gj9;
import com.zj.adlib.sa9;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class StyledPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public static final int O = 1000;
    public static final int P = 0;
    public static final int Q = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f31067a;
    public int K;
    public int L;
    public int M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f4861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources f4863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f4864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final View f4865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ImageView f4866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PopupWindow f4867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TextView f4868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView f4869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Player f4870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f4871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f4872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public OnFullScreenModeChangedListener f4873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ProgressUpdateListener f4874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f4875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f4876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f4878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f4879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TimeBar f4880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackNameProvider f4881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.ui.e f4882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f4884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Formatter f4885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArrayList<VisibilityListener> f4886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f4888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f4889a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable f4890b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final View f4891b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final ImageView f4892b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final TextView f4893b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4894b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long[] f4895b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean[] f4896b;
    public final Drawable c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final View f4897c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public ImageView f4898c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final TextView f4899c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4900c;
    public final Drawable d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public final View f4901d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public ImageView f4902d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public final TextView f4903d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4904d;
    public final Drawable e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public final View f4905e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public ImageView f4906e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4907e;
    public final Drawable f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public final View f4908f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final String f4909f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4910f;
    public final Drawable g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @Nullable
    public View f4911g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final String f4912g;
    public final Drawable h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @Nullable
    public View f4913h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public final String f4914h;
    public final Drawable i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @Nullable
    public View f4915i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public final String f4916i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    @Deprecated
    public interface OnFullScreenModeChangedListener {
        void k(boolean z);
    }

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public abstract class TrackSelectionAdapter extends RecyclerView.Adapter<g> {
        public List<i> f = new ArrayList();

        public TrackSelectionAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Player player, da9 da9Var, i iVar, View view) {
            player.L(player.K().a().W(new sa9(da9Var, ImmutableList.of(Integer.valueOf(iVar.f31073a)))).l0(iVar.f4921a.getType(), false).B());
            onTrackSelection(iVar.f4922a);
            StyledPlayerControlView.this.f4867a.dismiss();
        }

        public abstract void b(List<i> list);

        public void clear() {
            this.f = Collections.emptyList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i) {
            final Player player = StyledPlayerControlView.this.f4870a;
            if (player == null) {
                return;
            }
            if (i == 0) {
                onBindViewHolderAtZeroPosition(gVar);
                return;
            }
            final i iVar = this.f.get(i - 1);
            final da9 da9VarB = iVar.f4921a.b();
            boolean z = player.K().f4699a.get(da9VarB) != null && iVar.a();
            gVar.e.setText(iVar.f4922a);
            gVar.c.setVisibility(z ? 0 : 4);
            gVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4977a.c(player, da9VarB, iVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f.isEmpty()) {
                return 0;
            }
            return this.f.size() + 1;
        }

        public abstract void onBindViewHolderAtZeroPosition(g gVar);

        public abstract void onTrackSelection(String str);
    }

    @Deprecated
    public interface VisibilityListener {
        void e(int i);
    }

    public final class b extends TrackSelectionAdapter {
        public b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(View view) {
            if (StyledPlayerControlView.this.f4870a == null) {
                return;
            }
            ((Player) gj9.k(StyledPlayerControlView.this.f4870a)).L(StyledPlayerControlView.this.f4870a.K().a().E(1).l0(1, false).B());
            StyledPlayerControlView.this.f4878a.f(1, StyledPlayerControlView.this.getResources().getString(R.string.exo_track_selection_auto));
            StyledPlayerControlView.this.f4867a.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void b(List<i> list) {
            this.f = list;
            com.google.android.exoplayer2.trackselection.c cVarK = ((Player) sb0.g(StyledPlayerControlView.this.f4870a)).K();
            if (list.isEmpty()) {
                StyledPlayerControlView.this.f4878a.f(1, StyledPlayerControlView.this.getResources().getString(R.string.exo_track_selection_none));
                return;
            }
            if (!g(cVarK)) {
                StyledPlayerControlView.this.f4878a.f(1, StyledPlayerControlView.this.getResources().getString(R.string.exo_track_selection_auto));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                i iVar = list.get(i);
                if (iVar.a()) {
                    StyledPlayerControlView.this.f4878a.f(1, iVar.f4922a);
                    return;
                }
            }
        }

        public final boolean g(com.google.android.exoplayer2.trackselection.c cVar) {
            for (int i = 0; i < this.f.size(); i++) {
                if (cVar.f4699a.containsKey(this.f.get(i).f4921a.b())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void onBindViewHolderAtZeroPosition(g gVar) {
            gVar.e.setText(R.string.exo_track_selection_auto);
            gVar.c.setVisibility(g(((Player) sb0.g(StyledPlayerControlView.this.f4870a)).K()) ? 4 : 0);
            gVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.gt8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41985a.h(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void onTrackSelection(String str) {
            StyledPlayerControlView.this.f4878a.f(1, str);
        }
    }

    public final class c implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void e(TimeBar timeBar, long j) {
            StyledPlayerControlView.this.f4907e = true;
            if (StyledPlayerControlView.this.f4903d != null) {
                StyledPlayerControlView.this.f4903d.setText(gj9.s0(StyledPlayerControlView.this.f4884a, StyledPlayerControlView.this.f4885a, j));
            }
            StyledPlayerControlView.this.f4882a.W();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void k(TimeBar timeBar, long j, boolean z) {
            StyledPlayerControlView.this.f4907e = false;
            if (!z && StyledPlayerControlView.this.f4870a != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.r(styledPlayerControlView.f4870a, j);
            }
            StyledPlayerControlView.this.f4882a.X();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void l(TimeBar timeBar, long j) {
            if (StyledPlayerControlView.this.f4903d != null) {
                StyledPlayerControlView.this.f4903d.setText(gj9.s0(StyledPlayerControlView.this.f4884a, StyledPlayerControlView.this.f4885a, j));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player player = StyledPlayerControlView.this.f4870a;
            if (player == null) {
                return;
            }
            StyledPlayerControlView.this.f4882a.X();
            if (StyledPlayerControlView.this.f4891b == view) {
                player.seekToNext();
                return;
            }
            if (StyledPlayerControlView.this.f4865a == view) {
                player.seekToPrevious();
                return;
            }
            if (StyledPlayerControlView.this.f4901d == view) {
                if (player.getPlaybackState() != 4) {
                    player.seekForward();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.f4905e == view) {
                player.seekBack();
                return;
            }
            if (StyledPlayerControlView.this.f4897c == view) {
                StyledPlayerControlView.this.g(player);
                return;
            }
            if (StyledPlayerControlView.this.f4866a == view) {
                player.setRepeatMode(RepeatModeUtil.a(player.getRepeatMode(), StyledPlayerControlView.this.M));
                return;
            }
            if (StyledPlayerControlView.this.f4892b == view) {
                player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
                return;
            }
            if (StyledPlayerControlView.this.f4911g == view) {
                StyledPlayerControlView.this.f4882a.W();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.h(styledPlayerControlView.f4878a);
                return;
            }
            if (StyledPlayerControlView.this.f4913h == view) {
                StyledPlayerControlView.this.f4882a.W();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.h(styledPlayerControlView2.f4877a);
            } else if (StyledPlayerControlView.this.f4915i == view) {
                StyledPlayerControlView.this.f4882a.W();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.h(styledPlayerControlView3.f4875a);
            } else if (StyledPlayerControlView.this.f4898c == view) {
                StyledPlayerControlView.this.f4882a.W();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.h(styledPlayerControlView4.f4879a);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.f4910f) {
                StyledPlayerControlView.this.f4882a.X();
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void t(Player player, Player.c cVar) {
            if (cVar.b(4, 5)) {
                StyledPlayerControlView.this.y();
            }
            if (cVar.b(4, 5, 7)) {
                StyledPlayerControlView.this.A();
            }
            if (cVar.a(8)) {
                StyledPlayerControlView.this.B();
            }
            if (cVar.a(9)) {
                StyledPlayerControlView.this.E();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.this.x();
            }
            if (cVar.b(11, 0)) {
                StyledPlayerControlView.this.F();
            }
            if (cVar.a(12)) {
                StyledPlayerControlView.this.z();
            }
            if (cVar.a(2)) {
                StyledPlayerControlView.this.G();
            }
        }
    }

    public final class d extends RecyclerView.Adapter<g> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float[] f4917a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String[] f4918a;

        public d(String[] strArr, float[] fArr) {
            this.f4918a = strArr;
            this.f4917a = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(int i, View view) {
            if (i != this.K) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f4917a[i]);
            }
            StyledPlayerControlView.this.f4867a.dismiss();
        }

        public String f() {
            return this.f4918a[this.K];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f4918a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, final int i) {
            String[] strArr = this.f4918a;
            if (i < strArr.length) {
                gVar.e.setText(strArr[i]);
            }
            gVar.c.setVisibility(i == this.K ? 0 : 4);
            gVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ht8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f42200a.g(i, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void j(float f) {
            int i = 0;
            float f2 = Float.MAX_VALUE;
            int i2 = 0;
            while (true) {
                float[] fArr = this.f4917a;
                if (i >= fArr.length) {
                    this.K = i2;
                    return;
                }
                float fAbs = Math.abs(f - fArr[i]);
                if (fAbs < f2) {
                    i2 = i;
                    f2 = fAbs;
                }
                i++;
            }
        }
    }

    public final class e extends RecyclerView.ViewHolder {
        public final TextView e;
        public final ImageView f;
        public final TextView g;

        public e(View view) {
            super(view);
            if (gj9.f41922a < 26) {
                view.setFocusable(true);
            }
            this.e = (TextView) view.findViewById(R.id.exo_main_text);
            this.g = (TextView) view.findViewById(R.id.exo_sub_text);
            this.f = (ImageView) view.findViewById(R.id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.it8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f42439a.e(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            StyledPlayerControlView.this.p(getAdapterPosition());
        }
    }

    public class f extends RecyclerView.Adapter<e> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Drawable[] f4919a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String[] f4920a;
        public final String[] c;

        public f(String[] strArr, Drawable[] drawableArr) {
            this.f4920a = strArr;
            this.c = new String[strArr.length];
            this.f4919a = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(e eVar, int i) {
            eVar.e.setText(this.f4920a[i]);
            if (this.c[i] == null) {
                eVar.g.setVisibility(8);
            } else {
                eVar.g.setText(this.c[i]);
            }
            if (this.f4919a[i] == null) {
                eVar.f.setVisibility(8);
            } else {
                eVar.f.setImageDrawable(this.f4919a[i]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(ViewGroup viewGroup, int i) {
            return StyledPlayerControlView.this.new e(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R.layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void f(int i, String str) {
            this.c[i] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f4920a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }
    }

    public static class g extends RecyclerView.ViewHolder {
        public final View c;
        public final TextView e;

        public g(View view) {
            super(view);
            if (gj9.f41922a < 26) {
                view.setFocusable(true);
            }
            this.e = (TextView) view.findViewById(R.id.exo_text);
            this.c = view.findViewById(R.id.exo_check);
        }
    }

    public final class h extends TrackSelectionAdapter {
        public h() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(View view) {
            if (StyledPlayerControlView.this.f4870a != null) {
                StyledPlayerControlView.this.f4870a.L(StyledPlayerControlView.this.f4870a.K().a().E(3).M(-3).B());
                StyledPlayerControlView.this.f4867a.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void b(List<i> list) {
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).a()) {
                    z = true;
                    break;
                }
            }
            if (StyledPlayerControlView.this.f4898c != null) {
                ImageView imageView = StyledPlayerControlView.this.f4898c;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z ? styledPlayerControlView.f : styledPlayerControlView.g);
                StyledPlayerControlView.this.f4898c.setContentDescription(z ? StyledPlayerControlView.this.k : StyledPlayerControlView.this.l);
            }
            this.f = list;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d */
        public void onBindViewHolder(g gVar, int i) {
            super.onBindViewHolder(gVar, i);
            if (i > 0) {
                gVar.c.setVisibility(this.f.get(i + (-1)).a() ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void onBindViewHolderAtZeroPosition(g gVar) {
            boolean z;
            gVar.e.setText(R.string.exo_track_selection_none);
            int i = 0;
            while (true) {
                if (i >= this.f.size()) {
                    z = true;
                    break;
                } else {
                    if (this.f.get(i).a()) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            gVar.c.setVisibility(z ? 0 : 4);
            gVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jt8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f42670a.g(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void onTrackSelection(String str) {
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31073a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final p.a f4921a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4922a;

        public i(p pVar, int i, int i2, String str) {
            this.f4921a = pVar.c().get(i);
            this.f31073a = i2;
            this.f4922a = str;
        }

        public boolean a() {
            return this.f4921a.i(this.f31073a);
        }
    }

    static {
        ab3.a("goog.exo.ui");
        f31067a = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    public static boolean d(Timeline timeline, Timeline.d dVar) {
        if (timeline.v() > 100) {
            return false;
        }
        int iV = timeline.v();
        for (int i2 = 0; i2 < iV; i2++) {
            if (timeline.t(i2, dVar).f2209e == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public static int j(TypedArray typedArray, int i2) {
        return typedArray.getInt(R.styleable.StyledPlayerControlView_repeat_toggle_modes, i2);
    }

    public static void l(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean m(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        Player player = this.f4870a;
        if (player == null) {
            return;
        }
        player.c(player.b().e(f2));
    }

    public static void w(@Nullable View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final void A() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.f4894b) {
            Player player = this.f4870a;
            if (player != null) {
                contentPosition = this.f4862a + player.getContentPosition();
                contentBufferedPosition = this.f4862a + player.getContentBufferedPosition();
            } else {
                contentPosition = 0;
                contentBufferedPosition = 0;
            }
            TextView textView = this.f4903d;
            if (textView != null && !this.f4907e) {
                textView.setText(gj9.s0(this.f4884a, this.f4885a, contentPosition));
            }
            TimeBar timeBar = this.f4880a;
            if (timeBar != null) {
                timeBar.setPosition(contentPosition);
                this.f4880a.setBufferedPosition(contentBufferedPosition);
            }
            ProgressUpdateListener progressUpdateListener = this.f4874a;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(contentPosition, contentBufferedPosition);
            }
            removeCallbacks(this.f4883a);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f4883a, 1000L);
                return;
            }
            TimeBar timeBar2 = this.f4880a;
            long jMin = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f2 = player.b().f3399a;
            postDelayed(this.f4883a, gj9.t(f2 > 0.0f ? (long) (jMin / f2) : 1000L, this.L, 1000L));
        }
    }

    public final void B() {
        ImageView imageView;
        if (isVisible() && this.f4894b && (imageView = this.f4866a) != null) {
            if (this.M == 0) {
                t(false, imageView);
                return;
            }
            Player player = this.f4870a;
            if (player == null) {
                t(false, imageView);
                this.f4866a.setImageDrawable(this.f4864a);
                this.f4866a.setContentDescription(this.f4909f);
                return;
            }
            t(true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f4866a.setImageDrawable(this.f4864a);
                this.f4866a.setContentDescription(this.f4909f);
            } else if (repeatMode == 1) {
                this.f4866a.setImageDrawable(this.f4890b);
                this.f4866a.setContentDescription(this.f4912g);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f4866a.setImageDrawable(this.c);
                this.f4866a.setContentDescription(this.f4914h);
            }
        }
    }

    public final void C() {
        Player player = this.f4870a;
        int seekBackIncrement = (int) ((player != null ? player.getSeekBackIncrement() : 5000L) / 1000);
        TextView textView = this.f4893b;
        if (textView != null) {
            textView.setText(String.valueOf(seekBackIncrement));
        }
        View view = this.f4905e;
        if (view != null) {
            view.setContentDescription(this.f4863a.getQuantityString(R.plurals.exo_controls_rewind_by_amount_description, seekBackIncrement, Integer.valueOf(seekBackIncrement)));
        }
    }

    public final void D() {
        this.f4869a.measure(0, 0);
        this.f4867a.setWidth(Math.min(this.f4869a.getMeasuredWidth(), getWidth() - (this.N * 2)));
        this.f4867a.setHeight(Math.min(getHeight() - (this.N * 2), this.f4869a.getMeasuredHeight()));
    }

    public final void E() {
        ImageView imageView;
        if (isVisible() && this.f4894b && (imageView = this.f4892b) != null) {
            Player player = this.f4870a;
            if (!this.f4882a.A(imageView)) {
                t(false, this.f4892b);
                return;
            }
            if (player == null) {
                t(false, this.f4892b);
                this.f4892b.setImageDrawable(this.e);
                this.f4892b.setContentDescription(this.j);
            } else {
                t(true, this.f4892b);
                this.f4892b.setImageDrawable(player.getShuffleModeEnabled() ? this.d : this.e);
                this.f4892b.setContentDescription(player.getShuffleModeEnabled() ? this.f4916i : this.j);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4 A[SYNTHETIC] */
    public final void F() {
        int i2;
        Timeline.d dVar;
        long jS;
        long[] jArr;
        int length;
        Player player = this.f4870a;
        if (player == null) {
            return;
        }
        boolean z = true;
        this.f4904d = this.f4900c && d(player.a0(), this.f4872a);
        long j = 0;
        this.f4862a = 0L;
        Timeline timelineA0 = player.a0();
        if (timelineA0.w()) {
            i2 = 0;
        } else {
            int currentMediaItemIndex = player.getCurrentMediaItemIndex();
            boolean z2 = this.f4904d;
            int i3 = z2 ? 0 : currentMediaItemIndex;
            int iV = z2 ? timelineA0.v() - 1 : currentMediaItemIndex;
            long j2 = 0;
            i2 = 0;
            while (i3 <= iV) {
                if (i3 == currentMediaItemIndex) {
                    this.f4862a = gj9.H1(j2);
                }
                timelineA0.t(i3, this.f4872a);
                Timeline.d dVar2 = this.f4872a;
                if (dVar2.f2209e == -9223372036854775807L) {
                    sb0.i(this.f4904d ^ z);
                    break;
                }
                int i4 = dVar2.K;
                while (true) {
                    dVar = this.f4872a;
                    if (i4 <= dVar.L) {
                        timelineA0.j(i4, this.f4871a);
                        int iF = this.f4871a.f();
                        for (int iT = this.f4871a.t(); iT < iF; iT++) {
                            long jI = this.f4871a.i(iT);
                            if (jI == Long.MIN_VALUE) {
                                long j3 = this.f4871a.f2190a;
                                if (j3 != -9223372036854775807L) {
                                    jI = j3;
                                    jS = jI + this.f4871a.s();
                                    if (jS >= 0) {
                                        jArr = this.f4888a;
                                        if (i2 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.f4888a = Arrays.copyOf(jArr, length);
                                            this.f4889a = Arrays.copyOf(this.f4889a, length);
                                        }
                                        this.f4888a[i2] = gj9.H1(j2 + jS);
                                        this.f4889a[i2] = this.f4871a.u(iT);
                                        i2++;
                                    }
                                }
                            } else {
                                jS = jI + this.f4871a.s();
                                if (jS >= 0) {
                                    jArr = this.f4888a;
                                    if (i2 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f4888a = Arrays.copyOf(jArr, length);
                                        this.f4889a = Arrays.copyOf(this.f4889a, length);
                                    }
                                    this.f4888a[i2] = gj9.H1(j2 + jS);
                                    this.f4889a[i2] = this.f4871a.u(iT);
                                    i2++;
                                }
                            }
                        }
                        i4++;
                    }
                }
                j2 += dVar.f2209e;
                i3++;
                z = true;
            }
            j = j2;
        }
        long jH1 = gj9.H1(j);
        TextView textView = this.f4899c;
        if (textView != null) {
            textView.setText(gj9.s0(this.f4884a, this.f4885a, jH1));
        }
        TimeBar timeBar = this.f4880a;
        if (timeBar != null) {
            timeBar.setDuration(jH1);
            int length2 = this.f4895b.length;
            int i5 = i2 + length2;
            long[] jArr2 = this.f4888a;
            if (i5 > jArr2.length) {
                this.f4888a = Arrays.copyOf(jArr2, i5);
                this.f4889a = Arrays.copyOf(this.f4889a, i5);
            }
            System.arraycopy(this.f4895b, 0, this.f4888a, i2, length2);
            System.arraycopy(this.f4896b, 0, this.f4889a, i2, length2);
            this.f4880a.setAdGroupTimesMs(this.f4888a, this.f4889a, i5);
        }
        A();
    }

    public final void G() {
        k();
        t(this.f4879a.getItemCount() > 0, this.f4898c);
    }

    @Deprecated
    public void addVisibilityListener(VisibilityListener visibilityListener) {
        sb0.g(visibilityListener);
        this.f4886a.add(visibilityListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.f4870a;
        if (player == null || !m(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            player.seekForward();
            return true;
        }
        if (keyCode == 89) {
            player.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            g(player);
            return true;
        }
        if (keyCode == 87) {
            player.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            player.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            f(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        e(player);
        return true;
    }

    public final void e(Player player) {
        player.pause();
    }

    public final void f(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            player.prepare();
        } else if (playbackState == 4) {
            q(player, player.getCurrentMediaItemIndex(), -9223372036854775807L);
        }
        player.play();
    }

    public final void g(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
            f(player);
        } else {
            e(player);
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.f4870a;
    }

    public int getRepeatToggleModes() {
        return this.M;
    }

    public boolean getShowShuffleButton() {
        return this.f4882a.A(this.f4892b);
    }

    public boolean getShowSubtitleButton() {
        return this.f4882a.A(this.f4898c);
    }

    public int getShowTimeoutMs() {
        return this.K;
    }

    public boolean getShowVrButton() {
        return this.f4882a.A(this.f4908f);
    }

    public final void h(RecyclerView.Adapter<?> adapter) {
        this.f4869a.setAdapter(adapter);
        D();
        this.f4910f = false;
        this.f4867a.dismiss();
        this.f4910f = true;
        this.f4867a.showAsDropDown(this, (getWidth() - this.f4867a.getWidth()) - this.N, (-this.f4867a.getHeight()) - this.N);
    }

    public void hide() {
        this.f4882a.C();
    }

    public void hideImmediately() {
        this.f4882a.F();
    }

    public final ImmutableList<i> i(p pVar, int i2) {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList<p.a> immutableListC = pVar.c();
        for (int i3 = 0; i3 < immutableListC.size(); i3++) {
            p.a aVar2 = immutableListC.get(i3);
            if (aVar2.getType() == i2) {
                for (int i4 = 0; i4 < aVar2.K; i4++) {
                    if (aVar2.j(i4)) {
                        com.google.android.exoplayer2.d dVarC = aVar2.c(i4);
                        if ((dVarC.K & 2) == 0) {
                            aVar.a(new i(pVar, i3, i4, this.f4881a.a(dVarC)));
                        }
                    }
                }
            }
        }
        return aVar.e();
    }

    public boolean isAnimationEnabled() {
        return this.f4882a.I();
    }

    public boolean isFullyVisible() {
        return this.f4882a.J();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final void k() {
        this.f4879a.clear();
        this.f4875a.clear();
        Player player = this.f4870a;
        if (player != null && player.isCommandAvailable(30) && this.f4870a.isCommandAvailable(29)) {
            p pVarS = this.f4870a.s();
            this.f4875a.b(i(pVarS, 1));
            if (this.f4882a.A(this.f4898c)) {
                this.f4879a.b(i(pVarS, 3));
            } else {
                this.f4879a.b(ImmutableList.of());
            }
        }
    }

    public final void n(View view) {
        if (this.f4873a == null) {
            return;
        }
        boolean z = !this.f4887a;
        this.f4887a = z;
        v(this.f4902d, z);
        v(this.f4906e, this.f4887a);
        OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.f4873a;
        if (onFullScreenModeChangedListener != null) {
            onFullScreenModeChangedListener.k(this.f4887a);
        }
    }

    public void notifyOnVisibilityChange() {
        Iterator<VisibilityListener> it = this.f4886a.iterator();
        while (it.hasNext()) {
            it.next().e(getVisibility());
        }
    }

    public final void o(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.f4867a.isShowing()) {
            D();
            this.f4867a.update(view, (getWidth() - this.f4867a.getWidth()) - this.N, (-this.f4867a.getHeight()) - this.N, -1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4882a.P();
        this.f4894b = true;
        if (isFullyVisible()) {
            this.f4882a.X();
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4882a.Q();
        this.f4894b = false;
        removeCallbacks(this.f4883a);
        this.f4882a.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f4882a.R(z, i2, i3, i4, i5);
    }

    public final void p(int i2) {
        if (i2 == 0) {
            h(this.f4877a);
        } else if (i2 == 1) {
            h(this.f4875a);
        } else {
            this.f4867a.dismiss();
        }
    }

    public final void q(Player player, int i2, long j) {
        player.seekTo(i2, j);
    }

    public final void r(Player player, long j) {
        int currentMediaItemIndex;
        Timeline timelineA0 = player.a0();
        if (this.f4904d && !timelineA0.w()) {
            int iV = timelineA0.v();
            currentMediaItemIndex = 0;
            while (true) {
                long jG = timelineA0.t(currentMediaItemIndex, this.f4872a).g();
                if (j < jG) {
                    break;
                }
                if (currentMediaItemIndex == iV - 1) {
                    j = jG;
                    break;
                } else {
                    j -= jG;
                    currentMediaItemIndex++;
                }
            }
        } else {
            currentMediaItemIndex = player.getCurrentMediaItemIndex();
        }
        q(player, currentMediaItemIndex, j);
        A();
    }

    @Deprecated
    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.f4886a.remove(visibilityListener);
    }

    public void requestPlayPauseFocus() {
        View view = this.f4897c;
        if (view != null) {
            view.requestFocus();
        }
    }

    public final boolean s() {
        Player player = this.f4870a;
        return (player == null || player.getPlaybackState() == 4 || this.f4870a.getPlaybackState() == 1 || !this.f4870a.getPlayWhenReady()) ? false : true;
    }

    public void setAnimationEnabled(boolean z) {
        this.f4882a.Y(z);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f4895b = new long[0];
            this.f4896b = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) sb0.g(zArr);
            sb0.a(jArr.length == zArr2.length);
            this.f4895b = jArr;
            this.f4896b = zArr2;
        }
        F();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        this.f4873a = onFullScreenModeChangedListener;
        w(this.f4902d, onFullScreenModeChangedListener != null);
        w(this.f4906e, onFullScreenModeChangedListener != null);
    }

    public void setPlayer(@Nullable Player player) {
        boolean z = true;
        sb0.i(Looper.myLooper() == Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != Looper.getMainLooper()) {
            z = false;
        }
        sb0.a(z);
        Player player2 = this.f4870a;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.V(this.f4876a);
        }
        this.f4870a = player;
        if (player != null) {
            player.u(this.f4876a);
        }
        if (player instanceof com.google.android.exoplayer2.e) {
            ((com.google.android.exoplayer2.e) player).j0();
        }
        updateAll();
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.f4874a = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.M = i2;
        Player player = this.f4870a;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.f4870a.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.f4870a.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.f4870a.setRepeatMode(2);
            }
        }
        this.f4882a.Z(this.f4866a, i2 != 0);
        B();
    }

    public void setShowFastForwardButton(boolean z) {
        this.f4882a.Z(this.f4901d, z);
        x();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.f4900c = z;
        F();
    }

    public void setShowNextButton(boolean z) {
        this.f4882a.Z(this.f4891b, z);
        x();
    }

    public void setShowPreviousButton(boolean z) {
        this.f4882a.Z(this.f4865a, z);
        x();
    }

    public void setShowRewindButton(boolean z) {
        this.f4882a.Z(this.f4905e, z);
        x();
    }

    public void setShowShuffleButton(boolean z) {
        this.f4882a.Z(this.f4892b, z);
        E();
    }

    public void setShowSubtitleButton(boolean z) {
        this.f4882a.Z(this.f4898c, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.K = i2;
        if (isFullyVisible()) {
            this.f4882a.X();
        }
    }

    public void setShowVrButton(boolean z) {
        this.f4882a.Z(this.f4908f, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.L = gj9.s(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f4908f;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            t(onClickListener != null, this.f4908f);
        }
    }

    public void show() {
        this.f4882a.c0();
    }

    public final void t(boolean z, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.f4861a : this.b);
    }

    public final void u() {
        Player player = this.f4870a;
        int seekForwardIncrement = (int) ((player != null ? player.getSeekForwardIncrement() : 15000L) / 1000);
        TextView textView = this.f4868a;
        if (textView != null) {
            textView.setText(String.valueOf(seekForwardIncrement));
        }
        View view = this.f4901d;
        if (view != null) {
            view.setContentDescription(this.f4863a.getQuantityString(R.plurals.exo_controls_fastforward_by_amount_description, seekForwardIncrement, Integer.valueOf(seekForwardIncrement)));
        }
    }

    public void updateAll() {
        y();
        x();
        B();
        E();
        G();
        z();
        F();
    }

    public final void v(@Nullable ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(this.h);
            imageView.setContentDescription(this.m);
        } else {
            imageView.setImageDrawable(this.i);
            imageView.setContentDescription(this.n);
        }
    }

    public final void x() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (isVisible() && this.f4894b) {
            Player player = this.f4870a;
            if (player != null) {
                zIsCommandAvailable = player.isCommandAvailable(5);
                zIsCommandAvailable3 = player.isCommandAvailable(7);
                zIsCommandAvailable4 = player.isCommandAvailable(11);
                zIsCommandAvailable5 = player.isCommandAvailable(12);
                zIsCommandAvailable2 = player.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            if (zIsCommandAvailable4) {
                C();
            }
            if (zIsCommandAvailable5) {
                u();
            }
            t(zIsCommandAvailable3, this.f4865a);
            t(zIsCommandAvailable4, this.f4905e);
            t(zIsCommandAvailable5, this.f4901d);
            t(zIsCommandAvailable2, this.f4891b);
            TimeBar timeBar = this.f4880a;
            if (timeBar != null) {
                timeBar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    public final void y() {
        if (isVisible() && this.f4894b && this.f4897c != null) {
            if (s()) {
                ((ImageView) this.f4897c).setImageDrawable(this.f4863a.getDrawable(R.drawable.exo_styled_controls_pause));
                this.f4897c.setContentDescription(this.f4863a.getString(R.string.exo_controls_pause_description));
            } else {
                ((ImageView) this.f4897c).setImageDrawable(this.f4863a.getDrawable(R.drawable.exo_styled_controls_play));
                this.f4897c.setContentDescription(this.f4863a.getString(R.string.exo_controls_play_description));
            }
        }
    }

    public final void z() {
        Player player = this.f4870a;
        if (player == null) {
            return;
        }
        this.f4877a.j(player.b().f3399a);
        this.f4878a.f(0, this.f4877a.f());
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v66, types: [android.view.LayoutInflater] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.view.ViewGroup, com.google.android.exoplayer2.ui.StyledPlayerControlView$a] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ?? r9;
        boolean z9;
        super(context, attributeSet, i2);
        int resourceId = R.layout.exo_styled_player_control_view;
        this.K = 5000;
        this.M = 0;
        this.L = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.StyledPlayerControlView, i2, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StyledPlayerControlView_controller_layout_id, resourceId);
                this.K = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_show_timeout, this.K);
                this.M = j(typedArrayObtainStyledAttributes, this.M);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_next_button, true);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_time_bar_min_update_interval, this.L));
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z2 = z14;
                z3 = z15;
                z5 = z10;
                z6 = z11;
                z7 = z12;
                z4 = z17;
                z8 = z13;
                z = z16;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = true;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar = new c();
        this.f4876a = cVar;
        this.f4886a = new CopyOnWriteArrayList<>();
        this.f4871a = new Timeline.b();
        this.f4872a = new Timeline.d();
        StringBuilder sb = new StringBuilder();
        this.f4884a = sb;
        this.f4885a = new Formatter(sb, Locale.getDefault());
        this.f4888a = new long[0];
        this.f4889a = new boolean[0];
        this.f4895b = new long[0];
        this.f4896b = new boolean[0];
        this.f4883a = new Runnable() { // from class: com.zj.adlib.dt8
            @Override // java.lang.Runnable
            public final void run() {
                this.f41274a.A();
            }
        };
        this.f4899c = (TextView) findViewById(R.id.exo_duration);
        this.f4903d = (TextView) findViewById(R.id.exo_position);
        ImageView imageView = (ImageView) findViewById(R.id.exo_subtitle);
        this.f4898c = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_fullscreen);
        this.f4902d = imageView2;
        l(imageView2, new View.OnClickListener() { // from class: com.zj.adlib.et8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41524a.n(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.exo_minimal_fullscreen);
        this.f4906e = imageView3;
        l(imageView3, new View.OnClickListener() { // from class: com.zj.adlib.et8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41524a.n(view);
            }
        });
        View viewFindViewById = findViewById(R.id.exo_settings);
        this.f4911g = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar);
        }
        View viewFindViewById2 = findViewById(R.id.exo_playback_speed);
        this.f4913h = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R.id.exo_audio_track);
        this.f4915i = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        int i3 = R.id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i3);
        View viewFindViewById4 = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.f4880a = timeBar;
            r9 = 0;
        } else if (viewFindViewById4 != null) {
            r9 = 0;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R.style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i3);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f4880a = defaultTimeBar;
        } else {
            r9 = 0;
            this.f4880a = null;
        }
        TimeBar timeBar2 = this.f4880a;
        if (timeBar2 != null) {
            timeBar2.addListener(cVar);
        }
        View viewFindViewById5 = findViewById(R.id.exo_play_pause);
        this.f4897c = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R.id.exo_prev);
        this.f4865a = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R.id.exo_next);
        this.f4891b = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        Typeface font = ResourcesCompat.getFont(context, R.font.roboto_medium_numbers);
        ?? FindViewById = findViewById(R.id.exo_rew);
        ?? r6 = FindViewById == 0 ? (TextView) findViewById(R.id.exo_rew_with_amount) : r9;
        this.f4893b = r6;
        if (r6 != 0) {
            r6.setTypeface(font);
        }
        FindViewById = FindViewById == 0 ? r6 : FindViewById;
        this.f4905e = FindViewById;
        if (FindViewById != 0) {
            FindViewById.setOnClickListener(cVar);
        }
        ?? FindViewById2 = findViewById(R.id.exo_ffwd);
        ?? r7 = FindViewById2 == 0 ? (TextView) findViewById(R.id.exo_ffwd_with_amount) : r9;
        this.f4868a = r7;
        if (r7 != 0) {
            r7.setTypeface(font);
        }
        FindViewById2 = FindViewById2 == 0 ? r7 : FindViewById2;
        this.f4901d = FindViewById2;
        if (FindViewById2 != 0) {
            FindViewById2.setOnClickListener(cVar);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f4866a = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar);
        }
        ImageView imageView5 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f4892b = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar);
        }
        Resources resources = context.getResources();
        this.f4863a = resources;
        this.f4861a = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.b = this.f4863a.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById8 = findViewById(R.id.exo_vr);
        this.f4908f = viewFindViewById8;
        if (viewFindViewById8 != null) {
            t(false, viewFindViewById8);
        }
        com.google.android.exoplayer2.ui.e eVar = new com.google.android.exoplayer2.ui.e(this);
        this.f4882a = eVar;
        eVar.Y(z4);
        this.f4878a = new f(new String[]{this.f4863a.getString(R.string.exo_controls_playback_speed), this.f4863a.getString(R.string.exo_track_selection_title_audio)}, new Drawable[]{this.f4863a.getDrawable(R.drawable.exo_styled_controls_speed), this.f4863a.getDrawable(R.drawable.exo_styled_controls_audiotrack)});
        this.N = this.f4863a.getDimensionPixelSize(R.dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.exo_styled_settings_list, r9);
        this.f4869a = recyclerView;
        recyclerView.setAdapter(this.f4878a);
        this.f4869a.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.f4869a, -2, -2, true);
        this.f4867a = popupWindow;
        if (gj9.f41922a < 23) {
            z9 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z9 = false;
        }
        this.f4867a.setOnDismissListener(cVar);
        this.f4910f = true;
        this.f4881a = new com.google.android.exoplayer2.ui.b(getResources());
        this.f = this.f4863a.getDrawable(R.drawable.exo_styled_controls_subtitle_on);
        this.g = this.f4863a.getDrawable(R.drawable.exo_styled_controls_subtitle_off);
        this.k = this.f4863a.getString(R.string.exo_controls_cc_enabled_description);
        this.l = this.f4863a.getString(R.string.exo_controls_cc_disabled_description);
        this.f4879a = new h();
        this.f4875a = new b();
        this.f4877a = new d(this.f4863a.getStringArray(R.array.exo_controls_playback_speeds), f31067a);
        this.h = this.f4863a.getDrawable(R.drawable.exo_styled_controls_fullscreen_exit);
        this.i = this.f4863a.getDrawable(R.drawable.exo_styled_controls_fullscreen_enter);
        this.f4864a = this.f4863a.getDrawable(R.drawable.exo_styled_controls_repeat_off);
        this.f4890b = this.f4863a.getDrawable(R.drawable.exo_styled_controls_repeat_one);
        this.c = this.f4863a.getDrawable(R.drawable.exo_styled_controls_repeat_all);
        this.d = this.f4863a.getDrawable(R.drawable.exo_styled_controls_shuffle_on);
        this.e = this.f4863a.getDrawable(R.drawable.exo_styled_controls_shuffle_off);
        this.m = this.f4863a.getString(R.string.exo_controls_fullscreen_exit_description);
        this.n = this.f4863a.getString(R.string.exo_controls_fullscreen_enter_description);
        this.f4909f = this.f4863a.getString(R.string.exo_controls_repeat_off_description);
        this.f4912g = this.f4863a.getString(R.string.exo_controls_repeat_one_description);
        this.f4914h = this.f4863a.getString(R.string.exo_controls_repeat_all_description);
        this.f4916i = this.f4863a.getString(R.string.exo_controls_shuffle_on_description);
        this.j = this.f4863a.getString(R.string.exo_controls_shuffle_off_description);
        this.f4882a.Z((ViewGroup) findViewById(R.id.exo_bottom_bar), true);
        this.f4882a.Z(this.f4901d, z6);
        this.f4882a.Z(this.f4905e, z5);
        this.f4882a.Z(this.f4865a, z7);
        this.f4882a.Z(this.f4891b, z8);
        this.f4882a.Z(this.f4892b, z2);
        this.f4882a.Z(this.f4898c, z3);
        this.f4882a.Z(this.f4908f, z);
        this.f4882a.Z(this.f4866a, this.M != 0 ? true : z9);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.zj.adlib.ft8
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                this.f41755a.o(view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        });
    }
}
