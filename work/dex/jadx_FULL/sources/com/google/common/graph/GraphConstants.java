package com.google.common.graph;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class GraphConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f32075a = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f6270a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f6271a = "Node %s is not an element of this graph.";
    public static final int b = 10;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f6272b = "Edge %s is not an element of this graph.";
    public static final int c = 20;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f6273c = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";
    public static final int d = 2;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f6274d = "Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.";
    public static final String e = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";
    public static final String f = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";
    public static final String g = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";
    public static final String h = "Edge %s already exists in the graph.";
    public static final String i = "Mismatch: unordered endpoints cannot be used with directed graphs";

    public enum Presence {
        EDGE_EXISTS
    }
}
