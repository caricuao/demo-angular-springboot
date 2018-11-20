import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Router} from "@angular/router";
import { ToastrService } from 'ngx-toastr';
import {Familia} from './familia.model';
import { PersonaService } from '../services/persona.service';
import { Persona } from './persona.model';
import {UNAUTHORIZED, BAD_REQUEST, FORBIDDEN, CONFLICT} from "http-status-codes";
import {FamiliaService} from '../services/familia.service';

@Component({
  selector: 'app-familia-form',
  templateUrl: './familia-form.component.html',
  styleUrls: ['./familia-form.component.css']
})
export class FamiliaFormComponent implements OnInit {

  id: number;
  idPersona: number;
  familia: Familia;
  persona : Persona;
  errorMessage: string;
  constructor(
    private route: ActivatedRoute,
    private personaService: PersonaService,
    private router: Router,
    private toastr: ToastrService,
    private familiaService: FamiliaService
  ) { 
    this.route.params.subscribe(params => {
      this.id = +params['id']; 
      this.idPersona = +params['idPersona'];
      //console.log("ID "+this.id+ " IDPERSONA "+this.idPersona);
      this.familia = new Familia();
      if (this.id > 0) {  
        //this.title = "Edit";  
        /*this.personaService.findPersona(this.id).subscribe(
          data => {
            this.persona = data;
            //console.log('Datos '+JSON.stringify(data));
          },
          error => {
            this.errorMessage = error.error;
            this.handleError(error);
          }
        );*/

      }else{
        this.personaService.findPersona(this.idPersona).subscribe(
          data => {
            this.persona = data;
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
  }

  save() {
    this.familia.personDto = this.persona;
    //console.log('CREATE Family'+JSON.stringify(this.familia));
    this.familiaService.save(this.familia).subscribe(
      data => {
        this.familia = data;
        this.toastr.success('Se registro la informacion');
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
      case CONFLICT:
          //this.toastr.warning('Ya existe la persona');
          break;
      default:
         //this.showError(REFRESH_PAGE_ON_TOAST_CLICK_MESSAGE);
    }
  }

}
