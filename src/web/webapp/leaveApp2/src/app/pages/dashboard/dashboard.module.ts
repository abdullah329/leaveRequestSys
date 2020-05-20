import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {DashboardRoutingModule} from './dashboard-routing.module';
import {DashboadDefaultComponent} from './dashboad-default/dashboad-default.component';
import {NgxEchartsModule} from 'ngx-echarts';
import {SharedComponentsModule} from 'src/app/shared/components/shared-components.module';
import {DashboardV2Component} from './dashboard-v2/dashboard-v2.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {DashboardV3Component} from './dashboard-v3/dashboard-v3.component';
import {DashboardV4Component} from './dashboard-v4/dashboard-v4.component';
import { MatGridListModule } from '@angular/material/grid-list';

import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatSelectModule } from '@angular/material/select';
import {DashboardService} from './services/dashboard.service';

import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
@NgModule({
    imports: [
        CommonModule,
        SharedComponentsModule,
        NgxEchartsModule,
        NgxDatatableModule,
        NgbModule,
        DashboardRoutingModule,
        MatGridListModule,
        MatCardModule,
        MatInputModule,
        MatPaginatorModule,
        MatProgressSpinnerModule,
        MatSortModule,
        MatTableModule,
        MatIconModule,
        MatButtonModule,
        MatFormFieldModule,
        MatSliderModule,
        MatSlideToggleModule,
        MatButtonToggleModule,
        MatSelectModule,
        LayoutModule,
        MatToolbarModule,
        MatSidenavModule,
        MatListModule,
        MatMenuModule
    ],
    declarations: [DashboadDefaultComponent, DashboardV2Component, DashboardV3Component, DashboardV4Component],
    providers: [DashboardService]
})
export class DashboardModule {
}
