import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FabricantListComponent } from './fabricant-list.component';

describe('FabricantListComponent', () => {
  let component: FabricantListComponent;
  let fixture: ComponentFixture<FabricantListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FabricantListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FabricantListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
