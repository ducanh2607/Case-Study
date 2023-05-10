import { TestBed } from '@angular/core/testing';

import { PostStatusService } from './post-status.service';

describe('PostStatusService', () => {
  let service: PostStatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PostStatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
