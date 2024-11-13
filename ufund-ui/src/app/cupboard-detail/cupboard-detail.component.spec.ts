import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CupboardDetailComponent } from './cupboard-detail.component';

describe('CupboardDetailComponent', () => {
  let component: CupboardDetailComponent;
  let fixture: ComponentFixture<CupboardDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CupboardDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CupboardDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
