export class Leg {
  estimatedMiles: number;
  tripId: number;
  actualMiles: number;
  name: string;
  description: string;
  startDestinationId: number;
  endDestinationId: number;
  legNumber: number;
  notes: string;

  constructor(
    estimatedMiles: number = 0,
    tripId: number = 0,
    actualMiles: number = 0,
    name: string = '',
    description: string = '',
    startDestinationId: number = 0,
    endDestinationId: number = 0,
    legNumber: number = 0,
    notes: string = ''
  ){
    this.estimatedMiles = estimatedMiles;
    this.tripId = tripId;
    this.actualMiles = actualMiles;
    this.name = name;
    this.description = description;
    this.startDestinationId = startDestinationId;
    this.endDestinationId = endDestinationId;
    this.legNumber = legNumber;
    this.notes = notes;
  }
}
