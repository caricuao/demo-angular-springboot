import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import {Observable} from 'rxjs/Observable';
import {Familia} from '../personas/familia.model';


@Injectable({
  providedIn: 'root'
})
export class FamiliaService {
  private url = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }

  save(familia: Familia):Observable<Familia>{
    console.log("Service "+JSON.stringify(familia));
    return this.http.post<Familia>(this.url+"familia/",familia,{ responseType: 'json' })
  }

}
