import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthLayoutComponent} from './shared/components/layouts/auth-layout/auth-layout.component';
import {AuthGaurd} from './shared/services/auth.gaurd';
import {BlankLayoutComponent} from './shared/components/layouts/blank-layout/blank-layout.component';
import {AdminLayoutSidebarLargeComponent} from './shared/components/layouts/admin-layout-sidebar-large/admin-layout-sidebar-large.component';

const adminRoutes: Routes = [
    {
        path: 'dashboard',
        loadChildren: () => import('./pages/dashboard/dashboard.module').then(m => m.DashboardModule)
    },
    {
        path: 'leaveApp',
        loadChildren: () => import('./pages/leaveApp/leave-app.module').then(m => m.LeaveAppModule)
    }
];

const routes: Routes = [
    {
        path: '',
        redirectTo: 'dashboard/v1',
        pathMatch: 'full'
    },
    {
        path: '',
        component: AuthLayoutComponent,
        children: [
            {
                path: 'sessions',
                loadChildren: () => import('./shared/sessions/sessions.module').then(m => m.SessionsModule)
            }
        ]
    },
    {
        path: '',
        component: BlankLayoutComponent,
        children: [
            {
                path: 'others',
                loadChildren: () => import('./shared/others/others.module').then(m => m.OthersModule)
            }
        ]
    },
    {
        path: '',
        component: AdminLayoutSidebarLargeComponent,
        canActivate: [AuthGaurd],
        children: adminRoutes
    },
    {
        path: '**',
        redirectTo: 'others/404'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
