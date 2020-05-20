import { Component, OnInit } from '@angular/core';
import { LeaveApplicationModel } from '../model/LeaveApplicationModel';
import { LeaveApplicationService } from '../services/leave-application.service';

@Component({
  selector: 'app-leave-balances',
  templateUrl: './leave-balances.component.html',
  styleUrls: ['./leave-balances.component.scss']
})
export class LeaveBalancesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
