import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LvSysRoutingModule } from './lv-sys-routing.module';
import { SharedComponentsModule } from 'src/app/shared/components/shared-components.module';
import { SharedDirectivesModule } from 'src/app/shared/directives/shared-directives.module';
import { NgxEchartsModule } from 'ngx-echarts';
import { LaddaModule } from 'angular2-ladda';
import { CustomFormsModule } from 'ng2-validation';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LeaveApplicationsFormComponent } from './leave-applications-form/leave-applications-form.component';
import { LeaveBalancesComponent } from './leave-balances/leave-balances.component';
import { LeaveTransactionComponent } from './leave-transaction/leave-transaction.component';
import { LvSysComponent } from './lv-sys.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';


@NgModule({
    imports: [
        CommonModule,
        NgbModule,
        NgxEchartsModule,
        FormsModule,
        ReactiveFormsModule,
        CustomFormsModule,
        SharedComponentsModule,
        SharedDirectivesModule,
        LaddaModule.forRoot({style: 'expand-left'}),
        LvSysRoutingModule,
        NgxDatatableModule,
    ],
  declarations: [LeaveTransactionComponent, LeaveBalancesComponent, LeaveApplicationsFormComponent, LvSysComponent],
})
export class LvSysModule { }
