import { TestBed } from '@angular/core/testing';

import { LeaveApplicationService } from './leave-application.service';

describe('LeaveApplicationServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeaveApplicationService = TestBed.get(LeaveApplicationService);
    expect(service).toBeTruthy();
  });
});
