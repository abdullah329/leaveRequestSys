import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LeaveApplicationModel } from '../model/LeaveApplicationModel';

@Injectable({providedIn: 'root'})
export class LeaveApplicationService {

    applicationUrl: string;

    constructor(private http: HttpClient) {
      this.applicationUrl = 'http://localhost:8080/api/leave/';
    }

  public findAll(): Observable<LeaveApplicationModel[]> {
      return this.http.get<LeaveApplicationModel[]>(this.applicationUrl+"");
  }

    public findById(): Observable<LeaveApplicationModel[]> {
        return this.http.get<LeaveApplicationModel[]>(this.applicationUrl);
    }
  public fetchString_example(): Observable<string> {
        return this.http.get(this.applicationUrl, {responseType: 'text'});
    }

  public save(application: LeaveApplicationModel) {
      return this.http.post<LeaveApplicationModel>(this.applicationUrl, application);
    }

}
