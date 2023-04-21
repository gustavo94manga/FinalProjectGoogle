import { Component, OnInit } from '@angular/core';
import { Leg } from 'src/app/models/leg';
import { LegService } from 'src/app/services/leg.service';

@Component({
  selector: 'app-leg',
  templateUrl: './leg.component.html',
  styleUrls: ['./leg.component.css']
})
export class LegComponent implements OnInit {




  selected: Leg | null= null;
  newLeg: Leg = new Leg();
  editLeg: Leg | null = null;


  constructor(private legService: LegService) { }

  ngOnInit() {
  }


setEditLeg(){
  this.editLeg = Object.assign({}, this.selected)
}

createLeg(leg:Leg){
  this.legService.create(leg).subscribe({
    next:(madeLeg)=>{
      this.selected=madeLeg;
    },
    error: (failure) => {
      console.error('Error getting create leg');
      console.error(failure);
    }
  })
}

updateLeg(leg:Leg){
  this.legService.update(leg).subscribe({
    next:(updated)=>{
      this.selected=updated;
    },
    error: (failure) => {
      console.error('Error update leg');
      console.error(failure);
    }
  })
}


deleteLeg(id:number){
  this.legService.destroy(id).subscribe({

    next: () =>{
      this.selected=null;
    },
    error: (failure) => {
      console.error('Error getting todo list');
      console.error(failure);
    }
})

}



}
