import { Component, OnInit} from '@angular/core';
import {Need} from '../need'
import { NeedService } from '../need.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
// import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cupboard',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './cupboard.component.html',
  styleUrl: './cupboard.component.css',
  providers: [NeedService,]
  // HttpClient

})
export class CupboardComponent implements OnInit{
  needs: Need[] = [];
  newNeed : Need = {id: 0, name: '', quantity: 0};

  // private http: HttpClient
  constructor(private needService: NeedService){

  }

  ngOnInit(): void {
      this.loadNeeds();
  }

  loadNeeds(): void{
    this.needService.getNeeds().subscribe(data=>{
      this.needs = data;
    })
  }

  addNeed(): void{
    if(this.newNeed.name && this.newNeed.quantity > 0){
      this.needService.addNeed(this.newNeed).subscribe(() => {
        this.loadNeeds();
        this.newNeed = {id: 0, name: '', quantity: 0};
      })
    }
  }

  updateNeed(need: Need): void {
    this.needService.updateNeed(need).subscribe(() => {
      this.loadNeeds();
    });
  }

  deleteNeed(needId: number): void {
    this.needService.deleteNeed(needId).subscribe(() => {
      this.loadNeeds();
    });
  }

}
