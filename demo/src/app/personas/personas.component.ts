import { Component, OnInit } from '@angular/core';
import {Persona} from './persona.model';
import { PersonaService } from '../services/persona.service';
import {UNAUTHORIZED, BAD_REQUEST, FORBIDDEN} from "http-status-codes";
import {Router} from "@angular/router";


@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css']
})
export class PersonasComponent implements OnInit {
  personas : Persona[];
  errorMessage: string;
  constructor(private personaService: PersonaService,private router: Router) { }

  ngOnInit() {
    this.loadAll();
  }

  loadAll() {
    this.personaService.getAll().subscribe(
      data => {
        this.personas = data;
        //console.log('Datos '+JSON.stringify(data));
      },
      error => {
        this.errorMessage = error.error;
        this.handleError(error);
      }
    );
  }

  public handleError(error: any) {
    //console.error(error);
    let httpErrorCode = error.status;
    
    switch (httpErrorCode) {
      case UNAUTHORIZED:
          this.router.navigateByUrl("/auth/login");
          break;
      case FORBIDDEN:
          this.router.navigateByUrl("/auth/login");
          break;
      case BAD_REQUEST:
         //this.showError(error.message);
          break;
      default:
         //this.showError(REFRESH_PAGE_ON_TOAST_CLICK_MESSAGE);
    }
  }
}


