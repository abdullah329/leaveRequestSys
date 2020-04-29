import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveRequestTraceComponent } from './leave-request-trace.component';

describe('LeaveTransactionComponent', () => {
  let component: LeaveRequestTraceComponent;
  let fixture: ComponentFixture<LeaveRequestTraceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveRequestTraceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveRequestTraceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
