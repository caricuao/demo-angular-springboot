import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';
import { PersonasComponent } from './personas/personas.component';
import { PersonasFormComponent } from './personas/personas-form.component';
import { FamiliaFormComponent } from './personas/familia-form.component';
import { FamiliasComponent } from './personas/familias.component';
const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'personas',
        component: PersonasComponent
    },
    {
        path: 'personas/personas-form',
        component: PersonasFormComponent
    },
    {
        path: 'personas/personas-form/:id',
        component: PersonasFormComponent
    },
    {
        path: 'personas/personas-form/:idPersona/familia',
        component: FamiliaFormComponent
    },
    {
        path: 'personas/familia-update',
        component: FamiliaFormComponent
    },
    {
        path: 'personas/:id/familia',
        component: FamiliasComponent
    },
    {
        path: 'pm',
        component: PmComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
