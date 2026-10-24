import React from 'react';
import { Button, Select } from '../ui';
import MapCanvas from '../MapCanvas';

/* 首页：全屏地图；下方「目标距离」下拉 + 「开始」大圆钮 + 「更多」小圆钮 */
export default function HomePage({ mapProps, params, distanceOptions, busy, actions }) {
  return (
    <div className="run-layout">
      <div className="map-card"><MapCanvas {...mapProps} /></div>
      <aside className="side-panel">
        <div className="panel-top-row">
          <Button size="small" className="repick-entry" onClick={actions.toPick}>重新选择起始点</Button>
          <Button size="small" className="account-entry" onClick={actions.openAccount}>账户</Button>
        </div>
        <div className="side-brand">
          <img className="app-icon" src="assets/app-icon.png" alt="闪动校园" />
        </div>
        <div className="target-pill">
          <span>目标距离</span>
          <Select
            style={{ flex: 1 }}
            value={params.distance}
            options={distanceOptions}
            onChange={actions.setDistance}
          />
        </div>
        <div className="side-actions">
          <Button type="primary" className="btn-start" loading={busy} onClick={actions.startRun}>开始</Button>
          <Button className="btn-more" shape="circle" onClick={actions.toMore}>更多</Button>
        </div>
      </aside>
    </div>
  );
}