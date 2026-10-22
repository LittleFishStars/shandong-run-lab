import React, { useEffect, useRef } from 'react';
import { initMap, renderMap, setTileLayer } from './map';

/* 地图画布：挂载 Leaflet 实例，数据变化时重绘（页面切换时重建，镜头随围栏 fit） */
export default function MapCanvas({ status, walkPoints, route, waypoints, tiles, fitKey, onClick, className }) {
  const ref = useRef(null);
  const mapRef = useRef(null);
  const clickRef = useRef(onClick);
  clickRef.current = onClick;

  useEffect(() => {
    const m = initMap(ref.current, clickRef);
    mapRef.current = m;
    setTileLayer(m, tiles);
    renderMap(m, { status, walkPoints, route, waypoints, fitKey });
    return () => {
      try { m.remove(); } catch (_) { /* 忽略 */ }
      mapRef.current = null;
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  useEffect(() => {
    renderMap(mapRef.current, { status, walkPoints, route, waypoints, fitKey });
  }, [status, walkPoints, route, waypoints, fitKey]);

  useEffect(() => {
    setTileLayer(mapRef.current, tiles);
  }, [tiles]);

  return <div ref={ref} className={className || 'map-canvas'} />;
}
