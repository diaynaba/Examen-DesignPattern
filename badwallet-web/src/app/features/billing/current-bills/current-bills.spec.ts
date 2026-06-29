import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentBills } from './current-bills';

describe('CurrentBills', () => {
  let component: CurrentBills;
  let fixture: ComponentFixture<CurrentBills>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CurrentBills],
    }).compileComponents();

    fixture = TestBed.createComponent(CurrentBills);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
