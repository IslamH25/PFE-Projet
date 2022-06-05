import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFabricantComponent } from './update-fabricant.component';

describe('UpdateFabricantComponent', () => {
  let component: UpdateFabricantComponent;
  let fixture: ComponentFixture<UpdateFabricantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFabricantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFabricantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
