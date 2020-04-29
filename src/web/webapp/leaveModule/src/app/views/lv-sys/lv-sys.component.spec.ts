import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LvSysComponent } from './lv-sys.component';

describe('LvSysComponent', () => {
  let component: LvSysComponent;
  let fixture: ComponentFixture<LvSysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LvSysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LvSysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
