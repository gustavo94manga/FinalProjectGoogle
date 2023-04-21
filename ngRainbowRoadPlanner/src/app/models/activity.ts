export class Activity {
  legId: number;
  destinationId: number;
  didStop: boolean;
  description: string;
  priorityLevel: number;
  timeToSpend: string;

  constructor(
  legId: number = 0,
  destinationId: number = 0,
  didStop: boolean = false,
  description: string = '',
  priorityLevel: number = 0,
  timeToSpend: string = ''
  ){
    this.legId = legId;
    this.destinationId = destinationId;
    this.didStop = didStop;
    this.description = description;
    this.priorityLevel = priorityLevel;
    this.timeToSpend = timeToSpend;
  }

}
