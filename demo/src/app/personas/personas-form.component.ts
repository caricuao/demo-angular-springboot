import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import {Router} from "@angular/router";
import {UNAUTHORIZED, BAD_REQUEST, FORBIDDEN, CONFLICT} from "http-status-codes";
import { Persona } from './persona.model';
import { PersonaService } from '../services/persona.service';


@Component({
  selector: 'app-personas-form',
  templateUrl: './personas-form.component.html',
  styleUrls: ['./personas-form.component.css']
})
export class PersonasFormComponent implements OnInit {
  id: number;
  persona : Persona;
  errorMessage: string;
  isSaving: boolean;
  isNew:boolean;
  
  constructor(
    private route: ActivatedRoute,
    private personaService: PersonaService,
    private router: Router,
    private toastr: ToastrService,
    
  ) { 
    
    this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      //console.log("ID "+this.id);
      this.persona = new Persona();
      if (this.id > 0) {  
        //this.title = "Edit";  
        this.personaService.findPersona(this.id).subscribe(
          data => {
            this.persona = data;
            //console.log('Datos '+JSON.stringify(data));
          },
          error => {
            this.errorMessage = error.error;
            this.handleError(error);
          }
        );

      }
    });

  }

  ngOnInit() {
    if (Number.isNaN(this.id)){
      this.isNew = true;
    }else{
      this.isNew = false;
    }
    
  }

  

  save() {
    this.isNew = false;
    if (this.persona.id !== undefined) {
      //console.log('UPDATE '+JSON.stringify(this.persona));
      this.personaService.update(this.persona).subscribe(
        data => {
          this.persona = data;
          this.toastr.success('Se guardó la informacion');
        },
        error => {
          this.errorMessage = error.error;
          this.handleError(error);
        }
      );
  
    } else {
            //console.log('CREATE '+JSON.stringify(this.persona));
            this.personaService.save(this.persona).subscribe(
              data => {
                this.persona = data;
                this.toastr.success('Se registro la informacion');
              },
              error => {
                this.errorMessage = error.error;
                this.handleError(error);
              }
            );
    }
  }

  public handleError(error: any) {
    //console.error(error);
    this.isNew = true;
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
      case CONFLICT:
          this.toastr.warning('Ya existe la persona');
          break;
      default:
         //this.showError(REFRESH_PAGE_ON_TOAST_CLICK_MESSAGE);
    }
  }

  
}
