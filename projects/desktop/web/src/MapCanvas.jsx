import React, { useEffect, useRef } from 'react';
import { Radio } from 'antd';
import { initMap, renderMap, setTileLayer } from './map';

/* 地图画布：挂载 Leaflet 实例，数据变化时重绘（页面切换时重建，镜头随围栏 fit） */
export default function MapCanvas({ status, walkPoints, waypoints, checkpoints, tiles, fitKey, onClick, onTiles, className }) {
  const ref = useRef(null);
  const mapRef = useRef(null);
  const clickRef = useRef(onClick);
  clickRef.current = onClick;

  useEffect(() => {
    const m = initMap(ref.current, clickRef);
    mapRef.current = m;
    setTileLayer(m, tiles);
    renderMap(m, { status, walkPoints, waypoints, checkpoints, fitKey });
    return () => {
      try { m.remove(); } catch (_) { /* 忽略 */ }
      mapRef.current = null;
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  useEffect(() => {
    renderMap(mapRef.current, { status, walkPoints, waypoints, checkpoints, fitKey });
  }, [status, walkPoints, waypoints, checkpoints, fitKey]);

  useEffect(() => {
    setTileLayer(mapRef.current, tiles);
  }, [tiles]);

  return (
    <div className="map-wrap">
      <div ref={ref} className={className || 'map-canvas'} />
      {onTiles ? (
        <div className="map-top-right">
          <Radio.Group
            value={tiles === 'amap-sat' ? 'amap-sat' : (tiles === 'amap' ? 'amap' : null)}
            onChange={(e) => onTiles(e.target.value)}
            size="small"
            optionType="button"
            buttonStyle="solid"
          >
            <Radio.Button value="amap">高德地图</Radio.Button>
            <Radio.Button value="amap-sat">高德卫星</Radio.Button>
          </Radio.Group>
        </div>
      ) : null}
    </div>
  );
}
