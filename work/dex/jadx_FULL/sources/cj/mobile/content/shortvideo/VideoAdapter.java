package cj.mobile.content.shortvideo;

import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class VideoAdapter extends RecyclerView.Adapter<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cj.mobile.q.f f22187a;
    public List<cj.mobile.o.b> b;
    public cj.mobile.o.c c;

    public class a implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22188a;
        public final /* synthetic */ VideoAdapter b;

        /* JADX INFO: renamed from: cj.mobile.content.shortvideo.VideoAdapter$a$a, reason: collision with other inner class name */
        public class C0071a implements MediaPlayer.OnInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f22189a;

            public C0071a(a aVar) {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            }
        }

        public a(VideoAdapter videoAdapter, int i) {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
        }
    }

    public class b implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22190a;
        public final /* synthetic */ VideoAdapter b;

        public b(VideoAdapter videoAdapter, int i) {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
        }
    }

    public class c implements MediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22191a;
        public final /* synthetic */ VideoAdapter b;

        public c(VideoAdapter videoAdapter, int i) {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f22192a;

        public d(VideoAdapter videoAdapter, f fVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f22193a;

        public e(VideoAdapter videoAdapter, f fVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class f extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VideoView f22194a;
        public FrameLayout b;
        public ImageView c;
        public ImageView d;

        public f(@NonNull VideoAdapter videoAdapter, View view) {
        }
    }

    public VideoAdapter(List<cj.mobile.o.b> list, cj.mobile.q.f fVar, cj.mobile.o.c cVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    }

    public void a(@NonNull f fVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public f onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    }
}
