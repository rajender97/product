import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleCompanyLoginComponent } from './vehicle-company-login.component';

describe('VehicleCompanyLoginComponent', () => {
  let component: VehicleCompanyLoginComponent;
  let fixture: ComponentFixture<VehicleCompanyLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleCompanyLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleCompanyLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
