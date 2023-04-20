export class User {
  id: number;
  username: string;
  password: string;
  role: string;
  active: boolean;
  firstName: string;
  lastName:string;
  phone: string;
  imageUrl: string;
  aboutMe: string;
  createDate: string;
  updateDate: string;


  constructor(
  id: number = 0,
  username: string ='',
  password: string='',
  role: string ='',
  active: boolean = false,
  firstName: string='',
  lastName:string='',
  phone: string='',
  imageUrl: string='',
  aboutMe: string='',
  createDate: string='',
  updateDate: string='',
  ) {
  this.id = id;
  this.username= username;
  this.password = password;
  this.role = role;
  this.active = active;
  this.firstName = firstName;
  this.lastName= lastName;
  this.phone = phone;
  this.imageUrl = imageUrl;
  this.aboutMe = aboutMe;
  this.createDate = createDate;
  this.updateDate= updateDate;
  }
}
