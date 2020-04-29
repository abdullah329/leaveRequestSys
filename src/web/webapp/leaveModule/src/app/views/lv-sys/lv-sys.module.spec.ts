import { LvSysModule } from './lv-sys.module';

describe('LvSysModule', () => {
  let LvSysModule1: LvSysModule;

  beforeEach(() => {
    LvSysModule1 = new LvSysModule();
  });

  it('should create an instance', () => {
    expect(LvSysModule).toBeTruthy();
  });
});
