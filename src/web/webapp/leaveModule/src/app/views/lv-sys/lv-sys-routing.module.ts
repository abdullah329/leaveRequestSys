import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LeaveApplicationsFormComponent } from './leave-applications-form/leave-applications-form.component';
import { LeaveBalancesComponent } from './leave-balances/leave-balances.component';
import { LeaveTransactionComponent } from './leave-transaction/leave-transaction.component';
import { LvSysComponent } from './lv-sys.component';


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
    path: 'leave-transaction',
    component : LeaveTransactionComponent
  }
  ,
  {
    path: 'lvsys',
    component : LvSysComponent
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LvSysRoutingModule { }
