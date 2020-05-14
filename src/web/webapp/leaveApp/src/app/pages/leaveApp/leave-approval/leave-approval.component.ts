import { Component, OnInit } from '@angular/core';
import { LeaveApplicationModel } from '../model/LeaveApplicationModel';
import { LeaveApplicationService } from '../services/leave-application.service';

@Component({
  selector: 'app-leave-approval',
  templateUrl: './leave-approval.component.html',
  styleUrls: ['./leave-approval.compnent.scss']
})
export class LeaveApprovalsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
