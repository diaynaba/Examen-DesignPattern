import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchWallet } from './search-wallet';

describe('SearchWallet', () => {
  let component: SearchWallet;
  let fixture: ComponentFixture<SearchWallet>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchWallet],
    }).compileComponents();

    fixture = TestBed.createComponent(SearchWallet);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
