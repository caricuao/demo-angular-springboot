export class Persona  {
    constructor(
        public id?: number,
        public name?: string,
        public lastName?: string,
        public gender?:string,
        public dateOfBirth?:string,
        public email?:string,
        public identify?:string,
        public address?:string,
        public listFamily?:{ id: number, name: string, lastName }[]
    ) {
    }
}