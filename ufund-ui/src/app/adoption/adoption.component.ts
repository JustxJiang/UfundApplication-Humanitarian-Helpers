import { Component } from '@angular/core';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-adoption',
  standalone: true,
  imports: [NgFor],
  templateUrl: './adoption.component.html',
  styleUrl: './adoption.component.css'
})
export class AdoptionComponent {

  pets = [
    {
      name:'Juan',
      type: 'Cat',
      age: 3,
      gender:'Male',
      location: 'Greece,NY',
      image: 'assets/Juan.png'
    },
    {
      name:'Ricky',
      type: 'Hamster',
      age: 3,
      gender: 'Male',
      location: 'Henrietta, NY',
      image: 'assets/Ricky the hamster.png'
    },
    {
      name:'Priscilla',
      type: 'Dog',
      age: 5,
      gender: 'Female',
      location: 'Victor, NY',
      image: '/assets/Priscilla.png'
    },
    {
      name:'Darinka',
      type: 'Dog',
      age: 3,
      gender: 'Female',
      location: 'Bronx, NY',
      image: 'assets/Darinka.png'
    },
    {
      name:'Kari',
      type: 'Cat',
      age: 1,
      gender: 'Female',
      location: 'Queens, NY',
      image: 'assets/Kari.png'
    },
    {
      name:'Sultan',
      type: 'Parrot',
      age: 2,
      gender: 'Male',
      location: 'Staten Island, NY',
      image: 'assets/Sultan.png'
    }
  ];
  adoptPet(pet: { name: any; }) {
    alert(`You've adopted ${pet.name}! Thank you so much for giving ${pet.name} a home!`);
  }

}
