import { User } from "./user";

export class Comment {
  id: number;
  photo: string;
  description: string;
  commentDate: string;
  user: User;
  trip: Trip;
  active: boolean;

  constructor(
    id: number = 0,
  photo: string = "",
  description: string = "",
  commentDate: string = "",
  user: User,
  trip: Trip,
  active: boolean = false
  ){
    this.id = id;
    this.photo = photo;
    this.description = description;
    this.commentDate = commentDate;
    this.user = user;
    this.trip = trip;
    this.active = active;
  }
}
