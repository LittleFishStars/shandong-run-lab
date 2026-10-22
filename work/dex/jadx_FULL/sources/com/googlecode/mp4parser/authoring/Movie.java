package com.googlecode.mp4parser.authoring;

import com.googlecode.mp4parser.util.Matrix;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Movie {
    Matrix matrix;
    List<Track> tracks;

    public Movie() {
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
    }

    public static long gcd(long j, long j2) {
        return j2 == 0 ? j : gcd(j2, j % j2);
    }

    public void addTrack(Track track) {
        if (getTrackByTrackId(track.getTrackMetaData().getTrackId()) != null) {
            track.getTrackMetaData().setTrackId(getNextTrackId());
        }
        this.tracks.add(track);
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public long getNextTrackId() {
        long trackId = 0;
        for (Track track : this.tracks) {
            if (trackId < track.getTrackMetaData().getTrackId()) {
                trackId = track.getTrackMetaData().getTrackId();
            }
        }
        return trackId + 1;
    }

    public long getTimescale() {
        long timescale = getTracks().iterator().next().getTrackMetaData().getTimescale();
        Iterator<Track> it = getTracks().iterator();
        while (it.hasNext()) {
            timescale = gcd(it.next().getTrackMetaData().getTimescale(), timescale);
        }
        return timescale;
    }

    public Track getTrackByTrackId(long j) {
        for (Track track : this.tracks) {
            if (track.getTrackMetaData().getTrackId() == j) {
                return track;
            }
        }
        return null;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public void setTracks(List<Track> list) {
        this.tracks = list;
    }

    public String toString() {
        String str = "Movie{ ";
        for (Track track : this.tracks) {
            str = String.valueOf(str) + "track_" + track.getTrackMetaData().getTrackId() + " (" + track.getHandler() + ") ";
        }
        return String.valueOf(str) + '}';
    }

    public Movie(List<Track> list) {
        this.matrix = Matrix.ROTATE_0;
        new LinkedList();
        this.tracks = list;
    }
}
