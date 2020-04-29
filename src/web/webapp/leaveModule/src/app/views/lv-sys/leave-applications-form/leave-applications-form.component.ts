import { Component, OnInit} from '@angular/core';
import { CustomValidators } from 'ng2-validation';
import { ToastrService } from 'ngx-toastr';
import { LeaveApplicationModel } from '../model/LeaveApplicationModel';
import { LeaveApplicationService } from '../services/leave-application.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-leave-applications-form',
  templateUrl: './leave-applications-form.component.html',
  styleUrls: ['./leave-applications-form.component.scss'],
})
export class LeaveApplicationsFormComponent {
  loading: boolean;
  lvApplicationForm: LeaveApplicationModel;
  leaveData: LeaveApplicationModel[];

  public date: Object = new Date();


  constructor(
      private toastr: ToastrService,
      private route: ActivatedRoute,
      private router: Router,
      private leaveAppServices: LeaveApplicationService) {
      this.lvApplicationForm = new LeaveApplicationModel();
  }


  onSubmit() {
    this.loading = true;
    this.leaveAppServices.save(this.lvApplicationForm).subscribe(result => this.leaveAppServices.findAll());
    this.loading = false;
    this.toastr.success('تم إرسال طلبك', '--<>--', {progressBar: true});

  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit() {
    this.leaveAppServices.findById().subscribe(data => {
      this.leaveData = data;
    });
  }

 /* gotoNameIt() {
    this.router.navigate(['/users']);
  }*/

}
