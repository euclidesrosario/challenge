import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ResponseModule } from './models/response/response.module';

@Injectable({
  providedIn: 'root'
})
export class ResponseService {
  apiUrl: string;

  constructor(private http: HttpClient) {
    this.apiUrl = environment.apiUrl

  }



  getWeather(value:string): Observable<ResponseModule>{
    const params = new HttpParams()
                          .set('value',value)

    return this.http.get<any>(`${this.apiUrl+"api/travel/"}?${params.toString()}`);
  }

}
