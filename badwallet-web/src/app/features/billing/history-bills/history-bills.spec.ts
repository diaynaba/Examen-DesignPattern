import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryBills } from './history-bills';

describe('HistoryBills', () => {
  let component: HistoryBills;
  let fixture: ComponentFixture<HistoryBills>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistoryBills],
    }).compileComponents();

    fixture = TestBed.createComponent(HistoryBills);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
