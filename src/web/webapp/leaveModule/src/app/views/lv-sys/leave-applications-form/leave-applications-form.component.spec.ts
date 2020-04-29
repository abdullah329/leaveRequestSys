import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveApplicationsFormComponent } from './leave-applications-form.component';

describe('LeaveApplicationsComponent', () => {
  let component: LeaveApplicationsFormComponent;
  let fixture: ComponentFixture<LeaveApplicationsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveApplicationsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveApplicationsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
