import { LeaveAppModule } from './leave-app.module';

describe('LvSysModule', () => {
  let LvSysModule1: LeaveAppModule;

  beforeEach(() => {
    LvSysModule1 = new LeaveAppModule();
  });

  it('should create an instance', () => {
    expect(LeaveAppModule).toBeTruthy();
  });
});
