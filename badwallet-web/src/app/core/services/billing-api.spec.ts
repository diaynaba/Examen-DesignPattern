import { TestBed } from '@angular/core/testing';

import { BillingApi } from './billing-api';

describe('BillingApi', () => {
  let service: BillingApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BillingApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
