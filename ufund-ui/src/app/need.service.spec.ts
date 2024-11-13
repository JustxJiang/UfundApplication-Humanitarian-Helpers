import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { Need } from './need';
import { NEEDS } from './mock-needs';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root',
})
export class NeedService {

  constructor(private messageService: MessageService) { }

  getNeeds(): Observable<Need[]> {
    const needs = of(NEEDS);
    this.messageService.add('NeedService: fetched needs');
    return needs;
  }
}