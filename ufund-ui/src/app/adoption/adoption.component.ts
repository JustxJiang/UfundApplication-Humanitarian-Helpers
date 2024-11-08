import { Component } from '@angular/core';

@Component({
  selector: 'app-adoption',
  standalone: true,
  imports: [],
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
      image: 'ufund-ui/src/assets/Juan.png'
    },
    {
      name:'Ricky',
      age: 3,
      location: 'Henrietta, NY',
      image: 'ufund-ui/src/assets/Ricky the hamster.png'
    },
    {
      name:'Priscilla',
      age: 5,
      location: 'Victor, NY',
      image: 'ufund-ui/src/assets/Priscilla.png'
    },
    {
      name:'Darinka',
      age: 3,
      location: 'Bronx, NY',
      image: 'ufund-ui/src/assets/Darinka.png'
    },
    {
      name:'Kari',
      age: 1,
      location: 'Queens, NY',
      image: 'ufund-ui/src/assets/Kari.png'
    },
    {
      name:'Sultan',
      age: 2,
      location: 'Staten Island, NY',
      image: 'ufund-ui/src/assets/Sultan.png'
    }
  ];
  adoptPet(pet: { name: any; }) {
    alert(`You've adopted ${pet.name}! Thank you so much for giving ${pet.name} a home!`);
  }

}
