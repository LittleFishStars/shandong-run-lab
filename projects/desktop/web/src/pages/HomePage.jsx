import React from 'react';
import { Button, Select } from 'antd';
import MapCanvas from '../MapCanvas';

export default function HomePage({ mapProps, params, distanceOptions, busy, actions }) {
  return (
    <div className="home-page">
      <div className="home-map"><MapCanvas {...mapProps} /></div>
      <div className="home-sheet">
        <Button size="small" className="home-sheet-repick" onClick={actions.toPick}>重新选择起始点</Button>
        <Button className="home-sheet-account" shape="circle" onClick={actions.openAccount}>账户</Button>
        <div className="home-sheet-target">
          <span>目标距离</span>
          <Select
            style={{ flex: 1 }}
            value={params.distance}
            options={distanceOptions}
            onChange={actions.setDistance}
            bordered={false}
            listHeight={400}
          />
        </div>
        <div className="home-sheet-actions">
          <Button type="primary" className="btn-start" loading={busy} onClick={actions.startRun}>开始</Button>
          <Button className="btn-more" shape="circle" onClick={actions.toMore}>更多</Button>
        </div>
      </div>
    </div>
  );
}
