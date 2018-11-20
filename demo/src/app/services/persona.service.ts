import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import {Observable} from 'rxjs/Observable';
import {Persona} from '../personas/persona.model';

@Injectable({
    providedIn: 'root'
  })
  export class PersonaService {

    private personaUrl = 'http://localhost:8080/api/';
      
    constructor(private http: HttpClient) { }
  
    getUserBoard(): Observable<string> {
      return this.http.get(this.personaUrl, { responseType: 'text' });
    }
  
    getAll():Observable<Persona[]>{
        return this.http.get<Persona[]>(this.personaUrl+"personas",{ responseType: 'json' })
    }

    findPersona(id: number):Observable<Persona>{
      return this.http.get<Persona>(this.personaUrl+`/persona/${id}`,{ responseType: 'json' })
    }

    save(persona: Persona):Observable<Persona>{
      console.log("Service "+JSON.stringify(persona));
      return this.http.post<Persona>(this.personaUrl+"persona/",persona,{ responseType: 'json' })
    }

    update(persona: Persona):Observable<Persona>{
      
      return this.http.put<Persona>(this.personaUrl+`/personas/${persona.id}`,persona,{ responseType: 'json' })
    }

  }
  