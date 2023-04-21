import { User } from './user';
import { Vehicle } from './vehicle';

export class Trip {
  id: number;
  startDate: string;
  endDate: string;
  roundTrip: boolean;
  miles: number;
  createDate: string;
  updateDate: string;
  title: string;
  description: string;
  imageUrl: string;
  active: boolean;
  legs: any[] | undefined;
  vehicles: Vehicle;
  comments: any[] | undefined;
  users: User;

  constructor(
    id: number = 0,
    startDate: string = '',
    endDate: string = '',
    roundTrip: boolean = false,
    miles: number = 0,
    createDate: string = '',
    updateDate: string = '',
    title: string = '',
    description: string = '',
    imageUrl: string = '',
    active: boolean = false,
    legs: any[] = [],
    vehicles: Vehicle,
    comments: any[] = [],
    users: User
  ) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.roundTrip = roundTrip;
    this.miles = miles;
    this.createDate = createDate;
    this.updateDate = updateDate;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.active = active;
    this.legs = legs;
    this.vehicles = vehicles;
    this.comments = comments;
    this.users = users;
  }
}
