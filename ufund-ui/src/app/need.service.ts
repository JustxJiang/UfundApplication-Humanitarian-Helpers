import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Need } from './need';
1

@Injectable({
  providedIn: 'root'
})
export class NeedService {
  private apiUrl = 'http://localhost:8080/api/needs';

  constructor(private http: HttpClient) {}

  getNeeds(): Observable<Need[]> {
    return this.http.get<Need[]>(this.apiUrl);
  }

  addNeed(need: Need): Observable<Need> {
    return this.http.post<Need>(this.apiUrl, need);
  }

  updateNeed(need: Need): Observable<Need> {
    return this.http.put<Need>(`${this.apiUrl}/${need.id}`, need);
  }

  deleteNeed(needId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${needId}`);
  }
}