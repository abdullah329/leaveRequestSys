import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveAppComponent } from './leave-app.component';

describe('LvSysComponent', () => {
  let component: LeaveAppComponent;
  let fixture: ComponentFixture<LeaveAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
