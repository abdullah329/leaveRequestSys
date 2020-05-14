import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LeaveApplicationsFormComponent } from './leave-applications-form/leave-applications-form.component';
import { LeaveBalancesComponent } from './leave-balances/leave-balances.component';
import { LeaveTransactionComponent } from './leave-transaction/leave-transaction.component';
import { LeaveAppComponent } from './leave-app.component';
import { LeaveApprovalsComponent } from './leave-approval/leave-approval.component';


const routes: Routes = [
  {
    path: 'leave-applications-form',
    component: LeaveApplicationsFormComponent
  },
  {
    path: 'leave-balances',
    component : LeaveBalancesComponent
  },
  {
    path: 'leave-approvaltransaction',
    component : LeaveTransactionComponent
  }
  ,
  {
    path: 'leave',
    component : LeaveAppComponent
  }
  ,
  {
    path: 'leave-approvalManager',
    component: LeaveApprovalsComponent
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LeaveAppRoutingModule { }
