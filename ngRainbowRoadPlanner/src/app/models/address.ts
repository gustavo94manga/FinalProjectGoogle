import { Destination } from "./destination";

export class Address {
  id: number;
  street: string;
  street2: string;
  city: string;
  state: string;
  zip:string;
  active: boolean;
  destination: Destination | null;




constructor(

  id: number = 0,
  street: string='',
  street2: string='',
  city: string='',
  state: string='',
  zip:string='',
  active: boolean=true,
  destination: Destination | null = null






){

  this.id = id;
  this.street= street;
  this.street2= street2;
  this.city= city;
  this.state= state;
  this.zip=zip;
  this.active= active;
  this.destination= destination;

}









}
