import React from 'react';

import { DomainTimeline } from '../domain/timeline';
import { filterMetricsForDomains } from '../helpers/metrics';


const DOMAINS = ['Issues', 'Technical Debt'];


export class IssuesTimeline extends React.Component {
  render () {
    return <DomainTimeline {...this.props}
        initialMetric="violations"
        metrics={filterMetricsForDomains(this.props.metrics, DOMAINS)}/>;
  }
}
