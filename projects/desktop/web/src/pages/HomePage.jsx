import React from 'react';
import { Button, Progress, Select } from 'antd';
import MapCanvas from '../MapCanvas';

export default function HomePage({ mapProps, params, distanceOptions, progress, busy, actions }) {
  return (
    <div className="run-layout">
      <div className="map-card"><MapCanvas {...mapProps} /></div>
      <aside className="side-panel">
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
            bordered={false}
          />
        </div>
        <div className="side-actions">
          <Button type="primary" className="btn-start" loading={busy} onClick={actions.startRun}>开始</Button>
          <Button className="btn-more" shape="circle" onClick={actions.toMore}>更多</Button>
        </div>
        <div className="progress">
          <Progress percent={Number(progress.percent) || 0} showInfo={false} />
          <div className="progress-text">{progress.text}</div>
        </div>
      </aside>
    </div>
  );
}
