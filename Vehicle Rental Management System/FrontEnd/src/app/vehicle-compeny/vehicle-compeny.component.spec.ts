import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleCompenyComponent } from './vehicle-compeny.component';

describe('VehicleCompenyComponent', () => {
  let component: VehicleCompenyComponent;
  let fixture: ComponentFixture<VehicleCompenyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleCompenyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleCompenyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
