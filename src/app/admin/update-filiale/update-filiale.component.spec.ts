import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFilialeComponent } from './update-filiale.component';

describe('UpdateFilialeComponent', () => {
  let component: UpdateFilialeComponent;
  let fixture: ComponentFixture<UpdateFilialeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFilialeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFilialeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
