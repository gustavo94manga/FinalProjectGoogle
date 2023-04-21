import { Trip } from './trip';

export class Leg {
  id: number;
  estimatedMiles: number;
  trip: Trip;
  actualMiles: number;
  name: string;
  description: string;
  startDestination: number;
  endDestination: number;
  legNumber: number;
  notes: string;

  constructor(
    id: number = 0,
    estimatedMiles: number = 0,
    actualMiles: number = 0,
    name: string = '',
    description: string = '',
    legNumber: number = 0,
    notes: string = '',
    startDestination: number = 0,
    endDestination: number = 0,
    trip: Trip
  ) {
    this.id = id;
    this.estimatedMiles = estimatedMiles;
    this.trip = trip;
    this.actualMiles = actualMiles;
    this.name = name;
    this.description = description;
    this.startDestination = startDestination;
    this.endDestination = endDestination;
    this.legNumber = legNumber;
    this.notes = notes;
  }
}
