import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthenticationService} from '../../../shared/services/authentication.service';
import {environment} from '../../../../environments/environment';


@Injectable({
    providedIn: 'root'
})
export class DashboardService {

    private attendanceiUrl = environment.resourceServerURL + '/api/v1/mysfd/attendance';
    private employeeUrl = environment.resourceServerURL + '/api/v1/mysfd/employee';

    constructor(private http: HttpClient, private authService: AuthenticationService) {
    }


    public findAttendanceStatistical() {
        return this.authService.getResource(this.attendanceiUrl + '/statistical/me');
    }

    public getFiniancialInfo() {
        return this.authService.getResource(this.employeeUrl + '/financial/me');
    }

    public getEmployeeInfo() {
        return this.authService.getResource(this.employeeUrl + '/me');
    }

    public getEmployeeNameByNid(nid: number): Observable<string> {
        return this.authService.getResource(this.employeeUrl + '/' + nid);
    }
}
