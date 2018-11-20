import { Persona } from "./persona.model";

export class Familia  {
    constructor(
        public id?: number,
        public name?: string,
        public lastName?: string,
        public gender?:string,
        public email?:string,
        public identify?:string,
        public address?:string,
        public personDto?:Persona
    ) {
    }
}