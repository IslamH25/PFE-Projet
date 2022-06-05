import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFabricantComponent } from './add-fabricant.component';

describe('AddFabricantComponent', () => {
  let component: AddFabricantComponent;
  let fixture: ComponentFixture<AddFabricantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFabricantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFabricantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
